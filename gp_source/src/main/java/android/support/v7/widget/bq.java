package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class bq
  extends AnimatorListenerAdapter
{
  bq(bk parambk, fz paramfz, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.c != 0) {
      this.f.setTranslationX(0.0F);
    }
    if (this.d != 0) {
      this.f.setTranslationY(0.0F);
    }
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setListener(null);
    this.a.dispatchMoveFinished(this.e);
    this.a.mMoveAnimations.remove(this.e);
    this.a.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.dispatchMoveStarting(this.e);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */