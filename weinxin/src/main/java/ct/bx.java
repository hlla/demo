package ct;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.Arrays;
import java.util.Iterator;

final class bx
  implements GpsStatus.Listener, LocationListener
{
  private long a = 0L;
  private final bk b;
  private int c = 1024;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private int g = 0;
  private volatile boolean h;
  private boolean i;
  private br j;
  private GpsStatus k;
  private final double[] l = new double[2];
  
  public bx(bk parambk)
  {
    this.b = parambk;
    this.j = br.a();
  }
  
  private static void a(Location paramLocation, double paramDouble1, double paramDouble2, int paramInt)
  {
    Bundle localBundle2 = paramLocation.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putDouble("lat", paramDouble1);
    localBundle1.putDouble("lng", paramDouble2);
    localBundle1.putInt("rssi", paramInt);
    paramLocation.setExtras(localBundle1);
  }
  
  private static boolean a(double paramDouble)
  {
    return Math.abs(Double.valueOf(paramDouble).longValue() - paramDouble) < Double.MIN_VALUE;
  }
  
  @SuppressLint({"NewApi"})
  private boolean a(Location paramLocation)
  {
    if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {}
    for (;;)
    {
      return false;
      try
      {
        if (!this.b.c().isProviderEnabled("gps")) {
          return true;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          boolean bool = paramLocation.isFromMockProvider();
          if (bool) {
            return true;
          }
        }
      }
      catch (NoSuchMethodError paramLocation)
      {
        return false;
      }
      catch (Exception paramLocation) {}
    }
    return false;
  }
  
  private void d()
  {
    int m;
    if (this.c == 4) {
      m = 1;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = m;
      this.b.c(localMessage);
      return;
      if (this.c == 0) {
        m = 0;
      } else {
        m = -1;
      }
    }
  }
  
  private void e()
  {
    Object localObject1 = null;
    try
    {
      this.g = 0;
      this.f = 0;
      localObject2 = this.b.c();
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label28:
      b.a.b("TxGpsProvider", localException1.toString());
      return;
    }
    try
    {
      localObject2 = ((LocationManager)localObject2).getGpsStatus(null);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      break label28;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int m = ((GpsStatus)localObject1).getMaxSatellites();
      localObject1 = ((GpsStatus)localObject1).getSatellites().iterator();
      if (localObject1 != null) {
        while ((((Iterator)localObject1).hasNext()) && (this.f <= m))
        {
          this.f += 1;
          if (((GpsSatellite)((Iterator)localObject1).next()).usedInFix()) {
            this.g += 1;
          }
        }
      }
    }
  }
  
  private int f()
  {
    Object localObject = null;
    int n = -1;
    try
    {
      GpsStatus localGpsStatus = this.b.c().getGpsStatus(null);
      localObject = localGpsStatus;
    }
    catch (Exception localException)
    {
      int i1;
      int m;
      for (;;) {}
    }
    if (localObject == null) {}
    do
    {
      return n;
      i1 = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    m = 0;
    for (;;)
    {
      n = m;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      n = m;
      if (m > i1) {
        break;
      }
      ((Iterator)localObject).next();
      m += 1;
    }
  }
  
  private int g()
  {
    Object localObject = null;
    int n = -1;
    try
    {
      GpsStatus localGpsStatus = this.b.c().getGpsStatus(null);
      localObject = localGpsStatus;
    }
    catch (Exception localException)
    {
      int i1;
      int m;
      for (;;) {}
    }
    if (localObject == null) {}
    do
    {
      return n;
      i1 = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    m = 0;
    for (;;)
    {
      n = m;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      n = m;
      if (m > i1) {
        break;
      }
      if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
        m += 1;
      }
    }
  }
  
  public final void a()
  {
    if (!this.h) {
      return;
    }
    this.h = false;
    this.a = 0L;
    this.c = 1024;
    this.d = false;
    this.e = false;
    this.f = 0;
    this.g = 0;
    this.i = false;
    Arrays.fill(this.l, 0.0D);
    this.b.b(this);
    LocationManager localLocationManager = this.b.c();
    try
    {
      localLocationManager.removeGpsStatusListener(this);
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          localLocationManager.removeUpdates(this);
          b.a.a("TxGpsProvider", "shutdown: state=[shutdown]");
          return;
          localException2 = localException2;
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.b.a(this);
    paramLong = Math.max(paramLong, 1000L);
    LocationManager localLocationManager = this.b.c();
    if (!paramBoolean) {}
    try
    {
      localLocationManager.addGpsStatusListener(this);
      localLocationManager.requestLocationUpdates("gps", paramLong, 0.0F, this);
      for (;;)
      {
        if (c())
        {
          this.c = 4;
          d();
        }
        b.a.a("TxGpsProvider", "startup: state=[start]");
        return;
        localLocationManager.requestLocationUpdates("passive", paramLong, 0.0F, this);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ct.a = true;
        b.a.a("TxGpsProvider", "startup: can not add location listener", localException);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.c & 0x2) == 2)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.a < bw.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean c()
  {
    LocationManager localLocationManager = this.b.c();
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Error localError)
    {
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      e();
      paramInt = f();
      int m = g();
      if (paramInt > 0) {
        this.e = true;
      }
      if (m > 0) {
        this.d = true;
      }
      return;
      this.c |= 0x1;
      continue;
      this.c = 0;
      continue;
      this.c |= 0x2;
      continue;
      Object localObject = this.b.c();
      try
      {
        if (this.k == null) {
          this.k = ((LocationManager)localObject).getGpsStatus(null);
        }
        for (;;)
        {
          if (this.k == null) {
            break label216;
          }
          bool = this.j.a(this.k);
          if (!bool) {
            break label211;
          }
          paramInt = 3;
          localObject = new Message();
          ((Message)localObject).what = 12999;
          ((Message)localObject).arg1 = 12004;
          ((Message)localObject).arg2 = paramInt;
          this.b.c(localObject);
          break;
          ((LocationManager)localObject).getGpsStatus(this.k);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label211:
          paramInt = 4;
          continue;
          label216:
          boolean bool = true;
        }
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {}
    for (;;)
    {
      double d1;
      double d2;
      int n;
      try
      {
        if (!"gps".equals(paramLocation.getProvider())) {
          return;
        }
        d1 = paramLocation.getLatitude();
        d2 = paramLocation.getLongitude();
        b.a.a("TxGpsProvider", "onLocationChanged: " + DateFormat.format("yyyy-MM-dd kk:mm:ss", this.a) + d1 + "," + d2);
        if (paramLocation.getAccuracy() > 10000.0F)
        {
          m = 0;
          if (m == 0) {
            continue;
          }
          e();
          this.c |= 0x2;
          if (a(paramLocation)) {
            continue;
          }
          this.a = System.currentTimeMillis();
          m = 0;
          if (this.g == 3)
          {
            m = 1;
            if ((!this.i) || (!cu.a(paramLocation.getLatitude(), paramLocation.getLongitude()))) {
              break label420;
            }
            n = 1;
            if (n == 0) {
              continue;
            }
            b.a.a(paramLocation, this.l);
            a(paramLocation, this.l[0], this.l[1], m);
            paramLocation = new ch(paramLocation, this.a, this.f, this.g, this.c);
            this.b.c(paramLocation);
          }
        }
        else
        {
          if ((a(d1)) && (a(d2)))
          {
            m = 0;
            continue;
          }
          if ((Math.abs(d1) < 1.0E-8D) || (Math.abs(d2) < 1.0E-8D)) {
            break label362;
          }
          if (Math.abs(d1 - 1.0D) < 1.0E-8D) {
            break label368;
          }
          if (Math.abs(d2 - 1.0D) >= 1.0E-8D) {
            break label374;
          }
          break label368;
        }
        if ((this.g >= 4) && (this.g <= 6))
        {
          m = 2;
          continue;
        }
        if (this.g < 7) {
          continue;
        }
        m = 3;
        continue;
        a(paramLocation, paramLocation.getLatitude(), paramLocation.getLongitude(), m);
        continue;
        m = 0;
      }
      catch (Error paramLocation)
      {
        return;
      }
      catch (Exception paramLocation)
      {
        return;
      }
      label362:
      continue;
      label368:
      int m = 0;
      continue;
      label374:
      if ((d1 < -90.0D) || (d1 > 90.0D) || (d2 < -180.0D) || (d2 > 180.0D))
      {
        m = 0;
      }
      else
      {
        m = 1;
        continue;
        label420:
        n = 0;
      }
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      b.a.a("TxGpsProvider", "onProviderDisabled: gps is disabled");
      this.g = 0;
      this.f = 0;
      this.c = 0;
      this.d = false;
      this.a = 0L;
      d();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      b.a.a("TxGpsProvider", "onProviderEnabled: gps is enabled");
      this.c = 4;
      d();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */