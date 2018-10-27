package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.br;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.ac;
import com.google.android.gms.ads.internal.formats.a.am;
import com.google.android.gms.ads.internal.formats.m;
import com.google.android.gms.ads.internal.formats.p;
import com.google.android.gms.ads.internal.formats.r;
import com.google.android.gms.ads.internal.formats.s;
import com.google.android.gms.ads.internal.formats.x;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.mediation.client.q;
import com.google.android.gms.ads.internal.renderer.a.y;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.w;
import com.google.android.gms.common.internal.z;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@com.google.android.gms.ads.internal.q.a.a
public final class az
  extends c
  implements com.google.android.gms.ads.internal.formats.u
{
  public af k = new af();
  public int l = 1;
  public com.google.android.gms.ads.internal.webview.i m;
  public boolean n;
  public final String o = UUID.randomUUID().toString();
  public com.google.android.gms.ads.internal.webview.i p;
  private boolean q;
  private final Object r = new Object();
  private com.google.android.gms.ads.internal.renderer.a.u s;
  
  public az(Context paramContext, u paramu, AdSizeParcel paramAdSizeParcel, String paramString, b paramb, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramu, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, false);
  }
  
  public az(Context paramContext, u paramu, AdSizeParcel paramAdSizeParcel, String paramString, b paramb, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, paramu);
    this.q = paramBoolean;
  }
  
  static p a(com.google.android.gms.ads.internal.formats.v paramv)
  {
    p localp;
    if ((paramv instanceof com.google.android.gms.ads.internal.formats.k))
    {
      paramv = (com.google.android.gms.ads.internal.formats.k)paramv;
      localp = new p(paramv.g, paramv.h, paramv.c, paramv.k, paramv.d, paramv.a, -1.0D, null, null, paramv.b, paramv.l, paramv.m, paramv.i, paramv.j, paramv.f);
      com.google.android.gms.dynamic.e.a(paramv.e);
      paramv = com.google.android.gms.dynamic.e.a(com.google.android.gms.dynamic.e.a(paramv.e));
    }
    for (;;)
    {
      if ((paramv instanceof x)) {
        localp.a((x)paramv);
      }
      return localp;
      if ((paramv instanceof com.google.android.gms.ads.internal.formats.i))
      {
        paramv = (com.google.android.gms.ads.internal.formats.i)paramv;
        localp = new p(paramv.g, paramv.h, paramv.c, paramv.a, paramv.d, null, paramv.l, paramv.m, paramv.k, paramv.b, paramv.n, paramv.o, paramv.i, paramv.j, paramv.f);
        com.google.android.gms.dynamic.e.a(paramv.e);
        paramv = com.google.android.gms.dynamic.e.a(com.google.android.gms.dynamic.e.a(paramv.e));
      }
      else
      {
        localp = null;
        paramv = null;
      }
    }
  }
  
  static com.google.android.gms.ads.internal.request.u a(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    Bundle localBundle = paramAdRequestInfoParcel.b.f;
    if (localBundle != null) {}
    for (localBundle = new Bundle(localBundle);; localBundle = new Bundle())
    {
      localBundle.putString("_ad", paramString);
      paramString = paramAdRequestInfoParcel.b;
      paramString = new AdRequestParcel(paramString.u, paramString.b, localBundle, paramString.g, paramString.j, paramString.i, paramString.s, paramString.l, paramString.o, paramString.r, paramString.k, paramString.d, paramString.n, paramString.e, paramString.c, paramString.p, paramString.q, paramString.h, null, paramString.t, paramString.m);
      return new com.google.android.gms.ads.internal.request.u(paramAdRequestInfoParcel.a, paramString, paramAdRequestInfoParcel.c, paramAdRequestInfoParcel.d, paramAdRequestInfoParcel.k, paramAdRequestInfoParcel.N, paramAdRequestInfoParcel.X, paramAdRequestInfoParcel.Y, paramAdRequestInfoParcel.ae, paramAdRequestInfoParcel.aa, paramAdRequestInfoParcel.J, paramAdRequestInfoParcel.I, paramAdRequestInfoParcel.n, paramAdRequestInfoParcel.ac, paramAdRequestInfoParcel.W, paramAdRequestInfoParcel.V, paramAdRequestInfoParcel.U, paramAdRequestInfoParcel.af, paramAdRequestInfoParcel.o, paramAdRequestInfoParcel.P, paramAdRequestInfoParcel.s, paramAdRequestInfoParcel.Z, paramAdRequestInfoParcel.G, paramAdRequestInfoParcel.g, paramAdRequestInfoParcel.j, paramAdRequestInfoParcel.h, paramAdRequestInfoParcel.ab, paramAdRequestInfoParcel.e, paramAdRequestInfoParcel.y, paramAdRequestInfoParcel.z, h.a(paramAdRequestInfoParcel.ag), paramAdRequestInfoParcel.i, paramAdRequestInfoParcel.L, paramAdRequestInfoParcel.M, paramAdRequestInfoParcel.F, paramAdRequestInfoParcel.p, paramAdRequestInfoParcel.v, paramAdRequestInfoParcel.A, paramAdRequestInfoParcel.x, paramAdRequestInfoParcel.C, h.a(paramAdRequestInfoParcel.O), paramAdRequestInfoParcel.f, paramAdRequestInfoParcel.H, paramAdRequestInfoParcel.q, 1, paramAdRequestInfoParcel.B, paramAdRequestInfoParcel.r, paramAdRequestInfoParcel.D, paramAdRequestInfoParcel.t, paramAdRequestInfoParcel.m, paramAdRequestInfoParcel.w, paramAdRequestInfoParcel.u);
    }
  }
  
  static void a(bu parambu1, bu parambu2)
  {
    if (parambu2.z == null) {
      parambu2.z = parambu1.z;
    }
    if (parambu2.A == null) {
      parambu2.A = parambu1.A;
    }
    if (parambu2.B == null) {
      parambu2.B = parambu1.B;
    }
    if (parambu2.D == null) {
      parambu2.D = parambu1.D;
    }
    if (parambu2.Q == null) {
      parambu2.Q = parambu1.Q;
    }
    if (parambu2.x == null) {
      parambu2.x = parambu1.x;
    }
    if (parambu2.y == null) {
      parambu2.y = parambu1.y;
    }
    if (parambu2.i == null) {
      parambu2.i = parambu1.i;
    }
    if (parambu2.M == null) {
      parambu2.M = parambu1.M;
    }
    if (parambu2.a == null) {
      parambu2.a = parambu1.a;
    }
    if (parambu2.c == null) {
      parambu2.c = parambu1.c;
    }
    if (parambu2.g == null) {
      parambu2.g = parambu1.g;
    }
    if (parambu2.h == null) {
      parambu2.h = parambu1.h;
    }
    if (parambu2.G == null) {
      parambu2.G = parambu1.G;
    }
  }
  
  private final void a(com.google.android.gms.ads.internal.formats.i parami)
  {
    com.google.android.gms.ads.internal.util.n.a.post(new be(this, parami));
  }
  
  private final void a(com.google.android.gms.ads.internal.formats.k paramk)
  {
    com.google.android.gms.ads.internal.util.n.a.post(new bg(this, paramk));
  }
  
  private final void a(p paramp)
  {
    com.google.android.gms.ads.internal.util.n.a.post(new bf(this, paramp));
  }
  
  static void a(l paraml, int paramInt1, int paramInt2)
  {
    paraml.a("num_ads_requested", String.valueOf(paramInt2));
    paraml.a("ad_index", String.valueOf(paramInt1));
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    String str = null;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.m;
      if ((localObject2 != null) || (this.p != null))
      {
        localObject1 = this.p;
        if (localObject1 != null) {
          break label262;
        }
      }
    }
    label229:
    label262:
    for (int i = 0;; i = 1)
    {
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        if ((((com.google.android.gms.ads.internal.webview.i)localObject1).getWebView() != null) && (bt.A.y.a(this.g.m)))
        {
          localObject2 = this.g.P;
          int j = ((VersionInfoParcel)localObject2).b;
          int i1 = ((VersionInfoParcel)localObject2).c;
          localObject2 = new StringBuilder(23);
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(".");
          ((StringBuilder)localObject2).append(i1);
          localObject2 = ((StringBuilder)localObject2).toString();
          this.i = bt.A.y.a((String)localObject2, ((com.google.android.gms.ads.internal.webview.i)localObject1).getWebView(), "", "javascript", str, paramString);
          paramString = this.i;
          if (paramString != null)
          {
            ((com.google.android.gms.ads.internal.webview.i)localObject1).setOmidSession(paramString);
            if (i != 0)
            {
              paramString = this.i;
              localObject1 = this.p.getView();
              if (localObject1 != null) {
                break label229;
              }
            }
          }
        }
        for (;;)
        {
          bt.A.y.a(this.i);
          return;
          bt.A.y.a(paramString, (View)localObject1);
        }
        if (i != 0) {
          str = "javascript";
        } else {
          localObject1 = null;
        }
      }
    }
  }
  
  private final boolean ac()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    return (locala != null) && (locala.x);
  }
  
  private final com.google.android.gms.ads.internal.mediation.c ad()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if ((locala != null) && (locala.u)) {
      return locala.E;
    }
    return null;
  }
  
  private final void ae()
  {
    com.google.android.gms.ads.internal.renderer.a.u localu = Z();
    if (localu != null) {
      localu.a();
    }
  }
  
  public final void F()
  {
    Object localObject1 = this.g.h.B;
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).h();
        if (localObject3 == null)
        {
          localObject3 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).i();
          if (localObject3 == null)
          {
            localObject1 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).n();
            if (localObject1 == null) {
              break label111;
            }
            localObject1 = ((ac)localObject1).g();
            if (localObject1 != null)
            {
              localObject1 = ((bo)localObject1).i();
              if (localObject1 != null) {
                ((br)localObject1).d();
              }
            }
          }
          else
          {
            localObject1 = ((q)localObject3).l();
            continue;
          }
        }
        else
        {
          localObject1 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject3).m();
          continue;
          super.F();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
      }
      return;
      label111:
      Object localObject2 = null;
    }
  }
  
  public final void G()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if ((locala != null) && ("com.google.ads.mediation.admob.AdMobAdapter".equals(locala.C)))
    {
      s();
      return;
    }
    super.G();
  }
  
  public final void L()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if ((locala != null) && ("com.google.ads.mediation.admob.AdMobAdapter".equals(locala.C)))
    {
      r();
      return;
    }
    super.L();
  }
  
  public final void P()
  {
    throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
  }
  
  public final void S()
  {
    if ((ac()) && (this.i != null))
    {
      com.google.android.gms.ads.internal.webview.i locali2 = this.m;
      com.google.android.gms.ads.internal.webview.i locali1 = locali2;
      if (locali2 == null)
      {
        locali2 = this.p;
        locali1 = locali2;
        if (locali2 == null) {
          locali1 = null;
        }
      }
      if (locali1 != null) {
        locali1.a("onSdkImpression", new HashMap());
      }
    }
  }
  
  public final void T()
  {
    this.i = null;
    com.google.android.gms.ads.internal.webview.i locali = this.m;
    if (locali != null)
    {
      locali.destroy();
      this.m = null;
    }
  }
  
  public final void U()
  {
    com.google.android.gms.ads.internal.webview.i locali = this.p;
    if (locali != null)
    {
      locali.destroy();
      this.p = null;
    }
  }
  
  public final boolean V()
  {
    if (ad() != null) {
      return ad().e;
    }
    return false;
  }
  
  public final boolean W()
  {
    if (ad() != null) {
      return ad().d;
    }
    return false;
  }
  
  public final boolean X()
  {
    if (ad() != null) {
      return ad().c;
    }
    return false;
  }
  
  final void Y()
  {
    synchronized (this.r)
    {
      com.google.android.gms.ads.internal.util.e.a("Initializing webview native ads utills");
      bu localbu = this.g;
      this.s = new y(localbu.m, this, this.o, localbu.N, localbu.P);
      return;
    }
  }
  
  public final com.google.android.gms.ads.internal.renderer.a.u Z()
  {
    synchronized (this.r)
    {
      com.google.android.gms.ads.internal.renderer.a.u localu = this.s;
      return localu;
    }
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected final void a(int paramInt, boolean paramBoolean)
  {
    ae();
    super.a(paramInt, paramBoolean);
  }
  
  public final void a(r paramr)
  {
    com.google.android.gms.ads.internal.webview.i locali = this.p;
    if (locali != null) {
      locali.setNativeMediaViewEventListener(paramr);
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.formats.t paramt)
  {
    Object localObject = this.g;
    if ((((bu)localObject).h.a != null) && (((bu)localObject).q == null))
    {
      localObject = bt.A.i.a;
      bu localbu = this.g;
      ((com.google.android.gms.ads.internal.a.c)localObject).a(localbu.g, localbu.h, new com.google.android.gms.ads.internal.a.f(paramt), null);
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.h.a.e parame)
  {
    throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
  }
  
  protected final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    if (parama != null) {}
    for (parama = com.google.android.gms.dynamic.e.a(parama);; parama = null)
    {
      if ((parama instanceof com.google.android.gms.ads.internal.formats.t)) {
        ((com.google.android.gms.ads.internal.formats.t)parama).e();
      }
      super.b(this.g.h, false);
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.p.a.a parama)
  {
    throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
  }
  
  /* Error */
  public final void a(com.google.android.gms.ads.internal.v.b paramb, l paraml)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 704	com/google/android/gms/ads/internal/v/b:g	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +12 -> 20
    //   11: aload_0
    //   12: getfield 462	com/google/android/gms/ads/internal/az:g	Lcom/google/android/gms/ads/internal/bu;
    //   15: aload 6
    //   17: putfield 390	com/google/android/gms/ads/internal/bu:g	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   20: aload_1
    //   21: getfield 706	com/google/android/gms/ads/internal/v/b:h	I
    //   24: bipush -2
    //   26: if_icmpeq +20 -> 46
    //   29: getstatic 402	com/google/android/gms/ads/internal/util/n:a	Landroid/os/Handler;
    //   32: new 708	com/google/android/gms/ads/internal/ba
    //   35: dup
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 711	com/google/android/gms/ads/internal/ba:<init>	(Lcom/google/android/gms/ads/internal/az;Lcom/google/android/gms/ads/internal/v/b;)V
    //   41: invokevirtual 413	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   44: pop
    //   45: return
    //   46: aload_1
    //   47: getfield 714	com/google/android/gms/ads/internal/v/b:d	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   50: getfield 716	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:E	I
    //   53: istore 5
    //   55: iload 5
    //   57: iconst_1
    //   58: if_icmpne +107 -> 165
    //   61: aload_0
    //   62: getfield 462	com/google/android/gms/ads/internal/az:g	Lcom/google/android/gms/ads/internal/bu;
    //   65: astore 6
    //   67: aload 6
    //   69: iconst_0
    //   70: putfield 718	com/google/android/gms/ads/internal/bu:H	I
    //   73: getstatic 456	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   76: getfield 721	com/google/android/gms/ads/internal/bt:d	Lcom/google/android/gms/ads/internal/renderer/e;
    //   79: astore 7
    //   81: aload_0
    //   82: getfield 462	com/google/android/gms/ads/internal/az:g	Lcom/google/android/gms/ads/internal/bu;
    //   85: astore 7
    //   87: aload 6
    //   89: aload 7
    //   91: getfield 465	com/google/android/gms/ads/internal/bu:m	Landroid/content/Context;
    //   94: aload_0
    //   95: aload_1
    //   96: aload 7
    //   98: getfield 640	com/google/android/gms/ads/internal/bu:N	Lcom/google/android/gms/ads/internal/zxxz/aa;
    //   101: aconst_null
    //   102: aload_0
    //   103: getfield 724	com/google/android/gms/ads/internal/az:j	Lcom/google/android/gms/ads/internal/mediation/client/b;
    //   106: aload_0
    //   107: aload_2
    //   108: invokestatic 729	com/google/android/gms/ads/internal/renderer/e:a	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/a;Lcom/google/android/gms/ads/internal/v/b;Lcom/google/android/gms/ads/internal/zxxz/aa;Lcom/google/android/gms/ads/internal/webview/i;Lcom/google/android/gms/ads/internal/mediation/client/b;Lcom/google/android/gms/ads/internal/renderer/f;Lcom/google/android/gms/ads/internal/g/l;)Lcom/google/android/gms/ads/internal/util/ag;
    //   111: putfield 732	com/google/android/gms/ads/internal/bu:f	Lcom/google/android/gms/ads/internal/util/ag;
    //   114: aload_0
    //   115: getfield 462	com/google/android/gms/ads/internal/az:g	Lcom/google/android/gms/ads/internal/bu;
    //   118: getfield 732	com/google/android/gms/ads/internal/bu:f	Lcom/google/android/gms/ads/internal/util/ag;
    //   121: invokevirtual 736	java/lang/Object:getClass	()Ljava/lang/Class;
    //   124: invokevirtual 741	java/lang/Class:getName	()Ljava/lang/String;
    //   127: invokestatic 744	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 748	java/lang/String:length	()I
    //   135: ifne +19 -> 154
    //   138: new 430	java/lang/String
    //   141: dup
    //   142: ldc_w 750
    //   145: invokespecial 751	java/lang/String:<init>	(Ljava/lang/String;)V
    //   148: astore_1
    //   149: aload_1
    //   150: invokestatic 753	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   153: return
    //   154: ldc_w 750
    //   157: aload_1
    //   158: invokevirtual 757	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore_1
    //   162: goto -13 -> 149
    //   165: new 759	org/json/JSONArray
    //   168: dup
    //   169: invokespecial 760	org/json/JSONArray:<init>	()V
    //   172: astore 6
    //   174: new 762	org/json/JSONObject
    //   177: dup
    //   178: aload_1
    //   179: getfield 765	com/google/android/gms/ads/internal/v/b:e	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   182: getfield 769	com/google/android/gms/ads/internal/request/AdResponseParcel:f	Ljava/lang/String;
    //   185: invokespecial 770	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   188: ldc_w 772
    //   191: invokevirtual 776	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   194: astore_2
    //   195: iconst_0
    //   196: istore_3
    //   197: aload_2
    //   198: invokevirtual 777	org/json/JSONArray:length	()I
    //   201: istore 4
    //   203: iload_3
    //   204: iload 4
    //   206: if_icmplt +137 -> 343
    //   209: aload_0
    //   210: invokespecial 650	com/google/android/gms/ads/internal/az:ae	()V
    //   213: new 779	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 780	java/util/ArrayList:<init>	()V
    //   220: astore_2
    //   221: iconst_0
    //   222: istore_3
    //   223: iload_3
    //   224: iload 5
    //   226: if_icmpge +34 -> 260
    //   229: aload_2
    //   230: new 782	com/google/android/gms/ads/internal/bc
    //   233: dup
    //   234: aload_0
    //   235: iload_3
    //   236: aload 6
    //   238: iload 5
    //   240: aload_1
    //   241: invokespecial 785	com/google/android/gms/ads/internal/bc:<init>	(Lcom/google/android/gms/ads/internal/az;ILorg/json/JSONArray;ILcom/google/android/gms/ads/internal/v/b;)V
    //   244: invokestatic 790	com/google/android/gms/ads/internal/util/l:a	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/ads/internal/util/a/v;
    //   247: invokeinterface 795 2 0
    //   252: pop
    //   253: iload_3
    //   254: iconst_1
    //   255: iadd
    //   256: istore_3
    //   257: goto -34 -> 223
    //   260: iconst_0
    //   261: istore_3
    //   262: iload_3
    //   263: aload_2
    //   264: invokeinterface 798 1 0
    //   269: if_icmpge -224 -> 45
    //   272: aload_2
    //   273: iload_3
    //   274: invokeinterface 802 2 0
    //   279: checkcast 804	com/google/android/gms/ads/internal/util/a/v
    //   282: astore_1
    //   283: getstatic 810	com/google/android/gms/ads/internal/f/n:bq	Lcom/google/android/gms/ads/internal/f/c;
    //   286: astore 6
    //   288: aload_1
    //   289: getstatic 815	com/google/android/gms/ads/internal/client/u:h	Lcom/google/android/gms/ads/internal/client/u;
    //   292: getfield 818	com/google/android/gms/ads/internal/client/u:e	Lcom/google/android/gms/ads/internal/f/k;
    //   295: aload 6
    //   297: invokevirtual 823	com/google/android/gms/ads/internal/f/k:a	(Lcom/google/android/gms/ads/internal/f/c;)Ljava/lang/Object;
    //   300: checkcast 825	java/lang/Long
    //   303: invokevirtual 829	java/lang/Long:longValue	()J
    //   306: getstatic 835	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   309: invokeinterface 838 4 0
    //   314: checkcast 840	com/google/android/gms/ads/internal/formats/v
    //   317: astore_1
    //   318: getstatic 402	com/google/android/gms/ads/internal/util/n:a	Landroid/os/Handler;
    //   321: new 842	com/google/android/gms/ads/internal/bd
    //   324: dup
    //   325: aload_0
    //   326: aload_1
    //   327: iload_3
    //   328: aload_2
    //   329: invokespecial 845	com/google/android/gms/ads/internal/bd:<init>	(Lcom/google/android/gms/ads/internal/az;Lcom/google/android/gms/ads/internal/formats/v;ILjava/util/List;)V
    //   332: invokevirtual 413	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   335: pop
    //   336: iload_3
    //   337: iconst_1
    //   338: iadd
    //   339: istore_3
    //   340: goto -78 -> 262
    //   343: aload_2
    //   344: iload_3
    //   345: invokevirtual 849	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   348: ldc_w 851
    //   351: invokevirtual 854	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   354: astore 7
    //   356: iconst_0
    //   357: istore 4
    //   359: goto +85 -> 444
    //   362: iload 4
    //   364: aload 7
    //   366: invokevirtual 777	org/json/JSONArray:length	()I
    //   369: if_icmpge +80 -> 449
    //   372: aload 6
    //   374: aload 7
    //   376: iload 4
    //   378: invokevirtual 855	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   381: invokevirtual 859	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   384: pop
    //   385: iload 4
    //   387: iconst_1
    //   388: iadd
    //   389: istore 4
    //   391: goto +53 -> 444
    //   394: astore_1
    //   395: ldc_w 861
    //   398: aload_1
    //   399: invokestatic 863	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: aload_0
    //   403: iconst_0
    //   404: invokevirtual 865	com/google/android/gms/ads/internal/a:a	(I)V
    //   407: return
    //   408: astore_1
    //   409: ldc_w 495
    //   412: aload_1
    //   413: invokestatic 868	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   416: invokestatic 874	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   419: invokevirtual 877	java/lang/Thread:interrupt	()V
    //   422: goto -86 -> 336
    //   425: astore_1
    //   426: ldc_w 495
    //   429: aload_1
    //   430: invokestatic 868	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   433: goto -97 -> 336
    //   436: astore_1
    //   437: goto -11 -> 426
    //   440: astore_1
    //   441: goto -15 -> 426
    //   444: aload 7
    //   446: ifnonnull -84 -> 362
    //   449: iload_3
    //   450: iconst_1
    //   451: iadd
    //   452: istore_3
    //   453: goto -256 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	az
    //   0	456	1	paramb	com.google.android.gms.ads.internal.v.b
    //   0	456	2	paraml	l
    //   196	257	3	i	int
    //   201	189	4	j	int
    //   53	186	5	i1	int
    //   4	369	6	localObject1	Object
    //   79	366	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   174	195	394	org/json/JSONException
    //   197	203	394	org/json/JSONException
    //   343	356	394	org/json/JSONException
    //   362	385	394	org/json/JSONException
    //   272	336	408	java/lang/InterruptedException
    //   272	336	425	java/util/concurrent/ExecutionException
    //   272	336	436	java/util/concurrent/CancellationException
    //   272	336	440	java/util/concurrent/TimeoutException
  }
  
  public final boolean a(AdRequestParcel paramAdRequestParcel, l paraml)
  {
    try
    {
      Y();
      return super.a(paramAdRequestParcel, paraml, this.l);
    }
    catch (Exception paramAdRequestParcel)
    {
      com.google.android.gms.ads.internal.util.e.d("Error initializing webview.", paramAdRequestParcel);
    }
    return false;
  }
  
  protected final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    return this.f.c;
  }
  
  protected final boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    b(null);
    if (!this.g.c()) {
      throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }
    Object localObject4;
    label77:
    Object localObject3;
    label97:
    Object localObject5;
    label117:
    label348:
    label671:
    label749:
    label831:
    Object localObject2;
    if (parama2.u)
    {
      ae();
      for (;;)
      {
        String str1;
        List localList;
        String str2;
        String str3;
        String str4;
        double d;
        Object localObject6;
        Object localObject7;
        bo localbo;
        try
        {
          localObject1 = parama2.B;
          if (localObject1 == null) {
            break label1314;
          }
          localObject4 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).p();
          localObject1 = parama2.B;
          if (localObject1 == null) {
            break label1308;
          }
          localObject1 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).h();
          localObject3 = parama2.B;
          if (localObject3 == null) {
            break label1302;
          }
          localObject3 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject3).i();
          localObject5 = parama2.B;
          if (localObject5 == null) {
            break;
          }
          localObject5 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject5).n();
          str1 = c(parama2);
          if ((localObject4 == null) || (this.g.F == null)) {
            continue;
          }
          localObject5 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).a();
          localList = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).b();
          str2 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).c();
          if (((com.google.android.gms.ads.internal.mediation.client.t)localObject4).d() == null) {
            continue;
          }
          localObject1 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).d();
          str3 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).e();
          str4 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).f();
          d = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).g();
          localObject6 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).h();
          localObject7 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).i();
          localbo = ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).j();
          if (((com.google.android.gms.ads.internal.mediation.client.t)localObject4).m() == null) {
            continue;
          }
          localObject3 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.t)localObject4).m());
          localObject1 = new p((String)localObject5, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject1, str3, str4, d, (String)localObject6, (String)localObject7, null, localbo, (View)localObject3, ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).n(), str1, ((com.google.android.gms.ads.internal.mediation.client.t)localObject4).o());
          localObject3 = this.g;
          ((p)localObject1).a(new s(((bu)localObject3).m, this, ((bu)localObject3).N, (com.google.android.gms.ads.internal.mediation.client.t)localObject4, (com.google.android.gms.ads.internal.formats.v)localObject1));
          a((p)localObject1);
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject1;
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
          continue;
          localObject4 = null;
          continue;
          localObject3 = null;
          continue;
          if (localRemoteException == null) {
            break label831;
          }
        }
        return super.a(parama1, parama2);
        localObject3 = null;
        continue;
        localObject1 = null;
        continue;
        if ((localObject1 != null) && (this.g.F != null))
        {
          localObject5 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).a();
          localList = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).b();
          str2 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).c();
          if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d() != null)
          {
            localObject3 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d();
            str3 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).e();
            d = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).f();
            str4 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).g();
            localObject6 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).h();
            localObject7 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).m();
            if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p() != null)
            {
              localObject4 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p());
              localObject3 = new p((String)localObject5, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject3, str3, null, d, str4, (String)localObject6, null, (bo)localObject7, (View)localObject4, ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).q(), str1, ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).l());
              localObject4 = this.g;
              ((p)localObject3).a(new s(((bu)localObject4).m, this, ((bu)localObject4).N, (com.google.android.gms.ads.internal.mediation.client.n)localObject1, (com.google.android.gms.ads.internal.formats.v)localObject3));
              a((p)localObject3);
              continue;
            }
          }
        }
        if (this.g.z != null)
        {
          localObject5 = localRemoteException.a();
          localList = localRemoteException.b();
          str2 = localRemoteException.c();
          if (localRemoteException.d() == null) {
            break label1664;
          }
          localObject3 = localRemoteException.d();
          str3 = localRemoteException.e();
          d = localRemoteException.f();
          str4 = localRemoteException.g();
          localObject6 = localRemoteException.h();
          localObject7 = localRemoteException.l();
          localbo = localRemoteException.m();
          if (localRemoteException.p() == null) {
            break label1658;
          }
          localObject4 = (View)com.google.android.gms.dynamic.e.a(localRemoteException.p());
          localObject3 = new com.google.android.gms.ads.internal.formats.i((String)localObject5, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject3, str3, d, str4, (String)localObject6, null, (Bundle)localObject7, localbo, (View)localObject4, localRemoteException.q(), str1);
          localObject4 = this.g;
          ((com.google.android.gms.ads.internal.formats.i)localObject3).a(new s(((bu)localObject4).m, this, ((bu)localObject4).N, localRemoteException, (com.google.android.gms.ads.internal.formats.v)localObject3));
          a((com.google.android.gms.ads.internal.formats.i)localObject3);
        }
        else if ((localObject3 != null) && (this.g.F != null))
        {
          localObject5 = ((q)localObject3).a();
          localList = ((q)localObject3).b();
          str2 = ((q)localObject3).c();
          if (((q)localObject3).d() == null) {
            break label1676;
          }
          localObject2 = ((q)localObject3).d();
          label892:
          str3 = ((q)localObject3).e();
          str4 = ((q)localObject3).f();
          localObject6 = ((q)localObject3).l();
          if (((q)localObject3).n() == null) {
            break label1670;
          }
          localObject4 = (View)com.google.android.gms.dynamic.e.a(((q)localObject3).n());
          label944:
          localObject2 = new p((String)localObject5, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject2, str3, str4, -1.0D, null, null, null, (bo)localObject6, (View)localObject4, ((q)localObject3).o(), str1, ((q)localObject3).j());
          localObject4 = this.g;
          ((p)localObject2).a(new s(((bu)localObject4).m, this, ((bu)localObject4).N, (q)localObject3, (com.google.android.gms.ads.internal.formats.v)localObject2));
          a((p)localObject2);
        }
        else
        {
          if ((localObject3 == null) || (this.g.A == null)) {
            break label1694;
          }
          localObject5 = ((q)localObject3).a();
          localList = ((q)localObject3).b();
          str2 = ((q)localObject3).c();
          if (((q)localObject3).d() == null) {
            break label1688;
          }
          localObject2 = ((q)localObject3).d();
          label1094:
          str3 = ((q)localObject3).e();
          str4 = ((q)localObject3).f();
          localObject6 = ((q)localObject3).j();
          localObject7 = ((q)localObject3).l();
          if (((q)localObject3).n() == null) {
            break label1682;
          }
          localObject4 = (View)com.google.android.gms.dynamic.e.a(((q)localObject3).n());
          label1155:
          localObject2 = new com.google.android.gms.ads.internal.formats.k((String)localObject5, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject2, str3, str4, null, (Bundle)localObject6, (bo)localObject7, (View)localObject4, ((q)localObject3).o(), str1);
          localObject4 = this.g;
          ((com.google.android.gms.ads.internal.formats.k)localObject2).a(new s(((bu)localObject4).m, this, ((bu)localObject4).N, (q)localObject3, (com.google.android.gms.ads.internal.formats.v)localObject2));
          a((com.google.android.gms.ads.internal.formats.k)localObject2);
        }
      }
    }
    for (;;)
    {
      label1234:
      com.google.android.gms.ads.internal.util.e.e("No matching mapper/listener for retrieved native ad template.");
      a(0);
      return false;
      label1302:
      label1308:
      label1314:
      label1595:
      label1658:
      label1664:
      label1670:
      label1676:
      label1682:
      label1688:
      label1694:
      do
      {
        localObject2 = this.g.D;
        if ((localObject2 == null) || (((android.support.v4.g.v)localObject2).get(((ac)localObject5).c()) == null)) {
          break label1234;
        }
        com.google.android.gms.ads.internal.util.n.a.post(new bi(this, (ac)localObject5));
        break label348;
        localObject5 = null;
        break label117;
        localObject3 = null;
        break label97;
        localObject2 = null;
        break label77;
        localObject4 = null;
        break;
        localObject2 = parama2.H;
        if (this.q)
        {
          a("Google", parama2.x);
          this.k.b(localObject2);
          break label348;
        }
        boolean bool = localObject2 instanceof com.google.android.gms.ads.internal.formats.k;
        if ((bool) && (this.g.F != null))
        {
          a("Google", parama2.x);
          a(a(parama2.H));
          break label348;
        }
        if (!bool) {}
        while (this.g.A == null)
        {
          bool = localObject2 instanceof com.google.android.gms.ads.internal.formats.i;
          if ((bool) && (this.g.F != null))
          {
            a("Google", parama2.x);
            a(a(parama2.H));
            break;
          }
          if ((bool) && (this.g.z != null))
          {
            a("Google", parama2.x);
            a((com.google.android.gms.ads.internal.formats.i)parama2.H);
            break;
          }
          if ((localObject2 instanceof m))
          {
            localObject3 = this.g.D;
            if (localObject3 != null)
            {
              localObject4 = (m)localObject2;
              if (((android.support.v4.g.v)localObject3).get(((m)localObject4).a) != null) {
                break label1595;
              }
            }
          }
          if (((localObject2 instanceof com.google.android.gms.ads.internal.formats.f)) && (this.g.r != null))
          {
            localObject2 = (com.google.android.gms.ads.internal.formats.f)localObject2;
            com.google.android.gms.ads.internal.util.n.a.post(new bb(this, (com.google.android.gms.ads.internal.formats.f)localObject2));
            break;
          }
          com.google.android.gms.ads.internal.util.e.e("No matching listener for retrieved native ad template.");
          a(0);
          return false;
          localObject2 = ((m)localObject4).a;
          com.google.android.gms.ads.internal.util.n.a.post(new bh(this, (String)localObject2, parama2));
          break;
        }
        a("Google", parama2.x);
        a((com.google.android.gms.ads.internal.formats.k)parama2.H);
        break label348;
        localObject4 = null;
        break label749;
        localObject3 = null;
        break label671;
        localObject4 = null;
        break label944;
        localObject2 = null;
        break label892;
        localObject4 = null;
        break label1155;
        localObject2 = null;
        break label1094;
      } while (localObject5 != null);
    }
  }
  
  public final void aa()
  {
    if ((this.g.h == null) || (this.p == null))
    {
      this.n = true;
      com.google.android.gms.ads.internal.util.e.e("Request to enable ActiveView before adState is available.");
      return;
    }
    com.google.android.gms.ads.internal.a.c localc = bt.A.i.a;
    bu localbu = this.g;
    localc.a(localbu.g, localbu.h, this.p.getView(), this.p);
    this.n = false;
  }
  
  public final void ab()
  {
    Object localObject = this.p;
    if ((localObject != null) && (((com.google.android.gms.ads.internal.webview.i)localObject).getVideoController() != null))
    {
      localObject = this.g.x;
      if ((localObject != null) && (((NativeAdOptionsParcel)localObject).f != null)) {
        this.p.getVideoController().a(this.g.x.f);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.g.r == null);
      localObject = this.p;
    } while ((localObject == null) || (((com.google.android.gms.ads.internal.webview.i)localObject).getVideoController() == null));
    this.p.getVideoController().a(false, true, false);
  }
  
  public final void b(View paramView)
  {
    com.google.android.gms.ads.internal.webview.i locali = this.m;
    if ((ac()) && (this.i != null) && (locali != null) && (paramView != null)) {
      bt.A.y.a(this.i, paramView);
    }
  }
  
  public final void b(List paramList)
  {
    z.a("setNativeTemplates must be called on the main UI thread.");
    this.g.y = paramList;
  }
  
  public final am c(String paramString)
  {
    z.a("getOnCustomClickListener must be called on the main UI thread.");
    android.support.v4.g.v localv = this.g.B;
    if (localv != null) {
      return (am)localv.get(paramString);
    }
    return null;
  }
  
  protected final void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.n)
    {
      com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.as;
      if (((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue()) {
        aa();
      }
    }
  }
  
  public final void h()
  {
    throw new IllegalStateException("Native Ad DOES NOT support pause().");
  }
  
  public final void i()
  {
    throw new IllegalStateException("Native Ad DOES NOT support resume().");
  }
  
  protected final void q()
  {
    c(false);
  }
  
  public final String w()
  {
    return this.g.j;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */