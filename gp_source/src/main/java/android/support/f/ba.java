package android.support.f;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class ba
{
  public static final bg a;
  public static final Property b;
  private static Field c;
  private static boolean d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      a = new bf();
    }
    for (;;)
    {
      b = new bb(Float.class, "translationAlpha");
      new bc(Rect.class, "clipBounds");
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        a = new be();
      } else if (Build.VERSION.SDK_INT >= 19) {
        a = new bd();
      } else {
        a = new bg();
      }
    }
  }
  
  static bn a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new bm(paramView);
    }
    return new bl(paramView.getWindowToken());
  }
  
  static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  static void a(View paramView, int paramInt)
  {
    if (!d) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      c = localField;
      localField.setAccessible(true);
      d = true;
      if (c == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          int i = c.getInt(paramView);
          c.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
          return;
        }
        catch (IllegalAccessException paramView) {}
        localNoSuchFieldException = localNoSuchFieldException;
        Log.i("ViewUtils", "fetchViewFlagsField: ");
      }
    }
  }
  
  static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */