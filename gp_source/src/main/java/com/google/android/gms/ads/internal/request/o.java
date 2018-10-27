package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.f;

@com.google.android.gms.ads.internal.q.a.a
public abstract class o
  implements m, ag
{
  public final com.google.android.gms.ads.internal.util.c.a a;
  public final m b;
  private final Object c = new Object();
  
  public o(com.google.android.gms.ads.internal.util.c.a parama, m paramm)
  {
    this.a = parama;
    this.b = paramm;
  }
  
  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    synchronized (this.c)
    {
      this.b.a(paramAdResponseParcel);
      d();
      return;
    }
  }
  
  final boolean a(z paramz, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    try
    {
      paramz.a(paramAdRequestInfoParcel, new w(this));
      return true;
    }
    finally
    {
      e.e("Could not fetch ad response from ad request service due to an Exception.", paramz);
      bt.A.i.a(paramz, "AdRequestClientTask.getAdResponseFromService");
      this.b.a(new AdResponseParcel(0));
    }
    return false;
  }
  
  public final void b()
  {
    d();
  }
  
  public abstract void d();
  
  public abstract z e();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */