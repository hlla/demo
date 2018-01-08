package com.android.launcher2;

import android.animation.Animator;
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

public class NewPageDrawable
  extends Drawable
{
  private static final int DURATION = 200;
  public static final Property<NewPageDrawable, Float> OPEN_FACTOR = new Property(Float.class, "openFactor")
  {
    public Float get(NewPageDrawable paramAnonymousNewPageDrawable)
    {
      return Float.valueOf(paramAnonymousNewPageDrawable.getOpenFactor());
    }
    
    public void set(NewPageDrawable paramAnonymousNewPageDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousNewPageDrawable.setOpenFactor(paramAnonymousFloat.floatValue());
    }
  };
  public static final Property<NewPageDrawable, Float> SCALE_FACTOR = new Property(Float.class, "scaleFactor")
  {
    public Float get(NewPageDrawable paramAnonymousNewPageDrawable)
    {
      return Float.valueOf(paramAnonymousNewPageDrawable.getScaleFactor());
    }
    
    public void set(NewPageDrawable paramAnonymousNewPageDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousNewPageDrawable.setScaleFactor(paramAnonymousFloat.floatValue());
    }
  };
  private Drawable mBack;
  private Rect mBounds = new Rect();
  private Drawable mFront;
  private Animator mOpenAnimator;
  private float mOpenFactor = 0.0F;
  private Rect mOriginalBounds = null;
  private Animator mScaleAnimator;
  private float mScaleFactor = 1.0F;
  private boolean mSelected = false;
  
  public NewPageDrawable(Context paramContext, Drawable paramDrawable)
  {
    this.mFront = paramDrawable;
    this.mBack = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null)) {
      this.mBack = paramContext.getResources().getDrawable(2130837801);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mSelected)
    {
      paramCanvas.save();
      paramCanvas.translate(this.mFront.getBounds().width() * 0.05F * this.mOpenFactor, this.mFront.getBounds().height() * 0.05F * this.mOpenFactor);
      this.mBack.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas.save();
    paramCanvas.translate(this.mFront.getBounds().width() * -0.05F * this.mOpenFactor, this.mFront.getBounds().height() * -0.05F * this.mOpenFactor);
    this.mFront.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mFront.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mFront.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float getOpenFactor()
  {
    return this.mOpenFactor;
  }
  
  public float getScaleFactor()
  {
    return this.mScaleFactor;
  }
  
  public boolean isStateful()
  {
    return this.mFront.isStateful();
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds.set(paramRect);
    this.mFront.setBounds(paramRect);
    this.mBack.setBounds(paramRect);
    if (this.mOriginalBounds == null) {
      this.mOriginalBounds = new Rect(this.mBounds);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    float f2 = 1.0F;
    this.mFront.setLevel(paramInt);
    this.mBack.setLevel(paramInt);
    if (this.mOpenAnimator != null) {
      this.mOpenAnimator.cancel();
    }
    Property localProperty = OPEN_FACTOR;
    if (paramInt == 1) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      this.mOpenAnimator = ObjectAnimator.ofFloat(this, localProperty, new float[] { f1 });
      this.mOpenAnimator.setDuration(200L);
      this.mOpenAnimator.setInterpolator(new DecelerateInterpolator());
      if (this.mScaleAnimator != null) {
        this.mScaleAnimator.cancel();
      }
      localProperty = SCALE_FACTOR;
      f1 = f2;
      if (paramInt == 1) {
        f1 = 1.15F;
      }
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, localProperty, new float[] { f1 });
      this.mScaleAnimator.setDuration(200L);
      this.mScaleAnimator.setInterpolator(new DecelerateInterpolator());
      this.mOpenAnimator.start();
      this.mScaleAnimator.start();
      return true;
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    float f2 = 1.0F;
    this.mFront.setState(paramArrayOfInt);
    this.mBack.setState(paramArrayOfInt);
    if (this.mOpenAnimator != null) {
      this.mOpenAnimator.cancel();
    }
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
    if ((k != 0) && (j != 0)) {}
    for (boolean bool = true; bool == this.mSelected; bool = false) {
      return true;
    }
    this.mSelected = bool;
    paramArrayOfInt = OPEN_FACTOR;
    if (bool) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      this.mOpenAnimator = ObjectAnimator.ofFloat(this, paramArrayOfInt, new float[] { f1 });
      this.mOpenAnimator.setDuration(200L);
      this.mOpenAnimator.setInterpolator(new DecelerateInterpolator());
      paramArrayOfInt = SCALE_FACTOR;
      f1 = f2;
      if (bool) {
        f1 = 1.15F;
      }
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, paramArrayOfInt, new float[] { f1 });
      this.mScaleAnimator.setDuration(200L);
      this.mScaleAnimator.setInterpolator(new DecelerateInterpolator());
      this.mOpenAnimator.start();
      this.mScaleAnimator.start();
      return true;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setOpenFactor(float paramFloat)
  {
    this.mOpenFactor = paramFloat;
    invalidateSelf();
  }
  
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
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/NewPageDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */