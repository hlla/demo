package com.airbnb.lottie.d;

import android.animation.ValueAnimator;

public final class c
  extends ValueAnimator
{
  public boolean a = false;
  public float b = 1.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public boolean e = false;
  private long f;
  
  public c()
  {
    setFloatValues(new float[] { 0.0F, 1.0F });
    addListener(new d(this));
    addUpdateListener(new e(this));
  }
  
  public final void a(float paramFloat)
  {
    if (this.d != paramFloat) {
      b(paramFloat);
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    boolean bool = this.a;
    if (!bool) {}
    for (paramFloat2 = f1;; paramFloat2 = paramFloat1)
    {
      if (!bool) {}
      for (float f2 = paramFloat1;; f2 = f1)
      {
        setFloatValues(new float[] { paramFloat2, f2 });
        super.setDuration(((float)this.f * (paramFloat1 - f1)));
        a(this.d);
        return;
      }
    }
  }
  
  public final void b(float paramFloat)
  {
    float f1 = this.c;
    float f2;
    if (paramFloat >= f1)
    {
      f2 = this.b;
      f1 = paramFloat;
      if (paramFloat > f2) {
        f1 = f2;
      }
    }
    for (;;)
    {
      this.d = f1;
      if (getDuration() > 0L)
      {
        paramFloat = this.c;
        f2 = this.b;
        float f3 = (float)getDuration();
        setCurrentPlayTime(((f1 - paramFloat) / (f2 - paramFloat) * f3));
      }
      return;
    }
  }
  
  public final ValueAnimator setDuration(long paramLong)
  {
    this.f = paramLong;
    a(this.c, this.b);
    return this;
  }
  
  public final void start()
  {
    if (!this.e)
    {
      super.start();
      return;
    }
    a(this.b);
    end();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */