package com.google.android.gms.ads.internal.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.a.ac;
import com.google.android.gms.ads.internal.bm;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.d.g;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.formats.r;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.gmsg.d;
import com.google.android.gms.ads.internal.m.m;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.af;
import com.google.android.gms.ads.internal.util.bv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.zxxz.aa;
import com.google.android.gms.common.util.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
final class t
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, i
{
  private WeakReference A;
  private bv B;
  private final bm C;
  private String D = "";
  private int E;
  private int F = -1;
  private int G = -1;
  private AdOverlay H;
  private boolean I = true;
  private boolean J = false;
  private au K;
  private final aa L;
  private com.google.android.gms.ads.internal.g.k M;
  private final VersionInfoParcel N;
  private w O;
  private Map P;
  private final WindowManager Q;
  private boolean R = false;
  private boolean S = false;
  public int a;
  private final com.google.android.gms.ads.internal.d.a b;
  private AdOverlay c;
  private j d;
  private com.google.android.gms.ads.internal.g.j e;
  private com.google.android.gms.ads.internal.g.j f;
  private com.google.android.gms.ads.internal.g.j g;
  private final at h;
  private boolean i;
  private int j;
  private final com.google.android.gms.ads.internal.u k;
  private boolean l;
  private final DisplayMetrics m;
  private String n;
  private com.google.android.gms.ads.internal.formats.e o;
  private boolean p;
  private boolean q;
  private Boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private final float v;
  private int w = -1;
  private int x = -1;
  private r y;
  private com.google.android.gms.ads.internal.j.a z;
  
  protected t(at paramat, au paramau, String paramString, boolean paramBoolean, aa paramaa, VersionInfoParcel paramVersionInfoParcel, l paraml, bm parambm, com.google.android.gms.ads.internal.u paramu, com.google.android.gms.ads.internal.d.a parama)
  {
    super(paramat);
    this.h = paramat;
    this.K = paramau;
    this.n = paramString;
    this.s = paramBoolean;
    this.E = -1;
    this.L = paramaa;
    this.N = paramVersionInfoParcel;
    this.C = parambm;
    this.k = paramu;
    this.Q = ((WindowManager)getContext().getSystemService("window"));
    paramau = bt.A.e;
    this.m = com.google.android.gms.ads.internal.util.n.a(this.Q);
    this.v = this.m.density;
    this.b = parama;
    setBackgroundColor(0);
    paramau = getSettings();
    paramau.setAllowFileAccess(false);
    try
    {
      paramau.setJavaScriptEnabled(true);
      paramau.setSavePassword(false);
      paramau.setSupportMultipleWindows(true);
      paramau.setJavaScriptCanOpenWindowsAutomatically(true);
      if (Build.VERSION.SDK_INT >= 21) {
        paramau.setMixedContentMode(2);
      }
      bt.A.e.a(paramat, paramVersionInfoParcel.a, paramau);
      bt.A.g.a(getContext(), paramau);
      setDownloadListener(this);
      s();
      if (h.a()) {
        addJavascriptInterface(z.a(this), "googleAdsJsInterface");
      }
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
      this.B = new bv(this.h.a, this, this, null);
      x();
      this.M = new com.google.android.gms.ads.internal.g.k(new l(true, "make_wv", this.n));
      this.M.b.a(paraml);
      this.e = com.google.android.gms.ads.internal.g.e.a(this.M.b);
      this.M.a("native:view_create", this.e);
      this.f = null;
      this.g = null;
      bt.A.g.b(paramat);
      bt.A.i.d();
      return;
    }
    catch (NullPointerException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.c("Unable to enable Javascript.", paramString);
      }
    }
  }
  
  /* Error */
  private final void a(Boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 317	com/google/android/gms/ads/internal/webview/t:r	Ljava/lang/Boolean;
    //   7: aload_0
    //   8: monitorexit
    //   9: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   12: getfield 298	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 320	com/google/android/gms/ads/internal/v/f:g	Ljava/lang/Object;
    //   20: astore_2
    //   21: aload_2
    //   22: monitorenter
    //   23: aload_3
    //   24: aload_1
    //   25: putfield 322	com/google/android/gms/ads/internal/v/f:e	Ljava/lang/Boolean;
    //   28: aload_2
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	t
    //   0	41	1	paramBoolean	Boolean
    //   15	9	3	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	9	31	finally
    //   32	34	31	finally
    //   23	30	36	finally
    //   37	39	36	finally
  }
  
  /* Error */
  private final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc_w 326
    //   12: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 331	com/google/android/gms/ads/internal/webview/t:loadUrl	(Ljava/lang/String;)V
    //   23: goto -8 -> 15
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	t
    //   0	31	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	26	finally
    //   18	23	26	finally
  }
  
  private final void b(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("isVisible", str);
      a("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  /* Error */
  private final void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 361	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   14: getfield 298	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   17: aload_1
    //   18: ldc_w 363
    //   21: invokevirtual 366	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   24: ldc_w 368
    //   27: aload_1
    //   28: invokestatic 370	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: goto -24 -> 7
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_1
    //   40: goto -29 -> 11
    //   43: astore_1
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: goto -37 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	t
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	7	10	java/lang/Exception
    //   2	7	34	finally
    //   11	31	34	finally
    //   2	7	39	java/lang/NoClassDefFoundError
    //   2	7	43	java/lang/IncompatibleClassChangeError
    //   2	7	47	java/lang/UnsatisfiedLinkError
  }
  
  /* Error */
  @TargetApi(19)
  private final void e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc_w 326
    //   12: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: aconst_null
    //   21: invokevirtual 377	com/google/android/gms/ads/internal/webview/t:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	t
    //   0	32	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	27	finally
    //   18	24	27	finally
  }
  
  private final void f(String paramString)
  {
    if (h.b())
    {
      if (q() == null) {
        p();
      }
      if (q().booleanValue())
      {
        e(paramString);
        return;
      }
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {}
      for (paramString = new String("javascript:");; paramString = "javascript:".concat(paramString))
      {
        b(paramString);
        return;
      }
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String("javascript:");; paramString = "javascript:".concat(paramString))
    {
      b(paramString);
      return;
    }
  }
  
  private final boolean o()
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject1;
    int i3;
    int i4;
    int i2;
    int i1;
    if (!((j)getAdWebViewClient()).b())
    {
      bool1 = bool2;
      if (!((j)getAdWebViewClient()).c()) {}
    }
    else
    {
      localObject1 = com.google.android.gms.ads.internal.client.u.h.a;
      localObject1 = this.m;
      i3 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, ((DisplayMetrics)localObject1).widthPixels);
      localObject1 = com.google.android.gms.ads.internal.client.u.h.a;
      localObject1 = this.m;
      i4 = com.google.android.gms.ads.internal.util.client.a.b((DisplayMetrics)localObject1, ((DisplayMetrics)localObject1).heightPixels);
      localObject1 = getActivityContext();
      if (localObject1 != null) {
        break label230;
      }
      i2 = i4;
      i1 = i3;
    }
    for (;;)
    {
      int i5 = this.G;
      if ((i5 == i3) && (this.F == i4) && (this.x == i1))
      {
        bool1 = bool2;
        if (this.w == i2) {}
      }
      else
      {
        if (i5 != i3) {
          break label224;
        }
        if (this.F != i4) {
          break label218;
        }
        bool1 = false;
      }
      for (;;)
      {
        this.G = i3;
        this.F = i4;
        this.x = i1;
        this.w = i2;
        new m(this).a(i3, i4, i1, i2, this.m.density, this.Q.getDefaultDisplay().getRotation());
        return bool1;
        label218:
        bool1 = true;
        continue;
        label224:
        bool1 = true;
      }
      label230:
      if (((Activity)localObject1).getWindow() != null)
      {
        Object localObject2 = bt.A.e;
        localObject1 = com.google.android.gms.ads.internal.util.n.a((Activity)localObject1);
        localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
        i1 = com.google.android.gms.ads.internal.util.client.a.b(this.m, localObject1[0]);
        localObject2 = com.google.android.gms.ads.internal.client.u.h.a;
        i2 = com.google.android.gms.ads.internal.util.client.a.b(this.m, localObject1[1]);
      }
      else
      {
        i2 = i4;
        i1 = i3;
      }
    }
  }
  
  /* Error */
  private final void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   6: getfield 298	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   9: invokevirtual 473	com/google/android/gms/ads/internal/v/f:b	()Ljava/lang/Boolean;
    //   12: putfield 317	com/google/android/gms/ads/internal/webview/t:r	Ljava/lang/Boolean;
    //   15: aload_0
    //   16: getfield 317	com/google/android/gms/ads/internal/webview/t:r	Ljava/lang/Boolean;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +19 -> 40
    //   24: aload_0
    //   25: ldc_w 475
    //   28: aconst_null
    //   29: invokevirtual 377	com/google/android/gms/ads/internal/webview/t:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   32: aload_0
    //   33: iconst_1
    //   34: invokestatic 478	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: invokespecial 480	com/google/android/gms/ads/internal/webview/t:a	(Ljava/lang/Boolean;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: iconst_0
    //   46: invokestatic 478	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: invokespecial 480	com/google/android/gms/ads/internal/webview/t:a	(Ljava/lang/Boolean;)V
    //   52: goto -12 -> 40
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	t
    //   19	2	1	localBoolean	Boolean
    //   43	1	1	localIllegalStateException	IllegalStateException
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	40	43	java/lang/IllegalStateException
    //   2	20	55	finally
    //   24	40	55	finally
    //   44	52	55	finally
  }
  
  private final Boolean q()
  {
    try
    {
      Boolean localBoolean = this.r;
      return localBoolean;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final void r()
  {
    com.google.android.gms.ads.internal.g.e.a(this.M.b, this.e, new String[] { "aeh2" });
  }
  
  private final void s()
  {
    for (;;)
    {
      try
      {
        if ((this.s) || (this.K.e()))
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
      if (!this.t) {
        bt.A.g.c(this);
      }
      this.t = true;
      return;
    }
    finally {}
  }
  
  private final void u()
  {
    try
    {
      if (this.t) {
        bt.A.g.b(this);
      }
      this.t = false;
      return;
    }
    finally {}
  }
  
  private final void v()
  {
    try
    {
      if (!this.l)
      {
        this.l = true;
        bt.A.i.e();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final void w()
  {
    try
    {
      Object localObject1 = this.P;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.google.android.gms.ads.internal.w.b.k)((Iterator)localObject1).next()).b();
        }
      }
      this.P = null;
    }
    finally {}
  }
  
  private final void x()
  {
    Object localObject = this.M;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.g.k)localObject).b;
      if ((localObject != null) && (bt.A.i.a() != null)) {
        bt.A.i.a().a((l)localObject);
      }
    }
  }
  
  public final void Q()
  {
    try
    {
      this.J = true;
      bm localbm = this.C;
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
      this.J = false;
      bm localbm = this.C;
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
    //   3: getfield 513	com/google/android/gms/ads/internal/webview/t:P	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_1
    //   13: invokeinterface 555 2 0
    //   18: checkcast 534	com/google/android/gms/ads/internal/w/b/k
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
    //   0	36	0	this	t
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
      com.google.android.gms.ads.internal.g.e.a(this.M.b, this.e, new String[] { "aebb2" });
    }
    r();
    Object localObject = this.M.b;
    if (localObject != null) {
      ((l)localObject).a("close_type", String.valueOf(paramInt));
    }
    localObject = new HashMap(2);
    ((HashMap)localObject).put("closetype", String.valueOf(paramInt));
    ((HashMap)localObject).put("version", this.N.a);
    a("onhide", (Map)localObject);
  }
  
  public final void a(ac paramac)
  {
    try
    {
      this.p = paramac.f;
      b(paramac.f);
      return;
    }
    finally {}
  }
  
  public final void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    this.d.a(paramAdLauncherIntentInfoParcel);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    j localj = this.d;
    if (localj != null) {
      localj.a(paramString, paramu);
    }
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.w.b.k paramk)
  {
    try
    {
      if (this.P == null) {
        this.P = new HashMap();
      }
      this.P.put(paramString, paramk);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, com.google.android.gms.common.util.i parami)
  {
    Object localObject2 = this.d;
    if (localObject2 != null) {
      synchronized (((j)localObject2).i)
      {
        paramString = (List)((j)localObject2).g.get(paramString);
        if (paramString != null)
        {
          localObject2 = new ArrayList();
          Iterator localIterator = paramString.iterator();
          com.google.android.gms.ads.internal.gmsg.u localu;
          do
          {
            if (!localIterator.hasNext())
            {
              paramString.removeAll((Collection)localObject2);
              return;
            }
            localu = (com.google.android.gms.ads.internal.gmsg.u)localIterator.next();
          } while (!parami.a(localu));
          ((List)localObject2).add(localu);
        }
      }
    }
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifne +52 -> 58
    //   9: getstatic 635	com/google/android/gms/ads/internal/f/n:aH	Lcom/google/android/gms/ads/internal/f/c;
    //   12: invokevirtual 639	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   15: checkcast 387	java/lang/Boolean
    //   18: invokevirtual 390	java/lang/Boolean:booleanValue	()Z
    //   21: ifeq +34 -> 55
    //   24: aload_2
    //   25: iconst_1
    //   26: anewarray 393	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: invokestatic 644	com/google/android/gms/ads/internal/webview/aj:a	()Ljava/lang/String;
    //   34: aastore
    //   35: invokestatic 647	com/google/android/gms/ads/internal/webview/aj:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_2
    //   39: aload_0
    //   40: aload_1
    //   41: aload_2
    //   42: ldc_w 649
    //   45: ldc_w 651
    //   48: aload_3
    //   49: invokespecial 655	android/webkit/WebView:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: goto -16 -> 39
    //   58: ldc_w 326
    //   61: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	t
    //   0	72	1	paramString1	String
    //   0	72	2	paramString2	String
    //   0	72	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	39	67	finally
    //   39	52	67	finally
    //   58	64	67	finally
  }
  
  public final void a(String paramString, Map paramMap)
  {
    try
    {
      paramMap = bt.A.e.a(paramMap);
      a(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not convert parameters to JSON.");
    }
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    localObject = ((JSONObject)localObject).toString();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("(window.AFMA_ReceiveMessage || function() {})('");
    paramJSONObject.append(paramString);
    paramJSONObject.append("'");
    paramJSONObject.append(",");
    paramJSONObject.append((String)localObject);
    paramJSONObject.append(");");
    paramString = String.valueOf(paramJSONObject.toString());
    if (paramString.length() == 0) {}
    for (paramString = new String("Dispatching AFMA event: ");; paramString = "Dispatching AFMA event: ".concat(paramString))
    {
      com.google.android.gms.ads.internal.util.e.b(paramString);
      f(paramJSONObject.toString());
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d.m = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    j localj = this.d;
    if ((!localj.d.f()) || (localj.d.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = localj.a;; locala = null)
    {
      com.google.android.gms.ads.internal.overlay.k localk = localj.c;
      q localq = localj.h;
      i locali = localj.d;
      localj.a(new AdOverlayInfoParcel(locala, localk, localq, locali, paramBoolean, paramInt, locali.getVersionInfo()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    n localn = null;
    j localj = this.d;
    boolean bool = localj.d.f();
    if ((!bool) || (localj.d.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = localj.a;; locala = null)
    {
      if (!bool) {
        localn = new n(localj.d, localj.c);
      }
      com.google.android.gms.ads.internal.gmsg.b localb = localj.b;
      d locald = localj.e;
      q localq = localj.h;
      i locali = localj.d;
      localj.a(new AdOverlayInfoParcel(locala, localn, localb, locald, localq, locali, paramBoolean, paramInt, paramString, locali.getVersionInfo()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    j localj = this.d;
    boolean bool = localj.d.f();
    if ((!bool) || (localj.d.getAdSize().e())) {}
    for (com.google.android.gms.ads.internal.client.a locala = localj.a;; locala = null)
    {
      if (!bool) {}
      for (n localn = new n(localj.d, localj.c);; localn = null)
      {
        com.google.android.gms.ads.internal.gmsg.b localb = localj.b;
        d locald = localj.e;
        q localq = localj.h;
        i locali = localj.d;
        localj.a(new AdOverlayInfoParcel(locala, localn, localb, locald, localq, locali, paramBoolean, paramInt, paramString1, paramString2, locali.getVersionInfo()));
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
      a("onCacheAccessComplete", localHashMap);
      return;
    }
  }
  
  public final void b()
  {
    try
    {
      com.google.android.gms.ads.internal.formats.e locale = this.o;
      if (locale != null) {
        locale.a();
      }
      return;
    }
    finally {}
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    j localj = this.d;
    if (localj != null) {
      synchronized (localj.i)
      {
        paramString = (List)localj.g.get(paramString);
        if (paramString != null)
        {
          paramString.remove(paramu);
          return;
        }
        return;
      }
    }
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = ((JSONObject)localObject).toString();
    localObject = new StringBuilder(String.valueOf(paramString).length() + 3 + String.valueOf(paramJSONObject).length());
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(");");
    f(((StringBuilder)localObject).toString());
  }
  
  public final void c()
  {
    r();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.N.a);
    a("onhide", localHashMap);
  }
  
  public final void d()
  {
    if (this.g == null)
    {
      com.google.android.gms.ads.internal.g.e.a(this.M.b, this.e, new String[] { "aes2" });
      this.g = com.google.android.gms.ads.internal.g.e.a(this.M.b);
      this.M.a("native:view_show", this.g);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.N.a);
    a("onshow", localHashMap);
  }
  
  public final void d(String paramString)
  {
    f(paramString);
  }
  
  public final void destroy()
  {
    try
    {
      x();
      this.B.b();
      Object localObject1 = this.c;
      if (localObject1 != null)
      {
        ((AdOverlay)localObject1).a();
        this.c.k();
        this.c = null;
      }
      this.z = null;
      this.d.k();
      if (!this.q)
      {
        localObject1 = bt.A.D;
        com.google.android.gms.ads.internal.w.b.j.a(this);
        w();
        this.q = true;
        com.google.android.gms.ads.internal.util.e.a("Initiating WebView self destruct sequence in 3...");
        com.google.android.gms.ads.internal.util.e.a("Loading blank page in WebView, 2...");
        c("about:blank");
      }
      return;
    }
    finally {}
  }
  
  public final void e()
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("app_muted", String.valueOf(bt.A.j.b()));
    localHashMap.put("app_volume", String.valueOf(bt.A.j.a()));
    localHashMap.put("device_volume", String.valueOf(af.a(getContext())));
    a("volume", localHashMap);
  }
  
  /* Error */
  @TargetApi(19)
  public final void evaluateJavascript(String paramString, android.webkit.ValueCallback paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifeq +24 -> 30
    //   9: ldc_w 326
    //   12: aconst_null
    //   13: invokestatic 834	com/google/android/gms/ads/internal/util/client/k:f	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16: aload_2
    //   17: ifnull +10 -> 27
    //   20: aload_2
    //   21: aconst_null
    //   22: invokeinterface 840 2 0
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 841	android/webkit/WebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   36: goto -9 -> 27
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	t
    //   0	44	1	paramString	String
    //   0	44	2	paramValueCallback	android.webkit.ValueCallback
    // Exception table:
    //   from	to	target	type
    //   2	16	39	finally
    //   20	27	39	finally
    //   30	36	39	finally
  }
  
  public final boolean f()
  {
    try
    {
      boolean bool = this.s;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  protected final void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 784	com/google/android/gms/ads/internal/webview/t:q	Z
    //   6: ifne +30 -> 36
    //   9: aload_0
    //   10: getfield 595	com/google/android/gms/ads/internal/webview/t:d	Lcom/google/android/gms/ads/internal/webview/j;
    //   13: invokevirtual 782	com/google/android/gms/ads/internal/webview/j:k	()V
    //   16: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   19: getfield 787	com/google/android/gms/ads/internal/bt:D	Lcom/google/android/gms/ads/internal/w/b/j;
    //   22: astore_1
    //   23: aload_0
    //   24: invokestatic 792	com/google/android/gms/ads/internal/w/b/j:a	(Lcom/google/android/gms/ads/internal/w/ad;)Z
    //   27: pop
    //   28: aload_0
    //   29: invokespecial 794	com/google/android/gms/ads/internal/webview/t:w	()V
    //   32: aload_0
    //   33: invokespecial 844	com/google/android/gms/ads/internal/webview/t:v	()V
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: invokespecial 848	java/lang/Object:finalize	()V
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: invokespecial 848	java/lang/Object:finalize	()V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	t
    //   22	1	1	localj	com.google.android.gms.ads.internal.w.b.j
    //   43	6	1	localObject1	Object
    //   50	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	2	43	finally
    //   53	55	43	finally
    //   2	36	50	finally
    //   36	38	50	finally
    //   51	53	50	finally
  }
  
  public final boolean g()
  {
    try
    {
      boolean bool = this.q;
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
    return this.h.a;
  }
  
  public final com.google.android.gms.ads.internal.u getAdManagerDependencyProvider()
  {
    return this.k;
  }
  
  public final AdOverlay getAdOverlay()
  {
    try
    {
      AdOverlay localAdOverlay = this.c;
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
      au localau = this.K;
      return localau;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final com.google.android.gms.ads.internal.w.t getAdVideoUnderlayContainer()
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
      boolean bool = this.i;
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
      String str = this.n;
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
      r localr = this.y;
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
    try
    {
      com.google.android.gms.ads.internal.j.a locala = this.z;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final View.OnClickListener getOnClickListener()
  {
    return (View.OnClickListener)this.A.get();
  }
  
  public final Context getOriginalContext()
  {
    return this.h.b;
  }
  
  public final String getRequestId()
  {
    try
    {
      String str = this.D;
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
      int i1 = this.E;
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
      AdOverlay localAdOverlay = this.H;
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
    //   3: getfield 886	com/google/android/gms/ads/internal/webview/t:j	I
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
    //   0	27	0	this	t
    //   6	2	1	i1	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final aa getSpamSignalsUtil()
  {
    return this.L;
  }
  
  public final com.google.android.gms.ads.internal.g.k getTickStore()
  {
    return this.M;
  }
  
  public final VersionInfoParcel getVersionInfo()
  {
    return this.N;
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
      w localw = this.O;
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
    return this.d;
  }
  
  public final void h()
  {
    try
    {
      com.google.android.gms.ads.internal.util.e.a("Destroying WebView!");
      v();
      com.google.android.gms.ads.internal.util.n.a.post(new v(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean i()
  {
    try
    {
      boolean bool = this.I;
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
      boolean bool = this.J;
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
    this.B.a();
  }
  
  public final void l()
  {
    if (this.f == null)
    {
      this.f = com.google.android.gms.ads.internal.g.e.a(this.M.b);
      this.M.a("native:view_load", this.f);
    }
  }
  
  /* Error */
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc_w 326
    //   12: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: invokespecial 929	android/webkit/WebView:loadData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   25: goto -10 -> 15
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	t
    //   0	33	1	paramString1	String
    //   0	33	2	paramString2	String
    //   0	33	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	15	28	finally
    //   18	25	28	finally
  }
  
  /* Error */
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc_w 326
    //   12: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: aload 4
    //   24: aload 5
    //   26: invokespecial 655	android/webkit/WebView:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   29: goto -14 -> 15
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	t
    //   0	37	1	paramString1	String
    //   0	37	2	paramString2	String
    //   0	37	3	paramString3	String
    //   0	37	4	paramString4	String
    //   0	37	5	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   2	15	32	finally
    //   18	29	32	finally
  }
  
  /* Error */
  public final void loadUrl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +11 -> 19
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 361	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: ldc_w 326
    //   22: invokestatic 328	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   37: getfield 298	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   40: aload_1
    //   41: ldc_w 931
    //   44: invokevirtual 366	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   47: ldc_w 368
    //   50: aload_1
    //   51: invokestatic 370	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto -38 -> 16
    //   57: astore_1
    //   58: goto -24 -> 34
    //   61: astore_1
    //   62: goto -28 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	t
    //   0	65	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   11	16	28	finally
    //   19	25	28	finally
    //   34	54	28	finally
    //   11	16	33	java/lang/Exception
    //   11	16	57	java/lang/NoClassDefFoundError
    //   11	16	61	java/lang/IncompatibleClassChangeError
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
          this.B.c();
        }
        boolean bool = this.p;
        if ((j)getAdWebViewClient() == null) {
          break label149;
        }
        if (!((j)getAdWebViewClient()).c()) {
          break label146;
        }
        Object localObject;
        if (!this.u)
        {
          localObject = ((j)getAdWebViewClient()).d();
          if (localObject != null) {
            break label128;
          }
          localObject = ((j)getAdWebViewClient()).e();
          if (localObject == null) {
            this.u = true;
          }
        }
        else
        {
          o();
          bool = true;
          b(bool);
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
    //   3: invokevirtual 324	com/google/android/gms/ads/internal/webview/t:g	()Z
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: getfield 256	com/google/android/gms/ads/internal/webview/t:B	Lcom/google/android/gms/ads/internal/util/bv;
    //   13: invokevirtual 963	com/google/android/gms/ads/internal/util/bv:d	()V
    //   16: aload_0
    //   17: invokespecial 965	android/webkit/WebView:onDetachedFromWindow	()V
    //   20: aload_0
    //   21: getfield 940	com/google/android/gms/ads/internal/webview/t:u	Z
    //   24: ifeq +86 -> 110
    //   27: aload_0
    //   28: invokevirtual 415	com/google/android/gms/ads/internal/webview/t:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   31: checkcast 417	com/google/android/gms/ads/internal/webview/j
    //   34: ifnull +76 -> 110
    //   37: aload_0
    //   38: invokevirtual 415	com/google/android/gms/ads/internal/webview/t:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   41: checkcast 417	com/google/android/gms/ads/internal/webview/j
    //   44: invokevirtual 420	com/google/android/gms/ads/internal/webview/j:c	()Z
    //   47: ifeq +63 -> 110
    //   50: aload_0
    //   51: invokevirtual 969	com/google/android/gms/ads/internal/webview/t:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   54: ifnull +56 -> 110
    //   57: aload_0
    //   58: invokevirtual 969	com/google/android/gms/ads/internal/webview/t:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   61: invokevirtual 974	android/view/ViewTreeObserver:isAlive	()Z
    //   64: ifeq +46 -> 110
    //   67: aload_0
    //   68: invokevirtual 415	com/google/android/gms/ads/internal/webview/t:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   71: checkcast 417	com/google/android/gms/ads/internal/webview/j
    //   74: invokevirtual 943	com/google/android/gms/ads/internal/webview/j:d	()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnonnull +39 -> 118
    //   82: aload_0
    //   83: invokevirtual 415	com/google/android/gms/ads/internal/webview/t:getAdWebViewClient	()Lcom/google/android/gms/ads/internal/webview/ao;
    //   86: checkcast 417	com/google/android/gms/ads/internal/webview/j
    //   89: invokevirtual 946	com/google/android/gms/ads/internal/webview/j:e	()Landroid/view/ViewTreeObserver$OnScrollChangedListener;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +11 -> 105
    //   97: aload_0
    //   98: invokevirtual 969	com/google/android/gms/ads/internal/webview/t:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   101: aload_1
    //   102: invokevirtual 978	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 940	com/google/android/gms/ads/internal/webview/t:u	Z
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_0
    //   113: iconst_0
    //   114: invokespecial 592	com/google/android/gms/ads/internal/webview/t:b	(Z)V
    //   117: return
    //   118: getstatic 145	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   121: getfield 208	com/google/android/gms/ads/internal/bt:g	Lcom/google/android/gms/ads/internal/util/v;
    //   124: aload_0
    //   125: invokevirtual 969	com/google/android/gms/ads/internal/webview/t:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   128: aload_1
    //   129: invokevirtual 981	com/google/android/gms/ads/internal/util/v:a	(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   132: goto -50 -> 82
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	t
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
    if ((!g()) && ((Build.VERSION.SDK_INT != 21) || (!paramCanvas.isHardwareAccelerated()) || (isAttachedToWindow())))
    {
      super.onDraw(paramCanvas);
      if (((j)getAdWebViewClient() != null) && (((j)getAdWebViewClient()).k != null)) {
        ((j)getAdWebViewClient()).k.a();
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
    boolean bool = o();
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
        if ((isInEditMode()) || (this.s) || (this.K.f()))
        {
          super.onMeasure(paramInt1, paramInt2);
          continue;
        }
        if (!this.K.h()) {
          break label77;
        }
      }
      finally {}
      super.onMeasure(paramInt1, paramInt2);
      continue;
      if (this.K.g())
      {
        if (((Boolean)com.google.android.gms.ads.internal.f.n.am.a()).booleanValue())
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          localObject2 = getVideoController();
          if (localObject2 == null) {
            break label852;
          }
          f1 = ((w)localObject2).g();
          if (f1 != 0.0F)
          {
            i1 = View.MeasureSpec.getSize(paramInt1);
            i4 = View.MeasureSpec.getSize(paramInt2);
            paramInt1 = (int)(i4 * f1);
            paramInt2 = (int)(i1 / f1);
            if (i4 == 0) {
              break label833;
            }
            break label818;
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
      else if (this.K.d())
      {
        if ((((Boolean)com.google.android.gms.ads.internal.f.n.bU.a()).booleanValue()) || (!h.a()))
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          a("/contentHeight", new u(this));
          f("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
          f1 = this.m.density;
          i1 = View.MeasureSpec.getSize(paramInt1);
          paramInt1 = this.a;
        }
      }
      else {
        switch (paramInt1)
        {
        case -1: 
          for (;;)
          {
            label328:
            setMeasuredDimension(i1, paramInt1);
            break;
            paramInt1 = View.MeasureSpec.getSize(paramInt2);
          }
          if (!this.K.e()) {
            break label377;
          }
          setMeasuredDimension(this.m.widthPixels, this.m.heightPixels);
        }
      }
    }
    label377:
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == Integer.MIN_VALUE)
    {
      paramInt2 = i2;
      break label866;
      label414:
      localObject2 = this.K;
      if (((au)localObject2).b <= paramInt2) {
        if (((au)localObject2).a <= i1)
        {
          paramInt1 = 0;
          label441:
          if (((Boolean)com.google.android.gms.ads.internal.f.n.bb.a()).booleanValue())
          {
            localObject2 = this.K;
            i4 = ((au)localObject2).b;
            f1 = this.v;
            if (i4 / f1 <= paramInt2 / f1) {
              if (((au)localObject2).a / f1 <= i1 / f1)
              {
                paramInt2 = 1;
                break label880;
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
        localObject2 = this.K;
        paramInt1 = ((au)localObject2).b;
        f1 = this.v;
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
        if (this.R) {
          break;
        }
        this.b.a(g.i);
        this.R = true;
        break;
      }
      if (getVisibility() != 8) {
        setVisibility(0);
      }
      if (!this.S)
      {
        this.b.a(g.j);
        this.S = true;
      }
      localObject2 = this.K;
      setMeasuredDimension(((au)localObject2).b, ((au)localObject2).a);
      break;
      paramInt2 = 0;
      break label880;
      paramInt2 = 0;
      break label880;
      paramInt2 = paramInt1;
      continue;
      paramInt1 = 1;
      break label441;
      paramInt1 = 1;
      break label441;
      label818:
      label833:
      label852:
      label866:
      do
      {
        if (paramInt1 == 1073741824)
        {
          i1 = i3;
          break label414;
        }
        i1 = Integer.MAX_VALUE;
        break label414;
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
          paramInt1 = (int)(f1 * paramInt1);
          break label328;
        }
      } while (paramInt1 != Integer.MIN_VALUE);
      i1 = i3;
      break label414;
      label880:
      if (paramInt1 == 0) {
        paramInt2 = paramInt1;
      }
    }
  }
  
  public final void onPause()
  {
    if (!g()) {}
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
    if (!g()) {}
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
    if (((j)getAdWebViewClient()).c()) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.y;
        if (localObject == null)
        {
          if (!g()) {
            return super.onTouchEvent(paramMotionEvent);
          }
          return false;
        }
        ((r)localObject).a(paramMotionEvent);
        continue;
        localObject = this.L;
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
      this.c = paramAdOverlay;
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
      this.K = paramau;
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
      this.I = paramBoolean;
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
    this.h.setBaseContext(paramContext);
    this.B.a = this.h.a;
  }
  
  /* Error */
  public final void setCustomClose(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 776	com/google/android/gms/ads/internal/webview/t:c	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_0
    //   13: getfield 595	com/google/android/gms/ads/internal/webview/t:d	Lcom/google/android/gms/ads/internal/webview/j;
    //   16: invokevirtual 418	com/google/android/gms/ads/internal/webview/j:b	()Z
    //   19: iload_1
    //   20: invokevirtual 1179	com/google/android/gms/ads/internal/overlay/AdOverlay:a	(ZZ)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: iload_1
    //   28: putfield 857	com/google/android/gms/ads/internal/webview/t:i	Z
    //   31: goto -8 -> 23
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	t
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
    ((j)getAdWebViewClient()).f = paramBoolean;
  }
  
  public final void setInstreamAdEventListener(com.google.android.gms.ads.internal.formats.e parame)
  {
    try
    {
      this.o = parame;
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
    //   3: getfield 114	com/google/android/gms/ads/internal/webview/t:s	Z
    //   6: istore_2
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 114	com/google/android/gms/ads/internal/webview/t:s	Z
    //   12: aload_0
    //   13: invokespecial 220	com/google/android/gms/ads/internal/webview/t:s	()V
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpeq +27 -> 45
    //   21: new 445	com/google/android/gms/ads/internal/m/m
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 448	com/google/android/gms/ads/internal/m/m:<init>	(Lcom/google/android/gms/ads/internal/webview/i;)V
    //   29: astore 4
    //   31: iload_1
    //   32: ifne +16 -> 48
    //   35: ldc_w 1186
    //   38: astore_3
    //   39: aload 4
    //   41: aload_3
    //   42: invokevirtual 1187	com/google/android/gms/ads/internal/m/m:b	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: ldc_w 1189
    //   51: astore_3
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	t
    //   0	60	1	paramBoolean	boolean
    //   6	13	2	bool	boolean
    //   38	14	3	str	String
    //   55	4	3	localObject	Object
    //   29	11	4	localm	m
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
      this.y = paramr;
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
    try
    {
      this.z = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.A = new WeakReference(paramOnClickListener);
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
      this.D = str;
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
      this.E = paramInt;
      AdOverlay localAdOverlay = this.c;
      if (localAdOverlay != null) {
        localAdOverlay.a(this.E);
      }
      return;
    }
    finally {}
  }
  
  public final void setSecondPieceOverlay(AdOverlay paramAdOverlay)
  {
    try
    {
      this.H = paramAdOverlay;
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
    //   3: getfield 886	com/google/android/gms/ads/internal/webview/t:j	I
    //   6: istore_3
    //   7: iload_1
    //   8: ifne +38 -> 46
    //   11: iconst_m1
    //   12: istore_2
    //   13: aload_0
    //   14: iload_2
    //   15: iload_3
    //   16: iadd
    //   17: putfield 886	com/google/android/gms/ads/internal/webview/t:j	I
    //   20: aload_0
    //   21: getfield 886	com/google/android/gms/ads/internal/webview/t:j	I
    //   24: ifgt +19 -> 43
    //   27: aload_0
    //   28: getfield 776	com/google/android/gms/ads/internal/webview/t:c	Lcom/google/android/gms/ads/internal/overlay/AdOverlay;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +8 -> 43
    //   38: aload 4
    //   40: invokevirtual 1207	com/google/android/gms/ads/internal/overlay/AdOverlay:q	()V
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
    //   0	58	0	this	t
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
    //   3: getfield 902	com/google/android/gms/ads/internal/webview/t:O	Lcom/google/android/gms/ads/internal/webview/w;
    //   6: ifnull +12 -> 18
    //   9: ldc_w 1211
    //   12: invokestatic 1212	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 902	com/google/android/gms/ads/internal/webview/t:O	Lcom/google/android/gms/ads/internal/webview/w;
    //   23: goto -8 -> 15
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	t
    //   0	31	1	paramw	w
    // Exception table:
    //   from	to	target	type
    //   2	15	26	finally
    //   18	23	26	finally
  }
  
  public final void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof j)) {
      this.d = ((j)paramWebViewClient);
    }
  }
  
  public final void stopLoading()
  {
    if (!g()) {}
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */