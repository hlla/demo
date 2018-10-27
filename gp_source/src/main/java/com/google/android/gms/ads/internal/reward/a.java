package com.google.android.gms.ads.internal.reward;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.mediation.c;
import com.google.android.gms.ads.internal.mediation.k;
import com.google.android.gms.ads.internal.renderer.f;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.g;
import com.google.android.gms.ads.internal.reward.mediation.j;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  private static final com.google.android.gms.ads.internal.mediation.client.a e = new com.google.android.gms.ads.internal.mediation.client.a();
  public final com.google.android.gms.ads.internal.gmsg.b a;
  public final Map b = new HashMap();
  public final f c;
  private final com.google.android.gms.ads.internal.mediation.client.b d;
  private final g f;
  private final bu g;
  
  public a(bu parambu, com.google.android.gms.ads.internal.mediation.client.b paramb, g paramg, com.google.android.gms.ads.internal.gmsg.b paramb1, f paramf)
  {
    this.g = parambu;
    this.d = paramb;
    this.f = paramg;
    this.a = paramb1;
    this.c = paramf;
  }
  
  public static boolean b()
  {
    return true;
  }
  
  public final RewardItemParcel a(RewardItemParcel paramRewardItemParcel)
  {
    Object localObject1 = this.g.h;
    RewardItemParcel localRewardItemParcel = paramRewardItemParcel;
    if (localObject1 != null)
    {
      localObject1 = ((com.google.android.gms.ads.internal.v.a)localObject1).E;
      localRewardItemParcel = paramRewardItemParcel;
      if (localObject1 != null)
      {
        localRewardItemParcel = paramRewardItemParcel;
        if (!TextUtils.isEmpty(((c)localObject1).t))
        {
          paramRewardItemParcel = this.g.h.E;
          localRewardItemParcel = new RewardItemParcel(paramRewardItemParcel.t, paramRewardItemParcel.s);
        }
      }
    }
    paramRewardItemParcel = this.g.h;
    if ((paramRewardItemParcel != null) && (paramRewardItemParcel.A != null))
    {
      paramRewardItemParcel = bt.A.w;
      Object localObject2 = this.g;
      Context localContext = ((bu)localObject2).m;
      String str1 = ((bu)localObject2).P.a;
      paramRewardItemParcel = ((bu)localObject2).h.A.p;
      localObject1 = ((bu)localObject2).w;
      String str2 = ((bu)localObject2).J;
      if ((paramRewardItemParcel != null) && (!paramRewardItemParcel.isEmpty()))
      {
        localObject2 = k.a((String)localObject1);
        str2 = k.a(str2);
        long l = bt.A.l.a();
        Iterator localIterator = paramRewardItemParcel.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = k.a(k.a(k.a((String)localIterator.next(), "@gw_rwd_userid@", Uri.encode((String)localObject2)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(l));
          paramRewardItemParcel = (RewardItemParcel)localObject1;
          if (localRewardItemParcel != null) {
            paramRewardItemParcel = k.a(k.a((String)localObject1, "@gw_rwd_itm@", Uri.encode(localRewardItemParcel.b)), "@gw_rwd_amt@", Integer.toString(localRewardItemParcel.a));
          }
          localObject1 = bt.A.e;
          com.google.android.gms.ads.internal.util.n.a(localContext, str1, paramRewardItemParcel);
        }
      }
    }
    return localRewardItemParcel;
  }
  
  public final com.google.android.gms.ads.internal.reward.mediation.n a(String paramString)
  {
    com.google.android.gms.ads.internal.reward.mediation.n localn = (com.google.android.gms.ads.internal.reward.mediation.n)this.b.get(paramString);
    Object localObject2 = localn;
    if (localn == null) {}
    try
    {
      localObject2 = this.d;
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString)) {
        localObject2 = e;
      }
      for (;;)
      {
        localObject2 = new com.google.android.gms.ads.internal.reward.mediation.n(((com.google.android.gms.ads.internal.mediation.client.b)localObject2).a(paramString), this.f);
        try
        {
          this.b.put(paramString, localObject2);
          return (com.google.android.gms.ads.internal.reward.mediation.n)localObject2;
        }
        catch (Exception localException1)
        {
          Object localObject3 = localObject2;
          localObject2 = localException1;
          localObject1 = localObject3;
        }
      }
    }
    catch (Exception localException2)
    {
      Object localObject1;
      for (;;) {}
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String("Fail to instantiate adapter ");; paramString = "Fail to instantiate adapter ".concat(paramString))
    {
      com.google.android.gms.ads.internal.util.e.e(paramString, (Throwable)localObject2);
      return (com.google.android.gms.ads.internal.reward.mediation.n)localObject1;
    }
  }
  
  public final void a()
  {
    bu localbu = this.g;
    localbu.H = 0;
    Object localObject = bt.A.d;
    localObject = this.g;
    j localj = new j(((bu)localObject).m, ((bu)localObject).G, this);
    localObject = String.valueOf(localj.getClass().getName());
    if (((String)localObject).length() == 0) {}
    for (localObject = new String("AdRenderer: ");; localObject = "AdRenderer: ".concat((String)localObject))
    {
      com.google.android.gms.ads.internal.util.e.b((String)localObject);
      localj.c();
      localbu.f = localj;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    com.google.android.gms.ads.internal.reward.mediation.n localn = a(this.g.h.C);
    com.google.android.gms.ads.internal.mediation.client.e locale;
    if (localn != null)
    {
      locale = localn.a;
      if (locale == null) {}
    }
    try
    {
      locale.a(paramBoolean);
      localn.a.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void c()
  {
    Object localObject = this.g.h;
    if ((localObject != null) && (((com.google.android.gms.ads.internal.v.a)localObject).A != null))
    {
      localObject = bt.A.w;
      localObject = this.g;
      Context localContext = ((bu)localObject).m;
      String str = ((bu)localObject).P.a;
      com.google.android.gms.ads.internal.v.a locala = ((bu)localObject).h;
      k.a(localContext, str, locala, ((bu)localObject).j, false, locala.A.r);
    }
  }
  
  public final void d()
  {
    Object localObject = this.g.h;
    if ((localObject != null) && (((com.google.android.gms.ads.internal.v.a)localObject).A != null))
    {
      localObject = bt.A.w;
      localObject = this.g;
      Context localContext = ((bu)localObject).m;
      String str = ((bu)localObject).P.a;
      com.google.android.gms.ads.internal.v.a locala = ((bu)localObject).h;
      k.a(localContext, str, locala, ((bu)localObject).j, false, locala.A.q);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */