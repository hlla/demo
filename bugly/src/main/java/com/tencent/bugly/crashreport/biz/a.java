/*     */ package com.tencent.bugly.crashreport.biz;
/*     */ 
/*     */ import android.content.ContentValues;
/*     */ import android.content.Context;
/*     */ import android.database.Cursor;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.proguard.am;
/*     */ import com.tencent.bugly.proguard.ar;
/*     */ import com.tencent.bugly.proguard.p;
/*     */ import com.tencent.bugly.proguard.t;
/*     */ import com.tencent.bugly.proguard.u;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private Context a;
/*     */   private long b;
/*     */   private int c;
/*  43 */   private boolean d = true;
/*     */   
/*     */   public a(Context paramContext, boolean paramBoolean) {
/*  46 */     this.a = paramContext;
/*  47 */     this.d = paramBoolean;
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
/*     */   public final void a(int paramInt, boolean paramBoolean, long paramLong)
/*     */   {
/*  89 */     if (((paramLong = com.tencent.bugly.crashreport.common.strategy.a.a()) != null) && (!paramLong.c().h) && 
/*  90 */       (paramInt != 1) && (paramInt != 3)) {
/*  91 */       x.e("UserInfo is disable", new Object[0]);
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     if ((paramInt == 1) || (paramInt == 3)) {
/*  96 */       this.c += 1;
/*     */     }
/*     */     
/*  99 */     paramLong = paramInt;paramInt = com.tencent.bugly.crashreport.common.info.a.a(paramInt = this.a); UserInfoBean localUserInfoBean; (localUserInfoBean = new UserInfoBean()).b = paramLong;localUserInfoBean.c = paramInt.d;localUserInfoBean.d = paramInt.g();localUserInfoBean.e = System.currentTimeMillis();localUserInfoBean.f = -1L;localUserInfoBean.n = paramInt.j;localUserInfoBean.o = (paramLong == 1 ? 1 : 0);localUserInfoBean.l = paramInt.a();localUserInfoBean.m = paramInt.p;localUserInfoBean.g = paramInt.q;localUserInfoBean.h = paramInt.r;localUserInfoBean.i = paramInt.s;localUserInfoBean.k = paramInt.t;localUserInfoBean.r = paramInt.z();localUserInfoBean.s = paramInt.E();localUserInfoBean.p = paramInt.F();localUserInfoBean.q = paramInt.G();paramInt = localUserInfoBean;
/* 100 */     w.a().a(new a(paramInt, paramBoolean), 0L);
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
/*     */   public final void a()
/*     */   {
/* 117 */     this.b = (z.b() + 86400000L);
/* 118 */     w.a().a(new b(), this.b - System.currentTimeMillis() + 5000L);
/*     */   }
/*     */   
/*     */   class a implements Runnable
/*     */   {
/*     */     private boolean a;
/*     */     private UserInfoBean b;
/*     */     
/*     */     public a(UserInfoBean paramUserInfoBean, boolean paramBoolean)
/*     */     {
/* 128 */       this.b = paramUserInfoBean;
/* 129 */       this.a = paramBoolean;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final void run()
/*     */     {
/*     */       try
/*     */       {
/*     */         Object localObject2;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 146 */         if (this.b != null) {
/* 147 */           if (((localObject1 = this.b) != null) && ((localObject2 = com.tencent.bugly.crashreport.common.info.a.b()) != null)) { ((UserInfoBean)localObject1).j = ((com.tencent.bugly.crashreport.common.info.a)localObject2).e();
/*     */           }
/* 149 */           x.c("[UserInfo] Record user info.", new Object[0]);
/* 150 */           a.a(a.this, this.b, false);
/*     */         }
/* 152 */         if (this.a) {
/* 153 */           localObject1 = a.this; if ((localObject2 = w.a()) != null) ((w)localObject2).a(new a.2((a)localObject1));
/*     */         }
/*     */         return; } catch (Throwable localThrowable) { Object localObject1;
/* 156 */         if (!x.a(localObject1 = 
/*     */         
/*     */ 
/* 159 */           localThrowable)) {
/* 157 */           ((Throwable)localObject1).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void c()
/*     */   {
/* 170 */     if (!this.d) {
/* 171 */       return;
/*     */     }
/*     */     
/*     */ 
/* 175 */     if ((localObject1 = u.a()) == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     com.tencent.bugly.crashreport.common.strategy.a locala;
/*     */     
/* 181 */     if ((locala = com.tencent.bugly.crashreport.common.strategy.a.a()) == null)
/*     */     {
/* 183 */       return;
/*     */     }
/* 185 */     if ((locala.b()) && (!((u)localObject1).b(1001)))
/*     */     {
/*     */ 
/* 188 */       return;
/*     */     }
/*     */     
/* 191 */     int i = 1;
/* 192 */     final Object localObject2 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
/*     */     
/* 194 */     Object localObject3 = new ArrayList();
/*     */     
/*     */ 
/*     */     Object localObject4;
/*     */     
/* 199 */     if ((localObject2 = a((String)localObject2)) != null)
/*     */     {
/*     */       UserInfoBean localUserInfoBean;
/*     */       
/* 203 */       if ((j = ((List)localObject2).size() - 20) > 0)
/*     */       {
/* 205 */         for (k = 0; k < ((List)localObject2).size() - 1; k++) {
/* 206 */           for (int m = k + 1; m < ((List)localObject2).size(); m++) {
/* 207 */             if (((UserInfoBean)((List)localObject2).get(k)).e > ((UserInfoBean)((List)localObject2).get(m)).e)
/*     */             {
/* 209 */               localUserInfoBean = (UserInfoBean)((List)localObject2).get(k);
/* 210 */               ((List)localObject2).set(k, ((List)localObject2).get(m));
/* 211 */               ((List)localObject2).set(m, localUserInfoBean);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 217 */         for (k = 0; k < j; k++) {
/* 218 */           ((List)localObject3).add(((List)localObject2).get(k));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 223 */       int k = 0;
/* 224 */       localObject4 = ((List)localObject2).iterator();
/* 225 */       while (((Iterator)localObject4).hasNext())
/*     */       {
/* 227 */         if ((localUserInfoBean = (UserInfoBean)((Iterator)localObject4).next()).f != -1L)
/*     */         {
/* 229 */           ((Iterator)localObject4).remove();
/*     */           
/*     */ 
/* 232 */           if (localUserInfoBean.e < z.b()) {
/* 233 */             ((List)localObject3).add(localUserInfoBean);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 238 */         if ((localUserInfoBean.e > System.currentTimeMillis() - 600000L) && (
/* 239 */           (localUserInfoBean.b == 1) || (localUserInfoBean.b == 4) || (localUserInfoBean.b == 3)))
/*     */         {
/*     */ 
/* 242 */           k++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 247 */       if (k > 15) {
/* 248 */         i = 0;
/* 249 */         x.d("[UserInfo] Upload user info too many times in 10 min: %d", new Object[] { Integer.valueOf(k) });
/*     */       }
/*     */     } else {
/* 252 */       localObject2 = new ArrayList();
/*     */     }
/*     */     
/*     */ 
/* 256 */     if (((List)localObject3).size() > 0) {
/* 257 */       a((List)localObject3);
/*     */     }
/*     */     
/* 260 */     if ((i == 0) || (((List)localObject2).size() == 0)) {
/* 261 */       x.c("[UserInfo] There is no user info in local database.", new Object[0]);
/* 262 */       return;
/*     */     }
/*     */     
/*     */ 
/* 266 */     x.c("[UserInfo] Upload user info(size: %d)", new Object[] { Integer.valueOf(((List)localObject2).size()) });
/*     */     
/*     */ 
/* 269 */     int j = this.c == 1 ? 1 : 2;
/*     */     
/*     */     ar localar;
/* 272 */     if ((localar = com.tencent.bugly.proguard.a.a((List)localObject2, j)) == null) {
/* 273 */       x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
/* 274 */       return;
/*     */     }
/*     */     
/*     */ 
/* 278 */     if ((localObject4 = com.tencent.bugly.proguard.a.a(localar)) == null) {
/* 279 */       x.d("[UserInfo] Failed to encode data.", new Object[0]);
/* 280 */       return;
/*     */     }
/*     */     
/* 283 */     int n = ((u)localObject1).a ? 840 : 640;
/*     */     
/*     */ 
/*     */     am localam;
/*     */     
/* 288 */     if ((localam = com.tencent.bugly.proguard.a.a(this.a, n, (byte[])localObject4)) == null) {
/* 289 */       x.d("[UserInfo] Request package is null.", new Object[0]);
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     localObject2 = localObject2;
/*     */     
/*     */ 
/* 296 */     localObject2 = new t()
/*     */     {
/*     */       public final void a(boolean paramAnonymousBoolean)
/*     */       {
/*     */         long l;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 305 */         if (paramAnonymousBoolean) {
/* 306 */           x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
/* 307 */           l = System.currentTimeMillis();
/* 308 */           for (paramAnonymousBoolean = localObject2.iterator(); paramAnonymousBoolean.hasNext();) { UserInfoBean localUserInfoBean;
/* 309 */             (localUserInfoBean = (UserInfoBean)paramAnonymousBoolean.next()).f = l;
/* 310 */             a.a(a.this, localUserInfoBean, true);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 315 */     };
/* 316 */     localObject3 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
/* 317 */     localObject3 = ((u)localObject1).a ? ((StrategyBean)localObject3).r : ((StrategyBean)localObject3).t;
/* 318 */     Object localObject1 = ((u)localObject1).a ? StrategyBean.b : StrategyBean.a;
/*     */     
/*     */ 
/* 321 */     u.a().a(1001, localam, (String)localObject3, (String)localObject1, (t)localObject2, this.c == 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void b()
/*     */   {
/*     */     w localw;
/*     */     
/* 330 */     if ((localw = w.a()) != null)
/* 331 */       localw.a(new Runnable()
/*     */       {
/*     */         public final void run() {
/*     */           try {
/* 335 */             a.a(a.this); return;
/*     */           } catch (Throwable localThrowable2) { Throwable localThrowable1;
/* 337 */             x.a(localThrowable1 = 
/* 338 */               localThrowable2);
/*     */           }
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */   class b implements Runnable {
/*     */     b() {}
/*     */     
/*     */     public final void run() {
/*     */       long l;
/* 349 */       if ((l = System.currentTimeMillis()) < a.b(a.this))
/*     */       {
/* 351 */         w.a().a(new b(a.this), a.b(a.this) - l + 5000L);return;
/*     */       }
/*     */       
/*     */ 
/* 355 */       a.this.a(3, false, 0L);
/* 356 */       a.this.a();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class c
/*     */     implements Runnable
/*     */   {
/* 364 */     private long a = 21600000L;
/*     */     
/*     */     public c(long paramLong) {
/* 367 */       this.a = paramLong;
/*     */     }
/*     */     
/*     */     public final void run()
/*     */     {
/* 372 */       a locala = a.this; w localw; if ((localw = w.a()) != null) localw.a(new a.2(locala));
/* 373 */       long l = this.a;locala = a.this;w.a().a(new c(locala, l), l);
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
/*     */   public final List<UserInfoBean> a(String paramString)
/*     */   {
/* 406 */     Cursor localCursor = null;
/*     */     try {
/* 408 */       paramString = "_pc = '" + paramString + "'";
/*     */       
/*     */ 
/*     */ 
/* 412 */       if ((localCursor = p.a().a("t_ui", null, paramString, null, null, true)) == null)
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
/* 448 */         return null;
/*     */       }
/* 415 */       paramString = new StringBuilder();
/* 416 */       ArrayList localArrayList1 = new ArrayList();
/* 417 */       while (localCursor.moveToNext()) {
/*     */         UserInfoBean localUserInfoBean;
/* 419 */         if ((localUserInfoBean = a(localCursor)) != null) {
/* 420 */           localArrayList1.add(localUserInfoBean);
/*     */         } else {
/*     */           try
/*     */           {
/* 424 */             long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
/* 425 */             paramString.append(" or _id").append(" = ").append(l);
/*     */           } catch (Throwable localThrowable1) {
/* 427 */             x.d("[Database] unknown id.", new Object[0]);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 434 */       if ((paramString = paramString.toString()).length() > 0) {
/* 435 */         paramString = paramString.substring(4);
/* 436 */         int i = p.a().a("t_ui", paramString, null, null, true);
/*     */         
/* 438 */         x.d("[Database] deleted %s error data %d", new Object[] { "t_ui", Integer.valueOf(i) });
/*     */       }
/*     */       
/* 441 */       return localArrayList1;
/*     */     }
/*     */     catch (Throwable localThrowable2) {
/* 444 */       paramString.printStackTrace();
/*     */     }
/*     */     finally {
/* 447 */       if (localCursor != null) {
/* 448 */         localCursor.close();
/*     */       }
/*     */     }
/* 451 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void a(List<UserInfoBean> paramList)
/*     */   {
/* 458 */     if ((paramList == null) || (paramList.size() == 0)) {
/* 459 */       return;
/*     */     }
/* 461 */     StringBuilder localStringBuilder = new StringBuilder();
/* 462 */     for (int i = 0; (i < paramList.size()) && (i < 50); i++) {
/* 463 */       UserInfoBean localUserInfoBean = (UserInfoBean)paramList.get(i);
/* 464 */       localStringBuilder.append(" or _id").append(" = ").append(localUserInfoBean.a);
/*     */     }
/*     */     
/*     */     String str;
/* 468 */     if ((str = localStringBuilder.toString()).length() > 0) {
/* 469 */       str = str.substring(4);
/*     */     }
/* 471 */     localStringBuilder.setLength(0);
/*     */     try {
/* 473 */       int j = p.a().a("t_ui", str, null, null, true);
/*     */       
/* 475 */       x.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(j) }); return;
/*     */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/* 477 */       if (!x.a(localThrowable1 = 
/*     */       
/*     */ 
/* 480 */         localThrowable2)) {
/* 478 */         localThrowable1.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static ContentValues a(UserInfoBean paramUserInfoBean)
/*     */   {
/* 487 */     if (paramUserInfoBean == null) {
/* 488 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 492 */       localObject = new ContentValues();
/* 493 */       if (paramUserInfoBean.a > 0L) {
/* 494 */         ((ContentValues)localObject).put("_id", Long.valueOf(paramUserInfoBean.a));
/*     */       }
/* 496 */       ((ContentValues)localObject).put("_tm", Long.valueOf(paramUserInfoBean.e));
/* 497 */       ((ContentValues)localObject).put("_ut", Long.valueOf(paramUserInfoBean.f));
/* 498 */       ((ContentValues)localObject).put("_tp", Integer.valueOf(paramUserInfoBean.b));
/* 499 */       ((ContentValues)localObject).put("_pc", paramUserInfoBean.c);
/* 500 */       ((ContentValues)localObject).put("_dt", z.a(paramUserInfoBean));
/* 501 */       return (ContentValues)localObject;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 503 */       if (!x.a(localObject = localThrowable)) {
/* 504 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 507 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static UserInfoBean a(Cursor paramCursor)
/*     */   {
/* 514 */     if (paramCursor == null) {
/* 515 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 519 */       if ((localObject = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"))) == null) {
/* 520 */         return null;
/*     */       }
/* 522 */       long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
/*     */       
/* 524 */       if ((paramCursor = (UserInfoBean)z.a((byte[])localObject, UserInfoBean.CREATOR)) != null) {
/* 525 */         paramCursor.a = l;
/*     */       }
/* 527 */       return paramCursor;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 529 */       if (!x.a(localObject = localThrowable)) {
/* 530 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 533 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/biz/a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */