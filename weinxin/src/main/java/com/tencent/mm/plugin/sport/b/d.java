package com.tencent.mm.plugin.sport.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  public static final void mJ(int paramInt)
  {
    GMTrace.i(16743930003456L, 124752);
    v.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[] { Integer.valueOf(paramInt) });
    c.oRz.i(13168, new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(16743930003456L, 124752);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sport/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */