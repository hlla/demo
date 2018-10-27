package com.google.android.gms.ads.internal.formats.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.e;
import com.google.android.gms.ads.formats.j;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class x
  extends j
{
  private final u a;
  private final h b;
  private final List c = new ArrayList();
  private final n d = new n();
  
  public x(u paramu)
  {
    this.a = paramu;
    for (;;)
    {
      try
      {
        paramu = this.a.f();
        if (paramu != null)
        {
          localIterator = paramu.iterator();
          boolean bool = localIterator.hasNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (RemoteException paramu)
      {
        Iterator localIterator;
        k.c("", paramu);
        continue;
        paramu = null;
        continue;
      }
      try
      {
        paramu = this.a.h();
        if (paramu == null) {
          continue;
        }
        paramu = new h(paramu);
      }
      catch (RemoteException paramu)
      {
        k.c("", paramu);
        paramu = null;
        continue;
      }
      this.b = paramu;
      try
      {
        if (this.a.r() != null) {
          new d(this.a.r());
        }
        return;
      }
      catch (RemoteException paramu)
      {
        k.c("", paramu);
      }
      paramu = null;
      continue;
      paramu = localIterator.next();
      if (!(paramu instanceof IBinder)) {
        continue;
      }
      paramu = f.a((IBinder)paramu);
      if (paramu != null) {
        this.c.add(new h(paramu));
      }
    }
  }
  
  private final com.google.android.gms.ads.internal.j.a k()
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = this.a.n();
      return locala;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final CharSequence b()
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
  
  public final List c()
  {
    return this.c;
  }
  
  public final CharSequence d()
  {
    try
    {
      String str = this.a.g();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
  
  public final e e()
  {
    return this.b;
  }
  
  public final CharSequence f()
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
  
  public final Double g()
  {
    Double localDouble = null;
    try
    {
      double d1 = this.a.j();
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
  
  public final CharSequence h()
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
  
  public final CharSequence i()
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
  
  public final n j()
  {
    try
    {
      if (this.a.m() != null) {
        this.d.a(this.a.m());
      }
      return this.d;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        k.c("Exception occurred while getting video controller", localRemoteException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */