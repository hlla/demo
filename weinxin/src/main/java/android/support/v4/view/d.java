package android.support.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class d
{
  private final Context mContext;
  public a ww;
  public b wx;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(b paramb)
  {
    if (this.wx != null) {
      new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
    }
    this.wx = paramb;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public abstract View onCreateActionView();
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public boolean overridesItemVisibility()
  {
    return false;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.ww != null) {
      this.ww.q(paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void q(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void bJ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */