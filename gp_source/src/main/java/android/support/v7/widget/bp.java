package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class bp
  extends AnimatorListenerAdapter
{
  bp(bk parambk, fz paramfz, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.d.setAlpha(1.0F);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setListener(null);
    this.a.dispatchAddFinished(this.c);
    this.a.mAddAnimations.remove(this.c);
    this.a.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.dispatchAddStarting(this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */