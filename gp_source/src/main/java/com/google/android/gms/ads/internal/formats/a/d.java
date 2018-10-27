package com.google.android.gms.ads.internal.formats.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  extends com.google.android.gms.ads.formats.d
{
  private final List a = new ArrayList();
  private final a b;
  
  public d(a parama)
  {
    this.b = parama;
    try
    {
      this.b.a();
      for (;;)
      {
        try
        {
          Iterator localIterator = parama.b().iterator();
          if (localIterator.hasNext())
          {
            parama = localIterator.next();
            if ((parama instanceof IBinder))
            {
              parama = f.a((IBinder)parama);
              if (parama == null) {
                continue;
              }
              this.a.add(new h(parama));
            }
          }
          else
          {
            return;
          }
        }
        catch (RemoteException parama)
        {
          k.c("", parama);
        }
        parama = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        k.c("", localRemoteException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */