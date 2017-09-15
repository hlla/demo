package com.tencent.mm.modelmulti;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug.MemoryInfo;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.au.b;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.SDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.SubDirInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.WeChatSDInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class p
  implements am
{
  private static final long startTime;
  public Runnable hLA;
  public Runnable hLB;
  private com.tencent.mm.sdk.b.c hLC;
  private ai hLD;
  long hLh;
  long hLi;
  long hLj;
  long hLk;
  long hLl;
  long hLm;
  long hLn;
  long hLo;
  public long hLp;
  public long hLq;
  long hLr;
  private BroadcastReceiver hLs;
  public boolean hLt;
  public boolean hLu;
  public long hLv;
  public Runnable hLw;
  public c.a hLx;
  public long hLy;
  private com.tencent.mm.y.e hLz;
  private j.a hoC;
  
  static
  {
    GMTrace.i(401579442176L, 2992);
    startTime = System.currentTimeMillis();
    GMTrace.o(401579442176L, 2992);
  }
  
  public p()
  {
    GMTrace.i(397150257152L, 2959);
    this.hLh = 1024L;
    this.hLi = 10L;
    this.hLj = 1800L;
    this.hLk = 3000000L;
    this.hLl = 15000L;
    this.hLm = 100000L;
    this.hLn = 10000L;
    this.hLo = 1024L;
    this.hLp = 1440L;
    this.hLq = 20L;
    this.hLr = 1440L;
    this.hLt = false;
    this.hLu = true;
    this.hLv = 0L;
    this.hLy = 0L;
    this.hLz = new com.tencent.mm.y.e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(410706247680L, 3060);
        if (paramAnonymousk == null) {}
        for (int i = -1;; i = paramAnonymousk.getType())
        {
          v.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            com.tencent.mm.plugin.report.service.d.aXz();
          }
          GMTrace.o(410706247680L, 3060);
          return;
        }
      }
    };
    this.hoC = new j.a()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        GMTrace.i(396613386240L, 2955);
        v.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bf.bJP() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          p.this.bk(true);
        }
        GMTrace.o(396613386240L, 2955);
      }
    };
    this.hLA = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14449075290112L, 107654);
        v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        p localp = p.this;
        ap.yY();
        long l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uCR, Long.valueOf(0L))).longValue();
        long l2 = System.currentTimeMillis();
        if ((l2 - l1 > 259200000L) || (l1 > l2))
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uCR, Long.valueOf(l2));
          com.tencent.mm.sdk.f.e.post(new p.5(localp), "reportSDStatus");
        }
        localp = p.this;
        ap.yY();
        l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uDz, Long.valueOf(0L))).longValue();
        l2 = System.currentTimeMillis();
        if ((l2 - l1 > localp.hLr * 60000L) || (l1 > l2))
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uDz, Long.valueOf(l2));
          l1 = localp.hLj;
          l2 = localp.hLk;
          com.tencent.mm.sdk.f.e.post(new p.2(localp, l1 * 1024L * 1024L, localp.hLo * 1024L * 1024L, l2, localp.hLl, localp.hLm, localp.hLn), "reportDBInfo");
        }
        localp = p.this;
        ap.yY();
        l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uDF, Long.valueOf(0L))).longValue();
        l2 = System.currentTimeMillis();
        if ((l2 - l1 > 259200000L) || (l1 > l2))
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uDF, Long.valueOf(l2));
          com.tencent.mm.sdk.f.e.post(new p.3(localp), "reportVersion");
        }
        p.this.Hy();
        ap.vL();
        ae.I(p.this.hLB);
        ap.vL().e(p.this.hLB, 10000L);
        GMTrace.o(14449075290112L, 107654);
      }
    };
    this.hLB = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14447196241920L, 107640);
        v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        if (p.this.hLy != 0L)
        {
          ap.yY();
          long l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEy, Long.valueOf(0L))).longValue();
          long l2 = System.currentTimeMillis();
          if ((l2 - l1 > 86400000L) || (l1 > l2))
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(509L, 17L, 1L, true);
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uEy, Long.valueOf(l2));
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEx, Long.valueOf(0L))).longValue();
            log_14375 locallog_14375 = new log_14375();
            locallog_14375.type_ = 4;
            Object localObject = new HeavyDetailInfo();
            locallog_14375.heavyDetailInfo_ = ((HeavyDetailInfo)localObject);
            ((HeavyDetailInfo)localObject).flag_ = l1;
            ap.yY();
            l2 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEz, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).sdFileSize_ = l2;
            String str = String.valueOf(l1) + ";" + l2;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEA, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).sdFileRatio_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEB, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).dbSize_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEC, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).message_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uED, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).conversation_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEE, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).contact_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEF, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).chatroom_ = l1;
            str = str + ";" + l1;
            ap.yY();
            l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEG, Long.valueOf(0L))).longValue();
            ((HeavyDetailInfo)localObject).favDbSize_ = l1;
            localObject = str + ";" + l1;
            com.tencent.mm.plugin.report.service.g.oSF.i(13778, new Object[] { Integer.valueOf(4), Integer.valueOf(1), localObject });
            com.tencent.mm.plugin.report.service.g.oSF.b(14375, locallog_14375);
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", new Object[] { localObject });
          }
        }
        GMTrace.o(14447196241920L, 107640);
      }
    };
    this.hLC = new com.tencent.mm.sdk.b.c() {};
    this.hLD = new ai(ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(14448672636928L, 107651);
        p.this.Hy();
        GMTrace.o(14448672636928L, 107651);
        return true;
      }
    }, true);
    GMTrace.o(397150257152L, 2959);
  }
  
  public final void Hy()
  {
    GMTrace.i(16009222160384L, 119278);
    ap.yY();
    int j = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEH, Integer.valueOf(0))).intValue();
    ap.yY();
    long l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEI, Long.valueOf(0L))).longValue();
    ap.yY();
    int k = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEJ, Integer.valueOf(0))).intValue();
    int m = Process.myPid();
    Object localObject = ((ActivityManager)aa.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { m });
    if ((localObject != null) && (localObject.length > 0) && (localObject[0] != null)) {}
    for (int i = localObject[0].getTotalPss();; i = -1)
    {
      if (j == 0)
      {
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uEH, Integer.valueOf(m));
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uEI, Long.valueOf(System.currentTimeMillis() - startTime));
        ap.yY();
        localObject = com.tencent.mm.u.c.vr();
        w.a locala = w.a.uEJ;
        if (i > 0) {
          ((t)localObject).a(locala, Integer.valueOf(i));
        }
      }
      for (;;)
      {
        this.hLD.v(180000L, 180000L);
        GMTrace.o(16009222160384L, 119278);
        return;
        i = 0;
        break;
        if (j != m)
        {
          com.tencent.mm.plugin.report.service.g.oSF.i(13778, new Object[] { Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(l1) });
          com.tencent.mm.plugin.report.service.g.oSF.i(13778, new Object[] { Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(k) });
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uEH, Integer.valueOf(m));
          long l2 = System.currentTimeMillis() - startTime;
          if (i > 0) {}
          for (;;)
          {
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uEI, Long.valueOf(l2));
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uEJ, Integer.valueOf(i));
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) });
            break;
            i = 0;
          }
        }
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uEI, Long.valueOf(System.currentTimeMillis() - startTime));
        if (i > k)
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uEJ, Integer.valueOf(i));
        }
      }
    }
  }
  
  public final c.a a(File paramFile, c.a parama, c.b paramb, c.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(398089781248L, 2966);
    if (parama.hJL)
    {
      v.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      GMTrace.o(398089781248L, 2966);
      return parama;
    }
    if (parama.hJI < paramInt) {
      parama.hJI += 1;
    }
    Object localObject;
    if (paramFile.isDirectory())
    {
      localObject = paramFile.getAbsolutePath();
      if ((paramb != null) || (paramMap == null) || (paramMap.size() <= 0) || (paramMap.get(localObject) == null)) {
        break label866;
      }
      paramb = new c.b((String)localObject, ((Integer)paramMap.get(localObject)).intValue());
      paramMap.remove(localObject);
      parama.hJJ.add(paramb);
      v.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject, parama, paramb });
    }
    label808:
    label863:
    label866:
    for (;;)
    {
      parama.hJF += 1L;
      if (paramb != null) {
        paramb.hJF += 1L;
      }
      if (paramc != null) {
        paramc.hJF += 1L;
      }
      if (paramInt > 15)
      {
        v.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), paramFile.getAbsolutePath(), parama });
        GMTrace.o(398089781248L, 2966);
        return parama;
      }
      String[] arrayOfString = paramFile.list();
      int j;
      if (arrayOfString != null)
      {
        if (paramBoolean)
        {
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            localObject = paramc;
            if (!bf.mA(str))
            {
              localObject = paramc;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                localObject = new c.c(paramFile.getAbsolutePath() + File.separator + str);
                parama.hJK.add(localObject);
              }
            }
            a(new File(paramFile.getAbsolutePath() + File.separator + str), parama, paramb, (c.c)localObject, paramMap, false, paramInt + 1);
            i += 1;
            paramc = (c.c)localObject;
          }
        }
        int i = 1;
        int k = arrayOfString.length;
        j = 0;
        if (j >= k) {
          break label808;
        }
        localObject = arrayOfString[j];
        a(new File(paramFile.getAbsolutePath() + File.separator + (String)localObject), parama, paramb, paramc, paramMap, false, paramInt + 1);
        if ((i == 0) || (parama.hJI <= 15)) {
          break label863;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(418L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.g.oSF.i(13778, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramFile.getAbsolutePath() + File.separator + (String)localObject });
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        v.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { paramFile.getAbsolutePath() });
        GMTrace.o(398089781248L, 2966);
        return parama;
        parama.hJG += 1L;
        if (paramb != null) {
          paramb.hJG += 1L;
        }
        if (paramc != null) {
          paramc.hJG += 1L;
        }
        if (!paramFile.exists())
        {
          v.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { paramFile.getAbsolutePath(), Long.valueOf(parama.hJG) });
          GMTrace.o(398089781248L, 2966);
          return parama;
        }
        long l = paramFile.length();
        if ((l > 0L) && (l < 2147483648L))
        {
          parama.fKY += l;
          if (paramb != null) {
            paramb.fKY += l;
          }
          if (paramc != null) {
            paramc.fKY = (l + paramc.fKY);
          }
        }
        for (;;)
        {
          GMTrace.o(398089781248L, 2966);
          return parama;
          parama.fileLenInvalidCount += 1L;
          if (paramb != null) {
            paramb.fileLenInvalidCount += 1L;
          }
          if (paramc != null) {
            paramc.hJM += 1L;
          }
        }
      }
    }
  }
  
  public final void a(int paramInt, final long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(17613795098624L, 131233);
        if (paramLong1 > paramLong2)
        {
          bool = true;
          if (bool)
          {
            l = this.hLy | paramInt;
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.hLy), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.hLy) {
              break label539;
            }
            if (this.hLy == 0L) {
              com.tencent.mm.plugin.report.service.g.oSF.a(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label539;
            }
            com.tencent.mm.plugin.report.service.g.oSF.a(509L, 2L, 1L, true);
            break label539;
            this.hLy = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.d.gD(bool);
            ap.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(14447598895104L, 107643);
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uEx, Long.valueOf(l));
                if (paramLong1 != null)
                {
                  ap.yY();
                  com.tencent.mm.u.c.vr().a(paramLong1, Long.valueOf(this.hLN));
                }
                v.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(l), Long.valueOf(p.this.hLy), paramLong1, Long.valueOf(this.hLN) });
                GMTrace.o(14447598895104L, 107643);
              }
            });
            GMTrace.o(17613795098624L, 131233);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        final long l = this.hLy & (paramInt ^ 0xFFFFFFFF);
        continue;
        w.a locala = w.a.uEz;
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label619;
        }
        paramLong2 = 3L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEA;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label627;
        }
        paramLong2 = 5L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEB;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label635;
        }
        paramLong2 = 7L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEC;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label643;
        }
        paramLong2 = 9L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uED;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label651;
        }
        paramLong2 = 11L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEE;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label659;
        }
        paramLong2 = 13L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEF;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (!bool) {
          break label667;
        }
        paramLong2 = 15L;
        localg.a(509L, paramLong2, 1L, true);
        continue;
        locala = w.a.uEG;
        localg = com.tencent.mm.plugin.report.service.g.oSF;
        if (bool)
        {
          paramLong2 = 19L;
          localg.a(509L, paramLong2, 1L, true);
          continue;
        }
        paramLong2 = 20L;
        continue;
        boolean bool = false;
        continue;
        Object localObject2 = null;
      }
      finally {}
      label539:
      switch (paramInt)
      {
      }
      continue;
      label619:
      paramLong2 = 4L;
      continue;
      label627:
      paramLong2 = 6L;
      continue;
      label635:
      paramLong2 = 8L;
      continue;
      label643:
      paramLong2 = 10L;
      continue;
      label651:
      paramLong2 = 12L;
      continue;
      label659:
      paramLong2 = 14L;
      continue;
      label667:
      paramLong2 = 16L;
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(397687128064L, 2963);
    com.tencent.mm.sdk.b.a.uql.a(this.hLC);
    com.tencent.mm.u.c.c.Az().c(this.hoC);
    boolean bool = bk(false);
    ap.yY();
    this.hLy = ((Long)com.tencent.mm.u.c.vr().get(w.a.uEx, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.hLy != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.d.gD(paramBoolean);
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.hLy), Boolean.valueOf(bool), this.hoC });
      ap.vd().a(989, this.hLz);
      ap.vd().a(988, this.hLz);
      ap.vd().a(987, this.hLz);
      ap.vd().a(986, this.hLz);
      ap.yY();
      this.hLv = ((Long)com.tencent.mm.u.c.vr().get(w.a.uDA, Long.valueOf(0L))).longValue();
      localObject1 = aa.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label462;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label457;
      }
      paramBoolean = true;
      label244:
      this.hLt = paramBoolean;
      label249:
      this.hLu = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.hLs = new BroadcastReceiver()
      {
        public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          GMTrace.i(14444377669632L, 107619);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          label92:
          boolean bool2;
          boolean bool3;
          long l;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              bool2 = p.this.hLu;
              bool3 = p.this.hLt;
              l = p.this.hLv;
              if (p.this.hLw != null) {}
              break;
            }
            break;
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            v.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
            if ((p.this.hLw != null) || (!p.this.hLt) || (p.this.hLu)) {
              break label457;
            }
            if (System.currentTimeMillis() - p.this.hLv >= p.this.hLp * 60000L) {
              break label374;
            }
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(p.this.hLp) });
            GMTrace.o(14444377669632L, 107619);
            return;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
              break;
            }
            i = 0;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
              break;
            }
            i = 1;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
              break;
            }
            i = 2;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
              break;
            }
            i = 3;
            break;
            p.this.hLu = true;
            break label92;
            p.this.hLu = false;
            break label92;
            p.this.hLt = true;
            break label92;
            p.this.hLt = false;
            break label92;
          }
          label374:
          paramAnonymousContext = new c()
          {
            public final void a(int paramAnonymous2Int, c.a paramAnonymous2a)
            {
              GMTrace.i(14448941072384L, 107653);
              p.this.hLv = System.currentTimeMillis();
              v.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(p.this.hLv), p.this.hLx, paramAnonymous2a });
              p.this.hLx = null;
              p localp;
              log_14375 locallog_14375;
              SDStatusInfo localSDStatusInfo;
              if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.hJL))
              {
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uDA, Long.valueOf(p.this.hLv));
                ap.yY();
                com.tencent.mm.u.c.vr().jV(false);
                try
                {
                  localp = p.this;
                  locallog_14375 = new log_14375();
                  locallog_14375.type_ = 2;
                  localSDStatusInfo = new SDStatusInfo();
                  locallog_14375.sdStatusInfo_ = localSDStatusInfo;
                  localObject2 = new c.c("total/temp/acc/");
                  localObject1 = paramAnonymous2a.hJK.iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject3 = (c.c)((Iterator)localObject1).next();
                    ((c.c)localObject2).hJF += ((c.c)localObject3).hJF;
                    ((c.c)localObject2).hJG += ((c.c)localObject3).hJG;
                    ((c.c)localObject2).fKY += ((c.c)localObject3).fKY;
                    ((c.c)localObject2).hJM += ((c.c)localObject3).hJM;
                  }
                  GMTrace.o(14448941072384L, 107653);
                }
                catch (Exception paramAnonymous2a)
                {
                  v.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                  com.tencent.mm.plugin.report.service.g.oSF.a(418L, 6L, 1L, true);
                }
              }
              else
              {
                return;
              }
              v.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo total tempAccDirResult[%d][%s]", new Object[] { Integer.valueOf(paramAnonymous2a.hJK.size()), localObject2 });
              Collections.sort(paramAnonymous2a.hJJ, new p.14(localp));
              Object localObject1 = paramAnonymous2a.hJJ.iterator();
              while (((Iterator)localObject1).hasNext()) {
                v.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%s]", new Object[] { (c.b)((Iterator)localObject1).next() });
              }
              localObject1 = paramAnonymous2a.fKY + ":" + paramAnonymous2a.hJF + ":" + paramAnonymous2a.hJG + ":" + paramAnonymous2a.fileLenInvalidCount + ":" + paramAnonymous2a.hJJ.size() + ":" + paramAnonymous2a.hJH + ":" + paramAnonymous2a.hJI + "|" + paramAnonymous2a.hJK.size() + ":" + ((c.c)localObject2).fKY + ":" + ((c.c)localObject2).hJF + ":" + ((c.c)localObject2).hJG + ":" + ((c.c)localObject2).hJM;
              Object localObject3 = new WeChatSDInfo();
              localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject3);
              ((WeChatSDInfo)localObject3).totalSize_ = paramAnonymous2a.fKY;
              ((WeChatSDInfo)localObject3).fileCount_ = paramAnonymous2a.hJG;
              ((WeChatSDInfo)localObject3).fileLenInvalidCount_ = paramAnonymous2a.fileLenInvalidCount;
              ((WeChatSDInfo)localObject3).subDirResultsSize_ = paramAnonymous2a.hJJ.size();
              ((WeChatSDInfo)localObject3).totalTime_ = paramAnonymous2a.hJH;
              ((WeChatSDInfo)localObject3).depth_ = paramAnonymous2a.hJI;
              ((WeChatSDInfo)localObject3).tempAccTotalSize_ = ((c.c)localObject2).fKY;
              ((WeChatSDInfo)localObject3).tempAccDirResultsSize_ = paramAnonymous2a.hJK.size();
              ((WeChatSDInfo)localObject3).tempAccDirCount_ = ((c.c)localObject2).hJF;
              ((WeChatSDInfo)localObject3).tempAccFileCount_ = ((c.c)localObject2).hJG;
              ((WeChatSDInfo)localObject3).tempAccFileLenInvalidCount_ = ((c.c)localObject2).hJM;
              Object localObject2 = new LinkedList();
              ((WeChatSDInfo)localObject3).subDirList_ = ((LinkedList)localObject2);
              localObject3 = paramAnonymous2a.hJJ.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (c.b)((Iterator)localObject3).next();
                localObject1 = (String)localObject1 + "|" + ((c.b)localObject4).tag + ":" + ((c.b)localObject4).fKY + ":" + ((c.b)localObject4).hJF + ":" + ((c.b)localObject4).hJG + ":" + ((c.b)localObject4).fileLenInvalidCount;
                SubDirInfo localSubDirInfo = new SubDirInfo();
                ((LinkedList)localObject2).add(localSubDirInfo);
                localSubDirInfo.tag_ = ((c.b)localObject4).tag;
                localSubDirInfo.totalSize_ = ((c.b)localObject4).fKY;
                localSubDirInfo.dirCount_ = ((c.b)localObject4).hJF;
                localSubDirInfo.fileCount_ = ((c.b)localObject4).hJG;
                localSubDirInfo.fileLenInvalidCount = ((c.b)localObject4).fileLenInvalidCount;
              }
              v.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo wechatResult[%d][%s]", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
              localObject2 = h.getExternalStorageDirectory().getPath();
              boolean bool1 = au.bJv();
              localObject3 = au.PD(com.tencent.mm.compatible.util.e.hgi);
              Object localObject4 = new StatFs((String)localObject2);
              long l6 = ((StatFs)localObject4).getBlockSize();
              long l7 = ((StatFs)localObject4).getBlockCount();
              long l8 = ((StatFs)localObject4).getAvailableBlocks();
              long l9 = l6 * l7;
              long l10 = l6 * l8;
              paramAnonymous2Int = -1;
              if (l7 > 0L) {
                paramAnonymous2Int = Math.round((float)(100L * l8 / l7));
              }
              boolean bool2 = com.tencent.mm.compatible.util.e.hgi.equals(localObject2);
              long l5;
              long l4;
              long l3;
              long l2;
              long l1;
              int i;
              if (!bool2)
              {
                localObject4 = new StatFs(com.tencent.mm.compatible.util.e.hgi);
                l5 = ((StatFs)localObject4).getBlockSize();
                l4 = ((StatFs)localObject4).getBlockCount();
                l3 = ((StatFs)localObject4).getAvailableBlocks();
                l2 = l5 * l4;
                l1 = l5 * l3;
                if (l4 > 0L) {
                  i = Math.round((float)(100L * l3 / l4));
                }
              }
              for (;;)
              {
                int k = Math.round((float)(paramAnonymous2a.fKY * 100L / l2));
                localSDStatusInfo.weChatPer_ = k;
                localp.a(1, paramAnonymous2a.fKY, localp.hLh * 1024L * 1024L);
                if (paramAnonymous2a.fKY > localp.hLh * 1024L * 1024L)
                {
                  j = 1;
                  localSDStatusInfo.sizeHeavy_ = j;
                  localp.a(2, k, localp.hLi);
                  if (k <= localp.hLi) {
                    break label1678;
                  }
                  j = 1;
                  label1206:
                  localSDStatusInfo.ratioHeavy_ = j;
                  paramAnonymous2a = new StringBuilder().append(k).append(";");
                  if (!bool2) {
                    break label1684;
                  }
                  j = 1;
                  label1240:
                  paramAnonymous2a = paramAnonymous2a.append(j).append(";");
                  if (!bool1) {
                    break label1690;
                  }
                }
                label1678:
                label1684:
                label1690:
                for (int j = 1;; j = 0)
                {
                  paramAnonymous2a = j + ";" + l5 + ":" + l4 + ":" + l3 + ":" + l2 + ":" + l1 + ":" + i + "|" + l6 + ":" + l7 + ":" + l8 + ":" + l9 + ":" + l10 + ":" + paramAnonymous2Int + ";" + (String)localObject2 + ";" + com.tencent.mm.compatible.util.e.hgi + ";" + (String)localObject3;
                  localSDStatusInfo.sBlockSize_ = l5;
                  localSDStatusInfo.sBlockCount_ = l4;
                  localSDStatusInfo.sAvailableBlockCount_ = l3;
                  localSDStatusInfo.sTotalSize_ = l2;
                  localSDStatusInfo.sAvailableSize_ = l1;
                  localSDStatusInfo.sAvailablePer_ = i;
                  localSDStatusInfo.eBlockSize_ = l6;
                  localSDStatusInfo.eBlockCount_ = l7;
                  localSDStatusInfo.eAvailableBlockCount_ = l8;
                  localSDStatusInfo.eTotalSize_ = l9;
                  localSDStatusInfo.eAvailableSize_ = l10;
                  localSDStatusInfo.eAvailablePer_ = paramAnonymous2Int;
                  localSDStatusInfo.ePath_ = ((String)localObject2);
                  localSDStatusInfo.root_ = com.tencent.mm.compatible.util.e.hgi;
                  localSDStatusInfo.fSystem_ = ((String)localObject3);
                  v.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo phoneResult[%d][%s]", new Object[] { Integer.valueOf(paramAnonymous2a.length()), paramAnonymous2a });
                  paramAnonymous2a = (String)localObject1 + ";" + paramAnonymous2a;
                  v.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo totalResult[%d][%s]", new Object[] { Integer.valueOf(paramAnonymous2a.length()), paramAnonymous2a });
                  com.tencent.mm.plugin.report.service.g.oSF.a(418L, 5L, 1L, true);
                  com.tencent.mm.plugin.report.service.g.oSF.i(13778, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramAnonymous2a });
                  com.tencent.mm.plugin.report.service.g.oSF.b(14375, locallog_14375);
                  GMTrace.o(14448941072384L, 107653);
                  return;
                  j = 0;
                  break;
                  j = 0;
                  break label1206;
                  j = 0;
                  break label1240;
                }
                i = paramAnonymous2Int;
                continue;
                i = paramAnonymous2Int;
                l1 = l10;
                l2 = l9;
                l3 = l8;
                l4 = l7;
                l5 = l6;
              }
            }
          };
          p.this.hLw = new Runnable()
          {
            public final void run()
            {
              Object localObject1 = null;
              GMTrace.i(14448001548288L, 107646);
              p.this.hLw = null;
              p localp1 = p.this;
              p localp2 = p.this;
              c localc = paramAnonymousContext;
              v.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan");
              ap.yY();
              if (!com.tencent.mm.u.c.isSDCardAvailable())
              {
                v.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as sdcard not available");
                localc.a(-1, null);
              }
              for (;;)
              {
                localp1.hLx = ((c.a)localObject1);
                v.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { p.this.hLx });
                GMTrace.o(14448001548288L, 107646);
                return;
                Object localObject2 = com.tencent.mm.compatible.util.e.hgk;
                File localFile = new File((String)localObject2);
                if ((!localFile.exists()) || (!localFile.isDirectory()))
                {
                  v.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as path not exists[%s]", new Object[] { localObject2 });
                  localc.a(-1, null);
                }
                else
                {
                  v.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan root[%s] exist[%b], diretory[%b]", new Object[] { localObject2, Boolean.valueOf(localFile.exists()), Boolean.valueOf(localFile.isDirectory()) });
                  localObject2 = new HashMap(26);
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xe();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xe().length() - 1), Integer.valueOf(1));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xf();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xf().length() - 1), Integer.valueOf(2));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xb();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xb().length() - 1), Integer.valueOf(3));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xc();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xc().length() - 1), Integer.valueOf(4));
                  ap.yY();
                  ((Map)localObject2).put(com.tencent.mm.u.c.xr(), Integer.valueOf(5));
                  ((Map)localObject2).put(com.tencent.mm.plugin.g.a.ZQ().substring(0, com.tencent.mm.plugin.g.a.ZQ().length() - 1), Integer.valueOf(6));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xi();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xi().length() - 1), Integer.valueOf(7));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.getAccVideoPath();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.getAccVideoPath().length() - 1), Integer.valueOf(8));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xl();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xl().length() - 1), Integer.valueOf(9));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xj();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xj().length() - 1), Integer.valueOf(10));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xm();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xm().length() - 1), Integer.valueOf(11));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xn();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xn().length() - 1), Integer.valueOf(12));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xo();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xo().length() - 1), Integer.valueOf(13));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xs();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xs().length() - 1), Integer.valueOf(14));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xg();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xg().length() - 1), Integer.valueOf(15));
                  ((Map)localObject2).put(b.JK().substring(0, b.JK().length() - 1), Integer.valueOf(16));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xh();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xh().length() - 1), Integer.valueOf(17));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xq();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xq().length() - 1), Integer.valueOf(18));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xp();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xp().length() - 1), Integer.valueOf(19));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.getAccSnsPath();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.getAccSnsPath().length() - 1), Integer.valueOf(20));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xt();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xt().length() - 1), Integer.valueOf(21));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.xd();
                  ap.yY();
                  ((Map)localObject2).put(((String)localObject1).substring(0, com.tencent.mm.u.c.xd().length() - 1), Integer.valueOf(22));
                  ((Map)localObject2).put(com.tencent.mm.compatible.util.e.gSv, Integer.valueOf(23));
                  ((Map)localObject2).put(com.tencent.mm.compatible.util.e.gSn.substring(0, com.tencent.mm.compatible.util.e.gSn.length() - 1), Integer.valueOf(24));
                  ((Map)localObject2).put(com.tencent.mm.compatible.util.e.gSr.substring(0, com.tencent.mm.compatible.util.e.gSr.length() - 1), Integer.valueOf(25));
                  ((Map)localObject2).put(com.tencent.mm.compatible.util.e.gSp.substring(0, com.tencent.mm.compatible.util.e.gSp.length() - 1), Integer.valueOf(26));
                  localObject1 = new c.a(localFile.getAbsolutePath());
                  com.tencent.mm.sdk.f.e.post(new p.13(localp2, (Map)localObject2, (c.a)localObject1, localFile, localc), "summerhv_scanFile");
                }
              }
            }
          };
          ap.vL().e(p.this.hLw, p.this.hLq * 60000L);
          v.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(p.this.hLq) });
          GMTrace.o(14444377669632L, 107619);
          return;
          label457:
          if (p.this.hLw != null)
          {
            ap.vL().bJb().removeCallbacks(p.this.hLw);
            p.this.hLw = null;
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { p.this.hLx });
            GMTrace.o(14444377669632L, 107619);
            return;
          }
          if (p.this.hLx != null)
          {
            p.this.hLx.hJL = true;
            v.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { p.this.hLx });
            p.this.hLx = null;
          }
          GMTrace.o(14444377669632L, 107619);
        }
      };
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((Context)localObject1).registerReceiver(this.hLs, (IntentFilter)localObject2);
      if (this.hLx == null) {
        break label470;
      }
      localObject1 = "enabled";
      label344:
      if (!this.hLu) {
        break label478;
      }
      localObject2 = "";
      label356:
      if (!this.hLt) {
        break label486;
      }
    }
    label457:
    label462:
    label470:
    label478:
    label486:
    for (String str = "";; str = " not")
    {
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.hLv), Long.valueOf(this.hLp * 60000L), Long.valueOf(this.hLq * 60000L) });
      this.hLD.KI();
      GMTrace.o(397687128064L, 2963);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label244;
      this.hLt = false;
      break label249;
      localObject1 = "disabled";
      break label344;
      localObject2 = " not";
      break label356;
    }
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(397821345792L, 2964);
    GMTrace.o(397821345792L, 2964);
  }
  
  public final boolean bk(boolean paramBoolean)
  {
    GMTrace.i(17613660880896L, 131232);
    Object localObject = com.tencent.mm.u.c.c.Az().dX("100212");
    v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).bKA(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(20L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).bKA();
      long l1 = bf.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bf.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bf.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bf.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bf.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bf.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bf.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bf.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bf.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bf.getLong((String)((Map)localObject).get("sdwait"), 20L);
      long l11 = bf.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.hLh), Long.valueOf(l1), Long.valueOf(this.hLi), Long.valueOf(l2), Long.valueOf(this.hLj), Long.valueOf(l3), Long.valueOf(this.hLo), Long.valueOf(l4), Long.valueOf(this.hLk), Long.valueOf(l5), Long.valueOf(this.hLl), Long.valueOf(l6), Long.valueOf(this.hLm), Long.valueOf(l7), Long.valueOf(this.hLn), Long.valueOf(l8), Long.valueOf(this.hLp), Long.valueOf(l9), Long.valueOf(this.hLq), Long.valueOf(l10), Long.valueOf(this.hLr), Long.valueOf(l11) });
      if (this.hLh != l1)
      {
        this.hLh = l1;
        bool = true;
        if (this.hLi != l2)
        {
          this.hLi = l2;
          bool = true;
        }
        if (this.hLj != l3)
        {
          this.hLj = l3;
          bool = true;
        }
        if (this.hLo != l4)
        {
          this.hLo = l4;
          bool = true;
        }
        if (this.hLk != l5)
        {
          this.hLk = l5;
          bool = true;
        }
        if (this.hLl != l6)
        {
          this.hLl = l6;
          bool = true;
        }
        if (this.hLm != l7)
        {
          this.hLm = l7;
          bool = true;
        }
        if (this.hLn != l8)
        {
          this.hLn = l8;
          bool = true;
        }
        if (this.hLp != l9)
        {
          this.hLp = l9;
          bool = true;
        }
        if (this.hLq != l10)
        {
          this.hLq = l10;
          bool = true;
        }
        if (this.hLr != l11) {
          this.hLr = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.g.oSF.a(509L, 18L, 1L, true);
        }
      }
      if (this.hLh <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 30L, 1L, true);
        this.hLh = 1024L;
      }
      if (this.hLi <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 31L, 1L, true);
        this.hLi = 10L;
      }
      if (this.hLj <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 32L, 1L, true);
        this.hLj = 1800L;
      }
      if (this.hLk <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 33L, 1L, true);
        this.hLk = 3000000L;
      }
      if (this.hLl <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 34L, 1L, true);
        this.hLl = 15000L;
      }
      if (this.hLm <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 35L, 1L, true);
        this.hLm = 100000L;
      }
      if (this.hLn <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 36L, 1L, true);
        this.hLm = 10000L;
      }
      if (this.hLp <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 37L, 1L, true);
        this.hLp = 1440L;
      }
      if (this.hLq <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 38L, 1L, true);
        this.hLq = 20L;
      }
      if (this.hLr <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 39L, 1L, true);
        this.hLr = 1440L;
      }
      if (this.hLo <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(509L, 40L, 1L, true);
        this.hLo = 1024L;
      }
      GMTrace.o(17613660880896L, 131232);
      return bool;
      bool = false;
      break;
    }
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(397552910336L, 2962);
    GMTrace.o(397552910336L, 2962);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(397955563520L, 2965);
    v.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.hLs != null)
    {
      aa.getContext().unregisterReceiver(this.hLs);
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.hLs });
      this.hLs = null;
    }
    if (this.hLw != null)
    {
      ap.vL().bJb().removeCallbacks(this.hLw);
      this.hLw = null;
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.hLx });
    }
    if (this.hLx != null)
    {
      this.hLx.hJL = true;
      v.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.hLx });
      this.hLx = null;
    }
    ap.vd().b(989, this.hLz);
    ap.vd().b(988, this.hLz);
    ap.vd().b(987, this.hLz);
    ap.vd().b(986, this.hLz);
    com.tencent.mm.u.c.c.Az().f(this.hoC);
    com.tencent.mm.sdk.b.a.uql.c(this.hLC);
    GMTrace.o(397955563520L, 2965);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(397418692608L, 2961);
    GMTrace.o(397418692608L, 2961);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */