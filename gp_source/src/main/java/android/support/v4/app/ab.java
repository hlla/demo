package android.support.v4.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ab
  extends ah
{
  ab(z paramz, Animation.AnimationListener paramAnimationListener, ViewGroup paramViewGroup, Fragment paramFragment)
  {
    super(paramAnimationListener);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    this.c.post(new ac(this));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */