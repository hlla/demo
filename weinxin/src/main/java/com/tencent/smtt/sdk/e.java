package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;

final class e
  extends X5ProxyWebChromeClient
{
  private WebView vqH;
  private WebChromeClient wRJ;
  
  public e(IX5WebChromeClient paramIX5WebChromeClient, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramIX5WebChromeClient);
    this.vqH = paramWebView;
    this.wRJ = paramWebChromeClient;
  }
  
  public final Bitmap getDefaultVideoPoster()
  {
    return this.wRJ.getDefaultVideoPoster();
  }
  
  public final void getVisitedHistory(ValueCallback<String[]> paramValueCallback) {}
  
  public final void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onCloseWindow(this.vqH);
  }
  
  public final void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.wRJ.onConsoleMessage(paramConsoleMessage);
  }
  
  public final boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    paramIX5WebViewBase = this.vqH;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public final void run()
      {
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.wUy);
        }
        paramMessage.sendToTarget();
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    return this.wRJ.onCreateWindow(this.vqH, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    this.wRJ.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
  }
  
  public final void onGeolocationPermissionsHidePrompt()
  {
    this.wRJ.onGeolocationPermissionsHidePrompt();
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.wRJ.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public final void onHideCustomView()
  {
    this.wRJ.onHideCustomView();
  }
  
  public final boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.wRJ.onJsAlert(this.vqH, paramString1, paramString2, paramJsResult);
  }
  
  public final boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.wRJ.onJsBeforeUnload(this.vqH, paramString1, paramString2, paramJsResult);
  }
  
  public final boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.wRJ.onJsConfirm(this.vqH, paramString1, paramString2, paramJsResult);
  }
  
  public final boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    return this.wRJ.onJsPrompt(this.vqH, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public final boolean onJsTimeout()
  {
    return this.wRJ.onJsTimeout();
  }
  
  public final void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onProgressChanged(this.vqH, paramInt);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    this.wRJ.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
  }
  
  public final void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onReceivedIcon(this.vqH, paramBitmap);
  }
  
  public final void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onReceivedTitle(this.vqH, paramString);
  }
  
  public final void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onReceivedTouchIconUrl(this.vqH, paramString, paramBoolean);
  }
  
  public final void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    this.vqH.wUy = paramIX5WebViewBase;
    this.wRJ.onRequestFocus(this.vqH);
  }
  
  public final void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.wRJ.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public final void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.wRJ.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public final boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    paramValueCallback = new y() {};
    paramFileChooserParams = new WebChromeClient.a()
    {
      public final Intent createIntent()
      {
        return paramFileChooserParams.createIntent();
      }
      
      public final String[] getAcceptTypes()
      {
        return paramFileChooserParams.getAcceptTypes();
      }
      
      public final String getFilenameHint()
      {
        return paramFileChooserParams.getFilenameHint();
      }
      
      public final int getMode()
      {
        return paramFileChooserParams.getMode();
      }
      
      public final CharSequence getTitle()
      {
        return paramFileChooserParams.getTitle();
      }
      
      public final boolean isCaptureEnabled()
      {
        return paramFileChooserParams.isCaptureEnabled();
      }
    };
    this.vqH.wUy = paramIX5WebViewBase;
    return this.wRJ.onShowFileChooser(this.vqH, paramValueCallback, paramFileChooserParams);
  }
  
  public final void openFileChooser(final ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.wRJ.openFileChooser(new y() {}, paramString1, paramString2);
  }
  
  final class a
    implements aa.a
  {
    QuotaUpdater wRM;
    
    a(QuotaUpdater paramQuotaUpdater)
    {
      this.wRM = paramQuotaUpdater;
    }
    
    public final void updateQuota(long paramLong)
    {
      this.wRM.updateQuota(paramLong);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */