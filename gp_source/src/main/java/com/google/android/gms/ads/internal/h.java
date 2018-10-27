package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.common.internal.z;

@com.google.android.gms.ads.internal.q.a.a
public abstract class h
  extends c
  implements ae, com.google.android.gms.ads.internal.m.n
{
  private boolean k;
  
  public h(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel, u paramu)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, paramu);
  }
  
  public final void S()
  {
    e();
  }
  
  public final void T()
  {
    M();
    g();
  }
  
  protected final boolean U()
  {
    Object localObject = this.g.G;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.b)localObject).e;
      if ((localObject != null) && (((AdResponseParcel)localObject).C)) {
        return true;
      }
    }
    return false;
  }
  
  public final void V()
  {
    p();
  }
  
  public final void W()
  {
    n();
  }
  
  protected com.google.android.gms.ads.internal.webview.i a(com.google.android.gms.ads.internal.v.b paramb, v paramv, com.google.android.gms.ads.internal.safebrowsing.k paramk)
  {
    Object localObject1 = this.g.b.getNextView();
    if ((localObject1 instanceof com.google.android.gms.ads.internal.webview.i)) {
      ((com.google.android.gms.ads.internal.webview.i)localObject1).destroy();
    }
    if (localObject1 == null) {}
    for (;;)
    {
      localObject1 = bt.A.f;
      Object localObject2 = this.g;
      localObject1 = ((bu)localObject2).m;
      localObject2 = au.a(((bu)localObject2).g);
      bu localbu = this.g;
      localObject1 = AdWebViewFactory.a((Context)localObject1, (au)localObject2, localbu.g.a, false, false, localbu.N, localbu.P, this.h, this, this.c, paramb.c);
      if (this.g.g.h == null) {
        a(((com.google.android.gms.ads.internal.webview.i)localObject1).getView());
      }
      ((com.google.android.gms.ads.internal.webview.i)localObject1).getAdWebViewClient().a(this, this, this, this, this, false, null, paramv, this, paramk);
      a((com.google.android.gms.ads.internal.webview.i)localObject1);
      ((com.google.android.gms.ads.internal.webview.i)localObject1).setRequestId(paramb.d.P);
      return (com.google.android.gms.ads.internal.webview.i)localObject1;
      this.g.b.removeView((View)localObject1);
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.h.a.e parame)
  {
    z.a("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    this.g.C = parame;
  }
  
  protected void a(com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.g.l paraml)
  {
    if (paramb.h != -2)
    {
      com.google.android.gms.ads.internal.util.n.a.post(new j(this, paramb));
      return;
    }
    Object localObject1 = paramb.g;
    if (localObject1 != null) {
      this.g.g = ((AdSizeParcel)localObject1);
    }
    localObject1 = paramb.e;
    if ((((AdResponseParcel)localObject1).y) && (!((AdResponseParcel)localObject1).A))
    {
      localObject1 = this.g;
      ((bu)localObject1).H = 0;
      localObject2 = bt.A.d;
      localObject2 = this.g;
      ((bu)localObject1).f = com.google.android.gms.ads.internal.renderer.e.a(((bu)localObject2).m, this, paramb, ((bu)localObject2).N, null, this.j, this, paraml);
      return;
    }
    Object localObject2 = this.c.c;
    bu localbu = this.g;
    localObject1 = ((com.google.android.gms.ads.internal.safebrowsing.l)localObject2).a(localbu.m, localbu.P, (AdResponseParcel)localObject1);
    com.google.android.gms.ads.internal.util.n.a.post(new k(this, paramb, (com.google.android.gms.ads.internal.safebrowsing.k)localObject1, paraml));
  }
  
  protected final void a(com.google.android.gms.ads.internal.webview.i parami)
  {
    parami.a("/trackActiveViewUnit", new i(this));
  }
  
  /* Error */
  protected boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/android/gms/ads/internal/h:g	Lcom/google/android/gms/ads/internal/bu;
    //   4: invokevirtual 247	com/google/android/gms/ads/internal/bu:c	()Z
    //   7: ifeq +29 -> 36
    //   10: aload_0
    //   11: getfield 35	com/google/android/gms/ads/internal/h:g	Lcom/google/android/gms/ads/internal/bu;
    //   14: getfield 65	com/google/android/gms/ads/internal/bu:b	Lcom/google/android/gms/ads/internal/bv;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnull +15 -> 36
    //   24: aload 4
    //   26: invokevirtual 251	com/google/android/gms/ads/internal/bv:getDebugGestureDetector	()Lcom/google/android/gms/ads/internal/util/ah;
    //   29: aload_2
    //   30: getfield 256	com/google/android/gms/ads/internal/v/a:i	Ljava/lang/String;
    //   33: putfield 260	com/google/android/gms/ads/internal/util/ah:d	Ljava/lang/String;
    //   36: aload_2
    //   37: getfield 263	com/google/android/gms/ads/internal/v/a:g	Lcom/google/android/gms/ads/internal/webview/i;
    //   40: ifnull +44 -> 84
    //   43: aload_2
    //   44: getfield 266	com/google/android/gms/ads/internal/v/a:u	Z
    //   47: ifne +37 -> 84
    //   50: aload_2
    //   51: getfield 268	com/google/android/gms/ads/internal/v/a:P	Z
    //   54: ifeq +30 -> 84
    //   57: aload_2
    //   58: getfield 271	com/google/android/gms/ads/internal/v/a:d	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   61: getfield 276	com/google/android/gms/ads/internal/client/AdRequestParcel:f	Landroid/os/Bundle;
    //   64: ldc_w 278
    //   67: invokevirtual 284	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   70: istore_3
    //   71: iload_3
    //   72: ifne +12 -> 84
    //   75: aload_2
    //   76: getfield 263	com/google/android/gms/ads/internal/v/a:g	Lcom/google/android/gms/ads/internal/webview/i;
    //   79: invokeinterface 285 1 0
    //   84: aload_2
    //   85: ifnull +25 -> 110
    //   88: aload_2
    //   89: getfield 263	com/google/android/gms/ads/internal/v/a:g	Lcom/google/android/gms/ads/internal/webview/i;
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +14 -> 110
    //   99: aload 4
    //   101: aload_2
    //   102: getfield 287	com/google/android/gms/ads/internal/v/a:N	Z
    //   105: invokeinterface 290 2 0
    //   110: aload_0
    //   111: aload_1
    //   112: aload_2
    //   113: invokespecial 292	com/google/android/gms/ads/internal/c:a	(Lcom/google/android/gms/ads/internal/v/a;Lcom/google/android/gms/ads/internal/v/a;)Z
    //   116: ireturn
    //   117: astore 4
    //   119: ldc_w 294
    //   122: invokestatic 297	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   125: goto -41 -> 84
    //   128: astore 4
    //   130: ldc_w 299
    //   133: invokestatic 297	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   136: goto -52 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	h
    //   0	139	1	parama1	com.google.android.gms.ads.internal.v.a
    //   0	139	2	parama2	com.google.android.gms.ads.internal.v.a
    //   70	2	3	bool	boolean
    //   17	83	4	localObject1	Object
    //   117	1	4	localRuntimeException	RuntimeException
    //   128	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	71	117	java/lang/RuntimeException
    //   130	136	117	java/lang/RuntimeException
    //   75	84	128	finally
  }
  
  public final void b(View paramView)
  {
    bu localbu = this.g;
    localbu.o = paramView;
    b(new com.google.android.gms.ads.internal.v.a(localbu.G));
  }
  
  final void b(com.google.android.gms.ads.internal.webview.i parami)
  {
    bu localbu = this.g;
    com.google.android.gms.ads.internal.v.a locala = localbu.h;
    if (locala != null)
    {
      this.a.a(localbu.g, locala, parami.getView(), parami);
      this.k = false;
      return;
    }
    this.k = true;
    com.google.android.gms.ads.internal.util.e.e("Request to enable ActiveView before adState is available.");
  }
  
  protected void q()
  {
    super.q();
    if (this.k)
    {
      com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.as;
      if (((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue()) {
        b(this.g.h.g);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */