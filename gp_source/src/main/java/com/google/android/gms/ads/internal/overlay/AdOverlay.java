package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.gmsg.b;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.a.z;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.common.util.h;
import java.util.Collections;

@com.google.android.gms.ads.internal.q.a.a
public class AdOverlay
  extends com.google.android.gms.ads.internal.overlay.a.c
  implements t
{
  private static final int i = Color.argb(0, 0, 0, 0);
  public final Activity a;
  public AdOverlayInfoParcel b;
  public i c;
  public int d = 0;
  public boolean e;
  public WebChromeClient.CustomViewCallback f;
  public FrameLayout g;
  public boolean h = false;
  private f j;
  private l k;
  private final Object l = new Object();
  private Runnable m;
  private boolean n = false;
  private boolean o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private e s;
  private boolean t = true;
  private boolean u = false;
  
  public AdOverlay(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private static void a(com.google.android.gms.ads.internal.j.a parama, View paramView)
  {
    if ((parama != null) && (paramView != null)) {
      bt.A.y.a(parama, paramView);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    int i3 = 0;
    int i1 = ((Integer)com.google.android.gms.ads.internal.f.n.E.a()).intValue();
    Object localObject = new m();
    ((m)localObject).d = 50;
    if (!paramBoolean) {}
    for (int i2 = 0;; i2 = i1)
    {
      ((m)localObject).b = i2;
      i2 = i3;
      if (!paramBoolean) {
        i2 = i1;
      }
      ((m)localObject).c = i2;
      ((m)localObject).a = i1;
      this.k = new l(this.a, (m)localObject, this);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      if (!paramBoolean) {}
      for (i1 = 9;; i1 = 11)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(i1);
        a(paramBoolean, this.b.h);
        this.s.addView(this.k, (ViewGroup.LayoutParams)localObject);
        return;
      }
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    if (!this.e) {
      this.a.requestWindowFeature(1);
    }
    Object localObject2 = this.a.getWindow();
    if (localObject2 == null) {
      throw new AdOverlay.AdOverlayException("Invalid activity, no window available.");
    }
    Object localObject1;
    boolean bool1;
    if (h.d()) {
      if (((Boolean)com.google.android.gms.ads.internal.f.n.aK.a()).booleanValue())
      {
        localObject1 = bt.A.e;
        localObject1 = this.a;
        bool1 = com.google.android.gms.ads.internal.util.n.a((Activity)localObject1, ((Activity)localObject1).getResources().getConfiguration());
      }
    }
    for (;;)
    {
      localObject1 = this.b.k;
      int i1;
      if (localObject1 != null) {
        if (((InterstitialAdParameterParcel)localObject1).d) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (!this.u) {
          if (bool1) {}
        }
        for (;;)
        {
          localObject1 = this.b.e;
          if (localObject1 != null) {}
          for (localObject1 = ((i)localObject1).getAdWebViewClient();; localObject1 = null)
          {
            if (localObject1 != null) {}
            for (bool1 = ((ao)localObject1).b();; bool1 = false)
            {
              this.n = false;
              if (bool1)
              {
                if (this.b.m != bt.A.g.a()) {
                  break label860;
                }
                if (this.a.getResources().getConfiguration().orientation != 1) {
                  break label854;
                }
                bool2 = true;
                this.n = bool2;
              }
              label854:
              label860:
              while (this.b.m != bt.A.g.b()) {
                for (;;)
                {
                  bool2 = this.n;
                  localObject1 = new StringBuilder(46);
                  ((StringBuilder)localObject1).append("Delay onShow to next orientation change: ");
                  ((StringBuilder)localObject1).append(bool2);
                  com.google.android.gms.ads.internal.util.e.b(((StringBuilder)localObject1).toString());
                  a(this.b.m);
                  if (bt.A.g.a((Window)localObject2)) {
                    com.google.android.gms.ads.internal.util.e.b("Hardware acceleration on the AdActivity window enabled.");
                  }
                  if (!this.u) {
                    this.s.setBackgroundColor(-16777216);
                  }
                  for (;;)
                  {
                    this.a.setContentView(this.s);
                    this.e = true;
                    if (!paramBoolean)
                    {
                      this.c = this.b.e;
                      this.c.setContext(this.a);
                      this.c.setAdOverlay(this);
                      localObject1 = this.b.e;
                      if (localObject1 != null) {
                        a(((i)localObject1).getOmidSession(), this.s);
                      }
                      localObject1 = this.c.getParent();
                      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                        ((ViewGroup)localObject1).removeView(this.c.getView());
                      }
                      if (this.u) {
                        this.c.m();
                      }
                      this.s.addView(this.c.getView(), -1, -1);
                      if ((!paramBoolean) && (!this.n)) {
                        s();
                      }
                      a(bool1);
                      if (this.c.getCustomClose()) {
                        a(bool1, true);
                      }
                      return;
                    }
                    try
                    {
                      localObject1 = bt.A.f;
                      Object localObject4 = this.a;
                      localObject1 = this.b.e;
                      if (localObject1 != null) {}
                      for (localObject1 = ((i)localObject1).getAdSize();; localObject1 = null)
                      {
                        localObject2 = this.b.e;
                        if (localObject2 != null) {}
                        for (localObject2 = ((i)localObject2).getFormatString();; localObject2 = null)
                        {
                          Object localObject3 = this.b;
                          Object localObject5 = ((AdOverlayInfoParcel)localObject3).p;
                          localObject3 = ((AdOverlayInfoParcel)localObject3).e;
                          if (localObject3 != null) {}
                          for (localObject3 = ((i)localObject3).getAdManagerDependencyProvider();; localObject3 = null)
                          {
                            this.c = AdWebViewFactory.a((Context)localObject4, (au)localObject1, (String)localObject2, true, bool1, null, (VersionInfoParcel)localObject5, null, null, (u)localObject3, com.google.android.gms.ads.internal.d.a.a());
                            localObject2 = this.c.getAdWebViewClient();
                            localObject1 = this.b;
                            localObject3 = ((AdOverlayInfoParcel)localObject1).c;
                            localObject4 = ((AdOverlayInfoParcel)localObject1).f;
                            localObject5 = ((AdOverlayInfoParcel)localObject1).l;
                            localObject1 = ((AdOverlayInfoParcel)localObject1).e;
                            if (localObject1 != null) {}
                            for (localObject1 = ((i)localObject1).getAdWebViewClient().a();; localObject1 = null)
                            {
                              ((ao)localObject2).a(null, (b)localObject3, null, (com.google.android.gms.ads.internal.gmsg.d)localObject4, (q)localObject5, true, null, (com.google.android.gms.ads.internal.v)localObject1, null, null);
                              this.c.getAdWebViewClient().a(new c(this));
                              localObject1 = this.b;
                              localObject2 = ((AdOverlayInfoParcel)localObject1).o;
                              if (localObject2 != null) {
                                this.c.loadUrl((String)localObject2);
                              }
                              for (;;)
                              {
                                localObject1 = this.b.e;
                                if (localObject1 == null) {
                                  break;
                                }
                                ((i)localObject1).setSecondPieceOverlay(this);
                                break;
                                localObject2 = ((AdOverlayInfoParcel)localObject1).j;
                                if (localObject2 == null) {
                                  break label1026;
                                }
                                this.c.loadDataWithBaseURL(((AdOverlayInfoParcel)localObject1).g, (String)localObject2, "text/html", "UTF-8", null);
                              }
                            }
                          }
                        }
                      }
                      this.s.setBackgroundColor(i);
                    }
                    catch (Exception localException)
                    {
                      com.google.android.gms.ads.internal.util.e.c("Error obtaining webview.", localException);
                      throw new AdOverlay.AdOverlayException("Could not obtain webview for the overlay.");
                    }
                  }
                  bool2 = false;
                }
              }
              if (this.a.getResources().getConfiguration().orientation == 2) {}
              for (boolean bool2 = true;; bool2 = false)
              {
                this.n = bool2;
                break;
              }
            }
          }
          ((Window)localObject2).setFlags(1024, 1024);
          if (h.b())
          {
            localObject1 = this.b.k;
            if ((localObject1 != null) && (((InterstitialAdParameterParcel)localObject1).e))
            {
              ((Window)localObject2).getDecorView().setSystemUiVisibility(4098);
              continue;
              if (i1 != 0) {
                break;
              }
            }
          }
        }
        i1 = 0;
        continue;
        i1 = 0;
      }
      bool1 = true;
      continue;
      bool1 = true;
    }
    label1026:
    throw new AdOverlay.AdOverlayException("No URL or HTML to display in ad overlay.");
  }
  
  private final void r()
  {
    if ((this.a.isFinishing()) && (!this.r))
    {
      this.r = true;
      ??? = this.c;
      if (??? != null) {
        ((i)???).a(this.d);
      }
      synchronized (this.l)
      {
        if ((!this.o) && (this.c.getShouldDelayPageClose()))
        {
          this.m = new d(this);
          com.google.android.gms.ads.internal.util.n.a.postDelayed(this.m, ((Long)com.google.android.gms.ads.internal.f.n.bj.a()).longValue());
          return;
        }
        n();
        return;
      }
    }
  }
  
  private final void s()
  {
    this.c.d();
  }
  
  public final void a()
  {
    this.d = 2;
    this.a.finish();
  }
  
  public final void a(int paramInt)
  {
    if ((this.a.getApplicationInfo().targetSdkVersion < ((Integer)com.google.android.gms.ads.internal.f.n.j.a()).intValue()) || (this.a.getApplicationInfo().targetSdkVersion > ((Integer)com.google.android.gms.ads.internal.f.n.k.a()).intValue()) || (Build.VERSION.SDK_INT < ((Integer)com.google.android.gms.ads.internal.f.n.h.a()).intValue()) || (Build.VERSION.SDK_INT > ((Integer)com.google.android.gms.ads.internal.f.n.i.a()).intValue())) {
      this.a.setRequestedOrientation(paramInt);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.a.requestWindowFeature(1);
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.q = bool;
    Object localObject;
    try
    {
      this.b = AdOverlayInfoParcel.a(this.a.getIntent());
      localObject = this.b;
      if (localObject == null) {
        throw new AdOverlay.AdOverlayException("Could not get info for ad overlay.");
      }
    }
    catch (AdOverlay.AdOverlayException paramBundle)
    {
      com.google.android.gms.ads.internal.util.e.e(paramBundle.getMessage());
      this.d = 3;
      this.a.finish();
      return;
    }
    if (((AdOverlayInfoParcel)localObject).p.c <= 7500000) {
      if (this.a.getIntent() == null)
      {
        label107:
        localObject = this.b.k;
        if (localObject != null)
        {
          this.u = ((InterstitialAdParameterParcel)localObject).h;
          label127:
          if ((!this.u) || (((InterstitialAdParameterParcel)localObject).a == -1)) {
            break label407;
          }
          localObject = new g(this);
          if (((com.google.android.gms.ads.internal.util.a)localObject).j)
          {
            localObject = ((com.google.android.gms.ads.internal.util.a)localObject).k;
            com.google.android.gms.ads.internal.util.l.a.a((Runnable)localObject);
            break label407;
            label176:
            paramBundle = this.a;
            localObject = this.b;
            this.s = new e(paramBundle, ((AdOverlayInfoParcel)localObject).i, ((AdOverlayInfoParcel)localObject).p.a);
            this.s.setId(1000);
            paramBundle = this.b;
            switch (paramBundle.n)
            {
            }
          }
        }
      }
    }
    for (;;)
    {
      throw new AdOverlay.AdOverlayException("Could not determine ad overlay type.");
      b(true);
      return;
      this.j = new f(paramBundle.e);
      b(false);
      return;
      b(false);
      return;
      label407:
      do
      {
        paramBundle = this.b.d;
        if (paramBundle == null) {}
        for (;;)
        {
          paramBundle = this.b;
          if (paramBundle.n == 1) {
            break;
          }
          paramBundle = paramBundle.a;
          if (paramBundle == null) {
            break;
          }
          paramBundle.e();
          break;
          if (this.t) {
            paramBundle.C();
          }
        }
        com.google.android.gms.ads.internal.util.l.a(((com.google.android.gms.ads.internal.util.a)localObject).k);
        continue;
        this.u = false;
        break label127;
        this.t = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
        break label107;
        this.d = 3;
        break;
      } while (paramBundle == null);
      break label176;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    if ((((Boolean)com.google.android.gms.ads.internal.f.n.aK.a()).booleanValue()) && (h.d()))
    {
      parama = (Configuration)com.google.android.gms.dynamic.e.a(parama);
      com.google.android.gms.ads.internal.util.n localn = bt.A.e;
      if (com.google.android.gms.ads.internal.util.n.a(this.a, parama))
      {
        this.a.getWindow().addFlags(1024);
        this.a.getWindow().clearFlags(2048);
      }
    }
    else
    {
      return;
    }
    this.a.getWindow().addFlags(2048);
    this.a.getWindow().clearFlags(1024);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    Object localObject;
    int i1;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.bV.a()).booleanValue())
    {
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((AdOverlayInfoParcel)localObject).k;
        if (localObject != null) {
          if (((InterstitialAdParameterParcel)localObject).g) {
            i1 = 1;
          }
        }
      }
    }
    for (;;)
    {
      int i2;
      if (((Boolean)com.google.android.gms.ads.internal.f.n.bW.a()).booleanValue())
      {
        localObject = this.b;
        if (localObject != null)
        {
          localObject = ((AdOverlayInfoParcel)localObject).k;
          if (localObject != null) {
            if (((InterstitialAdParameterParcel)localObject).f) {
              i2 = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (!paramBoolean1) {}
        for (;;)
        {
          localObject = this.k;
          if (localObject != null)
          {
            if (i2 == 0) {
              break label130;
            }
            paramBoolean1 = bool;
          }
          for (;;)
          {
            ((l)localObject).setCustomClose(paramBoolean1);
            return;
            label130:
            if (!paramBoolean2)
            {
              paramBoolean1 = false;
            }
            else
            {
              paramBoolean1 = bool;
              if (i1 != 0) {
                paramBoolean1 = false;
              }
            }
          }
          if ((paramBoolean2) && (i1 != 0) && (i2 == 0)) {
            new com.google.android.gms.ads.internal.m.m(this.c, "useCustomClose").a("Custom close has been disabled for interstitial ads in this ad slot.");
          }
        }
        i2 = 0;
        continue;
        i2 = 0;
        continue;
        i2 = 0;
        continue;
        i2 = 0;
      }
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  public final void b()
  {
    Object localObject = this.b;
    if ((localObject != null) && (this.h)) {
      a(((AdOverlayInfoParcel)localObject).m);
    }
    if (this.g != null)
    {
      this.a.setContentView(this.s);
      this.e = true;
      this.g.removeAllViews();
      this.g = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((WebChromeClient.CustomViewCallback)localObject).onCustomViewHidden();
      this.f = null;
    }
    this.h = false;
  }
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.q);
  }
  
  public final void c()
  {
    this.d = 1;
    this.a.finish();
  }
  
  public final void d()
  {
    this.d = 0;
  }
  
  public final boolean e()
  {
    this.d = 0;
    i locali = this.c;
    if (locali != null)
    {
      boolean bool = locali.i();
      if (!bool) {
        this.c.a("onbackblocked", Collections.emptyMap());
      }
      return bool;
    }
    return true;
  }
  
  public final void f() {}
  
  public final void g()
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.aN.a()).booleanValue())
    {
      Object localObject = this.c;
      if ((localObject != null) && (!((i)localObject).g()))
      {
        localObject = bt.A.g;
        com.google.android.gms.ads.internal.util.v.b(this.c);
      }
    }
    else
    {
      return;
    }
    com.google.android.gms.ads.internal.util.e.e("The webview does not exist. Ignoring action.");
  }
  
  public final void h()
  {
    Object localObject = this.b.d;
    if (localObject != null) {
      ((k)localObject).E();
    }
    if (!((Boolean)com.google.android.gms.ads.internal.f.n.aN.a()).booleanValue())
    {
      localObject = this.c;
      if ((localObject != null) && (!((i)localObject).g()))
      {
        localObject = bt.A.g;
        com.google.android.gms.ads.internal.util.v.b(this.c);
      }
    }
    else
    {
      return;
    }
    com.google.android.gms.ads.internal.util.e.e("The webview does not exist. Ignoring action.");
  }
  
  public final void i()
  {
    b();
    Object localObject = this.b.d;
    if (localObject != null) {
      ((k)localObject).D();
    }
    if ((!((Boolean)com.google.android.gms.ads.internal.f.n.aN.a()).booleanValue()) && (this.c != null) && ((!this.a.isFinishing()) || (this.j == null)))
    {
      localObject = bt.A.g;
      com.google.android.gms.ads.internal.util.v.a(this.c);
    }
    r();
  }
  
  public final void j()
  {
    if ((((Boolean)com.google.android.gms.ads.internal.f.n.aN.a()).booleanValue()) && (this.c != null) && ((!this.a.isFinishing()) || (this.j == null)))
    {
      com.google.android.gms.ads.internal.util.v localv = bt.A.g;
      com.google.android.gms.ads.internal.util.v.a(this.c);
    }
    r();
  }
  
  public final void k()
  {
    i locali = this.c;
    if (locali != null) {
      this.s.removeView(locali.getView());
    }
    r();
  }
  
  public final void l()
  {
    this.e = true;
  }
  
  public final void m()
  {
    this.s.removeView(this.k);
    a(true);
  }
  
  final void n()
  {
    Object localObject;
    if (!this.p)
    {
      this.p = true;
      localObject = this.c;
      if (localObject != null)
      {
        this.s.removeView(((i)localObject).getView());
        localObject = this.j;
        if (localObject == null) {
          break label176;
        }
        this.c.setContext(((f)localObject).a);
        this.c.setIsExpanded(false);
        localObject = this.j.d;
        View localView = this.c.getView();
        f localf = this.j;
        ((ViewGroup)localObject).addView(localView, localf.b, localf.c);
        this.j = null;
      }
    }
    for (;;)
    {
      this.c = null;
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((AdOverlayInfoParcel)localObject).d;
        if (localObject != null) {
          ((k)localObject).B();
        }
      }
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((AdOverlayInfoParcel)localObject).e;
        if (localObject != null) {
          a(((i)localObject).getOmidSession(), this.b.e.getView());
        }
      }
      return;
      label176:
      if (this.a.getApplicationContext() != null) {
        this.c.setContext(this.a.getApplicationContext());
      }
    }
  }
  
  public final void o()
  {
    if (this.n)
    {
      this.n = false;
      s();
    }
  }
  
  public final void p()
  {
    this.s.a = true;
  }
  
  public final void q()
  {
    synchronized (this.l)
    {
      this.o = true;
      if (this.m != null)
      {
        com.google.android.gms.ads.internal.util.n.a.removeCallbacks(this.m);
        com.google.android.gms.ads.internal.util.n.a.post(this.m);
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/AdOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */