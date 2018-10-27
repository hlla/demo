package com.google.android.finsky.bn;

import com.google.android.finsky.utils.FinskyLog;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class ac
  extends ThreadPoolExecutor
{
  private final aa a;
  private final String b;
  
  ac(String paramString, aa paramaa, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    this.b = paramString;
    this.a = paramaa;
    paramaa.a = this;
    if (paramaa.c != null)
    {
      FinskyLog.e("Already monitoring executor: %s", new Object[] { this });
      paramaa.c.cancel(true);
    }
    paramaa.c = paramaa.b.scheduleWithFixedDelay(new ab(paramaa), 1L, 1L, TimeUnit.MINUTES);
  }
  
  protected final void terminated()
  {
    super.terminated();
    this.a.a();
  }
  
  public final String toString()
  {
    return String.format(Locale.ROOT, "Executor: %s %s", new Object[] { this.b, super.toString() });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */