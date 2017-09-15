package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class x
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public x(String paramString1, String paramString2, gt paramgt1, gt paramgt2, Object paramObject)
  {
    GMTrace.i(4578703572992L, 34114);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bgc();
    ((b.a)localObject).hrW = new bgd();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((b.a)localObject).hrU = 1357;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bgc)this.gUq.hrS.hsa;
    ((bgc)localObject).tjf = paramString1;
    ((bgc)localObject).tiZ = paramString2;
    ((bgc)localObject).ueP = paramgt1;
    ((bgc)localObject).ueQ = paramgt2;
    this.data = paramObject;
    GMTrace.o(4578703572992L, 34114);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4579106226176L, 34117);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4579106226176L, 34117);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4578837790720L, 34115);
    v.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4578837790720L, 34115);
  }
  
  public final int getType()
  {
    GMTrace.i(4578972008448L, 34116);
    GMTrace.o(4578972008448L, 34116);
    return 1357;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */