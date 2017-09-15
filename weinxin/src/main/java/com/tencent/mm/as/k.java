package com.tencent.mm.as;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.List;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private b hJX;
  bos hPO;
  bot hPP;
  
  public k(List<String> paramList, int paramInt, long paramLong, List<lz> paramList1)
  {
    GMTrace.i(1325936934912L, 9879);
    this.hPO = new bos();
    paramList = new b.a();
    paramList.hrU = 1948;
    paramList.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    paramList.hrV = new bos();
    paramList.hrW = new bot();
    this.hJX = paramList.BE();
    this.hPO = ((bos)this.hJX.hrS.hsa);
    this.hPO.tMy = d.hOW;
    this.hPO.lda = u.ea(aa.getContext());
    this.hPO.tzT = d.Il();
    this.hPO.tMz = d.AU();
    this.hPO.tcg = paramInt;
    this.hPO.tks = 0L;
    GMTrace.o(1325936934912L, 9879);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1326205370368L, 9881);
    this.gUt = parame1;
    int i = a(parame, this.hJX, this);
    GMTrace.o(1326205370368L, 9881);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1326339588096L, 9882);
    v.i("MicroMsg.FTS.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(1326339588096L, 9882);
      return;
    }
    this.hPP = ((bot)this.hJX.hrT.hsa);
    if (this.hPP != null) {
      v.v("MicroMsg.FTS.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.hPP.tjN });
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1326339588096L, 9882);
  }
  
  public final int getType()
  {
    GMTrace.i(1326071152640L, 9880);
    GMTrace.o(1326071152640L, 9880);
    return 1948;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */