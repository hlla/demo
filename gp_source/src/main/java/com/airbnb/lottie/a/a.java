package com.airbnb.lottie.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.i;
import java.util.List;

public class a
{
  public static final Interpolator a = new LinearInterpolator();
  public Float b;
  public final Object c;
  public final Interpolator d;
  public final float e;
  public final Object f;
  private final i g;
  private float h = Float.MIN_VALUE;
  private float i = Float.MIN_VALUE;
  
  public a(i parami, Object paramObject1, Object paramObject2, Interpolator paramInterpolator, float paramFloat, Float paramFloat1)
  {
    this.g = parami;
    this.f = paramObject1;
    this.c = paramObject2;
    this.d = paramInterpolator;
    this.e = paramFloat;
    this.b = paramFloat1;
  }
  
  public static void a(List paramList)
  {
    int m = paramList.size();
    int k;
    for (int j = 0;; j = k)
    {
      k = m - 1;
      if (j >= k) {
        break;
      }
      k = j + 1;
      ((a)paramList.get(j)).b = Float.valueOf(((a)paramList.get(k)).e);
    }
    a locala = (a)paramList.get(k);
    if (locala.f == null) {
      paramList.remove(locala);
    }
  }
  
  public final float a()
  {
    if (this.i == Float.MIN_VALUE)
    {
      float f1 = this.e;
      i locali = this.g;
      this.i = ((f1 - (float)locali.n) / locali.b());
    }
    return this.i;
  }
  
  public final boolean a(float paramFloat)
  {
    return (paramFloat >= a()) && (paramFloat <= b());
  }
  
  public final float b()
  {
    if (this.h == Float.MIN_VALUE) {
      if (this.b != null) {
        break label27;
      }
    }
    label27:
    for (this.h = 1.0F;; this.h = (a() + (this.b.floatValue() - this.e) / this.g.b())) {
      return this.h;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Keyframe{startValue=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", endValue=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", startFrame=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", endFrame=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", interpolator=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */