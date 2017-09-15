package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class l
  extends k
  implements j
{
  protected static int cCe;
  private static boolean hKB;
  private static int hKE;
  public String TAG;
  private int errCode;
  private int errType;
  private String fOW;
  private com.tencent.mm.y.e gUt;
  public boolean hJL;
  private int hJN;
  private g.a hJO;
  private long hJQ;
  public boolean hJR;
  public s hKA;
  private boolean hKC;
  private ai hKD;
  public int hKF;
  private boolean hKG;
  public String hKH;
  public w.b hKI;
  public long hKJ;
  private ai hqz;
  
  static
  {
    GMTrace.i(13432510218240L, 100080);
    cCe = 7;
    hKB = false;
    hKE = 0;
    GMTrace.o(13432510218240L, 100080);
  }
  
  public l(int paramInt)
  {
    GMTrace.i(13429557428224L, 100058);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.fOW = "";
    this.hKA = null;
    this.hKC = false;
    this.hJN = 0;
    this.hqz = null;
    this.hKD = null;
    this.hJQ = -1L;
    this.hJR = false;
    this.hKG = false;
    this.hJL = false;
    this.hKH = "";
    this.hKI = null;
    this.hKJ = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    v.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bf.bJP() });
    this.hKH = ag.bJd();
    this.hJO = new g.a();
    if (this.hKA == null) {
      this.hKA = new s();
    }
    this.hKA.hMu = paramInt;
    com.tencent.mm.kernel.h.vJ();
    if ((com.tencent.mm.kernel.h.vI() != null) && (com.tencent.mm.kernel.h.vG().uV()))
    {
      com.tencent.mm.kernel.h.vJ();
      if ((com.tencent.mm.kernel.h.vI().vr() != null) && (!com.tencent.mm.kernel.a.uP()))
      {
        com.tencent.mm.kernel.h.vJ();
        long l = bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.h.vJ();
          com.tencent.mm.kernel.h.vI().vr().set(8196, Long.valueOf(0L));
          int i = (int)(l | cCe);
          cCe = i;
          cCe = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      hKB = true;
    }
    if (paramInt == 1010)
    {
      cCe |= 0x10;
      hKB = true;
      this.hKF = 7;
    }
    for (;;)
    {
      if (hKE == 0) {
        Hu();
      }
      GMTrace.o(13429557428224L, 100058);
      return;
      if (paramInt == 1011)
      {
        cCe |= 0x40;
        hKB = true;
        this.hKF = 7;
      }
      else if (paramInt == 3)
      {
        cCe |= 0x40000;
        hKB = true;
        this.hKF = 3;
        v.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(cCe), Integer.valueOf(this.hKF) });
      }
      else
      {
        this.hKF = paramInt;
      }
    }
  }
  
  public l(final w.b paramb, int paramInt, long paramLong)
  {
    this(8);
    GMTrace.i(13429691645952L, 100059);
    this.hKH = ag.bJd();
    v.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.sXV), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.hJN = paramInt;
    this.hJQ = paramLong;
    this.hqz = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13429423210496L, 100057);
        l.this.hJR = true;
        l.a locala = new l.a(paramb);
        com.tencent.mm.plugin.report.c.oRz.a(99L, 230L, 1L, false);
        l.this.a(-1, 0, 0, "", locala, null);
        GMTrace.o(13429423210496L, 100057);
        return false;
      }
    }, false);
    if (hKE == 0) {
      Hu();
    }
    GMTrace.o(13429691645952L, 100059);
  }
  
  private boolean Hu()
  {
    GMTrace.i(13430899605504L, 100068);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    final Object localObject1 = f.a((PInt)localObject2, com.tencent.mm.kernel.a.uH());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      v.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      hKE = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bf.bm((byte[])localObject1))) {
        break;
      }
      hKE = 0;
      GMTrace.o(13430899605504L, 100068);
      return false;
    }
    localObject2 = new w.b();
    try
    {
      ((w.b)localObject2).y((byte[])localObject1);
      localObject1 = new a((w.b)localObject2);
      this.hKD = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(13446468861952L, 100184);
          l.this.hJR = true;
          com.tencent.mm.plugin.report.c.oRz.a(99L, 231L, 1L, false);
          l.this.a(-1, 0, 0, "", localObject1, null);
          GMTrace.o(13446468861952L, 100184);
          return false;
        }
      }, false);
      GMTrace.o(13430899605504L, 100068);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.c.oRz.a(99L, 226L, 1L, false);
      v.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = hKE;
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG();
      f.ay(i, com.tencent.mm.kernel.a.uH());
      hKE = 0;
      GMTrace.o(13430899605504L, 100068);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      v.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      GMTrace.o(13430899605504L, 100068);
    }
    return false;
  }
  
  private boolean Hv()
  {
    GMTrace.i(13431302258688L, 100071);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)aa.getContext().getSystemService("power"), new Object[0])).booleanValue();
      GMTrace.o(13431302258688L, 100071);
      return bool;
    }
    catch (Exception localException)
    {
      v.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.valueOf(true), bf.g(localException) });
      GMTrace.o(13431302258688L, 100071);
    }
    return true;
  }
  
  public final boolean BI()
  {
    GMTrace.i(13429960081408L, 100061);
    GMTrace.o(13429960081408L, 100061);
    return true;
  }
  
  public final boolean BJ()
  {
    int i = 1;
    GMTrace.i(13430362734592L, 100064);
    boolean bool = super.BJ();
    com.tencent.mm.plugin.report.c localc;
    if (bool)
    {
      com.tencent.mm.plugin.report.c.oRz.a(99L, 228L, 1L, false);
      localc = com.tencent.mm.plugin.report.c.oRz;
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label132;
      }
    }
    for (;;)
    {
      localc.i(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      GMTrace.o(13430362734592L, 100064);
      return bool;
      label132:
      i = 2;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13430765387776L, 100067);
    if (m.Hw())
    {
      hKE = 0;
      v.e(this.TAG, "dkinit never do sync before init done");
      GMTrace.o(13430765387776L, 100067);
      return -1;
    }
    this.gUt = parame1;
    if (this.hKA == null) {
      this.hKA = new s();
    }
    this.hKA.hMt = com.tencent.mm.sdk.a.b.foreground;
    if (this.hKD != null)
    {
      v.i(this.TAG, "pushSyncRespHandler not null");
      c(parame);
      this.hKD.v(0L, 0L);
      GMTrace.o(13430765387776L, 100067);
      return 0;
    }
    if (hKE > 0)
    {
      v.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(hKE) });
      GMTrace.o(13430765387776L, 100067);
      return -1;
    }
    if (this.hqz != null)
    {
      v.i(this.TAG, "pusher not null");
      c(parame);
      this.hqz.v(0L, 0L);
      GMTrace.o(13430765387776L, 100067);
      return 0;
    }
    parame1 = new a();
    anq localanq = ((w.a)parame1.BG()).sYw;
    if (this.hKF == 3)
    {
      localanq.tRh = 1;
      if (!this.hKG) {
        break label401;
      }
    }
    label401:
    for (int i = 6;; i = this.hKF)
    {
      this.hKF = i;
      localanq.tmu = cCe;
      com.tencent.mm.kernel.h.vJ();
      byte[] arrayOfByte = bf.PS(bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, new byte[0])));
      localanq.tmv = com.tencent.mm.platformtools.n.G(arrayOfByte);
      localanq.tcg = this.hKF;
      localanq.tRg = new lu();
      localanq.tfX = d.DEVICE_TYPE;
      v.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localanq.tmu), Integer.valueOf(localanq.tcg), com.tencent.mm.protocal.ad.ba(arrayOfByte) });
      hKB = false;
      i = a(parame, parame1, this);
      GMTrace.o(13430765387776L, 100067);
      return i;
      localanq.tRh = 0;
      break;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13430228516864L, 100063);
    int i = k.b.hsC;
    GMTrace.o(13430228516864L, 100063);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13431033823232L, 100069);
    if ((paramp == null) || (paramp.getType() != 138))
    {
      paramString = this.TAG;
      if (paramp == null) {}
      for (paramInt1 = -2;; paramInt1 = paramp.getType())
      {
        v.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        GMTrace.o(13431033823232L, 100069);
        return;
      }
    }
    w.b localb = (w.b)paramp.zg();
    paramArrayOfByte = this.TAG;
    long l = this.hJO.se();
    boolean bool = this.hJR;
    if (localb.sYx.tmy == null)
    {
      paramInt1 = -1;
      v.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.hqz, this.hKD });
      if (localb.sYx.tmy != null) {
        break label390;
      }
      paramInt1 = -1;
      label211:
      if (paramInt1 <= 0) {
        break label405;
      }
      paramInt1 = 1;
      label217:
      if (Hv()) {
        break label418;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.c.oRz;
      if (paramInt1 == 0) {
        break label410;
      }
      l = 221L;
      label238:
      paramArrayOfByte.a(99L, l, 1L, false);
      this.hqz = null;
      this.hKC = true;
      if ((paramInt2 != 4) || (paramInt3 != 63530)) {
        break label875;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.c.oRz.a(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.hKI != null)
        {
          v.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.fOW = paramString;
          ((w.b)paramp.zg()).sYx.tkt = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.c.oRz.a(99L, 232L, 1L, false);
          GMTrace.o(13431033823232L, 100069);
          return;
          paramInt1 = localb.sYx.tmy.jLr;
          break;
          label390:
          paramInt1 = localb.sYx.tmy.jLr;
          break label211;
          label405:
          paramInt1 = 0;
          break label217;
          label410:
          l = 218L;
          break label238;
          label418:
          if (!com.tencent.mm.sdk.a.b.foreground)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.c.oRz;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.a(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.c.oRz;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.a(99L, l, 1L, false);
            break;
          }
          this.gUt.a(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.c.oRz.a(99L, 233L, 1L, false);
      paramArrayOfByte = com.tencent.mm.platformtools.n.a(((w.a)paramp.BG()).sYw.tmv);
      paramp = com.tencent.mm.platformtools.n.a(localb.sYx.tmv);
      v.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.ba(paramArrayOfByte) });
      v.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.ba(paramp) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bf.bm(paramArrayOfByte))
        {
          com.tencent.mm.kernel.h.vJ();
          paramString = bf.PS(bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, new byte[0])));
          v.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bf.bl(paramString) });
        }
        paramArrayOfByte = com.tencent.mm.protocal.ad.g(paramString, paramp);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          v.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramp;
        }
        localb.sYx.tmv = com.tencent.mm.platformtools.n.G(paramString);
      }
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG().aF(localb.sYx.jLP, localb.sYx.tRi);
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG();
      com.tencent.mm.kernel.a.eM(localb.sYx.jLP);
      if (this.hKI == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.hKI = localb;
        this.hKJ = bf.NA();
        new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
        {
          private int hKM;
          private long hKN;
          private int hKO;
          
          public final boolean oQ()
          {
            GMTrace.i(13437342056448L, 100116);
            Object localObject2 = new com.tencent.mm.plugin.zero.c();
            if (!com.tencent.mm.kernel.h.vG().uV())
            {
              v.e(l.this.TAG, "syncRespHandler acc is not ready STOP :%s", new Object[] { l.this.hKI });
              l.this.hKI = null;
              GMTrace.o(13437342056448L, 100116);
              return false;
            }
            if (l.this.hJL)
            {
              ((com.tencent.mm.plugin.zero.c)localObject2).aZ(l.this);
              l.this.hKI = null;
              GMTrace.o(13437342056448L, 100116);
              return false;
            }
            if ((l.this.hKI == null) || (l.this.hKI.sYx.tmy == null) || (l.this.hKI.sYx.tmy.jLs == null))
            {
              v.e(l.this.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { l.this.hKI });
              ((com.tencent.mm.plugin.zero.c)localObject2).aZ(l.this);
              l.this.hKI = null;
              GMTrace.o(13437342056448L, 100116);
              return false;
            }
            Object localObject1 = l.this.hKI.sYx.tmy.jLs;
            ((com.tencent.mm.plugin.zero.c)localObject2).aX(l.this);
            this.hKO += 1;
            long l1 = bf.NA();
            int i = 0;
            while (i < 5)
            {
              if (this.hKM < ((LinkedList)localObject1).size())
              {
                v.v(l.this.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.hKM), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((lt)((LinkedList)localObject1).get(this.hKM)).tqs), Integer.valueOf(((lt)((LinkedList)localObject1).get(this.hKM)).tqt.tXB) });
                ((LinkedList)localObject1).size();
                if (!((com.tencent.mm.plugin.zero.c)localObject2).a((lt)((LinkedList)localObject1).get(this.hKM), false)) {
                  v.w(l.this.TAG, "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.hKM) });
                }
                this.hKM += 1;
              }
              if (this.hKM >= ((LinkedList)localObject1).size())
              {
                this.hKN += bf.aA(l1);
                l2 = bf.aA(l.this.hKJ);
                v.i(l.this.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.hKM), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.hKN), Integer.valueOf(this.hKO), l.this.hKI });
                l.this.a(l.this.hKI);
                ((com.tencent.mm.plugin.zero.c)localObject2).aY(l.this);
                i = bf.f((Integer)com.tencent.mm.plugin.report.c.a((int)this.hKN, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.c.oRz.a(99L, i, 1L, false);
                i = bf.f((Integer)com.tencent.mm.plugin.report.c.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.c.oRz.a(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.c.oRz;
                int j;
                int k;
                int m;
                int n;
                if (com.tencent.mm.sdk.a.b.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.c)localObject2).a(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.c.oRz.a(99L, l.this.hKF, 1L, false);
                  com.tencent.mm.plugin.report.c.oRz.a(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.c.oRz;
                  j = ((LinkedList)localObject1).size();
                  k = l.this.hKF;
                  m = l.this.hKI.sYx.tkt;
                  l1 = this.hKN;
                  n = this.hKO;
                  localObject1 = l.this.hKH;
                  if (!com.tencent.mm.sdk.a.b.foreground) {
                    break label1005;
                  }
                }
                label1005:
                for (i = 1;; i = 2)
                {
                  ((com.tencent.mm.plugin.report.c)localObject2).i(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
                  l.this.hKI = null;
                  GMTrace.o(13437342056448L, 100116);
                  return false;
                  l1 = 242L;
                  break;
                }
              }
              long l2 = bf.aA(l1);
              if (l2 > 500L)
              {
                v.d(l.this.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.hKM), l.this.hKI });
                this.hKN += bf.aA(l1);
                GMTrace.o(13437342056448L, 100116);
                return true;
              }
              i += 1;
            }
            this.hKN += bf.aA(l1);
            GMTrace.o(13437342056448L, 100116);
            return true;
          }
        }, true).v(50L, 50L);
        GMTrace.o(13431033823232L, 100069);
        return;
      }
      label875:
      bool = false;
    }
  }
  
  protected final void a(w.b paramb)
  {
    GMTrace.i(15700924039168L, 116981);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().set(8195, bf.bo(com.tencent.mm.platformtools.n.a(paramb.sYx.tmv)));
    aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bf.bo(com.tencent.mm.platformtools.n.a(paramb.sYx.tmv))).commit();
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vr().set(8196, Long.valueOf(paramb.sYx.tkt));
    boolean bool;
    Object localObject;
    if (((paramb.sYx.tkt & cCe) != 0) && (!super.BJ()))
    {
      bool = true;
      v.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.sYx.tkt), Integer.valueOf(cCe), Boolean.valueOf(super.BJ()) });
      if ((!bool) && ((paramb.sYx.tkt & 0x100) != 0))
      {
        localObject = new pi();
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.c.oRz;
      if (!bool) {
        break label371;
      }
    }
    label371:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.c)localObject).a(99L, l, 1L, false);
      v.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.sYx.tkt), Boolean.valueOf(this.hJR), Boolean.valueOf(bool), Boolean.valueOf(hKB), Integer.valueOf(this.hJN), Boolean.valueOf(this.hKG), this.hKD });
      if ((this.hJR) || (!bool)) {
        break label379;
      }
      this.hKG = true;
      a(this.hsm, this.gUt);
      GMTrace.o(15700924039168L, 116981);
      return;
      bool = false;
      break;
    }
    label379:
    int i;
    if (hKB)
    {
      v.i(this.TAG, "dkpush new notify pending, sync now");
      if (hKE != 0)
      {
        i = hKE;
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG();
        f.ay(i, com.tencent.mm.kernel.a.uH());
      }
      hKE = 0;
      this.hKD = null;
      hKB = false;
      this.hKG = true;
      a(this.hsm, this.gUt);
      GMTrace.o(15700924039168L, 116981);
      return;
    }
    if (this.hKD != null)
    {
      i = hKE;
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG();
      f.ay(i, com.tencent.mm.kernel.a.uH());
      this.hKD = null;
      Hu();
      a(this.hsm, this.gUt);
      GMTrace.o(15700924039168L, 116981);
      return;
    }
    if ((this.hJN & 0x1) > 0)
    {
      com.tencent.mm.kernel.h.vJ();
      paramb = bf.PS(bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, null)));
      com.tencent.mm.kernel.h.vd().a(new h(this.hJQ, paramb), 0);
    }
    v.d(this.TAG, "sync or init end: reset selector : now = " + cCe + " default = 7");
    cCe = 7;
    this.gUt.a(this.errType, this.errCode, this.fOW, this);
    GMTrace.o(15700924039168L, 116981);
  }
  
  protected final boolean a(k paramk)
  {
    boolean bool = true;
    GMTrace.i(13429825863680L, 100060);
    if (!(paramk instanceof l))
    {
      GMTrace.o(13429825863680L, 100060);
      return false;
    }
    paramk = (l)paramk;
    if ((!paramk.hKC) && (hKB))
    {
      v.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramk.hsn) });
      if (bf.aB(paramk.hsn) > 360000L) {}
      while (bool)
      {
        v.i(this.TAG, "summerworker NetSceneSync timeout");
        paramk = com.tencent.mm.kernel.h.vL().bJb().findTaskByRunTime(0L);
        if (paramk == null) {
          break;
        }
        v.e(this.TAG, "summerworker worker is just blocked by task: " + com.tencent.mm.sdk.platformtools.ad.dump(paramk, false));
        GMTrace.o(13429825863680L, 100060);
        return false;
        bool = false;
      }
      GMTrace.o(13429825863680L, 100060);
      return bool;
    }
    GMTrace.o(13429825863680L, 100060);
    return false;
  }
  
  protected final void cancel()
  {
    GMTrace.i(13430631170048L, 100066);
    super.cancel();
    com.tencent.mm.plugin.report.c.oRz.a(99L, 229L, 1L, false);
    this.hJL = true;
    GMTrace.o(13430631170048L, 100066);
  }
  
  public final int getType()
  {
    GMTrace.i(13430496952320L, 100065);
    GMTrace.o(13430496952320L, 100065);
    return 138;
  }
  
  protected final int ub()
  {
    GMTrace.i(13430094299136L, 100062);
    GMTrace.o(13430094299136L, 100062);
    return 100;
  }
  
  public static final class a
    extends i
  {
    private final w.a hJU;
    private final w.b hJV;
    private final boolean hJW;
    
    public a()
    {
      GMTrace.i(13449153216512L, 100204);
      this.hJU = new w.a();
      this.hJV = new w.b();
      this.hJW = false;
      GMTrace.o(13449153216512L, 100204);
    }
    
    public a(w.b paramb)
    {
      GMTrace.i(13449287434240L, 100205);
      this.hJU = new w.a();
      this.hJV = paramb;
      this.hJW = true;
      GMTrace.o(13449287434240L, 100205);
    }
    
    public final int getType()
    {
      GMTrace.i(13449690087424L, 100208);
      GMTrace.o(13449690087424L, 100208);
      return 138;
    }
    
    public final String getUri()
    {
      GMTrace.i(13449824305152L, 100209);
      GMTrace.o(13449824305152L, 100209);
      return "/cgi-bin/micromsg-bin/newsync";
    }
    
    public final k.d zf()
    {
      GMTrace.i(13449421651968L, 100206);
      w.a locala = this.hJU;
      GMTrace.o(13449421651968L, 100206);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(13449555869696L, 100207);
      w.b localb = this.hJV;
      GMTrace.o(13449555869696L, 100207);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */