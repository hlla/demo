package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  Map<String, String> hxf;
  
  public r(LinkedList<hp> paramLinkedList, Object paramObject)
  {
    GMTrace.i(4578166702080L, 34110);
    this.hxf = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (hp)((Iterator)localObject1).next();
      Object localObject3 = ((hp)localObject2).tkf;
      localObject2 = ((hp)localObject2).tjf;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.hxf.put(str, localObject2);
        }
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).hrV = new vh();
    ((b.a)localObject1).hrW = new vi();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((b.a)localObject1).hrU = 1353;
    ((b.a)localObject1).hrX = 0;
    ((b.a)localObject1).hrY = 0;
    this.gUq = ((b.a)localObject1).BE();
    ((vh)this.gUq.hrS.hsa).tBd = paramLinkedList;
    this.data = paramObject;
    GMTrace.o(4578166702080L, 34110);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4578569355264L, 34113);
    this.gUt = parame1;
    v.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4578569355264L, 34113);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4578300919808L, 34111);
    v.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4578300919808L, 34111);
  }
  
  public final int getType()
  {
    GMTrace.i(4578435137536L, 34112);
    GMTrace.o(4578435137536L, 34112);
    return 1353;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */