package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class q
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public q(String paramString, Object paramObject)
  {
    GMTrace.i(4570247856128L, 34051);
    b.a locala = new b.a();
    locala.hrV = new vf();
    locala.hrW = new vg();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.hrU = 1354;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    ((vf)this.gUq.hrS.hsa).tjf = paramString;
    this.data = paramObject;
    GMTrace.o(4570247856128L, 34051);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4570650509312L, 34054);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4570650509312L, 34054);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4570382073856L, 34052);
    v.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4570382073856L, 34052);
  }
  
  public final int getType()
  {
    GMTrace.i(4570516291584L, 34053);
    GMTrace.o(4570516291584L, 34053);
    return 1354;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */