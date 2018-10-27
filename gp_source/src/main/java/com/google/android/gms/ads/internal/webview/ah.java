package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(21)
public final class ah
  extends ag
{
  public ah(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean)
  {
    super(parami, parama, paramBoolean);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {
      return a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getRequestHeaders());
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */