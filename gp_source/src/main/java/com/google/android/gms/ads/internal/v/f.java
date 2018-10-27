package com.google.android.gms.ads.internal.v;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.g.b;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.a.z;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader.LoadingException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.l;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@com.google.android.gms.ads.internal.q.a.a
public final class f
{
  public com.google.android.gms.ads.internal.a.c a;
  public Context b;
  public b c = null;
  public final h d = new h();
  public Boolean e = null;
  public final AtomicInteger f = new AtomicInteger(0);
  public final Object g = new Object();
  public VersionInfoParcel h;
  public final n i = new n(u.h.i, this.k);
  private boolean j = false;
  private final com.google.android.gms.ads.internal.util.h k = new com.google.android.gms.ads.internal.util.h();
  
  public f()
  {
    new Object();
  }
  
  public static v g()
  {
    return com.google.android.gms.ads.internal.util.a.h.a(new ArrayList());
  }
  
  public final b a()
  {
    synchronized (this.g)
    {
      b localb = this.c;
      return localb;
    }
  }
  
  @TargetApi(23)
  public final void a(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (this.g)
    {
      if (!this.j)
      {
        this.b = paramContext.getApplicationContext();
        this.h = paramVersionInfoParcel;
        bt.A.h.a(this.i);
        this.k.a(this.b, null);
        com.google.android.gms.ads.internal.q.a.a(this.b, this.h);
        bt.A.e.b(paramContext, paramVersionInfoParcel.a);
        this.a = new com.google.android.gms.ads.internal.a.c(paramContext.getApplicationContext(), this.h);
        paramContext = bt.A.n;
        if (((Boolean)com.google.android.gms.ads.internal.f.n.M.a()).booleanValue()) {
          break label199;
        }
        com.google.android.gms.ads.internal.util.e.a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
        paramContext = null;
        this.c = paramContext;
        if (this.c != null)
        {
          paramContext = new g(this);
          if (!paramContext.j) {
            break label188;
          }
          paramContext = paramContext.k;
        }
      }
      label188:
      for (paramContext = l.a.a(paramContext);; paramContext = l.a(paramContext.k))
      {
        com.google.android.gms.ads.internal.util.a.e.a(paramContext, "AppState.registerCsiReporter");
        this.j = true;
        g();
        return;
      }
      label199:
      paramContext = new b();
    }
  }
  
  public final void a(Throwable paramThrowable, String paramString)
  {
    com.google.android.gms.ads.internal.q.a.a(this.b, this.h).a(paramThrowable, paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    h localh = this.d;
    if (!paramBoolean)
    {
      localh.a(i.b, i.c);
      return;
    }
    localh.a(i.c, i.b);
  }
  
  public final Boolean b()
  {
    synchronized (this.g)
    {
      Boolean localBoolean = this.e;
      return localBoolean;
    }
  }
  
  public final void b(Throwable paramThrowable, String paramString)
  {
    com.google.android.gms.ads.internal.q.a.a(this.b, this.h).a(paramThrowable, paramString, ((Float)com.google.android.gms.ads.internal.f.n.bO.a()).floatValue());
  }
  
  public final Resources c()
  {
    if (this.h.d) {
      return this.b.getResources();
    }
    try
    {
      DynamiteLoader.a(this.b).c.getResources();
      return null;
    }
    catch (DynamiteLoader.LoadingException localLoadingException)
    {
      com.google.android.gms.ads.internal.util.e.e("Cannot load resource from dynamite apk or local jar", localLoadingException);
    }
    return null;
  }
  
  public final void d()
  {
    this.f.incrementAndGet();
  }
  
  public final void e()
  {
    this.f.decrementAndGet();
  }
  
  @Deprecated
  public final com.google.android.gms.ads.internal.util.g f()
  {
    synchronized (this.g)
    {
      com.google.android.gms.ads.internal.util.h localh = this.k;
      return localh;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */