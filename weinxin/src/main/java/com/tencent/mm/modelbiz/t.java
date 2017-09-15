package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class t
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  public String hvO;
  
  public final ahw DD()
  {
    GMTrace.i(4538304036864L, 33813);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      ahw localahw = (ahw)this.gUq.hrT.hsa;
      GMTrace.o(4538304036864L, 33813);
      return localahw;
    }
    GMTrace.o(4538304036864L, 33813);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4538169819136L, 33812);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4538169819136L, 33812);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4537901383680L, 33810);
    v.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4537901383680L, 33810);
  }
  
  public final int getType()
  {
    GMTrace.i(4538035601408L, 33811);
    GMTrace.o(4538035601408L, 33811);
    return 672;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */