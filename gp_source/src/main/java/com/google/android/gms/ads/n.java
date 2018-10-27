package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.cl;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.common.internal.z;

@a
public final class n
{
  private o a;
  private bo b;
  private final Object c = new Object();
  
  public final bo a()
  {
    synchronized (this.c)
    {
      bo localbo = this.b;
      return localbo;
    }
  }
  
  public final void a(bo arg1)
  {
    Object localObject2;
    synchronized (this.c)
    {
      this.b = ???;
      localObject2 = this.a;
      if (localObject2 != null)
      {
        z.a(localObject2, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.c)
        {
          this.a = ((o)localObject2);
          localObject2 = this.b;
          if (localObject2 == null) {}
        }
      }
    }
    try
    {
      ((bo)localObject2).a(new cl());
      for (;;)
      {
        return;
      }
      localObject3 = finally;
      throw ((Throwable)localObject3);
      ??? = finally;
      throw ???;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        k.c("Unable to call setVideoLifecycleCallbacks on video controller.", localRemoteException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */