package com.tencent.mm.bn;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.h.a;

public final class c
  implements a
{
  private ad mHandler;
  
  private c(ad paramad)
  {
    GMTrace.i(13617059594240L, 101455);
    this.mHandler = paramad;
    GMTrace.o(13617059594240L, 101455);
  }
  
  public static c c(ad paramad)
  {
    GMTrace.i(13617193811968L, 101456);
    paramad = new c(paramad);
    GMTrace.o(13617193811968L, 101456);
    return paramad;
  }
  
  public final void cl()
  {
    GMTrace.i(13617730682880L, 101460);
    this.mHandler.removeCallbacksAndMessages(null);
    GMTrace.o(13617730682880L, 101460);
  }
  
  public final void f(Runnable paramRunnable)
  {
    GMTrace.i(13617328029696L, 101457);
    this.mHandler.post(paramRunnable);
    GMTrace.o(13617328029696L, 101457);
  }
  
  public final void g(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(13617462247424L, 101458);
    this.mHandler.postDelayed(paramRunnable, paramLong);
    GMTrace.o(13617462247424L, 101458);
  }
  
  public final Looper getLooper()
  {
    GMTrace.i(13617596465152L, 101459);
    Looper localLooper = this.mHandler.getLooper();
    GMTrace.o(13617596465152L, 101459);
    return localLooper;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bn/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */