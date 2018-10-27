package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@a
public final class t
  implements v
{
  private final Throwable a;
  private final w b;
  
  t(Throwable paramThrowable)
  {
    this.a = paramThrowable;
    this.b = new w();
    this.b.a();
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.b.a(paramRunnable, paramExecutor);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final Object get()
  {
    throw new ExecutionException(this.a);
  }
  
  public final Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new ExecutionException(this.a);
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final boolean isDone()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */