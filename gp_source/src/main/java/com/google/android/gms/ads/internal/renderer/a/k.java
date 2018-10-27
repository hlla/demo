package com.google.android.gms.ads.internal.renderer.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.az;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.gmsg.ag;
import com.google.android.gms.ads.internal.gmsg.f;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.bm;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.v.b;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.lang.ref.WeakReference;

@com.google.android.gms.ads.internal.q.a.a
public final class k
{
  public final az a;
  private final Context b;
  private final DisplayMetrics c;
  private ViewTreeObserver.OnGlobalLayoutListener d;
  private final Object e = new Object();
  private final b f;
  private int g = -1;
  private int h = -1;
  private bm i;
  private ViewTreeObserver.OnScrollChangedListener j;
  private final aa k;
  private final l l;
  
  public k(Context paramContext, aa paramaa, b paramb, l paraml, az paramaz)
  {
    this.b = paramContext;
    this.k = paramaa;
    this.f = paramb;
    this.l = paraml;
    this.a = paramaz;
    this.i = new bm(200L);
    paramaa = bt.A.e;
    this.c = n.a((WindowManager)paramContext.getSystemService("window"));
  }
  
  final ViewTreeObserver.OnGlobalLayoutListener a(WeakReference paramWeakReference)
  {
    if (this.d == null) {
      this.d = new s(this, paramWeakReference);
    }
    return this.d;
  }
  
  final i a()
  {
    Object localObject = bt.A.f;
    localObject = this.b;
    au localau = au.a();
    aa localaa = this.k;
    b localb = this.f;
    return AdWebViewFactory.a((Context)localObject, localau, "native-video", false, false, localaa, localb.d.ae, this.l, null, this.a.c, localb.c);
  }
  
  final void a(i parami, boolean paramBoolean)
  {
    parami.a("/video", f.q);
    parami.a("/videoMeta", f.r);
    parami.a("/precache", new com.google.android.gms.ads.internal.w.b.r());
    parami.a("/delayPageLoaded", f.j);
    parami.a("/instrument", f.g);
    parami.a("/log", f.m);
    parami.a("/videoClicked", f.n);
    parami.a("/trackActiveViewUnit", new q(this));
    parami.a("/untrackActiveViewUnit", new r(this));
    if (paramBoolean) {
      parami.a("/open", new ag(null, null));
    }
  }
  
  final void a(WeakReference paramWeakReference, boolean paramBoolean)
  {
    if (paramWeakReference != null)
    {
      paramWeakReference = (i)paramWeakReference.get();
      if ((paramWeakReference != null) && (paramWeakReference.getView() != null))
      {
        if (!paramBoolean) {}
        while (this.i.a())
        {
          Object localObject2 = paramWeakReference.getView();
          ??? = new int[2];
          ((View)localObject2).getLocationOnScreen((int[])???);
          localObject2 = u.h.a;
          int m = com.google.android.gms.ads.internal.util.client.a.b(this.c, ???[0]);
          localObject2 = u.h.a;
          int n = com.google.android.gms.ads.internal.util.client.a.b(this.c, ???[1]);
          synchronized (this.e)
          {
            if ((this.g == m) && (this.h == n)) {
              return;
            }
            this.g = m;
            this.h = n;
            paramWeakReference.getAdWebViewClient().a(this.g, this.h, paramBoolean ^ true);
          }
        }
      }
    }
  }
  
  final ViewTreeObserver.OnScrollChangedListener b(WeakReference paramWeakReference)
  {
    if (this.j == null) {
      this.j = new t(this, paramWeakReference);
    }
    return this.j;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */