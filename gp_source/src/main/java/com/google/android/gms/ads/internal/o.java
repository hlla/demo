package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.a.ac;
import com.google.android.gms.ads.internal.formats.a.am;
import com.google.android.gms.ads.internal.formats.a.as;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.common.internal.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class o
  extends c
  implements com.google.android.gms.ads.internal.formats.u
{
  public com.google.android.gms.ads.internal.v.a k;
  private boolean l;
  private boolean m = false;
  
  public o(Context paramContext, u paramu, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramb, paramVersionInfoParcel, paramu);
  }
  
  private final com.google.android.gms.ads.internal.mediation.c Y()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if ((locala != null) && (locala.u)) {
      return locala.E;
    }
    return null;
  }
  
  private static com.google.android.gms.ads.internal.v.a a(com.google.android.gms.ads.internal.v.b paramb, int paramInt)
  {
    Object localObject1 = paramb.d;
    AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject1).b;
    AdResponseParcel localAdResponseParcel = paramb.e;
    List localList1 = localAdResponseParcel.g;
    List localList2 = localAdResponseParcel.q;
    List localList3 = localAdResponseParcel.F;
    int i = localAdResponseParcel.K;
    long l1 = localAdResponseParcel.M;
    localObject1 = ((AdRequestInfoParcel)localObject1).X;
    boolean bool1 = localAdResponseParcel.y;
    com.google.android.gms.ads.internal.mediation.c localc = paramb.i;
    long l2 = localAdResponseParcel.G;
    AdSizeParcel localAdSizeParcel = paramb.g;
    l2 = localAdResponseParcel.r;
    l2 = paramb.f;
    long l3 = paramb.b;
    String str1 = localAdResponseParcel.k;
    JSONObject localJSONObject = paramb.a;
    RewardItemParcel localRewardItemParcel = localAdResponseParcel.P;
    List localList4 = localAdResponseParcel.Q;
    boolean bool2 = localAdResponseParcel.E;
    Object localObject2 = localAdResponseParcel.d;
    localObject2 = localAdResponseParcel.H;
    String str2 = localAdResponseParcel.l;
    com.google.android.gms.ads.internal.d.a locala = paramb.c;
    boolean bool3 = localAdResponseParcel.u;
    boolean bool4 = paramb.j;
    boolean bool5 = localAdResponseParcel.C;
    paramb = localAdResponseParcel.m;
    boolean bool6 = localAdResponseParcel.t;
    String str3 = localAdResponseParcel.J;
    return new com.google.android.gms.ads.internal.v.a(localAdRequestParcel, null, localList1, paramInt, localList2, localList3, i, l1, (String)localObject1, bool1, null, null, null, localc, null, localAdSizeParcel, l2, l3, str1, localJSONObject, null, localRewardItemParcel, localList4, localList4, bool2, null, (List)localObject2, str2, locala, bool3, bool4, bool5, paramb, bool6, localAdResponseParcel.S);
  }
  
  private final void a(com.google.android.gms.ads.internal.formats.p paramp)
  {
    com.google.android.gms.ads.internal.util.n.a.post(new q(this, paramp));
  }
  
  private final boolean b(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    b(null);
    if (!this.g.c())
    {
      com.google.android.gms.ads.internal.util.e.e("Native ad does not have custom rendering mode.");
      a(0);
      return false;
    }
    Object localObject1;
    Object localObject3;
    label67:
    Object localObject2;
    label87:
    Object localObject4;
    for (;;)
    {
      label107:
      String str1;
      List localList;
      String str2;
      String str3;
      String str4;
      double d;
      Object localObject5;
      Object localObject6;
      bo localbo;
      try
      {
        localObject1 = parama2.B;
        if (localObject1 == null) {
          break label1328;
        }
        localObject3 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).p();
        localObject1 = parama2.B;
        if (localObject1 == null) {
          break label1322;
        }
        localObject1 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject1).h();
        localObject2 = parama2.B;
        if (localObject2 == null) {
          break label1316;
        }
        localObject2 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject2).i();
        localObject4 = parama2.B;
        if (localObject4 == null) {
          break;
        }
        localObject4 = ((com.google.android.gms.ads.internal.mediation.client.e)localObject4).n();
        str1 = c(parama2);
        if ((localObject3 != null) && (this.g.F != null))
        {
          localObject4 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).a();
          localList = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).b();
          str2 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).c();
          if (((com.google.android.gms.ads.internal.mediation.client.t)localObject3).d() != null)
          {
            localObject1 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).d();
            str3 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).e();
            str4 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).f();
            d = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).g();
            localObject5 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).h();
            localObject6 = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).i();
            localbo = ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).j();
            if (((com.google.android.gms.ads.internal.mediation.client.t)localObject3).m() != null)
            {
              localObject2 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.t)localObject3).m());
              localObject1 = new com.google.android.gms.ads.internal.formats.p((String)localObject4, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject1, str3, str4, d, (String)localObject5, (String)localObject6, null, localbo, (View)localObject2, ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).n(), str1, ((com.google.android.gms.ads.internal.mediation.client.t)localObject3).o());
              localObject2 = this.g;
              ((com.google.android.gms.ads.internal.formats.p)localObject1).a(new com.google.android.gms.ads.internal.formats.s(((bu)localObject2).m, this, ((bu)localObject2).N, (com.google.android.gms.ads.internal.mediation.client.t)localObject3, (com.google.android.gms.ads.internal.formats.v)localObject1));
              a((com.google.android.gms.ads.internal.formats.p)localObject1);
              label338:
              return super.a(parama1, parama2);
            }
            localObject2 = null;
            continue;
          }
          localObject1 = null;
          continue;
        }
        if ((localObject1 == null) || (this.g.F == null)) {
          break label602;
        }
        localObject4 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).a();
        localList = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).b();
        str2 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).c();
        if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d() == null) {
          break label596;
        }
        localObject2 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d();
        str3 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).e();
        d = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).f();
        str4 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).g();
        localObject5 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).h();
        localObject6 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).m();
        if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p() != null)
        {
          localObject3 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p());
          localObject2 = new com.google.android.gms.ads.internal.formats.p((String)localObject4, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject2, str3, null, d, str4, (String)localObject5, null, (bo)localObject6, (View)localObject3, ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).q(), str1, ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).l());
          localObject3 = this.g;
          ((com.google.android.gms.ads.internal.formats.p)localObject2).a(new com.google.android.gms.ads.internal.formats.s(((bu)localObject3).m, this, ((bu)localObject3).N, (com.google.android.gms.ads.internal.mediation.client.n)localObject1, (com.google.android.gms.ads.internal.formats.v)localObject2));
          a((com.google.android.gms.ads.internal.formats.p)localObject2);
          continue;
        }
        localObject3 = null;
      }
      catch (RemoteException parama1)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", parama1);
        a(0);
        return false;
      }
      continue;
      label596:
      localObject2 = null;
      continue;
      label602:
      if ((localObject1 != null) && (this.g.z != null))
      {
        localObject4 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).a();
        localList = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).b();
        str2 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).c();
        if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d() == null) {
          break label1340;
        }
        localObject2 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).d();
        label663:
        str3 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).e();
        d = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).f();
        str4 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).g();
        localObject5 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).h();
        localObject6 = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).l();
        localbo = ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).m();
        if (((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p() == null) {
          break label1334;
        }
        localObject3 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.n)localObject1).p());
        label741:
        localObject2 = new com.google.android.gms.ads.internal.formats.i((String)localObject4, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject2, str3, d, str4, (String)localObject5, null, (Bundle)localObject6, localbo, (View)localObject3, ((com.google.android.gms.ads.internal.mediation.client.n)localObject1).q(), str1);
        localObject3 = this.g;
        ((com.google.android.gms.ads.internal.formats.i)localObject2).a(new com.google.android.gms.ads.internal.formats.s(((bu)localObject3).m, this, ((bu)localObject3).N, (com.google.android.gms.ads.internal.mediation.client.n)localObject1, (com.google.android.gms.ads.internal.formats.v)localObject2));
        com.google.android.gms.ads.internal.util.n.a.post(new r(this, (com.google.android.gms.ads.internal.formats.i)localObject2));
      }
      else if ((localObject2 != null) && (this.g.F != null))
      {
        localObject4 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).a();
        localList = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).b();
        str2 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).c();
        if (((com.google.android.gms.ads.internal.mediation.client.q)localObject2).d() == null) {
          break label1352;
        }
        localObject1 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).d();
        label895:
        str3 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).e();
        str4 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).f();
        localObject5 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).l();
        if (((com.google.android.gms.ads.internal.mediation.client.q)localObject2).n() == null) {
          break label1346;
        }
        localObject3 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.q)localObject2).n());
        label947:
        localObject1 = new com.google.android.gms.ads.internal.formats.p((String)localObject4, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject1, str3, str4, -1.0D, null, null, null, (bo)localObject5, (View)localObject3, ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).o(), str1, ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).j());
        localObject3 = this.g;
        ((com.google.android.gms.ads.internal.formats.p)localObject1).a(new com.google.android.gms.ads.internal.formats.s(((bu)localObject3).m, this, ((bu)localObject3).N, (com.google.android.gms.ads.internal.mediation.client.q)localObject2, (com.google.android.gms.ads.internal.formats.v)localObject1));
        a((com.google.android.gms.ads.internal.formats.p)localObject1);
      }
      else
      {
        if ((localObject2 == null) || (this.g.A == null)) {
          break label1370;
        }
        localObject4 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).a();
        localList = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).b();
        str2 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).c();
        if (((com.google.android.gms.ads.internal.mediation.client.q)localObject2).d() == null) {
          break label1364;
        }
        localObject1 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).d();
        label1097:
        str3 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).e();
        str4 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).f();
        localObject5 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).j();
        localObject6 = ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).l();
        if (((com.google.android.gms.ads.internal.mediation.client.q)localObject2).n() == null) {
          break label1358;
        }
        localObject3 = (View)com.google.android.gms.dynamic.e.a(((com.google.android.gms.ads.internal.mediation.client.q)localObject2).n());
        label1158:
        localObject1 = new com.google.android.gms.ads.internal.formats.k((String)localObject4, localList, str2, (com.google.android.gms.ads.internal.formats.a.e)localObject1, str3, str4, null, (Bundle)localObject5, (bo)localObject6, (View)localObject3, ((com.google.android.gms.ads.internal.mediation.client.q)localObject2).o(), str1);
        localObject3 = this.g;
        ((com.google.android.gms.ads.internal.formats.k)localObject1).a(new com.google.android.gms.ads.internal.formats.s(((bu)localObject3).m, this, ((bu)localObject3).N, (com.google.android.gms.ads.internal.mediation.client.q)localObject2, (com.google.android.gms.ads.internal.formats.v)localObject1));
        com.google.android.gms.ads.internal.util.n.a.post(new s(this, (com.google.android.gms.ads.internal.formats.k)localObject1));
      }
    }
    for (;;)
    {
      label1248:
      com.google.android.gms.ads.internal.util.e.e("No matching mapper/listener for retrieved native ad template.");
      a(0);
      return false;
      label1316:
      label1322:
      label1328:
      label1334:
      label1340:
      label1346:
      label1352:
      label1358:
      label1364:
      label1370:
      do
      {
        localObject1 = this.g.D;
        if ((localObject1 == null) || (((android.support.v4.g.v)localObject1).get(((ac)localObject4).c()) == null)) {
          break label1248;
        }
        com.google.android.gms.ads.internal.util.n.a.post(new t(this, (ac)localObject4));
        break label338;
        localObject4 = null;
        break label107;
        localObject2 = null;
        break label87;
        localObject1 = null;
        break label67;
        localObject3 = null;
        break;
        localObject3 = null;
        break label741;
        localObject2 = null;
        break label663;
        localObject3 = null;
        break label947;
        localObject1 = null;
        break label895;
        localObject3 = null;
        break label1158;
        localObject1 = null;
        break label1097;
      } while (localObject4 != null);
    }
  }
  
  private final boolean c(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    View localView1 = aq.a(parama2);
    if (localView1 != null)
    {
      View localView2 = this.g.b.getNextView();
      if (localView2 != null)
      {
        if ((localView2 instanceof com.google.android.gms.ads.internal.webview.i)) {
          ((com.google.android.gms.ads.internal.webview.i)localView2).destroy();
        }
        this.g.b.removeView(localView2);
      }
      if (aq.b(parama2)) {}
    }
    try
    {
      a(localView1);
      if (this.g.b.getChildCount() > 1) {
        this.g.b.showNext();
      }
      if (parama1 != null)
      {
        parama1 = this.g.b.getNextView();
        if (parama1 != null) {
          this.g.b.removeView(parama1);
        }
        this.g.b();
      }
      this.g.b.setMinimumWidth(c().j);
      this.g.b.setMinimumHeight(c().c);
      this.g.b.requestLayout();
      this.g.b.setVisibility(0);
      return true;
    }
    finally
    {
      bt.A.i.a(parama1, "AdLoaderManager.swapBannerViews");
      com.google.android.gms.ads.internal.util.e.e("Could not add mediation view to view hierarchy.", parama1);
    }
    return false;
    return false;
  }
  
  public final void G()
  {
    Object localObject = this.g.h;
    if ((localObject != null) && ("com.google.ads.mediation.admob.AdMobAdapter".equals(((com.google.android.gms.ads.internal.v.a)localObject).C)))
    {
      localObject = this.g.h.A;
      if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).b()))
      {
        s();
        return;
      }
    }
    super.G();
  }
  
  public final void L()
  {
    Object localObject = this.g.h;
    if ((localObject != null) && ("com.google.ads.mediation.admob.AdMobAdapter".equals(((com.google.android.gms.ads.internal.v.a)localObject).C)))
    {
      localObject = this.g.h.A;
      if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).b()))
      {
        r();
        return;
      }
    }
    super.L();
  }
  
  public final void P()
  {
    throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
  }
  
  public final void S()
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final void T()
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final void U()
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final boolean V()
  {
    if (Y() != null) {
      return Y().e;
    }
    return false;
  }
  
  public final boolean W()
  {
    if (Y() != null) {
      return Y().d;
    }
    return false;
  }
  
  public final boolean X()
  {
    if (Y() != null) {
      return Y().c;
    }
    return false;
  }
  
  public final void a(com.google.android.gms.ads.internal.formats.r paramr)
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final void a(com.google.android.gms.ads.internal.formats.t paramt)
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final void a(com.google.android.gms.ads.internal.h.a.e parame)
  {
    throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
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
  
  public final void a(com.google.android.gms.ads.internal.v.b paramb, l paraml)
  {
    this.k = null;
    int i = paramb.h;
    if (i != -2) {
      this.k = a(paramb, i);
    }
    for (;;)
    {
      if (this.k != null)
      {
        com.google.android.gms.ads.internal.util.n.a.post(new p(this));
        return;
      }
      Object localObject1 = paramb.g;
      if (localObject1 != null) {
        this.g.g = ((AdSizeParcel)localObject1);
      }
      localObject1 = this.g;
      ((bu)localObject1).H = 0;
      Object localObject2 = bt.A.d;
      localObject2 = this.g;
      ((bu)localObject1).f = com.google.android.gms.ads.internal.renderer.e.a(((bu)localObject2).m, this, paramb, ((bu)localObject2).N, null, this.j, this, paraml);
      return;
      if (!paramb.e.y)
      {
        com.google.android.gms.ads.internal.util.e.e("partialAdState is not mediation");
        this.k = a(paramb, 0);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    z.a("setManualImpressionsEnabled must be called from the main thread.");
    this.l = paramBoolean;
  }
  
  protected final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    if (!this.g.c()) {
      throw new IllegalStateException("AdLoader API does not support custom rendering.");
    }
    if (!parama2.u)
    {
      a(0);
      com.google.android.gms.ads.internal.util.e.e("newState is not mediation.");
    }
    Object localObject;
    do
    {
      return false;
      localObject = parama2.A;
      if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).a())) {
        break label122;
      }
      localObject = parama2.A;
      if ((localObject == null) || (!((com.google.android.gms.ads.internal.mediation.b)localObject).b())) {
        break;
      }
    } while (!b(parama1, parama2));
    for (;;)
    {
      c(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
      return true;
      a(0);
      com.google.android.gms.ads.internal.util.e.e("Response is neither banner nor native.");
      return false;
      label122:
      if (this.g.c())
      {
        localObject = this.g.b;
        if (localObject != null) {
          ((bv)localObject).getDebugGestureDetector().d = parama2.i;
        }
      }
      if (!super.a(parama1, parama2)) {
        break;
      }
      if ((this.g.c()) && (!c(parama1, parama2)))
      {
        a(0);
        return false;
      }
      if (!this.g.d()) {
        super.a(parama2, false);
      }
      this.m = true;
    }
  }
  
  public final void b(View paramView)
  {
    com.google.android.gms.ads.internal.util.client.k.f("#005 Unexpected call to an abstract (unimplemented) method.", null);
  }
  
  public final void b(List paramList)
  {
    z.a("setNativeTemplates must be called on the main UI thread.");
    this.g.y = paramList;
  }
  
  public final boolean b(AdRequestParcel paramAdRequestParcel)
  {
    Object localObject = this.g.k;
    if ((localObject == null) || (((List)localObject).size() != 1) || (((Integer)this.g.k.get(0)).intValue() != 2))
    {
      if (this.g.E != null)
      {
        boolean bool1 = paramAdRequestParcel.l;
        boolean bool3 = this.l;
        if (bool1 != bool3)
        {
          int i = paramAdRequestParcel.u;
          long l1 = paramAdRequestParcel.b;
          localObject = paramAdRequestParcel.f;
          int j = paramAdRequestParcel.g;
          List localList = paramAdRequestParcel.j;
          boolean bool2 = paramAdRequestParcel.i;
          int n = paramAdRequestParcel.s;
          if (bool1)
          {
            bool1 = true;
            paramAdRequestParcel = new AdRequestParcel(i, l1, (Bundle)localObject, j, localList, bool2, n, bool1, paramAdRequestParcel.o, paramAdRequestParcel.r, paramAdRequestParcel.k, paramAdRequestParcel.d, paramAdRequestParcel.n, paramAdRequestParcel.e, paramAdRequestParcel.c, paramAdRequestParcel.p, paramAdRequestParcel.q, paramAdRequestParcel.h, null, paramAdRequestParcel.t, paramAdRequestParcel.m);
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
      return super.b(paramAdRequestParcel);
    }
    com.google.android.gms.ads.internal.util.e.c("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
    a(0);
    return false;
  }
  
  public final am c(String paramString)
  {
    z.a("getOnCustomClickListener must be called on the main UI thread.");
    return (am)this.g.B.get(paramString);
  }
  
  public final void c(List paramList)
  {
    z.a("setAllowedAdTypes must be called on the main UI thread.");
    this.g.k = paramList;
  }
  
  public final void h()
  {
    if (!this.m) {
      throw new IllegalStateException("Native Ad does not support pause().");
    }
    super.h();
  }
  
  public final void i()
  {
    if (!this.m) {
      throw new IllegalStateException("Native Ad does not support resume().");
    }
    super.i();
  }
  
  public final bo m()
  {
    return null;
  }
  
  protected final void q()
  {
    super.q();
    Object localObject = this.g.h;
    as localas;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).A;
      if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).a()))
      {
        localObject = this.g;
        localas = ((bu)localObject).E;
        if (localas == null) {}
      }
    }
    try
    {
      localas.a(this, com.google.android.gms.dynamic.e.a(((bu)localObject).m));
      super.b(this.g.h, false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */