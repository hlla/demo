package android.support.f;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class be
  extends bd
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!b) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      a = localMethod;
      localMethod.setAccessible(true);
      b = true;
      if (a == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          a.invoke(paramView, new Object[] { paramMatrix });
          return;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", localNoSuchMethodException);
      }
    }
  }
  
  public final void b(View paramView, Matrix paramMatrix)
  {
    if (!d) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      c = localMethod;
      localMethod.setAccessible(true);
      d = true;
      if (c == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          c.invoke(paramView, new Object[] { paramMatrix });
          return;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", localNoSuchMethodException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */