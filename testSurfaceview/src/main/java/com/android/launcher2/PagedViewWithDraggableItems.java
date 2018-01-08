package com.android.launcher2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public abstract class PagedViewWithDraggableItems
  extends PagedView
  implements View.OnLongClickListener, View.OnTouchListener
{
  private float mDragSlopeThreshold;
  private boolean mIsDragEnabled;
  private boolean mIsDragging;
  private View mLastTouchedItem;
  
  public PagedViewWithDraggableItems(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagedViewWithDraggableItems(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagedViewWithDraggableItems(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void handleTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return;
      cancelDragging();
      this.mIsDragEnabled = true;
      return;
    } while ((this.mTouchState == 1) || (this.mIsDragging) || (!this.mIsDragEnabled));
    determineDraggingStart(paramMotionEvent);
  }
  
  protected boolean beginDragging(View paramView)
  {
    boolean bool = this.mIsDragging;
    this.mIsDragging = true;
    return !bool;
  }
  
  protected void cancelDragging()
  {
    this.mIsDragging = false;
    this.mLastTouchedItem = null;
    this.mIsDragEnabled = false;
  }
  
  protected void determineDraggingStart(MotionEvent paramMotionEvent)
  {
    int j = (int)Math.abs(paramMotionEvent.getX() - this.mLastMotionX);
    int k = (int)Math.abs(paramMotionEvent.getY() - this.mLastMotionY);
    int i;
    if (k > this.mTouchSlop)
    {
      i = 1;
      if (k / j <= this.mDragSlopeThreshold) {
        break label90;
      }
    }
    label90:
    for (j = 1;; j = 0)
    {
      if ((j != 0) && (i != 0) && (this.mLastTouchedItem != null))
      {
        beginDragging(this.mLastTouchedItem);
        cancelCurrentPageLongPress();
      }
      return;
      i = 0;
      break;
    }
  }
  
  protected void determineScrollingStart(MotionEvent paramMotionEvent)
  {
    if (!this.mIsDragging) {
      super.determineScrollingStart(paramMotionEvent);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    cancelDragging();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    handleTouchEvent(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!paramView.isInTouchMode()) {}
    while (this.mNextPage != Integer.MIN_VALUE) {
      return false;
    }
    performAccessibilityAction(128, null);
    if (Launcher.isHelpAppRunning)
    {
      HomePendingItem localHomePendingItem = (HomePendingItem)paramView.getTag();
      if ((!HomePendingItem.isWidget(localHomePendingItem)) || ((localHomePendingItem.mType == BaseItem.Type.HOME_WIDGET) && (localHomePendingItem.getSpanX() == 1) && (localHomePendingItem.getSpanY() == 1)))
      {
        Toast.makeText(getContext(), 2131755199, 0).show();
        return false;
      }
    }
    return beginDragging(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.mLastTouchedItem = paramView;
    this.mIsDragEnabled = true;
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    handleTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragSlopeThreshold(float paramFloat)
  {
    this.mDragSlopeThreshold = paramFloat;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PagedViewWithDraggableItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */