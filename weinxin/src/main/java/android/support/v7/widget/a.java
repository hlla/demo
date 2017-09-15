package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.g;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.f;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a
  extends ViewGroup
{
  protected int RA;
  protected ai RB;
  private boolean RC;
  private boolean RD;
  protected final a Rw = new a();
  protected final Context Rx;
  protected ActionMenuView Ry;
  protected ActionMenuPresenter Rz;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.Rx = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.Rx = paramContext;
  }
  
  protected static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 = (paramInt3 - j) / 2 + paramInt2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramBoolean) {
        paramInt1 = -i;
      }
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
  }
  
  protected static int c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected static int g(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public void ay(int paramInt)
  {
    this.RA = paramInt;
    requestLayout();
  }
  
  public ai c(int paramInt, long paramLong)
  {
    if (this.RB != null) {
      this.RB.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        z.d(this, 0.0F);
      }
      localai = z.V(this).p(1.0F);
      localai.c(paramLong);
      localai.a(this.Rw.a(localai, paramInt));
      return localai;
    }
    ai localai = z.V(this).p(0.0F);
    localai.c(paramLong);
    localai.a(this.Rw.a(localai, paramInt));
    return localai;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = getContext().obtainStyledAttributes(null, a.k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
    ay(paramConfiguration.getLayoutDimension(a.k.Lg, 0));
    paramConfiguration.recycle();
    if (this.Rz != null)
    {
      paramConfiguration = this.Rz;
      if (!paramConfiguration.SH) {
        paramConfiguration.SG = paramConfiguration.mContext.getResources().getInteger(a.g.Ky);
      }
      if (paramConfiguration.dW != null) {
        paramConfiguration.dW.h(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    if (i == 9) {
      this.RD = false;
    }
    if (!this.RD)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.RD = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.RD = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    if (i == 0) {
      this.RC = false;
    }
    if (!this.RC)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.RC = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.RC = false;
    }
    return true;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.RB != null) {
        this.RB.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    if (this.Rz != null) {
      return this.Rz.showOverflowMenu();
    }
    return false;
  }
  
  protected final class a
    implements am
  {
    private boolean RE = false;
    int RF;
    
    protected a() {}
    
    public final a a(ai paramai, int paramInt)
    {
      a.this.RB = paramai;
      this.RF = paramInt;
      return this;
    }
    
    public final void as(View paramView)
    {
      this.RE = true;
    }
    
    public final void p(View paramView)
    {
      a.a(a.this);
      this.RE = false;
    }
    
    public final void q(View paramView)
    {
      if (this.RE) {
        return;
      }
      a.this.RB = null;
      a.a(a.this, this.RF);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */