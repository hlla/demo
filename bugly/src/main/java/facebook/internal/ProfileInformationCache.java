/*    */ package com.facebook.internal;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.json.JSONObject;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ProfileInformationCache
/*    */ {
/* 36 */   private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap();
/*    */   
/*    */   public static JSONObject getProfileInformation(String accessToken)
/*    */   {
/* 40 */     return (JSONObject)infoCache.get(accessToken);
/*    */   }
/*    */   
/*    */   public static void putProfileInformation(String key, JSONObject value) {
/* 44 */     infoCache.put(key, value);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ProfileInformationCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */