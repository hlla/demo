package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;

final class f
  extends X5ProxyWebViewClient
{
  private static String wRN = null;
  private WebViewClient ooO;
  public WebView vqH;
  
  public f(IX5WebViewClient paramIX5WebViewClient, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    super(paramIX5WebViewClient);
    this.vqH = paramWebView;
    this.ooO = paramWebViewClient;
    this.ooO.wUS = this;
  }
  
  public final void countPVContentCacheCallBack(String paramString)
  {
    paramString = this.vqH;
    paramString.wUB += 1;
  }
  
  public final void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.doUpdateVisitedHistory(this.vqH, paramString, paramBoolean);
  }
  
  public final void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onDetectedBlankScreen(paramString, paramInt);
  }
  
  public final void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onFormResubmission(this.vqH, paramMessage1, paramMessage2);
  }
  
  public final void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onLoadResource(this.vqH, paramString);
  }
  
  public final void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    if (wRN == null)
    {
      localObject = com.tencent.smtt.utils.r.cfp();
      if (localObject != null)
      {
        ((com.tencent.smtt.utils.r)localObject).mc(false);
        wRN = Boolean.toString(false);
      }
    }
    this.vqH.wUy = paramIX5WebViewBase;
    Object localObject = this.vqH;
    ((WebView)localObject).wUB += 1;
    this.ooO.onPageFinished(this.vqH, paramString);
    if ("com.qzone".equals(paramIX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
      WebView.gD(paramIX5WebViewBase.getView().getContext());
    }
    TbsLog.app_extra("SmttWebViewClient", paramIX5WebViewBase.getView().getContext());
    try
    {
      super.onPageFinished(paramIX5WebViewBase, paramInt1, paramInt2, paramString);
      WebView.ceM();
      if ((!t.wTW) && (this.vqH.getContext() != null) && (t.gu(this.vqH.getContext())))
      {
        t.wTW = true;
        new Thread(new Runnable()
        {
          public final void run()
          {
            f.this.vqH.getContext();
            if (l.q(f.this.vqH.getContext(), false)) {
              l.fO(f.this.vqH.getContext());
            }
          }
        }).start();
      }
      if ((this.vqH.getContext() != null) && (!r.gr(this.vqH.getContext()).wTq))
      {
        r.gr(this.vqH.getContext()).wTq = true;
        r.gr(this.vqH.getContext()).ceu();
      }
      return;
    }
    catch (Exception paramIX5WebViewBase)
    {
      for (;;) {}
    }
  }
  
  public final void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    onPageFinished(paramIX5WebViewBase, 0, 0, paramString);
  }
  
  public final void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onPageStarted(this.vqH, paramString, paramBitmap);
  }
  
  public final void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    onPageStarted(paramIX5WebViewBase, 0, 0, paramString, paramBitmap);
  }
  
  public final void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedClientCertRequest(this.vqH, paramClientCertRequest);
  }
  
  public final void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    int i = paramInt;
    if (paramInt < -15)
    {
      if (paramInt == -17) {
        i = -1;
      }
    }
    else
    {
      this.vqH.wUy = paramIX5WebViewBase;
      this.ooO.onReceivedError(this.vqH, i, paramString1, paramString2);
    }
  }
  
  public final void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedError(this.vqH, paramWebResourceRequest, paramWebResourceError);
  }
  
  public final void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedHttpAuthRequest(this.vqH, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public final void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedHttpError(this.vqH, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public final void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedLoginRequest(this.vqH, paramString1, paramString2, paramString3);
  }
  
  public final void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onReceivedSslError(this.vqH, paramSslErrorHandler, paramSslError);
  }
  
  public final void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onScaleChanged(this.vqH, paramFloat1, paramFloat2);
  }
  
  public final void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onTooManyRedirects(this.vqH, paramMessage1, paramMessage2);
  }
  
  public final void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.ooO.onUnhandledKeyEvent(this.vqH, paramKeyEvent);
  }
  
  public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.ooO.shouldInterceptRequest(this.vqH, paramWebResourceRequest);
  }
  
  public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.ooO.shouldInterceptRequest(this.vqH, paramWebResourceRequest, paramBundle);
  }
  
  public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.ooO.shouldInterceptRequest(this.vqH, paramString);
  }
  
  public final boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.ooO.shouldOverrideKeyEvent(this.vqH, paramKeyEvent);
  }
  
  public final boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if ((paramString == null) || (this.vqH.showDebugView(paramString))) {}
    boolean bool;
    for (;;)
    {
      return true;
      this.vqH.wUy = paramIX5WebViewBase;
      if (!m.cfj().bE(this.vqH.getContext().getApplicationContext(), paramString))
      {
        bool = this.ooO.shouldOverrideUrlLoading(this.vqH, paramString);
        if (!bool)
        {
          if (paramString.startsWith("wtai://wp/mc;"))
          {
            paramIX5WebViewBase = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring(13)));
            this.vqH.getContext().startActivity(paramIX5WebViewBase);
            return true;
          }
          if (paramString.startsWith("tel:"))
          {
            paramIX5WebViewBase = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
            paramIX5WebViewBase.addFlags(268435456);
            try
            {
              if (this.vqH.getContext() != null)
              {
                this.vqH.getContext().startActivity(paramIX5WebViewBase);
                return true;
              }
            }
            catch (Exception paramIX5WebViewBase)
            {
              return true;
            }
          }
        }
      }
    }
    return bool;
  }
  
  public final void v(String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(this.vqH.wUy, 0, 0, paramString, paramBitmap);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */