package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class u
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  public String hvO;
  public int hvP;
  public String tag;
  
  public u(String paramString, LinkedList<String> paramLinkedList)
  {
    this(paramString, paramLinkedList, (byte)0);
    GMTrace.i(4549578326016L, 33897);
    GMTrace.o(4549578326016L, 33897);
  }
  
  private u(String paramString, LinkedList<String> paramLinkedList, byte paramByte)
  {
    GMTrace.i(4549712543744L, 33898);
    this.hvP = 1;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ahx();
    ((b.a)localObject).hrW = new ahy();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).hrU = 675;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ahx)this.gUq.hrS.hsa;
    ((ahx)localObject).tKr = paramString;
    ((ahx)localObject).tKu = paramLinkedList;
    this.hvO = paramString;
    this.hvP = 1;
    GMTrace.o(4549712543744L, 33898);
  }
  
  public final ahy DE()
  {
    GMTrace.i(4550249414656L, 33902);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      ahy localahy = (ahy)this.gUq.hrT.hsa;
      GMTrace.o(4550249414656L, 33902);
      return localahy;
    }
    GMTrace.o(4550249414656L, 33902);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4550115196928L, 33901);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4550115196928L, 33901);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4549846761472L, 33899);
    v.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4549846761472L, 33899);
  }
  
  public final int getType()
  {
    GMTrace.i(4549980979200L, 33900);
    GMTrace.o(4549980979200L, 33900);
    return 675;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */