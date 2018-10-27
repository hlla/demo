package com.google.android.finsky.bw;

import android.view.animation.Animation;

final class af
  extends c
{
  af(ae paramae) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a.a;
    if (paramAnimation != null) {
      paramAnimation.b();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */