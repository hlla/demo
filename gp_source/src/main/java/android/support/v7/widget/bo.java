package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class bo
  extends AnimatorListenerAdapter
{
  bo(bk parambk, fz paramfz, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setListener(null);
    this.d.setAlpha(1.0F);
    this.a.dispatchRemoveFinished(this.c);
    this.a.mRemoveAnimations.remove(this.c);
    this.a.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.dispatchRemoveStarting(this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */