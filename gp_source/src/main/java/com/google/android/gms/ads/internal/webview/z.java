package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.zxxz.v;

@a
@TargetApi(17)
public final class z
{
  public final ac a;
  private final ad b;
  
  private z(ad paramad, ac paramac)
  {
    this.a = paramac;
    this.b = paramad;
  }
  
  public static z a(i parami)
  {
    return new z(parami, new aa(parami));
  }
  
  @JavascriptInterface
  public final String getClickSignals(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      e.a("Click string is empty, not proceeding.");
      return "";
    }
    Object localObject = ((al)this.b).getSpamSignalsUtil();
    if (localObject == null)
    {
      e.a("Signal utils is empty, ignoring.");
      return "";
    }
    localObject = ((com.google.android.gms.ads.internal.zxxz.aa)localObject).e;
    if (localObject == null)
    {
      e.a("Signals object is empty, ignoring.");
      return "";
    }
    if (this.b.getContext() == null)
    {
      e.a("Context is null, ignoring.");
      return "";
    }
    return ((v)localObject).a(this.b.getContext(), paramString, ((an)this.b).getView(), this.b.getActivityContext());
  }
  
  @JavascriptInterface
  public final void notify(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      e.e("URL is empty, ignoring message");
      return;
    }
    n.a.post(new ab(this, paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */