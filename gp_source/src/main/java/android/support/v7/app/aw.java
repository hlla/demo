package android.support.v7.app;

import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

final class aw
{
  public static Field a;
  public static boolean b;
  public static Field c;
  public static boolean d;
  private static Class e;
  private static boolean f;
  private static Field g;
  private static boolean h;
  
  static void a(Object paramObject)
  {
    if (!f) {}
    try
    {
      e = Class.forName("android.content.res.ThemedResourceCache");
      f = true;
      if (e != null) {
        if (h) {}
      }
    }
    catch (ClassNotFoundException localNoSuchFieldException)
    {
      try
      {
        Field localField = e.getDeclaredField("mUnthemedEntries");
        g = localField;
        localField.setAccessible(true);
        h = true;
        if (g == null) {}
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        try
        {
          for (;;)
          {
            paramObject = (LongSparseArray)g.get(paramObject);
            if (paramObject != null) {
              ((LongSparseArray)paramObject).clear();
            }
            return;
            localClassNotFoundException = localClassNotFoundException;
            Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
          }
          localNoSuchFieldException = localNoSuchFieldException;
          Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
        }
        catch (IllegalAccessException paramObject)
        {
          for (;;)
          {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)paramObject);
            paramObject = null;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */