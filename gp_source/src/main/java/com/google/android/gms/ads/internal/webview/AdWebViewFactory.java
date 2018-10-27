package com.google.android.gms.ads.internal.webview;

import android.content.Context;
import com.google.android.gms.ads.internal.bm;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.bo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.x.f;
import com.google.android.gms.ads.internal.zxxz.aa;

@com.google.android.gms.ads.internal.q.a.a
public final class AdWebViewFactory
{
  public static i a(Context paramContext, au paramau, String paramString, boolean paramBoolean1, boolean paramBoolean2, aa paramaa, VersionInfoParcel paramVersionInfoParcel, l paraml, bm parambm, u paramu, com.google.android.gms.ads.internal.d.a parama)
  {
    n.a(paramContext);
    if (((Boolean)n.bR.a()).booleanValue()) {
      return f.a(paramContext, paramau, paramString, paramBoolean1, paramBoolean2, paramaa, paramVersionInfoParcel, paraml, parambm, paramu);
    }
    try
    {
      paramContext = (i)bo.a(new p(paramContext, paramau, paramString, paramBoolean1, paramBoolean2, paramaa, paramVersionInfoParcel, paraml, parambm, paramu, parama));
      return paramContext;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/AdWebViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */