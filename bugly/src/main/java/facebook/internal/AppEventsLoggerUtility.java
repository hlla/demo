/*    */ package com.facebook.internal;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.facebook.LoggingBehavior;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.json.JSONException;
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
/*    */ public class AppEventsLoggerUtility
/*    */ {
/*    */   public static enum GraphAPIActivityType
/*    */   {
/* 41 */     MOBILE_INSTALL_EVENT, 
/* 42 */     CUSTOM_APP_EVENTS;
/*    */     
/*    */     private GraphAPIActivityType() {} }
/* 45 */   private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new HashMap() {};
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType activityType, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage, Context context)
/*    */     throws JSONException
/*    */   {
/* 57 */     JSONObject publishParams = new JSONObject();
/*    */     
/* 59 */     publishParams.put("event", API_ACTIVITY_TYPE_TO_STRING.get(activityType));
/*    */     
/* 61 */     Utility.setAppEventAttributionParameters(publishParams, attributionIdentifiers, anonymousAppDeviceGUID, limitEventUsage);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 68 */       Utility.setAppEventExtendedDeviceInfoParameters(publishParams, context);
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 73 */       Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", new Object[] {e
/*    */       
/* 75 */         .toString() });
/*    */     }
/*    */     
/* 78 */     publishParams.put("application_package_name", context.getPackageName());
/*    */     
/* 80 */     return publishParams;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/AppEventsLoggerUtility.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */