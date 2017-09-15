package com.tencent.mm.sdk;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ax;

public class b<T>
  extends ax<T>
{
  private final Object mLock;
  
  public b()
  {
    super(20);
    GMTrace.i(13979581677568L, 104156);
    this.mLock = new Object();
    GMTrace.o(13979581677568L, 104156);
  }
  
  public final T bF()
  {
    GMTrace.i(13979715895296L, 104157);
    synchronized (this.mLock)
    {
      Object localObject2 = super.bF();
      GMTrace.o(13979715895296L, 104157);
      return (T)localObject2;
    }
  }
  
  public final boolean i(T paramT)
  {
    GMTrace.i(13979850113024L, 104158);
    synchronized (this.mLock)
    {
      boolean bool = super.i(paramT);
      GMTrace.o(13979850113024L, 104158);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */