package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class n
{
  public static MenuItem a(MenuItem paramMenuItem, b paramb)
  {
    return paramMenuItem.setOnActionExpandListener(new a(paramb));
  }
  
  static final class a
    implements MenuItem.OnActionExpandListener
  {
    private n.b xh;
    
    public a(n.b paramb)
    {
      this.xh = paramb;
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return this.xh.onMenuItemActionCollapse(paramMenuItem);
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return this.xh.onMenuItemActionExpand(paramMenuItem);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */