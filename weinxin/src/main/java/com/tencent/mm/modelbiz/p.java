package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ba;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class p
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  
  public p(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(4528371924992L, 33739);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ln();
    ((b.a)localObject).hrW = new lo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).hrU = 359;
    ((b.a)localObject).hrX = 176;
    ((b.a)localObject).hrY = 1000000176;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ln)this.gUq.hrS.hsa;
    ((ln)localObject).tqo = paramInt;
    ((ln)localObject).tqp = paramString2;
    ((ln)localObject).tiV = paramString1;
    ((ln)localObject).tdC = ba.zz();
    v.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, ((ln)localObject).tdC });
    GMTrace.o(4528371924992L, 33739);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4528774578176L, 33742);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4528774578176L, 33742);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4528506142720L, 33740);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4528506142720L, 33740);
  }
  
  public final int getType()
  {
    GMTrace.i(4528640360448L, 33741);
    GMTrace.o(4528640360448L, 33741);
    return 359;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */