/*     */ package com.tencent.bugly.crashreport.crash.jni;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.content.Context;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.crashreport.crash.CrashDetailBean;
/*     */ import com.tencent.bugly.crashreport.crash.c;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NativeCrashHandler
/*     */   implements com.tencent.bugly.crashreport.a
/*     */ {
/*     */   private static NativeCrashHandler a;
/*     */   private final Context b;
/*     */   private final com.tencent.bugly.crashreport.common.info.a c;
/*     */   private final w d;
/*     */   private NativeExceptionHandler e;
/*     */   private String f;
/*     */   private final boolean g;
/*  48 */   private boolean h = false;
/*  49 */   private boolean i = false;
/*     */   
/*  51 */   private boolean j = false;
/*     */   
/*  53 */   private boolean k = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */   private static boolean l = false;
/*     */   
/*  64 */   private static boolean m = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private com.tencent.bugly.crashreport.crash.b n;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SuppressLint({"SdCardPath"})
/*     */   private NativeCrashHandler(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, w paramw, boolean paramBoolean, String paramString)
/*     */   {
/* 122 */     this.b = z.a(paramContext);
/*     */     try
/*     */     {
/* 125 */       if (!z.a(paramString)) {
/* 126 */         paramString = paramString;
/*     */       } else {
/* 128 */         paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/* 131 */       paramString = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
/* 132 */       paramString = "/data/data/" + paramString + "/app_bugly";
/*     */     }
/* 134 */     this.n = paramb;
/* 135 */     this.f = paramString;
/* 136 */     this.c = parama;
/* 137 */     this.d = paramw;
/* 138 */     this.g = paramBoolean;
/* 139 */     this.e = new a(paramContext, parama, paramb, com.tencent.bugly.crashreport.common.strategy.a.a());
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
/*     */   public static synchronized NativeCrashHandler getInstance(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1, w paramw, boolean paramBoolean, String paramString)
/*     */   {
/* 159 */     if (a == null) {
/* 160 */       a = new NativeCrashHandler(paramContext, parama, paramb, paramw, paramBoolean, paramString);
/*     */     }
/*     */     
/* 163 */     return a;
/*     */   }
/*     */   
/*     */   public static synchronized NativeCrashHandler getInstance() {
/* 167 */     return a;
/*     */   }
/*     */   
/*     */   public synchronized String getDumpFilePath() {
/* 171 */     return this.f;
/*     */   }
/*     */   
/*     */   public synchronized void setDumpFilePath(String paramString) {
/* 175 */     this.f = paramString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native String regist(String paramString, boolean paramBoolean, int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native String unregist();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native void testCrash();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native boolean appendWholeNativeLog(String paramString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native String getNativeLog();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native boolean putNativeKeyValue(String paramString1, String paramString2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native String getNativeKeyValueList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native String removeNativeKeyValue(String paramString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected native void setNativeInfo(int paramInt, String paramString);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void a(boolean paramBoolean)
/*     */   {
/* 263 */     if (this.j) {
/* 264 */       x.d("[Native] Native crash report has already registered.", new Object[0]); return;
/*     */     }
/*     */     
/*     */     Object localObject;
/* 268 */     if (this.i)
/*     */       try
/*     */       {
/* 271 */         if ((localObject = regist(this.f, paramBoolean, 1)) != null) {
/* 272 */           x.a("[Native] Native Crash Report enable.", new Object[0]);
/* 273 */           paramBoolean = localObject;x.c("[Native] Check extra jni for Bugly NDK v%s", new Object[] { paramBoolean });String str1 = "2.1.1".replace(".", "");String str2 = "2.3.0".replace(".", ""); if ((paramBoolean = paramBoolean.replace(".", "")).length() == 2) paramBoolean = paramBoolean + "0"; else if (paramBoolean.length() == 1) paramBoolean = paramBoolean + "00"; try { if (Integer.parseInt(paramBoolean) >= Integer.parseInt(str1)) l = true; if (Integer.parseInt(paramBoolean) >= Integer.parseInt(str2)) m = true; } catch (Throwable localThrowable1) {} if (m) x.a("[Native] Info setting jni can be accessed.", new Object[0]); else x.d("[Native] Info setting jni can not be accessed.", new Object[0]); if (l) x.a("[Native] Extra jni can be accessed.", new Object[0]); else x.d("[Native] Extra jni can not be accessed.", new Object[0]);
/* 274 */           this.c.n = ((String)localObject);
/* 275 */           this.j = true;
/* 276 */           return;
/*     */         }
/*     */       } catch (Throwable localThrowable2) {
/* 279 */         x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
/*     */       }
/* 281 */     if (this.h)
/*     */     {
/*     */ 
/*     */       try
/*     */       {
/*     */ 
/*     */ 
/* 288 */         if ((localObject = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, Integer.TYPE, Integer.TYPE }, new Object[] { this.f, com.tencent.bugly.crashreport.common.info.b.a(false), Integer.valueOf(paramBoolean ? 1 : 5), Integer.valueOf(1) })) == null) {
/* 289 */           com.tencent.bugly.crashreport.common.info.a.b();{ this.f, com.tencent.bugly.crashreport.common.info.b.a(false) }[2] = Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.J());localObject = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, Integer.TYPE }, tmp411_404);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 296 */         if (localObject != null) {
/* 297 */           this.j = true;
/* 298 */           com.tencent.bugly.crashreport.common.info.a.b().n = ((String)localObject);
/*     */           
/*     */ 
/*     */ 
/* 302 */           if ((localObject = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[] { String.class }, new Object[] { localObject })) != null) {
/* 303 */             l = ((Boolean)localObject).booleanValue();
/*     */           }
/* 305 */           z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
/*     */           
/* 307 */           paramBoolean = paramBoolean;
/* 308 */           z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramBoolean) });
/*     */           
/* 310 */           return;
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable3) {}
/*     */     }
/*     */     
/* 316 */     this.i = false;
/* 317 */     this.h = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized void startNativeMonitor()
/*     */   {
/* 324 */     if ((this.i) || (this.h)) {
/* 325 */       a(this.g);
/* 326 */       return;
/*     */     }
/*     */     
/* 329 */     String str1 = "Bugly";
/* 330 */     boolean bool = !z.a(this.c.m);
/*     */     
/* 332 */     String str2 = this.c.m;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 341 */     if (!bool) {
/* 342 */       str2 = str1;
/* 343 */       this.c.getClass(); if (0 > 0) { this.c.getClass(); if (!"".contains("@")) {
/* 344 */           this.c.getClass();str2 = str2 + "-";
/*     */         }
/*     */       } }
/* 347 */     this.i = a(str2, bool);
/*     */     
/* 349 */     if ((!this.i) && (!this.h)) {
/* 350 */       return;
/*     */     }
/*     */     
/* 353 */     a(this.g);
/*     */     
/* 355 */     this.d.a(new Runnable()
/*     */     {
/*     */       public final void run()
/*     */       {
/* 359 */         if (!z.a(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock", 10000L))
/*     */         {
/*     */ 
/* 362 */           x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]); return;
/*     */         }
/*     */         
/*     */ 
/*     */         Object localObject;
/*     */         
/*     */         try
/*     */         {
/* 370 */           NativeCrashHandler.this.setNativeAppVersion(NativeCrashHandler.b(NativeCrashHandler.this).j);
/* 371 */           NativeCrashHandler.this.setNativeAppChannel(NativeCrashHandler.b(NativeCrashHandler.this).l);
/* 372 */           NativeCrashHandler.this.setNativeAppPackage(NativeCrashHandler.b(NativeCrashHandler.this).c);
/* 373 */           NativeCrashHandler.this.setNativeUserId(NativeCrashHandler.b(NativeCrashHandler.this).g());
/* 374 */           NativeCrashHandler.this.setNativeIsAppForeground(NativeCrashHandler.b(NativeCrashHandler.this).a());
/* 375 */           NativeCrashHandler.this.setNativeLaunchTime(NativeCrashHandler.b(NativeCrashHandler.this).a);
/*     */         } catch (Throwable localThrowable) {
/* 377 */           if (!x.a(localObject = 
/*     */           
/*     */ 
/* 380 */             localThrowable)) {
/* 378 */             ((Throwable)localObject).printStackTrace();
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 385 */         if ((localObject = b.a(NativeCrashHandler.a(NativeCrashHandler.this), NativeCrashHandler.c(NativeCrashHandler.this), NativeCrashHandler.d(NativeCrashHandler.this))) != null) {
/* 386 */           x.a("[Native] Get crash from native record.", new Object[0]);
/*     */           
/* 388 */           if (!NativeCrashHandler.e(NativeCrashHandler.this).a((CrashDetailBean)localObject)) {
/* 389 */             NativeCrashHandler.e(NativeCrashHandler.this).a((CrashDetailBean)localObject, 3000L, false);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 394 */           b.a(false, NativeCrashHandler.c(NativeCrashHandler.this));
/*     */         }
/* 396 */         NativeCrashHandler.this.a();
/*     */         
/* 398 */         z.b(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock");
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private static boolean a(String paramString, boolean paramBoolean) {
/* 404 */     boolean bool = false;
/*     */     try {
/* 406 */       x.a("[Native] Trying to load so: %s", new Object[] { paramString });
/* 407 */       if (paramBoolean) {
/* 408 */         System.load(paramString);
/*     */       } else {
/* 410 */         System.loadLibrary(paramString);
/*     */       }
/* 412 */       bool = true;
/* 413 */       x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
/*     */     } catch (Throwable localThrowable) {
/* 415 */       x.d((paramBoolean = 
/*     */       
/* 417 */         localThrowable).getMessage(), new Object[0]);x.d("[Native] Failed to load so: %s", new Object[] { paramString });
/*     */     }
/* 418 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private synchronized void b()
/*     */   {
/* 425 */     if (!this.j) {
/* 426 */       x.d("[Native] Native crash report has already unregistered.", new Object[0]);
/* 427 */       return;
/*     */     }
/*     */     try {
/*     */       String str;
/* 431 */       if ((str = unregist()) != null) {
/* 432 */         x.a("[Native] Successfully closed native crash report.", new Object[0]);
/* 433 */         this.j = false;
/* 434 */         return;
/*     */       }
/*     */     } catch (Throwable localThrowable1) {
/* 437 */       x.c("[Native] Failed to close native crash report.", new Object[0]);
/*     */     }
/*     */     try
/*     */     {
/* 441 */       z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(false) });
/*     */       
/* 443 */       this.j = false;
/* 444 */       x.a("[Native] Successfully closed native crash report.", new Object[0]);
/* 445 */       return;
/*     */     } catch (Throwable localThrowable2) {
/* 447 */       x.c("[Native] Failed to close native crash report.", new Object[0]);
/*     */       
/*     */ 
/* 450 */       this.i = false;
/* 451 */       this.h = false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void testNativeCrash()
/*     */   {
/* 458 */     if (!this.i) {
/* 459 */       x.d("[Native] Bugly SO file has not been load.", new Object[0]);
/* 460 */       return;
/*     */     }
/*     */     
/* 463 */     testCrash();
/*     */   }
/*     */   
/*     */   public NativeExceptionHandler getNativeExceptionHandler() {
/* 467 */     return this.e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected final void a()
/*     */   {
/* 474 */     long l1 = z.b() - c.g;
/*     */     Object localObject1;
/* 476 */     if (((localObject1 = new File(this.f)).exists()) && (((File)localObject1).isDirectory()))
/*     */     {
/* 478 */       if (((localObject1 = ((File)localObject1).listFiles()) == null) || (localObject1.length == 0)) {
/* 479 */         return;
/*     */       }
/*     */       
/* 482 */       String str1 = "tomb_";
/* 483 */       String str2 = ".txt";
/* 484 */       int i1 = str1.length();
/*     */       
/* 486 */       int i2 = 0;
/* 487 */       int i3 = (localObject1 = localObject1).length; for (int i4 = 0; i4 < i3; i4++) { Object localObject2;
/*     */         String str3;
/* 489 */         if ((str3 = (localObject2 = localObject1[i4]).getName()).startsWith(str1)) {
/*     */           try {
/*     */             int i5;
/* 492 */             if ((i5 = str3.indexOf(str2)) > 0) {
/*     */               long l2;
/* 494 */               if ((l2 = Long.parseLong(str3.substring(i1, i5))) >= l1) {
/*     */                 continue;
/*     */               }
/*     */             }
/*     */           } catch (Throwable localThrowable) {
/* 499 */             x.e("[Native] Tomb file format error, delete %s", new Object[] { str3 });
/*     */           }
/*     */           
/*     */ 
/* 503 */           if (((File)localObject2).delete()) {
/* 504 */             i2++;
/*     */           }
/*     */         }
/*     */       }
/* 508 */       x.c("[Native] Clean tombs %d", new Object[] { Integer.valueOf(i2) });
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
/*     */   private synchronized void b(boolean paramBoolean)
/*     */   {
/* 526 */     if (paramBoolean) {
/* 527 */       startNativeMonitor();return;
/*     */     }
/* 529 */     b();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isUserOpened()
/*     */   {
/* 537 */     return this.k;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private synchronized void c(boolean paramBoolean)
/*     */   {
/* 544 */     if (this.k != paramBoolean) {
/* 545 */       x.a("user change native %b", new Object[] { Boolean.valueOf(paramBoolean) });
/* 546 */       this.k = paramBoolean;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void setUserOpened(boolean paramBoolean)
/*     */   {
/* 555 */     c(paramBoolean);
/*     */     
/* 557 */     paramBoolean = isUserOpened();
/*     */     com.tencent.bugly.crashreport.common.strategy.a locala;
/* 559 */     if ((locala = com.tencent.bugly.crashreport.common.strategy.a.a()) != null) {
/* 560 */       paramBoolean = (paramBoolean) && (locala.c().g);
/*     */     }
/* 562 */     if (paramBoolean != this.j) {
/* 563 */       x.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
/* 564 */       b(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void onStrategyChanged(StrategyBean paramStrategyBean)
/*     */   {
/* 575 */     if ((paramStrategyBean != null) && (paramStrategyBean.g != this.j)) {
/* 576 */       x.d("server native changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.g) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 581 */     if ((paramStrategyBean = (com.tencent.bugly.crashreport.common.strategy.a.a().c().g) && (this.k) ? 1 : 0) != this.j) {
/* 582 */       x.a("native changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean) });
/* 583 */       b(paramStrategyBean);
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
/*     */   public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
/*     */   {
/* 597 */     if ((!this.h) && (!this.i)) {
/* 598 */       return false;
/*     */     }
/* 600 */     if (!l) {
/* 601 */       return false;
/*     */     }
/* 603 */     if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
/* 604 */       return false;
/*     */     }
/*     */     try {
/* 607 */       if (this.i) {
/* 608 */         return appendNativeLog(paramString1, paramString2, paramString3);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 614 */       if ((paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 })) != null) return paramString1.booleanValue(); return false;
/*     */     }
/*     */     catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
/* 617 */       l = false;
/* 618 */       return false;
/*     */     } catch (Throwable localThrowable) {
/* 620 */       if (!x.a(paramString1 = localThrowable))
/* 621 */         paramString1.printStackTrace();
/*     */     }
/* 623 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean putKeyValueToNative(String paramString1, String paramString2)
/*     */   {
/* 635 */     if ((!this.h) && (!this.i)) {
/* 636 */       return false;
/*     */     }
/* 638 */     if (!l) {
/* 639 */       return false;
/*     */     }
/* 641 */     if ((paramString1 == null) || (paramString2 == null)) {
/* 642 */       return false;
/*     */     }
/*     */     try {
/* 645 */       if (this.i) {
/* 646 */         return putNativeKeyValue(paramString1, paramString2);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 651 */       if ((paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 })) != null) return paramString1.booleanValue(); return false;
/*     */     }
/*     */     catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
/* 654 */       l = false;
/* 655 */       return false;
/*     */     } catch (Throwable localThrowable) {
/* 657 */       if (!x.a(paramString1 = localThrowable))
/* 658 */         paramString1.printStackTrace();
/*     */     }
/* 660 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean a(int paramInt, String paramString)
/*     */   {
/* 672 */     if ((!this.i) || (!m)) {
/* 673 */       return false;
/*     */     }
/*     */     try {
/* 676 */       setNativeInfo(paramInt, paramString);
/* 677 */       return true;
/*     */     } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
/* 679 */       m = false;
/* 680 */       return false;
/*     */     } catch (Throwable localThrowable) {
/* 682 */       if (!x.a(paramInt = localThrowable))
/* 683 */         paramInt.printStackTrace();
/*     */     }
/* 685 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean filterSigabrtSysLog()
/*     */   {
/* 695 */     return a(998, "true");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeAppVersion(String paramString)
/*     */   {
/* 705 */     return a(10, paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeAppChannel(String paramString)
/*     */   {
/* 715 */     return a(12, paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeAppPackage(String paramString)
/*     */   {
/* 725 */     return a(13, paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeUserId(String paramString)
/*     */   {
/* 735 */     return a(11, paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeIsAppForeground(boolean paramBoolean)
/*     */   {
/* 745 */     paramBoolean = paramBoolean ? "true" : "false";
/* 746 */     return a(14, paramBoolean);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setNativeLaunchTime(long paramLong)
/*     */   {
/*     */     try
/*     */     {
/* 757 */       return a(15, String.valueOf(paramLong));
/*     */     } catch (NumberFormatException localNumberFormatException) {
/* 759 */       if (!x.a(paramLong = localNumberFormatException))
/* 760 */         paramLong.printStackTrace();
/*     */     }
/* 762 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */