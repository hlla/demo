package com.tencent.mm.aw.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  
  public a(int paramInt, LinkedList<avu> paramLinkedList, avu paramavu1, avu paramavu2)
  {
    GMTrace.i(14690935635968L, 109456);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ava();
    ((b.a)localObject).hrW = new avb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    ((b.a)localObject).hrU = 228;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ava)this.gUq.hrS.hsa;
    ((ava)localObject).tWV = paramInt;
    ((ava)localObject).tWW = paramLinkedList;
    ((ava)localObject).tWX = paramavu1;
    ((ava)localObject).tWY = paramavu2;
    GMTrace.o(14690935635968L, 109456);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4399657123840L, 32780);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4399657123840L, 32780);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4399791341568L, 32781);
    v.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4399791341568L, 32781);
  }
  
  public final int getType()
  {
    GMTrace.i(4399522906112L, 32779);
    GMTrace.o(4399522906112L, 32779);
    return 228;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */