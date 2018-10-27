package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class o
{
  public static int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramMarginLayoutParams.getMarginStart();
    }
    return paramMarginLayoutParams.leftMargin;
  }
  
  public static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginStart(paramInt);
      return;
    }
    paramMarginLayoutParams.leftMargin = paramInt;
  }
  
  public static int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramMarginLayoutParams.getMarginEnd();
    }
    return paramMarginLayoutParams.rightMargin;
  }
  
  public static void b(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginEnd(paramInt);
      return;
    }
    paramMarginLayoutParams.rightMargin = paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */