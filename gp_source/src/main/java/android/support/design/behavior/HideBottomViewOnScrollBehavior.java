package android.support.design.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior
  extends h
{
  public ViewPropertyAnimator a;
  private int b = 2;
  private int c = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a(View paramView, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    this.a = paramView.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new a(this));
  }
  
  public final void a(View paramView, int paramInt)
  {
    int i = this.b;
    if (i == 1) {}
    while (paramInt <= 0)
    {
      if ((i != 2) && (paramInt < 0))
      {
        localViewPropertyAnimator = this.a;
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator.cancel();
          paramView.clearAnimation();
        }
        this.b = 2;
        a(paramView, 0, 225L, android.support.design.a.a.e);
      }
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.a;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramView.clearAnimation();
    }
    this.b = 1;
    a(paramView, this.c, 175L, android.support.design.a.a.b);
  }
  
  public final boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    this.c = paramView.getMeasuredHeight();
    return super.a(paramCoordinatorLayout, paramView, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/behavior/HideBottomViewOnScrollBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */