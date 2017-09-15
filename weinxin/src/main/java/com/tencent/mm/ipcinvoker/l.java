package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ExecutorService;

class l
{
  private static l gVP;
  private ad gVQ;
  private m gVR;
  private ad mHandler;
  private HandlerThread mHandlerThread;
  
  private l()
  {
    GMTrace.i(18711427678208L, 139411);
    this.mHandlerThread = e.Qt("IPCThreadCaller#Worker-" + hashCode());
    this.mHandlerThread.start();
    this.mHandler = new ad(this.mHandlerThread.getLooper());
    this.gVQ = new ad(Looper.getMainLooper());
    this.gVR = m.ut();
    GMTrace.o(18711427678208L, 139411);
  }
  
  public static boolean d(Runnable paramRunnable)
  {
    GMTrace.i(18711561895936L, 139412);
    ur().gVR.gVT.execute(paramRunnable);
    GMTrace.o(18711561895936L, 139412);
    return true;
  }
  
  private static l ur()
  {
    GMTrace.i(18711293460480L, 139410);
    if (gVP == null) {}
    try
    {
      if (gVP == null) {
        gVP = new l();
      }
      l locall = gVP;
      GMTrace.o(18711293460480L, 139410);
      return locall;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */