package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class y<T>
{
  private final Map<T, ap<T>> aHl = new HashMap();
  
  public final void a(ao paramao)
  {
    synchronized (this.aHl)
    {
      an.f localf = new an.f();
      Iterator localIterator = this.aHl.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ap localap = (ap)localEntry.getValue();
          if (localap == null) {
            continue;
          }
          localap.aHH = null;
          localap.aHI = null;
          localap.aHJ = null;
          localap.aHK = null;
          localap.aHL = null;
          localap.aHM = null;
          localap.aHN = null;
          localap.aHO = null;
          boolean bool = paramao.isConnected();
          if (!bool) {
            continue;
          }
          try
          {
            ((x)paramao.jY()).a(localf, new RemoveListenerRequest(localap));
            if (Log.isLoggable("WearableClient", 2)) {
              new StringBuilder("disconnect: removed: ").append(localEntry.getKey()).append("/").append(localap);
            }
          }
          catch (RemoteException localRemoteException)
          {
            new StringBuilder("disconnect: Didn't remove: ").append(localEntry.getKey()).append("/").append(localap);
          }
        }
      }
    }
    this.aHl.clear();
  }
  
  public final void u(IBinder paramIBinder)
  {
    synchronized (this.aHl)
    {
      paramIBinder = x.a.t(paramIBinder);
      an.f localf = new an.f();
      Iterator localIterator = this.aHl.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ap localap = (ap)localEntry.getValue();
          try
          {
            paramIBinder.a(localf, new AddListenerRequest(localap));
            if (Log.isLoggable("WearableClient", 2)) {
              new StringBuilder("onPostInitHandler: added: ").append(localEntry.getKey()).append("/").append(localap);
            }
          }
          catch (RemoteException localRemoteException)
          {
            new StringBuilder("onPostInitHandler: Didn't add: ").append(localEntry.getKey()).append("/").append(localap);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */