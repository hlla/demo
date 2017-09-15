package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class j
  extends Thread
{
  private static HashMap<String, b> stW;
  private static Object stX;
  private static aq stY;
  private Context context;
  private String fJC;
  private Intent intent;
  private boolean isStop;
  private int sAJ;
  private a sAK;
  private List<String> stM;
  private List<Integer> stN;
  private List<String> stO;
  private List<String> stP;
  private List<Integer> stQ;
  
  static
  {
    GMTrace.i(838458146816L, 6247);
    stW = new HashMap();
    stX = new byte[0];
    GMTrace.o(838458146816L, 6247);
  }
  
  public j(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, a parama)
  {
    GMTrace.i(835102703616L, 6222);
    this.context = paramContext;
    this.stM = paramList;
    this.intent = paramIntent;
    this.stN = new ArrayList();
    this.stO = new ArrayList();
    this.stP = new ArrayList();
    this.stQ = new ArrayList();
    this.sAK = parama;
    this.fJC = paramString;
    this.sAJ = paramInt;
    GMTrace.o(835102703616L, 6222);
  }
  
  public static boolean LR(String paramString)
  {
    GMTrace.i(836176445440L, 6230);
    synchronized (stX)
    {
      boolean bool = stW.containsKey(paramString);
      v.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      GMTrace.o(836176445440L, 6230);
      return bool;
    }
  }
  
  public static void LS(String paramString)
  {
    boolean bool = true;
    GMTrace.i(836310663168L, 6231);
    synchronized (stX)
    {
      if (stW.remove(paramString) != null)
      {
        v.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        GMTrace.o(836310663168L, 6231);
        return;
      }
      bool = false;
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Intent arg6)
  {
    GMTrace.i(14908099919872L, 111074);
    v.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002)
    {
      if (this.sAJ == 1) {}
      for (paramInt1 = 230;; paramInt1 = 245)
      {
        v.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + paramInt1 + " importType : " + this.sAJ);
        g.oSF.a(106L, paramInt1, 1L, false);
        a(this.fJC, paramString1, paramString2, ???, paramInt2, 141);
        GMTrace.o(14908099919872L, 111074);
        return;
      }
    }
    if (paramInt1 == -50008)
    {
      g.oSF.a(106L, 210L, 1L, false);
      a(this.fJC, paramString1, paramString2, ???, paramInt2, 140);
      GMTrace.o(14908099919872L, 111074);
      return;
    }
    if (paramInt1 == -50006)
    {
      if (com.tencent.mm.modelvideo.t.a(paramString1, 1, this.fJC, paramString2, 43) < 0L)
      {
        a(this.fJC, paramString1, paramString2, ???, paramInt2, 142);
        v.e("MicroMsg.ImportMultiVideo", "prepare");
        GMTrace.o(14908099919872L, 111074);
        return;
      }
      if (stY == null) {
        stY = new aq(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      b localb = new b();
      synchronized (stX)
      {
        stW.put(paramString1, localb);
        localb.fyw = paramString1;
        localb.hXD = paramString2;
        o.KW();
        localb.sub = s.lw(paramString1);
        localb.sAJ = this.sAJ;
        localb.toUser = this.fJC;
        localb.sud = paramVideoTransPara;
        stY.c(localb);
        GMTrace.o(14908099919872L, 111074);
        return;
      }
    }
    if (paramInt1 < 0)
    {
      if (this.sAJ == 1) {}
      for (paramInt1 = 229;; paramInt1 = 244)
      {
        v.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + paramInt1 + " importType : " + this.sAJ);
        g.oSF.a(106L, paramInt1, 1L, false);
        a(this.fJC, paramString1, paramString2, ???, paramInt2, 142);
        GMTrace.o(14908099919872L, 111074);
        return;
      }
    }
    com.tencent.mm.modelvideo.t.b(paramString1, paramInt2, this.fJC, paramString2);
    com.tencent.mm.modelvideo.t.lD(paramString1);
    if (this.sAJ == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      o.KW();
      paramString1 = s.lw(paramString1);
      n.KU().a(paramString2, paramString1, this.fJC, "", "", paramInt1, 2);
      GMTrace.o(14908099919872L, 111074);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    GMTrace.i(16286650204160L, 121345);
    Object localObject = new au();
    ((au)localObject).dv(5);
    ((au)localObject).cH(paramString1);
    ((au)localObject).z(ay.gk(paramString1));
    ((au)localObject).dw(1);
    ((au)localObject).cI(paramString2);
    ((au)localObject).setType(43);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().L((au)localObject);
    v.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ce)localObject).field_msgId), Long.valueOf(((ce)localObject).field_msgSvrId), ((ce)localObject).field_talker, Integer.valueOf(((ce)localObject).field_type), Integer.valueOf(((ce)localObject).field_isSend), ((ce)localObject).field_imgPath, Integer.valueOf(((ce)localObject).field_status), Long.valueOf(((ce)localObject).field_createTime) });
    if (-1L == l)
    {
      v.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      GMTrace.o(16286650204160L, 121345);
      return;
    }
    if (com.tencent.mm.modelvideo.t.lI(paramString2) == null)
    {
      o.KW();
      localObject = s.lx(paramString2);
      i = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramIntent = com.tencent.mm.compatible.i.a.i(this.context, paramIntent);
        if (paramIntent == null) {
          continue;
        }
        i = paramInt1;
        if (paramIntent.bitmap == null) {
          continue;
        }
        i = paramInt1;
        paramInt1 = bf.ex(paramIntent.duration);
        i = paramInt1;
        com.tencent.mm.sdk.platformtools.d.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        v.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = s.ly((String)localObject);
      o.KW();
      i = s.ly(s.lw(paramString2));
      paramIntent = new r();
      paramIntent.fyw = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.hrb = i;
      paramIntent.hZR = j;
      paramIntent.hZV = paramInt1;
      paramIntent.fRV = paramString1;
      paramIntent.hZN = ((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
      paramIntent.hZS = bf.Nz();
      paramIntent.hZT = bf.Nz();
      paramIntent.iab = null;
      paramIntent.hXD = paramString3;
      if (!bf.mA(paramString3)) {
        paramIntent.hZZ = 1;
      }
      paramIntent.iac = -1;
      paramIntent.status = paramInt2;
      paramIntent.hZW = ((int)l);
      if (!o.KW().a(paramIntent)) {
        v.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      GMTrace.o(16286650204160L, 121345);
      return;
      i = paramInt1;
      com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  public static void b(String paramString, int[] paramArrayOfInt)
  {
    GMTrace.i(835773792256L, 6227);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    int k = bf.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
    int j = bf.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
    paramArrayOfInt[0] = k;
    paramArrayOfInt[1] = j;
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        if ((k % 2 != 0) || (j % 2 != 0))
        {
          GMTrace.o(835773792256L, 6227);
          return;
        }
        if (((k < j) || ((k > 640) && (j > 480))) && ((k > j) || ((k > 480) && (j > 640)))) {}
      }
      else
      {
        paramArrayOfInt[0] = k;
        paramArrayOfInt[1] = j;
        GMTrace.o(835773792256L, 6227);
        return;
      }
      k /= 2;
      j /= 2;
      i += 1;
    }
  }
  
  public static void bCy()
  {
    GMTrace.i(836042227712L, 6229);
    int i;
    synchronized (stX)
    {
      i = stW.size();
      stW.clear();
      if (stY == null)
      {
        v.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(836042227712L, 6229);
        return;
      }
    }
    v.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(stY.utg.size()) });
    stY.utg.clear();
    stY = null;
    GMTrace.o(836042227712L, 6229);
  }
  
  private static void cr(String paramString, int paramInt)
  {
    GMTrace.i(836579098624L, 6233);
    int i;
    if (paramInt == 1)
    {
      paramInt = 219;
      i = 228;
    }
    for (int j = 220;; j = 234)
    {
      long l = com.tencent.mm.a.e.aN(paramString);
      i = bf.f((Integer)g.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      g.oSF.a(106L, i, 1L, false);
      g.oSF.a(106L, paramInt, 1L, false);
      v.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      GMTrace.o(836579098624L, 6233);
      return;
      paramInt = 233;
      i = 242;
    }
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      GMTrace.i(835908009984L, 6228);
      this.stN.add(Integer.valueOf(paramInt1));
      this.stO.add(paramString1);
      this.stP.add(paramString2);
      this.stQ.add(Integer.valueOf(paramInt2));
      GMTrace.o(835908009984L, 6228);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = 1;
    GMTrace.i(836713316352L, 6234);
    if (paramBoolean) {}
    while ((bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      v.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      GMTrace.o(836713316352L, 6234);
      return;
      i = 0;
    }
    try
    {
      long l1 = com.tencent.mm.a.e.aN(paramString1);
      long l2 = com.tencent.mm.a.e.aN(paramString2);
      int j = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(i).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(j);
      paramString1 = paramString1.toString();
      v.d("MicroMsg.AtomStatUtil", "report video remuxing : " + paramString1);
      g.oSF.i(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      GMTrace.o(836713316352L, 6234);
      return;
    }
    catch (Exception paramString1)
    {
      v.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      v.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      GMTrace.o(836713316352L, 6234);
    }
  }
  
  private void jf(boolean paramBoolean)
  {
    GMTrace.i(836444880896L, 6232);
    int i;
    if (this.sAJ == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.sAJ);
      g.oSF.a(106L, i, 1L, false);
      GMTrace.o(836444880896L, 6232);
      return;
      i = 218;
      continue;
      if (paramBoolean) {
        i = 231;
      } else {
        i = 232;
      }
    }
  }
  
  private void r(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(835371139072L, 6224);
    String str1 = s.lv((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
    o.KW();
    String str2 = s.lx(str1);
    o.KW();
    String str3 = s.lw(str1);
    boolean bool2 = al.is2G(aa.getContext());
    String str4 = com.tencent.mm.compatible.i.a.h(paramContext, paramIntent);
    if (bf.mA(str4))
    {
      v.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      GMTrace.o(835371139072L, 6224);
      return;
    }
    boolean bool1 = com.tencent.mm.plugin.a.c.mD(str4);
    int j = com.tencent.mm.a.e.aN(str4);
    PInt localPInt1;
    Object localObject;
    label186:
    int i;
    if (bool1)
    {
      localPInt1 = new PInt();
      if (com.tencent.mm.modelcontrol.d.Ev().iW(str4))
      {
        v.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { str4 });
        localPInt1.value = 1;
        g.oSF.a(422L, 51L, 1L, false);
        localObject = null;
        i = localPInt1.value;
      }
    }
    int k;
    int m;
    for (;;)
    {
      v.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) });
      switch (i)
      {
      default: 
        v.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        GMTrace.o(835371139072L, 6224);
        return;
        VideoTransPara localVideoTransPara = new VideoTransPara();
        localObject = new PInt();
        PInt localPInt2 = new PInt();
        PInt localPInt3 = new PInt();
        PInt localPInt4 = new PInt();
        PInt localPInt5 = new PInt();
        com.tencent.mm.plugin.sight.base.d.a(str4, (PInt)localObject, localPInt2, localPInt3, localPInt4, localPInt5);
        localVideoTransPara.duration = (((PInt)localObject).value / 1000);
        localVideoTransPara.width = localPInt2.value;
        localVideoTransPara.height = localPInt3.value;
        localVideoTransPara.gPu = localPInt4.value;
        localVideoTransPara.hzG = localPInt5.value;
        v.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara });
        localObject = com.tencent.mm.modelcontrol.d.Ev().a(localVideoTransPara);
        if (localObject == null)
        {
          v.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localVideoTransPara });
          localPInt1.value = -5;
          localObject = null;
          break label186;
        }
        v.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localObject });
        if ((localVideoTransPara.hzG <= 640000) || (((VideoTransPara)localObject).hzG > localVideoTransPara.hzG))
        {
          v.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localObject, localVideoTransPara });
          localPInt1.value = 1;
          localObject = null;
          break label186;
        }
        if ((localVideoTransPara.gPu >= 45) && (localVideoTransPara.duration * 1000 >= 180000))
        {
          localPInt1.value = -6;
          localObject = null;
          break label186;
        }
        bool2 = al.is2G(aa.getContext());
        k = ((VideoTransPara)localObject).width;
        m = ((VideoTransPara)localObject).height;
        if (bool2)
        {
          i = 10485760;
          label655:
          if (!bool2) {
            break label695;
          }
        }
        label695:
        for (double d = 60000.0D;; d = 300000.0D)
        {
          localPInt1.value = SightVideoJNI.shouldRemuxing(str4, k, m, i, d, 1000000);
          break;
          i = 20971520;
          break label655;
        }
        if (bool2) {}
        for (i = 10485760;; i = 20971520)
        {
          if (j <= i) {
            break label737;
          }
          i = -5;
          localObject = null;
          break;
        }
        label737:
        i = 1;
        localObject = null;
      }
    }
    if (j > 20971520)
    {
      a(-50002, str1, str4, 0, null, paramIntent);
      j = 0;
      i = -50002;
    }
    try
    {
      for (;;)
      {
        paramContext = com.tencent.mm.compatible.i.a.i(paramContext, paramIntent);
        if (paramContext != null) {
          break;
        }
        v.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
        a(-50005, str1, str4, 0, null, paramIntent);
        GMTrace.o(835371139072L, 6224);
        return;
        j = 0;
        i = 0;
        continue;
        j = 1;
        i = 0;
      }
      a(-50007, str1, str4, 0, null, paramIntent);
      GMTrace.o(835371139072L, 6224);
      return;
      a(-50002, str1, str4, 0, null, paramIntent);
      GMTrace.o(835371139072L, 6224);
      return;
      a(-50008, str1, str4, 0, null, paramIntent);
      GMTrace.o(835371139072L, 6224);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (j == 0)
    {
      com.tencent.mm.sdk.platformtools.j.p(str4, str3, false);
      cr(str3, this.sAJ);
      d(false, str4, str3);
    }
    for (;;)
    {
      int n = bf.ex(paramContext.duration);
      m = 1;
      k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        jf(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          jf(false);
          com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!com.tencent.mm.a.e.aO(str3)) {
              k = -50003;
            }
          }
          if (!com.tencent.mm.a.e.aO(str2)) {
            k = -50004;
          }
          a(k, str1, str4, n, (VideoTransPara)localObject, paramIntent);
          GMTrace.o(835371139072L, 6224);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          v.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void bCx()
  {
    GMTrace.i(835505356800L, 6225);
    this.isStop = true;
    interrupt();
    GMTrace.o(835505356800L, 6225);
  }
  
  public final void run()
  {
    GMTrace.i(835236921344L, 6223);
    int i;
    if ((this.stM != null) && (this.stM.size() > 0)) {
      i = 0;
    }
    while ((i < this.stM.size()) && (!this.isStop))
    {
      v.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.stM.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.stM.get(i)));
      r(this.context, localIntent);
      i += 1;
      continue;
      r(this.context, this.intent);
    }
    if ((this.sAK != null) && (!this.isStop)) {
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(750679752704L, 5593);
          j.a locala = j.e(j.this);
          j.a(j.this);
          j.b(j.this);
          j.c(j.this);
          j.d(j.this);
          locala.bCz();
          GMTrace.o(750679752704L, 5593);
        }
      });
    }
    GMTrace.o(835236921344L, 6223);
  }
  
  public static abstract interface a
  {
    public abstract void bCz();
  }
  
  private static final class b
    implements aq.a
  {
    String fyw;
    String hXD;
    int sAJ;
    String sub;
    int suc;
    VideoTransPara sud;
    private int sue;
    private int suf;
    private boolean sug;
    private int suh;
    String toUser;
    
    public b()
    {
      GMTrace.i(725715255296L, 5407);
      this.suh = 0;
      GMTrace.o(725715255296L, 5407);
    }
    
    public final boolean Bn()
    {
      GMTrace.i(725849473024L, 5408);
      for (;;)
      {
        synchronized (j.bBw())
        {
          int i;
          if (!j.bBx().containsKey(this.fyw))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (com.tencent.mm.modelvideo.t.lI(this.fyw) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              v.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fyw });
              GMTrace.o(725849473024L, 5408);
              return true;
            }
          }
          else
          {
            i = 0;
          }
        }
        int j = 0;
      }
      if ((this.sud != null) && (!this.sud.isDefault)) {
        this.sue = this.sud.width;
      }
      Object localObject3;
      for (this.suf = this.sud.height;; this.suf = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().a(this.hXD, (PString)???, (PInt)localObject3)) || (!com.tencent.mm.sdk.platformtools.j.ex(((PString)???).value, this.sub))) {
          break;
        }
        v.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.suc = ((PInt)localObject3).value;
        this.sug = true;
        GMTrace.o(725849473024L, 5408);
        return true;
        ??? = new int[2];
        j.b(this.hXD, (int[])???);
        this.sue = ???[0];
      }
      long l = bf.NB();
      boolean bool;
      if (this.sud != null)
      {
        v.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.sud });
        if (com.tencent.mm.plugin.sight.base.b.prW) {
          this.sud.hzG = ((int)(this.sud.hzG * 0.915D));
        }
        this.suc = SightVideoJNI.remuxing(this.hXD, this.sub, this.sue, this.suf, this.sud.hzG, this.sud.hzw, 8, this.sud.hzv, 25.0F, this.sud.gPu, null, 0, com.tencent.mm.plugin.sight.base.b.prW);
        this.suh = ((int)bf.aB(l));
        v.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.hXD, this.sub, Integer.valueOf(this.suc), Integer.valueOf(this.sue), Integer.valueOf(this.suf) });
        if (this.suc < 0) {
          break label632;
        }
        bool = true;
        label458:
        this.sug = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (com.tencent.mm.modelvideo.t.a(this.sub, (PInt)???, (PInt)localObject3)) {
          this.suc = ((PInt)???).value;
        }
        if (this.sug) {
          break label638;
        }
        v.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
        com.tencent.mm.loader.stub.b.deleteFile(this.sub);
        com.tencent.mm.sdk.platformtools.j.p(this.hXD, this.sub, false);
      }
      label632:
      label638:
      PInt localPInt;
      for (;;)
      {
        GMTrace.o(725849473024L, 5408);
        return true;
        v.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fyw });
        if (com.tencent.mm.plugin.sight.base.b.prW) {
          com.tencent.mm.plugin.sight.base.b.prY = (int)(com.tencent.mm.plugin.sight.base.b.prY * 0.915D);
        }
        this.suc = SightVideoJNI.remuxing(this.hXD, this.sub, this.sue, this.suf, com.tencent.mm.plugin.sight.base.b.prY, com.tencent.mm.plugin.sight.base.b.prX, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.prZ, null, 0, com.tencent.mm.plugin.sight.base.b.prW);
        break;
        bool = false;
        break label458;
        v.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
        try
        {
          ??? = new File(this.sub).getName();
          localObject3 = this.sub + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.d.b(this.sub, (String)localObject3, localPInt)) {
            break label875;
          }
          bool = com.tencent.mm.loader.stub.b.deleteFile(this.sub);
          localObject3 = new File((String)localObject3);
          v.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.a.e.h(((File)localObject3).getParent() + File.separator, ((File)localObject3).getName(), (String)???)), ((File)localObject3).getAbsolutePath(), this.sub });
          g.oSF.a(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().H(this.hXD, this.sub, this.suc);
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
      }
      label875:
      if (localPInt.value != 1) {
        g.oSF.a(354L, 31L, 1L, false);
      }
      for (;;)
      {
        v.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.hXD, this.sub });
        break;
        g.oSF.a(354L, 32L, 1L, false);
        g.oSF.i(13836, new Object[] { Integer.valueOf(600), Long.valueOf(bf.Nz()), this.sub });
      }
    }
    
    public final boolean Bo()
    {
      GMTrace.i(725983690752L, 5409);
      for (;;)
      {
        synchronized (j.bBw())
        {
          j.bBx().remove(this.fyw);
          if (this.sug)
          {
            j.cs(this.sub, this.sAJ);
            j.e(this.sug, this.hXD, this.sub);
            if (!com.tencent.mm.plugin.sight.base.b.prW) {
              break label188;
            }
            i = 1;
            j.a(i, this.suh, this.hXD, this.sub, this.suc);
            if (this.sAJ != 1) {
              break label193;
            }
            i = 8;
            if (!this.sug) {
              break label198;
            }
            j = 1;
            n.KU().a(this.hXD, this.sub, this.toUser, "", "", i, j);
            com.tencent.mm.modelvideo.t.i(this.fyw, this.suc, 43);
            com.tencent.mm.modelvideo.t.lD(this.fyw);
            GMTrace.o(725983690752L, 5409);
            return false;
          }
        }
        j.ct(this.sub, this.sAJ);
        continue;
        label188:
        int i = 0;
        continue;
        label193:
        i = 1;
        continue;
        label198:
        int j = 3;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */