package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class ap
  extends p
  implements SubMenu
{
  public p l;
  private t m;
  
  public ap(Context paramContext, p paramp, t paramt)
  {
    super(paramContext);
    this.l = paramp;
    this.m = paramt;
  }
  
  public final String a()
  {
    Object localObject = this.m;
    if (localObject != null) {}
    for (int i = ((t)localObject).getItemId();; i = 0)
    {
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(super.a());
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(i);
        return ((StringBuilder)localObject).toString();
      }
      return null;
    }
  }
  
  public final void a(q paramq)
  {
    this.l.a(paramq);
  }
  
  final boolean a(p paramp, MenuItem paramMenuItem)
  {
    return (super.a(paramp, paramMenuItem)) || (this.l.a(paramp, paramMenuItem));
  }
  
  public final boolean a(t paramt)
  {
    return this.l.a(paramt);
  }
  
  public final boolean b()
  {
    return this.l.b();
  }
  
  public final boolean b(t paramt)
  {
    return this.l.b(paramt);
  }
  
  public final boolean c()
  {
    return this.l.c();
  }
  
  public final boolean d()
  {
    return this.l.d();
  }
  
  public final MenuItem getItem()
  {
    return this.m;
  }
  
  public final p l()
  {
    return this.l.l();
  }
  
  public final void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.l.setGroupDividerEnabled(paramBoolean);
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    super.a(0, null, paramInt, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(0, null, 0, paramDrawable, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    super.a(paramInt, null, 0, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(0, paramCharSequence, 0, null, null);
    return (SubMenu)this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    super.a(0, null, 0, null, paramView);
    return (SubMenu)this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    this.m.setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    this.m.setIcon(paramDrawable);
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean)
  {
    this.l.setQwertyMode(paramBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */