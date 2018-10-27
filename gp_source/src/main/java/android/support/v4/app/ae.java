package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class ae
  extends AnimatorListenerAdapter
{
  ae(ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.endViewTransition(this.a);
    paramAnimator.removeListener(this);
    paramAnimator = this.c.U;
    if (paramAnimator != null) {
      paramAnimator.setVisibility(8);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */