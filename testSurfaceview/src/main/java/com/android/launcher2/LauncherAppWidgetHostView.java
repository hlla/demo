package com.android.launcher2;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public class LauncherAppWidgetHostView
  extends AppWidgetHostView
  implements DynamicShadowMixin.Holder
{
  private static boolean ENABLE_SHADOW = false;
  private final int[] lastSpanBitmap = new int[2];
  private Bitmap mBitmap;
  private boolean mHasPerformedLongPress;
  private LayoutInflater mInflater;
  final int[] mLastTouch = new int[2];
  private CheckForLongPress mPendingCheckForLongPress;
  private DynamicShadowMixin mShadowMixin;
  
  public LauncherAppWidgetHostView(Context paramContext)
  {
    super(paramContext);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    if (ENABLE_SHADOW) {
      this.mShadowMixin = new DynamicShadowMixin(this);
    }
  }
  
  private Bitmap getViewBitmap()
  {
    clearFocus();
    setPressed(false);
    boolean bool = willNotCacheDrawing();
    setWillNotCacheDrawing(false);
    int i = getDrawingCacheBackgroundColor();
    setDrawingCacheBackgroundColor(0);
    float f = getAlpha();
    setAlpha(1.0F);
    if (i != 0) {
      destroyDrawingCache();
    }
    buildDrawingCache();
    Bitmap localBitmap = getDrawingCache();
    if (localBitmap == null) {
      return null;
    }
    localBitmap = Bitmap.createBitmap(localBitmap);
    destroyDrawingCache();
    setAlpha(f);
    setWillNotCacheDrawing(bool);
    setDrawingCacheBackgroundColor(i);
    return localBitmap;
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
  
  public boolean bitmapNeedsUpdated(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((this.mBitmap == null) || (paramInt1 != this.lastSpanBitmap[0]) || (paramInt2 != this.lastSpanBitmap[1])) {
      bool = true;
    }
    return bool;
  }
  
  public void cancelLongPress()
  {
    super.cancelLongPress();
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress != null) {
      removeCallbacks(this.mPendingCheckForLongPress);
    }
  }
  
  public int getDescendantFocusability()
  {
    return 393216;
  }
  
  public DynamicShadowMixin getDynamicShadowMixin()
  {
    return this.mShadowMixin;
  }
  
  protected View getErrorView()
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
    paramRect = ((Launcher)getContext()).mHomeView.getWorkspace();
    if ((paramRect != null) && (paramRect.isInResizeMode())) {
      paramRect.invalidate();
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824);
    }
    paramInt1 = paramInt2;
    if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    super.onMeasure(i, paramInt1);
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
  
  public Bitmap updateBitmapForSpan(CellLayout paramCellLayout, int paramInt1, int paramInt2, ShadowBuilder paramShadowBuilder)
  {
    if (!bitmapNeedsUpdated(paramInt1, paramInt2)) {
      return this.mBitmap;
    }
    this.lastSpanBitmap[0] = paramInt1;
    this.lastSpanBitmap[1] = paramInt2;
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)getLayoutParams();
    int i = localLayoutParams.cellHSpan;
    int j = localLayoutParams.cellVSpan;
    localLayoutParams.cellHSpan = paramInt1;
    localLayoutParams.cellVSpan = paramInt2;
    paramCellLayout.getChildrenLayout().measureChild(this);
    paramInt1 = localLayoutParams.x;
    paramInt2 = localLayoutParams.y;
    layout(paramInt1, paramInt2, localLayoutParams.width + paramInt1, localLayoutParams.height + paramInt2);
    this.mBitmap = getViewBitmap();
    paramShadowBuilder.setBitmap(this.mBitmap);
    localLayoutParams.cellHSpan = i;
    localLayoutParams.cellVSpan = j;
    return this.mBitmap;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int mOriginalWindowAttachCount;
    
    CheckForLongPress() {}
    
    public void rememberWindowAttachCount()
    {
      this.mOriginalWindowAttachCount = LauncherAppWidgetHostView.this.getWindowAttachCount();
    }
    
    public void run()
    {
      if ((LauncherAppWidgetHostView.this.getParent() != null) && (LauncherAppWidgetHostView.this.hasWindowFocus()) && (this.mOriginalWindowAttachCount == LauncherAppWidgetHostView.this.getWindowAttachCount()) && (!LauncherAppWidgetHostView.this.mHasPerformedLongPress) && (LauncherAppWidgetHostView.this.performLongClick())) {
        LauncherAppWidgetHostView.access$102(LauncherAppWidgetHostView.this, true);
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherAppWidgetHostView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */