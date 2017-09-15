package com.tencent.mm.pluginsdk.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class m
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public m(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
    GMTrace.i(774167855104L, 5768);
    GMTrace.o(774167855104L, 5768);
  }
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(774302072832L, 5769);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new axn();
    ((b.a)localObject).hrW = new axo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((b.a)localObject).hrU = 153;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    axn localaxn = (axn)this.gUq.hrS.hsa;
    localObject = paramString2;
    if (paramInt != 8) {
      if (bf.mA(paramString2)) {
        break label169;
      }
    }
    label169:
    for (localObject = paramString2 + " " + w.bCD();; localObject = w.bCD())
    {
      localaxn.tYx = paramString1;
      localaxn.oog = ((String)localObject);
      localaxn.tKE = paramInt;
      GMTrace.o(774302072832L, 5769);
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(774436290560L, 5770);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(774436290560L, 5770);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(774704726016L, 5772);
    v.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(774704726016L, 5772);
  }
  
  public final int getType()
  {
    GMTrace.i(774570508288L, 5771);
    GMTrace.o(774570508288L, 5771);
    return 153;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */