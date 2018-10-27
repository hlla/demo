package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class e
  implements Interpolator
{
  private final float[] a;
  private final float[] b;
  
  public e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(localPath);
  }
  
  private e(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.a = new float[j];
    this.b = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.a[i] = arrayOfFloat[0];
      this.b[i] = arrayOfFloat[1];
      i += 1;
    }
  }
  
  public final float getInterpolation(float paramFloat)
  {
    float f1 = 1.0F;
    if (paramFloat > 0.0F)
    {
      int j;
      int i;
      if (paramFloat < 1.0F)
      {
        j = this.a.length - 1;
        i = 0;
      }
      for (;;)
      {
        if (j - i <= 1)
        {
          float[] arrayOfFloat = this.a;
          float f2 = arrayOfFloat[j];
          f1 = arrayOfFloat[i];
          float f3 = f2 - f1;
          if (f3 == 0.0F)
          {
            f1 = this.b[i];
            return f1;
          }
          arrayOfFloat = this.b;
          f2 = arrayOfFloat[i];
          paramFloat = (paramFloat - f1) / f3;
          return (arrayOfFloat[j] - f2) * paramFloat + f2;
        }
        int k = (i + j) / 2;
        f1 = this.a[k];
        int m = j;
        if (paramFloat < f1) {
          m = k;
        }
        j = m;
        if (paramFloat >= f1)
        {
          i = k;
          j = m;
        }
      }
    }
    return 0.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */