package com.tencent.mm.ipcinvoker.e;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b
{
  public static <T> T b(Class<?> paramClass1, Class<?> paramClass2)
  {
    GMTrace.i(18698005905408L, 139311);
    if (paramClass1 == null)
    {
      v.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
      GMTrace.o(18698005905408L, 139311);
      return null;
    }
    if (paramClass2 == null)
    {
      v.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
      GMTrace.o(18698005905408L, 139311);
      return null;
    }
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        v.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        GMTrace.o(18698005905408L, 139311);
        return null;
      }
      paramClass1 = paramClass1.getDeclaredConstructor(new Class[0]);
      paramClass1.setAccessible(true);
      paramClass1 = paramClass1.newInstance(new Object[0]);
      GMTrace.o(18698005905408L, 139311);
      return paramClass1;
    }
    catch (IllegalAccessException paramClass1)
    {
      v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      GMTrace.o(18698005905408L, 139311);
      return null;
    }
    catch (InstantiationException paramClass1)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
    catch (InvocationTargetException paramClass1)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      }
    }
  }
  
  public static <T> T c(String paramString, Class<?> paramClass)
  {
    GMTrace.i(18697871687680L, 139310);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
      GMTrace.o(18697871687680L, 139310);
      return null;
    }
    if (paramClass == null)
    {
      v.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
      GMTrace.o(18697871687680L, 139310);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(paramString))
      {
        v.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass, paramString });
        GMTrace.o(18697871687680L, 139310);
        return null;
      }
      paramString = paramString.getDeclaredConstructor(new Class[0]);
      paramString.setAccessible(true);
      paramString = paramString.newInstance(new Object[0]);
      GMTrace.o(18697871687680L, 139310);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      GMTrace.o(18697871687680L, 139310);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
      }
    }
  }
  
  public static <T> T e(Class<?> paramClass)
  {
    GMTrace.i(18698140123136L, 139312);
    if (paramClass == null)
    {
      v.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
      GMTrace.o(18698140123136L, 139312);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      paramClass = paramClass.newInstance(new Object[0]);
      GMTrace.o(18698140123136L, 139312);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      GMTrace.o(18698140123136L, 139312);
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
    catch (InvocationTargetException paramClass)
    {
      for (;;)
      {
        v.e("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */