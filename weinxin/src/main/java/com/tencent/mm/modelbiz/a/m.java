package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class m
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  public String hxc;
  
  public m(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    GMTrace.i(4579508879360L, 34120);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new mm();
    ((b.a)localObject).hrW = new mn();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).hrU = 1315;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (mm)this.gUq.hrS.hsa;
    ((mm)localObject).trk = paramString1;
    ((mm)localObject).trm = paramString2;
    ((mm)localObject).trl = paramString3;
    this.data = paramObject;
    GMTrace.o(4579508879360L, 34120);
  }
  
  public final mn Ea()
  {
    GMTrace.i(4580045750272L, 34124);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      mn localmn = (mn)this.gUq.hrT.hsa;
      GMTrace.o(4580045750272L, 34124);
      return localmn;
    }
    GMTrace.o(4580045750272L, 34124);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4579911532544L, 34123);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4579911532544L, 34123);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4579643097088L, 34121);
    v.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4579643097088L, 34121);
  }
  
  public final int getType()
  {
    GMTrace.i(4579777314816L, 34122);
    GMTrace.o(4579777314816L, 34122);
    return 1315;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */