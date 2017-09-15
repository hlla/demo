package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.h;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class l
{
  public static void run()
  {
    GMTrace.i(497142464512L, 3704);
    int i = g.sV().getInt("EnableMMBitmapFactoryProb", 0);
    ap.yY();
    int j = h.aw(c.uH(), 100);
    if ((b.bIk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      MMBitmapFactory.setUseMMBitmapFactory(bool);
      v.i("MicroMsg.PostTaskUpdateMMImgDecSwitch", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      GMTrace.o(497142464512L, 3704);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */