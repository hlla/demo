package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.e.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class c<T>
  extends d<T>
{
  Map<b, MenuItem> PW;
  Map<android.support.v4.c.a.c, SubMenu> PX;
  final Context mContext;
  
  c(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof android.support.v4.c.a.c))
    {
      android.support.v4.c.a.c localc = (android.support.v4.c.a.c)paramSubMenu;
      if (this.PX == null) {
        this.PX = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.PX.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = this.mContext;
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramSubMenu = new q(paramSubMenu, localc);
          this.PX.put(localc, paramSubMenu);
        }
      }
      else
      {
        return paramSubMenu;
      }
      throw new UnsupportedOperationException();
    }
    return paramSubMenu;
  }
  
  final MenuItem f(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (this.PW == null) {
        this.PW = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.PW.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = n.a(this.mContext, localb);
        this.PW.put(localb, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */