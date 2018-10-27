package com.google.android.gms.ads.internal.mediation.client;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.formats.a.af;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.ads.mediation.i;
import com.google.android.gms.ads.mediation.j;
import com.google.android.gms.ads.mediation.q;

@a
public final class z
  implements e, com.google.android.gms.ads.mediation.h, j
{
  public com.google.android.gms.ads.formats.n a;
  public com.google.android.gms.ads.mediation.k b;
  public q c;
  private final h d;
  
  public z(h paramh)
  {
    this.d = paramh;
  }
  
  private static void a(i parami)
  {
    if (!(parami instanceof AdMobAdapter)) {
      new com.google.android.gms.ads.n().a(new w());
    }
  }
  
  public final void a()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClicked.");
    try
    {
      this.d.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void a(int paramInt)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Adapter called onAdFailedToLoad with error. ");
    localStringBuilder.append(paramInt);
    com.google.android.gms.ads.internal.util.client.k.b(localStringBuilder.toString());
    try
    {
      this.d.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void a(com.google.android.gms.ads.formats.n paramn)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    String str = String.valueOf(paramn.a());
    if (str.length() == 0) {}
    for (str = new String("Adapter called onAdLoaded with template id ");; str = "Adapter called onAdLoaded with template id ".concat(str))
    {
      com.google.android.gms.ads.internal.util.client.k.b(str);
      this.a = paramn;
      try
      {
        this.d.e();
        return;
      }
      catch (RemoteException paramn)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", paramn);
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.formats.n paramn, String paramString)
  {
    if ((paramn instanceof af)) {}
    try
    {
      this.d.a(((af)paramn).a, paramString);
      return;
    }
    catch (RemoteException paramn)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", paramn);
    }
    com.google.android.gms.ads.internal.util.client.k.e("Unexpected native custom template ad type.");
    return;
  }
  
  public final void a(i parami, com.google.android.gms.ads.mediation.k paramk)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLoaded.");
    this.b = paramk;
    this.c = null;
    a(parami);
    try
    {
      this.d.e();
      return;
    }
    catch (RemoteException parami)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", parami);
    }
  }
  
  public final void a(i parami, q paramq)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLoaded.");
    this.c = paramq;
    this.b = null;
    a(parami);
    try
    {
      this.d.e();
      return;
    }
    catch (RemoteException parami)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", parami);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAppEvent.");
    try
    {
      this.d.a(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", paramString1);
    }
  }
  
  public final void b()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClosed.");
    try
    {
      this.d.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void b(int paramInt)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Adapter called onAdFailedToLoad with error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".");
    com.google.android.gms.ads.internal.util.client.k.b(localStringBuilder.toString());
    try
    {
      this.d.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void c()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLeftApplication.");
    try
    {
      this.d.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void c(int paramInt)
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Adapter called onAdFailedToLoad with error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".");
    com.google.android.gms.ads.internal.util.client.k.b(localStringBuilder.toString());
    try
    {
      this.d.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void d()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdOpened.");
    try
    {
      this.d.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void e()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLoaded.");
    try
    {
      this.d.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void f()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClicked.");
    try
    {
      this.d.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void g()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClosed.");
    try
    {
      this.d.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void h()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLeftApplication.");
    try
    {
      this.d.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void i()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdOpened.");
    try
    {
      this.d.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void j()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLoaded.");
    try
    {
      this.d.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void k()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdOpened.");
    try
    {
      this.d.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void l()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClosed.");
    try
    {
      this.d.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void m()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdLeftApplication.");
    try
    {
      this.d.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void n()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.mediation.k localk = this.b;
    q localq = this.c;
    if (this.a != null) {
      com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdClicked.");
    }
    try
    {
      this.d.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
    if (localk != null) {}
    for (;;)
    {
      if ((localq != null) && (!localq.i))
      {
        com.google.android.gms.ads.internal.util.client.k.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        return;
      }
      if ((localk == null) || (localk.b)) {
        break;
      }
      com.google.android.gms.ads.internal.util.client.k.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
      return;
      if (localq == null)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", null);
        return;
      }
    }
  }
  
  public final void o()
  {
    com.google.android.gms.common.internal.z.a("#008 Must be called on the main UI thread.");
    com.google.android.gms.ads.mediation.k localk = this.b;
    q localq = this.c;
    if (this.a != null) {
      com.google.android.gms.ads.internal.util.client.k.b("Adapter called onAdImpression.");
    }
    try
    {
      this.d.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
    if (localk != null) {}
    for (;;)
    {
      if ((localq != null) && (!localq.j))
      {
        com.google.android.gms.ads.internal.util.client.k.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        return;
      }
      if ((localk == null) || (localk.c)) {
        break;
      }
      com.google.android.gms.ads.internal.util.client.k.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
      return;
      if (localq == null)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", null);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */