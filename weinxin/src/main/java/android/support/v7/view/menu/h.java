package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.d.b;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class h
  implements b
{
  static String QV;
  static String QW;
  static String QX;
  static String QY;
  final int PA;
  private CharSequence PB;
  private Intent PC;
  private char PD;
  private char PE;
  private Drawable PF;
  private int PG = 0;
  private MenuItem.OnMenuItemClickListener PH;
  private final int Py;
  private final int Pz;
  private p QN;
  private Runnable QO;
  int QP = 0;
  private View QQ;
  public d QR;
  private m.e QS;
  private boolean QT = false;
  ContextMenu.ContextMenuInfo QU;
  public f dW;
  private final int dX;
  private CharSequence uI;
  private int uf = 16;
  
  h(f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.dW = paramf;
    this.dX = paramInt2;
    this.Py = paramInt1;
    this.Pz = paramInt3;
    this.PA = paramInt4;
    this.uI = paramCharSequence;
    this.QP = paramInt5;
  }
  
  private void F(boolean paramBoolean)
  {
    int j = this.uf;
    int k = this.uf;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.uf = (i | k & 0xFFFFFFFD);
      if (j != this.uf) {
        this.dW.h(false);
      }
      return;
    }
  }
  
  private b aK(View paramView)
  {
    this.QQ = paramView;
    this.QR = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.dX > 0)) {
      paramView.setId(this.dX);
    }
    this.dW.dy();
    return this;
  }
  
  public final void E(boolean paramBoolean)
  {
    int j = this.uf;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.uf = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean G(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.uf;
    int k = this.uf;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.uf = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.uf) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void H(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uf |= 0x20;
      return;
    }
    this.uf &= 0xFFFFFFDF;
  }
  
  public final void I(boolean paramBoolean)
  {
    this.QT = paramBoolean;
    this.dW.h(false);
  }
  
  public final b a(d paramd)
  {
    if (this.QR != null)
    {
      d locald = this.QR;
      locald.wx = null;
      locald.ww = null;
    }
    this.QQ = null;
    this.QR = paramd;
    this.dW.h(true);
    if (this.QR != null) {
      this.QR.a(new d.b()
      {
        public final void bJ()
        {
          h.this.dW.dx();
        }
      });
    }
    return this;
  }
  
  public final b a(m.e parame)
  {
    this.QS = parame;
    return this;
  }
  
  final CharSequence a(m.a parama)
  {
    if ((parama != null) && (parama.A())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void b(p paramp)
  {
    this.QN = paramp;
    paramp.setHeaderTitle(getTitle());
  }
  
  public final d bv()
  {
    return this.QR;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.QP & 0x8) == 0) {}
    do
    {
      return false;
      if (this.QQ == null) {
        return true;
      }
    } while ((this.QS != null) && (!this.QS.onMenuItemActionCollapse(this)));
    return this.dW.h(this);
  }
  
  public final boolean dD()
  {
    if ((this.PH != null) && (this.PH.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.dW.b(this.dW.dC(), this));
      if (this.QO != null)
      {
        this.QO.run();
        return true;
      }
      if (this.PC != null) {
        try
        {
          this.dW.mContext.startActivity(this.PC);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException) {}
      }
    } while ((this.QR != null) && (this.QR.onPerformDefaultAction()));
    return false;
  }
  
  final char dE()
  {
    if (this.dW.dt()) {
      return this.PE;
    }
    return this.PD;
  }
  
  final boolean dF()
  {
    return (this.dW.du()) && (dE() != 0);
  }
  
  public final boolean dG()
  {
    return (this.uf & 0x4) != 0;
  }
  
  public final boolean dH()
  {
    return (this.uf & 0x20) == 32;
  }
  
  public final boolean dI()
  {
    return (this.QP & 0x1) == 1;
  }
  
  public final boolean dJ()
  {
    return (this.QP & 0x2) == 2;
  }
  
  public final boolean dK()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.QP & 0x8) != 0)
    {
      if ((this.QQ == null) && (this.QR != null)) {
        this.QQ = this.QR.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.QQ != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean expandActionView()
  {
    if (!dK()) {}
    while ((this.QS != null) && (!this.QS.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.dW.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.QQ != null) {
      return this.QQ;
    }
    if (this.QR != null)
    {
      this.QQ = this.QR.onCreateActionView(this);
      return this.QQ;
    }
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
    if (this.PF != null) {
      return this.PF;
    }
    if (this.PG != 0)
    {
      Drawable localDrawable = android.support.v7.widget.h.ey().a(this.dW.mContext, this.PG, false);
      this.PG = 0;
      this.PF = localDrawable;
      return localDrawable;
    }
    return null;
  }
  
  public final Intent getIntent()
  {
    return this.PC;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.dX;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.QU;
  }
  
  public final char getNumericShortcut()
  {
    return this.PD;
  }
  
  public final int getOrder()
  {
    return this.Pz;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.QN;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.uI;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.PB != null) {}
    for (CharSequence localCharSequence = this.PB;; localCharSequence = this.uI)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return (CharSequence)localObject;
    }
  }
  
  public final boolean hasSubMenu()
  {
    return this.QN != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.QT;
  }
  
  public final boolean isCheckable()
  {
    return (this.uf & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.uf & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.uf & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.QR != null) && (this.QR.overridesItemVisibility())) {
      if (((this.uf & 0x8) != 0) || (!this.QR.isVisible())) {}
    }
    while ((this.uf & 0x8) == 0)
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
    if (this.PE == paramChar) {
      return this;
    }
    this.PE = Character.toLowerCase(paramChar);
    this.dW.h(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.uf;
    int k = this.uf;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.uf = (i | k & 0xFFFFFFFE);
      if (j != this.uf) {
        this.dW.h(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.uf & 0x4) != 0)
    {
      f localf = this.dW;
      int j = getGroupId();
      int k = localf.eh.size();
      int i = 0;
      if (i < k)
      {
        h localh = (h)localf.eh.get(i);
        if ((localh.getGroupId() == j) && (localh.dG()) && (localh.isCheckable())) {
          if (localh != this) {
            break label100;
          }
        }
        label100:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localh.F(paramBoolean);
          i += 1;
          break;
        }
      }
    }
    else
    {
      F(paramBoolean);
    }
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.uf |= 0x10;; this.uf &= 0xFFFFFFEF)
    {
      this.dW.h(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.PF = null;
    this.PG = paramInt;
    this.dW.h(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.PG = 0;
    this.PF = paramDrawable;
    this.dW.h(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.PC = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.PD == paramChar) {
      return this;
    }
    this.PD = paramChar;
    this.dW.h(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.PH = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.PD = paramChar1;
    this.PE = Character.toLowerCase(paramChar2);
    this.dW.h(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.QP = paramInt;
    this.dW.dy();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.dW.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    this.dW.h(false);
    if (this.QN != null) {
      this.QN.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.PB = paramCharSequence;
    this.dW.h(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (G(paramBoolean)) {
      this.dW.dx();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.uI != null) {
      return this.uI.toString();
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */