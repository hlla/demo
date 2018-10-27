package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.h;
import com.google.android.gms.ads.formats.i;
import com.google.android.gms.ads.formats.j;
import com.google.android.gms.ads.mediation.l;
import java.util.WeakHashMap;

final class d
  extends l
{
  private final j m;
  
  public d(j paramj)
  {
    this.m = paramj;
    this.g = paramj.b().toString();
    this.i = paramj.c();
    this.e = paramj.d().toString();
    this.h = paramj.e();
    this.f = paramj.f().toString();
    if (paramj.g() != null) {
      this.k = paramj.g().doubleValue();
    }
    if (paramj.h() != null) {
      this.l = paramj.h().toString();
    }
    if (paramj.i() != null) {
      this.j = paramj.i().toString();
    }
    this.c = true;
    this.b = true;
    this.d = paramj.j();
  }
  
  public final void a(View paramView)
  {
    if ((paramView instanceof h)) {
      ((h)paramView).setNativeAd(this.m);
    }
    if ((i)i.a.get(paramView) != null) {
      i.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */