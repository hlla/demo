package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h wBu;
  public static final h wBv;
  public static final h wBw;
  
  static
  {
    GMTrace.i(292997300224L, 2183);
    wBu = new h(Looper.getMainLooper(), "Vending.UI");
    wBv = new h(b.cbE().wBD.getLooper(), "Vending.LOGIC");
    wBw = new h(a.cbD().ixk.getLooper(), "Vending.HEAVY_WORK");
    g.cbC();
    GMTrace.o(292997300224L, 2183);
  }
  
  public d()
  {
    GMTrace.i(292191993856L, 2177);
    GMTrace.o(292191993856L, 2177);
  }
  
  public static d cbB()
  {
    try
    {
      GMTrace.i(292863082496L, 2182);
      d locald = g.cbB();
      GMTrace.o(292863082496L, 2182);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public abstract void ab(Runnable paramRunnable);
  
  public abstract void cancel();
  
  public abstract String getType();
  
  public abstract void h(Runnable paramRunnable, long paramLong);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */