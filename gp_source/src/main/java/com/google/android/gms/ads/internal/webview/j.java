package com.google.android.gms.ads.internal.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.cache.CacheEntryParcel;
import com.google.android.gms.ads.internal.cache.CacheOffering;
import com.google.android.gms.ads.internal.d.g;
import com.google.android.gms.ads.internal.gmsg.ab;
import com.google.android.gms.ads.internal.gmsg.af;
import com.google.android.gms.ads.internal.gmsg.ag;
import com.google.android.gms.ads.internal.gmsg.b;
import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.w.b.r;
import com.google.android.gms.ads.internal.zxxz.GADUrlException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

@com.google.android.gms.ads.internal.q.a.a
public class j
  extends WebViewClient
  implements ao
{
  private static final String[] n = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] o = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private final com.google.android.gms.ads.internal.m.l A;
  private View.OnAttachStateChangeListener B;
  private ViewTreeObserver.OnGlobalLayoutListener C;
  private ViewTreeObserver.OnScrollChangedListener D;
  public com.google.android.gms.ads.internal.client.a a;
  public b b;
  public com.google.android.gms.ads.internal.overlay.k c;
  public i d;
  public com.google.android.gms.ads.internal.gmsg.d e;
  public boolean f = false;
  public final HashMap g = new HashMap();
  public q h;
  public final Object i = new Object();
  public ar j;
  public as k;
  public com.google.android.gms.ads.internal.safebrowsing.k l;
  public boolean m;
  private final com.google.android.gms.ads.internal.d.a p;
  private ap q;
  private com.google.android.gms.ads.internal.v r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private boolean x;
  private aq y;
  private com.google.android.gms.ads.internal.m.d z;
  
  public j(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean)
  {
    this(parami, parama, paramBoolean, new com.google.android.gms.ads.internal.m.l(parami, parami.getOriginalContext(), new com.google.android.gms.ads.internal.e.a(parami.getContext())));
  }
  
  private j(i parami, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean, com.google.android.gms.ads.internal.m.l paraml)
  {
    this.p = parama;
    this.d = parami;
    this.t = paramBoolean;
    this.A = paraml;
    this.z = null;
  }
  
  private final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.cw.a()).booleanValue())
    {
      localBundle = new Bundle();
      localBundle.putString("err", paramString1);
      localBundle.putString("code", paramString2);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = Uri.parse(paramString3);
        if (paramString1.getHost() != null) {
          break label101;
        }
      }
    }
    label101:
    for (paramString1 = "";; paramString1 = paramString1.getHost())
    {
      localBundle.putString("host", paramString1);
      paramString1 = bt.A.e;
      com.google.android.gms.ads.internal.util.n.a(paramContext, this.d.getVersionInfo().a, "gmob-apps", localBundle, true);
      return;
    }
  }
  
  private final WebResourceResponse b(String paramString, Map paramMap)
  {
    paramString = new URL(paramString);
    int i1 = 0;
    i1 += 1;
    if (i1 <= 20)
    {
      Object localObject1 = paramString.openConnection();
      ((URLConnection)localObject1).setConnectTimeout(10000);
      ((URLConnection)localObject1).setReadTimeout(10000);
      Object localObject2 = paramMap.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((URLConnection)localObject1).addRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
      if (!(localObject1 instanceof HttpURLConnection)) {
        throw new IOException("Invalid protocol.");
      }
      localObject2 = (HttpURLConnection)localObject1;
      bt.A.e.a(this.d.getContext(), this.d.getVersionInfo().a, (HttpURLConnection)localObject2);
      localObject1 = new com.google.android.gms.ads.internal.util.client.e();
      ((com.google.android.gms.ads.internal.util.client.e)localObject1).a((HttpURLConnection)localObject2, null);
      int i2 = ((HttpURLConnection)localObject2).getResponseCode();
      ((com.google.android.gms.ads.internal.util.client.e)localObject1).a((HttpURLConnection)localObject2, i2);
      if ((i2 >= 300) && (i2 < 400))
      {
        localObject3 = ((HttpURLConnection)localObject2).getHeaderField("Location");
        if (localObject3 == null) {
          throw new IOException("Missing Location header in redirect");
        }
        localObject1 = new URL(paramString, (String)localObject3);
        paramString = ((URL)localObject1).getProtocol();
        if (paramString == null)
        {
          com.google.android.gms.ads.internal.util.e.e("Protocol is null");
          return null;
        }
        if ((!paramString.equals("http")) && (!paramString.equals("https")))
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {}
          for (paramString = new String("Unsupported scheme: ");; paramString = "Unsupported scheme: ".concat(paramString))
          {
            com.google.android.gms.ads.internal.util.e.e(paramString);
            return null;
          }
        }
        paramString = String.valueOf(localObject3);
        if (paramString.length() == 0) {}
        for (paramString = new String("Redirecting to ");; paramString = "Redirecting to ".concat(paramString))
        {
          com.google.android.gms.ads.internal.util.e.b(paramString);
          ((HttpURLConnection)localObject2).disconnect();
          paramString = (String)localObject1;
          break;
        }
      }
      paramString = bt.A.e;
      return com.google.android.gms.ads.internal.util.n.a((HttpURLConnection)localObject2);
    }
    paramString = new StringBuilder(32);
    paramString.append("Too many redirects (");
    paramString.append(20);
    paramString.append(")");
    throw new IOException(paramString.toString());
  }
  
  private final void m()
  {
    if (this.B != null) {
      this.d.getView().removeOnAttachStateChangeListener(this.B);
    }
  }
  
  private final void n()
  {
    ap localap = this.q;
    if (localap != null) {
      if (this.v) {
        break label50;
      }
    }
    for (;;)
    {
      if (this.u) {}
      label50:
      do
      {
        localap.a(this.u ^ true);
        this.q = null;
        this.d.l();
        return;
      } while (this.w <= 0);
    }
  }
  
  protected final WebResourceResponse a(String paramString, Map paramMap)
  {
    try
    {
      this.d.getContext();
      localObject = com.google.android.gms.ads.internal.s.c.a(paramString, this.m);
      if (((String)localObject).equals(paramString))
      {
        localObject = CacheOffering.a(paramString);
        if (localObject == null) {}
        while ((com.google.android.gms.ads.internal.util.client.e.b()) && (((Boolean)com.google.android.gms.ads.internal.f.n.ak.a()).booleanValue()))
        {
          return b(paramString, paramMap);
          localObject = bt.A.k.a((CacheOffering)localObject);
          if ((localObject != null) && (((CacheEntryParcel)localObject).a()))
          {
            paramString = new WebResourceResponse("", "", ((CacheEntryParcel)localObject).b());
            return paramString;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      bt.A.i.a(paramString, "AdWebViewClient.interceptRequest");
      return null;
      paramString = b((String)localObject, paramMap);
      return paramString;
    }
    catch (NoClassDefFoundError paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final com.google.android.gms.ads.internal.v a()
  {
    return this.r;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    com.google.android.gms.ads.internal.m.d locald = this.z;
    if (locald != null) {
      locald.b(paramInt1, paramInt2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.A.a(paramInt1, paramInt2);
    com.google.android.gms.ads.internal.m.d locald = this.z;
    if (locald != null) {
      locald.a(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void a(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    Object localObject1 = (List)this.g.get(str1);
    if (localObject1 != null)
    {
      Object localObject2 = bt.A.e;
      localObject2 = com.google.android.gms.ads.internal.util.n.a(paramUri);
      if (com.google.android.gms.ads.internal.util.e.a(2))
      {
        paramUri = String.valueOf(str1);
        if (paramUri.length() == 0) {}
        for (paramUri = new String("Received GMSG: ");; paramUri = "Received GMSG: ".concat(paramUri))
        {
          com.google.android.gms.ads.internal.util.e.a(paramUri);
          paramUri = ((Map)localObject2).keySet().iterator();
          while (paramUri.hasNext())
          {
            str1 = (String)paramUri.next();
            String str2 = (String)((Map)localObject2).get(str1);
            StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 4 + String.valueOf(str2).length());
            localStringBuilder.append("  ");
            localStringBuilder.append(str1);
            localStringBuilder.append(": ");
            localStringBuilder.append(str2);
            com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
          }
        }
      }
      paramUri = ((List)localObject1).iterator();
      while (paramUri.hasNext()) {
        ((u)paramUri.next()).a(this.d, (Map)localObject2);
      }
    }
    paramUri = String.valueOf(paramUri);
    localObject1 = new StringBuilder(String.valueOf(paramUri).length() + 32);
    ((StringBuilder)localObject1).append("No GMSG handler found for GMSG: ");
    ((StringBuilder)localObject1).append(paramUri);
    com.google.android.gms.ads.internal.util.e.a(((StringBuilder)localObject1).toString());
  }
  
  final void a(View paramView, com.google.android.gms.ads.internal.safebrowsing.k paramk, int paramInt)
  {
    if ((paramk.b()) && (paramInt > 0))
    {
      paramk.a(paramView);
      if (paramk.b()) {
        com.google.android.gms.ads.internal.util.n.a.postDelayed(new l(this, paramView, paramk, paramInt), 100L);
      }
    }
  }
  
  public final void a(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    synchronized (this.i)
    {
      this.x = true;
      this.d.k();
      this.C = paramOnGlobalLayoutListener;
      this.D = paramOnScrollChangedListener;
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.client.a parama, b paramb, com.google.android.gms.ads.internal.overlay.k paramk, com.google.android.gms.ads.internal.gmsg.d paramd, q paramq, boolean paramBoolean, com.google.android.gms.ads.internal.gmsg.ac paramac, com.google.android.gms.ads.internal.v paramv, com.google.android.gms.ads.internal.m.n paramn, com.google.android.gms.ads.internal.safebrowsing.k paramk1)
  {
    com.google.android.gms.ads.internal.v localv = paramv;
    if (paramv == null) {
      localv = new com.google.android.gms.ads.internal.v(this.d.getContext(), paramk1, null);
    }
    this.z = new com.google.android.gms.ads.internal.m.d(this.d, paramn);
    this.l = paramk1;
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
    a("/mraid", new af(localv, this.z, paramn));
    a("/mraidLoaded", this.A);
    a("/open", new ag(localv, this.z));
    a("/precache", new r());
    a("/touch", com.google.android.gms.ads.internal.gmsg.f.p);
    a("/video", com.google.android.gms.ads.internal.gmsg.f.q);
    a("/videoMeta", com.google.android.gms.ads.internal.gmsg.f.r);
    paramv = bt.A.B;
    this.d.getContext();
    if (paramac != null) {
      a("/setInterstitialProperties", new ab(paramac));
    }
    this.a = parama;
    this.c = paramk;
    this.b = paramb;
    this.e = paramd;
    this.h = paramq;
    this.r = localv;
    this.f = paramBoolean;
  }
  
  public final void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    com.google.android.gms.ads.internal.overlay.k localk = null;
    boolean bool = this.d.f();
    if ((!bool) || (this.d.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = this.a;; locala = null)
    {
      if (!bool) {
        localk = this.c;
      }
      a(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, locala, localk, this.h, this.d.getVersionInfo()));
      return;
    }
  }
  
  public final void a(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Object localObject = this.z;
    if (localObject != null) {}
    for (boolean bool = ((com.google.android.gms.ads.internal.m.d)localObject).b();; bool = false)
    {
      localObject = bt.A.c;
      com.google.android.gms.ads.internal.overlay.i.a(this.d.getContext(), paramAdOverlayInfoParcel, bool ^ true);
      com.google.android.gms.ads.internal.safebrowsing.k localk = this.l;
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
    this.q = paramap;
  }
  
  public final void a(aq paramaq)
  {
    this.y = paramaq;
  }
  
  public final void a(ar paramar)
  {
    this.j = paramar;
  }
  
  public final void a(as paramas)
  {
    this.k = paramas;
  }
  
  public final void a(String paramString, u paramu)
  {
    synchronized (this.i)
    {
      List localList = (List)this.g.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.g.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramu);
      return;
    }
  }
  
  public final boolean b()
  {
    synchronized (this.i)
    {
      boolean bool = this.t;
      return bool;
    }
  }
  
  public final boolean c()
  {
    synchronized (this.i)
    {
      boolean bool = this.x;
      return bool;
    }
  }
  
  public final ViewTreeObserver.OnGlobalLayoutListener d()
  {
    synchronized (this.i)
    {
      ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = this.C;
      return localOnGlobalLayoutListener;
    }
  }
  
  public final ViewTreeObserver.OnScrollChangedListener e()
  {
    synchronized (this.i)
    {
      ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = this.D;
      return localOnScrollChangedListener;
    }
  }
  
  public final boolean f()
  {
    synchronized (this.i)
    {
      boolean bool = this.s;
      return bool;
    }
  }
  
  public final void g()
  {
    com.google.android.gms.ads.internal.safebrowsing.k localk = this.l;
    if (localk != null)
    {
      WebView localWebView = this.d.getWebView();
      if (android.support.v4.view.ac.L(localWebView)) {
        a(localWebView, localk, 10);
      }
    }
    else
    {
      return;
    }
    m();
    this.B = new m(this, localk);
    this.d.getView().addOnAttachStateChangeListener(this.B);
  }
  
  public final void h()
  {
    synchronized (this.i)
    {
      this.s = true;
      this.w += 1;
      n();
      return;
    }
  }
  
  public final void i()
  {
    this.w -= 1;
    n();
  }
  
  public final void j()
  {
    this.u = true;
    n();
  }
  
  public final void k()
  {
    ??? = this.l;
    if (??? != null)
    {
      ((com.google.android.gms.ads.internal.safebrowsing.k)???).d();
      this.l = null;
    }
    m();
    synchronized (this.i)
    {
      this.g.clear();
      this.a = null;
      this.c = null;
      this.q = null;
      this.y = null;
      this.b = null;
      this.e = null;
      this.f = false;
      this.t = false;
      this.x = false;
      this.s = false;
      this.h = null;
      this.j = null;
      com.google.android.gms.ads.internal.m.d locald = this.z;
      if (locald != null)
      {
        locald.a(true);
        this.z = null;
      }
      return;
    }
  }
  
  public final void l()
  {
    synchronized (this.i)
    {
      this.f = false;
      this.t = true;
      com.google.android.gms.ads.internal.util.a.aa.b.execute(new k(this));
      return;
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() == 0) {}
    for (paramWebView = new String("Loading resource: ");; paramWebView = "Loading resource: ".concat(paramWebView))
    {
      com.google.android.gms.ads.internal.util.e.a(paramWebView);
      paramWebView = Uri.parse(paramString);
      if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
        a(paramWebView);
      }
      return;
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (this.i)
    {
      if (this.d.g())
      {
        com.google.android.gms.ads.internal.util.e.a("Blank page loaded, 1...");
        this.d.h();
        return;
      }
      this.v = true;
      ??? = this.y;
      if (??? != null)
      {
        ???.a();
        this.y = null;
      }
      n();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    int i1;
    if (paramInt < 0)
    {
      i1 = -paramInt - 1;
      if (i1 >= n.length) {}
    }
    for (String str = n[i1];; str = String.valueOf(paramInt))
    {
      a(this.d.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i1;
    if (paramSslError != null)
    {
      i1 = paramSslError.getPrimaryError();
      if ((i1 < 0) || (i1 >= o.length)) {
        break label68;
      }
    }
    label68:
    for (String str = o[i1];; str = String.valueOf(i1))
    {
      a(this.d.getContext(), "ssl_err", str, bt.A.g.a(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    paramRenderProcessGoneDetail = this.p;
    if (paramRenderProcessGoneDetail != null) {
      paramRenderProcessGoneDetail.a(g.h);
    }
    if ((paramWebView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramWebView.getParent()).removeView(paramWebView);
    }
    paramWebView.destroy();
    return true;
  }
  
  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramString, Collections.emptyMap());
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = String.valueOf(paramString);
    if (((String)localObject).length() == 0) {}
    for (localObject = new String("AdWebView shouldOverrideUrlLoading: ");; localObject = "AdWebView shouldOverrideUrlLoading: ".concat((String)localObject))
    {
      com.google.android.gms.ads.internal.util.e.a((String)localObject);
      localObject = Uri.parse(paramString);
      if (("gmsg".equalsIgnoreCase(((Uri)localObject).getScheme())) && ("mobileads.google.com".equalsIgnoreCase(((Uri)localObject).getHost()))) {
        a((Uri)localObject);
      }
      for (;;)
      {
        return true;
        label85:
        if (((this.f) && (paramWebView == this.d.getWebView())) || (!this.d.getWebView().willNotDraw())) {}
        try
        {
          paramWebView = this.d.getSpamSignalsUtil();
          if (paramWebView != null) {
            if (paramWebView.b((Uri)localObject)) {
              paramWebView = paramWebView.a((Uri)localObject, this.d.getContext(), this.d.getView(), this.d.getActivityContext());
            }
          }
          for (;;)
          {
            localObject = this.r;
            if ((localObject == null) || (((com.google.android.gms.ads.internal.v)localObject).a()))
            {
              a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
              break;
            }
            this.r.a(paramString);
            break;
            paramWebView = (WebView)localObject;
            continue;
            paramWebView = (WebView)localObject;
          }
          paramWebView = String.valueOf(paramString);
          if (paramWebView.length() == 0) {}
          for (paramWebView = new String("AdWebView unable to handle URL: ");; paramWebView = "AdWebView unable to handle URL: ".concat(paramWebView))
          {
            com.google.android.gms.ads.internal.util.e.e(paramWebView);
            break;
          }
          String str = ((Uri)localObject).getScheme();
          if ((!"http".equalsIgnoreCase(str)) && (!"https".equalsIgnoreCase(str))) {
            break label85;
          }
          localObject = this.a;
          if (localObject != null)
          {
            ((com.google.android.gms.ads.internal.client.a)localObject).e();
            localObject = this.l;
            if (localObject != null) {
              ((com.google.android.gms.ads.internal.safebrowsing.k)localObject).a(paramString);
            }
            this.a = null;
          }
          return super.shouldOverrideUrlLoading(paramWebView, paramString);
        }
        catch (GADUrlException paramWebView)
        {
          paramWebView = String.valueOf(paramString);
          if (paramWebView.length() != 0) {
            break label374;
          }
        }
      }
    }
    label374:
    for (paramWebView = new String("Unable to append parameter to URL: ");; paramWebView = "Unable to append parameter to URL: ".concat(paramWebView))
    {
      com.google.android.gms.ads.internal.util.e.e(paramWebView);
      paramWebView = (WebView)localObject;
      break;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */