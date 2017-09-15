package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class w
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public w(String paramString, gq paramgq, Object paramObject)
  {
    GMTrace.i(4562329010176L, 33992);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bge();
    ((b.a)localObject).hrW = new bgf();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((b.a)localObject).hrU = 1356;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bge)this.gUq.hrS.hsa;
    ((bge)localObject).tjf = paramString;
    ((bge)localObject).tyW = paramgq;
    this.data = paramObject;
    GMTrace.o(4562329010176L, 33992);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4562731663360L, 33995);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4562731663360L, 33995);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4562463227904L, 33993);
    v.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4562463227904L, 33993);
  }
  
  public final int getType()
  {
    GMTrace.i(4562597445632L, 33994);
    GMTrace.o(4562597445632L, 33994);
    return 1356;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */