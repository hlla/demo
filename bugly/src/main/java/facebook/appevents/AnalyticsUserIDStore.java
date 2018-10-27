/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.content.SharedPreferences;
/*     */ import android.preference.PreferenceManager;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.appevents.internal.AppEventUtility;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
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
/*     */ class AnalyticsUserIDStore
/*     */ {
/*  33 */   private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
/*     */   
/*     */   private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
/*     */   
/*  37 */   private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   private static String userID;
/*  39 */   private static volatile boolean initialized = false;
/*     */   
/*     */   public static void initStore() {
/*  42 */     if (initialized) {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
/*     */     {
/*     */       public void run() {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public static void setUserID(String id)
/*     */   {
/*     */     
/*  56 */     if (!initialized) {
/*  57 */       Log.w(TAG, "initStore should have been called before calling setUserID");
/*  58 */       initAndWait();
/*     */     }
/*     */     
/*  61 */     AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
/*     */     {
/*     */       /* Error */
/*     */       public void run()
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 4	com/facebook/appevents/AnalyticsUserIDStore:access$100	()Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */         //   3: invokevirtual 5	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */         //   6: invokevirtual 6	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
/*     */         //   9: aload_0
/*     */         //   10: getfield 2	com/facebook/appevents/AnalyticsUserIDStore$2:val$id	Ljava/lang/String;
/*     */         //   13: invokestatic 7	com/facebook/appevents/AnalyticsUserIDStore:access$202	(Ljava/lang/String;)Ljava/lang/String;
/*     */         //   16: pop
/*     */         //   17: invokestatic 8	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
/*     */         //   20: invokestatic 9	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
/*     */         //   23: astore_1
/*     */         //   24: aload_1
/*     */         //   25: invokeinterface 10 1 0
/*     */         //   30: astore_2
/*     */         //   31: aload_2
/*     */         //   32: ldc 11
/*     */         //   34: invokestatic 12	com/facebook/appevents/AnalyticsUserIDStore:access$200	()Ljava/lang/String;
/*     */         //   37: invokeinterface 13 3 0
/*     */         //   42: pop
/*     */         //   43: aload_2
/*     */         //   44: invokeinterface 14 1 0
/*     */         //   49: invokestatic 4	com/facebook/appevents/AnalyticsUserIDStore:access$100	()Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */         //   52: invokevirtual 5	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */         //   55: invokevirtual 15	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */         //   58: goto +15 -> 73
/*     */         //   61: astore_3
/*     */         //   62: invokestatic 4	com/facebook/appevents/AnalyticsUserIDStore:access$100	()Ljava/util/concurrent/locks/ReentrantReadWriteLock;
/*     */         //   65: invokevirtual 5	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
/*     */         //   68: invokevirtual 15	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
/*     */         //   71: aload_3
/*     */         //   72: athrow
/*     */         //   73: return
/*     */         // Line number table:
/*     */         //   Java source line #64	-> byte code offset #0
/*     */         //   Java source line #66	-> byte code offset #9
/*     */         //   Java source line #69	-> byte code offset #17
/*     */         //   Java source line #68	-> byte code offset #20
/*     */         //   Java source line #70	-> byte code offset #24
/*     */         //   Java source line #71	-> byte code offset #31
/*     */         //   Java source line #72	-> byte code offset #43
/*     */         //   Java source line #74	-> byte code offset #49
/*     */         //   Java source line #75	-> byte code offset #58
/*     */         //   Java source line #74	-> byte code offset #61
/*     */         //   Java source line #76	-> byte code offset #73
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	74	0	this	2
/*     */         //   23	2	1	sharedPreferences	SharedPreferences
/*     */         //   30	14	2	editor	android.content.SharedPreferences.Editor
/*     */         //   61	11	3	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   9	49	61	finally
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String getUserID()
/*     */   {
/*  81 */     if (!initialized) {
/*  82 */       Log.w(TAG, "initStore should have been called before calling setUserID");
/*  83 */       initAndWait();
/*     */     }
/*     */     
/*  86 */     lock.readLock().lock();
/*     */     try {
/*  88 */       return userID;
/*     */     } finally {
/*  90 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void initAndWait() {
/*  95 */     if (initialized) {
/*  96 */       return;
/*     */     }
/*     */     
/*  99 */     lock.writeLock().lock();
/*     */     try {
/* 101 */       if (initialized) {
/* 102 */         return;
/*     */       }
/*     */       
/* 105 */       SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/* 106 */         FacebookSdk.getApplicationContext());
/* 107 */       userID = sharedPreferences.getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
/* 108 */       initialized = true;
/*     */     } finally {
/* 110 */       lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AnalyticsUserIDStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */