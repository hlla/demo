package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements a
{
  public static c hvy;
  public double aKg;
  public boolean hCH;
  public g hCI;
  public List<WeakReference<a.a>> hCJ;
  long hCK;
  public long hCL;
  public boolean hCM;
  public boolean hCN;
  public double hCO;
  public double hCP;
  public int hCQ;
  public double hCR;
  public double hCS;
  private boolean hCT;
  private boolean hCU;
  private e hCV;
  private f hCW;
  private ad hgD;
  private Context mContext;
  
  private c(Context paramContext)
  {
    GMTrace.i(487076134912L, 3629);
    this.hCH = false;
    this.hCJ = new ArrayList();
    this.hCK = 0L;
    this.hCL = 0L;
    this.hCM = false;
    this.hCN = false;
    this.hCO = 23.0D;
    this.hCP = 100.0D;
    this.hCQ = 0;
    this.hCR = 0.0D;
    this.hCS = 0.0D;
    this.aKg = 0.0D;
    this.hCT = false;
    this.hCU = false;
    this.hgD = new ad(Looper.getMainLooper());
    this.hCV = new e()
    {
      public final void b(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5)
      {
        GMTrace.i(15680388726784L, 116828);
        c.this.bi(paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          c.this.hCO = paramAnonymousDouble1;
          c.this.hCP = paramAnonymousDouble2;
          c.this.hCQ = paramAnonymousInt;
          c.this.hCR = paramAnonymousDouble3;
          c.this.hCS = paramAnonymousDouble4;
          c.this.aKg = paramAnonymousDouble5;
          c.this.hCL = System.currentTimeMillis();
          c.this.hCM = true;
          c.this.hCN = false;
          c.this.fK(67592);
        }
        v.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble3) });
        new ad(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(483049603072L, 3599);
            c.this.a(paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt, paramAnonymousDouble4, paramAnonymousDouble5, this.hDd, this.hDe);
            GMTrace.o(483049603072L, 3599);
          }
        });
        GMTrace.o(15680388726784L, 116828);
      }
    };
    this.hCW = new f()
    {
      public final void b(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5)
      {
        GMTrace.i(15681462468608L, 116836);
        c.this.bi(paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          c.this.hCO = paramAnonymousDouble1;
          c.this.hCP = paramAnonymousDouble2;
          c.this.hCQ = paramAnonymousInt;
          c.this.hCR = paramAnonymousDouble3;
          c.this.hCS = paramAnonymousDouble4;
          c.this.aKg = paramAnonymousDouble5;
          c.this.hCN = true;
          c.this.hCM = false;
          c.this.hCL = System.currentTimeMillis();
          c.this.fK(67591);
        }
        v.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble3) });
        new ad(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(486807699456L, 3627);
            c.this.a(paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt, paramAnonymousDouble4, paramAnonymousDouble5, this.hDd, this.hDe);
            GMTrace.o(486807699456L, 3627);
          }
        }, 200L);
        GMTrace.o(15681462468608L, 116836);
      }
    };
    this.mContext = paramContext;
    this.hCI = g.aW(paramContext);
    GMTrace.o(487076134912L, 3629);
  }
  
  public static c Gl()
  {
    GMTrace.i(486941917184L, 3628);
    if (hvy == null) {
      hvy = new c(aa.getContext());
    }
    c localc = hvy;
    GMTrace.o(486941917184L, 3628);
    return localc;
  }
  
  public static boolean Gm()
  {
    GMTrace.i(487747223552L, 3634);
    try
    {
      boolean bool = ((LocationManager)aa.getContext().getSystemService("location")).isProviderEnabled("gps");
      GMTrace.o(487747223552L, 3634);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(487747223552L, 3634);
    }
    return false;
  }
  
  public static boolean Gn()
  {
    GMTrace.i(487881441280L, 3635);
    try
    {
      boolean bool = ((LocationManager)aa.getContext().getSystemService("location")).isProviderEnabled("network");
      GMTrace.o(487881441280L, 3635);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(487881441280L, 3635);
    }
    return false;
  }
  
  public final void a(a.a parama)
  {
    GMTrace.i(487478788096L, 3632);
    b(parama, true);
    GMTrace.o(487478788096L, 3632);
  }
  
  public final void a(a.a parama, boolean paramBoolean)
  {
    GMTrace.i(487210352640L, 3630);
    v.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.hCH) && (this.hCJ.size() > 0)) {}
    try
    {
      this.hCK = System.currentTimeMillis();
      this.hCT = false;
      this.hCU = false;
      g.Gp();
      g.a(this.hCW, 0, Looper.getMainLooper());
      this.hCH = false;
      Iterator localIterator = this.hCJ.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((a.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.hCJ.add(new WeakReference(parama));
      }
      v.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.hCJ.size()) });
      if ((this.hCJ.size() != 1) || (i == 0)) {}
    }
    catch (g.a locala)
    {
      for (;;)
      {
        try
        {
          this.hCK = System.currentTimeMillis();
          this.hCT = false;
          this.hCU = false;
          g.a(this.hCW, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.hCN) && (System.currentTimeMillis() - this.hCL < 60000L)) {
            this.hCV.b(true, this.hCO, this.hCP, this.hCQ, this.hCR, this.hCS, this.aKg);
          }
          GMTrace.o(487210352640L, 3630);
          return;
          locala = locala;
          v.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (g.a parama)
        {
          v.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void a(boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    GMTrace.i(16086263136256L, 119852);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.hCJ.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((List)localObject1).add((a.a)localWeakReference.get());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if ((r.iib) && (b.bIk())) {
        ((a.a)localObject2).a(paramBoolean, (float)r.lng, (float)r.lat, paramInt, (float)paramDouble3, paramDouble4, paramDouble5);
      } else {
        ((a.a)localObject2).a(paramBoolean, (float)paramDouble2, (float)paramDouble1, paramInt, (float)paramDouble3, paramDouble4, paramDouble5);
      }
    }
    GMTrace.o(16086263136256L, 119852);
  }
  
  public final void b(a.a parama)
  {
    GMTrace.i(487344570368L, 3631);
    a(parama, true);
    GMTrace.o(487344570368L, 3631);
  }
  
  public final void b(a.a parama, boolean paramBoolean)
  {
    GMTrace.i(16287589728256L, 121352);
    if ((!this.hCH) && (this.hCJ.size() > 0)) {}
    try
    {
      this.hCK = System.currentTimeMillis();
      this.hCT = false;
      this.hCU = false;
      g.Gp();
      g.a(this.hCV, 1, Looper.getMainLooper());
      this.hCH = true;
      Iterator localIterator = this.hCJ.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((a.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.hCJ.add(new WeakReference(parama));
      }
      v.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.hCJ.size()) });
      if ((this.hCJ.size() != 1) || (i == 0)) {}
    }
    catch (g.a locala)
    {
      for (;;)
      {
        try
        {
          this.hCK = System.currentTimeMillis();
          this.hCT = false;
          this.hCU = false;
          g.a(this.hCV, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.hCM) && (System.currentTimeMillis() - this.hCL < 60000L)) {
            this.hCV.b(true, this.hCO, this.hCP, this.hCQ, this.hCR, this.hCS, this.aKg);
          }
          GMTrace.o(16287589728256L, 121352);
          return;
          locala = locala;
          v.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (g.a parama)
        {
          v.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void bi(boolean paramBoolean)
  {
    int i = 10;
    GMTrace.i(16086397353984L, 119853);
    if ((paramBoolean) && (this.hCT))
    {
      GMTrace.o(16086397353984L, 119853);
      return;
    }
    if ((!paramBoolean) && (this.hCU))
    {
      GMTrace.o(16086397353984L, 119853);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.hCK <= 500L) {}
    for (;;)
    {
      int j = i;
      if (!paramBoolean) {
        j = i + 1;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(584L, j, 1L, true);
      if (!paramBoolean) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(584L, 30L, 1L, true);
      com.tencent.mm.plugin.report.service.g.oSF.a(584L, 31L, l - this.hCK, true);
      this.hCT = true;
      GMTrace.o(16086397353984L, 119853);
      return;
      if (l - this.hCK <= 1000L) {
        i = 12;
      } else if (l - this.hCK <= 2000L) {
        i = 14;
      } else if (l - this.hCK <= 4000L) {
        i = 16;
      } else if (l - this.hCK <= 8000L) {
        i = 18;
      }
    }
    this.hCU = true;
    GMTrace.o(16086397353984L, 119853);
  }
  
  public final void c(final a.a parama)
  {
    GMTrace.i(487613005824L, 3633);
    new ad().post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(482110078976L, 3592);
        Object localObject1 = new ArrayList();
        Object localObject2 = c.this.hCJ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (((a.a)localWeakReference.get()).equals(parama))) {
            ((List)localObject1).add(localWeakReference);
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WeakReference)((Iterator)localObject1).next();
          c.this.hCJ.remove(localObject2);
        }
        v.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(c.this.hCJ.size()) });
        if ((c.this.hCJ.size() == 0) && (c.this.hCI != null)) {
          g.Gp();
        }
        GMTrace.o(482110078976L, 3592);
      }
    });
    GMTrace.o(487613005824L, 3633);
  }
  
  public final void fK(int paramInt)
  {
    GMTrace.i(16086531571712L, 119854);
    if (!h.vG().uV())
    {
      GMTrace.o(16086531571712L, 119854);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((int)this.hCS);
    localStringBuffer.append(",");
    localStringBuffer.append(this.hCQ);
    localStringBuffer.append(",");
    localStringBuffer.append((int)(this.hCO * 1000000.0D));
    localStringBuffer.append(",");
    localStringBuffer.append((int)(this.hCP * 1000000.0D));
    h.vI().vr().set(paramInt, localStringBuffer.toString());
    v.d("MicroMsg.LocationGeo", "Save Location Success id=%d|content=%s", new Object[] { Integer.valueOf(paramInt), localStringBuffer.toString() });
    GMTrace.o(16086531571712L, 119854);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelgeo/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */