package com.google.android.finsky.bw;

import android.animation.TimeInterpolator;

final class ad
  implements TimeInterpolator
{
  ad(float paramFloat) {}
  
  public final float getInterpolation(float paramFloat)
  {
    return (1.0F - paramFloat) * this.a * (float)Math.sin((paramFloat + paramFloat) * 3.1415927F * 3.0F);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */