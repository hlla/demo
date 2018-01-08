package com.android.launcher2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Reflection
{
  public static Class<?> getClass(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Constructor<?> getConstructor(String paramString, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    try
    {
      paramString = Class.forName(paramString).getDeclaredConstructor(paramArrayOfClass);
      paramString.setAccessible(paramBoolean);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static Field getField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(paramBoolean);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Field getField(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramString1 = getField(Class.forName(paramString1), paramString2, paramBoolean);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static Object getFieldValue(Object paramObject, Field paramField)
  {
    try
    {
      paramObject = paramField.get(paramObject);
      return paramObject;
    }
    catch (IllegalArgumentException paramObject)
    {
      ((IllegalArgumentException)paramObject).printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);
      paramClass.setAccessible(paramBoolean);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(paramBoolean);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Method getMethod(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, new Class[0]);
      paramString1.setAccessible(paramBoolean);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static Method getMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(paramBoolean);
      return paramString1;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static Object invoke(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalArgumentException paramObject)
    {
      ((IllegalArgumentException)paramObject).printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;)
      {
        ((InvocationTargetException)paramObject).printStackTrace();
      }
    }
  }
  
  public static Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    paramString = getConstructor(paramString, paramArrayOfClass, paramBoolean);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.newInstance(paramArrayOfObject);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean setFieldValue(Object paramObject1, Field paramField, Object paramObject2)
  {
    try
    {
      paramField.set(paramObject1, paramObject2);
      return true;
    }
    catch (IllegalArgumentException paramObject1)
    {
      ((IllegalArgumentException)paramObject1).printStackTrace();
      return false;
    }
    catch (IllegalAccessException paramObject1)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject1).printStackTrace();
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */