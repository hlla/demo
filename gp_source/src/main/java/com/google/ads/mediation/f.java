package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.i;
import com.google.android.gms.ads.formats.r;
import com.google.android.gms.ads.formats.t;
import com.google.android.gms.ads.mediation.q;
import java.util.WeakHashMap;

final class f
  extends q
{
  private final r o;
  
  public f(r paramr)
  {
    this.o = paramr;
    this.e = paramr.a();
    this.g = paramr.b();
    this.b = paramr.c();
    this.f = paramr.d();
    this.c = paramr.e();
    this.a = paramr.f();
    this.l = paramr.g();
    this.m = paramr.h();
    this.k = paramr.i();
    this.h = paramr.l();
    this.j = true;
    this.i = true;
    this.n = paramr.j();
  }
  
  public final void a(View paramView)
  {
    if ((paramView instanceof t)) {
      ((t)paramView).setNativeAd(this.o);
    }
    while ((i)i.a.get(paramView) == null) {
      return;
    }
    i.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */