package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.ImageButton;
import android.widget.TextView;

public final class aq
  implements u
{
  public Window.Callback HJ;
  private ActionMenuPresenter Rz;
  private final h Um;
  private Drawable afA;
  private int afr;
  private View afs;
  private Drawable aft;
  private Drawable afu;
  private boolean afv;
  private CharSequence afw;
  public boolean afx;
  private int afy = 0;
  private int afz = 0;
  public Toolbar gz;
  private Drawable jQ;
  private View kD;
  public CharSequence uI;
  private CharSequence uJ;
  
  public aq(Toolbar paramToolbar)
  {
    this(paramToolbar, true, a.i.KS, a.e.Jg);
  }
  
  private aq(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.gz = paramToolbar;
    this.uI = paramToolbar.aeY;
    this.uJ = paramToolbar.aeZ;
    Object localObject1;
    if (this.uI != null)
    {
      paramBoolean = true;
      this.afv = paramBoolean;
      if (paramToolbar.aeJ == null) {
        break label662;
      }
      localObject1 = paramToolbar.aeJ.getDrawable();
      label68:
      this.afu = ((Drawable)localObject1);
      paramToolbar = ap.a(paramToolbar.getContext(), null, a.k.aV, a.a.actionBarStyle);
      localObject1 = paramToolbar.getText(a.k.Lo);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.afv = true;
        j((CharSequence)localObject1);
      }
      localObject1 = paramToolbar.getText(a.k.Lm);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.uJ = ((CharSequence)localObject1);
        if ((this.afr & 0x8) != 0) {
          this.gz.setSubtitle((CharSequence)localObject1);
        }
      }
      localObject1 = paramToolbar.getDrawable(a.k.Lk);
      if (localObject1 != null) {
        setLogo((Drawable)localObject1);
      }
      localObject1 = paramToolbar.getDrawable(a.k.Lj);
      if ((this.afu == null) && (localObject1 != null)) {
        setIcon((Drawable)localObject1);
      }
      localObject1 = paramToolbar.getDrawable(a.k.Li);
      if (localObject1 != null)
      {
        this.afu = ((Drawable)localObject1);
        hc();
      }
      setDisplayOptions(paramToolbar.getInt(a.k.Le, 0));
      int i = paramToolbar.getResourceId(a.k.Ld, 0);
      if (i != 0)
      {
        setCustomView(LayoutInflater.from(this.gz.getContext()).inflate(i, this.gz, false));
        setDisplayOptions(this.afr | 0x10);
      }
      i = paramToolbar.getLayoutDimension(a.k.Lg, 0);
      if (i > 0)
      {
        localObject1 = this.gz.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = i;
        this.gz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      int j = paramToolbar.getDimensionPixelOffset(a.k.Lc, -1);
      i = paramToolbar.getDimensionPixelOffset(a.k.Lb, -1);
      if ((j >= 0) || (i >= 0))
      {
        localObject1 = this.gz;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        ((Toolbar)localObject1).aeX.ac(j, i);
      }
      i = paramToolbar.getResourceId(a.k.Lp, 0);
      Context localContext;
      if (i != 0)
      {
        localObject1 = this.gz;
        localContext = this.gz.getContext();
        ((Toolbar)localObject1).aeP = i;
        if (((Toolbar)localObject1).aeH != null) {
          ((Toolbar)localObject1).aeH.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(a.k.Ln, 0);
      if (i != 0)
      {
        localObject1 = this.gz;
        localContext = this.gz.getContext();
        ((Toolbar)localObject1).aeQ = i;
        if (((Toolbar)localObject1).aeI != null) {
          ((Toolbar)localObject1).aeI.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(a.k.Ll, 0);
      if (i != 0) {
        this.gz.setPopupTheme(i);
      }
      paramToolbar.aeG.recycle();
      this.Um = h.ey();
      if (paramInt1 != this.afz)
      {
        this.afz = paramInt1;
        if (TextUtils.isEmpty(this.gz.getNavigationContentDescription()))
        {
          paramInt1 = this.afz;
          if (paramInt1 != 0) {
            break label668;
          }
        }
      }
    }
    label662:
    label668:
    for (paramToolbar = (Toolbar)localObject2;; paramToolbar = this.gz.getContext().getString(paramInt1))
    {
      this.afw = paramToolbar;
      hb();
      this.afw = this.gz.getNavigationContentDescription();
      paramToolbar = this.Um.a(this.gz.getContext(), paramInt2, false);
      if (this.afA != paramToolbar)
      {
        this.afA = paramToolbar;
        hc();
      }
      this.gz.setNavigationOnClickListener(new View.OnClickListener()
      {
        final a afB = new a(aq.this.gz.getContext(), aq.this.uI);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((aq.this.HJ != null) && (aq.this.afx)) {
            aq.this.HJ.onMenuItemSelected(0, this.afB);
          }
        }
      });
      return;
      paramBoolean = false;
      break;
      localObject1 = null;
      break label68;
    }
  }
  
  private void ha()
  {
    Drawable localDrawable = null;
    if ((this.afr & 0x2) != 0)
    {
      if ((this.afr & 0x1) == 0) {
        break label49;
      }
      if (this.aft == null) {
        break label41;
      }
      localDrawable = this.aft;
    }
    for (;;)
    {
      this.gz.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.jQ;
      continue;
      label49:
      localDrawable = this.jQ;
    }
  }
  
  private void hb()
  {
    Toolbar localToolbar;
    int i;
    if ((this.afr & 0x4) != 0)
    {
      if (!TextUtils.isEmpty(this.afw)) {
        break label53;
      }
      localToolbar = this.gz;
      i = this.afz;
      if (i == 0) {
        break label48;
      }
    }
    label48:
    for (CharSequence localCharSequence = localToolbar.getContext().getText(i);; localCharSequence = null)
    {
      localToolbar.setNavigationContentDescription(localCharSequence);
      return;
    }
    label53:
    this.gz.setNavigationContentDescription(this.afw);
  }
  
  private void hc()
  {
    Toolbar localToolbar;
    if ((this.afr & 0x4) != 0)
    {
      localToolbar = this.gz;
      if (this.afu == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = this.afu;; localDrawable = this.afA)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  private void j(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    if ((this.afr & 0x8) != 0) {
      this.gz.setTitle(paramCharSequence);
    }
  }
  
  private void setIcon(Drawable paramDrawable)
  {
    this.jQ = paramDrawable;
    ha();
  }
  
  public final void N(boolean paramBoolean)
  {
    Toolbar localToolbar = this.gz;
    localToolbar.afk = paramBoolean;
    localToolbar.requestLayout();
  }
  
  public final void a(l.a parama, f.a parama1)
  {
    Toolbar localToolbar = this.gz;
    localToolbar.Tc = parama;
    localToolbar.Td = parama1;
    if (localToolbar.Ry != null) {
      localToolbar.Ry.a(parama, parama1);
    }
  }
  
  public final void a(Menu paramMenu, l.a parama)
  {
    if (this.Rz == null)
    {
      this.Rz = new ActionMenuPresenter(this.gz.getContext());
      this.Rz.dX = a.f.JR;
    }
    this.Rz.dV = parama;
    this.gz.a((f)paramMenu, this.Rz);
  }
  
  public final void b(ai paramai)
  {
    if ((this.afs != null) && (this.afs.getParent() == this.gz)) {
      this.gz.removeView(this.afs);
    }
    this.afs = paramai;
    if ((paramai != null) && (this.afy == 2))
    {
      this.gz.addView(this.afs, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.afs.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramai.abO = true;
    }
  }
  
  public final void b(Window.Callback paramCallback)
  {
    this.HJ = paramCallback;
  }
  
  public final android.support.v4.view.ai c(final int paramInt, long paramLong)
  {
    android.support.v4.view.ai localai = z.V(this.gz);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localai.p(f).c(paramLong).a(new an()
      {
        private boolean RE = false;
        
        public final void as(View paramAnonymousView)
        {
          this.RE = true;
        }
        
        public final void p(View paramAnonymousView)
        {
          aq.this.gz.setVisibility(0);
        }
        
        public final void q(View paramAnonymousView)
        {
          if (!this.RE) {
            aq.this.gz.setVisibility(paramInt);
          }
        }
      });
    }
  }
  
  public final void collapseActionView()
  {
    this.gz.collapseActionView();
  }
  
  public final boolean dT()
  {
    Toolbar localToolbar = this.gz;
    return (localToolbar.getVisibility() == 0) && (localToolbar.Ry != null) && (localToolbar.Ry.SC);
  }
  
  public final boolean dU()
  {
    Object localObject = this.gz;
    if (((Toolbar)localObject).Ry != null)
    {
      localObject = ((Toolbar)localObject).Ry;
      if (((ActionMenuView)localObject).Tb != null)
      {
        localObject = ((ActionMenuView)localObject).Tb;
        if ((((ActionMenuPresenter)localObject).SQ != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
        {
          i = 1;
          if (i == 0) {
            break label62;
          }
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        return true;
        i = 0;
        break;
      }
    }
    label67:
    return false;
  }
  
  public final void dV()
  {
    this.afx = true;
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.gz;
    if (localToolbar.Ry != null) {
      localToolbar.Ry.dismissPopupMenus();
    }
  }
  
  public final void e(CharSequence paramCharSequence)
  {
    if (!this.afv) {
      j(paramCharSequence);
    }
  }
  
  public final ViewGroup eI()
  {
    return this.gz;
  }
  
  public final Context getContext()
  {
    return this.gz.getContext();
  }
  
  public final View getCustomView()
  {
    return this.kD;
  }
  
  public final int getDisplayOptions()
  {
    return this.afr;
  }
  
  public final int getHeight()
  {
    return this.gz.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.gz.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.afy;
  }
  
  public final CharSequence getTitle()
  {
    return this.gz.aeY;
  }
  
  public final int getVisibility()
  {
    return this.gz.getVisibility();
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.gz;
    return (localToolbar.afj != null) && (localToolbar.afj.afn != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.gz;
    if (((Toolbar)localObject).Ry != null)
    {
      localObject = ((Toolbar)localObject).Ry;
      if ((((ActionMenuView)localObject).Tb != null) && (((ActionMenuView)localObject).Tb.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.gz.isOverflowMenuShowing();
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.gz.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.kD != null) && ((this.afr & 0x10) != 0)) {
      this.gz.removeView(this.kD);
    }
    this.kD = paramView;
    if ((paramView != null) && ((this.afr & 0x10) != 0)) {
      this.gz.addView(this.kD);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.afr ^ paramInt;
    this.afr = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        hc();
        hb();
      }
      if ((i & 0x3) != 0) {
        ha();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        this.gz.setTitle(this.uI);
        this.gz.setSubtitle(this.uJ);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.kD != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        this.gz.addView(this.kD);
      }
      return;
      label115:
      this.gz.setNavigationIcon(null);
      break;
      label126:
      this.gz.setTitle(null);
      this.gz.setSubtitle(null);
    }
    label145:
    this.gz.removeView(this.kD);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.Um.a(this.gz.getContext(), paramInt, false);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.aft = paramDrawable;
    ha();
  }
  
  public final void setVisibility(int paramInt)
  {
    this.gz.setVisibility(paramInt);
  }
  
  public final boolean showOverflowMenu()
  {
    return this.gz.showOverflowMenu();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */