package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class o
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  boolean hxd;
  
  public o(String paramString1, String paramString2)
  {
    GMTrace.i(4559376220160L, 33970);
    this.hxd = false;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new vd();
    ((b.a)localObject).hrW = new ve();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
    ((b.a)localObject).hrU = 1352;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (vd)this.gUq.hrS.hsa;
    ((vd)localObject).tiZ = paramString1;
    ((vd)localObject).tjf = paramString2;
    this.hxd = true;
    GMTrace.o(4559376220160L, 33970);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4559778873344L, 33973);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4559778873344L, 33973);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4559510437888L, 33971);
    v.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4559510437888L, 33971);
  }
  
  public final int getType()
  {
    GMTrace.i(4559644655616L, 33972);
    GMTrace.o(4559644655616L, 33972);
    return 1352;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */