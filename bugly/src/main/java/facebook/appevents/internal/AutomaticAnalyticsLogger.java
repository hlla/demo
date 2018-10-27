/*    */ package com.facebook.appevents.internal;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Bundle;
/*    */ import com.facebook.appevents.AppEventsLogger;
/*    */ import com.facebook.internal.FetchedAppSettings;
/*    */ import com.facebook.internal.FetchedAppSettingsManager;
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
/*    */ class AutomaticAnalyticsLogger
/*    */ {
/*    */   public static void logActivityTimeSpentEvent(Context context, String appId, String activityName, long timeSpentInSeconds)
/*    */   {
/* 37 */     AppEventsLogger l = AppEventsLogger.newLogger(context);
/* 38 */     FetchedAppSettings settings = FetchedAppSettingsManager.queryAppSettings(appId, false);
/* 39 */     if ((settings.getAutomaticLoggingEnabled()) && (timeSpentInSeconds > 0L)) {
/* 40 */       Bundle params = new Bundle(1);
/* 41 */       params.putCharSequence("fb_aa_time_spent_view_name", activityName);
/* 42 */       l.logEvent("fb_aa_time_spent_on_view", timeSpentInSeconds, params);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/AutomaticAnalyticsLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */