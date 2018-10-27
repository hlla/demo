package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.webview.j;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(8)
public class v
{
  public static boolean a(i parami)
  {
    if (parami != null)
    {
      parami.onPause();
      return true;
    }
    return false;
  }
  
  public static boolean b(i parami)
  {
    if (parami != null)
    {
      parami.onResume();
      return true;
    }
    return false;
  }
  
  public static boolean e()
  {
    int i = Process.myUid();
    return (i == 0) || (i == 1000);
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public WebResourceResponse a(String paramString1, String paramString2, int paramInt, String paramString3, Map paramMap, InputStream paramInputStream)
  {
    return new WebResourceResponse(paramString1, paramString2, paramInputStream);
  }
  
  public j a(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean)
  {
    return new j(parami, parama, paramBoolean);
  }
  
  public String a(Context paramContext)
  {
    return "";
  }
  
  public String a(SslError paramSslError)
  {
    return "";
  }
  
  public Set a(Uri paramUri)
  {
    if (paramUri.isOpaque()) {
      return Collections.emptySet();
    }
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int k = 0;
    for (;;)
    {
      int j = paramUri.indexOf('&', k);
      int i = j;
      if (j == -1) {
        i = paramUri.length();
      }
      int m = paramUri.indexOf('=', k);
      if (m > i) {
        j = i;
      }
      for (;;)
      {
        localLinkedHashSet.add(Uri.decode(paramUri.substring(k, j)));
        k = i + 1;
        if (k < paramUri.length()) {
          break;
        }
        return Collections.unmodifiableSet(localLinkedHashSet);
        j = m;
        if (m == -1) {
          j = i;
        }
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean a(DownloadManager.Request paramRequest)
  {
    return false;
  }
  
  public boolean a(Context paramContext, WebSettings paramWebSettings)
  {
    return false;
  }
  
  public boolean a(View paramView)
  {
    return (paramView.getWindowToken() != null) || (paramView.getWindowVisibility() != 8);
  }
  
  public boolean a(Window paramWindow)
  {
    return false;
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(Context paramContext) {}
  
  public boolean b(View paramView)
  {
    return false;
  }
  
  public int c()
  {
    return 5;
  }
  
  public CookieManager c(Context paramContext)
  {
    CookieManager localCookieManager = null;
    if (!e()) {}
    try
    {
      CookieSyncManager.createInstance(paramContext);
      localCookieManager = CookieManager.getInstance();
      return localCookieManager;
    }
    finally
    {
      e.c("Failed to obtain CookieManager.", paramContext);
      bt.A.i.a(paramContext, "ApiLevelUtil.getCookieManager");
    }
    return null;
  }
  
  public boolean c(View paramView)
  {
    return false;
  }
  
  public ViewGroup.LayoutParams d()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */