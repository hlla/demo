package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;

public final class b
{
  private static b wBE;
  private Handler mHandler;
  public HandlerThread wBD;
  
  static
  {
    GMTrace.i(297292267520L, 2215);
    wBE = new b();
    GMTrace.o(297292267520L, 2215);
  }
  
  private b()
  {
    GMTrace.i(297023832064L, 2213);
    this.wBD = new HandlerThread("Vending-LogicThread");
    this.wBD.start();
    this.mHandler = new Handler(this.wBD.getLooper());
    GMTrace.o(297023832064L, 2213);
  }
  
  public static b cbE()
  {
    GMTrace.i(297158049792L, 2214);
    b localb = wBE;
    GMTrace.o(297158049792L, 2214);
    return localb;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */