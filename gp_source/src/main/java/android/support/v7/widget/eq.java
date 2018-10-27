package android.support.v7.widget;

import android.view.animation.Interpolator;

final class eq
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    paramFloat = -1.0F + paramFloat;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */