package android.support.v4.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class r
  implements View.OnApplyWindowInsetsListener
{
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    boolean bool3 = false;
    paramView = (DrawerLayout)paramView;
    if (paramWindowInsets.getSystemWindowInsetTop() > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramView.g = paramWindowInsets;
      paramView.e = bool1;
      boolean bool2 = bool3;
      if (!bool1)
      {
        bool2 = bool3;
        if (paramView.getBackground() == null) {
          bool2 = true;
        }
      }
      paramView.setWillNotDraw(bool2);
      paramView.requestLayout();
      return paramWindowInsets.consumeSystemWindowInsets();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */