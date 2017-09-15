package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class s
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public s(String paramString)
  {
    GMTrace.i(4580448403456L, 34127);
    b.a locala = new b.a();
    locala.hrV = new yc();
    locala.hrW = new yd();
    locala.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
    locala.hrU = 1367;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    ((yc)this.gUq.hrS.hsa).tjf = paramString;
    GMTrace.o(4580448403456L, 34127);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4580851056640L, 34130);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4580851056640L, 34130);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4580582621184L, 34128);
    v.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4580582621184L, 34128);
  }
  
  public final int getType()
  {
    GMTrace.i(4580716838912L, 34129);
    GMTrace.o(4580716838912L, 34129);
    return 1367;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */