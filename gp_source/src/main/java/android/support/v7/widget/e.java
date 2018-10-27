package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class e
  extends AnimatorListenerAdapter
{
  e(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.c = null;
    paramAnimator.b = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.c = null;
    paramAnimator.b = false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */