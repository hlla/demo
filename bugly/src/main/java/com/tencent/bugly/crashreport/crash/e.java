/*     */ package com.tencent.bugly.crashreport.crash;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Process;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.y;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.HashMap;
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
/*     */ public final class e
/*     */   implements Thread.UncaughtExceptionHandler
/*     */ {
/*     */   private Context a;
/*     */   private b b;
/*     */   private com.tencent.bugly.crashreport.common.strategy.a c;
/*     */   private com.tencent.bugly.crashreport.common.info.a d;
/*     */   private Thread.UncaughtExceptionHandler e;
/*     */   private Thread.UncaughtExceptionHandler f;
/*  34 */   private boolean g = false;
/*     */   
/*  36 */   private static String h = null;
/*  37 */   private static final Object i = new Object();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int j;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public e(Context paramContext, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1)
/*     */   {
/*  49 */     this.a = paramContext;
/*  50 */     this.b = paramb;
/*  51 */     this.c = parama;
/*  52 */     this.d = parama1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final synchronized void a()
/*     */   {
/*  59 */     if (this.j >= 10) {
/*  60 */       x.a("java crash handler over %d, no need set.", new Object[] { Integer.valueOf(10) }); return;
/*     */     }
/*     */     
/*     */     Thread.UncaughtExceptionHandler localUncaughtExceptionHandler;
/*     */     
/*  65 */     if ((localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
/*  66 */       String str1 = getClass().getName();
/*  67 */       String str2 = localUncaughtExceptionHandler.getClass().getName();
/*  68 */       if (str1.equals(str2)) {
/*  69 */         return;
/*     */       }
/*  71 */       if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(localUncaughtExceptionHandler.getClass().getName())) {
/*  72 */         x.a("backup system java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
/*  73 */         this.f = localUncaughtExceptionHandler;
/*  74 */         this.e = localUncaughtExceptionHandler;
/*     */       } else {
/*  76 */         x.a("backup java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
/*  77 */         this.e = localUncaughtExceptionHandler;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */     Thread.setDefaultUncaughtExceptionHandler(this);
/*  86 */     this.g = true;
/*  87 */     this.j += 1;
/*  88 */     x.a("registered java monitor: %s", new Object[] { toString() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final synchronized void b()
/*     */   {
/*  95 */     this.g = false;
/*  96 */     x.a("close java monitor!", new Object[0]);
/*     */     Thread.UncaughtExceptionHandler localUncaughtExceptionHandler;
/*  98 */     if ((localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()).getClass().getName().contains("bugly")) {
/*  99 */       x.a("Java monitor to unregister: %s", new Object[] { toString() });
/* 100 */       Thread.setDefaultUncaughtExceptionHandler(this.e);
/* 101 */       this.j -= 1;
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
/*     */   private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
/*     */   {
/* 140 */     if (paramThrowable == null) {
/* 141 */       x.d("We can do nothing with a null throwable.", new Object[0]);
/* 142 */       return null;
/*     */     }
/*     */     
/*     */     boolean bool;
/* 146 */     Object localObject = ((bool = c.a().l())) && (paramBoolean) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
/*     */     
/*     */ 
/* 149 */     if ((bool) && (paramBoolean)) {
/* 150 */       x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
/*     */     }
/*     */     
/*     */     CrashDetailBean localCrashDetailBean;
/*     */     
/* 155 */     (localCrashDetailBean = new CrashDetailBean()).B = com.tencent.bugly.crashreport.common.info.b.g();
/* 156 */     localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.e();
/* 157 */     localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
/* 158 */     localCrashDetailBean.E = this.d.p();
/* 159 */     localCrashDetailBean.F = this.d.o();
/* 160 */     localCrashDetailBean.G = this.d.q();
/* 161 */     localCrashDetailBean.w = z.a(this.a, c.e, null);
/*     */     
/* 163 */     localCrashDetailBean.x = y.a();
/* 164 */     x.a("user log size:%d", new Object[] { Integer.valueOf(localCrashDetailBean.x == null ? 0 : localCrashDetailBean.x.length) });
/* 165 */     localCrashDetailBean.b = (paramBoolean ? 0 : 2);
/*     */     
/* 167 */     localCrashDetailBean.e = this.d.h();
/* 168 */     localCrashDetailBean.f = this.d.j;
/* 169 */     localCrashDetailBean.g = this.d.w();
/* 170 */     localCrashDetailBean.m = this.d.g();
/*     */     
/* 172 */     String str1 = paramThrowable.getClass().getName();
/*     */     String str2;
/* 174 */     if ((str2 = b(paramThrowable, 1000)) == null) {
/* 175 */       str2 = "";
/*     */     }
/*     */     
/* 178 */     x.e("stack frame :%d, has cause %b", new Object[] { Integer.valueOf(paramThrowable.getStackTrace().length), Boolean.valueOf(paramThrowable.getCause() != null ? 1 : false) });
/*     */     
/* 180 */     String str3 = "";
/* 181 */     if (paramThrowable.getStackTrace().length > 0) {
/* 182 */       str3 = paramThrowable.getStackTrace()[0].toString();
/*     */     }
/*     */     
/* 185 */     Throwable localThrowable2 = paramThrowable;
/*     */     
/* 187 */     while ((localThrowable2 != null) && (localThrowable2.getCause() != null)) {
/* 188 */       localThrowable2 = localThrowable2.getCause();
/*     */     }
/* 190 */     if ((localThrowable2 != null) && (localThrowable2 != paramThrowable))
/*     */     {
/* 192 */       localCrashDetailBean.n = localThrowable2.getClass().getName();
/* 193 */       localCrashDetailBean.o = b(localThrowable2, 1000);
/* 194 */       if (localCrashDetailBean.o == null) {
/* 195 */         localCrashDetailBean.o = "";
/*     */       }
/* 197 */       if (localThrowable2.getStackTrace().length > 0) {
/* 198 */         localCrashDetailBean.p = localThrowable2.getStackTrace()[0].toString();
/*     */       }
/*     */       
/*     */ 
/* 202 */       (localObject = new StringBuilder()).append(str1).append(":").append(str2).append("\n");
/* 203 */       ((StringBuilder)localObject).append(str3);
/* 204 */       ((StringBuilder)localObject).append("\n......");
/* 205 */       ((StringBuilder)localObject).append("\nCaused by:\n");
/* 206 */       ((StringBuilder)localObject).append(localCrashDetailBean.n).append(":").append(localCrashDetailBean.o).append("\n");
/*     */       
/* 208 */       paramThrowable = a(localThrowable2, c.f);
/* 209 */       ((StringBuilder)localObject).append(paramThrowable);
/* 210 */       localCrashDetailBean.q = ((StringBuilder)localObject).toString();
/*     */     }
/*     */     else {
/* 213 */       localCrashDetailBean.n = str1;
/* 214 */       localCrashDetailBean.o = (str2 + (String)localObject);
/* 215 */       if (localCrashDetailBean.o == null) {
/* 216 */         localCrashDetailBean.o = "";
/*     */       }
/* 218 */       localCrashDetailBean.p = str3;
/* 219 */       paramThrowable = a(paramThrowable, c.f);
/* 220 */       localCrashDetailBean.q = paramThrowable;
/*     */     }
/*     */     
/* 223 */     localCrashDetailBean.r = System.currentTimeMillis();
/*     */     
/* 225 */     localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
/*     */     try {
/* 227 */       localCrashDetailBean.y = z.a(c.f, false);
/*     */       
/* 229 */       localCrashDetailBean.z = this.d.d;
/* 230 */       localCrashDetailBean.A = (paramThread.getName() + "(" + paramThread.getId() + ")");
/* 231 */       localCrashDetailBean.y.put(localCrashDetailBean.A, paramThrowable);
/* 232 */       localCrashDetailBean.H = this.d.y();
/* 233 */       localCrashDetailBean.h = this.d.v();
/* 234 */       localCrashDetailBean.i = this.d.I();
/* 235 */       localCrashDetailBean.L = this.d.a;
/* 236 */       localCrashDetailBean.M = this.d.a();
/*     */       
/*     */ 
/* 239 */       localCrashDetailBean.O = this.d.F();
/* 240 */       localCrashDetailBean.P = this.d.G();
/* 241 */       localCrashDetailBean.Q = this.d.z();
/* 242 */       localCrashDetailBean.R = this.d.E();
/*     */     }
/*     */     catch (Throwable localThrowable1) {
/* 245 */       x.e("handle crash error %s", new Object[] { localThrowable1.toString() });
/*     */     }
/* 247 */     if (paramBoolean) {
/* 248 */       this.b.c(localCrashDetailBean);
/*     */     } else {
/* 250 */       int k = (paramString != null) && (paramString.length() > 0) ? 1 : 0;
/* 251 */       paramThread = (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) ? 1 : 0;
/* 252 */       if (k != 0) {
/* 253 */         localCrashDetailBean.N = new HashMap(1);
/* 254 */         localCrashDetailBean.N.put("UserData", paramString);
/*     */       }
/* 256 */       if (paramThread != 0) {
/* 257 */         localCrashDetailBean.S = paramArrayOfByte;
/*     */       }
/*     */     }
/*     */     
/* 261 */     return localCrashDetailBean;
/*     */   }
/*     */   
/*     */   private static boolean a(Thread paramThread) {
/* 265 */     synchronized (i)
/*     */     {
/*     */ 
/* 268 */       if ((h == null) || (!paramThread.getName().equals(h))) {
/* 269 */         h = paramThread.getName();
/* 270 */         return false;
/*     */       }
/* 272 */       return true;
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
/*     */   public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
/*     */   {
/* 286 */     if (paramBoolean) {
/* 287 */       x.e("Java Crash Happen cause by %s(%d)", new Object[] { paramThread.getName(), Long.valueOf(paramThread.getId()) });
/* 288 */       if (a(paramThread)) {
/* 289 */         x.a("this class has handled this exception", new Object[0]);
/*     */         
/* 291 */         if (this.f != null) {
/* 292 */           x.a("call system handler", new Object[0]);
/* 293 */           this.f.uncaughtException(paramThread, paramThrowable);
/*     */         } else {
/* 295 */           x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/*     */         }
/*     */       }
/*     */     } else {
/* 299 */       x.e("Java Catch Happen", new Object[0]);
/*     */     }
/*     */     try {
/* 302 */       if (!this.g) {
/* 303 */         x.c("Java crash handler is disable. Just return.", new Object[0]);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */         if (paramBoolean) {
/* 352 */           if ((this.e != null) && (a(this.e))) {
/* 353 */             x.e("sys default last handle start!", new Object[0]);
/* 354 */             this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */             x.e("sys default last handle end!", new Object[0]); return; }
/* 356 */           if (this.f != null) {
/* 357 */             x.e("system handle start!", new Object[0]);
/* 358 */             this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */             x.e("system handle end!", new Object[0]); return;
/*     */           }
/* 361 */           x.e("crashreport last handle start!", new Object[0]);
/* 362 */           x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */           x.e("crashreport last handle end!", new Object[0]);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 307 */         if (!this.c.b())
/*     */         {
/* 309 */           x.e("waiting for remote sync", new Object[0]);
/* 310 */           int k = 0;
/* 311 */           do { if (this.c.b()) break;
/* 312 */             z.b(500L);
/* 313 */             k += 500;
/* 314 */           } while (k < 3000); }
/* 315 */         if (!this.c.b())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 321 */           x.d("no remote but still store!", new Object[0]);
/*     */         }
/*     */         
/*     */ 
/* 325 */         if ((!(localObject = this.c.c()).g) && (this.c.b())) {
/* 326 */           x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
/*     */           
/* 328 */           b.a(paramBoolean ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, paramThread, z.a(paramThrowable), null);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */           if (paramBoolean) {
/* 352 */             if ((this.e != null) && (a(this.e))) {
/* 353 */               x.e("sys default last handle start!", new Object[0]);
/* 354 */               this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */               x.e("sys default last handle end!", new Object[0]); return; }
/* 356 */             if (this.f != null) {
/* 357 */               x.e("system handle start!", new Object[0]);
/* 358 */               this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */               x.e("system handle end!", new Object[0]); return;
/*     */             }
/* 361 */             x.e("crashreport last handle start!", new Object[0]);
/* 362 */             x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */             x.e("crashreport last handle end!", new Object[0]);
/*     */           }
/*     */         }
/* 335 */         else if ((paramString = b(paramThread, paramThrowable, paramBoolean, paramString, paramArrayOfByte)) == null) {
/* 336 */           x.e("pkg crash datas fail!", new Object[0]);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */           if (paramBoolean) {
/* 352 */             if ((this.e != null) && (a(this.e))) {
/* 353 */               x.e("sys default last handle start!", new Object[0]);
/* 354 */               this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */               x.e("sys default last handle end!", new Object[0]); return; }
/* 356 */             if (this.f != null) {
/* 357 */               x.e("system handle start!", new Object[0]);
/* 358 */               this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */               x.e("system handle end!", new Object[0]); return;
/*     */             }
/* 361 */             x.e("crashreport last handle start!", new Object[0]);
/* 362 */             x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */             x.e("crashreport last handle end!", new Object[0]);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 340 */           b.a(paramBoolean ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, paramThread, z.a(paramThrowable), paramString);
/*     */           
/* 342 */           if (!this.b.a(paramString)) {
/* 343 */             this.b.a(paramString, 3000L, paramBoolean);
/*     */           }
/* 345 */           this.b.b(paramString);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */           if (paramBoolean) {
/* 352 */             if ((this.e != null) && (a(this.e))) {
/* 353 */               x.e("sys default last handle start!", new Object[0]);
/* 354 */               this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */               x.e("sys default last handle end!", new Object[0]);
/* 356 */             } else if (this.f != null) {
/* 357 */               x.e("system handle start!", new Object[0]);
/* 358 */               this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */               x.e("system handle end!", new Object[0]);
/*     */             } else {
/* 361 */               x.e("crashreport last handle start!", new Object[0]);
/* 362 */               x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */               x.e("crashreport last handle end!", new Object[0]);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/*     */       Object localObject;
/* 348 */       ((Throwable)localObject).printStackTrace();
/*     */       
/*     */ 
/* 351 */       if (paramBoolean) {
/* 352 */         if ((this.e != null) && (a(this.e))) {
/* 353 */           x.e("sys default last handle start!", new Object[0]);
/* 354 */           this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */           x.e("sys default last handle end!", new Object[0]);
/* 356 */         } else if (this.f != null) {
/* 357 */           x.e("system handle start!", new Object[0]);
/* 358 */           this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */           x.e("system handle end!", new Object[0]);
/*     */         } else {
/* 361 */           x.e("crashreport last handle start!", new Object[0]);
/* 362 */           x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */           x.e("crashreport last handle end!", new Object[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 351 */       if (paramBoolean) {
/* 352 */         if ((this.e != null) && (a(this.e))) {
/* 353 */           x.e("sys default last handle start!", new Object[0]);
/* 354 */           this.e.uncaughtException(paramThread, paramThrowable);
/* 355 */           x.e("sys default last handle end!", new Object[0]);
/* 356 */         } else if (this.f != null) {
/* 357 */           x.e("system handle start!", new Object[0]);
/* 358 */           this.f.uncaughtException(paramThread, paramThrowable);
/* 359 */           x.e("system handle end!", new Object[0]);
/*     */         } else {
/* 361 */           x.e("crashreport last handle start!", new Object[0]);
/* 362 */           x.e("current process die", new Object[0]);Process.killProcess(Process.myPid());System.exit(1);
/* 363 */           x.e("crashreport last handle end!", new Object[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
/*     */   {
/* 371 */     synchronized (i) {
/* 372 */       a(paramThread, paramThrowable, true, null, null);
/* 373 */       return;
/*     */     }
/*     */   }
/*     */   
/* 377 */   private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) { if (paramUncaughtExceptionHandler == null) {
/* 378 */       return true;
/*     */     }
/* 380 */     paramUncaughtExceptionHandler = paramUncaughtExceptionHandler.getClass().getName();
/* 381 */     String str1 = "uncaughtException";
/*     */     StackTraceElement[] arrayOfStackTraceElement;
/* 383 */     int k = (arrayOfStackTraceElement = arrayOfStackTraceElement = Thread.currentThread().getStackTrace()).length; for (int m = 0; m < k; m++) {
/* 384 */       String str2 = (localObject = arrayOfStackTraceElement[m]).getClassName();
/* 385 */       Object localObject = ((StackTraceElement)localObject).getMethodName();
/* 386 */       if ((paramUncaughtExceptionHandler.equals(str2)) && (str1.equals(localObject))) {
/* 387 */         return false;
/*     */       }
/*     */     }
/* 390 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void a(StrategyBean paramStrategyBean)
/*     */   {
/* 398 */     if ((paramStrategyBean != null) && (paramStrategyBean.g != this.g)) {
/* 399 */       x.a("java changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.g) });
/* 400 */       if (paramStrategyBean.g) {
/* 401 */         a();return;
/*     */       }
/* 403 */       b();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String a(Throwable paramThrowable, int paramInt)
/*     */   {
/* 412 */     if (paramThrowable == null) {
/* 413 */       return null;
/*     */     }
/*     */     
/* 416 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     try {
/* 418 */       if (paramThrowable.getStackTrace() != null) {
/* 419 */         int k = (paramThrowable = paramThrowable.getStackTrace()).length; for (int m = 0; m < k; m++) { Object localObject = paramThrowable[m];
/* 420 */           if ((paramInt > 0) && (localStringBuilder.length() >= paramInt))
/*     */           {
/* 422 */             localStringBuilder.append("\n[Stack over limit size :" + paramInt + " , has been cutted !]");
/* 423 */             return localStringBuilder.toString();
/*     */           }
/*     */           
/* 426 */           localStringBuilder.append(((StackTraceElement)localObject).toString()).append("\n");
/*     */         }
/*     */       }
/*     */     } catch (Throwable paramThrowable) {
/* 430 */       x.e("gen stack error %s", new Object[] { paramThrowable.toString() });
/*     */     }
/* 432 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static String b(Throwable paramThrowable, int paramInt)
/*     */   {
/* 439 */     if (paramThrowable.getMessage() == null) {
/* 440 */       return "";
/*     */     }
/*     */     
/* 443 */     if (paramThrowable.getMessage().length() <= 1000) {
/* 444 */       return paramThrowable.getMessage();
/*     */     }
/* 446 */     return paramThrowable.getMessage().substring(0, 1000) + "\n[Message over limit size:1000" + ", has been cutted!]";
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/e.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */