package android.support.v7.view.menu;

import android.support.v4.view.d;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class w
  extends d
{
  public final ActionProvider b;
  
  public w(v paramv, ActionProvider paramActionProvider)
  {
    this.b = paramActionProvider;
  }
  
  public final View a()
  {
    return this.b.onCreateActionView();
  }
  
  public final void a(SubMenu paramSubMenu)
  {
    this.b.onPrepareSubMenu(this.c.a(paramSubMenu));
  }
  
  public final boolean d()
  {
    return this.b.onPerformDefaultAction();
  }
  
  public final boolean e()
  {
    return this.b.hasSubMenu();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */