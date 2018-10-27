package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.f.a.c;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  implements c
{
  private final a a;
  
  public d(a parama)
  {
    this.a = parama;
  }
  
  public final void a(Bundle paramBundle)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdMetadataChanged.");
    try
    {
      this.a.a(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      k.f("#007 Could not call remote method.", paramBundle);
    }
  }
  
  public final void a(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onInitializationSucceeded.");
    try
    {
      this.a.a(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void a(com.google.android.gms.ads.f.a.b paramb, int paramInt)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdFailedToLoad.");
    try
    {
      this.a.b(e.a(paramb), paramInt);
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void a(com.google.android.gms.ads.f.a.b paramb, com.google.android.gms.ads.f.b paramb1)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onRewarded.");
    if (paramb1 != null) {}
    try
    {
      this.a.a(e.a(paramb), new RewardItemParcel(paramb1));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
    this.a.a(e.a(paramb), new RewardItemParcel("", 1));
    return;
  }
  
  public final void b(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdLoaded.");
    try
    {
      this.a.b(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void c(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdOpened.");
    try
    {
      this.a.c(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void d(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onVideoStarted.");
    try
    {
      this.a.d(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void e(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdClosed.");
    try
    {
      this.a.e(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void f(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onAdLeftApplication.");
    try
    {
      this.a.g(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
  
  public final void g(com.google.android.gms.ads.f.a.b paramb)
  {
    z.a("#008 Must be called on the main UI thread.");
    k.b("Adapter called onVideoCompleted.");
    try
    {
      this.a.h(e.a(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      k.f("#007 Could not call remote method.", paramb);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/mediation/client/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */