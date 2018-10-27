package com.google.android.gms.ads.internal.x;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.a.ac;
import com.google.android.gms.ads.internal.bm;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.formats.r;
import com.google.android.gms.ads.internal.gmsg.d;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.af;
import com.google.android.gms.ads.internal.util.bv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.w.t;
import com.google.android.gms.ads.internal.webview.as;
import com.google.android.gms.ads.internal.webview.at;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.w;
import com.google.android.gms.ads.internal.webview.z;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
final class h
  extends m
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, com.google.android.gms.ads.internal.js.h, com.google.android.gms.ads.internal.webview.i
{
  private int A = -1;
  private AdOverlay B;
  private boolean C = true;
  private boolean D = false;
  private au E;
  private final aa F;
  private com.google.android.gms.ads.internal.g.k G;
  private final VersionInfoParcel H;
  private w I;
  private Map J;
  private final WindowManager K;
  private final a L;
  public int a;
  private final at b;
  private float c;
  private AdOverlay d;
  private com.google.android.gms.ads.internal.g.j e;
  private com.google.android.gms.ads.internal.g.j f;
  private com.google.android.gms.ads.internal.g.j g;
  private boolean h;
  private int i;
  private final com.google.android.gms.ads.internal.u j;
  private String k;
  private com.google.android.gms.ads.internal.formats.e l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private int q = -1;
  private int r = -1;
  private r s;
  private final AtomicReference t = new AtomicReference();
  private WeakReference u;
  private bv v;
  private final bm w;
  private String x = "";
  private int y;
  private int z = -1;
  
  protected h(at paramat, a parama, au paramau, String paramString, boolean paramBoolean, aa paramaa, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.g.l paraml, bm parambm, com.google.android.gms.ads.internal.u paramu)
  {
    super(paramat, parama);
    this.b = paramat;
    this.L = parama;
    this.E = paramau;
    this.k = paramString;
    this.n = paramBoolean;
    this.y = -1;
    this.F = paramaa;
    this.H = paramVersionInfoParcel;
    this.w = parambm;
    this.j = paramu;
    this.K = ((WindowManager)getContext().getSystemService("window"));
    this.v = new bv(getActivityContext(), this, this, null);
    bt.A.e.a(paramat, paramVersionInfoParcel.a, getSettings());
    setDownloadListener(this);
    this.c = paramat.getResources().getDisplayMetrics().density;
    s();
    if (com.google.android.gms.common.util.h.a()) {
      addJavascriptInterface(z.a(this), "googleAdsJsInterface");
    }
    w();
    this.G = new com.google.android.gms.ads.internal.g.k(new com.google.android.gms.ads.internal.g.l(true, "make_wv", this.k));
    this.G.b.a(paraml);
    this.e = com.google.android.gms.ads.internal.g.e.a(this.G.b);
    this.G.a("native:view_create", this.e);
    this.f = null;
    this.g = null;
    bt.A.g.b(paramat);
  }
  
  private final void c(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("isVisible", str);
      com.google.android.gms.ads.internal.js.i.a(this, "onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  private final boolean q()
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject1;
    Object localObject2;
    int i3;
    int i4;
    int i2;
    int i1;
    if (!((a)getAdWebViewClient()).b())
    {
      bool1 = bool2;
      if (!((a)getAdWebViewClient()).c()) {}
    }
    else
    {
      localObject1 = bt.A.e;
      localObject1 = com.google.android.gms.ads.internal.util.n.a(this.K);
      localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
      i3 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, ((DisplayMetrics)localObject1).widthPixels);
      localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
      i4 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, ((DisplayMetrics)localObject1).heightPixels);
      localObject2 = getActivityContext();
      if (localObject2 != null) {
        break label233;
      }
      i2 = i4;
      i1 = i3;
    }
    for (;;)
    {
      int i5 = this.A;
      if ((i5 == i3) && (this.z == i4) && (this.r == i1))
      {
        bool1 = bool2;
        if (this.q == i2) {}
      }
      else
      {
        if (i5 != i3) {
          break label227;
        }
        if (this.z != i4) {
          break label221;
        }
        bool1 = false;
      }
      for (;;)
      {
        this.A = i3;
        this.z = i4;
        this.r = i1;
        this.q = i2;
        new com.google.android.gms.ads.internal.m.m(this).a(i3, i4, i1, i2, ((DisplayMetrics)localObject1).density, this.K.getDefaultDisplay().getRotation());
        return bool1;
        label221:
        bool1 = true;
        continue;
        label227:
        bool1 = true;
      }
      label233:
      if (((Activity)localObject2).getWindow() != null)
      {
        Object localObject3 = bt.A.e;
        localObject2 = com.google.android.gms.ads.internal.util.n.a((Activity)localObject2);
        localObject3 = com.google.android.gms.ads.internal.client.u.h.a;
        i1 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, localObject2[0]);
        localObject3 = com.google.android.gms.ads.internal.client.u.h.a;
        i2 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, localObject2[1]);
      }
      else
      {
        i2 = i4;
        i1 = i3;
      }
    }
  }
  
  private final void r()
  {
    com.google.android.gms.ads.internal.g.e.a(this.G.b, this.e, new String[] { "aeh2" });
  }
  
  private final void s()
  {
    for (;;)
    {
      try
      {
        if ((this.n) || (this.E.e()))
        {
          com.google.android.gms.ads.internal.util.e.b("Enabling hardware acceleration on an overlay.");
          u();
          return;
        }
        if (Build.VERSION.SDK_INT < 18)
        {
          com.google.android.gms.ads.internal.util.e.b("Disabling hardware acceleration on an AdView.");
          t();
          continue;
        }
        com.google.android.gms.ads.internal.util.e.b("Enabling hardware acceleration on an AdView.");
      }
      finally {}
      u();
    }
  }
  
  private final void t()
  {
    try
    {
      if (!this.o) {
        bt.A.g.c(this);
      }
      this.o = true;
      return;
    }
    finally {}
  }
  
  private final void u()
  {
    try
    {
      if (this.o) {
        bt.A.g.b(this);
      }
      this.o = false;
      return;
    }
    finally {}
  }
  
  private final void v()
  {
    try
    {
      Object localObject1 = this.J;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.google.android.gms.ads.internal.w.b.k)((Iterator)localObject1).next()).b();
        }
      }
      this.J = null;
    }
    finally {}
  }
  
  private final void w()
  {
    Object localObject = this.G;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.g.k)localObject).b;
      if ((localObject != null) && (bt.A.i.a() != null)) {
        bt.A.i.a().a((com.google.android.gms.ads.internal.g.l)localObject);
      }
    }
  }
  
  public final void Q()
  {
    try
    {
      this.D = true;
      bm localbm = this.w;
      if (localbm != null) {
        localbm.Q();
      }
      return;
    }
    finally {}
  }
  
  public final void R()
  {
    try
    {
      this.D = false;
      bm localbm = this.w;
      if (localbm != null) {
        localbm.R();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final com.google.android.gms.ads.internal.w.b.k a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 378	com/google/android/gms/ads/internal/x/h:J	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_1
    //   13: invokeinterface 427 2 0
    //   18: checkcast 399	com/google/android/gms/ads/internal/w/b/k
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aconst_null
    //   27: astore_1
    //   28: goto -6 -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	h
    //   0	36	1	paramString	String
    //   6	6	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	22	31	finally
  }
  
  public final void a()
  {
    AdOverlay localAdOverlay = getAdOverlay();
    if (localAdOverlay != null) {
      localAdOverlay.p();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 0) {
      com.google.android.gms.ads.internal.g.e.a(this.G.b, this.e, new String[] { "aebb2" });
    }
    r();
    Object localObject = this.G.b;
    if (localObject != null) {
      ((com.google.android.gms.ads.internal.g.l)localObject).a("close_type", String.valueOf(paramInt));
    }
    localObject = new HashMap(2);
    ((HashMap)localObject).put("closetype", String.valueOf(paramInt));
    ((HashMap)localObject).put("version", this.H.a);
    com.google.android.gms.ads.internal.js.i.a(this, "onhide", (Map)localObject);
  }
  
  public final void a(ac paramac)
  {
    try
    {
      this.m = paramac.f;
      c(paramac.f);
      return;
    }
    finally {}
  }
  
  public final void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    this.L.a(paramAdLauncherIntentInfoParcel);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    a locala = this.L;
    if (locala != null) {
      locala.a(paramString, paramu);
    }
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.w.b.k paramk)
  {
    try
    {
      if (this.J == null) {
        this.J = new HashMap();
      }
      this.J.put(paramString, paramk);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, com.google.android.gms.common.util.i parami)
  {
    a locala = this.L;
    if (locala != null) {
      locala.a.a(paramString, parami);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    com.google.android.gms.ads.internal.js.i.a(this, paramString1, paramString2);
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 492	com/google/android/gms/ads/internal/f/n:aH	Lcom/google/android/gms/ads/internal/f/c;
    //   5: invokevirtual 496	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   8: checkcast 498	java/lang/Boolean
    //   11: invokevirtual 501	java/lang/Boolean:booleanValue	()Z
    //   14: ifeq +34 -> 48
    //   17: aload_2
    //   18: iconst_1
    //   19: anewarray 340	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: invokestatic 506	com/google/android/gms/ads/internal/webview/aj:a	()Ljava/lang/String;
    //   27: aastore
    //   28: invokestatic 509	com/google/android/gms/ads/internal/webview/aj:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: ldc_w 511
    //   38: ldc_w 513
    //   41: aload_3
    //   42: invokespecial 517	com/google/android/gms/ads/internal/x/m:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: goto -16 -> 32
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	h
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    //   0	56	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	32	51	finally
    //   32	45	51	finally
  }
  
  public final void a(String paramString, Map paramMap)
  {
    com.google.android.gms.ads.internal.js.i.a(this, paramString, paramMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    com.google.android.gms.ads.internal.js.i.b(this, paramString, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    ((a)getAdWebViewClient()).r = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    a locala1 = this.L;
    if ((!locala1.f.f()) || (locala1.f.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = locala1.c;; locala = null)
    {
      com.google.android.gms.ads.internal.overlay.k localk = locala1.e;
      q localq = locala1.k;
      com.google.android.gms.ads.internal.webview.i locali = locala1.f;
      locala1.a(new AdOverlayInfoParcel(locala, localk, localq, locali, paramBoolean, paramInt, locali.getVersionInfo()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    e locale = null;
    a locala1 = this.L;
    boolean bool = locala1.f.f();
    if ((!bool) || (locala1.f.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = locala1.c;; locala = null)
    {
      if (!bool) {
        locale = new e(locala1.f, locala1.e);
      }
      com.google.android.gms.ads.internal.gmsg.b localb = locala1.d;
      d locald = locala1.h;
      q localq = locala1.k;
      com.google.android.gms.ads.internal.webview.i locali = locala1.f;
      locala1.a(new AdOverlayInfoParcel(locala, locale, localb, locald, localq, locali, paramBoolean, paramInt, paramString, locali.getVersionInfo()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    a locala1 = this.L;
    boolean bool = locala1.f.f();
    if ((!bool) || (locala1.f.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = locala1.c;; locala = null)
    {
      if (!bool) {}
      for (e locale = new e(locala1.f, locala1.e);; locale = null)
      {
        com.google.android.gms.ads.internal.gmsg.b localb = locala1.d;
        d locald = locala1.h;
        q localq = locala1.k;
        com.google.android.gms.ads.internal.webview.i locali = locala1.f;
        locala1.a(new AdOverlayInfoParcel(locala, locale, localb, locald, localq, locali, paramBoolean, paramInt, paramString1, paramString2, locali.getVersionInfo()));
        return;
      }
    }
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap(2);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("success", str);
      localHashMap.put("duration", Long.toString(paramLong));
      com.google.android.gms.ads.internal.js.i.a(this, "onCacheAccessComplete", localHashMap);
      return;
    }
  }
  
  public final void b()
  {
    try
    {
      com.google.android.gms.ads.internal.formats.e locale = this.l;
      if (locale != null) {
        locale.a();
      }
      return;
    }
    finally {}
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    a locala = this.L;
    if (locala != null) {
      locala.a.b(paramString, paramu);
    }
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    com.google.android.gms.ads.internal.js.i.a(this, paramString, paramJSONObject);
  }
  
  /* Error */
  protected final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +145 -> 148
    //   6: aload_0
    //   7: getfield 91	com/google/android/gms/ads/internal/x/h:t	Ljava/util/concurrent/atomic/AtomicReference;
    //   10: aconst_null
    //   11: invokevirtual 601	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 103	com/google/android/gms/ads/internal/x/h:L	Lcom/google/android/gms/ads/internal/x/a;
    //   18: astore_2
    //   19: aload_2
    //   20: getfield 604	com/google/android/gms/ads/internal/x/a:q	Lcom/google/android/gms/ads/internal/safebrowsing/k;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +14 -> 39
    //   28: aload_3
    //   29: invokeinterface 608 1 0
    //   34: aload_2
    //   35: aconst_null
    //   36: putfield 604	com/google/android/gms/ads/internal/x/a:q	Lcom/google/android/gms/ads/internal/safebrowsing/k;
    //   39: aload_2
    //   40: invokevirtual 610	com/google/android/gms/ads/internal/x/a:k	()V
    //   43: aload_2
    //   44: getfield 478	com/google/android/gms/ads/internal/x/a:a	Lcom/google/android/gms/ads/internal/js/l;
    //   47: invokevirtual 612	com/google/android/gms/ads/internal/js/l:c	()V
    //   50: aload_2
    //   51: getfield 478	com/google/android/gms/ads/internal/x/a:a	Lcom/google/android/gms/ads/internal/js/l;
    //   54: aconst_null
    //   55: putfield 615	com/google/android/gms/ads/internal/js/l:c	Ljava/lang/Object;
    //   58: aload_2
    //   59: getfield 617	com/google/android/gms/ads/internal/x/a:l	Ljava/lang/Object;
    //   62: astore_3
    //   63: aload_3
    //   64: monitorenter
    //   65: aload_2
    //   66: aconst_null
    //   67: putfield 537	com/google/android/gms/ads/internal/x/a:c	Lcom/google/android/gms/ads/internal/client/a;
    //   70: aload_2
    //   71: aconst_null
    //   72: putfield 540	com/google/android/gms/ads/internal/x/a:e	Lcom/google/android/gms/ads/internal/overlay/k;
    //   75: aload_2
    //   76: aconst_null
    //   77: putfield 620	com/google/android/gms/ads/internal/x/a:g	Lcom/google/android/gms/ads/internal/webview/ap;
    //   80: aload_2
    //   81: aconst_null
    //   82: putfield 623	com/google/android/gms/ads/internal/x/a:j	Lcom/google/android/gms/ads/internal/webview/aq;
    //   85: aload_2
    //   86: aconst_null
    //   87: putfield 564	com/google/android/gms/ads/internal/x/a:d	Lcom/google/android/gms/ads/internal/gmsg/b;
    //   90: aload_2
    //   91: aconst_null
    //   92: putfield 567	com/google/android/gms/ads/internal/x/a:h	Lcom/google/android/gms/ads/internal/gmsg/d;
    //   95: aload_2
    //   96: aconst_null
    //   97: putfield 543	com/google/android/gms/ads/internal/x/a:k	Lcom/google/android/gms/ads/internal/overlay/q;
    //   100: aload_2
    //   101: aconst_null
    //   102: putfield 626	com/google/android/gms/ads/internal/x/a:o	Lcom/google/android/gms/ads/internal/webview/ar;
    //   105: aload_2
    //   106: getfield 629	com/google/android/gms/ads/internal/x/a:m	Lcom/google/android/gms/ads/internal/m/d;
    //   109: astore 4
    //   111: aload 4
    //   113: ifnull +14 -> 127
    //   116: aload 4
    //   118: iconst_1
    //   119: invokevirtual 633	com/google/android/gms/ads/internal/m/d:a	(Z)V
    //   122: aload_2
    //   123: aconst_null
    //   124: putfield 629	com/google/android/gms/ads/internal/x/a:m	Lcom/google/android/gms/ads/internal/m/d;
    //   127: aload_3
    //   128: monitorexit
    //   129: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   132: getfield 636	com/google/android/gms/ads/internal/bt:D	Lcom/google/android/gms/ads/internal/w/b/j;
    //   135: astore_2
    //   136: aload_0
    //   137: invokestatic 641	com/google/android/gms/ads/internal/w/b/j:a	(Lcom/google/android/gms/ads/internal/w/ad;)Z
    //   140: pop
    //   141: aload_0
    //   142: invokespecial 643	com/google/android/gms/ads/internal/x/h:v	()V
    //   145: aload_0
    //   146: monitorexit
    //   147: return
    //   148: aload_0
    //   149: invokespecial 212	com/google/android/gms/ads/internal/x/h:w	()V
    //   152: aload_0
    //   153: getfield 146	com/google/android/gms/ads/internal/x/h:v	Lcom/google/android/gms/ads/internal/util/bv;
    //   156: invokevirtual 644	com/google/android/gms/ads/internal/util/bv:b	()V
    //   159: aload_0
    //   160: getfield 646	com/google/android/gms/ads/internal/x/h:d	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull -159 -> 6
    //   168: aload_2
    //   169: invokevirtual 647	com/google/android/gms/ads/internal/overlay/AdOverlay:a	()V
    //   172: aload_0
    //   173: getfield 646	com/google/android/gms/ads/internal/x/h:d	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   176: invokevirtual 648	com/google/android/gms/ads/internal/overlay/AdOverlay:k	()V
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 646	com/google/android/gms/ads/internal/x/h:d	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   184: goto -178 -> 6
    //   187: astore_2
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_2
    //   191: athrow
    //   192: astore_2
    //   193: aload_3
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	h
    //   0	197	1	paramBoolean	boolean
    //   18	151	2	localObject1	Object
    //   187	4	2	localObject2	Object
    //   192	4	2	localObject3	Object
    //   109	8	4	locald	com.google.android.gms.ads.internal.m.d
    // Exception table:
    //   from	to	target	type
    //   6	24	187	finally
    //   28	39	187	finally
    //   39	65	187	finally
    //   129	145	187	finally
    //   148	164	187	finally
    //   168	184	187	finally
    //   195	197	187	finally
    //   65	111	192	finally
    //   116	127	192	finally
    //   127	129	192	finally
    //   193	195	192	finally
  }
  
  public final void c()
  {
    r();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.H.a);
    com.google.android.gms.ads.internal.js.i.a(this, "onhide", localHashMap);
  }
  
  public final void d()
  {
    if (this.g == null)
    {
      com.google.android.gms.ads.internal.g.e.a(this.G.b, this.e, new String[] { "aes2" });
      this.g = com.google.android.gms.ads.internal.g.e.a(this.G.b);
      this.G.a("native:view_show", this.g);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.H.a);
    com.google.android.gms.ads.internal.js.i.a(this, "onshow", localHashMap);
  }
  
  /* Error */
  public final void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 656	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc_w 658
    //   12: invokestatic 660	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 662	com/google/android/gms/ads/internal/x/m:d	(Ljava/lang/String;)V
    //   23: goto -8 -> 15
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	h
    //   0	31	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	26	finally
    //   18	23	26	finally
  }
  
  public final void e()
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("app_muted", String.valueOf(bt.A.j.b()));
    localHashMap.put("app_volume", String.valueOf(bt.A.j.a()));
    localHashMap.put("device_volume", String.valueOf(af.a(getContext())));
    com.google.android.gms.ads.internal.js.i.a(this, "volume", localHashMap);
  }
  
  public final boolean f()
  {
    try
    {
      boolean bool = this.n;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Activity getActivityContext()
  {
    return this.b.a;
  }
  
  public final com.google.android.gms.ads.internal.u getAdManagerDependencyProvider()
  {
    return this.j;
  }
  
  public final AdOverlay getAdOverlay()
  {
    try
    {
      AdOverlay localAdOverlay = this.d;
      return localAdOverlay;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final au getAdSize()
  {
    try
    {
      au localau = this.E;
      return localau;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final t getAdVideoUnderlayContainer()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.g.j getAdWebViewCreatedLabel()
  {
    return this.e;
  }
  
  public final boolean getCustomClose()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String getFormatString()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final r getNativeMediaViewEventListener()
  {
    try
    {
      r localr = this.s;
      return localr;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final com.google.android.gms.ads.internal.j.a getOmidSession()
  {
    return (com.google.android.gms.ads.internal.j.a)this.t.get();
  }
  
  public final View.OnClickListener getOnClickListener()
  {
    return (View.OnClickListener)this.u.get();
  }
  
  public final Context getOriginalContext()
  {
    return this.b.b;
  }
  
  public final String getRequestId()
  {
    try
    {
      String str = this.x;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int getRequestedOrientation()
  {
    try
    {
      int i1 = this.y;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final AdOverlay getSecondPieceAdOverlay()
  {
    try
    {
      AdOverlay localAdOverlay = this.B;
      return localAdOverlay;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean getShouldDelayPageClose()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 732	com/google/android/gms/ads/internal/x/h:i	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifle +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	h
    //   6	2	1	i1	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final aa getSpamSignalsUtil()
  {
    return this.F;
  }
  
  public final com.google.android.gms.ads.internal.g.k getTickStore()
  {
    return this.G;
  }
  
  public final VersionInfoParcel getVersionInfo()
  {
    return this.H;
  }
  
  public final int getVideoBoundingHeight()
  {
    return getMeasuredHeight();
  }
  
  public final int getVideoBoundingWidth()
  {
    return getMeasuredWidth();
  }
  
  public final w getVideoController()
  {
    try
    {
      w localw = this.I;
      return localw;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final WebView getWebView()
  {
    return this;
  }
  
  public final WebViewClient getWebViewClientForNewWebView()
  {
    return this.L;
  }
  
  public final void h() {}
  
  public final boolean i()
  {
    try
    {
      boolean bool = this.C;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean j()
  {
    try
    {
      boolean bool = this.D;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void k()
  {
    this.v.a();
  }
  
  public final void l()
  {
    if (this.f == null)
    {
      this.f = com.google.android.gms.ads.internal.g.e.a(this.G.b);
      this.G.a("native:view_load", this.f);
    }
  }
  
  public final void m()
  {
    setBackgroundColor(0);
  }
  
  public final void n()
  {
    com.google.android.gms.ads.internal.util.e.a("Cannot add text view to inner AdWebView");
  }
  
  protected final void onAttachedToWindow()
  {
    label128:
    label146:
    label149:
    for (;;)
    {
      try
      {
        super.onAttachedToWindow();
        if (!g()) {
          this.v.c();
        }
        boolean bool = this.m;
        if ((a)getAdWebViewClient() == null) {
          break label149;
        }
        if (!((a)getAdWebViewClient()).c()) {
          break label146;
        }
        Object localObject;
        if (!this.p)
        {
          localObject = ((a)getAdWebViewClient()).d();
          if (localObject != null) {
            break label128;
          }
          localObject = ((a)getAdWebViewClient()).e();
          if (localObject == null) {
            this.p = true;
          }
        }
        else
        {
          q();
          bool = true;
          c(bool);
          return;
        }
        com.google.android.gms.ads.internal.util.d.a locala = bt.A.E;
        com.google.android.gms.ads.internal.util.d.a.a(getView(), (ViewTreeObserver.OnScrollChangedListener)localObject);
        continue;
        locala = bt.A.E;
      }
      finally {}
      com.google.android.gms.ads.internal.util.d.a.a(getView(), localOnGlobalLayoutListener);
      continue;
    }
  }
  
  /* Error */
  protected final void onDetachedFromWindow()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 656	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: getfield 146	com/google/android/gms/ads/internal/x/h:v	Lcom/google/android/gms/ads/internal/util/bv;
    //   13: invokevirtual 793	com/google/android/gms/ads/internal/util/bv:d	()V
    //   16: aload_0
    //   17: invokespecial 795	com/google/android/gms/ads/internal/x/m:onDetachedFromWindow	()V
    //   20: aload_0
    //   21: getfield 770	com/google/android/gms/ads/internal/x/h:p	Z
    //   24: ifeq +86 -> 110
    //   27: aload_0
    //   28: invokevirtual 283	com/google/android/gms/ads/internal/x/h:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   31: checkcast 285	com/google/android/gms/ads/internal/x/a
    //   34: ifnull +76 -> 110
    //   37: aload_0
    //   38: invokevirtual 283	com/google/android/gms/ads/internal/x/h:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   41: checkcast 285	com/google/android/gms/ads/internal/x/a
    //   44: invokevirtual 289	com/google/android/gms/ads/internal/x/a:c	()Z
    //   47: ifeq +63 -> 110
    //   50: aload_0
    //   51: invokevirtual 799	com/google/android/gms/ads/internal/x/h:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   54: ifnull +56 -> 110
    //   57: aload_0
    //   58: invokevirtual 799	com/google/android/gms/ads/internal/x/h:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   61: invokevirtual 804	android/view/ViewTreeObserver:isAlive	()Z
    //   64: ifeq +46 -> 110
    //   67: aload_0
    //   68: invokevirtual 283	com/google/android/gms/ads/internal/x/h:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   71: checkcast 285	com/google/android/gms/ads/internal/x/a
    //   74: invokevirtual 773	com/google/android/gms/ads/internal/x/a:d	()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnonnull +39 -> 118
    //   82: aload_0
    //   83: invokevirtual 283	com/google/android/gms/ads/internal/x/h:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   86: checkcast 285	com/google/android/gms/ads/internal/x/a
    //   89: invokevirtual 776	com/google/android/gms/ads/internal/x/a:e	()Landroid/view/ViewTreeObserver$OnScrollChangedListener;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +11 -> 105
    //   97: aload_0
    //   98: invokevirtual 799	com/google/android/gms/ads/internal/x/h:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   101: aload_1
    //   102: invokevirtual 808	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 770	com/google/android/gms/ads/internal/x/h:p	Z
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_0
    //   113: iconst_0
    //   114: invokespecial 467	com/google/android/gms/ads/internal/x/h:c	(Z)V
    //   117: return
    //   118: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   121: getfield 250	com/google/android/gms/ads/internal/bt:g	Lcom/google/android/gms/ads/internal/util/v;
    //   124: aload_0
    //   125: invokevirtual 799	com/google/android/gms/ads/internal/x/h:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   128: aload_1
    //   129: invokevirtual 811	com/google/android/gms/ads/internal/util/v:a	(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   132: goto -50 -> 82
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	h
    //   77	52	1	localObject1	Object
    //   135	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	135	finally
    //   16	78	135	finally
    //   82	93	135	finally
    //   97	105	135	finally
    //   105	110	135	finally
    //   110	112	135	finally
    //   118	132	135	finally
    //   136	138	135	finally
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      paramString3 = bt.A.e;
      com.google.android.gms.ads.internal.util.n.a(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      paramString2 = new StringBuilder(String.valueOf(paramString1).length() + 51 + String.valueOf(paramString4).length());
      paramString2.append("Couldn't find an Activity to view url/mimetype: ");
      paramString2.append(paramString1);
      paramString2.append(" / ");
      paramString2.append(paramString4);
      com.google.android.gms.ads.internal.util.e.b(paramString2.toString());
    }
  }
  
  @TargetApi(21)
  protected final void onDraw(Canvas paramCanvas)
  {
    if ((Build.VERSION.SDK_INT != 21) || (!paramCanvas.isHardwareAccelerated()) || (isAttachedToWindow()))
    {
      super.onDraw(paramCanvas);
      if (((a)getAdWebViewClient() != null) && (((a)getAdWebViewClient()).p != null)) {
        ((a)getAdWebViewClient()).p.a();
      }
    }
  }
  
  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getAxisValue(9);
    float f2 = paramMotionEvent.getAxisValue(10);
    if (paramMotionEvent.getActionMasked() == 8) {
      if (f1 > 0.0F) {
        break label85;
      }
    }
    for (;;)
    {
      if (f1 >= 0.0F) {
        if (f2 <= 0.0F) {
          if ((f2 >= 0.0F) || (canScrollHorizontally(1))) {
            return super.onGenericMotionEvent(paramMotionEvent);
          }
        }
      }
      label85:
      do
      {
        do
        {
          do
          {
            return false;
          } while (!canScrollHorizontally(-1));
          break;
        } while (!canScrollVertically(1));
        break;
      } while (!canScrollVertically(-1));
    }
  }
  
  public final void onGlobalLayout()
  {
    boolean bool = q();
    AdOverlay localAdOverlay = getAdOverlay();
    if ((localAdOverlay != null) && (bool)) {
      localAdOverlay.o();
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    label77:
    Object localObject2;
    float f1;
    int i4;
    for (;;)
    {
      try
      {
        if (g())
        {
          setMeasuredDimension(0, 0);
          return;
        }
        if ((isInEditMode()) || (this.n) || (this.E.f()))
        {
          super.onMeasure(paramInt1, paramInt2);
          continue;
        }
        if (!this.E.h()) {
          break label77;
        }
      }
      finally {}
      super.onMeasure(paramInt1, paramInt2);
      continue;
      if (this.E.g())
      {
        if (((Boolean)com.google.android.gms.ads.internal.f.n.am.a()).booleanValue())
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          localObject2 = getVideoController();
          if (localObject2 == null) {
            break label828;
          }
          f1 = ((w)localObject2).g();
          if (f1 != 0.0F)
          {
            i1 = View.MeasureSpec.getSize(paramInt1);
            i4 = View.MeasureSpec.getSize(paramInt2);
            paramInt1 = (int)(i4 * f1);
            paramInt2 = (int)(i1 / f1);
            if (i4 == 0) {
              break label809;
            }
            break label794;
            for (;;)
            {
              label168:
              setMeasuredDimension(Math.min(i2, i1), Math.min(paramInt2, i3));
              break;
              label188:
              i2 = paramInt1;
              i3 = i4;
              if (paramInt1 != 0)
              {
                paramInt2 = (int)(paramInt1 / f1);
                i1 = paramInt1;
                i2 = paramInt1;
                i3 = i4;
              }
            }
          }
          super.onMeasure(paramInt1, paramInt2);
        }
      }
      else if (this.E.d())
      {
        if ((((Boolean)com.google.android.gms.ads.internal.f.n.bU.a()).booleanValue()) || (!com.google.android.gms.common.util.h.a()))
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          a("/contentHeight", new i(this));
          d("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
          i1 = View.MeasureSpec.getSize(paramInt1);
          paramInt1 = this.a;
        }
      }
      else {
        switch (paramInt1)
        {
        case -1: 
          label320:
          for (paramInt1 = (int)(paramInt1 * this.c);; paramInt1 = View.MeasureSpec.getSize(paramInt2))
          {
            setMeasuredDimension(i1, paramInt1);
            break;
          }
          if (!this.E.e()) {
            break label397;
          }
          localObject2 = new DisplayMetrics();
          this.K.getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
          setMeasuredDimension(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
        }
      }
    }
    label397:
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == Integer.MIN_VALUE)
    {
      paramInt2 = i2;
      break label836;
      label434:
      localObject2 = this.E;
      if (((au)localObject2).b <= paramInt2) {
        if (((au)localObject2).a <= i1)
        {
          paramInt1 = 0;
          label461:
          if (((Boolean)com.google.android.gms.ads.internal.f.n.bb.a()).booleanValue())
          {
            localObject2 = this.E;
            i4 = ((au)localObject2).b;
            f1 = this.c;
            if (i4 / f1 <= paramInt2 / f1) {
              if (((au)localObject2).a / f1 <= i1 / f1)
              {
                paramInt2 = 1;
                break label850;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localObject2 = this.E;
        paramInt1 = ((au)localObject2).b;
        f1 = this.c;
        paramInt2 = ((au)localObject2).a;
        localObject2 = new StringBuilder(103);
        ((StringBuilder)localObject2).append("Not enough space to show ad. Needs ");
        ((StringBuilder)localObject2).append((int)(paramInt1 / f1));
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append((int)(paramInt2 / f1));
        ((StringBuilder)localObject2).append(" dp, but only has ");
        ((StringBuilder)localObject2).append((int)(i2 / f1));
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append((int)(i3 / f1));
        ((StringBuilder)localObject2).append(" dp.");
        com.google.android.gms.ads.internal.util.e.e(((StringBuilder)localObject2).toString());
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
        break;
      }
      if (getVisibility() != 8) {
        setVisibility(0);
      }
      localObject2 = this.E;
      setMeasuredDimension(((au)localObject2).b, ((au)localObject2).a);
      break;
      paramInt2 = 0;
      break label850;
      paramInt2 = 0;
      break label850;
      paramInt2 = paramInt1;
      continue;
      paramInt1 = 1;
      break label461;
      paramInt1 = 1;
      break label461;
      label794:
      label809:
      label828:
      label836:
      do
      {
        if (paramInt1 == 1073741824)
        {
          i1 = i3;
          break label434;
        }
        i1 = Integer.MAX_VALUE;
        break label434;
        if (i1 == 1073741824)
        {
          paramInt2 = i2;
        }
        else
        {
          paramInt2 = Integer.MAX_VALUE;
          continue;
          do
          {
            if (i1 == 0) {
              break label188;
            }
            i2 = paramInt1;
            i3 = i4;
            break;
          } while (paramInt2 == 0);
          i2 = (int)(paramInt2 * f1);
          paramInt1 = paramInt2;
          i3 = paramInt1;
          break label168;
          f1 = 0.0F;
          break;
          break label320;
        }
      } while (paramInt1 != Integer.MIN_VALUE);
      i1 = i3;
      break label434;
      label850:
      if (paramInt1 == 0) {
        paramInt2 = paramInt1;
      }
    }
  }
  
  public final void onPause()
  {
    try
    {
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      com.google.android.gms.ads.internal.util.e.c("Could not pause webview.", localException);
    }
  }
  
  public final void onResume()
  {
    try
    {
      super.onResume();
      return;
    }
    catch (Exception localException)
    {
      com.google.android.gms.ads.internal.util.e.c("Could not resume webview.", localException);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((a)getAdWebViewClient()).c()) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.s;
        if (localObject == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        ((r)localObject).a(paramMotionEvent);
        continue;
        localObject = this.F;
      }
      finally {}
      if (localObject != null) {
        ((aa)localObject).a(paramMotionEvent);
      }
    }
  }
  
  public final void setAdOverlay(AdOverlay paramAdOverlay)
  {
    try
    {
      this.d = paramAdOverlay;
      return;
    }
    finally
    {
      paramAdOverlay = finally;
      throw paramAdOverlay;
    }
  }
  
  public final void setAdSize(au paramau)
  {
    try
    {
      this.E = paramau;
      requestLayout();
      return;
    }
    finally
    {
      paramau = finally;
      throw paramau;
    }
  }
  
  public final void setBackButtonAllowed(boolean paramBoolean)
  {
    try
    {
      this.C = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setContext(Context paramContext)
  {
    this.b.setBaseContext(paramContext);
    this.v.a = this.b.a;
  }
  
  /* Error */
  public final void setCustomClose(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 646	com/google/android/gms/ads/internal/x/h:d	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_0
    //   13: getfield 103	com/google/android/gms/ads/internal/x/h:L	Lcom/google/android/gms/ads/internal/x/a;
    //   16: invokevirtual 287	com/google/android/gms/ads/internal/x/a:b	()Z
    //   19: iload_1
    //   20: invokevirtual 1029	com/google/android/gms/ads/internal/overlay/AdOverlay:a	(ZZ)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: iload_1
    //   28: putfield 700	com/google/android/gms/ads/internal/x/h:h	Z
    //   31: goto -8 -> 23
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	h
    //   0	39	1	paramBoolean	boolean
    //   6	6	2	localAdOverlay	AdOverlay
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   11	23	34	finally
    //   26	31	34	finally
  }
  
  public final void setFollowUrls(boolean paramBoolean)
  {
    ((a)getAdWebViewClient()).i = paramBoolean;
  }
  
  public final void setInstreamAdEventListener(com.google.android.gms.ads.internal.formats.e parame)
  {
    try
    {
      this.l = parame;
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  /* Error */
  public final void setIsExpanded(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/google/android/gms/ads/internal/x/h:n	Z
    //   6: istore_2
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 109	com/google/android/gms/ads/internal/x/h:n	Z
    //   12: aload_0
    //   13: invokespecial 192	com/google/android/gms/ads/internal/x/h:s	()V
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpeq +27 -> 45
    //   21: new 313	com/google/android/gms/ads/internal/m/m
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 316	com/google/android/gms/ads/internal/m/m:<init>	(Lcom/google/android/gms/ads/internal/webview/i;)V
    //   29: astore 4
    //   31: iload_1
    //   32: ifne +16 -> 48
    //   35: ldc_w 1037
    //   38: astore_3
    //   39: aload 4
    //   41: aload_3
    //   42: invokevirtual 1038	com/google/android/gms/ads/internal/m/m:b	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: ldc_w 1040
    //   51: astore_3
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	h
    //   0	60	1	paramBoolean	boolean
    //   6	13	2	bool	boolean
    //   38	14	3	str	String
    //   55	4	3	localObject	Object
    //   29	11	4	localm	com.google.android.gms.ads.internal.m.m
    // Exception table:
    //   from	to	target	type
    //   2	16	55	finally
    //   21	31	55	finally
    //   39	45	55	finally
  }
  
  public final void setNativeMediaViewEventListener(r paramr)
  {
    try
    {
      this.s = paramr;
      return;
    }
    finally
    {
      paramr = finally;
      throw paramr;
    }
  }
  
  public final void setOmidSession(com.google.android.gms.ads.internal.j.a parama)
  {
    this.t.set(parama);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.u = new WeakReference(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  public final void setRequestId(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      this.x = str;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    try
    {
      this.y = paramInt;
      AdOverlay localAdOverlay = this.d;
      if (localAdOverlay != null) {
        localAdOverlay.a(this.y);
      }
      return;
    }
    finally {}
  }
  
  public final void setSecondPieceOverlay(AdOverlay paramAdOverlay)
  {
    try
    {
      this.B = paramAdOverlay;
      return;
    }
    finally
    {
      paramAdOverlay = finally;
      throw paramAdOverlay;
    }
  }
  
  /* Error */
  public final void setShouldDelayPageClose(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 732	com/google/android/gms/ads/internal/x/h:i	I
    //   6: istore_3
    //   7: iload_1
    //   8: ifne +38 -> 46
    //   11: iconst_m1
    //   12: istore_2
    //   13: aload_0
    //   14: iload_2
    //   15: iload_3
    //   16: iadd
    //   17: putfield 732	com/google/android/gms/ads/internal/x/h:i	I
    //   20: aload_0
    //   21: getfield 732	com/google/android/gms/ads/internal/x/h:i	I
    //   24: ifgt +19 -> 43
    //   27: aload_0
    //   28: getfield 646	com/google/android/gms/ads/internal/x/h:d	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +8 -> 43
    //   38: aload 4
    //   40: invokevirtual 1058	com/google/android/gms/ads/internal/overlay/AdOverlay:q	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -35 -> 13
    //   51: astore 4
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 4
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	h
    //   0	58	1	paramBoolean	boolean
    //   12	36	2	i1	int
    //   6	11	3	i2	int
    //   31	8	4	localAdOverlay	AdOverlay
    //   51	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	51	finally
    //   13	33	51	finally
    //   38	43	51	finally
  }
  
  /* Error */
  public final void setVideoController(w paramw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 748	com/google/android/gms/ads/internal/x/h:I	Lcom/google/android/gms/ads/internal/webview/w;
    //   6: ifnull +12 -> 18
    //   9: ldc_w 1062
    //   12: invokestatic 1064	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 748	com/google/android/gms/ads/internal/x/h:I	Lcom/google/android/gms/ads/internal/webview/w;
    //   23: goto -8 -> 15
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	h
    //   0	31	1	paramw	w
    // Exception table:
    //   from	to	target	type
    //   2	15	26	finally
    //   18	23	26	finally
  }
  
  public final void stopLoading()
  {
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      com.google.android.gms.ads.internal.util.e.c("Could not stop loading webview.", localException);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */