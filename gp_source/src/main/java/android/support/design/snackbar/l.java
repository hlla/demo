package android.support.design.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.ac;

final class l
  implements ValueAnimator.AnimatorUpdateListener
{
  private int a = this.c;
  
  l(BaseTransientBottomBar paramBaseTransientBottomBar, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (BaseTransientBottomBar.a) {
      ac.e(this.b.i, i - this.a);
    }
    for (;;)
    {
      this.a = i;
      return;
      this.b.i.setTranslationY(i);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */