package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class br
  extends AnimatorListenerAdapter
{
  br(bk parambk, bt parambt, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.c.setListener(null);
    this.d.setAlpha(1.0F);
    this.d.setTranslationX(0.0F);
    this.d.setTranslationY(0.0F);
    this.a.dispatchChangeFinished(this.b.d, true);
    this.a.mChangeAnimations.remove(this.b.d);
    this.a.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.dispatchChangeStarting(this.b.d, true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */