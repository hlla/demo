package com.google.android.finsky.bn;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

final class ad
  extends AbstractExecutorService
{
  private final Handler a = new Handler(Looper.getMainLooper());
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  public final boolean isShutdown()
  {
    return false;
  }
  
  public final boolean isTerminated()
  {
    return false;
  }
  
  public final void shutdown()
  {
    throw new UnsupportedOperationException("Cannot shut down UiThread Executor");
  }
  
  public final List shutdownNow()
  {
    throw new UnsupportedOperationException("Cannot shut down UiThread Executor");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */