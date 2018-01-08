package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.DVFSHelper;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.Toast;
import com.samsung.android.feature.FloatingFeature;
import com.sec.dtl.launcher.Talk;

public class QuickViewMainMenu
  extends QuickView
{
  private static final int ANIMATED_SCROLL_DURATION = 600;
  private static final int INSIDE_LEFT_SCROLL_ZONE = 1;
  private static final int INSIDE_RIGHT_SCROLL_ZONE = 2;
  private static final int OUTSIDE_SCROLL_ZONE = 0;
  private static final int QV_PAGE_SNAP_ANIMATION_DURATION = 400;
  private static final ColorFilter RED_COLOR_FILTER = new LightingColorFilter(-6815744, -14680064);
  private static final int[][] ROW_BY_COL_LAYOUT;
  private static final String TAG = "QuickViewMainMenu";
  private static final int TOUCH_DRAG_DELETE = 1;
  private static final int TOUCH_DRAG_NORMAL = 0;
  private static Rect sHitRect = new Rect();
  public final int MENU_ZONE = getResources().getDimensionPixelSize(2131624195);
  public final int PAGE_SNAP_ANIMATION_DURATION = getResources().getInteger(2131492900);
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private QuickView.Animate[] mChildAnimate = new QuickView.Animate[getChildCount()];
  private int mChildLeft;
  private boolean mConfigurationChangeIsInProgress = false;
  private int mDragState = 0;
  private boolean mDropCheck = false;
  private Animator mEnterAnimator;
  private Animator mExitAnimator;
  private Handler mHandler = null;
  private int mHeightMeasureSpec;
  private final Drawable mHomeBgDrawable;
  private boolean mIsReadOnly = false;
  private boolean mIsSaved = false;
  private Drawable mLeftHoverDrawable;
  private int mMaxDeltaX = 0;
  private int mMaximumVelocity;
  private MenuAppsGrid mMenuAppsGrid;
  private int mMinimumVelocity;
  private int mOrientation;
  private FrameLayout.LayoutParams mPageLP;
  private int mReadOnlyToastResId = -1;
  private Drawable mRightHoverDrawable;
  private boolean mScrollCheck = false;
  private int mScrollDelay;
  private int mScrollHalfWidth;
  private ScrollRunnable mScrollRunnable = new ScrollRunnable();
  private int mScrollState = 0;
  private int mScrollWidth;
  Scroller mScroller;
  private Rect[] mTempRects;
  private VelocityTracker mVelocityTracker;
  private int mWidthMeasureSpec;
  
  static
  {
    int[] arrayOfInt1 = { 1 };
    int[] arrayOfInt2 = { 2 };
    int[] arrayOfInt3 = { 2, 1, 2 };
    int[] arrayOfInt4 = { 2, 2, 2 };
    int[] arrayOfInt5 = { 2, 3, 2 };
    ROW_BY_COL_LAYOUT = new int[][] { arrayOfInt1, arrayOfInt2, { 2, 1 }, { 2, 2 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 3, 3, 2 }, { 3, 3, 3 } };
  }
  
  public QuickViewMainMenu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuickViewMainMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickViewMainMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      this.mChildAnimate[paramInt] = new QuickView.Animate(this);
      paramInt += 1;
    }
    this.mScroller = new Scroller(paramContext, null, false);
    this.mScrollDelay = getResources().getInteger(2131492900);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    this.mMinimumVelocity = paramAttributeSet.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.mEnterAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034130);
    this.mEnterAnimator.setDuration(400L);
    this.mExitAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034131);
    this.mExitAnimator.setDuration(360L);
    this.mHomeBgDrawable = paramContext.getResources().getDrawable(2130837660);
  }
  
  private void getViewLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt1 > ROW_BY_COL_LAYOUT.length) || ((this.mTempRects != null) && (this.mTempRects.length == paramInt1))) {}
    for (;;)
    {
      return;
      this.mTempRects = new Rect[paramInt1];
      int n = ROW_BY_COL_LAYOUT[(paramInt1 - 1)].length;
      int i = 0;
      int j = 0;
      while (j < n)
      {
        m = ROW_BY_COL_LAYOUT[(paramInt1 - 1)][j];
        k = i;
        if (m > i) {
          k = m;
        }
        j += 1;
        i = k;
      }
      int m = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
      int k = this.mChildGapH;
      j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      float f2 = Math.min((j - (n + 1) * this.mChildGapV) / (paramInt3 * n), (m - (i + 1) * k) / (paramInt2 * i));
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      int i1 = (int)(paramInt2 * f1);
      int i2 = (int)(paramInt3 * f1);
      paramInt2 = this.mChildGapV;
      paramInt3 = this.mChildGapV;
      paramInt3 = getPaddingTop() + (j - ((paramInt2 + i2) * n - paramInt3)) / 2;
      i = 0;
      paramInt2 = 0;
      while (paramInt2 < n)
      {
        int i3 = ROW_BY_COL_LAYOUT[(paramInt1 - 1)][paramInt2];
        j = this.mChildGapH;
        k = this.mChildGapH;
        k = getPaddingLeft() + (m - ((j + i1) * i3 - k)) / 2;
        j = 0;
        if (j < i3)
        {
          if (this.mTempRects[i] == null) {
            this.mTempRects[i] = new Rect(k, paramInt3, k + i1, paramInt3 + i2);
          }
          for (;;)
          {
            i += 1;
            k += this.mChildGapH + i1;
            j += 1;
            break;
            this.mTempRects[i].set(k, paramInt3, k + i1, paramInt3 + i2);
          }
        }
        paramInt3 += this.mChildGapV + i2;
        paramInt2 += 1;
      }
    }
  }
  
  private View makeScreen(int paramInt, boolean paramBoolean)
  {
    Object localObject = getContext();
    FrameLayout localFrameLayout = new FrameLayout((Context)localObject);
    Resources localResources = ((Context)localObject).getResources();
    localObject = new FrameLayout((Context)localObject);
    ((FrameLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 49));
    localFrameLayout.addView((View)localObject);
    int i = localResources.getInteger(2131492888);
    ((FrameLayout)localObject).setPadding(0, localResources.getInteger(2131492889), i, 0);
    addView(localFrameLayout, paramInt, this.mPageLP);
    localFrameLayout.setPadding(this.mPanelPadding.left, this.mPanelPadding.top, this.mPanelPadding.right, this.mPanelPadding.bottom);
    localFrameLayout.setTag(Integer.valueOf(paramInt));
    localFrameLayout.setFocusable(true);
    localFrameLayout.setOnLongClickListener(this);
    localFrameLayout.setOnClickListener(this);
    return localFrameLayout;
  }
  
  private void onDrawComplete(Canvas paramCanvas)
  {
    if ((this.mScrollState == 0) || (this.mScrollRunnable.mState != 2)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = Launcher.getInstance().getResources().getDisplayMetrics();
    switch (this.mScrollState)
    {
    default: 
      return;
    case 1: 
      if (this.mLeftHoverDrawable == null) {
        this.mLeftHoverDrawable = getResources().getDrawable(2130837766);
      }
      this.mLeftHoverDrawable.setBounds(getScrollX(), getTop(), this.mLeftHoverDrawable.getIntrinsicWidth() + getScrollX(), getBottom());
      this.mLeftHoverDrawable.draw(paramCanvas);
      return;
    }
    if (this.mRightHoverDrawable == null) {
      this.mRightHoverDrawable = getResources().getDrawable(2130837767);
    }
    this.mRightHoverDrawable.setBounds(getScrollX() + localDisplayMetrics.widthPixels - this.mRightHoverDrawable.getIntrinsicWidth(), getTop(), getScrollX() + localDisplayMetrics.widthPixels, getBottom());
    this.mRightHoverDrawable.draw(paramCanvas);
  }
  
  private void savemenupage()
  {
    if ((!this.mIsSaved) && (!this.mIsReadOnly))
    {
      this.mQVProvider.saveCurrentPageOrder();
      this.mIsSaved = true;
    }
  }
  
  private void scroll(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = getScrollX();
    if (paramInt1 < 0) {
      if (paramInt2 > 0) {
        if (paramInt2 + paramInt1 < 0) {
          smoothScrollBy(-paramInt2, 0, paramBoolean);
        }
      }
    }
    while (paramInt1 <= 0)
    {
      return;
      smoothScrollBy(paramInt1, 0, paramBoolean);
      return;
      invalidate();
      return;
    }
    paramInt2 = this.mMaxDeltaX - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt2 > paramInt1)
      {
        smoothScrollBy(paramInt1, 0, paramBoolean);
        return;
      }
      smoothScrollBy(paramInt2, 0, paramBoolean);
      return;
    }
    invalidate();
  }
  
  public static void zOrderTweakMoveChild(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    View localView = paramViewGroup.getChildAt(paramInt1);
    if (localView != null) {
      localView.bringToFront();
    }
    int i = paramViewGroup.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < i - paramInt2 - 1)
    {
      localView = paramViewGroup.getChildAt(paramInt2);
      if (localView != null) {
        localView.bringToFront();
      }
      paramInt1 += 1;
    }
    paramViewGroup.requestLayout();
  }
  
  public void cancelDrag()
  {
    super.cancelDrag();
    this.mDragState = 0;
  }
  
  public void close()
  {
    super.close();
    this.mMenuAppsGrid.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.ALL_PAGE);
    savemenupage();
  }
  
  public void computeScroll()
  {
    if ((getChildCount() == 0) || (this.mChildRects == null)) {}
    while (!this.mScroller.computeScrollOffset()) {
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = this.mScroller.getCurrX();
    int m = this.mScroller.getCurrY();
    setScrollX(k);
    setScrollY(m);
    if ((i != getScrollX()) || (j != getScrollY())) {
      onScrollChanged(getScrollX(), getScrollY(), i, j);
    }
    if (this.mTouchState == 2)
    {
      i = getScrollX() - i;
      View localView = this.mDraggingView;
      if (localView != null)
      {
        Rect localRect = this.mTmpRect;
        localView.getHitRect(localRect);
        localRect.left += i;
        localRect.right += i;
        localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
    }
    invalidate();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int k = getChildCount();
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0)) {}
    View localView;
    int m;
    int n;
    do
    {
      return;
      j = this.mCurrentPage;
      if (((this.mChildRects != null) && (this.mChildRects.length == k)) || (k <= 0)) {
        break;
      }
      if ((this.mTempRects != null) && (this.mTempRects.length == k)) {
        break label281;
      }
      localView = getChildAt(0);
      i = getChildCount();
      m = localView.getMeasuredWidth();
      n = localView.getMeasuredHeight();
    } while (i < 1);
    if ((this.mChildRects == null) || (this.mChildRects.length != k)) {
      this.mChildRects = new Rect[k];
    }
    getViewLayout(k, m, n);
    label281:
    for (this.mChildRects = this.mTempRects; this.mAnimationState == 1; this.mChildRects = this.mTempRects)
    {
      this.mIsSaved = false;
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.mAnimationState = 2;
      this.mPinchIndex = this.mQVProvider.getCurrentPage();
      this.mIsWorkspace = false;
      setOpenStartRect(j);
      requestLayout();
      this.mFinishRects = new Rect[k];
      this.mCurrentRects = new Rect[k];
      i = 0;
      while (i < k)
      {
        this.mFinishRects[i] = new Rect();
        if (this.mChildRects != null) {
          this.mFinishRects[i].set(this.mChildRects[i]);
        }
        this.mCurrentRects[i] = new Rect();
        i += 1;
      }
    }
    if (this.mAnimationState == 3)
    {
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.mAnimationState = 4;
      this.mPinchIndex = j;
      requestLayout();
      setCloseEndRect(j);
      this.mStartRects = new Rect[k];
      this.mCurrentRects = new Rect[k];
      i = 0;
      while (i < k)
      {
        this.mStartRects[i] = new Rect();
        if (this.mChildRects != null) {
          this.mStartRects[i].set(this.mChildRects[i]);
        }
        this.mCurrentRects[i] = new Rect();
        i += 1;
      }
      this.mQVProvider.onQuickViewCloseAnimationStarted();
    }
    if (this.mTouchState == 2)
    {
      i = 0;
      while (i < k)
      {
        localView = getChildAt(i);
        if ((localView != this.mDraggingView) && ((i == j - 1) || (i == j + 1))) {
          drawChild(paramCanvas, localView, i);
        }
        i += 1;
      }
      drawChild(paramCanvas, this.mDraggingView, 0);
      postInvalidate();
    }
    for (;;)
    {
      if (this.mAnimationState == 8) {}
      onDrawComplete(paramCanvas);
      return;
      if ((this.mAnimationState == 2) || (this.mAnimationState == 4))
      {
        if ((this.mAnimationState == 4) && (this.mPinchIndex != this.mQVProvider.getCurrentPage())) {}
        long l = SystemClock.uptimeMillis() - this.mAnimationStartTime;
        if (l >= this.mAnimationDuration) {
          if (this.mAnimationState == 4)
          {
            this.mQVProvider.onQuickViewCloseAnimationCompleted();
            this.mAnimationState = 8;
          }
        }
        label594:
        for (float f = 1.0F;; f = (float)l / this.mAnimationDuration)
        {
          if (((this.mCurrentRects == null) || (this.mCurrentRects.length != k)) && (k > 0)) {
            this.mCurrentRects = new Rect[k];
          }
          this.mCurrentRects = this.mAniEngine.getRect(this.mStartRects, this.mFinishRects, this.mCurrentRects, f);
          if (this.mCurrentRects != null) {
            break label722;
          }
          Log.e("QuickViewMainMenu", "Failed to get current rectangles from animation engine");
          if (((this.mAnimationState == 2) || (this.mAnimationState == 7)) && (this.mAnimationState == 7)) {}
          invalidate();
          break;
          this.mAnimationState = 7;
          break label594;
        }
        label722:
        i = 0;
        label724:
        if (i < k)
        {
          localView = getChildAt(i);
          localView.layout(this.mCurrentRects[i].left, this.mCurrentRects[i].top, this.mCurrentRects[i].right, this.mCurrentRects[i].bottom);
          if (isAvailableRect(this.mCurrentRects[i]))
          {
            if (((f >= 0.5D) || (this.mAnimationState != 2)) && ((f <= 0.5D) || (this.mAnimationState != 4))) {
              break label846;
            }
            if (i == j) {
              drawChild(paramCanvas, localView, i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break label724;
          break;
          label846:
          if ((i == j - 1) || (i == j) || (i == j + 1)) {
            drawChild(paramCanvas, localView, i);
          }
        }
      }
      i = j;
      if (this.mScrollWidth != 0) {
        i = (getScrollX() + this.mScrollHalfWidth) / this.mScrollWidth;
      }
      j = 0;
      while (j < k)
      {
        if ((j == i - 1) || (j == i) || (j == i + 1)) {
          drawChild(paramCanvas, getChildAt(j), j);
        }
        j += 1;
      }
    }
  }
  
  protected void drawChild(Canvas paramCanvas, View paramView, int paramInt)
  {
    paramInt = paramView.getWidth();
    int i = paramView.getHeight();
    float f2 = paramInt / 2.0F;
    float f3 = i / 2.0F;
    float f4 = paramView.getLeft() + f2;
    float f5 = paramView.getTop() + f3;
    int j = getContext().getResources().getInteger(2131492887);
    paramCanvas.save();
    Object localObject = this.mHomeBgDrawable;
    float f1;
    if (this.mTouchedView == paramView) {
      if ((this.mDragState == 1) && (getChildCount() > 2))
      {
        ((Drawable)localObject).setColorFilter(RED_COLOR_FILTER);
        paramView.performAccessibilityAction(128, null);
        if (mScaleFactor + 0.02F >= 1.15F) {
          break label335;
        }
        f1 = mScaleFactor + 0.02F;
        label134:
        mScaleFactor = f1;
        label139:
        paramCanvas.translate(f4, f5);
        paramCanvas.scale(f1, f1);
        paramCanvas.translate(-f2, -f3);
        f2 = (int)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / this.mAnimationDuration;
        if (this.mAnimationState != 2) {
          break label355;
        }
      }
    }
    for (;;)
    {
      f3 = Math.max(0.0F, Math.min(1.0F, f2));
      f2 = f3;
      if (this.mAnimationState != 2)
      {
        f2 = f3;
        if (this.mAnimationState != 4)
        {
          f2 = f3;
          if (this.mAnimationState != 8) {
            f2 = 1.0F;
          }
        }
      }
      k = (int)(255.0F * f2);
      if (getVisibility() == 0)
      {
        ((Drawable)localObject).setAlpha(k);
        ((Drawable)localObject).setBounds(j, 0, paramInt, i);
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = paramView.getTag();
      if (!(localObject instanceof Integer)) {
        break label571;
      }
      paramCanvas.restore();
      localObject = this.mQVProvider.getPage(((Integer)localObject).intValue());
      if (localObject != null) {
        break label364;
      }
      return;
      ((Drawable)localObject).setColorFilter(null);
      break;
      label335:
      f1 = 1.15F;
      break label134;
      f1 = 1.0F;
      ((Drawable)localObject).setColorFilter(null);
      break label139;
      label355:
      f2 = 1.0F - f2;
    }
    label364:
    ((View)localObject).setAlpha(1.0F);
    j = ((View)localObject).getWidth();
    int k = ((View)localObject).getHeight();
    float f6 = ((ViewGroup)paramView).getChildAt(0).getHeight() * f2;
    f2 = (paramInt - this.mPanelPadding.left - this.mPanelPadding.right) / j;
    f3 = (i - this.mPanelPadding.bottom - (this.mPanelPadding.top + f6)) / k;
    if (f3 > f2) {}
    for (;;)
    {
      f1 = f2 * f1;
      paramCanvas.save();
      paramCanvas.translate((this.mPanelPadding.left - this.mPanelPadding.right) / 2.0F + f4, (this.mPanelPadding.top + f6 - this.mPanelPadding.bottom) / 2.0F + f5);
      paramCanvas.scale(f1, f1);
      paramCanvas.translate(-j / 2.0F, -k / 2.0F);
      ((View)localObject).draw(paramCanvas);
      paramCanvas.restore();
      paramView.draw(paramCanvas);
      return;
      f2 = f3;
    }
    label571:
    paramCanvas.restore();
  }
  
  public boolean drawCloseAnimation()
  {
    if (super.drawCloseAnimation())
    {
      cancelDrag();
      invalidate();
      return true;
    }
    return false;
  }
  
  public void drawOpenAnimation()
  {
    if (this.mMenuAppsGrid == null) {
      this.mMenuAppsGrid = ((Launcher)getContext()).getMenuView().getMenuAppsGrid();
    }
    super.drawOpenAnimation();
  }
  
  protected void drop(int paramInt1, int paramInt2)
  {
    super.drop(paramInt1, paramInt2);
  }
  
  protected void endDrag()
  {
    super.endDrag();
    this.mDragState = 0;
  }
  
  public int getCheckedIndex()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((localView instanceof ViewGroup)) && (((ViewGroup)localView).getChildCount() > 0))
      {
        localView = ((ViewGroup)localView).getChildAt(0);
        if (((localView instanceof CompoundButton)) && (((CompoundButton)localView).isChecked())) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCurrentPage()
  {
    return this.mCurrentPage;
  }
  
  public View getTargetPage()
  {
    int m = 0;
    int k = 0;
    int j = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      int[] arrayOfInt = new int[2];
      localView.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0] + localView.getWidth();
      int n = m;
      int i1 = k;
      if (arrayOfInt[0] <= getMeasuredWidth())
      {
        if (i < 0)
        {
          i1 = k;
          n = m;
        }
      }
      else
      {
        j += 1;
        m = n;
        k = i1;
        continue;
      }
      if (i > getMeasuredWidth()) {
        i = getMeasuredWidth() - arrayOfInt[0];
      }
      for (;;)
      {
        n = m;
        i1 = k;
        if (i <= m) {
          break;
        }
        i1 = j;
        n = i;
        break;
        if (arrayOfInt[0] >= 0) {
          i = localView.getWidth();
        }
      }
    }
    if (k > this.mCurrentPage) {
      setQvPage(this.mCurrentPage + 1);
    }
    for (;;)
    {
      return getChildAt(k);
      if (k < this.mCurrentPage) {
        setQvPage(this.mCurrentPage - 1);
      }
    }
  }
  
  public void initScreen(QuickView.QuickViewInfoProvider paramQuickViewInfoProvider)
  {
    this.mPageLP = super.init(paramQuickViewInfoProvider);
    if (this.mMenuAppsGrid == null) {
      this.mMenuAppsGrid = ((Launcher)getContext()).getMenuView().getMenuAppsGrid();
    }
    int j = paramQuickViewInfoProvider.getNumPages();
    this.mScroller = new Scroller(getContext(), null, false);
    int i = 0;
    while (i < j)
    {
      makeScreen(i, false).setContentDescription(String.format(getContext().getString(2131755118), new Object[] { Integer.valueOf(i + 1), Integer.valueOf(j) }));
      i += 1;
    }
  }
  
  protected boolean isValidTag(Object paramObject)
  {
    return paramObject != null;
  }
  
  void loadLayoutParameters()
  {
    Object localObject = ViewConfiguration.get(getContext());
    this.mOrientation = getResources().getConfiguration().orientation;
    this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.mTempRects = null;
    localObject = reloadLayoutParameters();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      localView.setPadding(this.mPanelPadding.left, this.mPanelPadding.top, this.mPanelPadding.right, this.mPanelPadding.bottom);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i += 1;
    }
  }
  
  protected void measureChildViews()
  {
    setMeasuredDimension(View.MeasureSpec.getSize(this.mWidthMeasureSpec), View.MeasureSpec.getSize(this.mHeightMeasureSpec));
    int j = getChildCount();
    if (j == 0) {}
    for (;;)
    {
      return;
      int k = View.MeasureSpec.makeMeasureSpec(getChildAt(0).getWidth(), 1073741824);
      int m = View.MeasureSpec.makeMeasureSpec(getChildAt(0).getHeight(), 1073741824);
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() != 8) {
          localView.measure(k, m);
        }
        i += 1;
      }
    }
  }
  
  public boolean moveCurrentPage(boolean paramBoolean)
  {
    boolean bool2 = false;
    int[] arrayOfInt = new int[2];
    boolean bool1 = bool2;
    if (this.mCurrentPage >= 0)
    {
      bool1 = bool2;
      if (this.mCurrentPage < getChildCount())
      {
        bool1 = bool2;
        if (this.mTouchState != 2)
        {
          getChildAt(this.mCurrentPage).getLocationInWindow(arrayOfInt);
          if ((arrayOfInt != null) && (arrayOfInt[0] < 0)) {
            arrayOfInt[0] -= 1;
          }
          scroll(arrayOfInt[0] - this.mChildLeft, 0, paramBoolean);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    if (!isAnimStateOkayForClickEvents()) {}
    while ((paramView == null) || (this.mTouchState == 2)) {
      return;
    }
    if (paramView.equals(getTargetPage()))
    {
      drawCloseAnimation();
      return;
    }
    setQvPage(((Integer)paramView.getTag()).intValue());
    moveCurrentPage(true);
    drawCloseAnimation();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mConfigurationChangeIsInProgress = true;
    if ((this.mQVProvider != null) && (!this.mDropCheck))
    {
      if (!LauncherApplication.isTabletLayout()) {
        cancelDrag();
      }
      refreshView();
    }
    if (LauncherApplication.isTabletLayout()) {
      return;
    }
    Object localObject = getResources();
    int i;
    int j;
    if (paramConfiguration.orientation == 2)
    {
      i = 1;
      j = ((Resources)localObject).getDimensionPixelSize(2131624190);
      paramConfiguration = ((Launcher)getContext()).mHomeView.getDeleteDropLayout();
      if (paramConfiguration != null)
      {
        localObject = (FrameLayout.LayoutParams)paramConfiguration.getLayoutParams();
        if ((i == 0) || (LauncherApplication.isDeleteDropTargetTop())) {
          break label193;
        }
        ((FrameLayout.LayoutParams)localObject).width = j;
        ((FrameLayout.LayoutParams)localObject).height = -1;
        ((FrameLayout.LayoutParams)localObject).gravity = 21;
        label126:
        if ((LauncherApplication.isDeleteDropTargetTop()) && (LauncherApplication.isDeleteDropTargetTextRight()))
        {
          if (i == 0) {
            break label215;
          }
          ((QuickViewDragBar)paramConfiguration).setTextDisplayPositionRight(true);
        }
      }
    }
    for (;;)
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler();
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          QuickViewMainMenu.access$102(QuickViewMainMenu.this, false);
        }
      }, 500L);
      return;
      i = 0;
      break;
      label193:
      ((FrameLayout.LayoutParams)localObject).width = -1;
      ((FrameLayout.LayoutParams)localObject).height = j;
      ((FrameLayout.LayoutParams)localObject).gravity = 49;
      break label126;
      label215:
      ((QuickViewDragBar)paramConfiguration).setTextDisplayPositionRight(false);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isAnimating()) {
      return true;
    }
    this.mOrientation = getResources().getConfiguration().orientation;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.mTouchState != 0)
    {
      return true;
      int i;
      int j;
      if (paramMotionEvent.getPointerCount() > 1)
      {
        if ((this.mMultiTouchUsed) && (this.mPinchOutProcess))
        {
          this.mTouchState = 0;
          i = (int)(f2 - paramMotionEvent.getY(1));
          j = (int)(f1 - paramMotionEvent.getX(1));
          if (((int)Math.sqrt(i * i + j * j) - this.mTouchPointDistance > 50) && (getChildAt(this.mPinchOutIndex) != null))
          {
            this.mMultiTouchUsed = false;
            this.mPinchOutProcess = false;
            this.mCurrentPage = this.mPinchOutIndex;
            drawCloseAnimation();
            return true;
          }
        }
      }
      else
      {
        j = (int)(this.mLastMotionX - f1);
        i = this.mTouchSlop;
        if (Math.abs(j) > i) {}
        for (i = 1;; i = 0)
        {
          if ((this.mTouchState == 0) && (i != 0))
          {
            this.mTouchState = 1;
            scroll(j, 0, false);
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
          }
          this.mMultiTouchUsed = false;
          this.mPinchOutProcess = false;
          break;
        }
        if (this.mDvfsHelper != null) {
          this.mDvfsHelper.acquire();
        }
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        i = Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX());
        if ((this.mScroller.isFinished()) || (i < this.mTouchSlop))
        {
          this.mTouchState = 0;
          this.mScroller.abortAnimation();
        }
        else
        {
          this.mTouchState = 1;
          continue;
          if (this.mMultiTouchUsed)
          {
            this.mMultiTouchUsed = false;
            this.mPinchOutProcess = false;
          }
          else if (this.mTouchState == 2)
          {
            this.mScrollState = 0;
            this.mScrollRunnable.removeSelf();
            endDrag();
            continue;
            if ((this.mTouchState == 0) && (!this.mMultiTouchUsed))
            {
              this.mMultiTouchUsed = true;
              float f3 = (int)paramMotionEvent.getY(1);
              float f4 = (int)paramMotionEvent.getX(1);
              if (getTouchedIndex((int)f1, (int)f2) == getTouchedIndex((int)f4, (int)f3))
              {
                i = (int)(f2 - f3);
                j = (int)(f1 - f4);
                this.mPinchOutProcess = true;
                this.mTouchPointDistance = ((int)Math.sqrt(i * i + j * j));
                this.mPinchOutIndex = getTouchedIndex((int)f1, (int)f2);
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    if ((!isChangingOrientation()) && (this.mEnabledChildAnimation) && (this.mAnimationState == 7))
    {
      paramInt2 = 1;
      if ((paramBoolean) || (!this.mConfigurationChangeIsInProgress) || (LauncherApplication.isTabletLayout()))
      {
        measureChildViews();
        updateParamsIfNeeded(paramBoolean);
        this.mMaxDeltaX = 0;
        k = getChildCount();
        if (k >= 1) {
          break label74;
        }
      }
    }
    label74:
    label441:
    label582:
    label615:
    for (;;)
    {
      return;
      paramInt2 = 0;
      break;
      if ((this.mChildRects == null) || (this.mChildRects.length != k)) {
        this.mChildRects = new Rect[k];
      }
      if ((this.mChildAnimate == null) || (this.mChildAnimate.length != k))
      {
        if (this.mChildAnimate != null)
        {
          paramInt4 = 0;
          while (paramInt4 < this.mChildAnimate.length)
          {
            this.mChildAnimate[paramInt4].stop();
            paramInt4 += 1;
          }
        }
        this.mChildAnimate = new QuickView.Animate[k];
        paramInt4 = 0;
        while (paramInt4 < k)
        {
          this.mChildAnimate[paramInt4] = new QuickView.Animate(this);
          paramInt4 += 1;
        }
      }
      getChildAt(0);
      Object localObject = getChildLayoutParams();
      int m = ((FrameLayout.LayoutParams)localObject).width;
      int n = ((FrameLayout.LayoutParams)localObject).height;
      this.mScrollWidth = (this.mChildGapH + m);
      this.mScrollHalfWidth = (this.mScrollWidth / 2);
      this.mChildLeft = ((getMeasuredWidth() - m) / 2);
      paramInt4 = this.mChildLeft;
      int i1 = getResources().getDimensionPixelSize(2131624257) + getResources().getDimensionPixelSize(2131623958);
      int i = 0;
      if (i < k)
      {
        localObject = getChildAt(i);
        int j = paramInt4;
        if (((View)localObject).getVisibility() != 8)
        {
          if (this.mChildRects[i] == null) {
            this.mChildRects[i] = new Rect();
          }
          this.mChildRects[i].set(paramInt4, i1, paramInt4 + m, i1 + n);
          ((View)localObject).getHitRect(sHitRect);
          if ((sHitRect.isEmpty()) || (paramInt2 == 0)) {
            break label441;
          }
          if (((View)localObject).getVisibility() == 0) {
            this.mChildAnimate[i].start((View)localObject, this.mChildRects[i]);
          }
        }
        for (;;)
        {
          j = paramInt4 + (this.mChildGapH + m);
          i += 1;
          paramInt4 = j;
          break;
          ((View)localObject).layout(this.mChildRects[i].left, this.mChildRects[i].top, this.mChildRects[i].right, this.mChildRects[i].bottom);
        }
      }
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - this.mChildGapH + this.mChildLeft;
      if (paramInt2 > paramInt1)
      {
        this.mMaxDeltaX = (paramInt2 - paramInt1);
        paramInt1 = this.mCurrentPage;
        if (this.mAnimationState != 1) {
          break label582;
        }
        setScrollX(getChildAt(paramInt1).getLeft() - this.mChildLeft);
      }
      for (;;)
      {
        if (!this.mConfigurationChangeIsInProgress) {
          break label615;
        }
        setScrollX(getChildAt(paramInt1).getLeft() - this.mChildLeft);
        return;
        this.mMaxDeltaX = 0;
        break;
        if (this.mAnimationState == 10)
        {
          setScrollX(getChildAt(paramInt1).getLeft() - this.mChildLeft);
          this.mAnimationState = 7;
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!isAnimStateOkayForClickEvents()) {}
    while ((!paramView.equals(getChildAt(this.mCurrentPage))) || (this.mMultiTouchUsed) || (getChildCount() <= 1)) {
      return false;
    }
    startDrag(paramView);
    this.mScrollState = 0;
    performHapticFeedback(0);
    invalidate();
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == 0) || (View.MeasureSpec.getMode(paramInt2) == 0)) {
      throw new IllegalArgumentException("CellLayoutChildren cannot accept an UNSPECIFIED MeasureSpec");
    }
    super.onMeasure(paramInt1, paramInt2);
    this.mWidthMeasureSpec = paramInt1;
    this.mHeightMeasureSpec = paramInt2;
  }
  
  public boolean onPinchOut()
  {
    if (getChildAt(this.mPinchOutIndex) != null) {
      super.onPinchOut();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isAnimating()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        if (!this.mScroller.isFinished())
        {
          this.mScroller.abortAnimation();
          computeScroll();
          continue;
          j = (int)(this.mLastMotionX - f1);
          int k = (int)(this.mLastMotionY - f2);
          if (Math.abs(j) > this.mTouchSlop) {}
          for (i = 1;; i = 0)
          {
            if ((i != 0) && (this.mTouchState == 0)) {
              this.mTouchState = 1;
            }
            if (this.mTouchState != 1) {
              break label187;
            }
            scroll(j, 0, false);
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
            break;
          }
          if (this.mTouchState == 2)
          {
            if (this.mDraggingView != null)
            {
              this.mDraggingView.layout(this.mDraggingView.getLeft() - j, this.mDraggingView.getTop() - k, this.mDraggingView.getRight() - j, this.mDraggingView.getBottom() - k);
              invalidate();
            }
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
            if (this.mDragState == 1) {
              this.mDragState = 0;
            }
            j = getTouchedIndex((int)f1, (int)f2);
            if ((j != -1) && (j != this.mDraggingIndex) && (getChildAt(j) != null)) {
              i = 1;
            }
            for (;;)
            {
              if (i != 0)
              {
                if (this.mDraggingView == null) {
                  break;
                }
                if (this.mDraggingIndex < j)
                {
                  scrollToRight();
                  break;
                  i = 0;
                  continue;
                }
                if (this.mDraggingIndex <= j) {
                  break;
                }
                scrollToLeft();
                break;
              }
            }
            this.mScrollState = 0;
            this.mScrollRunnable.removeSelf();
          }
        }
      }
    case 1: 
      label187:
      if (this.mTouchState == 1)
      {
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
        i = (int)paramMotionEvent.getXVelocity(0);
        j = this.mCurrentPage;
        getTargetPage();
        if ((Math.abs(i) > this.mMinimumVelocity) && (j == this.mCurrentPage))
        {
          if (i > 0) {
            setQvPage(this.mCurrentPage - 1);
          }
        }
        else
        {
          label459:
          snapToQvPage();
          if (this.mVelocityTracker != null)
          {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
          }
          this.mTouchState = 0;
        }
      }
      break;
    }
    for (;;)
    {
      if ((this.mTouchState == 2) && (this.mOrientation == getResources().getConfiguration().orientation))
      {
        this.mScrollState = 0;
        this.mScrollRunnable.removeSelf();
        drop((int)f1, (int)f2);
      }
      if ((this.mDraggingView != null) || (this.mTouchedView != null)) {
        invalidate();
      }
      endDrag();
      if (this.mDvfsHelper == null) {
        break;
      }
      this.mDvfsHelper.release();
      break;
      if (i >= 0) {
        break label459;
      }
      setQvPage(this.mCurrentPage + 1);
      break label459;
      float f3 = getMeasuredHeight() - this.mMenuAppsGrid.getMeasuredHeight();
      i = this.mMenuAppsGrid.getPageIndicatorManager().snapPageTouchArea(f1, f2 - f3);
      if (i > -1)
      {
        setQvPage(i);
        snapToQvPage();
      }
    }
  }
  
  public void open()
  {
    super.open();
    this.mIsSaved = false;
    Talk.INSTANCE.say(2131755045);
  }
  
  void refreshView()
  {
    initScreen(this.mQVProvider);
    this.mDragState = 0;
    requestLayout();
  }
  
  public void scrollLeft()
  {
    if (!setQvPage(this.mCurrentPage - 1)) {
      return;
    }
    scrollStart(-1);
    scroll(-this.mScrollWidth, 0, true);
    invalidate();
  }
  
  public void scrollRight()
  {
    if (!setQvPage(this.mCurrentPage + 1)) {
      return;
    }
    scrollStart(1);
    scroll(this.mScrollWidth, 0, true);
    invalidate();
  }
  
  public void scrollStart(int paramInt)
  {
    int j = this.mDraggingIndex;
    int i = j;
    if (this.mDraggingIndex + paramInt >= 0)
    {
      i = j;
      if (this.mDraggingIndex + paramInt < getChildCount()) {
        i = this.mDraggingIndex + paramInt;
      }
    }
    removeView(this.mDraggingView);
    addView(this.mDraggingView, i);
    this.mDraggingView.setVisibility(4);
    setQvPage(i);
    this.mDraggingIndex = i;
  }
  
  public void scrollToLeft()
  {
    this.mScrollState = 1;
    this.mScrollRunnable.postForScrollDelayed();
  }
  
  public void scrollToRight()
  {
    this.mScrollState = 2;
    this.mScrollRunnable.postForScrollDelayed();
  }
  
  public boolean setQvPage(int paramInt)
  {
    int i = getChildCount();
    if ((paramInt >= 0) && (paramInt < i))
    {
      this.mCurrentPage = paramInt;
      this.mQVProvider.setPage(paramInt);
      return true;
    }
    return false;
  }
  
  public void setReadOnly(boolean paramBoolean)
  {
    this.mIsReadOnly = paramBoolean;
  }
  
  public void setReadOnlyToastId(int paramInt)
  {
    this.mReadOnlyToastResId = paramInt;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt1, paramInt2, 600);
      this.mScrollCheck = true;
      invalidate();
      return;
    }
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    scrollBy(paramInt1, paramInt2);
  }
  
  public void snapToQvPage()
  {
    int[] arrayOfInt = new int[2];
    if ((this.mCurrentPage >= 0) && (this.mCurrentPage < getChildCount()) && (this.mTouchState != 2))
    {
      getChildAt(this.mCurrentPage).getLocationInWindow(arrayOfInt);
      if ((arrayOfInt != null) && (arrayOfInt[0] < 0)) {
        arrayOfInt[0] -= 1;
      }
      this.mScroller.startScroll(getScrollX(), getScrollY(), arrayOfInt[0] - this.mChildLeft, 0, 400);
      this.mScrollCheck = true;
      invalidate();
    }
  }
  
  protected void swapScreen(int paramInt)
  {
    if (!this.mIsReadOnly)
    {
      zOrderTweakMoveChild(this, indexOfChild(this.mDraggingView) + 0, paramInt + 0);
      this.mQVProvider.movePage(this.mOriginDragIndex + 0, paramInt + 0);
      setQvPage(paramInt);
      updateTags();
    }
  }
  
  protected void updateTags()
  {
    int k = getChildCount();
    if (getChildCount() == k) {}
    for (int i = k;; i = k - 1)
    {
      int j = 0;
      while (j < k)
      {
        View localView = getChildAt(j);
        localView.setTag(Integer.valueOf(j));
        localView.setContentDescription(String.format(getContext().getString(2131755118), new Object[] { Integer.valueOf(j + 1), Integer.valueOf(i) }));
        j += 1;
      }
    }
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
      if ((this.mState == 0) && (QuickViewMainMenu.this.mHandler.postDelayed(this, QuickViewMainMenu.this.PAGE_SNAP_ANIMATION_DURATION))) {
        this.mState = 1;
      }
      QuickViewMainMenu.this.invalidate();
    }
    
    public void postForScrollDelayed()
    {
      if ((this.mState == 0) && (QuickViewMainMenu.this.mHandler.postDelayed(this, QuickViewMainMenu.this.mScrollDelay))) {
        this.mState = 2;
      }
      QuickViewMainMenu.this.invalidate();
    }
    
    public void removeSelf()
    {
      if (this.mState != 0)
      {
        QuickViewMainMenu.this.mHandler.removeCallbacks(this);
        this.mState = 0;
        QuickViewMainMenu.this.invalidate();
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
      } while (((Launcher)QuickViewMainMenu.this.getContext()).isLauncherDestroyed());
      if (i == 1)
      {
        postForScrollDelayed();
        return;
      }
      switch (QuickViewMainMenu.this.mScrollState)
      {
      case 0: 
      default: 
        return;
      case 1: 
        if (QuickViewMainMenu.this.mIsReadOnly) {
          if (QuickViewMainMenu.this.mReadOnlyToastResId != -1) {
            Toast.makeText(QuickViewMainMenu.this.getContext(), QuickViewMainMenu.this.getContext().getString(QuickViewMainMenu.this.mReadOnlyToastResId), 0).show();
          }
        }
        for (;;)
        {
          postForScrollToComplete();
          return;
          QuickViewMainMenu.this.scrollLeft();
        }
      }
      if (QuickViewMainMenu.this.mIsReadOnly) {
        if (QuickViewMainMenu.this.mReadOnlyToastResId != -1) {
          Toast.makeText(QuickViewMainMenu.this.getContext(), QuickViewMainMenu.this.getContext().getString(QuickViewMainMenu.this.mReadOnlyToastResId), 0).show();
        }
      }
      for (;;)
      {
        postForScrollToComplete();
        return;
        QuickViewMainMenu.this.scrollRight();
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/QuickViewMainMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */