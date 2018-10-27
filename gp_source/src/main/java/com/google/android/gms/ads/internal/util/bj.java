package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.internal.z;

@a
public final class bj
{
  public Handler a = null;
  private HandlerThread b = null;
  private final Object c = new Object();
  private int d = 0;
  
  public final Looper a()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.d != 0)
        {
          z.a(this.b, "Invalid state: mHandlerThread should already been initialized.");
          this.d += 1;
          Looper localLooper = this.b.getLooper();
          return localLooper;
        }
        if (this.b != null)
        {
          e.a("Resuming the looper thread");
          this.c.notifyAll();
        }
      }
      e.a("Starting the looper thread.");
      this.b = new HandlerThread("LooperProvider");
      this.b.start();
      this.a = new Handler(this.b.getLooper());
      e.a("Looper thread started.");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */