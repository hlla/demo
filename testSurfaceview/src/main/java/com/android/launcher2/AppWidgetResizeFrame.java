package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.android.launcher2.guide.ResizeWidgetsGuider;

public class AppWidgetResizeFrame
  extends FrameLayout
  implements ScaleGestureDetector.OnScaleGestureListener, View.OnLongClickListener
{
  public static final int BOTTOM = 3;
  private static final boolean DEBUGGABLE = ;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  private static final String TAG = "Launcher.ResizeFrame";
  public static final int TOP = 1;
  private static final boolean enableMultitouchForWidgetResize = false;
  final int BACKGROUND_PADDING = 16;
  final int BORDER_MARGIN = 16;
  final float DIMMED_HANDLE_ALPHA = 0.0F;
  final float RESIZE_THRESHOLD = 0.66F;
  final int SNAP_DURATION = 150;
  private Drawable mBackground;
  private Drawable mBackgroundInvalid;
  private int mBackgroundPadding;
  private int mBaselineHeight;
  private int mBaselineWidth;
  private int mBaselineX;
  private int mBaselineY;
  private boolean mBeginResize = false;
  private boolean mBorderHasChanged;
  private int mBorderMargin;
  private boolean mBottomBorderActive;
  private ImageView mBottomHandle;
  private CellLayoutWithResizableWidgets mCellLayout;
  private boolean mClearIfNoScale;
  private int mDeltaX;
  private int mDeltaY;
  private int mDownX;
  private int mDownY;
  private int[] mExpandability = new int[4];
  private boolean mForceInvalid = false;
  private HomeItem mHomeWidgetItem;
  private boolean mHorizontalScaleActive;
  private int[] mLastTouch = new int[2];
  private boolean mLeftBorderActive;
  private ImageView mLeftHandle;
  private boolean mRightBorderActive;
  private ImageView mRightHandle;
  private int mRunningHInc;
  private int mRunningVInc;
  private ScaleGestureDetector mScaleGestureDetector = new ScaleGestureDetector(getContext(), this);
  private boolean mScaleHasHappened;
  private WidgetSizes mSizes;
  private float mStartSpanX;
  private float mStartSpanY;
  private boolean mTopBorderActive;
  private ImageView mTopHandle;
  private boolean mVerticalScaleActive;
  private boolean mVisualizeInvalid = false;
  private View mWidgetView;
  private Workspace mWorkspace;
  
  public AppWidgetResizeFrame(Context paramContext, HomeItem paramHomeItem, View paramView, CellLayoutWithResizableWidgets paramCellLayoutWithResizableWidgets)
  {
    super(paramContext);
    Resources localResources = getResources();
    this.mSizes = new WidgetSizes(paramContext);
    setOnLongClickListener(this);
    float f = localResources.getDisplayMetrics().density;
    this.mBackgroundPadding = ((int)Math.ceil(16.0F * f));
    this.mBorderMargin = ((int)Math.ceil(16.0F * f));
    this.mHomeWidgetItem = paramHomeItem;
    this.mCellLayout = paramCellLayoutWithResizableWidgets;
    this.mWidgetView = paramView;
    this.mWorkspace = ((Workspace)this.mCellLayout.getParent());
    paramCellLayoutWithResizableWidgets = "";
    if ((this.mWidgetView instanceof LauncherAppWidgetHostView))
    {
      paramHomeItem = ((LauncherAppWidgetHostView)paramView).getAppWidgetInfo();
      this.mSizes.load(paramHomeItem);
      paramHomeItem = paramHomeItem.label;
      this.mBackground = localResources.getDrawable(2130837880);
      this.mBackgroundInvalid = localResources.getDrawable(2130837881);
      setPadding(this.mBackgroundPadding, this.mBackgroundPadding, this.mBackgroundPadding, this.mBackgroundPadding);
      paramHomeItem = String.format(localResources.getString(2131755205), new Object[] { paramHomeItem });
      this.mLeftHandle = new ImageView(paramContext);
      this.mLeftHandle.setImageResource(2130837882);
      this.mLeftHandle.setContentDescription(paramHomeItem);
      this.mLeftHandle.setFocusable(true);
      paramView = new FrameLayout.LayoutParams(-2, -2, 19);
      addView(this.mLeftHandle, paramView);
      this.mRightHandle = new ImageView(paramContext);
      this.mRightHandle.setImageResource(2130837882);
      this.mRightHandle.setContentDescription(paramHomeItem);
      this.mRightHandle.setFocusable(true);
      paramView = new FrameLayout.LayoutParams(-2, -2, 21);
      addView(this.mRightHandle, paramView);
      this.mTopHandle = new ImageView(paramContext);
      this.mTopHandle.setImageResource(2130837882);
      this.mTopHandle.setContentDescription(paramHomeItem);
      this.mTopHandle.setFocusable(true);
      paramView = new FrameLayout.LayoutParams(-2, -2, 49);
      addView(this.mTopHandle, paramView);
      this.mBottomHandle = new ImageView(paramContext);
      this.mBottomHandle.setImageResource(2130837882);
      this.mBottomHandle.setContentDescription(paramHomeItem);
      this.mBottomHandle.setFocusable(true);
      paramContext = new FrameLayout.LayoutParams(-2, -2, 81);
      addView(this.mBottomHandle, paramContext);
      if (this.mSizes.resizeMode() != 1) {
        break label630;
      }
      this.mTopHandle.setVisibility(8);
      this.mBottomHandle.setVisibility(8);
    }
    for (;;)
    {
      setContentDescription(paramHomeItem);
      return;
      if ((this.mWidgetView instanceof SurfaceWidgetView))
      {
        paramHomeItem = ((SurfaceWidgetView)paramView).getAppWidgetInfo();
        if (paramHomeItem != null)
        {
          this.mSizes.load(paramHomeItem);
          paramHomeItem = paramHomeItem.label;
          break;
        }
        paramHomeItem = paramCellLayoutWithResizableWidgets;
        if (!DEBUGGABLE) {
          break;
        }
        Log.e("AppWidgetResizeFrame", "surface widget view has invalid info");
        paramHomeItem = paramCellLayoutWithResizableWidgets;
        break;
      }
      paramHomeItem = paramCellLayoutWithResizableWidgets;
      if (!DEBUGGABLE) {
        break;
      }
      Log.e("AppWidgetResizeFrame", "unknown view type of AppWidgetResizeFrame");
      paramHomeItem = paramCellLayoutWithResizableWidgets;
      break;
      label630:
      if (this.mSizes.resizeMode() == 2)
      {
        this.mLeftHandle.setVisibility(8);
        this.mRightHandle.setVisibility(8);
      }
    }
  }
  
  private boolean beginResizeIfPointInRegion(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    int i;
    int j;
    label33:
    Object localObject;
    boolean bool;
    if ((this.mSizes.resizeMode() & 0x1) != 0)
    {
      i = 1;
      if ((this.mSizes.resizeMode() & 0x2) == 0) {
        break label403;
      }
      j = 1;
      int k = getResources().getDrawable(2130837882).getIntrinsicWidth() + (this.mBorderMargin + this.mBackgroundPadding);
      localObject = getRect();
      if ((paramInt1 <= ((Rect)localObject).left) || (paramInt1 >= ((Rect)localObject).left + k) || (i == 0)) {
        break label409;
      }
      bool = true;
      label92:
      this.mLeftBorderActive = bool;
      if ((paramInt1 >= ((Rect)localObject).right) || (paramInt1 <= ((Rect)localObject).right - k) || (i == 0)) {
        break label415;
      }
      bool = true;
      label127:
      this.mRightBorderActive = bool;
      if ((paramInt2 <= ((Rect)localObject).top) || (paramInt2 >= ((Rect)localObject).top + k) || (j == 0)) {
        break label421;
      }
      bool = true;
      label162:
      this.mTopBorderActive = bool;
      if ((paramInt2 >= ((Rect)localObject).bottom) || (paramInt2 <= ((Rect)localObject).bottom - k) || (j == 0)) {
        break label427;
      }
      bool = true;
      label197:
      this.mBottomBorderActive = bool;
      if ((!this.mLeftBorderActive) && (!this.mRightBorderActive) && (!this.mTopBorderActive) && (!this.mBottomBorderActive)) {
        break label433;
      }
      bool = true;
      label234:
      localObject = (CellLayout.LayoutParams)getLayoutParams();
      this.mBaselineWidth = ((CellLayout.LayoutParams)localObject).width;
      this.mBaselineHeight = ((CellLayout.LayoutParams)localObject).height;
      this.mBaselineX = ((CellLayout.LayoutParams)localObject).x;
      this.mBaselineY = ((CellLayout.LayoutParams)localObject).y;
      this.mRunningHInc = 0;
      this.mRunningVInc = 0;
      if (bool)
      {
        localObject = this.mLeftHandle;
        if (!this.mLeftBorderActive) {
          break label439;
        }
        f1 = 1.0F;
        label309:
        ((ImageView)localObject).setAlpha(f1);
        localObject = this.mRightHandle;
        if (!this.mRightBorderActive) {
          break label444;
        }
        f1 = 1.0F;
        label330:
        ((ImageView)localObject).setAlpha(f1);
        localObject = this.mTopHandle;
        if (!this.mTopBorderActive) {
          break label449;
        }
        f1 = 1.0F;
        label351:
        ((ImageView)localObject).setAlpha(f1);
        localObject = this.mBottomHandle;
        if (!this.mBottomBorderActive) {
          break label454;
        }
      }
    }
    label403:
    label409:
    label415:
    label421:
    label427:
    label433:
    label439:
    label444:
    label449:
    label454:
    for (float f1 = f2;; f1 = 0.0F)
    {
      ((ImageView)localObject).setAlpha(f1);
      this.mCellLayout.getExpandabilityArrayForView(this.mWidgetView, this.mExpandability);
      return bool;
      i = 0;
      break;
      j = 0;
      break label33;
      bool = false;
      break label92;
      bool = false;
      break label127;
      bool = false;
      break label162;
      bool = false;
      break label197;
      bool = false;
      break label234;
      f1 = 0.0F;
      break label309;
      f1 = 0.0F;
      break label330;
      f1 = 0.0F;
      break label351;
    }
  }
  
  private void commitResize()
  {
    setVisualOk();
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)this.mWidgetView.getLayoutParams();
    if ((this.mWidgetView instanceof SurfaceWidgetView)) {
      ((SurfaceWidgetView)this.mWidgetView).resizeSurfaceWidgetView(localLayoutParams.width, localLayoutParams.height);
    }
    for (;;)
    {
      LauncherModel.moveItemInDatabase(getContext(), this.mHomeWidgetItem, -100L, this.mHomeWidgetItem.mScreen, localLayoutParams.cellX, localLayoutParams.cellY, localLayoutParams.cellHSpan, localLayoutParams.cellVSpan, "resizeItemInDatabase");
      this.mWidgetView.requestLayout();
      post(new Runnable()
      {
        public void run()
        {
          AppWidgetResizeFrame.this.snapToWidget(true);
        }
      });
      return;
      if ((this.mWidgetView instanceof LauncherAppWidgetHostView)) {
        this.mWorkspace.sendWidgetResizeIntent(localLayoutParams.cellHSpan, localLayoutParams.cellVSpan, ((LauncherAppWidgetHostView)this.mWidgetView).getAppWidgetInfo().provider, ((HomeWidgetItem)this.mHomeWidgetItem).appWidgetId);
      } else if (DEBUGGABLE) {
        Log.w("AppWidgetResizeFrame", "unknown view type in app widget resize frame");
      }
    }
  }
  
  private Rect getRect()
  {
    Rect localRect = new Rect();
    this.mWidgetView.getGlobalVisibleRect(localRect);
    localRect.left -= this.mBackgroundPadding;
    localRect.top -= this.mBackgroundPadding;
    localRect.right += this.mBackgroundPadding;
    localRect.bottom += this.mBackgroundPadding;
    return localRect;
  }
  
  private void resizeWidgetIfNeeded()
  {
    int i4 = this.mCellLayout.getCellWidth() + this.mCellLayout.getWidthGap();
    int i1 = this.mCellLayout.getCellHeight() + this.mCellLayout.getHeightGap();
    int i2 = this.mRunningHInc;
    int i3 = this.mRunningVInc;
    float f1 = 1.0F * this.mDeltaX / i4 - this.mRunningHInc;
    float f2 = 1.0F * this.mDeltaY / i1 - this.mRunningVInc;
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    if (Math.abs(f1) > 0.66F) {
      j = Math.round(f1);
    }
    if (Math.abs(f2) > 0.66F) {
      m = Math.round(f2);
    }
    if ((this.mForceInvalid) || ((this.mBottomBorderActive) && (this.mExpandability[3] < f2)) || ((this.mTopBorderActive) && (-this.mExpandability[1] > f2)) || ((this.mLeftBorderActive) && (-this.mExpandability[0] > f1)) || ((this.mRightBorderActive) && (this.mExpandability[2] < f1))) {
      setVisualInvalid();
    }
    while ((j == 0) && (m == 0))
    {
      return;
      setVisualOk();
    }
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)this.mWidgetView.getLayoutParams();
    int i;
    if (this.mLeftBorderActive)
    {
      i = Math.max(-this.mExpandability[0], j);
      k = Math.min(localLayoutParams.cellHSpan - this.mSizes.getMinXSpan(), i);
      i = Math.min(this.mExpandability[0], j * -1);
      i = Math.max(-(localLayoutParams.cellHSpan - this.mSizes.getMinXSpan()), i);
      this.mRunningHInc -= i;
      if (!this.mTopBorderActive) {
        break label889;
      }
      j = Math.max(-this.mExpandability[1], m);
      n = Math.min(localLayoutParams.cellVSpan - this.mSizes.getMinYSpan(), j);
      j = Math.min(this.mExpandability[1], m * -1);
      j = Math.max(-(localLayoutParams.cellVSpan - this.mSizes.getMinYSpan()), j);
      this.mRunningVInc -= j;
      label415:
      m = localLayoutParams.cellHSpan;
      i1 = localLayoutParams.cellVSpan;
      if ((this.mLeftBorderActive) || (this.mRightBorderActive) || (this.mHorizontalScaleActive)) {
        m = i + localLayoutParams.cellHSpan;
      }
      if ((!this.mTopBorderActive) && (!this.mBottomBorderActive))
      {
        i = i1;
        if (!this.mVerticalScaleActive) {}
      }
      else
      {
        i = j + localLayoutParams.cellVSpan;
      }
      if (!this.mSizes.isAvailableSize(m, i)) {
        break label1225;
      }
      j = localLayoutParams.cellHSpan;
      i1 = localLayoutParams.cellVSpan;
      i4 = localLayoutParams.cellX;
      int i5 = localLayoutParams.cellY;
      if ((this.mLeftBorderActive) || (this.mRightBorderActive) || (this.mHorizontalScaleActive))
      {
        localLayoutParams.cellHSpan = m;
        localLayoutParams.cellX += k;
      }
      if ((this.mTopBorderActive) || (this.mBottomBorderActive) || (this.mVerticalScaleActive))
      {
        localLayoutParams.cellVSpan = i;
        localLayoutParams.cellY += n;
      }
      if (this.mCellLayout.rearrangeWorkspaceForSpace(this.mHomeWidgetItem, localLayoutParams.cellX, localLayoutParams.cellY, m, i)) {
        break label1080;
      }
      setVisualInvalid();
      this.mRunningHInc = i2;
      this.mRunningVInc = i3;
      localLayoutParams.cellHSpan = j;
      localLayoutParams.cellVSpan = i1;
      localLayoutParams.cellX = i4;
      localLayoutParams.cellY = i5;
    }
    for (;;)
    {
      this.mCellLayout.getExpandabilityArrayForView(this.mWidgetView, this.mExpandability);
      this.mWidgetView.requestLayout();
      return;
      if (this.mRightBorderActive)
      {
        i = Math.min(this.mExpandability[2], j);
        i = Math.max(-(localLayoutParams.cellHSpan - this.mSizes.getMinXSpan()), i);
        this.mRunningHInc += i;
        break;
      }
      i = j;
      if (!this.mHorizontalScaleActive) {
        break;
      }
      i = Math.min(Math.max(this.mSizes.getMinXSpan(), localLayoutParams.cellHSpan + j), localLayoutParams.cellHSpan + this.mExpandability[0] + this.mExpandability[2]);
      i = this.mSizes.capWidth(i) - localLayoutParams.cellHSpan;
      j = Math.round(((CellLayout.LayoutParams)getLayoutParams()).x / i4);
      k = Math.min(Math.max(-this.mExpandability[0], j - localLayoutParams.cellX), this.mExpandability[2] - i);
      this.mRunningHInc += i;
      break;
      label889:
      if (this.mBottomBorderActive)
      {
        j = Math.min(this.mExpandability[3], m);
        j = Math.max(-(localLayoutParams.cellVSpan - this.mSizes.getMinYSpan()), j);
        this.mRunningVInc += j;
        break label415;
      }
      j = m;
      if (!this.mVerticalScaleActive) {
        break label415;
      }
      j = Math.min(Math.max(this.mSizes.getMinYSpan(), localLayoutParams.cellVSpan + m), localLayoutParams.cellVSpan + this.mExpandability[1] + this.mExpandability[3]);
      j = this.mSizes.capHeight(j) - localLayoutParams.cellVSpan;
      m = Math.round(((CellLayout.LayoutParams)getLayoutParams()).y / i1);
      n = Math.min(Math.max(-this.mExpandability[1], m - localLayoutParams.cellY), this.mExpandability[3] - j);
      this.mRunningVInc += j;
      break label415;
      label1080:
      if ((this.mWidgetView instanceof SurfaceWidgetView))
      {
        ((SurfaceWidgetView)this.mWidgetView).resizeSurfaceWidgetView(localLayoutParams.width, localLayoutParams.height);
      }
      else
      {
        ((LauncherApplication)getContext().getApplicationContext()).getSpanCalculator().updateWidgetSizeRanges((AppWidgetHostView)this.mWidgetView, (Launcher)getContext(), localLayoutParams.cellHSpan, localLayoutParams.cellVSpan);
        if ((!this.mSizes.pureGoogle) && ((this.mWidgetView instanceof LauncherAppWidgetHostView)))
        {
          ((Workspace)this.mCellLayout.getParent()).sendWidgetResizeIntent(localLayoutParams.cellHSpan, localLayoutParams.cellVSpan, ((LauncherAppWidgetHostView)this.mWidgetView).getAppWidgetInfo().provider, ((HomeWidgetItem)this.mWidgetView.getTag()).appWidgetId);
          continue;
          label1225:
          this.mRunningHInc = i2;
          this.mRunningVInc = i3;
          setVisualInvalid();
        }
      }
    }
  }
  
  private void setVisualInvalid()
  {
    this.mVisualizeInvalid = true;
    this.mBottomHandle.setImageResource(2130837883);
    this.mTopHandle.setImageResource(2130837883);
    this.mLeftHandle.setImageResource(2130837883);
    this.mRightHandle.setImageResource(2130837883);
  }
  
  private void setVisualOk()
  {
    this.mVisualizeInvalid = false;
    this.mBottomHandle.setImageResource(2130837882);
    this.mTopHandle.setImageResource(2130837882);
    this.mLeftHandle.setImageResource(2130837882);
    this.mRightHandle.setImageResource(2130837882);
  }
  
  private void updateDeltas(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mCellLayout.spanToPixel(this.mSizes.getMinXSpan(), this.mSizes.getMinYSpan());
    int m = arrayOfInt[0] + this.mBackgroundPadding * 2 - 1;
    int k = arrayOfInt[1] + this.mBackgroundPadding * 2 - 1;
    int j = 0;
    int i = 0;
    if ((this.mRightBorderActive) && (this.mBaselineWidth + paramInt1 <= m))
    {
      this.mDeltaX = (m - this.mBaselineWidth);
      paramInt1 = 1;
      if ((!this.mBottomBorderActive) || (this.mBaselineHeight + paramInt2 > k)) {
        break label208;
      }
      this.mDeltaY = (k - this.mBaselineHeight);
      paramInt2 = 1;
    }
    for (;;)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label279;
      }
      this.mForceInvalid = true;
      return;
      if ((this.mLeftBorderActive) && (this.mBaselineWidth - paramInt1 <= m))
      {
        this.mDeltaX = (this.mBaselineWidth - m);
        paramInt1 = 1;
        break;
      }
      this.mDeltaX = paramInt1;
      paramInt1 = j;
      if (this.mHorizontalScaleActive) {
        break;
      }
      paramInt1 = j;
      if (this.mLeftBorderActive) {
        break;
      }
      paramInt1 = j;
      if (this.mRightBorderActive) {
        break;
      }
      paramInt1 = 1;
      break;
      label208:
      if ((this.mTopBorderActive) && (this.mBaselineHeight - paramInt2 <= k))
      {
        this.mDeltaY = (this.mBaselineHeight - k);
        paramInt2 = 1;
      }
      else
      {
        this.mDeltaY = paramInt2;
        paramInt2 = i;
        if (!this.mVerticalScaleActive)
        {
          paramInt2 = i;
          if (!this.mBottomBorderActive)
          {
            paramInt2 = i;
            if (!this.mTopBorderActive) {
              paramInt2 = 1;
            }
          }
        }
      }
    }
    label279:
    this.mForceInvalid = false;
  }
  
  private void visualizeResizeForDelta(int paramInt1, int paramInt2)
  {
    updateDeltas(paramInt1, paramInt2);
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)getLayoutParams();
    int i = localLayoutParams.width;
    int j = localLayoutParams.height;
    if (this.mLeftBorderActive)
    {
      localLayoutParams.x = (this.mBaselineX + this.mDeltaX);
      localLayoutParams.width = (this.mBaselineWidth - this.mDeltaX);
      if (!this.mTopBorderActive) {
        break label312;
      }
      localLayoutParams.y = (this.mBaselineY + this.mDeltaY);
      localLayoutParams.height = (this.mBaselineHeight - this.mDeltaY);
    }
    for (;;)
    {
      if ((i != localLayoutParams.width) || (j != localLayoutParams.height))
      {
        this.mBorderHasChanged = true;
        resizeWidgetIfNeeded();
        requestLayout();
      }
      return;
      if (this.mRightBorderActive)
      {
        localLayoutParams.width = (this.mBaselineWidth + this.mDeltaX);
        break;
      }
      if (!this.mHorizontalScaleActive) {
        break;
      }
      int n;
      int k;
      int m;
      if (paramInt1 > 0)
      {
        n = this.mBaselineX + this.mBackgroundPadding;
        k = this.mCellLayout.getWidth() - (this.mBaselineX + this.mBaselineWidth - this.mBackgroundPadding * 2);
        int i1 = Math.min(n, k) * 2;
        m = Math.max(0, paramInt1 - i1);
        paramInt1 = Math.min(i1, paramInt1);
        n = Math.min(n, paramInt1 / 2 + m);
        paramInt1 = Math.min(k, paramInt1 / 2 + m);
        localLayoutParams.x = (this.mBaselineX - n);
        localLayoutParams.width = (this.mBaselineWidth + n + paramInt1);
        break;
      }
      localLayoutParams.x = (this.mBaselineX - paramInt1 / 2);
      localLayoutParams.width = (this.mBaselineWidth + paramInt1);
      break;
      label312:
      if (this.mBottomBorderActive) {
        localLayoutParams.height = (this.mBaselineHeight + this.mDeltaY);
      } else if (this.mVerticalScaleActive) {
        if (paramInt2 > 0)
        {
          k = this.mWorkspace.getChildAt(0).getHeight();
          paramInt1 = this.mBaselineY + this.mBackgroundPadding;
          k -= this.mBaselineY + this.mBaselineHeight - this.mBackgroundPadding * 2;
          n = Math.min(paramInt1, k) * 2;
          m = Math.max(0, paramInt2 - n);
          paramInt2 = Math.min(n, paramInt2);
          paramInt1 = Math.min(paramInt1, paramInt2 / 2 + m);
          paramInt2 = Math.min(k, paramInt2 / 2 + m);
          localLayoutParams.y = (this.mBaselineY - paramInt1);
          localLayoutParams.height = (this.mBaselineHeight + paramInt1 + paramInt2);
        }
        else
        {
          localLayoutParams.y = (this.mBaselineY - paramInt2 / 2);
          localLayoutParams.height = (this.mBaselineHeight + paramInt2);
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)getLayoutParams();
    int i = (int)(Math.max(this.mTopHandle.getWidth(), this.mLeftHandle.getWidth()) / 3.0F) + this.mBorderMargin;
    if (this.mVisualizeInvalid) {}
    for (Drawable localDrawable = this.mBackgroundInvalid;; localDrawable = this.mBackground)
    {
      localDrawable.setBounds(i, i, localLayoutParams.width - i, localLayoutParams.height - i);
      localDrawable.draw(paramCanvas);
      super.dispatchDraw(paramCanvas);
      return;
    }
  }
  
  public int getBackgroundPadding()
  {
    return this.mBackgroundPadding;
  }
  
  public View getWidgetView()
  {
    return this.mWidgetView;
  }
  
  public boolean isPointInFrame(float paramFloat1, float paramFloat2)
  {
    return getRect().contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.mBorderHasChanged)
    {
      if ((Launcher.isHelpAppRunning) && (this.mWorkspace.isInResizeMode())) {
        return false;
      }
      paramView = (BaseItem)this.mWidgetView.getTag();
      if (((this.mWidgetView instanceof AppIconView)) || (BaseItem.isWidget(paramView))) {
        ((DynamicShadowMixin.Holder)this.mWidgetView).setLastTouchPoint(this.mLastTouch[0] - this.mBackgroundPadding, this.mLastTouch[1] - this.mBackgroundPadding);
      }
      this.mWorkspace.exitWidgetResizeMode(this.mWorkspace.startDrag(this.mWidgetView));
      return true;
    }
    return false;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1 = Math.abs(paramScaleGestureDetector.getCurrentSpanX());
    float f2 = this.mStartSpanX;
    float f3 = Math.abs(paramScaleGestureDetector.getCurrentSpanY());
    float f4 = this.mStartSpanY;
    this.mHorizontalScaleActive = true;
    this.mRightBorderActive = false;
    this.mLeftBorderActive = false;
    this.mVerticalScaleActive = true;
    this.mTopBorderActive = false;
    this.mBottomBorderActive = false;
    visualizeResizeForDelta((int)(f1 - f2), (int)(f3 - f4));
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.mStartSpanX = Math.abs(paramScaleGestureDetector.getCurrentSpanX());
    this.mStartSpanY = Math.abs(paramScaleGestureDetector.getCurrentSpanY());
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    commitResize();
    this.mHorizontalScaleActive = false;
    this.mVerticalScaleActive = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      super.onTouchEvent(paramMotionEvent);
      return true;
      this.mDownX = i;
      this.mDownY = j;
      this.mLastTouch[0] = ((int)paramMotionEvent.getX());
      this.mLastTouch[1] = ((int)paramMotionEvent.getY());
      if (!beginResizeIfPointInRegion(this.mDownX, this.mDownY))
      {
        this.mClearIfNoScale = false;
        this.mScaleHasHappened = false;
        this.mBorderHasChanged = false;
      }
      else
      {
        this.mBeginResize = true;
        continue;
        visualizeResizeForDelta(i - this.mDownX, j - this.mDownY);
        continue;
        this.mBeginResize = false;
        visualizeResizeForDelta(i - this.mDownX, j - this.mDownY);
        commitResize();
        if ((this.mClearIfNoScale) && (!this.mScaleHasHappened)) {
          this.mCellLayout.clearResizeFrame();
        }
        if ((Launcher.isHelpAppRunning) && (Workspace.widgetSizeChanged))
        {
          ResizeWidgetsGuider localResizeWidgetsGuider = new ResizeWidgetsGuider((Launcher)getContext());
          ((ResizeWidgetsGuider)localResizeWidgetsGuider).dismissHelpDialog();
          ResizeWidgetsGuider.isStep3Visible = true;
          ((ResizeWidgetsGuider)localResizeWidgetsGuider).showHelpDialog_step2();
          continue;
          if (this.mBeginResize) {
            commitResize();
          }
          this.mBeginResize = false;
        }
      }
    }
  }
  
  public void snapToWidget(boolean paramBoolean)
  {
    Object localObject = (CellLayout.LayoutParams)getLayoutParams();
    int k = (int)(getResources().getDrawable(2130837882).getIntrinsicWidth() / 2.0F);
    int i = this.mWidgetView.getWidth() + k * 2 + this.mBorderMargin * 2;
    int j = this.mWidgetView.getHeight() + k * 2 + this.mBorderMargin * 2;
    int n = this.mCellLayout.getPaddingLeft();
    int m = this.mCellLayout.getPaddingTop();
    n = this.mWidgetView.getLeft() + n - k - this.mBorderMargin;
    k = this.mWidgetView.getTop() + m - k - this.mBorderMargin;
    if (!paramBoolean)
    {
      ((CellLayout.LayoutParams)localObject).width = i;
      ((CellLayout.LayoutParams)localObject).height = j;
      ((CellLayout.LayoutParams)localObject).x = n;
      ((CellLayout.LayoutParams)localObject).y = k;
      this.mLeftHandle.setAlpha(1.0F);
      this.mRightHandle.setAlpha(1.0F);
      this.mTopHandle.setAlpha(1.0F);
      this.mBottomHandle.setAlpha(1.0F);
      requestLayout();
      return;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(localObject, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(CellLayout.LayoutParams.WIDTH, new int[] { ((CellLayout.LayoutParams)localObject).width, i }), PropertyValuesHolder.ofInt(CellLayout.LayoutParams.HEIGHT, new int[] { ((CellLayout.LayoutParams)localObject).height, j }), PropertyValuesHolder.ofInt(CellLayout.LayoutParams.X, new int[] { ((CellLayout.LayoutParams)localObject).x, n }), PropertyValuesHolder.ofInt(CellLayout.LayoutParams.Y, new int[] { ((CellLayout.LayoutParams)localObject).y, k }) });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppWidgetResizeFrame.this.requestLayout();
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    switch (this.mSizes.resizeMode())
    {
    default: 
      localAnimatorSet.playTogether(new Animator[] { localObject, ObjectAnimator.ofFloat(this.mLeftHandle, View.ALPHA, new float[] { 1.0F }), ObjectAnimator.ofFloat(this.mRightHandle, View.ALPHA, new float[] { 1.0F }), ObjectAnimator.ofFloat(this.mTopHandle, View.ALPHA, new float[] { 1.0F }), ObjectAnimator.ofFloat(this.mBottomHandle, View.ALPHA, new float[] { 1.0F }) });
    }
    for (;;)
    {
      localAnimatorSet.setDuration(150L);
      localAnimatorSet.start();
      return;
      localAnimatorSet.playTogether(new Animator[] { localObject, ObjectAnimator.ofFloat(this.mTopHandle, View.ALPHA, new float[] { 1.0F }), ObjectAnimator.ofFloat(this.mBottomHandle, View.ALPHA, new float[] { 1.0F }) });
      continue;
      localAnimatorSet.playTogether(new Animator[] { localObject, ObjectAnimator.ofFloat(this.mLeftHandle, View.ALPHA, new float[] { 1.0F }), ObjectAnimator.ofFloat(this.mRightHandle, View.ALPHA, new float[] { 1.0F }) });
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppWidgetResizeFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */