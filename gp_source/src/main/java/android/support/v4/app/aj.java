package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class aj
  extends AnimatorListenerAdapter
{
  private View a;
  
  aj(View paramView)
  {
    this.a = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
    paramAnimator.removeListener(this);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.setLayerType(2, null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */