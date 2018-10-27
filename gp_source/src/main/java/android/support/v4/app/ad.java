package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class ad
  extends AnimatorListenerAdapter
{
  ad(z paramz, ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.endViewTransition(this.d);
    paramAnimator = this.c.N();
    this.c.a(null);
    if ((paramAnimator != null) && (this.b.indexOfChild(this.d) < 0))
    {
      paramAnimator = this.a;
      Fragment localFragment = this.c;
      paramAnimator.a(localFragment, localFragment.O(), 0, 0, false);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */