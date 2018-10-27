package com.google.android.gms.ads.internal.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.a.z;
import com.google.android.gms.ads.internal.util.l;
import java.util.concurrent.Future;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends com.google.android.gms.ads.internal.util.a
  implements f, i, m
{
  public volatile com.google.android.gms.ads.internal.gmsg.b a;
  public final String b;
  public final Context c;
  public final com.google.android.gms.ads.internal.mediation.b d;
  public final String e;
  private final n f;
  private int g = 3;
  private Future h;
  private final i i;
  private int m = 0;
  private final Object n;
  private final com.google.android.gms.ads.internal.v.b o;
  private d p;
  private final long q;
  
  public a(Context paramContext, String paramString1, String paramString2, com.google.android.gms.ads.internal.mediation.b paramb, com.google.android.gms.ads.internal.v.b paramb1, n paramn, i parami, long paramLong)
  {
    this.c = paramContext;
    this.b = paramString1;
    this.e = paramString2;
    this.d = paramb;
    this.o = paramb1;
    this.f = paramn;
    this.n = new Object();
    this.i = parami;
    this.q = paramLong;
  }
  
  private final boolean a(long paramLong)
  {
    paramLong = this.q - (bt.A.l.b() - paramLong);
    if (paramLong <= 0L)
    {
      this.g = 4;
      return false;
    }
    try
    {
      this.n.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      this.g = 5;
    }
    return false;
  }
  
  public final void a()
  {
    ??? = this.f;
    h localh;
    Object localObject3;
    if (??? != null)
    {
      localh = ((n)???).b;
      if ((localh != null) && (((n)???).a != null))
      {
        localh.b = null;
        localh.a = this;
        localh.c = this;
        ??? = this.o.d.b;
        localObject3 = this.f.a;
      }
    }
    try
    {
      if (!((com.google.android.gms.ads.internal.mediation.client.e)localObject3).g()) {
        com.google.android.gms.ads.internal.util.client.a.g.post(new c(this, (com.google.android.gms.ads.internal.mediation.client.e)localObject3, (AdRequestParcel)???, localh));
      }
      for (;;)
      {
        long l = bt.A.l.b();
        synchronized (this.n)
        {
          if (this.m == 0) {
            if (!a(l))
            {
              localObject3 = new e();
              ((e)localObject3).b = this.g;
              ((e)localObject3).c = (bt.A.l.b() - l);
              ((e)localObject3).a = this.d.g;
              this.p = ((e)localObject3).a();
              localh.b = null;
              localh.a = null;
              if (this.m == 1)
              {
                this.i.a(this.b);
                return;
              }
              this.i.a(this.g);
              return;
            }
          }
        }
        localObject3 = new e();
        ((e)localObject3).c = (bt.A.l.b() - l);
        if (this.m != 1) {}
        for (int j = this.g;; j = 6)
        {
          ((e)localObject3).b = j;
          ((e)localObject3).a = this.d.g;
          this.p = ((e)localObject3).a();
          break;
        }
        com.google.android.gms.ads.internal.util.client.a.g.post(new b(this, (AdRequestParcel)???, (com.google.android.gms.ads.internal.mediation.client.e)localObject3));
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.e("Fail to check if adapter is initialized.", localRemoteException);
        a(0);
      }
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.n)
    {
      this.m = 2;
      this.g = paramInt;
      this.n.notify();
      return;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    com.google.android.gms.ads.internal.gmsg.b localb = this.a;
    if (localb != null) {
      localb.a(paramBundle);
    }
  }
  
  final void a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.mediation.client.e parame)
  {
    this.f.b.b = this;
    try
    {
      if (!"com.google.ads.mediation.admob.AdMobAdapter".equals(this.b))
      {
        parame.a(paramAdRequestParcel, this.e);
        return;
      }
      parame.a(paramAdRequestParcel, this.e, this.d.b);
      return;
    }
    catch (RemoteException paramAdRequestParcel)
    {
      com.google.android.gms.ads.internal.util.e.e("Fail to load ad from adapter.", paramAdRequestParcel);
      a(0);
    }
  }
  
  public final void a(String arg1)
  {
    synchronized (this.n)
    {
      this.m = 1;
      this.n.notify();
      return;
    }
  }
  
  public final void be_() {}
  
  public final Future d()
  {
    Future localFuture = this.h;
    Object localObject = localFuture;
    if (localFuture == null)
    {
      if (!this.j) {
        break label40;
      }
      localObject = this.k;
    }
    label40:
    for (localObject = l.a.a((Runnable)localObject);; localObject = l.a(this.k))
    {
      this.h = ((Future)localObject);
      return (Future)localObject;
    }
  }
  
  public final d e()
  {
    synchronized (this.n)
    {
      d locald = this.p;
      return locald;
    }
  }
  
  public final void f()
  {
    a(this.o.d.b, this.f.a);
  }
  
  public final void g()
  {
    a(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/mediation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */