/*     */ package com.tencent.bugly;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import com.tencent.bugly.crashreport.CrashReport;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier;
/*     */ import com.tencent.bugly.crashreport.crash.c;
/*     */ import com.tencent.bugly.crashreport.crash.d;
/*     */ import com.tencent.bugly.proguard.n;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrashModule
/*     */   extends a
/*     */ {
/*     */   public static final int MODULE_ID = 1004;
/*     */   private long a;
/*     */   private BuglyStrategy.a b;
/*  27 */   private static int c = 0;
/*  28 */   private static boolean d = false;
/*     */   
/*  30 */   private static CrashModule e = new CrashModule();
/*     */   
/*     */   public static CrashModule getInstance() {
/*  33 */     e.id = 1004;
/*  34 */     return e;
/*     */   }
/*     */   
/*     */   public static boolean hasInitialized() {
/*  38 */     return d;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
/*     */   {
/*  48 */     if ((paramContext == null) || (d)) {
/*  49 */       return;
/*     */     }
/*  51 */     x.a("Initializing crash module.", new Object[0]);
/*  52 */     n.a().a(1004, ++c);
/*  53 */     d = true;
/*  54 */     CrashReport.setContext(paramContext);
/*  55 */     a(paramContext, paramBuglyStrategy);
/*  56 */     c.a(1004, paramContext, paramBoolean, this.b, null, null);
/*  57 */     (
/*     */     
/*  59 */       paramBoolean = c.a()).e();
/*     */     
/*  61 */     if ((paramBuglyStrategy == null) || (paramBuglyStrategy.isEnableNativeCrashMonitor())) {
/*  62 */       paramBoolean.g();
/*     */     } else {
/*  64 */       x.a("[crash] Closed native crash monitor!", new Object[0]);
/*  65 */       paramBoolean.f();
/*     */     }
/*  67 */     if ((paramBuglyStrategy == null) || (paramBuglyStrategy.isEnableANRCrashMonitor())) {
/*  68 */       paramBoolean.h();
/*     */     } else {
/*  70 */       x.a("[crash] Closed ANR monitor!", new Object[0]);
/*  71 */       paramBoolean.i();
/*     */     }
/*     */     
/*     */ 
/*  75 */     d.a(paramContext);
/*     */     
/*     */ 
/*  78 */     (
/*  79 */       paramBoolean = BuglyBroadcastRecevier.getInstance()).addFilter("android.net.conn.CONNECTIVITY_CHANGE");
/*  80 */     paramBoolean.register(paramContext);
/*     */     
/*  82 */     n.a().a(1004, --c);
/*     */   }
/*     */   
/*     */   private synchronized void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
/*  86 */     if (paramBuglyStrategy == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     String str;
/*  91 */     if (!TextUtils.isEmpty(str = paramBuglyStrategy.getLibBuglySOFilePath())) {
/*  92 */       com.tencent.bugly.crashreport.common.info.a.a(paramContext).m = str;
/*  93 */       x.a("setted libBugly.so file path :%s", new Object[] { str });
/*     */     }
/*     */     
/*  96 */     if (paramBuglyStrategy.getCrashHandleCallback() != null) {
/*  97 */       this.b = paramBuglyStrategy.getCrashHandleCallback();
/*  98 */       x.a("setted CrashHanldeCallback", new Object[0]);
/*     */     }
/*     */     
/* 101 */     if (paramBuglyStrategy.getAppReportDelay() > 0L) {
/* 102 */       this.a = paramBuglyStrategy.getAppReportDelay();
/* 103 */       x.a("setted delay: %d", new Object[] { Long.valueOf(this.a) });
/*     */     }
/*     */   }
/*     */   
/*     */   public void onServerStrategyChanged(StrategyBean paramStrategyBean)
/*     */   {
/* 109 */     if (paramStrategyBean == null) {
/*     */       return;
/*     */     }
/*     */     c localc;
/* 113 */     if ((localc = c.a()) != null) {
/* 114 */       localc.a(paramStrategyBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String[] getTables()
/*     */   {
/* 122 */     return new String[] { "t_cr" };
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/CrashModule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */