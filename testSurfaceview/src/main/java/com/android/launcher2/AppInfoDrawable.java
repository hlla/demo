package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

public class AppInfoDrawable
  extends Drawable
{
  private static final int SCALE_DURATION = 150;
  public static final Property<AppInfoDrawable, Float> SCALE_FACTOR = new Property(Float.class, "scaleFactor")
  {
    public Float get(AppInfoDrawable paramAnonymousAppInfoDrawable)
    {
      return Float.valueOf(paramAnonymousAppInfoDrawable.getScaleFactor());
    }
    
    public void set(AppInfoDrawable paramAnonymousAppInfoDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousAppInfoDrawable.setScaleFactor(paramAnonymousFloat.floatValue());
    }
  };
  private Drawable mAppInfo;
  private Rect mBounds = new Rect();
  private Context mContext;
  private Animator mCurrentAnimator;
  private float mDirection = -1.0F;
  private boolean mIsAnimatingTranslate = false;
  private boolean mIsRepeat = false;
  private Rect mOriginalBounds = null;
  private float mPreviousTranslateValue = 0.0F;
  private Animator mScaleAnimator;
  private float mScaleFactor = 1.0F;
  private ArrayList<Animator> mTranslateAnimators = new ArrayList(2);
  private float mTranslateDy = 0.0F;
  
  public AppInfoDrawable(Context paramContext, Drawable paramDrawable)
  {
    this.mContext = paramContext;
    this.mAppInfo = paramDrawable;
    initAnimations();
  }
  
  private void initAnimations()
  {
    Animator localAnimator1 = AnimatorInflater.loadAnimator(this.mContext, 2131034115);
    localAnimator1.setTarget(this);
    Animator localAnimator2 = AnimatorInflater.loadAnimator(this.mContext, 2131034116);
    localAnimator2.setTarget(this);
    this.mTranslateAnimators.add(localAnimator1);
    this.mTranslateAnimators.add(localAnimator2);
  }
  
  private void setScaleAnimation(boolean paramBoolean)
  {
    if (this.mScaleAnimator != null) {
      this.mScaleAnimator.cancel();
    }
    Property localProperty = SCALE_FACTOR;
    if (paramBoolean) {}
    for (float f = 1.15F;; f = 1.0F)
    {
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, localProperty, new float[] { f });
      this.mScaleAnimator.setDuration(150L);
      this.mScaleAnimator.setInterpolator(new DecelerateInterpolator());
      this.mScaleAnimator.start();
      return;
    }
  }
  
  private void startTranslateAnimation()
  {
    final AnimatorSet localAnimatorSet;
    if (!this.mIsAnimatingTranslate)
    {
      this.mTranslateDy = 0.0F;
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(this.mTranslateAnimators);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppInfoDrawable.access$002(AppInfoDrawable.this, true);
          AppInfoDrawable.access$102(AppInfoDrawable.this, localAnimatorSet);
          AppInfoDrawable.access$202(AppInfoDrawable.this, true);
        }
      });
      if (this.mIsRepeat) {
        break label60;
      }
      localAnimatorSet.setStartDelay(150L);
    }
    for (;;)
    {
      localAnimatorSet.start();
      return;
      label60:
      localAnimatorSet.setStartDelay(300L);
    }
  }
  
  private void stopCurrentAnimation()
  {
    if (this.mIsAnimatingTranslate)
    {
      this.mIsAnimatingTranslate = false;
      this.mCurrentAnimator.cancel();
      this.mCurrentAnimator = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.mIsAnimatingTranslate)
    {
      paramCanvas.translate(0.0F, this.mTranslateDy);
      this.mAppInfo.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.mAppInfo.draw(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mAppInfo.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mAppInfo.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float getScaleFactor()
  {
    return this.mScaleFactor;
  }
  
  public boolean isStateful()
  {
    return this.mAppInfo.isStateful();
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds.set(paramRect);
    this.mAppInfo.setBounds(paramRect);
    if (this.mOriginalBounds == null) {
      this.mOriginalBounds = new Rect(this.mBounds);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mAppInfo.setLevel(paramInt);
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mAppInfo.setState(paramArrayOfInt);
    int k = 0;
    int j = 0;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == 16842913) {
        k = 1;
      }
      if (paramArrayOfInt[i] == 16842910) {
        j = 1;
      }
      i += 1;
    }
    if ((k != 0) && (j != 0))
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      this.mIsRepeat = false;
      setScaleAnimation(true);
      startTranslateAnimation();
    }
    for (;;)
    {
      invalidateSelf();
      return true;
      i = 0;
      break;
      label90:
      setScaleAnimation(false);
      stopCurrentAnimation();
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setCancelAppinfoDummy(float paramFloat)
  {
    invalidateSelf();
    if (paramFloat >= 1.0F)
    {
      this.mPreviousTranslateValue = 0.0F;
      this.mDirection = -1.0F;
    }
  }
  
  public void setCancelAppinfoTranslate(float paramFloat)
  {
    float f1 = paramFloat * 12.0F;
    float f2 = this.mTranslateDy;
    float f3 = this.mPreviousTranslateValue;
    this.mPreviousTranslateValue = f1;
    f1 = f2 + this.mDirection * (f1 - f3) * 5.0F;
    while ((f1 > 5.0F) || (f1 < -5.0F)) {
      if (f1 > 5.0F)
      {
        f1 = 5.0F - (f1 - 5.0F);
        this.mDirection *= -1.0F;
      }
      else if (f1 < -5.0F)
      {
        f1 = -5.0F - (f1 + 5.0F);
        this.mDirection *= -1.0F;
      }
    }
    this.mTranslateDy = f1;
    invalidateSelf();
    if ((paramFloat >= 1.0F) && (this.mIsAnimatingTranslate))
    {
      this.mIsAnimatingTranslate = false;
      startTranslateAnimation();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setScaleFactor(float paramFloat)
  {
    if (this.mOriginalBounds == null) {
      return;
    }
    this.mScaleFactor = paramFloat;
    int i = (int)(this.mOriginalBounds.right * (paramFloat - 1.0F) / 2.0F);
    int j = (int)(this.mOriginalBounds.bottom * (paramFloat - 1.0F) / 2.0F);
    this.mBounds.left = (this.mOriginalBounds.left - i);
    this.mBounds.top = (this.mOriginalBounds.top - j);
    this.mBounds.right = (this.mOriginalBounds.right + i);
    this.mBounds.bottom = (this.mOriginalBounds.bottom + j);
    setBounds(this.mBounds);
    if ((getCallback() != null) && ((getCallback() instanceof View)))
    {
      ((View)getCallback()).invalidate();
      return;
    }
    invalidateSelf();
  }
  
  public static abstract interface BulgeAnimationListener
  {
    public abstract void onBulgeAnimationEnded();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppInfoDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */