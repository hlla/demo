package com.google.android.gms.ads.internal.renderer;

import android.content.Context;
import com.google.android.gms.ads.internal.az;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.zxxz.aa;

@com.google.android.gms.ads.internal.q.a.a
public final class e
{
  public static ag a(Context paramContext, com.google.android.gms.ads.internal.a parama, com.google.android.gms.ads.internal.v.b paramb, aa paramaa, i parami, com.google.android.gms.ads.internal.mediation.client.b paramb1, f paramf, l paraml)
  {
    AdResponseParcel localAdResponseParcel = paramb.e;
    if (localAdResponseParcel.y) {
      paramContext = new k(paramContext, paramb, paramb1, paramf, paraml, parami);
    }
    for (;;)
    {
      parama = String.valueOf(paramContext.getClass().getName());
      if (parama.length() == 0) {}
      for (parama = new String("AdRenderer: ");; parama = "AdRenderer: ".concat(parama))
      {
        com.google.android.gms.ads.internal.util.e.b(parama);
        paramContext.c();
        return paramContext;
      }
      boolean bool = localAdResponseParcel.z;
      if ((!bool) && (!(parama instanceof az)))
      {
        if ((!com.google.android.gms.common.util.h.b()) || (com.google.android.gms.common.util.h.c())) {}
        while ((parami == null) || (!parami.getAdSize().e()))
        {
          paramContext = new g(paramContext, paramb, parami, paramf);
          break;
        }
        paramContext = new j(paramContext, paramb, parami, paramf);
      }
      else
      {
        if (!bool) {}
        while (!(parama instanceof az))
        {
          paramContext = new h(paramb, paramf);
          break;
        }
        paramContext = new m(paramContext, (az)parama, paramb, paramaa, paramf, paraml);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */