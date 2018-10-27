package com.google.android.gms.ads.internal.reward;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.a.h;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.z;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class e
  extends com.google.android.gms.ads.internal.c
  implements com.google.android.gms.ads.internal.reward.mediation.g
{
  public static e m;
  public boolean k;
  public final a l;
  
  public e(Context paramContext, u paramu, AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramb, paramVersionInfoParcel, paramu);
    m = this;
    new com.google.android.gms.ads.internal.s.a(paramContext);
    this.l = new a(this.g, this.j, this, this, this);
  }
  
  private static com.google.android.gms.ads.internal.v.b b(com.google.android.gms.ads.internal.v.b paramb)
  {
    com.google.android.gms.ads.internal.util.e.a("Creating mediation ad response for non-mediated rewarded ad.");
    try
    {
      Object localObject1 = h.a(paramb.e);
      ((JSONObject)localObject1).remove("impression_urls");
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", paramb.d.d);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = new com.google.android.gms.ads.internal.mediation.c(Arrays.asList(new com.google.android.gms.ads.internal.mediation.b[] { new com.google.android.gms.ads.internal.mediation.b(((JSONObject)localObject1).toString(), Arrays.asList(new String[] { "com.google.ads.mediation.admob.AdMobAdapter" }), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (String)localObject2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()) }), ((Long)com.google.android.gms.ads.internal.f.n.bq.a()).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "");
      return new com.google.android.gms.ads.internal.v.b(paramb.d, paramb.e, (com.google.android.gms.ads.internal.mediation.c)localObject1, paramb.g, paramb.h, paramb.f, paramb.b, paramb.a, paramb.c, null);
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.e.c("Unable to generate ad state for non-mediated rewarded video.", localJSONException);
    }
    return new com.google.android.gms.ads.internal.v.b(paramb.d, paramb.e, null, paramb.g, 0, paramb.f, paramb.b, paramb.a, paramb.c, null);
  }
  
  public final boolean S()
  {
    z.a("isLoaded must be called on the main UI thread.");
    bu localbu = this.g;
    return (localbu.d == null) && (localbu.f == null) && (localbu.h != null);
  }
  
  public final void a()
  {
    a locala = this.l;
    z.a("destroy must be called on the main UI thread.");
    Iterator localIterator = locala.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        localObject = (com.google.android.gms.ads.internal.reward.mediation.n)locala.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((com.google.android.gms.ads.internal.reward.mediation.n)localObject).a;
          if (localObject != null) {
            ((com.google.android.gms.ads.internal.mediation.client.e)localObject).c();
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
      }
    }
    super.a();
  }
  
  public final void a(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    z.a("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(paramRewardedVideoAdRequestParcel.b))
    {
      com.google.android.gms.ads.internal.util.e.e("Invalid ad unit id. Aborting.");
      com.google.android.gms.ads.internal.util.n.a.post(new f(this));
      return;
    }
    this.g.j = paramRewardedVideoAdRequestParcel.b;
    String str = paramRewardedVideoAdRequestParcel.b;
    super.b(paramRewardedVideoAdRequestParcel.a);
  }
  
  public final void a(com.google.android.gms.ads.internal.v.b paramb, l paraml)
  {
    if (paramb.h != -2)
    {
      com.google.android.gms.ads.internal.util.n.a.post(new g(this, paramb));
      return;
    }
    paraml = this.g;
    paraml.G = paramb;
    if (paramb.i == null) {
      paraml.G = b(paramb);
    }
    this.l.a();
  }
  
  protected final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean a(com.google.android.gms.ads.internal.v.a parama1, com.google.android.gms.ads.internal.v.a parama2)
  {
    b(parama2, false);
    return a.b();
  }
  
  public final void a_(RewardItemParcel paramRewardItemParcel)
  {
    paramRewardItemParcel = this.l.a(paramRewardItemParcel);
    com.google.android.gms.ads.internal.s.b localb = bt.A.B;
    a(paramRewardItemParcel);
  }
  
  public final void b(boolean paramBoolean)
  {
    z.a("setImmersiveMode must be called on the main UI thread.");
    this.k = paramBoolean;
  }
  
  public final void bg_()
  {
    com.google.android.gms.ads.internal.s.b localb = bt.A.B;
    a(this.g.h, false);
    p();
  }
  
  public final void bh_()
  {
    this.l.c();
    t();
  }
  
  public final void bi_()
  {
    this.l.d();
    u();
  }
  
  public final void bj_()
  {
    com.google.android.gms.ads.internal.s.b localb = bt.A.B;
    n();
  }
  
  public final void bk_()
  {
    e();
  }
  
  public final void bl_()
  {
    o();
  }
  
  public final void h()
  {
    a locala = this.l;
    z.a("pause must be called on the main UI thread.");
    Iterator localIterator = locala.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        localObject = (com.google.android.gms.ads.internal.reward.mediation.n)locala.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((com.google.android.gms.ads.internal.reward.mediation.n)localObject).a;
          if (localObject != null) {
            ((com.google.android.gms.ads.internal.mediation.client.e)localObject).d();
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
      }
    }
  }
  
  public final void i()
  {
    a locala = this.l;
    z.a("resume must be called on the main UI thread.");
    Iterator localIterator = locala.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        localObject = (com.google.android.gms.ads.internal.reward.mediation.n)locala.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((com.google.android.gms.ads.internal.reward.mediation.n)localObject).a;
          if (localObject != null) {
            ((com.google.android.gms.ads.internal.mediation.client.e)localObject).e();
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
      }
    }
  }
  
  protected final void n()
  {
    this.g.h = null;
    super.n();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */