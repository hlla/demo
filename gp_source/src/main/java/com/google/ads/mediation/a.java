package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.al;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.bw;
import com.google.android.gms.ads.internal.client.bz;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.reward.client.t;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.l;
import com.google.android.gms.ads.mediation.p;
import com.google.android.gms.ads.mediation.r;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
public abstract class a
  implements com.google.android.gms.ads.f.a.b, com.google.android.gms.ads.mediation.b.b, com.google.android.gms.ads.mediation.d, com.google.android.gms.ads.mediation.i, p, r
{
  public com.google.android.gms.ads.f.a.c a;
  public l b;
  private com.google.android.gms.ads.c c;
  private com.google.android.gms.ads.i d;
  private l e;
  private Context f;
  private final com.google.android.gms.ads.f.d g = new b(this);
  
  private final com.google.android.gms.ads.e a(Context paramContext, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    f localf = new f();
    Object localObject = parama.a();
    if (localObject == null) {}
    for (;;)
    {
      int i = parama.b();
      if (i == 0) {}
      for (;;)
      {
        localObject = parama.c();
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            localf.a.b.add(str);
          }
        }
        localObject = parama.d();
        if (localObject == null) {}
        for (;;)
        {
          if (!parama.e()) {}
          for (;;)
          {
            if (parama.f() != -1) {
              if (parama.f() != 1) {
                break label233;
              }
            }
            label233:
            for (i = 1;; i = 0)
            {
              localf.a.j = i;
              boolean bool = parama.g();
              localf.a.f = bool;
              paramContext = a(paramBundle1, paramBundle2);
              localf.a.i.putBundle(AdMobAdapter.class.getName(), paramContext);
              if ((AdMobAdapter.class.equals(AdMobAdapter.class)) && (paramContext.getBoolean("_emulatorLiveAds"))) {
                localf.a.l.remove("B3EEABB8EE11C2BE770B684D95219ECB");
              }
              return localf.a();
            }
            localObject = u.h.a;
            paramContext = com.google.android.gms.ads.internal.util.client.a.a(paramContext);
            localf.a.a(paramContext);
          }
          localf.a.g = ((Location)localObject);
        }
        localf.a.e = i;
      }
      localf.a.c = ((Date)localObject);
    }
  }
  
  public abstract Bundle a(Bundle paramBundle1, Bundle paramBundle2);
  
  public String a(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }
  
  public final void a()
  {
    com.google.android.gms.ads.i locali = this.d;
    if (locali != null)
    {
      locali.c();
      this.d = null;
    }
    if (this.e != null) {
      this.e = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    if (this.b != null) {
      this.b = null;
    }
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.f.a.c paramc)
  {
    this.f = paramContext.getApplicationContext();
    this.a = paramc;
    this.a.a(this);
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.mediation.e parame, Bundle paramBundle1, com.google.android.gms.ads.g paramg, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle2)
  {
    this.d = new com.google.android.gms.ads.i(paramContext);
    this.d.setAdSize(new com.google.android.gms.ads.g(paramg.c, paramg.b));
    this.d.setAdUnitId(a(paramBundle1));
    this.d.setAdListener(new g(parame));
    this.d.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.mediation.h paramh, Bundle paramBundle1, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle2)
  {
    this.e = new l(paramContext);
    this.e.a(a(paramBundle1));
    Object localObject1 = this.e;
    paramh = new h(paramh);
    Object localObject2 = ((l)localObject1).a;
    for (;;)
    {
      try
      {
        ((bz)localObject2).b = paramh;
        localObject2 = ((bz)localObject2).c;
        if (localObject2 != null) {
          continue;
        }
      }
      catch (RemoteException localRemoteException)
      {
        k.f("#008 Must be called on the main UI thread.", localRemoteException);
        continue;
      }
      localObject1 = ((l)localObject1).a;
      paramh = (com.google.android.gms.ads.internal.client.a)paramh;
      try
      {
        ((bz)localObject1).a = paramh;
        localObject1 = ((bz)localObject1).c;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (RemoteException paramh)
      {
        k.f("#008 Must be called on the main UI thread.", paramh);
        continue;
      }
      this.e.a(a(paramContext, parama, paramBundle2, paramBundle1));
      return;
      ((al)localObject1).a(new com.google.android.gms.ads.internal.client.b(paramh));
      continue;
      ((al)localObject2).a(new com.google.android.gms.ads.internal.client.d(paramh));
    }
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.mediation.j paramj, Bundle paramBundle1, com.google.android.gms.ads.mediation.n paramn, Bundle paramBundle2)
  {
    i locali = new i(this, paramj);
    com.google.android.gms.ads.d locald = new com.google.android.gms.ads.d(paramContext, paramBundle1.getString("pubid")).a(locali);
    paramj = paramn.h();
    if (paramj != null) {
      locald.a(paramj);
    }
    if (paramn.j()) {
      locald.a(locali);
    }
    if (paramn.i()) {
      locald.a(locali);
    }
    if (paramn.k()) {
      locald.a(locali);
    }
    if (paramn.l())
    {
      Iterator localIterator = paramn.m().keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!((Boolean)paramn.m().get(str)).booleanValue()) {}
        for (paramj = null;; paramj = locali)
        {
          locald.a(str, locali, paramj);
          break;
        }
      }
    }
    this.c = locald.a();
    paramj = this.c;
    paramContext = a(paramContext, paramn, paramBundle2, paramBundle1).a;
    try
    {
      paramj.a.a(com.google.android.gms.ads.internal.client.j.a(paramj.b, paramContext));
      return;
    }
    catch (RemoteException paramContext)
    {
      k.c("Failed to load ad.", paramContext);
    }
  }
  
  public final void a(com.google.android.gms.ads.mediation.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    Object localObject1 = this.f;
    if ((localObject1 == null) || (this.a == null))
    {
      k.c("AdMobAdapter.loadAd called before initialize.");
      return;
    }
    this.b = new l((Context)localObject1);
    localObject1 = this.b;
    ((l)localObject1).a.j = true;
    ((l)localObject1).a(a(paramBundle1));
    Object localObject3 = this.b;
    localObject1 = this.g;
    localObject3 = ((l)localObject3).a;
    for (;;)
    {
      try
      {
        ((bz)localObject3).i = ((com.google.android.gms.ads.f.d)localObject1);
        localObject3 = ((bz)localObject3).c;
        if (localObject3 != null) {
          continue;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        t localt;
        k.f("#008 Must be called on the main UI thread.", localRemoteException2);
        continue;
        Object localObject2 = null;
        continue;
      }
      localObject3 = this.b;
      localObject1 = new c(this);
      localObject3 = ((l)localObject3).a;
      try
      {
        ((bz)localObject3).d = ((com.google.android.gms.ads.f.a)localObject1);
        localObject3 = ((bz)localObject3).c;
        if (localObject3 != null) {
          continue;
        }
      }
      catch (RemoteException localRemoteException1)
      {
        k.f("#008 Must be called on the main UI thread.", localRemoteException1);
        continue;
      }
      this.b.a(a(this.f, parama, paramBundle2, paramBundle1));
      return;
      ((al)localObject3).a(new com.google.android.gms.ads.internal.client.g((com.google.android.gms.ads.f.a)localObject1));
      continue;
      if (localRemoteException1 == null) {
        continue;
      }
      localt = new t(localRemoteException1);
      ((al)localObject3).a(localt);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    l locall = this.e;
    if (locall != null) {
      locall.a(paramBoolean);
    }
    locall = this.b;
    if (locall != null) {
      locall.a(paramBoolean);
    }
  }
  
  public final void b()
  {
    com.google.android.gms.ads.i locali = this.d;
    if (locali != null) {
      locali.b();
    }
  }
  
  public final void c()
  {
    com.google.android.gms.ads.i locali = this.d;
    if (locali != null) {
      locali.a();
    }
  }
  
  public final View d()
  {
    return this.d;
  }
  
  public final bo e()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.i)localObject).getVideoController();
      if (localObject != null) {
        return ((com.google.android.gms.ads.n)localObject).a();
      }
    }
    return null;
  }
  
  public final void f()
  {
    this.e.a.b();
  }
  
  public final Bundle g()
  {
    com.google.android.gms.ads.mediation.c localc = new com.google.android.gms.ads.mediation.c();
    localc.a = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("capabilities", localc.a);
    return localBundle;
  }
  
  public final void h()
  {
    this.b.a.b();
  }
  
  public final boolean i()
  {
    return this.a != null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */