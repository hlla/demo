package com.google.android.gms.ads.internal.w.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.w.ad;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class h
  extends com.google.android.gms.ads.internal.util.a
{
  public final k a;
  public final ad b;
  private final String c;
  
  h(ad paramad, k paramk, String paramString)
  {
    this.b = paramad;
    this.a = paramk;
    this.c = paramString;
    bt.A.D.a.add(this);
  }
  
  public final void a()
  {
    try
    {
      this.a.a(this.c);
      return;
    }
    finally
    {
      n.a.post(new i(this));
    }
  }
  
  public final void be_()
  {
    this.a.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */