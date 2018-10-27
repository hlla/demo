/*    */ package com.facebook.appevents;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.facebook.FacebookSdk;
/*    */ import com.facebook.internal.AttributionIdentifiers;
/*    */ import java.util.HashMap;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AppEventCollection
/*    */ {
/*    */   private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap;
/*    */   
/*    */   public AppEventCollection()
/*    */   {
/* 35 */     this.stateMap = new HashMap();
/*    */   }
/*    */   
/*    */   public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
/* 39 */     if (persistedEvents == null) {
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
/* 44 */       sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
/*    */       
/* 46 */       for (AppEvent appEvent : persistedEvents.get(accessTokenAppIdPair)) {
/* 47 */         sessionEventsState.addEvent(appEvent);
/*    */       }
/*    */     }
/*    */     SessionEventsState sessionEventsState;
/*    */   }
/*    */   
/*    */   public synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent)
/*    */   {
/* 55 */     SessionEventsState eventsState = getSessionEventsState(accessTokenAppIdPair);
/* 56 */     eventsState.addEvent(appEvent);
/*    */   }
/*    */   
/*    */   public synchronized Set<AccessTokenAppIdPair> keySet() {
/* 60 */     return this.stateMap.keySet();
/*    */   }
/*    */   
/*    */   public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
/* 64 */     return (SessionEventsState)this.stateMap.get(accessTokenAppIdPair);
/*    */   }
/*    */   
/*    */   public synchronized int getEventCount() {
/* 68 */     int count = 0;
/* 69 */     for (SessionEventsState sessionEventsState : this.stateMap.values()) {
/* 70 */       count += sessionEventsState.getAccumulatedEventCount();
/*    */     }
/*    */     
/* 73 */     return count;
/*    */   }
/*    */   
/*    */   private synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppId)
/*    */   {
/* 78 */     SessionEventsState eventsState = (SessionEventsState)this.stateMap.get(accessTokenAppId);
/* 79 */     if (eventsState == null) {
/* 80 */       Context context = FacebookSdk.getApplicationContext();
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 86 */       eventsState = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(context), AppEventsLogger.getAnonymousAppDeviceGUID(context));
/*    */     }
/*    */     
/* 89 */     this.stateMap.put(accessTokenAppId, eventsState);
/*    */     
/* 91 */     return eventsState;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AppEventCollection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */