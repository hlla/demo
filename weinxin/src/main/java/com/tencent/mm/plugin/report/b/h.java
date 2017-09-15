package com.tencent.mm.plugin.report.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class h
  extends k
  implements j
{
  private static boolean aJi;
  private static Object lock;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private a oRQ;
  private ww oRU;
  
  static
  {
    GMTrace.i(13105018961920L, 97640);
    aJi = false;
    lock = new Object();
    GMTrace.o(13105018961920L, 97640);
  }
  
  public h()
  {
    GMTrace.i(13104482091008L, 97636);
    this.oRU = null;
    this.oRQ = new a();
    gC(true);
    this.oRU = SmcProtoBufUtil.toMMGetStrategyReq();
    this.oRU.tqd = new aev();
    this.oRU.tqd.tIw = this.oRQ.rS(0);
    GMTrace.o(13104482091008L, 97636);
  }
  
  private static void gC(boolean paramBoolean)
  {
    GMTrace.i(13104347873280L, 97635);
    synchronized (lock)
    {
      aJi = paramBoolean;
      GMTrace.o(13104347873280L, 97635);
      return;
    }
  }
  
  public static boolean isRunning()
  {
    GMTrace.i(13104213655552L, 97634);
    synchronized (lock)
    {
      boolean bool = aJi;
      GMTrace.o(13104213655552L, 97634);
      return bool;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13104884744192L, 97639);
    this.gUt = parame1;
    int i;
    if (!bf.bm(com.tencent.mm.kernel.h.vH().vc())) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        this.oRU.tqc = com.tencent.mm.bd.b.aU(bf.bJG());
      }
      b.a locala = new b.a();
      locala.hrZ = false;
      locala.hrV = this.oRU;
      locala.hrW = new wx();
      if (i != 0)
      {
        parame1 = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
        locala.uri = parame1;
        locala.hrU = getType();
        this.gUq = locala.BE();
        if (i == 0)
        {
          this.gUq.a(ac.bHj());
          this.gUq.fYi = 1;
        }
        i = a(parame, this.gUq, this);
        if (i < 0) {
          v.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
        }
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        gC(false);
        GMTrace.o(13104884744192L, 97639);
        return i;
        i = 0;
        continue;
        parame1 = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception parame)
      {
        for (;;)
        {
          v.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bf.g(parame) });
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13104616308736L, 97637);
    if ((com.tencent.mm.kernel.h.vH().gXs == null) || (com.tencent.mm.kernel.h.vH().gXs.hsI == null))
    {
      v.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13104616308736L, 97637);
      return;
    }
    if (paramInt2 != 0)
    {
      v.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      gC(false);
      GMTrace.o(13104616308736L, 97637);
      return;
    }
    v.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (wx)this.gUq.hrT.hsa;
    this.oRQ.a(paramArrayOfByte.tqn, 0);
    try
    {
      paramp = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, paramp.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      gC(false);
      GMTrace.o(13104616308736L, 97637);
      return;
    }
    catch (Exception paramp)
    {
      for (;;)
      {
        v.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bf.g(paramp) });
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(13104750526464L, 97638);
    if (!bf.bm(com.tencent.mm.kernel.h.vH().vc())) {}
    for (int i = 1; i != 0; i = 0)
    {
      GMTrace.o(13104750526464L, 97638);
      return 988;
    }
    GMTrace.o(13104750526464L, 97638);
    return 989;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */