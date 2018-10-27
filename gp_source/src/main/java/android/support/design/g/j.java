package android.support.design.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class j
  extends AnimatorListenerAdapter
{
  j(h paramh, int paramInt) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = this.b;
    paramAnimator.c = 0.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */