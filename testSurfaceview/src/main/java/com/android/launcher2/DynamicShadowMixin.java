package com.android.launcher2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

class DynamicShadowMixin
{
  private Bitmap mBitmap = null;
  private Canvas mCanvas = new Canvas();
  private Rect mDestRect = new Rect();
  private Paint mPaint = new Paint();
  private boolean mShadowBitmapDirty = true;
  private final int mShadowBorder;
  private final int mShadowOffset;
  private Rect mSourceRect = new Rect();
  private View mView;
  private View mViewToInvalidateOnShadowDirty = null;
  private float mWidgetShadowAlphaWeight = 1.0F;
  
  static
  {
    System.loadLibrary("drawglfunction");
  }
  
  public DynamicShadowMixin(View paramView)
  {
    Resources localResources = paramView.getResources();
    this.mView = paramView;
    this.mShadowOffset = localResources.getDimensionPixelSize(2131623946);
    this.mShadowBorder = localResources.getDimensionPixelSize(2131623947);
    this.mWidgetShadowAlphaWeight = localResources.getFraction(2131558409, 1, 1);
  }
  
  private int align4(int paramInt)
  {
    return paramInt + 3 & 0xFFFFFFFC;
  }
  
  public static native boolean nGaussianBlur(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public void draw(Canvas paramCanvas)
  {
    View localView = this.mView;
    if (paramCanvas.quickReject(0.0F, 0.0F, localView.getWidth(), localView.getHeight(), Canvas.EdgeType.AA)) {
      return;
    }
    float f = this.mView.getAlpha();
    if (this.mShadowBitmapDirty)
    {
      int i = align4(localView.getWidth() / 2 + this.mShadowBorder * 2);
      int j = align4(localView.getHeight() / 2 + this.mShadowBorder * 2);
      if ((this.mBitmap == null) || (this.mBitmap.getWidth() != i) || (this.mBitmap.getHeight() != j))
      {
        this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ALPHA_8);
        this.mCanvas = new Canvas(this.mBitmap);
      }
      Bitmap localBitmap = this.mBitmap;
      localBitmap.eraseColor(0);
      this.mCanvas.save();
      this.mCanvas.clipRect(this.mShadowBorder, this.mShadowBorder, localBitmap.getWidth() - this.mShadowBorder, localBitmap.getHeight() - this.mShadowBorder);
      this.mCanvas.translate(localView.getScrollX(), localView.getScrollY());
      this.mCanvas.translate(this.mShadowBorder, this.mShadowBorder);
      this.mCanvas.scale(0.5F, 0.5F);
      this.mView.setAlpha(1.0F);
      this.mView.draw(this.mCanvas);
      this.mView.setAlpha(f);
      this.mCanvas.restore();
      nGaussianBlur(localBitmap, localBitmap);
      this.mSourceRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.mDestRect.set(-this.mShadowBorder * 2, this.mShadowOffset - this.mShadowBorder * 2, localView.getWidth() + this.mShadowBorder * 2, localView.getHeight() + this.mShadowOffset + this.mShadowBorder * 2);
      this.mShadowBitmapDirty = false;
    }
    this.mPaint.setAlpha((int)(150.0F * f * this.mWidgetShadowAlphaWeight));
    paramCanvas.drawBitmap(this.mBitmap, this.mSourceRect, this.mDestRect, this.mPaint);
  }
  
  public void invalidate()
  {
    this.mShadowBitmapDirty = true;
    if (this.mViewToInvalidateOnShadowDirty != null) {
      this.mViewToInvalidateOnShadowDirty.invalidate();
    }
  }
  
  public void setViewToInvalidate(View paramView)
  {
    this.mViewToInvalidateOnShadowDirty = paramView;
  }
  
  public static abstract interface Holder
  {
    public abstract DynamicShadowMixin getDynamicShadowMixin();
    
    public abstract int[] getLastTouchPoint();
    
    public abstract void setLastTouchPoint(int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DynamicShadowMixin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */