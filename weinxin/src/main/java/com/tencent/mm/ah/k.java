package com.tencent.mm.ah;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.h.a.a;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  public static boolean DEBUG;
  private static long hGF;
  public String TAG;
  public au fCQ;
  public float fNS;
  public String fUR;
  public long gUY;
  public int gUZ;
  public final com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  private d gVa;
  private boolean gVg;
  public int hEK;
  public long hEO;
  public String hGA;
  private boolean hGB;
  public float hGC;
  public String hGD;
  public String hGE;
  public final com.tencent.mm.y.f hGb;
  public long hGc;
  private com.tencent.mm.modelstat.g hGe;
  public String hGf;
  public int hGg;
  private int hGj;
  private h.a hGp;
  public String hGu;
  public String hGv;
  public boolean hGw;
  private d hGx;
  private int hGy;
  public b hGz;
  public int scene;
  public int startOffset;
  public long startTime;
  
  static
  {
    GMTrace.i(3556769792000L, 26500);
    DEBUG = true;
    GMTrace.o(3556769792000L, 26500);
  }
  
  public k(int paramInt1, int paramInt2)
  {
    GMTrace.i(3549656252416L, 26447);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hGu = "";
    this.hGv = "";
    this.hGw = true;
    this.hGy = 16384;
    this.hEK = 0;
    this.fCQ = null;
    this.hGe = null;
    this.hGf = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.hGg = 0;
    this.hGz = new b(null);
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(3505901273088L, 26121);
        v.d(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.w(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          k.this.gUt.a(3, paramAnonymousInt, "", k.this);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          v.e(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt) });
          h.fX((int)k.this.hGc);
          h.fW((int)k.this.hGc);
          if (paramAnonymouskeep_SceneResult != null)
          {
            paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            localObject = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult != null) {
              break label428;
            }
          }
          label428:
          for (paramAnonymousString = "";; paramAnonymousString = k.jx(paramAnonymouskeep_SceneResult.report_Part2))
          {
            paramAnonymouskeep_ProgressInfo.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramAnonymousString });
            k.this.gUt.a(3, paramAnonymousInt, "", k.this);
            if (k.this.hGz != null) {
              k.this.hGz.GG();
            }
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
        }
        final Object localObject = k.this.GH();
        if ((localObject == null) || (((d)localObject).hEG != k.this.gUY))
        {
          com.tencent.mm.modelcdntran.g.Em().iP(k.this.hGf);
          v.e(k.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(k.this.gUY), k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          k.this.a((d)localObject, paramAnonymouskeep_ProgressInfo.field_finishedLength, 0L, 0, paramAnonymouskeep_SceneResult);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i(k.this.TAG, "dkupimg sceneResult:%s", new Object[] { paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1443;
          }
          v.e(k.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 44425)
          {
            v.w(k.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { k.this.hGf, Boolean.valueOf(k.this.hGw) });
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3557038227456L, 26502);
                k.this.hGw = false;
                k.this.startTime = 0L;
                k.this.startOffset = 0;
                Object localObject = k.this.GH();
                ((d)localObject).fM(0);
                k.this.fCQ.z(ay.gk(k.this.fCQ.field_talker));
                k.this.hGf = com.tencent.mm.modelcdntran.d.a("upimg", k.this.fCQ.field_createTime, k.this.fCQ.field_talker, k.this.fCQ.field_msgId + "_" + k.this.gUY + "_" + k.this.hEK);
                boolean bool = k.this.a((d)localObject, 0, 0L, 0, paramAnonymouskeep_SceneResult);
                localObject = (bhr)k.this.gUq.hrS.hsa;
                if (localObject == null) {
                  v.w(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  v.i(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(k.this.hGw), Boolean.valueOf(bool), k.this.hGf, Long.valueOf(k.this.fCQ.field_createTime) });
                  k.this.a(k.b(k.this), k.this.gUt);
                  GMTrace.o(3557038227456L, 26502);
                  return;
                  ((bhr)localObject).ufz = new avu().OU(k.this.hGf);
                }
              }
            });
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
          paramAnonymousString = null;
          if (!bf.bm(paramAnonymouskeep_SceneResult.field_sKeyrespbuf)) {
            paramAnonymousString = new bhs();
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
            h.fX((int)k.this.hGc);
            h.fW((int)k.this.hGc);
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            String str = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult == null)
            {
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              localObject = com.tencent.mm.plugin.report.service.g.oSF;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
              l1 = k.this.startTime;
              l2 = bf.NA();
              i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
              j = k.this.hGg;
              k = paramAnonymouskeep_SceneResult.field_fileLength;
              str = paramAnonymouskeep_SceneResult.field_transInfo;
              if (paramAnonymouskeep_SceneResult != null) {
                continue;
              }
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              if ((paramAnonymousString == null) || (paramAnonymousString.tXs.tgr == 0)) {
                continue;
              }
              k.this.gUt.a(4, paramAnonymousString.tXs.tgr, paramAnonymousString.tXs.tgX.toString(), k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
            }
          }
          catch (IOException paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
          }
          catch (a.a.a.b paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
            continue;
          }
          label1443:
          v.i(k.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_needSendMsgField) });
          paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
          if (((d)localObject).cFR == 0)
          {
            paramAnonymousInt = 3;
            label1496:
            paramAnonymousString.i(13230, new Object[] { Integer.valueOf(paramAnonymousInt), k.this.hGu, Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType) });
            paramAnonymousString = k.this.hGA;
            if (!bf.mA(paramAnonymousString)) {
              break label1913;
            }
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + paramAnonymouskeep_SceneResult.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymouskeep_SceneResult.field_midimgLength != 0) {
              break label1904;
            }
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
            label1701:
            paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>";
            v.i(k.this.TAG, "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            label1751:
            paramAnonymouskeep_ProgressInfo = paramAnonymousString;
            if (paramAnonymouskeep_SceneResult.isUploadBySafeCDNWithMD5())
            {
              if (!bf.mA(k.this.hGE)) {
                break label2401;
              }
              v.w(k.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
          }
          for (paramAnonymouskeep_ProgressInfo = paramAnonymousString;; paramAnonymouskeep_ProgressInfo = paramAnonymousString + "length=\"" + paramAnonymouskeep_SceneResult.field_midimgLength + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
          {
            ((d)localObject).js(paramAnonymouskeep_ProgressInfo);
            if (k.this.hGc != k.this.gUY) {
              k.this.GI().js(paramAnonymouskeep_ProgressInfo);
            }
            if (!paramAnonymouskeep_SceneResult.field_needSendMsgField) {
              break label2562;
            }
            com.tencent.mm.kernel.h.vH().gXs.a(new l(k.this.gUZ, (bhr)k.this.gUq.hrS.hsa, (d)localObject, paramAnonymouskeep_SceneResult, new l.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                GMTrace.i(3541066317824L, 26383);
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
                v.i(k.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  h.fX((int)k.this.hGc);
                  h.fW((int)k.this.hGc);
                  k.this.gUt.a(paramAnonymous2Int2, paramAnonymous2Int3, "", k.this);
                  if (k.this.hGz != null) {
                    k.this.hGz.GG();
                  }
                  GMTrace.o(3541066317824L, 26383);
                  return;
                }
                k.this.a(localObject, localObject.hrb, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymouskeep_SceneResult);
                GMTrace.o(3541066317824L, 26383);
              }
            }), 0);
            break;
            paramAnonymousInt = ((d)localObject).cFR;
            break label1496;
            label1904:
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
            break label1701;
            label1913:
            paramAnonymouskeep_ProgressInfo = bg.q(paramAnonymousString, "msg");
            if (paramAnonymouskeep_ProgressInfo == null) {
              break label1751;
            }
            if (((d)localObject).hEK == 0)
            {
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnbigimgurl") + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
              paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
              if (paramAnonymouskeep_SceneResult.field_midimgLength == 0) {
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
              }
            }
            label2119:
            for (paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$hdlength") + "\"/></msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
            {
              v.i(k.this.TAG, "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
              break;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
              break label2119;
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
            }
            label2401:
            paramAnonymousString = "<msg><img aeskey=\"" + k.this.hGE + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + k.this.hGE + "\" ";
          }
          label2562:
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
          paramAnonymousString = new bhs();
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            if (paramAnonymousString.tdE != 0L) {}
            for (l1 = paramAnonymousString.tdE;; l1 = paramAnonymousInt)
            {
              v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
              k.this.a((d)localObject, ((d)localObject).hrb, l1, paramAnonymousString.ofk, paramAnonymouskeep_SceneResult);
              k.this.gUt.a(0, 0, "", k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
              paramAnonymousInt = paramAnonymousString.tdw;
            }
            if (k.this.hGz == null) {
              continue;
            }
          }
          catch (IOException paramAnonymousString)
          {
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymousString) });
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
          }
          k.this.hGz.GG();
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(3506035490816L, 26122);
        Object localObject1 = (bhr)k.this.gUq.hrS.hsa;
        ih localih = new ih();
        localih.tlp = ((bhr)localObject1).ufz.tXF;
        localih.muu = ((bhr)localObject1).tdx.tXF;
        localih.mut = ((bhr)localObject1).tdy.tXF;
        localih.tlq = ((bhr)localObject1).ufG;
        localih.tlr = ((bhr)localObject1).ufH;
        localih.tcg = k.this.scene;
        localih.tlt = k.this.hGC;
        localih.tlu = k.this.fNS;
        localih.tlv = k.this.hGD;
        localih.tdC = ((bhr)localObject1).tdC;
        localih.tlA = k.this.hGv;
        localObject1 = k.this.GH();
        Object localObject2 = n.GT().m(((d)localObject1).hEH, "", "");
        com.tencent.mm.modelcdntran.g.En();
        localih.tlC = com.tencent.mm.modelcdntran.b.iL((String)localObject2);
        localih.tlD = ((d)localObject1).hEL;
        int i;
        label298:
        String str;
        if (localih.tlD <= 0)
        {
          if (k.this.gUZ == 4)
          {
            i = 2;
            localih.tlD = i;
          }
        }
        else {
          switch (k.this.gUZ)
          {
          case 3: 
          case 5: 
          default: 
            localih.teq = 2;
            if (localih.tlD == 3) {
              localih.teq = 4;
            }
            v.i(k.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localih.tlq), Integer.valueOf(localih.tlr), localih.tdC, localih.mut, localih.tlA, Long.valueOf(k.this.gUY), Long.valueOf(k.this.hEO), ((d)localObject1).hEH, localObject2, Integer.valueOf(localih.tlC), Integer.valueOf(localih.tlD), Integer.valueOf(localih.teq) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hrV = localih;
            paramAnonymousString.hrW = new bhs();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.hrU = 625;
            paramAnonymousString.hrX = 9;
            paramAnonymousString.hrY = 1000000009;
            localObject1 = paramAnonymousString.BE();
            localObject2 = k.c(k.this).Cc();
            str = k.this.TAG;
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).BY()))
        {
          v.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).BY())) {
            break label737;
          }
          if (!com.tencent.mm.y.r.a(((com.tencent.mm.network.c)localObject2).vc(), ((com.tencent.mm.network.c)localObject2).BX(), ((com.tencent.mm.network.c)localObject2).BZ(), ((com.tencent.mm.y.b)localObject1).BG(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).Ca())) {
            break label702;
          }
          v.d(k.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localih.tlp });
          GMTrace.o(3506035490816L, 26122);
          return;
          i = 1;
          break;
          localih.teq = 1;
          break label298;
          localih.teq = 3;
          break label298;
          localih.teq = 5;
          break label298;
        }
        label702:
        v.e(k.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
        return;
        label737:
        v.e(k.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(3506169708544L, 26123);
        PInt localPInt = new PInt();
        ii localii = new ii();
        try
        {
          paramAnonymousArrayOfByte = t.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.vH().gXs.hsI.Cc().vc(), localPInt, localii);
          v.i(k.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localii.tlA, localii.tlE, localii.tlp });
          k.this.hGE = localii.tlA;
          v.i(k.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          GMTrace.o(3506169708544L, 26123);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          v.e(k.this.TAG, "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          k.this.hGE = null;
          GMTrace.o(3506169708544L, 26123);
        }
        return null;
      }
    };
    this.gVg = false;
    v.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bf.bJP() });
    this.hGc = paramInt1;
    this.gUY = paramInt1;
    this.hEK = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hrV = new bhr();
    ((b.a)localObject1).hrW = new bhs();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).hrU = 110;
    ((b.a)localObject1).hrX = 9;
    ((b.a)localObject1).hrY = 1000000009;
    this.gUq = ((b.a)localObject1).BE();
    this.hGb = null;
    v.d(this.TAG, "FROM B SERVICE:" + this.hGc);
    if (!h.fV((int)this.hGc))
    {
      this.hGc = -1L;
      GMTrace.o(3549656252416L, 26447);
      return;
    }
    localObject1 = n.GT().b(Long.valueOf(this.hGc));
    this.hEO = ((d)localObject1).hEO;
    if (paramInt2 == 1)
    {
      this.gUY = ((d)localObject1).hEQ;
      localObject1 = n.GT().b(Long.valueOf(this.gUY));
    }
    for (;;)
    {
      Object localObject2 = n.GT().fU((int)((d)localObject1).hEG);
      if (localObject2 != null) {
        this.hEO = ((d)localObject2).hEO;
      }
      this.fCQ = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(this.hEO);
      if ((this.fCQ != null) && (this.fCQ.field_msgId != this.hEO))
      {
        v.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.hEO) });
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 206L, 1L, false);
        this.fCQ = null;
        GMTrace.o(3549656252416L, 26447);
        return;
      }
      if (this.fCQ != null)
      {
        localObject2 = (bhr)this.gUq.hrS.hsa;
        ((bhr)localObject2).tdx = new avu().OU(com.tencent.mm.u.m.xL());
        ((bhr)localObject2).tdy = new avu().OU(this.fCQ.field_talker);
        ((bhr)localObject2).tfe = ((d)localObject1).offset;
        ((bhr)localObject2).tfd = ((d)localObject1).hrb;
        ((bhr)localObject2).mrC = this.fCQ.field_type;
        ((bhr)localObject2).tEg = paramInt2;
        if (!com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext())) {
          break label735;
        }
      }
      label735:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((bhr)localObject2).tpX = paramInt1;
        ((bhr)localObject2).ubQ = ((d)localObject1).cFR;
        ((bhr)localObject2).tlD = ((d)localObject1).hEL;
        ((bhr)localObject2).tlD = ((d)localObject1).hEL;
        ((bhr)localObject2).ufG = this.fCQ.gxx;
        ((bhr)localObject2).ufH = this.fCQ.gxw;
        v.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((bhr)localObject2).ufG), Integer.valueOf(((bhr)localObject2).ufH) });
        v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((d)localObject1).cFR), Integer.valueOf(((bhr)localObject2).tlD) });
        if (((d)localObject1).offset == 0) {
          this.hGe = new com.tencent.mm.modelstat.g(110, true, ((d)localObject1).hrb);
        }
        GMTrace.o(3549656252416L, 26447);
        return;
      }
    }
  }
  
  public k(int paramInt1, int paramInt2, byte paramByte)
  {
    GMTrace.i(3549790470144L, 26448);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hGu = "";
    this.hGv = "";
    this.hGw = true;
    this.hGy = 16384;
    this.hEK = 0;
    this.fCQ = null;
    this.hGe = null;
    this.hGf = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.hGg = 0;
    this.hGz = new b(null);
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(3505901273088L, 26121);
        v.d(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.w(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          k.this.gUt.a(3, paramAnonymousInt, "", k.this);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          v.e(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt) });
          h.fX((int)k.this.hGc);
          h.fW((int)k.this.hGc);
          if (paramAnonymouskeep_SceneResult != null)
          {
            paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            localObject = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult != null) {
              break label428;
            }
          }
          label428:
          for (paramAnonymousString = "";; paramAnonymousString = k.jx(paramAnonymouskeep_SceneResult.report_Part2))
          {
            paramAnonymouskeep_ProgressInfo.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramAnonymousString });
            k.this.gUt.a(3, paramAnonymousInt, "", k.this);
            if (k.this.hGz != null) {
              k.this.hGz.GG();
            }
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
        }
        final Object localObject = k.this.GH();
        if ((localObject == null) || (((d)localObject).hEG != k.this.gUY))
        {
          com.tencent.mm.modelcdntran.g.Em().iP(k.this.hGf);
          v.e(k.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(k.this.gUY), k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          k.this.a((d)localObject, paramAnonymouskeep_ProgressInfo.field_finishedLength, 0L, 0, paramAnonymouskeep_SceneResult);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i(k.this.TAG, "dkupimg sceneResult:%s", new Object[] { paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1443;
          }
          v.e(k.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 44425)
          {
            v.w(k.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { k.this.hGf, Boolean.valueOf(k.this.hGw) });
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3557038227456L, 26502);
                k.this.hGw = false;
                k.this.startTime = 0L;
                k.this.startOffset = 0;
                Object localObject = k.this.GH();
                ((d)localObject).fM(0);
                k.this.fCQ.z(ay.gk(k.this.fCQ.field_talker));
                k.this.hGf = com.tencent.mm.modelcdntran.d.a("upimg", k.this.fCQ.field_createTime, k.this.fCQ.field_talker, k.this.fCQ.field_msgId + "_" + k.this.gUY + "_" + k.this.hEK);
                boolean bool = k.this.a((d)localObject, 0, 0L, 0, paramAnonymouskeep_SceneResult);
                localObject = (bhr)k.this.gUq.hrS.hsa;
                if (localObject == null) {
                  v.w(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  v.i(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(k.this.hGw), Boolean.valueOf(bool), k.this.hGf, Long.valueOf(k.this.fCQ.field_createTime) });
                  k.this.a(k.b(k.this), k.this.gUt);
                  GMTrace.o(3557038227456L, 26502);
                  return;
                  ((bhr)localObject).ufz = new avu().OU(k.this.hGf);
                }
              }
            });
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
          paramAnonymousString = null;
          if (!bf.bm(paramAnonymouskeep_SceneResult.field_sKeyrespbuf)) {
            paramAnonymousString = new bhs();
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
            h.fX((int)k.this.hGc);
            h.fW((int)k.this.hGc);
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            String str = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult == null)
            {
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              localObject = com.tencent.mm.plugin.report.service.g.oSF;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
              l1 = k.this.startTime;
              l2 = bf.NA();
              i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
              j = k.this.hGg;
              k = paramAnonymouskeep_SceneResult.field_fileLength;
              str = paramAnonymouskeep_SceneResult.field_transInfo;
              if (paramAnonymouskeep_SceneResult != null) {
                continue;
              }
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              if ((paramAnonymousString == null) || (paramAnonymousString.tXs.tgr == 0)) {
                continue;
              }
              k.this.gUt.a(4, paramAnonymousString.tXs.tgr, paramAnonymousString.tXs.tgX.toString(), k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
            }
          }
          catch (IOException paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
          }
          catch (a.a.a.b paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
            continue;
          }
          label1443:
          v.i(k.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_needSendMsgField) });
          paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
          if (((d)localObject).cFR == 0)
          {
            paramAnonymousInt = 3;
            label1496:
            paramAnonymousString.i(13230, new Object[] { Integer.valueOf(paramAnonymousInt), k.this.hGu, Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType) });
            paramAnonymousString = k.this.hGA;
            if (!bf.mA(paramAnonymousString)) {
              break label1913;
            }
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + paramAnonymouskeep_SceneResult.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymouskeep_SceneResult.field_midimgLength != 0) {
              break label1904;
            }
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
            label1701:
            paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>";
            v.i(k.this.TAG, "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            label1751:
            paramAnonymouskeep_ProgressInfo = paramAnonymousString;
            if (paramAnonymouskeep_SceneResult.isUploadBySafeCDNWithMD5())
            {
              if (!bf.mA(k.this.hGE)) {
                break label2401;
              }
              v.w(k.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
          }
          for (paramAnonymouskeep_ProgressInfo = paramAnonymousString;; paramAnonymouskeep_ProgressInfo = paramAnonymousString + "length=\"" + paramAnonymouskeep_SceneResult.field_midimgLength + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
          {
            ((d)localObject).js(paramAnonymouskeep_ProgressInfo);
            if (k.this.hGc != k.this.gUY) {
              k.this.GI().js(paramAnonymouskeep_ProgressInfo);
            }
            if (!paramAnonymouskeep_SceneResult.field_needSendMsgField) {
              break label2562;
            }
            com.tencent.mm.kernel.h.vH().gXs.a(new l(k.this.gUZ, (bhr)k.this.gUq.hrS.hsa, (d)localObject, paramAnonymouskeep_SceneResult, new l.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                GMTrace.i(3541066317824L, 26383);
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
                v.i(k.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  h.fX((int)k.this.hGc);
                  h.fW((int)k.this.hGc);
                  k.this.gUt.a(paramAnonymous2Int2, paramAnonymous2Int3, "", k.this);
                  if (k.this.hGz != null) {
                    k.this.hGz.GG();
                  }
                  GMTrace.o(3541066317824L, 26383);
                  return;
                }
                k.this.a(localObject, localObject.hrb, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymouskeep_SceneResult);
                GMTrace.o(3541066317824L, 26383);
              }
            }), 0);
            break;
            paramAnonymousInt = ((d)localObject).cFR;
            break label1496;
            label1904:
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
            break label1701;
            label1913:
            paramAnonymouskeep_ProgressInfo = bg.q(paramAnonymousString, "msg");
            if (paramAnonymouskeep_ProgressInfo == null) {
              break label1751;
            }
            if (((d)localObject).hEK == 0)
            {
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnbigimgurl") + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
              paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
              if (paramAnonymouskeep_SceneResult.field_midimgLength == 0) {
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
              }
            }
            label2119:
            for (paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$hdlength") + "\"/></msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
            {
              v.i(k.this.TAG, "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
              break;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
              break label2119;
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
            }
            label2401:
            paramAnonymousString = "<msg><img aeskey=\"" + k.this.hGE + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + k.this.hGE + "\" ";
          }
          label2562:
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
          paramAnonymousString = new bhs();
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            if (paramAnonymousString.tdE != 0L) {}
            for (l1 = paramAnonymousString.tdE;; l1 = paramAnonymousInt)
            {
              v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
              k.this.a((d)localObject, ((d)localObject).hrb, l1, paramAnonymousString.ofk, paramAnonymouskeep_SceneResult);
              k.this.gUt.a(0, 0, "", k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
              paramAnonymousInt = paramAnonymousString.tdw;
            }
            if (k.this.hGz == null) {
              continue;
            }
          }
          catch (IOException paramAnonymousString)
          {
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymousString) });
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
          }
          k.this.hGz.GG();
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(3506035490816L, 26122);
        Object localObject1 = (bhr)k.this.gUq.hrS.hsa;
        ih localih = new ih();
        localih.tlp = ((bhr)localObject1).ufz.tXF;
        localih.muu = ((bhr)localObject1).tdx.tXF;
        localih.mut = ((bhr)localObject1).tdy.tXF;
        localih.tlq = ((bhr)localObject1).ufG;
        localih.tlr = ((bhr)localObject1).ufH;
        localih.tcg = k.this.scene;
        localih.tlt = k.this.hGC;
        localih.tlu = k.this.fNS;
        localih.tlv = k.this.hGD;
        localih.tdC = ((bhr)localObject1).tdC;
        localih.tlA = k.this.hGv;
        localObject1 = k.this.GH();
        Object localObject2 = n.GT().m(((d)localObject1).hEH, "", "");
        com.tencent.mm.modelcdntran.g.En();
        localih.tlC = com.tencent.mm.modelcdntran.b.iL((String)localObject2);
        localih.tlD = ((d)localObject1).hEL;
        int i;
        label298:
        String str;
        if (localih.tlD <= 0)
        {
          if (k.this.gUZ == 4)
          {
            i = 2;
            localih.tlD = i;
          }
        }
        else {
          switch (k.this.gUZ)
          {
          case 3: 
          case 5: 
          default: 
            localih.teq = 2;
            if (localih.tlD == 3) {
              localih.teq = 4;
            }
            v.i(k.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localih.tlq), Integer.valueOf(localih.tlr), localih.tdC, localih.mut, localih.tlA, Long.valueOf(k.this.gUY), Long.valueOf(k.this.hEO), ((d)localObject1).hEH, localObject2, Integer.valueOf(localih.tlC), Integer.valueOf(localih.tlD), Integer.valueOf(localih.teq) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hrV = localih;
            paramAnonymousString.hrW = new bhs();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.hrU = 625;
            paramAnonymousString.hrX = 9;
            paramAnonymousString.hrY = 1000000009;
            localObject1 = paramAnonymousString.BE();
            localObject2 = k.c(k.this).Cc();
            str = k.this.TAG;
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).BY()))
        {
          v.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).BY())) {
            break label737;
          }
          if (!com.tencent.mm.y.r.a(((com.tencent.mm.network.c)localObject2).vc(), ((com.tencent.mm.network.c)localObject2).BX(), ((com.tencent.mm.network.c)localObject2).BZ(), ((com.tencent.mm.y.b)localObject1).BG(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).Ca())) {
            break label702;
          }
          v.d(k.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localih.tlp });
          GMTrace.o(3506035490816L, 26122);
          return;
          i = 1;
          break;
          localih.teq = 1;
          break label298;
          localih.teq = 3;
          break label298;
          localih.teq = 5;
          break label298;
        }
        label702:
        v.e(k.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
        return;
        label737:
        v.e(k.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(3506169708544L, 26123);
        PInt localPInt = new PInt();
        ii localii = new ii();
        try
        {
          paramAnonymousArrayOfByte = t.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.vH().gXs.hsI.Cc().vc(), localPInt, localii);
          v.i(k.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localii.tlA, localii.tlE, localii.tlp });
          k.this.hGE = localii.tlA;
          v.i(k.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          GMTrace.o(3506169708544L, 26123);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          v.e(k.this.TAG, "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          k.this.hGE = null;
          GMTrace.o(3506169708544L, 26123);
        }
        return null;
      }
    };
    this.gVg = false;
    v.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, bf.bJP() });
    this.hGc = paramInt1;
    this.gUY = paramInt1;
    this.hEK = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hrV = new bhr();
    ((b.a)localObject1).hrW = new bhs();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).hrU = 110;
    ((b.a)localObject1).hrX = 9;
    ((b.a)localObject1).hrY = 1000000009;
    this.gUq = ((b.a)localObject1).BE();
    this.hGb = null;
    v.d(this.TAG, "FROM C SERVICE:" + this.hGc);
    if (!h.fV((int)this.hGc))
    {
      this.hGc = -1L;
      GMTrace.o(3549790470144L, 26448);
      return;
    }
    localObject1 = n.GT().b(Long.valueOf(this.hGc));
    this.hEO = ((d)localObject1).hEO;
    ((d)localObject1).dv(0);
    ((d)localObject1).y(0L);
    ((d)localObject1).setOffset(0);
    n.GT().a((int)this.gUY, (d)localObject1);
    if (paramInt2 == 1)
    {
      this.gUY = ((d)localObject1).hEQ;
      localObject1 = n.GT().b(Long.valueOf(this.gUY));
    }
    for (;;)
    {
      this.fCQ = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(this.hEO);
      Object localObject2;
      if (this.fCQ != null)
      {
        this.fCQ.dv(1);
        localObject2 = ((d)localObject1).hEJ;
        if ((localObject2 == null) || (!((String)localObject2).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label748;
        }
        this.fCQ.cI((String)localObject2);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.hEO, this.fCQ);
        localObject2 = (bhr)this.gUq.hrS.hsa;
        ((bhr)localObject2).tdx = new avu().OU(com.tencent.mm.u.m.xL());
        ((bhr)localObject2).tdy = new avu().OU(this.fCQ.field_talker);
        ((bhr)localObject2).tfe = ((d)localObject1).offset;
        ((bhr)localObject2).tfd = ((d)localObject1).hrb;
        ((bhr)localObject2).mrC = this.fCQ.field_type;
        ((bhr)localObject2).tEg = paramInt2;
        if (!com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext())) {
          break label779;
        }
      }
      label748:
      label779:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((bhr)localObject2).tpX = paramInt1;
        ((bhr)localObject2).ubQ = ((d)localObject1).cFR;
        ((bhr)localObject2).tlD = ((d)localObject1).hEL;
        ((bhr)localObject2).ufG = this.fCQ.gxx;
        ((bhr)localObject2).ufH = this.fCQ.gxw;
        v.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((bhr)localObject2).ufG), Integer.valueOf(((bhr)localObject2).ufH) });
        v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((d)localObject1).cFR), Integer.valueOf(((bhr)localObject2).tlD) });
        if (((d)localObject1).offset == 0) {
          this.hGe = new com.tencent.mm.modelstat.g(110, true, ((d)localObject1).hrb);
        }
        GMTrace.o(3549790470144L, 26448);
        return;
        this.fCQ.cI("THUMBNAIL://" + ((d)localObject1).hEG);
        break;
      }
    }
  }
  
  public k(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.y.f paramf, int paramInt3, a parama, int paramInt4)
  {
    this(3, paramString1, paramString2, paramString3, paramInt2, paramf, paramInt3, "", "", true, paramInt4);
    GMTrace.i(3548850946048L, 26441);
    this.hGz = new b(parama);
    GMTrace.o(3548850946048L, 26441);
  }
  
  public k(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.y.f paramf, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramf, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, 0, -1000.0F, -1000.0F);
    GMTrace.i(3549119381504L, 26443);
    GMTrace.o(3549119381504L, 26443);
  }
  
  public k(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.y.f paramf, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3549253599232L, 26444);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hGu = "";
    this.hGv = "";
    this.hGw = true;
    this.hGy = 16384;
    this.hEK = 0;
    this.fCQ = null;
    this.hGe = null;
    this.hGf = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.hGg = 0;
    this.hGz = new b(null);
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(3505901273088L, 26121);
        v.d(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.w(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          k.this.gUt.a(3, paramAnonymousInt, "", k.this);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          v.e(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt) });
          h.fX((int)k.this.hGc);
          h.fW((int)k.this.hGc);
          if (paramAnonymouskeep_SceneResult != null)
          {
            paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            localObject = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult != null) {
              break label428;
            }
          }
          label428:
          for (paramAnonymousString = "";; paramAnonymousString = k.jx(paramAnonymouskeep_SceneResult.report_Part2))
          {
            paramAnonymouskeep_ProgressInfo.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramAnonymousString });
            k.this.gUt.a(3, paramAnonymousInt, "", k.this);
            if (k.this.hGz != null) {
              k.this.hGz.GG();
            }
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
        }
        final Object localObject = k.this.GH();
        if ((localObject == null) || (((d)localObject).hEG != k.this.gUY))
        {
          com.tencent.mm.modelcdntran.g.Em().iP(k.this.hGf);
          v.e(k.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(k.this.gUY), k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          k.this.a((d)localObject, paramAnonymouskeep_ProgressInfo.field_finishedLength, 0L, 0, paramAnonymouskeep_SceneResult);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i(k.this.TAG, "dkupimg sceneResult:%s", new Object[] { paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1443;
          }
          v.e(k.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 44425)
          {
            v.w(k.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { k.this.hGf, Boolean.valueOf(k.this.hGw) });
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3557038227456L, 26502);
                k.this.hGw = false;
                k.this.startTime = 0L;
                k.this.startOffset = 0;
                Object localObject = k.this.GH();
                ((d)localObject).fM(0);
                k.this.fCQ.z(ay.gk(k.this.fCQ.field_talker));
                k.this.hGf = com.tencent.mm.modelcdntran.d.a("upimg", k.this.fCQ.field_createTime, k.this.fCQ.field_talker, k.this.fCQ.field_msgId + "_" + k.this.gUY + "_" + k.this.hEK);
                boolean bool = k.this.a((d)localObject, 0, 0L, 0, paramAnonymouskeep_SceneResult);
                localObject = (bhr)k.this.gUq.hrS.hsa;
                if (localObject == null) {
                  v.w(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  v.i(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(k.this.hGw), Boolean.valueOf(bool), k.this.hGf, Long.valueOf(k.this.fCQ.field_createTime) });
                  k.this.a(k.b(k.this), k.this.gUt);
                  GMTrace.o(3557038227456L, 26502);
                  return;
                  ((bhr)localObject).ufz = new avu().OU(k.this.hGf);
                }
              }
            });
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
          paramAnonymousString = null;
          if (!bf.bm(paramAnonymouskeep_SceneResult.field_sKeyrespbuf)) {
            paramAnonymousString = new bhs();
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
            h.fX((int)k.this.hGc);
            h.fW((int)k.this.hGc);
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            String str = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult == null)
            {
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              localObject = com.tencent.mm.plugin.report.service.g.oSF;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
              l1 = k.this.startTime;
              l2 = bf.NA();
              i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
              j = k.this.hGg;
              k = paramAnonymouskeep_SceneResult.field_fileLength;
              str = paramAnonymouskeep_SceneResult.field_transInfo;
              if (paramAnonymouskeep_SceneResult != null) {
                continue;
              }
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              if ((paramAnonymousString == null) || (paramAnonymousString.tXs.tgr == 0)) {
                continue;
              }
              k.this.gUt.a(4, paramAnonymousString.tXs.tgr, paramAnonymousString.tXs.tgX.toString(), k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
            }
          }
          catch (IOException paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
          }
          catch (a.a.a.b paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
            continue;
          }
          label1443:
          v.i(k.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_needSendMsgField) });
          paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
          if (((d)localObject).cFR == 0)
          {
            paramAnonymousInt = 3;
            label1496:
            paramAnonymousString.i(13230, new Object[] { Integer.valueOf(paramAnonymousInt), k.this.hGu, Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType) });
            paramAnonymousString = k.this.hGA;
            if (!bf.mA(paramAnonymousString)) {
              break label1913;
            }
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + paramAnonymouskeep_SceneResult.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymouskeep_SceneResult.field_midimgLength != 0) {
              break label1904;
            }
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
            label1701:
            paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>";
            v.i(k.this.TAG, "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            label1751:
            paramAnonymouskeep_ProgressInfo = paramAnonymousString;
            if (paramAnonymouskeep_SceneResult.isUploadBySafeCDNWithMD5())
            {
              if (!bf.mA(k.this.hGE)) {
                break label2401;
              }
              v.w(k.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
          }
          for (paramAnonymouskeep_ProgressInfo = paramAnonymousString;; paramAnonymouskeep_ProgressInfo = paramAnonymousString + "length=\"" + paramAnonymouskeep_SceneResult.field_midimgLength + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
          {
            ((d)localObject).js(paramAnonymouskeep_ProgressInfo);
            if (k.this.hGc != k.this.gUY) {
              k.this.GI().js(paramAnonymouskeep_ProgressInfo);
            }
            if (!paramAnonymouskeep_SceneResult.field_needSendMsgField) {
              break label2562;
            }
            com.tencent.mm.kernel.h.vH().gXs.a(new l(k.this.gUZ, (bhr)k.this.gUq.hrS.hsa, (d)localObject, paramAnonymouskeep_SceneResult, new l.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                GMTrace.i(3541066317824L, 26383);
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
                v.i(k.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  h.fX((int)k.this.hGc);
                  h.fW((int)k.this.hGc);
                  k.this.gUt.a(paramAnonymous2Int2, paramAnonymous2Int3, "", k.this);
                  if (k.this.hGz != null) {
                    k.this.hGz.GG();
                  }
                  GMTrace.o(3541066317824L, 26383);
                  return;
                }
                k.this.a(localObject, localObject.hrb, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymouskeep_SceneResult);
                GMTrace.o(3541066317824L, 26383);
              }
            }), 0);
            break;
            paramAnonymousInt = ((d)localObject).cFR;
            break label1496;
            label1904:
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
            break label1701;
            label1913:
            paramAnonymouskeep_ProgressInfo = bg.q(paramAnonymousString, "msg");
            if (paramAnonymouskeep_ProgressInfo == null) {
              break label1751;
            }
            if (((d)localObject).hEK == 0)
            {
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnbigimgurl") + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
              paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
              if (paramAnonymouskeep_SceneResult.field_midimgLength == 0) {
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
              }
            }
            label2119:
            for (paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$hdlength") + "\"/></msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
            {
              v.i(k.this.TAG, "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
              break;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
              break label2119;
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
            }
            label2401:
            paramAnonymousString = "<msg><img aeskey=\"" + k.this.hGE + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + k.this.hGE + "\" ";
          }
          label2562:
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
          paramAnonymousString = new bhs();
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            if (paramAnonymousString.tdE != 0L) {}
            for (l1 = paramAnonymousString.tdE;; l1 = paramAnonymousInt)
            {
              v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
              k.this.a((d)localObject, ((d)localObject).hrb, l1, paramAnonymousString.ofk, paramAnonymouskeep_SceneResult);
              k.this.gUt.a(0, 0, "", k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
              paramAnonymousInt = paramAnonymousString.tdw;
            }
            if (k.this.hGz == null) {
              continue;
            }
          }
          catch (IOException paramAnonymousString)
          {
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymousString) });
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
          }
          k.this.hGz.GG();
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(3506035490816L, 26122);
        Object localObject1 = (bhr)k.this.gUq.hrS.hsa;
        ih localih = new ih();
        localih.tlp = ((bhr)localObject1).ufz.tXF;
        localih.muu = ((bhr)localObject1).tdx.tXF;
        localih.mut = ((bhr)localObject1).tdy.tXF;
        localih.tlq = ((bhr)localObject1).ufG;
        localih.tlr = ((bhr)localObject1).ufH;
        localih.tcg = k.this.scene;
        localih.tlt = k.this.hGC;
        localih.tlu = k.this.fNS;
        localih.tlv = k.this.hGD;
        localih.tdC = ((bhr)localObject1).tdC;
        localih.tlA = k.this.hGv;
        localObject1 = k.this.GH();
        Object localObject2 = n.GT().m(((d)localObject1).hEH, "", "");
        com.tencent.mm.modelcdntran.g.En();
        localih.tlC = com.tencent.mm.modelcdntran.b.iL((String)localObject2);
        localih.tlD = ((d)localObject1).hEL;
        int i;
        label298:
        String str;
        if (localih.tlD <= 0)
        {
          if (k.this.gUZ == 4)
          {
            i = 2;
            localih.tlD = i;
          }
        }
        else {
          switch (k.this.gUZ)
          {
          case 3: 
          case 5: 
          default: 
            localih.teq = 2;
            if (localih.tlD == 3) {
              localih.teq = 4;
            }
            v.i(k.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localih.tlq), Integer.valueOf(localih.tlr), localih.tdC, localih.mut, localih.tlA, Long.valueOf(k.this.gUY), Long.valueOf(k.this.hEO), ((d)localObject1).hEH, localObject2, Integer.valueOf(localih.tlC), Integer.valueOf(localih.tlD), Integer.valueOf(localih.teq) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hrV = localih;
            paramAnonymousString.hrW = new bhs();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.hrU = 625;
            paramAnonymousString.hrX = 9;
            paramAnonymousString.hrY = 1000000009;
            localObject1 = paramAnonymousString.BE();
            localObject2 = k.c(k.this).Cc();
            str = k.this.TAG;
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).BY()))
        {
          v.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).BY())) {
            break label737;
          }
          if (!com.tencent.mm.y.r.a(((com.tencent.mm.network.c)localObject2).vc(), ((com.tencent.mm.network.c)localObject2).BX(), ((com.tencent.mm.network.c)localObject2).BZ(), ((com.tencent.mm.y.b)localObject1).BG(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).Ca())) {
            break label702;
          }
          v.d(k.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localih.tlp });
          GMTrace.o(3506035490816L, 26122);
          return;
          i = 1;
          break;
          localih.teq = 1;
          break label298;
          localih.teq = 3;
          break label298;
          localih.teq = 5;
          break label298;
        }
        label702:
        v.e(k.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
        return;
        label737:
        v.e(k.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(3506169708544L, 26123);
        PInt localPInt = new PInt();
        ii localii = new ii();
        try
        {
          paramAnonymousArrayOfByte = t.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.vH().gXs.hsI.Cc().vc(), localPInt, localii);
          v.i(k.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localii.tlA, localii.tlE, localii.tlp });
          k.this.hGE = localii.tlA;
          v.i(k.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          GMTrace.o(3506169708544L, 26123);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          v.e(k.this.TAG, "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          k.this.hGE = null;
          GMTrace.o(3506169708544L, 26123);
        }
        return null;
      }
    };
    this.gVg = false;
    v.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramf, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Boolean.valueOf(true), bf.bJP(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.hGB = paramBoolean;
    this.hGj = paramInt4;
    this.hGb = paramf;
    this.hEK = paramInt2;
    this.scene = paramInt5;
    this.fNS = paramFloat2;
    this.hGC = paramFloat1;
    this.gUZ = paramInt1;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.hGA = paramString4;
    localPString.value = paramString5;
    this.hGc = n.GT().a(paramString3, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
    this.gUY = this.hGc;
    v.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.hGc);
    if ((this.hGc < 0L) || (!h.fV((int)this.hGc)))
    {
      v.e(this.TAG, "insert to img storage failed id:" + this.hGc);
      this.hEO = -1L;
      this.gUq = null;
      GMTrace.o(3549253599232L, 26444);
      return;
    }
    if (this.hGc >= 0L)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      paramString3 = new b.a();
      paramString3.hrV = new bhr();
      paramString3.hrW = new bhs();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.hrU = 110;
      paramString3.hrX = 9;
      paramString3.hrY = 1000000009;
      this.gUq = paramString3.BE();
      this.fUR = paramString2;
      this.fCQ = new au();
      this.fCQ.setType(o.fH(paramString2));
      this.fCQ.cH(paramString2);
      this.fCQ.dw(1);
      this.fCQ.dv(1);
      this.fCQ.cI(localPString.value);
      this.fCQ.dH(localPInt1.value);
      this.fCQ.dI(localPInt2.value);
      this.fCQ.z(ay.gk(this.fCQ.field_talker));
      a.a.qB().b(this.fCQ);
      this.hEO = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().L(this.fCQ);
      if (this.hEO < 0L) {
        break label1190;
      }
      paramBoolean = true;
      label704:
      Assert.assertTrue(paramBoolean);
      v.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hEO);
      paramString3 = GI();
      paramString3.ag((int)this.hEO);
      n.GT().a(Long.valueOf(this.hGc), paramString3);
      if (paramInt2 != 1) {
        break label1207;
      }
      this.gUY = paramString3.hEQ;
      paramString3 = GH();
    }
    label972:
    label1190:
    label1202:
    label1207:
    for (;;)
    {
      paramString3.fO(com.tencent.mm.a.e.aN(n.GT().m(paramString3.hEH, "", "")));
      n.GT().a(Long.valueOf(this.gUY), paramString3);
      v.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gUY + " img len = " + paramString3.hrb);
      paramString4 = (bhr)this.gUq.hrS.hsa;
      paramString4.tdx = new avu().OU(paramString1);
      paramString4.tdy = new avu().OU(paramString2);
      paramString4.tfe = paramString3.offset;
      paramString4.tfd = paramString3.hrb;
      paramString4.mrC = this.fCQ.field_type;
      paramString4.tEg = paramInt2;
      if (com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext()))
      {
        paramInt3 = 1;
        paramString4.tpX = paramInt3;
        paramString4.ubQ = paramString3.cFR;
        paramString4.tlD = paramString3.hEL;
        paramString4.ufG = localPInt2.value;
        paramString4.ufH = localPInt1.value;
        v.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString4.ufG), Integer.valueOf(paramString4.ufH) });
        if (paramString4.tlD == 0) {
          if (paramInt1 != 4) {
            break label1202;
          }
        }
      }
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        paramString4.tlD = paramInt1;
        v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.cFR), Integer.valueOf(paramString4.tlD) });
        if (paramString3.offset == 0) {
          this.hGe = new com.tencent.mm.modelstat.g(110, true, paramString3.hrb);
        }
        fY(paramInt2);
        if (paramf != null) {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3518920392704L, 26218);
              paramf.a(this.hGr, this.hyg, k.this);
              GMTrace.o(3518920392704L, 26218);
            }
          });
        }
        GMTrace.o(3549253599232L, 26444);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label704;
        paramInt3 = 2;
        break label972;
      }
    }
  }
  
  private k(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.y.f paramf, String paramString4, String paramString5)
  {
    this(4, paramString1, paramString2, paramString3, paramInt2, null, 0, paramString4, paramString5, false, -1);
    GMTrace.i(3548985163776L, 26442);
    GMTrace.o(3548985163776L, 26442);
  }
  
  public k(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.y.f paramf, int paramInt3, String paramString4, String paramString5, int paramInt4)
  {
    GMTrace.i(3549387816960L, 26445);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hGu = "";
    this.hGv = "";
    this.hGw = true;
    this.hGy = 16384;
    this.hEK = 0;
    this.fCQ = null;
    this.hGe = null;
    this.hGf = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.hGg = 0;
    this.hGz = new b(null);
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(3505901273088L, 26121);
        v.d(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult });
        if (paramAnonymousInt == 44531)
        {
          v.w(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          k.this.gUt.a(3, paramAnonymousInt, "", k.this);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          v.e(k.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymousInt) });
          h.fX((int)k.this.hGc);
          h.fW((int)k.this.hGc);
          if (paramAnonymouskeep_SceneResult != null)
          {
            paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            localObject = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult != null) {
              break label428;
            }
          }
          label428:
          for (paramAnonymousString = "";; paramAnonymousString = k.jx(paramAnonymouskeep_SceneResult.report_Part2))
          {
            paramAnonymouskeep_ProgressInfo.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramAnonymousString });
            k.this.gUt.a(3, paramAnonymousInt, "", k.this);
            if (k.this.hGz != null) {
              k.this.hGz.GG();
            }
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
        }
        final Object localObject = k.this.GH();
        if ((localObject == null) || (((d)localObject).hEG != k.this.gUY))
        {
          com.tencent.mm.modelcdntran.g.Em().iP(k.this.hGf);
          v.e(k.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(k.this.gUY), k.this.hGf });
          if (k.this.hGz != null) {
            k.this.hGz.GG();
          }
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          k.this.a((d)localObject, paramAnonymouskeep_ProgressInfo.field_finishedLength, 0L, 0, paramAnonymouskeep_SceneResult);
          GMTrace.o(3505901273088L, 26121);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i(k.this.TAG, "dkupimg sceneResult:%s", new Object[] { paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1443;
          }
          v.e(k.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramAnonymouskeep_SceneResult });
          if (paramAnonymouskeep_SceneResult.field_retCode == 44425)
          {
            v.w(k.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { k.this.hGf, Boolean.valueOf(k.this.hGw) });
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3557038227456L, 26502);
                k.this.hGw = false;
                k.this.startTime = 0L;
                k.this.startOffset = 0;
                Object localObject = k.this.GH();
                ((d)localObject).fM(0);
                k.this.fCQ.z(ay.gk(k.this.fCQ.field_talker));
                k.this.hGf = com.tencent.mm.modelcdntran.d.a("upimg", k.this.fCQ.field_createTime, k.this.fCQ.field_talker, k.this.fCQ.field_msgId + "_" + k.this.gUY + "_" + k.this.hEK);
                boolean bool = k.this.a((d)localObject, 0, 0L, 0, paramAnonymouskeep_SceneResult);
                localObject = (bhr)k.this.gUq.hrS.hsa;
                if (localObject == null) {
                  v.w(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  v.i(k.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(k.this.hGw), Boolean.valueOf(bool), k.this.hGf, Long.valueOf(k.this.fCQ.field_createTime) });
                  k.this.a(k.b(k.this), k.this.gUt);
                  GMTrace.o(3557038227456L, 26502);
                  return;
                  ((bhr)localObject).ufz = new avu().OU(k.this.hGf);
                }
              }
            });
            GMTrace.o(3505901273088L, 26121);
            return 0;
          }
          paramAnonymousString = null;
          if (!bf.bm(paramAnonymouskeep_SceneResult.field_sKeyrespbuf)) {
            paramAnonymousString = new bhs();
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
            h.fX((int)k.this.hGc);
            h.fW((int)k.this.hGc);
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
            l1 = k.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
            j = k.this.hGg;
            k = paramAnonymouskeep_SceneResult.field_fileLength;
            String str = paramAnonymouskeep_SceneResult.field_transInfo;
            if (paramAnonymouskeep_SceneResult == null)
            {
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              localObject = com.tencent.mm.plugin.report.service.g.oSF;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
              l1 = k.this.startTime;
              l2 = bf.NA();
              i = com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext());
              j = k.this.hGg;
              k = paramAnonymouskeep_SceneResult.field_fileLength;
              str = paramAnonymouskeep_SceneResult.field_transInfo;
              if (paramAnonymouskeep_SceneResult != null) {
                continue;
              }
              paramAnonymouskeep_ProgressInfo = "";
              ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
              if ((paramAnonymousString == null) || (paramAnonymousString.tXs.tgr == 0)) {
                continue;
              }
              k.this.gUt.a(4, paramAnonymousString.tXs.tgr, paramAnonymousString.tXs.tgX.toString(), k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
            }
          }
          catch (IOException paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
          }
          catch (a.a.a.b paramAnonymouskeep_ProgressInfo)
          {
            paramAnonymousString = null;
            v.e(k.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymouskeep_ProgressInfo });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymouskeep_ProgressInfo) });
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            paramAnonymouskeep_ProgressInfo = k.jx(paramAnonymouskeep_SceneResult.report_Part2);
            continue;
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
            continue;
          }
          label1443:
          v.i(k.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_needSendMsgField) });
          paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
          if (((d)localObject).cFR == 0)
          {
            paramAnonymousInt = 3;
            label1496:
            paramAnonymousString.i(13230, new Object[] { Integer.valueOf(paramAnonymousInt), k.this.hGu, Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType) });
            paramAnonymousString = k.this.hGA;
            if (!bf.mA(paramAnonymousString)) {
              break label1913;
            }
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymouskeep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + paramAnonymouskeep_SceneResult.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymouskeep_SceneResult.field_midimgLength != 0) {
              break label1904;
            }
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
            label1701:
            paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>";
            v.i(k.this.TAG, "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            label1751:
            paramAnonymouskeep_ProgressInfo = paramAnonymousString;
            if (paramAnonymouskeep_SceneResult.isUploadBySafeCDNWithMD5())
            {
              if (!bf.mA(k.this.hGE)) {
                break label2401;
              }
              v.w(k.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
          }
          for (paramAnonymouskeep_ProgressInfo = paramAnonymousString;; paramAnonymouskeep_ProgressInfo = paramAnonymousString + "length=\"" + paramAnonymouskeep_SceneResult.field_midimgLength + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
          {
            ((d)localObject).js(paramAnonymouskeep_ProgressInfo);
            if (k.this.hGc != k.this.gUY) {
              k.this.GI().js(paramAnonymouskeep_ProgressInfo);
            }
            if (!paramAnonymouskeep_SceneResult.field_needSendMsgField) {
              break label2562;
            }
            com.tencent.mm.kernel.h.vH().gXs.a(new l(k.this.gUZ, (bhr)k.this.gUq.hrS.hsa, (d)localObject, paramAnonymouskeep_SceneResult, new l.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                GMTrace.i(3541066317824L, 26383);
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
                v.i(k.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { k.this.hGf, Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  h.fX((int)k.this.hGc);
                  h.fW((int)k.this.hGc);
                  k.this.gUt.a(paramAnonymous2Int2, paramAnonymous2Int3, "", k.this);
                  if (k.this.hGz != null) {
                    k.this.hGz.GG();
                  }
                  GMTrace.o(3541066317824L, 26383);
                  return;
                }
                k.this.a(localObject, localObject.hrb, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymouskeep_SceneResult);
                GMTrace.o(3541066317824L, 26383);
              }
            }), 0);
            break;
            paramAnonymousInt = ((d)localObject).cFR;
            break label1496;
            label1904:
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
            break label1701;
            label1913:
            paramAnonymouskeep_ProgressInfo = bg.q(paramAnonymousString, "msg");
            if (paramAnonymouskeep_ProgressInfo == null) {
              break label1751;
            }
            if (((d)localObject).hEK == 0)
            {
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnbigimgurl") + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
              paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
              if (paramAnonymouskeep_SceneResult.field_midimgLength == 0) {
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_fileLength;
              }
            }
            label2119:
            for (paramAnonymousString = paramAnonymousInt + "\" hdlength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$hdlength") + "\"/></msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymouskeep_SceneResult.field_fileLength + "\"/></msg>")
            {
              v.i(k.this.TAG, "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
              break;
              paramAnonymousInt = paramAnonymouskeep_SceneResult.field_midimgLength;
              break label2119;
              paramAnonymousString = "<msg><img aeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)paramAnonymouskeep_ProgressInfo.get(".msg.img.cdnthumblength") + "\" ";
            }
            label2401:
            paramAnonymousString = "<msg><img aeskey=\"" + k.this.hGE + "\" cdnmidimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymouskeep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + k.this.hGE + "\" ";
          }
          label2562:
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(k.this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(k.this.hGg), Integer.valueOf(paramAnonymouskeep_SceneResult.field_fileLength), paramAnonymouskeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jx(paramAnonymouskeep_SceneResult.report_Part2) });
          paramAnonymousString = new bhs();
          try
          {
            paramAnonymousString.aD(paramAnonymouskeep_SceneResult.field_sKeyrespbuf);
            if (paramAnonymousString.tdE != 0L) {}
            for (l1 = paramAnonymousString.tdE;; l1 = paramAnonymousInt)
            {
              v.d(k.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tXs.tgr), paramAnonymousString.tXs.tgX.toString() });
              k.this.a((d)localObject, ((d)localObject).hrb, l1, paramAnonymousString.ofk, paramAnonymouskeep_SceneResult);
              k.this.gUt.a(0, 0, "", k.this);
              if (k.this.hGz != null) {
                k.this.hGz.GG();
              }
              GMTrace.o(3505901273088L, 26121);
              return 0;
              paramAnonymousInt = paramAnonymousString.tdw;
            }
            if (k.this.hGz == null) {
              continue;
            }
          }
          catch (IOException paramAnonymousString)
          {
            v.e(k.this.TAG, "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
            v.e(k.this.TAG, "exception:%s", new Object[] { bf.g(paramAnonymousString) });
            k.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", k.this);
          }
          k.this.hGz.GG();
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(3506035490816L, 26122);
        Object localObject1 = (bhr)k.this.gUq.hrS.hsa;
        ih localih = new ih();
        localih.tlp = ((bhr)localObject1).ufz.tXF;
        localih.muu = ((bhr)localObject1).tdx.tXF;
        localih.mut = ((bhr)localObject1).tdy.tXF;
        localih.tlq = ((bhr)localObject1).ufG;
        localih.tlr = ((bhr)localObject1).ufH;
        localih.tcg = k.this.scene;
        localih.tlt = k.this.hGC;
        localih.tlu = k.this.fNS;
        localih.tlv = k.this.hGD;
        localih.tdC = ((bhr)localObject1).tdC;
        localih.tlA = k.this.hGv;
        localObject1 = k.this.GH();
        Object localObject2 = n.GT().m(((d)localObject1).hEH, "", "");
        com.tencent.mm.modelcdntran.g.En();
        localih.tlC = com.tencent.mm.modelcdntran.b.iL((String)localObject2);
        localih.tlD = ((d)localObject1).hEL;
        int i;
        label298:
        String str;
        if (localih.tlD <= 0)
        {
          if (k.this.gUZ == 4)
          {
            i = 2;
            localih.tlD = i;
          }
        }
        else {
          switch (k.this.gUZ)
          {
          case 3: 
          case 5: 
          default: 
            localih.teq = 2;
            if (localih.tlD == 3) {
              localih.teq = 4;
            }
            v.i(k.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localih.tlq), Integer.valueOf(localih.tlr), localih.tdC, localih.mut, localih.tlA, Long.valueOf(k.this.gUY), Long.valueOf(k.this.hEO), ((d)localObject1).hEH, localObject2, Integer.valueOf(localih.tlC), Integer.valueOf(localih.tlD), Integer.valueOf(localih.teq) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hrV = localih;
            paramAnonymousString.hrW = new bhs();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.hrU = 625;
            paramAnonymousString.hrX = 9;
            paramAnonymousString.hrY = 1000000009;
            localObject1 = paramAnonymousString.BE();
            localObject2 = k.c(k.this).Cc();
            str = k.this.TAG;
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).BY()))
        {
          v.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).BY())) {
            break label737;
          }
          if (!com.tencent.mm.y.r.a(((com.tencent.mm.network.c)localObject2).vc(), ((com.tencent.mm.network.c)localObject2).BX(), ((com.tencent.mm.network.c)localObject2).BZ(), ((com.tencent.mm.y.b)localObject1).BG(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).Ca())) {
            break label702;
          }
          v.d(k.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localih.tlp });
          GMTrace.o(3506035490816L, 26122);
          return;
          i = 1;
          break;
          localih.teq = 1;
          break label298;
          localih.teq = 3;
          break label298;
          localih.teq = 5;
          break label298;
        }
        label702:
        v.e(k.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
        return;
        label737:
        v.e(k.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localih.tlp });
        GMTrace.o(3506035490816L, 26122);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(3506169708544L, 26123);
        PInt localPInt = new PInt();
        ii localii = new ii();
        try
        {
          paramAnonymousArrayOfByte = t.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.vH().gXs.hsI.Cc().vc(), localPInt, localii);
          v.i(k.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localii.tlA, localii.tlE, localii.tlp });
          k.this.hGE = localii.tlA;
          v.i(k.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          GMTrace.o(3506169708544L, 26123);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          v.e(k.this.TAG, "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          k.this.hGE = null;
          GMTrace.o(3506169708544L, 26123);
        }
        return null;
      }
    };
    this.gVg = false;
    v.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(3), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramf, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(true), Integer.valueOf(paramInt4), Boolean.valueOf(true), bf.bJP() });
    this.hGB = true;
    this.hGj = paramInt4;
    this.hGb = paramf;
    this.hEK = paramInt2;
    this.gUZ = 3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.hGA = paramString4;
    this.hGc = paramLong;
    this.gUY = this.hGc;
    paramString3 = GI();
    this.fCQ = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramString3.hEO);
    this.hEO = this.fCQ.field_msgId;
    localPInt.value = this.fCQ.gxx;
    paramString5.value = this.fCQ.gxw;
    if (paramInt2 == 1)
    {
      this.gUY = paramString3.hEQ;
      this.gVa = null;
      paramString3 = GH();
    }
    for (;;)
    {
      if (!this.fCQ.field_talker.equals(paramString2))
      {
        v.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.fCQ.field_talker });
        com.tencent.mm.plugin.report.service.g.oSF.a(594L, 4L, 1L, true);
      }
      for (paramString4 = this.fCQ.field_talker;; paramString4 = paramString2)
      {
        v.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fCQ.field_msgId);
        v.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.hGc);
        if ((this.hGc < 0L) || (!h.fV((int)this.hGc)))
        {
          v.e(this.TAG, "insert to img storage failed id:" + this.hGc);
          this.hEO = -1L;
          this.gUq = null;
          GMTrace.o(3549387816960L, 26445);
          return;
        }
        boolean bool;
        if (this.hGc >= 0L)
        {
          bool = true;
          Assert.assertTrue(bool);
          paramString2 = new b.a();
          paramString2.hrV = new bhr();
          paramString2.hrW = new bhs();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.hrU = 110;
          paramString2.hrX = 9;
          paramString2.hrY = 1000000009;
          this.gUq = paramString2.BE();
          v.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gUY + " img len = " + paramString3.hrb);
          paramString2 = (bhr)this.gUq.hrS.hsa;
          paramString2.tdx = new avu().OU(paramString1);
          paramString2.tdy = new avu().OU(paramString4);
          paramString2.tfe = paramString3.offset;
          paramString2.tfd = paramString3.hrb;
          paramString2.mrC = this.fCQ.field_type;
          paramString2.tEg = paramInt2;
          if (!com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext())) {
            break label1024;
          }
        }
        label1024:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString2.tpX = paramInt1;
          paramString2.ubQ = paramString3.cFR;
          paramString2.tlD = paramString3.hEL;
          paramString2.ufG = localPInt.value;
          paramString2.ufH = paramString5.value;
          v.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.ufG), Integer.valueOf(paramString2.ufH) });
          if (paramString2.tlD == 0) {
            paramString2.tlD = 1;
          }
          v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.cFR), Integer.valueOf(paramString2.tlD) });
          if (paramString3.offset == 0) {
            this.hGe = new com.tencent.mm.modelstat.g(110, true, paramString3.hrb);
          }
          if (paramf != null) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(3538247745536L, 26362);
                paramf.a(this.hGr, this.hyg, k.this);
                GMTrace.o(3538247745536L, 26362);
              }
            });
          }
          GMTrace.o(3549387816960L, 26445);
          return;
          bool = false;
          break;
        }
      }
    }
  }
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(4, paramString1, paramString2, paramString3, paramInt, null, "", "");
    GMTrace.i(3548716728320L, 26440);
    GMTrace.o(3548716728320L, 26440);
  }
  
  public static void al(long paramLong)
  {
    GMTrace.i(3550998429696L, 26457);
    hGF = paramLong;
    GMTrace.o(3550998429696L, 26457);
  }
  
  private int fZ(int paramInt)
  {
    GMTrace.i(3550193123328L, 26451);
    v.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.hGz != null) {
      this.hGz.GG();
    }
    GMTrace.o(3550193123328L, 26451);
    return -1;
  }
  
  public static String jx(String paramString)
  {
    GMTrace.i(3551132647424L, 26458);
    try
    {
      boolean bool = bf.mA(paramString);
      if (bool)
      {
        GMTrace.o(3551132647424L, 26458);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = hGF;
        hGF = -1L;
        localObject[19] = l;
        localObject = bf.c(bf.f((String[])localObject), ",");
        GMTrace.o(3551132647424L, 26458);
        return (String)localObject;
      }
      GMTrace.o(3551132647424L, 26458);
      return paramString;
    }
    catch (Exception localException)
    {
      GMTrace.o(3551132647424L, 26458);
    }
    return paramString;
  }
  
  public final d GH()
  {
    GMTrace.i(3548448292864L, 26438);
    if (this.gVa == null) {
      this.gVa = n.GT().b(Long.valueOf(this.gUY));
    }
    d locald = this.gVa;
    GMTrace.o(3548448292864L, 26438);
    return locald;
  }
  
  public final d GI()
  {
    GMTrace.i(3548582510592L, 26439);
    if (this.hGx == null) {
      this.hGx = n.GT().b(Long.valueOf(this.hGc));
    }
    d locald = this.hGx;
    GMTrace.o(3548582510592L, 26439);
    return locald;
  }
  
  public final void GJ()
  {
    GMTrace.i(3550729994240L, 26455);
    v.i(this.TAG, "send img from system");
    this.gVg = true;
    GMTrace.o(3550729994240L, 26455);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(3550058905600L, 26450);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().e(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3517578215424L, 26208);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ad("SendImgSpeeder");
        GMTrace.o(3517578215424L, 26208);
      }
    }, 100L);
    if (this.gUY < 0L)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 204L, 1L, false);
      v.e(this.TAG, "doScene invalid imgLocalId:" + this.gUY);
      i = fZ(-1);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    if (this.fCQ == null)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 203L, 1L, false);
      v.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.gUY) });
      h.fX((int)this.hGc);
      i = fZ(-2);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    this.gUt = parame1;
    c(parame);
    bhr localbhr = (bhr)this.gUq.hrS.hsa;
    d locald = GH();
    parame1 = n.GT().fU((int)locald.hEG);
    if (parame1 != null)
    {
      if (parame1.status == -1)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 202L, 1L, false);
        v.e(this.TAG, "doScene hd img info is null or error.");
        i = fZ(-3);
        GMTrace.o(3550058905600L, 26450);
        return i;
      }
    }
    else if ((locald == null) || (locald.status == -1))
    {
      v.e(this.TAG, "doScene img info is null or error.");
      i = fZ(-4);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    if (a.a.qB().dr(this.fCQ.field_talker)) {}
    String str1;
    String str2;
    for (localbhr.tdC = a.a.qB().c(this.fCQ);; localbhr.tdC = this.fCQ.gxv)
    {
      str1 = n.GT().m(locald.hEH, "", "");
      str2 = n.GT().m(locald.hEJ, "", "");
      parame1 = "";
      if (!bf.mA(locald.hEI)) {
        parame1 = n.GT().m(locald.hEI, "", "");
      }
      if ((com.tencent.mm.a.e.aN(str1) > 0) && (com.tencent.mm.a.e.aN(str2) > 0)) {
        break;
      }
      v.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.gUY), Integer.valueOf(com.tencent.mm.a.e.aN(str1)), Integer.valueOf(com.tencent.mm.a.e.aN(str2)), str1, str2 });
      i = fZ(-5);
      GMTrace.o(3550058905600L, 26450);
      return i;
      parame1 = ba.zz();
      if (((parame1 != null) && (!parame1.equals(this.fCQ.gxv))) || ((parame1 == null) && (!bf.mA(this.fCQ.gxv))))
      {
        this.fCQ.cN(parame1);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.fCQ.field_msgId, this.fCQ);
      }
    }
    Object localObject;
    if ((localbhr.ufz == null) || (bf.mA(localbhr.ufz.tXF)))
    {
      if (bf.mA(this.hGf))
      {
        v.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.fCQ.field_createTime), this.fCQ.field_talker, Long.valueOf(this.fCQ.field_msgId), Long.valueOf(this.gUY), Integer.valueOf(this.hEK) });
        this.hGf = com.tencent.mm.modelcdntran.d.a("upimg", this.fCQ.field_createTime, this.fCQ.field_talker, this.fCQ.field_msgId + "_" + this.gUY + "_" + this.hEK);
      }
      localbhr.ufz = new avu().OU(this.hGf);
      localObject = this.fCQ;
      ((ce)localObject).gxC = this.hGf;
      ((ce)localObject).gtq = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bf.NA();
      this.startOffset = locald.offset;
      if (this.hEK == 1)
      {
        i = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        this.hGg = i;
      }
    }
    else
    {
      v.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[] { str1, str2, locald.hEH });
      if (!o.fF(this.fCQ.field_talker)) {
        break label965;
      }
      v.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { this.fCQ.field_talker });
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label1721;
      }
      v.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localbhr.ufz.tXF });
      GMTrace.o(3550058905600L, 26450);
      return 0;
      i = com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
      break;
      label965:
      com.tencent.mm.modelcdntran.g.Em();
      if ((!com.tencent.mm.modelcdntran.c.fA(1)) && (bf.mA(locald.hER)))
      {
        parame1 = this.TAG;
        com.tencent.mm.modelcdntran.g.Em();
        v.w(parame1, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(1)), locald.hER });
        i = 0;
      }
      else if (bf.mA(this.hGf))
      {
        v.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gUY) });
        i = 0;
      }
      else
      {
        localObject = new com.tencent.mm.modelcdntran.h();
        ((com.tencent.mm.modelcdntran.h)localObject).hyM = this.hGp;
        ((com.tencent.mm.modelcdntran.h)localObject).field_mediaId = this.hGf;
        ((com.tencent.mm.modelcdntran.h)localObject).field_fullpath = str1;
        ((com.tencent.mm.modelcdntran.h)localObject).field_thumbpath = str2;
        ((com.tencent.mm.modelcdntran.h)localObject).field_fileType = this.hGg;
        ((com.tencent.mm.modelcdntran.h)localObject).field_talker = this.fCQ.field_talker;
        if (o.dH(this.fCQ.field_talker))
        {
          i = 1;
          label1146:
          ((com.tencent.mm.modelcdntran.h)localObject).field_chattype = i;
          ((com.tencent.mm.modelcdntran.h)localObject).field_priority = com.tencent.mm.modelcdntran.b.hxt;
          ((com.tencent.mm.modelcdntran.h)localObject).field_needStorage = false;
          ((com.tencent.mm.modelcdntran.h)localObject).field_isStreamMedia = false;
          ((com.tencent.mm.modelcdntran.h)localObject).field_sendmsg_viacdn = true;
          ((com.tencent.mm.modelcdntran.h)localObject).field_enable_hitcheck = this.hGw;
          ((com.tencent.mm.modelcdntran.h)localObject).field_midimgpath = parame1;
          ((com.tencent.mm.modelcdntran.h)localObject).field_force_aeskeycdn = false;
          ((com.tencent.mm.modelcdntran.h)localObject).field_trysafecdn = true;
          if ((((com.tencent.mm.modelcdntran.h)localObject).field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE) && (bf.mA(((com.tencent.mm.modelcdntran.h)localObject).field_midimgpath)))
          {
            com.tencent.mm.modelcdntran.g.Em();
            if (com.tencent.mm.modelcdntran.c.fA(256))
            {
              v.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
              ((com.tencent.mm.modelcdntran.h)localObject).field_force_aeskeycdn = true;
              ((com.tencent.mm.modelcdntran.h)localObject).field_trysafecdn = false;
            }
          }
          parame1 = bg.q(this.hGA, "msg");
          if (parame1 == null) {
            break label1661;
          }
          if (this.hEK == 1) {
            break label1614;
          }
          ((com.tencent.mm.modelcdntran.h)localObject).field_fileId = ((String)parame1.get(".msg.img.$cdnmidimgurl"));
          ((com.tencent.mm.modelcdntran.h)localObject).field_midFileLength = bf.getInt((String)parame1.get(".msg.img.$length"), 0);
          ((com.tencent.mm.modelcdntran.h)localObject).field_totalLen = 0;
          label1329:
          ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey = ((String)parame1.get(".msg.img.$aeskey"));
        }
        for (;;)
        {
          if (bf.mA(((com.tencent.mm.modelcdntran.h)localObject).field_aesKey))
          {
            com.tencent.mm.modelcdntran.g.En();
            ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey = com.tencent.mm.modelcdntran.b.Ee();
            v.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey });
          }
          v.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(locald.cFR), ((com.tencent.mm.modelcdntran.h)localObject).field_fileId });
          this.hGu = ((com.tencent.mm.modelcdntran.h)localObject).field_fileId;
          this.hGv = ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey;
          v.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.modelcdntran.h)localObject).field_enable_hitcheck), Integer.valueOf(((com.tencent.mm.modelcdntran.h)localObject).field_fileType), ((com.tencent.mm.modelcdntran.h)localObject).field_midimgpath, ((com.tencent.mm.modelcdntran.h)localObject).field_fullpath, ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey, ((com.tencent.mm.modelcdntran.h)localObject).field_fileId, Boolean.valueOf(((com.tencent.mm.modelcdntran.h)localObject).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.modelcdntran.h)localObject).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.modelcdntran.h)localObject).field_trysafecdn) });
          this.hGE = null;
          if (com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject)) {
            break label1686;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(111L, 205L, 1L, false);
          v.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.hGf });
          this.hGf = "";
          i = 0;
          break;
          i = 0;
          break label1146;
          label1614:
          ((com.tencent.mm.modelcdntran.h)localObject).field_fileId = ((String)parame1.get(".msg.img.$cdnbigimgurl"));
          ((com.tencent.mm.modelcdntran.h)localObject).field_midFileLength = bf.getInt((String)parame1.get(".msg.img.$length"), 0);
          ((com.tencent.mm.modelcdntran.h)localObject).field_totalLen = 0;
          break label1329;
          label1661:
          v.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { locald.hER });
        }
        label1686:
        if (bf.mz(locald.hER).length() <= 0)
        {
          locald.js("CDNINFO_SEND");
          locald.fRM = 4096;
        }
        i = 1;
      }
    }
    label1721:
    v.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
    int i = locald.hEP;
    if (i >= ub())
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 201L, 1L, false);
      v.e(this.TAG, "doScene limit net time:" + i);
      h.fX((int)this.hGc);
      i = fZ(-6);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    locald.fM(i + 1);
    locald.fRM = 512;
    n.GT().a(Long.valueOf(this.gUY), locald);
    int j = locald.hrb - locald.offset;
    i = j;
    if (j > this.hGy) {
      i = this.hGy;
    }
    if (com.tencent.mm.a.e.aN(str1) > 10485760)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 200L, 1L, false);
      v.e(this.TAG, "doScene, file size is too large");
      i = fZ(-7);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    parame1 = com.tencent.mm.a.e.c(str1, locald.offset, i);
    if ((parame1 == null) || (parame1.length <= 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 199L, 1L, false);
      v.e(this.TAG, "doScene, file read buf error.");
      i = fZ(-8);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    localbhr.tff = parame1.length;
    localbhr.tfe = locald.offset;
    localbhr.tqC = new avt().bb(parame1);
    if (this.hGe != null) {
      this.hGe.Kb();
    }
    i = a(parame, this.gUq, this);
    if (i < 0)
    {
      v.e(this.TAG, "doScene netId error");
      h.fX((int)this.hGc);
      i = fZ(-9);
      GMTrace.o(3550058905600L, 26450);
      return i;
    }
    GMTrace.o(3550058905600L, 26450);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(3549924687872L, 26449);
    int i = com.tencent.mm.y.k.b.hsC;
    GMTrace.o(3549924687872L, 26449);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(3550595776512L, 26454);
    paramp = (bhs)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hGf);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(3550595776512L, 26454);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 198L, 1L, false);
      h.fX((int)this.hGc);
      h.fW((int)this.hGc);
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(0) });
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      if (this.hGz != null) {
        this.hGz.GG();
      }
      GMTrace.o(3550595776512L, 26454);
      return;
    }
    this.hGy = paramp.tff;
    if (this.hGy > 16384) {
      this.hGy = 16384;
    }
    paramString = GH();
    v.v(this.TAG, "onGYNetEnd localId:" + this.gUY + "  totalLen:" + paramString.hrb + " offSet:" + paramString.offset);
    if ((paramp.tfe < 0) || ((paramp.tfe > paramString.hrb) && (paramString.hrb > 0)))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 197L, 1L, false);
      v.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramp.tfe + " img totalLen = " + paramString.hrb);
      h.fX((int)this.hGc);
      h.fW((int)this.hGc);
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(0) });
      this.gUt.a(4, -2, "", this);
      if (this.hGz != null) {
        this.hGz.GG();
      }
      GMTrace.o(3550595776512L, 26454);
      return;
    }
    if ((paramp.tfe < paramString.offset) || ((e.b(paramString)) && (this.hGy <= 0)))
    {
      v.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramp.tfe + " totalLen = " + paramString.hrb + " off:" + paramString.offset);
      h.fX((int)this.hGc);
      h.fW((int)this.hGc);
      this.gUt.a(4, -1, "", this);
      if (this.hGz != null) {
        this.hGz.GG();
      }
      GMTrace.o(3550595776512L, 26454);
      return;
    }
    v.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramp.tfe);
    if ((a(paramString, paramp.tfe, paramp.tdE, paramp.ofk, null)) && (a(this.hsm, this.gUt) < 0))
    {
      h.fW((int)this.hGc);
      this.gUt.a(3, -1, "", this);
      if (this.hGz != null) {
        this.hGz.GG();
      }
    }
    GMTrace.o(3550595776512L, 26454);
  }
  
  public final boolean a(d paramd, final int paramInt1, final long paramLong, int paramInt2, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(3550864211968L, 26456);
    v.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.hGf, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    v.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(com.tencent.mm.platformtools.r.iiD) });
    long l = paramLong;
    if (10007 == com.tencent.mm.platformtools.r.iiC)
    {
      l = paramLong;
      if (com.tencent.mm.platformtools.r.iiD != 0)
      {
        l = com.tencent.mm.platformtools.r.iiD;
        com.tencent.mm.platformtools.r.iiD = 0;
      }
    }
    paramLong = paramd.hEG;
    paramInt2 = paramd.hrb;
    if (this.hGb != null) {
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(16420465278976L, 122342);
          m localm = m.GK();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.hGJ;
          if (localm.hGN.containsKey(Long.valueOf(l1))) {}
          for (m.d locald = (m.d)localm.hGN.get(Long.valueOf(l1));; locald = new m.d())
          {
            locald.hHf = l3;
            locald.hHe = l2;
            localm.hGN.put(Long.valueOf(l1), locald);
            k.this.hGb.a(this.hGJ, paramInt1, k.this);
            GMTrace.o(16420465278976L, 122342);
            return;
          }
        }
      });
    }
    paramd.setOffset(paramInt1);
    paramd.y(l);
    if ((e.b(paramd)) && (this.hGc != this.gUY))
    {
      d locald = n.GT().b(Long.valueOf(this.hGc));
      locald.y(l);
      locald.fO(paramd.hrb);
      locald.setOffset(paramd.hrb);
      n.GT().a(Long.valueOf(this.hGc), locald);
    }
    if (e.b(paramd))
    {
      if (bf.mA(this.hGf)) {
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(paramd.hrb - this.startOffset) });
      }
      this.fCQ.dv(2);
      this.fCQ.y(l);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.hEO, this.fCQ);
      if (com.tencent.mm.modelstat.q.hXj != null) {
        com.tencent.mm.modelstat.q.hXj.f(this.fCQ);
      }
      h.fW((int)this.hGc);
      if (this.hGe != null) {
        this.hGe.ar(0L);
      }
      this.gUt.a(0, 0, "", this);
      if (q.hHJ != null) {
        q.hHJ.a(this.gUY, this.fCQ, this.gUq, this.gUZ, this.gVg, paramkeep_SceneResult);
      }
      if (this.hGz != null) {
        this.hGz.GG();
      }
      GMTrace.o(3550864211968L, 26456);
      return false;
    }
    GMTrace.o(3550864211968L, 26456);
    return true;
  }
  
  public final void ak(final long paramLong)
  {
    GMTrace.i(16021838626816L, 119372);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3518651957248L, 26216);
        m localm = m.GK();
        long l = paramLong;
        localm.hGN.remove(Long.valueOf(l));
        GMTrace.o(3518651957248L, 26216);
      }
    });
    GMTrace.o(16021838626816L, 119372);
  }
  
  public final void fY(int paramInt)
  {
    int i = 0;
    GMTrace.i(3549522034688L, 26446);
    if (this.fCQ == null)
    {
      v.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.hEO), Integer.valueOf(paramInt) });
      GMTrace.o(3549522034688L, 26446);
      return;
    }
    if (this.hGB)
    {
      if (this.fCQ.gxA == 0)
      {
        Object localObject = n.GT();
        au localau = this.fCQ;
        int j = this.hGj;
        String str = f.p(localau);
        if (!bf.mA(str)) {}
        for (boolean bool = ((f)localObject).a(str, localau.field_imgPath, j, paramInt);; bool = false)
        {
          localObject = this.fCQ;
          paramInt = i;
          if (bool) {
            paramInt = 1;
          }
          ((ce)localObject).gxA = paramInt;
          ((ce)localObject).gtq = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.hEO, this.fCQ);
          GMTrace.o(3549522034688L, 26446);
          return;
        }
      }
    }
    else {
      n.GT().a(this.fCQ.field_imgPath, com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()), true);
    }
    GMTrace.o(3549522034688L, 26446);
  }
  
  public final int getType()
  {
    GMTrace.i(15343233794048L, 114316);
    GMTrace.o(15343233794048L, 114316);
    return 110;
  }
  
  protected final int ub()
  {
    GMTrace.i(3550461558784L, 26453);
    if (this.hEK == 0)
    {
      GMTrace.o(3550461558784L, 26453);
      return 100;
    }
    GMTrace.o(3550461558784L, 26453);
    return 1350;
  }
  
  public static abstract interface a
  {
    public abstract void GG();
  }
  
  private final class b
  {
    public k.a hGK;
    
    public b(k.a parama)
    {
      GMTrace.i(3505364402176L, 26117);
      this.hGK = parama;
      GMTrace.o(3505364402176L, 26117);
    }
    
    final void GG()
    {
      GMTrace.i(3505230184448L, 26116);
      if (k.this.hGc == k.this.gUY) {}
      for (d locald = k.this.GH();; locald = k.this.GI())
      {
        if (locald.hES == 1)
        {
          com.tencent.mm.plugin.report.service.f.rV(23);
          com.tencent.mm.plugin.report.service.f.rV(21);
        }
        if (n.GT().a(Long.valueOf(k.this.gUY), k.this.GH()) < 0)
        {
          v.e(k.this.TAG, "update db failed local id:" + k.this.gUY + " server id:" + k.this.GH().fTG);
          h.fX((int)k.this.hGc);
          h.fW((int)k.this.hGc);
          k.this.gUt.a(3, -1, "", k.this);
        }
        if (k.this.gUY != k.this.hGc) {
          n.GT().a(Long.valueOf(k.this.hGc), k.this.GI());
        }
        k.this.ak(k.this.gUY);
        if (k.this.hGc != k.this.gUY) {
          k.this.ak(k.this.hGc);
        }
        if (this.hGK != null) {
          this.hGK.GG();
        }
        k.this.fY(k.this.hEK);
        k.this.hGz = null;
        GMTrace.o(3505230184448L, 26116);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */