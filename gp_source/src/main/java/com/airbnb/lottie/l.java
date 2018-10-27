package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.d.c;

final class l
  implements ValueAnimator.AnimatorUpdateListener
{
  l(k paramk) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.a;
    d locald = paramValueAnimator.e;
    if (locald != null) {
      locald.a(paramValueAnimator.b.d);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */