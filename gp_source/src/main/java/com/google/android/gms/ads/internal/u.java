package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.safebrowsing.g;
import com.google.android.gms.ads.internal.safebrowsing.l;
import com.google.android.gms.ads.internal.w.b.b;
import com.google.android.gms.ads.internal.w.b.s;
import com.google.android.gms.ads.internal.w.m;

@a
public final class u
{
  public final m a;
  public final com.google.android.gms.ads.internal.d.h b;
  public final l c;
  public final s d;
  
  public u(s params, m paramm, l paraml, com.google.android.gms.ads.internal.d.h paramh)
  {
    this.d = params;
    this.a = paramm;
    this.c = paraml;
    this.b = paramh;
  }
  
  public static u a(Context paramContext)
  {
    return new u(new b(), new com.google.android.gms.ads.internal.w.u(), new g(new com.google.android.gms.ads.internal.safebrowsing.h()), new com.google.android.gms.ads.internal.d.h(paramContext));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */