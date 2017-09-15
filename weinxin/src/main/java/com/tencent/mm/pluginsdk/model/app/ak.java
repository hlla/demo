package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.ly.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class ak
  extends k
  implements com.tencent.mm.network.j
{
  public f.a fCR;
  public int fEO;
  public String fFw;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  private boolean gVc;
  public int gVe;
  public keep_SceneResult gVf;
  public com.tencent.mm.sdk.b.c gVh;
  public String hGf;
  private h.a hGp;
  public boolean hGw;
  private String hhi;
  public b sBZ;
  public long sCc;
  private boolean sCw;
  private long sCx;
  public long startTime;
  public String toUser;
  
  public ak(long paramLong, String paramString1, String paramString2)
  {
    GMTrace.i(805440585728L, 6001);
    this.sBZ = null;
    this.fCR = null;
    this.sCc = -1L;
    this.hhi = null;
    this.sCw = true;
    this.hGw = true;
    this.fEO = 0;
    this.startTime = 0L;
    this.sCx = -1L;
    this.hGf = "";
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(824633720832L, 6144);
        paramAnonymousString = ak.this.hGf;
        boolean bool1;
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          bool1 = true;
          if (paramAnonymouskeep_SceneResult == null) {
            break label155;
          }
        }
        label155:
        for (boolean bool2 = true;; bool2 = false)
        {
          v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          an.abF().b(ak.this.sCc, ak.this.sBZ);
          if (paramAnonymousInt != 44531) {
            break label161;
          }
          v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.this.hGf });
          GMTrace.o(824633720832L, 6144);
          return 0;
          bool1 = false;
          break;
        }
        label161:
        if (paramAnonymousInt != 0)
        {
          l.ee(ak.this.sBZ.uvp);
          an.abF().b(ak.this.sCc, ak.this.sBZ);
          ak.this.sBZ.field_signature = "";
          paramAnonymousBoolean = an.abF().c(ak.this.sBZ, new String[0]);
          v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(ak.this.sCc), Boolean.valueOf(paramAnonymousBoolean) });
          ak.this.gUt.a(3, paramAnonymousInt, "", ak.this);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "" });
          GMTrace.o(824633720832L, 6144);
          return 0;
        }
        if (ak.this.sBZ.field_status == 105L)
        {
          v.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(ak.this.sBZ.field_status), Long.valueOf(ak.this.sCc) });
          com.tencent.mm.modelcdntran.g.Em().iP(ak.this.hGf);
          ak.this.gUt.a(3, paramAnonymousInt, "attach  has paused, status" + ak.this.sBZ.field_status, ak.this);
          GMTrace.o(824633720832L, 6144);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (ak.this.sBZ.field_offset > paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(ak.this.sBZ.field_offset), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            GMTrace.o(824633720832L, 6144);
            return 0;
          }
          ak.this.sBZ.field_lastModifyTime = bf.Nz();
          ak.this.sBZ.field_offset = paramAnonymouskeep_ProgressInfo.field_finishedLength;
          paramAnonymousBoolean = an.abF().c(ak.this.sBZ, new String[0]);
          if (!paramAnonymousBoolean)
          {
            v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + paramAnonymousBoolean);
            ak.this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
            ak.this.gUt.a(3, paramAnonymousInt, "", ak.this);
            GMTrace.o(824633720832L, 6144);
            return 0;
          }
          GMTrace.o(824633720832L, 6144);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1256;
          }
          v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult.field_arg, paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          l.ee(ak.this.sBZ.uvp);
          an.abF().b(ak.this.sCc, ak.this.sBZ);
          ak.this.sBZ.field_signature = "";
          paramAnonymousBoolean = an.abF().c(ak.this.sBZ, new String[0]);
          v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Long.valueOf(ak.this.sCc), Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          ak.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", ak.this);
        }
        for (;;)
        {
          GMTrace.o(824633720832L, 6144);
          return 0;
          label1256:
          v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_exist_whencheck), bf.Qi(ak.this.sBZ.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymouskeep_SceneResult.field_exist_whencheck)
            {
              ap.vd().a(new z(ak.this.fCR, ak.this.sBZ.field_fileFullPath, ak.this.toUser, new z.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  GMTrace.i(825304809472L, 6149);
                  paramAnonymous2String2 = bf.Qi(paramAnonymous2String2);
                  String str1 = bf.Qi(paramAnonymous2String3);
                  String str2 = bf.Qi(paramAnonymous2String4);
                  String str3 = bf.Qi(paramAnonymous2String5);
                  if (ak.this.fCR == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hGw) });
                    if (!bf.mA(paramAnonymous2String3))
                    {
                      ak.this.sBZ.field_signature = paramAnonymous2String3;
                      ak.this.sBZ.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.sBZ.field_fakeSignature = paramAnonymous2String5;
                    }
                    ak.1.this.a(paramAnonymousInt, paramAnonymouskeep_SceneResult);
                    GMTrace.o(825304809472L, 6149);
                    return;
                  }
                }
              }), 0);
            }
            else
            {
              v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              ap.vd().a(new z(null, ak.this.sBZ.field_fileFullPath, ak.this.toUser, new z.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  GMTrace.i(811346165760L, 6045);
                  String str1 = bf.Qi(paramAnonymous2String2);
                  String str2 = bf.Qi(paramAnonymous2String3);
                  String str3 = bf.Qi(paramAnonymous2String4);
                  String str4 = bf.Qi(paramAnonymous2String5);
                  if (ak.this.fCR == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hGw) });
                    if (!bf.mA(paramAnonymous2String3))
                    {
                      ak.this.sBZ.field_signature = paramAnonymous2String3;
                      ak.this.sBZ.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.sBZ.field_fakeSignature = paramAnonymous2String5;
                      ak.this.sBZ.field_lastModifyTime = bf.NA();
                      if (ak.this.fCR != null)
                      {
                        ak.this.fCR.filemd5 = paramAnonymous2String1;
                        ak.this.fCR.hhu = paramAnonymous2String2;
                        ak.this.fCR.hhg = ((int)paramAnonymous2Long);
                        ap.yY();
                        paramAnonymous2String1 = com.tencent.mm.u.c.wT().cA(ak.this.sBZ.field_msgInfoId);
                        paramAnonymous2String1.setContent(f.a.a(ak.this.fCR, null, null));
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                      }
                    }
                    ak.this.hGw = false;
                    bool = an.abF().c(ak.this.sBZ, new String[0]);
                    if (bool) {
                      break;
                    }
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + bool);
                    ak.this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
                    ak.this.gUt.a(3, paramAnonymousInt, "", ak.this);
                    GMTrace.o(811346165760L, 6045);
                    return;
                  }
                  ap.vL().D(new Runnable()
                  {
                    public final void run()
                    {
                      GMTrace.i(806648545280L, 6010);
                      v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      ak.this.a(ak.this.hsm, ak.this.gUt);
                      GMTrace.o(806648545280L, 6010);
                    }
                  });
                  GMTrace.o(811346165760L, 6045);
                }
              }), 0);
            }
          }
          else {
            a(paramAnonymousInt, paramAnonymouskeep_SceneResult);
          }
        }
      }
      
      public final void a(int paramAnonymousInt, final keep_SceneResult paramAnonymouskeep_SceneResult)
      {
        GMTrace.i(824767938560L, 6145);
        ak.this.sBZ.field_status = 199L;
        boolean bool = an.abF().c(ak.this.sBZ, new String[0]);
        if (!bool)
        {
          v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + bool);
          ak.this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
          ak.this.gUt.a(3, paramAnonymousInt, "", ak.this);
          GMTrace.o(824767938560L, 6145);
          return;
        }
        l.a(ak.this.sBZ.field_msgInfoId, ak.this.sBZ.field_mediaSvrId, paramAnonymouskeep_SceneResult);
        ap.vd().a(new ai(ak.this.sBZ.field_msgInfoId, true, paramAnonymouskeep_SceneResult, new ai.a()
        {
          public final void bb(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            GMTrace.i(804366843904L, 5993);
            v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              ap.vL().D(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(811614601216L, 6047);
                  ak.this.hGw = false;
                  ak.this.sBZ.field_createTime = bf.NA();
                  ak.this.sBZ.field_lastModifyTime = bf.Nz();
                  ak.this.sBZ.field_offset = 0L;
                  ak.this.sBZ.field_status = 101L;
                  boolean bool = an.abF().c(ak.this.sBZ, new String[0]);
                  v.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(ak.this.hGw), Boolean.valueOf(bool), Long.valueOf(ak.this.sBZ.field_createTime) });
                  ak.this.a(ak.this.hsm, ak.this.gUt);
                  GMTrace.o(811614601216L, 6047);
                }
              });
              GMTrace.o(804366843904L, 5993);
              return;
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              ak.this.c(paramAnonymouskeep_SceneResult);
            }
            ak.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", ak.this);
            GMTrace.o(804366843904L, 5993);
          }
        }, ak.this.fFw, ak.this.sBZ), 0);
        GMTrace.o(824767938560L, 6145);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(824902156288L, 6146);
        GMTrace.o(824902156288L, 6146);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(825036374016L, 6147);
        GMTrace.o(825036374016L, 6147);
        return null;
      }
    };
    this.gVc = false;
    this.gVe = 0;
    this.gVh = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ly paramAnonymously)
      {
        GMTrace.i(791750377472L, 5899);
        if (!paramAnonymously.fSU.filePath.equals(ak.this.sBZ.field_fileFullPath))
        {
          GMTrace.o(791750377472L, 5899);
          return false;
        }
        Object localObject1 = "";
        try
        {
          paramAnonymously = URLEncoder.encode(paramAnonymously.fSU.result, "UTF-8");
          if (ak.this.gVe == 1)
          {
            ap.yY();
            Object localObject2 = com.tencent.mm.u.c.wT().cA(ak.this.sBZ.field_msgInfoId);
            com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
            locald.n("20toUser", ak.this.toUser + ",");
            locald.n("21source", "4,");
            locald.n("22qrUrl", paramAnonymously + ",");
            localObject1 = new StringBuilder();
            if (ak.this.gVf == null)
            {
              paramAnonymously = "";
              locald.n("23md5", paramAnonymously + ",");
              localObject1 = new StringBuilder();
              if (ak.this.gVf != null) {
                break label472;
              }
              paramAnonymously = "";
              locald.n("24cdnFileId", paramAnonymously + ",");
              localObject1 = new StringBuilder();
              if (ak.this.gVf != null) {
                break label486;
              }
              paramAnonymously = "";
              locald.n("25cdnAesKey", paramAnonymously + ",");
              localObject1 = "";
              paramAnonymously = (ly)localObject1;
              if (((au)localObject2).axH())
              {
                localObject2 = f.a.ek(((ce)localObject2).field_content);
                paramAnonymously = (ly)localObject1;
                if (localObject2 != null) {
                  paramAnonymously = ((f.a)localObject2).appId;
                }
              }
              locald.n("26appip", paramAnonymously + ",");
              locald.n("2toUsersCount", com.tencent.mm.u.j.eC(ak.this.toUser) + ",");
              v.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + locald.JH());
              com.tencent.mm.modelstat.n.s(13628, locald.toString());
            }
          }
          else
          {
            a.uql.c(ak.this.gVh);
            GMTrace.o(791750377472L, 5899);
            return false;
          }
        }
        catch (UnsupportedEncodingException paramAnonymously)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", paramAnonymously, "", new Object[0]);
            paramAnonymously = (ly)localObject1;
            continue;
            paramAnonymously = ak.this.gVf.field_filemd5;
            continue;
            label472:
            paramAnonymously = ak.this.gVf.field_fileId;
            continue;
            label486:
            paramAnonymously = ak.this.gVf.field_aesKey;
          }
        }
      }
    };
    this.sCc = paramLong;
    this.hhi = paramString1;
    this.fFw = paramString2;
    paramString2 = new b.a();
    paramString2.hrV = new bgx();
    paramString2.hrW = new bgy();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.hrU = 220;
    paramString2.hrX = 105;
    paramString2.hrY = 1000000105;
    this.gUq = paramString2.BE();
    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bf.bJP() });
    GMTrace.o(805440585728L, 6001);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(805574803456L, 6002);
    this.gUt = parame1;
    this.sBZ = new b();
    if ((!an.abF().b(this.sCc, this.sBZ)) || (this.sBZ == null))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig get info failed rowid:" + this.sCc);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.sBZ = null;
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if (this.sBZ.field_status != 101L)
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig get field_status failed rowid:" + this.sCc + " status:" + this.sBZ.field_status);
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bf.NA();
      this.sCx = this.sBZ.field_offset;
    }
    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.sCc), this.sBZ.field_fileFullPath, Long.valueOf(this.sBZ.field_totalLen), Boolean.valueOf(this.sBZ.field_isUpload), Integer.valueOf(this.sBZ.field_isUseCdn), Long.valueOf(this.sBZ.field_type) });
    if (bf.mA(this.sBZ.field_appId))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.sBZ.field_type != 8L) && (this.sBZ.field_type != 6L))
      {
        this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
        GMTrace.o(805574803456L, 6002);
        return -1;
      }
    }
    if ((this.sBZ.field_type == 8L) || (this.sBZ.field_type == 9L))
    {
      v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.sBZ.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.sCc) });
      GMTrace.o(805574803456L, 6002);
      return 0;
      com.tencent.mm.modelcdntran.g.Em();
      if ((!com.tencent.mm.modelcdntran.c.fA(4)) && (this.sBZ.field_isUseCdn != 1))
      {
        com.tencent.mm.modelcdntran.g.Em();
        v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(4)), Integer.valueOf(this.sBZ.field_isUseCdn) });
        i = 0;
      }
      else
      {
        ap.yY();
        au localau = com.tencent.mm.u.c.wT().cA(this.sBZ.field_msgInfoId);
        if (localau.field_msgId != this.sBZ.field_msgInfoId)
        {
          v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.sBZ.field_msgInfoId), Long.valueOf(this.sBZ.uvp), Long.valueOf(this.sBZ.field_createTime), Long.valueOf(this.sBZ.field_totalLen), Long.valueOf(this.sBZ.field_status), Boolean.valueOf(this.sBZ.field_isUpload), Integer.valueOf(this.sBZ.field_isUseCdn), this.sBZ.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          this.toUser = localau.field_talker;
          parame1 = "";
          if (!bf.mA(localau.field_imgPath)) {
            parame1 = com.tencent.mm.ah.n.GT().jv(localau.field_imgPath);
          }
          int k = com.tencent.mm.a.e.aN(parame1);
          int m = com.tencent.mm.a.e.aN(this.sBZ.field_fileFullPath);
          if (k >= com.tencent.mm.modelcdntran.b.hxI)
          {
            v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { parame1, Integer.valueOf(k) });
            i = 0;
          }
          else
          {
            this.hGf = com.tencent.mm.modelcdntran.d.a("upattach", this.sBZ.field_createTime, localau.field_talker, this.sCc);
            v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.sBZ.field_createTime), this.hGf });
            if (bf.mA(this.hGf))
            {
              v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.sCc) });
              i = 0;
            }
            else
            {
              h localh = new h();
              String str = localau.field_content;
              localObject = str;
              if (o.dH(localau.field_talker))
              {
                i = ay.gh(localau.field_content);
                localObject = str;
                if (i != -1) {
                  localObject = (localau.field_content + " ").substring(i + 2).trim();
                }
              }
              this.fCR = f.a.ek(bf.PW((String)localObject));
              label1105:
              int j;
              label1150:
              label1173:
              boolean bool;
              if (this.fCR != null)
              {
                v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.fCR.hhn, bf.Qi(this.fCR.hhu), this.fCR.filemd5, Integer.valueOf(this.fCR.type) });
                localh.field_fileId = this.fCR.hhn;
                localh.field_aesKey = this.fCR.hhu;
                localh.field_filemd5 = this.fCR.filemd5;
                if ((this.fCR.hhk != 0) || (this.fCR.hhg > 26214400))
                {
                  i = 1;
                  localh.hyM = this.hGp;
                  localh.field_mediaId = this.hGf;
                  localh.field_fullpath = this.sBZ.field_fileFullPath;
                  localh.field_thumbpath = parame1;
                  if (i == 0) {
                    break label1530;
                  }
                  j = com.tencent.mm.modelcdntran.b.hxv;
                  localh.field_fileType = j;
                  if (i == 0) {
                    break label1538;
                  }
                  localObject = bf.mz(this.sBZ.field_signature);
                  localh.field_svr_signature = ((String)localObject);
                  if (i == 0) {
                    break label1545;
                  }
                  bool = bf.mA(this.sBZ.field_signature);
                  label1196:
                  localh.field_onlycheckexist = bool;
                  localh.field_fake_bigfile_signature_aeskey = this.sBZ.field_fakeAeskey;
                  localh.field_fake_bigfile_signature = this.sBZ.field_fakeSignature;
                  localh.field_talker = localau.field_talker;
                  localh.field_priority = com.tencent.mm.modelcdntran.b.hxt;
                  localh.field_totalLen = m;
                  localh.field_needStorage = false;
                  localh.field_isStreamMedia = false;
                  localh.field_enable_hitcheck = this.hGw;
                  if (!o.dH(localau.field_talker)) {
                    break label1551;
                  }
                }
              }
              label1530:
              label1538:
              label1545:
              label1551:
              for (i = 1;; i = 0)
              {
                localh.field_chattype = i;
                localh.field_force_aeskeycdn = false;
                localh.field_trysafecdn = true;
                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.sBZ.field_msgInfoId), localh.field_fullpath, Integer.valueOf(m), parame1, Integer.valueOf(k), this.hGf, Integer.valueOf(localh.field_fileType), Boolean.valueOf(localh.field_enable_hitcheck), Boolean.valueOf(localh.field_onlycheckexist), Boolean.valueOf(localh.field_force_aeskeycdn), Boolean.valueOf(localh.field_trysafecdn), bf.Qi(localh.field_aesKey), localh.field_filemd5, bf.Qi(localh.field_svr_signature), bf.Qi(localh.field_fake_bigfile_signature_aeskey), bf.Qi(localh.field_fake_bigfile_signature) });
                if (com.tencent.mm.modelcdntran.g.Em().b(localh)) {
                  break label1556;
                }
                v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                this.hGf = "";
                i = 0;
                break;
                i = 0;
                break label1105;
                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                i = 0;
                break label1105;
                j = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                break label1150;
                localObject = "";
                break label1173;
                bool = false;
                break label1196;
              }
              label1556:
              if (this.sBZ.field_isUseCdn != 1)
              {
                this.sBZ.field_isUseCdn = 1;
                bool = an.abF().c(this.sBZ, new String[0]);
                if (!bool)
                {
                  v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + bool);
                  this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
                  this.gUt.a(3, -1, "", this);
                  i = 0;
                  continue;
                }
              }
              v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.hGf });
              i = 1;
            }
          }
        }
      }
    }
    if (this.sBZ.field_netTimes > 3200L)
    {
      l.ee(this.sBZ.uvp);
      v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.sCc);
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    parame1 = this.sBZ;
    parame1.field_netTimes += 1L;
    if (bf.mA(this.sBZ.field_clientAppDataId))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if ((this.sBZ.field_totalLen <= 0L) || (this.sBZ.field_totalLen > 26214400L))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.sBZ.field_totalLen);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      if (this.sBZ.field_totalLen > 26214400L) {
        l.ee(this.sBZ.uvp);
      }
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if (bf.mA(this.sBZ.field_fileFullPath))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if (com.tencent.mm.a.e.aN(this.sBZ.field_fileFullPath) > 26214400)
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      l.ee(this.sBZ.uvp);
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    if (bf.mA(this.hhi)) {}
    for (parame1 = com.tencent.mm.a.e.d(this.sBZ.field_fileFullPath, (int)this.sBZ.field_offset, 8192); bf.bm(parame1); parame1 = com.tencent.mm.a.e.d(this.sBZ.field_fileFullPath, (int)this.sBZ.field_offset, 32768))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(805574803456L, 6002);
      return -1;
    }
    Object localObject = (bgx)this.gUq.hrS.hsa;
    ((bgx)localObject).mrA = this.sBZ.field_appId;
    ((bgx)localObject).ten = ((int)this.sBZ.field_sdkVer);
    ((bgx)localObject).ueY = this.sBZ.field_clientAppDataId;
    ((bgx)localObject).jMq = ((int)this.sBZ.field_type);
    ((bgx)localObject).jLx = m.xL();
    ((bgx)localObject).tfd = ((int)this.sBZ.field_totalLen);
    ((bgx)localObject).tfe = ((int)this.sBZ.field_offset);
    if ((this.hhi != null) && (this.sCw))
    {
      ((bgx)localObject).tsQ = this.hhi;
      ((bgx)localObject).tfd = ((int)this.sBZ.field_totalLen);
      ((bgx)localObject).tff = 0;
      ((bgx)localObject).tqC = new avt().bb(new byte[0]);
      this.sCw = false;
      i = a(parame, this.gUq, this);
      GMTrace.o(805574803456L, 6002);
      return i;
    }
    ((bgx)localObject).tff = parame1.length;
    ((bgx)localObject).tqC = new avt().bb(parame1);
    if (this.hhi != null) {
      ((bgx)localObject).tsQ = this.hhi;
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(805574803456L, 6002);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(806111674368L, 6006);
    int i = k.b.hsC;
    GMTrace.o(806111674368L, 6006);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(805709021184L, 6003);
    v.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(805709021184L, 6003);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sBZ.field_totalLen - this.sCx) });
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    paramString = (bgy)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramString.mrA != null) && (this.hhi == null) && ((!paramString.mrA.equals(this.sBZ.field_appId)) || (!paramString.ueY.equals(this.sBZ.field_clientAppDataId))))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    if ((paramString.tfd < 0) || (paramString.tfd != this.sBZ.field_totalLen) || (paramString.tfe < 0) || (paramString.tfe > this.sBZ.field_totalLen))
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    this.sBZ.field_offset = paramString.tfe;
    paramp = this.sBZ;
    if (l.Me(paramString.tso)) {}
    for (paramString = paramString.tso;; paramString = "")
    {
      paramp.field_mediaSvrId = paramString;
      if (this.sBZ.field_status != 105L) {
        break;
      }
      v.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.sBZ.field_mediaSvrId + "," + this.sBZ.field_offset + "] ");
      this.gUt.a(paramInt2, -1, "", this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    if (this.sBZ.field_offset == this.sBZ.field_totalLen)
    {
      if (bf.mA(this.sBZ.field_mediaSvrId))
      {
        v.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
        this.gUt.a(3, -1, "", this);
        l.ee(this.sBZ.uvp);
        GMTrace.o(805709021184L, 6003);
        return;
      }
      this.sBZ.field_status = 199L;
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sBZ.field_totalLen - this.sCx) });
    }
    boolean bool = an.abF().c(this.sBZ, new String[0]);
    if (!bool)
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + bool);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      c(null);
      this.gUt.a(3, -1, "", this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    if (this.sBZ.field_status == 199L)
    {
      this.gUt.a(0, 0, "", this);
      GMTrace.o(805709021184L, 6003);
      return;
    }
    if (a(this.hsm, this.gUt) < 0)
    {
      v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
      this.gUt.a(3, -1, "", this);
    }
    GMTrace.o(805709021184L, 6003);
  }
  
  public final void c(keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(806245892096L, 6007);
    if (this.sBZ.field_type != 2L)
    {
      GMTrace.o(806245892096L, 6007);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.u.c.c.Az().dX("100131");
    if (localc.isValid()) {
      this.gVe = u.getInt((String)localc.bKA().get("needUploadData"), 1);
    }
    if ((this.gVc) || (this.gVe == 0))
    {
      GMTrace.o(806245892096L, 6007);
      return;
    }
    this.gVf = paramkeep_SceneResult;
    this.gVc = true;
    paramkeep_SceneResult = new lw();
    a.uql.b(this.gVh);
    paramkeep_SceneResult.fSR.filePath = this.sBZ.field_fileFullPath;
    a.uql.m(paramkeep_SceneResult);
    GMTrace.o(806245892096L, 6007);
  }
  
  public final int getType()
  {
    GMTrace.i(805977456640L, 6005);
    GMTrace.o(805977456640L, 6005);
    return 220;
  }
  
  protected final int ub()
  {
    GMTrace.i(805843238912L, 6004);
    GMTrace.o(805843238912L, 6004);
    return 3200;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */