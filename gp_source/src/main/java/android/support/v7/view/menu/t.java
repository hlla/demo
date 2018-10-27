package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class t
  implements b
{
  private CharSequence A;
  private CharSequence B;
  private CharSequence C;
  public d a;
  public p b;
  public final int c;
  public int d = 4096;
  public int e = 4096;
  public int f = 0;
  private View g;
  private final int h;
  private MenuItem.OnMenuItemClickListener i;
  private CharSequence j;
  private int k = 16;
  private final int l;
  private boolean m = false;
  private boolean n = false;
  private Drawable o;
  private int p = 0;
  private ColorStateList q = null;
  private PorterDuff.Mode r = null;
  private final int s;
  private Intent t;
  private boolean u = false;
  private boolean v = false;
  private MenuItem.OnActionExpandListener w;
  private char x;
  private char y;
  private ap z;
  
  t(p paramp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.b = paramp;
    this.s = paramInt2;
    this.l = paramInt1;
    this.h = paramInt3;
    this.c = paramInt4;
    this.A = paramCharSequence;
    this.f = paramInt5;
  }
  
  private final Drawable a(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.v) {
        if (!this.m)
        {
          localDrawable = paramDrawable;
          if (!this.n) {}
        }
        else
        {
          localDrawable = android.support.v4.a.a.a.f(paramDrawable).mutate();
          if (this.m) {
            android.support.v4.a.a.a.a(localDrawable, this.q);
          }
          if (this.n) {
            android.support.v4.a.a.a.a(localDrawable, this.r);
          }
          this.v = false;
        }
      }
    }
    return localDrawable;
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    int i2 = this.k;
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = 2)
    {
      this.k = (i1 | i2 & 0xFFFFFFFD);
      if (i2 != this.k) {
        this.b.b(false);
      }
      return;
    }
  }
  
  public final b a(d paramd)
  {
    d locald = this.a;
    if (locald == null) {}
    for (;;)
    {
      this.g = null;
      this.a = paramd;
      this.b.b(true);
      paramd = this.a;
      if (paramd != null) {
        paramd.a(new u(this));
      }
      return this;
      locald.a = null;
    }
  }
  
  public final b a(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final d a()
  {
    return this.a;
  }
  
  final CharSequence a(ai paramai)
  {
    if (paramai == null) {}
    while (!paramai.a()) {
      return getTitle();
    }
    return getTitleCondensed();
  }
  
  public final void a(ap paramap)
  {
    this.z = paramap;
    paramap.setHeaderTitle(getTitle());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i2 = this.k;
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = 4)
    {
      this.k = (i1 | i2 & 0xFFFFFFFB);
      return;
    }
  }
  
  public final b b(CharSequence paramCharSequence)
  {
    this.C = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final boolean b()
  {
    Object localObject = this.i;
    if ((localObject == null) || (!((MenuItem.OnMenuItemClickListener)localObject).onMenuItemClick(this)))
    {
      localObject = this.b;
      if (!((p)localObject).a((p)localObject, this))
      {
        localObject = this.t;
        if (localObject == null) {
          break label65;
        }
      }
    }
    label65:
    d locald;
    do
    {
      try
      {
        this.b.c.startActivity((Intent)localObject);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
      }
      locald = this.a;
    } while ((locald != null) && (locald.d()));
    return false;
  }
  
  final boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    int i2 = this.k;
    if (!paramBoolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      this.k = (i1 | i2 & 0xFFFFFFF7);
      paramBoolean = bool;
      if (i2 != this.k) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  final char c()
  {
    if (!this.b.c()) {
      return this.y;
    }
    return this.x;
  }
  
  public final void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.k &= 0xFFFFFFDF;
      return;
    }
    this.k |= 0x20;
  }
  
  public final boolean collapseActionView()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.f & 0x8) != 0)
    {
      if (this.g == null) {
        break label53;
      }
      MenuItem.OnActionExpandListener localOnActionExpandListener = this.w;
      if (localOnActionExpandListener != null)
      {
        bool1 = bool2;
        if (!localOnActionExpandListener.onMenuItemActionCollapse(this)) {}
      }
      else
      {
        bool1 = this.b.b(this);
      }
    }
    return bool1;
    label53:
    return true;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.b.b(false);
  }
  
  final boolean d()
  {
    return (this.b.d()) && (c() != 0);
  }
  
  public final boolean e()
  {
    return (this.k & 0x4) != 0;
  }
  
  public final boolean expandActionView()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (h())
    {
      MenuItem.OnActionExpandListener localOnActionExpandListener = this.w;
      if (localOnActionExpandListener != null)
      {
        bool1 = bool2;
        if (!localOnActionExpandListener.onMenuItemActionExpand(this)) {}
      }
      else
      {
        bool1 = this.b.a(this);
      }
    }
    return bool1;
  }
  
  public final boolean f()
  {
    return (this.k & 0x20) == 32;
  }
  
  public final boolean g()
  {
    return (this.f & 0x2) == 2;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    View localView = this.g;
    Object localObject = localView;
    if (localView == null)
    {
      localObject = this.a;
      if (localObject != null)
      {
        this.g = ((d)localObject).a(this);
        localObject = this.g;
      }
    }
    else
    {
      return (View)localObject;
    }
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.d;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.x;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.j;
  }
  
  public final int getGroupId()
  {
    return this.l;
  }
  
  public final Drawable getIcon()
  {
    Drawable localDrawable = this.o;
    if (localDrawable != null) {
      return a(localDrawable);
    }
    int i1 = this.p;
    if (i1 != 0)
    {
      localDrawable = android.support.v7.b.a.a.b(this.b.c, i1);
      this.p = 0;
      this.o = localDrawable;
      return a(localDrawable);
    }
    return null;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.q;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.r;
  }
  
  public final Intent getIntent()
  {
    return this.t;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.s;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final int getNumericModifiers()
  {
    return this.e;
  }
  
  public final char getNumericShortcut()
  {
    return this.y;
  }
  
  public final int getOrder()
  {
    return this.h;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.z;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.A;
  }
  
  public final CharSequence getTitleCondensed()
  {
    Object localObject2 = this.B;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.A;
    }
    localObject2 = localObject1;
    if (Build.VERSION.SDK_INT < 18)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof String)) {
          localObject2 = ((CharSequence)localObject1).toString();
        }
      }
    }
    return (CharSequence)localObject2;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.C;
  }
  
  public final boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.f & 0x8) != 0)
    {
      if (this.g == null)
      {
        d locald = this.a;
        if (locald != null) {
          this.g = locald.a(this);
        }
      }
      bool1 = bool2;
      if (this.g != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean hasSubMenu()
  {
    return this.z != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.u;
  }
  
  public final boolean isCheckable()
  {
    return (byte)(this.k & 0x1);
  }
  
  public final boolean isChecked()
  {
    return (this.k & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.k & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    d locald = this.a;
    if ((locald != null) && (locald.b())) {
      if (((this.k & 0x8) != 0) || (!this.a.c())) {}
    }
    while ((this.k & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.x != paramChar)
    {
      this.x = Character.toLowerCase(paramChar);
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.x != paramChar) || (this.d != paramInt))
    {
      this.x = Character.toLowerCase(paramChar);
      this.d = KeyEvent.normalizeMetaState(paramInt);
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = this.k;
    this.k = (i1 & 0xFFFFFFFE | paramBoolean);
    if (i1 != this.k) {
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.k & 0x4) != 0)
    {
      p localp = this.b;
      int i2 = getGroupId();
      int i3 = localp.i.size();
      localp.e();
      int i1 = 0;
      if (i1 < i3)
      {
        t localt = (t)localp.i.get(i1);
        if (localt.getGroupId() != i2) {}
        while ((!localt.e()) || (!localt.isCheckable()))
        {
          i1 += 1;
          break;
        }
        if (localt == this) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localt.e(paramBoolean);
          break;
        }
      }
      localp.f();
      return this;
    }
    e(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (this.k &= 0xFFFFFFEF;; this.k |= 0x10)
    {
      this.b.b(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.o = null;
    this.p = paramInt;
    this.v = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.p = 0;
    this.o = paramDrawable;
    this.v = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.q = paramColorStateList;
    this.m = true;
    this.v = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.r = paramMode;
    this.n = true;
    this.v = true;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.t = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.y != paramChar)
    {
      this.y = paramChar;
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.y != paramChar) || (this.e != paramInt))
    {
      this.y = paramChar;
      this.e = KeyEvent.normalizeMetaState(paramInt);
      this.b.b(false);
    }
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.w = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.i = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.y = paramChar1;
    this.x = Character.toLowerCase(paramChar2);
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.y = paramChar1;
    this.e = KeyEvent.normalizeMetaState(paramInt1);
    this.x = Character.toLowerCase(paramChar2);
    this.d = KeyEvent.normalizeMetaState(paramInt2);
    this.b.b(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.f = paramInt;
    this.b.h();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.b.c.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.A = paramCharSequence;
    this.b.b(false);
    ap localap = this.z;
    if (localap != null) {
      localap.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.B = paramCharSequence;
    this.b.b(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (b(paramBoolean)) {
      this.b.g();
    }
    return this;
  }
  
  public final String toString()
  {
    CharSequence localCharSequence = this.A;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */