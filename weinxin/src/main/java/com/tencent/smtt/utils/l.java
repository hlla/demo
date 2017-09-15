package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class l
{
  private static Class wVY;
  private static Method wVZ;
  
  static
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      wVY = localClass;
      wVZ = localClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String fj(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return fk(paramString1, paramString2);
  }
  
  private static String fk(String paramString1, String paramString2)
  {
    if ((wVY == null) || (wVZ == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)wVZ.invoke(wVY, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return paramString2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/utils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */