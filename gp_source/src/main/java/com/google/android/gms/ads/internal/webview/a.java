package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.v;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(11)
public final class a
  extends WebChromeClient
{
  private final i a;
  
  public a(i parami)
  {
    this.a = parami;
  }
  
  private static Context a(WebView paramWebView)
  {
    if (!(paramWebView instanceof i)) {
      paramWebView = paramWebView.getContext();
    }
    i locali;
    Activity localActivity;
    do
    {
      return paramWebView;
      locali = (i)paramWebView;
      localActivity = locali.getActivityContext();
      paramWebView = localActivity;
    } while (localActivity != null);
    return locali.getContext();
  }
  
  private final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    Object localObject;
    do
    {
      do
      {
        try
        {
          localObject = this.a;
          if (localObject == null)
          {
            paramString1 = new AlertDialog.Builder(paramContext);
            paramString1.setTitle(paramString2);
            if (!paramBoolean)
            {
              paramString1.setMessage(paramString3).setPositiveButton(17039370, new d(paramJsResult)).setNegativeButton(17039360, new c(paramJsResult)).setOnCancelListener(new b(paramJsResult)).create().show();
              return true;
            }
            paramString2 = new LinearLayout(paramContext);
            paramString2.setOrientation(1);
            paramJsResult = new TextView(paramContext);
            paramJsResult.setText(paramString3);
            paramContext = new EditText(paramContext);
            paramContext.setText(paramString4);
            paramString2.addView(paramJsResult);
            paramString2.addView(paramContext);
            paramString1.setView(paramString2).setPositiveButton(17039370, new g(paramJsPromptResult, paramContext)).setNegativeButton(17039360, new f(paramJsPromptResult)).setOnCancelListener(new e(paramJsPromptResult)).create().show();
            return true;
          }
        }
        catch (WindowManager.BadTokenException paramContext)
        {
          com.google.android.gms.ads.internal.util.e.e("Fail to display Dialog.", paramContext);
          return true;
        }
      } while ((((i)localObject).getAdWebViewClient() == null) || (this.a.getAdWebViewClient().a() == null));
      localObject = this.a.getAdWebViewClient().a();
    } while ((localObject == null) || (((v)localObject).a()));
    paramContext = new StringBuilder(String.valueOf(paramString1).length() + 11 + String.valueOf(paramString3).length());
    paramContext.append("window.");
    paramContext.append(paramString1);
    paramContext.append("('");
    paramContext.append(paramString3);
    paramContext.append("')");
    ((v)localObject).a(paramContext.toString());
    return false;
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof i))
    {
      com.google.android.gms.ads.internal.util.e.e("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    paramWebView = ((i)paramWebView).getAdOverlay();
    if (paramWebView == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    paramWebView.a();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str1 = paramConsoleMessage.message();
    String str2 = paramConsoleMessage.sourceId();
    int i = paramConsoleMessage.lineNumber();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 19 + String.valueOf(str2).length());
    localStringBuilder.append("JS: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" (");
    localStringBuilder.append(str2);
    localStringBuilder.append(":");
    localStringBuilder.append(i);
    localStringBuilder.append(")");
    str1 = localStringBuilder.toString();
    if (str1.contains("Application Cache")) {
      return super.onConsoleMessage(paramConsoleMessage);
    }
    switch (h.a[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      com.google.android.gms.ads.internal.util.e.d(str1);
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      com.google.android.gms.ads.internal.util.e.b(str1);
      continue;
      com.google.android.gms.ads.internal.util.e.d(str1);
      continue;
      com.google.android.gms.ads.internal.util.e.e(str1);
      continue;
      com.google.android.gms.ads.internal.util.e.c(str1);
    }
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    paramWebView = new WebView(paramWebView.getContext());
    if (this.a.getWebViewClientForNewWebView() != null) {
      paramWebView.setWebViewClient(this.a.getWebViewClientForNewWebView());
    }
    localWebViewTransport.setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong3 = 5242880L - paramLong3;
    if (paramLong3 > 0L)
    {
      if (paramLong1 != 0L) {
        if (paramLong2 == 0L) {
          paramLong1 = Math.min(Math.min(131072L, paramLong3) + paramLong1, 1048576L);
        }
      }
      for (;;)
      {
        paramQuotaUpdater.updateQuota(paramLong1);
        return;
        if (paramLong2 <= Math.min(1048576L - paramLong1, paramLong3))
        {
          paramLong1 += paramLong2;
        }
        else
        {
          continue;
          if (paramLong2 <= paramLong3)
          {
            if (paramLong2 <= 1048576L) {
              paramLong1 = paramLong2;
            } else {
              paramLong1 = 0L;
            }
          }
          else {
            paramLong1 = 0L;
          }
        }
      }
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    boolean bool;
    if (paramCallback != null)
    {
      n localn = bt.A.e;
      if (n.a(this.a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
        break label73;
      }
      localn = bt.A.e;
      if (n.a(this.a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
        break label68;
      }
      bool = false;
    }
    for (;;)
    {
      paramCallback.invoke(paramString, bool, true);
      return;
      label68:
      bool = true;
      continue;
      label73:
      bool = true;
    }
  }
  
  public final void onHideCustomView()
  {
    AdOverlay localAdOverlay = this.a.getAdOverlay();
    if (localAdOverlay == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not get ad overlay when hiding custom view.");
      return;
    }
    localAdOverlay.b();
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(a(paramWebView), "alert", paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(a(paramWebView), "onBeforeUnload", paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(a(paramWebView), "confirm", paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(a(paramWebView), "prompt", paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  @TargetApi(21)
  public final void onPermissionRequest(PermissionRequest paramPermissionRequest) {}
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong1 = 131072L + paramLong1;
    if (5242880L - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  @Deprecated
  public final void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AdOverlay localAdOverlay = this.a.getAdOverlay();
    if (localAdOverlay == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localAdOverlay.g = new FrameLayout(localAdOverlay.a);
    localAdOverlay.g.setBackgroundColor(-16777216);
    localAdOverlay.g.addView(paramView, -1, -1);
    localAdOverlay.a.setContentView(localAdOverlay.g);
    localAdOverlay.e = true;
    localAdOverlay.f = paramCustomViewCallback;
    localAdOverlay.h = true;
    localAdOverlay.a(paramInt);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, -1, paramCustomViewCallback);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */