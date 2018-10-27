package android.support.design.widget;

import android.support.v4.g.p;
import android.support.v4.view.ac;
import android.support.v4.view.bf;
import android.support.v4.view.y;
import android.view.View;

final class f
  implements y
{
  f(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final bf a(View paramView, bf parambf)
  {
    boolean bool2 = true;
    int i = 0;
    paramView = this.a;
    boolean bool1;
    if (!p.a(paramView.c, parambf))
    {
      paramView.c = parambf;
      if (parambf == null) {
        break label156;
      }
      if (parambf.b() <= 0) {
        break label150;
      }
      bool1 = true;
    }
    for (;;)
    {
      paramView.b = bool1;
      if (!paramView.b) {
        if (paramView.getBackground() == null) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        paramView.setWillNotDraw(bool1);
        if (!parambf.e())
        {
          int j = paramView.getChildCount();
          if (i < j)
          {
            View localView = paramView.getChildAt(i);
            if ((!ac.y(localView)) || (((k)localView.getLayoutParams()).i == null)) {}
            while (!parambf.e())
            {
              i += 1;
              break;
            }
          }
        }
        paramView.requestLayout();
        return parambf;
        bool1 = false;
        continue;
        bool1 = false;
      }
      label150:
      bool1 = false;
      continue;
      label156:
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */