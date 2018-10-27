package com.google.android.gms.ads.internal.formats.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.r;
import com.google.android.gms.ads.internal.client.bl;
import com.google.android.gms.ads.internal.client.bn;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class bc
  extends r
{
  private final az a;
  private final h b;
  private final List c = new ArrayList();
  private final List d = new ArrayList();
  private final n e = new n();
  
  public bc(az paramaz)
  {
    this.a = paramaz;
    for (;;)
    {
      try
      {
        paramaz = this.a.f();
        if (paramaz != null)
        {
          localIterator = paramaz.iterator();
          bool = localIterator.hasNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (RemoteException paramaz)
      {
        Iterator localIterator;
        boolean bool;
        k.c("", paramaz);
        continue;
        paramaz = null;
        continue;
      }
      try
      {
        paramaz = this.a.g();
        if (paramaz != null)
        {
          localIterator = paramaz.iterator();
          bool = localIterator.hasNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (RemoteException paramaz)
      {
        k.c("", paramaz);
        continue;
        paramaz = null;
        continue;
      }
      try
      {
        paramaz = this.a.j();
        if (paramaz == null) {
          continue;
        }
        paramaz = new h(paramaz);
      }
      catch (RemoteException paramaz)
      {
        k.c("", paramaz);
        paramaz = null;
        continue;
      }
      this.b = paramaz;
      try
      {
        if (this.a.u() != null) {
          new d(this.a.u());
        }
        return;
      }
      catch (RemoteException paramaz)
      {
        k.c("", paramaz);
      }
      paramaz = null;
      continue;
      paramaz = localIterator.next();
      if ((paramaz instanceof IBinder))
      {
        paramaz = bl.a((IBinder)paramaz);
        if (paramaz != null) {
          this.c.add(new bn(paramaz));
        }
      }
      else
      {
        paramaz = localIterator.next();
        if (!(paramaz instanceof IBinder)) {
          continue;
        }
        paramaz = f.a((IBinder)paramaz);
        if (paramaz != null) {
          this.d.add(new h(paramaz));
        }
      }
    }
  }
  
  private final com.google.android.gms.ads.internal.j.a m()
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = this.a.q();
      return locala;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final String a()
  {
    try
    {
      String str = this.a.a();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final List b()
  {
    return this.d;
  }
  
  public final String c()
  {
    try
    {
      String str = this.a.i();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final com.google.android.gms.ads.formats.e d()
  {
    return this.b;
  }
  
  public final String e()
  {
    try
    {
      String str = this.a.k();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final String f()
  {
    try
    {
      String str = this.a.l();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final Double g()
  {
    Double localDouble = null;
    try
    {
      double d1 = this.a.m();
      if (d1 != -1.0D) {
        localDouble = Double.valueOf(d1);
      }
      return localDouble;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final String h()
  {
    try
    {
      String str = this.a.n();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final String i()
  {
    try
    {
      String str = this.a.o();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final n j()
  {
    try
    {
      if (this.a.p() != null) {
        this.e.a(this.a.p());
      }
      return this.e;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        k.c("Exception occurred while getting video controller", localRemoteException);
      }
    }
  }
  
  public final Object l()
  {
    try
    {
      Object localObject = this.a.r();
      if (localObject != null)
      {
        localObject = com.google.android.gms.dynamic.e.a((com.google.android.gms.ads.internal.j.a)localObject);
        return localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */