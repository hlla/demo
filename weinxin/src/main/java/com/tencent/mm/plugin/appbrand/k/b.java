package com.tencent.mm.plugin.appbrand.k;

import com.tencent.gmtrace.GMTrace;

public final class b
{
  public static String aF(long paramLong)
  {
    GMTrace.i(18661096030208L, 139036);
    String str = "Token@" + paramLong;
    GMTrace.o(18661096030208L, 139036);
    return str;
  }
  
  public static String aM(Object paramObject)
  {
    GMTrace.i(17774185283584L, 132428);
    StringBuilder localStringBuilder = new StringBuilder("Token@");
    if (paramObject != null) {}
    for (paramObject = Integer.valueOf(paramObject.hashCode());; paramObject = "null")
    {
      paramObject = paramObject;
      GMTrace.o(17774185283584L, 132428);
      return (String)paramObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */