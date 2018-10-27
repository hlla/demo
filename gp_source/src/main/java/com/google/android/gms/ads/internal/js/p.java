package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.util.Map;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class p
  implements h, n
{
  public final com.google.android.gms.ads.internal.webview.i a;
  
  public p(Context paramContext, VersionInfoParcel paramVersionInfoParcel, aa paramaa)
  {
    AdWebViewFactory localAdWebViewFactory = bt.A.f;
    this.a = AdWebViewFactory.a(paramContext, au.a(), "", false, false, paramaa, paramVersionInfoParcel, null, null, null, com.google.android.gms.ads.internal.d.a.a());
    this.a.getView().setWillNotDraw(true);
  }
  
  private static void a(Runnable paramRunnable)
  {
    com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
    if (com.google.android.gms.ads.internal.util.client.a.b())
    {
      paramRunnable.run();
      return;
    }
    com.google.android.gms.ads.internal.util.n.a.post(paramRunnable);
  }
  
  public final void a()
  {
    this.a.destroy();
  }
  
  public final void a(o paramo)
  {
    ao localao = this.a.getAdWebViewClient();
    paramo.getClass();
    localao.a(new s(paramo));
  }
  
  public final void a(String paramString)
  {
    a(new t(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] { paramString })));
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    this.a.a(paramString, new w(this, paramu));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    i.a(this, paramString1, paramString2);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    i.a(this, paramString, paramMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    i.b(this, paramString, paramJSONObject);
  }
  
  public final av b()
  {
    return new aw(this);
  }
  
  public final void b(String paramString)
  {
    a(new u(this, paramString));
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    this.a.a(paramString, new r(paramu));
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    i.a(this, paramString, paramJSONObject);
  }
  
  public final void c(String paramString)
  {
    a(new v(this, paramString));
  }
  
  public final void d(String paramString)
  {
    a(new q(this, paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */