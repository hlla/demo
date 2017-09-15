package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class n
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public n(String paramString, sr paramsr, Object paramObject)
  {
    GMTrace.i(4576556089344L, 34098);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new mr();
    ((b.a)localObject).hrW = new ms();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).hrU = 1355;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (mr)this.gUq.hrS.hsa;
    ((mr)localObject).tjf = paramString;
    ((mr)localObject).tru = paramsr;
    this.data = paramObject;
    GMTrace.o(4576556089344L, 34098);
  }
  
  public final ms Eb()
  {
    GMTrace.i(4577092960256L, 34102);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      ms localms = (ms)this.gUq.hrT.hsa;
      GMTrace.o(4577092960256L, 34102);
      return localms;
    }
    GMTrace.o(4577092960256L, 34102);
    return null;
  }
  
  public final mr Ec()
  {
    GMTrace.i(4577227177984L, 34103);
    if ((this.gUq != null) && (this.gUq.hrS.hsa != null))
    {
      mr localmr = (mr)this.gUq.hrS.hsa;
      GMTrace.o(4577227177984L, 34103);
      return localmr;
    }
    GMTrace.o(4577227177984L, 34103);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4576958742528L, 34101);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4576958742528L, 34101);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4576690307072L, 34099);
    v.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4576690307072L, 34099);
  }
  
  public final int getType()
  {
    GMTrace.i(4576824524800L, 34100);
    GMTrace.o(4576824524800L, 34100);
    return 1355;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */