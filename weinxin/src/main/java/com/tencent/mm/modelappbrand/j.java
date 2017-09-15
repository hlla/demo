package com.tencent.mm.modelappbrand;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class j
  extends k
  implements com.tencent.mm.network.j
{
  private com.tencent.mm.y.e gWM;
  private final b hpE;
  
  public j(LinkedList<beg> paramLinkedList)
  {
    GMTrace.i(12930535915520L, 96340);
    b.a locala = new b.a();
    locala.hrV = new fn();
    locala.hrW = new fo();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.hrU = 1176;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hpE = locala.BE();
    ((fn)this.hpE.hrS.hsa).thv = paramLinkedList;
    GMTrace.o(12930535915520L, 96340);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12930938568704L, 96343);
    v.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.gWM = parame1;
    int i = a(parame, this.hpE, this);
    GMTrace.o(12930938568704L, 96343);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12930670133248L, 96341);
    v.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gWM != null) {
      this.gWM.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(12930670133248L, 96341);
  }
  
  public final int getType()
  {
    GMTrace.i(15658377019392L, 116664);
    GMTrace.o(15658377019392L, 116664);
    return 1176;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */