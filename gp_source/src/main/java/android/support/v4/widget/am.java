package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class am
  implements Animation.AnimationListener
{
  am(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    if (paramAnimation.h)
    {
      paramAnimation.g.setAlpha(255);
      this.a.g.start();
      paramAnimation = this.a;
      if (paramAnimation.e)
      {
        paramAnimation = paramAnimation.d;
        if (paramAnimation != null) {
          paramAnimation.a();
        }
      }
      paramAnimation = this.a;
      paramAnimation.b = paramAnimation.a.getTop();
      return;
    }
    paramAnimation.a();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */