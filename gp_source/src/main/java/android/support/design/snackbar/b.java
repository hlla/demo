package android.support.design.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class b
  extends AnimatorListenerAdapter
{
  b(BaseTransientBottomBar paramBaseTransientBottomBar, int paramInt) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b(this.b);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.c.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */