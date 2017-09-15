package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.au.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class n
{
  private static long gKk;
  
  static
  {
    GMTrace.i(501034778624L, 3733);
    gKk = 86400000L;
    GMTrace.o(501034778624L, 3733);
  }
  
  public static void run()
  {
    GMTrace.i(500900560896L, 3732);
    ap.yY();
    if (u.az(Long.valueOf(u.c((Long)c.vr().get(81944, null))).longValue()) * 1000L > gKk) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.JL();
        d.JM();
        if (!((d)localObject).hpu)
        {
          h.vJ();
          if (h.vI().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).hpu = true;
            h.vd().a(159, (com.tencent.mm.y.e)localObject);
            localObject = new com.tencent.mm.ap.k(9);
            h.vd().a((com.tencent.mm.y.k)localObject, 0);
          }
        }
      }
      GMTrace.o(500900560896L, 3732);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */