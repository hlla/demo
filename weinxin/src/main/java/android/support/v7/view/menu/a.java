package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a
  implements b
{
  private final int PA;
  private CharSequence PB;
  private Intent PC;
  private char PD;
  private char PE;
  private Drawable PF;
  private int PG = 0;
  private MenuItem.OnMenuItemClickListener PH;
  private final int Py;
  private final int Pz;
  private final int dX;
  private Context mContext;
  private CharSequence uI;
  private int uf = 16;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.dX = 16908332;
    this.Py = 0;
    this.Pz = 0;
    this.PA = 0;
    this.uI = paramCharSequence;
  }
  
  public final b a(d paramd)
  {
    throw new UnsupportedOperationException();
  }
  
  public final b a(m.e parame)
  {
    return this;
  }
  
  public final d bv()
  {
    return null;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.PE;
  }
  
  public final int getGroupId()
  {
    return this.Py;
  }
  
  public final Drawable getIcon()
  {
    return this.PF;
  }
  
  public final Intent getIntent()
  {
    return this.PC;
  }
  
  public final int getItemId()
  {
    return this.dX;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final char getNumericShortcut()
  {
    return this.PD;
  }
  
  public final int getOrder()
  {
    return this.PA;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.uI;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.PB != null) {
      return this.PB;
    }
    return this.uI;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return (this.uf & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.uf & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.uf & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.uf & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.PE = paramChar;
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.uf;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.uf = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.uf;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.uf = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.uf;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.uf = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.PG = paramInt;
    this.PF = android.support.v4.content.a.a(this.mContext, paramInt);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.PF = paramDrawable;
    this.PG = 0;
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.PC = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.PD = paramChar;
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.PH = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.PD = paramChar1;
    this.PE = paramChar2;
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.uI = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.PB = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.uf;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.uf = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */