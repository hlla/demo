package com.tencent.mm.sdk.f;

import com.tencent.gmtrace.GMTrace;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b
{
  private ThreadGroup hHV;
  private final AtomicInteger uvI;
  private e.b uvJ;
  
  b(e.b paramb)
  {
    GMTrace.i(13980118548480L, 104160);
    this.uvI = new AtomicInteger(1);
    this.uvJ = paramb;
    this.hHV = new ThreadGroup("MM_FREE_THREAD_GROUP");
    GMTrace.o(13980118548480L, 104160);
  }
  
  final Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    GMTrace.i(13980252766208L, 104161);
    Assert.assertNotNull("newThread arg name is null!", paramString);
    if (paramRunnable != null)
    {
      paramRunnable = new g(paramRunnable, paramString, paramInt, false, this.uvJ);
      paramRunnable = new a(this.hHV, paramRunnable, "MM_Thread_Pool_Free_Thread#" + this.uvI.getAndIncrement() + "#" + paramString);
      paramRunnable.setPriority(paramInt);
    }
    for (;;)
    {
      GMTrace.o(13980252766208L, 104161);
      return paramRunnable;
      paramRunnable = new a(this.hHV, null, "MM_Thread_Pool_Free_Thread#" + this.uvI.getAndIncrement() + "#" + paramString);
      paramRunnable.setPriority(paramInt);
    }
  }
  
  static final class a
    extends Thread
  {
    private g uvK;
    
    a(ThreadGroup paramThreadGroup, g paramg, String paramString)
    {
      super(paramg, paramString);
      GMTrace.i(13987903176704L, 104218);
      this.uvK = paramg;
      GMTrace.o(13987903176704L, 104218);
    }
    
    public final void run()
    {
      GMTrace.i(13988171612160L, 104220);
      super.run();
      GMTrace.o(13988171612160L, 104220);
    }
    
    public final void start()
    {
      GMTrace.i(13988037394432L, 104219);
      super.start();
      GMTrace.o(13988037394432L, 104219);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */