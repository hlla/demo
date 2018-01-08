package com.android.launcher2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class PagedViewGridLayout
  extends GridLayout
  implements Page
{
  private Runnable mBitmapLoaderRunnable;
  private int mCellCountX;
  private int mCellCountY;
  private int mPageType = 0;
  
  public PagedViewGridLayout(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, 0);
    this.mCellCountX = paramInt1;
    this.mCellCountY = paramInt2;
    this.mBitmapLoaderRunnable = null;
  }
  
  private void drawShadows(Canvas paramCanvas)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 0) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof PagedViewWidget))
        {
          paramCanvas.save();
          ((PagedViewWidget)localView).drawShadow(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
  }
  
  public void disableHardwareLayers()
  {
    if (getLayerType() != 0) {
      setLayerType(0, Launcher.sViewLayerPaint);
    }
  }
  
  public void enableHardwareLayers()
  {
    if (getLayerType() != 2) {
      setLayerType(2, Launcher.sViewLayerPaint);
    }
  }
  
  public Runnable getBitmapLoaderRunnable()
  {
    return this.mBitmapLoaderRunnable;
  }
  
  int getCellCountX()
  {
    return this.mCellCountX;
  }
  
  int getCellCountY()
  {
    return this.mCellCountY;
  }
  
  public View getChildOnPageAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  public int getPageItemCount()
  {
    return getChildCount();
  }
  
  public int getPageType()
  {
    return this.mPageType;
  }
  
  public int indexOfChildOnPage(View paramView)
  {
    return indexOfChild(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    int i = getPageItemCount();
    boolean bool1 = bool2;
    if (i > 0)
    {
      i = getChildOnPageAt(i - 1).getBottom();
      if ((bool2) || (paramMotionEvent.getY() < i)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void removeAllViewsOnPage()
  {
    removeAllViews();
    disableHardwareLayers();
  }
  
  public void removeViewOnPageAt(int paramInt)
  {
    removeViewAt(paramInt);
  }
  
  public void setAccessibilityEnabled(boolean paramBoolean)
  {
    int k = getChildCount();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      setImportantForAccessibility(i);
      int j = 0;
      while (j < k)
      {
        View localView = getChildAt(j);
        if (localView != null)
        {
          localView.setImportantForAccessibility(i);
          if ((localView instanceof PagedViewWidget))
          {
            ((PagedViewWidget)localView).getChildAt(0).setImportantForAccessibility(i);
            ((PagedViewWidget)localView).getChildAt(1).setImportantForAccessibility(i);
          }
        }
        j += 1;
      }
    }
  }
  
  public void setBitmapLoaderRunnable(Runnable paramRunnable)
  {
    this.mBitmapLoaderRunnable = paramRunnable;
  }
  
  public void setPageType(int paramInt)
  {
    this.mPageType = paramInt;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PagedViewGridLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */