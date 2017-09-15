package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class s
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  public String hvO;
  
  public s(String paramString1, String paramString2)
  {
    GMTrace.i(4543538528256L, 33852);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ahu();
    ((b.a)localObject).hrW = new ahv();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).hrU = 674;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ahu)this.gUq.hrS.hsa;
    ((ahu)localObject).tKr = paramString1;
    ((ahu)localObject).tKs = paramString2;
    this.hvO = paramString1;
    GMTrace.o(4543538528256L, 33852);
  }
  
  public final ahv DC()
  {
    GMTrace.i(4544075399168L, 33856);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      ahv localahv = (ahv)this.gUq.hrT.hsa;
      GMTrace.o(4544075399168L, 33856);
      return localahv;
    }
    GMTrace.o(4544075399168L, 33856);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4543941181440L, 33855);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4543941181440L, 33855);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4543672745984L, 33853);
    v.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4543672745984L, 33853);
  }
  
  public final int getType()
  {
    GMTrace.i(4543806963712L, 33854);
    GMTrace.o(4543806963712L, 33854);
    return 674;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */