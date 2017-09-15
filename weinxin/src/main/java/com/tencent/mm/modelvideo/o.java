package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.y.d.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private static ae hZG;
  private static ad hZH;
  public static boolean hZK;
  private s hZA;
  private w hZB;
  private x.a hZC;
  private l hZD;
  private k hZE;
  private m hZF;
  private f hZI;
  private i hZJ;
  private c<iv> hZL;
  private u hZz;
  
  static
  {
    GMTrace.i(328967651328L, 2451);
    hZG = null;
    hZH = null;
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(351784665088L, 2621);
        String[] arrayOfString = s.gUn;
        GMTrace.o(351784665088L, 2621);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(346013302784L, 2578);
        String[] arrayOfString = w.gUn;
        GMTrace.o(346013302784L, 2578);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(316351184896L, 2357);
        String[] arrayOfString = l.gUn;
        GMTrace.o(316351184896L, 2357);
        return arrayOfString;
      }
    });
    hZK = false;
    GMTrace.o(328967651328L, 2451);
  }
  
  public o()
  {
    GMTrace.i(326820167680L, 2435);
    this.hZz = new u();
    this.hZC = null;
    this.hZD = null;
    this.hZE = null;
    this.hZF = null;
    this.hZI = null;
    this.hZJ = null;
    this.hZL = new c() {};
    GMTrace.o(326820167680L, 2435);
  }
  
  public static o KV()
  {
    GMTrace.i(326954385408L, 2436);
    o localo = (o)com.tencent.mm.u.l.o(o.class);
    GMTrace.o(326954385408L, 2436);
    return localo;
  }
  
  public static s KW()
  {
    GMTrace.i(327088603136L, 2437);
    if (!h.vG().uV()) {
      throw new com.tencent.mm.u.b();
    }
    if (KV().hZA == null) {
      KV().hZA = new s(h.vI().gXW);
    }
    s locals = KV().hZA;
    GMTrace.o(327088603136L, 2437);
    return locals;
  }
  
  public static f KX()
  {
    GMTrace.i(14451625426944L, 107673);
    h.vG().uQ();
    if (KV().hZI == null) {
      KV().hZI = new f();
    }
    if (com.tencent.mm.modelcdntran.g.En().hxQ == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.modelcdntran.g.En().hxQ = KV().hZI;
      }
      f localf = KV().hZI;
      GMTrace.o(14451625426944L, 107673);
      return localf;
    }
  }
  
  public static i KY()
  {
    GMTrace.i(17453673349120L, 130040);
    h.vG().uQ();
    if (KV().hZJ == null) {
      KV().hZJ = new i();
    }
    i locali = KV().hZJ;
    GMTrace.o(17453673349120L, 130040);
    return locali;
  }
  
  public static w KZ()
  {
    GMTrace.i(327222820864L, 2438);
    if (!h.vG().uV()) {
      throw new com.tencent.mm.u.b();
    }
    if (KV().hZB == null) {
      KV().hZB = new w(h.vI().gXW);
    }
    w localw = KV().hZB;
    GMTrace.o(327222820864L, 2438);
    return localw;
  }
  
  public static l La()
  {
    GMTrace.i(327357038592L, 2439);
    if (!h.vG().uV()) {
      throw new com.tencent.mm.u.b();
    }
    if (KV().hZD == null) {
      KV().hZD = new l(h.vI().gXW);
    }
    l locall = KV().hZD;
    GMTrace.o(327357038592L, 2439);
    return locall;
  }
  
  public static x.a Lb()
  {
    GMTrace.i(327491256320L, 2440);
    if (!h.vG().uV()) {
      throw new com.tencent.mm.u.b();
    }
    if (KV().hZC == null) {
      KV().hZC = new x.a();
    }
    x.a locala = KV().hZC;
    GMTrace.o(327491256320L, 2440);
    return locala;
  }
  
  public static m Lc()
  {
    GMTrace.i(327625474048L, 2441);
    if (!h.vG().uV()) {
      throw new com.tencent.mm.u.b();
    }
    if (KV().hZF == null) {
      KV().hZF = new m();
    }
    m localm = KV().hZF;
    GMTrace.o(327625474048L, 2441);
    return localm;
  }
  
  private static void Ld()
  {
    boolean bool2 = false;
    GMTrace.i(327893909504L, 2443);
    if ((hZH != null) && (hZG != null))
    {
      GMTrace.o(327893909504L, 2443);
      return;
    }
    boolean bool1;
    if (hZH != null)
    {
      bool1 = true;
      if (hZG != null) {
        bool2 = true;
      }
      v.w("MicroMsg.SubCoreVideo", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bf.bJP() });
      if (hZH != null) {
        hZH.removeCallbacksAndMessages(null);
      }
      if (hZG == null) {
        break label141;
      }
      hZG.a(null);
    }
    for (;;)
    {
      hZH = new ad(hZG.nIe.getLooper());
      GMTrace.o(327893909504L, 2443);
      return;
      bool1 = false;
      break;
      label141:
      hZG = new ae("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
    }
  }
  
  public static boolean b(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(328028127232L, 2444);
    if (paramRunnable == null)
    {
      GMTrace.o(328028127232L, 2444);
      return false;
    }
    Ld();
    if (paramLong > 0L) {
      hZH.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      GMTrace.o(328028127232L, 2444);
      return true;
      hZH.post(paramRunnable);
    }
  }
  
  public static String getAccVideoPath()
  {
    GMTrace.i(18681631342592L, 139189);
    Object localObject = new StringBuilder();
    h.vJ();
    localObject = h.vI().gXV + "video/";
    GMTrace.o(18681631342592L, 139189);
    return (String)localObject;
  }
  
  public static boolean h(Runnable paramRunnable)
  {
    GMTrace.i(328162344960L, 2445);
    if (paramRunnable == null)
    {
      GMTrace.o(328162344960L, 2445);
      return true;
    }
    Ld();
    if (hZH == null)
    {
      v.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      GMTrace.o(328162344960L, 2445);
      return false;
    }
    hZH.removeCallbacks(paramRunnable);
    GMTrace.o(328162344960L, 2445);
    return true;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(328699215872L, 2449);
    v.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    d.c.a(Integer.valueOf(43), this.hZz);
    d.c.a(Integer.valueOf(44), this.hZz);
    d.c.a(Integer.valueOf(62), this.hZz);
    com.tencent.mm.sdk.b.a.uql.a(this.hZL);
    if (hZH != null) {
      hZH.removeCallbacksAndMessages(null);
    }
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(351113576448L, 2616);
        if (!h.vG().uV())
        {
          GMTrace.o(351113576448L, 2616);
          return;
        }
        Object localObject1 = o.KW();
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status" + " = 200";
        v.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
        ((s)localObject1).hnp.eE("videoinfo2", (String)localObject2);
        o.La().gUp.eE("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
        localObject1 = o.La();
        if (1209600000L <= 0L)
        {
          v.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
          ((l)localObject1).gUp.eE("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
        }
        for (;;)
        {
          localObject1 = o.La().KT().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            v.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((j)localObject2).field_fileName });
            com.tencent.mm.loader.stub.b.deleteFile(k.ln(((j)localObject2).field_fileName));
            com.tencent.mm.loader.stub.b.deleteFile(k.lo(((j)localObject2).field_fileName));
          }
          l = bf.NA() - 1209600000L;
          v.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
          localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + l;
          ((l)localObject1).gUp.eE("SightDraftInfo", (String)localObject2);
        }
        GMTrace.o(351113576448L, 2616);
      }
    });
    File localFile = new File(k.KS());
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    GMTrace.o(328699215872L, 2449);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(328833433600L, 2450);
    GMTrace.o(328833433600L, 2450);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(328564998144L, 2448);
    GMTrace.o(328564998144L, 2448);
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc2_w 408
    //   3: sipush 2446
    //   6: invokestatic 56	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc -18
    //   11: ldc_w 411
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: invokevirtual 355	java/lang/Object:hashCode	()I
    //   24: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 357	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   34: getfield 108	com/tencent/mm/modelvideo/o:hZC	Lcom/tencent/mm/modelvideo/x$a;
    //   37: ifnull +115 -> 152
    //   40: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   43: getfield 108	com/tencent/mm/modelvideo/o:hZC	Lcom/tencent/mm/modelvideo/x$a;
    //   46: astore_1
    //   47: aload_1
    //   48: iconst_0
    //   49: putfield 415	com/tencent/mm/modelvideo/x$a:fBf	I
    //   52: aload_1
    //   53: getfield 419	com/tencent/mm/modelvideo/x$a:iaF	Lcom/tencent/mm/modelvideo/d;
    //   56: ifnull +11 -> 67
    //   59: aload_1
    //   60: getfield 419	com/tencent/mm/modelvideo/x$a:iaF	Lcom/tencent/mm/modelvideo/d;
    //   63: invokevirtual 424	com/tencent/mm/modelvideo/d:pd	()Z
    //   66: pop
    //   67: aload_1
    //   68: getfield 428	com/tencent/mm/modelvideo/x$a:iaG	Lcom/tencent/mm/modelvideo/g;
    //   71: ifnull +61 -> 132
    //   74: aload_1
    //   75: getfield 428	com/tencent/mm/modelvideo/x$a:iaG	Lcom/tencent/mm/modelvideo/g;
    //   78: astore_2
    //   79: ldc_w 430
    //   82: ldc_w 432
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_2
    //   92: invokevirtual 437	com/tencent/mm/modelvideo/g:KP	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_2
    //   99: getfield 440	com/tencent/mm/modelvideo/g:hGf	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 357	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_2
    //   107: getfield 440	com/tencent/mm/modelvideo/g:hGf	Ljava/lang/String;
    //   110: invokestatic 444	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   113: ifne +14 -> 127
    //   116: invokestatic 448	com/tencent/mm/modelcdntran/g:Em	()Lcom/tencent/mm/modelcdntran/c;
    //   119: aload_2
    //   120: getfield 440	com/tencent/mm/modelvideo/g:hGf	Ljava/lang/String;
    //   123: invokevirtual 453	com/tencent/mm/modelcdntran/c:iP	(Ljava/lang/String;)Z
    //   126: pop
    //   127: aload_2
    //   128: iconst_1
    //   129: putfield 456	com/tencent/mm/modelvideo/g:hYi	Z
    //   132: invokestatic 460	com/tencent/mm/kernel/h:vd	()Lcom/tencent/mm/y/n;
    //   135: sipush 149
    //   138: aload_1
    //   139: invokevirtual 465	com/tencent/mm/y/n:b	(ILcom/tencent/mm/y/e;)V
    //   142: invokestatic 460	com/tencent/mm/kernel/h:vd	()Lcom/tencent/mm/y/n;
    //   145: sipush 150
    //   148: aload_1
    //   149: invokevirtual 465	com/tencent/mm/y/n:b	(ILcom/tencent/mm/y/e;)V
    //   152: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   155: getfield 114	com/tencent/mm/modelvideo/o:hZF	Lcom/tencent/mm/modelvideo/m;
    //   158: ifnull +56 -> 214
    //   161: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   164: getfield 114	com/tencent/mm/modelvideo/o:hZF	Lcom/tencent/mm/modelvideo/m;
    //   167: astore_1
    //   168: aload_1
    //   169: iconst_0
    //   170: putfield 466	com/tencent/mm/modelvideo/m:fBf	I
    //   173: ldc_w 468
    //   176: ldc_w 470
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_1
    //   186: getfield 473	com/tencent/mm/modelvideo/m:hZd	Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 357	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_1
    //   194: getfield 473	com/tencent/mm/modelvideo/m:hZd	Ljava/lang/String;
    //   197: invokestatic 444	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   200: ifne +14 -> 214
    //   203: invokestatic 448	com/tencent/mm/modelcdntran/g:Em	()Lcom/tencent/mm/modelcdntran/c;
    //   206: aload_1
    //   207: getfield 473	com/tencent/mm/modelvideo/m:hZd	Ljava/lang/String;
    //   210: invokevirtual 453	com/tencent/mm/modelcdntran/c:iP	(Ljava/lang/String;)Z
    //   213: pop
    //   214: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   217: getfield 118	com/tencent/mm/modelvideo/o:hZJ	Lcom/tencent/mm/modelvideo/i;
    //   220: ifnull +21 -> 241
    //   223: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   226: getfield 118	com/tencent/mm/modelvideo/o:hZJ	Lcom/tencent/mm/modelvideo/i;
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 476	com/tencent/mm/modelvideo/i:stopDownload	()V
    //   234: aload_1
    //   235: getfield 480	com/tencent/mm/modelvideo/i:hYN	Ljava/util/LinkedList;
    //   238: invokevirtual 485	java/util/LinkedList:clear	()V
    //   241: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   244: getfield 116	com/tencent/mm/modelvideo/o:hZI	Lcom/tencent/mm/modelcdntran/f;
    //   247: ifnull +20 -> 267
    //   250: invokestatic 153	com/tencent/mm/modelvideo/o:KV	()Lcom/tencent/mm/modelvideo/o;
    //   253: getfield 116	com/tencent/mm/modelvideo/o:hZI	Lcom/tencent/mm/modelcdntran/f;
    //   256: astore_1
    //   257: invokestatic 460	com/tencent/mm/kernel/h:vd	()Lcom/tencent/mm/y/n;
    //   260: sipush 379
    //   263: aload_1
    //   264: invokevirtual 465	com/tencent/mm/y/n:b	(ILcom/tencent/mm/y/e;)V
    //   267: bipush 43
    //   269: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: invokestatic 488	com/tencent/mm/y/d$c:aA	(Ljava/lang/Object;)V
    //   275: bipush 44
    //   277: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: invokestatic 488	com/tencent/mm/y/d$c:aA	(Ljava/lang/Object;)V
    //   283: bipush 62
    //   285: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: invokestatic 488	com/tencent/mm/y/d$c:aA	(Ljava/lang/Object;)V
    //   291: getstatic 368	com/tencent/mm/sdk/b/a:uql	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 123	com/tencent/mm/modelvideo/o:hZL	Lcom/tencent/mm/sdk/b/c;
    //   298: invokevirtual 492	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 60	com/tencent/mm/modelvideo/o:hZH	Lcom/tencent/mm/sdk/platformtools/ad;
    //   305: ifnull +10 -> 315
    //   308: getstatic 60	com/tencent/mm/modelvideo/o:hZH	Lcom/tencent/mm/sdk/platformtools/ad;
    //   311: aconst_null
    //   312: invokevirtual 263	com/tencent/mm/sdk/platformtools/ad:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   315: invokestatic 494	com/tencent/mm/modelvideo/o:Lb	()Lcom/tencent/mm/modelvideo/x$a;
    //   318: astore_1
    //   319: ldc_w 496
    //   322: ldc_w 498
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload_1
    //   332: getfield 501	com/tencent/mm/modelvideo/x$a:iaz	Landroid/os/HandlerThread;
    //   335: aastore
    //   336: invokestatic 357	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: aload_1
    //   340: getfield 501	com/tencent/mm/modelvideo/x$a:iaz	Landroid/os/HandlerThread;
    //   343: astore_2
    //   344: aload_2
    //   345: ifnull +74 -> 419
    //   348: aload_1
    //   349: getfield 501	com/tencent/mm/modelvideo/x$a:iaz	Landroid/os/HandlerThread;
    //   352: invokevirtual 504	android/os/HandlerThread:quit	()Z
    //   355: pop
    //   356: aload_1
    //   357: iconst_0
    //   358: putfield 507	com/tencent/mm/modelvideo/x$a:iaB	Z
    //   361: aload_1
    //   362: aconst_null
    //   363: putfield 510	com/tencent/mm/modelvideo/x$a:iaA	Lcom/tencent/mm/sdk/platformtools/ad;
    //   366: aload_1
    //   367: aconst_null
    //   368: putfield 501	com/tencent/mm/modelvideo/x$a:iaz	Landroid/os/HandlerThread;
    //   371: ldc2_w 408
    //   374: sipush 2446
    //   377: invokestatic 97	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   380: return
    //   381: astore_1
    //   382: ldc -18
    //   384: aload_1
    //   385: ldc_w 512
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 516	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: goto -128 -> 267
    //   398: astore_1
    //   399: ldc_w 496
    //   402: ldc_w 518
    //   405: iconst_1
    //   406: anewarray 4	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload_1
    //   412: invokevirtual 521	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: aastore
    //   416: invokestatic 523	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: ldc2_w 408
    //   422: sipush 2446
    //   425: invokestatic 97	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   428: return
    //   429: astore_1
    //   430: ldc -18
    //   432: ldc_w 525
    //   435: iconst_1
    //   436: anewarray 4	java/lang/Object
    //   439: dup
    //   440: iconst_0
    //   441: aload_1
    //   442: invokevirtual 521	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   445: aastore
    //   446: invokestatic 523	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: ldc2_w 408
    //   452: sipush 2446
    //   455: invokestatic 97	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   458: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	o
    //   46	321	1	localObject1	Object
    //   381	4	1	localException1	Exception
    //   398	14	1	localException2	Exception
    //   429	13	1	localException3	Exception
    //   78	267	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	67	381	java/lang/Exception
    //   67	127	381	java/lang/Exception
    //   127	132	381	java/lang/Exception
    //   132	152	381	java/lang/Exception
    //   152	214	381	java/lang/Exception
    //   214	241	381	java/lang/Exception
    //   241	267	381	java/lang/Exception
    //   348	371	398	java/lang/Exception
    //   315	344	429	java/lang/Exception
    //   371	380	429	java/lang/Exception
    //   399	419	429	java/lang/Exception
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(328430780416L, 2447);
    HashMap localHashMap = gJh;
    GMTrace.o(328430780416L, 2447);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */