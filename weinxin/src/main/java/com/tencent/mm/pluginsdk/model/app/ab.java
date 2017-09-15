package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;
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
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class ab
  extends k
  implements j
{
  int fEO;
  public long fGD;
  public au fTa;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  public f hGb;
  public String hGf;
  private h.a hGp;
  private long jDV;
  public String mediaId;
  public b sBZ;
  long sCc;
  private int sCd;
  public String sCe;
  public boolean sCf;
  private boolean sCg;
  private boolean sCh;
  public long startTime;
  private int type;
  
  public ab(long paramLong1, long paramLong2, f paramf)
  {
    GMTrace.i(17442801713152L, 129959);
    this.sBZ = null;
    this.sCc = -1L;
    this.mediaId = "";
    this.fGD = 0L;
    this.fTa = null;
    this.hGf = "";
    this.startTime = 0L;
    this.sCd = -1;
    this.sCe = "";
    this.type = 0;
    this.fEO = 0;
    this.sCf = false;
    this.sCg = false;
    this.jDV = 0L;
    this.sCh = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(795642691584L, 5928);
        if (paramAnonymouskeep_ProgressInfo == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != 44530) {
            break;
          }
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { ab.this.hGf });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          l.ee(ab.this.sBZ.uvp);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "" });
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        ab.this.sBZ = an.abF().eb(ab.this.fGD);
        if (ab.this.sBZ == null)
        {
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (ab.this.sBZ.field_status == 102L)
        {
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_status) });
          com.tencent.mm.modelcdntran.g.Em().iP(ab.this.hGf);
          ab.this.gUt.a(3, paramAnonymousInt, "attach  has paused, status=" + ab.this.sBZ.field_status, ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (paramAnonymouskeep_ProgressInfo.field_finishedLength == ab.this.sBZ.field_totalLen)
          {
            v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          if (ab.this.sBZ.field_offset > paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_offset), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            l.ee(ab.this.sBZ.uvp);
            ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          ab.this.sBZ.field_offset = paramAnonymouskeep_ProgressInfo.field_finishedLength;
          an.abF().c(ab.this.sBZ, new String[0]);
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(792824119296L, 5907);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(792824119296L, 5907);
              }
            });
          }
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { ab.this.hGf, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength) });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1076;
          }
          l.ee(ab.this.sBZ.uvp);
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          ab.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", ab.this);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          if (paramAnonymouskeep_SceneResult.field_retCode != 0) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          }
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(810809294848L, 6041);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(810809294848L, 6041);
              }
            });
          }
        }
        GMTrace.o(795642691584L, 5928);
        return 0;
        label1076:
        new File(ab.this.sCe).renameTo(new File(ab.this.sBZ.field_fileFullPath));
        ab.this.sBZ.field_status = 199L;
        ab.this.sBZ.field_offset = ab.this.sBZ.field_totalLen;
        an.abF().c(ab.this.sBZ, new String[0]);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 45L, ab.this.sBZ.field_totalLen, false);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 46L, 1L, false);
        paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
        if (ab.this.fTa == null)
        {
          paramAnonymousString = "";
          label1216:
          if (!o.dH(paramAnonymousString)) {
            break label1329;
          }
        }
        label1329:
        for (long l = 48L;; l = 47L)
        {
          paramAnonymouskeep_ProgressInfo.a(198L, l, 1L, false);
          ap.yY();
          paramAnonymousString = com.tencent.mm.u.c.wT().cA(ab.this.sBZ.field_msgInfoId);
          if (paramAnonymousString.field_status == 5)
          {
            paramAnonymousString.dv(3);
            ap.yY();
            com.tencent.mm.u.c.wT().a(paramAnonymousString.field_msgId, paramAnonymousString);
          }
          ab.this.gUt.a(0, 0, "", ab.this);
          break;
          paramAnonymousString = ab.this.fTa.field_talker;
          break label1216;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(795776909312L, 5929);
        GMTrace.o(795776909312L, 5929);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(795911127040L, 5930);
        GMTrace.o(795911127040L, 5930);
        return null;
      }
    };
    this.jDV = paramLong2;
    this.fGD = paramLong1;
    this.sBZ = an.abF().eb(paramLong1);
    this.hGb = paramf;
    this.sCg = true;
    if (this.sBZ == null)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + paramLong1, new Object[] { Long.valueOf(paramLong2) });
      GMTrace.o(17442801713152L, 129959);
      return;
    }
    paramf = new b.a();
    paramf.hrV = new oi();
    paramf.hrW = new oj();
    paramf.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramf.hrU = 221;
    paramf.hrX = 106;
    paramf.hrY = 1000000106;
    this.gUq = paramf.BE();
    GMTrace.o(17442801713152L, 129959);
  }
  
  public ab(long paramLong, String paramString, f paramf)
  {
    this(paramString, paramf, 0);
    GMTrace.i(819399229440L, 6105);
    this.fGD = paramLong;
    GMTrace.o(819399229440L, 6105);
  }
  
  public ab(b paramb)
  {
    GMTrace.i(819533447168L, 6106);
    this.sBZ = null;
    this.sCc = -1L;
    this.mediaId = "";
    this.fGD = 0L;
    this.fTa = null;
    this.hGf = "";
    this.startTime = 0L;
    this.sCd = -1;
    this.sCe = "";
    this.type = 0;
    this.fEO = 0;
    this.sCf = false;
    this.sCg = false;
    this.jDV = 0L;
    this.sCh = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(795642691584L, 5928);
        if (paramAnonymouskeep_ProgressInfo == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != 44530) {
            break;
          }
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { ab.this.hGf });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          l.ee(ab.this.sBZ.uvp);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "" });
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        ab.this.sBZ = an.abF().eb(ab.this.fGD);
        if (ab.this.sBZ == null)
        {
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (ab.this.sBZ.field_status == 102L)
        {
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_status) });
          com.tencent.mm.modelcdntran.g.Em().iP(ab.this.hGf);
          ab.this.gUt.a(3, paramAnonymousInt, "attach  has paused, status=" + ab.this.sBZ.field_status, ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (paramAnonymouskeep_ProgressInfo.field_finishedLength == ab.this.sBZ.field_totalLen)
          {
            v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          if (ab.this.sBZ.field_offset > paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_offset), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            l.ee(ab.this.sBZ.uvp);
            ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          ab.this.sBZ.field_offset = paramAnonymouskeep_ProgressInfo.field_finishedLength;
          an.abF().c(ab.this.sBZ, new String[0]);
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(792824119296L, 5907);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(792824119296L, 5907);
              }
            });
          }
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { ab.this.hGf, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength) });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1076;
          }
          l.ee(ab.this.sBZ.uvp);
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          ab.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", ab.this);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          if (paramAnonymouskeep_SceneResult.field_retCode != 0) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          }
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(810809294848L, 6041);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(810809294848L, 6041);
              }
            });
          }
        }
        GMTrace.o(795642691584L, 5928);
        return 0;
        label1076:
        new File(ab.this.sCe).renameTo(new File(ab.this.sBZ.field_fileFullPath));
        ab.this.sBZ.field_status = 199L;
        ab.this.sBZ.field_offset = ab.this.sBZ.field_totalLen;
        an.abF().c(ab.this.sBZ, new String[0]);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 45L, ab.this.sBZ.field_totalLen, false);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 46L, 1L, false);
        paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
        if (ab.this.fTa == null)
        {
          paramAnonymousString = "";
          label1216:
          if (!o.dH(paramAnonymousString)) {
            break label1329;
          }
        }
        label1329:
        for (long l = 48L;; l = 47L)
        {
          paramAnonymouskeep_ProgressInfo.a(198L, l, 1L, false);
          ap.yY();
          paramAnonymousString = com.tencent.mm.u.c.wT().cA(ab.this.sBZ.field_msgInfoId);
          if (paramAnonymousString.field_status == 5)
          {
            paramAnonymousString.dv(3);
            ap.yY();
            com.tencent.mm.u.c.wT().a(paramAnonymousString.field_msgId, paramAnonymousString);
          }
          ab.this.gUt.a(0, 0, "", ab.this);
          break;
          paramAnonymousString = ab.this.fTa.field_talker;
          break label1216;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(795776909312L, 5929);
        GMTrace.o(795776909312L, 5929);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(795911127040L, 5930);
        GMTrace.o(795911127040L, 5930);
        return null;
      }
    };
    this.sBZ = paramb;
    this.sCf = true;
    this.mediaId = this.sBZ.field_mediaId;
    this.hGb = null;
    this.type = 0;
    if (paramb == null)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      GMTrace.o(819533447168L, 6106);
      return;
    }
    b.a locala = new b.a();
    locala.hrV = new oi();
    locala.hrW = new oj();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.hrU = 221;
    locala.hrX = 106;
    locala.hrY = 1000000106;
    this.gUq = locala.BE();
    v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramb.field_fileFullPath, Boolean.valueOf(true), bf.bJP() });
    GMTrace.o(819533447168L, 6106);
  }
  
  public ab(String paramString)
  {
    this(paramString, null, 0);
    GMTrace.i(819265011712L, 6104);
    GMTrace.o(819265011712L, 6104);
  }
  
  public ab(String paramString, f paramf, int paramInt)
  {
    GMTrace.i(819667664896L, 6107);
    this.sBZ = null;
    this.sCc = -1L;
    this.mediaId = "";
    this.fGD = 0L;
    this.fTa = null;
    this.hGf = "";
    this.startTime = 0L;
    this.sCd = -1;
    this.sCe = "";
    this.type = 0;
    this.fEO = 0;
    this.sCf = false;
    this.sCg = false;
    this.jDV = 0L;
    this.sCh = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(795642691584L, 5928);
        if (paramAnonymouskeep_ProgressInfo == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != 44530) {
            break;
          }
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { ab.this.hGf });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          l.ee(ab.this.sBZ.uvp);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "" });
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        ab.this.sBZ = an.abF().eb(ab.this.fGD);
        if (ab.this.sBZ == null)
        {
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (ab.this.sBZ.field_status == 102L)
        {
          v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_status) });
          com.tencent.mm.modelcdntran.g.Em().iP(ab.this.hGf);
          ab.this.gUt.a(3, paramAnonymousInt, "attach  has paused, status=" + ab.this.sBZ.field_status, ab.this);
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (paramAnonymouskeep_ProgressInfo.field_finishedLength == ab.this.sBZ.field_totalLen)
          {
            v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          if (ab.this.sBZ.field_offset > paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(ab.this.sBZ.field_offset), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            l.ee(ab.this.sBZ.uvp);
            ab.this.gUt.a(3, paramAnonymousInt, "", ab.this);
            GMTrace.o(795642691584L, 5928);
            return 0;
          }
          ab.this.sBZ.field_offset = paramAnonymouskeep_ProgressInfo.field_finishedLength;
          an.abF().c(ab.this.sBZ, new String[0]);
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(792824119296L, 5907);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(792824119296L, 5907);
              }
            });
          }
          v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { ab.this.hGf, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength) });
          GMTrace.o(795642691584L, 5928);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1076;
          }
          l.ee(ab.this.sBZ.uvp);
          v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          ab.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", ab.this);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          if (paramAnonymouskeep_SceneResult.field_retCode != 0) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.sBZ.field_totalLen), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          }
          if (ab.this.hGb != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(810809294848L, 6041);
                ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
                GMTrace.o(810809294848L, 6041);
              }
            });
          }
        }
        GMTrace.o(795642691584L, 5928);
        return 0;
        label1076:
        new File(ab.this.sCe).renameTo(new File(ab.this.sBZ.field_fileFullPath));
        ab.this.sBZ.field_status = 199L;
        ab.this.sBZ.field_offset = ab.this.sBZ.field_totalLen;
        an.abF().c(ab.this.sBZ, new String[0]);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 45L, ab.this.sBZ.field_totalLen, false);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 46L, 1L, false);
        paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
        if (ab.this.fTa == null)
        {
          paramAnonymousString = "";
          label1216:
          if (!o.dH(paramAnonymousString)) {
            break label1329;
          }
        }
        label1329:
        for (long l = 48L;; l = 47L)
        {
          paramAnonymouskeep_ProgressInfo.a(198L, l, 1L, false);
          ap.yY();
          paramAnonymousString = com.tencent.mm.u.c.wT().cA(ab.this.sBZ.field_msgInfoId);
          if (paramAnonymousString.field_status == 5)
          {
            paramAnonymousString.dv(3);
            ap.yY();
            com.tencent.mm.u.c.wT().a(paramAnonymousString.field_msgId, paramAnonymousString);
          }
          ab.this.gUt.a(0, 0, "", ab.this);
          break;
          paramAnonymousString = ab.this.fTa.field_talker;
          break label1216;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(795776909312L, 5929);
        GMTrace.o(795776909312L, 5929);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(795911127040L, 5930);
        GMTrace.o(795911127040L, 5930);
        return null;
      }
    };
    this.mediaId = paramString;
    this.hGb = paramf;
    this.type = paramInt;
    this.sBZ = an.abF().LV(paramString);
    if (this.sBZ == null)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + paramString);
      GMTrace.o(819667664896L, 6107);
      return;
    }
    paramString = new b.a();
    paramString.hrV = new oi();
    paramString.hrW = new oj();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.hrU = 221;
    paramString.hrX = 106;
    paramString.hrY = 1000000106;
    this.gUq = paramString.BE();
    v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(paramInt), this.sBZ.field_fileFullPath, Long.valueOf(this.sBZ.field_type), this.sBZ.field_signature, bf.bJP() });
    GMTrace.o(819667664896L, 6107);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(819936100352L, 6109);
    this.gUt = parame1;
    if (this.sBZ == null)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sd() + " get info failed mediaId:" + this.mediaId);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
    }
    ap.yY();
    this.fTa = com.tencent.mm.u.c.wT().cA(this.fGD);
    if ((this.fTa == null) || (this.fTa.field_msgId != this.fGD))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sd() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.fGD) });
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bf.NA();
      this.sCd = ((int)this.sBZ.field_offset);
    }
    if (this.jDV != 0L)
    {
      parame1 = (oi)this.gUq.hrS.hsa;
      parame1.jLx = m.xL();
      parame1.tfd = ((int)this.sBZ.field_totalLen);
      parame1.tfe = ((int)this.sBZ.field_offset);
      parame1.tff = 0;
      parame1.jMq = 40;
      parame1.tdE = this.jDV;
      i = a(parame, this.gUq, this);
      GMTrace.o(819936100352L, 6109);
      return i;
    }
    Object localObject = this.fTa.field_content;
    parame1 = (com.tencent.mm.y.e)localObject;
    if (o.dH(this.fTa.field_talker))
    {
      i = ay.gh(this.fTa.field_content);
      parame1 = (com.tencent.mm.y.e)localObject;
      if (i != -1) {
        parame1 = (this.fTa.field_content + " ").substring(i + 2).trim();
      }
    }
    parame1 = f.a.ek(bf.PW(parame1));
    if (parame1 == null)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      v.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      GMTrace.o(819936100352L, 6109);
      return 0;
      v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.fGD), Long.valueOf(this.sBZ.field_totalLen), this.sBZ.field_fileFullPath, parame1.hhn, bf.Qi(parame1.hhu) });
      if ((bf.mA(parame1.hhn)) || (bf.mA(parame1.hhu)))
      {
        v.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.fGD), parame1.hhn, bf.Qi(parame1.hhu) });
        i = 0;
      }
      else
      {
        this.hGf = d.a("downattach", this.sBZ.field_createTime, this.fTa.field_talker, this.sCc);
        if (bf.mA(this.hGf))
        {
          v.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.sCc) });
          i = 0;
        }
        else
        {
          com.tencent.mm.a.e.aU(this.sBZ.field_fileFullPath);
          this.sCe = (this.sBZ.field_fileFullPath + "_tmp");
          localObject = new h();
          ((h)localObject).field_mediaId = this.hGf;
          ((h)localObject).field_fullpath = this.sCe;
          if ((parame1.hhk != 0) || (parame1.hhg > 26214400))
          {
            i = com.tencent.mm.modelcdntran.b.hxv;
            label751:
            ((h)localObject).field_fileType = i;
            ((h)localObject).field_totalLen = ((int)this.sBZ.field_totalLen);
            ((h)localObject).field_aesKey = parame1.hhu;
            ((h)localObject).field_fileId = parame1.hhn;
            ((h)localObject).field_svr_signature = this.sBZ.field_signature;
            ((h)localObject).field_fake_bigfile_signature_aeskey = this.sBZ.field_fakeAeskey;
            ((h)localObject).field_fake_bigfile_signature = this.sBZ.field_fakeSignature;
            ((h)localObject).field_onlycheckexist = false;
            ((h)localObject).field_priority = com.tencent.mm.modelcdntran.b.hxt;
            ((h)localObject).hyM = this.hGp;
            if (!o.dH(this.fTa.field_talker)) {
              break label994;
            }
          }
          label994:
          for (i = 1;; i = 0)
          {
            ((h)localObject).field_chattype = i;
            v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Integer.valueOf(((h)localObject).field_fileType), ((h)localObject).field_fullpath, bf.Qi(((h)localObject).field_aesKey), bf.Qi(((h)localObject).field_svr_signature), bf.Qi(((h)localObject).field_fake_bigfile_signature_aeskey), bf.Qi(((h)localObject).field_fake_bigfile_signature), Boolean.valueOf(((h)localObject).field_onlycheckexist) });
            if (com.tencent.mm.modelcdntran.g.Em().b((h)localObject, -1)) {
              break label999;
            }
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.hGf = "";
            i = 0;
            break;
            i = com.tencent.mm.modelcdntran.b.MediaType_FILE;
            break label751;
          }
          label999:
          if (this.sBZ.field_isUseCdn != 1)
          {
            this.sBZ.field_isUseCdn = 1;
            boolean bool = an.abF().c(this.sBZ, new String[0]);
            if (!bool)
            {
              v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + bool);
              this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
              this.gUt.a(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.sBZ.field_status == 102L)
    {
      this.sBZ.field_status = 101L;
      if (!this.sCf) {
        an.abF().c(this.sBZ, new String[0]);
      }
    }
    this.sCc = this.sBZ.uvp;
    if ((bf.mA(this.sBZ.field_mediaSvrId)) && (this.jDV == 0L))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
    }
    if ((this.sBZ.field_totalLen <= 0L) || (this.sBZ.field_totalLen > 26214400L))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.sBZ.field_totalLen);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
    }
    if ((bf.mA(this.sBZ.field_fileFullPath)) && (this.jDV == 0L))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
    }
    int j = com.tencent.mm.a.e.aN(this.sBZ.field_fileFullPath);
    int i = j;
    if (this.sCh)
    {
      i = j - 6;
      if (i <= 0) {
        break label1439;
      }
    }
    while (i != this.sBZ.field_offset)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.sBZ.field_offset);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      GMTrace.o(819936100352L, 6109);
      return -1;
      label1439:
      i = 0;
    }
    v.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.sBZ.field_appId, this.sBZ.field_mediaSvrId, Long.valueOf(this.sBZ.field_sdkVer) });
    parame1 = (oi)this.gUq.hrS.hsa;
    parame1.mrA = this.sBZ.field_appId;
    parame1.tso = this.sBZ.field_mediaSvrId;
    parame1.ten = ((int)this.sBZ.field_sdkVer);
    parame1.jLx = m.xL();
    parame1.tfd = ((int)this.sBZ.field_totalLen);
    parame1.tfe = ((int)this.sBZ.field_offset);
    parame1.tff = 0;
    if (this.jDV != 0L) {
      parame1.tdE = this.jDV;
    }
    if (this.type != 0) {}
    for (parame1.jMq = this.type;; parame1.jMq = ((int)this.sBZ.field_type))
    {
      i = a(parame, this.gUq, this);
      GMTrace.o(819936100352L, 6109);
      return i;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(820338753536L, 6112);
    int i = k.b.hsC;
    GMTrace.o(820338753536L, 6112);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(820070318080L, 6110);
    v.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0) });
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    paramp = (oj)((com.tencent.mm.y.b)paramp).hrT.hsa;
    this.sBZ.field_totalLen = paramp.tfd;
    if ((paramp.tso != null) && (!paramp.tso.equals(this.sBZ.field_mediaSvrId)))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if (paramp.tfe != this.sBZ.field_offset)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramp.tfe);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if (paramp.tff + this.sBZ.field_offset > this.sBZ.field_totalLen)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramp.tff + " off:" + this.sBZ.field_offset + " total?:" + this.sBZ.field_totalLen);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    paramString = n.a(paramp.tqC);
    if ((paramString == null) || (paramString.length == 0) || (paramString.length != paramp.tff))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    paramp = new String(paramString);
    v.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.sCg) });
    Object localObject;
    StringBuffer localStringBuffer1;
    if ((this.sBZ.field_offset < this.sBZ.field_totalLen) && (this.sCg))
    {
      ap.yY();
      paramArrayOfByte = com.tencent.mm.u.c.wT().cA(this.sBZ.field_msgInfoId);
      if (!paramp.startsWith("<appmsg")) {
        break label963;
      }
      if (!o.dH(paramArrayOfByte.field_talker)) {
        break label951;
      }
      if (!bf.mA(paramArrayOfByte.field_content))
      {
        localObject = paramArrayOfByte.field_content.split("\n", 2)[0];
        localStringBuffer1 = new StringBuffer();
        this.sBZ.field_fullXml = ((String)localObject + "\n");
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append(this.sBZ.field_fullXml).append(paramp);
        this.sBZ.field_fullXml = ((StringBuffer)localObject).toString();
      }
    }
    for (;;)
    {
      paramArrayOfByte.setContent(this.sBZ.field_fullXml);
      ap.yY();
      com.tencent.mm.u.c.wT().a(this.sBZ.field_msgInfoId, paramArrayOfByte);
      v.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramp });
      paramInt1 = com.tencent.mm.a.e.e(this.sBZ.field_fileFullPath, paramString);
      if ((bf.mA(this.sBZ.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      v.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + paramInt1);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
      label951:
      this.sBZ.field_fullXml = paramp;
      continue;
      label963:
      if (!paramArrayOfByte.field_content.startsWith("<msg>"))
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append(paramArrayOfByte.field_content).append(paramp);
        this.sBZ.field_fullXml = ((StringBuffer)localObject).toString();
      }
      if ((paramp.endsWith("</appmsg>")) || (this.sBZ.field_offset + paramString.length == this.sBZ.field_totalLen)) {
        if (o.dH(paramArrayOfByte.field_talker))
        {
          localObject = paramArrayOfByte.field_content.split("\n", 2);
          localStringBuffer1 = localObject[0];
          StringBuffer localStringBuffer2 = new StringBuffer();
          localStringBuffer2.append(localStringBuffer1).append("\n<msg>").append(localObject[1]).append(paramp).append("</msg>");
          this.sBZ.field_fullXml = localStringBuffer2.toString();
        }
        else
        {
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("<msg>").append(this.sBZ.field_fullXml).append("</msg>");
          this.sBZ.field_fullXml = ((StringBuffer)localObject).toString();
        }
      }
    }
    paramp = this.sBZ;
    paramp.field_offset += paramString.length;
    if (this.sBZ.field_offset == this.sBZ.field_totalLen) {
      this.sBZ.field_status = 199L;
    }
    if (this.hGb != null) {
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(822754672640L, 6130);
          ab.this.hGb.a((int)ab.this.sBZ.field_offset, (int)ab.this.sBZ.field_totalLen, ab.this);
          GMTrace.o(822754672640L, 6130);
        }
      });
    }
    if (this.sCf) {}
    for (boolean bool = true; !bool; bool = an.abF().c(this.sBZ, new String[0]))
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + paramInt1);
      this.fEO = (55536 - com.tencent.mm.compatible.util.g.sb());
      this.gUt.a(3, -1, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if (this.sBZ.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sBZ.field_totalLen - this.sCd) });
      this.gUt.a(0, 0, "", this);
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if (this.sBZ.field_status == 102L)
    {
      this.gUt.a(3, -1, "", this);
      this.fEO = 45434;
      GMTrace.o(820070318080L, 6110);
      return;
    }
    if (a(this.hsm, this.gUt) < 0)
    {
      v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      this.gUt.a(3, -1, "", this);
    }
    GMTrace.o(820070318080L, 6110);
  }
  
  public final void bCX()
  {
    GMTrace.i(819801882624L, 6108);
    this.sCh = true;
    if (this.sCh) {
      com.tencent.mm.a.e.e(this.sBZ.field_fileFullPath, "#!AMR\n".getBytes());
    }
    GMTrace.o(819801882624L, 6108);
  }
  
  public final String getMediaId()
  {
    GMTrace.i(820607188992L, 6114);
    if (this.sBZ == null)
    {
      GMTrace.o(820607188992L, 6114);
      return "";
    }
    String str = this.sBZ.field_mediaSvrId;
    GMTrace.o(820607188992L, 6114);
    return str;
  }
  
  public final int getType()
  {
    GMTrace.i(820204535808L, 6111);
    GMTrace.o(820204535808L, 6111);
    return 221;
  }
  
  protected final int ub()
  {
    GMTrace.i(820472971264L, 6113);
    GMTrace.o(820472971264L, 6113);
    return 400;
  }
  
  public static abstract interface a
  {
    public abstract void bCY();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */