package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.q.a.a;
import java.lang.ref.WeakReference;

@a
public final class w
  extends ad
{
  private final WeakReference a;
  
  public w(m paramm)
  {
    this.a = new WeakReference(paramm);
  }
  
  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    m localm = (m)this.a.get();
    if (localm != null) {
      localm.a(paramAdResponseParcel);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */