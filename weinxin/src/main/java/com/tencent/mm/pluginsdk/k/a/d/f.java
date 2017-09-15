package com.tencent.mm.pluginsdk.k.a.d;

import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class f<T extends b>
{
  public final Map<String, b> sEN;
  public final Map<String, Future<?>> sEO;
  
  public f()
  {
    GMTrace.i(876710199296L, 6532);
    this.sEN = new ConcurrentHashMap();
    this.sEO = new ConcurrentHashMap();
    GMTrace.o(876710199296L, 6532);
  }
  
  /* Error */
  public final boolean Mr(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 48
    //   5: sipush 6534
    //   8: invokestatic 34	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 41	com/tencent/mm/pluginsdk/k/a/d/f:sEO	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 55 2 0
    //   21: ifne +16 -> 37
    //   24: aload_0
    //   25: getfield 39	com/tencent/mm/pluginsdk/k/a/d/f:sEN	Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface 55 2 0
    //   34: ifeq +18 -> 52
    //   37: iconst_1
    //   38: istore_2
    //   39: ldc2_w 48
    //   42: sipush 6534
    //   45: invokestatic 44	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   48: aload_0
    //   49: monitorexit
    //   50: iload_2
    //   51: ireturn
    //   52: iconst_0
    //   53: istore_2
    //   54: ldc2_w 48
    //   57: sipush 6534
    //   60: invokestatic 44	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   63: goto -15 -> 48
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	f
    //   0	71	1	paramString	String
    //   38	16	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	37	66	finally
    //   39	48	66	finally
    //   54	63	66	finally
  }
  
  public abstract d a(T paramT);
  
  public final void b(T paramT)
  {
    GMTrace.i(876844417024L, 6533);
    this.sEN.put(paramT.bDh(), paramT);
    bDn().submit(a(paramT));
    GMTrace.o(876844417024L, 6533);
  }
  
  public abstract f<T>.a bDn();
  
  protected final class a
    extends ThreadPoolExecutor
  {
    public a(int paramInt, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, t paramt)
    {
      super(paramLong, ???, paramBlockingQueue, paramt, localThreadFactory);
      GMTrace.i(875636457472L, 6524);
      GMTrace.o(875636457472L, 6524);
    }
    
    protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      GMTrace.i(876173328384L, 6528);
      if ((paramRunnable instanceof f.c))
      {
        f.c localc = (f.c)paramRunnable;
        f.this.sEO.remove(localc.sEQ.bDh());
        f.this.sEN.remove(localc.sEQ.bDh());
      }
      for (;;)
      {
        super.afterExecute(paramRunnable, paramThrowable);
        GMTrace.o(876173328384L, 6528);
        return;
        v.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      GMTrace.i(876039110656L, 6527);
      f.c localc;
      if ((paramRunnable instanceof f.c))
      {
        localc = (f.c)paramRunnable;
        if (f.this.sEO.containsKey(localc.sEQ.bDh())) {
          localc.cancel(false);
        }
      }
      for (;;)
      {
        super.beforeExecute(paramThread, paramRunnable);
        GMTrace.o(876039110656L, 6527);
        return;
        f.this.sEO.put(localc.sEQ.bDh(), localc);
        f.this.sEN.remove(localc.sEQ.bDh());
        continue;
        v.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
    {
      GMTrace.i(875770675200L, 6525);
      if ((paramRunnable instanceof f.d))
      {
        paramRunnable = new f.c(paramRunnable, paramV, ((f.d)paramRunnable).sEQ);
        GMTrace.o(875770675200L, 6525);
        return paramRunnable;
      }
      paramRunnable = super.newTaskFor(paramRunnable, paramV);
      GMTrace.o(875770675200L, 6525);
      return paramRunnable;
    }
    
    protected final void terminated()
    {
      GMTrace.i(875904892928L, 6526);
      f.this.sEO.clear();
      super.terminated();
      GMTrace.o(875904892928L, 6526);
    }
  }
  
  public static abstract interface b
  {
    public abstract String bDh();
  }
  
  protected static final class c<V>
    extends FutureTask<V>
  {
    protected final f.b sEQ;
    
    public c(Runnable paramRunnable, V paramV, f.b paramb)
    {
      super(paramV);
      GMTrace.i(883555303424L, 6583);
      this.sEQ = paramb;
      GMTrace.o(883555303424L, 6583);
    }
  }
  
  protected static abstract class d<Req extends f.b>
    implements Runnable
  {
    public final Req sEQ;
    
    public d(Req paramReq)
    {
      GMTrace.i(876307546112L, 6529);
      this.sEQ = paramReq;
      GMTrace.o(876307546112L, 6529);
    }
    
    public Req Qv()
    {
      GMTrace.i(15305518612480L, 114035);
      f.b localb = this.sEQ;
      GMTrace.o(15305518612480L, 114035);
      return localb;
    }
    
    public void run()
    {
      GMTrace.i(876441763840L, 6530);
      if (Process.getThreadPriority(Process.myTid()) != 10) {
        Process.setThreadPriority(10);
      }
      GMTrace.o(876441763840L, 6530);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */