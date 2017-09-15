package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i
  extends c<b>
  implements MenuItem
{
  public Method Ra;
  
  i(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.mContext, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((b)this.PY).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((b)this.PY).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    android.support.v4.view.d locald = ((b)this.PY).bv();
    if ((locald instanceof a)) {
      return ((a)locald).Rb;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((b)this.PY).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof b)) {
      localView1 = (View)((b)localView2).Rd;
    }
    return localView1;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((b)this.PY).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((b)this.PY).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((b)this.PY).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((b)this.PY).getIntent();
  }
  
  public int getItemId()
  {
    return ((b)this.PY).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((b)this.PY).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((b)this.PY).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((b)this.PY).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((b)this.PY).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((b)this.PY).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((b)this.PY).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((b)this.PY).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((b)this.PY).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((b)this.PY).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((b)this.PY).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((b)this.PY).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((b)this.PY).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    b localb = (b)this.PY;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((b)this.PY).setActionView(paramInt);
    View localView = ((b)this.PY).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((b)this.PY).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((b)this.PY).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((b)this.PY).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((b)this.PY).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((b)this.PY).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((b)this.PY).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((b)this.PY).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((b)this.PY).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((b)this.PY).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((b)this.PY).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    b localb = (b)this.PY;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.a(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    b localb = (b)this.PY;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((b)this.PY).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((b)this.PY).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((b)this.PY).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((b)this.PY).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((b)this.PY).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((b)this.PY).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((b)this.PY).setVisible(paramBoolean);
  }
  
  class a
    extends android.support.v4.view.d
  {
    final ActionProvider Rb;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.Rb = paramActionProvider;
    }
    
    public final boolean hasSubMenu()
    {
      return this.Rb.hasSubMenu();
    }
    
    public final View onCreateActionView()
    {
      return this.Rb.onCreateActionView();
    }
    
    public final boolean onPerformDefaultAction()
    {
      return this.Rb.onPerformDefaultAction();
    }
    
    public final void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.Rb.onPrepareSubMenu(i.this.a(paramSubMenu));
    }
  }
  
  static final class b
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView Rd;
    
    b(View paramView)
    {
      super();
      this.Rd = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void onActionViewCollapsed()
    {
      this.Rd.onActionViewCollapsed();
    }
    
    public final void onActionViewExpanded()
    {
      this.Rd.onActionViewExpanded();
    }
  }
  
  private final class c
    extends d<MenuItem.OnActionExpandListener>
    implements m.e
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.PY).onMenuItemActionCollapse(i.this.f(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.PY).onMenuItemActionExpand(i.this.f(paramMenuItem));
    }
  }
  
  private final class d
    extends d<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.PY).onMenuItemClick(i.this.f(paramMenuItem));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */