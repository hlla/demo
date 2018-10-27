package com.google.android.gms.ads.internal.w;

import android.content.Context;

@com.google.android.gms.ads.internal.q.a.a
public final class u
  extends m
{
  public final l a(Context paramContext, ad paramad, int paramInt, boolean paramBoolean, com.google.android.gms.ads.internal.g.l paraml, ac paramac)
  {
    if (a(paramContext)) {
      return new a(paramContext, paramBoolean, a(paramad), new ae(paramContext, paramad.getVersionInfo(), paramad.getRequestId(), paraml, paramad.getAdWebViewCreatedLabel()));
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */