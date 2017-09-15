package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.o.a;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.e.a.sr.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
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
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah
  extends k
  implements com.tencent.mm.network.j
{
  public long fGD;
  public au fTa;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  public String hGf;
  private h.a hGp;
  public int hYE;
  public String iCm;
  private sr pSF;
  private String qIk;
  private o sCp;
  public long startTime;
  
  public ah(long paramLong, String paramString1, String paramString2)
  {
    GMTrace.i(807051198464L, 6013);
    this.fTa = null;
    this.fGD = 0L;
    this.startTime = 0L;
    this.hGf = "";
    this.hYE = 0;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(826646986752L, 6159);
        v.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ah.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ah.this.hGf });
          GMTrace.o(826646986752L, 6159);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ah.this.fTa.dv(5);
          com.tencent.mm.plugin.report.c.oRz.a(111L, 34L, 1L, true);
          ap.yY();
          com.tencent.mm.u.c.wT().a(ah.this.fTa.field_msgId, ah.this.fTa);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "" });
          ah.this.gUt.a(3, paramAnonymousInt, "", ah.this);
          GMTrace.o(826646986752L, 6159);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode != 0)
          {
            v.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult.field_arg, paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            ah.this.fTa.dv(5);
            com.tencent.mm.plugin.report.c.oRz.a(111L, 34L, 1L, true);
            ap.yY();
            com.tencent.mm.u.c.wT().a(ah.this.fTa.field_msgId, ah.this.fTa);
            com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            ah.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", ah.this);
          }
        }
        else
        {
          GMTrace.o(826646986752L, 6159);
          return 0;
        }
        if ((ah.this.hYE > 0) && (paramAnonymouskeep_SceneResult.field_fileLength > 0))
        {
          paramAnonymousString = ah.this.hYE + "," + paramAnonymouskeep_SceneResult.field_fileLength + "," + paramAnonymouskeep_SceneResult.field_fileId;
          if (ah.this.hYE * 2 <= paramAnonymouskeep_SceneResult.field_fileLength) {
            break label941;
          }
        }
        label941:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.ah.q("SendAppMsgThumbTooBig", paramAnonymousString, bool);
          v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_exist_whencheck), bf.Qi(paramAnonymouskeep_SceneResult.field_aesKey), paramAnonymouskeep_SceneResult.field_filemd5 });
          ap.vd().a(new ai(ah.this.fGD, false, paramAnonymouskeep_SceneResult, new ai.a()
          {
            public final void bb(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              GMTrace.i(803427319808L, 5986);
              v.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
              ah.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", ah.this);
              GMTrace.o(803427319808L, 5986);
            }
          }, ah.this.iCm, null), 0);
          break;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(826781204480L, 6160);
        GMTrace.o(826781204480L, 6160);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(826915422208L, 6161);
        GMTrace.o(826915422208L, 6161);
        return null;
      }
    };
    this.fGD = paramLong;
    this.iCm = paramString1;
    this.qIk = paramString2;
    b.a locala = new b.a();
    locala.hrV = new axj();
    locala.hrW = new axk();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.hrU = 222;
    locala.hrX = 107;
    locala.hrY = 1000000107;
    this.gUq = locala.BE();
    v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bf.Qi(paramString2), bf.bJP() });
    GMTrace.o(807051198464L, 6013);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(807185416192L, 6014);
    this.gUt = parame1;
    if (this.startTime == 0L) {
      this.startTime = bf.NA();
    }
    ap.yY();
    this.fTa = com.tencent.mm.u.c.wT().cA(this.fGD);
    if ((this.fTa == null) || (this.fTa.field_msgId != this.fGD))
    {
      GMTrace.o(807185416192L, 6014);
      return -1;
    }
    parame1 = f.a.ek(this.fTa.field_content);
    Object localObject1;
    if (parame1 == null)
    {
      localObject1 = aj.RC(this.fTa.field_content);
      if (bf.mA(((aj)localObject1).uHB))
      {
        parame1 = new f.a();
        parame1.hhi = ((aj)localObject1).fFN;
        parame1.type = 8;
        v.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.fTa.field_content + "]]";
      if (parame1 != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (parame1 != null) {
          break label232;
        }
        this.fTa = null;
        GMTrace.o(807185416192L, 6014);
        return -1;
        parame1 = f.a.ek(((aj)localObject1).uHB);
        break;
      }
      label232:
      if (!bf.mA(this.fTa.field_imgPath)) {}
      String str;
      for (localObject1 = com.tencent.mm.ah.n.GT().jv(this.fTa.field_imgPath);; localObject1 = "")
      {
        if ((parame1.type == 8) || (parame1.type == 9) || (parame1.type == 6))
        {
          v.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(parame1.type) });
          i = 0;
        }
        Object localObject2;
        while (i != 0)
        {
          v.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.hGf });
          GMTrace.o(807185416192L, 6014);
          return 0;
          if (bf.mA((String)localObject1))
          {
            v.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(parame1.type) });
            i = 0;
          }
          else
          {
            this.hYE = com.tencent.mm.a.e.aN((String)localObject1);
            if ((parame1.type != 33) && (parame1.type != 36) && (this.hYE >= 262144))
            {
              v.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Integer.valueOf(this.hYE) });
              i = 0;
            }
            else
            {
              v.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(parame1.type), localObject1, Integer.valueOf(this.hYE) });
              if (!bf.mA(parame1.fCN))
              {
                v.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.fGD) });
                i = 0;
              }
              else
              {
                com.tencent.mm.modelcdntran.g.Em();
                if (!com.tencent.mm.modelcdntran.c.fA(4))
                {
                  com.tencent.mm.modelcdntran.g.Em();
                  v.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(4)) });
                  i = 0;
                }
                else
                {
                  this.hGf = d.a("upappmsg", this.fTa.field_createTime, this.fTa.field_talker, this.fTa.field_msgId);
                  if (bf.mA(this.hGf))
                  {
                    v.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.fTa.field_msgId) });
                    i = 0;
                  }
                  else
                  {
                    localObject2 = new h();
                    ((h)localObject2).hyM = this.hGp;
                    ((h)localObject2).field_mediaId = this.hGf;
                    ((h)localObject2).field_fullpath = "";
                    ((h)localObject2).field_thumbpath = ((String)localObject1);
                    ((h)localObject2).field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    ((h)localObject2).field_talker = this.fTa.field_talker;
                    ((h)localObject2).field_priority = com.tencent.mm.modelcdntran.b.hxt;
                    ((h)localObject2).field_needStorage = false;
                    ((h)localObject2).field_isStreamMedia = false;
                    ((h)localObject2).hyM = this.hGp;
                    ((h)localObject2).field_force_aeskeycdn = true;
                    ((h)localObject2).field_trysafecdn = false;
                    v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(parame1.type), localObject1, this.hGf, Integer.valueOf(((h)localObject2).field_fileType), Boolean.valueOf(((h)localObject2).field_enable_hitcheck), Boolean.valueOf(((h)localObject2).field_onlycheckexist), Boolean.valueOf(((h)localObject2).field_force_aeskeycdn), Boolean.valueOf(((h)localObject2).field_trysafecdn) });
                    if (!com.tencent.mm.modelcdntran.g.Em().b((h)localObject2))
                    {
                      v.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                      this.hGf = "";
                      i = 0;
                    }
                    else
                    {
                      i = 1;
                    }
                  }
                }
              }
            }
          }
        }
        axj localaxj = (axj)this.gUq.hrS.hsa;
        cu localcu = new cu();
        localcu.mrA = parame1.appId;
        localcu.teo = (this.fTa.field_talker + this.fTa.field_msgId + "T" + this.fTa.field_createTime);
        localcu.oog = f.a.a(parame1, null, null, 0, 0);
        localcu.ofk = ((int)bf.Nz());
        localcu.mut = this.fTa.field_talker;
        localcu.muu = m.xL();
        localcu.jMq = parame1.type;
        localcu.ten = parame1.sdkVer;
        localcu.teq = parame1.hhj;
        q.b localb;
        bde localbde;
        if (com.tencent.mm.modelbiz.e.dr(this.fTa.field_talker))
        {
          localcu.tdC = com.tencent.mm.modelbiz.a.e.ix(this.fTa.gxv);
          localcu.tes = parame1.fUK;
          localcu.tet = parame1.fUL;
          localcu.teu = parame1.fUM;
          localb = q.yC().fP(this.iCm);
          if (localb != null)
          {
            this.pSF = new sr();
            this.pSF.gag.url = parame1.url;
            this.pSF.gag.gah = localb.getString("prePublishId", "");
            this.pSF.gag.gaj = localb.getString("preUsername", "");
            this.pSF.gag.gak = localb.getString("preChatName", "");
            this.pSF.gag.gal = localb.getInt("preMsgIndex", 0);
            this.pSF.gag.gap = localb.getInt("sendAppMsgScene", 0);
            this.pSF.gag.gaq = localb.getInt("getA8KeyScene", 0);
            this.pSF.gag.gar = localb.getString("referUrl", null);
            this.pSF.gag.gas = localb.getString("adExtStr", null);
            this.pSF.gag.gam = this.fTa.field_talker;
            this.pSF.gag.gat = parame1.title;
            ap.yY();
            localObject2 = com.tencent.mm.u.c.wR().Rb(this.fTa.field_talker);
            if (localObject2 != null) {
              this.pSF.gag.gan = ((x)localObject2).tK();
            }
            this.pSF.gag.gao = com.tencent.mm.u.j.eC(this.fTa.field_talker);
            str = "";
            localObject2 = str;
            if (parame1.fUO != null)
            {
              localbde = new bde();
              localObject2 = Base64.decode(parame1.fUO, 0);
            }
          }
        }
        try
        {
          localbde.aD((byte[])localObject2);
          localObject2 = str;
          if (localbde.ucQ != null) {
            localObject2 = localbde.ucQ.mnX;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject3 = str;
          }
        }
        localaxj.tYu = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.pSF.gag.gah, this.pSF.gag.gaj, this.pSF.gag.gak, Integer.valueOf(com.tencent.mm.u.p.G(this.pSF.gag.gaj, this.pSF.gag.gak)), Integer.valueOf(this.pSF.gag.gaq), localObject2 });
        if ((localb != null) && (parame1.type == 33))
        {
          this.sCp = new o();
          i = localb.getInt("fromScene", 1);
          this.sCp.fCC.scene = i;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.sCp.fCC.fCE = ((String)localObject2 + ":" + str);
            label1656:
            localObject2 = this.fTa.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2060;
            }
            localObject2 = this.sCp.fCC;
            if (!bool) {
              break label2055;
            }
            i = 5;
            label1703:
            ((o.a)localObject2).action = i;
            this.sCp.fCC.fCD = (parame1.hjJ + 1);
            this.sCp.fCC.fCF = parame1.hjB;
            this.sCp.fCC.fCA = parame1.hjC;
            this.sCp.fCC.appId = parame1.hjD;
            this.sCp.fCC.fCH = bf.Nz();
            this.sCp.fCC.fCI = 1;
          }
        }
        else
        {
          v.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { parame1.fUK, parame1.fUL, parame1.fUM });
          if (!bf.mA((String)localObject1))
          {
            localObject2 = com.tencent.mm.a.e.c((String)localObject1, 0, -1);
            if (!bf.bm((byte[])localObject2)) {
              localcu.tep = new avt().bb((byte[])localObject2);
            }
          }
          if (localcu.tep == null) {
            break label2090;
          }
        }
        label2055:
        label2060:
        label2090:
        for (int i = localcu.tep.tXB;; i = -1)
        {
          v.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localaxj.tYs = localcu;
          if ((parame1.hhk != 0) || (parame1.hhg > 26214400)) {
            localaxj.tfg = com.tencent.mm.modelcdntran.b.hxv;
          }
          localaxj.tsH = parame1.filemd5;
          localaxj.hAo = this.qIk;
          v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localaxj.tsH, bf.Qi(localaxj.hAo), Integer.valueOf(localaxj.tfg), localaxj.tYu });
          i = a(parame, this.gUq, this);
          GMTrace.o(807185416192L, 6014);
          return i;
          localcu.tdC = ba.zz();
          break;
          this.sCp.fCC.fCE = ((String)localObject2);
          break label1656;
          i = 2;
          break label1703;
          localObject2 = this.sCp.fCC;
          if (bool) {}
          for (i = 4;; i = 1)
          {
            ((o.a)localObject2).action = i;
            break;
          }
        }
      }
    }
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(807588069376L, 6017);
    int i = k.b.hsC;
    GMTrace.o(807588069376L, 6017);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(807319633920L, 6015);
    v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.fGD), this.fTa.field_content });
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(807319633920L, 6015);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.fTa.dv(5);
      com.tencent.mm.plugin.report.c.oRz.a(111L, 34L, 1L, true);
      ap.yY();
      com.tencent.mm.u.c.wT().a(this.fTa.field_msgId, this.fTa);
      v.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.fTa.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(807319633920L, 6015);
      return;
    }
    paramArrayOfByte = (axk)((com.tencent.mm.y.b)paramp).hrT.hsa;
    axj localaxj = (axj)((com.tencent.mm.y.b)paramp).hrS.hsa;
    this.fTa.dv(2);
    this.fTa.y(paramArrayOfByte.tdE);
    ap.yY();
    com.tencent.mm.u.c.wT().a(this.fTa.field_msgId, this.fTa);
    com.tencent.mm.modelstat.b.hTV.a(this.fTa, com.tencent.mm.t.g.g(this.fTa));
    if ((this.pSF != null) && (!bf.mA(this.pSF.gag.url)))
    {
      this.pSF.gag.gai = ("msg_" + Long.toString(paramArrayOfByte.tdE));
      a.uql.m(this.pSF);
    }
    paramArrayOfByte = f.a.ek(this.fTa.field_content);
    if ((paramArrayOfByte != null) && ("wx4310bbd51be7d979".equals(paramArrayOfByte.appId))) {
      if ((bf.mA(this.fTa.field_talker)) || (!this.fTa.field_talker.endsWith("@chatroom"))) {
        break label798;
      }
    }
    label798:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramp = "";
      try
      {
        paramArrayOfByte = URLEncoder.encode(paramArrayOfByte.description, "UTF-8");
        paramp = paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramp = paramInt1 + ",," + paramp;
      v.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramp });
      com.tencent.mm.plugin.report.service.g.oSF.A(13717, paramp);
      if (this.sCp != null)
      {
        this.sCp.fCC.fCG = ("msg_" + this.fTa.field_msgSvrId);
        a.uql.m(this.sCp);
      }
      if (localaxj.tYs.tep != null) {
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(localaxj.tYs.tep.tXB) });
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(807319633920L, 6015);
      return;
    }
  }
  
  public final int getType()
  {
    GMTrace.i(807453851648L, 6016);
    GMTrace.o(807453851648L, 6016);
    return 222;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */