package com.android.common;

import android.content.SharedPreferences.Editor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SharedPreferencesCompat
{
  private static Method sApplyMethod;
  
  static
  {
    try
    {
      sApplyMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      sApplyMethod = null;
    }
  }
  
  public static void apply(SharedPreferences.Editor paramEditor)
  {
    if (sApplyMethod != null) {}
    try
    {
      sApplyMethod.invoke(paramEditor, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramEditor.commit();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */