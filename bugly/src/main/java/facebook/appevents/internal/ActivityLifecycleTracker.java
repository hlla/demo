/*     */ package com.facebook.appevents.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Application;
/*     */ import android.app.Application.ActivityLifecycleCallbacks;
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ public class ActivityLifecycleTracker
/*     */ {
/*  44 */   private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
/*     */   
/*     */   private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
/*     */   
/*     */   private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
/*     */   
/*  50 */   private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
/*     */   private static volatile ScheduledFuture currentFuture;
/*  52 */   private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
/*     */   
/*     */   private static volatile SessionInfo currentSession;
/*  55 */   private static AtomicBoolean tracking = new AtomicBoolean(false);
/*     */   private static String appId;
/*     */   private static long currentActivityAppearTime;
/*     */   
/*     */   public static void startTracking(Application application, String appId) {
/*  60 */     if (!tracking.compareAndSet(false, true)) {
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     appId = appId;
/*     */     
/*  66 */     application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks()
/*     */     {
/*     */ 
/*     */       public void onActivityCreated(Activity activity, Bundle savedInstanceState)
/*     */       {
/*     */ 
/*  72 */         AppEventUtility.assertIsMainThread();
/*  73 */         ActivityLifecycleTracker.onActivityCreated(activity);
/*     */       }
/*     */       
/*     */ 
/*     */       public void onActivityStarted(Activity activity) {}
/*     */       
/*     */       public void onActivityResumed(Activity activity)
/*     */       {
/*  81 */         AppEventUtility.assertIsMainThread();
/*  82 */         ActivityLifecycleTracker.onActivityResumed(activity);
/*     */       }
/*     */       
/*     */       public void onActivityPaused(Activity activity)
/*     */       {
/*  87 */         AppEventUtility.assertIsMainThread();
/*  88 */         ActivityLifecycleTracker.onActivityPaused(activity);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onActivityStopped(Activity activity) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
/*     */       
/*     */ 
/*     */       public void onActivityDestroyed(Activity activity) {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean isTracking()
/*     */   {
/* 107 */     return tracking.get();
/*     */   }
/*     */   
/*     */   public static UUID getCurrentSessionGuid() {
/* 111 */     return currentSession != null ? currentSession.getSessionId() : null;
/*     */   }
/*     */   
/*     */   public static void onActivityCreated(Activity activity)
/*     */   {
/* 116 */     final long currentTime = System.currentTimeMillis();
/* 117 */     Runnable handleActivityCreate = new Runnable()
/*     */     {
/*     */       public void run() {
/* 120 */         if (ActivityLifecycleTracker.currentSession == null) {
/* 121 */           Context applicationContext = this.val$activity.getApplicationContext();
/* 122 */           String activityName = Utility.getActivityName(this.val$activity);
/*     */           
/*     */ 
/* 125 */           SessionInfo lastSession = SessionInfo.getStoredSessionInfo();
/* 126 */           if (lastSession != null) {
/* 127 */             SessionLogger.logDeactivateApp(applicationContext, activityName, lastSession, 
/*     */             
/*     */ 
/*     */ 
/* 131 */               ActivityLifecycleTracker.appId);
/*     */           }
/*     */           
/* 134 */           ActivityLifecycleTracker.access$102(new SessionInfo(Long.valueOf(currentTime), null));
/*     */           
/* 136 */           SourceApplicationInfo sourceApplicationInfo = SourceApplicationInfo.Factory.create(this.val$activity);
/* 137 */           ActivityLifecycleTracker.currentSession.setSourceApplicationInfo(sourceApplicationInfo);
/* 138 */           SessionLogger.logActivateApp(applicationContext, activityName, sourceApplicationInfo, 
/*     */           
/*     */ 
/*     */ 
/* 142 */             ActivityLifecycleTracker.appId);
/*     */         }
/*     */       }
/* 145 */     };
/* 146 */     singleThreadExecutor.execute(handleActivityCreate);
/*     */   }
/*     */   
/*     */   public static void onActivityResumed(Activity activity)
/*     */   {
/* 151 */     foregroundActivityCount.incrementAndGet();
/* 152 */     cancelCurrentTask();
/* 153 */     final long currentTime = System.currentTimeMillis();
/* 154 */     currentActivityAppearTime = currentTime;
/* 155 */     Runnable handleActivityResume = new Runnable()
/*     */     {
/*     */       public void run() {
/* 158 */         Context applicationContext = this.val$activity.getApplicationContext();
/* 159 */         String activityName = Utility.getActivityName(this.val$activity);
/*     */         
/* 161 */         if (ActivityLifecycleTracker.currentSession == null) {
/* 162 */           ActivityLifecycleTracker.access$102(new SessionInfo(Long.valueOf(currentTime), null));
/* 163 */           SessionLogger.logActivateApp(applicationContext, activityName, null, 
/*     */           
/*     */ 
/*     */ 
/* 167 */             ActivityLifecycleTracker.appId);
/* 168 */         } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null)
/*     */         {
/* 170 */           long suspendTime = currentTime - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
/* 171 */           if (suspendTime > ActivityLifecycleTracker.access$300() * 1000)
/*     */           {
/*     */ 
/* 174 */             SessionLogger.logDeactivateApp(applicationContext, activityName, 
/*     */             
/*     */ 
/* 177 */               ActivityLifecycleTracker.currentSession, 
/* 178 */               ActivityLifecycleTracker.appId);
/* 179 */             SessionLogger.logActivateApp(applicationContext, activityName, null, 
/*     */             
/*     */ 
/*     */ 
/* 183 */               ActivityLifecycleTracker.appId);
/* 184 */             ActivityLifecycleTracker.access$102(new SessionInfo(Long.valueOf(currentTime), null));
/* 185 */           } else if (suspendTime > 1000L) {
/* 186 */             ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
/*     */           }
/*     */         }
/*     */         
/* 190 */         ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTime));
/* 191 */         ActivityLifecycleTracker.currentSession.writeSessionToDisk();
/*     */       }
/*     */       
/* 194 */     };
/* 195 */     singleThreadExecutor.execute(handleActivityResume);
/*     */   }
/*     */   
/*     */   private static void onActivityPaused(Activity activity) {
/* 199 */     int count = foregroundActivityCount.decrementAndGet();
/* 200 */     if (count < 0)
/*     */     {
/*     */ 
/* 203 */       foregroundActivityCount.set(0);
/*     */       
/* 205 */       Log.w(TAG, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
/*     */     }
/*     */     
/* 208 */     cancelCurrentTask();
/* 209 */     long currentTime = System.currentTimeMillis();
/*     */     
/*     */ 
/* 212 */     Context applicationContext = activity.getApplicationContext();
/* 213 */     final String activityName = Utility.getActivityName(activity);
/*     */     
/* 215 */     Runnable handleActivityPaused = new Runnable()
/*     */     {
/*     */       public void run() {
/* 218 */         if (ActivityLifecycleTracker.currentSession == null)
/*     */         {
/*     */ 
/* 221 */           ActivityLifecycleTracker.access$102(new SessionInfo(Long.valueOf(this.val$currentTime), null));
/*     */         }
/*     */         
/* 224 */         ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(this.val$currentTime));
/* 225 */         if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0)
/*     */         {
/*     */ 
/*     */ 
/* 229 */           Runnable task = new Runnable()
/*     */           {
/*     */             public void run() {
/* 232 */               if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
/* 233 */                 SessionLogger.logDeactivateApp(ActivityLifecycleTracker.4.this.val$applicationContext, ActivityLifecycleTracker.4.this.val$activityName, 
/*     */                 
/*     */ 
/* 236 */                   ActivityLifecycleTracker.currentSession, 
/* 237 */                   ActivityLifecycleTracker.appId);
/* 238 */                 SessionInfo.clearSavedSessionFromDisk();
/* 239 */                 ActivityLifecycleTracker.access$102(null);
/*     */               }
/*     */               
/* 242 */               ActivityLifecycleTracker.access$502(null);
/*     */             }
/* 244 */           };
/* 245 */           ActivityLifecycleTracker.access$502(ActivityLifecycleTracker.singleThreadExecutor.schedule(task, 
/*     */           
/* 247 */             ActivityLifecycleTracker.access$300(), TimeUnit.SECONDS));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 252 */         long appearTime = ActivityLifecycleTracker.currentActivityAppearTime;
/* 253 */         long timeSpentOnActivityInSeconds = appearTime > 0L ? (this.val$currentTime - appearTime) / 1000L : 0L;
/*     */         
/*     */ 
/* 256 */         AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, 
/*     */         
/* 258 */           ActivityLifecycleTracker.appId, this.val$activityName, timeSpentOnActivityInSeconds);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 263 */         ActivityLifecycleTracker.currentSession.writeSessionToDisk();
/*     */       }
/* 265 */     };
/* 266 */     singleThreadExecutor.execute(handleActivityPaused);
/*     */   }
/*     */   
/*     */   private static int getSessionTimeoutInSeconds()
/*     */   {
/* 271 */     FetchedAppSettings settings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
/* 272 */     if (settings == null) {
/* 273 */       return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
/*     */     }
/*     */     
/* 276 */     return settings.getSessionTimeoutInSeconds();
/*     */   }
/*     */   
/*     */   private static void cancelCurrentTask() {
/* 280 */     if (currentFuture != null) {
/* 281 */       currentFuture.cancel(false);
/*     */     }
/*     */     
/* 284 */     currentFuture = null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/ActivityLifecycleTracker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */