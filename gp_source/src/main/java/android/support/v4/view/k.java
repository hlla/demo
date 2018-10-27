package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class k
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return 0xFF7FFFFF & paramInt1;
    }
    return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
      return;
    }
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */