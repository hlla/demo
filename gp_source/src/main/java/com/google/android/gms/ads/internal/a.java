package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.am;
import com.google.android.gms.ads.internal.client.ar;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.d.g;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.bs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.ads.internal.v.m;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public abstract class a
  extends am
  implements com.google.android.gms.ads.internal.client.a, com.google.android.gms.ads.internal.gmsg.b, com.google.android.gms.ads.internal.gmsg.d, q, com.google.android.gms.ads.internal.renderer.f, com.google.android.gms.ads.internal.request.b, com.google.android.gms.ads.internal.v.k
{
  public final com.google.android.gms.ads.internal.a.c a;
  public com.google.android.gms.ads.internal.g.j b;
  public final u c;
  public boolean d = false;
  public transient AdRequestParcel e;
  public final bj f;
  public final bu g;
  public com.google.android.gms.ads.internal.g.l h;
  public com.google.android.gms.ads.internal.j.a i;
  private final Bundle j = new Bundle();
  private com.google.android.gms.ads.internal.g.j k;
  private boolean l = false;
  
  a(bu parambu, u paramu)
  {
    this.g = parambu;
    this.f = new bj(this);
    this.c = paramu;
    bt.A.e.b(this.g.m);
    bt.A.e.c(this.g.m);
    com.google.android.gms.ads.internal.util.c.a(this.g.m);
    bt.A.q.a(this.g.m);
    parambu = bt.A.i;
    paramu = this.g;
    parambu.a(paramu.m, paramu.P);
    bt.A.k.a(this.g.m);
    this.a = bt.A.i.a;
    bt.A.h.a(this.g.m);
    bt.A.C.a(this.g.m);
  }
  
  protected static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      com.google.android.gms.ads.internal.s.b localb = bt.A.B;
      localArrayList.add(str);
    }
    return localArrayList;
  }
  
  protected static List a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.google.android.gms.ads.internal.s.c.a((String)paramList.next(), paramBoolean));
    }
    return localArrayList;
  }
  
  protected static boolean a(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = paramAdRequestParcel.n.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    return (paramAdRequestParcel == null) || (!paramAdRequestParcel.containsKey("gw"));
  }
  
  private static long c(String paramString)
  {
    int i1 = paramString.indexOf("ufe");
    int n = paramString.indexOf(',', i1);
    int m = n;
    if (n == -1) {
      m = paramString.length();
    }
    try
    {
      long l1 = Long.parseLong(paramString.substring(i1 + 4, m));
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      com.google.android.gms.ads.internal.util.client.k.c("", paramString);
      return -1L;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;) {}
    }
  }
  
  public void a()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: destroy");
    this.f.a();
    ??? = this.a;
    Object localObject4 = this.g.h;
    synchronized (((com.google.android.gms.ads.internal.a.c)???).b)
    {
      localObject4 = (com.google.android.gms.ads.internal.a.d)((com.google.android.gms.ads.internal.a.c)???).a.get(localObject4);
      if (localObject4 == null) {}
    }
    synchronized (((com.google.android.gms.ads.internal.a.d)localObject4).e)
    {
      ((com.google.android.gms.ads.internal.a.d)localObject4).d = true;
      ((com.google.android.gms.ads.internal.a.d)localObject4).a(3);
      ??? = this.g;
      ??? = ((bu)???).b;
      if (??? != null)
      {
        com.google.android.gms.ads.internal.util.e.a("Disable position monitoring on adFrame.");
        ??? = ((bv)???).b;
        if (??? != null) {
          ((com.google.android.gms.ads.internal.util.bv)???).b();
        }
      }
      ((bu)???).c = null;
      ((bu)???).e = null;
      ((bu)???).l = null;
      ((bu)???).C = null;
      ((bu)???).n = null;
      ((bu)???).a(false);
      ??? = ((bu)???).b;
      if (??? != null) {
        ((bv)???).removeAllViews();
      }
      ((bu)???).a();
      ((bu)???).b();
      ((bu)???).h = null;
      this.i = null;
      return;
      localObject3 = finally;
      throw ((Throwable)localObject3);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder(30);
    ((StringBuilder)localObject).append("Failed to load ad: ");
    ((StringBuilder)localObject).append(paramInt);
    com.google.android.gms.ads.internal.util.e.e(((StringBuilder)localObject).toString());
    this.d = paramBoolean;
    localObject = this.g.c;
    if (localObject != null) {}
    try
    {
      ((com.google.android.gms.ads.internal.client.z)localObject).a(paramInt);
      localObject = this.g.K;
      if (localObject == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        ((com.google.android.gms.ads.internal.reward.client.l)localObject).a(paramInt);
        localObject = this.g.r;
        if (localObject != null) {}
        try
        {
          ((com.google.android.gms.ads.internal.instream.a.e)localObject).a(paramInt);
          return;
        }
        catch (RemoteException localRemoteException3)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException3);
        }
        localRemoteException1 = localRemoteException1;
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException1);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException2);
        }
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    this.j.putAll(paramBundle);
    if (this.l)
    {
      paramBundle = this.g.e;
      if (paramBundle == null) {}
    }
    try
    {
      paramBundle.a();
      return;
    }
    catch (RemoteException paramBundle)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", paramBundle);
    }
  }
  
  protected final void a(View paramView)
  {
    bv localbv = this.g.b;
    if (localbv != null) {
      localbv.addView(paramView, bt.A.g.d());
    }
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setAdSize");
    Object localObject1 = this.g;
    ((bu)localObject1).g = paramAdSizeParcel;
    Object localObject2 = ((bu)localObject1).h;
    if (localObject2 != null)
    {
      localObject2 = ((com.google.android.gms.ads.internal.v.a)localObject2).g;
      if ((localObject2 != null) && (((bu)localObject1).H == 0)) {
        ((i)localObject2).setAdSize(com.google.android.gms.ads.internal.webview.au.a(paramAdSizeParcel));
      }
    }
    localObject1 = this.g.b;
    if (localObject1 != null)
    {
      if (((bv)localObject1).getChildCount() > 1)
      {
        localObject1 = this.g.b;
        ((bv)localObject1).removeView(((bv)localObject1).getNextView());
      }
      this.g.b.setMinimumWidth(paramAdSizeParcel.j);
      this.g.b.setMinimumHeight(paramAdSizeParcel.c);
      this.g.b.requestLayout();
    }
  }
  
  public final void a(IconAdOptionsParcel paramIconAdOptionsParcel)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setIconAdOptions");
    this.g.p = paramIconAdOptionsParcel;
  }
  
  public final void a(VideoOptionsParcel paramVideoOptionsParcel)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setVideoOptions");
    this.g.Q = paramVideoOptionsParcel;
  }
  
  public final void a(ar paramar)
  {
    this.g.e = paramar;
  }
  
  public final void a(com.google.android.gms.ads.internal.client.au paramau)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setAppEventListener");
    this.g.l = paramau;
  }
  
  public final void a(ba paramba)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setCorrelationIdProvider");
    this.g.n = paramba;
  }
  
  public final void a(w paramw)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setAdClickListener");
    this.g.a = paramw;
  }
  
  public final void a(com.google.android.gms.ads.internal.client.z paramz)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setAdListener");
    this.g.c = paramz;
  }
  
  public final void a(com.google.android.gms.ads.internal.g.j paramj)
  {
    com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.M;
    this.h = new com.google.android.gms.ads.internal.g.l(((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue(), "load_ad", this.g.g.a);
    this.k = new com.google.android.gms.ads.internal.g.j(-1L, null, null);
    if (paramj == null)
    {
      this.b = new com.google.android.gms.ads.internal.g.j(-1L, null, null);
      return;
    }
    this.b = new com.google.android.gms.ads.internal.g.j(paramj.c, paramj.a, paramj.b);
  }
  
  public void a(com.google.android.gms.ads.internal.h.a.e parame)
  {
    throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
  }
  
  public void a(com.google.android.gms.ads.internal.p.a.a parama)
  {
    com.google.android.gms.ads.internal.util.e.e("#006 Unexpected call to a deprecated method.");
  }
  
  public final void a(com.google.android.gms.ads.internal.p.a.f paramf, String paramString)
  {
    com.google.android.gms.ads.internal.util.e.e("#006 Unexpected call to a deprecated method.");
  }
  
  public final void a(com.google.android.gms.ads.internal.reward.client.l paraml)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setRewardedVideoAdListener");
    this.g.K = paraml;
  }
  
  public final void a(RewardItemParcel paramRewardItemParcel)
  {
    Object localObject;
    if (this.g.K != null)
    {
      localObject = "";
      if (paramRewardItemParcel == null) {
        break label87;
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramRewardItemParcel.b;
        m = paramRewardItemParcel.a;
        paramRewardItemParcel = (RewardItemParcel)localObject;
        paramRewardItemParcel = new com.google.android.gms.ads.internal.reward.b(paramRewardItemParcel, m);
        this.g.K.a(paramRewardItemParcel);
        localObject = this.g;
        com.google.android.gms.ads.internal.reward.client.d locald = ((bu)localObject).I;
        if (locald != null) {
          locald.a(paramRewardItemParcel, ((bu)localObject).G.d.P);
        }
        return;
      }
      catch (RemoteException paramRewardItemParcel)
      {
        int m;
        label87:
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", paramRewardItemParcel);
      }
      m = 1;
      paramRewardItemParcel = (RewardItemParcel)localObject;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.v.b paramb)
  {
    ??? = paramb.e;
    if ((((AdResponseParcel)???).o != -1L) && (!TextUtils.isEmpty(((AdResponseParcel)???).j)))
    {
      long l1 = c(paramb.e.j);
      if (l1 != -1L)
      {
        ??? = this.h.a(l1 + paramb.e.o);
        this.h.a((com.google.android.gms.ads.internal.g.j)???, new String[] { "stc" });
      }
    }
    com.google.android.gms.ads.internal.g.l locall = this.h;
    String str = paramb.e.j;
    if (locall.a) {}
    synchronized (locall.b)
    {
      locall.c = str;
      this.h.a(this.b, new String[] { "arf" });
      this.k = this.h.a();
      this.h.a("gqi", paramb.e.p);
      ??? = this.g;
      ((bu)???).d = null;
      ((bu)???).G = paramb;
      paramb.c.a(new b(paramb));
      paramb.c.a(g.e);
      a(paramb, this.h);
      return;
    }
  }
  
  public abstract void a(com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.g.l paraml);
  
  public final void a(String paramString)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setUserId");
    this.g.w = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    com.google.android.gms.ads.internal.client.au localau = this.g.l;
    if (localau != null) {}
    try
    {
      localau.a(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", paramString1);
    }
  }
  
  public final void a(HashSet paramHashSet)
  {
    this.g.v = paramHashSet;
  }
  
  public void a(boolean paramBoolean)
  {
    com.google.android.gms.ads.internal.util.e.e("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  protected abstract boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.g.l paraml);
  
  boolean a(com.google.android.gms.ads.internal.v.a parama)
  {
    return false;
  }
  
  public abstract boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2);
  
  public final com.google.android.gms.ads.internal.j.a b()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: getAdFrame");
    return com.google.android.gms.dynamic.e.a(this.g.b);
  }
  
  public void b(com.google.android.gms.ads.internal.v.a parama)
  {
    this.h.a(this.k, new String[] { "awr" });
    Object localObject1 = this.g;
    ((bu)localObject1).f = null;
    int m = parama.l;
    if (m == -2) {}
    for (;;)
    {
      if (parama.l == -1) {
        this.d = false;
      }
      for (;;)
      {
        return;
        if (a(parama)) {
          com.google.android.gms.ads.internal.util.e.b("Ad refresh scheduled.");
        }
        m = parama.l;
        if (m == -2)
        {
          localObject1 = this.g;
          if (((bu)localObject1).M == null) {
            ((bu)localObject1).M = new m(((bu)localObject1).j);
          }
          localObject1 = this.g.b;
          if (localObject1 != null) {
            ((bv)localObject1).getDebugGestureDetector().e = parama.j;
          }
          this.a.a(this.g.h);
          Object localObject3;
          long l1;
          if (a(this.g.h, parama))
          {
            localObject1 = this.g;
            ((bu)localObject1).h = parama;
            ??? = ((bu)localObject1).i;
            if (??? != null)
            {
              localObject3 = ((bu)localObject1).h;
              if (localObject3 != null)
              {
                ((com.google.android.gms.ads.internal.v.c)???).a(((com.google.android.gms.ads.internal.v.a)localObject3).f);
                localObject3 = ((bu)localObject1).i;
                l1 = ((bu)localObject1).h.b;
              }
            }
          }
          synchronized (((com.google.android.gms.ads.internal.v.c)localObject3).c)
          {
            if (((com.google.android.gms.ads.internal.v.c)localObject3).d == -1L)
            {
              localObject3 = ((bu)localObject1).i;
              boolean bool = ((bu)localObject1).h.u;
              synchronized (((com.google.android.gms.ads.internal.v.c)localObject3).c)
              {
                if (((com.google.android.gms.ads.internal.v.c)localObject3).d == -1L)
                {
                  ((bu)localObject1).i.a(((bu)localObject1).g.e);
                  ??? = this.h;
                  if (!this.g.h.a()) {}
                  for (localObject1 = "0";; localObject1 = "1")
                  {
                    ((com.google.android.gms.ads.internal.g.l)???).a("is_mraid", (String)localObject1);
                    ??? = this.h;
                    if (!this.g.h.u) {}
                    for (localObject1 = "0";; localObject1 = "1")
                    {
                      ((com.google.android.gms.ads.internal.g.l)???).a("is_mediation", (String)localObject1);
                      localObject1 = this.g.h.g;
                      if ((localObject1 != null) && (((i)localObject1).getAdWebViewClient() != null))
                      {
                        ??? = this.h;
                        if (this.g.h.g.getAdWebViewClient().f()) {
                          break label556;
                        }
                      }
                      label556:
                      for (localObject1 = "0";; localObject1 = "1")
                      {
                        ((com.google.android.gms.ads.internal.g.l)???).a("is_delay_pl", (String)localObject1);
                        this.h.a(this.b, new String[] { "ttc" });
                        if (bt.A.i.a() == null) {}
                        for (;;)
                        {
                          v();
                          if (this.g.c()) {
                            q();
                          }
                          if (parama.G == null) {
                            break;
                          }
                          localObject1 = bt.A.e;
                          com.google.android.gms.ads.internal.util.n.a(this.g.m, parama.G);
                          return;
                          bt.A.i.a().a(this.h);
                        }
                      }
                    }
                  }
                }
                ((com.google.android.gms.ads.internal.v.c)localObject3).b = bool;
                ((com.google.android.gms.ads.internal.v.c)localObject3).f.a((com.google.android.gms.ads.internal.v.c)localObject3);
              }
            }
            ((com.google.android.gms.ads.internal.v.c)localObject3).a = l1;
            ((com.google.android.gms.ads.internal.v.c)localObject3).f.a((com.google.android.gms.ads.internal.v.c)localObject3);
          }
        }
      }
      if (m != 3) {
        parama.c.a(g.a);
      }
      for (;;)
      {
        a(parama.l);
        return;
        parama.c.a(g.b);
      }
      if ((m != 3) && (((bu)localObject1).v != null)) {
        bt.A.i.i.a(this.g.v);
      }
    }
  }
  
  public final void b(String paramString)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setCustomData");
    this.g.J = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
  }
  
  public boolean b(AdRequestParcel paramAdRequestParcel)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: loadAd");
    bt.A.k.a();
    this.j.clear();
    this.l = false;
    Object localObject2 = paramAdRequestParcel.n.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramAdRequestParcel.f;
      paramAdRequestParcel.n.putBundle("com.google.ads.mediation.admob.AdMobAdapter", (Bundle)localObject1);
    }
    localObject1 = new AdRequestParcel(paramAdRequestParcel.u, paramAdRequestParcel.b, (Bundle)localObject1, paramAdRequestParcel.g, paramAdRequestParcel.j, paramAdRequestParcel.i, paramAdRequestParcel.s, paramAdRequestParcel.l, paramAdRequestParcel.o, paramAdRequestParcel.r, paramAdRequestParcel.k, paramAdRequestParcel.d, paramAdRequestParcel.n, paramAdRequestParcel.e, paramAdRequestParcel.c, paramAdRequestParcel.p, paramAdRequestParcel.q, paramAdRequestParcel.h, paramAdRequestParcel.a, paramAdRequestParcel.t, paramAdRequestParcel.m);
    ((AdRequestParcel)localObject1).f.putInt("dv", DynamiteModule.a(this.g.m, "com.google.android.gms.ads.dynamite"));
    ((AdRequestParcel)localObject1).f.putBoolean("_newBundle", true);
    paramAdRequestParcel = (AdRequestParcel)localObject1;
    if (com.google.android.gms.common.util.e.a(this.g.m))
    {
      paramAdRequestParcel = (AdRequestParcel)localObject1;
      if (((AdRequestParcel)localObject1).k != null)
      {
        paramAdRequestParcel = new h((AdRequestParcel)localObject1);
        paramAdRequestParcel.a = null;
        paramAdRequestParcel = paramAdRequestParcel.a();
      }
    }
    localObject1 = this.g;
    if ((((bu)localObject1).d != null) || (((bu)localObject1).f != null))
    {
      if (this.e != null) {
        com.google.android.gms.ads.internal.util.e.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      for (;;)
      {
        this.e = paramAdRequestParcel;
        return false;
        com.google.android.gms.ads.internal.util.e.e("Loading already in progress, saving this object for future refreshes.");
      }
    }
    com.google.android.gms.ads.internal.util.e.d("Starting ad request.");
    localObject1 = String.valueOf(this.g.P.a);
    if (((String)localObject1).length() == 0) {}
    for (localObject1 = new String("SDK version: ");; localObject1 = "SDK version: ".concat((String)localObject1))
    {
      com.google.android.gms.ads.internal.util.e.d((String)localObject1);
      a(null);
      this.b = this.h.a();
      if (paramAdRequestParcel.i) {
        com.google.android.gms.ads.internal.util.e.d("This request is sent from a test device.");
      }
      for (;;)
      {
        this.f.a = paramAdRequestParcel;
        this.d = a(paramAdRequestParcel, this.h);
        return this.d;
        localObject1 = com.google.android.gms.ads.internal.client.u.h.a;
        localObject1 = com.google.android.gms.ads.internal.util.client.a.a(this.g.m);
        localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 71);
        ((StringBuilder)localObject2).append("Use AdRequest.Builder.addTestDevice(\"");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("\") to get test ads on this device.");
        com.google.android.gms.ads.internal.util.e.d(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public final AdSizeParcel c()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: getAdSize");
    AdSizeParcel localAdSizeParcel = this.g.g;
    if (localAdSizeParcel != null) {
      return new ThinAdSizeParcel(localAdSizeParcel);
    }
    return null;
  }
  
  protected void c(boolean paramBoolean)
  {
    com.google.android.gms.ads.internal.util.e.a("Ad finished loading.");
    this.d = paramBoolean;
    this.l = true;
    Object localObject = this.g.c;
    if (localObject != null) {}
    try
    {
      ((com.google.android.gms.ads.internal.client.z)localObject).c();
      localObject = this.g.K;
      if (localObject == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        ((com.google.android.gms.ads.internal.reward.client.l)localObject).a();
        localObject = this.g.e;
        if (localObject != null) {}
        try
        {
          ((ar)localObject).a();
          return;
        }
        catch (RemoteException localRemoteException3)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException3);
        }
        localRemoteException1 = localRemoteException1;
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException1);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException2);
        }
      }
    }
  }
  
  protected boolean c(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = this.g.b;
    if (paramAdRequestParcel != null)
    {
      paramAdRequestParcel = paramAdRequestParcel.getParent();
      if ((paramAdRequestParcel instanceof View))
      {
        paramAdRequestParcel = (View)paramAdRequestParcel;
        return bt.A.e.a(paramAdRequestParcel, paramAdRequestParcel.getContext());
      }
      return false;
    }
    return false;
  }
  
  public final boolean d()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: isLoaded");
    bu localbu = this.g;
    return (localbu.d == null) && (localbu.f == null) && (localbu.h != null);
  }
  
  public void e()
  {
    if (this.g.h == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Ad state was null when trying to ping click URLs.");
      return;
    }
    com.google.android.gms.ads.internal.util.e.b("Pinging click URLs.");
    Object localObject1 = this.g.i;
    if (localObject1 != null) {
      ((com.google.android.gms.ads.internal.v.c)localObject1).b();
    }
    if (this.g.h.h == null) {}
    for (;;)
    {
      localObject1 = this.g.a;
      if (localObject1 == null) {
        break;
      }
      try
      {
        ((w)localObject1).a();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
        return;
      }
      Object localObject2 = bt.A.e;
      Object localObject3 = this.g;
      localObject2 = ((bu)localObject3).m;
      String str = ((bu)localObject3).P.a;
      localObject3 = ((bu)localObject3).h;
      com.google.android.gms.ads.internal.util.n.a((Context)localObject2, str, a(((com.google.android.gms.ads.internal.v.a)localObject3).h, ((com.google.android.gms.ads.internal.v.a)localObject3).N));
    }
  }
  
  public final void f()
  {
    o();
  }
  
  public final void g()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: recordManualImpression");
    if (this.g.h == null) {
      com.google.android.gms.ads.internal.util.e.e("Ad state was null when trying to ping manual tracking URLs.");
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        com.google.android.gms.ads.internal.util.e.b("Pinging manual tracking URLs.");
      } while (this.g.h.t);
      localArrayList = new ArrayList();
      localObject = this.g.h.z;
      if (localObject != null) {
        localArrayList.addAll((Collection)localObject);
      }
      localObject = this.g.h.A;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.mediation.b)localObject).o;
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    } while (localArrayList.isEmpty());
    Object localObject = bt.A.e;
    localObject = this.g;
    com.google.android.gms.ads.internal.util.n.a(((bu)localObject).m, ((bu)localObject).P.a, localArrayList);
    this.g.h.t = true;
  }
  
  public void h()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: pause");
  }
  
  public void i()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: resume");
  }
  
  public final Bundle j()
  {
    if (this.l) {
      return this.j;
    }
    return new Bundle();
  }
  
  public final void k()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: stopLoading");
    this.d = false;
    this.g.a(true);
  }
  
  public final boolean l()
  {
    return this.d;
  }
  
  public bo m()
  {
    return null;
  }
  
  public void n()
  {
    com.google.android.gms.ads.internal.util.e.a("Ad closing.");
    Object localObject = this.g.c;
    if (localObject != null) {}
    try
    {
      ((com.google.android.gms.ads.internal.client.z)localObject).a();
      localObject = this.g.K;
      if (localObject == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          ((com.google.android.gms.ads.internal.reward.client.l)localObject).d();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException1);
      }
    }
  }
  
  public final void o()
  {
    com.google.android.gms.ads.internal.util.e.a("Ad leaving application.");
    Object localObject = this.g.c;
    if (localObject != null) {}
    try
    {
      ((com.google.android.gms.ads.internal.client.z)localObject).b();
      localObject = this.g.K;
      if (localObject == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          ((com.google.android.gms.ads.internal.reward.client.l)localObject).e();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException1);
      }
    }
  }
  
  public final void p()
  {
    com.google.android.gms.ads.internal.util.e.a("Ad opening.");
    Object localObject = this.g.c;
    if (localObject != null) {}
    try
    {
      ((com.google.android.gms.ads.internal.client.z)localObject).d();
      localObject = this.g.K;
      if (localObject == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          ((com.google.android.gms.ads.internal.reward.client.l)localObject).b();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException1);
      }
    }
  }
  
  protected void q()
  {
    c(false);
  }
  
  public final void r()
  {
    com.google.android.gms.ads.internal.util.e.d("Ad impression.");
    com.google.android.gms.ads.internal.client.z localz = this.g.c;
    if (localz != null) {}
    try
    {
      localz.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void s()
  {
    com.google.android.gms.ads.internal.util.e.d("Ad clicked.");
    com.google.android.gms.ads.internal.client.z localz = this.g.c;
    if (localz != null) {}
    try
    {
      localz.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void t()
  {
    com.google.android.gms.ads.internal.reward.client.l locall = this.g.K;
    if (locall != null) {}
    try
    {
      locall.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void u()
  {
    com.google.android.gms.ads.internal.reward.client.l locall = this.g.K;
    if (locall != null) {}
    try
    {
      locall.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void v()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if ((locala != null) && (!TextUtils.isEmpty(locala.j)) && (!locala.p) && (bt.A.o.b()))
    {
      com.google.android.gms.ads.internal.util.e.b("Sending troubleshooting signals to the server.");
      com.google.android.gms.ads.internal.util.ao localao = bt.A.o;
      bu localbu = this.g;
      localao.a(localbu.m, localbu.P.a, locala.j, localbu.j);
      locala.p = true;
    }
  }
  
  public String w()
  {
    return this.g.j;
  }
  
  public final com.google.android.gms.ads.internal.client.au x()
  {
    return this.g.l;
  }
  
  public final com.google.android.gms.ads.internal.client.z y()
  {
    return this.g.c;
  }
  
  protected final String z()
  {
    Object localObject = this.g.G;
    if (localObject == null) {
      return "javascript";
    }
    localObject = ((com.google.android.gms.ads.internal.v.b)localObject).e;
    if (localObject == null) {
      return "javascript";
    }
    localObject = ((AdResponseParcel)localObject).J;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "javascript";
    }
    try
    {
      if (new JSONObject((String)localObject).optInt("media_type", -1) != 0) {
        return "javascript";
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.client.k.e("", localJSONException);
    }
    return "javascript";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */