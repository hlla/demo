package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.de;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k
{
  public static com.tencent.mm.modelgeo.c gJY;
  public static float gJZ;
  public static float gKa;
  public static boolean gKb;
  public static Map<String, afl> gKc;
  public static List<afl> gKd;
  public static Boolean gKe;
  public static a.a gKf;
  private static ai gKg;
  public static com.tencent.mm.sdk.b.c gKh;
  
  static
  {
    GMTrace.i(504658657280L, 3760);
    gJZ = -85.0F;
    gKa = -1000.0F;
    gKb = false;
    gKc = new ConcurrentHashMap();
    gKd = new CopyOnWriteArrayList();
    gKe = Boolean.valueOf(false);
    gKf = new a.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        GMTrace.i(15301492080640L, 114005);
        if (paramAnonymousBoolean)
        {
          v.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          k.gJZ = paramAnonymousFloat2;
          k.gKa = paramAnonymousFloat1;
          k.gKb = true;
          if (k.gJY != null)
          {
            k.gJY.c(k.gKf);
            k.gKb = false;
          }
        }
        for (;;)
        {
          GMTrace.o(15301492080640L, 114005);
          return false;
          v.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    gKg = new ai(Looper.getMainLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(494055456768L, 3681);
        try
        {
          ap.yY();
          Boolean localBoolean = Boolean.valueOf(bf.b((Boolean)com.tencent.mm.u.c.vr().get(w.a.uAQ, null), false));
          Object localObject2 = com.tencent.mm.i.g.sW().sJ();
          if (localObject2 == null) {
            break label382;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            v.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            df localdf = new df();
            localdf.fGR.fGT = str;
            localdf.fGR.fGQ = false;
            if (!localBoolean.booleanValue()) {
              a.uql.m(localdf);
            }
          }
          localObject1 = new afn();
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          GMTrace.o(494055456768L, 3681);
          return false;
        }
        final Object localObject1;
        ((afn)localObject1).latitude = k.gJZ;
        ((afn)localObject1).longitude = k.gKa;
        ap.yY();
        long l = bf.a((Long)com.tencent.mm.u.c.vr().get(w.a.uAH, null), 0L);
        if ((k.gKc.size() > 0) && (!k.gKe.booleanValue()) && (k.gKd.size() > 0))
        {
          k.gKe = Boolean.valueOf(true);
          localObject1 = new com.tencent.mm.modelmulti.e(k.gKd, l, (afn)localObject1);
          v.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + k.gKd.size() + ",info:" + k.gKd.toString());
          ap.vd().a(1708, new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.y.k paramAnonymous2k)
            {
              GMTrace.i(500095254528L, 3726);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2k = (uy)localObject1.hJX.hrT.hsa;
                if (paramAnonymous2k.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2k.tAT;
                  paramAnonymous2k = paramAnonymous2k.tAV;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.tJe + "," + paramAnonymous2String.tJf + "," + paramAnonymous2k.mpX + "," + paramAnonymous2k.major + "," + paramAnonymous2k.minor;
                  ap.yY();
                  String[] arrayOfString = bf.ap((String)com.tencent.mm.u.c.vr().get(w.a.uAN, null), "").split(",");
                  paramAnonymous2Int2 = arrayOfString.length;
                  paramAnonymous2String = Boolean.valueOf(false);
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    if (arrayOfString[paramAnonymous2Int1].equals(paramAnonymous2k.mpX + paramAnonymous2k.major + paramAnonymous2k.minor)) {
                      paramAnonymous2String = Boolean.valueOf(true);
                    }
                    paramAnonymous2Int1 += 1;
                  }
                  if (!paramAnonymous2String.booleanValue())
                  {
                    com.tencent.mm.plugin.report.service.g.oSF.i(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.g.oSF.i(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.uAM, str);
                  }
                }
              }
              for (;;)
              {
                ap.yY();
                com.tencent.mm.u.c.uR();
                paramAnonymous2String = new de();
                a.uql.m(paramAnonymous2String);
                k.gKe = Boolean.valueOf(false);
                ap.vd().b(1708, this);
                GMTrace.o(500095254528L, 3726);
                return;
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uAM, "");
                continue;
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uAM, "");
                continue;
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uAM, "");
              }
            }
          });
          ap.vd().a((com.tencent.mm.y.k)localObject1, 0);
        }
        for (;;)
        {
          k.gKc.clear();
          k.gKd.clear();
          a.uql.c(k.gKh);
          label382:
          GMTrace.o(494055456768L, 3681);
          return false;
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uAM, "");
        }
      }
    }, true);
    gKh = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(504658657280L, 3760);
  }
  
  public static void run()
  {
    GMTrace.i(502913826816L, 3747);
    if ((!ap.zb()) || (ap.uP()))
    {
      GMTrace.o(502913826816L, 3747);
      return;
    }
    ap.yY();
    Object localObject = Boolean.valueOf(bf.b((Boolean)com.tencent.mm.u.c.vr().get(w.a.uAO, null), false));
    v.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + localObject);
    if (!((Boolean)localObject).booleanValue())
    {
      GMTrace.o(502913826816L, 3747);
      return;
    }
    long l1 = bf.Nz();
    ap.yY();
    long l2 = bf.a((Long)com.tencent.mm.u.c.vr().get(w.a.uAP, null), 0L);
    ap.yY();
    if (l1 - l2 > bf.a((Long)com.tencent.mm.u.c.vr().get(w.a.uAJ, null), 0L))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uAO, Boolean.valueOf(false));
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uAN, "");
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uAM, "");
      ap.yY();
      com.tencent.mm.u.c.uR();
      GMTrace.o(502913826816L, 3747);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.i.g.sW().sJ();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          v.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          df localdf = new df();
          localdf.fGR.fGT = str;
          localdf.fGR.fGQ = true;
          a.uql.m(localdf);
        }
        gJY = com.tencent.mm.modelgeo.c.Gl();
        if (gKg.bJg()) {
          gKg.v(3000L, 3000L);
        }
        if ((!gKb) && (gJY != null)) {
          gJY.b(gKf);
        }
        a.uql.b(gKh);
      }
      GMTrace.o(502913826816L, 3747);
      return;
    }
    ap.yY();
    com.tencent.mm.u.c.vr().a(w.a.uAM, "");
    GMTrace.o(502913826816L, 3747);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */