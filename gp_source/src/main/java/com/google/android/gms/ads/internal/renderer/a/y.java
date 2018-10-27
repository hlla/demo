package com.google.android.gms.ads.internal.renderer.a;

import android.content.Context;
import com.google.android.gms.ads.internal.az;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.o;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class y
  implements u
{
  public final az a;
  public final Context b;
  public final ae c;
  public final com.google.android.gms.ads.internal.formats.y d;
  public String e;
  private v f;
  private final com.google.android.gms.ads.internal.zxxz.aa g;
  private final VersionInfoParcel h;
  
  public y(Context paramContext, az paramaz, String paramString, com.google.android.gms.ads.internal.zxxz.aa paramaa, VersionInfoParcel paramVersionInfoParcel)
  {
    com.google.android.gms.ads.internal.util.e.d("Webview loading for native ads.");
    this.b = paramContext;
    this.a = paramaz;
    this.g = paramaa;
    this.h = paramVersionInfoParcel;
    this.e = paramString;
    paramContext = bt.A.f;
    paramContext = this.b;
    paramaa = this.h;
    paramVersionInfoParcel = (String)n.aZ.a();
    com.google.android.gms.ads.internal.zxxz.aa localaa = this.g;
    com.google.android.gms.ads.internal.u localu = this.a.c;
    paramContext = h.a(h.a(null), new o(paramContext, localaa, paramaa, localu, paramVersionInfoParcel), com.google.android.gms.ads.internal.util.a.aa.b);
    this.c = new ae(this.b);
    this.d = new com.google.android.gms.ads.internal.formats.y(paramaz, paramString);
    this.f = h.a(paramContext, new z(this), com.google.android.gms.ads.internal.util.a.aa.a);
    com.google.android.gms.ads.internal.util.a.e.a(this.f, "WebViewNativeAdsUtil.constructor");
  }
  
  public final v a(JSONObject paramJSONObject)
  {
    return h.a(this.f, new aa(this, paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final void a()
  {
    h.a(this.f, new ai(), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    h.a(this.f, new af(paramString, paramu), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    h.a(this.f, new ah(paramString, paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final v b(JSONObject paramJSONObject)
  {
    return h.a(this.f, new ab(this, paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    h.a(this.f, new ag(paramString, paramu), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final v c(JSONObject paramJSONObject)
  {
    return h.a(this.f, new ac(this, paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.b);
  }
  
  public final v d(JSONObject paramJSONObject)
  {
    return h.a(this.f, new ad(this, paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */