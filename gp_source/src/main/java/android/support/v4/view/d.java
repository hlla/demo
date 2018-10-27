package android.support.v4.view;

import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class d
{
  public e a;
  
  public abstract View a();
  
  public View a(MenuItem paramMenuItem)
  {
    return a();
  }
  
  public void a(e parame)
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
      Log.w("ActionProvider(support)", localStringBuilder.toString());
    }
    this.a = parame;
  }
  
  public void a(SubMenu paramSubMenu) {}
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */