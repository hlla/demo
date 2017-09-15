package com.tencent.mm.bk;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;

public class a
{
  private static a uLK;
  private ad gVQ;
  private ad mHandler;
  private HandlerThread mHandlerThread;
  
  private a()
  {
    GMTrace.i(17506957787136L, 130437);
    this.mHandlerThread = e.Qt("WorkerThread#" + hashCode());
    this.mHandlerThread.start();
    this.mHandler = new ad(this.mHandlerThread.getLooper());
    this.gVQ = new ad(Looper.getMainLooper());
    GMTrace.o(17506957787136L, 130437);
  }
  
  public static boolean W(Runnable paramRunnable)
  {
    GMTrace.i(18730486595584L, 139553);
    boolean bool = bNT().gVQ.post(paramRunnable);
    GMTrace.o(18730486595584L, 139553);
    return bool;
  }
  
  public static boolean X(Runnable paramRunnable)
  {
    GMTrace.i(18730620813312L, 139554);
    boolean bool = bNT().gVQ.postDelayed(paramRunnable, 1000L);
    GMTrace.o(18730620813312L, 139554);
    return bool;
  }
  
  private static a bNT()
  {
    GMTrace.i(17506823569408L, 130436);
    if (uLK == null) {}
    try
    {
      if (uLK == null) {
        uLK = new a();
      }
      a locala = uLK;
      GMTrace.o(17506823569408L, 130436);
      return locala;
    }
    finally {}
  }
  
  public static boolean e(Runnable paramRunnable)
  {
    GMTrace.i(18730352377856L, 139552);
    boolean bool = bNT().mHandler.postDelayed(paramRunnable, 1000L);
    GMTrace.o(18730352377856L, 139552);
    return bool;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    GMTrace.i(17507092004864L, 130438);
    boolean bool = bNT().mHandler.post(paramRunnable);
    GMTrace.o(17507092004864L, 130438);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */