package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.g.v;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ad;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.aj;
import com.google.android.gms.ads.internal.formats.a.as;
import com.google.android.gms.ads.internal.formats.a.au;
import com.google.android.gms.ads.internal.instream.InstreamAdConfigurationParcel;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class ag
  extends ad
{
  public final com.google.android.gms.ads.internal.client.z a;
  public WeakReference b;
  public final String c;
  public final b d;
  public final com.google.android.gms.ads.internal.formats.a.ag e;
  public final AdSizeParcel f;
  public final aj g;
  public final Context h;
  public final ba i;
  public final v j;
  public final v k;
  public final u l;
  public final com.google.android.gms.ads.internal.instream.a.e m;
  public final Object n = new Object();
  public final NativeAdOptionsParcel o;
  public final as p;
  public final PublisherAdViewOptions q;
  public final au r;
  public final VersionInfoParcel s;
  private final InstreamAdConfigurationParcel t;
  
  ag(Context paramContext, String paramString, b paramb, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.client.z paramz, com.google.android.gms.ads.internal.formats.a.ag paramag, au paramau, com.google.android.gms.ads.internal.instream.a.e parame, aj paramaj, v paramv1, v paramv2, NativeAdOptionsParcel paramNativeAdOptionsParcel, InstreamAdConfigurationParcel paramInstreamAdConfigurationParcel, ba paramba, u paramu, as paramas, AdSizeParcel paramAdSizeParcel, PublisherAdViewOptions paramPublisherAdViewOptions)
  {
    this.h = paramContext;
    this.c = paramString;
    this.d = paramb;
    this.s = paramVersionInfoParcel;
    this.a = paramz;
    this.g = paramaj;
    this.e = paramag;
    this.r = paramau;
    this.m = parame;
    this.k = paramv1;
    this.j = paramv2;
    this.o = paramNativeAdOptionsParcel;
    this.t = paramInstreamAdConfigurationParcel;
    this.i = paramba;
    this.l = paramu;
    this.p = paramas;
    this.f = paramAdSizeParcel;
    this.q = paramPublisherAdViewOptions;
    com.google.android.gms.ads.internal.f.n.a(this.h);
  }
  
  private static void a(Runnable paramRunnable)
  {
    com.google.android.gms.ads.internal.util.n.a.post(paramRunnable);
  }
  
  final void a()
  {
    com.google.android.gms.ads.internal.client.z localz = this.a;
    if (localz != null) {}
    try
    {
      localz.a(0);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.e("Failed calling onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel)
  {
    a(new ah(this, paramAdRequestParcel));
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel, int paramInt)
  {
    if (paramInt > 0)
    {
      a(new ai(this, paramAdRequestParcel, paramInt));
      return;
    }
    throw new IllegalArgumentException("Number of ads has to be more than 0");
  }
  
  final void b(AdRequestParcel paramAdRequestParcel, int paramInt)
  {
    Object localObject1 = com.google.android.gms.ads.internal.f.n.bP;
    if ((!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject1)).booleanValue()) && (this.r != null))
    {
      a();
      return;
    }
    localObject1 = com.google.android.gms.ads.internal.f.n.aI;
    if ((!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject1)).booleanValue()) && (this.m != null))
    {
      a();
      return;
    }
    localObject1 = new az(this.h, this.l, AdSizeParcel.a(), this.c, this.d, this.s);
    this.b = new WeakReference(localObject1);
    Object localObject2 = this.e;
    com.google.android.gms.common.internal.z.a("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
    ((az)localObject1).g.z = ((com.google.android.gms.ads.internal.formats.a.ag)localObject2);
    localObject2 = this.r;
    com.google.android.gms.common.internal.z.a("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
    ((az)localObject1).g.F = ((au)localObject2);
    localObject2 = this.m;
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setInstreamAdLoadCallback");
    ((az)localObject1).g.r = ((com.google.android.gms.ads.internal.instream.a.e)localObject2);
    localObject2 = this.g;
    com.google.android.gms.common.internal.z.a("setOnContentAdLoadedListener must be called on the main UI thread.");
    ((az)localObject1).g.A = ((aj)localObject2);
    localObject2 = this.k;
    com.google.android.gms.common.internal.z.a("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    ((az)localObject1).g.D = ((v)localObject2);
    ((a)localObject1).a(this.a);
    localObject2 = this.j;
    com.google.android.gms.common.internal.z.a("setOnCustomClickListener must be called on the main UI thread.");
    ((az)localObject1).g.B = ((v)localObject2);
    ((az)localObject1).b(f());
    localObject2 = this.o;
    com.google.android.gms.common.internal.z.a("setNativeAdOptions must be called on the main UI thread.");
    ((az)localObject1).g.x = ((NativeAdOptionsParcel)localObject2);
    localObject2 = this.t;
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.: setInstreamAdConfiguration");
    ((az)localObject1).g.q = ((InstreamAdConfigurationParcel)localObject2);
    ((a)localObject1).a(this.i);
    com.google.android.gms.common.internal.z.a("setMaxNumberOfAds must be called on the main UI thread.");
    ((az)localObject1).l = paramInt;
    ((a)localObject1).b(paramAdRequestParcel);
  }
  
  final boolean b()
  {
    boolean bool3 = false;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.e == null)
    {
      bool1 = bool2;
      if (this.g == null)
      {
        bool1 = bool2;
        if (this.r == null)
        {
          v localv = this.k;
          if (localv == null) {
            break label56;
          }
          bool1 = bool3;
          if (localv.size() <= 0) {}
        }
      }
    }
    label56:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public final String c()
  {
    for (;;)
    {
      synchronized (this.n)
      {
        Object localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject1 = (c)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            localObject1 = ((c)localObject1).N();
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public final String d()
  {
    for (;;)
    {
      synchronized (this.n)
      {
        Object localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject1 = (c)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            localObject1 = ((c)localObject1).O();
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public final boolean e()
  {
    for (;;)
    {
      synchronized (this.n)
      {
        Object localObject2 = this.b;
        if (localObject2 != null)
        {
          localObject2 = (c)((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            bool = ((a)localObject2).d;
            return bool;
          }
        }
        else
        {
          return false;
        }
      }
      boolean bool = false;
    }
  }
  
  final List f()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.g != null) {
      localArrayList.add("1");
    }
    if (this.e != null) {
      localArrayList.add("2");
    }
    if (this.r != null) {
      localArrayList.add("6");
    }
    if (this.k.size() > 0) {
      localArrayList.add("3");
    }
    if (this.m != null)
    {
      localArrayList.add("2");
      localArrayList.add("1");
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */