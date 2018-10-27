/*    */ package com.facebook.appevents;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ class PersistedEvents
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 20160629001L;
/* 31 */   private HashMap<AccessTokenAppIdPair, List<AppEvent>> events = new HashMap();
/*    */   
/*    */   public PersistedEvents() {}
/*    */   
/*    */   public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> appEventMap)
/*    */   {
/* 37 */     this.events.putAll(appEventMap);
/*    */   }
/*    */   
/*    */   public Set<AccessTokenAppIdPair> keySet() {
/* 41 */     return this.events.keySet();
/*    */   }
/*    */   
/*    */   public List<AppEvent> get(AccessTokenAppIdPair accessTokenAppIdPair) {
/* 45 */     return (List)this.events.get(accessTokenAppIdPair);
/*    */   }
/*    */   
/*    */   public boolean containsKey(AccessTokenAppIdPair accessTokenAppIdPair) {
/* 49 */     return this.events.containsKey(accessTokenAppIdPair);
/*    */   }
/*    */   
/*    */   public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> appEvents) {
/* 53 */     if (!this.events.containsKey(accessTokenAppIdPair)) {
/* 54 */       this.events.put(accessTokenAppIdPair, appEvents);
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     ((List)this.events.get(accessTokenAppIdPair)).addAll(appEvents);
/*    */   }
/*    */   
/*    */   static class SerializationProxyV1 implements Serializable {
/*    */     private static final long serialVersionUID = 20160629001L;
/*    */     private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;
/*    */     
/*    */     private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> events) {
/* 66 */       this.proxyEvents = events;
/*    */     }
/*    */     
/*    */     private Object readResolve() {
/* 70 */       return new PersistedEvents(this.proxyEvents);
/*    */     }
/*    */   }
/*    */   
/*    */   private Object writeReplace() {
/* 75 */     return new SerializationProxyV1(this.events, null);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/PersistedEvents.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */