package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

final class cd
  extends AnimatorListenerAdapter
{
  private boolean a = false;
  
  cd(ca paramca) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a)
    {
      this.a = false;
      return;
    }
    if (((Float)this.b.j.getAnimatedValue()).floatValue() == 0.0F)
    {
      paramAnimator = this.b;
      paramAnimator.a = 0;
      paramAnimator.a(0);
      return;
    }
    paramAnimator = this.b;
    paramAnimator.a = 2;
    paramAnimator.f.invalidate();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */