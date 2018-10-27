/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import com.facebook.internal.Logger;
/*     */ import java.io.Serializable;
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
/*     */ class FacebookTimeSpentData
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  36 */   private static final String TAG = FacebookTimeSpentData.class.getCanonicalName();
/*     */   
/*     */   private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
/*     */   
/*     */   private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
/*     */   
/*     */   private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
/*     */   
/*     */   private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
/*  45 */   private static final long[] INACTIVE_SECONDS_QUANTA = { 300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L };
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean isWarmLaunch;
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean isAppActive;
/*     */   
/*     */ 
/*     */ 
/*     */   private long lastActivateEventLoggedTime;
/*     */   
/*     */ 
/*     */ 
/*     */   private long lastResumeTime;
/*     */   
/*     */ 
/*     */ 
/*     */   private long lastSuspendTime;
/*     */   
/*     */ 
/*     */   private long millisecondsSpentInSession;
/*     */   
/*     */ 
/*     */   private int interruptionCount;
/*     */   
/*     */ 
/*     */   private String firstOpenSourceApplication;
/*     */   
/*     */ 
/*     */ 
/*     */   private static class SerializationProxyV1
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 6L;
/*     */     
/*     */ 
/*     */     private final long lastResumeTime;
/*     */     
/*     */ 
/*     */     private final long lastSuspendTime;
/*     */     
/*     */ 
/*     */     private final long millisecondsSpentInSession;
/*     */     
/*     */ 
/*     */     private final int interruptionCount;
/*     */     
/*     */ 
/*     */ 
/*     */     SerializationProxyV1(long lastResumeTime, long lastSuspendTime, long millisecondsSpentInSession, int interruptionCount)
/*     */     {
/*  99 */       this.lastResumeTime = lastResumeTime;
/* 100 */       this.lastSuspendTime = lastSuspendTime;
/* 101 */       this.millisecondsSpentInSession = millisecondsSpentInSession;
/* 102 */       this.interruptionCount = interruptionCount;
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 106 */       return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, null);
/*     */     }
/*     */   }
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
/*     */   private FacebookTimeSpentData(long lastResumeTime, long lastSuspendTime, long millisecondsSpentInSession, int interruptionCount)
/*     */   {
/* 125 */     resetSession();
/* 126 */     this.lastResumeTime = lastResumeTime;
/* 127 */     this.lastSuspendTime = lastSuspendTime;
/* 128 */     this.millisecondsSpentInSession = millisecondsSpentInSession;
/* 129 */     this.interruptionCount = interruptionCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class SerializationProxyV2
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 6L;
/*     */     
/*     */ 
/*     */     private final long lastResumeTime;
/*     */     
/*     */ 
/*     */     private final long lastSuspendTime;
/*     */     
/*     */ 
/*     */     private final long millisecondsSpentInSession;
/*     */     
/*     */     private final int interruptionCount;
/*     */     
/*     */     private final String firstOpenSourceApplication;
/*     */     
/*     */ 
/*     */     SerializationProxyV2(long lastResumeTime, long lastSuspendTime, long millisecondsSpentInSession, int interruptionCount, String firstOpenSourceApplication)
/*     */     {
/* 155 */       this.lastResumeTime = lastResumeTime;
/* 156 */       this.lastSuspendTime = lastSuspendTime;
/* 157 */       this.millisecondsSpentInSession = millisecondsSpentInSession;
/* 158 */       this.interruptionCount = interruptionCount;
/* 159 */       this.firstOpenSourceApplication = firstOpenSourceApplication;
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 163 */       return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   FacebookTimeSpentData()
/*     */   {
/* 173 */     resetSession();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private FacebookTimeSpentData(long lastResumeTime, long lastSuspendTime, long millisecondsSpentInSession, int interruptionCount, String firstOpenSourceApplication)
/*     */   {
/* 186 */     resetSession();
/* 187 */     this.lastResumeTime = lastResumeTime;
/* 188 */     this.lastSuspendTime = lastSuspendTime;
/* 189 */     this.millisecondsSpentInSession = millisecondsSpentInSession;
/* 190 */     this.interruptionCount = interruptionCount;
/* 191 */     this.firstOpenSourceApplication = firstOpenSourceApplication;
/*     */   }
/*     */   
/*     */   private Object writeReplace() {
/* 195 */     return new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onSuspend(AppEventsLogger logger, long eventTime)
/*     */   {
/* 205 */     if (!this.isAppActive) {
/* 206 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
/* 207 */       return;
/*     */     }
/*     */     
/* 210 */     long now = eventTime;
/* 211 */     long delta = now - this.lastResumeTime;
/* 212 */     if (delta < 0L) {
/* 213 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
/* 214 */       delta = 0L;
/*     */     }
/* 216 */     this.millisecondsSpentInSession += delta;
/* 217 */     this.lastSuspendTime = now;
/* 218 */     this.isAppActive = false;
/*     */   }
/*     */   
/*     */   void onResume(AppEventsLogger logger, long eventTime, String sourceApplicationInfo) {
/* 222 */     long now = eventTime;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */     if ((isColdLaunch()) || (now - this.lastActivateEventLoggedTime > 300000L))
/*     */     {
/* 230 */       Bundle eventParams = new Bundle();
/* 231 */       eventParams.putString("fb_mobile_launch_source", sourceApplicationInfo);
/*     */       
/*     */ 
/* 234 */       logger.logEvent("fb_mobile_activate_app", eventParams);
/* 235 */       this.lastActivateEventLoggedTime = now;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 240 */     if (this.isAppActive) {
/* 241 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
/* 242 */       return;
/*     */     }
/*     */     
/* 245 */     long interruptionDurationMillis = wasSuspendedEver() ? now - this.lastSuspendTime : 0L;
/* 246 */     if (interruptionDurationMillis < 0L) {
/* 247 */       Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
/* 248 */       interruptionDurationMillis = 0L;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 253 */     if (interruptionDurationMillis > 60000L) {
/* 254 */       logAppDeactivatedEvent(logger, interruptionDurationMillis);
/*     */ 
/*     */ 
/*     */     }
/* 258 */     else if (interruptionDurationMillis > 1000L) {
/* 259 */       this.interruptionCount += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 264 */     if (this.interruptionCount == 0) {
/* 265 */       this.firstOpenSourceApplication = sourceApplicationInfo;
/*     */     }
/*     */     
/* 268 */     this.lastResumeTime = now;
/* 269 */     this.isAppActive = true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void logAppDeactivatedEvent(AppEventsLogger logger, long interruptionDurationMillis)
/*     */   {
/* 275 */     Bundle eventParams = new Bundle();
/* 276 */     eventParams.putInt("fb_mobile_app_interruptions", this.interruptionCount);
/*     */     
/*     */ 
/* 279 */     eventParams.putString("fb_mobile_time_between_sessions", 
/*     */     
/* 281 */       String.format(Locale.ROOT, "session_quanta_%d", new Object[] {
/*     */       
/*     */ 
/* 284 */       Integer.valueOf(getQuantaIndex(interruptionDurationMillis)) }));
/* 285 */     eventParams.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
/*     */     
/*     */ 
/* 288 */     logger.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, eventParams);
/*     */     
/*     */ 
/*     */ 
/* 292 */     resetSession();
/*     */   }
/*     */   
/*     */   private static int getQuantaIndex(long timeBetweenSessions) {
/* 296 */     int quantaIndex = 0;
/*     */     
/* 298 */     while ((quantaIndex < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[quantaIndex] < timeBetweenSessions))
/*     */     {
/*     */ 
/*     */ 
/* 302 */       quantaIndex++;
/*     */     }
/*     */     
/* 305 */     return quantaIndex;
/*     */   }
/*     */   
/*     */   private void resetSession() {
/* 309 */     this.isAppActive = false;
/* 310 */     this.lastResumeTime = -1L;
/* 311 */     this.lastSuspendTime = -1L;
/* 312 */     this.interruptionCount = 0;
/* 313 */     this.millisecondsSpentInSession = 0L;
/*     */   }
/*     */   
/*     */   private boolean wasSuspendedEver() {
/* 317 */     return this.lastSuspendTime != -1L;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isColdLaunch()
/*     */   {
/* 323 */     boolean result = !this.isWarmLaunch;
/* 324 */     this.isWarmLaunch = true;
/* 325 */     return result;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/FacebookTimeSpentData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */