package com.google.android.finsky.ay.a;

import android.os.Handler;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.ay.b;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.utils.af;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.nano.cb;
import com.google.wireless.android.finsky.dfe.nano.cd;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.google.android.finsky.ay.a
{
  public final Object a = new Object();
  public cb b;
  public long c;
  public final AtomicBoolean d = new AtomicBoolean(false);
  public final AtomicBoolean e = new AtomicBoolean(false);
  public final Set f = new HashSet();
  public final Handler g;
  private final com.google.android.finsky.api.i h;
  private final com.google.android.finsky.bo.c i;
  
  public a(com.google.android.finsky.api.i parami, Handler paramHandler, com.google.android.finsky.bo.c paramc)
  {
    this.h = parami;
    this.g = paramHandler;
    this.i = paramc;
  }
  
  private static cd b()
  {
    return new cd();
  }
  
  private final void c()
  {
    if ((this.i.cY().a(12657706L)) && (!this.e.get()))
    {
      com.google.android.finsky.api.d locald2 = this.h.a();
      com.google.android.finsky.api.d locald1 = locald2;
      if (locald2 == null) {
        locald1 = this.h.b();
      }
      this.e.set(true);
      locald1.j(new c(this), new d(this));
    }
  }
  
  public final cd a()
  {
    if (!this.i.cY().a(12657706L)) {
      return new cd();
    }
    if (this.d.get()) {}
    for (;;)
    {
      long l = this.c;
      if (((Long)com.google.android.finsky.ag.d.bE.b()).longValue() + l >= com.google.android.finsky.utils.i.a()) {
        synchronized (this.a)
        {
          cd localcd = this.b.a;
          if (localcd == null) {
            return b();
          }
          return localcd;
        }
      }
      c();
      return b();
      ??? = new cb();
      ??? = (String)com.google.android.finsky.ag.c.V.a();
      if (??? != null) {
        if (af.a((String)???, (g)???)) {
          l = ((Long)com.google.android.finsky.ag.c.W.a()).longValue();
        }
      }
      synchronized (this.a)
      {
        for (;;)
        {
          this.b = ((cb)???);
          this.c = l;
          c();
          break;
          l = 0L;
        }
        l = 0L;
      }
    }
  }
  
  public final void a(b paramb)
  {
    synchronized (this.f)
    {
      this.f.add(paramb);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */