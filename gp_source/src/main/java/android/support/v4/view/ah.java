package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ah
{
  public static int a(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return 0;
    }
    return paramViewGroup.getLayoutMode();
  }
  
  public static void b(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramViewGroup.setTransitionGroup(true);
      return;
    }
    paramViewGroup.setTag(2131429436, Boolean.valueOf(true));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */