package com.tencent.mm.z;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class b
  extends k
  implements j
{
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  
  public b(String paramString)
  {
    GMTrace.i(4496562323456L, 33502);
    b.a locala = new b.a();
    locala.hrV = new bfx();
    locala.hrW = new bfy();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.hrU = 253;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    ((bfx)this.gUq.hrS.hsa).tsG = paramString;
    GMTrace.o(4496562323456L, 33502);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4496696541184L, 33503);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4496696541184L, 33503);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4496964976640L, 33505);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4496964976640L, 33505);
  }
  
  public final int getType()
  {
    GMTrace.i(4496830758912L, 33504);
    GMTrace.o(4496830758912L, 33504);
    return 253;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/z/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */