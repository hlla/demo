package com.android.launcher2.mainmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.android.launcher2.Launcher;
import com.android.launcher2.MenuAppsGrid;

public class PinchLayerView
  extends FrameLayout
{
  private OnPinchListener mListener;
  private int mTouchPointDistance;
  
  public PinchLayerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PinchLayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PinchLayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.mListener != null) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    int i;
    int j;
    do
    {
      bool = false;
      View localView;
      do
      {
        return bool;
        if ((paramMotionEvent.getPointerCount() != 2) || (Launcher.isHelpAppRunning)) {
          break;
        }
        i = (int)(paramMotionEvent.getY() - paramMotionEvent.getY(1));
        j = (int)(paramMotionEvent.getX() - paramMotionEvent.getX(1));
        this.mTouchPointDistance = ((int)Math.sqrt(i * i + j * j));
        break;
        localView = getChildAt(0);
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
      } while ((localView != null) && ((localView instanceof MenuAppsGrid)) && (((MenuAppsGrid)localView).isScrollingState()));
      i = (int)(paramMotionEvent.getY() - paramMotionEvent.getY(1));
      j = (int)(paramMotionEvent.getX() - paramMotionEvent.getX(1));
    } while ((this.mTouchPointDistance - (int)Math.sqrt(i * i + j * j) <= 50) || (!this.mListener.onPinch()));
    return true;
  }
  
  public void setOnPinchListener(OnPinchListener paramOnPinchListener)
  {
    this.mListener = paramOnPinchListener;
  }
  
  public static abstract interface OnPinchListener
  {
    public abstract boolean onPinch();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/mainmenu/PinchLayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */