package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends k
  implements com.tencent.mm.network.j
{
  int fEO;
  public String fyw;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  public String hGf;
  public String hGm;
  public int hGn;
  private h.a hGp;
  public boolean hYd;
  public boolean hYe;
  public r hYf;
  public i hYg;
  public int hYh;
  private boolean hYi;
  public long hYj;
  private ai hqz;
  public int hrb;
  private String mediaId;
  private int startOffset;
  public long startTime;
  
  public d(String paramString)
  {
    this(paramString, false);
    GMTrace.i(363058954240L, 2705);
    GMTrace.o(363058954240L, 2705);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    GMTrace.i(363193171968L, 2706);
    this.hYf = null;
    this.hGf = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.hrb = 0;
    this.fEO = 0;
    this.hYh = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    this.hYi = false;
    this.hGm = null;
    this.hGn = 0;
    this.hYj = 0L;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(355408543744L, 2648);
        if (paramAnonymousInt == 44530)
        {
          v.d("MicroMsg.NetSceneDownloadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.hGf });
          GMTrace.o(355408543744L, 2648);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          t.lB(d.this.fyw);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(d.this.hYh), Integer.valueOf(d.this.hrb), "" });
          com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(d.this.hYh), Integer.valueOf(d.this.hrb), "" });
          d.this.gUt.a(3, paramAnonymousInt, "", d.this);
          GMTrace.o(355408543744L, 2648);
          return 0;
        }
        d.this.hYf = t.lI(d.this.fyw);
        if ((d.this.hYf == null) || (d.this.hYf.status == 113))
        {
          if (d.this.hYf == null) {}
          for (int i = -1;; i = d.this.hYf.status)
          {
            v.i("MicroMsg.NetSceneDownloadVideo", "upload video info is null or has paused, status:%d", new Object[] { Integer.valueOf(i) });
            d.this.pd();
            d.this.gUt.a(3, paramAnonymousInt, "upload video info is null or has paused, status" + i, d.this);
            GMTrace.o(355408543744L, 2648);
            return 0;
          }
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (paramAnonymouskeep_ProgressInfo.field_finishedLength == d.this.hrb)
          {
            v.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            GMTrace.o(355408543744L, 2648);
            return 0;
          }
          if ((d.this.hYf.hZP > paramAnonymouskeep_ProgressInfo.field_finishedLength) && (!d.this.hYd))
          {
            v.e("MicroMsg.NetSceneDownloadVideo", "cdnEndProc error oldpos:%d newpos:%d", new Object[] { Integer.valueOf(d.this.hYf.hZP), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            t.lB(d.this.fyw);
            d.this.gUt.a(3, paramAnonymousInt, "", d.this);
            GMTrace.o(355408543744L, 2648);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.hYf.hZT = bf.Nz();
          if (d.this.hYf.hZP < paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            d.this.hYf.hZP = paramAnonymouskeep_ProgressInfo.field_finishedLength;
            paramAnonymousInt = 1040;
          }
          d.this.hYf.fRM = paramAnonymousInt;
          t.e(d.this.hYf);
          v.d("MicroMsg.NetSceneDownloadVideo", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.hGf, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength) });
          GMTrace.o(355408543744L, 2648);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i("MicroMsg.NetSceneDownloadVideo", "cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Long.valueOf(bf.NA() - d.this.hYj) });
          d.a(d.this.hYg, paramAnonymouskeep_SceneResult);
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1186;
          }
          t.lB(d.this.fyw);
          if (d.this.hYd) {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 13L, 1L, false);
          }
          if (d.this.hYe) {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 136L, 1L, false);
          }
          d.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", d.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(d.this.hYh), Integer.valueOf(d.this.hrb), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          if (paramAnonymouskeep_SceneResult.field_retCode != 0) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(d.this.hYh), Integer.valueOf(d.this.hrb), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
          }
          a.a(d.this.hYf, 1);
          d.this.hYg = null;
          GMTrace.o(355408543744L, 2648);
          return 0;
          label1186:
          if (d.this.hYd) {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 12L, 1L, false);
          }
          if (d.this.hYe)
          {
            paramAnonymousString = t.lI(d.this.fyw);
            if (paramAnonymousString != null)
            {
              paramAnonymousString.videoFormat = 1;
              paramAnonymousString.fRM = 2;
              o.KW().b(paramAnonymousString);
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 137L, 1L, false);
          }
          d.this.gM(paramAnonymouskeep_SceneResult.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(355542761472L, 2649);
        GMTrace.o(355542761472L, 2649);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(355676979200L, 2650);
        GMTrace.o(355676979200L, 2650);
        return null;
      }
    };
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(350039834624L, 2608);
        if (d.this.a(d.this.hsm, d.this.gUt) == -1) {
          d.this.gUt.a(3, -1, "doScene failed", d.this);
        }
        GMTrace.o(350039834624L, 2608);
        return false;
      }
    }, false);
    if (paramString != null) {
      bool = true;
    }
    Assert.assertTrue(bool);
    v.i("MicroMsg.NetSceneDownloadVideo", "NetSceneDownloadVideo:  file:" + paramString + " isCompleteOnlineVideo : " + paramBoolean);
    this.fyw = paramString;
    this.hYd = paramBoolean;
    GMTrace.o(363193171968L, 2706);
  }
  
  private boolean KM()
  {
    GMTrace.i(363327389696L, 2707);
    v.d("MicroMsg.NetSceneDownloadVideo", "parseVideoMsgXML content:" + this.hYf.Li());
    Object localObject2 = bg.q(this.hYf.Li(), "msg");
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 214L, 1L, false);
      v.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
      GMTrace.o(363327389696L, 2707);
      return false;
    }
    String str = (String)((Map)localObject2).get(".msg.videomsg.$cdnvideourl");
    if (bf.mA(str))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 213L, 1L, false);
      v.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
      GMTrace.o(363327389696L, 2707);
      return false;
    }
    Object localObject1 = (String)((Map)localObject2).get(".msg.videomsg.$aeskey");
    this.hrb = Integer.valueOf((String)((Map)localObject2).get(".msg.videomsg.$length")).intValue();
    Object localObject4 = (String)((Map)localObject2).get(".msg.videomsg.$fileparam");
    this.hGf = com.tencent.mm.modelcdntran.d.a("downvideo", this.hYf.hZS, this.hYf.Lf(), this.hYf.getFileName());
    if (bf.mA(this.hGf))
    {
      v.w("MicroMsg.NetSceneDownloadVideo", "cdntra genClientId failed not use cdn file:%s", new Object[] { this.hYf.getFileName() });
      GMTrace.o(363327389696L, 2707);
      return false;
    }
    localObject2 = (String)((Map)localObject2).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.KW();
    localObject3 = s.lw(this.fyw) + ".tmp";
    this.hYg = new i();
    this.hYg.filename = this.hYf.getFileName();
    this.hYg.hyZ = ((String)localObject2);
    this.hYg.hza = this.hrb;
    this.hYg.hzb = 0;
    this.hYg.fOl = this.hYf.Lg();
    this.hYg.hzc = this.hYf.Lf();
    i locali = this.hYg;
    int i;
    label540:
    label646:
    label683:
    label800:
    int k;
    if (com.tencent.mm.u.o.dH(this.hYf.Lf()))
    {
      i = com.tencent.mm.u.j.eC(this.hYf.Lf());
      locali.fOn = i;
      this.hYg.field_mediaId = this.hGf;
      this.hYg.field_fullpath = ((String)localObject3);
      this.hYg.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
      this.hYg.field_totalLen = this.hrb;
      this.hYg.field_aesKey = ((String)localObject1);
      this.hYg.field_fileId = str;
      this.hYg.field_priority = com.tencent.mm.modelcdntran.b.hxt;
      this.hYg.hyM = this.hGp;
      this.hYg.field_wxmsgparam = ((String)localObject4);
      localObject1 = this.hYg;
      if (!com.tencent.mm.u.o.dH(this.hYf.Lf())) {
        break label1431;
      }
      i = 1;
      ((i)localObject1).field_chattype = i;
      this.hYg.hzd = this.hYf.hzd;
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(this.hYf.Lf(), this.hYf.fTG);
      this.hYg.hzf = ((ce)localObject4).field_createTime;
      this.hYg.fTG = ((ce)localObject4).field_msgSvrId;
      localObject1 = ay.gm(((ce)localObject4).gxv);
      locali = this.hYg;
      if (localObject1 == null) {
        break label1436;
      }
      i = ((ay.b)localObject1).hmI;
      locali.hzg = i;
      if (this.hYf.Lf().equals(((ce)localObject4).field_talker))
      {
        localObject4 = this.hYg;
        if (localObject1 != null) {
          break label1441;
        }
        i = 0;
        ((i)localObject4).field_limitrate = i;
      }
      v.d("MicroMsg.NetSceneDownloadVideo", "limitrate:%d file:%s", new Object[] { Integer.valueOf(this.hYg.field_limitrate), this.hYf.getFileName() });
      if (!com.tencent.mm.modelcdntran.g.Em().hxZ.contains("video_" + this.hYf.hZW)) {
        break label1453;
      }
      com.tencent.mm.modelcdntran.g.Em().hxZ.remove("video_" + this.hYf.hZW);
      this.hYg.field_autostart = true;
      if (3 == this.hYf.iac) {
        this.hYg.field_smallVideoFlag = 1;
      }
      if ((bf.mA((String)localObject2)) || (this.hYd)) {
        break label1484;
      }
      localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().cH((String)localObject2, this.hrb);
      j = com.tencent.mm.a.e.aN((String)localObject1);
      k = this.hrb - j;
      o.KW();
      localObject4 = s.lw(this.fyw);
      int m = com.tencent.mm.a.e.aN((String)localObject4);
      if (m > 0)
      {
        v.w("MicroMsg.NetSceneDownloadVideo", "already copy dup file, but download again, something error here.");
        bool = com.tencent.mm.loader.stub.b.deleteFile((String)localObject4);
        localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
        int n = this.hrb;
        i = 0;
        if (!bf.mA((String)localObject2)) {
          i = ((at)localObject1).gUp.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = t.lI(this.fyw);
        ((r)localObject1).hZP = 0;
        ((r)localObject1).fRM = 16;
        t.e((r)localObject1);
        v.w("MicroMsg.NetSceneDownloadVideo", "don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      v.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { Integer.valueOf(this.hrb), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (bf.mA((String)localObject1)) {
        break label1470;
      }
      if ((k < 0) || (k > 16)) {
        break label1484;
      }
      v.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { localObject1, localObject3 });
      com.tencent.mm.sdk.platformtools.j.ex((String)localObject1, (String)localObject3);
      gM(this.hrb);
      localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
      long l1 = this.hYf.fTG;
      long l2 = this.hYf.hZS;
      localObject3 = this.hYf.Lf();
      if (3 == this.hYf.iac) {
        break label1464;
      }
      i = 43;
      label1214:
      ((com.tencent.mm.plugin.report.service.g)localObject1).i(13267, new Object[] { str, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1275:
      if (i != 0) {
        break label1516;
      }
      this.mediaId = this.hYg.field_mediaId;
      this.hYj = bf.NA();
      if (this.hYf.videoFormat != 2) {
        break label1489;
      }
    }
    label1431:
    label1436:
    label1441:
    label1453:
    label1464:
    label1470:
    label1484:
    label1489:
    for (boolean bool = true;; bool = false)
    {
      this.hYe = bool;
      v.i("MicroMsg.NetSceneDownloadVideo", "%d check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hYe), Boolean.valueOf(this.hYd) });
      if ((!this.hYe) && (this.hYd)) {
        break label1731;
      }
      if (com.tencent.mm.modelcdntran.g.Em().b(this.hYg, -1)) {
        break label1495;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 212L, 1L, false);
      v.e("MicroMsg.NetSceneDownloadVideo", "cdntra addSendTask failed.");
      this.hGf = "";
      GMTrace.o(363327389696L, 2707);
      return false;
      i = 0;
      break;
      i = 0;
      break label540;
      i = 0;
      break label646;
      i = ((ay.b)localObject1).hmG / 8;
      break label683;
      this.hYg.field_autostart = false;
      break label800;
      i = 62;
      break label1214;
      this.hGm = ((String)localObject2);
      this.hGn = this.hrb;
      i = 0;
      break label1275;
    }
    label1495:
    if (this.hYe) {
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 135L, 1L, false);
    }
    label1516:
    if (this.hYf.iaa != 1)
    {
      this.hYf.iaa = 1;
      this.hYf.fRM = 524288;
      t.e(this.hYf);
    }
    if (3 != this.hYf.iac)
    {
      localObject1 = this.hYf.Lf();
      if (!bf.mA((String)localObject1)) {
        if (!com.tencent.mm.u.o.dH((String)localObject1)) {
          break label1870;
        }
      }
    }
    label1731:
    label1870:
    for (int j = com.tencent.mm.u.j.eC((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { bf.g(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str + "," + this.hrb + "," + i;
        v.i("MicroMsg.NetSceneDownloadVideo", "dk12024 report:%s", new Object[] { localObject1 });
        com.tencent.mm.plugin.report.service.g.oSF.A(12024, (String)localObject1);
        GMTrace.o(363327389696L, 2707);
        return true;
        localObject1 = this.hYg;
        o.KW();
        ((i)localObject1).field_fullpath = s.lw(this.fyw);
        o.KX().a(this.hYg, false);
        break;
        if ((i == 13) || (i == 15) || (i == 14)) {
          i = 4;
        } else if ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 12)) {
          i = 3;
        } else if ((i == 1) || (i == 2)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public static void a(i parami, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(16008819507200L, 119275);
    if ((parami == null) || (paramkeep_SceneResult == null))
    {
      v.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
      GMTrace.o(16008819507200L, 119275);
      return;
    }
    if (parami.field_smallVideoFlag == 1)
    {
      v.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
      GMTrace.o(16008819507200L, 119275);
      return;
    }
    if ((parami != null) && (paramkeep_SceneResult != null))
    {
      v.i("MicroMsg.NetSceneDownloadVideo", "sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { Integer.valueOf(paramkeep_SceneResult.field_recvedBytes), Long.valueOf(paramkeep_SceneResult.field_startTime), Long.valueOf(paramkeep_SceneResult.field_endTime) });
      o.KX();
      f.a(null, paramkeep_SceneResult, parami, true);
    }
    GMTrace.o(16008819507200L, 119275);
  }
  
  public final boolean BJ()
  {
    GMTrace.i(363998478336L, 2712);
    boolean bool = super.BJ();
    if (bool) {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 210L, 1L, false);
    }
    GMTrace.o(363998478336L, 2712);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    int i = 1;
    GMTrace.i(363595825152L, 2709);
    this.gUt = parame1;
    this.hYf = t.lI(this.fyw);
    if (this.hYf == null)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      GMTrace.o(363595825152L, 2709);
      return -1;
    }
    if ((this.hYf != null) && (3 == this.hYf.iac)) {
      this.hYh = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bf.NA();
      this.startOffset = this.hYf.hZP;
    }
    if (KM())
    {
      v.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fyw });
      GMTrace.o(363595825152L, 2709);
      return 0;
    }
    if (this.hYf.status != 112)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hYf.status + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "]");
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      GMTrace.o(363595825152L, 2709);
      return -1;
    }
    v.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "]  filesize:" + this.hYf.hZP + " file:" + this.hYf.hrb + " netTimes:" + this.hYf.hZX);
    if (!t.lA(this.fyw))
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hYf.hZX + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      GMTrace.o(363595825152L, 2709);
      return -1;
    }
    if (this.hYf.fTG <= 0L)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hYf.fTG + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      GMTrace.o(363595825152L, 2709);
      return -1;
    }
    if ((this.hYf.hZP < 0) || (this.hYf.hrb <= this.hYf.hZP) || (this.hYf.hrb <= 0))
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hYf.hZP + " total:" + this.hYf.hrb + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      GMTrace.o(363595825152L, 2709);
      return -1;
    }
    parame1 = new b.a();
    parame1.hrV = new ok();
    parame1.hrW = new ol();
    parame1.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    parame1.hrU = 150;
    parame1.hrX = 40;
    parame1.hrY = 1000000040;
    this.gUq = parame1.BE();
    parame1 = (ok)this.gUq.hrS.hsa;
    parame1.tdE = this.hYf.fTG;
    parame1.tfe = this.hYf.hZP;
    parame1.tfd = this.hYf.hrb;
    if (com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext())) {}
    for (;;)
    {
      parame1.tss = i;
      i = a(parame, this.gUq, this);
      GMTrace.o(363595825152L, 2709);
      return i;
      i = 2;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(363730042880L, 2710);
    paramp = (ok)((com.tencent.mm.y.b)paramp).hrS.hsa;
    if ((paramp.tdE <= 0L) || (paramp.tfe < 0) || (paramp.tfd <= 0) || (paramp.tfd <= paramp.tfe))
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      i = k.b.hsD;
      GMTrace.o(363730042880L, 2710);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(363730042880L, 2710);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(364266913792L, 2714);
    if (this.hYi)
    {
      v.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(364266913792L, 2714);
      return;
    }
    paramArrayOfByte = (ol)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramp = (ok)((com.tencent.mm.y.b)paramp).hrS.hsa;
    this.hYf = t.lI(this.fyw);
    if (this.hYf == null)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (this.hYf.status == 113)
    {
      v.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (this.hYf.status != 112)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYf.status + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 208L, 1L, false);
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hYh), Integer.valueOf(this.hrb - this.startOffset) });
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 207L, 1L, false);
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.hYf.status = 113;
      t.e(this.hYf);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (bf.bm(paramArrayOfByte.tqC.tXD.sWU))
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (paramArrayOfByte.tfe != paramp.tfe)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.tfe + " reqStartPos:" + paramp.tfe + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (paramArrayOfByte.tfd != paramp.tfd)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.tfd + " reqTotal:" + paramp.tfd + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (paramp.tfd < paramArrayOfByte.tfe)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.tfd + " respStartPos:" + paramp.tfe + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (paramArrayOfByte.tdE != paramp.tdE)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.tdE + " reqMsgId:" + paramp.tdE + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    v.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.tqC.tXB + " reqStartPos:" + paramp.tfe + " totallen:" + paramp.tfd + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
    o.KW();
    int j = s.a(s.lw(this.fyw), paramp.tfe, paramArrayOfByte.tqC.tXD.toByteArray());
    if (j < 0)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (j > this.hYf.hrb)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.hYf.hrb + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    paramp = this.fyw;
    paramArrayOfByte = t.lI(paramp);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + paramp);
      paramInt1 = 0 - com.tencent.mm.compatible.util.g.sb();
    }
    while (paramInt1 < 0)
    {
      v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
      paramArrayOfByte.hZP = j;
      paramArrayOfByte.hZT = bf.Nz();
      paramArrayOfByte.fRM = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.hrb > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.hrb)
        {
          t.d(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.fRM |= 0x100;
          v.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramp + " newsize:" + j + " total:" + paramArrayOfByte.hrb + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.hZX);
          paramInt1 = 1;
        }
      }
      v.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.sd() + " file:" + paramp + " newsize:" + j + " total:" + paramArrayOfByte.hrb + " status:" + paramArrayOfByte.status);
      if (!t.e(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.g.sb();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hYh), Integer.valueOf(this.hrb - this.startOffset) });
      a.a(this.hYf, 1);
      v.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "]");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    if (this.hYi)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(364266913792L, 2714);
      return;
    }
    this.hqz.v(0L, 0L);
    GMTrace.o(364266913792L, 2714);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(364132696064L, 2713);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 211L, 1L, false);
    t.lB(this.fyw);
    GMTrace.o(364132696064L, 2713);
  }
  
  public final void gM(final int paramInt)
  {
    GMTrace.i(363461607424L, 2708);
    Object localObject = new StringBuilder();
    o.KW();
    localObject = new File(s.lw(this.fyw) + ".tmp");
    o.KW();
    ((File)localObject).renameTo(new File(s.lw(this.fyw)));
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(337826021376L, 2517);
        Object localObject1 = bg.q(d.this.hYf.Li(), "msg");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = o.KW();
          o.KW();
          ((s)localObject2).o(s.lw(d.this.fyw), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
        }
        boolean bool = t.H(d.this.fyw, paramInt);
        v.i("MicroMsg.NetSceneDownloadVideo", "ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d", new Object[] { d.this.fyw, Long.valueOf(d.this.hYf.fTG), d.this.hYf.Lg(), d.this.hYf.Lf(), Boolean.valueOf(bool), d.this.hGm, Integer.valueOf(d.this.hGn) });
        if ((!bf.mA(d.this.hGm)) && (d.this.hGn > 0))
        {
          localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
          localObject2 = d.this.hGm;
          int i = d.this.hGn;
          o.KW();
          ((at)localObject1).p((String)localObject2, i, s.lw(d.this.fyw));
        }
        if (d.this.hYf.iac == 3)
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(198L, 38L, d.this.hYf.hrb, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(198L, 40L, d.this.hYf.hZV, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(198L, 41L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
          if (com.tencent.mm.u.o.dH(d.this.hYf.Lf())) {}
          for (l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject1).a(198L, l, 1L, false);
            d.this.gUt.a(0, 0, "", d.this);
            GMTrace.o(337826021376L, 2517);
            return;
          }
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 31L, d.this.hYf.hrb, false);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 33L, d.this.hYf.hZV, false);
        com.tencent.mm.plugin.report.service.g.oSF.a(198L, 34L, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
        if (com.tencent.mm.u.o.dH(d.this.hYf.Lf())) {}
        for (long l = 36L;; l = 35L)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject1).a(198L, l, 1L, false);
          break;
        }
      }
    });
    GMTrace.o(363461607424L, 2708);
  }
  
  public final int getType()
  {
    GMTrace.i(364401131520L, 2715);
    GMTrace.o(364401131520L, 2715);
    return 150;
  }
  
  public final boolean pd()
  {
    GMTrace.i(362924736512L, 2704);
    boolean bool = false;
    if (!bf.mA(this.mediaId))
    {
      if (!this.hYd) {
        break label66;
      }
      v.i("MicroMsg.NetSceneDownloadVideo", "cancel online video task.");
      o.KX().b(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.hYi = true;
      GMTrace.o(362924736512L, 2704);
      return bool;
      label66:
      v.i("MicroMsg.NetSceneDownloadVideo", "cancel offline video task.");
      com.tencent.mm.modelcdntran.g.Em().iQ(this.mediaId);
    }
  }
  
  protected final int ub()
  {
    GMTrace.i(363864260608L, 2711);
    GMTrace.o(363864260608L, 2711);
    return 2500;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */