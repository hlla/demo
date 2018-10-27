package android.support.v4.view.b;

import android.view.animation.Interpolator;

class d
  implements Interpolator
{
  private final float a;
  private final float[] b;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.b = paramArrayOfFloat;
    this.a = (1.0F / (this.b.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f1 = 0.0F;
    if (paramFloat < 1.0F)
    {
      if (paramFloat > 0.0F)
      {
        int i = this.b.length;
        i = Math.min((int)((i - 1) * paramFloat), i - 2);
        float f2 = this.a;
        float[] arrayOfFloat = this.b;
        f1 = arrayOfFloat[i];
        paramFloat = (paramFloat - i * f2) / f2;
        f1 = (arrayOfFloat[(i + 1)] - f1) * paramFloat + f1;
      }
      return f1;
    }
    return 1.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */