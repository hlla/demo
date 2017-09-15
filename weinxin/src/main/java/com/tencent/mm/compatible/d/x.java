package com.tencent.mm.compatible.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;

public final class x
{
  private static Class<?> gRD;
  private static Method gRE;
  private static Method gRF;
  
  static
  {
    GMTrace.i(13795971825664L, 102788);
    gRD = null;
    gRE = null;
    gRF = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      gRD = localClass;
      gRE = localClass.getDeclaredMethod("get", new Class[] { String.class });
      gRF = gRD.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      gRE.setAccessible(true);
      gRF.setAccessible(true);
      GMTrace.o(13795971825664L, 102788);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      GMTrace.o(13795971825664L, 102788);
    }
  }
  
  public static String get(String paramString)
  {
    GMTrace.i(13795837607936L, 102787);
    try
    {
      paramString = (String)gRE.invoke(null, new Object[] { paramString });
      GMTrace.o(13795837607936L, 102787);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      GMTrace.o(13795837607936L, 102787);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */