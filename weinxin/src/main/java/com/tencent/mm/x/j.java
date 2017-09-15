package com.tencent.mm.x;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.util.LinkedList;

public final class j
  extends k
  implements com.tencent.mm.network.j
{
  private com.tencent.mm.y.e gUt;
  LinkedList<avu> hro;
  LinkedList<aft> hrp;
  
  public j(LinkedList<avu> paramLinkedList)
  {
    GMTrace.i(381044129792L, 2839);
    this.hro = null;
    this.hrp = null;
    this.hro = paramLinkedList;
    GMTrace.o(381044129792L, 2839);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(381178347520L, 2840);
    if ((this.hro == null) || (this.hro.size() <= 0))
    {
      v.e("MicroMsg.NetSceneBatchGetHeadImg", g.sd() + "doScene ReqSize==0");
      GMTrace.o(381178347520L, 2840);
      return -1;
    }
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrV = new fe();
    parame1.hrW = new ff();
    parame1.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    parame1.hrU = 123;
    parame1.hrX = 15;
    parame1.hrY = 1000000015;
    parame1 = parame1.BE();
    fe localfe = (fe)parame1.hrS.hsa;
    localfe.thh = this.hro;
    localfe.jLr = this.hro.size();
    int i = a(parame, parame1, this);
    GMTrace.o(381178347520L, 2840);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(381312565248L, 2841);
    int i = k.b.hsC;
    GMTrace.o(381312565248L, 2841);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(381581000704L, 2843);
    v.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.hrp = ((ff)((b)paramp).hrT.hsa).thk;
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(381581000704L, 2843);
  }
  
  public final int getType()
  {
    GMTrace.i(381715218432L, 2844);
    GMTrace.o(381715218432L, 2844);
    return 123;
  }
  
  protected final int ub()
  {
    GMTrace.i(381446782976L, 2842);
    GMTrace.o(381446782976L, 2842);
    return 20;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */