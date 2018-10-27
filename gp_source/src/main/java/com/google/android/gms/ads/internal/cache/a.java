package com.google.android.gms.ads.internal.cache;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.util.bj;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public g a;
  public final Object b = new Object();
  public j c;
  private Context d;
  private final Runnable e = new b(this);
  
  public final CacheEntryParcel a(CacheOffering paramCacheOffering)
  {
    j localj;
    synchronized (this.b)
    {
      localj = this.c;
      if (localj == null)
      {
        paramCacheOffering = new CacheEntryParcel();
        return paramCacheOffering;
      }
    }
    return paramCacheOffering;
  }
  
  public final void a()
  {
    ??? = com.google.android.gms.ads.internal.f.n.w;
    if (((Boolean)u.h.e.a((com.google.android.gms.ads.internal.f.c)???)).booleanValue()) {
      synchronized (this.b)
      {
        b();
        Object localObject2 = bt.A.e;
        com.google.android.gms.ads.internal.util.n.a.removeCallbacks(this.e);
        localObject2 = bt.A.e;
        localObject2 = com.google.android.gms.ads.internal.util.n.a;
        Runnable localRunnable = this.e;
        com.google.android.gms.ads.internal.f.c localc = com.google.android.gms.ads.internal.f.n.x;
        ((Handler)localObject2).postDelayed(localRunnable, ((Long)u.h.e.a(localc)).longValue());
        return;
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    if (paramContext != null) {
      synchronized (this.b)
      {
        if (this.d == null)
        {
          this.d = paramContext.getApplicationContext();
          paramContext = com.google.android.gms.ads.internal.f.n.v;
          if (!((Boolean)u.h.e.a(paramContext)).booleanValue())
          {
            paramContext = com.google.android.gms.ads.internal.f.n.u;
            if (((Boolean)u.h.e.a(paramContext)).booleanValue())
            {
              paramContext = new c(this);
              bt.A.h.a(paramContext);
            }
            return;
          }
          b();
        }
      }
    }
  }
  
  final void b()
  {
    synchronized (this.b)
    {
      if ((this.d != null) && (this.a == null))
      {
        d locald = new d(this);
        e locale = new e(this);
        this.a = new g(this.d, bt.A.t.a(), locald, locale);
        this.a.r();
        return;
      }
      return;
    }
  }
  
  final void c()
  {
    synchronized (this.b)
    {
      g localg = this.a;
      if (localg != null)
      {
        if (localg.k()) {}
        for (;;)
        {
          this.a.f();
          do
          {
            this.a = null;
            this.c = null;
            Binder.flushPendingCommands();
            return;
          } while (!this.a.l());
        }
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */