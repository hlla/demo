package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] At;
  private final float Au;
  
  public d(float[] paramArrayOfFloat)
  {
    this.At = paramArrayOfFloat;
    this.Au = (1.0F / (this.At.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.At.length - 1) * paramFloat), this.At.length - 2);
    paramFloat = (paramFloat - i * this.Au) / this.Au;
    float f = this.At[i];
    return (this.At[(i + 1)] - this.At[i]) * paramFloat + f;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */