package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class b
{
  static Method tM;
  static boolean tN;
  private static Method tO;
  private static boolean tP;
  
  public static int i(Drawable paramDrawable)
  {
    if (!tP) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      tO = localMethod;
      localMethod.setAccessible(true);
      tP = true;
      if (tO != null) {
        try
        {
          int i = ((Integer)tO.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          tO = null;
        }
      }
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */