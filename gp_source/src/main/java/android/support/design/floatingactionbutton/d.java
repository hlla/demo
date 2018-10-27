package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.internal.p;

final class d
  extends AnimatorListenerAdapter
{
  d(b paramb, i parami) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.h = 0;
    paramAnimator.k = null;
    paramAnimator = this.c;
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.z.a(0, false);
    b localb = this.a;
    localb.h = 2;
    localb.k = paramAnimator;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */