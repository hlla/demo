package com.tencent.mm.app.plugin;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bf;

public final class c
{
  public static boolean oL()
  {
    GMTrace.i(13016569479168L, 96981);
    if (!d.Jr("translate"))
    {
      GMTrace.o(13016569479168L, 96981);
      return false;
    }
    String str = g.sV().getValue("TranslateMsgOff");
    if (bf.mA(str))
    {
      GMTrace.o(13016569479168L, 96981);
      return true;
    }
    if (bf.PX(str) != 0)
    {
      GMTrace.o(13016569479168L, 96981);
      return false;
    }
    GMTrace.o(13016569479168L, 96981);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/plugin/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */