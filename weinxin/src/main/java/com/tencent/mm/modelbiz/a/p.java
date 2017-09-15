package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  Map<String, String> hxe;
  
  public p(LinkedList<gr> paramLinkedList)
  {
    GMTrace.i(4570784727040L, 34055);
    this.hxe = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (gr)((Iterator)localObject1).next();
      String str = ((gr)localObject2).tiZ;
      localObject2 = ((gr)localObject2).tjf;
      if ((localObject2 != null) && (str != null)) {
        this.hxe.put(str, localObject2);
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).hrV = new vb();
    ((b.a)localObject1).hrW = new vc();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((b.a)localObject1).hrU = 1365;
    ((b.a)localObject1).hrX = 0;
    ((b.a)localObject1).hrY = 0;
    this.gUq = ((b.a)localObject1).BE();
    ((vb)this.gUq.hrS.hsa).tBb = paramLinkedList;
    GMTrace.o(4570784727040L, 34055);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4571187380224L, 34058);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4571187380224L, 34058);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4570918944768L, 34056);
    v.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4570918944768L, 34056);
  }
  
  public final int getType()
  {
    GMTrace.i(4571053162496L, 34057);
    GMTrace.o(4571053162496L, 34057);
    return 1365;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */