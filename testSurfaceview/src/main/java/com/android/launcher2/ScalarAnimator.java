package com.android.launcher2;

import android.os.SystemClock;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class ScalarAnimator
{
  private float mCurrent = 0.0F;
  private long mDefaultDuration = 0L;
  private long mDelay = 0L;
  private float mDelta = 0.0F;
  private long mDuration = 0L;
  private ScalarAnimatorListener mEndListener = null;
  private Interpolator mInterpolator;
  private float mInverseDuration;
  private boolean mIsRunning = false;
  private float mStart = 0.0F;
  private long mStartTime;
  private float mStop = 0.0F;
  
  public ScalarAnimator() {}
  
  public ScalarAnimator(long paramLong)
  {
    this.mDefaultDuration = paramLong;
  }
  
  public ScalarAnimator(long paramLong, float paramFloat)
  {
    this.mDefaultDuration = paramLong;
    this.mCurrent = paramFloat;
    this.mStart = paramFloat;
  }
  
  public ScalarAnimator(long paramLong, float paramFloat, Interpolator paramInterpolator)
  {
    this.mDefaultDuration = paramLong;
    this.mCurrent = paramFloat;
    this.mStart = paramFloat;
    this.mInterpolator = paramInterpolator;
  }
  
  public ScalarAnimator(long paramLong, Interpolator paramInterpolator)
  {
    this.mDefaultDuration = paramLong;
    this.mInterpolator = paramInterpolator;
  }
  
  public ScalarAnimator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  private void onEnd()
  {
    if (this.mEndListener != null) {
      this.mEndListener.run(this.mCurrent);
    }
  }
  
  public boolean abort()
  {
    return abort(this.mStop);
  }
  
  public boolean abort(float paramFloat)
  {
    boolean bool = isAnimating();
    this.mDuration = 0L;
    this.mStop = paramFloat;
    this.mCurrent = paramFloat;
    this.mIsRunning = false;
    return bool;
  }
  
  public void extend(float paramFloat, long paramLong)
  {
    if ((paramFloat != this.mStop) || (paramLong != 0L))
    {
      if (!this.mIsRunning) {
        start(this.mCurrent, paramFloat, paramLong);
      }
    }
    else {
      return;
    }
    this.mStop = paramFloat;
    this.mDelta = (this.mStop - this.mStart);
    this.mDuration += paramLong;
    if ((this.mDelta == 0.0F) || (this.mDuration <= 0L))
    {
      this.mDuration = 0L;
      return;
    }
    this.mInverseDuration = (1.0F / (float)this.mDuration);
  }
  
  public float get()
  {
    return get(AnimationUtils.currentAnimationTimeMillis());
  }
  
  public float get(long paramLong)
  {
    if (this.mIsRunning)
    {
      long l = paramLong - this.mStartTime - this.mDelay;
      paramLong = l;
      if (l <= 0L)
      {
        paramLong = 0L;
        this.mCurrent = this.mStart;
      }
      if (paramLong < this.mDuration) {
        break label71;
      }
      this.mIsRunning = false;
      this.mCurrent = this.mStop;
      onEnd();
    }
    for (;;)
    {
      return this.mCurrent;
      label71:
      if (paramLong > 0L)
      {
        float f2 = (float)paramLong * this.mInverseDuration;
        float f1 = f2;
        if (this.mInterpolator != null) {
          f1 = this.mInterpolator.getInterpolation(f2);
        }
        this.mCurrent = (this.mStart + this.mDelta * f1);
      }
    }
  }
  
  public float getFactor(long paramLong)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.mDuration > 0L)
    {
      f1 = f2;
      if (paramLong > this.mStartTime)
      {
        paramLong -= this.mStartTime;
        if (paramLong < this.mDuration) {
          break label70;
        }
      }
    }
    label70:
    for (f1 = 1.0F;; f1 = (float)paramLong * this.mInverseDuration)
    {
      f2 = f1;
      if (this.mInterpolator != null) {
        f2 = this.mInterpolator.getInterpolation(f1);
      }
      return f2;
    }
  }
  
  public float getRemaining()
  {
    return this.mStop - this.mCurrent;
  }
  
  public boolean isAnimating()
  {
    return this.mIsRunning;
  }
  
  public void setDefaultDuration(long paramLong)
  {
    this.mDefaultDuration = paramLong;
  }
  
  public void setEndListener(ScalarAnimatorListener paramScalarAnimatorListener)
  {
    this.mEndListener = paramScalarAnimatorListener;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void start(float paramFloat1, float paramFloat2)
  {
    start(paramFloat1, paramFloat2, this.mDefaultDuration);
  }
  
  public void start(float paramFloat1, float paramFloat2, long paramLong)
  {
    start(paramFloat1, paramFloat2, paramLong, 0L);
  }
  
  public void start(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    this.mDelay = paramLong2;
    this.mCurrent = paramFloat1;
    this.mStart = paramFloat1;
    this.mStop = paramFloat2;
    this.mDuration = paramLong1;
    this.mDelta = (this.mStop - this.mStart);
    if ((this.mDelta == 0.0F) || (this.mDuration <= 0L)) {
      this.mDuration = 0L;
    }
    for (;;)
    {
      this.mIsRunning = true;
      return;
      this.mInverseDuration = (1.0F / (float)this.mDuration);
      this.mStartTime = SystemClock.uptimeMillis();
    }
  }
  
  public void to(float paramFloat)
  {
    to(paramFloat, this.mDefaultDuration);
  }
  
  public void to(float paramFloat, long paramLong)
  {
    to(paramFloat, paramLong, 0L);
  }
  
  public void to(float paramFloat, long paramLong1, long paramLong2)
  {
    if ((paramFloat != this.mStop) && (paramFloat != this.mCurrent)) {
      start(this.mCurrent, paramFloat, paramLong1, paramLong2);
    }
    while ((paramFloat == this.mStop) || (!this.mIsRunning)) {
      return;
    }
    abort(paramFloat);
  }
  
  public static abstract interface ScalarAnimatorListener
  {
    public abstract void run(float paramFloat);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ScalarAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */