package com.android.launcher2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class SamsungWidgetView
  extends FrameLayout
  implements DynamicShadowMixin.Holder
{
  private static boolean ENABLE_SHADOW = false;
  private boolean mHasPerformedLongPress;
  private LayoutInflater mInflater;
  final int[] mLastTouch = new int[2];
  private CheckForLongPress mPendingCheckForLongPress;
  private DynamicShadowMixin mShadowMixin;
  
  public SamsungWidgetView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SamsungWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    if (ENABLE_SHADOW) {
      this.mShadowMixin = new DynamicShadowMixin(this);
    }
  }
  
  private void postCheckForLongClick()
  {
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress == null) {
      this.mPendingCheckForLongPress = new CheckForLongPress();
    }
    this.mPendingCheckForLongPress.rememberWindowAttachCount();
    postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
  }
  
  public void cancelLongPress()
  {
    super.cancelLongPress();
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress != null) {
      removeCallbacks(this.mPendingCheckForLongPress);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {}
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {}
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void dumpSamsungWidgetAppInfo()
  {
    Object localObject = getTag();
    if ((localObject instanceof SamsungWidgetItem)) {
      Log.d("SamsungWidgetView", "" + localObject);
    }
  }
  
  public DynamicShadowMixin getDynamicShadowMixin()
  {
    return this.mShadowMixin;
  }
  
  public View getErrorView()
  {
    return this.mInflater.inflate(2130903044, this, false);
  }
  
  public int[] getLastTouchPoint()
  {
    return (int[])this.mLastTouch.clone();
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    if (this.mShadowMixin != null) {
      this.mShadowMixin.invalidate();
    }
    return paramArrayOfInt;
  }
  
  public boolean onInterceptHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getToolType(0);
    if (Settings.System.getInt(((Launcher)getContext()).getContentResolver(), "pen_hovering", 0) == 0) {
      return false;
    }
    return i == 2;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (Launcher.isHelpAppRunning) {
      return true;
    }
    if ((this.mHasPerformedLongPress) && (paramMotionEvent.getAction() != 2))
    {
      this.mHasPerformedLongPress = false;
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.mLastTouch[0] = ((int)paramMotionEvent.getX());
        this.mLastTouch[1] = ((int)paramMotionEvent.getY());
        postCheckForLongClick();
      }
      this.mHasPerformedLongPress = false;
      if (this.mPendingCheckForLongPress != null) {
        removeCallbacks(this.mPendingCheckForLongPress);
      }
    } while ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!Launcher.isHomeEditMode()));
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 0) && (!Launcher.isHelpAppRunning))
    {
      this.mLastTouch[0] = ((int)paramMotionEvent.getX());
      this.mLastTouch[1] = ((int)paramMotionEvent.getY());
    }
    while (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (Launcher.isHelpAppRunning)) {
      return bool;
    }
    cancelLongPress();
    return bool;
  }
  
  public void setLastTouchPoint(int paramInt1, int paramInt2)
  {
    this.mLastTouch[0] = paramInt1;
    this.mLastTouch[1] = paramInt2;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int mOriginalWindowAttachCount;
    
    CheckForLongPress() {}
    
    public void rememberWindowAttachCount()
    {
      this.mOriginalWindowAttachCount = SamsungWidgetView.this.getWindowAttachCount();
    }
    
    public void run()
    {
      if ((SamsungWidgetView.this.getParent() != null) && (SamsungWidgetView.this.hasWindowFocus()) && (this.mOriginalWindowAttachCount == SamsungWidgetView.this.getWindowAttachCount()) && (!SamsungWidgetView.this.mHasPerformedLongPress) && (SamsungWidgetView.this.performLongClick())) {
        SamsungWidgetView.access$102(SamsungWidgetView.this, true);
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SamsungWidgetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */