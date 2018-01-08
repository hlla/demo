package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.Toast;
import com.android.launcher2.guide.GuideFragment;
import com.samsung.android.feature.FloatingFeature;
import com.sec.dtl.launcher.Talk;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickViewWorkspace
  extends QuickView
{
  private static final Object ADD_BTN_TAG = new Object();
  private static final int ANIMATED_SCROLL_DURATION = 600;
  private static final int INSIDE_LEFT_SCROLL_ZONE = 1;
  private static final int INSIDE_RIGHT_SCROLL_ZONE = 2;
  private static final int OUTSIDE_SCROLL_ZONE = 0;
  private static final int QV_PAGE_SNAP_ANIMATION_DURATION = 400;
  private static final ColorFilter RED_COLOR_FILTER = new LightingColorFilter(-6815744, -14680064);
  private static final int[][] ROW_BY_COL_LAYOUT;
  private static final String TAG = "QuickViewWorkspace";
  private static final int TOUCH_DRAG_DELETE = 1;
  private static final int TOUCH_DRAG_NORMAL = 0;
  private static Rect sHitRect = new Rect();
  public final int MENU_ZONE = getResources().getDimensionPixelSize(2131624195);
  public final int PAGE_SNAP_ANIMATION_DURATION = getResources().getInteger(2131492900);
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private Drawable mAddDrawable;
  private QuickView.Animate[] mChildAnimate = new QuickView.Animate[LauncherApplication.getMaxScreenCount()];
  private int mChildLeft;
  private boolean mConfigurationChangeIsInProgress = false;
  private int mDeleteIndex;
  private View mDeleteView;
  private int mDragState = 0;
  private Animator mEnterAnimator;
  private Animator mExitAnimator;
  private Handler mHandler = null;
  private int mHeightMeasureSpec;
  private final Drawable mHomeBgDrawable;
  private final Drawable mHomeBgMainDrawable;
  private Drawable mLeftHoverDrawable;
  private int mMaxDeltaX = 0;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private int mOrientation;
  private FrameLayout.LayoutParams mPageLP;
  private Drawable mRightHoverDrawable;
  private boolean mScrollCheck = false;
  private int mScrollDelay;
  private int mScrollHalfWidth;
  private ScrollRunnable mScrollRunnable = new ScrollRunnable();
  private int mScrollState = 0;
  private int mScrollWidth;
  Scroller mScroller;
  private final View.OnClickListener mSetHomeListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = ((View)paramAnonymousView.getParent()).getTag();
      if (!(paramAnonymousView instanceof Number)) {}
      while ((Launcher.isHelpAppRunning) && (("add_widgets".equals(GuideFragment.GMode)) || ("change_wallpaper".equals(GuideFragment.GMode)))) {
        return;
      }
      int j = ((Number)paramAnonymousView).intValue();
      paramAnonymousView = QuickViewWorkspace.this.getContext();
      if (j != LauncherApplication.getHomeScreenIndex()) {
        Toast.makeText(paramAnonymousView, paramAnonymousView.getString(2131755134), 0).show();
      }
      QuickViewWorkspace.this.mWsQVProvider.setHomeScreenAt(j);
      int k = QuickViewWorkspace.this.getChildCount();
      int i = 0;
      if (i < k)
      {
        paramAnonymousView = QuickViewWorkspace.this.getChildAt(i);
        if (((paramAnonymousView instanceof ViewGroup)) && (((ViewGroup)paramAnonymousView).getChildCount() >= 1))
        {
          paramAnonymousView = (ViewGroup)((ViewGroup)paramAnonymousView).getChildAt(0);
          if (paramAnonymousView.getChildCount() >= 1)
          {
            paramAnonymousView = paramAnonymousView.getChildAt(0);
            if ((paramAnonymousView instanceof CompoundButton))
            {
              paramAnonymousView = (CompoundButton)paramAnonymousView;
              if (i != j) {
                break label200;
              }
            }
          }
        }
        label200:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          i += 1;
          break;
        }
      }
      QuickViewWorkspace.this.invalidate();
      QuickViewWorkspace.this.mWorkspace.invalidate();
    }
  };
  private Rect[] mTempRects;
  private VelocityTracker mVelocityTracker;
  private int mWidthMeasureSpec;
  private Workspace mWorkspace;
  WorkspaceQuickViewInfoProvider mWsQVProvider;
  private View vDeleteDropLayout;
  
  static
  {
    int[] arrayOfInt1 = { 2 };
    int[] arrayOfInt2 = { 2, 1 };
    int[] arrayOfInt3 = { 2, 2, 2 };
    int[] arrayOfInt4 = { 2, 3, 2 };
    int[] arrayOfInt5 = { 3, 3, 3 };
    ROW_BY_COL_LAYOUT = new int[][] { { 1 }, arrayOfInt1, arrayOfInt2, { 2, 2 }, { 2, 1, 2 }, arrayOfInt3, arrayOfInt4, { 3, 3, 2 }, arrayOfInt5 };
  }
  
  public QuickViewWorkspace(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuickViewWorkspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickViewWorkspace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = LauncherApplication.getMaxScreenCount();
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
    this.mEnterAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        paramAnonymousAnimator = (FrameLayout.LayoutParams)QuickViewWorkspace.this.getLayoutParams();
        paramAnonymousAnimator.setMargins(0, 0, 0, QuickViewWorkspace.this.getResources().getDimensionPixelSize(2131624258));
        QuickViewWorkspace.this.setLayoutParams(paramAnonymousAnimator);
      }
    });
    this.mExitAnimator = AnimatorInflater.loadAnimator(paramContext, 2131034131);
    this.mExitAnimator.setDuration(360L);
    this.mHomeBgDrawable = paramContext.getResources().getDrawable(2130837660);
    this.mHomeBgMainDrawable = paramContext.getResources().getDrawable(2130837661);
  }
  
  private void addScreen()
  {
    int k = getChildCount();
    int j = k - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    View localView = getChildAt(i);
    j = LauncherApplication.getMaxScreenCount();
    if ((k >= j) && (localView.getTag() != ADD_BTN_TAG)) {
      return;
    }
    if (k == j) {
      removeView(localView);
    }
    makeScreen(i, false).setOnLongClickListener(this);
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
      this.mWorkspace.insertWorkspaceScreen(LauncherApplication.getScreenCount(), true);
    }
    for (;;)
    {
      updateTags();
      if ((getChildCount() > 2) && (this.vDeleteDropLayout != null)) {
        ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(true);
      }
      ((Launcher)getContext()).mHomeView.getWorkspace().setAllEmptyMessageVisibility(false);
      this.mWsQVProvider.updateWallpaperOffsets();
      setQvPage(i);
      Talk.INSTANCE.say(2131755098);
      return;
      this.mWsQVProvider.addPage();
      this.mWorkspace.setCurrentPage(this.mWorkspace.getChildCount() - 1);
    }
  }
  
  private void enableWorkspaceScreensCache()
  {
    int j = this.mWsQVProvider.getNumPages();
    int i = 0;
    while (i < j)
    {
      CellLayout localCellLayout = this.mWsQVProvider.getPage(i);
      localCellLayout.setChildrenDrawingCacheEnabled(true);
      localCellLayout.setChildrenDrawnWithCacheEnabled(true);
      i += 1;
    }
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
  
  private boolean isDeleteDropTarget(int paramInt1, int paramInt2)
  {
    QuickViewDragBar localQuickViewDragBar = this.mWsQVProvider.getDeleteDropLayout();
    if ((localQuickViewDragBar.getVisibility() == 0) && (getChildCount() > 2)) {
      return localQuickViewDragBar.checkOver(paramInt1, paramInt2);
    }
    return false;
  }
  
  private static boolean isHome(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramView instanceof ViewGroup))
    {
      paramView = ((ViewGroup)((ViewGroup)paramView).getChildAt(0)).getChildAt(0);
      bool1 = bool2;
      if ((paramView instanceof Checkable)) {
        bool1 = ((Checkable)paramView).isChecked();
      }
    }
    return bool1;
  }
  
  private View makeAddBtn()
  {
    View localView = makeScreen(getChildCount(), true);
    localView.setTag(ADD_BTN_TAG);
    localView.setContentDescription(getContext().getString(2131755047) + ", " + getContext().getString(2131755048));
    return localView;
  }
  
  private View makeScreen(int paramInt, boolean paramBoolean)
  {
    Object localObject = getContext();
    FrameLayout localFrameLayout1 = new FrameLayout((Context)localObject);
    Resources localResources = ((Context)localObject).getResources();
    FrameLayout localFrameLayout2 = new FrameLayout((Context)localObject);
    localFrameLayout2.setLayoutParams(new FrameLayout.LayoutParams(getChildLayoutParams().width, -2, 49));
    localObject = new MarkAsHomeButton((Context)localObject);
    ((MarkAsHomeButton)localObject).setPadding(0, 0, 0, 0);
    if (paramInt == LauncherApplication.getHomeScreenIndex()) {}
    for (boolean bool = true;; bool = false)
    {
      ((MarkAsHomeButton)localObject).setChecked(bool);
      ((MarkAsHomeButton)localObject).setContentDescription(getResources().getString(2131755032));
      if (!paramBoolean) {
        localFrameLayout2.addView((View)localObject);
      }
      localFrameLayout2.setOnClickListener(this.mSetHomeListener);
      localFrameLayout1.addView(localFrameLayout2);
      int i = localResources.getInteger(2131492888);
      int j = localResources.getInteger(2131492889);
      localFrameLayout2.setPadding(localResources.getInteger(2131492890), j, i, 0);
      addView(localFrameLayout1, paramInt, this.mPageLP);
      localFrameLayout1.setPadding(this.mPanelPadding.left, this.mPanelPadding.top, this.mPanelPadding.right, this.mPanelPadding.bottom);
      localFrameLayout1.setTag(Integer.valueOf(paramInt));
      localFrameLayout1.setFocusable(true);
      localFrameLayout1.setOnLongClickListener(this);
      localFrameLayout1.setOnClickListener(this);
      return localFrameLayout1;
    }
  }
  
  private void onDrawComplete(Canvas paramCanvas)
  {
    if ((this.mScrollState == 0) || (this.mScrollRunnable.mState != 2))
    {
      if ((this.mScroller.isFinished()) && (this.mScrollCheck == true))
      {
        paramCanvas = ((Launcher)getContext()).getHomeView().getWorkspace();
        paramCanvas.getChildAt(paramCanvas.getCurrentPage()).setVisibility(4);
        this.mScrollCheck = false;
      }
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
  
  void cancelDeleteView()
  {
    if (this.mDeleteView == null) {
      return;
    }
    this.mDeleteView = null;
    this.mDeleteIndex = -1;
    this.mDragState = 0;
  }
  
  public void cancelDrag()
  {
    isDeleteDropTarget(-1, -1);
    super.cancelDrag();
    this.mDragState = 0;
  }
  
  public void close(boolean paramBoolean)
  {
    super.close();
    cancelDeleteView();
    this.mWorkspace.setAllEmptyMessageVisibility(true);
    Object localObject = this.mWsQVProvider.getDeleteDropLayout();
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = getResources();
    this.mWorkspace.updateIndicator(((Resources)localObject).getDimensionPixelSize(2131624160), ((Resources)localObject).getDimensionPixelSize(2131624159));
    if (((Launcher)getContext()).mHomeView != null) {
      ((Launcher)getContext()).mHomeView.setVisibilityHomeOptionMenu(8);
    }
    enableWorkspaceScreensCache();
    if (paramBoolean) {
      this.mWsQVProvider.setDarkenViewAlpha(0.0F);
    }
    this.mWorkspace.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.ALL_PAGE);
    Talk.INSTANCE.sayByTalkback(this.mWorkspace, 2131755118, this.mWsQVProvider.getCurrentPage() + 1, this.mWsQVProvider.getNumPages(), true);
  }
  
  public void computeScroll()
  {
    if ((getChildCount() == 0) || (this.mChildRects == null)) {}
    while (!this.mScroller.computeScrollOffset()) {
      return;
    }
    int i = getScrollX();
    getScrollY();
    int j = this.mScroller.getCurrX();
    int k = this.mScroller.getCurrY();
    setScrollX(j);
    setScrollY(k);
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
  
  void disableWorkspaceScreensCache()
  {
    int j = this.mWsQVProvider.getNumPages();
    int i = 0;
    while (i < j)
    {
      this.mWsQVProvider.getPage(i).setChildrenDrawnWithCacheEnabled(false);
      i += 1;
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    Workspace localWorkspace = ((Launcher)getContext()).getHomeView().getWorkspace();
    int k = getChildCount();
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0)) {}
    Object localObject;
    int m;
    int n;
    do
    {
      return;
      j = this.mCurrentPage;
      if ((this.mAnimationState == 1) && (((this.mChildRects != null) && (this.mChildRects.length == k)) || (k <= 0))) {
        break;
      }
      if ((this.mTempRects != null) && (this.mTempRects.length == k)) {
        break label328;
      }
      localObject = getChildAt(0);
      i = getChildCount();
      m = ((View)localObject).getMeasuredWidth();
      n = ((View)localObject).getMeasuredHeight();
    } while (i < 1);
    if ((this.mChildRects == null) || (this.mChildRects.length != k)) {
      this.mChildRects = new Rect[k];
    }
    getViewLayout(k, m, n);
    label328:
    for (this.mChildRects = this.mTempRects; this.mAnimationState == 1; this.mChildRects = this.mTempRects)
    {
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.mAnimationState = 2;
      this.mPinchIndex = this.mQVProvider.getCurrentPage();
      this.mIsWorkspace = true;
      setOpenStartRect(j);
      if (this.mWsQVProvider != null)
      {
        localObject = this.mWsQVProvider.getDeleteDropLayout();
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
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
      if (this.mWsQVProvider != null)
      {
        localObject = this.mWsQVProvider.getDeleteDropLayout();
        if (localObject != null) {
          ((View)localObject).setAlpha(0.0F);
        }
        localObject = this.mWsQVProvider.getHomeScreenOptionMenu();
        if (localObject != null) {
          ((View)localObject).setAlpha(0.0F);
        }
        localObject = (FrameLayout.LayoutParams)getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
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
      if (this.mWsQVProvider != null) {
        this.mWsQVProvider.onQuickViewCloseAnimationStarted();
      }
    }
    if (this.mTouchState == 2)
    {
      i = 0;
      while (i < k)
      {
        localObject = getChildAt(i);
        if ((localObject != this.mDraggingView) && ((i == j - 1) || (i == j + 1))) {
          drawChild(paramCanvas, (View)localObject, i);
        }
        i += 1;
      }
      drawChild(paramCanvas, this.mDraggingView, 0);
    }
    for (;;)
    {
      if (this.mAnimationState == 8) {
        localWorkspace.invalidate();
      }
      onDrawComplete(paramCanvas);
      return;
      if ((this.mAnimationState == 2) || (this.mAnimationState == 4))
      {
        if ((this.mAnimationState == 4) && (this.mPinchIndex != this.mQVProvider.getCurrentPage()) && (this.mWsQVProvider != null)) {
          this.mWsQVProvider.updateWallpaperOffsets();
        }
        long l = SystemClock.uptimeMillis() - this.mAnimationStartTime;
        if (l >= this.mAnimationDuration) {
          if (this.mAnimationState == 4)
          {
            if (this.mWsQVProvider != null) {
              this.mWsQVProvider.onQuickViewCloseAnimationCompleted();
            }
            this.mAnimationState = 8;
          }
        }
        label747:
        for (float f = 1.0F;; f = (float)l / this.mAnimationDuration)
        {
          if (((this.mCurrentRects == null) || (this.mCurrentRects.length != k)) && (k > 0)) {
            this.mCurrentRects = new Rect[k];
          }
          this.mCurrentRects = this.mAniEngine.getRect(this.mStartRects, this.mFinishRects, this.mCurrentRects, f);
          if (this.mCurrentRects != null) {
            break label906;
          }
          Log.e("QuickViewWorkspace", "Failed to get current rectangles from animation engine");
          if ((this.mAnimationState == 2) || (this.mAnimationState == 7))
          {
            if (this.mAnimationState == 7) {
              f = 1.0F;
            }
            if (this.mWsQVProvider != null)
            {
              localObject = this.mWsQVProvider.getHomeScreenOptionMenu();
              if (localObject != null) {
                ((View)localObject).setAlpha(f);
              }
            }
          }
          invalidate();
          break;
          this.mAnimationState = 7;
          break label747;
        }
        label906:
        i = 0;
        label908:
        if (i < k)
        {
          localObject = getChildAt(i);
          ((View)localObject).layout(this.mCurrentRects[i].left, this.mCurrentRects[i].top, this.mCurrentRects[i].right, this.mCurrentRects[i].bottom);
          if (isAvailableRect(this.mCurrentRects[i]))
          {
            if (((f >= 0.5D) || (this.mAnimationState != 2)) && ((f <= 0.5D) || (this.mAnimationState != 4))) {
              break label1030;
            }
            if (i == j) {
              drawChild(paramCanvas, (View)localObject, i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break label908;
          break;
          label1030:
          if ((i == j - 1) || (i == j) || (i == j + 1)) {
            drawChild(paramCanvas, (View)localObject, i);
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
    float f4 = paramInt / 2.0F;
    float f5 = i / 2.0F;
    float f6 = paramView.getLeft() + f4;
    float f7 = paramView.getTop() + f5;
    int j = getContext().getResources().getInteger(2131492887);
    paramCanvas.save();
    Object localObject;
    label118:
    float f1;
    label141:
    label146:
    float f2;
    label198:
    float f3;
    if (isHome(paramView))
    {
      localObject = this.mHomeBgMainDrawable;
      if (this.mTouchedView != paramView) {
        break label634;
      }
      if ((this.mDragState != 1) || (getChildCount() <= 2)) {
        break label617;
      }
      ((Drawable)localObject).setColorFilter(RED_COLOR_FILTER);
      paramView.performAccessibilityAction(128, null);
      if (mScaleFactor + 0.02F >= 1.15F) {
        break label626;
      }
      f1 = mScaleFactor + 0.02F;
      mScaleFactor = f1;
      paramCanvas.translate(f6, f7);
      paramCanvas.scale(f1, f1);
      paramCanvas.translate(-f4, -f5);
      f2 = (int)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / this.mAnimationDuration;
      if (this.mAnimationState != 2) {
        break label646;
      }
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
      int k = (int)(255.0F * f2);
      if (getVisibility() == 0)
      {
        ((Drawable)localObject).setAlpha(k);
        ((Drawable)localObject).setBounds(j, 0, paramInt, i);
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = paramView.getTag();
      if ((localObject == ADD_BTN_TAG) || (!(localObject instanceof Integer))) {
        break label667;
      }
      paramCanvas.restore();
      localObject = this.mWsQVProvider.getPage(((Integer)localObject).intValue());
      ((CellLayout)localObject).setAlpha(1.0F);
      ((CellLayout)localObject).setBackgroundAlpha(0.0F, 0.0F);
      j = ((CellLayout)localObject).getWidth();
      k = ((CellLayout)localObject).getHeight();
      float f8 = ((ViewGroup)paramView).getChildAt(0).getHeight() * f2;
      f2 = (paramInt - this.mPanelPadding.left - this.mPanelPadding.right) / j;
      f3 = (i - this.mPanelPadding.bottom - (this.mPanelPadding.top + f8)) / k;
      if (f3 <= f2) {
        break label655;
      }
      label440:
      f2 *= f1;
      paramCanvas.save();
      paramCanvas.translate((this.mPanelPadding.left - this.mPanelPadding.right) / 2.0F + f6, (this.mPanelPadding.top + f8 - this.mPanelPadding.bottom) / 2.0F + f7);
      paramCanvas.scale(f2, f2);
      paramCanvas.translate(-j / 2.0F, -k / 2.0F);
      ((CellLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      if ((this.mAnimationState == 4) || (this.mAnimationState == 2) || (this.mAnimationState == 8)) {
        break label662;
      }
    }
    label617:
    label626:
    label634:
    label646:
    label655:
    label662:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramCanvas.save();
        paramCanvas.translate(f6, f7);
        paramCanvas.scale(f1, f1);
        paramCanvas.translate(-f4, -f5);
        paramView.draw(paramCanvas);
        paramCanvas.restore();
      }
      return;
      localObject = this.mHomeBgDrawable;
      break;
      ((Drawable)localObject).setColorFilter(null);
      break label118;
      f1 = 1.15F;
      break label141;
      f1 = 1.0F;
      ((Drawable)localObject).setColorFilter(null);
      break label146;
      f2 = 1.0F - f2;
      break label198;
      f2 = f3;
      break label440;
    }
    label667:
    paramInt = this.mAddDrawable.getIntrinsicWidth();
    i = this.mAddDrawable.getIntrinsicHeight();
    paramCanvas.translate(f4 - paramInt / 2, f5 - i / 2);
    this.mAddDrawable.draw(paramCanvas);
    paramView.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean drawCloseAnimation()
  {
    if (super.drawCloseAnimation())
    {
      this.mWorkspace.setAllEmptyMessageVisibility(true);
      Resources localResources = getResources();
      if (Utilities.getDeviceRotation(getContext()) == 0) {
        this.mWorkspace.getPageIndicatorManager().getPageIndicator().setPageIndicatorPanelRightAdjust(localResources.getDimensionPixelSize(2131624108));
      }
      for (;;)
      {
        this.mWorkspace.updateIndicator(localResources.getDimensionPixelSize(2131624160), localResources.getDimensionPixelSize(2131624159));
        this.mWorkspace.updateIndicatorWidth(false);
        this.mWorkspace.invalidate();
        this.mExitAnimator.setTarget(this.mWorkspace);
        this.mExitAnimator.start();
        cancelDrag();
        cancelDeleteView();
        this.mWsQVProvider.wallpaperHack();
        invalidate();
        return true;
        if (Utilities.getDeviceRotation(getContext()) == 2) {
          this.mWorkspace.getPageIndicatorManager().getPageIndicator().setPageIndicatorPanelRightAdjust(localResources.getDimensionPixelSize(2131624109));
        }
      }
    }
    return false;
  }
  
  public void drawOpenAnimation()
  {
    Resources localResources = getResources();
    if (this.mWorkspace == null) {
      this.mWorkspace = ((Launcher)getContext()).mHomeView.getWorkspace();
    }
    this.mWorkspace.updateIndicator(localResources.getDimensionPixelSize(2131624161), localResources.getDimensionPixelSize(2131624159));
    if (getResources().getConfiguration().orientation == 1) {
      this.mWorkspace.updateIndicatorWidth(false);
    }
    for (;;)
    {
      this.mWorkspace.invalidate();
      this.mEnterAnimator.setTarget(this.mWorkspace);
      this.mEnterAnimator.start();
      super.drawOpenAnimation();
      return;
      this.mWorkspace.updateIndicatorWidth(true);
    }
  }
  
  protected void drop(int paramInt1, int paramInt2)
  {
    if ((isDeleteDropTarget(paramInt1, paramInt2)) && (this.mDragState == 1))
    {
      this.mDraggingView.setVisibility(0);
      this.mDraggingView.requestLayout();
      this.mWsQVProvider.getDeleteDropLayout().onDrop();
      removeView(this.mDraggingView);
      addView(this.mDraggingView, this.mDraggingIndex);
      swapScreen(this.mDraggingIndex);
      this.mDeleteIndex = this.mDraggingIndex;
      this.mDeleteView = this.mDraggingView;
      paramInt1 = this.mDeleteIndex;
      if (this.mWsQVProvider.isIncludeItem(paramInt1))
      {
        this.mWsQVProvider.showDeleteWorkScreen();
        if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
          performHapticFeedback(25687, 1);
        }
      }
    }
    while (this.mDraggingView == null) {
      for (;;)
      {
        return;
        removeScreen();
      }
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
    super.endDrag();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131624258));
    setLayoutParams(localLayoutParams);
    this.mDragState = 0;
    if (this.vDeleteDropLayout != null)
    {
      if (getChildCount() <= 2) {
        ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(false);
      }
    }
    else {
      return;
    }
    ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(true);
  }
  
  public void exitDrakenView()
  {
    this.mExitAnimator.setTarget(this.mWorkspace);
    this.mExitAnimator.start();
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
  
  public int getDeletePageIndex()
  {
    return this.mDeleteIndex;
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
    if (this.mWorkspace == null) {
      this.mWorkspace = ((Launcher)getContext()).mHomeView.getWorkspace();
    }
    this.mWsQVProvider = ((WorkspaceQuickViewInfoProvider)paramQuickViewInfoProvider);
    int j = paramQuickViewInfoProvider.getNumPages();
    int i = j;
    if (LauncherApplication.sFestivalPageLauncher)
    {
      i = j;
      if (Launcher.sIsFestivalModeOn)
      {
        i = j - LauncherApplication.getFestivalScreenCount();
        Log.i("QuickViewWorkspace", "initScreen() festival screenCount = " + i);
      }
    }
    paramQuickViewInfoProvider = getResources();
    this.mAddDrawable = paramQuickViewInfoProvider.getDrawable(2130837686);
    this.mAddDrawable.setBounds(0, 0, this.mAddDrawable.getIntrinsicWidth(), this.mAddDrawable.getIntrinsicHeight());
    MarkAsHomeButton.LP.setMargins(0, -this.mPanelPadding.left, -this.mPanelPadding.top, 0);
    this.mScroller = new Scroller(getContext(), null, false);
    j = 0;
    while (j < i)
    {
      makeScreen(j, false).setContentDescription(String.format(getContext().getString(2131755118), new Object[] { Integer.valueOf(j + 1), Integer.valueOf(i) }));
      j += 1;
    }
    if (i < LauncherApplication.getMaxScreenCount()) {
      makeAddBtn();
    }
    this.vDeleteDropLayout = this.mWsQVProvider.getDeleteDropLayout();
    if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (!LauncherApplication.getInst().isKnoxMode())) {}
    for (i = paramQuickViewInfoProvider.getDimensionPixelSize(2131624076);; i = paramQuickViewInfoProvider.getDimensionPixelSize(2131624260))
    {
      j = paramQuickViewInfoProvider.getDimensionPixelSize(2131624262);
      this.mWsQVProvider.getHomeScreenOptionMenu().setPadding(i, 0, i, j);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mWsQVProvider.getHomeScreenOptionMenu().getLayoutParams();
      localLayoutParams.height = paramQuickViewInfoProvider.getDimensionPixelSize(2131624259);
      this.mWsQVProvider.getHomeScreenOptionMenu().setLayoutParams(localLayoutParams);
      updateWidgetButtonState();
      return;
    }
  }
  
  protected boolean isValidTag(Object paramObject)
  {
    return paramObject != ADD_BTN_TAG;
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
          this.mWorkspace.invalidate();
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    if ((Launcher.isHelpAppRunning) && ((GuideFragment.GMode.equals("add_widgets")) || (GuideFragment.GMode.equals("change_wallpaper")))) {}
    while ((!isAnimStateOkayForClickEvents()) || (this.mWsQVProvider.isDeleteWorkScreenPopup()) || (paramView == null) || (this.mTouchState == 2)) {
      return;
    }
    if (paramView.equals(getTargetPage()))
    {
      if (paramView.getTag().equals(ADD_BTN_TAG))
      {
        addScreen();
        return;
      }
      drawCloseAnimation();
      return;
    }
    if (paramView.getTag() != ADD_BTN_TAG)
    {
      setQvPage(((Integer)paramView.getTag()).intValue());
      moveCurrentPage(true);
      drawCloseAnimation();
      return;
    }
    setQvPage(getChildCount() - 1);
    moveCurrentPage(true);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mConfigurationChangeIsInProgress = true;
    Object localObject = ((Launcher)getContext()).mHomeView;
    Resources localResources = getResources();
    boolean bool;
    if (paramConfiguration.orientation == 2)
    {
      bool = true;
      if (this.mWsQVProvider != null)
      {
        if (!LauncherApplication.isTabletLayout()) {
          cancelDrag();
        }
        if (!getTouchState()) {
          break label149;
        }
        cancelDeleteView();
      }
    }
    for (;;)
    {
      if (!LauncherApplication.isTabletLayout()) {
        break label182;
      }
      if ((localObject != null) && (((HomeView)localObject).getQuickViewWorkspace().isOpened()))
      {
        i = localResources.getDimensionPixelSize(2131624020);
        ((HomeView)localObject).getWorkspace().setPageIndicatorTop(i);
      }
      if (this.mHandler == null) {
        this.mHandler = new Handler();
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          QuickViewWorkspace.access$302(QuickViewWorkspace.this, false);
        }
      }, 500L);
      return;
      bool = false;
      break;
      label149:
      paramConfiguration = (FrameLayout.LayoutParams)getLayoutParams();
      paramConfiguration.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131624258));
      setLayoutParams(paramConfiguration);
    }
    label182:
    int i = localResources.getDimensionPixelSize(2131624190);
    if ((bool) && (!LauncherApplication.isDeleteDropTargetTop()))
    {
      setPadding(0, 0, i, 0);
      if ((getResources().getConfiguration().smallestScreenWidthDp < 600) && (isOpened()))
      {
        paramConfiguration = getResources();
        this.mWorkspace.updateIndicator(paramConfiguration.getDimensionPixelSize(2131624161), paramConfiguration.getDimensionPixelSize(2131624159));
        this.mWorkspace.updateIndicatorWidth(bool);
      }
      paramConfiguration = ((Launcher)getContext()).mHomeView.getDeleteDropLayout();
      if (paramConfiguration != null)
      {
        localObject = (FrameLayout.LayoutParams)paramConfiguration.getLayoutParams();
        if ((!bool) || (LauncherApplication.isDeleteDropTargetTop())) {
          break label392;
        }
        ((FrameLayout.LayoutParams)localObject).width = i;
        ((FrameLayout.LayoutParams)localObject).height = -1;
        ((FrameLayout.LayoutParams)localObject).gravity = 21;
        label322:
        if ((LauncherApplication.isDeleteDropTargetTop()) && (LauncherApplication.isDeleteDropTargetTextRight()))
        {
          if (!bool) {
            break label414;
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
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          QuickViewWorkspace.access$302(QuickViewWorkspace.this, false);
        }
      });
      return;
      setPadding(0, i, 0, 0);
      break;
      label392:
      ((FrameLayout.LayoutParams)localObject).width = -1;
      ((FrameLayout.LayoutParams)localObject).height = i;
      ((FrameLayout.LayoutParams)localObject).gravity = 49;
      break label322;
      label414:
      ((QuickViewDragBar)paramConfiguration).setTextDisplayPositionRight(false);
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {}
    switch (paramMotionEvent.getAction())
    {
    default: 
      return super.onGenericMotionEvent(paramMotionEvent);
    }
    int i = this.mCurrentPage;
    float f2;
    float f1;
    if ((paramMotionEvent.getMetaState() & 0x1) != 0)
    {
      f2 = 0.0F;
      f1 = paramMotionEvent.getAxisValue(9);
      label62:
      if ((f1 == 0.0F) && (f2 == 0.0F)) {
        break label128;
      }
      if (i == this.mCurrentPage)
      {
        if ((f1 <= 0.0F) && (f2 <= 0.0F)) {
          break label130;
        }
        setQvPage(this.mCurrentPage - 1);
      }
    }
    for (;;)
    {
      snapToQvPage();
      return true;
      f2 = -paramMotionEvent.getAxisValue(9);
      f1 = paramMotionEvent.getAxisValue(10);
      break label62;
      label128:
      break;
      label130:
      setQvPage(this.mCurrentPage + 1);
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
      if ((!Launcher.isHelpAppRunning) || ((!GuideFragment.GMode.equals("add_widgets")) && (!GuideFragment.GMode.equals("change_wallpaper"))))
      {
        int i;
        int j;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if ((this.mMultiTouchUsed) && (this.mPinchOutProcess))
          {
            this.mTouchState = 0;
            i = (int)(f2 - paramMotionEvent.getY(1));
            j = (int)(f1 - paramMotionEvent.getX(1));
            if ((int)Math.sqrt(i * i + j * j) - this.mTouchPointDistance > 50)
            {
              paramMotionEvent = getChildAt(this.mPinchOutIndex);
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != ADD_BTN_TAG))
              {
                this.mMultiTouchUsed = false;
                this.mPinchOutProcess = false;
                this.mCurrentPage = this.mPinchOutIndex;
                drawCloseAnimation();
                return true;
              }
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
    label440:
    label622:
    label655:
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
      this.mChildLeft = ((getMeasuredWidth() - getPaddingRight() - getPaddingLeft() - m) / 2);
      paramInt4 = this.mChildLeft;
      int i1 = getResources().getDimensionPixelSize(2131624257);
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
            break label440;
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
        paramInt2 = this.mCurrentPage;
        paramInt1 = paramInt2;
        if (LauncherApplication.sFestivalPageLauncher)
        {
          paramInt1 = paramInt2;
          if (Launcher.sIsFestivalModeOn)
          {
            paramInt1 = paramInt2;
            if (paramInt2 >= LauncherApplication.getScreenCount()) {
              paramInt1 = LauncherApplication.getHomeScreenIndex();
            }
          }
        }
        if ((paramInt1 < 0) || (getChildAt(paramInt1) == null)) {
          continue;
        }
        if (this.mAnimationState != 1) {
          break label622;
        }
        setScrollX(getChildAt(paramInt1).getLeft() - this.mChildLeft);
      }
      for (;;)
      {
        if (!this.mConfigurationChangeIsInProgress) {
          break label655;
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
    if (Launcher.isHelpAppRunning) {}
    while ((!isAnimStateOkayForClickEvents()) || ((paramView.getTag() != ADD_BTN_TAG) && (!paramView.equals(getChildAt(this.mCurrentPage)))) || (paramView.getTag() == ADD_BTN_TAG) || (this.mMultiTouchUsed) || (getChildCount() <= 2)) {
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
    View localView = getChildAt(this.mPinchOutIndex);
    if ((localView != null) && (localView.getTag() != ADD_BTN_TAG)) {
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
          if ((!Launcher.isHelpAppRunning) || ((!"add_widgets".equals(GuideFragment.GMode)) && (!"change_wallpaper".equals(GuideFragment.GMode))))
          {
            j = (int)(this.mLastMotionX - f1);
            int k = (int)(this.mLastMotionY - f2);
            if (Math.abs(j) > this.mTouchSlop) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) && (this.mTouchState == 0)) {
                this.mTouchState = 1;
              }
              if (this.mTouchState != 1) {
                break label217;
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
              if (isDeleteDropTarget((int)f1, (int)f2))
              {
                if (this.mDragState != 1)
                {
                  Talk.INSTANCE.say(2131755145);
                  if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
                    performHapticFeedback(22165, 1);
                  }
                }
                this.mDragState = 1;
              }
              else
              {
                if (this.mDragState == 1) {
                  this.mDragState = 0;
                }
                j = getTouchedIndex((int)f1, (int)f2);
                if ((j != -1) && (j != this.mDraggingIndex) && (getChildAt(j) != null) && (getChildAt(j).getTag() != ADD_BTN_TAG)) {
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
        }
      }
    case 1: 
      label217:
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
          label569:
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
      if (getCheckedIndex() != LauncherApplication.getHomeScreenIndex()) {
        updateHomeScreenOnDrag();
      }
      if (this.mDvfsHelper == null) {
        break;
      }
      this.mDvfsHelper.release();
      break;
      if (i >= 0) {
        break label569;
      }
      setQvPage(this.mCurrentPage + 1);
      break label569;
      i = this.mWorkspace.getPageIndicatorManager().snapPageTouchArea(f1, f2);
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
    this.mWorkspace.setAllEmptyMessageVisibility(false);
    if (LauncherApplication.isTabletLayout())
    {
      int i = getResources().getDimensionPixelSize(2131624020);
      this.mWorkspace.setPageIndicatorTop(i);
    }
    if (this.vDeleteDropLayout != null)
    {
      this.vDeleteDropLayout.setVisibility(0);
      if (getChildCount() <= 2) {
        break label137;
      }
      ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(true);
    }
    for (;;)
    {
      if (((Launcher)getContext()).mHomeView != null) {
        ((Launcher)getContext()).mHomeView.setVisibilityHomeOptionMenu(0);
      }
      disableWorkspaceScreensCache();
      if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
        this.mWorkspace.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE);
      }
      Talk.INSTANCE.say(2131755046);
      return;
      label137:
      if (getChildCount() <= 2) {
        ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(false);
      }
    }
  }
  
  void refreshView()
  {
    if (this.mDeleteView != null) {
      this.mDeleteView = null;
    }
    initScreen(this.mQVProvider);
    this.mDeleteIndex = -1;
    this.mDragState = 0;
    requestLayout();
  }
  
  public void removeNormalScreen()
  {
    removeView(this.mDeleteView);
    int i = getChildCount();
    if ((i < 1) || (getChildAt(i - 1).getTag() != ADD_BTN_TAG)) {
      makeAddBtn();
    }
    int k = LauncherApplication.getSecretScreenCount();
    i = this.mDeleteIndex + k;
    this.mWsQVProvider.deletePage(i);
    if (i <= LauncherApplication.getHomeScreenIndex())
    {
      int j = Math.max(LauncherApplication.getHomeScreenIndex() - 1, 0);
      i = j;
      if (j >= LauncherApplication.getScreenCount()) {
        i = LauncherApplication.getScreenCount() - 1;
      }
      this.mWsQVProvider.setHomeScreenAt(i);
      int m = getChildCount();
      j = 0;
      if (j < m)
      {
        Object localObject = getChildAt(j);
        if (((localObject instanceof ViewGroup)) && (((ViewGroup)localObject).getChildCount() > 0))
        {
          localObject = (ViewGroup)((ViewGroup)localObject).getChildAt(0);
          if (((ViewGroup)localObject).getChildCount() >= 1)
          {
            localObject = ((ViewGroup)localObject).getChildAt(0);
            if ((localObject instanceof CompoundButton))
            {
              localObject = (CompoundButton)localObject;
              if (j != i - k) {
                break label212;
              }
            }
          }
        }
        label212:
        for (boolean bool = true;; bool = false)
        {
          ((CompoundButton)localObject).setChecked(bool);
          j += 1;
          break;
        }
      }
      Toast.makeText((Launcher)getContext(), ((Launcher)getContext()).getString(2131755134), 0).show();
    }
    this.mQVProvider.saveCurrentPageOrder();
    this.mDeleteView = null;
    this.mDeleteIndex = -1;
    updateTags();
    this.mCurrentPage = (this.mQVProvider.getCurrentPage() - k);
    this.mWsQVProvider.updateWallpaperOffsets();
  }
  
  public void removeScreen()
  {
    if ((indexOfChild(this.mDeleteView) == -1) || (this.mDeleteView == null))
    {
      this.mDeleteView = null;
      return;
    }
    removeView(this.mDeleteView);
    if (this.mDeleteIndex == LauncherApplication.getHomeScreenIndex()) {
      Toast.makeText((Launcher)getContext(), ((Launcher)getContext()).getString(2131755134), 0).show();
    }
    int i = getChildCount();
    if ((i < 1) || (getChildAt(i - 1).getTag() != ADD_BTN_TAG)) {
      makeAddBtn();
    }
    this.mWsQVProvider.deletePage(this.mDeleteIndex);
    if ((getChildCount() <= 2) && (this.vDeleteDropLayout != null)) {
      ((QuickViewDragBar)this.vDeleteDropLayout).enableDelete(false);
    }
    Object localObject;
    if (Utilities.DEBUGGABLE())
    {
      localObject = new Date(System.currentTimeMillis());
      localObject = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format((Date)localObject);
      SharedPreferences.Editor localEditor = ((LauncherApplication)((Launcher)getContext()).getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      localEditor.putString("quickviewDeletePage", this.mDeleteIndex + ", time : " + (String)localObject);
      localEditor.commit();
    }
    if (this.mDeleteIndex <= LauncherApplication.getHomeScreenIndex())
    {
      int j = Math.max(LauncherApplication.getHomeScreenIndex() - 1, 0);
      this.mWsQVProvider.setHomeScreenAt(j);
      int k = getChildCount();
      i = 0;
      if (i < k)
      {
        localObject = getChildAt(i);
        if (((localObject instanceof ViewGroup)) && (((ViewGroup)localObject).getChildCount() > 0))
        {
          localObject = (ViewGroup)((ViewGroup)localObject).getChildAt(0);
          if (((ViewGroup)localObject).getChildCount() >= 1)
          {
            localObject = ((ViewGroup)localObject).getChildAt(0);
            if ((localObject instanceof CompoundButton))
            {
              localObject = (CompoundButton)localObject;
              if (i != j) {
                break label385;
              }
            }
          }
        }
        label385:
        for (boolean bool = true;; bool = false)
        {
          ((CompoundButton)localObject).setChecked(bool);
          i += 1;
          break;
        }
      }
    }
    this.mQVProvider.saveCurrentPageOrder();
    if (this.mDeleteIndex >= getChildCount() - 1) {}
    for (this.mCurrentPage = this.mDeleteIndex;; this.mCurrentPage = this.mQVProvider.getCurrentPage())
    {
      this.mDeleteView = null;
      this.mDeleteIndex = -1;
      updateTags();
      this.mWsQVProvider.updateWallpaperOffsets();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          Talk.INSTANCE.say(2131755212);
        }
      }, 100L);
      return;
    }
  }
  
  public void removeSecretScreen()
  {
    removeView(this.mDeleteView);
    int i = getChildCount();
    if ((i < 1) || (getChildAt(i - 1).getTag() != ADD_BTN_TAG)) {
      makeAddBtn();
    }
    this.mWsQVProvider.deletePage(this.mDeleteIndex);
    this.mQVProvider.saveCurrentPageOrder();
    this.mDeleteView = null;
    this.mDeleteIndex = -1;
    updateTags();
    this.mCurrentPage = this.mQVProvider.getCurrentPage();
    this.mWsQVProvider.updateWallpaperOffsets();
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
    if ((this.mCurrentPage < LauncherApplication.getMaxScreenCount()) && (getChildAt(this.mCurrentPage + 1) != null) && (getChildAt(this.mCurrentPage + 1).getTag() == ADD_BTN_TAG)) {
      Log.e("QuickViewWorkspace", "ignore scroll right to add btn page");
    }
    while (!setQvPage(this.mCurrentPage + 1)) {
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
  
  public void setDeletePageIndex(int paramInt)
  {
    this.mDeleteIndex = paramInt;
    this.mDeleteView = getChildAt(paramInt);
  }
  
  public boolean setQvPage(int paramInt)
  {
    int i = getChildCount();
    if (this.mCurrentPage == paramInt) {}
    while ((paramInt < 0) || (paramInt >= i)) {
      return false;
    }
    this.mCurrentPage = paramInt;
    if (getChildAt(this.mCurrentPage).getTag() != ADD_BTN_TAG) {
      this.mWsQVProvider.setPage(paramInt);
    }
    return true;
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
  
  protected void startDrag(View paramView)
  {
    super.startDrag(paramView);
    paramView = (FrameLayout.LayoutParams)getLayoutParams();
    paramView.setMargins(0, 0, 0, 0);
    setLayoutParams(paramView);
  }
  
  protected void swapScreen(int paramInt)
  {
    this.mQVProvider.movePage(this.mOriginDragIndex, paramInt);
    setQvPage(paramInt);
    updateTags();
  }
  
  public void updateHomeScreenOnDrag()
  {
    int j = LauncherApplication.getHomeScreenIndex();
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      Object localObject = getChildAt(i);
      if (((localObject instanceof ViewGroup)) && (((ViewGroup)localObject).getChildCount() > 0))
      {
        localObject = (ViewGroup)((ViewGroup)localObject).getChildAt(0);
        if (((ViewGroup)localObject).getChildCount() >= 1)
        {
          localObject = ((ViewGroup)localObject).getChildAt(0);
          if ((localObject instanceof CompoundButton))
          {
            localObject = (CompoundButton)localObject;
            if (i != j) {
              break label110;
            }
          }
        }
      }
      label110:
      for (boolean bool = true;; bool = false)
      {
        ((CompoundButton)localObject).setChecked(bool);
        i += 1;
        break;
      }
    }
  }
  
  protected void updateTags()
  {
    int k = getChildCount();
    if (getChildAt(k - 1).getTag() == ADD_BTN_TAG)
    {
      i = 1;
      if ((LauncherApplication.getMaxScreenCount() != k) || (i != 0)) {
        break label120;
      }
    }
    label120:
    for (int i = k;; i = k - 1)
    {
      int j = 0;
      while (j < k)
      {
        View localView = getChildAt(j);
        if (localView.getTag() != ADD_BTN_TAG)
        {
          localView.setTag(Integer.valueOf(j));
          localView.setContentDescription(String.format(getContext().getString(2131755118), new Object[] { Integer.valueOf(j + 1), Integer.valueOf(i) }));
        }
        j += 1;
      }
      i = 0;
      break;
    }
  }
  
  public void updateWidgetButtonState()
  {
    View localView = this.mWsQVProvider.getHomeScreenOptionMenu().getWidgetButton();
    localView.setEnabled(true);
    if (1 != 0) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      localView.setAlpha(f);
      return;
    }
  }
  
  private static class MarkAsHomeButton
    extends CompoundButton
  {
    private static final FrameLayout.LayoutParams LP = new FrameLayout.LayoutParams(-2, -2, 49);
    
    public MarkAsHomeButton(Context paramContext)
    {
      super();
      setLayoutParams(LP);
      setBackgroundResource(2130837751);
    }
    
    public void toggle()
    {
      if (!isChecked())
      {
        super.toggle();
        getParent();
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
      if ((this.mState == 0) && (QuickViewWorkspace.this.mHandler.postDelayed(this, QuickViewWorkspace.this.PAGE_SNAP_ANIMATION_DURATION))) {
        this.mState = 1;
      }
      QuickViewWorkspace.this.invalidate();
    }
    
    public void postForScrollDelayed()
    {
      if ((this.mState == 0) && (QuickViewWorkspace.this.mHandler.postDelayed(this, QuickViewWorkspace.this.mScrollDelay))) {
        this.mState = 2;
      }
      QuickViewWorkspace.this.invalidate();
    }
    
    public void removeSelf()
    {
      if (this.mState != 0)
      {
        QuickViewWorkspace.this.mHandler.removeCallbacks(this);
        this.mState = 0;
        QuickViewWorkspace.this.invalidate();
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
      } while (((Launcher)QuickViewWorkspace.this.getContext()).isLauncherDestroyed());
      if (i == 1)
      {
        postForScrollDelayed();
        return;
      }
      switch (QuickViewWorkspace.this.mScrollState)
      {
      case 0: 
      default: 
        return;
      case 1: 
        QuickViewWorkspace.this.scrollLeft();
        postForScrollToComplete();
        return;
      }
      QuickViewWorkspace.this.scrollRight();
      postForScrollToComplete();
    }
  }
  
  private static class SecretButton
    extends CompoundButton
  {
    private static final FrameLayout.LayoutParams LP = new FrameLayout.LayoutParams(-2, -2, 49);
    
    public SecretButton(Context paramContext)
    {
      super();
      setLayoutParams(LP);
      setBackgroundResource(2130837525);
    }
    
    public void toggle()
    {
      if (!isChecked())
      {
        super.toggle();
        getParent();
      }
    }
  }
  
  public static abstract interface WorkspaceQuickViewInfoProvider
    extends QuickView.QuickViewInfoProvider
  {
    public abstract void addPage();
    
    public abstract void deletePage(int paramInt);
    
    public abstract Activity getActivity();
    
    public abstract QuickViewDragBar getDeleteDropLayout();
    
    public abstract HomeScreenOptionMenu getHomeScreenOptionMenu();
    
    public abstract CellLayout getPage(int paramInt);
    
    public abstract boolean isDeleteWorkScreenPopup();
    
    public abstract boolean isIncludeItem(int paramInt);
    
    public abstract void setDarkenViewAlpha(float paramFloat);
    
    public abstract void setHomeScreenAt(int paramInt);
    
    public abstract void showDeleteWorkScreen();
    
    public abstract void updateWallpaperOffsets();
    
    public abstract void wallpaperHack();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/QuickViewWorkspace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */