package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class c
{
  private static Method vw;
  private static Method vx;
  
  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        vx = localClass.getMethod("getScript", new Class[] { String.class });
        vw = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
      }
      return;
    }
    catch (Exception localException)
    {
      vx = null;
      vw = null;
    }
  }
  
  public static String a(Locale paramLocale)
  {
    paramLocale = b(paramLocale);
    if (paramLocale != null) {
      return m(paramLocale);
    }
    return null;
  }
  
  private static String b(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (vw != null)
      {
        String str = (String)vw.invoke(null, new Object[] { paramLocale });
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      return paramLocale;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  private static String m(String paramString)
  {
    try
    {
      if (vx != null)
      {
        paramString = (String)vx.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (InvocationTargetException paramString)
    {
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */