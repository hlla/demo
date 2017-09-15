package com.tencent.mm.modelstat;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class i
  extends k
  implements j
{
  private com.tencent.mm.y.e gWM;
  final com.tencent.mm.y.b hVQ;
  
  public i(com.tencent.mm.bd.b paramb)
  {
    GMTrace.i(1396669677568L, 10406);
    b.a locala = new b.a();
    ya localya = new ya();
    localya.taR = 0;
    localya.tCV = paramb;
    locala.hrV = localya;
    locala.hrW = new yb();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.hrU = 1126;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hVQ = locala.BE();
    GMTrace.o(1396669677568L, 10406);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1396938113024L, 10408);
    v.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    this.hss = true;
    this.gWM = parame1;
    int i = a(parame, this.hVQ, this);
    GMTrace.o(1396938113024L, 10408);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1397072330752L, 10409);
    v.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramp.toString() });
    this.gWM.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1397072330752L, 10409);
  }
  
  public final int getType()
  {
    GMTrace.i(1396803895296L, 10407);
    GMTrace.o(1396803895296L, 10407);
    return 1126;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */