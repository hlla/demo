package com.google.android.finsky.bn;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class p
  implements ThreadFactory
{
  private final AtomicLong a = new AtomicLong(0L);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new q(paramRunnable);
    long l = this.a.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder(41);
    localStringBuilder.append("LightweightExecutor #");
    localStringBuilder.append(l);
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */