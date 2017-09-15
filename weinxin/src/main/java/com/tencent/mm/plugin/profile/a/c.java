package com.tencent.mm.plugin.profile.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class c
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public c(String paramString, boolean paramBoolean)
  {
    GMTrace.i(6719073681408L, 50061);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bdy();
    ((b.a)localObject).hrW = new bdz();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((b.a)localObject).hrU = 1394;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bdy)this.gUq.hrS.hsa;
    ((bdy)localObject).tjf = paramString;
    ((bdy)localObject).udt = paramBoolean;
    GMTrace.o(6719073681408L, 50061);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(6719476334592L, 50064);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(6719476334592L, 50064);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(6719207899136L, 50062);
    v.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(6719207899136L, 50062);
  }
  
  public final bdz aTm()
  {
    GMTrace.i(6719610552320L, 50065);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      bdz localbdz = (bdz)this.gUq.hrT.hsa;
      GMTrace.o(6719610552320L, 50065);
      return localbdz;
    }
    GMTrace.o(6719610552320L, 50065);
    return null;
  }
  
  public final bdy aTn()
  {
    GMTrace.i(6719744770048L, 50066);
    if ((this.gUq != null) && (this.gUq.hrS.hsa != null))
    {
      bdy localbdy = (bdy)this.gUq.hrS.hsa;
      GMTrace.o(6719744770048L, 50066);
      return localbdy;
    }
    GMTrace.o(6719744770048L, 50066);
    return null;
  }
  
  public final int getType()
  {
    GMTrace.i(6719342116864L, 50063);
    GMTrace.o(6719342116864L, 50063);
    return 1394;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/profile/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */