package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class u
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public u(String paramString1, String paramString2)
  {
    GMTrace.i(4581924798464L, 34138);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new asv();
    ((b.a)localObject).hrW = new asw();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((b.a)localObject).hrU = 1358;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (asv)this.gUq.hrS.hsa;
    ((asv)localObject).tjf = paramString1;
    ((asv)localObject).tiZ = paramString2;
    GMTrace.o(4581924798464L, 34138);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4582327451648L, 34141);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4582327451648L, 34141);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4582059016192L, 34139);
    v.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4582059016192L, 34139);
  }
  
  public final int getType()
  {
    GMTrace.i(4582193233920L, 34140);
    GMTrace.o(4582193233920L, 34140);
    return 1358;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */