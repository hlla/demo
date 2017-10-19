/*      */ package com.tencent.bugly.proguard;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.os.Process;
/*      */ import android.util.Base64;
/*      */ import com.tencent.bugly.b;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.LinkedBlockingQueue;
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
/*      */ 
/*      */ public final class u
/*      */ {
/*   65 */   private static u b = null;
/*      */   
/*      */   private final p c;
/*      */   
/*      */   private final Context d;
/*      */   
/*   71 */   private Map<Integer, Long> e = new HashMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private long f;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private long g;
/*      */   
/*      */ 
/*      */ 
/*   85 */   private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
/*      */   
/*      */ 
/*      */ 
/*   89 */   private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
/*      */   
/*      */ 
/*   92 */   private final Object j = new Object();
/*      */   
/*      */ 
/*   95 */   private String k = null;
/*      */   
/*   97 */   private byte[] l = null;
/*      */   
/*      */ 
/*  100 */   private long m = 0L;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  106 */   private byte[] n = null;
/*      */   
/*  108 */   private long o = 0L;
/*      */   
/*  110 */   private String p = null;
/*      */   
/*  112 */   private long q = 0L;
/*      */   
/*      */ 
/*  115 */   private final Object r = new Object();
/*      */   
/*      */ 
/*  118 */   private boolean s = false;
/*      */   
/*  120 */   private final Object t = new Object();
/*      */   
/*  122 */   public boolean a = true;
/*      */   
/*      */ 
/*  125 */   private int u = 0;
/*      */   
/*      */   private u(Context paramContext) {
/*  128 */     this.d = paramContext;
/*  129 */     this.c = p.a();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     try
/*      */     {
/*  137 */       Class.forName("android.util.Base64");
/*      */     } catch (ClassNotFoundException localClassNotFoundException) {
/*  139 */       x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
/*      */       
/*  141 */       this.a = false;
/*      */     }
/*      */     
/*  144 */     if (this.a)
/*      */     {
/*  146 */       (paramContext = new StringBuilder()).append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/").append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
/*      */       
/*      */ 
/*      */ 
/*  150 */       this.k = paramContext.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static synchronized u a(Context paramContext)
/*      */   {
/*  158 */     if (b == null) {
/*  159 */       b = new u(paramContext);
/*      */     }
/*  161 */     return b;
/*      */   }
/*      */   
/*      */   public static synchronized u a() {
/*  165 */     return b;
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
/*      */   public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean)
/*      */   {
/*  207 */     boolean paramBoolean = paramBoolean;long l1 = paramLong;??? = paramt;paramLong = paramString2;paramt = paramString1;paramString2 = a.a(paramam);paramString1 = paramam.g;paramam = paramInt;paramInt = this; try { paramam = new v(paramInt.d, paramam, paramString1, paramString2, paramt, paramLong, ???, paramInt.a, paramBoolean);paramInt.a(paramam, true, true, l1);return; } catch (Throwable localThrowable) { if (!x.a(paramam = localThrowable)) { paramam.printStackTrace();
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
/*      */   public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap)
/*      */   {
/*      */     try
/*      */     {
/*  228 */       paramInt1 = new v(this.d, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramt, this.a, paramInt3, paramInt4, false, paramMap);
/*      */       
/*      */ 
/*  231 */       a(paramInt1, paramBoolean, false, 0L); return;
/*      */     } catch (Throwable localThrowable) {
/*  233 */       if (!x.a(paramInt1 = 
/*      */       
/*      */ 
/*  236 */         localThrowable)) {
/*  234 */         paramInt1.printStackTrace();
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
/*      */   public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, boolean paramBoolean)
/*      */   {
/*  269 */     a(paramInt, paramam.g, a.a(paramam), paramString1, paramString2, paramt, 0, 0, paramBoolean, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final long a(boolean paramBoolean)
/*      */   {
/*  279 */     long l1 = 0L;
/*  280 */     long l2 = z.b();
/*  281 */     int i1 = paramBoolean ? 5 : 3;
/*      */     
/*      */     List localList;
/*  284 */     if (((localList = this.c.a(i1)) != null) && (localList.size() > 0))
/*      */     {
/*      */       try {
/*  287 */         if ((paramBoolean = (r)localList.get(0)).e >= l2) {
/*  288 */           l1 = z.c(paramBoolean.g);
/*  289 */           if (i1 == 3) {
/*  290 */             this.f = l1;
/*      */           } else {
/*  292 */             this.g = l1;
/*      */           }
/*  294 */           localList.remove(paramBoolean);
/*      */         }
/*      */       } catch (Throwable localThrowable) {
/*  297 */         x.a(paramBoolean = 
/*  298 */           localThrowable); }
/*  299 */       if (localList.size() > 0) {
/*  300 */         this.c.a(localList);
/*      */       }
/*      */     } else {
/*  303 */       l1 = paramBoolean ? this.g : this.f;
/*      */     }
/*  305 */     x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l1 / 1024L) });
/*  306 */     return l1;
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
/*      */   protected final synchronized void a(long paramLong, boolean paramBoolean)
/*      */   {
/*  344 */     int i1 = paramBoolean ? 5 : 3;
/*      */     
/*      */     r localr;
/*  347 */     (localr = new r()).b = i1;
/*  348 */     localr.e = z.b();
/*  349 */     localr.c = "";
/*  350 */     localr.d = "";
/*  351 */     localr.g = z.c(paramLong);
/*  352 */     this.c.b(i1);
/*  353 */     this.c.a(localr);
/*  354 */     if (paramBoolean) {
/*  355 */       this.g = paramLong;
/*      */     } else {
/*  357 */       this.f = paramLong;
/*      */     }
/*  359 */     x.c("[UploadManager] Network total consume: %d KB", new Object[] { Long.valueOf(paramLong / 1024L) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public final synchronized void a(int paramInt, long paramLong)
/*      */   {
/*  366 */     if (paramInt >= 0) {
/*  367 */       this.e.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
/*      */       r localr;
/*  369 */       (localr = new r()).b = paramInt;
/*  370 */       localr.e = paramLong;
/*  371 */       localr.c = "";
/*  372 */       localr.d = "";
/*  373 */       localr.g = new byte[0];
/*  374 */       this.c.b(paramInt);
/*  375 */       this.c.a(localr);
/*  376 */       x.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), z.a(paramLong) });
/*      */       
/*  378 */       return; }
/*  379 */     x.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public final synchronized long a(int paramInt)
/*      */   {
/*  387 */     long l1 = 0L;
/*  388 */     if (paramInt >= 0) {
/*      */       Object localObject;
/*  390 */       if ((localObject = (Long)this.e.get(Integer.valueOf(paramInt))) != null) {
/*  391 */         return ((Long)localObject).longValue();
/*      */       }
/*      */       
/*  394 */       if (((localObject = this.c.a(paramInt)) != null) && (((List)localObject).size() > 0))
/*  395 */         if (((List)localObject).size() > 1)
/*      */         {
/*  397 */           for (localObject = ((List)localObject).iterator(); ((Iterator)localObject).hasNext();) { r localr;
/*  398 */             if ((localr = (r)((Iterator)localObject).next()).e > l1) {
/*  399 */               l1 = localr.e;
/*      */             }
/*      */           }
/*  402 */           this.c.b(paramInt);
/*      */         }
/*      */         else {
/*      */           try {
/*  406 */             l1 = (localObject = (r)((List)localObject).get(0)).e;
/*      */           } catch (Throwable localThrowable) {
/*  408 */             x.a(localObject = 
/*  409 */               localThrowable);
/*      */           }
/*      */         }
/*      */     } else {
/*  413 */       x.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */     }
/*  415 */     return l1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final boolean b(int paramInt)
/*      */   {
/*  425 */     if (b.c) {
/*  426 */       x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
/*  427 */       return true;
/*      */     }
/*  429 */     long l1 = System.currentTimeMillis() - a(paramInt);
/*  430 */     x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l1 / 1000L), Integer.valueOf(paramInt) });
/*      */     
/*  432 */     if (l1 < 30000L) {
/*  433 */       x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
/*      */       
/*  435 */       return false;
/*      */     }
/*  437 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean c()
/*      */   {
/*  446 */     x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */     try
/*      */     {
/*  450 */       if ((localObject = p.a()) == null) {
/*  451 */         x.d("[UploadManager] Failed to get Database", new Object[0]);
/*  452 */         return false;
/*      */       }
/*      */       
/*  455 */       return ((p)localObject).a(555, "security_info", null, true);
/*      */     } catch (Throwable localThrowable) {
/*      */       Object localObject;
/*  458 */       x.a(localObject = localThrowable); }
/*  459 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean d()
/*      */   {
/*  469 */     x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */     try
/*      */     {
/*  473 */       if ((localObject = p.a()) == null) {
/*  474 */         x.d("[UploadManager] Failed to get database", new Object[0]);
/*  475 */         return false;
/*      */       }
/*  477 */       StringBuilder localStringBuilder = new StringBuilder();
/*      */       
/*  479 */       if (this.n != null) {
/*  480 */         localStringBuilder.append(Base64.encodeToString(this.n, 0));
/*      */       } else {
/*  482 */         x.c("[UploadManager] AES key is null, will not record", new Object[0]);
/*  483 */         return false;
/*      */       }
/*  485 */       localStringBuilder.append("#");
/*      */       
/*  487 */       if (this.o != 0L) {
/*  488 */         localStringBuilder.append(Long.toString(this.o));
/*      */       } else {
/*  490 */         localStringBuilder.append("null");
/*      */       }
/*  492 */       localStringBuilder.append("#");
/*      */       
/*  494 */       if (this.p != null) {
/*  495 */         localStringBuilder.append(this.p);
/*      */       } else {
/*  497 */         localStringBuilder.append("null");
/*      */       }
/*  499 */       localStringBuilder.append("#");
/*      */       
/*  501 */       if (this.q != 0L) {
/*  502 */         localStringBuilder.append(Long.toString(this.q));
/*      */       } else {
/*  504 */         localStringBuilder.append("null");
/*      */       }
/*  506 */       ((p)localObject).a(555, "security_info", localStringBuilder.toString().getBytes(), null, true);
/*      */       
/*  508 */       return true;
/*      */     } catch (Throwable localThrowable) {
/*      */       Object localObject;
/*  511 */       x.a(localObject = localThrowable);
/*      */       
/*  513 */       c(); }
/*  514 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean e()
/*      */   {
/*  524 */     x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */     try
/*      */     {
/*  528 */       if ((localObject = p.a()) == null) {
/*  529 */         x.d("[UploadManager] Failed to get database", new Object[0]);
/*  530 */         return false;
/*      */       }
/*  532 */       int i1 = 0;
/*  533 */       String str = null;
/*      */       
/*  535 */       if (((localObject = ((p)localObject).a(555, null, true)) != null) && (((Map)localObject).containsKey("security_info")))
/*      */       {
/*      */         int i4;
/*  538 */         if ((localObject = (str = new String((byte[])((Map)localObject).get("security_info"))).split("#")).length == 4) { int i2;
/*  539 */           if ((!localObject[0].isEmpty()) && (!localObject[0].equals("null")))
/*      */             try {
/*  541 */               this.n = Base64.decode(localObject[0], 0);
/*      */             } catch (Throwable localThrowable4) {
/*      */               Throwable localThrowable1;
/*  544 */               x.a(localThrowable1 = 
/*      */               
/*  546 */                 localThrowable4);i2 = 1;
/*      */             }
/*      */           int i3;
/*  548 */           if ((i2 == 0) && (!localObject[1].isEmpty()) && (!localObject[1].equals("null"))) {
/*      */             try {
/*  550 */               this.o = Long.parseLong(localObject[1]);
/*      */             } catch (Throwable localThrowable5) {
/*      */               Throwable localThrowable2;
/*  553 */               x.a(localThrowable2 = 
/*      */               
/*  555 */                 localThrowable5);i3 = 1;
/*      */             }
/*      */           }
/*  557 */           if ((i3 == 0) && (!localObject[2].isEmpty()) && (!localObject[2].equals("null"))) {
/*  558 */             this.p = localObject[2];
/*      */           }
/*  560 */           if ((i3 == 0) && (!localObject[3].isEmpty()) && (!localObject[3].equals("null"))) {
/*      */             try {
/*  562 */               this.q = Long.parseLong(localObject[3]);
/*      */             } catch (Throwable localThrowable6) {
/*      */               Throwable localThrowable3;
/*  565 */               x.a(localThrowable3 = 
/*      */               
/*  567 */                 localThrowable6);i4 = 1;
/*      */             }
/*      */           }
/*      */         } else {
/*  570 */           x.a("SecurityInfo = %s, Strings.length = %d", new Object[] { str, Integer.valueOf(localObject.length) });
/*      */           
/*  572 */           i4 = 1;
/*      */         }
/*  574 */         if (i4 != 0) {
/*  575 */           c();
/*      */         }
/*      */       }
/*  578 */       return true;
/*      */     } catch (Throwable localThrowable7) {
/*      */       Object localObject;
/*  581 */       x.a(localObject = localThrowable7); }
/*  582 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean b()
/*      */   {
/*  592 */     if ((this.p == null) || (this.q == 0L)) {
/*  593 */       return false;
/*      */     }
/*  595 */     long l1 = System.currentTimeMillis() + this.m;
/*  596 */     if (this.q < l1) {
/*  597 */       x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", new Object[] { Long.valueOf(this.q), new Date(this.q).toString(), Long.valueOf(l1), new Date(l1).toString() });
/*      */       
/*      */ 
/*      */ 
/*  601 */       return false;
/*      */     }
/*  603 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void b(boolean paramBoolean)
/*      */   {
/*  613 */     synchronized (this.r) {
/*  614 */       x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*  616 */       this.n = null;
/*  617 */       this.p = null;
/*  618 */       this.q = 0L;
/*      */     }
/*  620 */     if (paramBoolean)
/*      */     {
/*  622 */       c();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void c(final int paramInt)
/*      */   {
/*  632 */     if (paramInt < 0) {
/*  633 */       x.a("[UploadManager] Number of task to execute should >= 0", new Object[0]);
/*  634 */       return;
/*      */     }
/*  636 */     w localw = w.a();
/*      */     
/*      */ 
/*      */ 
/*  640 */     LinkedBlockingQueue localLinkedBlockingQueue1 = new LinkedBlockingQueue();
/*  641 */     final LinkedBlockingQueue localLinkedBlockingQueue2 = new LinkedBlockingQueue();
/*      */     int i1;
/*      */     int i2;
/*  644 */     synchronized (this.j) {
/*  645 */       x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*      */ 
/*  648 */       i1 = this.h.size();
/*  649 */       i2 = this.i.size();
/*  650 */       if ((i1 == 0) && (i2 == 0)) {
/*  651 */         x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
/*  652 */         return;
/*      */       }
/*  654 */       if (paramInt != 0)
/*  655 */         if (paramInt < i1)
/*      */         {
/*      */ 
/*  658 */           i1 = paramInt;
/*  659 */           i2 = 0;
/*  660 */         } else if (paramInt < i1 + i2)
/*      */         {
/*  662 */           i2 = paramInt - i1;
/*      */         }
/*  664 */       if ((localw == null) || (!localw.c()))
/*      */       {
/*  666 */         i2 = 0;
/*      */       }
/*      */       
/*  669 */       for (paramInt = 0; paramInt < i1; paramInt++) {
/*      */         Runnable localRunnable1;
/*  671 */         if ((localRunnable1 = (Runnable)this.h.peek()) == null) break;
/*  672 */         try { localLinkedBlockingQueue1.put(localRunnable1);
/*      */           
/*      */ 
/*      */ 
/*  676 */           this.h.poll();
/*      */         } catch (Throwable localThrowable1) {
/*  678 */           x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable1.getMessage() });
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  683 */       for (paramInt = 0; paramInt < i2; paramInt++) {
/*      */         Runnable localRunnable2;
/*  685 */         if ((localRunnable2 = (Runnable)this.i.peek()) == null) break;
/*  686 */         try { localLinkedBlockingQueue2.put(localRunnable2);
/*      */           
/*      */ 
/*      */ 
/*  690 */           this.i.poll();
/*      */         } catch (Throwable localThrowable2) {
/*  692 */           x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable2.getMessage() });
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  697 */     if (i1 > 0) {
/*  698 */       x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(i1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     }
/*      */     
/*      */ 
/*  702 */     for (??? = 0; ??? < i1; ???++)
/*      */     {
/*  704 */       if ((paramInt = (Runnable)localLinkedBlockingQueue1.poll()) == null) break;
/*  705 */       synchronized (this.j)
/*      */       {
/*      */ 
/*      */ 
/*  709 */         if (this.u >= 2)
/*      */         {
/*  711 */           if (localw != null) {
/*  712 */             localw.a(paramInt);
/*  713 */             continue;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  718 */       x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
/*      */       
/*  720 */       if (z.a(new Runnable()
/*      */       {
/*      */         public final void run() {
/*  723 */           paramInt.run();
/*  724 */           synchronized (u.a(u.this))
/*      */           {
/*  726 */             u.b(u.this); return;
/*      */           }
/*      */         }
/*  720 */       }, "BUGLY_ASYNC_UPLOAD") != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  730 */         synchronized (this.j)
/*      */         {
/*  732 */           this.u += 1;
/*      */         }
/*      */       }
/*      */       
/*  736 */       x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
/*      */       
/*  738 */       a(paramInt, true);
/*      */     }
/*      */     
/*  741 */     if (i2 > 0) {
/*  742 */       x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     }
/*      */     
/*      */ 
/*  746 */     final int i3 = i2;
/*      */     
/*  748 */     if (localw != null) {
/*  749 */       localw.a(new Runnable()
/*      */       {
/*      */         public final void run() {
/*  752 */           for (int i = 0; i < i3; i++) {
/*      */             Runnable localRunnable;
/*  754 */             if ((localRunnable = (Runnable)localLinkedBlockingQueue2.poll()) == null) break;
/*  755 */             localRunnable.run();
/*      */           }
/*      */         }
/*      */       });
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
/*      */   private boolean a(Runnable paramRunnable, boolean paramBoolean)
/*      */   {
/*  772 */     if (paramRunnable == null) {
/*  773 */       x.a("[UploadManager] Upload task should not be null", new Object[0]);
/*  774 */       return false;
/*      */     }
/*      */     try {
/*  777 */       x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*      */ 
/*  780 */       synchronized (this.j)
/*      */       {
/*  782 */         if (paramBoolean) {
/*  783 */           this.h.put(paramRunnable);
/*      */         } else {
/*  785 */           this.i.put(paramRunnable);
/*      */         }
/*      */       }
/*  788 */       return true;
/*      */     } catch (Throwable localThrowable) {
/*  790 */       x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { localThrowable.getMessage() }); }
/*  791 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void a(Runnable paramRunnable, long paramLong)
/*      */   {
/*  802 */     if (paramRunnable == null) {
/*  803 */       x.d("[UploadManager] Upload task should not be null", new Object[0]);
/*  804 */       return;
/*      */     }
/*  806 */     x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */     Thread localThread;
/*  809 */     if ((localThread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD")) == null) {
/*  810 */       x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
/*      */       
/*      */ 
/*  813 */       a(paramRunnable, true);
/*  814 */       return;
/*      */     }
/*      */     try {
/*  817 */       localThread.join(paramLong); return;
/*      */     } catch (Throwable paramLong) {
/*  819 */       x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { paramLong.getMessage() });
/*      */       
/*      */ 
/*      */ 
/*  823 */       a(paramRunnable, true);
/*      */       
/*  825 */       c(0);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   private void a(Runnable paramRunnable, boolean arg2, boolean paramBoolean2, long paramLong)
/*      */   {
/*  882 */     if (paramRunnable == null) {
/*  883 */       x.d("[UploadManager] Upload task should not be null", new Object[0]);
/*      */     }
/*  885 */     x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */ 
/*  888 */     if (this.p != null)
/*      */     {
/*  890 */       if (b())
/*      */       {
/*  892 */         x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */         
/*      */ 
/*  895 */         if (paramBoolean2) {
/*  896 */           a(paramRunnable, paramLong);return;
/*      */         }
/*  898 */         a(paramRunnable, ???);
/*      */         
/*  900 */         c(0);
/*      */         
/*      */ 
/*  903 */         return;
/*      */       }
/*      */       
/*  906 */       x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*      */ 
/*  909 */       b(false);
/*      */     }
/*      */     
/*  912 */     synchronized (this.t)
/*      */     {
/*  914 */       if (this.s)
/*      */       {
/*  916 */         a(paramRunnable, ???);
/*  917 */         return;
/*      */       }
/*      */       
/*  920 */       this.s = true;
/*      */     }
/*      */     
/*      */ 
/*  924 */     long l1 = paramLong;paramLong = paramBoolean2;paramBoolean2 = ???;??? = paramRunnable;paramRunnable = this;x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) }); if (paramLong != 0) { paramRunnable.a(new a(paramRunnable, paramRunnable.d, ???, l1), 0L);return; } paramRunnable.a(???, paramBoolean2);??? = new a(paramRunnable, paramRunnable.d);x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" }); if (z.a(???, "BUGLY_ASYNC_UPLOAD") == null) { x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]); if ((paramBoolean2 = w.a()) != null) { paramBoolean2.a(???);return; } x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]); synchronized (paramRunnable.t) { paramRunnable.s = false;return;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void a(int arg1, an paraman)
/*      */   {
/*  934 */     if (!this.a)
/*      */     {
/*  936 */       return;
/*      */     }
/*      */     
/*  939 */     if (??? == 2)
/*      */     {
/*  941 */       x.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*      */ 
/*  944 */       b(true);
/*      */     } else {
/*  946 */       synchronized (this.t)
/*      */       {
/*  948 */         if (!this.s)
/*      */         {
/*  950 */           return;
/*      */         }
/*      */       }
/*  953 */       if (paraman != null) {
/*  954 */         x.c("[UploadManager] Record security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */         
/*  956 */         ??? = 1;
/*      */         try
/*      */         {
/*  959 */           if (((localObject2 = paraman.g) != null) && (((Map)localObject2).containsKey("S1")) && (((Map)localObject2).containsKey("S2")))
/*      */           {
/*      */ 
/*  962 */             this.m = (paraman.e - System.currentTimeMillis());
/*  963 */             x.c("[UploadManager] Time lag of server is: %d", new Object[] { Long.valueOf(this.m) });
/*  964 */             this.p = ((String)((Map)localObject2).get("S1"));
/*  965 */             x.c("[UploadManager] Session ID from server is: %s", new Object[] { this.p });
/*  966 */             if (this.p.length() > 0) {
/*      */               try {
/*  968 */                 this.q = Long.parseLong((String)((Map)localObject2).get("S2"));
/*      */                 
/*  970 */                 x.c("[UploadManager] Session expired time from server is: %d(%s)", new Object[] { Long.valueOf(this.q), new Date(this.q).toString() });
/*      */                 
/*      */ 
/*      */ 
/*  974 */                 if (this.q < 1000L) {
/*  975 */                   x.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
/*      */                   
/*      */ 
/*  978 */                   this.q = 259200000L;
/*      */                 }
/*      */               } catch (NumberFormatException localNumberFormatException) {
/*  981 */                 x.d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
/*      */                 
/*  983 */                 this.q = 259200000L;
/*      */               }
/*      */               
/*  986 */               if (d()) {
/*  987 */                 ??? = 0;
/*      */               }
/*      */               else {
/*  990 */                 x.c("[UploadManager] Failed to record database", new Object[0]);
/*      */               }
/*      */               
/*  993 */               c(0);
/*      */             } else {
/*  995 */               x.c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
/*      */             }
/*      */           }
/*      */         }
/*      */         catch (Throwable localThrowable) {
/*      */           Object localObject2;
/* 1001 */           x.a(localObject2 = 
/* 1002 */             localThrowable); }
/* 1003 */         if (??? != 0)
/*      */         {
/* 1005 */           b(false);
/*      */         }
/*      */       } else {
/* 1008 */         x.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */         
/*      */ 
/*      */ 
/* 1012 */         b(false);
/*      */       }
/*      */     }
/* 1015 */     synchronized (this.t)
/*      */     {
/* 1017 */       if (this.s)
/*      */       {
/* 1019 */         this.s = false;
/*      */         
/* 1021 */         z.b(this.d, "security_info");
/*      */       }
/*      */       
/*      */       return;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   class a
/*      */     implements Runnable
/*      */   {
/*      */     private final Context a;
/*      */     
/*      */     private final Runnable b;
/*      */     private final long c;
/*      */     
/*      */     public a(Context paramContext)
/*      */     {
/* 1039 */       this.a = paramContext;
/* 1040 */       this.b = null;
/* 1041 */       this.c = 0L;
/*      */     }
/*      */     
/*      */     public a(Context paramContext, Runnable paramRunnable, long paramLong) {
/* 1045 */       this.a = paramContext;
/* 1046 */       this.b = paramRunnable;
/* 1047 */       this.c = paramLong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public final void run()
/*      */     {
/* 1058 */       if (!z.a(this.a, "security_info", 30000L))
/*      */       {
/*      */ 
/* 1061 */         x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", new Object[] { Integer.valueOf(5000), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */         
/*      */ 
/*      */ 
/* 1065 */         z.b(5000L);
/* 1066 */         if (z.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
/* 1067 */           x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
/*      */           
/*      */           w localw;
/*      */           
/* 1071 */           if ((localw = w.a()) != null) {
/* 1072 */             localw.a(this);return;
/*      */           }
/* 1074 */           x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
/*      */           
/*      */ 
/* 1077 */           return;
/*      */         }
/*      */         
/*      */ 
/* 1081 */         return;
/*      */       }
/*      */       
/*      */ 
/* 1085 */       if (!u.c(u.this))
/*      */       {
/* 1087 */         x.d("[UploadManager] Failed to load security info from database", new Object[0]);
/* 1088 */         u.this.b(false);
/*      */       }
/*      */       
/* 1091 */       if (u.d(u.this) != null)
/*      */       {
/* 1093 */         if (u.this.b())
/*      */         {
/* 1095 */           x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */           
/*      */ 
/* 1098 */           if (this.b != null)
/*      */           {
/* 1100 */             u.a(u.this, this.b, this.c);
/*      */           }
/* 1102 */           u.a(u.this, 0);
/*      */           
/* 1104 */           z.b(this.a, "security_info");
/* 1105 */           synchronized (u.e(u.this))
/*      */           {
/* 1107 */             u.a(u.this, false);
/* 1108 */             return;
/*      */           } }
/* 1110 */         x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1115 */         u.this.b(true);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1120 */       if (((??? = z.a(128)) != null) && (???.length << 3 == 128)) {
/* 1121 */         u.a(u.this, (byte[])???);
/*      */         
/* 1123 */         x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */         
/*      */ 
/* 1126 */         if (this.b != null)
/*      */         {
/* 1128 */           u.a(u.this, this.b, this.c);return;
/*      */         }
/*      */         
/*      */ 
/* 1132 */         u.a(u.this, 1);
/*      */         
/* 1134 */         return;
/*      */       }
/*      */       
/* 1137 */       x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/*      */ 
/*      */ 
/* 1141 */       u.this.b(false);
/*      */       
/* 1143 */       z.b(this.a, "security_info");
/* 1144 */       synchronized (u.e(u.this))
/*      */       {
/* 1146 */         u.a(u.this, false); return;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final byte[] a(byte[] paramArrayOfByte)
/*      */   {
/* 1158 */     if ((this.n == null) || (this.n.length << 3 != 128)) {
/* 1159 */       x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/* 1161 */       return null;
/*      */     }
/*      */     
/* 1164 */     return z.a(1, paramArrayOfByte, this.n);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final byte[] b(byte[] paramArrayOfByte)
/*      */   {
/* 1174 */     if ((this.n == null) || (this.n.length << 3 != 128)) {
/* 1175 */       x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */       
/* 1177 */       return null;
/*      */     }
/*      */     
/* 1180 */     return z.a(2, paramArrayOfByte, this.n);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final boolean a(Map<String, String> paramMap)
/*      */   {
/* 1190 */     if (paramMap == null) {
/* 1191 */       return false;
/*      */     }
/* 1193 */     x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*      */     
/*      */ 
/* 1196 */     if (this.p != null)
/*      */     {
/* 1198 */       paramMap.put("secureSessionId", this.p);
/* 1199 */       return true;
/*      */     }
/* 1201 */     if ((this.n == null) || (this.n.length << 3 != 128)) {
/* 1202 */       x.d("[UploadManager] AES key is invalid", new Object[0]);
/* 1203 */       return false;
/*      */     }
/* 1205 */     if (this.l == null)
/*      */     {
/* 1207 */       this.l = Base64.decode(this.k, 0);
/* 1208 */       if (this.l == null) {
/* 1209 */         x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
/* 1210 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */     Object localObject;
/* 1215 */     if ((localObject = z.b(1, this.n, this.l)) == null) {
/* 1216 */       x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
/* 1217 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1221 */     if ((localObject = Base64.encodeToString((byte[])localObject, 0)) == null) {
/* 1222 */       x.d("[UploadManager] Failed to encode AES key", new Object[0]);
/* 1223 */       return false;
/*      */     }
/* 1225 */     paramMap.put("raKey", localObject);
/* 1226 */     return true;
/*      */   }
/*      */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/u.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */