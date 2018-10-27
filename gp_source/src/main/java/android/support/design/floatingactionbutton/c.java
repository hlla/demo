package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.internal.p;

final class c
  extends AnimatorListenerAdapter
{
  private boolean a;
  
  c(b paramb, i parami) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    paramAnimator.h = 0;
    paramAnimator.k = null;
    if (!this.a)
    {
      paramAnimator.z.a(4, false);
      paramAnimator = this.d;
      if (paramAnimator != null) {
        paramAnimator.b();
      }
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.b.z.a(0, false);
    b localb = this.b;
    localb.h = 1;
    localb.k = paramAnimator;
    this.a = false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */