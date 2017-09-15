package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class h
{
  public static boolean qf()
  {
    GMTrace.i(496471375872L, 3699);
    try
    {
      ap.yY();
      u.d((Long)c.vr().get(66817, null));
      if (u.az(0L) * 1000L > 1800000L)
      {
        GMTrace.o(496471375872L, 3699);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", localException, "", new Object[0]);
      }
      GMTrace.o(496471375872L, 3699);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */