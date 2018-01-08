package com.android.launcher2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class FastBitmapDrawable
  extends Drawable
{
  private int mAlpha;
  private Bitmap mBitmap;
  private int mHeight;
  private final Paint mPaint = new Paint();
  private int mWidth;
  
  public FastBitmapDrawable(Bitmap paramBitmap)
  {
    ensureBitmapIntegrity("FastBitmapDrawable Constructor", paramBitmap);
    this.mAlpha = 255;
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.mWidth = this.mBitmap.getWidth();
      this.mHeight = this.mBitmap.getHeight();
    }
    for (;;)
    {
      this.mPaint.setFilterBitmap(true);
      this.mPaint.setAntiAlias(true);
      return;
      this.mHeight = 0;
      this.mWidth = 0;
    }
  }
  
  private void ensureBitmapIntegrity(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("NULL bitmap, this: " + this + " msg: " + paramString);
    }
    if (paramBitmap.isRecycled()) {
      throw new IllegalArgumentException("Recycled bitmap bmp: " + paramBitmap + " this: " + this + " msg: " + paramString);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mAlpha == 0) {}
    do
    {
      return;
      ensureBitmapIntegrity("FastBitmapDrawable draw", this.mBitmap);
    } while ((this.mBitmap == null) || (this.mBitmap.isRecycled()));
    Rect localRect = getBounds();
    paramCanvas.drawBitmap(this.mBitmap, localRect.left, localRect.top, this.mPaint);
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getMinimumHeight()
  {
    return this.mHeight;
  }
  
  public int getMinimumWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    ensureBitmapIntegrity("FastBitmapDrawable setBitmap", paramBitmap);
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.mWidth = this.mBitmap.getWidth();
      this.mHeight = this.mBitmap.getHeight();
      return;
    }
    this.mHeight = 0;
    this.mWidth = 0;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FastBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */