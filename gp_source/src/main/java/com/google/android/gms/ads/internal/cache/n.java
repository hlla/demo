package com.google.android.gms.ads.internal.cache;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.bj;
import java.util.concurrent.Future;

@com.google.android.gms.ads.internal.q.a.a
public final class n
{
  public boolean a;
  public g b;
  public final Object c = new Object();
  private final Context d;
  
  public n(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public final Future a(CacheOffering arg1)
  {
    o localo = new o(this);
    p localp = new p(this, ???, localo);
    t localt = new t(this, localo);
    synchronized (this.c)
    {
      this.b = new g(this.d, bt.A.t.a(), localp, localt);
      this.b.r();
      return localo;
    }
  }
  
  final void a()
  {
    synchronized (this.c)
    {
      g localg = this.b;
      if (localg == null) {
        return;
      }
      localg.f();
      this.b = null;
      Binder.flushPendingCommands();
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/cache/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */