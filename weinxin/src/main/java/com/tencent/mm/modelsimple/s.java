package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class s
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  public final b hRy;
  
  public s()
  {
    GMTrace.i(1346203811840L, 10030);
    b.a locala = new b.a();
    locala.hrV = new aaw();
    locala.hrW = new aax();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.hrU = 725;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hRy = locala.BE();
    ((aaw)this.hRy.hrS.hsa).jMq = 0;
    v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), bf.bJP() });
    GMTrace.o(1346203811840L, 10030);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1346606465024L, 10033);
    this.gUt = parame1;
    g.oSF.a(405L, 1L, 1L, true);
    int i = a(parame, this.hRy, this);
    GMTrace.o(1346606465024L, 10033);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1346338029568L, 10031);
    v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      g.oSF.a(405L, 2L, 1L, true);
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1346338029568L, 10031);
  }
  
  public final int getType()
  {
    GMTrace.i(1346472247296L, 10032);
    GMTrace.o(1346472247296L, 10032);
    return 725;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */