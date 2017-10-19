/*     */ package com.tencent.bugly.crashreport.common.info;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.os.Process;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
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
/*     */ {
/*     */   private final Context F;
/*     */   private String G;
/*     */   public final long a;
/*     */   public final byte b;
/*     */   public String c;
/*     */   public final String d;
/*  37 */   public boolean e = true;
/*     */   public final String f;
/*  39 */   public final String g; public final String h; private String H; private String I = "unknown";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  49 */   private String J = "unknown";
/*  50 */   private String K = "";
/*  51 */   public long i; private String L = null;
/*     */   
/*     */ 
/*  54 */   private String M = null;
/*  55 */   private String N = null;
/*  56 */   private String O = null;
/*     */   
/*  58 */   private long P = -1L;
/*  59 */   private long Q = -1L;
/*  60 */   private long R = -1L;
/*  61 */   private String S = null;
/*  62 */   private String T = null;
/*  63 */   private Map<String, PlugInBean> U = null;
/*  64 */   private boolean V = true;
/*  65 */   private String W = null;
/*  66 */   public String j = null;
/*  67 */   public String k = null;
/*  68 */   private String X = null;
/*  69 */   public String l = null;
/*  70 */   private Boolean Y = null;
/*  71 */   private String Z = null;
/*  72 */   public String m = null;
/*  73 */   public String n = null;
/*  74 */   private Map<String, PlugInBean> aa = null;
/*     */   
/*  76 */   public List<String> o = null;
/*     */   
/*  78 */   private static a ab = null;
/*  79 */   private int ac = -1;
/*  80 */   private int ad = -1;
/*  81 */   private Map<String, String> ae = new HashMap();
/*  82 */   private Map<String, String> af = new HashMap();
/*  83 */   private Map<String, String> ag = new HashMap();
/*     */   
/*     */   private boolean ah;
/*  86 */   public String p = "unknown";
/*  87 */   public long q = 0L;
/*  88 */   public long r = 0L;
/*  89 */   public long s = 0L;
/*  90 */   public long t = 0L;
/*     */   
/*  92 */   public boolean u = false;
/*  93 */   public String v = null;
/*  94 */   public String w = null;
/*     */   
/*  96 */   public String x = null;
/*  97 */   public boolean y = false;
/*  98 */   public boolean z = false;
/*     */   
/* 100 */   public HashMap<String, String> A = new HashMap();
/*     */   
/* 102 */   private String ai = null;
/* 103 */   private String aj = null;
/* 104 */   private String ak = null;
/* 105 */   private String al = null;
/* 106 */   private String am = null;
/*     */   
/* 108 */   public boolean B = true;
/*     */   
/* 110 */   public List<String> C = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 115 */   public com.tencent.bugly.crashreport.a D = null;
/*     */   
/*     */ 
/*     */   public SharedPreferences E;
/*     */   
/*     */ 
/* 121 */   private final Object an = new Object();
/* 122 */   private final Object ao = new Object();
/* 123 */   private final Object ap = new Object();
/* 124 */   private final Object aq = new Object();
/* 125 */   private final Object ar = new Object();
/* 126 */   private final Object as = new Object();
/* 127 */   private final Object at = new Object();
/*     */   
/*     */   private a(Context paramContext) {
/* 130 */     this.a = System.currentTimeMillis();
/* 131 */     this.F = z.a(paramContext);
/* 132 */     this.b = 1;
/* 133 */     Object localObject2 = paramContext;Object localObject1 = this; Object localObject3; if ((localObject2 = AppInfo.b((Context)localObject2)) != null) try { ((a)localObject1).j = ((PackageInfo)localObject2).versionName;((a)localObject1).v = ((a)localObject1).j;((a)localObject1).w = Integer.toString(((PackageInfo)localObject2).versionCode); } catch (Throwable localThrowable2) { if (!x.a(localObject3 = localThrowable2)) ((Throwable)localObject3).printStackTrace(); }
/* 134 */     this.c = AppInfo.a(paramContext);
/* 135 */     this.d = AppInfo.a(Process.myPid());
/* 136 */     this.f = b.k();
/* 137 */     this.g = b.a();
/* 138 */     this.k = AppInfo.c(paramContext);
/* 139 */     this.h = ("Android " + b.b() + ",level " + b.c());
/* 140 */     new StringBuilder().append(this.g).append(";").append(this.h).toString();
/* 141 */     localObject2 = paramContext;localObject1 = this; if ((localObject2 = AppInfo.d((Context)localObject2)) != null) try { ((a)localObject1).o = AppInfo.a((Map)localObject2); if ((localObject3 = (String)((Map)localObject2).get("BUGLY_APPID")) != null) ((a)localObject1).X = ((String)localObject3); if ((localObject3 = (String)((Map)localObject2).get("BUGLY_APP_VERSION")) != null) ((a)localObject1).j = ((String)localObject3); if ((localObject3 = (String)((Map)localObject2).get("BUGLY_APP_CHANNEL")) != null) ((a)localObject1).l = ((String)localObject3); if ((localObject3 = (String)((Map)localObject2).get("BUGLY_ENABLE_DEBUG")) != null) ((a)localObject1).u = ((String)localObject3).equalsIgnoreCase("true"); if ((localObject3 = (String)((Map)localObject2).get("com.tencent.rdm.uuid")) != null) ((a)localObject1).x = ((String)localObject3); } catch (Throwable localThrowable3) { if (!x.a(localObject3 = localThrowable3)) ((Throwable)localObject3).printStackTrace();
/*     */       }
/*     */     try
/*     */     {
/* 145 */       if (!(localObject1 = paramContext.getDatabasePath("bugly_db_")).exists())
/*     */       {
/* 147 */         this.z = true;
/* 148 */         x.c("App is first time to be installed on the device.", new Object[0]);
/*     */       }
/*     */     } catch (Throwable localThrowable1) {
/* 151 */       if (com.tencent.bugly.b.c) {
/* 152 */         localThrowable1.printStackTrace();
/*     */       }
/*     */     }
/* 155 */     this.E = z.a("BUGLY_COMMON_VALUES", paramContext);
/* 156 */     x.c("com info create end", new Object[0]);
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
/*     */   public final boolean a()
/*     */   {
/* 225 */     return this.ah;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(boolean paramBoolean)
/*     */   {
/* 234 */     this.ah = paramBoolean;
/* 235 */     if (this.D != null) {
/* 236 */       this.D.setNativeIsAppForeground(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized a a(Context paramContext)
/*     */   {
/* 247 */     if (ab == null) {
/* 248 */       ab = new a(paramContext);
/*     */     }
/* 250 */     return ab;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized a b()
/*     */   {
/* 259 */     return ab;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String c()
/*     */   {
/* 268 */     return "2.6.5";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void d()
/*     */   {
/* 275 */     synchronized (this.an) {
/* 276 */       this.G = UUID.randomUUID().toString();
/* 277 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String e()
/*     */   {
/* 286 */     if (this.G == null) {
/* 287 */       synchronized (this.an) {
/* 288 */         if (this.G == null) {
/* 289 */           this.G = UUID.randomUUID().toString();
/*     */         }
/*     */       }
/*     */     }
/* 293 */     return this.G;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String f()
/*     */   {
/* 302 */     if (!z.a(null)) {
/* 303 */       return null;
/*     */     }
/* 305 */     return this.X;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(String paramString)
/*     */   {
/* 314 */     this.X = paramString;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final String g()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 107	com/tencent/bugly/crashreport/common/info/a:as	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 70	com/tencent/bugly/crashreport/common/info/a:I	Ljava/lang/String;
/*     */     //   11: aload_1
/*     */     //   12: monitorexit
/*     */     //   13: areturn
/*     */     //   14: astore_2
/*     */     //   15: aload_1
/*     */     //   16: monitorexit
/*     */     //   17: aload_2
/*     */     //   18: athrow
/*     */     // Line number table:
/*     */     //   Java source line #323	-> byte code offset #0
/*     */     //   Java source line #324	-> byte code offset #7
/*     */     //   Java source line #325	-> byte code offset #14
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	a
/*     */     //   5	11	1	Ljava/lang/Object;	Object
/*     */     //   14	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	13	14	finally
/*     */   }
/*     */   
/*     */   public final void b(String paramString)
/*     */   {
/* 334 */     synchronized (this.as) {
/* 335 */       if (paramString == null) {
/* 336 */         paramString = "10000";
/*     */       }
/* 338 */       this.I = paramString;
/* 339 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String h()
/*     */   {
/* 348 */     if (this.H != null) {
/* 349 */       return this.H;
/*     */     }
/* 351 */     this.H = (k() + "|" + m() + "|" + n());
/* 352 */     return this.H;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void c(String paramString)
/*     */   {
/* 362 */     this.H = paramString;
/* 363 */     synchronized (this.at) {
/* 364 */       this.af.put("E8", paramString); return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized String i()
/*     */   {
/* 374 */     return this.J;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void d(String paramString)
/*     */   {
/* 383 */     this.J = paramString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized String j()
/*     */   {
/* 392 */     return this.K;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void e(String paramString)
/*     */   {
/* 401 */     this.K = paramString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String k()
/*     */   {
/* 410 */     if (!this.V) {
/* 411 */       return "";
/*     */     }
/* 413 */     if (this.L == null) {
/* 414 */       this.L = b.a(this.F);
/*     */     }
/* 416 */     return this.L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String l()
/*     */   {
/* 425 */     if (!this.V) {
/* 426 */       return "";
/*     */     }
/* 428 */     if (this.M == null) {
/* 429 */       this.M = b.d(this.F);
/*     */     }
/* 431 */     return this.M;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String m()
/*     */   {
/* 440 */     if (!this.V) {
/* 441 */       return "";
/*     */     }
/* 443 */     if (this.N == null) {
/* 444 */       this.N = b.b(this.F);
/*     */     }
/* 446 */     return this.N;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String n()
/*     */   {
/* 455 */     if (!this.V) {
/* 456 */       return "";
/*     */     }
/* 458 */     if (this.O == null) {
/* 459 */       this.O = b.c(this.F);
/*     */     }
/* 461 */     return this.O;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long o()
/*     */   {
/* 470 */     if (this.P <= 0L) {
/* 471 */       this.P = b.d();
/*     */     }
/* 473 */     return this.P;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long p()
/*     */   {
/* 482 */     if (this.Q <= 0L) {
/* 483 */       this.Q = b.f();
/*     */     }
/* 485 */     return this.Q;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long q()
/*     */   {
/* 494 */     if (this.R <= 0L) {
/* 495 */       this.R = b.h();
/*     */     }
/* 497 */     return this.R;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String r()
/*     */   {
/* 506 */     if (this.S == null) {
/* 507 */       this.S = b.a(true);
/*     */     }
/* 509 */     return this.S;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String s()
/*     */   {
/* 518 */     if (this.T == null) {
/* 519 */       this.T = b.g(this.F);
/*     */     }
/* 521 */     return this.T;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(String paramString1, String paramString2)
/*     */   {
/* 531 */     if ((paramString1 == null) || (paramString2 == null)) {
/* 532 */       return;
/*     */     }
/* 534 */     synchronized (this.ao) {
/* 535 */       this.A.put(paramString1, paramString2); return;
/*     */     }
/*     */   }
/*     */   
/*     */   public final String t()
/*     */   {
/*     */     Object localObject4;
/*     */     Object localObject3;
/*     */     try
/*     */     {
/*     */       Object localObject1;
/* 546 */       if (!(localObject4 = (localObject1 = this.F.getSharedPreferences("BuglySdkInfos", 0)).getAll()).isEmpty())
/* 547 */         synchronized (this.ao) {
/* 548 */           for (localObject1 = ((Map)localObject4).entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject4 = (Map.Entry)((Iterator)localObject1).next();
/*     */             try {
/* 550 */               this.A.put(((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue().toString());
/*     */             } catch (Throwable localThrowable1) {
/* 552 */               x.a(localObject4 = 
/* 553 */                 localThrowable1);
/*     */             }
/*     */           }
/*     */         }
/*     */     } catch (Throwable localThrowable2) {
/* 558 */       x.a(localObject3 = 
/* 559 */         localThrowable2); }
/* 560 */     if (!this.A.isEmpty()) {
/* 561 */       localObject3 = new StringBuilder();
/* 562 */       for (localObject4 = this.A.entrySet().iterator(); ((Iterator)localObject4).hasNext();) { ??? = (Map.Entry)((Iterator)localObject4).next();
/* 563 */         ((StringBuilder)localObject3).append("[");
/* 564 */         ((StringBuilder)localObject3).append((String)((Map.Entry)???).getKey());
/* 565 */         ((StringBuilder)localObject3).append(",");
/* 566 */         ((StringBuilder)localObject3).append((String)((Map.Entry)???).getValue());
/* 567 */         ((StringBuilder)localObject3).append("] ");
/*     */       }
/*     */       
/* 570 */       c("SDK_INFO", ((StringBuilder)localObject3).toString());
/* 571 */       return ((StringBuilder)localObject3).toString();
/*     */     }
/* 573 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String u()
/*     */   {
/* 582 */     if (this.am == null) {
/* 583 */       this.am = AppInfo.e(this.F);
/*     */     }
/* 585 */     return this.am;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized Map<String, PlugInBean> v()
/*     */   {
/* 594 */     return null;
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
/*     */   public final String w()
/*     */   {
/* 639 */     if (this.W == null) {
/* 640 */       this.W = b.j();
/*     */     }
/* 642 */     return this.W;
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
/*     */   public final Boolean x()
/*     */   {
/* 660 */     if (this.Y == null) {
/* 661 */       this.Y = Boolean.valueOf(b.h(this.F));
/*     */     }
/* 663 */     return this.Y;
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
/*     */   public final String y()
/*     */   {
/* 681 */     if (this.Z == null) {
/* 682 */       this.Z = b.f(this.F);
/* 683 */       x.a("rom:%s", new Object[] { this.Z });
/*     */     }
/* 685 */     return this.Z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Map<String, String> z()
/*     */   {
/* 694 */     synchronized (this.ap) {
/* 695 */       if (this.ae.size() <= 0) {
/* 696 */         return null;
/*     */       }
/* 698 */       return new HashMap(this.ae);
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final String f(String paramString)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokestatic 176	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
/*     */     //   4: ifeq +32 -> 36
/*     */     //   7: ldc 22
/*     */     //   9: iconst_1
/*     */     //   10: anewarray 45	java/lang/Object
/*     */     //   13: dup
/*     */     //   14: iconst_0
/*     */     //   15: new 47	java/lang/StringBuilder
/*     */     //   18: dup
/*     */     //   19: invokespecial 185	java/lang/StringBuilder:<init>	()V
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   26: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   29: aastore
/*     */     //   30: invokestatic 174	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
/*     */     //   33: pop
/*     */     //   34: aconst_null
/*     */     //   35: areturn
/*     */     //   36: aload_0
/*     */     //   37: getfield 104	com/tencent/bugly/crashreport/common/info/a:ap	Ljava/lang/Object;
/*     */     //   40: dup
/*     */     //   41: astore_2
/*     */     //   42: monitorenter
/*     */     //   43: aload_0
/*     */     //   44: getfield 93	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
/*     */     //   47: aload_1
/*     */     //   48: invokeinterface 210 2 0
/*     */     //   53: checkcast 46	java/lang/String
/*     */     //   56: aload_2
/*     */     //   57: monitorexit
/*     */     //   58: areturn
/*     */     //   59: astore_1
/*     */     //   60: aload_2
/*     */     //   61: monitorexit
/*     */     //   62: aload_1
/*     */     //   63: athrow
/*     */     // Line number table:
/*     */     //   Java source line #709	-> byte code offset #0
/*     */     //   Java source line #710	-> byte code offset #7
/*     */     //   Java source line #711	-> byte code offset #34
/*     */     //   Java source line #713	-> byte code offset #36
/*     */     //   Java source line #714	-> byte code offset #43
/*     */     //   Java source line #715	-> byte code offset #59
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	64	0	this	a
/*     */     //   0	64	1	paramString	String
/*     */     //   41	20	2	Ljava/lang/Object;	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   43	58	59	finally
/*     */   }
/*     */   
/*     */   public final void A()
/*     */   {
/* 722 */     synchronized (this.ap) {
/* 723 */       this.ae.clear();
/* 724 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final String g(String paramString)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokestatic 176	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
/*     */     //   4: ifeq +32 -> 36
/*     */     //   7: ldc 22
/*     */     //   9: iconst_1
/*     */     //   10: anewarray 45	java/lang/Object
/*     */     //   13: dup
/*     */     //   14: iconst_0
/*     */     //   15: new 47	java/lang/StringBuilder
/*     */     //   18: dup
/*     */     //   19: invokespecial 185	java/lang/StringBuilder:<init>	()V
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   26: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   29: aastore
/*     */     //   30: invokestatic 174	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
/*     */     //   33: pop
/*     */     //   34: aconst_null
/*     */     //   35: areturn
/*     */     //   36: aload_0
/*     */     //   37: getfield 104	com/tencent/bugly/crashreport/common/info/a:ap	Ljava/lang/Object;
/*     */     //   40: dup
/*     */     //   41: astore_2
/*     */     //   42: monitorenter
/*     */     //   43: aload_0
/*     */     //   44: getfield 93	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
/*     */     //   47: aload_1
/*     */     //   48: invokeinterface 206 2 0
/*     */     //   53: checkcast 46	java/lang/String
/*     */     //   56: aload_2
/*     */     //   57: monitorexit
/*     */     //   58: areturn
/*     */     //   59: astore_1
/*     */     //   60: aload_2
/*     */     //   61: monitorexit
/*     */     //   62: aload_1
/*     */     //   63: athrow
/*     */     // Line number table:
/*     */     //   Java source line #734	-> byte code offset #0
/*     */     //   Java source line #735	-> byte code offset #7
/*     */     //   Java source line #736	-> byte code offset #34
/*     */     //   Java source line #738	-> byte code offset #36
/*     */     //   Java source line #739	-> byte code offset #43
/*     */     //   Java source line #740	-> byte code offset #59
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	64	0	this	a
/*     */     //   0	64	1	paramString	String
/*     */     //   41	20	2	Ljava/lang/Object;	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   43	58	59	finally
/*     */   }
/*     */   
/*     */   public final void b(String paramString1, String paramString2)
/*     */   {
/* 750 */     if ((z.a(paramString1)) || (z.a(paramString2))) {
/* 751 */       x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
/* 752 */       return;
/*     */     }
/* 754 */     synchronized (this.ap) {
/* 755 */       this.ae.put(paramString1, paramString2); return;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final int B()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 104	com/tencent/bugly/crashreport/common/info/a:ap	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 93	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
/*     */     //   11: invokeinterface 211 1 0
/*     */     //   16: aload_1
/*     */     //   17: monitorexit
/*     */     //   18: ireturn
/*     */     //   19: astore_2
/*     */     //   20: aload_1
/*     */     //   21: monitorexit
/*     */     //   22: aload_2
/*     */     //   23: athrow
/*     */     // Line number table:
/*     */     //   Java source line #765	-> byte code offset #0
/*     */     //   Java source line #766	-> byte code offset #7
/*     */     //   Java source line #767	-> byte code offset #19
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	24	0	this	a
/*     */     //   5	16	1	Ljava/lang/Object;	Object
/*     */     //   19	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	18	19	finally
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final Set<String> C()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 104	com/tencent/bugly/crashreport/common/info/a:ap	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 93	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
/*     */     //   11: invokeinterface 208 1 0
/*     */     //   16: aload_1
/*     */     //   17: monitorexit
/*     */     //   18: areturn
/*     */     //   19: astore_2
/*     */     //   20: aload_1
/*     */     //   21: monitorexit
/*     */     //   22: aload_2
/*     */     //   23: athrow
/*     */     // Line number table:
/*     */     //   Java source line #776	-> byte code offset #0
/*     */     //   Java source line #777	-> byte code offset #7
/*     */     //   Java source line #778	-> byte code offset #19
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	24	0	this	a
/*     */     //   5	16	1	Ljava/lang/Object;	Object
/*     */     //   19	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	18	19	finally
/*     */   }
/*     */   
/*     */   public final Map<String, String> D()
/*     */   {
/* 803 */     synchronized (this.at) {
/* 804 */       if (this.af.size() <= 0) {
/* 805 */         return null;
/*     */       }
/* 807 */       return new HashMap(this.af);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void c(String paramString1, String paramString2)
/*     */   {
/* 815 */     if ((z.a(paramString1)) || (z.a(paramString2))) {
/* 816 */       x.d("server key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
/*     */       
/* 818 */       return;
/*     */     }
/* 820 */     synchronized (this.aq) {
/* 821 */       this.ag.put(paramString1, paramString2); return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Map<String, String> E()
/*     */   {
/* 831 */     synchronized (this.aq) {
/* 832 */       if (this.ag.size() <= 0) {
/* 833 */         return null;
/*     */       }
/* 835 */       return new HashMap(this.ag);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(int paramInt)
/*     */   {
/* 846 */     synchronized (this.ar) {
/*     */       int i1;
/* 848 */       if ((i1 = this.ac) != paramInt) {
/* 849 */         this.ac = paramInt;
/* 850 */         x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ac) });
/*     */       }
/* 852 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final int F()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 106	com/tencent/bugly/crashreport/common/info/a:ar	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 91	com/tencent/bugly/crashreport/common/info/a:ac	I
/*     */     //   11: aload_1
/*     */     //   12: monitorexit
/*     */     //   13: ireturn
/*     */     //   14: astore_2
/*     */     //   15: aload_1
/*     */     //   16: monitorexit
/*     */     //   17: aload_2
/*     */     //   18: athrow
/*     */     // Line number table:
/*     */     //   Java source line #861	-> byte code offset #0
/*     */     //   Java source line #862	-> byte code offset #7
/*     */     //   Java source line #863	-> byte code offset #14
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	a
/*     */     //   5	11	1	Ljava/lang/Object;	Object
/*     */     //   14	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	13	14	finally
/*     */   }
/*     */   
/*     */   public final void b(int paramInt)
/*     */   {
/* 871 */     if ((paramInt = this.ad) != 24096) {
/* 872 */       this.ad = 24096;
/* 873 */       x.a("server scene tag %d changed to tag %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ad) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int G()
/*     */   {
/* 883 */     return this.ad;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean H()
/*     */   {
/* 892 */     return AppInfo.f(this.F);
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
/*     */   public final synchronized Map<String, PlugInBean> I()
/*     */   {
/* 910 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int J()
/*     */   {
/* 920 */     return b.c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String K()
/*     */   {
/* 930 */     if (this.ai == null) {
/* 931 */       this.ai = b.l();
/*     */     }
/* 933 */     return this.ai;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String L()
/*     */   {
/* 942 */     if (this.aj == null) {
/* 943 */       this.aj = b.i(this.F);
/*     */     }
/* 945 */     return this.aj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String M()
/*     */   {
/* 954 */     if (this.ak == null) {
/* 955 */       this.ak = b.j(this.F);
/*     */     }
/* 957 */     return this.ak;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String N()
/*     */   {
/* 967 */     return b.m();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String O()
/*     */   {
/* 976 */     if (this.al == null) {
/* 977 */       this.al = b.k(this.F);
/*     */     }
/* 979 */     return this.al;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long P()
/*     */   {
/* 989 */     return b.n();
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/info/a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */