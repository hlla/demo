package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class v
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  public int hSl;
  
  public v(int paramInt)
  {
    GMTrace.i(13158571835392L, 98039);
    this.hSl = 1;
    b.a locala = new b.a();
    locala.hrV = new asp();
    locala.hrW = new asq();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.hrU = 255;
    locala.hrX = 132;
    locala.hrY = 1000000132;
    this.gUq = locala.BE();
    ((asp)this.gUq.hrS.hsa).tcg = paramInt;
    GMTrace.o(13158571835392L, 98039);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13158706053120L, 98040);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(13158706053120L, 98040);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13158974488576L, 98042);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13158974488576L, 98042);
  }
  
  public final int getType()
  {
    GMTrace.i(13158840270848L, 98041);
    GMTrace.o(13158840270848L, 98041);
    return 255;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */