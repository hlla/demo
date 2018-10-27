package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ba
  extends AnimatorListenerAdapter
{
  ba(bc parambc, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b();
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a(this.b);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */