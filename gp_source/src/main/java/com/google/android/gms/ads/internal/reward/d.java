package com.google.android.gms.ads.internal.reward;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ar;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.g;
import com.google.android.gms.ads.internal.reward.client.l;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  extends g
{
  private final e a;
  private final Context b;
  private final Object c = new Object();
  
  private d(Context paramContext, e parame)
  {
    this.b = paramContext;
    this.a = parame;
  }
  
  public d(Context paramContext, u paramu, b paramb, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, new e(paramContext, paramu, AdSizeParcel.b(), paramb, paramVersionInfoParcel));
  }
  
  public final void a()
  {
    synchronized (this.c)
    {
      e locale = this.a;
      z.a("showAd must be called on the main UI thread.");
      if (!locale.S())
      {
        com.google.android.gms.ads.internal.util.e.e("The reward video has not loaded.");
        return;
      }
      locale.l.a(locale.k);
    }
  }
  
  public final void a(ar paramar)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.by.a()).booleanValue()) {
      synchronized (this.c)
      {
        this.a.a(paramar);
        return;
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    try
    {
      Context localContext = this.b;
      if ((localContext instanceof c)) {
        ((c)localContext).a((Activity)com.google.android.gms.dynamic.e.a(parama));
      }
      a();
      return;
    }
    finally {}
  }
  
  public final void a(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    synchronized (this.c)
    {
      this.a.a(paramRewardedVideoAdRequestParcel);
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.reward.client.d paramd)
  {
    synchronized (this.c)
    {
      e locale = this.a;
      z.a("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
      locale.g.I = paramd;
      return;
    }
  }
  
  public final void a(l paraml)
  {
    synchronized (this.c)
    {
      this.a.a(paraml);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    synchronized (this.c)
    {
      this.a.a(paramString);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      this.a.b(paramBoolean);
      return;
    }
  }
  
  public final Bundle b()
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.by.a()).booleanValue()) {}
    synchronized (this.c)
    {
      Bundle localBundle = this.a.j();
      return localBundle;
      return new Bundle();
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a arg1)
  {
    synchronized (this.c)
    {
      this.a.h();
      return;
    }
  }
  
  public final void b(String paramString)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.bv.a()).booleanValue()) {
      synchronized (this.c)
      {
        this.a.b(paramString);
        return;
      }
    }
  }
  
  public final void c(com.google.android.gms.ads.internal.j.a parama)
  {
    Object localObject = this.c;
    if (parama != null) {}
    for (;;)
    {
      try
      {
        parama = (Context)com.google.android.gms.dynamic.e.a(parama);
        if (parama != null)
        {
          Iterator localIterator = this.a.l.b.values().iterator();
          if (localIterator.hasNext())
          {
            com.google.android.gms.ads.internal.reward.mediation.n localn = (com.google.android.gms.ads.internal.reward.mediation.n)localIterator.next();
            try
            {
              localn.a.a(com.google.android.gms.dynamic.e.a(parama));
            }
            catch (RemoteException localRemoteException)
            {
              com.google.android.gms.ads.internal.util.e.c("Unable to call Adapter.onContextChanged.", localRemoteException);
            }
            continue;
          }
        }
        parama = null;
      }
      catch (Exception parama)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to extract updated context.", parama);
        this.a.i();
        return;
      }
      finally {}
    }
  }
  
  public final void c(String paramString)
  {
    Context localContext = this.b;
    if ((localContext instanceof c)) {}
    try
    {
      ((c)localContext).a(paramString);
      return;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      throw new RemoteException(PackageManager.NameNotFoundException.class.getSimpleName());
    }
  }
  
  public final boolean c()
  {
    synchronized (this.c)
    {
      boolean bool = this.a.S();
      return bool;
    }
  }
  
  public final void d()
  {
    b(null);
  }
  
  public final void d(com.google.android.gms.ads.internal.j.a arg1)
  {
    synchronized (this.c)
    {
      this.a.a();
      return;
    }
  }
  
  public final void e()
  {
    c(null);
  }
  
  public final void f()
  {
    d(null);
  }
  
  public final String g()
  {
    synchronized (this.c)
    {
      String str = this.a.N();
      return str;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */