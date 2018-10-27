package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a
  implements b
{
  private CharSequence a;
  private Context b;
  private int c = 16;
  private boolean d = false;
  private boolean e = false;
  private Drawable f;
  private ColorStateList g = null;
  private PorterDuff.Mode h = null;
  private final int i;
  private Intent j;
  private char k;
  private int l = 4096;
  private char m;
  private int n = 4096;
  private CharSequence o;
  private CharSequence p;
  private CharSequence q;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.b = paramContext;
    this.i = 16908332;
    this.o = paramCharSequence;
  }
  
  private final void b()
  {
    Drawable localDrawable = this.f;
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      this.f = android.support.v4.a.a.a.f(localDrawable);
      this.f = this.f.mutate();
      if (this.d) {
        android.support.v4.a.a.a.a(this.f, this.g);
      }
      if (this.e) {
        android.support.v4.a.a.a.a(this.f, this.h);
      }
    }
  }
  
  public final b a(android.support.v4.view.d paramd)
  {
    throw new UnsupportedOperationException();
  }
  
  public final b a(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.view.d a()
  {
    return null;
  }
  
  public final b b(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    return this;
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
  
  public final int getAlphabeticModifiers()
  {
    return this.l;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.k;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.a;
  }
  
  public final int getGroupId()
  {
    return 0;
  }
  
  public final Drawable getIcon()
  {
    return this.f;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.g;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.h;
  }
  
  public final Intent getIntent()
  {
    return this.j;
  }
  
  public final int getItemId()
  {
    return this.i;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final int getNumericModifiers()
  {
    return this.n;
  }
  
  public final char getNumericShortcut()
  {
    return this.m;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.o;
  }
  
  public final CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence2 = this.p;
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = this.o;
    }
    return localCharSequence1;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.q;
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
    return (byte)(this.c & 0x1);
  }
  
  public final boolean isChecked()
  {
    return (this.c & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.c & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.c & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.k = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.k = Character.toLowerCase(paramChar);
    this.l = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    this.c = (this.c & 0xFFFFFFFE | paramBoolean);
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int i2 = this.c;
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = 2)
    {
      this.c = (i1 | i2 & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int i2 = this.c;
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = 16)
    {
      this.c = (i1 | i2 & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.f = android.support.v4.content.d.a(this.b, paramInt);
    b();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    b();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    this.d = true;
    b();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.h = paramMode;
    this.e = true;
    b();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.j = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.m = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.m = paramChar;
    this.n = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.m = paramChar1;
    this.k = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.m = paramChar1;
    this.n = KeyEvent.normalizeMetaState(paramInt1);
    this.k = Character.toLowerCase(paramChar2);
    this.l = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.o = this.b.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.o = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int i2 = this.c;
    if (!paramBoolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      this.c = (i1 | i2 & 0x8);
      return this;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */