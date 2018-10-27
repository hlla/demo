package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ao
  extends Animation
{
  ao(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.a.a(1.0F - paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */