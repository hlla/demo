/*      */ package com.tencent.bugly.crashreport.crash;
/*      */ 
/*      */ import android.content.ContentValues;
/*      */ import android.content.Context;
/*      */ import android.database.Cursor;
/*      */ import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.BuglyStrategy.a;
/*      */ import com.tencent.bugly.crashreport.common.info.PlugInBean;
/*      */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*      */ import com.tencent.bugly.proguard.ah;
/*      */ import com.tencent.bugly.proguard.aj;
/*      */ import com.tencent.bugly.proguard.ak;
/*      */ import com.tencent.bugly.proguard.al;
/*      */ import com.tencent.bugly.proguard.am;
/*      */ import com.tencent.bugly.proguard.k;
/*      */ import com.tencent.bugly.proguard.o;
/*      */ import com.tencent.bugly.proguard.p;
/*      */ import com.tencent.bugly.proguard.r;
/*      */ import com.tencent.bugly.proguard.t;
/*      */ import com.tencent.bugly.proguard.u;
/*      */ import com.tencent.bugly.proguard.x;
/*      */ import com.tencent.bugly.proguard.z;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.net.URLEncoder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class b
/*      */ {
/*   61 */   private static int a = 0;
/*      */   
/*      */ 
/*      */   private Context b;
/*      */   
/*      */ 
/*      */   private u c;
/*      */   
/*      */ 
/*      */   private p d;
/*      */   
/*      */ 
/*      */   private com.tencent.bugly.crashreport.common.strategy.a e;
/*      */   
/*      */ 
/*      */   private o f;
/*      */   
/*      */   private BuglyStrategy.a g;
/*      */   
/*      */ 
/*      */   public b(int paramInt, Context paramContext, u paramu, p paramp, com.tencent.bugly.crashreport.common.strategy.a parama, BuglyStrategy.a parama1, o paramo)
/*      */   {
/*   83 */     a = paramInt;
/*   84 */     this.b = paramContext;
/*   85 */     this.c = paramu;
/*   86 */     this.d = paramp;
/*   87 */     this.e = parama;
/*   88 */     this.g = parama1;
/*   89 */     this.f = paramo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<a> a(List<a> paramList)
/*      */   {
/*   98 */     if ((paramList == null) || (paramList.size() == 0)) {
/*   99 */       return null;
/*      */     }
/*      */     
/*      */ 
/*  103 */     long l = System.currentTimeMillis();
/*  104 */     ArrayList localArrayList = new ArrayList();
/*  105 */     paramList = paramList.iterator();
/*  106 */     while (paramList.hasNext()) {
/*      */       a locala;
/*  108 */       if (((locala = (a)paramList.next()).d) && (locala.b <= l - 86400000L))
/*      */       {
/*  110 */         localArrayList.add(locala);
/*      */       }
/*      */     }
/*  113 */     return localArrayList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean)
/*      */   {
/*  123 */     if ((paramList == null) || (paramList.size() == 0)) {
/*  124 */       return paramCrashDetailBean;
/*      */     }
/*      */     
/*  127 */     Object localObject1 = null;
/*      */     
/*      */ 
/*  130 */     Object localObject2 = new ArrayList(10);
/*  131 */     for (Object localObject3 = paramList.iterator(); ((Iterator)localObject3).hasNext();) { a locala1;
/*  132 */       if ((locala1 = (a)((Iterator)localObject3).next()).e) {
/*  133 */         ((List)localObject2).add(locala1);
/*      */       }
/*      */     }
/*      */     
/*  137 */     if (((List)localObject2).size() > 0)
/*      */     {
/*      */ 
/*  140 */       if (((localObject3 = b((List)localObject2)) != null) && (((List)localObject3).size() > 0)) {
/*  141 */         Collections.sort((List)localObject3);
/*  142 */         for (int i = 0; i < ((List)localObject3).size(); i++) {
/*  143 */           localObject2 = (CrashDetailBean)((List)localObject3).get(i);
/*  144 */           if (i == 0)
/*      */           {
/*  146 */             localObject1 = localObject2;
/*      */           }
/*  148 */           else if (((CrashDetailBean)localObject2).s != null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  154 */             if ((localObject2 = ((CrashDetailBean)localObject2).s.split("\n")) != null) {
/*  155 */               int j = (localObject2 = localObject2).length; for (int k = 0; k < j; 
/*      */                   
/*      */ 
/*  158 */                   k++)
/*      */               {
/*  155 */                 String str = localObject2[k];
/*      */                 
/*      */ 
/*      */ 
/*  159 */                 if (!((CrashDetailBean)localObject1).s.contains(str)) {
/*  160 */                   localObject1.t += 1; Object 
/*  161 */                     tmp247_246 = localObject1;tmp247_246.s = (tmp247_246.s + str + "\n");
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  169 */     if (localObject1 == null)
/*      */     {
/*      */ 
/*  172 */       (localObject1 = paramCrashDetailBean).j = true;
/*  173 */       ((CrashDetailBean)localObject1).t = 0;
/*  174 */       ((CrashDetailBean)localObject1).s = "";
/*      */     }
/*      */     
/*      */     a locala2;
/*  178 */     for (localObject3 = paramList.iterator(); ((Iterator)localObject3).hasNext(); 
/*      */         
/*      */ 
/*      */ 
/*  182 */         tmp395_394.s = (tmp395_394.s + locala2.b + "\n")) {
/*  179 */       if ((!(locala2 = (a)((Iterator)localObject3).next()).e) && (!locala2.d) && (!((CrashDetailBean)localObject1).s.contains(locala2.b)))
/*      */       {
/*  181 */         localObject1.t += 1;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  186 */     if ((((CrashDetailBean)localObject1).r != paramCrashDetailBean.r) && (!((CrashDetailBean)localObject1).s.contains(paramCrashDetailBean.r)))
/*      */     {
/*      */ 
/*  189 */       localObject1.t += 1; Object 
/*  190 */         tmp481_480 = localObject1;tmp481_480.s = (tmp481_480.s + paramCrashDetailBean.r + "\n");
/*      */     }
/*      */     
/*  193 */     return (CrashDetailBean)localObject1;
/*      */   }
/*      */   
/*      */   public final boolean a(CrashDetailBean paramCrashDetailBean) {
/*  197 */     return a(paramCrashDetailBean, -123456789);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final boolean a(CrashDetailBean paramCrashDetailBean, int paramInt)
/*      */   {
/*  206 */     if (paramCrashDetailBean == null) {
/*  207 */       return true;
/*      */     }
/*  209 */     if ((c.m != null) && (!c.m.isEmpty())) {
/*  210 */       x.c("Crash filter for crash stack is: %s", new Object[] { c.m });
/*  211 */       if (paramCrashDetailBean.q.contains(c.m)) {
/*  212 */         x.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
/*      */         
/*  214 */         return true;
/*      */       }
/*      */     }
/*  217 */     if ((c.n != null) && (!c.n.isEmpty())) {
/*  218 */       x.c("Crash regular filter for crash stack is: %s", new Object[] { c.n });
/*      */       
/*      */ 
/*  221 */       if ((paramInt = Pattern.compile(c.n)).matcher(paramCrashDetailBean.q).find()) {
/*  222 */         x.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
/*      */         
/*  224 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  236 */     if (this.f != null)
/*      */     {
/*      */ 
/*      */ 
/*  240 */       if (!(paramInt = this.f.c())) {
/*  241 */         x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
/*      */         
/*  243 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  248 */     if (paramCrashDetailBean.b != 2)
/*      */     {
/*  250 */       (paramInt = new r()).b = 1;
/*  251 */       paramInt.c = paramCrashDetailBean.z;
/*  252 */       paramInt.d = paramCrashDetailBean.A;
/*  253 */       paramInt.e = paramCrashDetailBean.r;
/*      */       
/*  255 */       this.d.b(1);
/*  256 */       this.d.a(paramInt);
/*  257 */       x.b("[crash] a crash occur, handling...", new Object[0]);
/*      */     } else {
/*  259 */       x.b("[crash] a caught exception occur, handling...", new Object[0]);
/*      */     }
/*      */     
/*  262 */     paramInt = b();
/*  263 */     ArrayList localArrayList1 = null;
/*  264 */     if ((paramInt != null) && (paramInt.size() > 0)) {
/*  265 */       localArrayList1 = new ArrayList(10);
/*  266 */       ArrayList localArrayList2 = new ArrayList(10);
/*      */       
/*      */ 
/*  269 */       localArrayList1.addAll(a(paramInt));
/*  270 */       paramInt.removeAll(localArrayList1);
/*      */       
/*  272 */       if ((!com.tencent.bugly.b.c) && (c.d))
/*      */       {
/*      */ 
/*  275 */         int i = 0;
/*  276 */         for (paramInt = paramInt.iterator(); paramInt.hasNext();) { localObject = (a)paramInt.next();
/*  277 */           if (paramCrashDetailBean.u.equals(((a)localObject).c)) {
/*  278 */             if (((a)localObject).e) {
/*  279 */               i = 1;
/*      */             }
/*  281 */             localArrayList2.add(localObject);
/*      */           }
/*      */         }
/*      */         Object localObject;
/*  285 */         if ((i != 0) || (localArrayList2.size() >= c.c))
/*      */         {
/*      */ 
/*  288 */           x.a("same crash occur too much do merged!", new Object[0]);
/*  289 */           paramInt = a(localArrayList2, paramCrashDetailBean);
/*  290 */           for (localObject = localArrayList2.iterator(); ((Iterator)localObject).hasNext();) {
/*  291 */             if ((paramCrashDetailBean = (a)((Iterator)localObject).next()).a != paramInt.a) {
/*  292 */               localArrayList1.add(paramCrashDetailBean);
/*      */             }
/*      */           }
/*  295 */           d(paramInt);
/*  296 */           c(localArrayList1);
/*  297 */           x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
/*      */           
/*  299 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  305 */     d(paramCrashDetailBean);
/*  306 */     if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
/*  307 */       c(localArrayList1);
/*      */     }
/*  309 */     x.b("[crash] save crash success", new Object[0]);
/*  310 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public final List<CrashDetailBean> a()
/*      */   {
/*      */     Object localObject1;
/*      */     
/*      */ 
/*  320 */     if ((localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a().c()) == null) {
/*  321 */       x.d("have not synced remote!", new Object[0]);
/*  322 */       return null;
/*      */     }
/*      */     
/*  325 */     if (!((StrategyBean)localObject1).g) {
/*  326 */       x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
/*      */       
/*      */ 
/*  329 */       x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
/*      */       
/*      */ 
/*  332 */       return null;
/*      */     }
/*      */     
/*  335 */     long l1 = System.currentTimeMillis();
/*  336 */     long l2 = z.b();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  341 */     if (((localObject1 = b()) == null) || (((List)localObject1).size() <= 0)) {
/*  342 */       return null;
/*      */     }
/*      */     
/*  345 */     ArrayList localArrayList = new ArrayList();
/*      */     
/*      */ 
/*  348 */     Iterator localIterator2 = ((List)localObject1).iterator();
/*  349 */     while (localIterator2.hasNext())
/*      */     {
/*  351 */       if ((localObject2 = (a)localIterator2.next()).b < l2 - c.g)
/*      */       {
/*  353 */         localIterator2.remove();
/*  354 */         localArrayList.add(localObject2);
/*      */ 
/*      */ 
/*      */       }
/*  358 */       else if (((a)localObject2).d) {
/*  359 */         if (((a)localObject2).b >= l1 - 86400000L)
/*      */         {
/*  361 */           localIterator2.remove();
/*      */         }
/*  363 */         else if (!((a)localObject2).e)
/*      */         {
/*  365 */           localIterator2.remove();
/*  366 */           localArrayList.add(localObject2);
/*      */         }
/*  368 */       } else if ((((a)localObject2).f >= 3L) && (((a)localObject2).b < l1 - 86400000L))
/*      */       {
/*      */ 
/*  371 */         localIterator2.remove();
/*  372 */         localArrayList.add(localObject2);
/*      */       }
/*      */     }
/*      */     
/*  376 */     if (localArrayList.size() > 0) {
/*  377 */       c(localArrayList);
/*      */     }
/*      */     
/*      */ 
/*  381 */     Object localObject2 = new ArrayList();
/*      */     
/*  383 */     if (((localObject1 = b((List)localObject1)) != null) && (((List)localObject1).size() > 0))
/*      */     {
/*  385 */       String str = com.tencent.bugly.crashreport.common.info.a.b().j;
/*  386 */       Iterator localIterator1 = ((List)localObject1).iterator();
/*  387 */       while (localIterator1.hasNext()) {
/*  388 */         CrashDetailBean localCrashDetailBean = (CrashDetailBean)localIterator1.next();
/*  389 */         if (!str.equals(localCrashDetailBean.f)) {
/*  390 */           localIterator1.remove();
/*  391 */           ((List)localObject2).add(localCrashDetailBean);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  396 */     if (((List)localObject2).size() > 0) {
/*  397 */       d((List)localObject2);
/*      */     }
/*      */     
/*  400 */     return (List<CrashDetailBean>)localObject1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void b(CrashDetailBean paramCrashDetailBean)
/*      */   {
/*  409 */     if (this.f != null) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean)
/*      */   {
/*  421 */     if (c.l) {
/*  422 */       x.a("try to upload right now", new Object[0]);
/*  423 */       (
/*  424 */         paramLong = new ArrayList()).add(paramCrashDetailBean);
/*      */       
/*      */ 
/*  427 */       a(paramLong, 3000L, paramBoolean, paramCrashDetailBean.b == 7, paramBoolean);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void a(final List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
/*      */   {
/*  442 */     if (!com.tencent.bugly.crashreport.common.info.a.a(this.b).e)
/*      */     {
/*  444 */       return;
/*      */     }
/*  446 */     if (this.c == null) {
/*  447 */       return;
/*      */     }
/*  449 */     if ((!paramBoolean3) && (!this.c.b(c.a)))
/*      */     {
/*  451 */       return;
/*      */     }
/*      */     
/*  454 */     if (!(paramBoolean3 = this.e.c()).g) {
/*  455 */       x.d("remote report is disable!", new Object[0]);
/*  456 */       x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
/*      */       
/*  458 */       return;
/*      */     }
/*      */     
/*  461 */     if ((paramList == null) || (paramList.size() == 0)) {
/*  462 */       return;
/*      */     }
/*      */     try {
/*  465 */       paramBoolean3 = this.c.a ? paramBoolean3.s : paramBoolean3.t;
/*  466 */       String str = this.c.a ? StrategyBean.c : StrategyBean.a;
/*      */       
/*  468 */       int i = this.c.a ? 830 : 630;
/*      */       
/*      */ 
/*  471 */       com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();Object localObject2 = paramList; Object localObject1; x.d("enEXPPkg args == null!", new Object[0]); al localal; (localal = new al()).a = new ArrayList(); CrashDetailBean localCrashDetailBean; for (localObject2 = ((List)localObject2).iterator(); ((Iterator)localObject2).hasNext(); localal.a.add(a((Context)localObject1, localCrashDetailBean, locala))) { localCrashDetailBean = (CrashDetailBean)((Iterator)localObject2).next();
/*      */       }
/*  473 */       if ((localObject1 = ((localObject1 = this.b) == null) || (localObject2 == null) || (((List)localObject2).size() == 0) || (locala == null) ? null : localal) == null) {
/*  474 */         x.d("create eupPkg fail!", new Object[0]);
/*  475 */         return;
/*      */       }
/*      */       
/*  478 */       if ((localObject1 = com.tencent.bugly.proguard.a.a((k)localObject1)) == null) {
/*  479 */         x.d("send encode fail!", new Object[0]); return;
/*      */       }
/*      */       
/*      */       am localam;
/*  483 */       if ((localam = com.tencent.bugly.proguard.a.a(this.b, i, (byte[])localObject1)) == null) {
/*  484 */         x.d("request package is null.", new Object[0]);
/*  485 */         return;
/*      */       }
/*  487 */       paramList = new t()
/*      */       {
/*      */ 
/*      */ 
/*      */         public final void a(boolean paramAnonymousBoolean)
/*      */         {
/*      */ 
/*      */ 
/*  495 */           b.a(paramAnonymousBoolean, paramList);
/*      */         }
/*      */       };
/*  498 */       if (paramBoolean1) {
/*  499 */         this.c.a(a, localam, paramBoolean3, str, paramList, paramLong, paramBoolean2);
/*      */       }
/*      */       else {
/*  502 */         this.c.a(a, localam, paramBoolean3, str, paramList, false); return;
/*      */       }
/*      */     } catch (Throwable paramBoolean3) {
/*  505 */       x.e("req cr error %s", new Object[] { paramBoolean3.toString() });
/*  506 */       if (!x.b(paramBoolean3)) {
/*  507 */         paramBoolean3.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void a(boolean paramBoolean, List<CrashDetailBean> paramList)
/*      */   {
/*  520 */     if ((paramList != null) && (paramList.size() > 0)) {
/*  521 */       x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
/*  522 */       Object localObject1 = paramList.iterator();
/*  523 */       while (((Iterator)localObject1).hasNext()) {
/*  524 */         localObject2 = (CrashDetailBean)((Iterator)localObject1).next();
/*  525 */         x.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { ((CrashDetailBean)localObject2).c, Integer.valueOf(((CrashDetailBean)localObject2).l), Boolean.valueOf(((CrashDetailBean)localObject2).d), Boolean.valueOf(((CrashDetailBean)localObject2).j) });
/*      */         
/*      */ 
/*  528 */         localObject2.l += 1;
/*  529 */         ((CrashDetailBean)localObject2).d = paramBoolean;
/*  530 */         x.c("set uid:%s uc:%d re:%b me:%b", new Object[] { ((CrashDetailBean)localObject2).c, Integer.valueOf(((CrashDetailBean)localObject2).l), Boolean.valueOf(((CrashDetailBean)localObject2).d), Boolean.valueOf(((CrashDetailBean)localObject2).j) });
/*      */       }
/*      */       
/*  533 */       for (Object localObject2 = paramList.iterator(); ((Iterator)localObject2).hasNext();) { localObject1 = (CrashDetailBean)((Iterator)localObject2).next();
/*  534 */         c.a().a((CrashDetailBean)localObject1);
/*      */       }
/*  536 */       x.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
/*      */     }
/*  538 */     if (!paramBoolean) {
/*  539 */       x.b("[crash] upload fail.", new Object[0]);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public final void c(CrashDetailBean paramCrashDetailBean)
/*      */   {
/*  547 */     if (paramCrashDetailBean == null) {
/*  548 */       return;
/*      */     }
/*  550 */     if ((this.g == null) && (this.f == null)) {
/*  551 */       return;
/*      */     }
/*      */     try {
/*  554 */       x.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
/*      */       
/*      */       int i;
/*      */       
/*  558 */       switch (paramCrashDetailBean.b) {
/*      */       case 3: 
/*  560 */         i = 4;
/*  561 */         break;
/*      */       case 7: 
/*  563 */         i = 7;
/*  564 */         break;
/*      */       case 2: 
/*  566 */         i = 1;
/*  567 */         break;
/*      */       case 0: 
/*  569 */         i = 0;
/*  570 */         break;
/*      */       case 1: 
/*  572 */         i = 2;
/*  573 */         break;
/*      */       case 4: 
/*  575 */         i = 3;
/*  576 */         break;
/*      */       case 5: 
/*  578 */         i = 5;
/*  579 */         break;
/*      */       case 6: 
/*  581 */         i = 6;
/*  582 */         break;
/*      */       default: 
/*  584 */         return;
/*      */       }
/*      */       
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  596 */       Object localObject1 = null;
/*  597 */       if (this.f != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  602 */         if ((localObject2 = this.f.b()) != null)
/*      */         {
/*  604 */           (localObject1 = new HashMap(1)).put("userData", localObject2);
/*      */         }
/*  606 */       } else if (this.g != null) {
/*  607 */         localObject1 = this.g.onCrashHandleStart(i, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  612 */       if ((localObject1 != null) && (((Map)localObject1).size() > 0))
/*      */       {
/*      */ 
/*  615 */         paramCrashDetailBean.N = new LinkedHashMap(((Map)localObject1).size());
/*  616 */         for (localObject2 = ((Map)localObject1).entrySet().iterator(); ((Iterator)localObject2).hasNext();) {
/*  617 */           if (!z.a((String)(localObject1 = (Map.Entry)((Iterator)localObject2).next()).getKey()))
/*      */           {
/*      */             String str;
/*      */             
/*      */ 
/*  622 */             if ((str = (String)((Map.Entry)localObject1).getKey()).length() > 100)
/*      */             {
/*  624 */               str = str.substring(0, 100);
/*  625 */               x.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), str });
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*  630 */             if ((!z.a((String)((Map.Entry)localObject1).getValue())) && (((String)((Map.Entry)localObject1).getValue()).length() > 30000))
/*      */             {
/*  632 */               localObject1 = ((String)((Map.Entry)localObject1).getValue()).substring(((String)((Map.Entry)localObject1).getValue()).length() - 30000);
/*      */               
/*  634 */               x.d("setted %s value length is over limit %d substring", new Object[] { str, Integer.valueOf(30000) });
/*      */             }
/*      */             else {
/*  637 */               localObject1 = (String)((Map.Entry)localObject1).getValue();
/*      */             }
/*      */             
/*  640 */             paramCrashDetailBean.N.put(str, localObject1);
/*  641 */             x.a("add setted key %s value size:%d", new Object[] { str, Integer.valueOf(((String)localObject1).length()) });
/*      */           }
/*      */         }
/*      */       }
/*  645 */       x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
/*      */       
/*      */ 
/*  648 */       Object localObject2 = null;
/*      */       
/*  650 */       if (this.f != null) {
/*  651 */         localObject2 = this.f.a();
/*      */       }
/*  653 */       else if (this.g != null) {
/*  654 */         localObject2 = this.g.onCrashHandleStart2GetExtraDatas(i, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
/*      */       }
/*      */       
/*  657 */       paramCrashDetailBean.S = ((byte[])localObject2);
/*  658 */       if (paramCrashDetailBean.S != null) {
/*  659 */         if (paramCrashDetailBean.S.length > 30000) {
/*  660 */           x.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(paramCrashDetailBean.S.length), Integer.valueOf(30000) });
/*      */         }
/*      */         
/*      */ 
/*  664 */         x.a("add extra bytes %d ", new Object[] { Integer.valueOf(paramCrashDetailBean.S.length) });
/*      */       }
/*      */       return;
/*  667 */     } catch (Throwable localThrowable) { x.d("crash handle callback somthing wrong! %s", new Object[] { localThrowable.getClass().getName() });
/*  668 */       if (!x.a(localThrowable)) {
/*  669 */         localThrowable.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static ContentValues e(CrashDetailBean paramCrashDetailBean)
/*      */   {
/*  679 */     if (paramCrashDetailBean == null) {
/*  680 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  684 */       localObject = new ContentValues();
/*  685 */       if (paramCrashDetailBean.a > 0L) {
/*  686 */         ((ContentValues)localObject).put("_id", Long.valueOf(paramCrashDetailBean.a));
/*      */       }
/*  688 */       ((ContentValues)localObject).put("_tm", Long.valueOf(paramCrashDetailBean.r));
/*  689 */       ((ContentValues)localObject).put("_s1", paramCrashDetailBean.u);
/*  690 */       ((ContentValues)localObject).put("_up", Integer.valueOf(paramCrashDetailBean.d ? 1 : 0));
/*  691 */       ((ContentValues)localObject).put("_me", Integer.valueOf(paramCrashDetailBean.j ? 1 : 0));
/*  692 */       ((ContentValues)localObject).put("_uc", Integer.valueOf(paramCrashDetailBean.l));
/*  693 */       ((ContentValues)localObject).put("_dt", z.a(paramCrashDetailBean));
/*  694 */       return (ContentValues)localObject;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  696 */       if (!x.a(localObject = localThrowable)) {
/*  697 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  700 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static CrashDetailBean a(Cursor paramCursor)
/*      */   {
/*  707 */     if (paramCursor == null) {
/*  708 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  712 */       if ((localObject = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"))) == null) {
/*  713 */         return null;
/*      */       }
/*  715 */       long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
/*      */       
/*  717 */       if ((paramCursor = (CrashDetailBean)z.a((byte[])localObject, CrashDetailBean.CREATOR)) != null) {
/*  718 */         paramCursor.a = l;
/*      */       }
/*  720 */       return paramCursor;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  722 */       if (!x.a(localObject = localThrowable)) {
/*  723 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  726 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public final void d(CrashDetailBean paramCrashDetailBean)
/*      */   {
/*  733 */     if (paramCrashDetailBean == null) {
/*      */       return;
/*      */     }
/*      */     ContentValues localContentValues;
/*  737 */     if ((localContentValues = e(paramCrashDetailBean)) != null) {
/*      */       long l;
/*  739 */       if ((l = p.a().a("t_cr", localContentValues, null, true)) >= 0L) {
/*  740 */         x.c("insert %s success!", new Object[] { "t_cr" });
/*  741 */         paramCrashDetailBean.a = l;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private List<CrashDetailBean> b(List<a> paramList)
/*      */   {
/*  753 */     if ((paramList == null) || (paramList.size() == 0)) {
/*  754 */       return null;
/*      */     }
/*      */     
/*  757 */     StringBuilder localStringBuilder = new StringBuilder();
/*  758 */     for (paramList = paramList.iterator(); paramList.hasNext();) { localObject1 = (a)paramList.next();
/*  759 */       localStringBuilder.append(" or _id").append(" = ").append(((a)localObject1).a);
/*      */     }
/*      */     
/*      */ 
/*  763 */     if ((paramList = localStringBuilder.toString()).length() > 0) {
/*  764 */       paramList = paramList.substring(4);
/*      */     }
/*  766 */     localStringBuilder.setLength(0);
/*      */     
/*  768 */     Object localObject1 = null;
/*      */     
/*      */     try
/*      */     {
/*  772 */       if ((localObject1 = p.a().a("t_cr", null, paramList, null, null, true)) == null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  807 */         return null;
/*      */       }
/*  776 */       localObject2 = new ArrayList();
/*  777 */       while (((Cursor)localObject1).moveToNext())
/*      */       {
/*  779 */         if ((paramList = a((Cursor)localObject1)) != null) {
/*  780 */           ((List)localObject2).add(paramList);
/*      */         } else {
/*      */           try
/*      */           {
/*  784 */             long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("_id"));
/*  785 */             localStringBuilder.append(" or _id").append(" = ").append(l);
/*      */           } catch (Throwable localThrowable1) {
/*  787 */             x.d("unknown id!", new Object[0]);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  794 */       if ((paramList = localStringBuilder.toString()).length() > 0) {
/*  795 */         paramList = paramList.substring(4);
/*  796 */         paramList = p.a().a("t_cr", paramList, null, null, true);
/*      */         
/*  798 */         x.d("deleted %s illegle data %d", new Object[] { "t_cr", Integer.valueOf(paramList) });
/*      */       }
/*  800 */       return (List<a>)localObject2;
/*      */     } catch (Throwable localThrowable2) {
/*      */       Object localObject2;
/*  803 */       ((Throwable)localObject2).printStackTrace();
/*      */     }
/*      */     finally {
/*  806 */       if (localObject1 != null) {
/*  807 */         ((Cursor)localObject1).close();
/*      */       }
/*      */     }
/*      */     
/*  811 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static a b(Cursor paramCursor)
/*      */   {
/*  818 */     if (paramCursor == null) {
/*  819 */       return null;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  824 */       (localObject = new a()).a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
/*  825 */       ((a)localObject).b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
/*  826 */       ((a)localObject).c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
/*  827 */       ((a)localObject).d = (paramCursor.getInt(paramCursor.getColumnIndex("_up")) == 1);
/*      */       
/*  829 */       ((a)localObject).e = (paramCursor.getInt(paramCursor.getColumnIndex("_me")) == 1);
/*      */       
/*  831 */       ((a)localObject).f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
/*  832 */       return (a)localObject;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  834 */       if (!x.a(localObject = localThrowable)) {
/*  835 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  838 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private List<a> b()
/*      */   {
/*  845 */     Cursor localCursor = null;
/*  846 */     ArrayList localArrayList1 = new ArrayList();
/*      */     try {
/*  848 */       localObject1 = new String[] { "_id", "_tm", "_s1", "_up", "_me", "_uc" };
/*      */       
/*      */ 
/*      */ 
/*  852 */       if ((localCursor = p.a().a("t_cr", (String[])localObject1, null, null, null, true)) == null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  886 */         return null;
/*      */       }
/*  855 */       localObject1 = new StringBuilder();
/*  856 */       Object localObject2; while (localCursor.moveToNext())
/*      */       {
/*  858 */         if ((localObject2 = b(localCursor)) != null) {
/*  859 */           localArrayList1.add(localObject2);
/*      */         } else {
/*      */           try
/*      */           {
/*  863 */             long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
/*  864 */             ((StringBuilder)localObject1).append(" or _id").append(" = ").append(l);
/*      */           } catch (Throwable localThrowable1) {
/*  866 */             x.d("unknown id!", new Object[0]);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  873 */       if ((localObject2 = ((StringBuilder)localObject1).toString()).length() > 0) {
/*  874 */         localObject2 = ((String)localObject2).substring(4);
/*  875 */         int i = p.a().a("t_cr", (String)localObject2, null, null, true);
/*      */         
/*  877 */         x.d("deleted %s illegle data %d", new Object[] { "t_cr", Integer.valueOf(i) });
/*      */       }
/*  879 */       return localArrayList1;
/*      */     } catch (Throwable localThrowable2) {
/*      */       Object localObject1;
/*  882 */       ((Throwable)localObject1).printStackTrace();
/*      */     }
/*      */     finally {
/*  885 */       if (localCursor != null) {
/*  886 */         localCursor.close();
/*      */       }
/*      */     }
/*      */     
/*  890 */     return localList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void c(List<a> paramList)
/*      */   {
/*  897 */     if ((paramList == null) || (paramList.size() == 0)) {
/*  898 */       return;
/*      */     }
/*      */     
/*  901 */     StringBuilder localStringBuilder = new StringBuilder();
/*  902 */     for (a locala : paramList) {
/*  903 */       localStringBuilder.append(" or _id").append(" = ").append(locala.a);
/*      */     }
/*      */     
/*      */ 
/*  907 */     if ((paramList = localStringBuilder.toString()).length() > 0) {
/*  908 */       paramList = paramList.substring(4);
/*      */     }
/*  910 */     localStringBuilder.setLength(0);
/*      */     try {
/*  912 */       int i = p.a().a("t_cr", paramList, null, null, true);
/*      */       
/*  914 */       x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(i) }); return;
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*  916 */       if (!x.a(localThrowable1 = 
/*      */       
/*      */ 
/*  919 */         localThrowable2)) {
/*  917 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void d(List<CrashDetailBean> paramList)
/*      */   {
/*      */     try
/*      */     {
/*  927 */       if ((paramList == null) || (paramList.size() == 0)) {
/*  928 */         return;
/*      */       }
/*      */       
/*  931 */       localObject = new StringBuilder();
/*  932 */       for (CrashDetailBean localCrashDetailBean : paramList) {
/*  933 */         ((StringBuilder)localObject).append(" or _id").append(" = ").append(localCrashDetailBean.a);
/*      */       }
/*      */       
/*      */ 
/*  937 */       if ((paramList = ((StringBuilder)localObject).toString()).length() > 0) {
/*  938 */         paramList = paramList.substring(4);
/*      */       }
/*  940 */       ((StringBuilder)localObject).setLength(0);
/*  941 */       int i = p.a().a("t_cr", paramList, null, null, true);
/*      */       
/*  943 */       x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(i) }); return;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  945 */       if (!x.a(localObject = 
/*      */       
/*      */ 
/*  948 */         localThrowable)) {
/*  946 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static ak a(Context paramContext, CrashDetailBean paramCrashDetailBean, com.tencent.bugly.crashreport.common.info.a parama)
/*      */   {
/*  956 */     if ((paramContext == null) || (paramCrashDetailBean == null) || (parama == null)) {
/*  957 */       x.d("enExp args == null", new Object[0]);
/*  958 */       return null;
/*      */     }
/*  960 */     ak localak = new ak();
/*  961 */     switch (paramCrashDetailBean.b) {
/*      */     case 3: 
/*  963 */       localak.a = (paramCrashDetailBean.j ? "203" : "103");
/*      */       
/*  965 */       break;
/*      */     case 7: 
/*  967 */       localak.a = (paramCrashDetailBean.j ? "208" : "108");
/*      */       
/*  969 */       break;
/*      */     
/*      */     case 0: 
/*  972 */       localak.a = (paramCrashDetailBean.j ? "200" : "100");
/*      */       
/*  974 */       break;
/*      */     case 1: 
/*  976 */       localak.a = (paramCrashDetailBean.j ? "201" : "101");
/*      */       
/*      */ 
/*  979 */       break;
/*      */     case 2: 
/*  981 */       localak.a = (paramCrashDetailBean.j ? "202" : "102");
/*      */       
/*      */ 
/*  984 */       break;
/*      */     case 4: 
/*  986 */       localak.a = (paramCrashDetailBean.j ? "204" : "104");
/*  987 */       break;
/*      */     
/*      */     case 6: 
/*  990 */       localak.a = (paramCrashDetailBean.j ? "206" : "106");
/*      */       
/*  992 */       break;
/*      */     
/*      */     case 5: 
/*  995 */       localak.a = (paramCrashDetailBean.j ? "207" : "107");
/*      */       
/*  997 */       break;
/*      */     
/*      */     default: 
/* 1000 */       x.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
/*      */     }
/*      */     
/*      */     
/* 1004 */     localak.b = paramCrashDetailBean.r;
/* 1005 */     localak.c = paramCrashDetailBean.n;
/* 1006 */     localak.d = paramCrashDetailBean.o;
/* 1007 */     localak.e = paramCrashDetailBean.p;
/* 1008 */     localak.g = paramCrashDetailBean.q;
/* 1009 */     localak.h = paramCrashDetailBean.y;
/* 1010 */     localak.i = paramCrashDetailBean.c;
/* 1011 */     localak.j = null;
/* 1012 */     localak.l = paramCrashDetailBean.m;
/* 1013 */     localak.m = paramCrashDetailBean.e;
/* 1014 */     localak.f = paramCrashDetailBean.A;
/* 1015 */     localak.t = com.tencent.bugly.crashreport.common.info.a.b().i();
/*      */     
/* 1017 */     localak.n = null;
/* 1018 */     Object localObject1; if ((paramCrashDetailBean.i != null) && (paramCrashDetailBean.i.size() > 0)) {
/* 1019 */       localak.o = new ArrayList();
/* 1020 */       for (localObject1 = paramCrashDetailBean.i.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*      */         
/* 1022 */         (localObject3 = new ah()).a = ((PlugInBean)((Map.Entry)localObject2).getValue()).a;
/* 1023 */         ((ah)localObject3).c = ((PlugInBean)((Map.Entry)localObject2).getValue()).c;
/* 1024 */         ((ah)localObject3).d = ((PlugInBean)((Map.Entry)localObject2).getValue()).b;
/* 1025 */         ((ah)localObject3).b = parama.r();
/* 1026 */         localak.o.add(localObject3);
/*      */       } }
/*      */     Object localObject2;
/*      */     Object localObject3;
/* 1030 */     if ((paramCrashDetailBean.h != null) && (paramCrashDetailBean.h.size() > 0)) {
/* 1031 */       localak.p = new ArrayList();
/* 1032 */       for (localObject1 = paramCrashDetailBean.h.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*      */         
/* 1034 */         (localObject3 = new ah()).a = ((PlugInBean)((Map.Entry)localObject2).getValue()).a;
/* 1035 */         ((ah)localObject3).c = ((PlugInBean)((Map.Entry)localObject2).getValue()).c;
/* 1036 */         ((ah)localObject3).d = ((PlugInBean)((Map.Entry)localObject2).getValue()).b;
/* 1037 */         localak.p.add(localObject3);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1042 */     if (paramCrashDetailBean.j) {
/* 1043 */       localak.k = paramCrashDetailBean.t;
/* 1044 */       if ((paramCrashDetailBean.s != null) && (paramCrashDetailBean.s.length() > 0)) {
/* 1045 */         if (localak.q == null) {
/* 1046 */           localak.q = new ArrayList();
/*      */         }
/*      */         try
/*      */         {
/* 1050 */           localak.q.add(new aj((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
/*      */         }
/*      */         catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
/* 1053 */           (localObject1 = 
/*      */           
/* 1055 */             localUnsupportedEncodingException1).printStackTrace();localak.q = null;
/*      */         }
/*      */       }
/*      */       
/* 1058 */       x.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(localak.k), Integer.valueOf(localak.q != null ? localak.q.size() : 0) });
/*      */     }
/*      */     
/*      */ 
/* 1062 */     if (paramCrashDetailBean.w != null) {
/* 1063 */       if (localak.q == null) {
/* 1064 */         localak.q = new ArrayList();
/*      */       }
/*      */       try {
/* 1067 */         localak.q.add(new aj((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8")));
/*      */       }
/*      */       catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
/* 1070 */         (localObject1 = 
/*      */         
/* 1072 */           localUnsupportedEncodingException2).printStackTrace();localak.q = null;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1076 */     if (!z.a(paramCrashDetailBean.T)) {
/* 1077 */       if (localak.q == null) {
/* 1078 */         localak.q = new ArrayList();
/*      */       }
/* 1080 */       localObject1 = null;
/*      */       try {
/* 1082 */         localObject1 = new aj((byte)1, "crashInfos.txt", paramCrashDetailBean.T.getBytes("utf-8"));
/*      */       }
/*      */       catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
/* 1085 */         (localObject2 = 
/* 1086 */           localUnsupportedEncodingException3).printStackTrace();
/*      */       }
/* 1087 */       if (localObject1 != null) {
/* 1088 */         x.c("attach crash infos", new Object[0]);
/* 1089 */         localak.q.add(localObject1);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1094 */     if (paramCrashDetailBean.U != null) {
/* 1095 */       if (localak.q == null) {
/* 1096 */         localak.q = new ArrayList();
/*      */       }
/*      */       
/*      */ 
/* 1100 */       if ((localObject1 = a("backupRecord.zip", paramContext, paramCrashDetailBean.U)) != null) {
/* 1101 */         x.c("attach backup record", new Object[0]);
/* 1102 */         localak.q.add(localObject1);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1107 */     if ((paramCrashDetailBean.x != null) && (paramCrashDetailBean.x.length > 0))
/*      */     {
/* 1109 */       localObject1 = new aj((byte)2, "buglylog.zip", paramCrashDetailBean.x);
/*      */       
/* 1111 */       x.c("attach user log", new Object[0]);
/*      */       
/* 1113 */       if (localak.q == null) {
/* 1114 */         localak.q = new ArrayList();
/*      */       }
/* 1116 */       localak.q.add(localObject1);
/*      */     }
/*      */     
/*      */ 
/* 1120 */     if (paramCrashDetailBean.b == 3) {
/* 1121 */       if (localak.q == null) {
/* 1122 */         localak.q = new ArrayList();
/*      */       }
/*      */       
/* 1125 */       if ((paramCrashDetailBean.N != null) && (paramCrashDetailBean.N.containsKey("BUGLY_CR_01")))
/*      */       {
/*      */         try
/*      */         {
/* 1129 */           localak.q.add(new aj((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.N.get("BUGLY_CR_01")).getBytes("utf-8")));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1134 */           x.c("attach anr message", new Object[0]);
/*      */         } catch (UnsupportedEncodingException localUnsupportedEncodingException4) {
/* 1136 */           (localObject1 = 
/*      */           
/* 1138 */             localUnsupportedEncodingException4).printStackTrace();localak.q = null;
/*      */         }
/* 1139 */         paramCrashDetailBean.N.remove("BUGLY_CR_01");
/*      */       }
/*      */       
/*      */ 
/* 1143 */       if (paramCrashDetailBean.v != null)
/*      */       {
/*      */ 
/* 1146 */         if ((localObject1 = a("trace.zip", paramContext, paramCrashDetailBean.v)) != null) {
/* 1147 */           x.c("attach traces", new Object[0]);
/* 1148 */           localak.q.add(localObject1);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1153 */     if (paramCrashDetailBean.b == 1) {
/* 1154 */       if (localak.q == null) {
/* 1155 */         localak.q = new ArrayList();
/*      */       }
/*      */       
/* 1158 */       if (paramCrashDetailBean.v != null)
/*      */       {
/*      */ 
/* 1161 */         if ((localObject1 = a("tomb.zip", paramContext, paramCrashDetailBean.v)) != null) {
/* 1162 */           x.c("attach tombs", new Object[0]);
/* 1163 */           localak.q.add(localObject1);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1168 */     if ((parama.C != null) && (!parama.C.isEmpty())) {
/* 1169 */       if (localak.q == null) {
/* 1170 */         localak.q = new ArrayList();
/*      */       }
/* 1172 */       localObject1 = new StringBuilder();
/* 1173 */       for (localObject2 = parama.C.iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (String)((Iterator)localObject2).next();
/* 1174 */         ((StringBuilder)localObject1).append((String)localObject3);
/*      */       }
/*      */       try {
/* 1177 */         localak.q.add(new aj((byte)1, "martianlog.txt", ((StringBuilder)localObject1).toString().getBytes("utf-8")));
/*      */         
/* 1179 */         x.c("attach pageTracingList", new Object[0]);
/*      */       } catch (UnsupportedEncodingException localUnsupportedEncodingException5) {
/* 1181 */         (localObject2 = 
/* 1182 */           localUnsupportedEncodingException5).printStackTrace();
/*      */       }
/*      */     }
/*      */     
/* 1185 */     if ((paramCrashDetailBean.S != null) && (paramCrashDetailBean.S.length > 0)) {
/* 1186 */       if (localak.q == null) {
/* 1187 */         localak.q = new ArrayList();
/*      */       }
/*      */       
/* 1190 */       localak.q.add(new aj((byte)1, "userExtraByteData", paramCrashDetailBean.S));
/*      */       
/* 1192 */       x.c("attach extraData", new Object[0]);
/*      */     }
/*      */     
/* 1195 */     localak.r = new HashMap();
/* 1196 */     localak.r.put("A9", paramCrashDetailBean.B);
/* 1197 */     localak.r.put("A11", paramCrashDetailBean.C);
/* 1198 */     localak.r.put("A10", paramCrashDetailBean.D);
/* 1199 */     localak.r.put("A23", paramCrashDetailBean.f);
/* 1200 */     localak.r.put("A7", parama.f);
/* 1201 */     localak.r.put("A6", parama.s());
/* 1202 */     localak.r.put("A5", parama.r());
/* 1203 */     localak.r.put("A22", parama.h());
/* 1204 */     localak.r.put("A2", paramCrashDetailBean.F);
/* 1205 */     localak.r.put("A1", paramCrashDetailBean.E);
/* 1206 */     localak.r.put("A24", parama.h);
/* 1207 */     localak.r.put("A17", paramCrashDetailBean.G);
/* 1208 */     localak.r.put("A3", parama.k());
/* 1209 */     localak.r.put("A16", parama.m());
/* 1210 */     localak.r.put("A25", parama.n());
/* 1211 */     localak.r.put("A14", parama.l());
/* 1212 */     localak.r.put("A15", parama.w());
/* 1213 */     localak.r.put("A13", parama.x());
/* 1214 */     localak.r.put("A34", paramCrashDetailBean.z);
/*      */     
/* 1216 */     if (parama.x != null) {
/* 1217 */       localak.r.put("productIdentify", parama.x);
/*      */     }
/*      */     try
/*      */     {
/* 1221 */       localak.r.put("A26", URLEncoder.encode(paramCrashDetailBean.H, "utf-8"));
/*      */     }
/*      */     catch (UnsupportedEncodingException localUnsupportedEncodingException6) {
/* 1224 */       (localObject1 = 
/* 1225 */         localUnsupportedEncodingException6).printStackTrace();
/*      */     }
/* 1226 */     if (paramCrashDetailBean.b == 1) {
/* 1227 */       localak.r.put("A27", paramCrashDetailBean.J);
/* 1228 */       localak.r.put("A28", paramCrashDetailBean.I);
/* 1229 */       localak.r.put("A29", paramCrashDetailBean.k);
/*      */     }
/* 1231 */     localak.r.put("A30", paramCrashDetailBean.K);
/* 1232 */     localak.r.put("A18", paramCrashDetailBean.L);
/*      */     
/*      */ 
/* 1235 */     localak.r.put("A36", !paramCrashDetailBean.M);
/*      */     
/* 1237 */     localak.r.put("F02", parama.q);
/*      */     
/* 1239 */     localak.r.put("F03", parama.r);
/*      */     
/* 1241 */     localak.r.put("F04", parama.e());
/*      */     
/* 1243 */     localak.r.put("F05", parama.s);
/*      */     
/* 1245 */     localak.r.put("F06", parama.p);
/*      */     
/*      */ 
/*      */ 
/* 1249 */     localak.r.put("F08", parama.v);
/*      */     
/* 1251 */     localak.r.put("F09", parama.w);
/*      */     
/* 1253 */     localak.r.put("F10", parama.t);
/*      */     
/*      */ 
/* 1256 */     if (paramCrashDetailBean.O >= 0) {
/* 1257 */       localak.r.put("C01", paramCrashDetailBean.O);
/*      */     }
/*      */     
/* 1260 */     if (paramCrashDetailBean.P >= 0) {
/* 1261 */       localak.r.put("C02", paramCrashDetailBean.P);
/*      */     }
/*      */     
/* 1264 */     if ((paramCrashDetailBean.Q != null) && (paramCrashDetailBean.Q.size() > 0)) {
/* 1265 */       for (localObject1 = paramCrashDetailBean.Q.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 1266 */         localak.r.put("C03_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
/*      */       }
/*      */     }
/*      */     
/* 1270 */     if ((paramCrashDetailBean.R != null) && (paramCrashDetailBean.R.size() > 0)) {
/* 1271 */       for (localObject1 = paramCrashDetailBean.R.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 1272 */         localak.r.put("C04_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1278 */     localak.s = null;
/* 1279 */     if ((paramCrashDetailBean.N != null) && (paramCrashDetailBean.N.size() > 0)) {
/* 1280 */       localak.s = paramCrashDetailBean.N;
/* 1281 */       x.a("setted message size %d", new Object[] { Integer.valueOf(localak.s.size()) });
/*      */     }
/* 1283 */     x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { paramCrashDetailBean.n, paramCrashDetailBean.c, parama.e(), Long.valueOf((paramCrashDetailBean.r - paramCrashDetailBean.L) / 1000L), Boolean.valueOf(paramCrashDetailBean.k), Boolean.valueOf(paramCrashDetailBean.M), Boolean.valueOf(paramCrashDetailBean.j), Boolean.valueOf(paramCrashDetailBean.b == 1 ? 1 : false), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(localak.r.size()) });
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1289 */     return localak;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static aj a(String paramString1, Context paramContext, String paramString2)
/*      */   {
/* 1316 */     if ((paramString2 == null) || (paramContext == null)) {
/* 1317 */       x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
/*      */       
/* 1319 */       return null;
/*      */     }
/*      */     
/* 1322 */     x.c("zip %s", new Object[] { paramString2 });
/* 1323 */     paramString2 = new File(paramString2);
/* 1324 */     paramString1 = new File(paramContext.getCacheDir(), paramString1);
/*      */     
/* 1326 */     if (!z.a(paramString2, paramString1, 5000)) {
/* 1327 */       x.d("zip fail!", new Object[0]);
/* 1328 */       return null;
/*      */     }
/*      */     
/* 1331 */     paramContext = new ByteArrayOutputStream();
/* 1332 */     paramString2 = null;
/*      */     try {
/* 1334 */       paramString2 = new FileInputStream(paramString1);
/* 1335 */       localObject1 = new byte['က'];
/* 1336 */       int i = 0;
/* 1337 */       while ((i = paramString2.read((byte[])localObject1)) > 0) {
/* 1338 */         paramContext.write((byte[])localObject1, 0, i);
/* 1339 */         paramContext.flush();
/*      */       }
/* 1341 */       localObject1 = paramContext.toByteArray();
/* 1342 */       x.c("read bytes :%d", new Object[] { Integer.valueOf(localObject1.length) });
/*      */       
/*      */ 
/*      */ 
/* 1346 */       paramContext = paramContext = new aj((byte)2, paramString1.getName(), (byte[])localObject1);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */       try
/*      */       {
/* 1353 */         paramString2.close();
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/* 1357 */         if (!x.a(paramString2 = 
/*      */         
/*      */ 
/* 1360 */           localIOException1)) {
/* 1358 */           paramString2.printStackTrace();
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1363 */       if (paramString1.exists()) {
/* 1364 */         x.c("del tmp", new Object[0]);
/* 1365 */         paramString1.delete(); } return paramContext;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*      */       Object localObject1;
/* 1349 */       ((Throwable)localObject1).printStackTrace();
/*      */       
/* 1351 */       Object localObject2 = null;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1365 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/* 1353 */       if (paramString2 != null) {
/*      */         try {
/* 1355 */           paramString2.close();
/*      */         } catch (IOException localIOException3) {
/* 1357 */           if (!x.a(paramString2 = 
/*      */           
/*      */ 
/* 1360 */             localIOException3)) {
/* 1358 */             paramString2.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 1363 */       if (paramString1.exists()) {
/* 1364 */         x.c("del tmp", new Object[0]);
/* 1365 */         paramString1.delete();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void a(String paramString1, String paramString2, String paramString3, Thread paramThread, String paramString4, CrashDetailBean paramCrashDetailBean)
/*      */   {
/*      */     com.tencent.bugly.crashreport.common.info.a locala;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1469 */     if ((locala = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
/* 1470 */       return;
/*      */     }
/* 1472 */     x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
/* 1473 */     x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
/* 1474 */     x.e("# PKG NAME: %s", new Object[] { locala.c });
/* 1475 */     x.e("# APP VER: %s", new Object[] { locala.j });
/* 1476 */     x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)) });
/*      */     
/* 1478 */     x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
/* 1479 */     x.e("# CRASH TIME: %s", new Object[] { paramString2 });
/* 1480 */     x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
/* 1481 */     if (paramThread != null) {
/* 1482 */       x.e("# CRASH THREAD: %s", new Object[] { paramThread.getName() });
/*      */     }
/* 1484 */     if (paramCrashDetailBean != null) {
/* 1485 */       x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
/* 1486 */       x.e("# CRASH DEVICE: %s %s", new Object[] { locala.g, locala.x().booleanValue() ? "ROOTED" : "UNROOT" });
/*      */       
/* 1488 */       x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.B), Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D) });
/*      */       
/* 1490 */       x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.E), Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G) });
/*      */       
/* 1492 */       if (!z.a(paramCrashDetailBean.J)) {
/* 1493 */         x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.J, paramCrashDetailBean.I });
/*      */       }
/* 1495 */       else if (paramCrashDetailBean.b == 3) {
/* 1496 */         x.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { (String)paramCrashDetailBean.N.get("BUGLY_CR_01") });
/*      */       }
/*      */     }
/*      */     
/* 1500 */     if (!z.a(paramString4)) {
/* 1501 */       x.e("# CRASH STACK: ", new Object[0]);
/* 1502 */       x.e(paramString4, new Object[0]);
/*      */     }
/* 1504 */     x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
/*      */   }
/*      */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */