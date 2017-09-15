package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class t
  extends k
  implements j
{
  Object data;
  public b gUq;
  private com.tencent.mm.y.e gUt;
  public String hxc;
  
  public t(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    GMTrace.i(4577495613440L, 34105);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new afw();
    ((b.a)localObject).hrW = new afx();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((b.a)localObject).hrU = 1389;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (afw)this.gUq.hrS.hsa;
    ((afw)localObject).trk = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((afw)localObject).tJs = paramString1;
    ((afw)localObject).tJt = paramLinkedList;
    this.data = paramObject;
    GMTrace.o(4577495613440L, 34105);
  }
  
  public final afx Ed()
  {
    GMTrace.i(4578032484352L, 34109);
    if ((this.gUq != null) && (this.gUq.hrT.hsa != null))
    {
      afx localafx = (afx)this.gUq.hrT.hsa;
      GMTrace.o(4578032484352L, 34109);
      return localafx;
    }
    GMTrace.o(4578032484352L, 34109);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4577898266624L, 34108);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(4577898266624L, 34108);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4577629831168L, 34106);
    v.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4577629831168L, 34106);
  }
  
  public final int getType()
  {
    GMTrace.i(4577764048896L, 34107);
    GMTrace.o(4577764048896L, 34107);
    return 1389;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */