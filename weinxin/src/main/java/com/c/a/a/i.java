package com.c.a.a;

import android.location.Location;

final class i
{
  static i aJP;
  double aJQ;
  double aJR;
  float aJS;
  float aJT;
  float aJU;
  float aJV;
  float aJW;
  float aJX;
  boolean aJY = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d = -1.0E-5D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d, arrayOfFloat);
      this.aJX = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label119;
      }
    }
    label119:
    for (double d = -1.0E-5D;; d = 1.0E-5D)
    {
      Location.distanceBetween(d + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.aJW = arrayOfFloat[0];
      this.aJQ = paramDouble1;
      this.aJR = paramDouble2;
      this.aJS = paramFloat2;
      this.aJT = paramFloat3;
      this.aJV = paramFloat1;
      this.aJU = paramFloat4;
      this.aJY = true;
      return;
      d = 1.0E-5D;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */