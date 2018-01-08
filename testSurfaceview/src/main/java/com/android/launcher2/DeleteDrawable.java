package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

public class DeleteDrawable
  extends Drawable
{
  private static final int SCALE_DURATION = 150;
  public static final Property<DeleteDrawable, Float> SCALE_FACTOR = new Property(Float.class, "scaleFactor")
  {
    public Float get(DeleteDrawable paramAnonymousDeleteDrawable)
    {
      return Float.valueOf(paramAnonymousDeleteDrawable.getScaleFactor());
    }
    
    public void set(DeleteDrawable paramAnonymousDeleteDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousDeleteDrawable.setScaleFactor(paramAnonymousFloat.floatValue());
    }
  };
  private final int kLidUpHeight = 2;
  private float mAngleDirection = 1.0F;
  private Rect mBounds = new Rect();
  private BulgeAnimationListener mBulgeAnimationListener;
  private int mBulgeFrameNumber = 0;
  private Drawable[] mBulgeFrames;
  private Context mContext;
  private Animator mCurrentAnimator;
  private boolean mIsAnimatingBulge = false;
  private boolean mIsAnimatingShake = false;
  private float mLidAngle = 0.0F;
  private int mLidOffsetY = 0;
  private Rect mOriginalBounds = null;
  private float mPreviousLidShakeValue = 0.0F;
  private Animator mScaleAnimator;
  private float mScaleFactor = 1.0F;
  private ArrayList<Animator> mShakeAnimators = new ArrayList(3);
  private Drawable mTrashBinOnly;
  private Drawable mTrashCan;
  private Drawable mTrashLidOnly;
  
  public DeleteDrawable(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, boolean paramBoolean, BulgeAnimationListener paramBulgeAnimationListener)
  {
    this.mContext = paramContext;
    this.mTrashCan = paramDrawable1;
    this.mTrashBinOnly = paramDrawable2;
    this.mTrashLidOnly = paramDrawable3;
    this.mBulgeFrames = new Drawable[6];
    paramContext = this.mContext.getResources();
    this.mBulgeFrames[0] = paramContext.getDrawable(2130837687);
    this.mBulgeFrames[1] = paramContext.getDrawable(2130837687);
    this.mBulgeFrames[2] = paramContext.getDrawable(2130837687);
    this.mBulgeFrames[3] = paramContext.getDrawable(2130837687);
    this.mBulgeFrames[4] = paramContext.getDrawable(2130837687);
    this.mBulgeFrames[5] = paramContext.getDrawable(2130837687);
    this.mBulgeAnimationListener = paramBulgeAnimationListener;
    initAnimations();
  }
  
  private void drawShakeAnimation(Canvas paramCanvas)
  {
    int i = getIntrinsicWidth();
    int j = getIntrinsicHeight();
    int k = (int)(i * 1.0F);
    int m = (int)(j * 1.0F);
    paramCanvas.save();
    paramCanvas.translate((float)(-(k - i) / 2.0D), (float)(-(m - j) / 2.0D));
    paramCanvas.scale(1.0F, 1.0F);
    this.mTrashBinOnly.draw(paramCanvas);
    paramCanvas.save();
    i = getIntrinsicWidth() / 2;
    j = this.mTrashLidOnly.getIntrinsicHeight() * 2 / 5;
    paramCanvas.rotate(this.mLidAngle, i, j - this.mLidOffsetY);
    paramCanvas.translate(0.0F, -this.mLidOffsetY);
    this.mTrashLidOnly.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  private void initAnimations()
  {
    Animator localAnimator1 = AnimatorInflater.loadAnimator(this.mContext, 2131034139);
    localAnimator1.setTarget(this);
    localAnimator1.setStartDelay(60L);
    Animator localAnimator2 = AnimatorInflater.loadAnimator(this.mContext, 2131034138);
    localAnimator2.setTarget(this);
    localAnimator2.setStartDelay(60L);
    Animator localAnimator3 = AnimatorInflater.loadAnimator(this.mContext, 2131034137);
    localAnimator3.setTarget(this);
    localAnimator3.setStartDelay(60L);
    this.mShakeAnimators.add(localAnimator1);
    this.mShakeAnimators.add(localAnimator2);
    this.mShakeAnimators.add(localAnimator3);
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
  
  private void startAnimator(int paramInt, long paramLong)
  {
    if (this.mCurrentAnimator != null) {
      this.mCurrentAnimator.cancel();
    }
    Animator localAnimator = AnimatorInflater.loadAnimator(this.mContext, paramInt);
    localAnimator.setTarget(this);
    localAnimator.setStartDelay(paramLong);
    if (paramInt == 2131034136) {
      localAnimator.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (DeleteDrawable.this.mBulgeAnimationListener != null) {
            DeleteDrawable.this.mBulgeAnimationListener.onBulgeAnimationEnded();
          }
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    localAnimator.start();
    this.mCurrentAnimator = localAnimator;
  }
  
  private void startBulgeAnimation()
  {
    if (this.mIsAnimatingShake) {
      stopCurrentAnimation();
    }
    if (!this.mIsAnimatingBulge)
    {
      this.mBulgeFrameNumber = 0;
      startAnimator(2131034136, 60L);
      this.mIsAnimatingBulge = true;
    }
  }
  
  private void startShakeAnimation()
  {
    if (this.mIsAnimatingBulge) {
      stopCurrentAnimation();
    }
    if (!this.mIsAnimatingShake)
    {
      this.mLidAngle = 0.0F;
      this.mLidOffsetY = 0;
      final AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(this.mShakeAnimators);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          DeleteDrawable.access$102(DeleteDrawable.this, true);
          DeleteDrawable.access$202(DeleteDrawable.this, localAnimatorSet);
        }
      });
      localAnimatorSet.setStartDelay(150L);
      localAnimatorSet.start();
    }
  }
  
  private void stopCurrentAnimation()
  {
    if ((this.mIsAnimatingBulge) || (this.mIsAnimatingShake))
    {
      this.mIsAnimatingShake = false;
      this.mIsAnimatingBulge = false;
      this.mCurrentAnimator.cancel();
      this.mCurrentAnimator = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.mIsAnimatingBulge) {
      this.mBulgeFrames[this.mBulgeFrameNumber].draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      if (this.mIsAnimatingShake) {
        drawShakeAnimation(paramCanvas);
      } else {
        this.mTrashCan.draw(paramCanvas);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mTrashCan.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mTrashCan.getIntrinsicWidth();
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
    return this.mTrashCan.isStateful();
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds.set(paramRect);
    this.mTrashCan.setBounds(paramRect);
    this.mTrashBinOnly.setBounds(paramRect);
    this.mTrashLidOnly.setBounds(paramRect);
    if (this.mBulgeFrames != null)
    {
      int i = 0;
      while (i < this.mBulgeFrames.length)
      {
        if (this.mBulgeFrames[i] != null) {
          this.mBulgeFrames[i].setBounds(paramRect);
        }
        i += 1;
      }
    }
    if (this.mOriginalBounds == null) {
      this.mOriginalBounds = new Rect(this.mBounds);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mTrashCan.setLevel(paramInt);
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mTrashCan.setState(paramArrayOfInt);
    int m = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    while (j < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[j] == 16842913) {
        m = 1;
      }
      if (paramArrayOfInt[j] == 16842910) {
        k = 1;
      }
      if (paramArrayOfInt[j] == 16843518) {
        i = 1;
      }
      j += 1;
    }
    if ((m != 0) && (k != 0))
    {
      j = 1;
      if ((i == 0) || (k == 0)) {
        break label113;
      }
      i = 1;
      label90:
      if ((i == 0) || (j == 0)) {
        break label118;
      }
      startBulgeAnimation();
    }
    for (;;)
    {
      invalidateSelf();
      return true;
      j = 0;
      break;
      label113:
      i = 0;
      break label90;
      label118:
      if (j != 0)
      {
        setScaleAnimation(true);
        startShakeAnimation();
      }
      else if (i == 0)
      {
        setScaleAnimation(false);
        stopCurrentAnimation();
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
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
  
  public void setTrashCanFill(float paramFloat)
  {
    this.mBulgeFrameNumber = Math.min((int)(paramFloat / (1.0F / (this.mBulgeFrames.length - 1))), this.mBulgeFrames.length - 1);
    if (paramFloat >= 1.0F) {
      this.mIsAnimatingBulge = false;
    }
    invalidateSelf();
  }
  
  public void setTrashCanLidDown(float paramFloat)
  {
    this.mLidOffsetY = ((int)(2.0F * (1.0F - paramFloat)));
    this.mLidAngle = 0.0F;
    invalidateSelf();
    if ((paramFloat >= 1.0F) && (this.mIsAnimatingShake))
    {
      this.mIsAnimatingShake = false;
      startShakeAnimation();
    }
  }
  
  public void setTrashCanLidShake(float paramFloat)
  {
    paramFloat *= 8.0F;
    float f1 = this.mLidAngle;
    float f2 = this.mPreviousLidShakeValue;
    this.mPreviousLidShakeValue = paramFloat;
    f1 += this.mAngleDirection * (paramFloat - f2) * 12.0F;
    if (f1 > 12.0F)
    {
      paramFloat = 12.0F - (f1 - 12.0F);
      this.mAngleDirection *= -1.0F;
    }
    for (;;)
    {
      this.mLidAngle = paramFloat;
      invalidateSelf();
      return;
      paramFloat = f1;
      if (f1 < -12.0F)
      {
        paramFloat = -12.0F - (f1 + 12.0F);
        this.mAngleDirection *= -1.0F;
      }
    }
  }
  
  public void setTrashCanLidUp(float paramFloat)
  {
    this.mLidOffsetY = ((int)(2.0F * paramFloat));
    invalidateSelf();
    if (paramFloat >= 1.0F)
    {
      this.mPreviousLidShakeValue = 0.0F;
      this.mAngleDirection = 1.0F;
    }
  }
  
  public static abstract interface BulgeAnimationListener
  {
    public abstract void onBulgeAnimationEnded();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DeleteDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */