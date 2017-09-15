package com.tencent.mm.modelcdntran;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mm.network.m.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class c
  implements b.b, m.b, com.tencent.mm.y.e
{
  com.tencent.mm.network.m hxS;
  public Queue<String> hxT;
  public Map<String, h> hxU;
  public Map<String, h> hxV;
  public Map<String, Integer> hxW;
  private String hxX;
  private long hxY;
  public HashSet<String> hxZ;
  
  public c()
  {
    GMTrace.i(593242357760L, 4420);
    this.hxS = new m.a()
    {
      public final void cU(int paramAnonymousInt)
      {
        GMTrace.i(573646569472L, 4274);
        v.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseEvent.onNetworkChange();
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          GMTrace.o(573646569472L, 4274);
          return;
        }
        if (!com.tencent.mm.kernel.h.vG().uV())
        {
          GMTrace.o(573646569472L, 4274);
          return;
        }
        com.tencent.mm.kernel.h.vd().a(new e(), 0);
        GMTrace.o(573646569472L, 4274);
      }
    };
    this.hxT = new LinkedList();
    this.hxU = new HashMap();
    this.hxV = new HashMap();
    this.hxW = new HashMap();
    this.hxX = "";
    this.hxY = 0L;
    this.hxZ = new HashSet();
    com.tencent.mm.kernel.h.vH().a(this.hxS);
    if (com.tencent.mm.kernel.h.vG().uV()) {
      com.tencent.mm.kernel.h.vI().vr().a(this);
    }
    com.tencent.mm.kernel.h.vd().a(379, this);
    GMTrace.o(593242357760L, 4420);
  }
  
  public static void Eg()
  {
    GMTrace.i(17505481392128L, 130426);
    com.tencent.mm.kernel.h.vG();
    b.c localc;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    if (com.tencent.mm.kernel.a.uU())
    {
      localc = new b.c(g.En());
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableSnsStreamDownload");
    }
    for (;;)
    {
      try
      {
        if (!bf.mA(str1)) {
          localc.field_UseStreamCDN = Integer.valueOf(str1).intValue();
        }
        if (!bf.mA(str2)) {
          localc.field_EnableCDNVerifyConnect = Integer.valueOf(str2).intValue();
        }
        if (!bf.mA(str3)) {
          localc.field_EnableCDNVideoRedirectOC = Integer.valueOf(str3).intValue();
        }
        if (!bf.mA(str4)) {
          localc.field_EnableStreamUploadVideo = Integer.valueOf(str4).intValue();
        }
        if (!bf.mA(str5)) {
          localc.field_C2COverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bf.mA(str6)) {
          localc.field_SNSOverloadDelaySeconds = Integer.valueOf(str6).intValue();
        }
        if (!bf.mA(str7)) {
          localc.field_EnableSnsStreamDownload = Integer.valueOf(str7).intValue();
        }
        g.Em();
        if (!fA(256)) {
          continue;
        }
        i = 1;
        localc.field_EnableSafeCDN = i;
        if (localc.field_UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableJPEGDyncmicETL");
          if (!bf.mA(str1)) {
            localc.field_WifiEtl = Integer.valueOf(str1).intValue();
          }
          if (!bf.mA(str2)) {
            localc.field_noWifiEtl = Integer.valueOf(str2).intValue();
          }
          if (!bf.mA(str3)) {
            localc.field_Ptl = Integer.valueOf(str3).intValue();
          }
          if (!bf.mA(str4))
          {
            if (Integer.valueOf(str4).intValue() == 0) {
              continue;
            }
            bool = true;
            localc.field_onlyrecvPtl = bool;
          }
          if (!bf.mA(str5)) {
            localc.field_UseDynamicETL = Integer.valueOf(str5).intValue();
          }
        }
        v.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localc });
        g.En();
        b.a(localc);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        boolean bool;
        v.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (r.iiV)
      {
        v.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        if (!r.iiR) {
          continue;
        }
        i = 1;
        localc.field_UseStreamCDN = i;
        if (localc.field_UseStreamCDN != 0)
        {
          localc.field_onlysendETL = r.iiS;
          localc.field_onlyrecvPtl = r.iiT;
          if (!bf.mA(r.iiO)) {
            localc.field_WifiEtl = Integer.valueOf(r.iiO).intValue();
          }
          if (!bf.mA(r.iiP)) {
            localc.field_noWifiEtl = Integer.valueOf(r.iiP).intValue();
          }
          if (!bf.mA(r.iiQ)) {
            localc.field_Ptl = Integer.valueOf(r.iiQ).intValue();
          }
        }
        if (!r.iiW) {
          continue;
        }
        i = 1;
        localc.field_EnableCDNVerifyConnect = i;
        if (!r.iiX) {
          continue;
        }
        i = 1;
        localc.field_EnableCDNVideoRedirectOC = i;
        v.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localc });
        g.En();
        b.a(localc);
      }
      GMTrace.o(17505481392128L, 130426);
      return;
      i = 0;
      continue;
      bool = false;
    }
  }
  
  public static boolean fA(int paramInt)
  {
    GMTrace.i(593108140032L, 4419);
    com.tencent.mm.kernel.h.vG();
    if (com.tencent.mm.kernel.a.uU())
    {
      int i = bf.a((Integer)com.tencent.mm.kernel.h.vI().vr().get(144385, null), 0);
      v.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(i & paramInt), Boolean.valueOf(r.iiw) });
      if (r.iiw)
      {
        GMTrace.o(593108140032L, 4419);
        return true;
      }
      if ((i & paramInt) > 0)
      {
        GMTrace.o(593108140032L, 4419);
        return true;
      }
      GMTrace.o(593108140032L, 4419);
      return false;
    }
    GMTrace.o(593108140032L, 4419);
    return true;
  }
  
  public final int a(final String paramString, final keep_ProgressInfo paramkeep_ProgressInfo, final keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(594047664128L, 4426);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      GMTrace.o(594047664128L, 4426);
      return -1;
    }
    if ((paramkeep_ProgressInfo == null) && (paramkeep_SceneResult == null))
    {
      v.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      GMTrace.o(594047664128L, 4426);
      return -2;
    }
    if (paramkeep_ProgressInfo != null) {
      v.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Integer.valueOf(paramkeep_ProgressInfo.field_toltalLength), Integer.valueOf(paramkeep_ProgressInfo.field_finishedLength), Boolean.valueOf(paramkeep_ProgressInfo.field_mtlnotify) });
    }
    this.hxY = bf.NA();
    this.hxX = paramString;
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        GMTrace.i(589618479104L, 4393);
        Object localObject = (h)c.this.hxV.get(paramString);
        if (localObject == null)
        {
          v.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          GMTrace.o(589618479104L, 4393);
          return;
        }
        if (paramkeep_ProgressInfo != null)
        {
          paramkeep_ProgressInfo.mediaId = paramString;
          v.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Integer.valueOf(paramkeep_ProgressInfo.field_toltalLength), Integer.valueOf(paramkeep_ProgressInfo.field_finishedLength), Boolean.valueOf(paramkeep_ProgressInfo.field_mtlnotify) });
        }
        if (paramkeep_SceneResult != null) {
          paramkeep_SceneResult.mediaId = paramString;
        }
        if (((h)localObject).hyM != null)
        {
          long l = bf.NA();
          if ((paramkeep_SceneResult == null) && (paramkeep_ProgressInfo != null) && (!paramkeep_ProgressInfo.field_mtlnotify) && (al.getNetWorkType(aa.getContext()) == -1))
          {
            GMTrace.o(589618479104L, 4393);
            return;
          }
          ((h)localObject).field_lastProgressCallbackTime = l;
          ((h)localObject).hyM.a(paramString, 0, paramkeep_ProgressInfo, paramkeep_SceneResult, ((h)localObject).field_onlycheckexist);
        }
        localObject = paramkeep_ProgressInfo;
        if ((localObject != null) && (((keep_ProgressInfo)localObject).field_finishedLength != ((keep_ProgressInfo)localObject).field_toltalLength)) {}
        for (;;)
        {
          if (i != 0) {
            c.this.hxW.remove(paramString);
          }
          if (paramkeep_SceneResult != null)
          {
            c.this.hxV.remove(paramString);
            if (paramkeep_SceneResult.field_retCode == -5103011)
            {
              v.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.g.oSF.a(546L, 4L, 1L, true);
              g.En().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          GMTrace.o(589618479104L, 4393);
          return;
          i = 1;
        }
      }
      
      public final String toString()
      {
        GMTrace.i(589752696832L, 4394);
        String str = super.toString() + "|callback";
        GMTrace.o(589752696832L, 4394);
        return str;
      }
    });
    GMTrace.o(594047664128L, 4426);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(592973922304L, 4418);
    if (paramk.getType() != 379)
    {
      GMTrace.o(592973922304L, 4418);
      return;
    }
    v.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramk.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.vG().uV()) {
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(573915004928L, 4276);
          c.this.be(true);
          GMTrace.o(573915004928L, 4276);
        }
        
        public final String toString()
        {
          GMTrace.i(574049222656L, 4277);
          String str = super.toString() + "|onSceneEnd";
          GMTrace.o(574049222656L, 4277);
          return str;
        }
      });
    }
    GMTrace.o(592973922304L, 4418);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    GMTrace.i(592839704576L, 4417);
    if (!com.tencent.mm.kernel.h.vG().uV())
    {
      GMTrace.o(592839704576L, 4417);
      return;
    }
    int i = bf.n(paramObject, 0);
    v.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != com.tencent.mm.kernel.h.vI().vr()) || (i <= 0))
    {
      v.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
      GMTrace.o(592839704576L, 4417);
      return;
    }
    if (i != 144385)
    {
      GMTrace.o(592839704576L, 4417);
      return;
    }
    com.tencent.mm.kernel.h.vd().a(new e(), 0);
    GMTrace.o(592839704576L, 4417);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    GMTrace.i(594181881856L, 4427);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      GMTrace.o(594181881856L, 4427);
      return;
    }
    h localh = (h)this.hxV.get(paramString);
    if (localh == null)
    {
      v.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      GMTrace.o(594181881856L, 4427);
      return;
    }
    if (localh.hyM != null)
    {
      localh.hyM.a(paramString, paramByteArrayOutputStream);
      GMTrace.o(594181881856L, 4427);
      return;
    }
    v.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    GMTrace.o(594181881856L, 4427);
  }
  
  public final boolean b(final h paramh)
  {
    GMTrace.i(593510793216L, 4422);
    if (bf.mA(paramh.field_mediaId))
    {
      v.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      GMTrace.o(593510793216L, 4422);
      return false;
    }
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.fZA = true;
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(578612625408L, 4311);
        c.this.hxT.add(paramh.field_mediaId);
        c.this.hxU.put(paramh.field_mediaId, paramh);
        c.this.be(false);
        GMTrace.o(578612625408L, 4311);
      }
      
      public final String toString()
      {
        GMTrace.i(578746843136L, 4312);
        String str = super.toString() + "|addSendTask";
        GMTrace.o(578746843136L, 4312);
        return str;
      }
    });
    GMTrace.o(593510793216L, 4422);
    return true;
  }
  
  public final boolean b(final h paramh, final int paramInt)
  {
    GMTrace.i(593376575488L, 4421);
    if (paramh == null)
    {
      v.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      GMTrace.o(593376575488L, 4421);
      return false;
    }
    if (bf.mA(paramh.field_mediaId))
    {
      v.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      GMTrace.o(593376575488L, 4421);
      return false;
    }
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.fZA = false;
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(577941536768L, 4306);
        if (paramInt != -1) {
          c.this.hxW.put(paramh.field_mediaId, Integer.valueOf(paramInt));
        }
        c.this.hxT.add(paramh.field_mediaId);
        c.this.hxU.put(paramh.field_mediaId, paramh);
        c.this.be(false);
        GMTrace.o(577941536768L, 4306);
      }
      
      public final String toString()
      {
        GMTrace.i(578075754496L, 4307);
        String str = super.toString() + "|addRecvTask";
        GMTrace.o(578075754496L, 4307);
        return str;
      }
    });
    GMTrace.o(593376575488L, 4421);
    return true;
  }
  
  public final void be(boolean paramBoolean)
  {
    GMTrace.i(593913446400L, 4425);
    if ((!paramBoolean) && (g.En().Ef()))
    {
      com.tencent.mm.kernel.h.vG();
      if (com.tencent.mm.kernel.a.uU())
      {
        v.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        com.tencent.mm.kernel.h.vd().a(new e(), 0);
        GMTrace.o(593913446400L, 4425);
        return;
      }
    }
    Eg();
    v.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.hxT.size()) });
    Object localObject1;
    int i;
    label232:
    int j;
    label242:
    Object localObject2;
    for (;;)
    {
      if (!this.hxT.isEmpty())
      {
        localObject1 = (String)this.hxT.poll();
        localObject1 = (h)this.hxU.remove(localObject1);
        if (localObject1 == null)
        {
          v.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
          GMTrace.o(593913446400L, 4425);
          return;
        }
        v.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((h)localObject1).field_mediaId, Boolean.valueOf(((h)localObject1).field_autostart), Integer.valueOf(((h)localObject1).field_chattype) });
        ((h)localObject1).field_startTime = bf.NA();
        if (((h)localObject1).fZA)
        {
          if (((h)localObject1).field_fullpath == null)
          {
            i = -1;
            if (((h)localObject1).field_thumbpath != null) {
              break label801;
            }
            j = -1;
            v.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bf.Qi(((h)localObject1).field_svr_signature), bf.Qi(((h)localObject1).field_aesKey), Integer.valueOf(((h)localObject1).field_fileType), ((h)localObject1).field_mediaId, Boolean.valueOf(((h)localObject1).field_onlycheckexist) });
            if (((h)localObject1).field_fullpath == null) {
              ((h)localObject1).field_fullpath = "";
            }
            if (((h)localObject1).field_thumbpath == null) {
              ((h)localObject1).field_thumbpath = "";
            }
            g.En();
            localObject2 = new CdnLogic.C2CUploadRequest();
            ((CdnLogic.C2CUploadRequest)localObject2).fileKey = ((h)localObject1).field_mediaId;
            ((CdnLogic.C2CUploadRequest)localObject2).filePath = ((h)localObject1).field_fullpath;
            ((CdnLogic.C2CUploadRequest)localObject2).thumbfilePath = ((h)localObject1).field_thumbpath;
            ((CdnLogic.C2CUploadRequest)localObject2).fileSize = ((h)localObject1).field_totalLen;
            ((CdnLogic.C2CUploadRequest)localObject2).fileType = ((h)localObject1).field_fileType;
            ((CdnLogic.C2CUploadRequest)localObject2).forwardAeskey = ((h)localObject1).field_aesKey;
            ((CdnLogic.C2CUploadRequest)localObject2).forwardFileid = ((h)localObject1).field_fileId;
            ((CdnLogic.C2CUploadRequest)localObject2).midfileSize = ((h)localObject1).field_midFileLength;
            ((CdnLogic.C2CUploadRequest)localObject2).queueTimeoutSeconds = 0;
            ((CdnLogic.C2CUploadRequest)localObject2).transforTimeoutSeconds = 0;
            ((CdnLogic.C2CUploadRequest)localObject2).toUser = ((h)localObject1).field_talker;
            ((CdnLogic.C2CUploadRequest)localObject2).sendmsgFromCDN = ((h)localObject1).field_sendmsg_viacdn;
            ((CdnLogic.C2CUploadRequest)localObject2).needCompressImage = ((h)localObject1).field_needCompressImage;
            ((CdnLogic.C2CUploadRequest)localObject2).chatType = ((h)localObject1).field_chattype;
            ((CdnLogic.C2CUploadRequest)localObject2).apptype = ((h)localObject1).field_appType;
            ((CdnLogic.C2CUploadRequest)localObject2).bizscene = ((h)localObject1).field_bzScene;
            ((CdnLogic.C2CUploadRequest)localObject2).checkExistOnly = ((h)localObject1).field_onlycheckexist;
            if (((h)localObject1).field_smallVideoFlag != 1) {
              break label813;
            }
            paramBoolean = true;
            label539:
            ((CdnLogic.C2CUploadRequest)localObject2).isSmallVideo = paramBoolean;
            ((CdnLogic.C2CUploadRequest)localObject2).isLargeSVideo = ((h)localObject1).field_largesvideo;
            if (((h)localObject1).field_advideoflag != 1) {
              break label818;
            }
          }
          label801:
          label813:
          label818:
          for (paramBoolean = true;; paramBoolean = false)
          {
            ((CdnLogic.C2CUploadRequest)localObject2).isSnsAdVideo = paramBoolean;
            ((CdnLogic.C2CUploadRequest)localObject2).isStorageMode = ((h)localObject1).field_needStorage;
            ((CdnLogic.C2CUploadRequest)localObject2).isStreamMedia = ((h)localObject1).field_isStreamMedia;
            ((CdnLogic.C2CUploadRequest)localObject2).enableHitCheck = ((h)localObject1).field_enable_hitcheck;
            ((CdnLogic.C2CUploadRequest)localObject2).forceNoSafeCdn = ((h)localObject1).field_force_aeskeycdn;
            ((CdnLogic.C2CUploadRequest)localObject2).trySafeCdn = ((h)localObject1).field_trysafecdn;
            ((CdnLogic.C2CUploadRequest)localObject2).midimgPath = ((h)localObject1).field_midimgpath;
            ((CdnLogic.C2CUploadRequest)localObject2).bigfileSignature = ((h)localObject1).field_svr_signature;
            if (bf.mA(((CdnLogic.C2CUploadRequest)localObject2).bigfileSignature)) {
              ((CdnLogic.C2CUploadRequest)localObject2).bigfileSignature = "";
            }
            ((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignature = ((h)localObject1).field_fake_bigfile_signature;
            if (bf.mA(((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignature)) {
              ((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignature = "";
            }
            ((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignatureAeskey = ((h)localObject1).field_fake_bigfile_signature_aeskey;
            if (bf.mA(((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignatureAeskey)) {
              ((CdnLogic.C2CUploadRequest)localObject2).fakeBigfileSignatureAeskey = "";
            }
            i = CdnLogic.startC2CUpload((CdnLogic.C2CUploadRequest)localObject2);
            if (i == 0) {
              break label823;
            }
            v.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId });
            if (((h)localObject1).hyM == null) {
              break;
            }
            ((h)localObject1).hyM.a(((h)localObject1).field_mediaId, i, null, null, ((h)localObject1).field_onlycheckexist);
            break;
            i = ((h)localObject1).field_fullpath.length();
            break label232;
            j = ((h)localObject1).field_thumbpath.length();
            break label242;
            paramBoolean = false;
            break label539;
          }
          label823:
          v.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { ((h)localObject1).field_mediaId });
          this.hxV.put(((h)localObject1).field_mediaId, localObject1);
        }
        else
        {
          i = -1;
          if (((h)localObject1).hyN)
          {
            j = i;
            if (((h)localObject1).field_fullpath != null)
            {
              j = i;
              if (!((h)localObject1).field_fullpath.isEmpty())
              {
                g.En();
                j = b.a(((h)localObject1).field_mediaId, ((h)localObject1).hyO, ((h)localObject1).field_fullpath, ((h)localObject1).hyP, ((h)localObject1).hyQ, ((h)localObject1).hyR);
              }
            }
            if (((h)localObject1).field_fullpath == null)
            {
              i = -1;
              label945:
              v.i("MicroMsg.CdnTransportService", "https download tryStart recv file:%d field_mediaId[%s], download_url[%s]", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId, ((h)localObject1).hyO });
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        v.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId });
        if (((h)localObject1).hyM == null) {
          break;
        }
        ((h)localObject1).hyM.a(((h)localObject1).field_mediaId, i, null, null, ((h)localObject1).field_onlycheckexist);
        break;
        i = ((h)localObject1).field_fullpath.length();
        break label945;
        if (((h)localObject1).hyS)
        {
          j = i;
          if (((h)localObject1).field_fullpath != null)
          {
            j = i;
            if (!((h)localObject1).field_fullpath.isEmpty())
            {
              g.En();
              j = b.a(((h)localObject1).field_mediaId, ((h)localObject1).field_fullpath, ((h)localObject1).hyO, ((h)localObject1).hyT, ((h)localObject1).hyU, ((h)localObject1).allow_mobile_net_download, ((h)localObject1).hyP, ((h)localObject1).hyQ, ((h)localObject1).hyR);
            }
          }
          if (((h)localObject1).field_fullpath == null) {}
          for (i = -1;; i = ((h)localObject1).field_fullpath.length())
          {
            v.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId, ((h)localObject1).hyO, ((h)localObject1).hyT });
            i = j;
            break;
          }
        }
        if (((h)localObject1).field_fullpath == null)
        {
          j = -1;
          label1227:
          if (((h)localObject1).field_thumbpath != null) {
            break label1372;
          }
        }
        label1372:
        for (int k = -1;; k = ((h)localObject1).field_thumbpath.length())
        {
          v.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), ((h)localObject1).field_svr_signature, ((h)localObject1).field_aesKey, Integer.valueOf(((h)localObject1).field_fileType), ((h)localObject1).field_mediaId, Boolean.valueOf(((h)localObject1).field_onlycheckexist) });
          if (((h)localObject1).hyV != 2) {
            break label1464;
          }
          if (!(localObject1 instanceof i)) {
            break label1531;
          }
          localObject2 = (i)localObject1;
          if (!((i)localObject2).Ep()) {
            break label1385;
          }
          g.En();
          i = b.a((h)localObject1, 2);
          break;
          j = ((h)localObject1).field_fullpath.length();
          break label1227;
        }
        label1385:
        if (((i)localObject2).Eo())
        {
          g.En();
          i = b.a(((i)localObject2).field_mediaId, ((i)localObject2).url, ((i)localObject2).referer, ((i)localObject2).field_fullpath, ((i)localObject2).hzb, ((i)localObject2).iplist, ((i)localObject2).initialDownloadOffset, ((i)localObject2).initialDownloadLength, ((i)localObject2).isColdSnsData, ((i)localObject2).signalQuality, ((i)localObject2).snsScene, ((i)localObject2).field_preloadRatio);
        }
        continue;
        label1464:
        g.En();
        i = CdnLogic.startC2CDownload(b.a((h)localObject1));
        continue;
      }
      v.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { ((h)localObject1).field_mediaId });
      this.hxV.put(((h)localObject1).field_mediaId, localObject1);
      break;
      GMTrace.o(593913446400L, 4425);
      return;
      label1531:
      i = -1;
    }
  }
  
  public final byte[] i(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(594316099584L, 4428);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      GMTrace.o(594316099584L, 4428);
      return null;
    }
    h localh = (h)this.hxV.get(paramString);
    if (localh == null)
    {
      v.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      GMTrace.o(594316099584L, 4428);
      return null;
    }
    if (localh.hyM != null)
    {
      paramString = localh.hyM.i(paramString, paramArrayOfByte);
      GMTrace.o(594316099584L, 4428);
      return paramString;
    }
    v.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    GMTrace.o(594316099584L, 4428);
    return null;
  }
  
  public final boolean iP(String paramString)
  {
    GMTrace.i(593645010944L, 4423);
    h localh = (h)this.hxV.remove(paramString);
    if (localh != null)
    {
      g.En();
      b.iI(paramString);
      com.tencent.mm.plugin.report.service.g.oSF.i(10769, new Object[] { Integer.valueOf(d.hys), Integer.valueOf(localh.field_fileType), Long.valueOf(bf.NA() - localh.field_startTime) });
    }
    this.hxU.remove(paramString);
    v.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localh, Integer.valueOf(0) });
    GMTrace.o(593645010944L, 4423);
    return true;
  }
  
  public final boolean iQ(String paramString)
  {
    GMTrace.i(593779228672L, 4424);
    h localh = (h)this.hxV.remove(paramString);
    if (localh != null)
    {
      if (!localh.hyN) {
        break label150;
      }
      g.En();
      b.iN(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10769, new Object[] { Integer.valueOf(d.hyr), Integer.valueOf(localh.field_fileType), Long.valueOf(bf.NA() - localh.field_startTime) });
      this.hxU.remove(paramString);
      this.hxW.remove(paramString);
      v.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localh, Integer.valueOf(0) });
      GMTrace.o(593779228672L, 4424);
      return true;
      label150:
      if (localh.hyS)
      {
        g.En();
        b.iO(paramString);
      }
      else
      {
        g.En();
        b.iJ(paramString);
      }
    }
  }
  
  public final void onPreloadCompleted(final String paramString, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(17505615609856L, 130427);
    if (bf.mA(paramString))
    {
      GMTrace.o(17505615609856L, 130427);
      return;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17505884045312L, 130429);
        h localh = (h)c.this.hxV.get(paramString);
        if (localh == null)
        {
          v.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          GMTrace.o(17505884045312L, 130429);
          return;
        }
        if (localh.hyX != null) {
          localh.hyX.onPreloadCompleted(paramString, paramInt1, paramInt2);
        }
        GMTrace.o(17505884045312L, 130429);
      }
    });
    GMTrace.o(17505615609856L, 130427);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */