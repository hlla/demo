package com.tencent.mm.at;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  String hPZ;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    GMTrace.i(4401804607488L, 32796);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ayh();
    ((b.a)localObject).hrW = new ayi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).hrU = 752;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = new aiv();
    ((aiv)localObject).tvk = paramString2;
    ((aiv)localObject).tvl = paramInt2;
    ((aiv)localObject).tlu = paramFloat2;
    ((aiv)localObject).tlt = paramFloat1;
    ((aiv)localObject).tvj = paramString1;
    ((aiv)localObject).tvi = paramInt1;
    paramString1 = (ayh)this.gUq.hrS.hsa;
    paramString1.trB = ((aiv)localObject);
    paramString1.tYJ = paramInt3;
    paramString1.tcg = paramInt4;
    paramString1.oog = paramString3;
    GMTrace.o(4401804607488L, 32796);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4402207260672L, 32799);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4402207260672L, 32799);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4401938825216L, 32797);
    v.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.hPZ = ((ayi)((b)paramp).hrT.hsa).oog;
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4401938825216L, 32797);
      return;
      v.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
  
  public final int getType()
  {
    GMTrace.i(4402073042944L, 32798);
    GMTrace.o(4402073042944L, 32798);
    return 752;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/at/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */