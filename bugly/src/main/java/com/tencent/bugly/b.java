/*     */ package com.tencent.bugly;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.tencent.bugly.proguard.n;
/*     */ import com.tencent.bugly.proguard.p;
/*     */ import com.tencent.bugly.proguard.u;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.y;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*  32 */   public static boolean a = true;
/*  33 */   public static List<a> b = new ArrayList();
/*     */   
/*     */ 
/*     */   public static boolean c;
/*     */   
/*     */ 
/*     */   private static p d;
/*     */   
/*     */ 
/*     */   private static boolean e;
/*     */   
/*     */ 
/*     */   private static boolean a(com.tencent.bugly.crashreport.common.info.a parama)
/*     */   {
/*  47 */     List localList = parama.o;
/*  48 */     parama.getClass();parama.getClass();parama = 1 != 0 ? "bugly" : "";
/*  49 */     if ((localList != null) && (localList.contains(parama))) {
/*  50 */       return true;
/*     */     }
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   public static synchronized void a(Context paramContext) {
/*  56 */     a(paramContext, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
/*     */   {
/*  66 */     if (e) {
/*  67 */       x.d("[init] initial Multi-times, ignore this.", new Object[0]);
/*  68 */       return;
/*     */     }
/*  70 */     if (paramContext == null) {
/*  71 */       Log.w(x.a, "[init] context of init() is null, check it."); return;
/*     */     }
/*     */     
/*     */ 
/*     */     com.tencent.bugly.crashreport.common.info.a locala;
/*     */     
/*  77 */     if (a(locala = com.tencent.bugly.crashreport.common.info.a.a(paramContext))) {
/*  78 */       a = false; return;
/*     */     }
/*     */     
/*     */ 
/*     */     String str;
/*     */     
/*  84 */     if ((str = locala.f()) == null) {
/*  85 */       Log.e(x.a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
/*     */       
/*  87 */       return;
/*     */     }
/*  89 */     a(paramContext, str, locala.u, paramBuglyStrategy);
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
/*     */   public static synchronized void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
/*     */   {
/* 102 */     if (e) {
/* 103 */       x.d("[init] initial Multi-times, ignore this.", new Object[0]);
/* 104 */       return;
/*     */     }
/* 106 */     if (paramContext == null) {
/* 107 */       Log.w(x.a, "[init] context is null, check it.");
/* 108 */       return;
/*     */     }
/*     */     
/* 111 */     if (paramString == null) {
/* 112 */       Log.e(x.a, "init arg 'crashReportAppID' should not be null!");
/* 113 */       return;
/*     */     }
/* 115 */     e = true;
/* 116 */     if (paramBoolean)
/*     */     {
/* 118 */       c = true;
/* 119 */       x.b = true;
/* 120 */       x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
/*     */       
/* 122 */       x.e("--------------------------------------------------------------------------------------------", new Object[0]);
/*     */       
/* 124 */       x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
/*     */       
/* 126 */       x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
/*     */       
/* 128 */       x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
/*     */       
/* 130 */       x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
/* 131 */       x.e("--------------------------------------------------------------------------------------------", new Object[0]);
/*     */       
/* 133 */       x.b("[init] Open debug mode of Bugly.", new Object[0]);
/*     */     }
/*     */     
/* 136 */     x.a("[init] Bugly version: v%s", new Object[] { "2.6.5" });
/* 137 */     x.a(" crash report start initializing...", new Object[0]);
/* 138 */     x.b("[init] Bugly start initializing...", new Object[0]);
/* 139 */     x.a("[init] Bugly complete version: v%s", new Object[] { "2.6.5" });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 144 */     (
/*     */     
/* 146 */       locala = com.tencent.bugly.crashreport.common.info.a.a(paramContext = z.a(paramContext))).t();
/* 147 */     y.a(paramContext);
/* 148 */     d = p.a(paramContext, b);
/* 149 */     u.a(paramContext);
/* 150 */     com.tencent.bugly.crashreport.common.strategy.a locala1 = com.tencent.bugly.crashreport.common.strategy.a.a(paramContext, b);
/* 151 */     n localn = n.a(paramContext);
/*     */     
/*     */ 
/* 154 */     if (a(locala)) {
/* 155 */       a = false;
/* 156 */       return;
/*     */     }
/*     */     
/* 159 */     locala.a(paramString);
/* 160 */     x.a("[param] Set APP ID:%s", new Object[] { paramString });
/*     */     
/* 162 */     com.tencent.bugly.crashreport.common.info.a locala = locala; if ((paramString = paramBuglyStrategy) != null) { Object localObject1; Object localObject2; if (!TextUtils.isEmpty(localObject1 = paramString.getAppVersion())) { if (((String)localObject1).length() > 100) { localObject2 = ((String)localObject1).substring(0, 100);x.d("appVersion %s length is over limit %d substring to %s", new Object[] { localObject1, Integer.valueOf(100), localObject2 });localObject1 = localObject2; } locala.j = ((String)localObject1);x.a("[param] Set App version: %s", new Object[] { paramString.getAppVersion() }); } try { if (paramString.isReplaceOldChannel()) { if (!TextUtils.isEmpty(localObject2 = paramString.getAppChannel())) { if (((String)localObject2).length() > 100) { localObject1 = ((String)localObject2).substring(0, 100);x.d("appChannel %s length is over limit %d substring to %s", new Object[] { localObject2, Integer.valueOf(100), localObject1 });localObject2 = localObject1; } d.a(556, "app_channel", ((String)localObject2).getBytes(), null, false);locala.l = ((String)localObject2); } } else if (((localObject2 = d.a(556, null, true)) != null) && ((localObject1 = (byte[])((Map)localObject2).get("app_channel")) != null)) locala.l = new String((byte[])localObject1); x.a("[param] Set App channel: %s", new Object[] { locala.l }); } catch (Exception localException) { if (c) localException.printStackTrace(); } Object localObject3; if (!TextUtils.isEmpty(localObject3 = paramString.getAppPackageName())) { if (((String)localObject3).length() > 100) { localObject1 = ((String)localObject3).substring(0, 100);x.d("appPackageName %s length is over limit %d substring to %s", new Object[] { localObject3, Integer.valueOf(100), localObject1 });localObject3 = localObject1; } locala.c = ((String)localObject3);x.a("[param] Set App package: %s", new Object[] { paramString.getAppPackageName() }); } if ((localObject1 = paramString.getDeviceID()) != null) { if (((String)localObject1).length() > 100) { localObject3 = ((String)localObject1).substring(0, 100);x.d("deviceId %s length is over limit %d substring to %s", new Object[] { localObject1, Integer.valueOf(100), localObject3 });localObject1 = localObject3; } locala.c((String)localObject1);x.a("s[param] Set device ID: %s", new Object[] { localObject1 }); } locala.e = paramString.isUploadProcess(); boolean bool; y.a = bool = paramString.isBuglyLogUpload();
/*     */     }
/* 164 */     com.tencent.bugly.crashreport.biz.b.a(paramContext, paramBuglyStrategy);
/*     */     
/*     */ 
/* 167 */     for (int i = 0; i < b.size(); i++) {
/*     */       try {
/* 169 */         if (localn.a(((a)b.get(i)).id))
/* 170 */           ((a)b.get(i)).init(paramContext, paramBoolean, paramBuglyStrategy);
/*     */       } catch (Throwable localThrowable2) {
/*     */         Throwable localThrowable1;
/* 173 */         if (!x.a(localThrowable1 = 
/*     */         
/*     */ 
/* 176 */           localThrowable2)) {
/* 174 */           localThrowable1.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 180 */     long l = paramBuglyStrategy != null ? paramBuglyStrategy.getAppReportDelay() : 0L;
/* 181 */     locala1.a(l);
/*     */     
/* 183 */     x.b("[init] Bugly initialization finished.", new Object[0]);
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
/*     */   public static synchronized void a(a parama)
/*     */   {
/* 280 */     if (!b.contains(parama)) {
/* 281 */       b.add(parama);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */