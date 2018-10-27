package android.support.design.widget;

import android.support.design.behavior.SwipeDismissBehavior;
import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.snackbar.s;
import android.view.View;
import android.view.ViewGroup;

@Deprecated
public class b
  extends BaseTransientBottomBar
{
  public b(ViewGroup paramViewGroup, View paramView, s params)
  {
    super(paramViewGroup, paramView, params);
  }
  
  protected final int a()
  {
    if (b()) {
      return 2131624611;
    }
    return 2131624138;
  }
  
  protected final SwipeDismissBehavior f()
  {
    return new d(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */