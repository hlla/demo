package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ap
  extends Animation
{
  ap(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a.g;
    int i = this.c;
    float f = i;
    paramTransformation.setAlpha((int)((this.b - i) * paramFloat + f));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */