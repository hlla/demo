/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.Logger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AppEventQueue
/*     */ {
/*  51 */   private static final String TAG = AppEventQueue.class.getName();
/*     */   
/*     */   private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
/*     */   
/*     */   private static final int FLUSH_PERIOD_IN_SECONDS = 15;
/*  56 */   private static volatile AppEventCollection appEventCollection = new AppEventCollection();
/*     */   
/*  58 */   private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
/*     */   
/*     */   private static ScheduledFuture scheduledFuture;
/*     */   
/*  62 */   private static final Runnable flushRunnable = new Runnable()
/*     */   {
/*     */     public void run() {
/*  65 */       AppEventQueue.access$002(null);
/*     */       
/*  67 */       if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY)
/*     */       {
/*  69 */         AppEventQueue.flushAndWait(FlushReason.TIMER);
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   public static void persistToDisk() {
/*  75 */     singleThreadExecutor.execute(new Runnable()
/*     */     {
/*     */       public void run() {
/*  78 */         AppEventStore.persistEvents(AppEventQueue.appEventCollection);
/*  79 */         AppEventQueue.access$102(new AppEventCollection());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static void flush(FlushReason reason)
/*     */   {
/*  86 */     singleThreadExecutor.execute(new Runnable()
/*     */     {
/*     */       public void run() {
/*  89 */         AppEventQueue.flushAndWait(this.val$reason);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public static void add(AccessTokenAppIdPair accessTokenAppId, final AppEvent appEvent)
/*     */   {
/*  97 */     singleThreadExecutor.execute(new Runnable()
/*     */     {
/*     */       public void run() {
/* 100 */         AppEventQueue.appEventCollection.addEvent(this.val$accessTokenAppId, appEvent);
/*     */         
/* 102 */         if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY)
/*     */         {
/* 104 */           if (AppEventQueue.appEventCollection.getEventCount() > 100)
/*     */           {
/* 106 */             AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD); return; } }
/* 107 */         if (AppEventQueue.scheduledFuture == null) {
/* 108 */           AppEventQueue.access$002(AppEventQueue.singleThreadExecutor.schedule(
/* 109 */             AppEventQueue.flushRunnable, 15L, TimeUnit.SECONDS));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<AccessTokenAppIdPair> getKeySet()
/*     */   {
/* 122 */     return appEventCollection.keySet();
/*     */   }
/*     */   
/*     */   static void flushAndWait(FlushReason reason)
/*     */   {
/* 127 */     PersistedEvents result = AppEventStore.readAndClearStore();
/*     */     
/* 129 */     appEventCollection.addPersistedEvents(result);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 134 */       flushResults = sendEventsToServer(reason, appEventCollection);
/*     */     }
/*     */     catch (Exception e) {
/*     */       FlushStatistics flushResults;
/* 138 */       Log.w(TAG, "Caught unexpected exception while flushing app events: ", e); return;
/*     */     }
/*     */     
/*     */     FlushStatistics flushResults;
/* 142 */     if (flushResults != null) {
/* 143 */       Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
/* 144 */       intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", flushResults.numEvents);
/*     */       
/*     */ 
/* 147 */       intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", flushResults.result);
/*     */       
/*     */ 
/* 150 */       Context context = FacebookSdk.getApplicationContext();
/* 151 */       LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static FlushStatistics sendEventsToServer(FlushReason reason, AppEventCollection appEventCollection)
/*     */   {
/* 158 */     FlushStatistics flushResults = new FlushStatistics();
/*     */     
/* 160 */     Context context = FacebookSdk.getApplicationContext();
/* 161 */     boolean limitEventUsage = FacebookSdk.getLimitEventAndDataUsage(context);
/*     */     
/* 163 */     List<GraphRequest> requestsToExecute = new ArrayList();
/* 164 */     for (AccessTokenAppIdPair accessTokenAppId : appEventCollection.keySet()) {
/* 165 */       GraphRequest request = buildRequestForSession(accessTokenAppId, appEventCollection
/*     */       
/* 167 */         .get(accessTokenAppId), limitEventUsage, flushResults);
/*     */       
/*     */ 
/* 170 */       if (request != null) {
/* 171 */         requestsToExecute.add(request);
/*     */       }
/*     */     }
/*     */     
/* 175 */     if (requestsToExecute.size() > 0) {
/* 176 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", new Object[] {
/* 177 */         Integer.valueOf(flushResults.numEvents), reason
/* 178 */         .toString() });
/*     */       
/* 180 */       for (GraphRequest request : requestsToExecute)
/*     */       {
/*     */ 
/* 183 */         request.executeAndWait();
/*     */       }
/* 185 */       return flushResults;
/*     */     }
/*     */     
/* 188 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppId, final SessionEventsState appEvents, boolean limitEventUsage, final FlushStatistics flushState)
/*     */   {
/* 196 */     String applicationId = accessTokenAppId.getApplicationId();
/*     */     
/*     */ 
/* 199 */     FetchedAppSettings fetchedAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
/*     */     
/* 201 */     final GraphRequest postRequest = GraphRequest.newPostRequest(null, 
/*     */     
/* 203 */       String.format("%s/activities", new Object[] { applicationId }), null, null);
/*     */     
/*     */ 
/*     */ 
/* 207 */     Bundle requestParameters = postRequest.getParameters();
/* 208 */     if (requestParameters == null) {
/* 209 */       requestParameters = new Bundle();
/*     */     }
/* 211 */     requestParameters.putString("access_token", accessTokenAppId.getAccessTokenString());
/*     */     
/* 213 */     String pushNotificationsRegistrationId = AppEventsLogger.getPushNotificationsRegistrationId();
/* 214 */     if (pushNotificationsRegistrationId != null) {
/* 215 */       requestParameters.putString("device_token", pushNotificationsRegistrationId);
/*     */     }
/*     */     
/* 218 */     postRequest.setParameters(requestParameters);
/*     */     
/* 220 */     if (fetchedAppSettings == null) {
/* 221 */       return null;
/*     */     }
/*     */     
/* 224 */     int numEvents = appEvents.populateRequest(postRequest, 
/*     */     
/* 226 */       FacebookSdk.getApplicationContext(), fetchedAppSettings
/* 227 */       .supportsImplicitLogging(), limitEventUsage);
/*     */     
/*     */ 
/* 230 */     if (numEvents == 0) {
/* 231 */       return null;
/*     */     }
/*     */     
/* 234 */     flushState.numEvents += numEvents;
/*     */     
/* 236 */     postRequest.setCallback(new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 239 */         AppEventQueue.handleResponse(this.val$accessTokenAppId, postRequest, response, appEvents, flushState);
/*     */ 
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 247 */     });
/* 248 */     return postRequest;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void handleResponse(AccessTokenAppIdPair accessTokenAppId, GraphRequest request, GraphResponse response, final SessionEventsState appEvents, FlushStatistics flushState)
/*     */   {
/* 257 */     FacebookRequestError error = response.getError();
/* 258 */     String resultDescription = "Success";
/*     */     
/* 260 */     FlushResult flushResult = FlushResult.SUCCESS;
/*     */     
/* 262 */     if (error != null) {
/* 263 */       int NO_CONNECTIVITY_ERROR_CODE = -1;
/* 264 */       if (error.getErrorCode() == -1) {
/* 265 */         resultDescription = "Failed: No Connectivity";
/* 266 */         flushResult = FlushResult.NO_CONNECTIVITY;
/*     */       } else {
/* 268 */         resultDescription = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] {response
/* 269 */           .toString(), error
/* 270 */           .toString() });
/* 271 */         flushResult = FlushResult.SERVER_ERROR;
/*     */       }
/*     */     }
/*     */     
/* 275 */     if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
/* 276 */       String eventsJsonString = (String)request.getTag();
/*     */       String prettyPrintedEvents;
/*     */       try
/*     */       {
/* 280 */         JSONArray jsonArray = new JSONArray(eventsJsonString);
/* 281 */         prettyPrintedEvents = jsonArray.toString(2);
/*     */       } catch (JSONException exc) { String prettyPrintedEvents;
/* 283 */         prettyPrintedEvents = "<Can't encode events for debug logging>";
/*     */       }
/*     */       
/* 286 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] {request
/*     */       
/* 288 */         .getGraphObject().toString(), resultDescription, prettyPrintedEvents });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 293 */     appEvents.clearInFlightAndStats(error != null);
/*     */     
/* 295 */     if (flushResult == FlushResult.NO_CONNECTIVITY)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 301 */       FacebookSdk.getExecutor().execute(new Runnable()
/*     */       {
/*     */         public void run() {
/* 304 */           AppEventStore.persistEvents(this.val$accessTokenAppId, appEvents);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/* 309 */     if (flushResult != FlushResult.SUCCESS)
/*     */     {
/* 311 */       if (flushState.result != FlushResult.NO_CONNECTIVITY) {
/* 312 */         flushState.result = flushResult;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AppEventQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */