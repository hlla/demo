package android.support.design.appbar;

import android.support.v4.g.p;
import android.support.v4.view.ac;
import android.support.v4.view.bf;
import android.support.v4.view.y;
import android.view.View;

final class a
  implements y
{
  a(AppBarLayout paramAppBarLayout) {}
  
  public final bf a(View paramView, bf parambf)
  {
    AppBarLayout localAppBarLayout = this.a;
    if (!ac.y(localAppBarLayout)) {}
    for (paramView = null;; paramView = parambf)
    {
      if (!p.a(localAppBarLayout.b, paramView))
      {
        localAppBarLayout.b = paramView;
        localAppBarLayout.a();
      }
      return parambf;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */