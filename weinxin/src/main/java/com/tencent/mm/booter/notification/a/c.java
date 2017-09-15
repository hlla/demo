package com.tencent.mm.booter.notification.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.ba.a;
import com.tencent.mm.i.f;

public final class c
{
  public int gLK;
  
  public c()
  {
    GMTrace.i(529757372416L, 3947);
    this.gLK = -1;
    GMTrace.o(529757372416L, 3947);
  }
  
  public final int o(String paramString, int paramInt)
  {
    GMTrace.i(529891590144L, 3948);
    this.gLK = a.bCc();
    if ((!f.eu(paramInt)) || (f.dD(paramString))) {}
    try
    {
      this.gLK = R.g.blx;
      for (;;)
      {
        if (this.gLK < 0) {
          this.gLK = a.bCc();
        }
        paramInt = this.gLK;
        GMTrace.o(529891590144L, 3948);
        return paramInt;
        if (f.dE(paramString)) {
          try
          {
            this.gLK = R.g.blx;
          }
          catch (Exception paramString) {}
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */