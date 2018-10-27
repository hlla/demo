package com.google.android.finsky.af.a;

import com.google.android.finsky.af.c;
import com.google.android.finsky.af.e;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

final class h
  extends AbstractExecutorService
  implements c
{
  private final Executor a;
  private final ExecutorService b;
  
  h(ExecutorService paramExecutorService, Executor paramExecutor)
  {
    this.b = paramExecutorService;
    this.a = paramExecutor;
  }
  
  public final e a(Callable paramCallable)
  {
    return (e)super.submit(paramCallable);
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.b.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
  
  public final boolean isShutdown()
  {
    return this.b.isShutdown();
  }
  
  public final boolean isTerminated()
  {
    return this.b.isTerminated();
  }
  
  protected final RunnableFuture newTaskFor(Runnable paramRunnable, Object paramObject)
  {
    return new j(paramRunnable, paramObject, this.a);
  }
  
  protected final RunnableFuture newTaskFor(Callable paramCallable)
  {
    return new j(paramCallable, this.a);
  }
  
  public final void shutdown()
  {
    this.b.shutdown();
  }
  
  public final List shutdownNow()
  {
    return this.b.shutdownNow();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */