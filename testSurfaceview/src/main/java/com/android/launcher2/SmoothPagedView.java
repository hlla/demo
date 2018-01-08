package com.android.launcher2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public abstract class SmoothPagedView
  extends PagedView
{
  static final int DEFAULT_MODE = 0;
  private static final int INSIDE_LEFT_SCROLL_ZONE = 1;
  private static final int INSIDE_RIGHT_SCROLL_ZONE = 2;
  private static final int OUTSIDE_SCROLL_ZONE = 0;
  static final int SCROLL_LEFT = 0;
  static final int SCROLL_NONE = -1;
  static final int SCROLL_RIGHT = 1;
  private static final float SMOOTHING_CONSTANT = (float)(0.016D / Math.log(0.75D));
  private static final float SMOOTHING_SPEED = 0.75F;
  static final int X_LARGE_MODE = 1;
  private float mBaseLineFlingVelocity;
  private float mFlingVelocityInfluence;
  private Handler mHandler = new Handler();
  private Drawable mLeftHoverDrawable;
  private Drawable mRightHoverDrawable;
  private int mScrollDelay = getResources().getInteger(2131492882);
  private Interpolator mScrollInterpolator;
  private int mScrollMode = getScrollMode();
  private ScrollRunnable mScrollRunnable = new ScrollRunnable();
  private int mScrollState = 0;
  private Rect mUnEncumberedPagedViewBounds = new Rect();
  
  public SmoothPagedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmoothPagedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (this.mScrollMode == 0)
    {
      this.mBaseLineFlingVelocity = 2500.0F;
      this.mFlingVelocityInfluence = 0.4F;
      this.mScrollInterpolator = new WorkspaceOvershootInterpolator();
      this.mScroller = new Scroller(getContext(), this.mScrollInterpolator);
    }
    this.mUsePagingTouchSlop = false;
    if (this.mScrollMode != 1) {}
    for (;;)
    {
      this.mDeferScrollUpdate = bool;
      return;
      bool = false;
    }
  }
  
  private void checkEdgeScroll(int paramInt1, int paramInt2)
  {
    if (Launcher.isHelpAppRunning) {}
    do
    {
      return;
      i = getCurrentPage();
    } while ((i < 0) || (i >= getPageCount()));
    View localView = getRootView();
    int i = getScrollZoneLeftWidth();
    int j = getScrollZoneRightWidth();
    int k = localView.getWidth();
    if (paramInt1 < i)
    {
      scrollToLeft(paramInt1, paramInt2);
      return;
    }
    if (paramInt1 > k - j)
    {
      scrollToRight(paramInt1, paramInt2);
      return;
    }
    this.mScrollState = 0;
    this.mScrollRunnable.removeSelf();
    onExitScrollArea();
  }
  
  private boolean isInsideScrollZone()
  {
    return (1 == this.mScrollState) || (2 == this.mScrollState);
  }
  
  private void scrollToLeft(int paramInt1, int paramInt2)
  {
    if (onEnterScrollArea(paramInt1, paramInt2, 0))
    {
      this.mScrollState = 1;
      this.mScrollRunnable.postForScrollDelayed();
    }
  }
  
  private void scrollToRight(int paramInt1, int paramInt2)
  {
    if (onEnterScrollArea(paramInt1, paramInt2, 1))
    {
      this.mScrollState = 2;
      this.mScrollRunnable.postForScrollDelayed();
    }
  }
  
  private void snapToPageWithVelocity(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = getAdjustedPageIndex(paramInt1);
    int m = Math.max(1, Math.abs(i - getCurrentPage()));
    int j = getNonLoopedScrollXForPageIndex(i);
    int k = this.mUnboundedScrollX;
    paramInt1 = (m + 1) * 100;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (paramBoolean)
    {
      ((WorkspaceOvershootInterpolator)this.mScrollInterpolator).setDistance(m);
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 <= 0) {
        break label133;
      }
      paramInt1 = (int)(paramInt1 + paramInt1 / (paramInt2 / this.mBaseLineFlingVelocity) * this.mFlingVelocityInfluence);
    }
    for (;;)
    {
      snapToPage(i, j - k, paramInt1);
      return;
      ((WorkspaceOvershootInterpolator)this.mScrollInterpolator).disableSettle();
      break;
      label133:
      paramInt1 += 100;
    }
  }
  
  protected void cancelScrollRunnable()
  {
    this.mScrollRunnable.removeSelf();
  }
  
  public void computeScroll()
  {
    if (this.mScrollMode == 1) {
      super.computeScroll();
    }
    float f3;
    do
    {
      do
      {
        return;
      } while ((computeScrollHelper()) || (this.mTouchState != 1));
      float f1 = (float)System.nanoTime() / 1.0E9F;
      float f2 = (float)Math.exp((f1 - this.mSmoothingTime) / SMOOTHING_CONSTANT);
      f3 = this.mTouchX - this.mUnboundedScrollX;
      scrollTo(Math.round(this.mUnboundedScrollX + f3 * f2), getScrollY());
      this.mSmoothingTime = f1;
    } while ((f3 <= 1.0F) && (f3 >= -1.0F));
    invalidate();
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    int i = (int)paramDragEvent.getX();
    int j = (int)paramDragEvent.getY();
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchDragEvent(paramDragEvent);
      this.mScrollState = 0;
      continue;
      checkEdgeScroll(i, j);
      continue;
      this.mScrollState = 0;
      this.mScrollRunnable.removeSelf();
      onExitScrollArea();
    }
  }
  
  protected int getScrollMode()
  {
    return 1;
  }
  
  protected int getScrollZoneLeftWidth()
  {
    return 0;
  }
  
  protected int getScrollZoneRightWidth()
  {
    return 0;
  }
  
  protected boolean getUnEncumberedPagedViewBounds(Rect paramRect)
  {
    return false;
  }
  
  protected void onDrawComplete(Canvas paramCanvas)
  {
    if ((!isInsideScrollZone()) || (!getUnEncumberedPagedViewBounds(this.mUnEncumberedPagedViewBounds)) || (!this.mScrollRunnable.isWaitingtoScroll()) || (getPageCount() <= 1)) {
      return;
    }
    switch (this.mScrollState)
    {
    default: 
      return;
    case 1: 
      if (this.mLeftHoverDrawable == null) {
        this.mLeftHoverDrawable = getResources().getDrawable(2130837752);
      }
      this.mLeftHoverDrawable.setBounds(getScrollX() + this.mUnEncumberedPagedViewBounds.left, this.mUnEncumberedPagedViewBounds.top, getScrollX() + this.mUnEncumberedPagedViewBounds.left + this.mLeftHoverDrawable.getIntrinsicWidth(), this.mUnEncumberedPagedViewBounds.bottom);
      this.mLeftHoverDrawable.draw(paramCanvas);
      return;
    }
    if (this.mRightHoverDrawable == null) {
      this.mRightHoverDrawable = getResources().getDrawable(2130837753);
    }
    this.mRightHoverDrawable.setBounds(getScrollX() + this.mUnEncumberedPagedViewBounds.right - this.mRightHoverDrawable.getIntrinsicWidth(), this.mUnEncumberedPagedViewBounds.top, getScrollX() + this.mUnEncumberedPagedViewBounds.right, this.mUnEncumberedPagedViewBounds.bottom);
    this.mRightHoverDrawable.draw(paramCanvas);
  }
  
  protected boolean onEnterScrollArea(int paramInt1, int paramInt2, int paramInt3)
  {
    return true;
  }
  
  protected void onExitScrollArea() {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = getPageTotWidth();
    paramInt4 = getChildCount() * paramInt3;
    int i = (paramInt4 + paramInt1) % paramInt4 / paramInt3;
    paramInt2 = 0;
    while (paramInt2 < getChildCount())
    {
      View localView = getChildAt(paramInt2);
      if ((localView instanceof CellLayoutWithResizableWidgets)) {
        ((CellLayoutWithResizableWidgets)localView).notifyWidgetsOfPageScroll(i, paramInt2, paramInt3, (paramInt4 + paramInt1) % paramInt4 % paramInt3);
      }
      paramInt2 += 1;
    }
  }
  
  protected void onScrollComplete() {}
  
  public void scrollToLeft(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = getCurrentPage();
    int j = getPageCount();
    if (paramBoolean1) {
      if (i - 1 >= 0)
      {
        i -= 1;
        if (!paramBoolean2) {
          break label72;
        }
        snapToPage(i);
      }
    }
    for (;;)
    {
      getChildAt(i).requestFocus();
      return;
      i = j - 1;
      break;
      if (i + 1 < j) {
        i += 1;
      }
      for (;;)
      {
        break;
        i = 0;
      }
      label72:
      setCurrentPage(i);
    }
  }
  
  protected void snapToDestination()
  {
    if (this.mScrollMode == 1)
    {
      super.snapToDestination();
      return;
    }
    snapToPageWithVelocity(getPageNearestToCenterOfScreen(), 0);
  }
  
  protected void snapToPage(int paramInt)
  {
    if (this.mScrollMode == 1)
    {
      super.snapToPage(paramInt);
      return;
    }
    snapToPageWithVelocity(paramInt, 0, false);
  }
  
  protected void snapToPageWithVelocity(int paramInt1, int paramInt2)
  {
    if (this.mScrollMode == 1)
    {
      super.snapToPageWithVelocity(paramInt1, paramInt2);
      return;
    }
    snapToPageWithVelocity(paramInt1, 0, true);
  }
  
  private class ScrollRunnable
    implements Runnable
  {
    private static final int STATE_NOT_IN_QUEUE = 0;
    private static final int STATE_PAGE_SCROLLING = 1;
    private static final int STATE_WAITING_TO_SCROLL = 2;
    private int mState = 0;
    
    ScrollRunnable() {}
    
    private void postForScrollToComplete()
    {
      if ((this.mState == 0) && (SmoothPagedView.this.mHandler.postDelayed(this, SmoothPagedView.this.PAGE_SNAP_ANIMATION_DURATION))) {
        this.mState = 1;
      }
      SmoothPagedView.this.invalidate();
    }
    
    public boolean isWaitingtoScroll()
    {
      return this.mState == 2;
    }
    
    public void postForScrollDelayed()
    {
      if ((this.mState == 0) && (SmoothPagedView.this.mHandler.postDelayed(this, SmoothPagedView.this.mScrollDelay))) {
        this.mState = 2;
      }
      SmoothPagedView.this.invalidate();
    }
    
    public void removeSelf()
    {
      if (this.mState != 0)
      {
        SmoothPagedView.this.mHandler.removeCallbacks(this);
        this.mState = 0;
        SmoothPagedView.this.invalidate();
      }
    }
    
    public void run()
    {
      if (this.mState == 0) {}
      int i;
      do
      {
        return;
        i = this.mState;
        this.mState = 0;
      } while (((Launcher)SmoothPagedView.this.getContext()).isLauncherDestroyed());
      if (i == 1)
      {
        postForScrollDelayed();
        return;
      }
      switch (SmoothPagedView.this.mScrollState)
      {
      }
      for (;;)
      {
        SmoothPagedView.this.onScrollComplete();
        return;
        SmoothPagedView.this.scrollLeft();
        postForScrollToComplete();
        continue;
        SmoothPagedView.this.scrollRight();
        postForScrollToComplete();
      }
    }
  }
  
  private static class WorkspaceOvershootInterpolator
    implements Interpolator
  {
    private static final float DEFAULT_TENSION = 1.3F;
    private float mTension = 1.3F;
    
    public void disableSettle()
    {
      this.mTension = 0.0F;
    }
    
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * ((this.mTension + 1.0F) * paramFloat + this.mTension) + 1.0F;
    }
    
    public void setDistance(int paramInt)
    {
      float f = 1.3F;
      if (paramInt > 0) {
        f = 1.3F / paramInt;
      }
      this.mTension = f;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SmoothPagedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */