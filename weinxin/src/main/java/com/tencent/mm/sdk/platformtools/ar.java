package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ar
{
  private static final ConcurrentLinkedQueue<Runnable> utl;
  private static ExecutorService utm;
  
  static
  {
    GMTrace.i(13745237524480L, 102410);
    utl = new ConcurrentLinkedQueue();
    utm = null;
    GMTrace.o(13745237524480L, 102410);
  }
  
  ar()
  {
    GMTrace.i(13744700653568L, 102406);
    GMTrace.o(13744700653568L, 102406);
  }
  
  public static void K(Runnable paramRunnable)
  {
    GMTrace.i(13744969089024L, 102408);
    utl.add(paramRunnable);
    GMTrace.o(13744969089024L, 102408);
  }
  
  public static void L(Runnable paramRunnable)
  {
    GMTrace.i(13745103306752L, 102409);
    utl.remove(paramRunnable);
    GMTrace.o(13745103306752L, 102409);
  }
  
  public static ExecutorService bJo()
  {
    GMTrace.i(13744834871296L, 102407);
    try
    {
      if (utm == null) {
        utm = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = utm;
      GMTrace.o(13744834871296L, 102407);
      return localExecutorService;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */