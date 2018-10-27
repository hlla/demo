package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public class v
  extends e
  implements MenuItem
{
  public Method e;
  
  v(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  w a(ActionProvider paramActionProvider)
  {
    return new w(this, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((b)this.d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((b)this.d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    d locald = ((b)this.d).a();
    if ((locald instanceof w)) {
      return ((w)locald).b;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((b)this.d).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof x)) {
      localView1 = (View)((x)localView2).a;
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((b)this.d).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((b)this.d).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((b)this.d).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((b)this.d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((b)this.d).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((b)this.d).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((b)this.d).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((b)this.d).getIntent();
  }
  
  public int getItemId()
  {
    return ((b)this.d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((b)this.d).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((b)this.d).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((b)this.d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((b)this.d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((b)this.d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((b)this.d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((b)this.d).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((b)this.d).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((b)this.d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((b)this.d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((b)this.d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((b)this.d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((b)this.d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((b)this.d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    b localb = (b)this.d;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((b)this.d).setActionView(paramInt);
    View localView = ((b)this.d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((b)this.d).setActionView(new x(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new x(paramView);
    }
    ((b)this.d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((b)this.d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((b)this.d).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((b)this.d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((b)this.d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((b)this.d).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((b)this.d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((b)this.d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((b)this.d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((b)this.d).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((b)this.d).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((b)this.d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((b)this.d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((b)this.d).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    b localb = (b)this.d;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new y(this, paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    b localb = (b)this.d;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new z(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((b)this.d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((b)this.d).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((b)this.d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((b)this.d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((b)this.d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((b)this.d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((b)this.d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((b)this.d).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((b)this.d).setVisible(paramBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */