package com.google.android.gms.ads.internal.formats.a;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.b;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.e;
import java.util.WeakHashMap;

@a
public final class af
  implements com.google.android.gms.ads.formats.n
{
  private static WeakHashMap b = new WeakHashMap();
  public final ac a;
  
  private af(ac paramac)
  {
    new com.google.android.gms.ads.n();
    this.a = paramac;
    try
    {
      paramac = (Context)e.a(paramac.i());
      if (paramac != null) {
        paramac = new b(paramac);
      }
    }
    catch (RemoteException paramac)
    {
      for (;;)
      {
        try
        {
          boolean bool = this.a.a(e.a(paramac));
          if (!bool) {}
          return;
        }
        catch (RemoteException paramac)
        {
          k.c("", paramac);
          return;
        }
        paramac = paramac;
        k.c("", paramac);
        paramac = null;
      }
    }
    catch (NullPointerException paramac)
    {
      for (;;) {}
    }
  }
  
  public static af a(ac paramac)
  {
    synchronized (b)
    {
      af localaf = (af)b.get(paramac.asBinder());
      if (localaf == null)
      {
        localaf = new af(paramac);
        b.put(paramac.asBinder(), localaf);
        return localaf;
      }
      return localaf;
    }
  }
  
  public final String a()
  {
    try
    {
      String str = this.a.c();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.c("", localRemoteException);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */