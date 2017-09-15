package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p
  extends f
  implements SubMenu
{
  public f Ru;
  private h Rv;
  
  public p(Context paramContext, f paramf, h paramh)
  {
    super(paramContext);
    this.Ru = paramf;
    this.Rv = paramh;
  }
  
  public final void a(f.a parama)
  {
    this.Ru.a(parama);
  }
  
  final boolean b(f paramf, MenuItem paramMenuItem)
  {
    return (super.b(paramf, paramMenuItem)) || (this.Ru.b(paramf, paramMenuItem));
  }
  
  public final f dC()
  {
    return this.Ru;
  }
  
  public final String ds()
  {
    if (this.Rv != null) {}
    for (int i = this.Rv.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.ds() + ":" + i;
  }
  
  public final boolean dt()
  {
    return this.Ru.dt();
  }
  
  public final boolean du()
  {
    return this.Ru.du();
  }
  
  public final boolean g(h paramh)
  {
    return this.Ru.g(paramh);
  }
  
  public MenuItem getItem()
  {
    return this.Rv;
  }
  
  public final boolean h(h paramh)
  {
    return this.Ru.h(paramh);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.k(a.a(this.mContext, paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.k(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.g(this.mContext.getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.g(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.a(null, null, paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.Rv.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.Rv.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.Ru.setQwertyMode(paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */