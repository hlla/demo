/*     */ package com.tencent.bugly.crashreport.common.strategy;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.tencent.bugly.crashreport.biz.b;
/*     */ import com.tencent.bugly.proguard.ao;
/*     */ import com.tencent.bugly.proguard.ap;
/*     */ import com.tencent.bugly.proguard.p;
/*     */ import com.tencent.bugly.proguard.r;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
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
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*  33 */   public static int a = 1000;
/*  34 */   private static a b = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final List<com.tencent.bugly.a> c;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final w d;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final StrategyBean e;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  54 */   private StrategyBean f = null;
/*     */   private Context g;
/*     */   
/*     */   private a(Context paramContext, List<com.tencent.bugly.a> paramList) {
/*  58 */     this.g = paramContext;
/*  59 */     this.e = new StrategyBean();
/*  60 */     this.c = paramList;
/*  61 */     this.d = w.a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static synchronized a a(Context paramContext, List<com.tencent.bugly.a> paramList)
/*     */   {
/*  68 */     if (b == null) {
/*  69 */       b = new a(paramContext, paramList);
/*     */     }
/*  71 */     return b;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(long paramLong)
/*     */   {
/*  81 */     this.d.a(new Thread()
/*     */     {
/*     */       public final void run()
/*     */       {
/*     */         try
/*     */         {
/*  87 */           if ((localObject1 = p.a().a(a.a, null, true)) != null) {
/*  88 */             localObject2 = (byte[])((Map)localObject1).get("key_imei");
/*  89 */             localObject1 = (byte[])((Map)localObject1).get("key_ip");
/*  90 */             if (localObject2 != null) {
/*  91 */               com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).e(new String((byte[])localObject2));
/*     */             }
/*  93 */             if (localObject1 != null) {
/*  94 */               com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).d(new String((byte[])localObject1));
/*     */             }
/*     */           }
/*  97 */           Object localObject2 = a.d();
/*  98 */           a.a(a.this, (StrategyBean)localObject2);
/*     */         } catch (Throwable localThrowable) { Object localObject1;
/* 100 */           if (!x.a(localObject1 = 
/*     */           
/*     */ 
/* 103 */             localThrowable)) {
/* 101 */             ((Throwable)localObject1).printStackTrace();
/*     */           }
/*     */         }
/* 104 */         a.this.a(a.b(a.this), false); } }, paramLong);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static synchronized a a()
/*     */   {
/* 111 */     return b;
/*     */   }
/*     */   
/*     */   public final synchronized boolean b() {
/* 115 */     return this.f != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final StrategyBean c()
/*     */   {
/* 122 */     if (this.f != null) {
/* 123 */       return this.f;
/*     */     }
/* 125 */     return this.e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean)
/*     */   {
/* 133 */     x.c("[Strategy] Notify %s", new Object[] { b.class.getName() });
/* 134 */     b.a(paramStrategyBean, paramBoolean);
/* 135 */     for (Object localObject : this.c) {
/*     */       try {
/* 137 */         x.c("[Strategy] Notify %s", new Object[] { localObject.getClass().getName() });
/* 138 */         ((com.tencent.bugly.a)localObject).onServerStrategyChanged(paramStrategyBean);
/*     */       } catch (Throwable localThrowable) {
/* 140 */         if (!x.a(localObject = 
/*     */         
/*     */ 
/* 143 */           localThrowable)) {
/* 141 */           ((Throwable)localObject).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void a(ap paramap)
/*     */   {
/* 151 */     if (paramap == null) {
/* 152 */       return;
/*     */     }
/* 154 */     if ((this.f != null) && (paramap.h == this.f.p)) {
/*     */       return;
/*     */     }
/*     */     
/*     */ 
/*     */     StrategyBean localStrategyBean;
/*     */     
/* 161 */     (localStrategyBean = new StrategyBean()).g = paramap.a;
/* 162 */     localStrategyBean.i = paramap.c;
/* 163 */     localStrategyBean.h = paramap.b;
/*     */     
/*     */ 
/* 166 */     if (z.c(paramap.d)) {
/* 167 */       x.c("[Strategy] Upload url changes to %s", new Object[] { paramap.d });
/* 168 */       localStrategyBean.r = paramap.d;
/*     */     }
/* 170 */     if (z.c(paramap.e)) {
/* 171 */       x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramap.e });
/* 172 */       localStrategyBean.s = paramap.e;
/*     */     }
/* 174 */     if ((paramap.f != null) && 
/* 175 */       (!z.a(paramap.f.a))) {
/* 176 */       localStrategyBean.u = paramap.f.a;
/*     */     }
/*     */     
/* 179 */     if (paramap.h != 0L) {
/* 180 */       localStrategyBean.p = paramap.h;
/*     */     }
/*     */     Object localObject;
/* 183 */     if ((paramap.g != null) && (paramap.g.size() > 0)) {
/* 184 */       localStrategyBean.v = paramap.g;
/*     */       String str;
/* 186 */       if (((str = (String)paramap.g.get("B11")) != null) && (str.equals("1")))
/*     */       {
/* 188 */         localStrategyBean.j = true;
/*     */       } else {
/* 190 */         localStrategyBean.j = false;
/*     */       }
/*     */       
/*     */ 
/* 194 */       if ((str = (String)paramap.g.get("B3")) != null) {
/* 195 */         localStrategyBean.y = Long.valueOf(str).longValue();
/*     */       }
/*     */       
/* 198 */       localStrategyBean.q = paramap.i;
/* 199 */       localStrategyBean.x = paramap.i;
/*     */       
/*     */ 
/*     */ 
/* 203 */       if (((str = (String)paramap.g.get("B27")) != null) && (str.length() > 0)) {
/*     */         try {
/*     */           int i;
/* 206 */           if ((i = Integer.parseInt(str)) > 0) {
/* 207 */             localStrategyBean.w = i;
/*     */           }
/*     */         } catch (Exception localException) {
/* 210 */           if (!x.a(localObject = 
/*     */           
/*     */ 
/* 213 */             localException)) {
/* 211 */             ((Exception)localObject).printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 216 */       if (((localObject = (String)paramap.g.get("B25")) != null) && (((String)localObject).equals("1")))
/*     */       {
/* 218 */         localStrategyBean.l = true;
/*     */       } else {
/* 220 */         localStrategyBean.l = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 225 */     x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.j), Boolean.valueOf(localStrategyBean.k), Boolean.valueOf(localStrategyBean.n), Boolean.valueOf(localStrategyBean.o), Long.valueOf(localStrategyBean.q), Boolean.valueOf(localStrategyBean.l), Long.valueOf(localStrategyBean.p) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 234 */     this.f = localStrategyBean;
/*     */     
/*     */ 
/* 237 */     p.a().b(2);
/*     */     
/* 239 */     (localObject = new r()).b = 2;
/* 240 */     ((r)localObject).a = localStrategyBean.e;
/* 241 */     ((r)localObject).e = localStrategyBean.f;
/* 242 */     ((r)localObject).g = z.a(localStrategyBean);
/* 243 */     p.a().a((r)localObject);
/*     */     
/*     */ 
/* 246 */     a(localStrategyBean, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static StrategyBean d()
/*     */   {
/*     */     Object localObject;
/*     */     
/*     */ 
/* 257 */     if (((localObject = p.a().a(2)) != null) && (((List)localObject).size() > 0))
/*     */     {
/* 259 */       if ((localObject = (r)((List)localObject).get(0)).g != null) {
/* 260 */         return (StrategyBean)z.a(((r)localObject).g, StrategyBean.CREATOR);
/*     */       }
/*     */     }
/* 263 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/strategy/a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */