package android.support.design.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.a.a;

final class i
  implements ValueAnimator.AnimatorUpdateListener
{
  i(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    this.a.a(a.a(this.d, this.b, f), a.a(this.e, this.c, f));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */