/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.internal.AppEventsLoggerUtility;
/*     */ import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
/*     */ import com.facebook.internal.AttributionIdentifiers;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ class SessionEventsState
/*     */ {
/*  40 */   private List<AppEvent> accumulatedEvents = new ArrayList();
/*  41 */   private List<AppEvent> inFlightEvents = new ArrayList();
/*     */   
/*     */   private int numSkippedEventsDueToFullBuffer;
/*     */   private AttributionIdentifiers attributionIdentifiers;
/*     */   private String anonymousAppDeviceGUID;
/*  46 */   private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
/*     */   
/*     */ 
/*     */   public SessionEventsState(AttributionIdentifiers identifiers, String anonymousGUID)
/*     */   {
/*  51 */     this.attributionIdentifiers = identifiers;
/*  52 */     this.anonymousAppDeviceGUID = anonymousGUID;
/*     */   }
/*     */   
/*     */ 
/*     */   public synchronized void addEvent(AppEvent event)
/*     */   {
/*  58 */     if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
/*  59 */       this.numSkippedEventsDueToFullBuffer += 1;
/*     */     } else {
/*  61 */       this.accumulatedEvents.add(event);
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized int getAccumulatedEventCount() {
/*  66 */     return this.accumulatedEvents.size();
/*     */   }
/*     */   
/*     */   public synchronized void clearInFlightAndStats(boolean moveToAccumulated) {
/*  70 */     if (moveToAccumulated) {
/*  71 */       this.accumulatedEvents.addAll(this.inFlightEvents);
/*     */     }
/*  73 */     this.inFlightEvents.clear();
/*  74 */     this.numSkippedEventsDueToFullBuffer = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int populateRequest(GraphRequest request, Context applicationContext, boolean includeImplicitEvents, boolean limitEventUsage)
/*     */   {
/*  85 */     synchronized (this) {
/*  86 */       int numSkipped = this.numSkippedEventsDueToFullBuffer;
/*     */       
/*     */ 
/*  89 */       this.inFlightEvents.addAll(this.accumulatedEvents);
/*  90 */       this.accumulatedEvents.clear();
/*     */       
/*  92 */       JSONArray jsonArray = new JSONArray();
/*  93 */       for (AppEvent event : this.inFlightEvents) {
/*  94 */         if (event.isChecksumValid()) {
/*  95 */           if ((includeImplicitEvents) || (!event.getIsImplicit())) {
/*  96 */             jsonArray.put(event.getJSONObject());
/*     */           }
/*     */         } else {
/*  99 */           Utility.logd("Event with invalid checksum: %s", event.toString());
/*     */         }
/*     */       }
/*     */       
/* 103 */       if (jsonArray.length() == 0)
/* 104 */         return 0;
/*     */     }
/*     */     JSONArray jsonArray;
/*     */     int numSkipped;
/* 108 */     populateRequest(request, applicationContext, numSkipped, jsonArray, limitEventUsage);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     return jsonArray.length();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized List<AppEvent> getEventsToPersist()
/*     */   {
/* 121 */     List<AppEvent> result = this.accumulatedEvents;
/* 122 */     this.accumulatedEvents = new ArrayList();
/* 123 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized void accumulatePersistedEvents(List<AppEvent> events)
/*     */   {
/* 130 */     this.accumulatedEvents.addAll(events);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void populateRequest(GraphRequest request, Context applicationContext, int numSkipped, JSONArray events, boolean limitEventUsage)
/*     */   {
/* 139 */     JSONObject publishParams = null;
/*     */     try {
/* 141 */       publishParams = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, limitEventUsage, applicationContext);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       if (this.numSkippedEventsDueToFullBuffer > 0) {
/* 149 */         publishParams.put("num_skipped_events", numSkipped);
/*     */       }
/*     */     }
/*     */     catch (JSONException e) {
/* 153 */       publishParams = new JSONObject();
/*     */     }
/* 155 */     request.setGraphObject(publishParams);
/*     */     
/* 157 */     Bundle requestParameters = request.getParameters();
/* 158 */     if (requestParameters == null) {
/* 159 */       requestParameters = new Bundle();
/*     */     }
/*     */     
/* 162 */     String jsonString = events.toString();
/* 163 */     if (jsonString != null) {
/* 164 */       requestParameters.putByteArray("custom_events_file", 
/*     */       
/* 166 */         getStringAsByteArray(jsonString));
/* 167 */       request.setTag(jsonString);
/*     */     }
/* 169 */     request.setParameters(requestParameters);
/*     */   }
/*     */   
/*     */   private byte[] getStringAsByteArray(String jsonString) {
/* 173 */     byte[] jsonUtf8 = null;
/*     */     try {
/* 175 */       jsonUtf8 = jsonString.getBytes("UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/* 178 */       Utility.logd("Encoding exception: ", e);
/*     */     }
/* 180 */     return jsonUtf8;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/SessionEventsState.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */