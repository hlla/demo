package com.tencent.mm.b;

import com.tencent.gmtrace.GMTrace;

public final class j
{
  public static int bd(String paramString)
  {
    GMTrace.i(14019578560512L, 104454);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        GMTrace.o(14019578560512L, 104454);
        return 0;
      }
      int i = Integer.parseInt(paramString);
      GMTrace.o(14019578560512L, 104454);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      GMTrace.o(14019578560512L, 104454);
    }
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */