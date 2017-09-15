package com.tencent.mm.ar;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.io.File;

public final class b
  extends k
  implements j
{
  private String clientId;
  private String fNR;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public String hOI;
  private int hrb;
  private int hrc;
  private String username;
  
  private b(String paramString)
  {
    GMTrace.i(304003153920L, 2265);
    this.username = paramString;
    this.hrb = 0;
    this.hrc = 0;
    paramString = new StringBuilder();
    com.tencent.mm.kernel.h.vG();
    this.clientId = (com.tencent.mm.kernel.a.uH() + System.currentTimeMillis());
    GMTrace.o(304003153920L, 2265);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    GMTrace.i(303868936192L, 2264);
    this.fNR = paramString2;
    GMTrace.o(303868936192L, 2264);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(304540024832L, 2269);
    this.gUt = parame1;
    if ((this.fNR == null) || (this.fNR.length() == 0))
    {
      v.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      GMTrace.o(304540024832L, 2269);
      return -1;
    }
    if (!com.tencent.mm.a.e.aO(this.fNR))
    {
      v.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.fNR);
      GMTrace.o(304540024832L, 2269);
      return -1;
    }
    if (this.hrb == 0) {
      this.hrb = ((int)new File(this.fNR).length());
    }
    parame1 = new b.a();
    parame1.hrV = new bgz();
    parame1.hrW = new bha();
    parame1.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    parame1.hrU = 575;
    parame1.hrX = 0;
    parame1.hrY = 0;
    this.gUq = parame1.BE();
    int i = Math.min(this.hrb - this.hrc, 32768);
    parame1 = com.tencent.mm.a.e.c(this.fNR, this.hrc, i);
    if (parame1 == null)
    {
      v.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      GMTrace.o(304540024832L, 2269);
      return -1;
    }
    v.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(parame1.length), Integer.valueOf(this.hrb) });
    bgz localbgz = (bgz)this.gUq.hrS.hsa;
    localbgz.trV = this.username;
    localbgz.tfd = this.hrb;
    localbgz.tfe = this.hrc;
    localbgz.tqC = new avt().bb(parame1);
    localbgz.tff = localbgz.tqC.tXB;
    localbgz.tdq = this.clientId;
    i = a(parame, this.gUq, this);
    GMTrace.o(304540024832L, 2269);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(304271589376L, 2267);
    if ((this.fNR == null) || (this.fNR.length() == 0))
    {
      i = k.b.hsD;
      GMTrace.o(304271589376L, 2267);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(304271589376L, 2267);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(304674242560L, 2270);
    v.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(304674242560L, 2270);
      return;
    }
    paramp = (bha)((com.tencent.mm.y.b)paramp).hrT.hsa;
    this.hOI = paramp.tPj;
    this.hrc = paramp.tfe;
    if (this.hrc < this.hrb)
    {
      if (a(this.hsm, this.gUt) < 0)
      {
        v.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.gUt.a(3, -1, "", this);
      }
      v.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      GMTrace.o(304674242560L, 2270);
      return;
    }
    if (!bf.mA(this.hOI))
    {
      paramp = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(this.username);
      if ((paramp != null) && ((int)paramp.gTG > 0) && (com.tencent.mm.j.a.ez(paramp.field_type)))
      {
        paramp.cm(this.hOI);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this.username, paramp);
      }
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(304674242560L, 2270);
  }
  
  public final int getType()
  {
    GMTrace.i(304137371648L, 2266);
    GMTrace.o(304137371648L, 2266);
    return 575;
  }
  
  protected final int ub()
  {
    GMTrace.i(304405807104L, 2268);
    GMTrace.o(304405807104L, 2268);
    return 100;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */