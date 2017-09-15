package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class v
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public v(gy paramgy, Object paramObject)
  {
    GMTrace.i(4538840907776L, 33817);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ayp();
    ((b.a)localObject).hrW = new ayq();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((b.a)localObject).hrU = 1228;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ayp)this.gUq.hrS.hsa;
    ((ayp)localObject).tBf = paramgy;
    ((ayp)localObject).mask = 1;
    ((ayp)localObject).tBe = 1;
    this.data = paramObject;
    GMTrace.o(4538840907776L, 33817);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4539243560960L, 33820);
    this.gUt = parame1;
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4539243560960L, 33820);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4538975125504L, 33818);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4538975125504L, 33818);
  }
  
  public final int getType()
  {
    GMTrace.i(4539109343232L, 33819);
    GMTrace.o(4539109343232L, 33819);
    return 1228;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */