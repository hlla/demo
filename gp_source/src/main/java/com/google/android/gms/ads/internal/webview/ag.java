package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.safebrowsing.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(11)
public class ag
  extends j
{
  public ag(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean)
  {
    super(parami, parama, paramBoolean);
  }
  
  protected final WebResourceResponse a(WebView paramWebView, String paramString, Map paramMap)
  {
    if (!(paramWebView instanceof i))
    {
      e.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
      return null;
    }
    i locali = (i)paramWebView;
    paramWebView = this.l;
    if (paramWebView != null) {
      paramWebView.a(paramString, paramMap, 1);
    }
    if ("mraid.js".equalsIgnoreCase(new File(paramString).getName()))
    {
      if (locali.getAdWebViewClient() != null) {
        locali.getAdWebViewClient().l();
      }
      if (locali.getAdSize().e()) {
        paramWebView = (String)com.google.android.gms.ads.internal.f.n.aX.a();
      }
      for (;;)
      {
        paramString = bt.A.e;
        return com.google.android.gms.ads.internal.util.n.c(locali.getContext(), locali.getVersionInfo().a, paramWebView);
        if (locali.f()) {
          paramWebView = (String)com.google.android.gms.ads.internal.f.n.aW.a();
        } else {
          paramWebView = (String)com.google.android.gms.ads.internal.f.n.aV.a();
        }
      }
    }
    paramWebView = paramMap;
    if (paramMap == null) {
      paramWebView = Collections.emptyMap();
    }
    return super.a(paramString, paramWebView);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */