package com.tencent.mm.plugin.report.a;

import com.tencent.gmtrace.GMTrace;

public final class c
{
  public static boolean oRC;
  public static boolean oRD;
  public static boolean oRE;
  public static boolean oRF;
  
  static
  {
    GMTrace.i(13108374405120L, 97665);
    oRC = false;
    oRD = true;
    oRE = true;
    oRF = true;
    GMTrace.o(13108374405120L, 97665);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    GMTrace.i(13108240187392L, 97664);
    oRC = paramBoolean1;
    oRD = paramBoolean2;
    oRE = paramBoolean3;
    oRF = paramBoolean4;
    GMTrace.o(13108240187392L, 97664);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */