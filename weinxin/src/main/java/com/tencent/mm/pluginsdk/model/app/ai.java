package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.e.a.sr.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.util.Locale;

public final class ai
  extends k
  implements com.tencent.mm.network.j
{
  private long fGD;
  private au fTa;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private keep_SceneResult gVf;
  private String iCm;
  private sr pSF;
  private o sCp;
  private b sCs;
  private boolean sCt;
  private a sCu;
  
  public ai(long paramLong, boolean paramBoolean, keep_SceneResult paramkeep_SceneResult, a parama, String paramString, b paramb)
  {
    GMTrace.i(807856504832L, 6019);
    this.fGD = 0L;
    this.gVf = null;
    this.sCs = null;
    this.fTa = null;
    this.sCt = false;
    this.sCu = null;
    this.fGD = paramLong;
    this.iCm = paramString;
    this.gVf = paramkeep_SceneResult;
    this.sCu = parama;
    this.sCt = paramBoolean;
    this.sCs = paramb;
    parama = new b.a();
    parama.hrV = new axj();
    parama.hrW = new axk();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.hrU = 222;
    parama.hrX = 107;
    parama.hrY = 1000000107;
    this.gUq = parama.BE();
    v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramkeep_SceneResult, paramString, paramb, bf.bJP() });
    GMTrace.o(807856504832L, 6019);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(808259158016L, 6022);
    this.gUt = parame1;
    ap.yY();
    this.fTa = com.tencent.mm.u.c.wT().cA(this.fGD);
    if ((this.fTa == null) || (this.fTa.field_msgId != this.fGD))
    {
      v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.fGD) });
      this.sCu.bb(3, -1);
      GMTrace.o(808259158016L, 6022);
      return -1;
    }
    f.a locala = f.a.ek(this.fTa.field_content);
    if (locala == null)
    {
      v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.fGD) });
      this.sCu.bb(3, -1);
    }
    axj localaxj = (axj)this.gUq.hrS.hsa;
    cu localcu = new cu();
    localcu.mrA = locala.appId;
    localcu.teo = (this.fTa.field_talker + this.fTa.field_msgId + "T" + this.fTa.field_createTime);
    localcu.ofk = ((int)bf.Nz());
    localcu.mut = this.fTa.field_talker;
    localcu.muu = m.xL();
    localcu.jMq = locala.type;
    localcu.ten = locala.sdkVer;
    localcu.teq = locala.hhj;
    q.b localb;
    bde localbde;
    if (com.tencent.mm.modelbiz.e.dr(this.fTa.field_talker))
    {
      localcu.tdC = com.tencent.mm.modelbiz.a.e.ix(this.fTa.gxv);
      localcu.tes = locala.fUK;
      localcu.tet = locala.fUL;
      localcu.teu = locala.fUM;
      localb = q.yC().fP(this.iCm);
      if (localb != null)
      {
        this.pSF = new sr();
        this.pSF.gag.url = locala.url;
        this.pSF.gag.gah = localb.getString("prePublishId", "");
        this.pSF.gag.gaj = localb.getString("preUsername", "");
        this.pSF.gag.gak = localb.getString("preChatName", "");
        this.pSF.gag.gal = localb.getInt("preMsgIndex", 0);
        this.pSF.gag.gap = localb.getInt("sendAppMsgScene", 0);
        this.pSF.gag.gaq = localb.getInt("getA8KeyScene", 0);
        this.pSF.gag.gar = localb.getString("referUrl", null);
        this.pSF.gag.gas = localb.getString("adExtStr", null);
        this.pSF.gag.gam = this.fTa.field_talker;
        this.pSF.gag.gat = locala.title;
        ap.yY();
        parame1 = com.tencent.mm.u.c.wR().Rb(this.fTa.field_talker);
        if (parame1 != null) {
          this.pSF.gag.gan = parame1.tK();
        }
        this.pSF.gag.gao = com.tencent.mm.u.j.eC(this.fTa.field_talker);
        str = "";
        parame1 = str;
        if (locala.fUO != null)
        {
          localbde = new bde();
          parame1 = Base64.decode(locala.fUO, 0);
        }
      }
    }
    try
    {
      localbde.aD(parame1);
      parame1 = str;
      if (localbde.ucQ != null) {
        parame1 = localbde.ucQ.mnX;
      }
    }
    catch (Exception parame1)
    {
      for (;;)
      {
        int i;
        label921:
        boolean bool;
        label965:
        int k;
        int m;
        int j;
        label1541:
        label1546:
        label1574:
        parame1 = str;
      }
    }
    localaxj.tYu = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.pSF.gag.gah, this.pSF.gag.gaj, this.pSF.gag.gak, Integer.valueOf(com.tencent.mm.u.p.G(this.pSF.gag.gaj, this.pSF.gag.gak)), Integer.valueOf(this.pSF.gag.gaq), parame1 });
    if ((localb != null) && (locala.type == 33))
    {
      this.sCp = new o();
      i = localb.getInt("fromScene", 1);
      this.sCp.fCC.scene = i;
      parame1 = localb.getString("preChatName", "");
      if (2 == i)
      {
        str = localb.getString("preUsername", "");
        this.sCp.fCC.fCE = (parame1 + ":" + str);
        parame1 = this.fTa.field_talker;
        bool = localb.getBoolean("moreRetrAction", false);
        if (!parame1.endsWith("@chatroom")) {
          break label1546;
        }
        parame1 = this.sCp.fCC;
        if (!bool) {
          break label1541;
        }
        i = 5;
        parame1.action = i;
        this.sCp.fCC.fCD = (locala.hjJ + 1);
        this.sCp.fCC.fCF = locala.hjB;
        this.sCp.fCC.fCA = locala.hjC;
        this.sCp.fCC.appId = locala.hjD;
        this.sCp.fCC.fCH = bf.Nz();
        this.sCp.fCC.fCI = 1;
      }
    }
    else
    {
      v.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { locala.fUK, locala.fUL, locala.fUM });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bf.mA(this.fTa.field_imgPath))
      {
        parame1 = d.Pd(n.GT().jv(this.fTa.field_imgPath));
        j = m;
        i = k;
        if (parame1 != null)
        {
          i = parame1.outWidth;
          j = parame1.outHeight;
        }
      }
      if (this.gVf.isUploadBySafeCDNWithMD5())
      {
        v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.gVf.field_filecrc), Boolean.valueOf(this.gVf.field_upload_by_safecdn), Integer.valueOf(this.gVf.field_UploadHitCacheType), this.gVf.field_aesKey });
        this.gVf.field_aesKey = "";
        localaxj.tYv = 1;
      }
      localaxj.tlC = this.gVf.field_filecrc;
      parame1 = null;
      if (this.sCt) {
        parame1 = "@cdn_" + this.gVf.field_fileId + "_" + this.gVf.field_aesKey + "_1";
      }
      localcu.oog = f.a.a(locala, parame1, this.gVf, i, j);
      localaxj.tYs = localcu;
      if ((this.sCs != null) && ((locala.hhk != 0) || (locala.hhg > 26214400)))
      {
        localaxj.hAo = this.sCs.field_signature;
        localaxj.tfg = com.tencent.mm.modelcdntran.b.hxv;
      }
      localaxj.tsH = locala.filemd5;
      if (!bf.mA(this.gVf.field_filemd5)) {
        break label1574;
      }
      v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { locala.filemd5 });
    }
    for (;;)
    {
      v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localaxj.tsH, Integer.valueOf(localaxj.tYv), bf.Qi(localaxj.hAo), Integer.valueOf(localaxj.tfg), this.gVf, localaxj.tYu });
      i = a(parame, this.gUq, this);
      GMTrace.o(808259158016L, 6022);
      return i;
      localcu.tdC = ba.zz();
      break;
      this.sCp.fCC.fCE = parame1;
      break label921;
      i = 2;
      break label965;
      parame1 = this.sCp.fCC;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        parame1.action = i;
        break;
      }
      localaxj.tsH = this.gVf.field_filemd5;
    }
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(808124940288L, 6021);
    int i = k.b.hsC;
    GMTrace.o(808124940288L, 6021);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(808393375744L, 6023);
    paramArrayOfByte = (axj)((com.tencent.mm.y.b)paramp).hrS.hsa;
    v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.fGD), this.fTa.field_content, paramArrayOfByte.tYs.oog });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        v.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        this.sCu.bb(paramInt2, paramInt3);
        GMTrace.o(808393375744L, 6023);
        return;
      }
      this.fTa.dv(5);
      ap.yY();
      com.tencent.mm.u.c.wT().a(this.fTa.field_msgId, this.fTa);
      v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.sCu.bb(paramInt2, paramInt3);
      GMTrace.o(808393375744L, 6023);
      return;
    }
    paramp = (axk)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramp.tdE), paramp.tlA, this.fTa.field_content });
    if ((this.gVf != null) && (this.gVf.isUploadBySafeCDNWithMD5()))
    {
      if (bf.mA(paramp.tlA)) {
        break label613;
      }
      paramArrayOfByte = f.a.ek(this.fTa.field_content);
      paramArrayOfByte.hhu = paramp.tlA;
      this.fTa.setContent(f.a.a(paramArrayOfByte, null, null));
      v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramp.tlA, this.fTa.field_content });
    }
    for (;;)
    {
      this.fTa.dv(2);
      this.fTa.y(paramp.tdE);
      ap.yY();
      com.tencent.mm.u.c.wT().a(this.fTa.field_msgId, this.fTa);
      com.tencent.mm.modelstat.b.hTV.a(this.fTa, g.g(this.fTa));
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.sCu.bb(paramInt2, paramInt3);
      if ((this.pSF != null) && (!bf.mA(this.pSF.gag.url)))
      {
        this.pSF.gag.gai = ("msg_" + Long.toString(paramp.tdE));
        a.uql.m(this.pSF);
      }
      if (this.sCp != null)
      {
        this.sCp.fCC.fCG = ("msg_" + this.fTa.field_msgSvrId);
        a.uql.m(this.sCp);
      }
      GMTrace.o(808393375744L, 6023);
      return;
      label613:
      v.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final int getType()
  {
    GMTrace.i(807990722560L, 6020);
    GMTrace.o(807990722560L, 6020);
    return 222;
  }
  
  static abstract interface a
  {
    public abstract void bb(int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */