package com.airbnb.lottie.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class e
  implements ValueAnimator.AnimatorUpdateListener
{
  e(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    c localc = this.a;
    if (!localc.e) {
      localc.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */