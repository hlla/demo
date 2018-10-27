package com.google.android.gms.ads.internal.w;

import android.os.Handler;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class af
  implements Runnable
{
  private n a;
  private boolean b = false;
  
  af(n paramn)
  {
    this.a = paramn;
  }
  
  private final void c()
  {
    com.google.android.gms.ads.internal.util.n.a.removeCallbacks(this);
    com.google.android.gms.ads.internal.util.n.a.postDelayed(this, 250L);
  }
  
  public final void a()
  {
    this.b = true;
    this.a.j();
  }
  
  public final void b()
  {
    this.b = false;
    c();
  }
  
  public final void run()
  {
    if (!this.b)
    {
      this.a.j();
      c();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */