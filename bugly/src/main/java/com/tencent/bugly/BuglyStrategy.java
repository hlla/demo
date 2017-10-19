/*     */ package com.tencent.bugly;
/*     */ 
/*     */ import com.tencent.bugly.crashreport.common.info.a;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BuglyStrategy
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private String c;
/*     */   private long d;
/*     */   private String e;
/*     */   private String f;
/*     */   private boolean g;
/*     */   
/*     */   public BuglyStrategy()
/*     */   {
/*  20 */     this.g = true;
/*  21 */     this.h = true;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  26 */     this.i = true;
/*  27 */     this.j = null;
/*  28 */     this.k = true;
/*  29 */     this.l = true;
/*  30 */     this.m = true;
/*  31 */     this.n = false; }
/*     */   
/*     */   private boolean h;
/*     */   private boolean i;
/*     */   private Class<?> j;
/*     */   private boolean k;
/*     */   private boolean l;
/*     */   private boolean m;
/*     */   private boolean n;
/*     */   private a o;
/*  41 */   public synchronized BuglyStrategy setBuglyLogUpload(boolean paramBoolean) { this.k = paramBoolean;
/*  42 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
/*     */   {
/*  52 */     this.n = paramBoolean;
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public synchronized BuglyStrategy setUploadProcess(boolean paramBoolean) {
/*  57 */     this.m = paramBoolean;
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public synchronized boolean isUploadProcess() {
/*  62 */     return this.m;
/*     */   }
/*     */   
/*     */   public synchronized boolean isBuglyLogUpload() {
/*  66 */     return this.k;
/*     */   }
/*     */   
/*     */   public synchronized boolean recordUserInfoOnceADay() {
/*  70 */     return this.n;
/*     */   }
/*     */   
/*     */   public boolean isReplaceOldChannel() {
/*  74 */     return this.l;
/*     */   }
/*     */   
/*     */   public void setReplaceOldChannel(boolean paramBoolean) {
/*  78 */     this.l = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getAppVersion()
/*     */   {
/*  87 */     if (this.a == null) return a.b().j; return this.a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setAppVersion(String paramString)
/*     */   {
/*  97 */     this.a = paramString;
/*  98 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setUserInfoActivity(Class<?> paramClass)
/*     */   {
/* 108 */     this.j = paramClass;
/* 109 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized Class<?> getUserInfoActivity()
/*     */   {
/* 118 */     return this.j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getAppChannel()
/*     */   {
/* 127 */     if (this.b == null) return a.b().l; return this.b;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setAppChannel(String paramString)
/*     */   {
/* 137 */     this.b = paramString;
/* 138 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getAppPackageName()
/*     */   {
/* 147 */     if (this.c == null) return a.b().c; return this.c;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setAppPackageName(String paramString)
/*     */   {
/* 157 */     this.c = paramString;
/* 158 */     return this;
/*     */   }
/*     */   
/*     */   public synchronized long getAppReportDelay()
/*     */   {
/* 163 */     return this.d;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setAppReportDelay(long paramLong)
/*     */   {
/* 173 */     this.d = paramLong;
/* 174 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getLibBuglySOFilePath()
/*     */   {
/* 183 */     return this.e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setLibBuglySOFilePath(String paramString)
/*     */   {
/* 193 */     this.e = paramString;
/* 194 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getDeviceID()
/*     */   {
/* 203 */     return this.f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setDeviceID(String paramString)
/*     */   {
/* 213 */     this.f = paramString;
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isEnableNativeCrashMonitor()
/*     */   {
/* 223 */     return this.g;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
/*     */   {
/* 233 */     this.g = paramBoolean;
/* 234 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setEnableUserInfo(boolean paramBoolean)
/*     */   {
/* 244 */     this.i = paramBoolean;
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isEnableUserInfo()
/*     */   {
/* 254 */     return this.i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isEnableANRCrashMonitor()
/*     */   {
/* 263 */     return this.h;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
/*     */   {
/* 270 */     this.h = paramBoolean;
/* 271 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized a getCrashHandleCallback()
/*     */   {
/* 280 */     return this.o;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized BuglyStrategy setCrashHandleCallback(a parama)
/*     */   {
/* 290 */     this.o = parama;
/* 291 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class a
/*     */   {
/*     */     public static final int MAX_USERDATA_KEY_LENGTH = 100;
/*     */     
/*     */ 
/*     */     public static final int MAX_USERDATA_VALUE_LENGTH = 30000;
/*     */     
/*     */ 
/*     */     public static final int CRASHTYPE_JAVA_CRASH = 0;
/*     */     
/*     */     public static final int CRASHTYPE_JAVA_CATCH = 1;
/*     */     
/*     */     public static final int CRASHTYPE_NATIVE = 2;
/*     */     
/*     */     public static final int CRASHTYPE_U3D = 3;
/*     */     
/*     */     public static final int CRASHTYPE_ANR = 4;
/*     */     
/*     */     public static final int CRASHTYPE_COCOS2DX_JS = 5;
/*     */     
/*     */     public static final int CRASHTYPE_COCOS2DX_LUA = 6;
/*     */     
/*     */     public static final int CRASHTYPE_BLOCK = 7;
/*     */     
/*     */ 
/*     */     public synchronized Map<String, String> onCrashHandleStart(int paramInt, String paramString1, String paramString2, String paramString3)
/*     */     {
/* 323 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public synchronized byte[] onCrashHandleStart2GetExtraDatas(int paramInt, String paramString1, String paramString2, String paramString3)
/*     */     {
/* 337 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/BuglyStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */