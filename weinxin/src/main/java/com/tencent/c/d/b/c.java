package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c
{
  private static Object wQe = null;
  private static Method wQf = null;
  private static boolean wQg = false;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        wQe = e.fd("libcore.io.Libcore", "os");
        wQf = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        wQg = true;
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static int Vb(String paramString)
  {
    if (!wQg) {}
    do
    {
      return 0;
      paramString = wQf.invoke(wQe, new Object[] { paramString });
    } while (paramString == null);
    return ((Integer)e.b(paramString.getClass(), "st_mode", paramString)).intValue();
  }
  
  public static boolean isAvailable()
  {
    return wQg;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */