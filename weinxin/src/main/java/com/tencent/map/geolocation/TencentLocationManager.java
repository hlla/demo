package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import ct.b.a;
import ct.bk;
import ct.bl;
import ct.by;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final bk b;
  private final by c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = bk.a(paramContext);
    this.c = new by(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      if (d != null) {
        break label76;
      }
      if (paramContext == null) {
        throw new NullPointerException("context is null");
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    if (Looper.myLooper() == null) {
      throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
    }
    d = new TencentLocationManager(paramContext.getApplicationContext());
    label76:
    paramContext = d;
    return paramContext;
  }
  
  public final String getBuild()
  {
    bl localbl = this.b.a(-1L);
    if (localbl != null) {
      return localbl.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.f();
  }
  
  public final String getKey()
  {
    return b.a.b(this.b.g().h);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    return this.c.a();
  }
  
  public final String getVersion()
  {
    bl localbl = this.b.a(-1L);
    if (localbl != null) {
      return localbl.d();
    }
    return "None";
  }
  
  public final String pauseLocationUpdates()
  {
    return this.c.e();
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.c();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final int requestSingleFreshLocation(TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final String resumeLocationUpdates()
  {
    return this.c.d();
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        this.c.a(paramInt);
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: " + paramString);
    }
    this.b.g().h = paramString;
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentDistanceListener);
      return i;
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      TencentDistanceAnalysis localTencentDistanceAnalysis = this.c.b();
      return localTencentDistanceAnalysis;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/map/geolocation/TencentLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */