package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static a gZy;
  public HandlerThread gZx;
  private Handler mHandler;
  
  static
  {
    GMTrace.i(449897824256L, 3352);
    gZy = new a();
    GMTrace.o(449897824256L, 3352);
  }
  
  private a()
  {
    GMTrace.i(449629388800L, 3350);
    this.gZx = new HandlerThread("InflateThread", 5);
    this.gZx.start();
    this.mHandler = new Handler(this.gZx.getLooper());
    GMTrace.o(449629388800L, 3350);
  }
  
  public static a vR()
  {
    GMTrace.i(449763606528L, 3351);
    a locala = gZy;
    GMTrace.o(449763606528L, 3351);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */