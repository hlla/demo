package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ah
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public ah(String paramString, int paramInt, LinkedList<ch> paramLinkedList)
  {
    GMTrace.i(1344861634560L, 10020);
    v.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bfn();
    ((b.a)localObject).hrW = new bfo();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).hrU = 1200;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bfn)this.gUq.hrS.hsa;
    ((bfn)localObject).hSD = paramString;
    ((bfn)localObject).scene = paramInt;
    ((bfn)localObject).uer = paramLinkedList;
    GMTrace.o(1344861634560L, 10020);
  }
  
  public final bfo JA()
  {
    GMTrace.i(1345532723200L, 10025);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      bfo localbfo = (bfo)this.gUq.hrT.hsa;
      GMTrace.o(1345532723200L, 10025);
      return localbfo;
    }
    GMTrace.o(1345532723200L, 10025);
    return null;
  }
  
  public final String Jz()
  {
    GMTrace.i(1345398505472L, 10024);
    Object localObject = (bfo)this.gUq.hrT.hsa;
    if (localObject == null)
    {
      GMTrace.o(1345398505472L, 10024);
      return null;
    }
    localObject = ((bfo)localObject).ues;
    GMTrace.o(1345398505472L, 10024);
    return (String)localObject;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1345130070016L, 10022);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1345130070016L, 10022);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1345264287744L, 10023);
    v.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1345264287744L, 10023);
  }
  
  public final int getType()
  {
    GMTrace.i(1344995852288L, 10021);
    GMTrace.o(1344995852288L, 10021);
    return 1200;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */