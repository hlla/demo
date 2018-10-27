package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

class a
  extends ViewGroup
{
  public j a;
  public int b;
  public ActionMenuView c;
  public final Context d;
  public az e;
  private boolean f;
  private boolean g;
  private final b h = new b(this);
  
  a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(2130968578, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.d = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.d = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramInt1 + paramInt2;
    }
    return paramInt1 - paramInt2;
  }
  
  protected static int a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth());
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
  
  public az a(int paramInt, long paramLong)
  {
    az localaz = this.e;
    if (localaz == null) {}
    for (;;)
    {
      if (paramInt == 0)
      {
        if (getVisibility() != 0) {
          setAlpha(0.0F);
        }
        localaz = ac.t(this).a(1.0F);
        localaz.a(paramLong);
        localaz.a(this.h.a(localaz, paramInt));
        return localaz;
      }
      localaz = ac.t(this).a(0.0F);
      localaz.a(paramLong);
      localaz.a(this.h.a(localaz, paramInt));
      return localaz;
      localaz.a();
    }
  }
  
  public boolean a()
  {
    j localj = this.a;
    if (localj == null) {
      return false;
    }
    return localj.c();
  }
  
  public int getAnimatedVisibility()
  {
    if (this.e != null) {
      return this.h.a;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.b;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, android.support.v7.a.a.a, 2130968581, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(android.support.v7.a.a.l, 0));
    paramConfiguration.recycle();
    paramConfiguration = this.a;
    if (paramConfiguration != null)
    {
      paramConfiguration.h = android.support.v7.view.a.a(paramConfiguration.b).a();
      paramConfiguration = paramConfiguration.c;
      if (paramConfiguration != null) {
        paramConfiguration.b(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.f = false;
    }
    boolean bool;
    if (!this.f)
    {
      bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9) {
        break label53;
      }
    }
    for (;;)
    {
      if ((i == 10) || (i == 3)) {
        this.f = false;
      }
      return true;
      label53:
      if (!bool) {
        this.f = true;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.g = false;
    }
    boolean bool;
    if (!this.g)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0) {
        break label48;
      }
    }
    for (;;)
    {
      if ((i == 1) || (i == 3)) {
        this.g = false;
      }
      return true;
      label48:
      if (!bool) {
        this.g = true;
      }
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.b = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      az localaz = this.e;
      if (localaz != null) {
        localaz.a();
      }
      super.setVisibility(paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */