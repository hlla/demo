package com.google.android.gms.ads.internal.renderer;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.b;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.i;

@com.google.android.gms.ads.internal.q.a.a
public class g
  extends a
{
  g(Context paramContext, b paramb, i parami, f paramf)
  {
    super(paramContext, paramb, parami, paramf);
  }
  
  protected final void a()
  {
    if (this.a.n == -2)
    {
      this.b.getAdWebViewClient().a(this);
      d();
      e.b("Loading HTML in WebView.");
      i locali = this.b;
      AdResponseParcel localAdResponseParcel = this.a;
      locali.a(localAdResponseParcel.e, localAdResponseParcel.f, null);
    }
  }
  
  protected void d() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */