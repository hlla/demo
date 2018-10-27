package com.google.android.finsky.cb;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.e.af;
import com.google.android.finsky.heterodyne.HeterodynePeriodicSyncJob;
import com.google.android.finsky.heterodyne.o;
import com.google.android.finsky.scheduler.bw;
import com.google.android.finsky.selfupdate.r;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bg;
import com.google.wireless.android.a.b.a.a.v;
import java.util.ArrayDeque;

public final class a
{
  public com.google.android.finsky.volley.h A;
  private ArrayDeque B = null;
  private final int C;
  public com.google.android.finsky.accounts.c a;
  public com.google.android.finsky.l.a b;
  public final Runnable c;
  public Context d;
  public com.google.android.finsky.deviceconfig.d e;
  public com.google.android.finsky.az.a f;
  public com.google.android.finsky.api.d g = null;
  public com.google.android.finsky.api.i h;
  public com.google.android.finsky.api.n i;
  public com.google.android.finsky.dn.e j;
  public com.google.android.finsky.bo.f k;
  public com.google.android.finsky.bo.c l;
  public com.google.android.finsky.heterodyne.f m;
  public boolean n;
  public com.google.android.finsky.heterodyne.n o;
  public final h p;
  public int q;
  public af r;
  public final Handler s;
  public final boolean t;
  public com.google.android.finsky.eg.a u;
  public r v;
  public com.google.android.finsky.ba.g w;
  public com.google.android.finsky.en.a x;
  public com.google.android.finsky.eu.c y;
  public int z;
  
  public a(int paramInt, h paramh, af paramaf)
  {
    ((i)com.google.android.finsky.dt.b.a(i.class)).a(this);
    this.C = paramInt;
    this.p = paramh;
    this.k = this.l.cY();
    this.r = paramaf;
    this.t = (this.k.a(12660604L) ^ true);
    this.s = new Handler(Looper.getMainLooper());
    this.c = new c(this);
  }
  
  public static void a(String paramString)
  {
    FinskyLog.b("Hygiene stage: %s", new Object[] { paramString });
  }
  
  public final void a()
  {
    boolean bool2 = false;
    a("checkVpaDeferredNotificationSupport");
    if (!com.google.android.finsky.ag.c.aZ.b())
    {
      Object localObject = this.b.a;
      if (localObject != null)
      {
        localObject = ((com.google.android.finsky.dh.a)localObject).a("com.android.vending");
        if (localObject == null)
        {
          b();
          return;
        }
        q localq = com.google.android.finsky.ag.c.aZ;
        boolean bool1 = bool2;
        if (this.z == -1)
        {
          bool1 = bool2;
          if (!((com.google.android.finsky.dh.b)localObject).n) {
            bool1 = true;
          }
        }
        localq.a(Boolean.valueOf(bool1));
      }
    }
    else
    {
      b();
      return;
    }
    b();
  }
  
  final void b()
  {
    a("probeAccounts");
    if (this.B == null) {
      this.B = this.i.a(com.google.android.finsky.utils.a.d());
    }
    if (this.B.isEmpty())
    {
      this.k = this.l.h(null);
      this.r = this.r.a(null);
      this.p.a(null, true, this.k, this.r, false);
      return;
    }
    this.g = ((com.google.android.finsky.api.d)this.B.removeFirst());
    if (this.g.b() != null)
    {
      FinskyLog.a("Probe %s for hygiene pass", new Object[] { FinskyLog.a(this.g.c()) });
      this.k = this.l.h(this.g.c());
    }
    for (this.r = this.r.a(this.g.b());; this.r = this.r.a(null))
    {
      af localaf = this.r;
      int i1 = this.C;
      v localv = new v();
      localv.a(i1);
      localaf.a(new com.google.android.finsky.e.d(151).a(localv).a(this.f.a()));
      a("beginPreloadFinskyExperiments");
      if (!((Boolean)com.google.android.finsky.ag.d.bi.b()).booleanValue())
      {
        c();
        return;
      }
      if (this.g.b() != null)
      {
        this.y.a(this.g, false, false, new d(this));
        return;
      }
      c();
      return;
      FinskyLog.a("Probe unauthenticated for hygiene pass", new Object[0]);
      this.k = this.l.h(null);
    }
  }
  
  final void c()
  {
    a("beginPreloadPhenotypeExperiments");
    if ((!((Boolean)com.google.android.finsky.ag.d.bi.b()).booleanValue()) || (!this.k.a(12652520L)) || (this.n))
    {
      d();
      return;
    }
    if (this.t) {
      this.s.postDelayed(this.c, ((Long)com.google.android.finsky.ag.d.en.b()).longValue());
    }
    Object localObject1;
    if ((!this.l.cY().a(12658823L)) && (this.j.c("ExperimentFramework", "enable_heterodyne_periodic_sync")))
    {
      localObject1 = this.o;
      if (!((com.google.android.finsky.heterodyne.n)localObject1).b.c(0)) {
        break label241;
      }
      FinskyLog.b("Heterodyne periodic sync already running.", new Object[0]);
    }
    for (;;)
    {
      Object localObject2 = this.m.a(this.d, this.r);
      localObject1 = this.g;
      if (localObject1 == null) {}
      String str;
      for (localObject1 = this.a.cS();; str = localException.c()) {
        try
        {
          bg.a(new e(this, (com.google.android.finsky.heterodyne.a)localObject2, (String)localObject1), new Void[0]);
          return;
        }
        catch (Exception localException)
        {
          FinskyLog.a(localException, "Unable to start thread for loading experiment flags.", new Object[0]);
          if (this.t) {
            this.s.removeCallbacks(this.c);
          }
          d();
          return;
        }
      }
      label241:
      localObject2 = str.a;
      if (localObject2 != null) {
        str.b.a(0, "period_sync", HeterodynePeriodicSyncJob.class, (com.google.android.finsky.scheduler.b.a)localObject2, null).a(o.a);
      }
    }
  }
  
  final void d()
  {
    a("beginSelfUpdateCheck");
    if ((((Boolean)com.google.android.finsky.ag.d.bN.b()).booleanValue()) && (this.w.c()))
    {
      this.p.a(this.g, true, this.k, this.r, false);
      return;
    }
    com.google.wireless.android.a.b.a.a.f localf = new com.google.wireless.android.a.b.a.a.f();
    localf.b(this.q);
    localf.a(true);
    af localaf = this.r.a("su_daily_hygiene");
    this.u.a(this.g, this.e, new g(this, localf, localaf));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */