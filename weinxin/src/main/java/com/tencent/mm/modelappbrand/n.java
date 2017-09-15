package com.tencent.mm.modelappbrand;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bqq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class n
  extends k
  implements j
{
  private com.tencent.mm.y.e gWM;
  public final b hpE;
  
  public n(String paramString)
  {
    GMTrace.i(12933086052352L, 96359);
    b.a locala = new b.a();
    locala.hrV = new bqp();
    locala.hrW = new bqq();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.hrU = 1198;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hpE = locala.BE();
    ((bqp)this.hpE.hrS.hsa).une = paramString;
    GMTrace.o(12933086052352L, 96359);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12933488705536L, 96362);
    v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gWM = parame1;
    int i = a(parame, this.hpE, this);
    GMTrace.o(12933488705536L, 96362);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12933354487808L, 96361);
    v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gWM != null) {
      this.gWM.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(12933354487808L, 96361);
  }
  
  public final int getType()
  {
    GMTrace.i(15658511237120L, 116665);
    GMTrace.o(15658511237120L, 116665);
    return 1198;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */