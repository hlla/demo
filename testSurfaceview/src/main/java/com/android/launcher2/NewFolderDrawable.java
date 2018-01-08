package com.android.launcher2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class NewFolderDrawable
  extends Drawable
{
  public static final Property<NewFolderDrawable, Float> OPEN_FACTOR = new Property(Float.class, "openFactor")
  {
    public Float get(NewFolderDrawable paramAnonymousNewFolderDrawable)
    {
      return Float.valueOf(paramAnonymousNewFolderDrawable.getOpenFactor());
    }
    
    public void set(NewFolderDrawable paramAnonymousNewFolderDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousNewFolderDrawable.setOpenFactor(paramAnonymousFloat.floatValue());
    }
  };
  public static final Property<NewFolderDrawable, Float> SCALE_FACTOR = new Property(Float.class, "scaleFactor")
  {
    public Float get(NewFolderDrawable paramAnonymousNewFolderDrawable)
    {
      return Float.valueOf(paramAnonymousNewFolderDrawable.getScaleFactor());
    }
    
    public void set(NewFolderDrawable paramAnonymousNewFolderDrawable, Float paramAnonymousFloat)
    {
      paramAnonymousNewFolderDrawable.setScaleFactor(paramAnonymousFloat.floatValue());
    }
  };
  private Drawable mBack;
  private Rect mBounds = new Rect();
  private Camera mCamera = new Camera();
  private Drawable mFront;
  private Matrix mMatrix = new Matrix();
  private Animator mOpenAnimator;
  private float mOpenFactor = 0.0F;
  private Rect mOriginalBounds = null;
  private Animator mScaleAnimator;
  private float mScaleFactor = 1.0F;
  private boolean mSelected = false;
  
  public NewFolderDrawable(Context paramContext, Drawable paramDrawable)
  {
    this.mFront = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null)) {
      this.mBack = paramContext.getResources().getDrawable(2130837796);
    }
  }
  
  private void drawPiece(Canvas paramCanvas, Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    this.mCamera.save();
    float f1 = this.mBounds.width() / 2.0F;
    float f2 = this.mBounds.height() / 2.0F;
    float f3 = paramDrawable.getBounds().height() * 0.77F - f2;
    this.mCamera.rotateY(this.mOpenFactor * paramFloat2);
    this.mCamera.translate(0.0F, -f3, 0.0F);
    this.mCamera.rotateX(this.mOpenFactor * paramFloat1);
    this.mCamera.translate(0.0F, f3, 0.0F);
    paramCanvas.save();
    this.mCamera.getMatrix(this.mMatrix);
    this.mMatrix.preTranslate(-f1, -f2);
    this.mMatrix.postTranslate(f1, f2);
    paramCanvas.concat(this.mMatrix);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
    this.mCamera.restore();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mSelected) {
      drawPiece(paramCanvas, this.mBack, 0.0F, 0.0F);
    }
    drawPiece(paramCanvas, this.mFront, -25.0F, -15.0F);
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
    this.mFront.setLevel(paramInt);
    this.mBack.setLevel(paramInt);
    if (this.mOpenAnimator != null) {
      this.mOpenAnimator.cancel();
    }
    return super.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mFront.setState(paramArrayOfInt);
    this.mBack.setState(paramArrayOfInt);
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
    if (this.mOpenAnimator != null) {
      this.mOpenAnimator.cancel();
    }
    if (this.mScaleAnimator != null) {
      this.mScaleAnimator.cancel();
    }
    if (bool)
    {
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, SCALE_FACTOR, new float[] { this.mScaleFactor, 1.15F });
      this.mScaleAnimator.setStartDelay(0L);
      this.mScaleAnimator.setDuration(100L);
      this.mOpenAnimator = ObjectAnimator.ofFloat(this, OPEN_FACTOR, new float[] { this.mOpenFactor, 1.0F });
      this.mOpenAnimator.setStartDelay(100L);
      this.mOpenAnimator.setDuration(250L);
    }
    for (;;)
    {
      this.mScaleAnimator.setInterpolator(new DecelerateInterpolator());
      this.mScaleAnimator.start();
      this.mOpenAnimator.setInterpolator(new DecelerateInterpolator());
      this.mOpenAnimator.start();
      return true;
      this.mOpenAnimator = ObjectAnimator.ofFloat(this, OPEN_FACTOR, new float[] { this.mOpenFactor, 0.0F });
      this.mOpenAnimator.setStartDelay(0L);
      this.mOpenAnimator.setDuration(167L);
      this.mScaleAnimator = ObjectAnimator.ofFloat(this, SCALE_FACTOR, new float[] { this.mScaleFactor, 1.0F });
      this.mScaleAnimator.setStartDelay(0L);
      this.mScaleAnimator.setDuration(167L);
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


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/NewFolderDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */