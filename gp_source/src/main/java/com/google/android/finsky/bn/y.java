package com.google.android.finsky.bn;

import com.google.common.util.concurrent.an;
import com.google.common.util.concurrent.c;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class y
  extends c
  implements an
{
  private final an e;
  
  private y(an paraman)
  {
    this.e = paraman;
  }
  
  public static y a(an paraman)
  {
    if ((paraman instanceof y)) {
      return (y)paraman;
    }
    return new y(paraman);
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.e.a(paramRunnable, paramExecutor);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return this.e.cancel(paramBoolean);
  }
  
  public final Object get()
  {
    return this.e.get();
  }
  
  public final Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.e.get(paramLong, paramTimeUnit);
  }
  
  public final long getDelay(TimeUnit paramTimeUnit)
  {
    return this.e.getDelay(paramTimeUnit);
  }
  
  public final boolean isCancelled()
  {
    return this.e.isCancelled();
  }
  
  public final boolean isDone()
  {
    return this.e.isDone();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */