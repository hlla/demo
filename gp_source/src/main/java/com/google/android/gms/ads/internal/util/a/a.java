package com.google.android.gms.ads.internal.util.a;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@com.google.android.gms.ads.internal.q.a.a
public abstract class a
  extends AbstractExecutorService
  implements z
{
  public final v a(Runnable paramRunnable)
  {
    return (v)super.submit(paramRunnable);
  }
  
  public final v a(Callable paramCallable)
  {
    return (v)super.submit(paramCallable);
  }
  
  protected final RunnableFuture newTaskFor(Runnable paramRunnable, Object paramObject)
  {
    return new y(paramRunnable, paramObject);
  }
  
  protected final RunnableFuture newTaskFor(Callable paramCallable)
  {
    return new y(paramCallable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */