/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import com.tencent.bugly.b;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class w
/*     */ {
/*     */   private static w a;
/*  17 */   private ScheduledExecutorService b = null;
/*     */   
/*     */ 
/*     */   protected w()
/*     */   {
/*  22 */     ThreadFactory local1 = new ThreadFactory()
/*     */     {
/*     */       public final Thread newThread(Runnable paramAnonymousRunnable)
/*     */       {
/*  26 */         (paramAnonymousRunnable = new Thread(paramAnonymousRunnable)).setName("BUGLY_THREAD");
/*  27 */         return paramAnonymousRunnable;
/*     */       }
/*  29 */     };
/*  30 */     this.b = Executors.newScheduledThreadPool(3, local1);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */     if ((this.b == null) || (this.b.isShutdown())) {
/*  39 */       x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
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
/*     */   public static synchronized w a()
/*     */   {
/*  53 */     if (a == null) {
/*  54 */       a = new w();
/*     */     }
/*  56 */     return a;
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
/*     */   public final synchronized boolean a(Runnable paramRunnable, long paramLong)
/*     */   {
/*  94 */     if (!c()) {
/*  95 */       x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (paramRunnable == null) {
/* 100 */       x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     paramLong = paramLong > 0L ? paramLong : 0L;
/*     */     
/* 106 */     x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", new Object[] { Long.valueOf(paramLong), paramRunnable.getClass().getName() });
/*     */     try {
/* 108 */       this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
/* 109 */       return true;
/*     */     } catch (Throwable paramRunnable) {
/* 111 */       if (b.c)
/* 112 */         paramRunnable.printStackTrace();
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized boolean a(Runnable paramRunnable)
/*     */   {
/* 122 */     if (!c()) {
/* 123 */       x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (paramRunnable == null) {
/* 128 */       x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     x.c("[AsyncTaskHandler] Post a normal task: %s", new Object[] { paramRunnable.getClass().getName() });
/*     */     try {
/* 134 */       this.b.execute(paramRunnable);
/* 135 */       return true;
/*     */     } catch (Throwable paramRunnable) {
/* 137 */       if (b.c)
/* 138 */         paramRunnable.printStackTrace();
/*     */     }
/* 140 */     return false;
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
/*     */   public final synchronized void b()
/*     */   {
/* 176 */     if ((this.b != null) && (!this.b.isShutdown())) {
/* 177 */       x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
/* 178 */       this.b.shutdownNow();
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
/*     */   public final synchronized boolean c()
/*     */   {
/* 196 */     return (this.b != null) && (!this.b.isShutdown());
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/w.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */