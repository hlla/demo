package com.tencent.mm.sdk.f;

import com.tencent.gmtrace.GMTrace;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class d
  implements ThreadFactory
{
  private ThreadGroup hHV;
  private final AtomicInteger uvI;
  
  d()
  {
    GMTrace.i(13982400249856L, 104177);
    this.uvI = new AtomicInteger(1);
    this.hHV = new ThreadGroup("MM_THREAD_POOL_GROUP");
    GMTrace.o(13982400249856L, 104177);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    GMTrace.i(13982534467584L, 104178);
    paramRunnable = new Thread(this.hHV, paramRunnable, "MM_Thread_Pool_Thread#" + this.uvI.getAndIncrement());
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    GMTrace.o(13982534467584L, 104178);
    return paramRunnable;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */