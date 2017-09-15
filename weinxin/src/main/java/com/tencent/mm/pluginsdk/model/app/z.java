package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class z
  extends k
  implements j
{
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private final a sCa;
  
  public z(f.a parama, String paramString1, String paramString2, a parama1)
  {
    GMTrace.i(814298955776L, 6067);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new kc();
    ((b.a)localObject).hrW = new kd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).hrU = 727;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (kc)this.gUq.hrS.hsa;
    if (parama != null)
    {
      ((kc)localObject).tlA = parama.hhu;
      ((kc)localObject).toA = parama.filemd5;
      ((kc)localObject).hNH = parama.title;
      ((kc)localObject).toB = parama.hhh;
    }
    for (((kc)localObject).toz = parama.hhg;; ((kc)localObject).toz = com.tencent.mm.a.e.aN(paramString1))
    {
      ((kc)localObject).tfg = com.tencent.mm.modelcdntran.b.hxv;
      ((kc)localObject).mut = paramString2;
      ((kc)localObject).muu = m.xL();
      this.sCa = parama1;
      v.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { parama, ((kc)localObject).tlA, ((kc)localObject).toA, ((kc)localObject).hNH, Long.valueOf(((kc)localObject).toz), ((kc)localObject).toB, ((kc)localObject).mut, ((kc)localObject).muu, bf.bJP() });
      GMTrace.o(814298955776L, 6067);
      return;
      g.En();
      ((kc)localObject).tlA = com.tencent.mm.modelcdntran.b.Ee();
      g.En();
      ((kc)localObject).toA = com.tencent.mm.modelcdntran.b.iK(paramString1);
      ((kc)localObject).hNH = com.tencent.mm.a.e.aR(paramString1);
      ((kc)localObject).toB = com.tencent.mm.a.e.aQ(paramString1);
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(814567391232L, 6069);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(814567391232L, 6069);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(814701608960L, 6070);
    v.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      if (this.sCa != null) {
        this.sCa.a("", "", "", "", "", 0L);
      }
      GMTrace.o(814701608960L, 6070);
      return;
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    paramString = (kc)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (kd)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramp.hAo, Integer.valueOf(paramp.toC), paramp.toD, paramp.toE });
    if (this.sCa != null) {
      this.sCa.a(paramString.toA, paramString.tlA, paramp.hAo, paramp.toD, paramp.toE, paramString.toz);
    }
    GMTrace.o(814701608960L, 6070);
  }
  
  public final int getType()
  {
    GMTrace.i(814433173504L, 6068);
    GMTrace.o(814433173504L, 6068);
    return 727;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */