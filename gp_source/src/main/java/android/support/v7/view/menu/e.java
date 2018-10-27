package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.c.a.c;
import android.support.v4.g.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

class e
  extends f
{
  public final Context a;
  public Map b;
  public Map c;
  
  e(Context paramContext, Object paramObject)
  {
    super(paramObject);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (this.b == null) {
        this.b = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = aj.a(this.a, localb);
        this.b.put(localb, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof c))
    {
      c localc = (c)paramSubMenu;
      if (this.c == null) {
        this.c = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new aq(this.a, localc);
        this.c.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */