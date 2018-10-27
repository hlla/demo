package com.google.android.finsky.bn;

import com.google.common.util.concurrent.o;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class v
  extends o
  implements w
{
  private final ExecutorService a;
  
  v(ExecutorService paramExecutorService)
  {
    this.a = paramExecutorService;
  }
  
  public final com.google.common.util.concurrent.v a(Runnable paramRunnable)
  {
    return com.google.common.util.concurrent.v.c(super.b(paramRunnable));
  }
  
  public final com.google.common.util.concurrent.v a(Runnable paramRunnable, Object paramObject)
  {
    return com.google.common.util.concurrent.v.c(super.b(paramRunnable, paramObject));
  }
  
  public final com.google.common.util.concurrent.v a(Callable paramCallable)
  {
    return com.google.common.util.concurrent.v.c(super.b(paramCallable));
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
  
  public final boolean isShutdown()
  {
    return this.a.isShutdown();
  }
  
  public final boolean isTerminated()
  {
    return this.a.isTerminated();
  }
  
  public final void shutdown()
  {
    this.a.shutdown();
  }
  
  public final List shutdownNow()
  {
    return this.a.shutdownNow();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */