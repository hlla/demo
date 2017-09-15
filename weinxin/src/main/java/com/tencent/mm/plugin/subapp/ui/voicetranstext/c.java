package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class c
  extends k
  implements j
{
  private final String TAG;
  private com.tencent.mm.y.b hrN;
  private String mFileName;
  private com.tencent.mm.y.e nVH;
  private String qUd;
  private bjk qUf;
  public bib qUl;
  
  public c(c paramc)
  {
    GMTrace.i(5762369716224L, 42933);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.qUd = paramc.qUd;
    this.qUf = paramc.qUf;
    this.qUl = paramc.qUl;
    this.mFileName = paramc.mFileName;
    bnc();
    GMTrace.o(5762369716224L, 42933);
  }
  
  public c(String paramString1, bib parambib, int paramInt, String paramString2)
  {
    GMTrace.i(5762503933952L, 42934);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.qUd = paramString1;
      this.qUl = parambib;
      this.qUf = d.aq(paramInt, paramString2);
      this.mFileName = paramString2;
      bnc();
      GMTrace.o(5762503933952L, 42934);
      return;
    }
  }
  
  private void bnc()
  {
    GMTrace.i(5763040804864L, 42938);
    b.a locala = new b.a();
    locala.hrV = new bic();
    locala.hrW = new bid();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.hrU = 547;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hrN = locala.BE();
    GMTrace.o(5763040804864L, 42938);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5762772369408L, 42936);
    this.nVH = parame1;
    if ((!bf.mA(this.mFileName)) && (!bf.mA(this.qUd)) && (this.qUl != null) && (this.qUf != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      v.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      GMTrace.o(5762772369408L, 42936);
      return -1;
    }
    bic localbic = (bic)this.hrN.hrS.hsa;
    localbic.tpP = this.qUd;
    localbic.tpQ = this.qUf;
    localbic.tpS = this.qUl;
    Object localObject = this.mFileName;
    i = this.qUl.tfe;
    int j = this.qUl.tff;
    parame1 = new avt();
    localObject = q.lW((String)localObject);
    if (localObject != null) {
      parame1 = n.G(((com.tencent.mm.modelvoice.b)localObject).bd(i, j).buf);
    }
    localbic.tqC = parame1;
    i = a(parame, this.hrN, this);
    GMTrace.o(5762772369408L, 42936);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5762906587136L, 42937);
    bnd();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.qUl = ((bid)this.hrN.hrT.hsa).tpS;
      this.nVH.a(paramInt2, paramInt3, paramString, this);
      if (!bnd()) {
        break label137;
      }
      if (this.qUl == null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(5762906587136L, 42937);
      return;
      v.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label137:
    GMTrace.o(5762906587136L, 42937);
  }
  
  public final boolean bnd()
  {
    GMTrace.i(5763175022592L, 42939);
    if (this.qUl != null)
    {
      if (this.qUl.tff <= 0)
      {
        GMTrace.o(5763175022592L, 42939);
        return true;
      }
      GMTrace.o(5763175022592L, 42939);
      return false;
    }
    GMTrace.o(5763175022592L, 42939);
    return true;
  }
  
  public final int getType()
  {
    GMTrace.i(5762638151680L, 42935);
    GMTrace.o(5762638151680L, 42935);
    return 547;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicetranstext/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */