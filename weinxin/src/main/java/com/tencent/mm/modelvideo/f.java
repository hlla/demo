package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.h.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  long fGD;
  public String fGE;
  private h.a hGp;
  private i hYg;
  public boolean hYp;
  public String hYq;
  private long hYr;
  public long hYs;
  public long hYt;
  public int hYu;
  private String hYv;
  public a hYw;
  private h.b hyX;
  public String hyZ;
  private String mediaId;
  
  public f(long paramLong)
  {
    GMTrace.i(17455820832768L, 130056);
    this.hYp = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(17455418179584L, 130053);
        if (paramAnonymousInt != 0)
        {
          v.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hYw != null) {
            f.this.hYw.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymouskeep_ProgressInfo != null) {
          v.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label211;
          }
          if (f.this.hYw != null) {
            f.this.hYw.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          GMTrace.o(17455418179584L, 130053);
          return 0;
          label211:
          v.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.d(f.this.hYq, paramAnonymouskeep_SceneResult.field_fileLength, f.this.hyZ);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(17455552397312L, 130054);
        GMTrace.o(17455552397312L, 130054);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(17455686615040L, 130055);
        GMTrace.o(17455686615040L, 130055);
        return new byte[0];
      }
    };
    this.hyX = new h.b()
    {
      public final void onPreloadCompleted(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(17454076002304L, 130043);
        v.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hYq, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 > 0) && (paramAnonymousInt2 > 0)) {
          f.this.hYt = f.c(f.this.hYq, paramAnonymousInt1, true);
        }
        f localf;
        if (f.this.hYw != null)
        {
          paramAnonymousString = f.this.hYw;
          localf = f.this;
          if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0)) {
            break label210;
          }
        }
        label210:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.a(localf, bool, paramAnonymousInt1, paramAnonymousInt2);
          f.this.hYs = bf.Nz();
          f.this.KO();
          if (!f.this.hYp) {
            break label239;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 142L, 1L, false);
          if (f.this.hYu != 1) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 123L, 1L, false);
          GMTrace.o(17454076002304L, 130043);
          return;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 124L, 1L, false);
        GMTrace.o(17454076002304L, 130043);
        return;
        label239:
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 143L, 1L, false);
        GMTrace.o(17454076002304L, 130043);
      }
    };
    this.fGD = paramLong;
    this.hYp = true;
    GMTrace.o(17455820832768L, 130056);
  }
  
  public f(i parami, String paramString)
  {
    GMTrace.i(17455955050496L, 130057);
    this.hYp = false;
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(17455418179584L, 130053);
        if (paramAnonymousInt != 0)
        {
          v.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hYw != null) {
            f.this.hYw.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymouskeep_ProgressInfo != null) {
          v.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymouskeep_SceneResult != null)
        {
          v.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
          if (paramAnonymouskeep_SceneResult.field_retCode == 0) {
            break label211;
          }
          if (f.this.hYw != null) {
            f.this.hYw.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          GMTrace.o(17455418179584L, 130053);
          return 0;
          label211:
          v.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.d(f.this.hYq, paramAnonymouskeep_SceneResult.field_fileLength, f.this.hyZ);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(17455552397312L, 130054);
        GMTrace.o(17455552397312L, 130054);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(17455686615040L, 130055);
        GMTrace.o(17455686615040L, 130055);
        return new byte[0];
      }
    };
    this.hyX = new h.b()
    {
      public final void onPreloadCompleted(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(17454076002304L, 130043);
        v.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hYq, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 > 0) && (paramAnonymousInt2 > 0)) {
          f.this.hYt = f.c(f.this.hYq, paramAnonymousInt1, true);
        }
        f localf;
        if (f.this.hYw != null)
        {
          paramAnonymousString = f.this.hYw;
          localf = f.this;
          if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0)) {
            break label210;
          }
        }
        label210:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.a(localf, bool, paramAnonymousInt1, paramAnonymousInt2);
          f.this.hYs = bf.Nz();
          f.this.KO();
          if (!f.this.hYp) {
            break label239;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 142L, 1L, false);
          if (f.this.hYu != 1) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 123L, 1L, false);
          GMTrace.o(17454076002304L, 130043);
          return;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 124L, 1L, false);
        GMTrace.o(17454076002304L, 130043);
        return;
        label239:
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 143L, 1L, false);
        GMTrace.o(17454076002304L, 130043);
      }
    };
    this.hYg = parami;
    this.fGE = paramString;
    this.hYp = false;
    GMTrace.o(17455955050496L, 130057);
  }
  
  public static int c(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    GMTrace.i(18681228689408L, 139186);
    r localr = t.lI(paramString);
    int j;
    if (localr != null)
    {
      j = localr.fOr;
      if (paramBoolean)
      {
        localr.fOr = paramInt;
        v.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(localr.fOr), Boolean.valueOf(paramBoolean) });
        localr.hZT = bf.Nz();
        localr.fRM = 1025;
        t.e(localr);
        if (!paramBoolean) {
          break label145;
        }
        paramInt -= j;
        label117:
        if (paramInt >= 0) {
          break label158;
        }
        paramInt = i;
      }
    }
    label145:
    label158:
    for (;;)
    {
      GMTrace.o(18681228689408L, 139186);
      return paramInt;
      localr.fOr = (j + paramInt);
      break;
      break label117;
      GMTrace.o(18681228689408L, 139186);
      return paramInt;
    }
  }
  
  public final String KN()
  {
    GMTrace.i(17456089268224L, 130058);
    if (this.hYp)
    {
      str = this.fGD;
      GMTrace.o(17456089268224L, 130058);
      return str;
    }
    String str = this.fGE;
    GMTrace.o(17456089268224L, 130058);
    return str;
  }
  
  public final void KO()
  {
    GMTrace.i(18681497124864L, 139188);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hYr).append(",");
    ((StringBuffer)localObject).append(this.hYs).append(",");
    ((StringBuffer)localObject).append(this.hYt).append(",");
    ((StringBuffer)localObject).append(this.hYv).append(",");
    ((StringBuffer)localObject).append(this.hYu).append(",");
    try
    {
      long l = this.hYt / 1024L / (this.hYs - this.hYr);
      i = (int)l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    ((StringBuffer)localObject).append(i).append(",");
    ((StringBuffer)localObject).append(0);
    localObject = ((StringBuffer)localObject).toString();
    v.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), localObject });
    com.tencent.mm.plugin.report.service.g.oSF.A(14499, (String)localObject);
    GMTrace.o(18681497124864L, 139188);
  }
  
  public final int a(a parama)
  {
    GMTrace.i(17456357703680L, 130060);
    this.hYw = parama;
    for (;;)
    {
      try
      {
        v.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.fGD) });
        Object localObject;
        String str1;
        int j;
        if (this.hYp)
        {
          parama = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(this.fGD);
          localObject = ay.gm(parama.gxv);
          if ((localObject == null) || (((ay.b)localObject).hmI <= 0))
          {
            v.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama == null) {
              break label982;
            }
            if (!com.tencent.mm.u.o.dH(parama.hzc)) {
              break label995;
            }
            i = 2;
            this.hYu = i;
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 140L, 1L, false);
            if (this.hYu == 1)
            {
              com.tencent.mm.plugin.report.service.g.oSF.a(354L, 121L, 1L, false);
              if (parama != null) {
                continue;
              }
              v.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
              i = 0;
              if (i == 0) {
                continue;
              }
              GMTrace.o(17456357703680L, 130060);
              return 0;
            }
          }
          else
          {
            str1 = parama.field_imgPath;
            r localr = t.lI(str1);
            if (localr == null)
            {
              parama = null;
              continue;
            }
            parama = bg.q(localr.Li(), "msg");
            if (parama == null)
            {
              v.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (bf.mA(str2))
            {
              v.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = Integer.valueOf((String)parama.get(".msg.videomsg.$length")).intValue();
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.modelcdntran.d.a("downvideo", localr.hZS, localr.Lf(), localr.getFileName());
            if (bf.mA(str7))
            {
              v.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { localr.getFileName() });
              parama = null;
              continue;
            }
            o.KW();
            String str8 = s.lw(str1);
            parama = new i();
            parama.filename = str1;
            parama.hyZ = str3;
            parama.hza = j;
            parama.hzb = 2;
            parama.fOl = localr.Lg();
            parama.hzc = localr.Lf();
            if (!com.tencent.mm.u.o.dH(localr.Lf())) {
              break label985;
            }
            i = com.tencent.mm.u.j.eC(localr.Lf());
            parama.fOn = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = b.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = b.hxt;
            parama.field_wxmsgparam = str6;
            if (!com.tencent.mm.u.o.dH(localr.Lf())) {
              break label990;
            }
            i = 1;
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, localr);
            parama.field_preloadRatio = ((ay.b)localObject).hmI;
            parama.fvf = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 122L, 1L, false);
          continue;
        }
        else
        {
          this.hYu = 3;
          parama = this.hYg;
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 141L, 1L, false);
          continue;
        }
        if (((Integer)com.tencent.mm.kernel.h.vI().vr().get(w.a.uCU, Integer.valueOf(-1))).intValue() == 2)
        {
          v.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
          break label1000;
          if (i != 0)
          {
            v.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
            i = 0;
          }
        }
        else
        {
          if (parama.Eq()) {
            break label1000;
          }
          localObject = parama.hyZ;
          i = parama.hza;
          str1 = ((a)com.tencent.mm.kernel.h.h(a.class)).wY().cH((String)localObject, i);
          j = i - com.tencent.mm.a.e.aN(str1);
          if ((bf.mA(str1)) || (j < 0) || (j > 16)) {
            break label1000;
          }
          v.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
          com.tencent.mm.sdk.platformtools.j.ex(str1, parama.field_fullpath);
          d(parama.filename, i, (String)localObject);
          i = 1;
          continue;
        }
        parama.hyX = this.hyX;
        parama.hyM = this.hGp;
        parama.hyV = 2;
        this.hyZ = parama.hyZ;
        this.mediaId = parama.field_mediaId;
        this.hYq = parama.filename;
        this.hYr = bf.Nz();
        this.hYv = parama.fvf;
        v.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
        com.tencent.mm.modelcdntran.g.Em().b(parama, -1);
        i = 1;
        continue;
        continue;
      }
      catch (Exception parama)
      {
        v.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.hYw = null;
        GMTrace.o(17456357703680L, 130060);
        return -1;
      }
      label982:
      label985:
      int i = 0;
      continue;
      label990:
      i = 0;
      continue;
      label995:
      i = 1;
      continue;
      label1000:
      i = 0;
    }
  }
  
  public final void d(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(18681362907136L, 139187);
    v.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (t.lI(paramString1) != null)
    {
      t.H(paramString1, paramInt);
      if (!bf.mA(paramString2))
      {
        o.KW();
        paramString1 = s.lw(paramString1);
        if ((bf.mA(paramString2)) || (paramInt <= 0) || (bf.mA(paramString1)) || (!com.tencent.mm.a.e.aO(paramString1)))
        {
          v.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString2, paramString1 });
          GMTrace.o(18681362907136L, 139187);
          return;
        }
        ((a)com.tencent.mm.kernel.h.h(a.class)).wY().p(paramString2, paramInt, paramString1);
      }
    }
    GMTrace.o(18681362907136L, 139187);
  }
  
  public final void stop()
  {
    GMTrace.i(17456223485952L, 130059);
    v.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    PInt localPInt = new PInt();
    if (!bf.mA(this.mediaId))
    {
      com.tencent.mm.modelcdntran.c localc = com.tencent.mm.modelcdntran.g.Em();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.modelcdntran.h localh = (com.tencent.mm.modelcdntran.h)localc.hxV.remove(str);
      if (localh != null)
      {
        keep_SceneResult localkeep_SceneResult = new keep_SceneResult();
        com.tencent.mm.modelcdntran.g.En();
        i = b.a(str, localkeep_SceneResult);
        localPInt.value = localkeep_SceneResult.field_recvedBytes;
        com.tencent.mm.plugin.report.service.g.oSF.i(10769, new Object[] { Integer.valueOf(com.tencent.mm.modelcdntran.d.hyr), Integer.valueOf(localh.field_fileType), Long.valueOf(bf.NA() - localh.field_startTime) });
      }
      localc.hxU.remove(str);
      localc.hxW.remove(str);
      v.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localh, Integer.valueOf(i) });
      this.hYs = bf.Nz();
      this.hYt = c(this.hYq, localPInt.value, false);
      KO();
    }
    this.hYw = null;
    GMTrace.o(17456223485952L, 130059);
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */