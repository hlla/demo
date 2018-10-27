package com.google.android.finsky.d;

import android.graphics.Rect;
import com.google.android.finsky.bw.k;

final class j
{
  public final Rect a = new Rect();
  public final int[] b = new int[2];
  
  j(k paramk) {}
  
  static double a(Rect paramRect1, Rect paramRect2)
  {
    return Math.max(0, Math.min(paramRect1.right, paramRect2.right) - Math.max(paramRect1.left, paramRect2.left)) * Math.max(0, Math.min(paramRect1.bottom, paramRect2.bottom) - Math.max(paramRect1.top, paramRect2.top));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */