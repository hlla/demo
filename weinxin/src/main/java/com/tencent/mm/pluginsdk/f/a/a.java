package com.tencent.mm.pluginsdk.f.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a
{
  private CountDownLatch sAi;
  
  public a()
  {
    GMTrace.i(838726582272L, 6249);
    this.sAi = null;
    GMTrace.o(838726582272L, 6249);
  }
  
  public final void b(long paramLong, Runnable paramRunnable)
  {
    GMTrace.i(838995017728L, 6251);
    v.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.sAi == null) {
      this.sAi = new CountDownLatch(1);
    }
    ae.v(paramRunnable);
    v.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.sAi != null) {
      try
      {
        this.sAi.await(paramLong, TimeUnit.MILLISECONDS);
        GMTrace.o(838995017728L, 6251);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        v.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        v.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    GMTrace.o(838995017728L, 6251);
  }
  
  public final void countDown()
  {
    GMTrace.i(838860800000L, 6250);
    if (this.sAi != null)
    {
      this.sAi.countDown();
      this.sAi = null;
    }
    GMTrace.o(838860800000L, 6250);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */