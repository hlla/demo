package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class z
  extends f
  implements MenuItem.OnMenuItemClickListener
{
  z(v paramv, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)this.d).onMenuItemClick(this.a.a(paramMenuItem));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */