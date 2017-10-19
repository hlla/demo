/*     */
package com.tencent.bugly.crashreport.crash.anr;
/*     */ 
/*     */

import android.app.ActivityManager;
/*     */ import android.app.ActivityManager.ProcessErrorStateInfo;
/*     */ import android.content.Context;
/*     */ import android.os.FileObserver;
/*     */ import android.os.Process;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import com.tencent.bugly.crashreport.crash.CrashDetailBean;
/*     */ import com.tencent.bugly.crashreport.crash.c;
/*     */ import com.tencent.bugly.proguard.w;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.y;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicInteger;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
    /*  47 */   private AtomicInteger a = new AtomicInteger(0);
    /*  48 */   private long b = -1L;
    /*     */
/*     */ 
/*     */   private final Context c;
    /*     */
/*     */ 
/*     */   private final com.tencent.bugly.crashreport.common.info.a d;
    /*     */
/*     */ 
/*     */   private final w e;
    /*     */
/*     */ 
/*     */   private final com.tencent.bugly.crashreport.common.strategy.a f;
    /*     */
/*     */ 
/*     */   private final String g;
    /*     */
/*     */   private final com.tencent.bugly.crashreport.crash.b h;
    /*     */
/*     */   private FileObserver i;
    /*     */
/*  69 */   private boolean j = true;

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com
            .tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly
            .crashreport.crash.b paramb)
/*     */ {
/*  85 */
        this.c = z.a(paramContext);
/*  86 */
        paramContext = paramContext.getDir("bugly", 0);
/*  87 */
        this.g = paramContext.getAbsolutePath();
/*  88 */
        this.d = parama1;
/*  89 */
        this.e = paramw;
/*  90 */
        this.f = parama;
/*  91 */
        this.h = paramb;
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    private CrashDetailBean a(a parama)
/*     */ {
/* 155 */
        CrashDetailBean localCrashDetailBean = new CrashDetailBean();
/*     */
        try
/*     */ {
/* 158 */
            localCrashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.g();
/* 159 */
            localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.e();
/* 160 */
            localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
/* 161 */
            localCrashDetailBean.E = this.d.p();
/* 162 */
            localCrashDetailBean.F = this.d.o();
/* 163 */
            localCrashDetailBean.G = this.d.q();
/* 164 */
            localCrashDetailBean.w = z.a(this.c, c.e, null);
/*     */       
/* 166 */
            localCrashDetailBean.b = 3;
/* 167 */
            localCrashDetailBean.e = this.d.h();
/* 168 */
            localCrashDetailBean.f = this.d.j;
/* 169 */
            localCrashDetailBean.g = this.d.w();
/* 170 */
            localCrashDetailBean.m = this.d.g();
/* 171 */
            localCrashDetailBean.n = "ANR_EXCEPTION";
/* 172 */
            localCrashDetailBean.o = parama.f;
/* 173 */
            localCrashDetailBean.q = parama.g;
/* 174 */
            localCrashDetailBean.N = new HashMap();
/* 175 */
            localCrashDetailBean.N.put("BUGLY_CR_01", parama.e);
/*     */       
/* 177 */
            int k = -1;
/* 178 */
            if (localCrashDetailBean.q != null) {
/* 179 */
                k = localCrashDetailBean.q.indexOf("\n");
/*     */
            }
/* 181 */
            localCrashDetailBean.p = (k > 0 ? localCrashDetailBean.q.substring(0, k) : "GET_FAIL");
/*     */       
/*     */ 
/* 184 */
            localCrashDetailBean.r = parama.c;
/* 185 */
            if (localCrashDetailBean.q != null) {
/* 186 */
                localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
/*     */
            }
/*     */       
/* 189 */
            localCrashDetailBean.y = parama.b;
/* 190 */
            localCrashDetailBean.z = this.d.d;
/* 191 */
            localCrashDetailBean.A = "main(1)";
/* 192 */
            localCrashDetailBean.H = this.d.y();
/* 193 */
            localCrashDetailBean.h = this.d.v();
/* 194 */
            localCrashDetailBean.i = this.d.I();
/* 195 */
            localCrashDetailBean.v = parama.d;
/* 196 */
            localCrashDetailBean.K = this.d.n;
/* 197 */
            localCrashDetailBean.L = this.d.a;
/* 198 */
            localCrashDetailBean.M = this.d.a();
/*     */       
/*     */ 
/* 201 */
            localCrashDetailBean.O = this.d.F();
/* 202 */
            localCrashDetailBean.P = this.d.G();
/* 203 */
            localCrashDetailBean.Q = this.d.z();
/* 204 */
            localCrashDetailBean.R = this.d.E();
/*     */       
/* 206 */
            this.h.c(localCrashDetailBean);
/* 207 */
            localCrashDetailBean.x = y.a();
/*     */
        } catch (Throwable localThrowable2) {
            Throwable localThrowable1;
/* 209 */
            if (!x.a(localThrowable1 =
/*     */       
/*     */ 
/* 212 */         localThrowable2)) {
/* 210 */
                localThrowable1.printStackTrace();
/*     */
            }
/*     */
        }
/* 213 */
        return localCrashDetailBean;
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */
    private static boolean a(String paramString1, String paramString2, String paramString3)
/*     */ {
/* 221 */
        if (((paramString1 = TraceFileHelper.readTargetDumpInfo(paramString3, paramString1, true)
        ) == null) || (paramString1.d == null) || (paramString1.d.size() <= 0)) {
/* 222 */
            x.e("not found trace dump for %s", new Object[]{paramString3});
/* 223 */
            return false;
/*     */
        }
/*     */     
/* 226 */
        paramString3 = new File(paramString2);
/*     */
        try {
/* 228 */
            if (!paramString3.exists()) {
/* 229 */
                if (!paramString3.getParentFile().exists()) {
/* 230 */
                    paramString3.getParentFile().mkdirs();
/*     */
                }
/*     */         
/* 233 */
                paramString3.createNewFile();
/*     */
            }
/*     */
        }
/*     */ catch (Exception localException) {
/* 237 */
            if (!x.a(localObject1 =
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 243 */         localException)) {
/* 238 */
                ((Exception) localObject1).printStackTrace();
/*     */
            }
/* 240 */
            x.e("backup file create error! %s  %s", new Object[]{localObject1.getClass().getName
                    () + ":" + ((Exception) localObject1).getMessage(), paramString2});
/*     */       
/* 242 */
            return false;
/*     */
        }
/*     */     
/* 245 */
        if ((!paramString3.exists()) || (!paramString3.canWrite())) {
/* 246 */
            x.e("backup file create fail %s", new Object[]{paramString2});
/* 247 */
            return false;
/*     */
        }
/*     */     
/* 250 */
        Object localObject1 = null;
/*     */
        try
/*     */ {
/* 253 */
            localObject1 = new BufferedWriter(new FileWriter(paramString3, false));
/*     */       
/*     */ 
/* 256 */
            if (((paramString2 = (String[]) paramString1.d.get("main")) != null) &&
                    (paramString2.length >= 3)) {
/* 257 */
                paramString3 = paramString2[0];
/* 258 */
                localObject2 = paramString2[1];
/* 259 */
                paramString2 = paramString2[2];
/* 260 */
                ((BufferedWriter) localObject1).write("\"main\" tid=" + paramString2 + " :\n" +
                        paramString3 + "\n" + (String) localObject2 + "\n\n");
/* 261 */
                ((BufferedWriter) localObject1).flush();
/*     */
            }
/*     */       
/* 264 */
            for (paramString3 = paramString1.d.entrySet().iterator(); paramString3.hasNext(); )
/* 265 */
                if (!((String) (localObject2 = (Map.Entry) paramString3.next()).getKey()).equals
                        ("main"))
/* 266 */
                    if ((((Map.Entry) localObject2).getValue() != null) && (((String[]) ((Map
                            .Entry) localObject2).getValue()).length >= 3))
/*     */ {
/*     */ 
/*     */ 
/* 270 */
                        paramString2 = ((String[]) localObject2.getValue())[0];
/* 271 */
                        paramString1 = ((String[]) localObject2.getValue())[1];
/* 272 */
                        String str = ((String[]) localObject2.getValue())[2];
/* 273 */
                        ((BufferedWriter) localObject1).write("\"" + (String) ((Map.Entry)
                                localObject2).getKey() + "\" tid=" + str + " :\n" + paramString2
                                + "\n" + paramString1 + "\n\n");
/*     */             
/* 275 */
                        ((BufferedWriter) localObject1).flush();
/*     */
                    }
/*     */
            try {
/* 278 */
                ((BufferedWriter) localObject1).close();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
            }
/*     */ catch (IOException localIOException1)
/*     */ {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 290 */
                if (!x.a(localObject2 =
/*     */         
/*     */ 
/* 293 */           localIOException1))
/* 291 */ ((IOException) localObject2).printStackTrace();
/*     */
            }
/* 293 */
            return true;
/*     */
        }
/*     */ catch (IOException localIOException2)
/*     */ {
/*     */
            Object localObject2;
/* 281 */
            paramString2.printStackTrace();
/*     */       
/* 283 */
            x.e("dump trace fail %s", new Object[]{paramString2.getClass().getName() + ":" +
                    paramString2.getMessage()});
/* 284 */
            if (localObject1 != null)
/*     */ {
/*     */
                try
/*     */ {
/* 288 */
                    ((BufferedWriter) localObject1).close();
/*     */
                } catch (IOException localIOException3) {
/* 290 */
                    if (!x.a(localObject2 =
/*     */           
/*     */ 
/* 293 */             localIOException3))
/* 291 */ ((IOException) localObject2).printStackTrace();
/*     */
                }
            }
/* 293 */
            return false;
/*     */
        }
/*     */ finally
/*     */ {
/* 286 */
            if (localObject1 != null) {
/*     */
                try {
/* 288 */
                    ((BufferedWriter) localObject1).close();
/*     */
                } catch (IOException localIOException4) {
/* 290 */
                    if (!x.a(paramString2 =
/*     */           
/*     */ 
/* 293 */             localIOException4)) {
/* 291 */
                        paramString2.printStackTrace();
/*     */
                    }
/*     */
                }
/*     */
            }
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */
    public final boolean a()
/*     */ {
/* 302 */
        return this.a.get() != 0;
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    public final void a(String paramString)
/*     */ {
/* 383 */
        synchronized (this) {
/* 384 */
            if (this.a.get() != 0) {
/* 385 */
                x.c("trace started return ", new Object[0]);
/* 386 */
                return;
/*     */
            }
/* 388 */
            this.a.set(1);
/*     */
        }
/*     */     
/*     */ 
/*     */ 
/*     */
        try
/*     */ {
/* 395 */
            x.c("read trace first dump for create time!", new Object[0]);
/* 396 */
            long l1 = -1L;
/*     */
            Object localObject4;
/* 398 */
            if ((localObject4 = TraceFileHelper.readFirstDumpInfo(paramString, false)) != null) {
/* 399 */
                l1 = ((TraceFileHelper.a) localObject4).c;
/*     */
            }
/*     */       
/* 402 */
            if (l1 == -1L)
/*     */ {
/* 404 */
                x.d("trace dump fail could not get time!", new Object[0]);
/* 405 */
                l1 = System.currentTimeMillis();
/*     */
            }
/*     */       
/* 408 */
            if (Math.abs(l1 - this.b) < 10000L) {
/* 409 */
                x.d("should not process ANR too Fre in %d", new Object[]{Integer.valueOf(10000)});
/*     */
            }
/*     */
            else
/*     */ {
/* 413 */
                this.b = l1;
/*     */         
/*     */ 
/* 416 */
                this.a.set(1);
/*     */
                try {
/* 418 */
                    localObject4 = z.a(c.f, false);
/*     */ 
/*     */
                }
/*     */ catch (Throwable localThrowable1)
/*     */ {
/*     */ 
/* 424 */
                    x.a(localObject5 =
/*     */           
/*     */ 
/* 427 */             localThrowable1);
                    x.e("get all thread stack fail!", new Object[0]);
                    return;
/*     */
                }
/*     */         
/*     */ 
/* 429 */
                if ((localObject4 == null) || (((Map) localObject4).size() <= 0)) {
/* 430 */
                    x.d("can't get all thread skip this anr", new Object[0]);
                    return;
/*     */
                }
/*     */         
/*     */ 
/* 434 */
                long l2 = 10000L;
                Object localObject5 = this.c;
                l2 = 10000L < 0L ? 0L : 10000L;
                x.c("to find!", new Object[0]);
                ActivityManager localActivityManager = (ActivityManager) ((Context) localObject5)
                        .getSystemService("activity");
                long l4 = l2 / 500L;
                int k = 0;
                Object localObject7;
                do {
                    x.c("waiting!", new Object[0]);
                    List localList;
                    if ((localList = localActivityManager.getProcessesInErrorState()) != null) {
                        localObject7 = localList.iterator();
                        while ((localObject8 = (ActivityManager.ProcessErrorStateInfo) (
                                (Iterator) localObject7).next()).condition != 2) {
                        }
                        x.c("found!", new Object[0]);
                    }
                    z.b(500L);
                } while (k++ < l4);
                x.c("end!", new Object[0]);
/*     */         
/*     */ 
/* 437 */
                if ((localObject5 = ((Iterator) localObject7).hasNext() ? localObject8 : null) ==
                        null)
/*     */ {
/* 439 */
                    x.c("proc state is unvisiable!", new Object[0]);
                    return;
/*     */
                }
/*     */         
/*     */ 
/* 443 */
                if (((ActivityManager.ProcessErrorStateInfo) localObject5).pid != Process.myPid()) {
/* 444 */
                    x.c("not mind proc!", new Object[]{((ActivityManager.ProcessErrorStateInfo)
                            localObject5).processName});
                    return;
/*     */
                }
/*     */         
/*     */ 
/* 448 */
                x.a("found visiable anr , start to process!", new Object[0]);
/*     */         
/* 450 */
                Object localObject9 = localObject4;
                long l3 = l1;
                paramString = (String) localObject5;
                String str = paramString;
                Object localObject8 = this.c;
                localObject5 = this;
                this.f.c();
                if (!((b) localObject5).f.b()) {
                    x.e("waiting for remote sync", new Object[0]);
                    int m = 0;
                    do {
                        if (((b) localObject5).f.b()) break;
                        z.b(500L);
                        m += 500;
                    } while (m < 3000);
                }
                Object localObject3 = localObject9;
                long l5 = l3;
                localObject1 = paramString;
                paramString = (String) localObject8;
                paramString = new File(paramString.getFilesDir(), "bugly/bugly_trace_" + l5 + "" +
                        ".txt");
                (localObject4 = new a()).c = l5;
                ((a) localObject4).d = paramString.getAbsolutePath();
                ((a) localObject4).a = ((ActivityManager.ProcessErrorStateInfo) localObject1)
                        .processName;
                ((a) localObject4).f = ((ActivityManager.ProcessErrorStateInfo) localObject1)
                        .shortMsg;
                ((a) localObject4).e = ((ActivityManager.ProcessErrorStateInfo) localObject1)
                        .longMsg;
                ((a) localObject4).b = ((Map) localObject3);
                if (localObject3 != null)
                    for (paramString = ((Map) localObject3).keySet().iterator(); paramString
                            .hasNext(); )
                        if ((localObject1 = (String) paramString.next()).startsWith("main("))
                            ((a) localObject4).g = ((String) ((Map) localObject3).get
                                    (localObject1));
                x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new
                        Object[]{Long.valueOf(((a) localObject4).c), ((a) localObject4).d, ((a)
                        localObject4).a, ((a) localObject4).f, ((a) localObject4).e, Integer
                        .valueOf(((a) localObject4).b == null ? 0 : ((a) localObject4).b.size())});
                Object localObject6 = localObject4;
                x.e("crash report sync remote fail, will not upload to Bugly , print local for " +
                        "helpful!", new Object[0]);
                com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), ((a) localObject6).a, null,
                        ((a) localObject6).e, null);
                StrategyBean localStrategyBean;
                x.d("ANR Report is closed!", new Object[0]);
                x.a("found visiable anr , start to upload!", new Object[0]);
                x.e("pack anr fail!", new Object[0]);
                c.a().a((CrashDetailBean) localObject7);
                if (((CrashDetailBean) localObject7).a >= 0L)
                    x.a("backup anr record success!", new Object[0]);
                else x.d("backup anr record fail!", new Object[0]);
                if ((str != null) && (new File(str).exists())) {
                    ((b) localObject5).a.set(3);
                    boolean bool;
                    if ((bool = a(str, ((a) localObject6).d, ((a) localObject6).a)))
                        x.a("backup trace success", new Object[0]);
                }
                com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), ((a) localObject6).a, null,
                        ((a) localObject6).e, (CrashDetailBean) localObject7);
                if (!((b) localObject5).h.a((CrashDetailBean) localObject7))
                    ((b) localObject5).h.a((CrashDetailBean) localObject7, 3000L, true);
                ((b) localObject5).h.b((CrashDetailBean) localObject7);
                ((localObject7 = ((b) localObject5).a((a) localObject6)) == null ? 0 : !
                        (localStrategyBean = ((b) localObject5).f.c()).j ? 0 : !((b)
                        localObject5).f.b() ? 0 : 1);
                return;
/*     */
            }
/*     */
        } catch (Throwable localThrowable2) {
            Object localObject1;
/* 453 */
            ((Throwable) localObject1).printStackTrace();
/*     */       
/* 455 */
            x.e("handle anr error %s", new Object[]{localObject1.getClass().toString()});
/*     */
        } finally {
/* 457 */
            this.a.set(0);
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    private synchronized void c()
/*     */ {
/* 467 */
        if (e()) {
/* 468 */
            x.d("start when started!", new Object[0]);
/* 469 */
            return;
/*     */
        }
/*     */     
/* 472 */
        this.i = new FileObserver("/data/anr/", 8)
/*     */ {
            /*     */
            public final void onEvent(int paramAnonymousInt, String paramAnonymousString)
/*     */ {
/* 476 */
                if (paramAnonymousString == null) {
/* 477 */
                    return;
/*     */
                }
/*     */         
/* 480 */
                if (!(paramAnonymousInt = "/data/anr/" + paramAnonymousString).contains("trace")) {
/* 481 */
                    x.d("not anr file %s", new Object[]{paramAnonymousInt});
/* 482 */
                    return;
/*     */
                }
/*     */         
/* 485 */
                b.this.a(paramAnonymousInt);
/*     */
            }
/*     */
        };
/*     */
        try
/*     */ {
/* 490 */
            this.i.startWatching();
/* 491 */
            x.a("start anr monitor!", new Object[0]);
/* 492 */
            this.e.a(new Runnable()
/*     */ {
                /*     */
                public final void run()
/*     */ {
/* 496 */
                    b.this.b();
/*     */
                }
/*     */
            });
            return;
/*     */
        } catch (Throwable localThrowable) {
/* 500 */
            this.i = null;
/* 501 */
            x.d("start anr monitor failed!", new Object[0]);
/* 502 */
            if (!x.a(localThrowable)) {
/* 503 */
                localThrowable.printStackTrace();
/*     */
            }
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */
    private synchronized void d()
/*     */ {
/* 513 */
        if (!e()) {
/* 514 */
            x.d("close when closed!", new Object[0]);
/* 515 */
            return;
/*     */
        }
/*     */     
/*     */
        try
/*     */ {
/* 520 */
            this.i.stopWatching();
/* 521 */
            this.i = null;
/* 522 */
            x.d("close anr monitor!", new Object[0]);
            return;
/*     */
        } catch (Throwable localThrowable) {
/* 524 */
            x.d("stop anr monitor failed!", new Object[0]);
/* 525 */
            if (!x.a(localThrowable)) {
/* 526 */
                localThrowable.printStackTrace();
/*     */
            }
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */
    private synchronized boolean e()
/*     */ {
/* 536 */
        return this.i != null;
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    private synchronized void b(boolean paramBoolean)
/*     */ {
/* 545 */
        if (paramBoolean) {
/* 546 */
            c();
            return;
/*     */
        }
/* 548 */
        d();
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */
    private synchronized boolean f()
/*     */ {
/* 556 */
        return this.j;
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */
    private synchronized void c(boolean paramBoolean)
/*     */ {
/* 563 */
        if (this.j != paramBoolean) {
/* 564 */
            x.a("user change anr %b", new Object[]{Boolean.valueOf(paramBoolean)});
/* 565 */
            this.j = paramBoolean;
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */
    public final void a(boolean paramBoolean)
/*     */ {
/* 574 */
        c(paramBoolean);
/*     */     
/*     */ 
/* 577 */
        paramBoolean = f();
/*     */
        com.tencent.bugly.crashreport.common.strategy.a locala;
/* 579 */
        if ((locala = com.tencent.bugly.crashreport.common.strategy.a.a()) != null) {
/* 580 */
            paramBoolean = (paramBoolean) && (locala.c().g);
/*     */
        }
/* 582 */
        if (paramBoolean != e()) {
/* 583 */
            x.a("anr changed to %b", new Object[]{Boolean.valueOf(paramBoolean)});
/* 584 */
            b(paramBoolean);
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */
    protected final void b()
/*     */ {
/* 592 */
        long l1 = z.b() - c.g;
/*     */
        Object localObject1;
/* 594 */
        if (((localObject1 = new File(this.g)).exists()) && (((File) localObject1).isDirectory()))
/*     */ {
/* 596 */
            if (((localObject1 = ((File) localObject1).listFiles()) == null) || (localObject1.length == 0)) {
/* 597 */
                return;
/*     */
            }
/*     */       
/* 600 */
            String str1 = "bugly_trace_";
/* 601 */
            String str2 = ".txt";
/* 602 */
            int k = str1.length();
/*     */       
/* 604 */
            int m = 0;
/* 605 */
            int n = (localObject1 = localObject1).length;
            for (int i1 = 0; i1 < n; i1++) {
                Object localObject2;
/*     */
                String str3;
/* 607 */
                if ((str3 = (localObject2 = localObject1[i1]).getName()).startsWith(str1)) {
/*     */
                    try {
/*     */
                        int i2;
/* 610 */
                        if ((i2 = str3.indexOf(str2)) > 0) {
/*     */
                            long l2;
/* 612 */
                            if ((l2 = Long.parseLong(str3.substring(k, i2))) >= l1) {
/*     */
                                continue;
/*     */
                            }
/*     */
                        }
/*     */
                    } catch (Throwable localThrowable) {
/* 617 */
                        x.e("tomb format error delete %s", new Object[]{str3});
/*     */
                    }
/*     */           
/*     */ 
/* 621 */
                    if (((File) localObject2).delete()) {
/* 622 */
                        m++;
/*     */
                    }
/*     */
                }
/*     */
            }
/* 626 */
            x.c("clean tombs %d", new Object[]{Integer.valueOf(m)});
/*     */
        }
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
    public final synchronized void a(StrategyBean paramStrategyBean)
/*     */ {
/* 636 */
        if (paramStrategyBean == null) {
/* 637 */
            return;
/*     */
        }
/*     */     
/* 640 */
        if (paramStrategyBean.j != e()) {
/* 641 */
            x.d("server anr changed to %b", new Object[]{Boolean.valueOf(paramStrategyBean.j)});
/*     */
        }
/*     */     
/*     */ 
/*     */ 
/* 646 */
        if ((paramStrategyBean = (paramStrategyBean.j) && (f()) ? 1 : 0) != e()) {
/* 647 */
            x.a("anr changed to %b", new Object[]{Boolean.valueOf(paramStrategyBean)});
/* 648 */
            b(paramStrategyBean);
/*     */
        }
/*     */
    }
/*     */
}


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/anr/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */