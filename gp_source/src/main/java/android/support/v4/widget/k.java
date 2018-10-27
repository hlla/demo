package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class k
{
  private static Field a;
  private static boolean b;
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!b) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      a = localField;
      localField.setAccessible(true);
      b = true;
      if (a != null) {
        try
        {
          paramCompoundButton = (Drawable)a.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", paramCompoundButton);
          a = null;
        }
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
    }
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    while (!(paramCompoundButton instanceof ax)) {
      return;
    }
    ((ax)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */