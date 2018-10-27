package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.a.z;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@a
public final class l
{
  public static final z a;
  public static final ScheduledExecutorService b = new ScheduledThreadPoolExecutor(3, a("Schedule"));
  public static final z c = aa.a(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), a("Default")));
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Loader"));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    a = aa.a(localThreadPoolExecutor);
  }
  
  public static v a(Runnable paramRunnable)
  {
    return c.a(paramRunnable);
  }
  
  public static v a(Callable paramCallable)
  {
    return c.a(paramCallable);
  }
  
  private static ThreadFactory a(String paramString)
  {
    return new m(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */