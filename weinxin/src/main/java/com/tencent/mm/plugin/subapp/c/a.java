package com.tencent.mm.plugin.subapp.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.bjm;
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
  
  public a(LinkedList<bjm> paramLinkedList, int paramInt)
  {
    GMTrace.i(5844645183488L, 43546);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new aol();
    ((b.a)localObject).hrW = new aom();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((b.a)localObject).hrU = 331;
    ((b.a)localObject).hrX = 150;
    ((b.a)localObject).hrY = 1000000150;
    this.gUq = ((b.a)localObject).BE();
    localObject = (aol)this.gUq.hrS.hsa;
    ((aol)localObject).tay = 1;
    ((aol)localObject).tRS = paramLinkedList;
    ((aol)localObject).tRR = paramInt;
    GMTrace.o(5844645183488L, 43546);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5844779401216L, 43547);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(5844779401216L, 43547);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5845047836672L, 43549);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(5845047836672L, 43549);
  }
  
  public final int getType()
  {
    GMTrace.i(5844913618944L, 43548);
    GMTrace.o(5844913618944L, 43548);
    return 331;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */