package com.airbnb.lottie.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class d
  extends AnimatorListenerAdapter
{
  d(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.a(paramAnimator.c, paramAnimator.b);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.a(paramAnimator.c, paramAnimator.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */