package com.google.android.gms.ads.internal.x;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.common.util.h;

@a
class j
  extends WebView
{
  public j(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
    paramContext = getSettings();
    paramContext.setAllowFileAccess(false);
    paramContext.setSavePassword(false);
    paramContext.setSupportMultipleWindows(true);
    paramContext.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setMixedContentMode(2);
    }
    bt.A.g.a(getContext(), paramContext);
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
    try
    {
      getSettings().setJavaScriptEnabled(true);
      setLayerType(1, null);
      return;
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        e.c("Unable to enable Javascript.", paramContext);
      }
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      e.a("Ignore addJavascriptInterface due to low Android version.");
      return;
    }
    super.addJavascriptInterface(paramObject, paramString);
  }
  
  public void d(String paramString)
  {
    if ((h.b()) && (o.a(this)))
    {
      evaluateJavascript(paramString, null);
      return;
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String("javascript:");; paramString = "javascript:".concat(paramString))
    {
      loadUrl(paramString);
      return;
    }
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      super.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      bt.A.i.a(paramString, "CoreWebView.loadUrl");
      e.f("#007 Could not call remote method.", paramString);
      return;
    }
    catch (NoClassDefFoundError paramString)
    {
      for (;;) {}
    }
    catch (IncompatibleClassChangeError paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */