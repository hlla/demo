package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ah
  implements Animation.AnimationListener
{
  private final Animation.AnimationListener a;
  
  ah(Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationRepeat(paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */