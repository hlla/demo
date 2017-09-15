package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  private final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  
  public k(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(1345666940928L, 10026);
    v.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ps();
    ((b.a)localObject).hrW = new pt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
    ((b.a)localObject).hrU = 1066;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    if (paramString2 != null)
    {
      localObject = paramString2;
      if (paramString2.length() <= 32) {}
    }
    for (localObject = paramString2.substring(0, 32);; localObject = "")
    {
      paramString2 = (ps)this.gUq.hrS.hsa;
      paramString2.tiV = paramString1;
      paramString2.teq = paramInt;
      paramString2.tui = com.tencent.mm.bd.b.NF((String)localObject);
      paramString2.trQ = com.tencent.mm.bd.b.aU(new byte[0]);
      v.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramString2.trQ.sWU.length) });
      GMTrace.o(1345666940928L, 10026);
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1345935376384L, 10028);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1345935376384L, 10028);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1346069594112L, 10029);
    v.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1346069594112L, 10029);
  }
  
  public final int getType()
  {
    GMTrace.i(1345801158656L, 10027);
    GMTrace.o(1345801158656L, 10027);
    return 1066;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */