package com.google.android.gms.ads.internal.w.b;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.w.ad;
import java.lang.ref.WeakReference;

@a
public final class u
  extends k
{
  public u(ad paramad)
  {
    super(paramad);
  }
  
  public final void a() {}
  
  public final boolean a(String paramString)
  {
    ad localad = (ad)this.c.get();
    if (localad != null) {
      localad.a(b(paramString), this);
    }
    e.e("VideoStreamNoopCache is doing nothing.");
    a(paramString, b(paramString), "noop", "Noop cache is a noop.");
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */