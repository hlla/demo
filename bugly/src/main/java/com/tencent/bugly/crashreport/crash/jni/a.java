/*     */ package com.tencent.bugly.crashreport.crash.jni;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.tencent.bugly.crashreport.common.info.AppInfo;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.crashreport.crash.CrashDetailBean;
/*     */ import com.tencent.bugly.crashreport.crash.c;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.y;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   implements NativeExceptionHandler
/*     */ {
/*     */   private final Context a;
/*     */   private final com.tencent.bugly.crashreport.crash.b b;
/*     */   private final com.tencent.bugly.crashreport.common.info.a c;
/*     */   private final com.tencent.bugly.crashreport.common.strategy.a d;
/*     */   
/*     */   public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1)
/*     */   {
/*  48 */     this.a = paramContext;
/*  49 */     this.b = paramb;
/*  50 */     this.c = parama;
/*  51 */     this.d = parama1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean)
/*     */   {
/*     */     ;
/*     */     
/*     */ 
/*     */     boolean bool1;
/*     */     
/*     */ 
/*  64 */     if ((bool1 = c.a().l())) {
/*  65 */       x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
/*     */     }
/*     */     
/*     */     CrashDetailBean localCrashDetailBean;
/*     */     
/*  70 */     (localCrashDetailBean = new CrashDetailBean()).b = 1;
/*  71 */     localCrashDetailBean.e = this.c.h();
/*  72 */     localCrashDetailBean.f = this.c.j;
/*  73 */     localCrashDetailBean.g = this.c.w();
/*  74 */     localCrashDetailBean.m = this.c.g();
/*  75 */     localCrashDetailBean.n = paramString3;
/*  76 */     localCrashDetailBean.o = (bool1 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "");
/*     */     
/*     */ 
/*  79 */     localCrashDetailBean.p = paramString4;
/*  80 */     localCrashDetailBean.q = (paramString5 == null ? "" : paramString5);
/*  81 */     localCrashDetailBean.r = paramLong;
/*  82 */     localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
/*  83 */     localCrashDetailBean.z = paramString1;
/*  84 */     localCrashDetailBean.A = paramString2;
/*  85 */     localCrashDetailBean.H = this.c.y();
/*  86 */     localCrashDetailBean.h = this.c.v();
/*  87 */     localCrashDetailBean.i = this.c.I();
/*  88 */     localCrashDetailBean.v = paramString8;
/*  89 */     paramString2 = null;
/*     */     
/*  91 */     if ((paramLong = NativeCrashHandler.getInstance()) != null) {
/*  92 */       paramString2 = paramLong.getDumpFilePath();
/*     */     }
/*     */     
/*  95 */     if (!z.a(paramLong = b.a(paramString2, paramString8))) {
/*  96 */       localCrashDetailBean.T = paramLong;
/*     */     }
/*  98 */     localCrashDetailBean.U = b.b(paramString2);
/*  99 */     localCrashDetailBean.w = b.a(paramString9, c.e, null);
/*     */     
/* 101 */     localCrashDetailBean.I = paramString7;
/* 102 */     localCrashDetailBean.J = paramString6;
/* 103 */     localCrashDetailBean.K = paramString10;
/*     */     
/*     */ 
/* 106 */     localCrashDetailBean.E = this.c.p();
/* 107 */     localCrashDetailBean.F = this.c.o();
/* 108 */     localCrashDetailBean.G = this.c.q();
/* 109 */     if (paramBoolean)
/*     */     {
/* 111 */       localCrashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.g();
/* 112 */       localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.e();
/* 113 */       localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
/* 114 */       if (localCrashDetailBean.w == null) {
/* 115 */         localCrashDetailBean.w = z.a(this.a, c.e, null);
/*     */       }
/*     */       
/* 118 */       localCrashDetailBean.x = y.a();
/* 119 */       localCrashDetailBean.L = this.c.a;
/* 120 */       localCrashDetailBean.M = this.c.a();
/*     */       
/* 122 */       localCrashDetailBean.O = this.c.F();
/* 123 */       localCrashDetailBean.P = this.c.G();
/* 124 */       localCrashDetailBean.Q = this.c.z();
/* 125 */       localCrashDetailBean.R = this.c.E();
/* 126 */       localCrashDetailBean.y = z.a(c.f, false);
/*     */       
/* 128 */       paramString2 = "java:\n";
/*     */       
/* 130 */       if ((paramLong = localCrashDetailBean.q.indexOf(paramString2)) > 0)
/*     */       {
/* 132 */         if ((paramLong = paramLong + paramString2.length()) < localCrashDetailBean.q.length())
/*     */         {
/*     */ 
/*     */ 
/* 136 */           if (((paramString2 = localCrashDetailBean.q.substring(paramLong, localCrashDetailBean.q.length() - 1)).length() > 0) && (localCrashDetailBean.y.containsKey(localCrashDetailBean.A)))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */             if ((paramString2 = (??? = (String)localCrashDetailBean.y.get(localCrashDetailBean.A)).indexOf(paramString2)) > 0) {
/* 143 */               paramString2 = ???.substring(paramString2);
/*     */               
/* 145 */               localCrashDetailBean.y.put(localCrashDetailBean.A, paramString2);
/* 146 */               localCrashDetailBean.q = localCrashDetailBean.q.substring(0, paramLong);
/*     */               
/* 148 */               localCrashDetailBean.q += paramString2;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 153 */       if (paramString1 == null) {
/* 154 */         localCrashDetailBean.z = this.c.d;
/*     */       }
/*     */       
/* 157 */       this.b.c(localCrashDetailBean);
/*     */     }
/*     */     else {
/* 160 */       localCrashDetailBean.B = -1L;
/* 161 */       localCrashDetailBean.C = -1L;
/* 162 */       localCrashDetailBean.D = -1L;
/* 163 */       if (localCrashDetailBean.w == null) {
/* 164 */         localCrashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
/*     */       }
/*     */       
/* 167 */       localCrashDetailBean.L = -1L;
/* 168 */       localCrashDetailBean.O = -1;
/* 169 */       localCrashDetailBean.P = -1;
/* 170 */       localCrashDetailBean.Q = paramMap;
/*     */       
/* 172 */       localCrashDetailBean.R = this.c.E();
/* 173 */       localCrashDetailBean.y = null;
/* 174 */       if (paramString1 == null) {
/* 175 */         localCrashDetailBean.z = "unknown(record)";
/*     */       }
/* 177 */       if (paramArrayOfByte != null) {
/* 178 */         localCrashDetailBean.x = paramArrayOfByte;
/*     */       }
/*     */     }
/*     */     
/* 182 */     return localCrashDetailBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
/*     */   {
/* 190 */     x.a("Native Crash Happen v1", new Object[0]);
/* 191 */     handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
/*     */   {
/* 202 */     x.a("Native Crash Happen v2", new Object[0]);
/*     */     try
/*     */     {
/* 205 */       if (!this.d.b())
/*     */       {
/* 207 */         x.e("waiting for remote sync", new Object[0]);
/* 208 */         paramInt1 = 0;
/* 209 */         do { if (this.d.b()) break;
/* 210 */           z.b(500L);
/* 211 */           paramInt1 += 500;
/* 212 */         } while (paramInt1 < 3000); }
/* 213 */       paramInt1 = paramString1;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 220 */       paramInt2 = b.a(paramString3);
/*     */       
/* 222 */       paramString3 = "UNKNOWN";
/*     */       
/* 224 */       if (paramInt3 > 0)
/*     */       {
/* 226 */         paramInt1 = paramInt1 + "(" + paramString5 + ")";
/* 227 */         paramString1 = "KERNEL";
/*     */       }
/*     */       else {
/* 230 */         paramString1 = paramString5;
/* 231 */         if (paramInt4 > 0) {
/* 232 */           paramString3 = AppInfo.a(paramInt4);
/*     */         }
/* 234 */         if (!paramString3.equals(String.valueOf(paramInt4))) {
/* 235 */           paramString3 = paramString3 + "(" + paramInt4 + ")";
/*     */         }
/*     */       }
/*     */       
/* 239 */       if (!this.d.b()) {
/* 240 */         x.d("no remote but still store!", new Object[0]);
/*     */       }
/*     */       
/*     */ 
/* 244 */       if ((!(paramString5 = this.d.c()).g) && (this.d.b())) {
/* 245 */         x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
/*     */         
/* 247 */         com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", z.a(), this.c.d, Thread.currentThread(), paramInt1 + "\n" + paramString2 + "\n" + paramInt2, null);
/*     */         
/*     */ 
/* 250 */         z.b(paramString4);
/* 251 */         return;
/*     */       }
/*     */       
/* 254 */       paramString5 = new HashMap();
/* 255 */       Iterator localIterator; if (paramArrayOfString != null) {
/* 256 */         paramInt5 = (paramInt4 = paramArrayOfString).length; for (int i = 0; i < paramInt5; i++)
/*     */         {
/* 258 */           if ((paramInt6 = (localIterator = paramInt4[i]).split("=")).length == 2) {
/* 259 */             paramString5.put(paramInt6[0], paramInt6[1]);
/*     */           } else {
/* 261 */             x.d("bad extraMsg %s", new Object[] { localIterator });
/*     */           }
/*     */         }
/*     */       } else {
/* 265 */         x.c("not found extraMsg", new Object[0]);
/*     */       }
/*     */       
/*     */ 
/* 269 */       if (((paramInt4 = (String)paramString5.get("ExceptionProcessName")) == null) || (paramInt4.length() == 0)) {
/* 270 */         paramInt4 = this.c.d;
/*     */       } else {
/* 272 */         x.c("crash process name change to %s", new Object[] { paramInt4 });
/*     */       }
/*     */       
/*     */       Object localObject;
/* 276 */       if (((paramInt5 = (String)paramString5.get("ExceptionThreadName")) == null) || (paramInt5.length() == 0)) {
/* 277 */         localObject = Thread.currentThread();
/* 278 */         paramInt5 = ((Thread)localObject).getName() + "(" + ((Thread)localObject).getId() + ")";
/*     */       } else {
/* 280 */         x.c("crash thread name change to %s", new Object[] { paramInt5 });
/*     */         
/* 282 */         localIterator = (localObject = Thread.getAllStackTraces().keySet()).iterator();
/* 283 */         while (localIterator.hasNext())
/*     */         {
/* 285 */           if ((paramInt6 = (Thread)localIterator.next()).getName().equals(paramInt5)) {
/* 286 */             paramInt5 = paramInt5 + "(" + paramInt6.getId() + ")";
/* 287 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 292 */       long l = paramLong1 * 1000L + paramLong2 / 1000L;
/*     */       
/* 294 */       paramInt6 = (String)paramString5.get("SysLogPath");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 299 */       if ((paramLong1 = packageCrashDatas(paramInt4, paramInt5, l, paramInt1, paramString2, paramInt2, paramString1, paramString3, paramString4, paramInt6, paramString7, null, null, true)) == null) {
/* 300 */         x.e("pkg crash datas fail!", new Object[0]);
/* 301 */         return;
/*     */       }
/*     */       
/* 304 */       com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", z.a(), this.c.d, Thread.currentThread(), paramInt1 + "\n" + paramString2 + "\n" + paramInt2, paramLong1);
/*     */       
/*     */ 
/* 307 */       if (!this.b.a(paramLong1, paramInt3)) {
/* 308 */         this.b.a(paramLong1, 3000L, true);
/*     */       }
/* 310 */       this.b.b(paramLong1);
/*     */       
/* 312 */       paramInt1 = null;
/*     */       
/* 314 */       if ((paramInt2 = NativeCrashHandler.getInstance()) != null) {
/* 315 */         paramInt1 = paramInt2.getDumpFilePath();
/*     */       }
/* 317 */       b.a(true, paramInt1); return;
/*     */     } catch (Throwable localThrowable) {
/* 319 */       if (!x.a(paramInt1 = 
/*     */       
/*     */ 
/* 322 */         localThrowable)) {
/* 320 */         paramInt1.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/jni/a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */