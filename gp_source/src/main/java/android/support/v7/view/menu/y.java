package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class y
  extends f
  implements MenuItem.OnActionExpandListener
{
  y(v paramv, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionCollapse(this.a.a(paramMenuItem));
  }
  
  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionExpand(this.a.a(paramMenuItem));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */