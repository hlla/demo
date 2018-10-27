package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.f;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@a
public final class h
{
  public static q a(Iterable paramIterable)
  {
    return new q(paramIterable);
  }
  
  public static t a(Throwable paramThrowable)
  {
    return new t(paramThrowable);
  }
  
  public static u a(Object paramObject)
  {
    return new u(paramObject);
  }
  
  public static v a(v paramv, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    af localaf = af.b();
    a(localaf, paramv);
    paramTimeUnit = paramScheduledExecutorService.schedule(new l(localaf), paramLong, paramTimeUnit);
    a(paramv, localaf);
    localaf.a(new m(paramTimeUnit), aa.a);
    return localaf;
  }
  
  public static v a(v paramv, b paramb, Executor paramExecutor)
  {
    af localaf = new af();
    paramv.a(new k(localaf, paramb, paramv), paramExecutor);
    a(localaf, paramv);
    return localaf;
  }
  
  public static v a(v paramv, c paramc, Executor paramExecutor)
  {
    af localaf = new af();
    paramv.a(new j(localaf, paramc, paramv), paramExecutor);
    a(localaf, paramv);
    return localaf;
  }
  
  public static v a(v paramv, Class paramClass, b paramb, Executor paramExecutor)
  {
    af localaf = af.b();
    a(localaf, paramv);
    paramv.a(new n(localaf, paramv, paramClass, paramb, paramExecutor), aa.a);
    return localaf;
  }
  
  public static Object a(Future paramFuture, Object paramObject)
  {
    try
    {
      Object localObject = paramFuture.get(((Long)com.google.android.gms.ads.internal.f.n.bs.a()).longValue(), TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      paramFuture.cancel(true);
      e.e("InterruptedException caught while resolving future.", localInterruptedException);
      Thread.currentThread().interrupt();
      bt.A.i.b(localInterruptedException, "Futures.resolveFuture");
      return paramObject;
    }
    catch (Exception localException)
    {
      paramFuture.cancel(true);
      e.c("Error waiting for future.", localException);
      bt.A.i.b(localException, "Futures.resolveFuture");
    }
    return paramObject;
  }
  
  public static Object a(Future paramFuture, Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit = paramFuture.get(paramLong, paramTimeUnit);
      return paramTimeUnit;
    }
    catch (InterruptedException paramTimeUnit)
    {
      paramFuture.cancel(true);
      e.e("InterruptedException caught while resolving future.", paramTimeUnit);
      Thread.currentThread().interrupt();
      bt.A.i.b(paramTimeUnit, "Futures.resolveFuture");
      return paramObject;
    }
    catch (Exception paramTimeUnit)
    {
      paramFuture.cancel(true);
      e.c("Error waiting for future.", paramTimeUnit);
      bt.A.i.b(paramTimeUnit, "Futures.resolveFuture");
    }
    return paramObject;
  }
  
  static void a(v paramv, af paramaf)
  {
    a(paramaf, paramv);
    paramv.a(new o(paramaf, paramv), aa.a);
  }
  
  public static void a(v paramv, d paramd, Executor paramExecutor)
  {
    paramv.a(new i(paramd, paramv), paramExecutor);
  }
  
  static void a(v paramv, Future paramFuture)
  {
    paramv.a(new p(paramv, paramFuture), aa.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */