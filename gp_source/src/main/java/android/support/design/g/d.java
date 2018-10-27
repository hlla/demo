package android.support.design.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class d
  implements ValueAnimator.AnimatorUpdateListener
{
  d(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */