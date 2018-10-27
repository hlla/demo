package com.google.android.gms.ads.internal.x;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;

@a
public class k
  extends WebViewClient
{
  private static final String[] a = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] b = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  public p s;
  
  public void a(l paraml) {}
  
  public boolean b(l paraml)
  {
    return false;
  }
  
  public void bm_() {}
  
  public WebResourceResponse c(l paraml)
  {
    return null;
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    if (paramString != null)
    {
      paramWebView = String.valueOf(paramString);
      if (paramWebView.length() != 0) {
        break label43;
      }
    }
    label43:
    for (paramWebView = new String("Loading resource: ");; paramWebView = "Loading resource: ".concat(paramWebView))
    {
      e.a(paramWebView);
      a(new l(paramString));
      return;
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (paramString != null)
    {
      new l(paramString);
      paramWebView = this.s;
      if (paramWebView != null) {
        paramWebView.o();
      }
    }
    else
    {
      return;
    }
    bm_();
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 >= a.length)) {}
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (paramSslError != null)
    {
      int i = paramSslError.getPrimaryError();
      if ((i >= 0) && (i >= b.length)) {}
      paramSslError.getUrl();
    }
  }
  
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    if ((paramWebView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramWebView.getParent()).removeView(paramWebView);
    }
    paramWebView.destroy();
    return true;
  }
  
  @TargetApi(24)
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {
      return c(new l(paramWebResourceRequest));
    }
    return null;
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (paramString != null) {
      return c(new l(paramString));
    }
    return null;
  }
  
  public final boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  @TargetApi(24)
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {
      return b(new l(paramWebResourceRequest));
    }
    return false;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString != null) {
      return b(new l(paramString));
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */