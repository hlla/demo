package com.tencent.mm.plugin.report.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ae;
import com.tencent.mm.protocal.c.af;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class g
  extends k
  implements j
{
  private static boolean aJi;
  private static Object lock;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private tq oRS;
  public af oRT;
  
  static
  {
    GMTrace.i(18923625906176L, 140992);
    aJi = false;
    lock = new Object();
    GMTrace.o(18923625906176L, 140992);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    GMTrace.i(18923089035264L, 140988);
    this.oRS = null;
    gC(true);
    ae localae = new ae();
    this.oRS = new tq();
    try
    {
      localae.tbc = paramInt1;
      localae.tbd = paramInt2;
      this.oRS.tAq = localae;
      GMTrace.o(18923089035264L, 140988);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
      GMTrace.o(18923089035264L, 140988);
    }
  }
  
  private static void gC(boolean paramBoolean)
  {
    GMTrace.i(18922954817536L, 140987);
    synchronized (lock)
    {
      aJi = paramBoolean;
      GMTrace.o(18922954817536L, 140987);
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(18923491688448L, 140991);
    this.gUt = parame1;
    if (!bf.bm(h.vH().vc())) {}
    for (int i = 1; i == 0; i = 0)
    {
      v.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      GMTrace.o(18923491688448L, 140991);
      return -1;
    }
    parame1 = new b.a();
    parame1.hrZ = false;
    parame1.hrV = this.oRS;
    parame1.hrW = new tr();
    parame1.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    parame1.hrU = 914;
    this.gUq = parame1.BE();
    i = a(parame, this.gUq, this);
    if (i < 0) {
      v.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.oRT = null;
      gC(false);
      GMTrace.o(18923491688448L, 140991);
      return i;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        v.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bf.g(parame) });
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(18923223252992L, 140989);
    try
    {
      this.oRT = null;
      if ((h.vH().gXs == null) || (h.vH().gXs.hsI == null))
      {
        v.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        gC(false);
        GMTrace.o(18923223252992L, 140989);
        return;
      }
      if (paramInt2 != 0)
      {
        v.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        gC(false);
        GMTrace.o(18923223252992L, 140989);
        return;
      }
      v.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.oRT = ((tr)this.gUq.hrT.hsa).tAr;
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      gC(false);
      GMTrace.o(18923223252992L, 140989);
      return;
    }
    finally
    {
      gC(false);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(18923357470720L, 140990);
    GMTrace.o(18923357470720L, 140990);
    return 914;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */