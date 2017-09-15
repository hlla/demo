package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public abstract class o
  implements MenuItem.OnMenuItemClickListener
{
  private long pwA;
  
  public o()
  {
    GMTrace.i(2900579319808L, 21611);
    this.pwA = -1L;
    GMTrace.o(2900579319808L, 21611);
  }
  
  public abstract void bsL();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    GMTrace.i(2900713537536L, 21612);
    v.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.pwA != -1L)
    {
      long l = (System.nanoTime() - this.pwA) / 1000000L;
      if (l < 500L)
      {
        v.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        GMTrace.o(2900713537536L, 21612);
        return false;
      }
    }
    this.pwA = System.nanoTime();
    bsL();
    GMTrace.o(2900713537536L, 21612);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */