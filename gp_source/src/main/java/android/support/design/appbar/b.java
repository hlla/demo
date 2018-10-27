package android.support.design.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.CoordinatorLayout;

final class b
  implements ValueAnimator.AnimatorUpdateListener
{
  b(AppBarLayout.BaseBehavior paramBaseBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a_(this.c, this.b, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */