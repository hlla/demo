package com.airbnb.lottie.d;

public final class a
{
  private static float a(float paramFloat)
  {
    if (paramFloat > 0.0031308F) {
      return (float)(Math.pow(paramFloat, 0.4166666567325592D) * 1.0549999475479126D - 0.054999999701976776D);
    }
    return 12.92F * paramFloat;
  }
  
  public static int a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = (paramInt1 >> 24 & 0xFF) / 255.0F;
    float f6 = b((paramInt1 >> 16 & 0xFF) / 255.0F);
    float f4 = b((paramInt1 >> 8 & 0xFF) / 255.0F);
    float f2 = b((paramInt1 & 0xFF) / 255.0F);
    float f7 = b((paramInt2 >> 16 & 0xFF) / 255.0F);
    float f5 = b((paramInt2 >> 8 & 0xFF) / 255.0F);
    float f3 = b((paramInt2 & 0xFF) / 255.0F);
    f6 = a(f6 + (f7 - f6) * paramFloat);
    f4 = a(f4 + (f5 - f4) * paramFloat);
    f2 = a(f2 + (f3 - f2) * paramFloat);
    return Math.round((f1 + ((paramInt2 >> 24 & 0xFF) / 255.0F - f1) * paramFloat) * 255.0F) << 24 | Math.round(f6 * 255.0F) << 16 | Math.round(f4 * 255.0F) << 8 | Math.round(f2 * 255.0F);
  }
  
  private static float b(float paramFloat)
  {
    if (paramFloat > 0.04045F) {
      return (float)Math.pow((0.055F + paramFloat) / 1.055F, 2.4000000953674316D);
    }
    return paramFloat / 12.92F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */