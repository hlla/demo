package com.c.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import java.util.Iterator;

final class k
  extends c
  implements GpsStatus.Listener, LocationListener
{
  private static k aKZ;
  private LocationManager HT;
  private boolean aLa;
  private GpsStatus aLb;
  private a aLc;
  private Looper aLd;
  private final l aLe = new l();
  private Context ty;
  
  private void a(long paramLong, float paramFloat)
  {
    this.HT.requestLocationUpdates("gps", paramLong, paramFloat, this, this.aLd);
  }
  
  static k nl()
  {
    if (aKZ == null) {
      aKZ = new k();
    }
    return aKZ;
  }
  
  final void O(Context paramContext)
  {
    this.ty = paramContext;
    this.HT = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.HT != null) && (this.HT.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.aLa = bool;
      return;
    }
  }
  
  final void P(Context paramContext)
  {
    if (!this.aLa) {
      return;
    }
    this.HT.removeUpdates(this);
    this.HT.removeGpsStatusListener(this);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (!this.aLa) {
      return;
    }
    this.aLc = ((a)parama);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.aLd = paramContext;
      a(this.aLc.aJl, this.aLc.aLf);
      this.HT.addGpsStatusListener(this);
      this.aLe.aLn = Math.max(5000L, Math.min(this.aLc.aJl + 5000L, 65000L));
      return;
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      try
      {
        parama = new a(30000L);
        super.a(paramHandler, parama);
        return;
      }
      finally {}
      if ((parama instanceof a)) {
        parama = (a)parama;
      } else {
        parama = new a(parama.aJl);
      }
    }
  }
  
  final void ne() {}
  
  final void nf()
  {
    if ((!this.aLa) || (!this.aJi) || (this.aLc.aJl >= 300000L)) {
      return;
    }
    a(300000L, this.aLc.aLf);
  }
  
  final void ng()
  {
    if ((!this.aLa) || (!this.aJi) || (this.aLc.aJl >= 300000L)) {
      return;
    }
    a(this.aLc.aJl, this.aLc.aLf);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    if (paramInt == 4)
    {
      if (this.aLb == null) {
        this.aLb = this.HT.getGpsStatus(null);
      }
    }
    else {
      return;
    }
    this.HT.getGpsStatus(this.aLb);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    int i;
    if (!y.aPp)
    {
      if (Settings.Secure.getString(this.ty.getContentResolver(), "mock_location").equals("0")) {}
      for (i = 0; i != 0; i = 1) {
        return;
      }
    }
    Iterator localIterator;
    int j;
    if (this.aLb != null)
    {
      localIterator = this.aLb.getSatellites().iterator();
      i = 0;
      j = 0;
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      this.aLe.a(paramLocation.getAccuracy(), j, paramLocation.getTime());
      c(new b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), i, j, this.aLe.aLj, this.aLe.aLr / 1000L));
      return;
      GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
      int k = i + 1;
      i = k;
      if (!localGpsSatellite.usedInFix()) {
        break;
      }
      j += 1;
      i = k;
      break;
      j = 0;
      i = 0;
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  static final class a
    extends d.a
  {
    final int aLf = 0;
    
    a(long paramLong)
    {
      super();
    }
  }
  
  static final class b
    extends p
  {
    final double aLg;
    final float aLh;
    final float aLi;
    final float aLj;
    final int aLk;
    final int aLl;
    final long aLm;
    final double lat;
    final double lng;
    
    public b(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.aLg = paramDouble3;
      this.aLh = paramFloat1;
      this.aLi = paramFloat2;
      this.aLk = paramInt1;
      this.aLl = paramInt2;
      this.aLj = paramFloat3;
      this.aLm = paramLong;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */