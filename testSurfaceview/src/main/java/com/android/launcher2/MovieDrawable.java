package com.android.launcher2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;

public class MovieDrawable
  extends Drawable
{
  private static final int MAX_CYCLE_TIMES = 3;
  private int mAlpha;
  private Bitmap mBitmap;
  private final Canvas mCanvas;
  private int mCurrentCycle;
  private int mHeight;
  private final Movie mMovie;
  private boolean mNewFrame = true;
  private final Paint mPaint = new Paint();
  private int mRelTime;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      if ((MovieDrawable.this.mMovie.duration() == 0) || (MovieDrawable.this.mCurrentCycle >= 3))
      {
        MovieDrawable.this.unscheduleSelf(MovieDrawable.this.mRunnable);
        MovieDrawable.access$102(MovieDrawable.this, 0);
        MovieDrawable.access$302(MovieDrawable.this, 0L);
        return;
      }
      long l = AnimationUtils.currentAnimationTimeMillis();
      if (MovieDrawable.this.mStartTime == 0L) {
        MovieDrawable.access$302(MovieDrawable.this, l);
      }
      int i = (int)(l - MovieDrawable.this.mStartTime) % MovieDrawable.this.mMovie.duration();
      if (MovieDrawable.this.mMovie.setTime(i))
      {
        MovieDrawable.access$402(MovieDrawable.this, true);
        MovieDrawable.this.invalidateSelf();
        if (MovieDrawable.this.mRelTime <= i)
        {
          MovieDrawable.access$502(MovieDrawable.this, i);
          return;
        }
        MovieDrawable.access$502(MovieDrawable.this, 0);
        MovieDrawable.access$108(MovieDrawable.this);
        return;
      }
      MovieDrawable.this.scheduleSelf(MovieDrawable.this.mRunnable, 16L);
    }
  };
  private long mStartTime;
  private int mWidth;
  
  public MovieDrawable(Movie paramMovie)
  {
    this(paramMovie, paramMovie.width(), paramMovie.height());
  }
  
  public MovieDrawable(Movie paramMovie, int paramInt1, int paramInt2)
  {
    this.mMovie = paramMovie;
    this.mAlpha = 255;
    this.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.mCanvas = new Canvas(this.mBitmap);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setAntiAlias(true);
    updateBitmap();
  }
  
  private void updateBitmap()
  {
    this.mCanvas.save();
    float f1 = this.mBitmap.getHeight();
    float f4 = this.mBitmap.getWidth();
    float f2 = this.mMovie.height();
    float f5 = this.mMovie.width();
    float f3 = f1 / f2;
    this.mCanvas.scale(f3, f3);
    f4 = (f4 - f5 * f3) / 2.0F / f3;
    f1 = (f1 - f2 * f3) / 2.0F / f3;
    this.mCanvas.drawColor(-1);
    this.mMovie.draw(this.mCanvas, f4, f1);
    this.mCanvas.restore();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mAlpha == 0) {
      return;
    }
    Rect localRect = getBounds();
    if (this.mNewFrame)
    {
      this.mNewFrame = false;
      updateBitmap();
      scheduleSelf(this.mRunnable, 16L);
    }
    paramCanvas.drawBitmap(this.mBitmap, localRect.left, localRect.top, this.mPaint);
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
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
  
  public void pause()
  {
    unscheduleSelf(this.mRunnable);
  }
  
  public void resume()
  {
    scheduleSelf(this.mRunnable, 16L);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    this.mPaint.setAlpha(paramInt);
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


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MovieDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */