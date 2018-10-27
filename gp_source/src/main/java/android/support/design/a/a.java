package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public final class a
{
  public static final TimeInterpolator a = new DecelerateInterpolator();
  public static final TimeInterpolator b;
  public static final TimeInterpolator c;
  public static final TimeInterpolator d = new LinearInterpolator();
  public static final TimeInterpolator e;
  
  static
  {
    c = new b();
    b = new android.support.v4.view.b.a();
    e = new c();
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */