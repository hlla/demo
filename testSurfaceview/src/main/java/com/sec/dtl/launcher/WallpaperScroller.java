package com.sec.dtl.launcher;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.IBinder;
import android.util.DisplayMetrics;
import com.android.launcher2.Utilities;

public class WallpaperScroller
{
  static final float SCALE = 2.0F;
  private final int TILT_WALLPAPER_OFFSET_DP = 10;
  GyroForShadow.VectorListener mGyroListener = new GyroForShadow.VectorListener()
  {
    public void onVectorChanged(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      WallpaperScroller.WallpaperThread.access$300(WallpaperScroller.this.mThread, -paramAnonymousFloat4 * WallpaperScroller.this.mThread.mBorder, 0.0F, WallpaperScroller.this.mScreenWidth, WallpaperScroller.this.mScreenHeight);
    }
  };
  private float mScreenHeight = 1.0F;
  private float mScreenWidth = 1.0F;
  private final WallpaperThread mThread;
  
  public WallpaperScroller(Context paramContext, IBinder paramIBinder)
  {
    WallpaperManager localWallpaperManager = WallpaperManager.getInstance(paramContext);
    Point localPoint = new Point();
    Utilities.getScreenSize(paramContext, localPoint);
    this.mScreenWidth = localPoint.x;
    this.mScreenHeight = localPoint.y;
    this.mThread = new WallpaperThread(localWallpaperManager, paramIBinder, 10.0F * paramContext.getResources().getDisplayMetrics().density);
    this.mThread.start();
    this.mThread.update(0.0F, 0.0F, this.mScreenWidth, this.mScreenHeight);
    GyroForShadow.registerListener(this.mGyroListener);
  }
  
  public void pause()
  {
    GyroForShadow.unregisterListener(this.mGyroListener);
  }
  
  public void resume()
  {
    GyroForShadow.registerListener(this.mGyroListener);
  }
  
  public void shutdown()
  {
    GyroForShadow.unregisterListener(this.mGyroListener);
    this.mThread.shutdown();
  }
  
  private static class WallpaperThread
    extends Thread
  {
    float mBorder;
    float mHeight;
    boolean mStop = false;
    IBinder mToken;
    private WallpaperManager mWallpaperManager;
    float mWidth;
    float mX;
    float mY;
    
    public WallpaperThread(WallpaperManager paramWallpaperManager, IBinder paramIBinder, float paramFloat)
    {
      super();
      this.mWallpaperManager = paramWallpaperManager;
      this.mToken = paramIBinder;
      this.mBorder = paramFloat;
    }
    
    private void shutdown()
    {
      try
      {
        this.mStop = true;
        notify();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void update(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      try
      {
        this.mX = (0.5F - paramFloat1 / (this.mBorder * 2.0F));
        this.mY = (0.5F - paramFloat2 / (this.mBorder * 2.0F));
        this.mWidth = paramFloat3;
        this.mHeight = paramFloat4;
        notify();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void run()
    {
      int m = 0;
      for (int k = 0;; k = n)
      {
        i = 0;
        n = 0;
        int j;
        if (m == 0) {
          j = i;
        }
        try
        {
          if (this.mWidth == 0.0F)
          {
            j = i;
            wait();
          }
          j = i;
          boolean bool = this.mStop;
          if (bool) {
            return;
          }
          j = i;
          i = (int)(this.mWidth + 2.0F * this.mBorder);
          j = i;
          float f = this.mHeight;
          n = (int)f;
          j = i;
          i = n;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
            i = n;
          }
        }
        finally {}
        if (j == m)
        {
          n = k;
          if (i == k) {}
        }
        else
        {
          m = j;
          n = i;
          this.mWallpaperManager.suggestDesiredDimensions(j, i);
        }
        this.mWallpaperManager.setWallpaperOffsets(this.mToken, this.mX, this.mY);
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/sec/dtl/launcher/WallpaperScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */