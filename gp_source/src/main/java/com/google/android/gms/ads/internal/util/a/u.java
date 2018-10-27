package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@a
public final class u
  implements v
{
  private final w a;
  private final Object b;
  
  u(Object paramObject)
  {
    this.b = paramObject;
    this.a = new w();
    this.a.a();
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.a.a(paramRunnable, paramExecutor);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final Object get()
  {
    return this.b;
  }
  
  public final Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.b;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */