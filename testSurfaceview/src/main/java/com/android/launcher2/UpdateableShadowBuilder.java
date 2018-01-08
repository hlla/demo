package com.android.launcher2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.view.Surface;
import android.view.Surface.OutOfResourcesException;
import android.view.View;
import android.view.View.DragShadowBuilder;

abstract class UpdateableShadowBuilder
  extends View.DragShadowBuilder
{
  private Surface mSurface;
  
  public UpdateableShadowBuilder(View paramView)
  {
    super(paramView);
  }
  
  public void clear()
  {
    if (this.mSurface == null) {
      return;
    }
    try
    {
      Canvas localCanvas = this.mSurface.lockCanvas(null);
      return;
    }
    catch (Surface.OutOfResourcesException localOutOfResourcesException)
    {
      try
      {
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        return;
      }
      finally
      {
        this.mSurface.unlockCanvasAndPost(localOutOfResourcesException);
      }
      localOutOfResourcesException = localOutOfResourcesException;
      Log.w("UpdateableShadowBuilder", "Not enough memory to draw shadow");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w("UpdateableShadowBuilder", "Failed to draw shadow: " + localIllegalArgumentException);
    }
  }
  
  public void clearSurface()
  {
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
  }
  
  public void draw()
  {
    if (this.mSurface == null) {
      return;
    }
    try
    {
      Canvas localCanvas = this.mSurface.lockCanvas(null);
      return;
    }
    catch (Surface.OutOfResourcesException localOutOfResourcesException)
    {
      try
      {
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        onDrawShadow(localCanvas);
        return;
      }
      finally
      {
        this.mSurface.unlockCanvasAndPost(localOutOfResourcesException);
      }
      localOutOfResourcesException = localOutOfResourcesException;
      Log.w("UpdateableShadowBuilder", "Not enough memory to draw shadow");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w("UpdateableShadowBuilder", "Failed to draw shadow: " + localIllegalArgumentException);
    }
  }
  
  public abstract Paint getPaint();
  
  public void onDrawShadow(Canvas paramCanvas) {}
  
  public abstract void resetPaint();
  
  public void setSurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/UpdateableShadowBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */