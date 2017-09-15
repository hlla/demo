package com.tencent.mm.ui.chatting.gallery;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.i.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class l
{
  public String filename;
  int hXL;
  int hXM;
  com.tencent.mm.plugin.a.f hXN;
  public int hXO;
  int hXP;
  boolean hXR;
  int hXS;
  private int hXT;
  public boolean hXU;
  boolean hXV;
  long hyY;
  int iyv;
  String mediaId;
  private int quA;
  HashMap<String, Integer> qut;
  int quv;
  public int quw;
  long qux;
  public long quy;
  private long quz;
  public i vRT;
  a vRU;
  
  public l(i parami)
  {
    GMTrace.i(2411355701248L, 17966);
    this.hXL = 0;
    this.hXM = 0;
    this.hXS = 0;
    this.qut = new HashMap();
    this.quw = 0;
    this.hXU = false;
    this.hXV = false;
    this.vRT = parami;
    reset();
    this.hXN = new com.tencent.mm.plugin.a.f();
    this.vRU = new a();
    parami = com.tencent.mm.i.g.sV().getValue("AndroidOnlineVideoArgs");
    if (!bf.mA(parami))
    {
      v.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + parami);
      parami = parami.split(";");
      if ((parami != null) && (parami.length >= 4))
      {
        this.vRU.hYb = bf.getInt(parami[0], 5);
        this.vRU.hYc = bf.getInt(parami[1], 1);
        this.vRU.quD = bf.getInt(parami[2], 75);
        this.vRU.vRW = (bf.getInt(parami[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.vRU.hYb = 5;
        this.vRU.hYc = 1;
        this.vRU.quD = 75;
        this.vRU.vRW = 1048576;
      }
      v.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.vRU.hYb), Integer.valueOf(this.vRU.hYc), Integer.valueOf(this.vRU.quD), Integer.valueOf(this.vRU.vRW) });
      this.hXT = this.vRU.hYb;
      GMTrace.o(2411355701248L, 17966);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    GMTrace.i(2412429443072L, 17974);
    paramPInt1.value = Math.max(paramInt, this.hXS);
    if (this.hXM == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hXT;
    }
    if (this.hXM == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hXT + 8);
    }
    if ((this.hXM == 3) || (this.hXM == 4))
    {
      paramPInt1.value = this.hXS;
      paramPInt2.value = (this.hXT + paramInt + 2 + this.vRU.hYc);
    }
    if (paramPInt2.value >= this.hXO + 1) {
      paramPInt2.value = (this.hXO + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.vRU.hYc;
      GMTrace.o(2412429443072L, 17974);
      return false;
    }
    v.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hXM), Integer.valueOf(this.hXS), Integer.valueOf(this.hXT) });
    GMTrace.o(2412429443072L, 17974);
    return true;
  }
  
  private boolean g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(2412563660800L, 17975);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.hXN.a(paramInt1, paramInt2, localPInt1, localPInt2)) {
        bool1 = o.KX().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
      }
      if (!bool1) {
        if (!this.qut.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          v.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.hXV), Boolean.valueOf(paramBoolean) });
          if ((!this.qut.containsKey(str)) && ((!this.hXV) || (paramBoolean)))
          {
            this.hXV = true;
            o.KX();
            com.tencent.mm.modelcdntran.f.e(this.mediaId, localPInt1.value, localPInt2.value);
            this.qut.put(str, Integer.valueOf(paramInt2));
          }
        }
        else
        {
          GMTrace.o(2412563660800L, 17975);
          return bool1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        v.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        bool1 = bool2;
        continue;
        v.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + localException);
        continue;
        v.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean GM(String paramString)
  {
    GMTrace.i(2411758354432L, 17969);
    boolean bool = bf.eB(paramString, this.mediaId);
    GMTrace.o(2411758354432L, 17969);
    return bool;
  }
  
  public final boolean am(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2412026789888L, 17971);
    switch (this.hXL)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      v.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hXL), Integer.valueOf(this.hXM) });
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 4L, 1L, false);
      GMTrace.o(2412026789888L, 17971);
      return paramBoolean;
      this.hXM = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (g(localPInt1.value, localPInt2.value, true))
      {
        this.hXP = -1;
        this.hXR = false;
        this.hXS = localPInt2.value;
        this.hXM = 3;
        this.vRT.K(paramInt, paramBoolean);
        break;
      }
      this.hXP = paramInt;
      this.hXR = true;
      this.vRT.KH();
    }
  }
  
  public final void bXp()
  {
    GMTrace.i(2411624136704L, 17968);
    v.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.hXL == 3)
    {
      i = 1;
      this.hXL = 0;
      if (!bf.mA(this.mediaId))
      {
        if (i == 0) {
          break label94;
        }
        bXr();
      }
    }
    for (;;)
    {
      o.KX().b(this.mediaId, bXs());
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 2L, 1L, false);
      GMTrace.o(2411624136704L, 17968);
      return;
      i = 0;
      break;
      label94:
      if (this.quv >= this.vRU.quD)
      {
        v.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.quv), Integer.valueOf(this.vRU.quD) });
        t.I(this.filename, 2);
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 10L, 1L, false);
      }
    }
  }
  
  public final void bXq()
  {
    GMTrace.i(2412697878528L, 17976);
    String str = this.mediaId + 0 + "_-1";
    if (!this.qut.containsKey(str))
    {
      v.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      o.KX();
      com.tencent.mm.modelcdntran.f.e(this.mediaId, 0, -1);
      this.qut.put(str, Integer.valueOf(0));
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 24L, 1L, false);
      v.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
      com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bf.Nz()), "" });
    }
    this.hXM = 5;
    GMTrace.o(2412697878528L, 17976);
  }
  
  final void bXr()
  {
    GMTrace.i(17604399857664L, 131163);
    o.KW();
    boolean bool;
    if (q.lq(s.lw(this.filename)))
    {
      v.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete");
      r localr = t.lI(this.filename);
      if ((localr == null) || (localr.videoFormat == 2)) {
        break label158;
      }
      localr.videoFormat = 2;
      localr.hZU = bf.Nz();
      localr.hZT = bf.Nz();
      localr.hzd = 16;
      localr.fRM = 268438530;
      bool = o.KW().b(localr);
      v.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + localr.status);
    }
    for (;;)
    {
      if (bool) {
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 134L, 1L, false);
      }
      GMTrace.o(17604399857664L, 131163);
      return;
      label158:
      bool = false;
    }
  }
  
  final Object[] bXs()
  {
    int j = 0;
    GMTrace.i(2412832096256L, 17977);
    Object[] arrayOfObject = new Object[7];
    i locali = this.vRT;
    if (locali.qum < 0) {
      locali.qum = 0;
    }
    v.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { locali.filename, Integer.valueOf(locali.qum) });
    arrayOfObject[0] = Integer.valueOf(locali.qum);
    if (this.quy <= 0L) {
      this.quy = bf.NA();
    }
    int k = (int)(this.quy - this.hyY);
    int i = k;
    if (k <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.qux <= 0L) {
      this.qux = bf.NA();
    }
    k = (int)(this.qux - this.hyY);
    i = k;
    if (k <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.quw);
    if (this.quw > 0)
    {
      if (this.quA == 0) {
        this.quA = ((int)(this.quA + bf.aA(this.quz)));
      }
      arrayOfObject[4] = Integer.valueOf(this.quA / this.quw);
      locali = this.vRT;
      if ((locali.qug <= 0L) || (locali.quf <= 0L)) {
        break label321;
      }
    }
    label321:
    for (i = (int)(locali.qug - locali.quf);; i = 0)
    {
      if (i < 0) {
        i = j;
      }
      for (;;)
      {
        arrayOfObject[5] = Integer.valueOf(i);
        arrayOfObject[6] = Integer.valueOf(this.vRT.lIE);
        GMTrace.o(2412832096256L, 17977);
        return arrayOfObject;
        arrayOfObject[4] = Integer.valueOf(0);
        break;
      }
    }
  }
  
  final void bjp()
  {
    GMTrace.i(2411892572160L, 17970);
    v.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2440615165952L, 18184);
        if (l.this.vRT != null) {
          l.this.vRT.as(l.this.filename, false);
        }
        GMTrace.o(2440615165952L, 18184);
      }
    });
    GMTrace.o(2411892572160L, 17970);
  }
  
  public final boolean gK(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    GMTrace.i(2412161007616L, 17972);
    if (this.hXP != -1) {}
    for (int i = this.hXP;; i = paramInt)
    {
      v.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hXS), Integer.valueOf(this.hXO), Integer.valueOf(this.hXL), Long.valueOf(this.quy - this.hyY), Boolean.valueOf(this.hXU) });
      boolean bool1 = bool2;
      switch (this.hXL)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        GMTrace.o(2412161007616L, 17972);
        return bool1;
        if (!gL(i))
        {
          this.hXR = true;
          if (this.hXS <= 0) {
            if (this.hXP == -1)
            {
              this.hXM = 1;
              label191:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.vRT.BD(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label685;
          }
          if (!g(localPInt1.value, localPInt2.value, false)) {
            break label693;
          }
          this.hXS = Math.max(this.hXS, localPInt2.value);
          bool1 = bool2;
          break;
          this.hXM = 2;
          break label191;
          v.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.quw + " playStatus : " + this.hXM);
          this.quz = bf.NA();
          if ((this.hXM != 2) && (this.hXM != 4))
          {
            this.hXT += this.vRU.hYb;
            this.hXT = Math.min(this.hXT, 60);
            this.quw += 1;
            this.hXM = 4;
          }
          this.vRT.KH();
          break label191;
          if ((this.quw == 0) && (this.quy == 0L)) {
            this.quy = bf.NA();
          }
          if (this.hXU)
          {
            this.vRT.TJ(this.filename);
            if (this.hXR) {
              if ((this.quw == 0) && (this.quy == 0L))
              {
                this.quy = bf.NA();
                label465:
                v.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.quw), Integer.valueOf(this.quA) });
                if (this.hXP == -1) {
                  break label571;
                }
                this.vRT.K(this.hXP, true);
                this.hXP = -1;
                bool1 = false;
                label524:
                this.hXR = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.hXM = paramInt;
              label571:
              do
              {
                bool1 = true;
                break;
                if (this.quz <= 0L) {
                  break label465;
                }
                this.quA = ((int)(this.quA + bf.aA(this.quz)));
                break label465;
                if (this.vRT.bjg())
                {
                  bool1 = false;
                  break label524;
                }
                bool1 = true;
                break label524;
              } while (this.hXM == 3);
              v.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.hXM) });
              if (this.vRT.bjg()) {
                paramInt = 3;
              } else {
                paramInt = this.hXM;
              }
            }
          }
          v.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.vRT.as(this.filename, true);
          this.hXU = true;
          bool1 = true;
        }
        label685:
        v.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label693:
        continue;
        if (this.hXU)
        {
          if (this.hXR)
          {
            if (this.hXP == -1) {
              break label757;
            }
            this.vRT.K(this.hXP, true);
            this.hXP = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.hXR = bool1;
            this.vRT.BD(i);
            bool1 = bool2;
            break;
            label757:
            if (this.vRT.bjg()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.vRT.as(this.filename, false);
        this.hXU = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean gL(int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 507
    //   3: sipush 17973
    //   6: invokestatic 56	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 58	com/tencent/mm/ui/chatting/gallery/l:hXL	I
    //   13: iconst_3
    //   14: if_icmpne +14 -> 28
    //   17: ldc2_w 507
    //   20: sipush 17973
    //   23: invokestatic 169	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 62	com/tencent/mm/ui/chatting/gallery/l:hXS	I
    //   32: iload_1
    //   33: isub
    //   34: iconst_2
    //   35: if_icmpgt +25 -> 60
    //   38: aload_0
    //   39: getfield 62	com/tencent/mm/ui/chatting/gallery/l:hXS	I
    //   42: aload_0
    //   43: getfield 186	com/tencent/mm/ui/chatting/gallery/l:hXO	I
    //   46: if_icmpge +14 -> 60
    //   49: ldc2_w 507
    //   52: sipush 17973
    //   55: invokestatic 169	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   58: iconst_0
    //   59: ireturn
    //   60: new 181	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 195	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 4
    //   69: new 181	com/tencent/mm/pointers/PInt
    //   72: dup
    //   73: invokespecial 195	com/tencent/mm/pointers/PInt:<init>	()V
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 83	com/tencent/mm/ui/chatting/gallery/l:hXN	Lcom/tencent/mm/plugin/a/f;
    //   82: iload_1
    //   83: iload_1
    //   84: iconst_2
    //   85: iadd
    //   86: aload 4
    //   88: aload 5
    //   90: invokevirtual 198	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   93: ifeq +100 -> 193
    //   96: invokestatic 204	com/tencent/mm/modelvideo/o:KX	()Lcom/tencent/mm/modelcdntran/f;
    //   99: aload_0
    //   100: getfield 206	com/tencent/mm/ui/chatting/gallery/l:mediaId	Ljava/lang/String;
    //   103: aload 4
    //   105: getfield 184	com/tencent/mm/pointers/PInt:value	I
    //   108: aload 5
    //   110: getfield 184	com/tencent/mm/pointers/PInt:value	I
    //   113: invokevirtual 212	com/tencent/mm/modelcdntran/f:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   116: istore_2
    //   117: iload_2
    //   118: istore_3
    //   119: iload_2
    //   120: ifne +10 -> 130
    //   123: aload_0
    //   124: iload_1
    //   125: putfield 62	com/tencent/mm/ui/chatting/gallery/l:hXS	I
    //   128: iload_2
    //   129: istore_3
    //   130: ldc2_w 507
    //   133: sipush 17973
    //   136: invokestatic 169	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   139: iload_3
    //   140: ireturn
    //   141: astore 4
    //   143: iconst_0
    //   144: istore_2
    //   145: ldc 108
    //   147: aload 4
    //   149: ldc -15
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 245	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: ldc 108
    //   160: new 110	java/lang/StringBuilder
    //   163: dup
    //   164: ldc -9
    //   166: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload 4
    //   171: invokevirtual 248	java/lang/Exception:toString	()Ljava/lang/String;
    //   174: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 250	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload_2
    //   184: istore_3
    //   185: goto -55 -> 130
    //   188: astore 4
    //   190: goto -45 -> 145
    //   193: iconst_0
    //   194: istore_3
    //   195: goto -65 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	l
    //   0	198	1	paramInt	int
    //   116	68	2	bool1	boolean
    //   118	77	3	bool2	boolean
    //   67	37	4	localPInt1	PInt
    //   141	29	4	localException1	Exception
    //   188	1	4	localException2	Exception
    //   76	33	5	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   78	117	141	java/lang/Exception
    //   123	128	188	java/lang/Exception
  }
  
  public final boolean isStreaming()
  {
    GMTrace.i(16136192131072L, 120224);
    if ((!bf.mA(this.mediaId)) && ((this.hXL == 1) || (this.hXL == 3)))
    {
      GMTrace.o(16136192131072L, 120224);
      return true;
    }
    GMTrace.o(16136192131072L, 120224);
    return false;
  }
  
  public final void reset()
  {
    GMTrace.i(2411489918976L, 17967);
    this.mediaId = "";
    this.filename = "";
    this.hXP = -1;
    this.quv = 0;
    this.iyv = 0;
    this.hXS = 0;
    this.hXO = 0;
    this.quw = 0;
    this.hXM = 0;
    this.hXL = 0;
    this.hXR = false;
    this.hXU = false;
    this.hXV = false;
    this.qut.clear();
    if (this.vRU != null) {
      this.hXT = this.vRU.hYb;
    }
    this.qux = 0L;
    this.hyY = 0L;
    this.quA = 0;
    this.quz = 0L;
    this.quy = 0L;
    GMTrace.o(2411489918976L, 17967);
  }
  
  private static final class a
  {
    int hYb;
    int hYc;
    int quD;
    int vRW;
    
    public a()
    {
      GMTrace.i(2426656522240L, 18080);
      GMTrace.o(2426656522240L, 18080);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */