package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class g
  extends k
  implements j
{
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public int opType;
  
  public g(int paramInt, String paramString)
  {
    GMTrace.i(1361638850560L, 10145);
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new qy();
    ((b.a)localObject).hrW = new qz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).hrU = 183;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    qy localqy = (qy)this.gUq.hrS.hsa;
    localObject = paramString;
    if (bf.mA(paramString)) {
      localObject = "";
    }
    localqy.tuT = ((String)localObject);
    localqy.mse = paramInt;
    GMTrace.o(1361638850560L, 10145);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1361773068288L, 10146);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1361773068288L, 10146);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1362041503744L, 10148);
    v.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramp = (qz)this.gUq.hrT.hsa;
      paramInt1 = paramp.tXs.tgr;
      if (paramInt1 != 0)
      {
        v.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + paramInt1);
        this.gUt.a(4, paramInt1, paramString, this);
        GMTrace.o(1362041503744L, 10148);
        return;
      }
      v.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramp.tuV + ", fbusername = " + paramp.tuW);
      if ((this.opType == 0) || (this.opType == 1))
      {
        ap.yY();
        c.vr().set(65825, paramp.tuV);
        com.tencent.mm.x.b.gY(paramp.tuV);
        ap.yY();
        c.vr().set(65826, paramp.tuW);
        ap.yY();
        c.vr().jV(true);
      }
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1362041503744L, 10148);
  }
  
  public final int getType()
  {
    GMTrace.i(1361907286016L, 10147);
    GMTrace.o(1361907286016L, 10147);
    return 183;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */