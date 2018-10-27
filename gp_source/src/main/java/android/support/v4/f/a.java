package android.support.v4.f;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  private static Method a;
  private static Method b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
        return;
      }
      catch (Exception localException2)
      {
        Class localClass;
        throw new IllegalStateException(localException2);
      }
      try
      {
        localClass = Class.forName("libcore.icu.ICU");
        if (localClass == null) {
          continue;
        }
        b = localClass.getMethod("getScript", new Class[] { String.class });
        a = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
        return;
      }
      catch (Exception localException1)
      {
        b = null;
        a = null;
        Log.w("ICUCompat", localException1);
        return;
      }
    }
  }
  
  private static String a(String paramString)
  {
    try
    {
      if (b != null)
      {
        paramString = (String)b.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      Log.w("ICUCompat", paramString);
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        Log.w("ICUCompat", paramString);
      }
    }
  }
  
  public static String a(Locale paramLocale)
  {
    String str1 = null;
    if (Build.VERSION.SDK_INT >= 21) {}
    do
    {
      try
      {
        str1 = ((Locale)a.invoke(null, new Object[] { paramLocale })).getScript();
        paramLocale = str1;
        return paramLocale;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        String str2;
        Log.w("ICUCompat", localInvocationTargetException);
        return paramLocale.getScript();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.w("ICUCompat", localIllegalAccessException);
        }
      }
      str2 = b(paramLocale);
      paramLocale = str1;
    } while (str2 == null);
    return a(str2);
  }
  
  private static String b(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (a != null)
      {
        String str = (String)a.invoke(null, new Object[] { paramLocale });
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompat", localIllegalAccessException);
      return paramLocale;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.w("ICUCompat", localInvocationTargetException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */