package com.tencent.mm.performance.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    GMTrace.i(13140855095296L, 97907);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      GMTrace.o(13140855095296L, 97907);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      v.printErrStackTrace("MicroMsg.ReflectHelper", paramClass, "", new Object[0]);
      GMTrace.o(13140855095296L, 97907);
    }
    return null;
  }
  
  private static Object a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    GMTrace.i(13140989313024L, 97908);
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, null);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, null);
      GMTrace.o(13140989313024L, 97908);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      v.printErrStackTrace("MicroMsg.ReflectHelper", paramClass, "", new Object[0]);
      GMTrace.o(13140989313024L, 97908);
    }
    return null;
  }
  
  public static Object ao(String paramString1, String paramString2)
  {
    GMTrace.i(13141123530752L, 97909);
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, null, null, null);
      GMTrace.o(13141123530752L, 97909);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      v.printErrStackTrace("MicroMsg.ReflectHelper", paramString1, "", new Object[0]);
      GMTrace.o(13141123530752L, 97909);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */