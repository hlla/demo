package com.google.android.gms.ads.internal.mediation.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.mediation.m;
import com.google.ads.mediation.o;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.client.k;

@com.google.android.gms.ads.internal.q.a.a
public final class ae
  implements m, o
{
  public final h a;
  
  public ae(h paramh)
  {
    this.a = paramh;
  }
  
  public final void a(com.google.ads.a parama)
  {
    Object localObject = String.valueOf(parama);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 47);
    localStringBuilder.append("Adapter called onFailedToReceiveAd with error. ");
    localStringBuilder.append((String)localObject);
    k.b(localStringBuilder.toString());
    localObject = u.h.a;
    if (!com.google.android.gms.ads.internal.util.client.a.b())
    {
      k.f("#008 Must be called on the main UI thread.", null);
      com.google.android.gms.ads.internal.util.client.a.g.post(new af(this, parama));
      return;
    }
    try
    {
      this.a.a(ah.a(parama));
      return;
    }
    catch (RemoteException parama)
    {
      k.f("#007 Could not call remote method.", parama);
    }
  }
  
  public final void b(com.google.ads.a parama)
  {
    Object localObject = String.valueOf(parama);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 47);
    localStringBuilder.append("Adapter called onFailedToReceiveAd with error ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".");
    k.b(localStringBuilder.toString());
    localObject = u.h.a;
    if (!com.google.android.gms.ads.internal.util.client.a.b())
    {
      k.f("#008 Must be called on the main UI thread.", null);
      com.google.android.gms.ads.internal.util.client.a.g.post(new ag(this, parama));
      return;
    }
    try
    {
      this.a.a(ah.a(parama));
      return;
    }
    catch (RemoteException parama)
    {
      k.f("#007 Could not call remote method.", parama);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */