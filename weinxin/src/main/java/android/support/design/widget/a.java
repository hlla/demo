package android.support.design.widget;

import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

final class a
{
  static final Interpolator es = new LinearInterpolator();
  static final Interpolator et = new b();
  static final Interpolator eu = new android.support.v4.view.b.a();
  static final Interpolator ev = new c();
  static final Interpolator ew = new DecelerateInterpolator();
  
  static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */