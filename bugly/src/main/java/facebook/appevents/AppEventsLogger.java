/*      */ package com.facebook.appevents;
/*      */ 
/*      */ import android.app.Activity;
/*      */ import android.app.Application;
/*      */ import android.content.ComponentName;
/*      */ import android.content.Context;
/*      */ import android.content.Intent;
/*      */ import android.content.SharedPreferences;
/*      */ import android.content.SharedPreferences.Editor;
/*      */ import android.os.Bundle;
/*      */ import android.support.annotation.Nullable;
/*      */ import android.util.Log;
/*      */ import bolts.AppLinks;
/*      */ import com.facebook.AccessToken;
/*      */ import com.facebook.FacebookException;
/*      */ import com.facebook.FacebookSdk;
/*      */ import com.facebook.GraphRequest;
/*      */ import com.facebook.GraphRequest.Callback;
/*      */ import com.facebook.HttpMethod;
/*      */ import com.facebook.LoggingBehavior;
/*      */ import com.facebook.appevents.internal.ActivityLifecycleTracker;
/*      */ import com.facebook.internal.AttributionIdentifiers;
/*      */ import com.facebook.internal.BundleJSONConverter;
/*      */ import com.facebook.internal.FetchedAppSettingsManager;
/*      */ import com.facebook.internal.Logger;
/*      */ import com.facebook.internal.Utility;
/*      */ import com.facebook.internal.Validate;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Currency;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONException;
/*      */ import org.json.JSONObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AppEventsLogger
/*      */ {
/*      */   public static enum FlushBehavior
/*      */   {
/*  158 */     AUTO, 
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  163 */     EXPLICIT_ONLY;
/*      */     
/*      */     private FlushBehavior() {} }
/*      */   
/*  167 */   private static final String TAG = AppEventsLogger.class.getCanonicalName();
/*      */   
/*      */   private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
/*      */   
/*      */   private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
/*      */   
/*      */   public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
/*      */   
/*      */   private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
/*      */   
/*      */   private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
/*      */   
/*      */   private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
/*      */   
/*      */   private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
/*      */   
/*      */   private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
/*      */   
/*      */   private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
/*      */   private final String contextName;
/*      */   private final AccessTokenAppIdPair accessTokenAppId;
/*      */   private static ScheduledThreadPoolExecutor backgroundExecutor;
/*  189 */   private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
/*  190 */   private static Object staticLock = new Object();
/*      */   
/*      */   private static String anonymousAppDeviceGUID;
/*      */   
/*      */   private static String sourceApplication;
/*      */   
/*      */   private static boolean isOpenedByApplink;
/*      */   private static boolean isActivateAppEventRequested;
/*      */   private static String pushNotificationsRegistrationId;
/*      */   private static String externalAnalyticsUserID;
/*      */   public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
/*      */   public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
/*      */   public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
/*      */   
/*      */   public static void activateApp(Application application)
/*      */   {
/*  206 */     activateApp(application, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void activateApp(Application application, String applicationId)
/*      */   {
/*  221 */     if (!FacebookSdk.isInitialized()) {
/*  222 */       throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
/*      */     }
/*      */     
/*      */ 
/*  226 */     AnalyticsUserIDStore.initStore();
/*      */     
/*  228 */     if (applicationId == null) {
/*  229 */       applicationId = FacebookSdk.getApplicationId();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  235 */     FacebookSdk.publishInstallAsync(application, applicationId);
/*      */     
/*  237 */     ActivityLifecycleTracker.startTracking(application, applicationId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   @Deprecated
/*      */   public static void activateApp(Context context)
/*      */   {
/*  255 */     if (ActivityLifecycleTracker.isTracking()) {
/*  256 */       Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
/*      */       
/*  258 */       return;
/*      */     }
/*      */     
/*  261 */     FacebookSdk.sdkInitialize(context);
/*  262 */     activateApp(context, Utility.getMetadataApplicationId(context));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   @Deprecated
/*      */   public static void activateApp(Context context, String applicationId)
/*      */   {
/*  276 */     if (ActivityLifecycleTracker.isTracking()) {
/*  277 */       Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
/*      */       
/*  279 */       return;
/*      */     }
/*      */     
/*  282 */     if ((context == null) || (applicationId == null)) {
/*  283 */       throw new IllegalArgumentException("Both context and applicationId must be non-null");
/*      */     }
/*      */     
/*  286 */     AnalyticsUserIDStore.initStore();
/*      */     
/*  288 */     if ((context instanceof Activity)) {
/*  289 */       setSourceApplication((Activity)context);
/*      */     }
/*      */     else {
/*  292 */       resetSourceApplication();
/*  293 */       Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  301 */     FacebookSdk.publishInstallAsync(context, applicationId);
/*      */     
/*  303 */     AppEventsLogger logger = new AppEventsLogger(context, applicationId, null);
/*  304 */     final long eventTime = System.currentTimeMillis();
/*  305 */     String sourceApplicationInfo = getSourceApplication();
/*  306 */     backgroundExecutor.execute(new Runnable()
/*      */     {
/*      */       public void run() {
/*  309 */         this.val$logger.logAppSessionResumeEvent(eventTime, this.val$sourceApplicationInfo);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   @Deprecated
/*      */   public static void deactivateApp(Context context)
/*      */   {
/*  330 */     if (ActivityLifecycleTracker.isTracking()) {
/*  331 */       Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
/*      */       
/*  333 */       return;
/*      */     }
/*      */     
/*  336 */     deactivateApp(context, Utility.getMetadataApplicationId(context));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   @Deprecated
/*      */   public static void deactivateApp(Context context, String applicationId)
/*      */   {
/*  351 */     if (ActivityLifecycleTracker.isTracking()) {
/*  352 */       Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
/*      */       
/*  354 */       return;
/*      */     }
/*      */     
/*  357 */     if ((context == null) || (applicationId == null)) {
/*  358 */       throw new IllegalArgumentException("Both context and applicationId must be non-null");
/*      */     }
/*      */     
/*  361 */     resetSourceApplication();
/*      */     
/*  363 */     AppEventsLogger logger = new AppEventsLogger(context, applicationId, null);
/*  364 */     final long eventTime = System.currentTimeMillis();
/*  365 */     backgroundExecutor.execute(new Runnable()
/*      */     {
/*      */       public void run() {
/*  368 */         this.val$logger.logAppSessionSuspendEvent(eventTime);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   private void logAppSessionResumeEvent(long eventTime, String sourceApplicationInfo) {
/*  374 */     PersistedAppSessionInfo.onResume(
/*  375 */       FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, eventTime, sourceApplicationInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void logAppSessionSuspendEvent(long eventTime)
/*      */   {
/*  383 */     PersistedAppSessionInfo.onSuspend(
/*  384 */       FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, eventTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static AppEventsLogger newLogger(Context context)
/*      */   {
/*  400 */     return new AppEventsLogger(context, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static AppEventsLogger newLogger(Context context, AccessToken accessToken)
/*      */   {
/*  412 */     return new AppEventsLogger(context, null, accessToken);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static AppEventsLogger newLogger(Context context, String applicationId, AccessToken accessToken)
/*      */   {
/*  431 */     return new AppEventsLogger(context, applicationId, accessToken);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static AppEventsLogger newLogger(Context context, String applicationId)
/*      */   {
/*  445 */     return new AppEventsLogger(context, applicationId, null);
/*      */   }
/*      */   
/*      */   /* Error */
/*      */   public static FlushBehavior getFlushBehavior()
/*      */   {
/*      */     // Byte code:
/*      */     //   0: getstatic 44	com/facebook/appevents/AppEventsLogger:staticLock	Ljava/lang/Object;
/*      */     //   3: dup
/*      */     //   4: astore_0
/*      */     //   5: monitorenter
/*      */     //   6: getstatic 45	com/facebook/appevents/AppEventsLogger:flushBehavior	Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;
/*      */     //   9: aload_0
/*      */     //   10: monitorexit
/*      */     //   11: areturn
/*      */     //   12: astore_1
/*      */     //   13: aload_0
/*      */     //   14: monitorexit
/*      */     //   15: aload_1
/*      */     //   16: athrow
/*      */     // Line number table:
/*      */     //   Java source line #467	-> byte code offset #0
/*      */     //   Java source line #468	-> byte code offset #6
/*      */     //   Java source line #469	-> byte code offset #12
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   4	10	0	Ljava/lang/Object;	Object
/*      */     //   12	4	1	localObject1	Object
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   6	11	12	finally
/*      */     //   12	15	12	finally
/*      */   }
/*      */   
/*      */   public static void setFlushBehavior(FlushBehavior flushBehavior)
/*      */   {
/*  479 */     synchronized (staticLock) {
/*  480 */       flushBehavior = flushBehavior;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logEvent(String eventName)
/*      */   {
/*  495 */     logEvent(eventName, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logEvent(String eventName, double valueToSum)
/*      */   {
/*  513 */     logEvent(eventName, valueToSum, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logEvent(String eventName, Bundle parameters)
/*      */   {
/*  535 */     logEvent(eventName, null, parameters, false, 
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  540 */       ActivityLifecycleTracker.getCurrentSessionGuid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logEvent(String eventName, double valueToSum, Bundle parameters)
/*      */   {
/*  565 */     logEvent(eventName, 
/*      */     
/*  567 */       Double.valueOf(valueToSum), parameters, false, 
/*      */       
/*      */ 
/*  570 */       ActivityLifecycleTracker.getCurrentSessionGuid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logPurchase(BigDecimal purchaseAmount, Currency currency)
/*      */   {
/*  583 */     logPurchase(purchaseAmount, currency, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logPurchase(BigDecimal purchaseAmount, Currency currency, Bundle parameters)
/*      */   {
/*  601 */     if (purchaseAmount == null) {
/*  602 */       notifyDeveloperError("purchaseAmount cannot be null");
/*  603 */       return; }
/*  604 */     if (currency == null) {
/*  605 */       notifyDeveloperError("currency cannot be null");
/*  606 */       return;
/*      */     }
/*      */     
/*  609 */     if (parameters == null) {
/*  610 */       parameters = new Bundle();
/*      */     }
/*  612 */     parameters.putString("fb_currency", currency.getCurrencyCode());
/*      */     
/*  614 */     logEvent("fb_mobile_purchase", purchaseAmount.doubleValue(), parameters);
/*  615 */     eagerFlush();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logPushNotificationOpen(Bundle payload)
/*      */   {
/*  623 */     logPushNotificationOpen(payload, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logPushNotificationOpen(Bundle payload, String action)
/*      */   {
/*  631 */     String campaignId = null;
/*      */     try {
/*  633 */       String payloadString = payload.getString("fb_push_payload");
/*  634 */       if (Utility.isNullOrEmpty(payloadString)) {
/*  635 */         return;
/*      */       }
/*      */       
/*  638 */       JSONObject facebookPayload = new JSONObject(payloadString);
/*  639 */       campaignId = facebookPayload.getString("campaign");
/*      */     }
/*      */     catch (JSONException localJSONException) {}
/*      */     
/*  643 */     if (campaignId == null) {
/*  644 */       Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
/*      */       
/*  646 */       return;
/*      */     }
/*      */     
/*  649 */     Bundle parameters = new Bundle();
/*  650 */     parameters.putString("fb_push_campaign", campaignId);
/*  651 */     if (action != null) {
/*  652 */       parameters.putString("fb_push_action", action);
/*      */     }
/*  654 */     logEvent("fb_mobile_push_opened", parameters);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void flush()
/*      */   {
/*  662 */     AppEventQueue.flush(FlushReason.EXPLICIT);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onContextStop() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isValidForAccessToken(AccessToken accessToken)
/*      */   {
/*  683 */     AccessTokenAppIdPair other = new AccessTokenAppIdPair(accessToken);
/*  684 */     return this.accessTokenAppId.equals(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setPushNotificationsRegistrationId(String registrationId)
/*      */   {
/*  692 */     synchronized (staticLock) {
/*  693 */       pushNotificationsRegistrationId = registrationId;
/*      */     }
/*      */   }
/*      */   
/*      */   /* Error */
/*      */   static String getPushNotificationsRegistrationId()
/*      */   {
/*      */     // Byte code:
/*      */     //   0: getstatic 44	com/facebook/appevents/AppEventsLogger:staticLock	Ljava/lang/Object;
/*      */     //   3: dup
/*      */     //   4: astore_0
/*      */     //   5: monitorenter
/*      */     //   6: getstatic 85	com/facebook/appevents/AppEventsLogger:pushNotificationsRegistrationId	Ljava/lang/String;
/*      */     //   9: aload_0
/*      */     //   10: monitorexit
/*      */     //   11: areturn
/*      */     //   12: astore_1
/*      */     //   13: aload_0
/*      */     //   14: monitorexit
/*      */     //   15: aload_1
/*      */     //   16: athrow
/*      */     // Line number table:
/*      */     //   Java source line #698	-> byte code offset #0
/*      */     //   Java source line #699	-> byte code offset #6
/*      */     //   Java source line #700	-> byte code offset #12
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   4	10	0	Ljava/lang/Object;	Object
/*      */     //   12	4	1	localObject1	Object
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   6	11	12	finally
/*      */     //   12	15	12	finally
/*      */   }
/*      */   
/*      */   public static void setUserID(String userID)
/*      */   {
/*  712 */     AnalyticsUserIDStore.setUserID(userID);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String getUserID()
/*      */   {
/*  719 */     return AnalyticsUserIDStore.getUserID();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void clearUserID()
/*      */   {
/*  726 */     AnalyticsUserIDStore.setUserID(null);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void updateUserProperties(Bundle parameters, GraphRequest.Callback callback)
/*      */   {
/*  732 */     updateUserProperties(parameters, 
/*      */     
/*  734 */       FacebookSdk.getApplicationId(), callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void updateUserProperties(final Bundle parameters, final String applicationID, final GraphRequest.Callback callback)
/*      */   {
/*  742 */     String userID = getUserID();
/*  743 */     if ((userID == null) || (userID.isEmpty())) {
/*  744 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "AppEventsLogger userID cannot be null or empty");
/*      */       
/*      */ 
/*      */ 
/*  748 */       return;
/*      */     }
/*      */     
/*  751 */     getAnalyticsExecutor().execute(new Runnable()
/*      */     {
/*      */       public void run() {
/*  754 */         Bundle userPropertiesParams = new Bundle();
/*  755 */         userPropertiesParams.putString("user_unique_id", this.val$userID);
/*  756 */         userPropertiesParams.putBundle("custom_data", parameters);
/*      */         
/*      */ 
/*  759 */         AttributionIdentifiers identifiers = AttributionIdentifiers.getAttributionIdentifiers(
/*  760 */           FacebookSdk.getApplicationContext());
/*  761 */         if ((identifiers != null) && (identifiers.getAndroidAdvertiserId() != null)) {
/*  762 */           userPropertiesParams.putString("advertiser_id", identifiers
/*      */           
/*  764 */             .getAndroidAdvertiserId());
/*      */         }
/*      */         
/*  767 */         Bundle data = new Bundle();
/*      */         try {
/*  769 */           JSONObject userData = BundleJSONConverter.convertToJSON(userPropertiesParams);
/*  770 */           JSONArray dataArray = new JSONArray();
/*  771 */           dataArray.put(userData);
/*      */           
/*  773 */           data.putString("data", dataArray
/*  774 */             .toString());
/*      */         } catch (JSONException ex) {
/*  776 */           throw new FacebookException("Failed to construct request", ex);
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  781 */         GraphRequest request = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", new Object[] { applicationID }), data, HttpMethod.POST, callback);
/*      */         
/*      */ 
/*      */ 
/*  785 */         request.setSkipClientToken(true);
/*  786 */         request.executeAsync();
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void logSdkEvent(String eventName, Double valueToSum, Bundle parameters)
/*      */   {
/*  796 */     logEvent(eventName, valueToSum, parameters, true, 
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  801 */       ActivityLifecycleTracker.getCurrentSessionGuid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getApplicationId()
/*      */   {
/*  810 */     return this.accessTokenAppId.getApplicationId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private AppEventsLogger(Context context, String applicationId, AccessToken accessToken)
/*      */   {
/*  821 */     this(
/*  822 */       Utility.getActivityName(context), applicationId, accessToken);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected AppEventsLogger(String activityName, String applicationId, AccessToken accessToken)
/*      */   {
/*  831 */     Validate.sdkInitialized();
/*  832 */     this.contextName = activityName;
/*      */     
/*  834 */     if (accessToken == null) {
/*  835 */       accessToken = AccessToken.getCurrentAccessToken();
/*      */     }
/*      */     
/*      */ 
/*  839 */     if ((accessToken != null) && ((applicationId == null) || 
/*  840 */       (applicationId.equals(accessToken.getApplicationId()))))
/*      */     {
/*  842 */       this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
/*      */     }
/*      */     else {
/*  845 */       if (applicationId == null) {
/*  846 */         applicationId = Utility.getMetadataApplicationId(
/*  847 */           FacebookSdk.getApplicationContext());
/*      */       }
/*  849 */       this.accessTokenAppId = new AccessTokenAppIdPair(null, applicationId);
/*      */     }
/*      */     
/*  852 */     initializeTimersIfNeeded();
/*      */   }
/*      */   
/*      */   private static void initializeTimersIfNeeded() {
/*  856 */     synchronized (staticLock) {
/*  857 */       if (backgroundExecutor != null) {
/*  858 */         return;
/*      */       }
/*  860 */       backgroundExecutor = new ScheduledThreadPoolExecutor(1);
/*      */     }
/*      */     
/*  863 */     Runnable attributionRecheckRunnable = new Runnable()
/*      */     {
/*      */       public void run() {
/*  866 */         Set<String> applicationIds = new HashSet();
/*  867 */         for (AccessTokenAppIdPair accessTokenAppId : AppEventQueue.getKeySet()) {
/*  868 */           applicationIds.add(accessTokenAppId.getApplicationId());
/*      */         }
/*      */         
/*  871 */         for (String applicationId : applicationIds) {
/*  872 */           FetchedAppSettingsManager.queryAppSettings(applicationId, true);
/*      */         }
/*      */         
/*      */       }
/*  876 */     };
/*  877 */     backgroundExecutor.scheduleAtFixedRate(attributionRecheckRunnable, 0L, 86400L, TimeUnit.SECONDS);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void logEvent(String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, @Nullable UUID currentSessionId)
/*      */   {
/*      */     try
/*      */     {
/*  892 */       AppEvent event = new AppEvent(this.contextName, eventName, valueToSum, parameters, isImplicitlyLogged, currentSessionId);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  899 */       logEvent(FacebookSdk.getApplicationContext(), event, this.accessTokenAppId);
/*      */     }
/*      */     catch (JSONException jsonException) {
/*  902 */       Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {jsonException
/*  903 */         .toString() });
/*      */     }
/*      */     catch (FacebookException e)
/*      */     {
/*  907 */       Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", new Object[] {e
/*  908 */         .toString() });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void logEvent(Context context, AppEvent event, AccessTokenAppIdPair accessTokenAppId)
/*      */   {
/*  916 */     AppEventQueue.add(accessTokenAppId, event);
/*      */     
/*      */ 
/*  919 */     if ((!event.getIsImplicit()) && (!isActivateAppEventRequested)) {
/*  920 */       if (event.getName() == "fb_mobile_activate_app") {
/*  921 */         isActivateAppEventRequested = true;
/*      */       } else {
/*  923 */         Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void eagerFlush()
/*      */   {
/*  933 */     if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
/*  934 */       AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void notifyDeveloperError(String message)
/*      */   {
/*  944 */     Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", message);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void setSourceApplication(Activity activity)
/*      */   {
/*  952 */     ComponentName callingApplication = activity.getCallingActivity();
/*  953 */     if (callingApplication != null) {
/*  954 */       String callingApplicationPackage = callingApplication.getPackageName();
/*  955 */       if (callingApplicationPackage.equals(activity.getPackageName()))
/*      */       {
/*  957 */         resetSourceApplication();
/*  958 */         return;
/*      */       }
/*  960 */       sourceApplication = callingApplicationPackage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  966 */     Intent openIntent = activity.getIntent();
/*  967 */     if ((openIntent == null) || 
/*  968 */       (openIntent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))) {
/*  969 */       resetSourceApplication();
/*  970 */       return;
/*      */     }
/*      */     
/*  973 */     Bundle applinkData = AppLinks.getAppLinkData(openIntent);
/*      */     
/*  975 */     if (applinkData == null) {
/*  976 */       resetSourceApplication();
/*  977 */       return;
/*      */     }
/*      */     
/*  980 */     isOpenedByApplink = true;
/*      */     
/*  982 */     Bundle applinkReferrerData = applinkData.getBundle("referer_app_link");
/*      */     
/*  984 */     if (applinkReferrerData == null) {
/*  985 */       sourceApplication = null;
/*  986 */       return;
/*      */     }
/*      */     
/*  989 */     String applinkReferrerPackage = applinkReferrerData.getString("package");
/*  990 */     sourceApplication = applinkReferrerPackage;
/*      */     
/*      */ 
/*  993 */     openIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
/*      */   }
/*      */   
/*      */ 
/*      */   static void setSourceApplication(String applicationPackage, boolean openByAppLink)
/*      */   {
/*  999 */     sourceApplication = applicationPackage;
/* 1000 */     isOpenedByApplink = openByAppLink;
/*      */   }
/*      */   
/*      */   static String getSourceApplication() {
/* 1004 */     String openType = "Unclassified";
/* 1005 */     if (isOpenedByApplink) {
/* 1006 */       openType = "Applink";
/*      */     }
/* 1008 */     if (sourceApplication != null) {
/* 1009 */       return openType + "(" + sourceApplication + ")";
/*      */     }
/* 1011 */     return openType;
/*      */   }
/*      */   
/*      */   static void resetSourceApplication() {
/* 1015 */     sourceApplication = null;
/* 1016 */     isOpenedByApplink = false;
/*      */   }
/*      */   
/*      */   static Executor getAnalyticsExecutor() {
/* 1020 */     if (backgroundExecutor == null) {
/* 1021 */       initializeTimersIfNeeded();
/*      */     }
/*      */     
/* 1024 */     return backgroundExecutor;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getAnonymousAppDeviceGUID(Context context)
/*      */   {
/* 1035 */     if (anonymousAppDeviceGUID == null) {
/* 1036 */       synchronized (staticLock) {
/* 1037 */         if (anonymousAppDeviceGUID == null)
/*      */         {
/* 1039 */           SharedPreferences preferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
/*      */           
/*      */ 
/* 1042 */           anonymousAppDeviceGUID = preferences.getString("anonymousAppDeviceGUID", null);
/* 1043 */           if (anonymousAppDeviceGUID == null)
/*      */           {
/* 1045 */             anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
/*      */             
/* 1047 */             context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0)
/* 1048 */               .edit()
/* 1049 */               .putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID)
/* 1050 */               .apply();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1056 */     return anonymousAppDeviceGUID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static class PersistedAppSessionInfo
/*      */   {
/*      */     private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1072 */     private static final Object staticLock = new Object();
/* 1073 */     private static boolean hasChanges = false;
/* 1074 */     private static boolean isLoaded = false;
/*      */     
/*      */     private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
/* 1077 */     private static final Runnable appSessionInfoFlushRunnable = new Runnable()
/*      */     {
/*      */       public void run() {
/* 1080 */         PersistedAppSessionInfo.saveAppSessionInformation(
/* 1081 */           FacebookSdk.getApplicationContext());
/*      */       }
/*      */     };
/*      */     
/*      */     private static void restoreAppSessionInformation(Context context)
/*      */     {
/* 1087 */       ObjectInputStream ois = null;
/*      */       
/* 1089 */       synchronized (staticLock) {
/* 1090 */         if (!isLoaded) {
/*      */           try
/*      */           {
/* 1093 */             ois = new ObjectInputStream(context.openFileInput("AppEventsLogger.persistedsessioninfo"));
/*      */             
/* 1095 */             appSessionInfoMap = (HashMap)ois.readObject();
/* 1096 */             Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
/*      */ 
/*      */           }
/*      */           catch (FileNotFoundException localFileNotFoundException) {}catch (Exception e)
/*      */           {
/*      */ 
/* 1102 */             Log.w(
/* 1103 */               AppEventsLogger.TAG, "Got unexpected exception restoring app session info: " + e
/*      */               
/* 1105 */               .toString());
/*      */           } finally {
/* 1107 */             Utility.closeQuietly(ois);
/* 1108 */             context.deleteFile("AppEventsLogger.persistedsessioninfo");
/* 1109 */             if (appSessionInfoMap == null) {
/* 1110 */               appSessionInfoMap = new HashMap();
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/* 1116 */             isLoaded = true;
/* 1117 */             hasChanges = false;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     static void saveAppSessionInformation(Context context) {
/* 1124 */       ObjectOutputStream oos = null;
/*      */       
/* 1126 */       synchronized (staticLock) {
/* 1127 */         if (hasChanges)
/*      */         {
/*      */           try
/*      */           {
/* 1131 */             oos = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
/*      */             
/*      */ 
/*      */ 
/*      */ 
/* 1136 */             oos.writeObject(appSessionInfoMap);
/* 1137 */             hasChanges = false;
/* 1138 */             Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
/*      */ 
/*      */           }
/*      */           catch (Exception e)
/*      */           {
/* 1143 */             Log.w(
/* 1144 */               AppEventsLogger.TAG, "Got unexpected exception while writing app session info: " + e
/*      */               
/* 1146 */               .toString());
/*      */           } finally {
/* 1148 */             Utility.closeQuietly(oos);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     static void onResume(Context context, AccessTokenAppIdPair accessTokenAppId, AppEventsLogger logger, long eventTime, String sourceApplicationInfo)
/*      */     {
/* 1161 */       synchronized (staticLock) {
/* 1162 */         FacebookTimeSpentData timeSpentData = getTimeSpentData(context, accessTokenAppId);
/* 1163 */         timeSpentData.onResume(logger, eventTime, sourceApplicationInfo);
/* 1164 */         onTimeSpentDataUpdate();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppId, AppEventsLogger logger, long eventTime)
/*      */     {
/* 1174 */       synchronized (staticLock) {
/* 1175 */         FacebookTimeSpentData timeSpentData = getTimeSpentData(context, accessTokenAppId);
/* 1176 */         timeSpentData.onSuspend(logger, eventTime);
/* 1177 */         onTimeSpentDataUpdate();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppId)
/*      */     {
/* 1185 */       restoreAppSessionInformation(context);
/* 1186 */       FacebookTimeSpentData result = null;
/*      */       
/* 1188 */       result = (FacebookTimeSpentData)appSessionInfoMap.get(accessTokenAppId);
/* 1189 */       if (result == null) {
/* 1190 */         result = new FacebookTimeSpentData();
/* 1191 */         appSessionInfoMap.put(accessTokenAppId, result);
/*      */       }
/*      */       
/* 1194 */       return result;
/*      */     }
/*      */     
/*      */     private static void onTimeSpentDataUpdate() {
/* 1198 */       if (!hasChanges) {
/* 1199 */         hasChanges = true;
/* 1200 */         AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AppEventsLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */