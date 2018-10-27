package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.mediation.client.q;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import java.lang.ref.WeakReference;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class w
  extends h
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private boolean k;
  private boolean l;
  
  public w(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel, u paramu)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, paramu);
    new WeakReference(null);
  }
  
  private final boolean b(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    Object localObject1;
    Object localObject2;
    if (parama2.u)
    {
      localObject1 = aq.a(parama2);
      if (localObject1 == null)
      {
        com.google.android.gms.ads.internal.util.e.e("Could not get mediation view");
        return false;
      }
      localObject2 = this.g.b.getNextView();
      if (localObject2 != null)
      {
        if ((localObject2 instanceof i)) {
          ((i)localObject2).destroy();
        }
        this.g.b.removeView((View)localObject2);
      }
      if (aq.b(parama2)) {}
    }
    try
    {
      localObject2 = bt.A.B;
      localObject2 = this.g;
      AdSizeParcel localAdSizeParcel = parama2.e;
      if (localAdSizeParcel != null)
      {
        ((bu)localObject2).b.setMinimumWidth(localAdSizeParcel.j);
        this.g.b.setMinimumHeight(parama2.e.c);
      }
      a((View)localObject1);
      for (;;)
      {
        if (this.g.b.getChildCount() > 1) {
          this.g.b.showNext();
        }
        if (parama1 != null)
        {
          parama1 = this.g.b.getNextView();
          if (!(parama1 instanceof i)) {
            break label212;
          }
          ((i)parama1).destroy();
        }
        for (;;)
        {
          this.g.b();
          this.g.b.setVisibility(0);
          return true;
          label212:
          if (parama1 != null) {
            this.g.b.removeView(parama1);
          }
        }
        localObject1 = parama2.e;
        if (localObject1 != null)
        {
          localObject2 = parama2.g;
          if (localObject2 != null)
          {
            ((i)localObject2).setAdSize(au.a((AdSizeParcel)localObject1));
            this.g.b.removeAllViews();
            this.g.b.setMinimumWidth(parama2.e.j);
            this.g.b.setMinimumHeight(parama2.e.c);
            a(parama2.g.getView());
          }
        }
      }
      return false;
    }
    catch (Exception parama1)
    {
      bt.A.i.a(parama1, "BannerAdManager.swapViews");
      com.google.android.gms.ads.internal.util.e.e("Could not add mediation view to view hierarchy.", parama1);
    }
  }
  
  private final void c(i parami)
  {
    if (U())
    {
      WebView localWebView = parami.getWebView();
      if (localWebView != null)
      {
        View localView = parami.getView();
        if ((localView != null) && (bt.A.y.a(this.g.m)))
        {
          Object localObject = this.g.P;
          int i = ((VersionInfoParcel)localObject).b;
          int j = ((VersionInfoParcel)localObject).c;
          localObject = new StringBuilder(23);
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(".");
          ((StringBuilder)localObject).append(j);
          localObject = ((StringBuilder)localObject).toString();
          this.i = bt.A.y.a((String)localObject, localWebView, "", "javascript", z());
          if (this.i != null)
          {
            bt.A.y.a(this.i, localView);
            parami.setOmidSession(this.i);
            bt.A.y.a(this.i);
            this.k = true;
          }
        }
      }
    }
  }
  
  protected final boolean A()
  {
    Object localObject = bt.A.e;
    if (!com.google.android.gms.ads.internal.util.n.a(this.g.m, "android.permission.INTERNET"))
    {
      localObject = com.google.android.gms.ads.internal.client.u.h.a;
      localObject = this.g;
      com.google.android.gms.ads.internal.util.client.a.a(((bu)localObject).b, ((bu)localObject).g, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
    }
    for (boolean bool = false;; bool = true)
    {
      localObject = bt.A.e;
      if (!com.google.android.gms.ads.internal.util.n.a(this.g.m))
      {
        localObject = com.google.android.gms.ads.internal.client.u.h.a;
        localObject = this.g;
        com.google.android.gms.ads.internal.util.client.a.a(((bu)localObject).b, ((bu)localObject).g, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
        bool = false;
      }
      if (!bool)
      {
        localObject = this.g.b;
        if (localObject != null) {
          ((bv)localObject).setVisibility(0);
        }
      }
      return bool;
    }
  }
  
  public final void P()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  public final void X()
  {
    bj localbj = this.f;
    localbj.b = false;
    localbj.c = false;
    Object localObject = localbj.a;
    if (localObject != null)
    {
      localObject = ((AdRequestParcel)localObject).f;
      if (localObject != null) {
        ((Bundle)localObject).remove("_ad");
      }
    }
    localbj.a(localbj.a, 0L);
  }
  
  protected final i a(com.google.android.gms.ads.internal.v.b paramb, v paramv, com.google.android.gms.ads.internal.safebrowsing.k paramk)
  {
    bu localbu = this.g;
    AdSizeParcel localAdSizeParcel = localbu.g;
    if ((localAdSizeParcel.h == null) && (localAdSizeParcel.d))
    {
      AdResponseParcel localAdResponseParcel = paramb.e;
      localObject = localAdSizeParcel;
      if (!localAdResponseParcel.w)
      {
        localObject = localAdResponseParcel.b;
        if (localObject == null) {
          break label147;
        }
        localObject = ((String)localObject).split("[xX]");
        localObject[0] = localObject[0].trim();
        localObject[1] = localObject[1].trim();
      }
    }
    label147:
    for (Object localObject = new com.google.android.gms.ads.g(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]));; localObject = localAdSizeParcel.c())
    {
      localObject = new AdSizeParcel(this.g.m, (com.google.android.gms.ads.g)localObject);
      localbu.g = ((AdSizeParcel)localObject);
      return super.a(paramb, paramv, paramk);
    }
  }
  
  protected final void a(com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    Object localObject4 = null;
    aa localaa;
    i locali;
    Object localObject1;
    label63:
    Object localObject2;
    if (!U())
    {
      super.a(parama, paramBoolean);
      if (!aq.b(parama)) {
        return;
      }
      localaa = new aa(this);
      if ((parama == null) || (!aq.b(parama))) {
        return;
      }
      locali = parama.g;
      if (locali != null)
      {
        localObject1 = locali.getView();
        if (localObject1 != null) {
          label87:
          break label95;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = parama.A;
        if (localObject2 == null) {
          break label300;
        }
        localObject2 = ((com.google.android.gms.ads.internal.mediation.b)localObject2).t;
      }
      catch (RemoteException parama)
      {
        label95:
        com.google.android.gms.ads.internal.mediation.client.e locale;
        com.google.android.gms.ads.internal.util.e.e("Error occurred while recording impression and registering for clicks", parama);
        return;
      }
      com.google.android.gms.ads.internal.util.e.e("No template ids present in mediation response");
      return;
      if (!((List)localObject2).isEmpty())
      {
        Object localObject3 = parama.B;
        if (localObject3 != null)
        {
          localObject3 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject3).h();
          locale = parama.B;
          parama = (com.google.android.gms.ads.internal.v.a)localObject4;
          if (locale != null) {
            parama = locale.i();
          }
          if (!((List)localObject2).contains("2"))
          {
            if (!((List)localObject2).contains("1"))
            {
              com.google.android.gms.ads.internal.util.e.e("No matching template id and mapper");
              return;
            }
            if (parama == null) {
              continue;
            }
            parama.b(com.google.android.gms.dynamic.e.a(localObject1));
            if (parama.h()) {}
            for (;;)
            {
              locali.a("/nativeExpressViewClicked", aq.a(null, parama, localaa));
              return;
              parama.g();
            }
          }
          if (localObject3 == null) {
            continue;
          }
          ((com.google.android.gms.ads.internal.mediation.client.n)localObject3).b(com.google.android.gms.dynamic.e.a(localObject1));
          if (((com.google.android.gms.ads.internal.mediation.client.n)localObject3).j()) {}
          for (;;)
          {
            locali.a("/nativeExpressViewClicked", aq.a((com.google.android.gms.ads.internal.mediation.client.n)localObject3, null, localaa));
            return;
            ((com.google.android.gms.ads.internal.mediation.client.n)localObject3).i();
          }
        }
        localObject3 = null;
        continue;
        label300:
        localObject2 = null;
        break label374;
        com.google.android.gms.ads.internal.util.e.e("AdWebView is null");
        return;
        localObject1 = null;
        break label63;
        if (parama != null) {}
        for (localObject1 = parama.g;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label372;
          }
          if (!this.k) {
            c((i)localObject1);
          }
          if (this.i == null) {
            break;
          }
          ((i)localObject1).a("onSdkImpression", new android.support.v4.g.a());
          break;
        }
        label372:
        break;
        label374:
        if (localObject2 != null) {
          break label87;
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    com.google.android.gms.common.internal.z.a("setManualImpressionsEnabled must be called from the main thread.");
    this.l = paramBoolean;
  }
  
  public final boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    if (super.a(parama1, parama2))
    {
      if ((this.g.c()) && (!b(parama1, parama2)))
      {
        parama1 = parama2.c;
        if (parama1 != null) {
          parama1.a(com.google.android.gms.ads.internal.d.g.a);
        }
        a(0);
        return false;
      }
      b(parama2, false);
      Object localObject;
      if (parama2.y)
      {
        d(parama2);
        parama1 = bt.A.E;
        com.google.android.gms.ads.internal.util.d.a.a(this.g.b, this);
        parama1 = bt.A.E;
        com.google.android.gms.ads.internal.util.d.a.a(this.g.b, this);
        if (!parama2.q)
        {
          localObject = new x(this);
          parama1 = parama2.g;
          if (parama1 == null) {
            break label407;
          }
          parama1 = parama1.getAdWebViewClient();
          if (parama1 != null) {
            parama1.a(new y(parama2, (Runnable)localObject));
          }
        }
      }
      for (;;)
      {
        parama1 = parama2.g;
        if (parama1 != null)
        {
          parama1 = parama1.getVideoController();
          localObject = parama2.g.getAdWebViewClient();
          if (localObject != null) {
            ((ao)localObject).g();
          }
          localObject = this.g.Q;
          if (localObject != null) {
            break label395;
          }
        }
        for (;;)
        {
          if (this.g.c()) {
            if (parama2.g != null)
            {
              if (parama2.a != null) {
                this.a.a(this.g.g, parama2);
              }
              parama1 = parama2.g.getView();
              localObject = new com.google.android.gms.ads.internal.a.z(this.g.m, parama1);
              com.google.android.gms.ads.internal.s.b localb = bt.A.B;
              if (parama2.a()) {
                ((com.google.android.gms.ads.internal.a.z)localObject).a(parama2.g);
              }
            }
          }
          for (;;)
          {
            if (!parama2.u) {
              this.g.a(parama1);
            }
            return true;
            parama2.g.getAdWebViewClient().a(new z((com.google.android.gms.ads.internal.a.z)localObject, parama2));
            continue;
            parama1 = null;
            continue;
            parama1 = this.g;
            localObject = parama1.o;
            if (localObject != null)
            {
              if (parama2.a != null)
              {
                this.a.a(parama1.g, parama2, (View)localObject);
                parama1 = this.g.o;
              }
              else
              {
                parama1 = null;
              }
            }
            else {
              parama1 = null;
            }
          }
          label395:
          if (parama1 != null) {
            parama1.a((VideoOptionsParcel)localObject);
          }
        }
        label407:
        parama1 = null;
        break;
        if (this.g.d())
        {
          parama1 = com.google.android.gms.ads.internal.f.n.P;
          if (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(parama1)).booleanValue()) {}
        }
        else
        {
          a(parama2, false);
        }
      }
    }
    return false;
  }
  
  public final boolean b(AdRequestParcel paramAdRequestParcel)
  {
    this.k = false;
    this.i = null;
    boolean bool1 = paramAdRequestParcel.l;
    boolean bool3 = this.l;
    if (bool1 != bool3)
    {
      int i = paramAdRequestParcel.u;
      long l1 = paramAdRequestParcel.b;
      Bundle localBundle = paramAdRequestParcel.f;
      int j = paramAdRequestParcel.g;
      List localList = paramAdRequestParcel.j;
      boolean bool2 = paramAdRequestParcel.i;
      int m = paramAdRequestParcel.s;
      if (bool1)
      {
        bool1 = true;
        paramAdRequestParcel = new AdRequestParcel(i, l1, localBundle, j, localList, bool2, m, bool1, paramAdRequestParcel.o, paramAdRequestParcel.r, paramAdRequestParcel.k, paramAdRequestParcel.d, paramAdRequestParcel.n, paramAdRequestParcel.e, paramAdRequestParcel.c, paramAdRequestParcel.p, paramAdRequestParcel.q, paramAdRequestParcel.h, null, paramAdRequestParcel.t, paramAdRequestParcel.m);
      }
    }
    for (;;)
    {
      return super.b(paramAdRequestParcel);
      if (!bool3)
      {
        bool1 = false;
        break;
      }
      bool1 = true;
      break;
    }
  }
  
  final void d(com.google.android.gms.ads.internal.v.a parama)
  {
    if ((parama != null) && (!parama.q) && (this.g.b != null))
    {
      Object localObject = bt.A.e;
      bu localbu = this.g;
      if ((((com.google.android.gms.ads.internal.util.n)localObject).a(localbu.b, localbu.m)) && (this.g.b.getGlobalVisibleRect(new Rect(), null)))
      {
        if (parama != null)
        {
          localObject = parama.g;
          if ((localObject != null) && (((i)localObject).getAdWebViewClient() != null)) {
            parama.g.getAdWebViewClient().a(null);
          }
        }
        a(parama, false);
        parama.q = true;
      }
    }
  }
  
  public final bo m()
  {
    com.google.android.gms.common.internal.z.a("getVideoController must be called from the main thread.");
    Object localObject = this.g.h;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;
      if (localObject != null) {
        return ((i)localObject).getVideoController();
      }
    }
    return null;
  }
  
  public final void onGlobalLayout()
  {
    d(this.g.h);
  }
  
  public final void onScrollChanged()
  {
    d(this.g.h);
  }
  
  protected final void q()
  {
    Object localObject = this.g.h;
    if (localObject != null) {}
    for (localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;; localObject = null)
    {
      if ((!this.k) && (localObject != null)) {
        c((i)localObject);
      }
      super.q();
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */