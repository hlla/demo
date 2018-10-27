package android.support.f;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class bd
  extends bg
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  
  public final float a(View paramView)
  {
    if (!b) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      a = localMethod;
      localMethod.setAccessible(true);
      b = true;
      if (a == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        float f = ((Float)a.invoke(paramView, new Object[0])).floatValue();
        return f;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return super.a(paramView);
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", localNoSuchMethodException);
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
    }
  }
  
  public final void a(View paramView, float paramFloat)
  {
    if (!d) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      c = localMethod;
      localMethod.setAccessible(true);
      d = true;
      if (c != null) {}
      try
      {
        c.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
      paramView.setAlpha(paramFloat);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", localNoSuchMethodException);
      }
    }
  }
  
  public final void b(View paramView) {}
  
  public final void c(View paramView) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */