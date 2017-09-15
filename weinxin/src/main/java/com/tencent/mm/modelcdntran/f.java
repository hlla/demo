package com.tencent.mm.modelcdntran;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.iu;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.a.kk.a;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f
  implements b.a, com.tencent.mm.y.e
{
  public Queue<String> hxT;
  public Map<String, i> hxU;
  public Map<String, i> hxV;
  public Map<String, i> hyA;
  public Map<String, keep_SceneResult> hyB;
  
  public f()
  {
    GMTrace.i(578881060864L, 4313);
    this.hxT = new LinkedList();
    this.hxU = new HashMap();
    this.hxV = new HashMap();
    this.hyA = new HashMap();
    this.hyB = new HashMap();
    com.tencent.mm.kernel.h.vd().a(379, this);
    GMTrace.o(578881060864L, 4313);
  }
  
  public static i a(an paraman, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    GMTrace.i(17447767769088L, 129996);
    if (paraman == null)
    {
      v.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      GMTrace.o(17447767769088L, 129996);
      return null;
    }
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      GMTrace.o(17447767769088L, 129996);
      return null;
    }
    Object localObject = com.tencent.mm.modelvideo.t.lI(paramString3);
    if (localObject == null)
    {
      v.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      GMTrace.o(17447767769088L, 129996);
      return null;
    }
    String str = d.a("snsvideo", paraman.cId, "sns", paramString1);
    if (bf.mA(str))
    {
      v.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      GMTrace.o(17447767769088L, 129996);
      return null;
    }
    i locali = new i();
    locali.filename = paramString3;
    locali.field_fullpath = paramString2;
    locali.field_mediaId = str;
    locali.hyW = 2;
    locali.hzb = paramInt;
    locali.hzd = ((r)localObject).hzd;
    if (paraman == null) {
      paramString2 = "";
    }
    for (;;)
    {
      paramInt = com.tencent.mm.protocal.d.sXh;
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG();
      localObject = com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.uH());
      int i = al.getNetTypeForStat(aa.getContext());
      int j = al.getStrength(aa.getContext());
      label256:
      long l1;
      if (!bf.mA(paramString2))
      {
        paramString3 = "&scene=" + paramString2;
        locali.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(paramInt), localObject, Integer.valueOf(i), Integer.valueOf(j), paramString3 });
        locali.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        v.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(paraman.cId) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(paraman, locali.url, l1, paramString1);; bool = false)
      {
        try
        {
          locali.host = new URL(locali.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.a(bool, paramString1, locali.host);
          locali.iplist = new String[paramString1.size()];
          paramString1.toArray(locali.iplist);
          if (bf.az(paraman.cId) <= l1) {
            continue;
          }
          bool = true;
          locali.isColdSnsData = bool;
          locali.signalQuality = al.getStrength(aa.getContext());
          locali.snsScene = paramString2;
          GMTrace.o(17447767769088L, 129996);
          return locali;
        }
        catch (Exception paraman)
        {
          v.printErrStackTrace("MicroMsg.OnlineVideoService", paraman, "check can sns online video error taskInfo %s", new Object[] { locali });
          GMTrace.o(17447767769088L, 129996);
          return null;
        }
        if (paraman.equals(an.uHQ))
        {
          paramString2 = "album_friend";
          break;
        }
        if (paraman.equals(an.uHR))
        {
          paramString2 = "album_self";
          break;
        }
        if (paraman.equals(an.uHS))
        {
          paramString2 = "album_stranger";
          break;
        }
        if (paraman.equals(an.uHT))
        {
          paramString2 = "profile_friend";
          break;
        }
        if (paraman.equals(an.uHU))
        {
          paramString2 = "profile_stranger";
          break;
        }
        if (paraman.equals(an.uHV))
        {
          paramString2 = "comment";
          break;
        }
        if (paraman.equals(an.uHP))
        {
          paramString2 = "timeline";
          break;
        }
        if (!paraman.equals(an.uHY)) {
          break label722;
        }
        paramString2 = "snssight";
        break;
        paramString3 = "";
        break label256;
      }
      label722:
      paramString2 = "";
    }
  }
  
  public static void a(r paramr, int paramInt, String paramString)
  {
    GMTrace.i(580089020416L, 4322);
    v.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (paramr != null)
    {
      com.tencent.mm.modelvideo.t.H(paramr.getFileName(), paramInt);
      paramr = paramr.getFileName();
      if (!bf.mA(paramString))
      {
        com.tencent.mm.modelvideo.o.KW();
        paramr = s.lw(paramr);
        if ((bf.mA(paramString)) || (paramInt <= 0) || (bf.mA(paramr)))
        {
          v.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString, paramr });
          GMTrace.o(580089020416L, 4322);
          return;
        }
        ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().p(paramString, paramInt, paramr);
      }
    }
    GMTrace.o(580089020416L, 4322);
  }
  
  public static void a(Object[] paramArrayOfObject, keep_SceneResult paramkeep_SceneResult, i parami, boolean paramBoolean)
  {
    GMTrace.i(580491673600L, 4325);
    if ((parami == null) || (paramkeep_SceneResult == null))
    {
      v.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      GMTrace.o(580491673600L, 4325);
      return;
    }
    if (parami.Eq())
    {
      GMTrace.o(580491673600L, 4325);
      return;
    }
    v.i("MicroMsg.OnlineVideoService", "rpt online video format[%d]", new Object[] { Integer.valueOf(paramkeep_SceneResult.field_videoFormat) });
    if (paramkeep_SceneResult.field_videoFormat == 2)
    {
      localObject1 = parami.filename;
      localObject2 = com.tencent.mm.modelvideo.t.lI((String)localObject1);
      if (localObject2 != null)
      {
        ((r)localObject2).videoFormat = 2;
        ((r)localObject2).fRM = 2;
        v.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.o.KW().b((r)localObject2)), localObject1, Integer.valueOf(2) });
      }
    }
    boolean bool = parami.Ep();
    Object localObject1 = new PInt();
    Object localObject2 = new PInt();
    ((PInt)localObject2).value = 0;
    ((PInt)localObject1).value = 0;
    com.tencent.mm.modelvideo.t.a(parami.field_fullpath, (PInt)localObject1, (PInt)localObject2);
    int i6 = ((PInt)localObject1).value;
    int i5 = ((PInt)localObject2).value;
    int m = 0;
    int i1;
    int i2;
    int i3;
    int n;
    int j;
    int k;
    if (paramArrayOfObject != null)
    {
      i1 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      i2 = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      n = ((Integer)paramArrayOfObject[4]).intValue();
      j = ((Integer)paramArrayOfObject[5]).intValue();
      k = ((Integer)paramArrayOfObject[6]).intValue();
    }
    for (;;)
    {
      int i4 = parami.hzd;
      int i = i4;
      if (i4 <= 0)
      {
        if (bool) {
          i = 10;
        }
      }
      else
      {
        i4 = al.ef(aa.getContext());
        localObject1 = new StringBuffer();
        if (!bool) {
          break label1047;
        }
        ((StringBuffer)localObject1).append(parami.field_fileId).append(",").append(parami.field_aesKey).append(",");
        label377:
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_fileLength).append(",").append(i6 * 1000).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_recvedBytes).append(",");
        ((StringBuffer)localObject1).append(i1 + ",").append(i2 + ",").append(i3 + ",");
        ((StringBuffer)localObject1).append(m + ",").append(n + ",");
        ((StringBuffer)localObject1).append(i4).append(",");
        ((StringBuffer)localObject1).append(i).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_startTime).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_endTime).append(",");
        if (!bool) {
          break label1093;
        }
        if (parami.hzc == null) {
          break label1079;
        }
        paramArrayOfObject = com.tencent.mm.a.g.n(parami.hzc.getBytes());
        label633:
        ((StringBuffer)localObject1).append(paramArrayOfObject).append(",");
        if (!com.tencent.mm.u.o.dH(parami.hzc)) {
          break label1087;
        }
        i = 1;
        label659:
        ((StringBuffer)localObject1).append(i).append(",");
        label673:
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_retCode).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_enQueueTime).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_firstRequestCost).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_firstRequestSize).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_firstRequestDownloadSize).append(",");
        if (!paramkeep_SceneResult.field_firstRequestCompleted) {
          break label1125;
        }
        i = 1;
        label763:
        ((StringBuffer)localObject1).append(i).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_averageSpeed).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_averageConnectCost).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_firstConnectCost).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_netConnectTimes).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_moovRequestTimes).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_moovCost).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_moovSize).append(",");
        if (!paramkeep_SceneResult.field_moovCompleted) {
          break label1131;
        }
      }
      label1047:
      label1079:
      label1087:
      label1093:
      label1125:
      label1131:
      for (i = 1;; i = 0)
      {
        ((StringBuffer)localObject1).append(i).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_moovFailReason).append(",");
        ((StringBuffer)localObject1).append(j).append(",");
        ((StringBuffer)localObject1).append(k).append(",");
        if (!bool) {
          break label1137;
        }
        ((StringBuffer)localObject1).append(i5).append(",");
        paramArrayOfObject = "";
        if (paramkeep_SceneResult.field_usedSvrIps == null) {
          break label1198;
        }
        paramArrayOfObject = new StringBuffer();
        localObject2 = paramkeep_SceneResult.field_usedSvrIps;
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramArrayOfObject.append(localObject2[i]).append("|");
          i += 1;
        }
        i = 31;
        break;
        ((StringBuffer)localObject1).append(parami.url).append(",").append(parami.hze).append(",");
        break label377;
        paramArrayOfObject = Integer.valueOf(0);
        break label633;
        i = 0;
        break label659;
        ((StringBuffer)localObject1).append(0).append(",");
        ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_httpStatusCode).append(",");
        break label673;
        i = 0;
        break label763;
      }
      label1137:
      ((StringBuffer)localObject1).append(i5).append(",");
      if (parami.hzc != null) {}
      for (paramArrayOfObject = com.tencent.mm.a.g.n(parami.hzc.getBytes());; paramArrayOfObject = Integer.valueOf(0))
      {
        ((StringBuffer)localObject1).append(paramArrayOfObject).append(",");
        break;
      }
      paramArrayOfObject = paramArrayOfObject.toString();
      label1198:
      ((StringBuffer)localObject1).append(paramArrayOfObject).append(",");
      ((StringBuffer)localObject1).append(parami.hzf).append(",");
      ((StringBuffer)localObject1).append(parami.fTG).append(",");
      ((StringBuffer)localObject1).append(parami.initialDownloadLength).append(",");
      ((StringBuffer)localObject1).append(paramkeep_SceneResult.field_videoFormat);
      long l1;
      long l2;
      String str1;
      String[] arrayOfString;
      String str2;
      if (bool)
      {
        i = 13570;
        paramArrayOfObject = ((StringBuffer)localObject1).toString();
        v.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(i), paramArrayOfObject });
        com.tencent.mm.plugin.report.service.g.oSF.A(i, paramArrayOfObject);
        if (paramBoolean)
        {
          paramArrayOfObject = parami.fOl;
          localObject1 = parami.hzc;
          m = parami.fOn;
          localObject2 = paramkeep_SceneResult.field_fileId;
          l1 = paramkeep_SceneResult.field_startTime;
          l2 = paramkeep_SceneResult.field_endTime;
          str1 = parami.field_fullpath;
          arrayOfString = paramkeep_SceneResult.field_usedSvrIps;
          str2 = parami.url;
          String str3 = parami.filename;
          n = parami.hzg;
          parami = com.tencent.mm.modelvideo.t.lI(str3);
          if (parami == null) {
            break label1686;
          }
          j = parami.fOr;
        }
      }
      for (k = parami.hrb;; k = 0)
      {
        if (n <= 0)
        {
          i = 1;
          parami = new iu();
          parami.fOk.fOl = paramArrayOfObject;
          parami.fOk.fOm = ((String)localObject1);
          parami.fOk.fOn = m;
          parami.fOk.fOo = ((String)localObject2);
          parami.fOk.netType = i4;
          parami.fOk.startTime = l1;
          parami.fOk.endTime = l2;
          parami.fOk.path = str1;
          parami.fOk.fOp = arrayOfString;
          parami.fOk.fOq = str2;
          parami.fOk.fOr = j;
          parami.fOk.fOs = i;
          com.tencent.mm.sdk.b.a.uql.m(parami);
          if (!bool) {
            break label1676;
          }
          if (paramkeep_SceneResult.field_videoFormat != 2) {
            break label1662;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 132L, 1L, false);
          GMTrace.o(580491673600L, 4325);
          return;
          i = 13790;
          break;
        }
        i1 = (int)(n / 100.0F * k);
        if (j < i1) {}
        for (i = 2;; i = 3)
        {
          v.d("MicroMsg.OnlineVideoService", "rptMediaInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(j) });
          break;
        }
        label1662:
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 133L, 1L, false);
        label1676:
        GMTrace.o(580491673600L, 4325);
        return;
        label1686:
        j = 0;
      }
      j = 0;
      k = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      n = 0;
    }
  }
  
  private static boolean a(an paraman, String paramString1, long paramLong, String paramString2)
  {
    GMTrace.i(580357455872L, 4324);
    if (paramString1 == null)
    {
      GMTrace.o(580357455872L, 4324);
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      if (paraman == null)
      {
        GMTrace.o(580357455872L, 4324);
        return false;
      }
      if (paramString2 == null)
      {
        GMTrace.o(580357455872L, 4324);
        return false;
      }
      int i = paramString2.indexOf(paramString1.getHost());
      if (i == -1)
      {
        GMTrace.o(580357455872L, 4324);
        return false;
      }
      i = paraman.cId;
      if (i == 0)
      {
        GMTrace.o(580357455872L, 4324);
        return false;
      }
      long l = bf.az(paraman.cId);
      if (l > paramLong)
      {
        GMTrace.o(580357455872L, 4324);
        return true;
      }
      GMTrace.o(580357455872L, 4324);
      return false;
    }
    catch (Exception paraman)
    {
      v.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { paraman.getMessage() });
      GMTrace.o(580357455872L, 4324);
    }
    return false;
  }
  
  public static int e(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(14627450650624L, 108983);
    g.En();
    int i = b.requestVideoData(paramString, paramInt1, paramInt2, 0);
    v.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    GMTrace.o(14627450650624L, 108983);
    return i;
  }
  
  public final int a(final String paramString, final keep_ProgressInfo paramkeep_ProgressInfo, final keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(579954802688L, 4321);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      GMTrace.o(579954802688L, 4321);
      return -1;
    }
    if ((paramkeep_ProgressInfo == null) && (paramkeep_SceneResult == null))
    {
      v.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      GMTrace.o(579954802688L, 4321);
      return -2;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17447230898176L, 129992);
        Object localObject = (i)f.this.hxV.get(paramString);
        if (localObject == null)
        {
          GMTrace.o(17447230898176L, 129992);
          return;
        }
        if (((i)localObject).hzh != null)
        {
          if (paramkeep_ProgressInfo != null)
          {
            ((i)localObject).hzh.f(paramString, paramkeep_ProgressInfo.field_finishedLength, paramkeep_ProgressInfo.field_toltalLength);
            GMTrace.o(17447230898176L, 129992);
            return;
          }
          if (paramkeep_SceneResult != null)
          {
            ((i)localObject).hzh.w(paramString, paramkeep_SceneResult.field_retCode);
            GMTrace.o(17447230898176L, 129992);
            return;
          }
          GMTrace.o(17447230898176L, 129992);
          return;
        }
        r localr = com.tencent.mm.modelvideo.t.lI(((i)localObject).filename);
        if (localr == null)
        {
          v.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((i)localObject).filename });
          GMTrace.o(17447230898176L, 129992);
          return;
        }
        if (((i)localObject).hyM != null)
        {
          ((i)localObject).hyM.a(paramString, 0, paramkeep_ProgressInfo, paramkeep_SceneResult, ((i)localObject).field_onlycheckexist);
          if (paramkeep_SceneResult != null) {
            f.this.hxV.remove(paramString);
          }
          GMTrace.o(17447230898176L, 129992);
          return;
        }
        if (paramkeep_ProgressInfo != null)
        {
          if (paramkeep_ProgressInfo.field_finishedLength == localr.hrb)
          {
            v.i("MicroMsg.OnlineVideoService", "stream download finish.");
            GMTrace.o(17447230898176L, 129992);
            return;
          }
          if ((localr.status != 130) && (localr.hZP > paramkeep_ProgressInfo.field_finishedLength))
          {
            v.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(localr.hZP), Integer.valueOf(paramkeep_ProgressInfo.field_finishedLength) });
            GMTrace.o(17447230898176L, 129992);
            return;
          }
          v.i("MicroMsg.OnlineVideoService", "callback progress info " + paramkeep_ProgressInfo.field_finishedLength);
          localr.hZT = bf.Nz();
          localr.hZP = paramkeep_ProgressInfo.field_finishedLength;
          localr.fRM = 1040;
          com.tencent.mm.modelvideo.t.e(localr);
          localObject = new kk();
          ((kk)localObject).fQF.fJB = 5;
          ((kk)localObject).fQF.mediaId = paramString;
          ((kk)localObject).fQF.offset = paramkeep_ProgressInfo.field_finishedLength;
          ((kk)localObject).fQF.length = paramkeep_ProgressInfo.field_toltalLength;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
          GMTrace.o(17447230898176L, 129992);
          return;
        }
        int i;
        int j;
        if (paramkeep_SceneResult != null)
        {
          v.i("MicroMsg.OnlineVideoService", "callback result info " + paramkeep_SceneResult.field_retCode + ", filesize:" + paramkeep_SceneResult.field_fileLength + ",recved:" + paramkeep_SceneResult.field_recvedBytes);
          if (paramkeep_SceneResult.field_retCode == 0) {
            break label1031;
          }
          if (paramkeep_SceneResult.field_retCode != 55524) {
            com.tencent.mm.modelvideo.t.lB(localr.getFileName());
          }
          boolean bool = ((i)localObject).Ep();
          i = paramkeep_SceneResult.field_retCode;
          j = ((i)localObject).hzb;
          if (!bool) {
            break label940;
          }
          if (j != 1) {
            break label852;
          }
          if (i != -5103059) {
            break label787;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(101), Long.valueOf(bf.Nz()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new kk();
          ((kk)localObject).fQF.fJB = 4;
          ((kk)localObject).fQF.mediaId = paramString;
          ((kk)localObject).fQF.offset = 0;
          ((kk)localObject).fQF.fEO = paramkeep_SceneResult.field_retCode;
          ((kk)localObject).fQF.length = paramkeep_SceneResult.field_fileLength;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
          f.this.hxV.remove(paramString);
          GMTrace.o(17447230898176L, 129992);
          return;
          label787:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 112L, 1L, false);
            break;
          }
          if (i == 55524)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 114L, 1L, false);
          break;
          label852:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 117L, 1L, false);
            break;
          }
          if (i == 55524)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 119L, 1L, false);
          break;
          label940:
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(201), Long.valueOf(bf.Nz()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 215L, 1L, false);
          }
          label1031:
          f.a(localr, paramkeep_SceneResult.field_fileLength, ((i)localObject).hyZ);
          f.this.hyA.put(((i)localObject).field_mediaId, localObject);
          f.this.hyB.put(((i)localObject).field_mediaId, paramkeep_SceneResult);
        }
      }
    });
    if (this.hxV.get(paramString) != null)
    {
      GMTrace.o(579954802688L, 4321);
      return 1;
    }
    GMTrace.o(579954802688L, 4321);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(17447633551360L, 129995);
    if (paramk.getType() != 379)
    {
      GMTrace.o(17447633551360L, 129995);
      return;
    }
    v.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.vG().uV()) {
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(575525617664L, 4288);
          f.this.be(true);
          GMTrace.o(575525617664L, 4288);
        }
      });
    }
    GMTrace.o(17447633551360L, 129995);
  }
  
  public final boolean a(final i parami, boolean paramBoolean)
  {
    GMTrace.i(579015278592L, 4314);
    if (parami == null)
    {
      v.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      GMTrace.o(579015278592L, 4314);
      return false;
    }
    if (bf.mA(parami.field_mediaId))
    {
      v.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      GMTrace.o(579015278592L, 4314);
      return false;
    }
    v.i("MicroMsg.OnlineVideoService", "add download task : " + parami.field_mediaId + " delay : " + paramBoolean);
    if (parami.field_fileId == null) {
      parami.field_fileId = "";
    }
    if (parami.field_aesKey == null) {
      parami.field_aesKey = "";
    }
    parami.fZA = false;
    if ((b(parami.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(577673101312L, 4304);
          f.this.hxT.add(parami.field_mediaId);
          f.this.hxU.put(parami.field_mediaId, parami);
          f.this.be(false);
          GMTrace.o(577673101312L, 4304);
        }
      });
    }
    for (;;)
    {
      GMTrace.o(579015278592L, 4314);
      return true;
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(591497527296L, 4407);
          f.this.hxT.add(parami.field_mediaId);
          f.this.hxU.put(parami.field_mediaId, parami);
          f.this.be(false);
          GMTrace.o(591497527296L, 4407);
        }
      });
    }
  }
  
  public final boolean b(final String paramString, final Object[] paramArrayOfObject)
  {
    GMTrace.i(579149496320L, 4315);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bf.mA(paramString)) {
      if (!this.hxV.containsKey(paramString)) {
        break label96;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(592034398208L, 4411);
          i locali = (i)f.this.hxV.remove(paramString);
          keep_SceneResult localkeep_SceneResult;
          int i;
          if (locali != null)
          {
            localkeep_SceneResult = new keep_SceneResult();
            g.En();
            i = b.a(locali.field_mediaId, localkeep_SceneResult);
            if (i == 0) {
              f.a(paramArrayOfObject, localkeep_SceneResult, locali, false);
            }
          }
          for (;;)
          {
            f.this.hxU.remove(paramString);
            GMTrace.o(592034398208L, 4411);
            return;
            v.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), locali.field_mediaId });
            continue;
            locali = (i)f.this.hyA.remove(paramString);
            localkeep_SceneResult = (keep_SceneResult)f.this.hyB.remove(paramString);
            if ((locali != null) && (localkeep_SceneResult != null)) {
              f.a(paramArrayOfObject, localkeep_SceneResult, locali, true);
            }
          }
        }
      });
      v.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      GMTrace.o(579149496320L, 4315);
      return bool1;
      label96:
      g.Em().iQ(paramString);
    }
  }
  
  public final void be(boolean paramBoolean)
  {
    GMTrace.i(19010733211648L, 141641);
    if (!com.tencent.mm.kernel.h.vG().uV())
    {
      GMTrace.o(19010733211648L, 141641);
      return;
    }
    if ((!paramBoolean) && (g.En().Ef()))
    {
      com.tencent.mm.kernel.h.vG();
      if (com.tencent.mm.kernel.a.uU())
      {
        v.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        g.Em().be(paramBoolean);
        GMTrace.o(19010733211648L, 141641);
        return;
      }
    }
    c.Eg();
    while (!this.hxT.isEmpty())
    {
      Object localObject1 = (String)this.hxT.poll();
      Object localObject2 = (i)this.hxU.remove(localObject1);
      if (localObject2 != null)
      {
        ((i)localObject2).field_startTime = bf.NA();
        if (!((i)localObject2).fZA)
        {
          if (((Integer)com.tencent.mm.kernel.h.vI().vr().get(w.a.uCU, Integer.valueOf(-1))).intValue() == 2) {
            v.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label176:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label351;
            }
            localObject2 = new kk();
            ((kk)localObject2).fQF.fJB = 6;
            ((kk)localObject2).fQF.mediaId = ((String)localObject1);
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((i)localObject2).Eq()) {
              break label176;
            }
            String str1 = ((i)localObject2).hyZ;
            i = ((i)localObject2).hza;
            String str2 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().cH(str1, i);
            j = i - com.tencent.mm.a.e.aN(str2);
            if ((bf.mA(str2)) || (j < 0) || (j > 16)) {
              break label176;
            }
            v.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), str1, str2 });
            j.ex(str2, ((i)localObject2).field_fullpath);
            a(com.tencent.mm.modelvideo.t.lI(((i)localObject2).filename), i, str1);
          }
          label351:
          if (((i)localObject2).Ep())
          {
            g.En();
            i = b.a((h)localObject2, ((i)localObject2).hzb);
            label374:
            v.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label862;
            }
            v.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((i)localObject2).field_mediaId);
            paramBoolean = ((i)localObject2).Ep();
            j = ((i)localObject2).hzb;
            if (!paramBoolean) {
              break label773;
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 3L, 1L, false);
            if (j != 1) {
              break label708;
            }
            if (i != 44530) {
              break label667;
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(100), Long.valueOf(bf.Nz()), "" });
            break;
            if (((i)localObject2).Eo())
            {
              g.En();
              i = b.a(((i)localObject2).field_mediaId, ((i)localObject2).url, ((i)localObject2).referer, ((i)localObject2).field_fullpath, ((i)localObject2).hzb, ((i)localObject2).iplist, ((i)localObject2).initialDownloadOffset, ((i)localObject2).initialDownloadLength, ((i)localObject2).isColdSnsData, ((i)localObject2).signalQuality, ((i)localObject2).snsScene, ((i)localObject2).field_preloadRatio);
              break label374;
            }
            g.En();
            i = b.a(((i)localObject2).field_mediaId, ((i)localObject2).url, ((i)localObject2).referer, ((i)localObject2).field_fullpath, ((i)localObject2).hzb, ((i)localObject2).iplist, ((i)localObject2).initialDownloadOffset, ((i)localObject2).initialDownloadLength, ((i)localObject2).field_preloadRatio);
            break label374;
            label667:
            if (i == 45533)
            {
              com.tencent.mm.plugin.report.service.g.oSF.a(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.oSF.a(354L, 102L, 1L, false);
              continue;
              label708:
              if (i == 44530) {
                com.tencent.mm.plugin.report.service.g.oSF.a(354L, 106L, 1L, false);
              } else if (i == 45533) {
                com.tencent.mm.plugin.report.service.g.oSF.a(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.g.oSF.a(354L, 108L, 1L, false);
              }
            }
          }
          label773:
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(200), Long.valueOf(bf.Nz()), "" });
            break;
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 212L, 1L, false);
          }
          label862:
          ((i)localObject2).hyY = bf.NA();
          if (((i)localObject2).Ep())
          {
            localObject1 = com.tencent.mm.modelvideo.t.lI(((i)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((r)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((r)localObject1).status = 120;
                ((r)localObject1).fRM = 256;
                com.tencent.mm.modelvideo.o.KW().b((r)localObject1);
              }
            }
          }
          this.hxV.put(((i)localObject2).field_mediaId, localObject2);
        }
      }
    }
    GMTrace.o(19010733211648L, 141641);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(579283714048L, 4316);
    if ((i)this.hxV.get(paramString) == null)
    {
      v.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      GMTrace.o(579283714048L, 4316);
      return false;
    }
    g.En();
    boolean bool = b.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    v.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    GMTrace.o(579283714048L, 4316);
    return bool;
  }
  
  public final void onDataAvailable(final String paramString, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(579686367232L, 4319);
    v.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bf.mA(paramString))
    {
      GMTrace.o(579686367232L, 4319);
      return;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(577404665856L, 4302);
        Object localObject = (i)f.this.hxV.get(paramString);
        if (localObject != null)
        {
          if (((i)localObject).hzh != null) {
            ((i)localObject).hzh.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new kk();
          ((kk)localObject).fQF.fJB = 2;
          ((kk)localObject).fQF.fEO = 0;
          ((kk)localObject).fQF.mediaId = paramString;
          ((kk)localObject).fQF.offset = paramInt1;
          ((kk)localObject).fQF.length = paramInt2;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        }
        GMTrace.o(577404665856L, 4302);
      }
    });
    GMTrace.o(579686367232L, 4319);
  }
  
  public final void onDownloadToEnd(final String paramString, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(579820584960L, 4320);
    v.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bf.mA(paramString))
    {
      GMTrace.o(579820584960L, 4320);
      return;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(589350043648L, 4391);
        i locali = (i)f.this.hxV.get(paramString);
        if (locali != null)
        {
          if (locali.hzh != null)
          {
            locali.hzh.w(paramString, 0);
            GMTrace.o(589350043648L, 4391);
            return;
          }
          kk localkk = new kk();
          localkk.fQF.fJB = 3;
          localkk.fQF.fEO = 0;
          localkk.fQF.mediaId = paramString;
          localkk.fQF.offset = paramInt1;
          localkk.fQF.length = paramInt2;
          com.tencent.mm.sdk.b.a.uql.m(localkk);
          if ((paramInt1 == 0) && (paramInt2 >= locali.hza)) {
            f.a(com.tencent.mm.modelvideo.t.lI(locali.filename), locali.hza, locali.hyZ);
          }
        }
        GMTrace.o(589350043648L, 4391);
      }
    });
    GMTrace.o(579820584960L, 4320);
  }
  
  public final void onMoovReady(final String paramString, final int paramInt1, final int paramInt2)
  {
    GMTrace.i(579552149504L, 4318);
    v.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString });
    if (bf.mA(paramString))
    {
      GMTrace.o(579552149504L, 4318);
      return;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        GMTrace.i(581431197696L, 4332);
        i locali = (i)f.this.hxV.get(paramString);
        if (locali != null)
        {
          if (locali.hzh != null)
          {
            locali.hzh.onMoovReady(paramString, paramInt1, paramInt2);
            GMTrace.o(581431197696L, 4332);
            return;
          }
          if (q.lp(locali.field_fullpath))
          {
            v.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + locali.hzb);
            if (locali.hzb == 1)
            {
              f.e(locali.field_mediaId, 0, locali.field_totalLen);
              com.tencent.mm.plugin.report.service.g.oSF.a(354L, 19L, 1L, false);
            }
            GMTrace.o(581431197696L, 4332);
            return;
          }
          Object localObject = new kk();
          ((kk)localObject).fQF.fJB = 1;
          ((kk)localObject).fQF.fEO = 0;
          ((kk)localObject).fQF.mediaId = paramString;
          ((kk)localObject).fQF.offset = paramInt1;
          ((kk)localObject).fQF.length = paramInt2;
          ((kk)localObject).fQF.fQG = locali.hyY;
          kk.a locala = ((kk)localObject).fQF;
          if (locali.initialDownloadLength > 0) {
            bool = true;
          }
          locala.fQH = bool;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
          localObject = com.tencent.mm.modelvideo.t.lI(locali.filename);
          if (localObject != null)
          {
            v.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((r)localObject).getFileName() + " status : " + ((r)localObject).status);
            if (((r)localObject).status == 130)
            {
              GMTrace.o(581431197696L, 4332);
              return;
            }
            if (((r)localObject).status != 122)
            {
              localObject = com.tencent.mm.modelvideo.t.lI(locali.filename);
              if (localObject != null)
              {
                ((r)localObject).status = 121;
                ((r)localObject).fRM = 256;
                com.tencent.mm.modelvideo.o.KW().b((r)localObject);
              }
              if (locali.hzb == 0)
              {
                v.i("MicroMsg.OnlineVideoService", "stop download video");
                com.tencent.mm.modelvideo.o.Lb().Lu();
                com.tencent.mm.modelvideo.o.Lb().run();
              }
            }
          }
        }
        GMTrace.o(581431197696L, 4332);
      }
    });
    GMTrace.o(579552149504L, 4318);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */