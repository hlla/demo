package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class m
  extends k
  implements com.tencent.mm.network.j
{
  private com.tencent.mm.y.e gUt;
  private final p htc;
  
  public m()
  {
    GMTrace.i(13157632311296L, 98032);
    this.htc = new com.tencent.mm.y.j();
    GMTrace.o(13157632311296L, 98032);
  }
  
  public final boolean BL()
  {
    GMTrace.i(13157900746752L, 98034);
    GMTrace.o(13157900746752L, 98034);
    return false;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13158034964480L, 98035);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(13158034964480L, 98035);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13158169182208L, 98036);
    v.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13158169182208L, 98036);
  }
  
  public final int getType()
  {
    GMTrace.i(13157766529024L, 98033);
    GMTrace.o(13157766529024L, 98033);
    return 381;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */