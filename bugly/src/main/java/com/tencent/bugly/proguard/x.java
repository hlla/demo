/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.util.Log;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class x
/*     */ {
/*  14 */   private static String c = "CrashReportInfo";
/*  15 */   public static String a = "CrashReport";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  22 */   public static boolean b = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean a(int paramInt, String paramString, Object... paramVarArgs)
/*     */   {
/*  38 */     if (!b) {
/*  39 */       return false;
/*     */     }
/*  41 */     paramVarArgs = paramVarArgs;paramString = (paramVarArgs == null) || (paramVarArgs.length == 0) ? paramString : (paramString = paramString) == null ? "null" : String.format(Locale.US, paramString, paramVarArgs);
/*     */     
/*  43 */     switch (paramInt) {
/*     */     case 0: 
/*  45 */       Log.i(a, paramString);
/*  46 */       return true;
/*     */     case 5: 
/*  48 */       Log.i(c, paramString);
/*     */       
/*  50 */       return true;
/*     */     case 1: 
/*  52 */       Log.d(a, paramString);
/*  53 */       return true;
/*     */     case 2: 
/*  55 */       Log.w(a, paramString);
/*     */       
/*  57 */       return true;
/*     */     case 3: 
/*  59 */       Log.e(a, paramString);
/*     */       
/*  61 */       return true;
/*     */     }
/*     */     
/*     */     
/*  65 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a(String paramString, Object... paramVarArgs)
/*     */   {
/*  77 */     return a(0, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static boolean a(Class paramClass, String paramString, Object... paramVarArgs) {
/*  81 */     paramClass = String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString });
/*  82 */     return a(0, paramClass, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static boolean b(String paramString, Object... paramVarArgs) {
/*  86 */     return a(5, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static boolean c(String paramString, Object... paramVarArgs) {
/*  90 */     return a(1, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static boolean b(Class paramClass, String paramString, Object... paramVarArgs) {
/*  94 */     paramClass = String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString });
/*  95 */     return a(1, paramClass, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static boolean d(String paramString, Object... paramVarArgs) {
/*  99 */     return a(2, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a(Throwable paramThrowable)
/*     */   {
/* 108 */     Object localObject = paramThrowable;paramThrowable = 2; if (!b) return false; localObject = z.a((Throwable)localObject);return a(paramThrowable, (String)localObject, new Object[0]);
/*     */   }
/*     */   
/*     */   public static boolean e(String paramString, Object... paramVarArgs) {
/* 112 */     return a(3, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean b(Throwable paramThrowable)
/*     */   {
/* 121 */     Object localObject = paramThrowable;paramThrowable = 3; if (!b) return false; localObject = z.a((Throwable)localObject);return a(paramThrowable, (String)localObject, new Object[0]);
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/x.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */