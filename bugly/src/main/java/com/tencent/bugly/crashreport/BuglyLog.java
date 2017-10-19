/*     */ package com.tencent.bugly.crashreport;
/*     */ 
/*     */ import android.util.Log;
/*     */ import com.tencent.bugly.b;
/*     */ import com.tencent.bugly.proguard.y;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BuglyLog
/*     */ {
/*     */   public static void v(String paramString1, String paramString2)
/*     */   {
/*  21 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  22 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  23 */     if (b.c) {
/*  24 */       Log.v(paramString1, paramString2);
/*     */     }
/*  26 */     y.a("V", paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void d(String paramString1, String paramString2)
/*     */   {
/*  36 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  37 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  38 */     if (b.c) {
/*  39 */       Log.d(paramString1, paramString2);
/*     */     }
/*  41 */     y.a("D", paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void i(String paramString1, String paramString2)
/*     */   {
/*  51 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  52 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  53 */     if (b.c) {
/*  54 */       Log.i(paramString1, paramString2);
/*     */     }
/*  56 */     y.a("I", paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void w(String paramString1, String paramString2)
/*     */   {
/*  66 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  67 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  68 */     if (b.c) {
/*  69 */       Log.w(paramString1, paramString2);
/*     */     }
/*  71 */     y.a("W", paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void e(String paramString1, String paramString2)
/*     */   {
/*  81 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  82 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  83 */     if (b.c) {
/*  84 */       Log.e(paramString1, paramString2);
/*     */     }
/*  86 */     y.a("E", paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void e(String paramString1, String paramString2, Throwable paramThrowable)
/*     */   {
/*  96 */     paramString1 = paramString1 == null ? "" : paramString1;
/*  97 */     paramString2 = paramString2 == null ? "null" : paramString2;
/*  98 */     if (b.c) {
/*  99 */       Log.e(paramString1, paramString2, paramThrowable);
/*     */     }
/* 101 */     y.a("E", paramString1, paramThrowable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setCache(int paramInt)
/*     */   {
/* 110 */     y.a(paramInt);
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/BuglyLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */