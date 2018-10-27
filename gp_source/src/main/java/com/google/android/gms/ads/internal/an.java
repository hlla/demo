package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.webview.i;

@com.google.android.gms.ads.internal.q.a.a
final class an
  extends com.google.android.gms.ads.internal.util.a
{
  private final int b;
  
  public an(ak paramak, int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a()
  {
    boolean bool1 = this.a.g.O;
    Object localObject1 = bt.A.e;
    boolean bool2 = n.r(this.a.g.m);
    localObject1 = this.a;
    boolean bool3 = ((ak)localObject1).k;
    float f = ((ak)localObject1).l;
    Object localObject2 = ((ak)localObject1).g;
    if (((bu)localObject2).O) {}
    for (int i = this.b;; i = -1)
    {
      boolean bool4 = ((ak)localObject1).m;
      localObject1 = ((bu)localObject2).h;
      localObject1 = new InterstitialAdParameterParcel(bool1, bool2, bool3, f, i, bool4, ((com.google.android.gms.ads.internal.v.a)localObject1).o, ((com.google.android.gms.ads.internal.v.a)localObject1).n);
      int j = this.a.g.h.g.getRequestedOrientation();
      i = j;
      if (j == -1) {
        i = this.a.g.h.I;
      }
      localObject2 = this.a;
      bu localbu = ((ak)localObject2).g;
      com.google.android.gms.ads.internal.v.a locala = localbu.h;
      localObject1 = new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.a)localObject2, (k)localObject2, (q)localObject2, locala.g, i, localbu.P, locala.i, (InterstitialAdParameterParcel)localObject1);
      n.a.post(new ao(this, (AdOverlayInfoParcel)localObject1));
      return;
    }
  }
  
  public final void be_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */