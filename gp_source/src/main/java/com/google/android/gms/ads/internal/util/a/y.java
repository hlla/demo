package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@a
final class y
  extends FutureTask
  implements v
{
  private final w a = new w();
  
  y(Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, paramObject);
  }
  
  y(Callable paramCallable)
  {
    super(paramCallable);
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.a.a(paramRunnable, paramExecutor);
  }
  
  protected final void done()
  {
    this.a.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */