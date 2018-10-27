package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class aq
  implements Animation.AnimationListener
{
  aq(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    boolean bool = paramAnimation.i;
    paramAnimation.a(null);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */