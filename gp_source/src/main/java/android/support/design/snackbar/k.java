package android.support.design.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class k
  extends AnimatorListenerAdapter
{
  k(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.a.i();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.c.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */