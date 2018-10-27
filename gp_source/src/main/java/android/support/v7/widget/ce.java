package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

final class ce
  implements ValueAnimator.AnimatorUpdateListener
{
  ce(ca paramca) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    this.a.m.setAlpha(i);
    this.a.o.setAlpha(i);
    this.a.f.invalidate();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */