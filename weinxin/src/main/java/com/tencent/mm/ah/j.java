package com.tencent.mm.ah;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.n.a;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class j
  extends k
  implements com.tencent.mm.network.j
{
  public String TAG;
  public au fCQ;
  private long fGD;
  public long gUY;
  private final com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  private int hEK;
  public final com.tencent.mm.y.f hGb;
  public final long hGc;
  private int hGd;
  private com.tencent.mm.modelstat.g hGe;
  public String hGf;
  public int hGg;
  private String hGh;
  public String hGi;
  int hGj;
  public boolean hGk;
  private int hGl;
  private String hGm;
  private int hGn;
  public boolean hGo;
  private h.a hGp;
  public int hrb;
  private int startOffset;
  public long startTime;
  private int token;
  
  public j(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.y.f paramf)
  {
    this(paramLong1, paramLong2, paramInt, paramf, -1);
    GMTrace.i(3542945366016L, 26397);
    GMTrace.o(3542945366016L, 26397);
  }
  
  public j(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.y.f paramf, int paramInt2)
  {
    GMTrace.i(3543079583744L, 26398);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.hGe = null;
    this.fGD = -1L;
    this.fCQ = null;
    this.hGf = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.hGg = 0;
    this.hGh = "";
    this.hGi = "";
    this.hrb = 0;
    this.hGj = -1;
    this.hGk = false;
    this.hGl = -1;
    this.hGm = null;
    this.hGn = 0;
    this.token = -1;
    this.hGo = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(3527107674112L, 26279);
        if (paramAnonymousInt == 44530)
        {
          v.i(j.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { j.this.hGf });
          GMTrace.o(3527107674112L, 26279);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          h.fX((int)j.this.hGc);
          h.fW((int)j.this.hGc);
          localObject = com.tencent.mm.plugin.report.service.g.oSF;
          l1 = j.this.startTime;
          l2 = bf.NA();
          i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
          j = j.this.hGg;
          k = j.this.hrb;
          if (paramAnonymouskeep_SceneResult == null)
          {
            paramAnonymousString = "";
            if (paramAnonymouskeep_SceneResult != null) {
              break label482;
            }
            paramAnonymouskeep_ProgressInfo = "";
            label141:
            ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            l1 = j.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
            j = j.this.hGg;
            k = j.this.hrb;
            if (paramAnonymouskeep_SceneResult != null) {
              break label491;
            }
            paramAnonymousString = "";
            label314:
            if (paramAnonymouskeep_SceneResult != null) {
              break label500;
            }
          }
          label482:
          label491:
          label500:
          for (paramAnonymouskeep_ProgressInfo = "";; paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
            j.this.gUt.a(3, paramAnonymousInt, "", j.this);
            GMTrace.o(3527107674112L, 26279);
            return 0;
            paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
            break;
            paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2;
            break label141;
            paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
            break label314;
          }
        }
        Object localObject = n.GT().b(Long.valueOf(j.this.gUY));
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          if (paramAnonymouskeep_ProgressInfo.field_finishedLength == j.this.hrb)
          {
            v.d(j.this.TAG, "cdntra ignore progress 100%");
            GMTrace.o(3527107674112L, 26279);
            return 0;
          }
          j.this.hGo = true;
          if (!j.this.hGk) {
            j.this.hGk = paramAnonymouskeep_ProgressInfo.field_mtlnotify;
          }
          v.i(j.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { j.this.hGf, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength), Boolean.valueOf(j.this.hGk) });
          j.this.a((d)localObject, j.this.hrb, ((d)localObject).offset, paramAnonymouskeep_ProgressInfo.field_finishedLength - ((d)localObject).offset, null);
          GMTrace.o(3527107674112L, 26279);
          return 0;
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label1169;
          }
          h.fW((int)j.this.hGc);
          v.e(j.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          j.this.gUt.a(3, paramAnonymouskeep_SceneResult.field_retCode, "", j.this);
          localObject = com.tencent.mm.plugin.report.service.g.oSF;
          paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
          l1 = j.this.startTime;
          l2 = bf.NA();
          i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
          j = j.this.hGg;
          k = j.this.hrb;
          if (paramAnonymouskeep_SceneResult != null) {
            break label1544;
          }
          paramAnonymousString = "";
          label835:
          if (paramAnonymouskeep_SceneResult != null) {
            break label1553;
          }
          paramAnonymouskeep_ProgressInfo = "";
          label843:
          ((com.tencent.mm.plugin.report.service.g)localObject).i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
          if (paramAnonymouskeep_SceneResult.field_retCode != 0)
          {
            localObject = com.tencent.mm.plugin.report.service.g.oSF;
            paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
            l1 = j.this.startTime;
            l2 = bf.NA();
            i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
            j = j.this.hGg;
            k = j.this.hrb;
            if (paramAnonymouskeep_SceneResult != null) {
              break label1562;
            }
            paramAnonymousString = "";
            label1030:
            if (paramAnonymouskeep_SceneResult != null) {
              break label1571;
            }
          }
        }
        label1169:
        label1263:
        label1399:
        label1465:
        label1497:
        label1505:
        label1544:
        label1553:
        label1562:
        label1571:
        for (paramAnonymouskeep_ProgressInfo = "";; paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
          GMTrace.o(3527107674112L, 26279);
          return 0;
          v.i(j.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymouskeep_SceneResult.field_convert2baseline) });
          if (((d)localObject).hEK == 1)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(198L, 26L, ((d)localObject).hrb, false);
            com.tencent.mm.plugin.report.service.g.oSF.a(198L, 27L, 1L, false);
            paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
            if (j.this.fCQ != null)
            {
              paramAnonymousString = j.this.fCQ.field_talker;
              if (!o.dH(paramAnonymousString)) {
                break label1399;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymouskeep_ProgressInfo.a(198L, l1, 1L, false);
              if (paramAnonymouskeep_SceneResult.field_convert2baseline)
              {
                v.i(j.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { j.this.hGi });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(j.this.hGi, 60);
                v.i(j.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!j.this.hGo) {
                break label1505;
              }
              j.this.a((d)localObject, ((d)localObject).offset, ((d)localObject).offset, 0, null);
              break;
              paramAnonymousString = "";
              break label1263;
            }
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(198L, 21L, ((d)localObject).hrb, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(198L, 22L, 1L, false);
          paramAnonymouskeep_ProgressInfo = com.tencent.mm.plugin.report.service.g.oSF;
          if (j.this.fCQ != null)
          {
            paramAnonymousString = j.this.fCQ.field_talker;
            if (!o.dH(paramAnonymousString)) {
              break label1497;
            }
          }
          for (l1 = 24L;; l1 = 23L)
          {
            paramAnonymouskeep_ProgressInfo.a(198L, l1, 1L, false);
            break;
            paramAnonymousString = "";
            break label1465;
          }
          j.this.a((d)localObject, j.this.hrb, ((d)localObject).offset, j.this.hrb - ((d)localObject).offset, null);
          break;
          paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
          break label835;
          paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2;
          break label843;
          paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
          break label1030;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(3527241891840L, 26280);
        GMTrace.o(3527241891840L, 26280);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(3527376109568L, 26281);
        GMTrace.o(3527376109568L, 26281);
        return null;
      }
    };
    boolean bool;
    d locald;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramf != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hGb = paramf;
      this.hEK = paramInt1;
      this.hGc = paramLong1;
      this.gUY = paramLong1;
      this.fGD = paramLong2;
      this.hGl = paramInt2;
      locald = n.GT().b(Long.valueOf(this.gUY));
      if (paramInt1 != 1) {
        break label584;
      }
      this.gUY = locald.hEQ;
      locald = n.GT().b(Long.valueOf(this.gUY));
    }
    label584:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.gUY + "]");
      Object localObject = new b.a();
      ((b.a)localObject).hrV = new zk();
      ((b.a)localObject).hrW = new zl();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).hrU = 109;
      ((b.a)localObject).hrX = 10;
      ((b.a)localObject).hrY = 1000000010;
      this.gUq = ((b.a)localObject).BE();
      localObject = (zk)this.gUq.hrS.hsa;
      this.fCQ = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramLong2);
      ((zk)localObject).tfe = locald.offset;
      ((zk)localObject).tfd = locald.hrb;
      v.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(locald.offset), Integer.valueOf(locald.hrb), bf.bJP() });
      ((zk)localObject).tdE = this.fCQ.field_msgSvrId;
      ((zk)localObject).tdx = new avu().OU(this.fCQ.field_talker);
      ((zk)localObject).tdy = new avu().OU((String)com.tencent.mm.kernel.h.vI().vr().get(2, null));
      ((zk)localObject).tEg = paramInt1;
      if (locald.offset == 0) {
        this.hGe = new com.tencent.mm.modelstat.g(109, false, locald.hrb);
      }
      this.hGd = 8192;
      if (paramf != null) {
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3530865770496L, 26307);
            paramf.a(this.hGr, this.hyg, j.this);
            GMTrace.o(3530865770496L, 26307);
          }
        });
      }
      GMTrace.o(3543079583744L, 26398);
      return;
      bool = false;
      break;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(3543616454656L, 26402);
    this.gUt = parame1;
    zk localzk = (zk)this.gUq.hrS.hsa;
    d locald = n.GT().b(Long.valueOf(this.gUY));
    if (locald.hEG == 0L)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 195L, 1L, false);
      v.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.gUY), locald });
      GMTrace.o(3543616454656L, 26402);
      return -1;
    }
    if (locald.status != 0)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 194L, 1L, false);
      v.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(locald.hEG), Integer.valueOf(locald.status) });
      GMTrace.o(3543616454656L, 26402);
      return -1;
    }
    parame1 = locald.hEH;
    if (parame1.startsWith("SERVERID://"))
    {
      this.hGh = com.tencent.mm.a.g.n(locald.hEH.getBytes());
      this.hGi = n.GT().m(this.hGh, null, ".temp");
      locald.jp(this.hGh + ".temp");
      n.GT().a(Long.valueOf(this.gUY), locald);
      v.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(locald.hEG), Integer.valueOf(this.hEK), Integer.valueOf(locald.offset), Integer.valueOf(locald.hrb), parame1, this.hGh, this.hGi });
      if (this.startTime == 0L)
      {
        this.startTime = bf.NA();
        this.startOffset = locald.offset;
        if (this.hEK != 1) {
          break label486;
        }
        i = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        label387:
        this.hGg = i;
      }
      parame1 = localzk.tdx.tXF;
      long l = localzk.tdE;
      if (!bf.mA(locald.hER)) {
        break label493;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label1512;
      }
      v.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.hGf });
      GMTrace.o(3543616454656L, 26402);
      return 0;
      this.hGh = locald.hEH;
      this.hGi = n.GT().m(this.hGh, null, "");
      break;
      label486:
      i = com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
      break label387;
      label493:
      Object localObject = bg.q(locald.hER, "msg");
      if (localObject == null)
      {
        v.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { locald.hER });
        i = 0;
      }
      else
      {
        this.hrb = 0;
        if (this.hEK != 1) {
          parame1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
        }
        for (this.hrb = bf.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);; this.hrb = bf.getInt((String)((Map)localObject).get(".msg.img.$hdlength"), 0))
        {
          v.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s]", new Object[] { Integer.valueOf(this.hEK), Integer.valueOf(this.hrb), parame1 });
          if (!bf.mA(parame1)) {
            break label684;
          }
          v.e(this.TAG, "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          parame1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
        }
        label684:
        String str1 = (String)((Map)localObject).get(".msg.img.$aeskey");
        if (bf.mA(str1))
        {
          v.e(this.TAG, "cdntra get aes key failed.");
          i = 0;
        }
        else
        {
          this.hGf = com.tencent.mm.modelcdntran.d.a("downimg", locald.hEN, this.fCQ.field_talker, this.fCQ.field_msgId);
          if (bf.mA(this.hGf))
          {
            v.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gUY) });
            i = 0;
          }
          else
          {
            String str2 = (String)((Map)localObject).get(".msg.img.$md5");
            if ((!bf.mA(str2)) && ((bf.mA((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"))) || (this.hEK == 1)))
            {
              a.aDn();
              String str3 = a.wY().cH(str2, this.hrb);
              i = com.tencent.mm.a.e.aN(str3);
              int j = this.hrb - i;
              String str4 = this.TAG;
              int k = this.hrb;
              localObject = ((Map)localObject).get(".msg.img.$cdnbigimgurl");
              if (this.hEK == 1) {}
              for (boolean bool = true;; bool = false)
              {
                v.i(str4, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str2, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str3, Integer.valueOf(j), this.hGi });
                if (bf.mA(str3)) {
                  break label1160;
                }
                if ((j < 0) || (j > 16)) {
                  break label1174;
                }
                bool = com.tencent.mm.sdk.platformtools.j.ex(str3, this.hGi);
                v.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str3, this.hGi, Boolean.valueOf(bool) });
                a(locald, this.hrb, this.hrb, 0, null);
                com.tencent.mm.plugin.report.service.g.oSF.i(13267, new Object[] { parame1, Long.valueOf(this.fCQ.field_msgSvrId), str2, Long.valueOf(this.fCQ.field_createTime / 1000L), this.fCQ.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
                i = 1;
                break;
              }
              label1160:
              this.hGm = str2;
              this.hGn = this.hrb;
            }
            label1174:
            localObject = new com.tencent.mm.modelcdntran.h();
            ((com.tencent.mm.modelcdntran.h)localObject).field_mediaId = this.hGf;
            ((com.tencent.mm.modelcdntran.h)localObject).field_fullpath = this.hGi;
            ((com.tencent.mm.modelcdntran.h)localObject).field_fileType = this.hGg;
            ((com.tencent.mm.modelcdntran.h)localObject).field_totalLen = this.hrb;
            ((com.tencent.mm.modelcdntran.h)localObject).field_aesKey = str1;
            ((com.tencent.mm.modelcdntran.h)localObject).field_fileId = parame1;
            ((com.tencent.mm.modelcdntran.h)localObject).field_priority = com.tencent.mm.modelcdntran.b.hxt;
            ((com.tencent.mm.modelcdntran.h)localObject).hyM = this.hGp;
            if (o.dH(this.fCQ.field_talker))
            {
              i = 1;
              label1264:
              ((com.tencent.mm.modelcdntran.h)localObject).field_chattype = i;
              v.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.fCQ.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.Em().hxZ.contains("image_" + this.fCQ.field_msgId)) });
              if (!com.tencent.mm.modelcdntran.g.Em().hxZ.contains("image_" + this.fCQ.field_msgId)) {
                break label1488;
              }
              com.tencent.mm.modelcdntran.g.Em().hxZ.remove("image_" + this.fCQ.field_msgId);
            }
            label1488:
            for (((com.tencent.mm.modelcdntran.h)localObject).field_autostart = true;; ((com.tencent.mm.modelcdntran.h)localObject).field_autostart = false)
            {
              if (com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject, this.hGl)) {
                break label1497;
              }
              com.tencent.mm.plugin.report.service.g.oSF.a(111L, 196L, 1L, false);
              v.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.hGf });
              this.hGf = "";
              i = 0;
              break;
              i = 0;
              break label1264;
            }
            label1497:
            v.d(this.TAG, "add recv task");
            i = 1;
          }
        }
      }
    }
    label1512:
    v.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.hGf });
    locald.js("");
    locald.fRM = 4096;
    n.GT().a(Long.valueOf(this.gUY), locald);
    localzk.tfe = locald.offset;
    localzk.tff = this.hGd;
    localzk.tfd = locald.hrb;
    if (this.hGe != null) {
      this.hGe.Kb();
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(3543616454656L, 26402);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(3543348019200L, 26400);
    int i = k.b.hsC;
    GMTrace.o(3543348019200L, 26400);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(3543884890112L, 26404);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bf.mA(this.hGf)))
    {
      v.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hGf });
      GMTrace.o(3543884890112L, 26404);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(this.hrb - this.startOffset) });
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(3543884890112L, 26404);
      return;
    }
    paramString = (zl)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramp = n.GT().b(Long.valueOf(this.gUY));
    paramInt1 = 0;
    if (paramString.tff <= 0)
    {
      v.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(this.hrb - this.startOffset) });
      this.gUt.a(4, -1, "", this);
      GMTrace.o(3543884890112L, 26404);
      return;
      if ((paramString.tqC == null) || (paramString.tff != paramString.tqC.tXB))
      {
        v.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.tfe < 0) || (paramString.tfe + paramString.tff > paramString.tfd))
      {
        v.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.tfe != paramp.offset)
      {
        v.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.tfd <= 0)
      {
        v.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramp, paramString.tfd, paramString.tfe, paramString.tff, paramString.tqC.tXD.sWU)) && (a(this.hsm, this.gUt) < 0)) {
      this.gUt.a(3, -1, "", this);
    }
    GMTrace.o(3543884890112L, 26404);
  }
  
  public final boolean a(final d paramd, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GMTrace.i(3544019107840L, 26405);
    paramd.fO(paramInt1);
    paramd.setOffset(paramInt2 + paramInt3);
    this.hGd = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.a.e.e(this.hGi, paramArrayOfByte);
    }
    v.d(this.TAG, "onGYNetEnd : offset = " + paramd.offset + " totalLen = " + paramd.hrb + " stack:[%s]", new Object[] { bf.bJP() });
    if (paramd.GB())
    {
      paramArrayOfByte = this.hGi;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.equals(""))) {
        paramArrayOfByte = "";
      }
    }
    for (;;)
    {
      Object localObject = new MMBitmapFactory.DecodeResultLogger();
      boolean bool = MMBitmapFactory.checkIsImageLegal(this.hGi, (MMBitmapFactory.DecodeResultLogger)localObject);
      File localFile = new File(this.hGi);
      if (bool)
      {
        localObject = n.GT().m(this.hGh, null, paramArrayOfByte);
        v.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.hGh, this.hGi, localObject });
        localFile.renameTo(new File((String)localObject));
        paramd.jp(this.hGh + paramArrayOfByte);
        paramd.jo(FileOp.kp((String)localObject));
        paramd.fS(this.hEK);
      }
      for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = null)
      {
        if (n.GT().a(Long.valueOf(this.gUY), paramd) >= 0) {
          break label541;
        }
        v.e(this.TAG, "onGYNetEnd : update img fail");
        this.gUt.a(3, -1, "", this);
        GMTrace.o(3544019107840L, 26405);
        return false;
        paramArrayOfByte = com.tencent.mm.a.e.c(paramArrayOfByte, 0, 2);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
        {
          paramArrayOfByte = "";
          break;
        }
        paramInt3 = paramArrayOfByte[0];
        paramInt2 = paramInt3;
        if (paramInt3 < 0) {
          paramInt2 = paramInt3 + 256;
        }
        int i = paramArrayOfByte[1];
        paramInt3 = i;
        if (i < 0) {
          paramInt3 = i + 256;
        }
        if ((paramInt2 == 66) && (paramInt3 == 77))
        {
          paramArrayOfByte = ".bmp";
          break;
        }
        if ((paramInt2 == 255) && (paramInt3 == 216))
        {
          paramArrayOfByte = ".jpg";
          break;
        }
        if ((paramInt2 == 137) && (paramInt3 == 80))
        {
          paramArrayOfByte = ".png";
          break;
        }
        if ((paramInt2 != 71) || (paramInt3 != 73)) {
          break label911;
        }
        paramArrayOfByte = ".gif";
        break;
        localFile.delete();
        if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() >= 2000)
        {
          paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(this.hGi, 2, (MMBitmapFactory.DecodeResultLogger)localObject);
          com.tencent.mm.plugin.report.service.g.oSF.A(12712, paramArrayOfByte);
        }
      }
      label541:
      if (this.hGb != null) {
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3529926246400L, 26300);
            j.this.hGb.a(paramd.offset, paramd.hrb, j.this);
            GMTrace.o(3529926246400L, 26300);
          }
        });
      }
      v.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramd.GB()), this.hGf });
      if (paramd.GB())
      {
        if (bf.mA(this.hGf)) {
          com.tencent.mm.plugin.report.service.g.oSF.i(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(this.hGg), Integer.valueOf(paramInt1 - this.startOffset) });
        }
        bool = false;
        if (this.hGj > 0) {
          bool = n.GT().a(paramArrayOfByte, paramd.hEJ, this.hGj, 1);
        }
        if (bool)
        {
          paramd.gxA = 1;
          paramd.hFh = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.fCQ.field_msgId, this.fCQ);
        }
        n.GT().a(Long.valueOf(this.gUY), paramd);
        v.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.hGi, paramArrayOfByte, paramd.hEH, this.hGm });
        if (this.hGe != null) {
          this.hGe.ar(paramd.hrb);
        }
        if ((!bf.mA(this.hGm)) && (this.hGn > 0))
        {
          a.aDn();
          a.wY().p(this.hGm, this.hGn, paramArrayOfByte);
        }
        this.gUt.a(0, 0, "", this);
        GMTrace.o(3544019107840L, 26405);
        return false;
      }
      GMTrace.o(3544019107840L, 26405);
      return true;
      label911:
      paramArrayOfByte = ".jpg";
    }
  }
  
  protected final void cancel()
  {
    GMTrace.i(3543482236928L, 26401);
    if ((!bf.mA(this.hGf)) && (com.tencent.mm.modelcdntran.g.Em() != null))
    {
      v.d(this.TAG, "cancel recv task");
      com.tencent.mm.modelcdntran.g.Em().iQ(this.hGf);
    }
    super.cancel();
    GMTrace.o(3543482236928L, 26401);
  }
  
  public final int getType()
  {
    GMTrace.i(15343099576320L, 114315);
    GMTrace.o(15343099576320L, 114315);
    return 109;
  }
  
  protected final int ub()
  {
    GMTrace.i(3543213801472L, 26399);
    if (this.hEK == 0)
    {
      GMTrace.o(3543213801472L, 26399);
      return 100;
    }
    GMTrace.o(3543213801472L, 26399);
    return 1280;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */