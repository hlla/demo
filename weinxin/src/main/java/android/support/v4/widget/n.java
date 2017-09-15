package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class n
{
  private static Field Dp;
  
  static
  {
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      Dp = localField;
      localField.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Dp != null) {}
    try
    {
      Dp.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (IllegalAccessException paramPopupWindow) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */