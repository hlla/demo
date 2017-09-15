package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class m
{
  static final a HS = new a();
  private final LocationManager HT;
  final Context mContext;
  
  m(Context paramContext)
  {
    this.mContext = paramContext;
    this.HT = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  static boolean a(a parama)
  {
    return (parama != null) && (parama.HZ > System.currentTimeMillis());
  }
  
  static void b(Location paramLocation)
  {
    a locala = HS;
    long l1 = System.currentTimeMillis();
    if (l.HP == null) {
      l.HP = new l();
    }
    l locall = l.HP;
    locall.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = locall.HQ;
    locall.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (locall.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = locall.HR;
      l4 = locall.HQ;
      locall.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = locall.HR;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.HU = bool;
      locala.HV = l2;
      locala.HW = l3;
      locala.HX = l4;
      locala.HY = l5;
      locala.HZ = l1;
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  final Location o(String paramString)
  {
    if (this.HT != null) {
      try
      {
        if (this.HT.isProviderEnabled(paramString))
        {
          paramString = this.HT.getLastKnownLocation(paramString);
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private static final class a
  {
    boolean HU;
    long HV;
    long HW;
    long HX;
    long HY;
    long HZ;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */