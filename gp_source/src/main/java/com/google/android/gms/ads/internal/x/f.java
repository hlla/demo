package com.google.android.gms.ads.internal.x;

import android.content.Context;
import com.google.android.gms.ads.internal.bm;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.bo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.zxxz.aa;

@a
public final class f
{
  public static i a(Context paramContext, au paramau, String paramString, boolean paramBoolean1, boolean paramBoolean2, aa paramaa, VersionInfoParcel paramVersionInfoParcel, l paraml, bm parambm, u paramu)
  {
    try
    {
      paramContext = (i)bo.a(new g(paramContext, paramau, paramString, paramBoolean1, paramBoolean2, paramaa, paramVersionInfoParcel, paraml, parambm, paramu));
      return paramContext;
    }
    finally
    {
      bt.A.i.a(paramContext, "AdWebViewFactory.newAdWebView2");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */