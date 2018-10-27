package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.x;
import android.util.Log;
import java.util.Calendar;

final class be
{
  public static be a;
  private final Context b;
  private final LocationManager c;
  private final bf d = new bf();
  
  be(Context paramContext, LocationManager paramLocationManager)
  {
    this.b = paramContext;
    this.c = paramLocationManager;
  }
  
  private final Location a(String paramString)
  {
    try
    {
      if (this.c.isProviderEnabled(paramString))
      {
        paramString = this.c.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.d("TwilightManager", "Failed to get last known location", paramString);
    }
    return null;
  }
  
  final boolean a()
  {
    bf localbf = this.d;
    if (localbf.b <= System.currentTimeMillis())
    {
      if (x.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
      for (Object localObject1 = a("network");; localObject1 = null)
      {
        if (x.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {}
        for (Object localObject2 = a("gps");; localObject2 = null)
        {
          if (localObject2 == null) {
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if (localObject1 == null)
            {
              Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
              int i = Calendar.getInstance().get(11);
              return (i < 6) || (i >= 22);
            }
            localObject2 = this.d;
            long l4 = System.currentTimeMillis();
            if (bd.a == null) {
              bd.a = new bd();
            }
            bd localbd = bd.a;
            localbd.a(-86400000L + l4, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
            localbd.a(l4, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
            if (localbd.b == 1) {}
            for (boolean bool = true;; bool = false)
            {
              long l2 = localbd.c;
              long l3 = localbd.d;
              localbd.a(86400000L + l4, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
              long l1 = localbd.c;
              if (l2 == -1L) {}
              while (l3 == -1L)
              {
                l1 = 43200000L + l4;
                ((bf)localObject2).a = bool;
                ((bf)localObject2).b = l1;
                return localbf.a;
              }
              if (l4 <= l3) {
                if (l4 <= l2) {
                  break label305;
                }
              }
              label305:
              for (l1 = l3;; l1 = l2)
              {
                l1 += 60000L;
                break;
              }
            }
            continue;
            if (localObject1 == null) {
              break;
            }
            if (((Location)localObject2).getTime() > ((Location)localObject1).getTime()) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    return localbf.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */