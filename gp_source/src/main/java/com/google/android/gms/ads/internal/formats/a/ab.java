package com.google.android.gms.ads.internal.formats.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.e;
import com.google.android.gms.ads.formats.l;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class ab
  extends l
{
  private final y a;
  private final List b = new ArrayList();
  private final h c;
  private final n d = new n();
  
  public ab(y paramy)
  {
    this.a = paramy;
    for (;;)
    {
      try
      {
        paramy = this.a.f();
        if (paramy != null)
        {
          localIterator = paramy.iterator();
          boolean bool = localIterator.hasNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (RemoteException paramy)
      {
        Iterator localIterator;
        k.c("", paramy);
        continue;
        paramy = null;
        continue;
      }
      try
      {
        paramy = this.a.j();
        if (paramy == null) {
          continue;
        }
        paramy = new h(paramy);
      }
      catch (RemoteException paramy)
      {
        k.c("", paramy);
        paramy = null;
        continue;
      }
      this.c = paramy;
      try
      {
        if (this.a.p() != null) {
          new d(this.a.p());
        }
        return;
      }
      catch (RemoteException paramy)
      {
        k.c("", paramy);
      }
      paramy = null;
      continue;
      paramy = localIterator.next();
      if (!(paramy instanceof IBinder)) {
        continue;
      }
      paramy = f.a((IBinder)paramy);
      if (paramy != null) {
        this.b.add(new h(paramy));
      }
    }
  }
  
  private final com.google.android.gms.ads.internal.j.a i()
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
    return this.b;
  }
  
  public final CharSequence d()
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
  
  public final e e()
  {
    return this.c;
  }
  
  public final CharSequence f()
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
  
  public final CharSequence g()
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
  
  public final n h()
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */