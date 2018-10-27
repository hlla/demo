package com.google.android.finsky.ca;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import com.google.android.finsky.download.h;
import com.google.android.finsky.download.x;

abstract class a
  implements x
{
  public long a;
  public com.google.android.finsky.download.b b;
  public final Handler c;
  public c d;
  public long e;
  private final ConnectivityManager f;
  private final WifiManager g;
  
  a(Context paramContext, Handler paramHandler)
  {
    this.f = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.g = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi"));
    this.c = paramHandler;
    a();
  }
  
  protected final void a()
  {
    this.a = -1L;
    this.e = -1L;
    this.d = null;
    this.b = null;
  }
  
  protected final c b()
  {
    StrictMode.noteSlowCall("DownloadNetworkQualityListener.getCurrentNetworkState");
    c localc = new c();
    localc.a = this.f.getActiveNetworkInfo();
    NetworkInfo localNetworkInfo = localc.a;
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1)) {
      localc.b = this.g.getConnectionInfo();
    }
    return localc;
  }
  
  public void b(com.google.android.finsky.download.b paramb, int paramInt)
  {
    a();
  }
  
  public void b(com.google.android.finsky.download.b paramb, h paramh)
  {
    double d1 = paramh.a / paramh.b;
    com.google.android.finsky.download.b localb = this.b;
    if ((localb != null) && (!localb.equals(paramb))) {
      a();
    }
    if ((this.b == null) && (d1 >= 0.2D) && (d1 < 0.9D))
    {
      this.b = paramb;
      this.a = paramh.a;
      this.e = SystemClock.uptimeMillis();
      this.c.post(new b(this, paramb));
    }
  }
  
  public void f(com.google.android.finsky.download.b paramb)
  {
    a();
  }
  
  public void g(com.google.android.finsky.download.b paramb)
  {
    a();
  }
  
  public void h(com.google.android.finsky.download.b paramb) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ca/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */