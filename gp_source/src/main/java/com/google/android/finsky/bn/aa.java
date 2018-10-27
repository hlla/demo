package com.google.android.finsky.bn;

import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public final class aa
{
  public ExecutorService a;
  public final ScheduledExecutorService b;
  public ScheduledFuture c;
  
  public aa(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.b = paramScheduledExecutorService;
  }
  
  final void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ScheduledFuture)localObject).cancel(true);
      this.c = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      FinskyLog.a("Tracking stopped for %s", new Object[] { localObject });
      this.a = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */