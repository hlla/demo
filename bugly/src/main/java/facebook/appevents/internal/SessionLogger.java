/*     */ package com.facebook.appevents.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import com.facebook.internal.Logger;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ class SessionLogger
/*     */ {
/*  34 */   private static final String TAG = SessionLogger.class.getCanonicalName();
/*     */   
/*  36 */   private static final long[] INACTIVE_SECONDS_QUANTA = { 300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logActivateApp(Context applicationContext, String activityName, SourceApplicationInfo sourceApplicationInfo, String appId)
/*     */   {
/*  66 */     String sourAppInfoStr = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
/*     */     
/*     */ 
/*  69 */     Bundle eventParams = new Bundle();
/*  70 */     eventParams.putString("fb_mobile_launch_source", sourAppInfoStr);
/*     */     
/*     */ 
/*  73 */     new InternalAppEventsLogger(activityName, appId, null)
/*     */     
/*     */ 
/*     */ 
/*  77 */       .logEvent("fb_mobile_activate_app", eventParams);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logDeactivateApp(Context applicationContext, String activityName, SessionInfo sessionInfo, String appId)
/*     */   {
/*  87 */     Long interruptionDurationMillis = Long.valueOf(sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue());
/*  88 */     if (interruptionDurationMillis.longValue() < 0L) {
/*  89 */       interruptionDurationMillis = Long.valueOf(0L);
/*  90 */       logClockSkewEvent();
/*     */     }
/*     */     
/*  93 */     Long sessionLength = Long.valueOf(sessionInfo.getSessionLength());
/*  94 */     if (sessionLength.longValue() < 0L) {
/*  95 */       logClockSkewEvent();
/*  96 */       sessionLength = Long.valueOf(0L);
/*     */     }
/*     */     
/*  99 */     Bundle eventParams = new Bundle();
/* 100 */     eventParams.putInt("fb_mobile_app_interruptions", sessionInfo
/*     */     
/* 102 */       .getInterruptionCount());
/* 103 */     eventParams.putString("fb_mobile_time_between_sessions", 
/*     */     
/* 105 */       String.format(Locale.ROOT, "session_quanta_%d", new Object[] {
/*     */       
/*     */ 
/* 108 */       Integer.valueOf(getQuantaIndex(interruptionDurationMillis.longValue())) }));
/* 109 */     SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
/*     */     
/* 111 */     String sourAppInfoStr = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
/*     */     
/* 113 */     eventParams.putString("fb_mobile_launch_source", sourAppInfoStr);
/*     */     
/*     */ 
/*     */ 
/* 117 */     eventParams.putLong("_logTime", sessionInfo
/* 118 */       .getSessionLastEventTime().longValue() / 1000L);
/*     */     
/* 120 */     new InternalAppEventsLogger(activityName, appId, null)
/*     */     
/*     */ 
/*     */ 
/* 124 */       .logEvent("fb_mobile_deactivate_app", sessionLength
/*     */       
/* 126 */       .longValue() / 1000L, eventParams);
/*     */   }
/*     */   
/*     */   private static void logClockSkewEvent()
/*     */   {
/* 131 */     Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
/*     */   }
/*     */   
/*     */   private static int getQuantaIndex(long timeBetweenSessions) {
/* 135 */     int quantaIndex = 0;
/*     */     
/* 137 */     while ((quantaIndex < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[quantaIndex] < timeBetweenSessions))
/*     */     {
/*     */ 
/*     */ 
/* 141 */       quantaIndex++;
/*     */     }
/*     */     
/* 144 */     return quantaIndex;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/SessionLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */