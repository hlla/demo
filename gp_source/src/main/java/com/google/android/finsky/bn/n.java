package com.google.android.finsky.bn;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class n
  implements ThreadFactory
{
  private final AtomicLong a = new AtomicLong(0L);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new o(paramRunnable);
    long l = this.a.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append("bgExecutor #");
    localStringBuilder.append(l);
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */