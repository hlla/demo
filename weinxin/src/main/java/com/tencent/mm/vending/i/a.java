package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static a wBC;
  public HandlerThread ixk;
  private Handler mHandler;
  
  static
  {
    GMTrace.i(296889614336L, 2212);
    wBC = new a();
    GMTrace.o(296889614336L, 2212);
  }
  
  private a()
  {
    GMTrace.i(296621178880L, 2210);
    this.ixk = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.ixk.start();
    this.mHandler = new Handler(this.ixk.getLooper());
    GMTrace.o(296621178880L, 2210);
  }
  
  public static a cbD()
  {
    GMTrace.i(296755396608L, 2211);
    a locala = wBC;
    GMTrace.o(296755396608L, 2211);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */