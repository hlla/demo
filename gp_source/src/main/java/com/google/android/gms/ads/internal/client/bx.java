package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.n;
import com.google.android.gms.ads.p;
import java.util.concurrent.atomic.AtomicBoolean;

@com.google.android.gms.ads.internal.q.a.a
public final class bx
{
  public a a;
  public com.google.android.gms.ads.b b;
  public al c;
  public g[] d;
  public String e;
  public ViewGroup f;
  public int g;
  public final com.google.android.gms.ads.internal.mediation.client.a h = new com.google.android.gms.ads.internal.mediation.client.a();
  public com.google.android.gms.ads.b.a i;
  public com.google.android.gms.ads.k j;
  public final v k = new by(this);
  public boolean l;
  public com.google.android.gms.ads.b.b m;
  public final n n = new n();
  public p o;
  
  public bx(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, j.a, 0);
  }
  
  private bx(ViewGroup paramViewGroup, int paramInt)
  {
    this.f = paramViewGroup;
    this.c = null;
    new AtomicBoolean(false);
    this.g = paramInt;
  }
  
  private bx(ViewGroup paramViewGroup, j paramj, int paramInt)
  {
    this(paramViewGroup, 0);
  }
  
  public static AdSizeParcel a(Context paramContext, g[] paramArrayOfg, int paramInt)
  {
    boolean bool = true;
    paramContext = new AdSizeParcel(paramContext, paramArrayOfg);
    if (paramInt != 1) {
      bool = false;
    }
    paramContext.g = bool;
    return paramContext;
  }
  
  public final g a()
  {
    label24:
    do
    {
      try
      {
        localObject = this.c;
        if (localObject != null) {
          break label24;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject;
          com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
        }
      }
      localObject = this.d;
      if (localObject != null) {
        return localObject[0];
      }
      return null;
      localObject = ((al)localObject).c();
    } while (localObject == null);
    localObject = ((AdSizeParcel)localObject).c();
    return (g)localObject;
  }
  
  public final void a(com.google.android.gms.ads.b.a parama)
  {
    try
    {
      this.i = parama;
      al localal = this.c;
      if (localal != null) {
        if (parama == null) {
          break label35;
        }
      }
      label35:
      for (parama = new l(parama);; parama = null)
      {
        localal.a(parama);
        return;
      }
      return;
    }
    catch (RemoteException parama)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", parama);
    }
  }
  
  public final void a(com.google.android.gms.ads.b paramb)
  {
    this.b = paramb;
    v localv = this.k;
    synchronized (localv.b)
    {
      localv.a = paramb;
      return;
    }
  }
  
  public final void a(a parama)
  {
    try
    {
      this.a = parama;
      al localal = this.c;
      if (localal != null) {
        if (parama == null) {
          break label35;
        }
      }
      label35:
      for (parama = new b(parama);; parama = null)
      {
        localal.a(parama);
        return;
      }
      return;
    }
    catch (RemoteException parama)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", parama);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.e != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    this.e = paramString;
  }
  
  public final void a(g... paramVarArgs)
  {
    if (this.d != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    b(paramVarArgs);
  }
  
  public final String b()
  {
    al localal;
    if (this.e == null)
    {
      localal = this.c;
      if (localal == null) {}
    }
    try
    {
      this.e = localal.w();
      return this.e;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
      }
    }
  }
  
  public final void b(g... paramVarArgs)
  {
    this.d = paramVarArgs;
    try
    {
      paramVarArgs = this.c;
      if (paramVarArgs != null) {
        paramVarArgs.a(a(this.f.getContext(), this.d, this.g));
      }
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", paramVarArgs);
      }
    }
    this.f.requestLayout();
  }
  
  public final String c()
  {
    try
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((al)localObject).O();
        return (String)localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }
  
  public final bo d()
  {
    bo localbo = null;
    al localal = this.c;
    if (localal != null) {}
    try
    {
      localbo = localal.m();
      return localbo;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */