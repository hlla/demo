/*     */ package com.tencent.bugly.crashreport.biz;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Application;
/*     */ import android.app.Application.ActivityLifecycleCallbacks;
/*     */ import android.content.Context;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import com.tencent.bugly.BuglyStrategy;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.List;
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
/*     */ public class b
/*     */ {
/*     */   private static boolean b;
/*  43 */   private static int c = 10;
/*  44 */   private static long d = 300000L;
/*  45 */   private static long e = 30000L;
/*  46 */   private static long f = 0L;
/*     */   
/*     */ 
/*     */   private static int g;
/*     */   
/*     */ 
/*     */   private static long h;
/*     */   
/*     */ 
/*     */   private static long i;
/*     */   
/*     */ 
/*     */   public static a a;
/*     */   
/*     */ 
/*  61 */   private static long j = 0L;
/*     */   
/*     */ 
/*  64 */   private static Application.ActivityLifecycleCallbacks k = null;
/*     */   
/*     */ 
/*  67 */   private static Class<?> l = null;
/*     */   
/*  69 */   private static boolean m = true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
/*     */   {
/* 147 */     boolean bool1 = true;
/* 148 */     boolean bool2 = false;
/* 149 */     if (paramBuglyStrategy != null) {
/* 150 */       bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
/* 151 */       bool1 = paramBuglyStrategy.isEnableUserInfo(); }
/*     */     Object localObject1;
/*     */     Object localObject2;
/* 154 */     if (bool2) {
/* 155 */       paramBuglyStrategy = paramContext;String str = (localObject1 = com.tencent.bugly.crashreport.common.info.a.a(paramContext)).d; if ((localObject2 = a.a(str)) != null) for (int i1 = 0; i1 < ((List)localObject2).size(); i1++) { UserInfoBean localUserInfoBean; if (((localUserInfoBean = (UserInfoBean)((List)localObject2).get(i1)).n.equals(((com.tencent.bugly.crashreport.common.info.a)localObject1).j)) && (localUserInfoBean.b == 1)) { long l1; if ((l1 = z.b()) <= 0L) break; if (localUserInfoBean.f <= 0L) { paramBuglyStrategy = a; w localw; if ((localw = w.a()) != null) localw.a(new a.2(paramBuglyStrategy)); } } } if ((localUserInfoBean.e >= l1 ? 0 : 1) == 0)
/*     */       {
/* 157 */         return;
/*     */       }
/*     */       
/* 160 */       bool1 = false;
/*     */     }
/*     */     
/* 163 */     if ((paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.b()) != null) { localObject1 = null;int n = 0; StackTraceElement[] arrayOfStackTraceElement; int i2 = (arrayOfStackTraceElement = localObject2 = Thread.currentThread().getStackTrace()).length; for (int i3 = 0; i3 < i2; i3++) { StackTraceElement localStackTraceElement; if ((localStackTraceElement = arrayOfStackTraceElement[i3]).getMethodName().equals("onCreate")) localObject1 = localStackTraceElement.getClassName(); if (localStackTraceElement.getClassName().equals("android.app.Activity")) n = 1; } if (localObject1 != null) { if (n != 0) paramBuglyStrategy.a(true); else localObject1 = "background"; } else localObject1 = "unknown"; paramBuglyStrategy.p = ((String)localObject1);
/*     */     }
/* 165 */     if (bool1) {
/* 166 */       paramBuglyStrategy = paramContext;localObject1 = null; if (Build.VERSION.SDK_INT >= 14) { if ((paramBuglyStrategy.getApplicationContext() instanceof Application)) localObject1 = (Application)paramBuglyStrategy.getApplicationContext(); if (localObject1 != null) try { if (k == null) k = new Application.ActivityLifecycleCallbacks()
/*     */               {
/*     */                 public final void onActivityStopped(Activity paramAnonymousActivity) {}
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
/*     */                 public final void onActivityStarted(Activity paramAnonymousActivity) {}
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
/*     */                 public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
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
/*     */                 public final void onActivityResumed(Activity paramAnonymousActivity)
/*     */                 {
/* 312 */                   String str = "unknown";
/* 313 */                   if (paramAnonymousActivity != null) {
/* 314 */                     str = paramAnonymousActivity.getClass().getName();
/*     */                   }
/* 316 */                   if ((b.b() != null) && 
/* 317 */                     (!b.b().getName().equals(str)))
/*     */                   {
/* 319 */                     return;
/*     */                   }
/*     */                   
/* 322 */                   x.c(">>> %s onResumed <<<", new Object[] { str });
/*     */                   
/* 324 */                   if ((paramAnonymousActivity = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
/* 325 */                     return;
/*     */                   }
/* 327 */                   paramAnonymousActivity.C.add(b.a(str, "onResumed"));
/*     */                   
/* 329 */                   paramAnonymousActivity.a(true);
/* 330 */                   paramAnonymousActivity.p = str;
/*     */                   
/* 332 */                   paramAnonymousActivity.q = System.currentTimeMillis();
/*     */                   
/* 334 */                   paramAnonymousActivity.t = (paramAnonymousActivity.q - b.c());
/*     */                   
/* 336 */                   long l1 = paramAnonymousActivity.q - b.d();
/*     */                   
/* 338 */                   long l2 = b.e() > 0L ? b.e() : b.f();
/*     */                   
/* 340 */                   if (l1 > l2)
/*     */                   {
/* 342 */                     paramAnonymousActivity.d();
/* 343 */                     b.g();
/* 344 */                     x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l1 / 1000L), Long.valueOf(b.f() / 1000L) });
/*     */                     
/*     */ 
/*     */ 
/* 348 */                     if (b.h() % b.i() == 0) {
/* 349 */                       b.a.a(4, b.j(), 0L);return;
/*     */                     }
/*     */                     
/* 352 */                     b.a.a(4, false, 0L);
/*     */                     long l3;
/* 354 */                     if ((l3 = System.currentTimeMillis()) - b.k() > b.l()) {
/* 355 */                       b.b(l3);
/* 356 */                       x.a("add a timer to upload hot start user info", new Object[0]);
/* 357 */                       if (b.j())
/*     */                       {
/* 359 */                         long l4 = b.l();paramAnonymousActivity = b.a;w.a().a(new a.a(paramAnonymousActivity, null, true), l4);
/*     */                       }
/*     */                     }
/*     */                   }
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */                 public final void onActivityPaused(Activity paramAnonymousActivity)
/*     */                 {
/* 369 */                   String str = "unknown";
/* 370 */                   if (paramAnonymousActivity != null) {
/* 371 */                     str = paramAnonymousActivity.getClass().getName();
/*     */                   }
/* 373 */                   if ((b.b() != null) && 
/* 374 */                     (!b.b().getName().equals(str)))
/*     */                   {
/* 376 */                     return;
/*     */                   }
/*     */                   
/* 379 */                   x.c(">>> %s onPaused <<<", new Object[] { str });
/*     */                   com.tencent.bugly.crashreport.common.info.a locala;
/* 381 */                   if ((locala = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
/* 382 */                     return;
/*     */                   }
/* 384 */                   locala.C.add(b.a(str, "onPaused"));
/*     */                   
/* 386 */                   locala.a(false);
/*     */                   
/* 388 */                   locala.r = System.currentTimeMillis();
/* 389 */                   locala.s = (locala.r - locala.q);
/*     */                   
/* 391 */                   b.c(locala.r);
/*     */                   
/* 393 */                   if (locala.s < 0L) {
/* 394 */                     locala.s = 0L;
/*     */                   }
/* 396 */                   if (paramAnonymousActivity != null) {
/* 397 */                     locala.p = "background";return;
/*     */                   }
/* 399 */                   locala.p = "unknown";
/*     */                 }
/*     */                 
/*     */ 
/*     */                 public final void onActivityDestroyed(Activity paramAnonymousActivity)
/*     */                 {
/* 405 */                   String str = "unknown";
/* 406 */                   if (paramAnonymousActivity != null) {
/* 407 */                     str = paramAnonymousActivity.getClass().getName();
/*     */                   }
/* 409 */                   if ((b.b() != null) && 
/* 410 */                     (!b.b().getName().equals(str)))
/*     */                   {
/* 412 */                     return;
/*     */                   }
/*     */                   
/* 415 */                   x.c(">>> %s onDestroyed <<<", new Object[] { str });
/*     */                   
/* 417 */                   if ((paramAnonymousActivity = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
/* 418 */                     paramAnonymousActivity.C.add(b.a(str, "onDestroyed"));
/*     */                   }
/*     */                 }
/*     */                 
/*     */ 
/*     */                 public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
/*     */                 {
/* 425 */                   paramAnonymousBundle = "unknown";
/* 426 */                   if (paramAnonymousActivity != null) {
/* 427 */                     paramAnonymousBundle = paramAnonymousActivity.getClass().getName();
/*     */                   }
/* 429 */                   if ((b.b() != null) && 
/* 430 */                     (!b.b().getName().equals(paramAnonymousBundle)))
/*     */                   {
/* 432 */                     return;
/*     */                   }
/*     */                   
/* 435 */                   x.c(">>> %s onCreated <<<", new Object[] { paramAnonymousBundle });
/*     */                   
/* 437 */                   if ((paramAnonymousActivity = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
/* 438 */                     paramAnonymousActivity.C.add(b.a(paramAnonymousBundle, "onCreated"));
/*     */                   }
/*     */                 }
/*     */               };
/* 166 */             ((Application)localObject1).registerActivityLifecycleCallbacks(k); } catch (Exception localException2) { Exception localException1; if (!x.a(localException1 = localException2)) localException1.printStackTrace();
/*     */           }
/*     */       } }
/* 169 */     if (m)
/*     */     {
/* 171 */       i = System.currentTimeMillis();a.a(1, false, 0L);x.a("[session] launch app, new start", new Object[0]);
/*     */       
/* 173 */       a.a();
/*     */       
/* 175 */       long l2 = 21600000L;paramBuglyStrategy = a;w.a().a(new a.c(paramBuglyStrategy, l2), l2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(Context paramContext, final BuglyStrategy paramBuglyStrategy)
/*     */   {
/* 186 */     if (b) {
/* 187 */       return;
/*     */     }
/*     */     
/* 190 */     m = com.tencent.bugly.crashreport.common.info.a.a(paramContext).e;
/*     */     
/* 192 */     a = new a(paramContext, m);
/*     */     
/* 194 */     b = true;
/*     */     
/* 196 */     long l1 = 0L;
/*     */     
/* 198 */     if (paramBuglyStrategy != null) {
/* 199 */       l = paramBuglyStrategy.getUserInfoActivity();
/* 200 */       l1 = paramBuglyStrategy.getAppReportDelay();
/*     */     }
/*     */     
/* 203 */     if (l1 <= 0L) {
/* 204 */       c(paramContext, paramBuglyStrategy);return;
/*     */     }
/* 206 */     w.a().a(new Runnable()
/*     */     {
/*     */ 
/*     */       public final void run() {
/* 210 */         b.b(this.a, paramBuglyStrategy); } }, l1);
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
/*     */   public static void a(long paramLong)
/*     */   {
/* 223 */     if (paramLong < 0L) {
/* 224 */       paramLong = com.tencent.bugly.crashreport.common.strategy.a.a().c().q;
/*     */     }
/* 226 */     f = paramLong;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(StrategyBean paramStrategyBean, boolean paramBoolean)
/*     */   {
/* 235 */     if ((a != null) && (!paramBoolean)) {
/* 236 */       paramBoolean = a; w localw; if ((localw = w.a()) != null) localw.a(new a.2(paramBoolean));
/*     */     }
/* 238 */     if (paramStrategyBean == null) {
/* 239 */       return;
/*     */     }
/* 241 */     if (paramStrategyBean.q > 0L) {
/* 242 */       e = paramStrategyBean.q;
/*     */     }
/* 244 */     if (paramStrategyBean.w > 0) {
/* 245 */       c = paramStrategyBean.w;
/*     */     }
/* 247 */     if (paramStrategyBean.x > 0L) {
/* 248 */       d = paramStrategyBean.x;
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
/*     */   public static void a()
/*     */   {
/* 264 */     if (a != null) {
/* 265 */       a.a(2, false, 0L);
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
/*     */   public static void a(Context paramContext)
/*     */   {
/* 482 */     if ((!b) || (paramContext == null)) {
/* 483 */       return;
/*     */     }
/* 485 */     paramContext = paramContext;Application localApplication = null; if (Build.VERSION.SDK_INT >= 14) { if ((paramContext.getApplicationContext() instanceof Application)) localApplication = (Application)paramContext.getApplicationContext(); if (localApplication != null) try { if (k != null) localApplication.unregisterActivityLifecycleCallbacks(k); } catch (Exception localException) { if (!x.a(paramContext = localException)) paramContext.printStackTrace(); } }
/* 486 */     b = false;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/biz/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */