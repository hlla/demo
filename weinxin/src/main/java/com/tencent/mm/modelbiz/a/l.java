package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class l
  extends k
  implements j
{
  private Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(4581387927552L, 34134);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new gv();
    ((b.a)localObject).hrW = new gw();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((b.a)localObject).hrU = 1364;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (gv)this.gUq.hrS.hsa;
    ((gv)localObject).tjf = paramString1;
    ((gv)localObject).fDj = paramString2;
    ((gv)localObject).offset = paramInt;
    this.data = null;
    GMTrace.o(4581387927552L, 34134);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4581790580736L, 34137);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4581790580736L, 34137);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4581522145280L, 34135);
    v.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4581522145280L, 34135);
  }
  
  public final int getType()
  {
    GMTrace.i(4581656363008L, 34136);
    GMTrace.o(4581656363008L, 34136);
    return 1364;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */