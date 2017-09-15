package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class o
  extends k
  implements j
{
  private String gLt;
  com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private a<o> hvN;
  
  private o(String paramString1, String paramString2)
  {
    GMTrace.i(4523137433600L, 33700);
    this.gLt = paramString1;
    v.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new b.a();
    paramString1.hrU = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.hrV = new gn();
    paramString1.hrW = new go();
    paramString1.hrX = 0;
    paramString1.hrY = 0;
    this.gUq = paramString1.BE();
    paramString1 = (gn)this.gUq.hrS.hsa;
    paramString1.tiV = this.gLt;
    paramString1.tiW = new com.tencent.mm.bd.b(bf.PS(bf.mz(paramString2)));
    GMTrace.o(4523137433600L, 33700);
  }
  
  public o(String paramString1, String paramString2, a<o> parama)
  {
    this(paramString1, paramString2);
    GMTrace.i(4523003215872L, 33699);
    this.hvN = parama;
    GMTrace.o(4523003215872L, 33699);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4523540086784L, 33703);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4523540086784L, 33703);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4523271651328L, 33701);
    v.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    if (this.hvN != null) {
      this.hvN.b(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4523271651328L, 33701);
  }
  
  public final int getType()
  {
    GMTrace.i(4523405869056L, 33702);
    GMTrace.o(4523405869056L, 33702);
    return 1075;
  }
  
  public static abstract interface a<T extends k>
  {
    public abstract void b(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */