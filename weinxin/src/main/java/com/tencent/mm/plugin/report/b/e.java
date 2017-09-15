package com.tencent.mm.plugin.report.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class e
  extends k
  implements com.tencent.mm.network.j
{
  private boolean fCb;
  public int fRh;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private ll oRP;
  private a oRQ;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(13106226921472L, 97649);
    this.fCb = false;
    this.oRP = null;
    this.fRh = 0;
    this.oRQ = new a();
    if (paramArrayOfByte == null) {
      throw new NullPointerException("data must not be null");
    }
    this.fRh = paramInt;
    boolean bool;
    if ((com.tencent.mm.kernel.h.vG().uV()) && (!bf.bm(com.tencent.mm.kernel.h.vH().vc())))
    {
      bool = true;
      this.fCb = bool;
      if (paramInt != 1) {
        break label201;
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).aD(paramArrayOfByte);
        this.oRP = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.oRP == null) {
          break label264;
        }
        this.oRP.tqd = new aev();
        this.oRP.tqd.tIw = this.oRQ.rS(this.fRh);
        GMTrace.o(13106226921472L, 97649);
        return;
        bool = false;
      }
      catch (Exception paramArrayOfByte)
      {
        v.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(13108105969664L, 97663);
            SmcLogic.OnReportResp(3, -1, null, e.this.fRh);
            GMTrace.o(13108105969664L, 97663);
          }
        });
        continue;
      }
      label201:
      if (paramInt == 2) {
        try
        {
          localObject = new g();
          ((g)localObject).aD(paramArrayOfByte);
          this.oRP = SmcProtoBufUtil.toMMReportIdkeyReq((g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          v.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.h.vJ();
          com.tencent.mm.kernel.h.vL().D(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13106898010112L, 97654);
              SmcLogic.OnReportResp(3, -1, null, e.this.fRh);
              GMTrace.o(13106898010112L, 97654);
            }
          });
        }
      }
    }
    label264:
    v.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bf.bJP() });
    GMTrace.o(13106226921472L, 97649);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13106629574656L, 97652);
    this.gUt = parame1;
    if (this.oRP == null)
    {
      v.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      GMTrace.o(13106629574656L, 97652);
      return -2;
    }
    if (!this.fCb) {
      this.oRP.tqc = com.tencent.mm.bd.b.aU(bf.bJG());
    }
    b.a locala = new b.a();
    locala.hrZ = false;
    locala.hrV = this.oRP;
    locala.hrW = new lm();
    if (1 == this.fRh) {
      parame1 = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label117:
      int i;
      if (1 == this.fRh)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.fCb) {
          break label241;
        }
        locala.uri = parame1;
        locala.hrU = getType();
        this.gUq = locala.BE();
        if (!this.fCb)
        {
          this.gUq.a(ac.bHj());
          this.gUq.fYi = 1;
        }
        i = a(parame, this.gUq, this);
        if (i < 0) {
          v.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
        }
      }
      try
      {
        SmcLogic.OnReportResp(3, -1, null, this.fRh);
        GMTrace.o(13106629574656L, 97652);
        return i;
        parame1 = "/cgi-bin/micromsg-bin/newreportidkey";
        continue;
        str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        break label117;
        label241:
        parame1 = str;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          v.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bf.g(parame) });
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13106361139200L, 97650);
    if ((com.tencent.mm.kernel.h.vH().gXs == null) || (com.tencent.mm.kernel.h.vH().gXs.hsI == null))
    {
      v.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13106361139200L, 97650);
      return;
    }
    if (paramInt2 != 0)
    {
      v.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.fRh);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13106361139200L, 97650);
      return;
    }
    v.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.fRh);
    paramp = (lm)this.gUq.hrT.hsa;
    this.oRQ.a(paramp.tqn, this.fRh);
    try
    {
      if (this.fRh == 1) {
        SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(paramp).toByteArray(), this.fRh);
      }
      for (;;)
      {
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        GMTrace.o(13106361139200L, 97650);
        return;
        if (this.fRh == 2) {
          SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(paramp).toByteArray(), this.fRh);
        }
      }
    }
    catch (Exception paramp)
    {
      for (;;)
      {
        v.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bf.g(paramp) });
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(13106495356928L, 97651);
    if (!this.fCb)
    {
      if (1 == this.fRh)
      {
        GMTrace.o(13106495356928L, 97651);
        return 997;
      }
      GMTrace.o(13106495356928L, 97651);
      return 987;
    }
    if (1 == this.fRh)
    {
      GMTrace.o(13106495356928L, 97651);
      return 996;
    }
    GMTrace.o(13106495356928L, 97651);
    return 986;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */