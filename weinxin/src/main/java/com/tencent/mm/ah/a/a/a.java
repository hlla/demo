package com.tencent.mm.ah.a.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.c.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  public static h aN(int paramInt1, int paramInt2)
  {
    GMTrace.i(13728191873024L, 102283);
    Object localObject = new com.tencent.mm.ah.a.e.a();
    localObject = new b(paramInt1, paramInt1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a(paramInt2, "image_loader_"));
    GMTrace.o(13728191873024L, 102283);
    return (h)localObject;
  }
  
  private static final class a
    implements ThreadFactory
  {
    private static final AtomicInteger hHU;
    private final ThreadGroup hHV;
    private final AtomicInteger hHW;
    private final String hHX;
    private final int hHY;
    
    static
    {
      GMTrace.i(13727520784384L, 102278);
      hHU = new AtomicInteger(1);
      GMTrace.o(13727520784384L, 102278);
    }
    
    a(int paramInt, String paramString)
    {
      GMTrace.i(13727252348928L, 102276);
      this.hHW = new AtomicInteger(1);
      this.hHY = paramInt;
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.hHV = ((ThreadGroup)localObject);
        this.hHX = (paramString + hHU.getAndIncrement() + "-thread-");
        GMTrace.o(13727252348928L, 102276);
        return;
      }
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      GMTrace.i(13727386566656L, 102277);
      paramRunnable = new Thread(this.hHV, paramRunnable, this.hHX + this.hHW.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      paramRunnable.setPriority(this.hHY);
      GMTrace.o(13727386566656L, 102277);
      return paramRunnable;
    }
  }
  
  private static final class b
    extends ThreadPoolExecutor
    implements h
  {
    private ReentrantLock hHZ;
    private Condition hIa;
    private BlockingQueue<Runnable> hIb;
    private boolean isPaused;
    
    public b(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
    {
      super(paramInt2, 0L, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
      GMTrace.i(13726312824832L, 102269);
      this.hHZ = new ReentrantLock();
      this.hIa = this.hHZ.newCondition();
      this.hIb = paramBlockingQueue;
      GMTrace.o(13726312824832L, 102269);
    }
    
    /* Error */
    protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      // Byte code:
      //   0: ldc2_w 58
      //   3: ldc 60
      //   5: invokestatic 32	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: aload_0
      //   9: aload_1
      //   10: aload_2
      //   11: invokespecial 62	java/util/concurrent/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
      //   14: aload_0
      //   15: getfield 39	com/tencent/mm/ah/a/a/a$b:hHZ	Ljava/util/concurrent/locks/ReentrantLock;
      //   18: invokevirtual 65	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   21: aload_0
      //   22: getfield 67	com/tencent/mm/ah/a/a/a$b:isPaused	Z
      //   25: ifeq +54 -> 79
      //   28: aload_0
      //   29: getfield 45	com/tencent/mm/ah/a/a/a$b:hIa	Ljava/util/concurrent/locks/Condition;
      //   32: invokeinterface 72 1 0
      //   37: goto -16 -> 21
      //   40: astore_2
      //   41: aload_1
      //   42: invokevirtual 77	java/lang/Thread:interrupt	()V
      //   45: ldc 79
      //   47: ldc 81
      //   49: iconst_1
      //   50: anewarray 83	java/lang/Object
      //   53: dup
      //   54: iconst_0
      //   55: aload_2
      //   56: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
      //   59: aastore
      //   60: invokestatic 93	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   63: aload_0
      //   64: getfield 39	com/tencent/mm/ah/a/a/a$b:hHZ	Ljava/util/concurrent/locks/ReentrantLock;
      //   67: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   70: ldc2_w 58
      //   73: ldc 60
      //   75: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   78: return
      //   79: aload_0
      //   80: getfield 39	com/tencent/mm/ah/a/a/a$b:hHZ	Ljava/util/concurrent/locks/ReentrantLock;
      //   83: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   86: ldc2_w 58
      //   89: ldc 60
      //   91: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   94: return
      //   95: astore_1
      //   96: aload_0
      //   97: getfield 39	com/tencent/mm/ah/a/a/a$b:hHZ	Ljava/util/concurrent/locks/ReentrantLock;
      //   100: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   103: aload_1
      //   104: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	this	b
      //   0	105	1	paramThread	Thread
      //   0	105	2	paramRunnable	Runnable
      // Exception table:
      //   from	to	target	type
      //   21	37	40	java/lang/Exception
      //   21	37	95	finally
      //   41	63	95	finally
    }
    
    public final void execute(Runnable paramRunnable)
    {
      GMTrace.i(13726849695744L, 102273);
      super.execute(paramRunnable);
      GMTrace.o(13726849695744L, 102273);
    }
    
    public final boolean oV()
    {
      GMTrace.i(13726983913472L, 102274);
      boolean bool = this.isPaused;
      GMTrace.o(13726983913472L, 102274);
      return bool;
    }
    
    public final void pause()
    {
      GMTrace.i(13726581260288L, 102271);
      this.hHZ.lock();
      try
      {
        this.isPaused = true;
        this.hHZ.unlock();
        GMTrace.o(13726581260288L, 102271);
        return;
      }
      finally
      {
        this.hHZ.unlock();
      }
    }
    
    public final void remove(Object paramObject)
    {
      GMTrace.i(13727118131200L, 102275);
      if (this.hIb != null) {
        this.hIb.remove(paramObject);
      }
      GMTrace.o(13727118131200L, 102275);
    }
    
    public final void resume()
    {
      GMTrace.i(13726715478016L, 102272);
      this.hHZ.lock();
      try
      {
        this.isPaused = false;
        this.hIa.signalAll();
        this.hHZ.unlock();
        GMTrace.o(13726715478016L, 102272);
        return;
      }
      finally
      {
        this.hHZ.unlock();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */