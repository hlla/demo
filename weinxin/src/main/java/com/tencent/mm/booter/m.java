package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.h;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class m
{
  public static void run()
  {
    GMTrace.i(492981714944L, 3673);
    int i = g.sV().getInt("EnableFlockMultiProcSPProb", 0);
    ap.yY();
    int j = h.aw(c.uH(), 101);
    if ((b.bIk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      ak.a.setValue(ak.a.usn, bool);
      v.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      GMTrace.o(492981714944L, 3673);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */