package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.h;
import com.google.android.gms.ads.formats.i;
import com.google.android.gms.ads.formats.l;
import com.google.android.gms.ads.mediation.m;
import java.util.WeakHashMap;

final class e
  extends m
{
  private final l k;
  
  public e(l paraml)
  {
    this.k = paraml;
    this.h = paraml.b().toString();
    this.i = paraml.c();
    this.f = paraml.d().toString();
    if (paraml.e() != null) {
      this.j = paraml.e();
    }
    this.g = paraml.f().toString();
    this.e = paraml.g().toString();
    this.c = true;
    this.b = true;
    this.d = paraml.h();
  }
  
  public final void a(View paramView)
  {
    if ((paramView instanceof h)) {
      ((h)paramView).setNativeAd(this.k);
    }
    if ((i)i.a.get(paramView) != null) {
      i.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */