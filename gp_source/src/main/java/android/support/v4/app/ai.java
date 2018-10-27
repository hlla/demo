package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

final class ai
{
  public final Animation a;
  public final Animator b;
  
  ai(Animator paramAnimator)
  {
    this.a = null;
    this.b = paramAnimator;
    if (paramAnimator == null) {
      throw new IllegalStateException("Animator cannot be null");
    }
  }
  
  ai(Animation paramAnimation)
  {
    this.a = paramAnimation;
    this.b = null;
    if (paramAnimation == null) {
      throw new IllegalStateException("Animation cannot be null");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */