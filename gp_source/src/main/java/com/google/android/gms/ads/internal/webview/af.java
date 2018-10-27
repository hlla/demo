package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(11)
public final class af
  extends ag
{
  public af(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean)
  {
    super(parami, parama, paramBoolean);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString, null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */