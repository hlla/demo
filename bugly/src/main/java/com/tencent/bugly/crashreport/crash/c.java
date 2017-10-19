/*     */ package com.tencent.bugly.crashreport.crash;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.tencent.bugly.BuglyStrategy.a;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
/*     */ import com.tencent.bugly.proguard.o;
/*     */ import com.tencent.bugly.proguard.p;
/*     */ import com.tencent.bugly.proguard.r;
/*     */ import com.tencent.bugly.proguard.u;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*  34 */   public static int a = 0;
/*     */   
/*  36 */   public static boolean b = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final Context p;
/*     */   
/*     */ 
/*     */ 
/*  45 */   public static int c = 2;
/*  46 */   public static boolean d = true;
/*  47 */   public static int e = 20000;
/*  48 */   public static int f = 20000;
/*  49 */   public static long g = 604800000L;
/*  50 */   public static String h = null;
/*  51 */   public static boolean i = false;
/*  52 */   public static String j = null;
/*  53 */   public static int k = 5000;
/*  54 */   public static boolean l = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */   public static String m = null;
/*     */   
/*  64 */   public static String n = null;
/*     */   
/*     */ 
/*     */   private static c q;
/*     */   
/*     */ 
/*     */   public final b o;
/*     */   
/*     */ 
/*     */   private final e r;
/*     */   
/*     */ 
/*     */   private final NativeCrashHandler s;
/*     */   
/*     */ 
/*     */   private com.tencent.bugly.crashreport.common.strategy.a t;
/*     */   
/*     */ 
/*     */   private w u;
/*     */   
/*     */ 
/*     */   private final com.tencent.bugly.crashreport.crash.anr.b v;
/*     */   
/*     */ 
/*     */   private Boolean w;
/*     */   
/*     */ 
/*     */   private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString)
/*     */   {
/*  93 */     a = paramInt;
/*  94 */     paramContext = z.a(paramContext);
/*  95 */     this.p = paramContext;
/*  96 */     this.t = com.tencent.bugly.crashreport.common.strategy.a.a();
/*  97 */     this.u = paramw;
/*  98 */     u localu = u.a();
/*     */     
/*     */ 
/* 101 */     p localp = p.a();
/* 102 */     this.o = new b(paramInt, paramContext, localu, localp, this.t, parama, paramo);
/*     */     
/* 104 */     paramInt = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
/* 105 */     this.r = new e(paramContext, this.o, this.t, paramInt);
/* 106 */     this.s = NativeCrashHandler.getInstance(paramContext, paramInt, this.o, this.t, paramw, paramBoolean, paramString);
/*     */     
/* 108 */     paramInt.D = this.s;
/* 109 */     this.v = new com.tencent.bugly.crashreport.crash.anr.b(paramContext, this.t, paramInt, paramw, this.o);
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
/*     */   public static synchronized void a(int paramInt, Context paramContext, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString)
/*     */   {
/* 126 */     if (q == null) {
/* 127 */       q = new c(1004, paramContext, w.a(), paramBoolean, parama, null, null);
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
/*     */   public static synchronized c a()
/*     */   {
/* 145 */     return q;
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
/*     */   public final boolean b()
/*     */   {
/* 166 */     if ((localObject1 = this.w) != null) {
/* 167 */       return ((Boolean)localObject1).booleanValue();
/*     */     }
/*     */     
/* 170 */     Object localObject1 = com.tencent.bugly.crashreport.common.info.a.b().d;
/* 171 */     Object localObject2 = p.a().a(1);
/*     */     
/* 173 */     ArrayList localArrayList = new ArrayList();
/* 174 */     if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
/* 175 */       for (localObject2 = ((List)localObject2).iterator(); ((Iterator)localObject2).hasNext();) { r localr = (r)((Iterator)localObject2).next();
/* 176 */         if (((String)localObject1).equals(localr.c)) {
/* 177 */           this.w = Boolean.valueOf(true);
/* 178 */           localArrayList.add(localr);
/*     */         }
/*     */       }
/*     */       
/* 182 */       if (localArrayList.size() > 0) {
/* 183 */         p.a().a(localArrayList);
/*     */       }
/* 185 */       return true;
/*     */     }
/*     */     
/* 188 */     this.w = Boolean.valueOf(false);
/* 189 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final synchronized void c()
/*     */   {
/* 196 */     c localc = this;this.r.a();
/* 197 */     localc = this;this.s.setUserOpened(true);
/* 198 */     localc = this;this.v.a(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void d()
/*     */   {
/* 207 */     c localc = this;this.r.b();
/* 208 */     localc = this;this.s.setUserOpened(false);
/* 209 */     localc = this;this.v.a(false);
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
/*     */   public final void e()
/*     */   {
/* 225 */     this.r.a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void f()
/*     */   {
/* 232 */     this.s.setUserOpened(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void g()
/*     */   {
/* 239 */     this.s.setUserOpened(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void h()
/*     */   {
/* 246 */     this.v.a(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void i()
/*     */   {
/* 254 */     this.v.a(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final synchronized void j()
/*     */   {
/* 261 */     this.s.testNativeCrash();
/*     */   }
/*     */   
/*     */   public final synchronized void k()
/*     */   {
/*     */     try
/*     */     {
/* 268 */       for (int i1 = 0; i1++ < 30; z.b(5000L)) x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", new Object[] { Integer.valueOf(i1) }); return; } catch (Throwable localThrowable2) { Throwable localThrowable1; if (!x.a(localThrowable1 = localThrowable2)) { localThrowable1.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean l()
/*     */   {
/* 275 */     return this.v.a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(final Thread paramThread, final Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, final boolean paramBoolean2)
/*     */   {
/* 283 */     this.u.a(new Runnable()
/*     */     {
/*     */       public final void run()
/*     */       {
/*     */         try {
/* 288 */           x.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
/* 289 */           c.a(c.this).a(paramThread, paramThrowable, false, this.d, this.e);
/* 290 */           if (paramBoolean2)
/*     */           {
/* 292 */             x.a("clear user datas", new Object[0]);
/* 293 */             com.tencent.bugly.crashreport.common.info.a.a(c.b(c.this)).A();
/*     */           }
/*     */           return; } catch (Throwable localThrowable2) { Throwable localThrowable1;
/* 296 */           if (x.b(localThrowable1 = 
/*     */           
/*     */ 
/*     */ 
/* 300 */             localThrowable2) != true) {
/* 297 */             localThrowable1.printStackTrace();
/*     */           }
/* 299 */           x.e("java catch error: %s", new Object[] { paramThrowable.toString() });
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public final void a(CrashDetailBean paramCrashDetailBean) {
/* 306 */     this.o.d(paramCrashDetailBean);
/*     */   }
/*     */   
/*     */   public final void a(StrategyBean paramStrategyBean)
/*     */   {
/* 154 */     this.r.a(paramStrategyBean);
/* 155 */     this.s.onStrategyChanged(paramStrategyBean);
/* 156 */     this.v.a(paramStrategyBean);
/*     */     
/* 158 */     long l1 = 0L;paramStrategyBean = this;w.a().a(new Thread()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public final void run()
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 319 */         if (!z.a(c.b(c.this), "local_crash_lock", 10000L)) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/*     */         List localList;
/*     */         
/* 326 */         if (((localList = c.this.o.a()) != null) && (localList.size() > 0)) {
/* 327 */           Object localObject = localList;
/*     */           int i;
/* 329 */           if ((i = localList.size()) > 100L) {
/* 330 */             localObject = new ArrayList();
/*     */             
/* 332 */             Collections.sort(localList);
/*     */             
/* 334 */             for (int j = 0; j < 100L; j++) {
/* 335 */               ((List)localObject).add(localList.get(i - 1 - j));
/*     */             }
/*     */           }
/* 338 */           c.this.o.a((List)localObject, 0L, false, false, false);
/*     */         }
/*     */         
/* 341 */         z.b(c.b(c.this), "local_crash_lock"); } }, 0L);
/*     */   }
/*     */   
/*     */   public final void a(long paramLong)
/*     */   {
/* 315 */     w.a().a(new Thread()
/*     */     {
/*     */       public final void run()
/*     */       {
/* 319 */         if (!z.a(c.b(c.this), "local_crash_lock", 10000L)) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/*     */         List localList;
/*     */         
/* 326 */         if (((localList = c.this.o.a()) != null) && (localList.size() > 0)) {
/* 327 */           Object localObject = localList;
/*     */           int i;
/* 329 */           if ((i = localList.size()) > 100L) {
/* 330 */             localObject = new ArrayList();
/*     */             
/* 332 */             Collections.sort(localList);
/*     */             
/* 334 */             for (int j = 0; j < 100L; j++) {
/* 335 */               ((List)localObject).add(localList.get(i - 1 - j));
/*     */             }
/*     */           }
/* 338 */           c.this.o.a((List)localObject, 0L, false, false, false);
/*     */         }
/*     */         
/* 341 */         z.b(c.b(c.this), "local_crash_lock"); } }, 0L);
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */