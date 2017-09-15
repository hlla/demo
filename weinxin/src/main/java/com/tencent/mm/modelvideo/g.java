package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ba;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends k
  implements j
{
  private static int hYy;
  private final int MAX_TIMES;
  public int fEO;
  private String fVs;
  public String fyw;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  public String hGf;
  private com.tencent.mm.modelcdntran.h.a hGp;
  public boolean hGw;
  g.a hJO;
  boolean hYA;
  private int hYB;
  public boolean hYC;
  public boolean hYD;
  public int hYE;
  private int hYF;
  int hYG;
  public r hYf;
  public int hYh;
  boolean hYi;
  private final long hYz;
  ai hqz;
  public long startTime;
  
  static
  {
    GMTrace.i(337557585920L, 2515);
    hYy = 32000;
    GMTrace.o(337557585920L, 2515);
  }
  
  public g(String paramString)
  {
    GMTrace.i(334202142720L, 2490);
    this.fVs = "";
    this.hYz = 1800000L;
    this.fEO = 0;
    this.hYi = false;
    this.hYA = false;
    this.hJO = null;
    this.hGw = true;
    this.hGf = "";
    this.startTime = 0L;
    this.hYB = -1;
    this.hYh = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    this.hYC = false;
    this.hYD = false;
    this.hYE = 0;
    this.hYF = 0;
    this.hGp = new com.tencent.mm.modelcdntran.h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(332457312256L, 2477);
        v.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.this.KP(), g.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.this.hGf });
          GMTrace.o(332457312256L, 2477);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          t.lB(g.this.fyw);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(g.this.hYh), Integer.valueOf(0), "" });
          g.this.gUt.a(3, paramAnonymousInt, "", g.this);
          GMTrace.o(332457312256L, 2477);
          return 0;
        }
        g.this.hYf = t.lI(g.this.fyw);
        int i;
        if ((g.this.hYf == null) || (g.this.hYf.status == 105))
        {
          if (g.this.hYf == null) {}
          for (i = -1;; i = g.this.hYf.status)
          {
            v.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.this.KP(), Integer.valueOf(i) });
            com.tencent.mm.modelcdntran.g.Em().iP(g.this.hGf);
            g.this.gUt.a(3, paramAnonymousInt, "info is null or has paused, status" + i, g.this);
            GMTrace.o(332457312256L, 2477);
            return 0;
          }
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (g.this.hYf.hYB > paramAnonymouskeep_ProgressInfo.field_finishedLength)
          {
            v.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.this.KP(), Integer.valueOf(g.this.hYf.hYB), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
            GMTrace.o(332457312256L, 2477);
            return 0;
          }
          g.this.hYf.hZT = bf.Nz();
          g.this.hYf.hYB = paramAnonymouskeep_ProgressInfo.field_finishedLength;
          g.this.hYf.fRM = 1032;
          t.e(g.this.hYf);
          GMTrace.o(332457312256L, 2477);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode != 0)
          {
            v.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.this.KP(), Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult.field_arg, paramAnonymouskeep_SceneResult.field_transInfo });
            t.lB(g.this.fyw);
            com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(g.this.hYh), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(g.this.hYh), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
            g.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", g.this);
          }
        }
        else
        {
          GMTrace.o(332457312256L, 2477);
          return 0;
        }
        v.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.this.KP(), Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(g.this.hGw) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
        if (g.this.hYD)
        {
          paramAnonymousInt = 810;
          label1002:
          paramAnonymousString.i(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Integer.valueOf(g.this.hYf.hrb) });
          paramAnonymousBoolean = paramAnonymouskeep_SceneResult.field_isVideoReduced;
          v.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.this.KP(), Boolean.valueOf(paramAnonymousBoolean), g.this.fyw });
          if (paramAnonymousBoolean) {
            break label1759;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(106L, 205L, 1L, false);
          if ((g.this.hYE > 0) && (paramAnonymouskeep_SceneResult.field_thumbimgLength > 0))
          {
            v.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.this.KP(), Integer.valueOf(g.this.hYE), Integer.valueOf(paramAnonymouskeep_SceneResult.field_thumbimgLength) });
            if (g.this.hYE * 2 <= paramAnonymouskeep_SceneResult.field_thumbimgLength) {
              break label1725;
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(106L, 206L, 1L, false);
          }
          label1201:
          o.KW();
          paramAnonymousInt = com.tencent.mm.a.e.aN(s.lw(g.this.fyw));
          v.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.this.KP(), Integer.valueOf(g.this.hYf.hrb), Integer.valueOf(paramAnonymousInt) });
          if (g.this.hYf.hrb == paramAnonymousInt) {
            break label1742;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(106L, 208L, 1L, false);
          label1292:
          g.this.hYf = t.lI(g.this.fyw);
          if (bf.mA(g.this.hYf.Li()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymouskeep_SceneResult.field_thumbimgLength + "\"/></msg>";
            v.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.this.KP(), paramAnonymousString });
            g.this.hYf.iab = paramAnonymousString;
            t.e(g.this.hYf);
          }
          paramAnonymousString = bg.q(g.this.hYf.Li(), "msg");
          if (paramAnonymousString != null)
          {
            paramAnonymouskeep_ProgressInfo = o.KW();
            o.KW();
            boolean bool = paramAnonymouskeep_ProgressInfo.o(s.lw(g.this.fyw), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
            if (!bool) {
              break label1776;
            }
            paramAnonymousInt = 1;
            label1614:
            paramAnonymousString.i(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(g.this.hYf.hrb) });
          }
          paramAnonymousString = com.tencent.mm.kernel.h.vd();
          paramAnonymouskeep_ProgressInfo = g.this.fyw;
          if (!paramAnonymousBoolean) {
            break label1781;
          }
          paramAnonymousInt = 0;
        }
        for (;;)
        {
          paramAnonymousString.a(new h(paramAnonymouskeep_ProgressInfo, paramAnonymousInt, paramAnonymouskeep_SceneResult, new h.a()
          {
            public final void bb(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              GMTrace.i(354737455104L, 2643);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.h.vL().D(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(326014861312L, 2429);
                    g.this.hGw = false;
                    g.this.hYf.status = 104;
                    g.this.hYf.hZS = bf.Nz();
                    g.this.hYf.hZT = bf.Nz();
                    g.this.hYf.hYB = 0;
                    g.this.hYf.fRM = 1800;
                    boolean bool = t.e(g.this.hYf);
                    v.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.this.KP(), Boolean.valueOf(g.this.hGw), Boolean.valueOf(bool), Long.valueOf(g.this.hYf.hZS) });
                    g.this.a(g.a(g.this), g.this.gUt);
                    GMTrace.o(326014861312L, 2429);
                  }
                });
                GMTrace.o(354737455104L, 2643);
                return;
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(g.this.hYh), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramAnonymouskeep_SceneResult.report_Part2 });
              a.a(g.this.hYf, 0);
              g localg = g.this;
              keep_SceneResult localkeep_SceneResult = paramAnonymouskeep_SceneResult;
              n localn = n.KU();
              o.KW();
              localn.a(localkeep_SceneResult, s.lw(localg.fyw));
              g.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
              GMTrace.o(354737455104L, 2643);
            }
          }), 0);
          break;
          if (g.this.hYC)
          {
            paramAnonymousInt = 820;
            break label1002;
          }
          paramAnonymousInt = 830;
          break label1002;
          label1725:
          com.tencent.mm.plugin.report.service.g.oSF.a(106L, 207L, 1L, false);
          break label1201;
          label1742:
          com.tencent.mm.plugin.report.service.g.oSF.a(106L, 209L, 1L, false);
          break label1292;
          label1759:
          com.tencent.mm.plugin.report.service.g.oSF.a(106L, 200L, 1L, false);
          break label1292;
          label1776:
          paramAnonymousInt = 2;
          break label1614;
          label1781:
          g localg = g.this;
          o.KW();
          String str = s.lw(localg.hYf.getFileName());
          if (!com.tencent.mm.plugin.a.c.mD(str))
          {
            v.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", new Object[] { localg.KP() });
            paramAnonymousInt = 0;
          }
          else
          {
            i = 0;
            com.tencent.mm.plugin.a.b localb = new com.tencent.mm.plugin.a.b();
            long l1 = localb.mC(str);
            long l2 = localb.ill;
            paramAnonymousInt = i;
            if (l1 < 131072L)
            {
              paramAnonymousInt = i;
              if (l1 > 0L)
              {
                paramAnonymousInt = i;
                if (localg.hYf.hZV > 5)
                {
                  paramAnonymousInt = i;
                  if (localb.ilm > 0L)
                  {
                    paramAnonymousInt = i;
                    if (l2 > 0L)
                    {
                      i = (int)l2 + (int)(localb.ilm * 5L / localg.hYf.hZV);
                      paramAnonymousInt = i;
                      if (i <= 131072) {
                        paramAnonymousInt = i + 131072;
                      }
                    }
                  }
                }
              }
            }
            v.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", new Object[] { localg.KP(), Integer.valueOf(paramAnonymousInt), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(localg.hYf.hZV), Long.valueOf(localb.ilm) });
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(332591529984L, 2478);
        GMTrace.o(332591529984L, 2478);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(332725747712L, 2479);
        GMTrace.o(332725747712L, 2479);
        return null;
      }
    };
    this.hYG = 0;
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(332188876800L, 2475);
        if (g.this.a(g.b(g.this), g.this.gUt) == -1)
        {
          g.this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
          g.this.gUt.a(3, -1, "doScene failed", g.this);
        }
        GMTrace.o(332188876800L, 2475);
        return false;
      }
    }, true);
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      v.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + paramString);
      this.fyw = paramString;
      this.hYf = t.lI(paramString);
      if (this.hYf == null) {
        break label268;
      }
    }
    label268:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.hJO = new g.a();
      if ((this.hYf != null) && (3 == this.hYf.iac)) {
        this.hYh = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
      }
      v.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { KP(), Integer.valueOf(this.hYh) });
      GMTrace.o(334202142720L, 2490);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean KM()
  {
    GMTrace.i(334067924992L, 2489);
    if (com.tencent.mm.u.o.fF(this.hYf.Lf()))
    {
      v.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { KP(), this.hYf.Lf() });
      GMTrace.o(334067924992L, 2489);
      return false;
    }
    com.tencent.mm.modelcdntran.g.Em();
    if ((!com.tencent.mm.modelcdntran.c.fA(2)) && (this.hYf.iaa != 1))
    {
      localObject1 = KP();
      com.tencent.mm.modelcdntran.g.Em();
      v.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(2)), Integer.valueOf(this.hYf.iaa) });
      GMTrace.o(334067924992L, 2489);
      return false;
    }
    this.hGf = com.tencent.mm.modelcdntran.d.a("upvideo", this.hYf.hZS, this.hYf.Lf(), this.hYf.getFileName());
    if (bf.mA(this.hGf))
    {
      v.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { KP(), this.hYf.getFileName() });
      GMTrace.o(334067924992L, 2489);
      return false;
    }
    o.KW();
    Object localObject1 = s.lx(this.fyw);
    o.KW();
    String str2 = s.lw(this.fyw);
    com.tencent.mm.modelcdntran.h localh = new com.tencent.mm.modelcdntran.h();
    localh.hyM = this.hGp;
    localh.field_mediaId = this.hGf;
    localh.field_fullpath = str2;
    localh.field_thumbpath = lm((String)localObject1);
    localh.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    localh.field_enable_hitcheck = this.hGw;
    localh.field_largesvideo = com.tencent.mm.modelcontrol.d.Ev().iW(str2);
    if ((this.hYf != null) && (3 == this.hYf.iac)) {
      localh.field_smallVideoFlag = 1;
    }
    localObject1 = KP();
    boolean bool1;
    String str1;
    Object localObject3;
    if (this.hYf.iaf == null)
    {
      bool1 = true;
      v.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fyw });
      if ((this.hYf.iaf != null) && (this.hYf.iaf.tMG))
      {
        v.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { KP() });
        localObject1 = n.KU();
        o.KW();
        ((n)localObject1).a("", s.lw(this.fyw), this.hYf.Lf(), "", "", 2, 2);
        localh.field_largesvideo = true;
      }
      str1 = KP();
      localObject3 = this.hYf.getFileName();
      if (this.hYf.iae != null) {
        break label718;
      }
      localObject1 = "null";
      label512:
      v.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str1, localObject3, localObject1 });
      if ((this.hYf.iae != null) && (!bf.mA(this.hYf.iae.hjz))) {
        localh.field_advideoflag = 1;
      }
      localh.field_talker = this.hYf.Lf();
      if (!com.tencent.mm.u.o.dH(this.hYf.Lf())) {
        break label733;
      }
    }
    label718:
    label733:
    for (int i = 1;; i = 0)
    {
      localh.field_chattype = i;
      localh.field_priority = com.tencent.mm.modelcdntran.b.hxt;
      localh.field_needStorage = false;
      localh.field_isStreamMedia = false;
      localh.field_trysafecdn = true;
      this.hYF = com.tencent.mm.a.e.aN(localh.field_fullpath);
      this.hYE = com.tencent.mm.a.e.aN(localh.field_thumbpath);
      if (this.hYE < com.tencent.mm.modelcdntran.b.hxI) {
        break label738;
      }
      v.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { KP(), localh.field_thumbpath, Integer.valueOf(this.hYE) });
      GMTrace.o(334067924992L, 2489);
      return false;
      bool1 = false;
      break;
      localObject1 = this.hYf.iae.hjz;
      break label512;
    }
    label738:
    localObject1 = bg.q(this.hYf.Li(), "msg");
    boolean bool2;
    label1177:
    int m;
    long l1;
    label1264:
    label1282:
    label1437:
    label1443:
    label1449:
    label1455:
    label1461:
    label1467:
    label1473:
    Object localObject2;
    Object localObject5;
    Object localObject4;
    label1890:
    int k;
    int j;
    label1953:
    int i2;
    if (localObject1 != null)
    {
      localh.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localh.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.hYD = true;
      localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
      if (this.hYC)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject1).i(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.hYf.hrb) });
        if ((bf.mA(localh.field_aesKey)) || (bf.mA(localh.field_aesKey)))
        {
          localh.field_aesKey = "";
          localh.field_fileId = "";
        }
        v.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %b", new Object[] { KP(), localh.field_mediaId, localh.field_fileId, localh.field_aesKey, Boolean.valueOf(this.hGw), Boolean.valueOf(localh.field_largesvideo) });
        if (com.tencent.mm.modelcdntran.g.Em().b(localh)) {
          break label2879;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 226L, 1L, false);
        v.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { KP() });
        this.hGf = "";
        GMTrace.o(334067924992L, 2489);
        return false;
      }
    }
    else
    {
      v.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { KP() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str1 = bf.mz(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("UseVideoHash"));
          localObject1 = str1.split(",");
          com.tencent.mm.kernel.h.vJ();
          com.tencent.mm.kernel.h.vG();
          i = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1443;
          }
          if (bf.getInt(localObject1[0], 0) < i) {
            break label1437;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1455;
          }
          if (bf.getInt(localObject1[1], 0) < i) {
            break label1449;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1467;
          }
          if (bf.getInt(localObject1[2], 0) < i) {
            break label1461;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.bIk()) {
            break label2956;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2856;
          }
          localObject3 = o.KW();
          m = bf.getInt(localObject1[2], 0);
          v.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str2, bf.bJP() });
          l1 = bf.NA();
          if (!bf.mA(str2)) {
            break label1473;
          }
          v.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str2 });
          localObject1 = "";
          if (bf.mA((String)localObject1)) {
            break label2856;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localh.field_fileId = localObject1[0];
            localh.field_aesKey = localObject1[1];
            this.hYC = true;
          }
          v.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { KP(), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIk()), str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.hYC), localh.field_fileId, localh.field_aesKey });
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bf.g(localException) });
        }
        break;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        continue;
        localObject2 = s.lz(str2);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          v.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str2 });
          localObject2 = "";
        }
        else
        {
          ((s)localObject3).hnp.eE("VideoHash", "delete from VideoHash where CreateTime < " + (bf.Nz() - 432000L));
          n = localObject2[32];
          StringBuffer localStringBuffer = new StringBuffer();
          i = 0;
          while (i < 32)
          {
            localStringBuffer.append(Integer.toHexString(localObject2[i]));
            i += 1;
          }
          i1 = localStringBuffer.length();
          localObject5 = new Vector();
          localObject4 = new Vector();
          Vector localVector1 = new Vector();
          localVector2 = new Vector();
          i = -1;
          Cursor localCursor = ((s)localObject3).hnp.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + n, null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            v.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bf.mA(str3)) || (bf.mA(str4)))
            {
              com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              v.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label2971;
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              v.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label2953;
                }
                j += 1;
                break label2978;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label2950;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              v.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            v.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              v.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bf.aA(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str2 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bf.mz((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2304:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label2947;
                }
                j += 1;
                break label2985;
              }
              if (j <= 0) {
                break label2518;
              }
              ((s)localObject3).hnp.eE("VideoHash", "delete from VideoHash where size = " + n);
              com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              v.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str2 });
              localObject2 = "";
            }
          }
        }
      }
      label2518:
      l1 = bf.aA(l1);
      long l2 = bf.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.g.oSF.i(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      v.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str2, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bf.NA() % 1000L;
      if (l1 < m * 10) {
        break label2992;
      }
      if (i2 < 90) {
        break label2992;
      }
    }
    for (;;)
    {
      v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIk()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.bIk())) {
        com.tencent.mm.sdk.f.e.b(new s.2((s)localObject3, str2, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff", 1);
      }
      break label1264;
      boolean bool4 = false;
      continue;
      label2856:
      localObject2 = null;
      break label1282;
      if (this.hYD)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2879:
      if (this.hYf.iaa != 1)
      {
        this.hYf.iaa = 1;
        this.hYf.status = 104;
        this.hYf.clientId = this.hGf;
        this.hYf.fRM = 524544;
        t.e(this.hYf);
      }
      GMTrace.o(334067924992L, 2489);
      return true;
      label2947:
      break label2985;
      label2950:
      break label1953;
      label2953:
      break label2978;
      label2956:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1177;
      label2971:
      j = 0;
      k = 0;
      break label1890;
      label2978:
      k += 1;
      break label1890;
      label2985:
      k += 1;
      break label2304;
      label2992:
      bool4 = true;
    }
  }
  
  /* Error */
  private String lm(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 696
    //   3: sipush 2498
    //   6: invokestatic 58	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 699	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 700	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 9
    //   19: new 699	java/io/File
    //   22: dup
    //   23: aload 9
    //   25: invokevirtual 704	java/io/File:getParentFile	()Ljava/io/File;
    //   28: new 134	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 706
    //   35: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload 9
    //   40: invokevirtual 709	java/io/File:getName	()Ljava/lang/String;
    //   43: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 712	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore 10
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 8
    //   60: aconst_null
    //   61: astore 6
    //   63: aconst_null
    //   64: astore 5
    //   66: ldc -124
    //   68: ldc_w 714
    //   71: iconst_1
    //   72: anewarray 179	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload 9
    //   79: invokevirtual 716	java/io/File:length	()J
    //   82: invokestatic 620	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 624	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload 9
    //   91: invokevirtual 716	java/io/File:length	()J
    //   94: ldc2_w 717
    //   97: lcmp
    //   98: ifle +563 -> 661
    //   101: aload 10
    //   103: invokevirtual 721	java/io/File:exists	()Z
    //   106: ifeq +112 -> 218
    //   109: ldc -124
    //   111: ldc_w 723
    //   114: iconst_1
    //   115: anewarray 179	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 10
    //   122: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 624	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iconst_1
    //   130: istore_2
    //   131: aload 8
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 729	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 732	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +382 -> 542
    //   163: ldc -124
    //   165: ldc_w 734
    //   168: iconst_3
    //   169: anewarray 179	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 182	com/tencent/mm/modelvideo/g:KP	()Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 10
    //   183: invokevirtual 716	java/io/File:length	()J
    //   186: invokestatic 620	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload 10
    //   194: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 191	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 10
    //   203: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   206: astore_1
    //   207: ldc2_w 696
    //   210: sipush 2498
    //   213: invokestatic 63	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   216: aload_1
    //   217: areturn
    //   218: aload 9
    //   220: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   223: invokestatic 740	com/tencent/mm/sdk/platformtools/d:Pd	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   226: astore 11
    //   228: aload 11
    //   230: ifnonnull +111 -> 341
    //   233: ldc_w 336
    //   236: astore 4
    //   238: ldc -124
    //   240: ldc_w 742
    //   243: iconst_1
    //   244: anewarray 179	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload 4
    //   251: aastore
    //   252: invokestatic 191	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 11
    //   257: ifnull +121 -> 378
    //   260: aload 11
    //   262: getfield 747	android/graphics/BitmapFactory$Options:outWidth	I
    //   265: sipush 288
    //   268: if_icmpgt +14 -> 282
    //   271: aload 11
    //   273: getfield 750	android/graphics/BitmapFactory$Options:outHeight	I
    //   276: sipush 288
    //   279: if_icmple +99 -> 378
    //   282: aload 9
    //   284: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: sipush 288
    //   290: sipush 288
    //   293: getstatic 756	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   296: bipush 60
    //   298: new 134	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 757	java/lang/StringBuilder:<init>	()V
    //   305: aload 10
    //   307: invokevirtual 704	java/io/File:getParentFile	()Ljava/io/File;
    //   310: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   313: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 759
    //   319: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aload 10
    //   327: invokevirtual 709	java/io/File:getName	()Ljava/lang/String;
    //   330: invokestatic 762	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   333: istore_2
    //   334: aload 8
    //   336: astore 4
    //   338: goto -203 -> 135
    //   341: new 134	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 757	java/lang/StringBuilder:<init>	()V
    //   348: aload 11
    //   350: getfield 747	android/graphics/BitmapFactory$Options:outWidth	I
    //   353: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 764
    //   359: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 11
    //   364: getfield 750	android/graphics/BitmapFactory$Options:outHeight	I
    //   367: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore 4
    //   375: goto -137 -> 238
    //   378: new 766	java/io/FileInputStream
    //   381: dup
    //   382: aload 9
    //   384: invokespecial 769	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   387: astore 4
    //   389: aload 4
    //   391: fconst_0
    //   392: sipush 288
    //   395: sipush 288
    //   398: invokestatic 772	com/tencent/mm/sdk/platformtools/d:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   401: astore 8
    //   403: aload 8
    //   405: ifnull +251 -> 656
    //   408: new 774	java/io/FileOutputStream
    //   411: dup
    //   412: aload 10
    //   414: invokespecial 775	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   417: astore 5
    //   419: aload 5
    //   421: astore 7
    //   423: aload 4
    //   425: astore 6
    //   427: aload 8
    //   429: getstatic 756	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   432: bipush 60
    //   434: aload 5
    //   436: invokevirtual 781	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   439: istore_2
    //   440: goto -305 -> 135
    //   443: astore 8
    //   445: aconst_null
    //   446: astore 5
    //   448: aconst_null
    //   449: astore 4
    //   451: aload 5
    //   453: astore 7
    //   455: aload 4
    //   457: astore 6
    //   459: ldc -124
    //   461: ldc_w 783
    //   464: iconst_1
    //   465: anewarray 179	java/lang/Object
    //   468: dup
    //   469: iconst_0
    //   470: aload 8
    //   472: invokestatic 523	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   475: aastore
    //   476: invokestatic 440	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   479: aload 4
    //   481: ifnull +8 -> 489
    //   484: aload 4
    //   486: invokevirtual 729	java/io/InputStream:close	()V
    //   489: aload 5
    //   491: ifnull +160 -> 651
    //   494: aload 5
    //   496: invokevirtual 732	java/io/OutputStream:close	()V
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -342 -> 159
    //   504: astore 4
    //   506: iconst_0
    //   507: istore_3
    //   508: goto -349 -> 159
    //   511: astore_1
    //   512: aload 7
    //   514: astore 4
    //   516: aload 6
    //   518: astore 5
    //   520: aload 4
    //   522: ifnull +8 -> 530
    //   525: aload 4
    //   527: invokevirtual 729	java/io/InputStream:close	()V
    //   530: aload 5
    //   532: ifnull +8 -> 540
    //   535: aload 5
    //   537: invokevirtual 732	java/io/OutputStream:close	()V
    //   540: aload_1
    //   541: athrow
    //   542: ldc -124
    //   544: ldc_w 785
    //   547: iconst_3
    //   548: anewarray 179	java/lang/Object
    //   551: dup
    //   552: iconst_0
    //   553: aload_0
    //   554: invokevirtual 182	com/tencent/mm/modelvideo/g:KP	()Ljava/lang/String;
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: aload 9
    //   562: invokevirtual 716	java/io/File:length	()J
    //   565: invokestatic 620	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   568: aastore
    //   569: dup
    //   570: iconst_2
    //   571: aload 9
    //   573: invokevirtual 726	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 191	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: ldc2_w 696
    //   583: sipush 2498
    //   586: invokestatic 63	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   589: aload_1
    //   590: areturn
    //   591: astore 4
    //   593: goto -448 -> 145
    //   596: astore 4
    //   598: iload_2
    //   599: istore_3
    //   600: goto -441 -> 159
    //   603: astore 4
    //   605: goto -116 -> 489
    //   608: astore 4
    //   610: goto -80 -> 530
    //   613: astore 4
    //   615: goto -75 -> 540
    //   618: astore_1
    //   619: aload 6
    //   621: astore 5
    //   623: goto -103 -> 520
    //   626: astore_1
    //   627: aload 7
    //   629: astore 5
    //   631: aload 6
    //   633: astore 4
    //   635: goto -115 -> 520
    //   638: astore 8
    //   640: aconst_null
    //   641: astore 5
    //   643: goto -192 -> 451
    //   646: astore 8
    //   648: goto -197 -> 451
    //   651: iconst_0
    //   652: istore_3
    //   653: goto -494 -> 159
    //   656: iconst_0
    //   657: istore_2
    //   658: goto -523 -> 135
    //   661: iconst_0
    //   662: istore_2
    //   663: aload 8
    //   665: astore 4
    //   667: goto -532 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	g
    //   0	670	1	paramString	String
    //   130	533	2	bool1	boolean
    //   146	507	3	bool2	boolean
    //   133	352	4	localObject1	Object
    //   504	1	4	localIOException1	java.io.IOException
    //   514	12	4	localObject2	Object
    //   591	1	4	localIOException2	java.io.IOException
    //   596	1	4	localIOException3	java.io.IOException
    //   603	1	4	localIOException4	java.io.IOException
    //   608	1	4	localIOException5	java.io.IOException
    //   613	1	4	localIOException6	java.io.IOException
    //   633	33	4	localObject3	Object
    //   64	578	5	localObject4	Object
    //   61	571	6	localObject5	Object
    //   55	573	7	localObject6	Object
    //   58	370	8	localBitmap	android.graphics.Bitmap
    //   443	28	8	localException1	Exception
    //   638	1	8	localException2	Exception
    //   646	18	8	localException3	Exception
    //   17	555	9	localFile1	java.io.File
    //   52	361	10	localFile2	java.io.File
    //   226	137	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   89	129	443	java/lang/Exception
    //   218	228	443	java/lang/Exception
    //   238	255	443	java/lang/Exception
    //   260	282	443	java/lang/Exception
    //   282	334	443	java/lang/Exception
    //   341	375	443	java/lang/Exception
    //   378	389	443	java/lang/Exception
    //   494	499	504	java/io/IOException
    //   89	129	511	finally
    //   218	228	511	finally
    //   238	255	511	finally
    //   260	282	511	finally
    //   282	334	511	finally
    //   341	375	511	finally
    //   378	389	511	finally
    //   140	145	591	java/io/IOException
    //   152	157	596	java/io/IOException
    //   484	489	603	java/io/IOException
    //   525	530	608	java/io/IOException
    //   535	540	613	java/io/IOException
    //   389	403	618	finally
    //   408	419	618	finally
    //   427	440	626	finally
    //   459	479	626	finally
    //   389	403	638	java/lang/Exception
    //   408	419	638	java/lang/Exception
    //   427	440	646	java/lang/Exception
  }
  
  public final boolean BJ()
  {
    GMTrace.i(334873231360L, 2495);
    boolean bool = super.BJ();
    if (bool) {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 210L, 1L, false);
    }
    GMTrace.o(334873231360L, 2495);
    return bool;
  }
  
  public final String KP()
  {
    GMTrace.i(18679483858944L, 139173);
    String str = this.fyw + "_" + hashCode();
    GMTrace.o(18679483858944L, 139173);
    return str;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(334336360448L, 2491);
    this.gUt = parame1;
    this.hYf = t.lI(this.fyw);
    if ((this.hYf == null) || ((this.hYf.status != 104) && (this.hYf.status != 103)))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { KP(), this.fyw });
      this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
      GMTrace.o(334336360448L, 2491);
      return -1;
    }
    parame1 = new StringBuilder("doscene file:").append(this.fyw).append(" stat:").append(this.hYf.status).append(" [").append(this.hYf.hZQ).append(",").append(this.hYf.hZR).append("] [").append(this.hYf.hYB).append(",").append(this.hYf.hrb).append("]  netTimes:").append(this.hYf.hZX).append(" times:");
    int i = this.hYG;
    this.hYG = (i + 1);
    v.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bf.NA();
      this.hYB = this.hYf.hYB;
    }
    if (KM())
    {
      v.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fyw });
      GMTrace.o(334336360448L, 2491);
      return 0;
    }
    bhz localbhz;
    if (this.hYf.hZZ == 1)
    {
      this.hYA = true;
      parame1 = new b.a();
      parame1.hrV = new bhz();
      parame1.hrW = new bia();
      parame1.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      parame1.hrU = 149;
      parame1.hrX = 39;
      parame1.hrY = 1000000039;
      this.gUq = parame1.BE();
      localbhz = (bhz)this.gUq.hrS.hsa;
      localbhz.muu = ((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
      localbhz.mut = this.hYf.Lf();
      localbhz.teo = this.fyw;
      if (this.hYA) {
        localbhz.ufR = 2;
      }
      if (this.hYf.iac == 3) {
        localbhz.ufR = 3;
      }
      localbhz.ufQ = this.hYf.hZV;
      localbhz.tNg = this.hYf.hZR;
      localbhz.ufN = this.hYf.hrb;
      if (!com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext())) {
        break label1148;
      }
      i = 1;
      label532:
      localbhz.tss = i;
      localbhz.tNj = 2;
      localbhz.ufO = 0;
      localbhz.ufP = new avt().bb(new byte[0]);
      localbhz.tNi = new avt().bb(new byte[0]);
      if (!bf.mA(this.fVs)) {
        break label1153;
      }
      o.KW();
      parame1 = com.tencent.mm.a.g.aV(s.lw(this.fyw));
      this.fVs = parame1;
      label616:
      localbhz.ufU = parame1;
      localbhz.tdC = ba.zz();
      localbhz.ugd = this.hYf.fUO;
      parame1 = this.hYf.iae;
      if ((parame1 == null) || (bf.mA(parame1.hjt))) {
        break label1161;
      }
      localbhz.ufV = bf.ap(parame1.hjt, "");
      localbhz.ufW = parame1.txr;
      localbhz.ufX = bf.ap(parame1.hjv, "");
      localbhz.ufZ = bf.ap(parame1.hjx, "");
      localbhz.ufY = bf.ap(parame1.hjw, "");
      localbhz.uga = bf.ap(parame1.hjy, "");
    }
    for (;;)
    {
      if (parame1 != null)
      {
        localbhz.ugc = bf.ap(parame1.hjz, "");
        localbhz.ugb = bf.ap(parame1.hjA, "");
      }
      v.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(localbhz.ufQ), Integer.valueOf(localbhz.tNh), Integer.valueOf(localbhz.ufN), Integer.valueOf(localbhz.ufR), localbhz.ufU, localbhz.ufV, Integer.valueOf(localbhz.ufW), localbhz.ufX, localbhz.uga });
      if (this.hYf.status != 103) {
        break label1460;
      }
      o.KW();
      parame1 = s.h(s.lx(this.fyw), this.hYf.hZQ, hYy);
      if ((parame1.ret >= 0) && (parame1.fAB != 0)) {
        break label1206;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 225L, 1L, false);
      t.lB(this.fyw);
      v.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fyw + "]  Error ");
      this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
      GMTrace.o(334336360448L, 2491);
      return -1;
      if (this.hYf.hZS + 600L < bf.Nz())
      {
        v.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fyw);
        t.lB(this.fyw);
        this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
        GMTrace.o(334336360448L, 2491);
        return -1;
      }
      if (t.lA(this.fyw)) {
        break;
      }
      v.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fyw);
      t.lB(this.fyw);
      this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
      GMTrace.o(334336360448L, 2491);
      return -1;
      label1148:
      i = 2;
      break label532;
      label1153:
      parame1 = this.fVs;
      break label616;
      label1161:
      if ((parame1 != null) && (!bf.mA(parame1.hjx)) && (!bf.mA(parame1.hjw)))
      {
        localbhz.ufZ = parame1.hjx;
        localbhz.ufY = parame1.hjw;
      }
    }
    label1206:
    v.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + this.hYf.hZQ);
    if (parame1.iav < this.hYf.hZQ)
    {
      v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fyw + "] newOff:" + parame1.iav + " OldtOff:" + this.hYf.hZQ);
      t.lB(this.fyw);
      this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
      GMTrace.o(334336360448L, 2491);
      return -1;
    }
    byte[] arrayOfByte = new byte[parame1.fAB];
    System.arraycopy(parame1.buf, 0, arrayOfByte, 0, parame1.fAB);
    localbhz.tNh = this.hYf.hZQ;
    localbhz.tNi = new avt().bb(arrayOfByte);
    for (;;)
    {
      i = a(parame, this.gUq, this);
      GMTrace.o(334336360448L, 2491);
      return i;
      label1460:
      o.KW();
      parame1 = s.h(s.lw(this.fyw), this.hYf.hYB, hYy);
      if ((parame1.ret < 0) || (parame1.fAB == 0))
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 224L, 1L, false);
        t.lB(this.fyw);
        v.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fyw + "]  Error ");
        this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
        GMTrace.o(334336360448L, 2491);
        return -1;
      }
      v.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + this.hYf.hYB);
      if (parame1.iav < this.hYf.hYB)
      {
        v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fyw + "] newOff:" + parame1.iav + " OldtOff:" + this.hYf.hYB);
        t.lB(this.fyw);
        this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
        GMTrace.o(334336360448L, 2491);
        return -1;
      }
      if (parame1.iav >= 20971520)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 222L, 1L, false);
        v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fyw + "] maxsize:20971520");
        t.lB(this.fyw);
        this.fEO = (0 - (com.tencent.mm.compatible.util.g.sb() + 10000));
        GMTrace.o(334336360448L, 2491);
        return -1;
      }
      arrayOfByte = new byte[parame1.fAB];
      System.arraycopy(parame1.buf, 0, arrayOfByte, 0, parame1.fAB);
      localbhz.ufO = this.hYf.hYB;
      localbhz.tNh = this.hYf.hZQ;
      localbhz.ufP = new avt().bb(arrayOfByte);
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(334470578176L, 2492);
    paramp = (bhz)((com.tencent.mm.y.b)paramp).hrS.hsa;
    if ((bf.mA(paramp.teo)) || (paramp.tNj <= 0) || (bf.mA(paramp.muu)) || (bf.mA(paramp.mut)) || (paramp.tss <= 0) || (paramp.tNh > paramp.tNg) || (paramp.tNh < 0) || (paramp.ufO > paramp.ufN) || (paramp.ufO < 0) || ((paramp.ufO == paramp.ufN) && (paramp.tNh == paramp.tNg)) || (paramp.tNg <= 0) || (paramp.ufN <= 0) || ((paramp.ufP.tXB <= 0) && (paramp.tNi.tXB <= 0)))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fyw + " user:" + paramp.mut);
      i = k.b.hsD;
      GMTrace.o(334470578176L, 2492);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(334470578176L, 2492);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(335007449088L, 2496);
    v.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hGf);
    if (this.hYi)
    {
      v.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fyw + " user:" + this.hYf.Lf());
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(335007449088L, 2496);
      return;
    }
    paramArrayOfByte = (bia)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramp = (bhz)((com.tencent.mm.y.b)paramp).hrS.hsa;
    this.hYf = t.lI(this.fyw);
    if (this.hYf == null)
    {
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyw);
      this.fEO = (0 - com.tencent.mm.compatible.util.g.sb() - 10000);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if (this.hYf.status == 105)
    {
      v.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((this.hYf.status != 104) && (this.hYf.status != 103))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYf.status + " [" + this.fyw + "," + this.hYf.fTG + "," + this.hYf.Lg() + "," + this.hYf.Lf() + "] ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + this.hYf.Lf());
      t.lC(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 220L, 1L, false);
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + this.hYf.Lf());
      t.lB(this.fyw);
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hYh), Integer.valueOf(0) });
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 219L, 1L, false);
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + this.hYf.Lf());
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((!bf.bm(paramp.tNi.tXD.sWU)) && (paramp.tNh != paramArrayOfByte.tNh - paramp.tNi.tXB))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramp.tNh + "," + paramp.tNi.tXB + "," + paramArrayOfByte.tNh + "] file:" + this.fyw + " user:" + paramp.mut);
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    if ((!bf.bm(paramp.ufP.tXD.sWU)) && (paramp.ufO != paramArrayOfByte.ufO - paramp.ufP.tXB))
    {
      v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramp.ufO + "," + paramp.ufP.tXB + "," + paramArrayOfByte.ufO + "] file:" + this.fyw + " user:" + paramp.mut);
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    this.hYf.hZT = bf.Nz();
    this.hYf.fTG = paramArrayOfByte.tdE;
    this.hYf.fRM = 1028;
    v.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.hYf.fTG), Integer.valueOf(com.tencent.mm.platformtools.r.iiD) });
    if ((10007 == com.tencent.mm.platformtools.r.iiC) && (com.tencent.mm.platformtools.r.iiD != 0) && (this.hYf.fTG != 0L))
    {
      this.hYf.fTG = com.tencent.mm.platformtools.r.iiD;
      com.tencent.mm.platformtools.r.iiD = 0;
    }
    int i = 0;
    paramInt1 = this.hYf.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.hYf;
      paramInt1 = paramp.tNh;
      paramArrayOfByte.hZQ = (paramp.tNi.tXB + paramInt1);
      this.hYf.fRM |= 0x40;
      paramInt1 = i;
      if (this.hYf.hZQ >= this.hYf.hZR)
      {
        this.hYf.status = 104;
        this.hYf.fRM |= 0x100;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      t.e(this.hYf);
      if (!this.hYi) {
        break label1708;
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
      if (paramInt1 != 104) {
        break;
      }
      paramArrayOfByte = this.hYf;
      paramInt1 = paramp.ufO;
      paramArrayOfByte.hYB = (paramp.ufP.tXB + paramInt1);
      this.hYf.fRM |= 0x8;
      paramInt1 = i;
      if (this.hYf.hYB >= this.hYf.hrb)
      {
        this.hYf.status = 199;
        this.hYf.fRM |= 0x100;
        t.c(this.hYf);
        paramInt1 = 1;
      }
    }
    v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fyw + " user:" + paramp.mut);
    t.lB(this.fyw);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(335007449088L, 2496);
    return;
    label1708:
    if (paramInt1 == 0)
    {
      this.hqz.v(10L, 10L);
      GMTrace.o(335007449088L, 2496);
      return;
    }
    paramp = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(this.hYf.hZW);
    com.tencent.mm.modelstat.b.hTV.f(paramp);
    com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hYh), Integer.valueOf(this.hYf.hrb - this.hYB) });
    boolean bool;
    if (this.hYf == null)
    {
      bool = false;
      if ((!bool) && (!com.tencent.mm.u.o.fh(this.hYf.Lf()))) {
        break label2257;
      }
      v.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.hYf.Lf() });
      if (this.hYf.fTG < 0L)
      {
        v.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYf.fTG + " file:" + this.fyw + " toUser:" + this.hYf.Lf());
        t.lB(this.fyw);
      }
      label1987:
      if (this.hJO == null) {
        break label2345;
      }
    }
    label2257:
    label2345:
    for (long l = this.hJO.se();; l = 0L)
    {
      v.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fyw + " toUser:" + this.hYf.Lf() + " msgsvrid:" + this.hYf.fTG + " thumbsize:" + this.hYf.hZR + " videosize:" + this.hYf.hrb + " useTime:" + l);
      v.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fyw + " packSize:" + hYy + " filesize:" + this.hYf.hrb + " useTime:" + l);
      a.a(this.hYf, 0);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(335007449088L, 2496);
      return;
      paramp = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(this.hYf.Lf());
      if ((paramp == null) || ((int)paramp.gTG <= 0))
      {
        bool = false;
        break;
      }
      bool = paramp.bKU();
      break;
      v.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
      if (this.hYf.fTG > 0L) {
        break label1987;
      }
      v.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYf.fTG + " file:" + this.fyw + " toUser:" + this.hYf.Lf());
      t.lB(this.fyw);
      break label1987;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(334739013632L, 2494);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 221L, 1L, false);
    t.lB(this.fyw);
    GMTrace.o(334739013632L, 2494);
  }
  
  public final int getType()
  {
    GMTrace.i(335141666816L, 2497);
    GMTrace.o(335141666816L, 2497);
    return 149;
  }
  
  protected final int ub()
  {
    GMTrace.i(334604795904L, 2493);
    int i = this.MAX_TIMES;
    GMTrace.o(334604795904L, 2493);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */