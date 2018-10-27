package android.support.v4.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ak
{
  private static Field a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    for (;;)
    {
      return;
      if (!d) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        c = localMethod;
        localMethod.setAccessible(true);
        d = true;
        if (c == null) {
          continue;
        }
        try
        {
          c.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 21) {
        continue;
      }
      if (!b) {}
      try
      {
        Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        a = localField;
        localField.setAccessible(true);
        b = true;
        if (a == null) {
          continue;
        }
        try
        {
          a.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
          return;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */