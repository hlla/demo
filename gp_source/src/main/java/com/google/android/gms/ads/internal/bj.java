package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import java.lang.ref.WeakReference;

@com.google.android.gms.ads.internal.q.a.a
public final class bj
{
  public AdRequestParcel a;
  public boolean b = false;
  public boolean c = false;
  private final bl d;
  private long e = 0L;
  private final Runnable f;
  
  public bj(a parama)
  {
    this(parama, new bl(n.a));
  }
  
  private bj(a parama, bl parambl)
  {
    this.d = parambl;
    this.f = new bk(this, new WeakReference(parama));
  }
  
  public final void a()
  {
    this.c = false;
    this.d.a(this.f);
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel)
  {
    a(paramAdRequestParcel, 60000L);
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    if (this.c) {
      e.e("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      this.a = paramAdRequestParcel;
      this.c = true;
      this.e = paramLong;
    } while (this.b);
    paramAdRequestParcel = new StringBuilder(65);
    paramAdRequestParcel.append("Scheduling ad refresh ");
    paramAdRequestParcel.append(paramLong);
    paramAdRequestParcel.append(" milliseconds from now.");
    e.d(paramAdRequestParcel.toString());
    paramAdRequestParcel = this.d;
    Runnable localRunnable = this.f;
    paramAdRequestParcel.a.postDelayed(localRunnable, paramLong);
  }
  
  public final void b()
  {
    this.b = true;
    if (this.c) {
      this.d.a(this.f);
    }
  }
  
  public final void c()
  {
    this.b = false;
    if (this.c)
    {
      this.c = false;
      a(this.a, this.e);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */