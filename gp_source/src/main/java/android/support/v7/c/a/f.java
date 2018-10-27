package android.support.v7.c.a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

final class f
  implements TimeInterpolator
{
  public int a;
  private int[] b;
  private int c;
  
  f(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    int m = paramAnimationDrawable.getNumberOfFrames();
    this.c = m;
    int[] arrayOfInt = this.b;
    if ((arrayOfInt == null) || (arrayOfInt.length < m)) {
      this.b = new int[m];
    }
    arrayOfInt = this.b;
    int j = 0;
    if (i < m)
    {
      if (paramBoolean) {}
      for (int k = m - i - 1;; k = i)
      {
        k = paramAnimationDrawable.getDuration(k);
        arrayOfInt[i] = k;
        i += 1;
        j = k + j;
        break;
      }
    }
    this.a = j;
  }
  
  public final float getInterpolation(float paramFloat)
  {
    int i = (int)(this.a * paramFloat + 0.5F);
    int k = this.c;
    int[] arrayOfInt = this.b;
    int j = 0;
    while (j < k)
    {
      int m = arrayOfInt[j];
      if (i < m) {
        break;
      }
      j += 1;
      i -= m;
    }
    if (j < k) {}
    for (paramFloat = i / this.a;; paramFloat = 0.0F) {
      return paramFloat + j / k;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */