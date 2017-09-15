package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String wRN = null;
  private WebViewClient ooO;
  private WebView vqH;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.vqH = paramWebView;
    this.ooO = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.ooO.doUpdateVisitedHistory(this.vqH, paramString, paramBoolean);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.ooO.onFormResubmission(this.vqH, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    this.ooO.onLoadResource(this.vqH, paramString);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    if (wRN == null)
    {
      localObject = com.tencent.smtt.utils.r.cfp();
      if (localObject != null)
      {
        ((com.tencent.smtt.utils.r)localObject).mc(true);
        wRN = Boolean.toString(true);
      }
    }
    Object localObject = this.vqH;
    ((WebView)localObject).wUB += 1;
    this.ooO.onPageFinished(this.vqH, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      WebView.gD(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.ceM();
    if ((!t.wTW) && (this.vqH.getContext() != null) && (t.gu(this.vqH.getContext())))
    {
      t.wTW = true;
      new Thread(new Runnable()
      {
        public void run()
        {
          SystemWebViewClient.a(SystemWebViewClient.this).getContext();
          if (l.q(SystemWebViewClient.a(SystemWebViewClient.this).getContext(), false)) {
            l.fO(SystemWebViewClient.a(SystemWebViewClient.this).getContext());
          }
        }
      }).start();
    }
    if ((this.vqH.getContext() != null) && (!r.gr(this.vqH.getContext()).wTq))
    {
      r.gr(this.vqH.getContext()).wTq = true;
      r.gr(this.vqH.getContext()).ceu();
    }
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.ooO.onPageStarted(this.vqH, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, android.webkit.ClientCertRequest paramClientCertRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWebView = new ClientCertRequestImpl(paramClientCertRequest);
      this.ooO.onReceivedClientCertRequest(this.vqH, paramWebView);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.ooO.onReceivedError(this.vqH, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, final android.webkit.WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new WebResourceRequestImpl2(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = (android.webkit.WebResourceRequest)localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new com.tencent.smtt.export.external.interfaces.WebResourceError()
        {
          public CharSequence getDescription()
          {
            return paramWebResourceError.getDescription();
          }
          
          public int getErrorCode()
          {
            return paramWebResourceError.getErrorCode();
          }
        };
      }
      this.ooO.onReceivedError(this.vqH, paramWebView, paramWebResourceRequest);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, android.webkit.HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.ooO.onReceivedHttpAuthRequest(this.vqH, new HttpAuthHandlerImpl(paramHttpAuthHandler), paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    paramWebView = new WebResourceRequestImpl2(paramWebResourceRequest);
    paramWebResourceRequest = new WebResourceResponseImpl2(paramWebResourceResponse);
    this.ooO.onReceivedHttpError(this.vqH, paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT >= 12) {
      this.ooO.onReceivedLoginRequest(this.vqH, paramString1, paramString2, paramString3);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, android.webkit.SslErrorHandler paramSslErrorHandler, android.net.http.SslError paramSslError)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      this.ooO.onReceivedSslError(this.vqH, new SslErrorHandlerImpl(paramSslErrorHandler), new SslErrorImpl(paramSslError));
    }
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.ooO.onScaleChanged(this.vqH, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.ooO.onTooManyRedirects(this.vqH, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.ooO.onUnhandledKeyEvent(this.vqH, paramKeyEvent);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramWebView = null;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramWebView;
        if (paramWebResourceRequest == null) {
          return null;
        }
        paramWebView = new WebResourceRequestImpl(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
        paramWebView = this.ooO.shouldInterceptRequest(this.vqH, paramWebView);
        if (paramWebView == null) {
          return null;
        }
        paramWebResourceRequest = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
        paramWebResourceRequest.setResponseHeaders(paramWebView.getResponseHeaders());
        i = paramWebView.getStatusCode();
        str = paramWebView.getReasonPhrase();
        if (i != paramWebResourceRequest.getStatusCode()) {
          break;
        }
        paramWebView = paramWebResourceRequest;
      } while (str == null);
      paramWebView = paramWebResourceRequest;
    } while (str.equals(paramWebResourceRequest.getReasonPhrase()));
    paramWebResourceRequest.setStatusCodeAndReasonPhrase(i, str);
    return paramWebResourceRequest;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return null;
      paramWebView = this.ooO.shouldInterceptRequest(this.vqH, paramString);
    } while (paramWebView == null);
    return new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return this.ooO.shouldOverrideKeyEvent(this.vqH, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if ((paramString == null) || (this.vqH.showDebugView(paramString))) {}
    while (m.cfj().bE(this.vqH.getContext().getApplicationContext(), paramString)) {
      return true;
    }
    return this.ooO.shouldOverrideUrlLoading(this.vqH, paramString);
  }
  
  private static class ClientCertRequestImpl
    extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
  {
    private android.webkit.ClientCertRequest mClientCertRequest;
    
    public ClientCertRequestImpl(android.webkit.ClientCertRequest paramClientCertRequest)
    {
      this.mClientCertRequest = paramClientCertRequest;
    }
    
    public void cancel()
    {
      this.mClientCertRequest.cancel();
    }
    
    public String getHost()
    {
      return this.mClientCertRequest.getHost();
    }
    
    public String[] getKeyTypes()
    {
      return this.mClientCertRequest.getKeyTypes();
    }
    
    public int getPort()
    {
      return this.mClientCertRequest.getPort();
    }
    
    public Principal[] getPrincipals()
    {
      return this.mClientCertRequest.getPrincipals();
    }
    
    public void ignore()
    {
      this.mClientCertRequest.ignore();
    }
    
    public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
    {
      this.mClientCertRequest.proceed(paramPrivateKey, paramArrayOfX509Certificate);
    }
  }
  
  private static class HttpAuthHandlerImpl
    implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
  {
    private android.webkit.HttpAuthHandler mHandler;
    
    HttpAuthHandlerImpl(android.webkit.HttpAuthHandler paramHttpAuthHandler)
    {
      this.mHandler = paramHttpAuthHandler;
    }
    
    public void cancel()
    {
      this.mHandler.cancel();
    }
    
    public void proceed(String paramString1, String paramString2)
    {
      this.mHandler.proceed(paramString1, paramString2);
    }
    
    public boolean useHttpAuthUsernamePassword()
    {
      return this.mHandler.useHttpAuthUsernamePassword();
    }
  }
  
  private static class SslErrorHandlerImpl
    implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
  {
    android.webkit.SslErrorHandler mSslErrorHandler;
    
    SslErrorHandlerImpl(android.webkit.SslErrorHandler paramSslErrorHandler)
    {
      this.mSslErrorHandler = paramSslErrorHandler;
    }
    
    public void cancel()
    {
      this.mSslErrorHandler.cancel();
    }
    
    public void proceed()
    {
      this.mSslErrorHandler.proceed();
    }
  }
  
  private static class SslErrorImpl
    implements com.tencent.smtt.export.external.interfaces.SslError
  {
    android.net.http.SslError mSslError;
    
    SslErrorImpl(android.net.http.SslError paramSslError)
    {
      this.mSslError = paramSslError;
    }
    
    public boolean addError(int paramInt)
    {
      return this.mSslError.addError(paramInt);
    }
    
    public SslCertificate getCertificate()
    {
      return this.mSslError.getCertificate();
    }
    
    public int getPrimaryError()
    {
      return this.mSslError.getPrimaryError();
    }
    
    public boolean hasError(int paramInt)
    {
      return this.mSslError.hasError(paramInt);
    }
  }
  
  private class WebResourceRequestImpl
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    private boolean hasUserGesture;
    private boolean isMainFrame;
    private String method;
    private Map<String, String> requestHeaders;
    private String url;
    
    public WebResourceRequestImpl(boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
    {
      this.url = paramBoolean1;
      this.isMainFrame = paramBoolean2;
      this.hasUserGesture = paramString;
      this.method = paramMap;
      Map localMap;
      this.requestHeaders = localMap;
    }
    
    public String getMethod()
    {
      return this.method;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.requestHeaders;
    }
    
    public Uri getUrl()
    {
      return Uri.parse(this.url);
    }
    
    public boolean hasGesture()
    {
      return this.hasUserGesture;
    }
    
    public boolean isForMainFrame()
    {
      return this.isMainFrame;
    }
  }
  
  private static class WebResourceRequestImpl2
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    android.webkit.WebResourceRequest mWebResourceRequest;
    
    WebResourceRequestImpl2(android.webkit.WebResourceRequest paramWebResourceRequest)
    {
      this.mWebResourceRequest = paramWebResourceRequest;
    }
    
    public String getMethod()
    {
      return this.mWebResourceRequest.getMethod();
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.mWebResourceRequest.getRequestHeaders();
    }
    
    public Uri getUrl()
    {
      return this.mWebResourceRequest.getUrl();
    }
    
    public boolean hasGesture()
    {
      return this.mWebResourceRequest.hasGesture();
    }
    
    public boolean isForMainFrame()
    {
      return this.mWebResourceRequest.isForMainFrame();
    }
  }
  
  private static class WebResourceResponseImpl2
    extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
  {
    android.webkit.WebResourceResponse mWebResourceResponse;
    
    public WebResourceResponseImpl2(android.webkit.WebResourceResponse paramWebResourceResponse)
    {
      this.mWebResourceResponse = paramWebResourceResponse;
    }
    
    public InputStream getData()
    {
      return this.mWebResourceResponse.getData();
    }
    
    public String getEncoding()
    {
      return this.mWebResourceResponse.getEncoding();
    }
    
    public String getMimeType()
    {
      return this.mWebResourceResponse.getMimeType();
    }
    
    public String getReasonPhrase()
    {
      return this.mWebResourceResponse.getReasonPhrase();
    }
    
    public Map<String, String> getResponseHeaders()
    {
      return this.mWebResourceResponse.getResponseHeaders();
    }
    
    public int getStatusCode()
    {
      return this.mWebResourceResponse.getStatusCode();
    }
    
    public void setData(InputStream paramInputStream)
    {
      this.mWebResourceResponse.setData(paramInputStream);
    }
    
    public void setEncoding(String paramString)
    {
      this.mWebResourceResponse.setEncoding(paramString);
    }
    
    public void setMimeType(String paramString)
    {
      this.mWebResourceResponse.setMimeType(paramString);
    }
    
    public void setResponseHeaders(Map<String, String> paramMap)
    {
      this.mWebResourceResponse.setResponseHeaders(paramMap);
    }
    
    public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
    {
      this.mWebResourceResponse.setStatusCodeAndReasonPhrase(paramInt, paramString);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/SystemWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */