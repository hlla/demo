package com.google.android.finsky.bn;

import com.google.android.finsky.utils.bg;
import com.google.common.util.concurrent.ap;
import com.google.common.util.concurrent.aq;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public final class m
{
  private static final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(bg.a("Monitor Thread #%d"));
  private static final ap b = aq.a(Executors.newSingleThreadScheduledExecutor(bg.a("Scheduler Thread #%d")));
  
  static x a()
  {
    return a.a(new v(new ad()), b);
  }
  
  static x b()
  {
    return a.a(new v(new ac("bgExecutor", new aa(a), 4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new n())), b);
  }
  
  static x c()
  {
    int i = Runtime.getRuntime().availableProcessors();
    return a.a(new v(new ac("LightweightExecutor", new aa(a), Math.max(2, Math.min(i - 1, 4)), i + i + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new p())), b);
  }
  
  static x d()
  {
    return a.a(new v(new ac("BlockingExecutor", new aa(a), 0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), bg.a("BlockingExecutor #%d", 1))), b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */