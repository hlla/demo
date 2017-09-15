package com.tencent.mm.modelappbrand;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  private com.tencent.mm.y.e gWM;
  public final b hpE;
  
  public k(int paramInt)
  {
    GMTrace.i(12928791085056L, 96327);
    b.a locala = new b.a();
    locala.hrV = new aay();
    locala.hrW = new aaz();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.hrU = 1145;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hpE = locala.BE();
    ((aay)this.hpE.hrS.hsa).tFp = paramInt;
    GMTrace.o(12928791085056L, 96327);
  }
  
  public final aaz AR()
  {
    GMTrace.i(12928925302784L, 96328);
    if (this.hpE == null)
    {
      GMTrace.o(12928925302784L, 96328);
      return null;
    }
    aaz localaaz = (aaz)this.hpE.hrT.hsa;
    GMTrace.o(12928925302784L, 96328);
    return localaaz;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12929327955968L, 96331);
    v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gWM = parame1;
    int i = a(parame, this.hpE, this);
    GMTrace.o(12929327955968L, 96331);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12929059520512L, 96329);
    v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gWM != null) {
      this.gWM.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(12929059520512L, 96329);
  }
  
  public final int getType()
  {
    GMTrace.i(15657974366208L, 116661);
    GMTrace.o(15657974366208L, 116661);
    return 1145;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */