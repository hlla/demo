package com.tencent.mm.plugin.wear.a;

import com.tencent.gmtrace.GMTrace;

public final class b
{
  public static final boolean II(String paramString)
  {
    GMTrace.i(9217134034944L, 68673);
    try
    {
      boolean bool = paramString.split("/")[2].equals("wear");
      GMTrace.o(9217134034944L, 68673);
      return bool;
    }
    catch (Exception paramString)
    {
      GMTrace.o(9217134034944L, 68673);
    }
    return false;
  }
  
  public static final int IJ(String paramString)
  {
    GMTrace.i(18825646964736L, 140262);
    try
    {
      int i = Integer.valueOf(paramString.split("/")[4]).intValue();
      GMTrace.o(18825646964736L, 140262);
      return i;
    }
    catch (Exception paramString)
    {
      GMTrace.o(18825646964736L, 140262);
    }
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/wear/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */