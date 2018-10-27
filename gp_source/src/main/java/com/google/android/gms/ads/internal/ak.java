package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.gmsg.ac;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.bk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class ak
  extends h
  implements ac, com.google.android.gms.ads.internal.gmsg.al
{
  public boolean k;
  public float l;
  public boolean m;
  private int n = -1;
  private final com.google.android.gms.ads.internal.reward.a o;
  private transient boolean p = false;
  
  public ak(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel, u paramu)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, paramu);
    paramContext = (Context)localObject;
    if (paramAdSizeParcel != null)
    {
      paramContext = (Context)localObject;
      if ("reward_mb".equals(paramAdSizeParcel.a))
      {
        paramContext = new am(this);
        paramContext = new com.google.android.gms.ads.internal.reward.a(this.g, this.j, paramContext, this, this);
      }
    }
    this.o = paramContext;
  }
  
  private final void aa()
  {
    Object localObject = bt.A.x;
    int i = this.n;
    ((bk)localObject).b.remove(Integer.valueOf(i));
    if (this.g.c())
    {
      this.g.a();
      localObject = this.g;
      ((bu)localObject).h = null;
      ((bu)localObject).O = false;
      this.p = false;
    }
  }
  
  private static com.google.android.gms.ads.internal.v.b b(com.google.android.gms.ads.internal.v.b paramb)
  {
    try
    {
      Object localObject1 = com.google.android.gms.ads.internal.request.a.h.a(paramb.e).toString();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", paramb.d.d);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject2 = new com.google.android.gms.ads.internal.mediation.b((String)localObject1, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (String)localObject2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
      localObject1 = paramb.e;
      localObject2 = Collections.singletonList(localObject2);
      com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.bq;
      localObject2 = new com.google.android.gms.ads.internal.mediation.c((List)localObject2, ((Long)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), ((AdResponseParcel)localObject1).H, ((AdResponseParcel)localObject1).I, "");
      localObject1 = new AdResponseParcel(paramb.d, ((AdResponseParcel)localObject1).e, ((AdResponseParcel)localObject1).f, Collections.emptyList(), Collections.emptyList(), ((AdResponseParcel)localObject1).r, true, ((AdResponseParcel)localObject1).G, Collections.emptyList(), ((AdResponseParcel)localObject1).M, ((AdResponseParcel)localObject1).K, ((AdResponseParcel)localObject1).b, ((AdResponseParcel)localObject1).o, ((AdResponseParcel)localObject1).k, ((AdResponseParcel)localObject1).x, ((AdResponseParcel)localObject1).L, null, ((AdResponseParcel)localObject1).v, ((AdResponseParcel)localObject1).z, ((AdResponseParcel)localObject1).U, ((AdResponseParcel)localObject1).h, ((AdResponseParcel)localObject1).D, ((AdResponseParcel)localObject1).p, ((AdResponseParcel)localObject1).w, ((AdResponseParcel)localObject1).A, null, Collections.emptyList(), Collections.emptyList(), ((AdResponseParcel)localObject1).E, ((AdResponseParcel)localObject1).d, ((AdResponseParcel)localObject1).s, ((AdResponseParcel)localObject1).V, ((AdResponseParcel)localObject1).H, ((AdResponseParcel)localObject1).I, ((AdResponseParcel)localObject1).c, null, ((AdResponseParcel)localObject1).l, ((AdResponseParcel)localObject1).i, ((AdResponseParcel)localObject1).B, ((AdResponseParcel)localObject1).u, ((AdResponseParcel)localObject1).C, Collections.emptyList(), ((AdResponseParcel)localObject1).t, ((AdResponseParcel)localObject1).J, ((AdResponseParcel)localObject1).T, ((AdResponseParcel)localObject1).S);
      return new com.google.android.gms.ads.internal.v.b(paramb.d, (AdResponseParcel)localObject1, (com.google.android.gms.ads.internal.mediation.c)localObject2, paramb.g, paramb.h, paramb.f, paramb.b, null, paramb.c, null);
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.e.c("Unable to generate ad state for an interstitial ad with pooling.", localJSONException);
    }
    return paramb;
  }
  
  private final void b(Bundle paramBundle)
  {
    Object localObject = bt.A.e;
    localObject = this.g;
    com.google.android.gms.ads.internal.util.n.b(((bu)localObject).m, ((bu)localObject).P.a, "gmob-apps", paramBundle, false);
  }
  
  private final boolean e(boolean paramBoolean)
  {
    return (this.o != null) && (paramBoolean);
  }
  
  public final void B()
  {
    super.B();
    this.a.a(this.g.h);
    this.i = null;
  }
  
  public final void C()
  {
    M();
    super.C();
    Object localObject = this.g.h;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.webview.i)localObject).getAdWebViewClient();
        if (localObject != null) {
          ((ao)localObject).g();
        }
      }
    }
    localObject = bt.A.B;
    if (this.i != null)
    {
      localObject = this.g.h;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;
        if (localObject != null) {
          ((com.google.android.gms.ads.internal.webview.i)localObject).a("onSdkImpression", new HashMap());
        }
      }
    }
  }
  
  public final void P()
  {
    com.google.android.gms.common.internal.z.a("showInterstitial must be called on the main UI thread.");
    Object localObject1 = this.g.h;
    boolean bool1;
    if (localObject1 != null) {
      if (((com.google.android.gms.ads.internal.v.a)localObject1).u) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (e(bool1)) {
        this.o.a(this.m);
      }
      do
      {
        return;
        localObject1 = bt.A.B;
        if (this.g.h == null)
        {
          com.google.android.gms.ads.internal.util.e.e("The interstitial has not loaded.");
          return;
        }
        if (this.p) {
          break;
        }
        localObject1 = com.google.android.gms.ads.internal.f.n.bi;
      } while (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject1)).booleanValue());
      localObject1 = com.google.android.gms.ads.internal.f.n.p;
      if (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject1)).booleanValue()) {}
      label882:
      do
      {
        localObject1 = com.google.android.gms.ads.internal.f.n.aB;
        if (((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject1)).booleanValue()) {
          if (this.g.m.getApplicationContext() == null) {
            break label882;
          }
        }
        for (localObject1 = this.g.m.getApplicationContext().getPackageName();; localObject2 = this.g.m.getPackageName())
        {
          if (!this.p)
          {
            com.google.android.gms.ads.internal.util.e.e("It is not recommended to show an interstitial before onAdLoaded completes.");
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("appid", (String)localObject1);
            ((Bundle)localObject3).putString("action", "show_interstitial_before_load_finish");
            b((Bundle)localObject3);
          }
          Object localObject3 = bt.A.e;
          if (!com.google.android.gms.ads.internal.util.n.g(this.g.m))
          {
            com.google.android.gms.ads.internal.util.e.e("It is not recommended to show an interstitial when app is not in foreground.");
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("appid", (String)localObject1);
            ((Bundle)localObject3).putString("action", "show_interstitial_app_not_in_foreground");
            b((Bundle)localObject3);
          }
          if (this.g.d()) {
            break;
          }
          localObject1 = this.g.h;
          if (((com.google.android.gms.ads.internal.v.a)localObject1).u)
          {
            localObject3 = ((com.google.android.gms.ads.internal.v.a)localObject1).B;
            if (localObject3 != null) {
              try
              {
                ((com.google.android.gms.ads.internal.mediation.client.e)localObject3).a(this.m);
                this.g.h.B.b();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                com.google.android.gms.ads.internal.util.e.e("Could not show interstitial.", localRemoteException);
                aa();
                return;
              }
            }
          }
          localObject2 = localRemoteException.g;
          if (localObject2 == null)
          {
            com.google.android.gms.ads.internal.util.e.e("The interstitial failed to load.");
            return;
          }
          if (((com.google.android.gms.ads.internal.webview.i)localObject2).f())
          {
            com.google.android.gms.ads.internal.util.e.e("The interstitial is already showing.");
            return;
          }
          this.g.h.g.setIsExpanded(true);
          localObject2 = this.g;
          ((bu)localObject2).a(((bu)localObject2).h.g.getView());
          localObject2 = this.g;
          localObject3 = ((bu)localObject2).h;
          if (((com.google.android.gms.ads.internal.v.a)localObject3).a != null) {
            this.a.a(((bu)localObject2).g, (com.google.android.gms.ads.internal.v.a)localObject3);
          }
          localObject2 = this.g.h;
          if (((com.google.android.gms.ads.internal.v.a)localObject2).a()) {
            new com.google.android.gms.ads.internal.a.z(this.g.m, ((com.google.android.gms.ads.internal.v.a)localObject2).g.getView()).a(((com.google.android.gms.ads.internal.v.a)localObject2).g);
          }
          for (;;)
          {
            if (this.g.O) {
              localObject2 = bt.A.e;
            }
            for (localObject2 = com.google.android.gms.ads.internal.util.n.i(this.g.m);; localObject2 = null)
            {
              localObject3 = bt.A.x;
              int i;
              if (localObject2 == null)
              {
                com.google.android.gms.ads.internal.util.e.b("Bitmap is null. Skipping putting into the Memory Map.");
                i = -1;
              }
              for (;;)
              {
                this.n = i;
                if (localObject2 == null)
                {
                  bool1 = this.g.O;
                  localObject2 = bt.A.e;
                  boolean bool2 = com.google.android.gms.ads.internal.util.n.r(this.g.m);
                  boolean bool3 = this.m;
                  localObject2 = this.g.h;
                  localObject2 = new InterstitialAdParameterParcel(bool1, bool2, false, 0.0F, -1, bool3, ((com.google.android.gms.ads.internal.v.a)localObject2).o, ((com.google.android.gms.ads.internal.v.a)localObject2).n);
                  int j = this.g.h.g.getRequestedOrientation();
                  i = j;
                  if (j == -1) {
                    i = this.g.h.I;
                  }
                  localObject3 = this.g;
                  com.google.android.gms.ads.internal.v.a locala = ((bu)localObject3).h;
                  localObject2 = new AdOverlayInfoParcel(this, this, this, locala.g, i, ((bu)localObject3).P, locala.i, (InterstitialAdParameterParcel)localObject2);
                  localObject3 = bt.A.c;
                  com.google.android.gms.ads.internal.overlay.i.a(this.g.m, (AdOverlayInfoParcel)localObject2, true);
                  return;
                }
                localObject2 = new an(this, this.n);
                if (((com.google.android.gms.ads.internal.util.a)localObject2).j)
                {
                  localObject2 = ((com.google.android.gms.ads.internal.util.a)localObject2).k;
                  com.google.android.gms.ads.internal.util.l.a.a((Runnable)localObject2);
                  return;
                }
                com.google.android.gms.ads.internal.util.l.a(((com.google.android.gms.ads.internal.util.a)localObject2).k);
                return;
                i = ((bk)localObject3).a.getAndIncrement();
                ((bk)localObject3).b.put(Integer.valueOf(i), localObject2);
              }
            }
            ((com.google.android.gms.ads.internal.v.a)localObject2).g.getAdWebViewClient().a(new al(this, (com.google.android.gms.ads.internal.v.a)localObject2));
          }
        }
        Object localObject2 = bt.A.e;
      } while (!com.google.android.gms.ads.internal.util.n.h(this.g.m));
      com.google.android.gms.ads.internal.util.e.e("It is not recommended to show an interstitial when app is not in foreground.");
      return;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void X()
  {
    AdOverlay localAdOverlay = this.g.h.g.getAdOverlay();
    if (localAdOverlay != null) {
      localAdOverlay.a();
    }
  }
  
  public final void Y()
  {
    boolean bool2 = false;
    Object localObject = this.g.h;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((com.google.android.gms.ads.internal.v.a)localObject).u) {
        bool1 = true;
      }
    }
    if (e(bool1))
    {
      this.o.c();
      t();
      return;
    }
    localObject = this.g.h;
    if ((localObject != null) && (((com.google.android.gms.ads.internal.v.a)localObject).M != null))
    {
      localObject = bt.A.e;
      localObject = this.g;
      com.google.android.gms.ads.internal.util.n.a(((bu)localObject).m, ((bu)localObject).P.a, ((bu)localObject).h.M);
    }
    t();
  }
  
  public final void Z()
  {
    boolean bool2 = false;
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    boolean bool1 = bool2;
    if (locala != null)
    {
      bool1 = bool2;
      if (locala.u) {
        bool1 = true;
      }
    }
    if (e(bool1)) {
      this.o.d();
    }
    u();
  }
  
  protected final com.google.android.gms.ads.internal.webview.i a(com.google.android.gms.ads.internal.v.b paramb, v paramv, com.google.android.gms.ads.internal.safebrowsing.k paramk)
  {
    Object localObject1 = bt.A.f;
    Object localObject2 = this.g;
    localObject1 = ((bu)localObject2).m;
    localObject2 = au.a(((bu)localObject2).g);
    bu localbu = this.g;
    localObject1 = AdWebViewFactory.a((Context)localObject1, (au)localObject2, localbu.g.a, false, false, localbu.N, localbu.P, this.h, this, this.c, paramb.c);
    ((com.google.android.gms.ads.internal.webview.i)localObject1).getAdWebViewClient().a(this, this, null, this, this, true, this, paramv, this, paramk);
    a((com.google.android.gms.ads.internal.webview.i)localObject1);
    ((com.google.android.gms.ads.internal.webview.i)localObject1).setRequestId(paramb.d.P);
    com.google.android.gms.ads.internal.gmsg.ak.a((com.google.android.gms.ads.internal.webview.i)localObject1, this);
    return (com.google.android.gms.ads.internal.webview.i)localObject1;
  }
  
  public final void a(com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.g.l paraml)
  {
    if (paramb.h != -2)
    {
      super.a(paramb, paraml);
      return;
    }
    if (paramb.i != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (e(bool))
      {
        this.o.a();
        return;
      }
      com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.aL;
      if (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue())
      {
        super.a(paramb, paraml);
        return;
      }
      bool = paramb.e.y;
      if ((a(paramb.d.b)) && ((bool ^ true))) {
        this.g.G = b(paramb);
      }
      super.a(this.g.G, paraml);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.k = paramBoolean;
    this.l = paramFloat;
  }
  
  public final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.g.l paraml)
  {
    if (this.g.h != null)
    {
      com.google.android.gms.ads.internal.util.e.e("An interstitial is already loading. Aborting.");
      return false;
    }
    if (a(paramAdRequestParcel)) {
      com.google.android.gms.ads.internal.s.b localb = bt.A.B;
    }
    return super.a(paramAdRequestParcel, paraml);
  }
  
  protected final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    if ((this.g.c()) && (parama.g != null))
    {
      paramAdRequestParcel = bt.A.g;
      com.google.android.gms.ads.internal.util.v.a(parama.g);
    }
    return this.f.c;
  }
  
  public final boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    boolean bool = false;
    if (e(parama2.u)) {
      bool = com.google.android.gms.ads.internal.reward.a.b();
    }
    while (!super.a(parama1, parama2)) {
      return bool;
    }
    if (!this.g.c())
    {
      parama1 = this.g;
      View localView = parama1.o;
      if ((localView != null) && (parama2.a != null)) {
        this.a.a(parama1.g, parama2, localView);
      }
    }
    b(parama2, false);
    return true;
  }
  
  public final void b(RewardItemParcel paramRewardItemParcel)
  {
    boolean bool2 = false;
    Object localObject1 = this.g.h;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((com.google.android.gms.ads.internal.v.a)localObject1).u) {
        bool1 = true;
      }
    }
    if (e(bool1))
    {
      a(this.o.a(paramRewardItemParcel));
      return;
    }
    Object localObject2 = this.g.h;
    localObject1 = paramRewardItemParcel;
    if (localObject2 != null) {
      if (((com.google.android.gms.ads.internal.v.a)localObject2).K != null) {
        break label107;
      }
    }
    for (;;)
    {
      localObject2 = this.g.h.L;
      localObject1 = paramRewardItemParcel;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      a((RewardItemParcel)localObject1);
      return;
      label107:
      localObject1 = bt.A.e;
      localObject1 = this.g;
      com.google.android.gms.ads.internal.util.n.a(((bu)localObject1).m, ((bu)localObject1).P.a, ((bu)localObject1).h.K);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    com.google.android.gms.common.internal.z.a("setImmersiveMode must be called on the main UI thread.");
    this.m = paramBoolean;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.g.O = paramBoolean;
  }
  
  protected final void n()
  {
    aa();
    super.n();
  }
  
  protected final void q()
  {
    Object localObject2 = this.g;
    Object localObject1 = ((bu)localObject2).h;
    if (localObject1 != null) {}
    for (localObject1 = ((com.google.android.gms.ads.internal.v.a)localObject1).g;; localObject1 = null)
    {
      localObject2 = ((bu)localObject2).G;
      if (localObject2 != null)
      {
        localObject2 = ((com.google.android.gms.ads.internal.v.b)localObject2).e;
        if ((localObject2 != null) && (((AdResponseParcel)localObject2).C)) {
          break label63;
        }
      }
      for (;;)
      {
        super.q();
        this.p = true;
        return;
        label63:
        if ((localObject1 != null) && (bt.A.y.a(this.g.m)))
        {
          localObject2 = this.g.P;
          int i = ((VersionInfoParcel)localObject2).b;
          int j = ((VersionInfoParcel)localObject2).c;
          localObject2 = new StringBuilder(23);
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(".");
          ((StringBuilder)localObject2).append(j);
          localObject2 = ((StringBuilder)localObject2).toString();
          this.i = bt.A.y.a((String)localObject2, ((com.google.android.gms.ads.internal.webview.i)localObject1).getWebView(), "", "javascript", z());
          if ((this.i != null) && (((com.google.android.gms.ads.internal.webview.i)localObject1).getView() != null))
          {
            bt.A.y.a(this.i, ((com.google.android.gms.ads.internal.webview.i)localObject1).getView());
            ((com.google.android.gms.ads.internal.webview.i)localObject1).setOmidSession(this.i);
            bt.A.y.a(this.i);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */