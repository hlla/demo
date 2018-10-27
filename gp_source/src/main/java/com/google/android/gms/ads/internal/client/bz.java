package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.f.d;
import com.google.android.gms.ads.internal.util.client.k;

@com.google.android.gms.ads.internal.q.a.a
public final class bz
{
  public a a;
  public b b;
  public al c;
  public com.google.android.gms.ads.f.a d;
  public String e;
  public final com.google.android.gms.ads.internal.mediation.client.a f = new com.google.android.gms.ads.internal.mediation.client.a();
  public final Context g;
  public boolean h;
  public d i;
  public boolean j;
  
  public bz(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private bz(Context paramContext, byte paramByte)
  {
    this.g = paramContext;
  }
  
  public final Bundle a()
  {
    try
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((al)localObject).j();
        return (Bundle)localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      k.f("#008 Must be called on the main UI thread.", localRemoteException);
    }
    return new Bundle();
  }
  
  public final void a(String paramString)
  {
    if (this.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 63);
      localStringBuilder.append("The ad unit ID must be set on InterstitialAd before ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is called.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public final void b()
  {
    try
    {
      a("show");
      this.c.P();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      k.f("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */