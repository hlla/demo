package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class aq
  extends ak
  implements SubMenu
{
  aq(Context paramContext, c paramc)
  {
    super(paramContext, paramc);
  }
  
  public final void clearHeader()
  {
    ((c)this.d).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return a(((c)this.d).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((c)this.d).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((c)this.d).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((c)this.d).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((c)this.d).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((c)this.d).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((c)this.d).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((c)this.d).setIcon(paramDrawable);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */