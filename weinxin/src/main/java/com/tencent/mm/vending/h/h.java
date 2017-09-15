package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;

public final class h
  extends d
{
  Looper aLd;
  private String mType;
  public a wBB;
  
  private h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
    GMTrace.i(295681654784L, 2203);
    GMTrace.o(295681654784L, 2203);
  }
  
  private h(Looper paramLooper, a parama, String paramString)
  {
    GMTrace.i(295547437056L, 2202);
    this.aLd = paramLooper;
    this.wBB = parama;
    this.mType = paramString;
    GMTrace.o(295547437056L, 2202);
  }
  
  public h(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
    GMTrace.i(295950090240L, 2205);
    GMTrace.o(295950090240L, 2205);
  }
  
  public h(a parama, String paramString)
  {
    this(parama.getLooper(), parama, paramString);
    GMTrace.i(295815872512L, 2204);
    GMTrace.o(295815872512L, 2204);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    GMTrace.i(296352743424L, 2208);
    this.wBB.f(paramRunnable);
    GMTrace.o(296352743424L, 2208);
  }
  
  public final void cancel()
  {
    GMTrace.i(296218525696L, 2207);
    this.wBB.cl();
    GMTrace.o(296218525696L, 2207);
  }
  
  public final String getType()
  {
    GMTrace.i(296084307968L, 2206);
    String str = this.mType;
    GMTrace.o(296084307968L, 2206);
    return str;
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(296486961152L, 2209);
    if (paramLong >= 0L)
    {
      this.wBB.g(paramRunnable, paramLong);
      GMTrace.o(296486961152L, 2209);
      return;
    }
    this.wBB.f(paramRunnable);
    GMTrace.o(296486961152L, 2209);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/h/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */