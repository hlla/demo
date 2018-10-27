package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class id
{
  private static Method a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      a = localMethod;
      if (!localMethod.isAccessible()) {
        a.setAccessible(true);
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
    }
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    if (a != null) {}
    try
    {
      a.invoke(paramView, new Object[] { paramRect1, paramRect2 });
      return;
    }
    catch (Exception paramView)
    {
      Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", paramView);
    }
  }
  
  public static boolean a(View paramView)
  {
    boolean bool = true;
    if (ac.h(paramView) != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static void b(View paramView)
  {
    try
    {
      Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      if (localMethod.isAccessible()) {}
      for (;;)
      {
        localMethod.invoke(paramView, new Object[0]);
        return;
        localMethod.setAccessible(true);
      }
      return;
    }
    catch (NoSuchMethodException paramView)
    {
      Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
      return;
    }
    catch (InvocationTargetException paramView)
    {
      Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      return;
    }
    catch (IllegalAccessException paramView)
    {
      Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */