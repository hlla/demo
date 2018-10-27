package android.support.design.internal;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.Log;
import java.lang.reflect.Method;

public final class g
{
  private static Method a;
  private static boolean b;
  
  public static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!b) {}
    try
    {
      Method localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      a = localMethod;
      localMethod.setAccessible(true);
      b = true;
      if (a != null) {
        try
        {
          a.invoke(paramDrawableContainer, new Object[] { paramConstantState });
          return true;
        }
        catch (Exception paramDrawableContainer)
        {
          Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
        }
      }
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */