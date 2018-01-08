package com.android.launcher2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class AddToPersonalDrawable
  extends Drawable
{
  public static final Property<AddToPersonalDrawable, Float> SCALE_FACTOR = new Property(Float.class, "scaleFactor")
  {
    public Float get(AddToPersonalDrawable paramAnonymousAddToPersonalDrawable)
    {
      return Float.valueOf(paramAnonymousAddToPersonalDrawable.getScaleFactor());
    }
    
    public void set(AddToPersonalDrawable paramAnonymousAddToPersonalDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousAddToPersonalDrawable.setScaleFactor(paramAnonymousFloat.floatValue());
    }
  };
  private Drawable mAddToPersonal;
  private Rect mBounds = new Rect();
  private Rect mOriginalBounds = null;
  private Animator mScaleAnimator;
  private float mScaleFactor = 1.0F;
  
  public AddToPersonalDrawable(Drawable paramDrawable)
  {
    this.mAddToPersonal = paramDrawable;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mAddToPersonal.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return this.mAddToPersonal.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mAddToPersonal.getIntrinsicWidth();
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
    return this.mAddToPersonal.isStateful();
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds.set(paramRect);
    this.mAddToPersonal.setBounds(paramRect);
    if (this.mOriginalBounds == null) {
      this.mOriginalBounds = new Rect(this.mBounds);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mAddToPersonal.setLevel(paramInt);
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mAddToPersonal.setState(paramArrayOfInt);
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
        break label138;
      }
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, SCALE_FACTOR, new float[] { this.mScaleFactor, 1.15F });
      this.mScaleAnimator.setStartDelay(0L);
      this.mScaleAnimator.setDuration(160L);
    }
    for (;;)
    {
      this.mScaleAnimator.setInterpolator(new DecelerateInterpolator());
      this.mScaleAnimator.start();
      return true;
      i = 0;
      break;
      label138:
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, SCALE_FACTOR, new float[] { this.mScaleFactor, 1.0F });
      this.mScaleAnimator.setStartDelay(0L);
      this.mScaleAnimator.setDuration(160L);
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
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AddToPersonalDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */