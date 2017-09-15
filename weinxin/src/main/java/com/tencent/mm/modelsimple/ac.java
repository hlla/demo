package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axr;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ac
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public ac(int[] paramArrayOfInt)
  {
    GMTrace.i(1347814424576L, 10042);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new axr();
    ((b.a)localObject).hrW = new axs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((b.a)localObject).hrU = 116;
    ((b.a)localObject).hrX = 41;
    ((b.a)localObject).hrY = 1000000041;
    this.gUq = ((b.a)localObject).BE();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((axr)this.gUq.hrS.hsa).tYA = ((LinkedList)localObject);
    ((axr)this.gUq.hrS.hsa).tYz = ((LinkedList)localObject).size();
    GMTrace.o(1347814424576L, 10042);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1347948642304L, 10043);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1347948642304L, 10043);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1348217077760L, 10045);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1348217077760L, 10045);
  }
  
  public final int getType()
  {
    GMTrace.i(1348082860032L, 10044);
    GMTrace.o(1348082860032L, 10044);
    return 116;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */