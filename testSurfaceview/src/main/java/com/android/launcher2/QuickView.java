package com.android.launcher2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.DVFSHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.samsung.android.feature.FloatingFeature;
import com.sec.dtl.launcher.Talk;

public abstract class QuickView
  extends FrameLayout
  implements View.OnLongClickListener, View.OnClickListener
{
  public static final int ANIMATION_IN_TIME = 400;
  public static final int ANIMATION_OUT_TIME = 360;
  protected static final int ANIMATION_STATE_CLOSE_DONE = 8;
  protected static final int ANIMATION_STATE_CLOSE_RUNNING = 4;
  protected static final int ANIMATION_STATE_CLOSE_STARTING = 3;
  protected static final int ANIMATION_STATE_OPEN_DONE = 7;
  protected static final int ANIMATION_STATE_OPEN_NONE = 10;
  protected static final int ANIMATION_STATE_OPEN_RUNNING = 2;
  protected static final int ANIMATION_STATE_OPEN_STARTING = 1;
  protected static final boolean DEBUG = false;
  static final int INVALID_VALUE = -1;
  public static final int PINCH_DISTANCE_DELTA = 50;
  protected static final float SCALE_FACTOR = 1.15F;
  private static final String TAG = "QuickView";
  static final int TOUCH_STATE_DRAGGING = 2;
  static final int TOUCH_STATE_PINCHIN = 4;
  static final int TOUCH_STATE_PINCHOUT = 3;
  static final int TOUCH_STATE_REST = 0;
  static final int TOUCH_STATE_SCROLLING = 1;
  protected static float mScaleFactor;
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  protected AnimateEngine mAniEngine;
  protected int mAnimationDuration;
  protected long mAnimationStartTime;
  protected int mAnimationState = 7;
  private boolean mChangingOrientation = false;
  protected int mChildGapH;
  protected int mChildGapV;
  protected Rect[] mChildRects;
  protected int mCurrentPage;
  protected Rect[] mCurrentRects;
  protected int mDraggingIndex;
  protected View mDraggingView;
  protected DVFSHelper mDvfsHelper = null;
  protected boolean mEnabledChildAnimation;
  protected Rect[] mFinishRects;
  protected boolean mIsSecretQuickView;
  protected boolean mIsWorkspace = false;
  protected float mLastMotionX;
  protected float mLastMotionY;
  protected boolean mMultiTouchUsed = false;
  private int mOrientation;
  protected int mOriginDragIndex;
  protected final Rect mPanelPadding = new Rect();
  private final int mPanelSizeLong;
  private final int mPanelSizeLong2;
  private final int mPanelSizeShort;
  private final int mPanelSizeShort2;
  protected int mPinchIndex;
  protected int mPinchOutIndex;
  protected boolean mPinchOutProcess = false;
  protected QuickViewInfoProvider mQVProvider;
  protected Drawable mScreenBgDrawable;
  private final Rect mScreenRect = new Rect();
  protected Rect[] mStartRects;
  protected long mTimeStore;
  protected Rect mTmpRect = new Rect();
  protected int mTouchPointDistance;
  protected int mTouchSlop;
  protected int mTouchState = 0;
  protected View mTouchedView;
  private boolean mUpdateHitRect = false;
  
  public QuickView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuickView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    this.mPanelSizeShort = paramContext.getDimensionPixelSize(2131624253);
    this.mPanelSizeShort2 = paramContext.getDimensionPixelSize(2131624254);
    this.mPanelSizeLong = paramContext.getDimensionPixelSize(2131624255);
    this.mPanelSizeLong2 = paramContext.getDimensionPixelSize(2131624256);
    this.mAniEngine = new AnimateEngine();
    this.mAniEngine.setInterpolator(new AccelerateDecelerateInterpolator());
    setClickable(true);
  }
  
  private void clearDragVars()
  {
    this.mTouchState = 0;
    this.mDraggingView = null;
    this.mTouchedView = null;
    this.mPinchIndex = -1;
    this.mDraggingIndex = -1;
    this.mOriginDragIndex = -1;
  }
  
  private void initDVFSHelper()
  {
    if (this.mDvfsHelper == null) {
      this.mDvfsHelper = new DVFSHelper(getContext(), 1, 8L);
    }
  }
  
  private void setAniRects(Rect[] paramArrayOfRect, int paramInt1, int paramInt2)
  {
    if ((this.mQVProvider.getNumPages() <= 0) || (paramInt1 < 0) || (paramInt2 <= paramInt1)) {}
    for (;;)
    {
      return;
      View localView = this.mQVProvider.getPage(0);
      int j = localView.getLeft();
      int k = localView.getTop();
      int i = 0;
      while (i < paramInt1)
      {
        j += getChildAt(0).getWidth() + this.mChildGapH;
        i += 1;
      }
      if (this.mIsWorkspace) {
        paramArrayOfRect[paramInt1].set(j - this.mPanelPadding.left, k - this.mPanelPadding.top, localView.getWidth() + j + this.mPanelPadding.right, localView.getHeight() + k + this.mPanelPadding.bottom);
      }
      for (;;)
      {
        j = this.mQVProvider.getPageHorizontalOffset();
        i = paramInt1 - 1;
        while (i >= 0)
        {
          paramArrayOfRect[i].set(paramArrayOfRect[(i + 1)]);
          paramArrayOfRect[i].offset(-paramArrayOfRect[i].width() - j, 0);
          i -= 1;
        }
        paramArrayOfRect[paramInt1].set(j - this.mPanelPadding.left, k - this.mPanelPadding.top + getResources().getDimensionPixelSize(2131623958), localView.getWidth() + j + this.mPanelPadding.right, localView.getHeight() + k + getResources().getDimensionPixelSize(2131623958) + this.mPanelPadding.bottom);
      }
      paramInt1 += 1;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfRect[paramInt1].set(paramArrayOfRect[(paramInt1 - 1)]);
        paramArrayOfRect[paramInt1].offset(paramArrayOfRect[paramInt1].width() + j, 0);
        paramInt1 += 1;
      }
    }
  }
  
  public void cancelDrag()
  {
    if (this.mDraggingView != null)
    {
      this.mDraggingView.setVisibility(0);
      removeView(this.mDraggingView);
      addView(this.mDraggingView, this.mOriginDragIndex);
      this.mDraggingView.requestLayout();
    }
    updateTags();
    this.mTouchState = 0;
    this.mDraggingIndex = -1;
    this.mDraggingView = null;
    this.mTouchedView = null;
    this.mPinchIndex = -1;
    this.mOriginDragIndex = -1;
    invalidate();
  }
  
  public void close()
  {
    this.mEnabledChildAnimation = false;
    setVisibility(8);
    this.mAnimationState = 7;
  }
  
  public boolean drawCloseAnimation()
  {
    this.mTimeStore = referenceTime();
    if ((isOpened()) && (this.mAnimationState == 7))
    {
      this.mAnimationState = 3;
      this.mAnimationDuration = 360;
      return true;
    }
    return false;
  }
  
  public void drawOpenAnimation()
  {
    this.mTimeStore = referenceTime();
    this.mAnimationState = 1;
    this.mAnimationDuration = 400;
  }
  
  public void drawOpenNonAnimation()
  {
    this.mAnimationState = 10;
  }
  
  protected void drop(int paramInt1, int paramInt2)
  {
    if (this.mDraggingView == null) {
      return;
    }
    this.mDraggingView.setVisibility(0);
    this.mDraggingView.requestLayout();
    paramInt1 = this.mDraggingIndex;
    if ((paramInt1 != -1) && (isValidTag(getChildAt(paramInt1).getTag()))) {
      swapScreen(paramInt1);
    }
    for (;;)
    {
      Talk.INSTANCE.say(2131755210, paramInt1 + 1, this.mChildRects.length);
      if ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn())) {
        break;
      }
      performHapticFeedback(25687, 1);
      return;
      swapScreen(this.mDraggingIndex);
    }
  }
  
  protected void endDrag()
  {
    clearDragVars();
    this.mQVProvider.onQuickViewDragEnd();
  }
  
  protected FrameLayout.LayoutParams getChildLayoutParams()
  {
    if (this.mOrientation == 2) {
      return new FrameLayout.LayoutParams(this.mPanelSizeLong2, this.mPanelSizeShort2);
    }
    return new FrameLayout.LayoutParams(this.mPanelSizeShort, this.mPanelSizeLong);
  }
  
  public int getCurrentPage()
  {
    return this.mCurrentPage;
  }
  
  public boolean getTouchState()
  {
    return this.mTouchState != 0;
  }
  
  protected int getTouchedIndex(int paramInt1, int paramInt2)
  {
    if (this.mChildRects == null) {
      return -1;
    }
    int j = this.mChildRects.length;
    int i = 0;
    if (i < j)
    {
      if (this.mChildRects[i] == null) {}
      while (!this.mChildRects[i].contains(getScrollX() + paramInt1, getScrollY() + paramInt2))
      {
        i += 1;
        break;
      }
      return i;
    }
    return -1;
  }
  
  protected int getYOffset()
  {
    return 0;
  }
  
  protected FrameLayout.LayoutParams init(QuickViewInfoProvider paramQuickViewInfoProvider)
  {
    removeAllViews();
    clearDragVars();
    this.mQVProvider = paramQuickViewInfoProvider;
    initDVFSHelper();
    paramQuickViewInfoProvider = getResources();
    this.mTouchSlop = paramQuickViewInfoProvider.getDimensionPixelSize(2131624184);
    this.mOrientation = paramQuickViewInfoProvider.getConfiguration().orientation;
    this.mScreenBgDrawable = paramQuickViewInfoProvider.getDrawable(2130837649);
    this.mChildGapV = paramQuickViewInfoProvider.getDimensionPixelSize(2131624188);
    this.mChildGapH = paramQuickViewInfoProvider.getDimensionPixelSize(2131624189);
    this.mScreenBgDrawable.getPadding(this.mPanelPadding);
    getHitRect(this.mScreenRect);
    return getChildLayoutParams();
  }
  
  public abstract void initScreen(QuickViewInfoProvider paramQuickViewInfoProvider);
  
  protected final boolean isAnimStateOkayForClickEvents()
  {
    return this.mAnimationState == 7;
  }
  
  public final boolean isAnimating()
  {
    return (this.mAnimationState != 7) && (this.mAnimationState != 8);
  }
  
  protected boolean isAvailableRect(Rect paramRect)
  {
    return isAvailableRect(paramRect, 0);
  }
  
  protected boolean isAvailableRect(Rect paramRect, int paramInt)
  {
    return (paramRect.right >= this.mScreenRect.left) || (paramRect.top <= this.mScreenRect.bottom + paramInt) || (paramRect.left <= this.mScreenRect.right) || (paramRect.bottom >= this.mScreenRect.top + paramInt);
  }
  
  protected boolean isChangingOrientation()
  {
    return this.mChangingOrientation;
  }
  
  public boolean isOpened()
  {
    return getVisibility() == 0;
  }
  
  public boolean isSecretQuickViewMode()
  {
    return this.mIsSecretQuickView;
  }
  
  protected abstract boolean isValidTag(Object paramObject);
  
  protected boolean onPinchOut()
  {
    this.mMultiTouchUsed = false;
    this.mPinchOutProcess = false;
    this.mCurrentPage = this.mPinchOutIndex;
    drawCloseAnimation();
    postInvalidate();
    return true;
  }
  
  public void open()
  {
    this.mEnabledChildAnimation = true;
    setVisibility(0);
    this.mCurrentPage = this.mQVProvider.getCurrentPage();
    setScrollX(0);
  }
  
  public void openInstantly()
  {
    this.mAnimationState = 7;
  }
  
  protected long referenceTime()
  {
    return System.currentTimeMillis();
  }
  
  protected FrameLayout.LayoutParams reloadLayoutParameters()
  {
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    Object localObject = getResources();
    int i = ((Resources)localObject).getConfiguration().orientation;
    if (i != this.mOrientation) {
      this.mChangingOrientation = true;
    }
    this.mOrientation = i;
    this.mScreenBgDrawable = ((Resources)localObject).getDrawable(2130837649);
    this.mChildGapV = ((Resources)localObject).getDimensionPixelSize(2131624188);
    this.mChildGapH = ((Resources)localObject).getDimensionPixelSize(2131624189);
    Rect localRect = new Rect();
    this.mScreenBgDrawable.getPadding(localRect);
    if (this.mOrientation == 2)
    {
      localObject = new FrameLayout.LayoutParams(this.mPanelSizeLong2, this.mPanelSizeShort2);
      this.mPanelPadding.left = localRect.top;
      this.mPanelPadding.top = localRect.left;
      this.mPanelPadding.right = localRect.bottom;
      this.mPanelPadding.bottom = localRect.right;
      switch (this.mAnimationState)
      {
      }
    }
    for (;;)
    {
      this.mStartRects = null;
      this.mFinishRects = null;
      this.mCurrentRects = null;
      this.mUpdateHitRect = true;
      return (FrameLayout.LayoutParams)localObject;
      localObject = new FrameLayout.LayoutParams(this.mPanelSizeShort, this.mPanelSizeLong);
      this.mPanelPadding.left = localRect.left;
      this.mPanelPadding.top = localRect.top;
      this.mPanelPadding.right = localRect.right;
      this.mPanelPadding.bottom = localRect.bottom;
      break;
      this.mAnimationState = 7;
      continue;
      this.mQVProvider.onQuickViewCloseAnimationStarted();
      this.mAnimationState = 8;
      this.mQVProvider.onQuickViewCloseAnimationCompleted();
    }
  }
  
  public void setAnimateOpenNone()
  {
    this.mAnimationState = 10;
  }
  
  protected void setCloseEndRect(int paramInt)
  {
    int j = getChildCount();
    if ((this.mFinishRects == null) || (this.mFinishRects.length != j))
    {
      this.mFinishRects = new Rect[j];
      int i = 0;
      while (i < j)
      {
        this.mFinishRects[i] = new Rect();
        i += 1;
      }
    }
    setAniRects(this.mFinishRects, paramInt, j);
  }
  
  public void setCurrentPage(int paramInt)
  {
    this.mCurrentPage = paramInt;
  }
  
  protected void setOpenStartRect(int paramInt)
  {
    int j = getChildCount();
    if ((this.mStartRects == null) || (this.mStartRects.length != j))
    {
      this.mStartRects = new Rect[j];
      int i = 0;
      while (i < j)
      {
        this.mStartRects[i] = new Rect();
        i += 1;
      }
    }
    setAniRects(this.mStartRects, paramInt, j);
  }
  
  public void setSecretQuickViewMode(boolean paramBoolean)
  {
    this.mIsSecretQuickView = paramBoolean;
  }
  
  protected void startDrag(View paramView)
  {
    this.mTouchState = 2;
    this.mDraggingIndex = ((Integer)paramView.getTag()).intValue();
    this.mOriginDragIndex = this.mDraggingIndex;
    this.mDraggingView = paramView;
    this.mTouchedView = paramView;
    mScaleFactor = 1.0F;
    invalidate();
    this.mQVProvider.onQuickViewDragStart();
  }
  
  protected abstract void swapScreen(int paramInt);
  
  protected void updateParamsIfNeeded(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mUpdateHitRect) {
        getHitRect(this.mScreenRect);
      }
      this.mChangingOrientation = false;
    }
    this.mUpdateHitRect = false;
  }
  
  protected abstract void updateTags();
  
  protected class Animate
    implements Runnable
  {
    private static final int PROGRESS_INT_MAX = 100;
    private AnimateEngine mAnimateEngine = new AnimateEngine();
    private Rect[] mDestRects = { new Rect() };
    private Rect[] mResultRects = { new Rect() };
    private Scroller mScroller = new Scroller(QuickView.this.getContext(), new DecelerateInterpolator());
    private Rect[] mStartRects = { new Rect() };
    private View mTargetView;
    
    Animate() {}
    
    public boolean isEnd()
    {
      return !this.mScroller.computeScrollOffset();
    }
    
    public void run()
    {
      Object localObject = this.mScroller;
      boolean bool = ((Scroller)localObject).computeScrollOffset();
      int i = ((Scroller)localObject).getCurrX();
      this.mAnimateEngine.getRect(this.mStartRects, this.mDestRects, this.mResultRects, i / 100.0F);
      localObject = this.mTargetView;
      if (bool)
      {
        ((View)localObject).layout(this.mResultRects[0].left, this.mResultRects[0].top, this.mResultRects[0].right, this.mResultRects[0].bottom);
        QuickView.this.invalidate();
        QuickView.this.post(this);
        return;
      }
      ((View)localObject).layout(this.mDestRects[0].left, this.mDestRects[0].top, this.mDestRects[0].right, this.mDestRects[0].bottom);
      QuickView.this.invalidate();
    }
    
    public void start(View paramView, Rect paramRect)
    {
      stop();
      this.mTargetView = paramView;
      paramView.getHitRect(this.mStartRects[0]);
      this.mDestRects[0].set(paramRect);
      this.mScroller.startScroll(0, 0, 100, 0, 200);
      QuickView.this.post(this);
    }
    
    public void stop()
    {
      QuickView.this.removeCallbacks(this);
    }
  }
  
  public static abstract interface QuickViewInfoProvider
  {
    public abstract int getCurrentPage();
    
    public abstract int getNumPages();
    
    public abstract int getNumSecretPages();
    
    public abstract View getPage(int paramInt);
    
    public abstract int getPageHorizontalOffset();
    
    public abstract void getPagesLocationOnScreen(int[] paramArrayOfInt);
    
    public abstract int getPagesTop();
    
    public abstract boolean isFolderPage(int paramInt);
    
    public abstract void movePage(int paramInt1, int paramInt2);
    
    public abstract void onQuickViewCloseAnimationCompleted();
    
    public abstract void onQuickViewCloseAnimationStarted();
    
    public abstract void onQuickViewDragEnd();
    
    public abstract void onQuickViewDragStart();
    
    public abstract void saveCurrentPageOrder();
    
    public abstract void setPage(int paramInt);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/QuickView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */