package android.support.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class ac
  extends AnimatorListenerAdapter
{
  ac(z paramz) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.a.e();
    paramAnimator.removeListener(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */