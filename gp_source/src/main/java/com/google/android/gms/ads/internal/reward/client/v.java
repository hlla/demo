package com.google.android.gms.ads.internal.reward.client;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.ads.f.c;
import com.google.android.gms.ads.f.d;
import com.google.android.gms.ads.internal.client.bv;
import com.google.android.gms.ads.internal.client.ci;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;

@a
public final class v
  implements c
{
  private final Context a;
  private final Object b = new Object();
  private final f c;
  private final t d = new t(null);
  
  public v(Context paramContext, f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = new ci();
    }
    this.c = ((f)localObject);
    this.a = paramContext.getApplicationContext();
  }
  
  public final void a(Activity paramActivity)
  {
    f localf;
    synchronized (this.b)
    {
      localf = this.c;
      if (localf == null) {}
    }
    try
    {
      localf.a(com.google.android.gms.dynamic.e.a(paramActivity));
      return;
      return;
      paramActivity = finally;
      throw paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      for (;;)
      {
        k.f("#007 Could not call remote method.", paramActivity);
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    f localf;
    synchronized (this.b)
    {
      this.d.a = null;
      localf = this.c;
      if (localf == null) {}
    }
    try
    {
      localf.d(com.google.android.gms.dynamic.e.a(paramContext));
      return;
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        k.f("#007 Could not call remote method.", paramContext);
      }
    }
  }
  
  public final void a(d paramd)
  {
    t localt;
    synchronized (this.b)
    {
      localt = this.d;
      localt.a = paramd;
      paramd = this.c;
      if (paramd == null) {}
    }
    try
    {
      paramd.a(localt);
      return;
      paramd = finally;
      throw paramd;
    }
    catch (RemoteException paramd)
    {
      for (;;)
      {
        k.f("#007 Could not call remote method.", paramd);
      }
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.c.c(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      if (PackageManager.NameNotFoundException.class.getSimpleName().equals(paramString.getMessage())) {
        throw new PackageManager.NameNotFoundException();
      }
      k.f("#007 Could not call remote method.", paramString);
    }
  }
  
  public final void a(String paramString, com.google.android.gms.ads.e arg2)
  {
    bv localbv = ???.a;
    f localf;
    synchronized (this.b)
    {
      localf = this.c;
      if (localf == null) {}
    }
    try
    {
      localf.a(new RewardedVideoAdRequestParcel(j.a(this.a, localbv), paramString));
      return;
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        k.f("#007 Could not call remote method.", paramString);
      }
    }
  }
  
  public final boolean a()
  {
    synchronized (this.b)
    {
      f localf = this.c;
      if (localf != null) {}
      try
      {
        boolean bool = localf.c();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        k.f("#007 Could not call remote method.", localRemoteException);
      }
      return false;
    }
    return false;
  }
  
  public final void b()
  {
    a(null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/client/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */