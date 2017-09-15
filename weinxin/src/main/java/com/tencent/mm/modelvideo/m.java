package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.y.n;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  public static int fBh;
  public boolean fBd;
  public boolean fBe;
  public int fBf;
  public g.a fBj;
  public ai fBk;
  public LinkedList<Long> hYZ;
  public Map<Long, g.a> hZa;
  public Map<Long, String> hZb;
  public Object hZc;
  public String hZd;
  
  static
  {
    GMTrace.i(319840845824L, 2383);
    fBh = 0;
    GMTrace.o(319840845824L, 2383);
  }
  
  public m()
  {
    GMTrace.i(316485402624L, 2358);
    this.hYZ = new LinkedList();
    this.hZa = new HashMap();
    this.hZb = new HashMap();
    this.hZc = new Object();
    this.fBd = false;
    this.fBe = false;
    this.fBf = 0;
    this.fBj = new g.a();
    this.fBk = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(331115134976L, 2467);
        m.this.pq();
        GMTrace.o(331115134976L, 2467);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(331249352704L, 2468);
        String str = super.toString() + "|scenePusher";
        GMTrace.o(331249352704L, 2468);
        return str;
      }
    }, false);
    GMTrace.o(316485402624L, 2358);
  }
  
  public static void N(List<r> paramList)
  {
    GMTrace.i(316619620352L, 2359);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      GMTrace.o(316619620352L, 2359);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      t.lB(((r)paramList.next()).getFileName());
    }
    GMTrace.o(316619620352L, 2359);
  }
  
  public static void O(List<r> paramList)
  {
    GMTrace.i(316753838080L, 2360);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      GMTrace.o(316753838080L, 2360);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      t.lC(((r)paramList.next()).getFileName());
    }
    GMTrace.o(316753838080L, 2360);
  }
  
  private String as(long paramLong)
  {
    GMTrace.i(316888055808L, 2361);
    Object localObject2 = o.KW().au(paramLong);
    if (((List)localObject2).isEmpty())
    {
      v.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      GMTrace.o(316888055808L, 2361);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (r)((Iterator)localObject1).next();
      if (com.tencent.mm.u.o.fF(((r)localObject3).Lf()))
      {
        v.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((r)localObject3).Lf(), ((r)localObject3).iad, Long.valueOf(paramLong) });
        GMTrace.o(316888055808L, 2361);
        return null;
      }
      com.tencent.mm.modelcdntran.g.Em();
      if ((!com.tencent.mm.modelcdntran.c.fA(2)) && (((r)localObject3).iaa != 1))
      {
        com.tencent.mm.modelcdntran.g.Em();
        v.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(2)), Integer.valueOf(((r)localObject3).iaa), ((r)localObject3).iad, Long.valueOf(paramLong) });
        GMTrace.o(316888055808L, 2361);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      v.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      GMTrace.o(316888055808L, 2361);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label435;
        }
        localObject3 = (r)((List)localObject2).get(i);
        localObject1 = t.lI(((r)localObject3).getFileName());
        if (localObject1 != null)
        {
          v.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((r)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((r)localObject3).iad });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        v.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((r)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((r)localObject3).iad });
        i += 1;
      }
      label435:
      localObject1 = null;
    }
    Object localObject3 = d.a("upvideo", ((r)localObject1).hZS, ((r)localObject1).iad, ((r)localObject1).getFileName());
    if (bf.mA((String)localObject3))
    {
      v.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((r)localObject1).getFileName(), Long.valueOf(((r)localObject1).hYm), ((r)localObject1).iad });
      GMTrace.o(316888055808L, 2361);
      return null;
    }
    Object localObject4 = ((r)localObject1).getFileName();
    o.KW();
    String str1 = s.lx((String)localObject4);
    o.KW();
    String str2 = s.lw((String)localObject4);
    a locala = new a();
    locala.hox = ((List)localObject2);
    locala.hYm = paramLong;
    locala.hZg = ((String)localObject3);
    locala.startTime = bf.NA();
    locala.hYn = ((r)localObject1);
    localObject4 = new com.tencent.mm.modelcdntran.h();
    ((com.tencent.mm.modelcdntran.h)localObject4).hyM = locala;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.modelcdntran.h)localObject4).field_fullpath = str2;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_fileType = b.MediaType_VIDEO;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_talker = ((r)localObject1).iad;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_priority = b.hxt;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_needStorage = false;
    ((com.tencent.mm.modelcdntran.h)localObject4).field_isStreamMedia = false;
    localObject1 = bg.q(((r)localObject1).Li(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.modelcdntran.h)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.modelcdntran.h)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject4))
    {
      v.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      GMTrace.o(316888055808L, 2361);
      return null;
      v.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (r)((Iterator)localObject1).next();
      if (((r)localObject2).iaa != 1)
      {
        ((r)localObject2).iaa = 1;
        ((r)localObject2).fRM = 524288;
        boolean bool = t.e((r)localObject2);
        v.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((r)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    GMTrace.o(316888055808L, 2361);
    return (String)localObject3;
  }
  
  public final void c(final long paramLong, int paramInt1, final int paramInt2)
  {
    GMTrace.i(317022273536L, 2362);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(329236086784L, 2453);
        m.fBh += 1;
        m.this.fBd = false;
        m.this.hZd = "";
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (m.this.hZa.get(Long.valueOf(paramLong)) != null) {
            l1 = ((g.a)m.this.hZa.get(Long.valueOf(paramLong))).se();
          }
        }
        v.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.fBn) });
        if ((paramInt2 != 0) || (this.fBn != 0))
        {
          localObject1 = m.this;
          ((m)localObject1).fBf -= 1;
        }
        v.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.fBh), Integer.valueOf(m.this.fBf), Boolean.valueOf(m.this.fBe), Boolean.valueOf(m.this.fBd) });
        if (m.this.fBf > 0) {
          m.this.pq();
        }
        while (m.this.fBd)
        {
          m.fBh -= 1;
          GMTrace.o(329236086784L, 2453);
          return;
        }
        v.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        Object localObject1 = o.KW();
        Object localObject3 = m.this.hYZ;
        if ((localObject3 == null) || (((List)localObject3).isEmpty())) {}
        for (;;)
        {
          m.this.pr();
          break;
          l1 = System.currentTimeMillis() / 1000L;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append('(');
          int i = 0;
          while (i < ((List)localObject3).size() - 1)
          {
            ((StringBuilder)localObject2).append((Long)((List)localObject3).get(i));
            ((StringBuilder)localObject2).append(',');
            i += 1;
          }
          localObject3 = (Long)((List)localObject3).get(((List)localObject3).size() - 1);
          if (localObject3 != null) {
            ((StringBuilder)localObject2).append(localObject3);
          }
          ((StringBuilder)localObject2).append(')');
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject2 = "UPDATE videoinfo2 SET status=198, lastmodifytime=" + l1 + " WHERE masssendid IN " + (String)localObject2;
          v.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
          ((s)localObject1).hnp.eE("videoinfo2", (String)localObject2);
        }
      }
      
      public final String toString()
      {
        GMTrace.i(329370304512L, 2454);
        String str = super.toString() + "|onSceneEnd";
        GMTrace.o(329370304512L, 2454);
        return str;
      }
    });
    GMTrace.o(317022273536L, 2362);
  }
  
  public final void pq()
  {
    GMTrace.i(16008416854016L, 119272);
    Object localObject;
    if ((!this.fBd) && (this.hYZ.isEmpty()))
    {
      localObject = o.KW().Ln();
      if (!((List)localObject).isEmpty()) {
        break label89;
      }
      v.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
    }
    while ((!this.fBd) && (this.hYZ.isEmpty()))
    {
      pr();
      v.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
      GMTrace.o(16008416854016L, 119272);
      return;
      label89:
      long l = System.currentTimeMillis() / 1000L;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        r localr = (r)((Iterator)localObject).next();
        if (this.hZa.containsKey(Long.valueOf(localr.hYm)))
        {
          v.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", new Object[] { localr.getFileName(), Long.valueOf(localr.hYm) });
        }
        else
        {
          v.d("MicroMsg.SightMassSendService", "Get file:" + localr.getFileName() + " status:" + localr.status + " user" + localr.Lf() + " human:" + localr.Lg() + " massSendId:" + localr.hYm + " massSendList:" + localr.iad + " create:" + bf.ev(localr.hZS) + " last:" + bf.ev(localr.hZT) + " now:" + bf.ev(l) + " " + (l - localr.hZT));
          if (localr.status == 200)
          {
            this.hYZ.offer(Long.valueOf(localr.hYm));
            this.hZa.put(Long.valueOf(localr.hYm), null);
          }
        }
      }
      v.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + this.hZa.size() + " [send:" + this.hYZ.size() + "]");
      this.hYZ.size();
    }
    if ((!this.fBd) && (this.hYZ.size() > 0))
    {
      localObject = (Long)this.hYZ.poll();
      v.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", new Object[] { localObject });
      if (localObject != null)
      {
        this.hZa.put(localObject, new g.a());
        this.fBd = true;
        this.hZd = as(((Long)localObject).longValue());
        if (this.hZd == null)
        {
          this.fBd = false;
          this.fBk.v(10L, 10L);
          GMTrace.o(16008416854016L, 119272);
          return;
        }
        this.hZb.put(localObject, this.hZd);
      }
    }
    GMTrace.o(16008416854016L, 119272);
  }
  
  public final void pr()
  {
    GMTrace.i(317156491264L, 2363);
    this.hZb.clear();
    this.hZa.clear();
    this.hYZ.clear();
    this.fBd = false;
    this.fBe = false;
    v.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.fBj.se());
    GMTrace.o(317156491264L, 2363);
  }
  
  private final class a
    implements h.a, com.tencent.mm.y.e
  {
    long hYm;
    r hYn;
    String hZg;
    List<r> hox;
    long startTime;
    
    public a()
    {
      GMTrace.i(353797931008L, 2636);
      GMTrace.o(353797931008L, 2636);
    }
    
    public final int a(String arg1, int paramInt, keep_ProgressInfo paramkeep_ProgressInfo, keep_SceneResult paramkeep_SceneResult, boolean paramBoolean)
    {
      GMTrace.i(353932148736L, 2637);
      v.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.hZg, Integer.valueOf(paramInt), paramkeep_ProgressInfo, paramkeep_SceneResult });
      if (paramInt == 44531)
      {
        v.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.hZg });
        GMTrace.o(353932148736L, 2637);
        return 0;
      }
      if (paramInt != 0)
      {
        m.N(this.hox);
        v.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.hYm), Integer.valueOf(paramInt) });
        com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), "" });
        m.this.c(this.hYm, 3, paramInt);
        GMTrace.o(353932148736L, 2637);
        return 0;
      }
      if (paramkeep_ProgressInfo != null)
      {
        v.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Integer.valueOf(paramkeep_ProgressInfo.field_finishedLength) });
        ??? = this.hox.iterator();
        while (???.hasNext())
        {
          paramkeep_SceneResult = (r)???.next();
          paramkeep_SceneResult.hZT = bf.Nz();
          paramkeep_SceneResult.hYB = paramkeep_ProgressInfo.field_finishedLength;
          paramkeep_SceneResult.fRM = 1032;
          t.e(paramkeep_SceneResult);
        }
        GMTrace.o(353932148736L, 2637);
        return 0;
      }
      if (paramkeep_SceneResult != null)
      {
        if (paramkeep_SceneResult.field_retCode != 0)
        {
          v.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramkeep_SceneResult.field_retCode), paramkeep_SceneResult.field_arg, paramkeep_SceneResult.field_transInfo, Long.valueOf(this.hYm) });
          m.N(this.hox);
          com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramkeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(paramkeep_SceneResult.field_fileLength), paramkeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramkeep_SceneResult.report_Part2 });
          com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramkeep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bf.NA()), Integer.valueOf(d.aU(aa.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(paramkeep_SceneResult.field_fileLength), paramkeep_SceneResult.field_transInfo, "", "", "", "", "", "", "", paramkeep_SceneResult.report_Part2 });
          m.this.c(this.hYm, 3, paramkeep_SceneResult.field_retCode);
        }
      }
      else
      {
        GMTrace.o(353932148736L, 2637);
        return 0;
      }
      v.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramkeep_SceneResult.field_UploadHitCacheType), Long.valueOf(this.hYm) });
      ??? = "<msg><videomsg aeskey=\"" + paramkeep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + paramkeep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + paramkeep_SceneResult.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramkeep_SceneResult.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramkeep_SceneResult.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramkeep_SceneResult.field_thumbimgLength + "\"/></msg>";
      v.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramkeep_ProgressInfo = this.hox.iterator();
      while (paramkeep_ProgressInfo.hasNext())
      {
        r localr = (r)paramkeep_ProgressInfo.next();
        if (bf.mA(localr.Li()))
        {
          localr.iab = ???;
          localr.fRM = 2097152;
          paramBoolean = t.e(localr);
          v.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.hYm), localr.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (m.this.hZc)
        {
          paramkeep_ProgressInfo = (String)m.this.hZb.get(Long.valueOf(this.hYm));
          if (bf.mA(paramkeep_ProgressInfo)) {
            v.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hYm), paramkeep_ProgressInfo, this.hZg });
          }
        }
        v.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hYm), paramkeep_ProgressInfo, this.hZg });
        m.this.hZb.put(Long.valueOf(this.hYm), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.h.vd().a(245, this);
        paramkeep_ProgressInfo = new e(this.hYm, this.hYn, paramkeep_SceneResult, this.hZg);
        if (!com.tencent.mm.kernel.h.vd().a(paramkeep_ProgressInfo, 0))
        {
          v.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.h.vd().b(245, this);
          m.this.c(this.hYm, 3, 0);
        }
      }
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(354334801920L, 2640);
      com.tencent.mm.kernel.h.vd().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.hYm);
        m.O(this.hox);
        m.this.c(this.hYm, paramInt1, paramInt2);
        GMTrace.o(354334801920L, 2640);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hYm);
        m.N(this.hox);
        m.this.c(this.hYm, paramInt1, paramInt2);
        GMTrace.o(354334801920L, 2640);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hYm);
        m.N(this.hox);
        m.this.c(this.hYm, paramInt1, paramInt2);
        GMTrace.o(354334801920L, 2640);
        return;
      }
      paramString = this.hox.iterator();
      if (paramString.hasNext())
      {
        paramk = (r)paramString.next();
        paramk.hZT = bf.Nz();
        paramk.status = 199;
        paramk.fRM = 1280;
        if (t.e(paramk))
        {
          if (paramk != null) {
            break label390;
          }
          v.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          v.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.hYm), paramk.getFileName(), Integer.valueOf(199) });
          break;
          label390:
          au localau;
          if (paramk.hZW > 0)
          {
            localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramk.hZW);
            paramInt1 = localau.field_type;
            v.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localau.dw(1);
              localau.cH(paramk.Lf());
              localau.y(paramk.fTG);
              localau.dv(2);
              localau.setContent(p.b(paramk.Lg(), paramk.hZV, false));
              ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramk.hZW, localau);
              v.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localau.field_msgId) });
            }
          }
          else
          {
            localau = new au();
            localau.cH(paramk.Lf());
            localau.setType(62);
            localau.dw(1);
            localau.cI(paramk.getFileName());
            localau.dv(2);
            localau.z(ay.gk(paramk.Lf()));
            paramk.hZW = ((int)ay.i(localau));
            paramk.fRM = 8192;
            t.e(paramk);
            v.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localau.field_msgId) });
          }
        }
      }
      paramString = m.this;
      long l = this.hYm;
      com.tencent.mm.kernel.h.vL().D(new m.1(paramString, l));
      GMTrace.o(354334801920L, 2640);
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      GMTrace.i(354066366464L, 2638);
      GMTrace.o(354066366464L, 2638);
    }
    
    public final byte[] i(String paramString, byte[] paramArrayOfByte)
    {
      GMTrace.i(354200584192L, 2639);
      GMTrace.o(354200584192L, 2639);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */