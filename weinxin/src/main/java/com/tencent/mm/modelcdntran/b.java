package com.tencent.mm.modelcdntran;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.ICallback;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.e;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements CdnLogic.ICallback
{
  public static int MediaType_FAVORITE_FILE;
  public static int MediaType_FAVORITE_VIDEO;
  public static int MediaType_FILE;
  public static int MediaType_FRIENDS;
  public static int MediaType_FULLSIZEIMAGE;
  public static int MediaType_IMAGE;
  public static int MediaType_THUMBIMAGE;
  public static int MediaType_TinyVideo;
  public static int MediaType_VIDEO;
  public static int hxA;
  public static int hxB;
  public static int hxC;
  public static int hxD;
  public static int hxE;
  public static int hxF;
  public static int hxG;
  public static int hxH;
  public static int hxI;
  public static int hxJ;
  public static int hxs;
  public static int hxt;
  public static int hxu;
  public static int hxv;
  public static int hxw;
  public static int hxx;
  public static int hxy;
  public static int hxz;
  private if hxK;
  b hxL;
  public int hxM;
  public int hxN;
  public String hxO;
  private ai hxP;
  public a hxQ;
  
  static
  {
    GMTrace.i(589081608192L, 4389);
    hxs = 1;
    hxt = 2;
    hxu = 3;
    MediaType_FULLSIZEIMAGE = 1;
    MediaType_IMAGE = 2;
    MediaType_THUMBIMAGE = 3;
    MediaType_VIDEO = 4;
    MediaType_FILE = 5;
    MediaType_TinyVideo = 6;
    hxv = 7;
    MediaType_FAVORITE_FILE = 10001;
    MediaType_FAVORITE_VIDEO = 10002;
    hxw = 10011;
    MediaType_FRIENDS = 20201;
    hxx = 20202;
    hxy = 20301;
    hxz = 20302;
    hxA = 20304;
    hxB = 20303;
    hxC = 20321;
    hxD = 20322;
    hxE = 100;
    hxF = 101;
    hxG = 102;
    hxH = 103;
    hxI = 32768;
    hxJ = 7340033;
    GMTrace.o(589081608192L, 4389);
  }
  
  public b(String paramString, b paramb)
  {
    GMTrace.i(14591882952704L, 108718);
    this.hxK = null;
    this.hxL = null;
    this.hxM = 0;
    this.hxN = 0;
    this.hxO = "";
    this.hxP = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(582370721792L, 4339);
        if ((b.this.hxM == 0) && (b.this.hxN == 0))
        {
          GMTrace.o(582370721792L, 4339);
          return false;
        }
        v.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { b.this.hxO, Integer.valueOf(b.this.hxM), Integer.valueOf(b.this.hxN) });
        ag.a.hlB.aH(b.this.hxN, b.this.hxM);
        b.this.hxM = 0;
        b.this.hxN = 0;
        GMTrace.o(582370721792L, 4339);
        return true;
      }
    }, true);
    this.hxL = paramb;
    CdnLogic.setCallBack(this);
    CdnLogic.onCreate(paramString);
    CdnLogic.setRSAPublicKeyParams("1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001");
    CdnLogic.setToUserCiper("cdnwx2013usrname");
    GMTrace.o(14591882952704L, 108718);
  }
  
  public static String Ee()
  {
    GMTrace.i(583712899072L, 4349);
    String str = CdnLogic.createAeskey();
    GMTrace.o(583712899072L, 4349);
    return str;
  }
  
  public static int a(h paramh, int paramInt)
  {
    GMTrace.i(17504139214848L, 130416);
    paramInt = CdnLogic.startVideoStreamingDownload(a(paramh), paramInt);
    GMTrace.o(17504139214848L, 130416);
    return paramInt;
  }
  
  public static int a(String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(584249769984L, 4353);
    CdnLogic.C2CDownloadResult localC2CDownloadResult = new CdnLogic.C2CDownloadResult();
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, localC2CDownloadResult);
    a(localC2CDownloadResult, paramkeep_SceneResult);
    GMTrace.o(584249769984L, 4353);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    GMTrace.i(14894141276160L, 110970);
    v.i("MicroMsg.CdnTransportEngine", "startHttpsDownload: mediaid:" + paramString1);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.savePath = paramString3;
    localC2CDownloadRequest.queueTimeoutSeconds = paramInt1;
    localC2CDownloadRequest.transforTimeoutSeconds = paramInt2;
    localC2CDownloadRequest.iplist = paramArrayOfString;
    paramInt1 = CdnLogic.startHttpsDownload(localC2CDownloadRequest);
    GMTrace.o(14894141276160L, 110970);
    return paramInt1;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(17504273432576L, 130417);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.initialDownloadOffset = paramInt2;
    localC2CDownloadRequest.initialDownloadLength = paramInt3;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.iplist = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.iplist = null)
    {
      localC2CDownloadRequest.preloadRatio = paramInt4;
      paramInt1 = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, paramInt1);
      GMTrace.o(17504273432576L, 130417);
      return paramInt1;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean, String paramString5, String paramString6, int paramInt4)
  {
    GMTrace.i(17504004997120L, 130415);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20202;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.initialDownloadOffset = paramInt2;
    localC2CDownloadRequest.initialDownloadLength = paramInt3;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.iplist = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.iplist = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt4;
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, paramInt1);
      GMTrace.o(17504004997120L, 130415);
      return paramInt1;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    GMTrace.i(18739613401088L, 139621);
    v.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:" + paramString1);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.bakup_url = paramString4;
    localC2CDownloadRequest.savePath = paramString2;
    localC2CDownloadRequest.queueTimeoutSeconds = paramInt1;
    localC2CDownloadRequest.transforTimeoutSeconds = paramInt2;
    localC2CDownloadRequest.iplist = paramArrayOfString;
    if (paramMap != null)
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        localC2CDownloadRequest.serialized_verify_headers += (String)paramString2.getKey();
        localC2CDownloadRequest.serialized_verify_headers += ":";
        localC2CDownloadRequest.serialized_verify_headers += (String)paramString2.getValue();
        localC2CDownloadRequest.serialized_verify_headers += ";";
      }
    }
    localC2CDownloadRequest.allow_mobile_net_download = paramBoolean;
    paramInt1 = CdnLogic.startHttpMultiSocketDownloadTask(localC2CDownloadRequest);
    GMTrace.o(18739613401088L, 139621);
    return paramInt1;
  }
  
  static CdnLogic.C2CDownloadRequest a(h paramh)
  {
    boolean bool = true;
    GMTrace.i(583176028160L, 4345);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileid = paramh.field_fileId;
    localC2CDownloadRequest.aeskey = paramh.field_aesKey;
    localC2CDownloadRequest.fileType = paramh.field_fileType;
    localC2CDownloadRequest.fileKey = paramh.field_mediaId;
    localC2CDownloadRequest.fileSize = paramh.field_totalLen;
    localC2CDownloadRequest.savePath = paramh.field_fullpath;
    localC2CDownloadRequest.isStorageMode = paramh.field_needStorage;
    if (paramh.field_smallVideoFlag == 1) {}
    for (;;)
    {
      localC2CDownloadRequest.isSmallVideo = bool;
      localC2CDownloadRequest.isLargeSVideo = paramh.field_largesvideo;
      localC2CDownloadRequest.limitRate = paramh.field_limitrate;
      localC2CDownloadRequest.isAutoStart = paramh.field_autostart;
      localC2CDownloadRequest.chatType = paramh.field_chattype;
      localC2CDownloadRequest.isSilentTask = paramh.field_isSilentTask;
      localC2CDownloadRequest.requestVideoFormat = paramh.field_requestVideoFormat;
      localC2CDownloadRequest.isColdSnsData = paramh.field_isColdSnsData;
      localC2CDownloadRequest.signalQuality = paramh.field_signalQuality;
      localC2CDownloadRequest.snsScene = paramh.field_snsScene;
      localC2CDownloadRequest.requestVideoFormat = paramh.field_requestVideoFormat;
      localC2CDownloadRequest.videofileid = paramh.field_videoFileId;
      localC2CDownloadRequest.bigfileSignature = paramh.field_svr_signature;
      if (bf.mA(localC2CDownloadRequest.bigfileSignature)) {
        localC2CDownloadRequest.bigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignature = paramh.field_fake_bigfile_signature;
      if (bf.mA(localC2CDownloadRequest.fakeBigfileSignature)) {
        localC2CDownloadRequest.fakeBigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignatureAeskey = paramh.field_fake_bigfile_signature_aeskey;
      if (bf.mA(localC2CDownloadRequest.fakeBigfileSignatureAeskey)) {
        localC2CDownloadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CDownloadRequest.msgExtra = paramh.field_wxmsgparam;
      if (bf.mA(localC2CDownloadRequest.msgExtra)) {
        localC2CDownloadRequest.msgExtra = "";
      }
      localC2CDownloadRequest.queueTimeoutSeconds = 0;
      localC2CDownloadRequest.transforTimeoutSeconds = 0;
      localC2CDownloadRequest.initialDownloadLength = paramh.initialDownloadLength;
      localC2CDownloadRequest.initialDownloadOffset = paramh.initialDownloadOffset;
      localC2CDownloadRequest.preloadRatio = paramh.field_preloadRatio;
      GMTrace.o(583176028160L, 4345);
      return localC2CDownloadRequest;
      bool = false;
    }
  }
  
  private static CdnLogic.CdnInfo a(if paramif)
  {
    GMTrace.i(584652423168L, 4356);
    CdnLogic.CdnInfo localCdnInfo = new CdnLogic.CdnInfo();
    localCdnInfo.ver = paramif.tkZ;
    localCdnInfo.uin = paramif.lcP;
    localCdnInfo.frontid = paramif.tlb;
    localCdnInfo.zoneid = paramif.tlg;
    localCdnInfo.nettype = d.aT(aa.getContext());
    localCdnInfo.authkey = com.tencent.mm.platformtools.n.a(paramif.tlf);
    if (paramif.tlc >= 2)
    {
      localCdnInfo.frontip1 = com.tencent.mm.platformtools.n.a((avu)paramif.tld.get(0));
      localCdnInfo.frontip2 = com.tencent.mm.platformtools.n.a((avu)paramif.tld.get(1));
      v.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    if (paramif.tlh >= 2)
    {
      localCdnInfo.zoneip1 = com.tencent.mm.platformtools.n.a((avu)paramif.tli.get(0));
      localCdnInfo.zoneip2 = com.tencent.mm.platformtools.n.a((avu)paramif.tli.get(1));
      v.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    int j;
    int i;
    if (paramif.tll > 0)
    {
      j = ((ig)paramif.tlj.get(0)).tln;
      localCdnInfo.frontports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.frontports[i] = ((Integer)((ig)paramif.tlj.get(0)).tlo.get(i)).intValue();
        i += 1;
      }
    }
    if (paramif.tlm > 0)
    {
      j = ((ig)paramif.tlk.get(0)).tln;
      localCdnInfo.zoneports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.zoneports[i] = ((Integer)((ig)paramif.tlk.get(0)).tlo.get(i)).intValue();
        i += 1;
      }
    }
    GMTrace.o(584652423168L, 4356);
    return localCdnInfo;
  }
  
  private static keep_SceneResult a(CdnLogic.C2CDownloadResult paramC2CDownloadResult, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(587202560000L, 4375);
    keep_SceneResult localkeep_SceneResult = paramkeep_SceneResult;
    if (paramkeep_SceneResult == null) {
      localkeep_SceneResult = new keep_SceneResult();
    }
    localkeep_SceneResult.field_retCode = paramC2CDownloadResult.errorCode;
    localkeep_SceneResult.field_argInfo = paramC2CDownloadResult.argInfo;
    localkeep_SceneResult.field_fileLength = paramC2CDownloadResult.fileSize;
    localkeep_SceneResult.field_fileId = paramC2CDownloadResult.fileid;
    localkeep_SceneResult.field_transInfo = paramC2CDownloadResult.transforMsg;
    localkeep_SceneResult.field_convert2baseline = false;
    localkeep_SceneResult.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
    localkeep_SceneResult.field_videoFormat = paramC2CDownloadResult.videoFormat;
    localkeep_SceneResult.field_enQueueTime = paramC2CDownloadResult.enQueueTime;
    localkeep_SceneResult.field_startTime = paramC2CDownloadResult.startTime;
    localkeep_SceneResult.field_endTime = paramC2CDownloadResult.endTime;
    localkeep_SceneResult.field_firstRequestCost = paramC2CDownloadResult.firstRequestCost;
    localkeep_SceneResult.field_firstRequestSize = paramC2CDownloadResult.firstRequestSize;
    localkeep_SceneResult.field_firstRequestDownloadSize = paramC2CDownloadResult.firstRequestDownloadSize;
    localkeep_SceneResult.field_firstRequestCompleted = paramC2CDownloadResult.firstRequestCompleted;
    localkeep_SceneResult.field_averageSpeed = paramC2CDownloadResult.averageSpeed;
    localkeep_SceneResult.field_averageConnectCost = paramC2CDownloadResult.averageConnectCost;
    localkeep_SceneResult.field_firstConnectCost = paramC2CDownloadResult.firstConnectCost;
    localkeep_SceneResult.field_netConnectTimes = paramC2CDownloadResult.netConnectTimes;
    localkeep_SceneResult.field_moovRequestTimes = paramC2CDownloadResult.moovRequestTimes;
    localkeep_SceneResult.field_moovCost = paramC2CDownloadResult.moovCost;
    localkeep_SceneResult.field_moovSize = paramC2CDownloadResult.moovSize;
    localkeep_SceneResult.field_moovCompleted = paramC2CDownloadResult.moovCompleted;
    localkeep_SceneResult.field_moovFailReason = paramC2CDownloadResult.moovFailReason;
    localkeep_SceneResult.field_httpStatusCode = paramC2CDownloadResult.httpStatusCode;
    localkeep_SceneResult.field_httpResponseHeader = paramC2CDownloadResult.httpResponseHeader;
    if (paramC2CDownloadResult.usedSvrIps != null) {
      localkeep_SceneResult.field_usedSvrIps = ((String[])paramC2CDownloadResult.usedSvrIps.clone());
    }
    GMTrace.o(587202560000L, 4375);
    return localkeep_SceneResult;
  }
  
  public static void a(c paramc)
  {
    GMTrace.i(584920858624L, 4358);
    v.i("MicroMsg.CdnTransportEngine", "set WXConfig:" + paramc);
    CdnLogic.Config localConfig = new CdnLogic.Config();
    localConfig.AckSlice = paramc.field_AckSlice;
    localConfig.UseDynamicETL = paramc.field_UseDynamicETL;
    localConfig.UseStreamCDN = paramc.field_UseStreamCDN;
    localConfig.C2COverloadDelaySeconds = paramc.field_C2COverloadDelaySeconds;
    localConfig.SNSOverloadDelaySeconds = paramc.field_SNSOverloadDelaySeconds;
    localConfig.EnableCDNVerifyConnect = paramc.field_EnableCDNVerifyConnect;
    localConfig.EnableCDNVideoRedirectOC = paramc.field_EnableCDNVideoRedirectOC;
    localConfig.EnableStreamUploadVideo = paramc.field_EnableStreamUploadVideo;
    localConfig.EnableSafeCDN = paramc.field_EnableSafeCDN;
    localConfig.EnableSnsStreamDownload = paramc.field_EnableSnsStreamDownload;
    localConfig.WifiEtl = paramc.field_WifiEtl;
    localConfig.MobileEtl = paramc.field_noWifiEtl;
    localConfig.onlyrecvPtl = paramc.field_onlyrecvPtl;
    localConfig.onlysendETL = paramc.field_onlysendETL;
    localConfig.Ptl = paramc.field_Ptl;
    CdnLogic.setConfig(localConfig);
    GMTrace.o(584920858624L, 4358);
  }
  
  private static void a(keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(586531471360L, 4370);
    if ((paramkeep_SceneResult != null) && (!bf.mA(paramkeep_SceneResult.field_transInfo)))
    {
      int i = paramkeep_SceneResult.field_transInfo.indexOf("@,");
      if (i > 0)
      {
        paramkeep_SceneResult.report_Part2 = paramkeep_SceneResult.field_transInfo.substring(i + 2);
        paramkeep_SceneResult.field_transInfo = paramkeep_SceneResult.field_transInfo.substring(0, i);
      }
      v.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[] { paramkeep_SceneResult.field_transInfo, paramkeep_SceneResult.report_Part2 });
    }
    GMTrace.o(586531471360L, 4370);
  }
  
  public static int iI(String paramString)
  {
    GMTrace.i(583310245888L, 4346);
    CdnLogic.cancelTask(paramString);
    GMTrace.o(583310245888L, 4346);
    return 0;
  }
  
  public static int iJ(String paramString)
  {
    GMTrace.i(583444463616L, 4347);
    CdnLogic.cancelTask(paramString);
    GMTrace.o(583444463616L, 4347);
    return 0;
  }
  
  public static String iK(String paramString)
  {
    GMTrace.i(583578681344L, 4348);
    paramString = CdnLogic.getFileMD5(paramString);
    GMTrace.o(583578681344L, 4348);
    return paramString;
  }
  
  public static int iL(String paramString)
  {
    GMTrace.i(583847116800L, 4350);
    int i = CdnLogic.getFileCrc32(paramString);
    GMTrace.o(583847116800L, 4350);
    return i;
  }
  
  public static String iM(String paramString)
  {
    GMTrace.i(583981334528L, 4351);
    paramString = CdnLogic.getMP4IdentifyMD5(paramString);
    GMTrace.o(583981334528L, 4351);
    return paramString;
  }
  
  public static int iN(String paramString)
  {
    GMTrace.i(18739479183360L, 139620);
    v.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:" + paramString);
    CdnLogic.cancelTask(paramString);
    GMTrace.o(18739479183360L, 139620);
    return 0;
  }
  
  public static int iO(String paramString)
  {
    GMTrace.i(18739747618816L, 139622);
    v.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:" + paramString);
    CdnLogic.cancelTask(paramString);
    GMTrace.o(18739747618816L, 139622);
    return 0;
  }
  
  public static boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(584518205440L, 4355);
    boolean bool = CdnLogic.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    GMTrace.o(584518205440L, 4355);
    return bool;
  }
  
  public static int keep_callFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    GMTrace.i(583041810432L, 4344);
    if (paramInt1 == hxE) {
      d.a(paramArrayOfByte, "MicroMsg.CdnEngine", paramInt2);
    }
    GMTrace.o(583041810432L, 4344);
    return 0;
  }
  
  public static int requestVideoData(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(584383987712L, 4354);
    paramInt1 = CdnLogic.requestVideoData(paramString, paramInt1, paramInt2, 0);
    GMTrace.o(584383987712L, 4354);
    return paramInt1;
  }
  
  public final boolean Ef()
  {
    GMTrace.i(17504407650304L, 130418);
    if (this.hxK == null)
    {
      GMTrace.o(17504407650304L, 130418);
      return true;
    }
    GMTrace.o(17504407650304L, 130418);
    return false;
  }
  
  public final void RequestGetCDN(int paramInt)
  {
    GMTrace.i(15218277089280L, 113385);
    v.i("MicroMsg.CdnTransportEngine", "requestgetcdn %d", new Object[] { Integer.valueOf(paramInt) });
    keep_OnRequestDoGetCdnDnsInfo(paramInt);
    GMTrace.o(15218277089280L, 113385);
  }
  
  public final boolean a(if paramif1, if paramif2, if paramif3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, if paramif4)
  {
    GMTrace.i(584786640896L, 4357);
    v.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[] { this.hxK, paramif1, paramif4, bf.bJP() });
    if ((paramif1 == null) && (paramArrayOfByte1 == null))
    {
      GMTrace.o(584786640896L, 4357);
      return false;
    }
    this.hxK = paramif1;
    try
    {
      paramif1 = a(paramif1);
      paramif2 = a(paramif2);
      paramif3 = a(paramif3);
      paramif4 = a(paramif4);
      CdnLogic.setLegacyCdnInfo(paramif1, paramif2, paramif3, paramif4, paramArrayOfByte1, paramArrayOfByte2);
      CdnLogic.setDebugIP("");
      if ((r.iiV) && (r.iiM != null) && (r.iiM.length() >= 7))
      {
        v.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", new Object[] { r.iiM });
        CdnLogic.setDebugIP(r.iiM);
      }
      GMTrace.o(584786640896L, 4357);
      return true;
    }
    catch (Exception paramif1)
    {
      v.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + paramif1.getLocalizedMessage());
      GMTrace.o(584786640896L, 4357);
    }
    return false;
  }
  
  public final byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(587873648640L, 4380);
    paramString = keep_cdnDecodePrepareResponse(paramString, paramArrayOfByte);
    GMTrace.o(587873648640L, 4380);
    return paramString;
  }
  
  public final byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(587739430912L, 4379);
    paramArrayOfByte = new ByteArrayOutputStream();
    keep_cdnGetSkeyBuf(paramString, paramArrayOfByte);
    if (paramArrayOfByte.size() > 0)
    {
      paramString = paramArrayOfByte.toByteArray();
      GMTrace.o(587739430912L, 4379);
      return paramString;
    }
    GMTrace.o(587739430912L, 4379);
    return null;
  }
  
  public final void keep_OnRequestDoGetCdnDnsInfo(int paramInt)
  {
    GMTrace.i(15218142871552L, 113384);
    com.tencent.mm.kernel.h.vG();
    if (a.uU()) {
      com.tencent.mm.kernel.h.vd().a(new e(paramInt + 1000), 0);
    }
    GMTrace.o(15218142871552L, 113384);
  }
  
  public final byte[] keep_cdnDecodePrepareResponse(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(585994600448L, 4366);
    if (this.hxL != null)
    {
      paramString = this.hxL.i(paramString, paramArrayOfByte);
      GMTrace.o(585994600448L, 4366);
      return paramString;
    }
    GMTrace.o(585994600448L, 4366);
    return null;
  }
  
  public final void keep_cdnGetSkeyBuf(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    GMTrace.i(585860382720L, 4365);
    if (this.hxL != null) {
      this.hxL.a(paramString, paramByteArrayOutputStream);
    }
    GMTrace.o(585860382720L, 4365);
  }
  
  public final void keep_cdnSendAndRecvData(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(586665689088L, 4371);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      GMTrace.o(586665689088L, 4371);
      return;
    }
    this.hxM += paramInt1;
    this.hxN += paramInt2;
    if (!bf.mA(paramString)) {
      this.hxO = paramString;
    }
    if (this.hxM + this.hxN > 51200) {
      this.hxP.v(500L, 500L);
    }
    GMTrace.o(586665689088L, 4371);
  }
  
  public final void keep_onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(586263035904L, 4368);
    v.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.hxQ != null) {
      this.hxQ.onDataAvailable(paramString, paramInt1, paramInt2);
    }
    GMTrace.o(586263035904L, 4368);
  }
  
  public final int keep_onDownloadError(String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(585591947264L, 4363);
    if (this.hxQ != null) {}
    for (int i = this.hxQ.a(paramString, null, paramkeep_SceneResult);; i = 0)
    {
      if ((i == 0) && (this.hxL != null))
      {
        a(paramkeep_SceneResult);
        this.hxL.a(paramString, null, paramkeep_SceneResult);
      }
      GMTrace.o(585591947264L, 4363);
      return 0;
    }
  }
  
  public final int keep_onDownloadProgress(String paramString, keep_ProgressInfo paramkeep_ProgressInfo)
  {
    GMTrace.i(585457729536L, 4362);
    if (this.hxQ != null) {}
    for (int i = this.hxQ.a(paramString, paramkeep_ProgressInfo, null);; i = 0)
    {
      if ((i == 0) && (this.hxL != null)) {
        this.hxL.a(paramString, paramkeep_ProgressInfo, null);
      }
      GMTrace.o(585457729536L, 4362);
      return 0;
    }
  }
  
  public final int keep_onDownloadSuccessed(String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(585726164992L, 4364);
    if (this.hxQ != null) {}
    for (int i = this.hxQ.a(paramString, null, paramkeep_SceneResult);; i = 0)
    {
      if ((i == 0) && (this.hxL != null))
      {
        a(paramkeep_SceneResult);
        this.hxL.a(paramString, null, paramkeep_SceneResult);
      }
      GMTrace.o(585726164992L, 4364);
      return 0;
    }
  }
  
  public final void keep_onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(586397253632L, 4369);
    v.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.hxQ != null) {
      this.hxQ.onDownloadToEnd(paramString, paramInt1, paramInt2);
    }
    GMTrace.o(586397253632L, 4369);
  }
  
  public final void keep_onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(586128818176L, 4367);
    v.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.hxQ != null) {
      this.hxQ.onMoovReady(paramString, paramInt1, paramInt2);
    }
    GMTrace.o(586128818176L, 4367);
  }
  
  public final int keep_onUploadError(String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(585189294080L, 4360);
    if (this.hxL != null)
    {
      a(paramkeep_SceneResult);
      this.hxL.a(paramString, null, paramkeep_SceneResult);
    }
    GMTrace.o(585189294080L, 4360);
    return 0;
  }
  
  public final int keep_onUploadProgress(String paramString, keep_ProgressInfo paramkeep_ProgressInfo)
  {
    GMTrace.i(585055076352L, 4359);
    if (this.hxL != null)
    {
      v.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[] { paramString, Integer.valueOf(paramkeep_ProgressInfo.field_toltalLength), Integer.valueOf(paramkeep_ProgressInfo.field_finishedLength) });
      this.hxL.a(paramString, paramkeep_ProgressInfo, null);
    }
    GMTrace.o(585055076352L, 4359);
    return 0;
  }
  
  public final int keep_onUploadSuccessed(String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(585323511808L, 4361);
    if (this.hxL != null)
    {
      v.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[] { paramString });
      a(paramkeep_SceneResult);
      this.hxL.a(paramString, null, paramkeep_SceneResult);
    }
    GMTrace.o(585323511808L, 4361);
    return 0;
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    GMTrace.i(587470995456L, 4377);
    paramC2CDownloadResult = a(paramC2CDownloadResult, null);
    if (paramC2CDownloadResult.field_retCode != 0)
    {
      keep_onDownloadError(paramString, paramC2CDownloadResult);
      GMTrace.o(587470995456L, 4377);
      return;
    }
    keep_onDownloadSuccessed(paramString, paramC2CDownloadResult);
    GMTrace.o(587470995456L, 4377);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    GMTrace.i(587336777728L, 4376);
    keep_SceneResult localkeep_SceneResult = new keep_SceneResult();
    localkeep_SceneResult.field_retCode = paramC2CUploadResult.errorCode;
    localkeep_SceneResult.field_toUser = paramC2CUploadResult.touser;
    localkeep_SceneResult.field_UploadHitCacheType = paramC2CUploadResult.hitCache;
    localkeep_SceneResult.field_fileId = paramC2CUploadResult.fileid;
    localkeep_SceneResult.field_aesKey = paramC2CUploadResult.aeskey;
    localkeep_SceneResult.field_filemd5 = paramC2CUploadResult.filemd5;
    localkeep_SceneResult.field_thumbfilemd5 = paramC2CUploadResult.thumbfilemd5;
    localkeep_SceneResult.field_mp4identifymd5 = paramC2CUploadResult.mp4identifymd5;
    localkeep_SceneResult.field_transInfo = paramC2CUploadResult.transforMsg;
    localkeep_SceneResult.field_fileLength = paramC2CUploadResult.fileSize;
    localkeep_SceneResult.field_midimgLength = paramC2CUploadResult.midfileSize;
    localkeep_SceneResult.field_thumbimgLength = paramC2CUploadResult.thumbfileSize;
    if (!paramC2CUploadResult.sendmsgFromCDN) {}
    for (boolean bool = true;; bool = false)
    {
      localkeep_SceneResult.field_needSendMsgField = bool;
      localkeep_SceneResult.field_exist_whencheck = paramC2CUploadResult.existOnSvr;
      if (paramC2CUploadResult.skeyrespbuf != null) {
        localkeep_SceneResult.field_sKeyrespbuf = ((byte[])paramC2CUploadResult.skeyrespbuf.clone());
      }
      localkeep_SceneResult.field_videoFileId = paramC2CUploadResult.videofileid;
      localkeep_SceneResult.field_filecrc = paramC2CUploadResult.fileCrc32;
      localkeep_SceneResult.field_upload_by_safecdn = paramC2CUploadResult.uploadBySafecdn;
      localkeep_SceneResult.field_isVideoReduced = paramC2CUploadResult.isVideoReduced;
      if (paramC2CUploadResult.usedSvrIps != null) {
        localkeep_SceneResult.field_usedSvrIps = ((String[])paramC2CUploadResult.usedSvrIps.clone());
      }
      localkeep_SceneResult.field_fileUrl = paramC2CUploadResult.fileUrl;
      localkeep_SceneResult.field_thumbUrl = paramC2CUploadResult.thumbfileUrl;
      if (localkeep_SceneResult.field_retCode == 0) {
        break;
      }
      keep_onUploadError(paramString, localkeep_SceneResult);
      GMTrace.o(587336777728L, 4376);
      return;
    }
    keep_onUploadSuccessed(paramString, localkeep_SceneResult);
    GMTrace.o(587336777728L, 4376);
  }
  
  public final void onCheckFileidCompleted(String paramString, CdnLogic.CheckFileIDResult paramCheckFileIDResult)
  {
    GMTrace.i(587605213184L, 4378);
    GMTrace.o(587605213184L, 4378);
  }
  
  public final void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(588142084096L, 4382);
    keep_onDataAvailable(paramString, paramInt1, paramInt2);
    GMTrace.o(588142084096L, 4382);
  }
  
  public final void onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(588276301824L, 4383);
    keep_onDownloadToEnd(paramString, paramInt1, paramInt2);
    GMTrace.o(588276301824L, 4383);
  }
  
  public final void onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(588007866368L, 4381);
    keep_onMoovReady(paramString, paramInt1, paramInt2);
    GMTrace.o(588007866368L, 4381);
  }
  
  public final void onPreloadCompleted(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(17504541868032L, 130419);
    if (this.hxL != null) {
      this.hxL.onPreloadCompleted(paramString, paramInt1, paramInt2);
    }
    GMTrace.o(17504541868032L, 130419);
  }
  
  public final void onProgressChanged(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(586934124544L, 4373);
    keep_ProgressInfo localkeep_ProgressInfo = new keep_ProgressInfo();
    localkeep_ProgressInfo.field_finishedLength = paramInt1;
    localkeep_ProgressInfo.field_toltalLength = paramInt2;
    localkeep_ProgressInfo.field_status = 0;
    localkeep_ProgressInfo.field_mtlnotify = false;
    keep_onDownloadProgress(paramString, localkeep_ProgressInfo);
    keep_onUploadProgress(paramString, localkeep_ProgressInfo);
    GMTrace.o(586934124544L, 4373);
  }
  
  public final void onRecvedData(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(587068342272L, 4374);
    GMTrace.o(587068342272L, 4374);
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, keep_ProgressInfo paramkeep_ProgressInfo, keep_SceneResult paramkeep_SceneResult);
    
    public abstract void onDataAvailable(String paramString, int paramInt1, int paramInt2);
    
    public abstract void onDownloadToEnd(String paramString, int paramInt1, int paramInt2);
    
    public abstract void onMoovReady(String paramString, int paramInt1, int paramInt2);
  }
  
  static abstract interface b
  {
    public abstract int a(String paramString, keep_ProgressInfo paramkeep_ProgressInfo, keep_SceneResult paramkeep_SceneResult);
    
    public abstract void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream);
    
    public abstract byte[] i(String paramString, byte[] paramArrayOfByte);
    
    public abstract void onPreloadCompleted(String paramString, int paramInt1, int paramInt2);
  }
  
  final class c
  {
    public int field_AckSlice;
    public int field_C2COverloadDelaySeconds;
    public int field_EnableCDNVerifyConnect;
    public int field_EnableCDNVideoRedirectOC;
    public int field_EnableSafeCDN;
    public int field_EnableSnsStreamDownload;
    public int field_EnableStreamUploadVideo;
    public int field_Ptl;
    public int field_SNSOverloadDelaySeconds;
    public int field_UseDynamicETL;
    public int field_UseStreamCDN;
    public int field_WifiEtl;
    public int field_noWifiEtl;
    public boolean field_onlyrecvPtl;
    public boolean field_onlysendETL;
    
    c()
    {
      GMTrace.i(591631745024L, 4408);
      this.field_WifiEtl = 90;
      this.field_noWifiEtl = 70;
      this.field_Ptl = 35;
      this.field_UseStreamCDN = 1;
      this.field_AckSlice = 8192;
      this.field_EnableCDNVerifyConnect = 1;
      this.field_EnableCDNVideoRedirectOC = 1;
      this.field_EnableStreamUploadVideo = 1;
      this.field_UseDynamicETL = 0;
      this.field_C2COverloadDelaySeconds = 10;
      this.field_SNSOverloadDelaySeconds = 60;
      this.field_EnableSafeCDN = 0;
      this.field_EnableSnsStreamDownload = 0;
      this.field_onlysendETL = false;
      this.field_onlyrecvPtl = false;
      GMTrace.o(591631745024L, 4408);
    }
    
    public final String toString()
    {
      GMTrace.i(591765962752L, 4409);
      String str = String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d", new Object[] { Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload) });
      GMTrace.o(591765962752L, 4409);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */