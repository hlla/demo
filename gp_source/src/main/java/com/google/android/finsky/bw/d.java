package com.google.android.finsky.bw;

public final class d
{
  public static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.max(Math.round(paramInt2 / paramInt1 - paramFloat), 3) + paramFloat;
  }
  
  public static int b(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round(paramInt2 / a(paramInt1, paramInt2, paramFloat));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */