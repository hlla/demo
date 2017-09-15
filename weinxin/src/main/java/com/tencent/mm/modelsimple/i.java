package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class i
  extends k
  implements j
{
  private final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  
  public i(String paramString)
  {
    GMTrace.i(1365128511488L, 10171);
    v.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new nr();
    ((b.a)localObject).hrW = new ns();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((b.a)localObject).hrU = 1067;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (nr)this.gUq.hrS.hsa;
    ((nr)localObject).tiV = paramString;
    ((nr)localObject).trQ = com.tencent.mm.bd.b.aU(new byte[0]);
    GMTrace.o(1365128511488L, 10171);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1365396946944L, 10173);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1365396946944L, 10173);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1365531164672L, 10174);
    v.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1365531164672L, 10174);
  }
  
  public final int getType()
  {
    GMTrace.i(1365262729216L, 10172);
    GMTrace.o(1365262729216L, 10172);
    return 1067;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */