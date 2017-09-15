package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class x
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  int sBX;
  w sBY;
  
  public x(int paramInt, w paramw)
  {
    GMTrace.i(793629425664L, 5913);
    this.sBX = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new cn();
    ((b.a)localObject).hrW = new co();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject).hrU = 452;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (cn)this.gUq.hrS.hsa;
    byte[] arrayOfByte = paramw.aBo();
    if (arrayOfByte != null) {
      ((cn)localObject).tea = new avt().bb(arrayOfByte);
    }
    ((cn)localObject).jMq = paramInt;
    this.sBY = paramw;
    GMTrace.o(793629425664L, 5913);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(794032078848L, 5916);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(794032078848L, 5916);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(793763643392L, 5914);
    v.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(793763643392L, 5914);
      return;
    }
    this.sBY.ar(n.a(((co)this.gUq.hrT.hsa).teb));
    this.sBY.a(paramInt1, paramInt2, paramInt3, paramString, this.gUq, paramArrayOfByte);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(793763643392L, 5914);
  }
  
  public final int getType()
  {
    GMTrace.i(793897861120L, 5915);
    GMTrace.o(793897861120L, 5915);
    return 452;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */