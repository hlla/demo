package android.support.v4.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class h
  implements ValueAnimator.AnimatorUpdateListener
{
  h(g paramg, j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    g.a(f, this.b);
    this.a.a(f, this.b, false);
    this.a.invalidateSelf();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */