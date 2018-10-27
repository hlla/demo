package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class bs
  extends AnimatorListenerAdapter
{
  bs(bk parambk, bt parambt, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.d.setListener(null);
    this.c.setAlpha(1.0F);
    this.c.setTranslationX(0.0F);
    this.c.setTranslationY(0.0F);
    this.a.dispatchChangeFinished(this.b.c, false);
    this.a.mChangeAnimations.remove(this.b.c);
    this.a.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.dispatchChangeStarting(this.b.c, false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */