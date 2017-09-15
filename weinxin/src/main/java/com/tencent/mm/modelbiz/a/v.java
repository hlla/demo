package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class v
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public v(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(4571321597952L, 34059);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new asz();
    ((b.a)localObject).hrW = new ata();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((b.a)localObject).hrU = 1361;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (asz)this.gUq.hrS.hsa;
    ((asz)localObject).tjf = paramString1;
    ((asz)localObject).tiZ = paramString2;
    ((asz)localObject).time_stamp = paramInt;
    GMTrace.o(4571321597952L, 34059);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4571724251136L, 34062);
    this.gUt = parame1;
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4571724251136L, 34062);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4571455815680L, 34060);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4571455815680L, 34060);
  }
  
  public final int getType()
  {
    GMTrace.i(4571590033408L, 34061);
    GMTrace.o(4571590033408L, 34061);
    return 1361;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */