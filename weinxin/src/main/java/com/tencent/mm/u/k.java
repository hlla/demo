package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class k
{
  public static String f(String paramString, long paramLong)
  {
    GMTrace.i(13263664316416L, 98822);
    String str = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(paramLong));
    if ((paramString != null) && (paramString.length() > 1)) {}
    for (paramString = str + g.n(paramString.getBytes()).substring(0, 7);; paramString = str + "fffffff")
    {
      paramString = paramString + String.format("%04x", new Object[] { Long.valueOf(paramLong % 65535L) });
      paramString = paramString + (paramLong % 7L + 100L);
      GMTrace.o(13263664316416L, 98822);
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */