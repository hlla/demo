package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class d
{
  private static Field Bf;
  private static boolean Bg;
  
  static Drawable a(CompoundButton paramCompoundButton)
  {
    if (!Bg) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      Bf = localField;
      localField.setAccessible(true);
      Bg = true;
      if (Bf != null) {
        try
        {
          paramCompoundButton = (Drawable)Bf.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Bf = null;
        }
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */