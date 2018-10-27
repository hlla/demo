package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ar
  extends Animation
{
  ar(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a;
    boolean bool = paramTransformation.k;
    int i = paramTransformation.j;
    int j = Math.abs(paramTransformation.f);
    paramTransformation = this.a;
    int k = paramTransformation.c;
    int m = paramTransformation.a.getTop();
    this.a.a((int)((i - j - k) * paramFloat) + k - m);
    this.a.g.a(1.0F - paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */