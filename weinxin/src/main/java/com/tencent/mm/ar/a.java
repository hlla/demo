package com.tencent.mm.ar;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public a(String paramString)
  {
    GMTrace.i(303332065280L, 2260);
    b.a locala = new b.a();
    locala.hrV = new nv();
    locala.hrW = new nw();
    locala.uri = "/cgi-bin/micromsg-bin/deletecardimg";
    locala.hrU = 576;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    ((nv)this.gUq.hrS.hsa).trV = paramString;
    GMTrace.o(303332065280L, 2260);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(303600500736L, 2262);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(303600500736L, 2262);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(303734718464L, 2263);
    v.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(303734718464L, 2263);
  }
  
  public final int getType()
  {
    GMTrace.i(303466283008L, 2261);
    GMTrace.o(303466283008L, 2261);
    return 576;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */