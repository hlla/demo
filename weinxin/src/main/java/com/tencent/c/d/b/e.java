package com.tencent.c.d.b;

import android.text.TextUtils;
import com.tencent.c.e.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e
{
  private static Field a(Class<?> paramClass, String paramString)
  {
    if (paramClass == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramClass = paramClass.getDeclaredField(paramString);
        if (paramClass != null)
        {
          paramClass.setAccessible(true);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        g.i(paramClass);
      }
    }
    return null;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        if (paramClass != null)
        {
          paramClass.setAccessible(true);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        g.i(paramClass);
      }
    }
    return null;
  }
  
  public static Method a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      paramString1 = a(p(paramString1, null), paramString2, paramVarArgs);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      g.i(paramString1);
    }
    return null;
  }
  
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = a(paramClass, paramString);
      if (paramClass == null) {
        return null;
      }
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      g.i(paramClass);
    }
    return null;
  }
  
  public static Object fd(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b(p(paramString1, null), paramString2, null);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      g.i(paramString1);
    }
    return null;
  }
  
  private static Class<?> p(String paramString, Object paramObject)
  {
    try
    {
      paramString = Class.forName(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      try
      {
        g.i(paramString);
        paramString = null;
      }
      catch (Throwable paramString)
      {
        g.i(paramString);
      }
      return paramString;
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */