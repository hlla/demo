package android.support.design.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.internal.e;

final class h
  implements ValueAnimator.AnimatorUpdateListener
{
  h(TextInputLayout paramTextInputLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.a(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */