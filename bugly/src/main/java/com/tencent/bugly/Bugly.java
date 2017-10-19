/*     */ package com.tencent.bugly;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.tencent.bugly.crashreport.common.info.a;
/*     */ import com.tencent.bugly.proguard.p;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Bugly
/*     */ {
/*     */   private static boolean a;
/*  32 */   public static boolean enable = true;
/*     */   public static Boolean isDev;
/*  34 */   public static Context applicationContext = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String SDK_IS_DEV = "false";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  45 */   private static String[] b = { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
/*  46 */   private static String[] c = { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void init(Context paramContext, String paramString, boolean paramBoolean)
/*     */   {
/*  59 */     init(paramContext, paramString, paramBoolean, null);
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
/*     */   public static synchronized void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
/*     */   {
/*  72 */     if (a) {
/*  73 */       return;
/*     */     }
/*  75 */     a = true;
/*     */     
/*  77 */     if ((applicationContext = z.a(paramContext)) == null) {
/*  78 */       Log.e(x.a, "init arg 'context' should not be null!");
/*  79 */       return;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (isDev()) {
/*  84 */       b = c;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  89 */     int i = (paramContext = b).length; for (int j = 0; j < i; j++) { Throwable localThrowable1 = paramContext[j];
/*     */       try {
/*  91 */         if (localThrowable1.equals("BuglyCrashModule")) {
/*  92 */           b.a(CrashModule.getInstance());
/*  93 */         } else if (!localThrowable1.equals("BuglyBetaModule"))
/*     */         {
/*  95 */           if (!localThrowable1.equals("BuglyRqdModule"))
/*     */           {
/*  97 */             localThrowable1.equals("BuglyFeedbackModule");
/*     */           }
/*     */         }
/*     */       } catch (Throwable localThrowable2) {
/* 101 */         x.b(localThrowable1 = 
/* 102 */           localThrowable2);
/*     */       } }
/* 104 */     b.a = enable;
/* 105 */     b.a(applicationContext, paramString, paramBoolean, paramBuglyStrategy);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static synchronized String getAppChannel()
/*     */   {
/*     */     a locala;
/*     */     
/*     */ 
/* 115 */     if ((locala = a.b()) == null) {
/* 116 */       return null;
/*     */     }
/*     */     
/* 119 */     if (TextUtils.isEmpty(locala.l)) {
/*     */       Object localObject;
/* 121 */       if ((localObject = p.a()) == null) {
/* 122 */         return locala.l;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       if ((localObject = ((p)localObject).a(556, null, true)) != null)
/*     */       {
/* 130 */         if ((localObject = (byte[])((Map)localObject).get("app_channel")) != null) {
/* 131 */           return new String((byte[])localObject);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 136 */     return locala.l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isDev()
/*     */   {
/* 145 */     if (isDev == null) {
/* 146 */       isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
/*     */     }
/* 148 */     return isDev.booleanValue();
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/Bugly.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */