package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class aa
{
  private static Field yd;
  private static boolean ye;
  private static Field yf;
  private static boolean yg;
  
  static int T(View paramView)
  {
    if (!ye) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      yd = localField;
      localField.setAccessible(true);
      ye = true;
      if (yd != null) {
        try
        {
          int i = ((Integer)yd.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  static int U(View paramView)
  {
    if (!yg) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      yf = localField;
      localField.setAccessible(true);
      yg = true;
      if (yf != null) {
        try
        {
          int i = ((Integer)yf.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */