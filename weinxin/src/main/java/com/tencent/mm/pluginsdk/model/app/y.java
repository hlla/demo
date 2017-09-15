package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.protocal.c.kb;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class y
  extends k
  implements j
{
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private final b sBZ;
  
  public y(b paramb, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(825439027200L, 6150);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ka();
    ((b.a)localObject).hrW = new kb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
    ((b.a)localObject).hrU = 728;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    this.sBZ = paramb;
    localObject = (ka)this.gUq.hrS.hsa;
    ((ka)localObject).tlA = paramString1;
    ((ka)localObject).toz = paramb.field_totalLen;
    ((ka)localObject).toA = paramString2;
    ((ka)localObject).hNH = paramString3;
    ((ka)localObject).toB = paramString4;
    ((ka)localObject).muu = paramString5;
    ap.yY();
    ((ka)localObject).mut = ((String)com.tencent.mm.u.c.vr().get(2, ""));
    ((ka)localObject).tfg = com.tencent.mm.modelcdntran.b.hxv;
    v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[] { bf.Qi(((ka)localObject).tlA), ((ka)localObject).toA, ((ka)localObject).hNH, ((ka)localObject).toB, Long.valueOf(((ka)localObject).toz), Integer.valueOf(((ka)localObject).tfg), bf.bJP() });
    GMTrace.o(825439027200L, 6150);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(825707462656L, 6152);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(825707462656L, 6152);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(825841680384L, 6153);
    v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramp = (kb)((com.tencent.mm.y.b)paramp).hrT.hsa;
      this.sBZ.field_signature = paramp.hAo;
      this.sBZ.field_fakeAeskey = paramp.toD;
      this.sBZ.field_fakeSignature = paramp.toE;
      boolean bool = an.abF().c(this.sBZ, new String[0]);
      v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[] { bf.Qi(this.sBZ.field_signature), bf.Qi(this.sBZ.field_fakeAeskey), bf.Qi(this.sBZ.field_fakeSignature), Boolean.valueOf(bool) });
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(825841680384L, 6153);
  }
  
  public final int getType()
  {
    GMTrace.i(825573244928L, 6151);
    GMTrace.o(825573244928L, 6151);
    return 728;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */