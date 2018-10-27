package com.google.android.gms.ads.internal.x;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.cache.CacheEntryParcel;
import com.google.android.gms.ads.internal.cache.CacheOffering;
import com.google.android.gms.ads.internal.gmsg.ab;
import com.google.android.gms.ads.internal.gmsg.af;
import com.google.android.gms.ads.internal.gmsg.ag;
import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v;
import com.google.android.gms.ads.internal.w.b.r;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.ap;
import com.google.android.gms.ads.internal.webview.aq;
import com.google.android.gms.ads.internal.webview.ar;
import com.google.android.gms.ads.internal.webview.as;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.zxxz.GADUrlException;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends k
  implements ao
{
  private ViewTreeObserver.OnGlobalLayoutListener A;
  private ViewTreeObserver.OnScrollChangedListener B;
  public final com.google.android.gms.ads.internal.js.l a = new com.google.android.gms.ads.internal.js.l();
  public volatile boolean b;
  public com.google.android.gms.ads.internal.client.a c;
  public com.google.android.gms.ads.internal.gmsg.b d;
  public com.google.android.gms.ads.internal.overlay.k e;
  public com.google.android.gms.ads.internal.webview.i f;
  public ap g;
  public com.google.android.gms.ads.internal.gmsg.d h;
  public boolean i = false;
  public aq j;
  public q k;
  public final Object l = new Object();
  public com.google.android.gms.ads.internal.m.d m;
  public com.google.android.gms.ads.internal.m.l n;
  public ar o;
  public as p;
  public com.google.android.gms.ads.internal.safebrowsing.k q;
  public boolean r;
  private v t;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private boolean y;
  private View.OnAttachStateChangeListener z;
  
  private final WebResourceResponse d(l paraml)
  {
    Object localObject1 = new URL(paraml.c);
    int i1 = 0;
    i1 += 1;
    if (i1 <= 20)
    {
      Object localObject2 = ((URL)localObject1).openConnection();
      ((URLConnection)localObject2).setConnectTimeout(10000);
      ((URLConnection)localObject2).setReadTimeout(10000);
      Object localObject3 = paraml.a.entrySet().iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        ((URLConnection)localObject2).addRequestProperty((String)((Map.Entry)localObject4).getKey(), (String)((Map.Entry)localObject4).getValue());
      }
      if (!(localObject2 instanceof HttpURLConnection)) {
        throw new IOException("Invalid protocol.");
      }
      localObject3 = (HttpURLConnection)localObject2;
      bt.A.e.a(this.f.getContext(), this.f.getVersionInfo().a, (HttpURLConnection)localObject3);
      localObject2 = new com.google.android.gms.ads.internal.util.client.e();
      ((com.google.android.gms.ads.internal.util.client.e)localObject2).a((HttpURLConnection)localObject3, null);
      int i2 = ((HttpURLConnection)localObject3).getResponseCode();
      ((com.google.android.gms.ads.internal.util.client.e)localObject2).a((HttpURLConnection)localObject3, i2);
      if ((i2 >= 300) && (i2 < 400))
      {
        localObject4 = ((HttpURLConnection)localObject3).getHeaderField("Location");
        if (localObject4 == null) {
          throw new IOException("Missing Location header in redirect");
        }
        localObject2 = new URL((URL)localObject1, (String)localObject4);
        localObject1 = ((URL)localObject2).getProtocol();
        if (localObject1 == null)
        {
          com.google.android.gms.ads.internal.util.e.e("Protocol is null");
          return null;
        }
        if ((!((String)localObject1).equals("http")) && (!((String)localObject1).equals("https")))
        {
          paraml = String.valueOf(localObject1);
          if (paraml.length() == 0) {}
          for (paraml = new String("Unsupported scheme: ");; paraml = "Unsupported scheme: ".concat(paraml))
          {
            com.google.android.gms.ads.internal.util.e.e(paraml);
            return null;
          }
        }
        localObject1 = String.valueOf(localObject4);
        if (((String)localObject1).length() == 0) {}
        for (localObject1 = new String("Redirecting to ");; localObject1 = "Redirecting to ".concat((String)localObject1))
        {
          com.google.android.gms.ads.internal.util.e.b((String)localObject1);
          ((HttpURLConnection)localObject3).disconnect();
          localObject1 = localObject2;
          break;
        }
      }
      paraml = bt.A.e;
      return com.google.android.gms.ads.internal.util.n.a((HttpURLConnection)localObject3);
    }
    paraml = new StringBuilder(32);
    paraml.append("Too many redirects (");
    paraml.append(20);
    paraml.append(")");
    throw new IOException(paraml.toString());
  }
  
  private final void m()
  {
    ap localap = this.g;
    if (localap != null) {
      if (this.w) {
        break label50;
      }
    }
    for (;;)
    {
      if (this.v) {}
      label50:
      do
      {
        localap.a(this.v ^ true);
        this.g = null;
        this.f.l();
        return;
      } while (this.x <= 0);
    }
  }
  
  public final v a()
  {
    return this.t;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    com.google.android.gms.ads.internal.m.d locald = this.m;
    if (locald != null) {
      locald.b(paramInt1, paramInt2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.n.a(paramInt1, paramInt2);
    com.google.android.gms.ads.internal.m.d locald = this.m;
    if (locald != null) {
      locald.a(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void a(Uri paramUri)
  {
    this.a.b(paramUri);
  }
  
  final void a(View paramView, com.google.android.gms.ads.internal.safebrowsing.k paramk, int paramInt)
  {
    if ((paramk.b()) && (paramInt > 0))
    {
      paramk.a(paramView);
      if (paramk.b()) {
        com.google.android.gms.ads.internal.util.n.a.postDelayed(new c(this, paramView, paramk, paramInt), 100L);
      }
    }
  }
  
  public final void a(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    synchronized (this.l)
    {
      this.y = true;
      this.f.k();
      this.A = paramOnGlobalLayoutListener;
      this.B = paramOnScrollChangedListener;
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.client.a parama, com.google.android.gms.ads.internal.gmsg.b paramb, com.google.android.gms.ads.internal.overlay.k paramk, com.google.android.gms.ads.internal.gmsg.d paramd, q paramq, boolean paramBoolean, com.google.android.gms.ads.internal.gmsg.ac paramac, v paramv, com.google.android.gms.ads.internal.m.n paramn, com.google.android.gms.ads.internal.safebrowsing.k paramk1)
  {
    v localv = paramv;
    if (paramv == null) {
      localv = new v(this.f.getContext(), paramk1, null);
    }
    this.m = new com.google.android.gms.ads.internal.m.d(this.f, paramn);
    this.q = paramk1;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.by.a()).booleanValue()) {
      a("/adMetadata", new com.google.android.gms.ads.internal.gmsg.a(paramb));
    }
    a("/appEvent", new com.google.android.gms.ads.internal.gmsg.c(paramd));
    a("/backButton", com.google.android.gms.ads.internal.gmsg.f.a);
    a("/refresh", com.google.android.gms.ads.internal.gmsg.f.b);
    a("/canOpenURLs", com.google.android.gms.ads.internal.gmsg.f.d);
    a("/canOpenIntents", com.google.android.gms.ads.internal.gmsg.f.c);
    a("/click", com.google.android.gms.ads.internal.gmsg.f.e);
    a("/close", com.google.android.gms.ads.internal.gmsg.f.f);
    a("/customClose", com.google.android.gms.ads.internal.gmsg.f.h);
    a("/instrument", com.google.android.gms.ads.internal.gmsg.f.g);
    a("/delayPageLoaded", com.google.android.gms.ads.internal.gmsg.f.j);
    a("/delayPageClosed", com.google.android.gms.ads.internal.gmsg.f.i);
    a("/getLocationInfo", com.google.android.gms.ads.internal.gmsg.f.k);
    a("/httpTrack", com.google.android.gms.ads.internal.gmsg.f.l);
    a("/log", com.google.android.gms.ads.internal.gmsg.f.m);
    a("/mraid", new af(localv, this.m, paramn));
    a("/mraidLoaded", this.n);
    a("/open", new ag(localv, this.m));
    a("/precache", new r());
    a("/touch", com.google.android.gms.ads.internal.gmsg.f.p);
    a("/video", com.google.android.gms.ads.internal.gmsg.f.q);
    a("/videoMeta", com.google.android.gms.ads.internal.gmsg.f.r);
    paramv = bt.A.B;
    this.f.getContext();
    if (paramac != null) {
      a("/setInterstitialProperties", new ab(paramac));
    }
    this.c = parama;
    this.e = paramk;
    this.d = paramb;
    this.h = paramd;
    this.k = paramq;
    this.t = localv;
    this.i = paramBoolean;
  }
  
  public final void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    com.google.android.gms.ads.internal.overlay.k localk = null;
    boolean bool = this.f.f();
    if ((!bool) || (this.f.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = this.c;; locala = null)
    {
      if (!bool) {
        localk = this.e;
      }
      a(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, locala, localk, this.k, this.f.getVersionInfo()));
      return;
    }
  }
  
  public final void a(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Object localObject = this.m;
    if (localObject != null) {}
    for (boolean bool = ((com.google.android.gms.ads.internal.m.d)localObject).b();; bool = false)
    {
      localObject = bt.A.c;
      com.google.android.gms.ads.internal.overlay.i.a(this.f.getContext(), paramAdOverlayInfoParcel, bool ^ true);
      com.google.android.gms.ads.internal.safebrowsing.k localk = this.q;
      if (localk != null)
      {
        String str = paramAdOverlayInfoParcel.o;
        localObject = str;
        if (str == null)
        {
          paramAdOverlayInfoParcel = paramAdOverlayInfoParcel.b;
          localObject = str;
          if (paramAdOverlayInfoParcel != null) {
            localObject = paramAdOverlayInfoParcel.f;
          }
        }
        localk.a((String)localObject);
      }
      return;
    }
  }
  
  public final void a(ap paramap)
  {
    this.g = paramap;
  }
  
  public final void a(aq paramaq)
  {
    this.j = paramaq;
  }
  
  public final void a(ar paramar)
  {
    this.o = paramar;
  }
  
  public final void a(as paramas)
  {
    this.p = paramas;
  }
  
  public final void a(l paraml)
  {
    this.a.a(paraml.b);
  }
  
  public final void a(String paramString, u paramu)
  {
    this.a.a(paramString, paramu);
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final boolean b(l paraml)
  {
    Object localObject1 = String.valueOf(paraml.c);
    if (((String)localObject1).length() == 0) {}
    for (localObject1 = new String("AdWebView shouldOverrideUrlLoading: ");; localObject1 = "AdWebView shouldOverrideUrlLoading: ".concat((String)localObject1))
    {
      com.google.android.gms.ads.internal.util.e.a((String)localObject1);
      localObject1 = paraml.b;
      for (;;)
      {
        if ((this.a.a((Uri)localObject1)) || ((this.i) || (!this.f.getWebView().willNotDraw()))) {}
        try
        {
          Object localObject2 = this.f.getSpamSignalsUtil();
          if (localObject2 != null) {
            if (((com.google.android.gms.ads.internal.zxxz.aa)localObject2).b((Uri)localObject1))
            {
              localObject2 = ((com.google.android.gms.ads.internal.zxxz.aa)localObject2).a((Uri)localObject1, this.f.getContext(), this.f.getView(), this.f.getActivityContext());
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            localObject2 = this.t;
            if ((localObject2 == null) || (((v)localObject2).a())) {
              a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", ((Uri)localObject1).toString(), null, null, null, null, null));
            }
            for (;;)
            {
              return true;
              this.t.a(paraml.c);
            }
          }
          paraml = String.valueOf(paraml.c);
          if (paraml.length() == 0) {}
          for (paraml = new String("AdWebView unable to handle URL: ");; paraml = "AdWebView unable to handle URL: ".concat(paraml))
          {
            com.google.android.gms.ads.internal.util.e.e(paraml);
            break;
          }
          localObject2 = ((Uri)localObject1).getScheme();
          if (("http".equalsIgnoreCase((String)localObject2)) || ("https".equalsIgnoreCase((String)localObject2)))
          {
            localObject1 = this.c;
            if (localObject1 != null)
            {
              ((com.google.android.gms.ads.internal.client.a)localObject1).e();
              localObject1 = this.q;
              if (localObject1 != null) {
                ((com.google.android.gms.ads.internal.safebrowsing.k)localObject1).a(paraml.c);
              }
              this.c = null;
            }
            return false;
          }
        }
        catch (GADUrlException localGADUrlException)
        {
          str = String.valueOf(paraml.c);
          if (str.length() != 0) {
            break label341;
          }
        }
      }
      return true;
    }
    label341:
    for (String str = new String("Unable to append parameter to URL: ");; str = "Unable to append parameter to URL: ".concat(str))
    {
      com.google.android.gms.ads.internal.util.e.e(str);
      break;
    }
  }
  
  public final void bm_()
  {
    this.w = true;
    aq localaq = this.j;
    if (localaq != null)
    {
      localaq.a();
      this.j = null;
    }
    m();
  }
  
  public final WebResourceResponse c(l paraml)
  {
    Object localObject = this.q;
    if (localObject != null) {
      ((com.google.android.gms.ads.internal.safebrowsing.k)localObject).a(paraml.c, paraml.a, 1);
    }
    if ("mraid.js".equalsIgnoreCase(new File(paraml.c).getName()))
    {
      l();
      if (this.f.getAdSize().e()) {
        localObject = (String)com.google.android.gms.ads.internal.f.n.aX.a();
      }
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.n localn = bt.A.e;
      localObject = com.google.android.gms.ads.internal.util.n.c(this.f.getContext(), this.f.getVersionInfo().a, (String)localObject);
      if (localObject == null) {
        try
        {
          localObject = paraml.c;
          this.f.getContext();
          if (com.google.android.gms.ads.internal.s.c.a((String)localObject, this.r).equals(paraml.c))
          {
            localObject = CacheOffering.a(paraml.c);
            if (localObject == null) {}
            do
            {
              if ((!com.google.android.gms.ads.internal.util.client.e.b()) || (!((Boolean)com.google.android.gms.ads.internal.f.n.ak.a()).booleanValue())) {
                break;
              }
              return d(paraml);
              localObject = bt.A.k.a((CacheOffering)localObject);
            } while ((localObject == null) || (!((CacheEntryParcel)localObject).a()));
            paraml = new WebResourceResponse("", "", ((CacheEntryParcel)localObject).b());
            return paraml;
          }
        }
        catch (Exception paraml)
        {
          bt.A.i.a(paraml, "AdWebViewClient.interceptRequest");
          return null;
          paraml = d(paraml);
          return paraml;
          if (this.f.f())
          {
            localObject = (String)com.google.android.gms.ads.internal.f.n.aW.a();
          }
          else
          {
            localObject = (String)com.google.android.gms.ads.internal.f.n.aV.a();
            continue;
            localObject = null;
          }
        }
        catch (NoClassDefFoundError paraml)
        {
          for (;;) {}
        }
      }
    }
    return (WebResourceResponse)localObject;
    return null;
  }
  
  public final boolean c()
  {
    synchronized (this.l)
    {
      boolean bool = this.y;
      return bool;
    }
  }
  
  public final ViewTreeObserver.OnGlobalLayoutListener d()
  {
    synchronized (this.l)
    {
      ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = this.A;
      return localOnGlobalLayoutListener;
    }
  }
  
  public final ViewTreeObserver.OnScrollChangedListener e()
  {
    synchronized (this.l)
    {
      ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = this.B;
      return localOnScrollChangedListener;
    }
  }
  
  public final boolean f()
  {
    synchronized (this.l)
    {
      boolean bool = this.u;
      return bool;
    }
  }
  
  public final void g()
  {
    com.google.android.gms.ads.internal.safebrowsing.k localk = this.q;
    if (localk != null)
    {
      WebView localWebView = this.f.getWebView();
      if (android.support.v4.view.ac.L(localWebView)) {
        a(localWebView, localk, 10);
      }
    }
    else
    {
      return;
    }
    k();
    this.z = new d(this, localk);
    this.f.getView().addOnAttachStateChangeListener(this.z);
  }
  
  public final void h()
  {
    synchronized (this.l)
    {
      this.u = true;
      this.x += 1;
      m();
      return;
    }
  }
  
  public final void i()
  {
    this.x -= 1;
    m();
  }
  
  public final void j()
  {
    this.v = true;
    m();
  }
  
  final void k()
  {
    if (this.z != null) {
      this.f.getView().removeOnAttachStateChangeListener(this.z);
    }
  }
  
  public final void l()
  {
    synchronized (this.l)
    {
      this.i = false;
      this.b = true;
      com.google.android.gms.ads.internal.util.a.aa.b.execute(new b(this));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */