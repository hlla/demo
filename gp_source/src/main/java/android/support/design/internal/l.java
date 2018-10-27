package android.support.design.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class l
  extends AnimatorListenerAdapter
{
  l(k paramk) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    k localk = this.a;
    if (localk.b == paramAnimator) {
      localk.b = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */