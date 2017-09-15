package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class q
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public q(String paramString, int paramInt, Object paramObject)
  {
    GMTrace.i(4544209616896L, 33857);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new vj();
    ((b.a)localObject).hrW = new vk();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).hrU = 1343;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (vj)this.gUq.hrS.hsa;
    ((vj)localObject).tjf = paramString;
    ((vj)localObject).tBe = paramInt;
    this.data = paramObject;
    GMTrace.o(4544209616896L, 33857);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4544612270080L, 33860);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4544612270080L, 33860);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4544343834624L, 33858);
    v.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4544343834624L, 33858);
  }
  
  public final int getType()
  {
    GMTrace.i(4544478052352L, 33859);
    GMTrace.o(4544478052352L, 33859);
    return 1343;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */