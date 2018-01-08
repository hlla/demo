package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.feature.FloatingFeature;
import com.sec.android.app.launcher.R.styleable;
import com.sec.dtl.launcher.GyroForShadow.VectorListener;
import com.sec.dtl.launcher.Talk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CellLayout
  extends ViewGroup
  implements DragReceivable, DragOrigin, Page
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "CellLayout";
  private static boolean isItemApp = false;
  public static boolean isWidgetResized = false;
  private final boolean ENABLE_TILT = false;
  private final int TILT_SHADOW_OFFSET_DP = 6;
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private boolean mAcceptsDrops = true;
  public boolean mAnimateChildInstantly = false;
  private float mBackgroundAlpha = 0.0F;
  private Rect mBackgroundRect;
  private int mCellHeight;
  private final CellInfo mCellInfo = new CellInfo();
  private int mCellWidth;
  CellLayoutChildren mChildren;
  private float mChildrenAlpha = 1.0F;
  private int mCountX;
  private int mCountY;
  private InterruptibleInOutAnimator mCrosshairsAnimator = null;
  private Drawable mCrosshairsDrawable = null;
  private float mCrosshairsVisibility = 0.0F;
  protected final int[] mDragCell = new int[2];
  private float[] mDragOutlineAlphas = new float[this.mDragOutlines.length];
  private InterruptibleInOutAnimator[] mDragOutlineAnims = new InterruptibleInOutAnimator[this.mDragOutlines.length];
  private int mDragOutlineCurrent = 0;
  private final Paint mDragOutlinePaint = new Paint();
  private Rect[] mDragOutlines = new Rect[4];
  private DragState mDragState = null;
  boolean mDragging = false;
  protected boolean mDrawDragOutlines = true;
  private DummyPanelView mDummyPanelView;
  private TimeInterpolator mEaseOutInterpolator;
  private TextView mEmptyMessage;
  private boolean mFingerMovedOnDrag = false;
  private int mForegroundAlpha = 0;
  private int mForegroundPadding;
  private Rect mForegroundRect;
  private int mGapX;
  private int mGapY;
  private float mGlowBackgroundAlpha;
  private Rect mGlowBackgroundRect;
  private float mGlowBackgroundScale;
  private GyroForShadow.VectorListener mGyroListener = null;
  protected HomeView mHomeView;
  boolean mIgnoreOccupied = false;
  private View.OnTouchListener mInterceptTouchListener;
  private boolean mIsDefaultDropTarget = false;
  private boolean mIsDragOccuring = false;
  private boolean mIsDragOverlapping = false;
  protected boolean mIsPaused = true;
  private boolean mLastDownOnOccupiedCell = false;
  private int[] mLastVisualize = { 0, 0, 0, 0 };
  private float[] mLastXY = new float[2];
  private boolean mNoNeedToDraw = false;
  private View.OnDragListener mOnDragListener;
  private Drawable mOverScrollForegroundDrawable;
  private Drawable mOverScrollLeft;
  private Drawable mOverScrollRight;
  private int mPageType = 0;
  final CellPositioner mPositioner;
  private AppIconView mPressedOrFocusedIcon;
  private ImageView mSecretPageMetaphor;
  private float mShadowOffset = 0.0F;
  private boolean mStateAnimationFinished = false;
  int[] mTempLocation = new int[2];
  private final int[] mTmpPoint = new int[2];
  protected final int[] mTmpXY = new int[2];
  final DeltaVisualizer mVisualizer;
  
  public CellLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayout(Context paramContext, final AttributeSet paramAttributeSet, final int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mDragOutlinePaint.setFilterBitmap(true);
    this.mDragOutlinePaint.setAntiAlias(true);
    this.mDragOutlinePaint.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
    setWillNotDraw(false);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CellLayout, paramInt, 0);
    this.mCellWidth = paramAttributeSet.getDimensionPixelSize(0, 10);
    this.mCellHeight = paramAttributeSet.getDimensionPixelSize(1, 10);
    this.mGapX = paramAttributeSet.getDimensionPixelSize(2, 0);
    this.mGapY = paramAttributeSet.getDimensionPixelSize(3, 0);
    this.mCountX = LauncherModel.getCellCountX();
    this.mCountY = LauncherModel.getCellCountY();
    paramAttributeSet.recycle();
    setAlwaysDrawnWithCacheEnabled(false);
    paramAttributeSet = getResources();
    this.mOverScrollLeft = paramAttributeSet.getDrawable(2130837749);
    this.mOverScrollRight = paramAttributeSet.getDrawable(2130837750);
    this.mForegroundPadding = paramAttributeSet.getDimensionPixelSize(2131624187);
    this.mCrosshairsDrawable = paramAttributeSet.getDrawable(2130837543);
    this.mEaseOutInterpolator = new DecelerateInterpolator(2.5F);
    this.mCrosshairsAnimator = new InterruptibleInOutAnimator(paramAttributeSet.getInteger(2131492878), 0.0F, 1.0F);
    this.mCrosshairsAnimator.getAnimator().addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        CellLayout.access$002(CellLayout.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        CellLayout.this.invalidate();
      }
    });
    this.mCrosshairsAnimator.getAnimator().setInterpolator(this.mEaseOutInterpolator);
    int[] arrayOfInt = this.mDragCell;
    this.mDragCell[1] = -1;
    arrayOfInt[0] = -1;
    paramInt = 0;
    while (paramInt < this.mDragOutlines.length)
    {
      this.mDragOutlines[paramInt] = new Rect(-1, -1, -1, -1);
      paramInt += 1;
    }
    int i = paramAttributeSet.getInteger(2131492879);
    float f = paramAttributeSet.getInteger(2131492880);
    Arrays.fill(this.mDragOutlineAlphas, 0.0F);
    paramInt = 0;
    while (paramInt < this.mDragOutlineAnims.length)
    {
      paramAttributeSet = new InterruptibleInOutAnimator(i, 0.0F, f);
      paramAttributeSet.getAnimator().setInterpolator(this.mEaseOutInterpolator);
      paramAttributeSet.getAnimator().addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if ((Bitmap)paramAttributeSet.getTag() == null)
          {
            paramAnonymousValueAnimator.cancel();
            return;
          }
          CellLayout.this.mDragOutlineAlphas[paramInt] = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          CellLayout.this.invalidate(CellLayout.this.mDragOutlines[paramInt]);
        }
      });
      paramAttributeSet.getAnimator().addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (((Float)((ValueAnimator)paramAnonymousAnimator).getAnimatedValue()).floatValue() == 0.0F) {
            paramAttributeSet.setTag(null);
          }
        }
      });
      this.mDragOutlineAnims[paramInt] = paramAttributeSet;
      paramInt += 1;
    }
    this.mBackgroundRect = new Rect();
    this.mForegroundRect = new Rect();
    this.mGlowBackgroundRect = new Rect();
    setHoverScale(1.0F);
    setHoverAlpha(1.0F);
    this.mChildren = new CellLayoutChildren(paramContext);
    this.mChildren.setCellDimensions(this.mCellWidth, this.mCellHeight, this.mGapX, this.mGapY);
    addView(this.mChildren);
    this.mPositioner = newCellPositioner();
    this.mVisualizer = new DeltaVisualizer(this);
  }
  
  private void cleanupWidgetAutoResize(DragState paramDragState)
  {
    Object localObject = paramDragState.getView();
    BaseItem localBaseItem = paramDragState.getItem();
    if (((localObject instanceof LauncherAppWidgetHostView)) && (((View)localObject).getParent() == this.mChildren))
    {
      int i = localBaseItem.getSpanX();
      int j = localBaseItem.getSpanY();
      localObject = (LauncherAppWidgetHostView)localObject;
      if ((((LauncherAppWidgetHostView)localObject).bitmapNeedsUpdated(i, j)) && (paramDragState.getShadow() != null)) {
        ((LauncherAppWidgetHostView)localObject).updateBitmapForSpan(this, i, j, paramDragState.getShadow());
      }
    }
  }
  
  static boolean findVacantCell(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean[][] paramArrayOfBoolean)
  {
    int i = 0;
    while (i < paramInt4)
    {
      int j = 0;
      while (j < paramInt3)
      {
        int m;
        int k;
        int n;
        int i2;
        if (paramArrayOfBoolean[j][i] == 0)
        {
          m = 1;
          k = 0;
          n = j;
          i2 = m;
        }
        for (;;)
        {
          m = k;
          int i1;
          if (n < j + paramInt1)
          {
            m = k;
            if (n < paramInt3)
            {
              i1 = i;
              m = k;
              k = i2;
            }
          }
          for (;;)
          {
            if ((i1 >= i + paramInt2) || (i1 >= paramInt4)) {
              break label169;
            }
            if ((k != 0) && (paramArrayOfBoolean[n][i1] == 0)) {}
            for (k = 1;; k = 0)
            {
              m += 1;
              if (k != 0) {
                break label160;
              }
              m = 0;
              if (m != paramInt1 * paramInt2) {
                break label186;
              }
              paramArrayOfInt[0] = j;
              paramArrayOfInt[1] = i;
              return true;
              m = 0;
              break;
            }
            label160:
            i1 += 1;
          }
          label169:
          n += 1;
          i2 = k;
          k = m;
        }
        label186:
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  static int heightInLandscape(Resources paramResources, int paramInt)
  {
    int i = paramResources.getDimensionPixelSize(2131624156);
    return (paramInt - 1) * Math.min(paramResources.getDimensionPixelSize(2131624157), paramResources.getDimensionPixelSize(2131624158)) + i * paramInt;
  }
  
  private void invalidateAppIconView(AppIconView paramAppIconView)
  {
    int i = paramAppIconView.getPressedOrFocusedBackgroundPadding();
    invalidate(paramAppIconView.getLeft() + getPaddingLeft() - i, paramAppIconView.getTop() + getPaddingTop() - i, paramAppIconView.getRight() + getPaddingLeft() + i, paramAppIconView.getBottom() + getPaddingTop() + i);
  }
  
  private void invalidateVisualize()
  {
    this.mLastVisualize[3] = 0;
  }
  
  public static boolean isItemApp()
  {
    return isItemApp;
  }
  
  private void onLauncherTiltChanged(float paramFloat)
  {
    float f = getResources().getDisplayMetrics().density;
    this.mShadowOffset = (-paramFloat * 6.0F * f);
    invalidate();
  }
  
  private void setChildrenAlpha(float paramFloat)
  {
    this.mChildrenAlpha = paramFloat;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setAlpha(paramFloat);
      i += 1;
    }
  }
  
  private void updateGlowRect()
  {
    float f = (this.mGlowBackgroundScale - 1.0F) / 2.0F;
    int i = (int)((this.mBackgroundRect.right - this.mBackgroundRect.left) * f);
    int j = (int)((this.mBackgroundRect.bottom - this.mBackgroundRect.top) * f);
    this.mGlowBackgroundRect.set(this.mBackgroundRect.left - i, this.mBackgroundRect.top - j, this.mBackgroundRect.right + i, this.mBackgroundRect.bottom + j);
    invalidate();
  }
  
  static int widthInPortrait(Resources paramResources, int paramInt)
  {
    int i = paramResources.getDimensionPixelSize(2131624155);
    return (paramInt - 1) * Math.min(paramResources.getDimensionPixelSize(2131624157), paramResources.getDimensionPixelSize(2131624158)) + i * paramInt;
  }
  
  boolean CLIP_BY_DEFAULT()
  {
    return true;
  }
  
  public void addChildrenLayout(CellLayoutChildren paramCellLayoutChildren)
  {
    addChildrenLayout(paramCellLayoutChildren, -1);
  }
  
  public void addChildrenLayout(CellLayoutChildren paramCellLayoutChildren, int paramInt)
  {
    addView(paramCellLayoutChildren, paramInt);
    if (this.mChildren == null) {
      this.mChildren = paramCellLayoutChildren;
    }
  }
  
  public boolean addItem(BaseItem paramBaseItem)
  {
    boolean bool = false;
    if ((getParent() instanceof PagedView))
    {
      PagedView localPagedView = (PagedView)getParent();
      if (!localPagedView.isPageConstructed(localPagedView.indexOfChild(this))) {}
    }
    for (bool = true;; bool = true) {
      return this.mChildren.addItem(paramBaseItem, bool);
    }
  }
  
  @Deprecated
  public boolean addViewToCellLayout(View paramView, int paramInt1, int paramInt2, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if ((paramLayoutParams.cellX >= 0) && (paramLayoutParams.cellX <= this.mCountX - 1) && (paramLayoutParams.cellY >= 0) && (paramLayoutParams.cellY <= this.mCountY - 1))
    {
      if (paramLayoutParams.cellHSpan < 0) {
        paramLayoutParams.cellHSpan = this.mCountX;
      }
      if (paramLayoutParams.cellVSpan < 0) {
        paramLayoutParams.cellVSpan = this.mCountY;
      }
      this.mChildren.addView(paramView, paramInt1, paramLayoutParams);
      return true;
    }
    return false;
  }
  
  public List<BaseItem> allItems()
  {
    return this.mChildren.mItems;
  }
  
  public boolean animateChildToPosition(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((getChildrenLayout().indexOfChild(paramView) != -1) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      Object localObject = (LayoutParams)paramView.getLayoutParams();
      View localView = getChildAt(paramInt1, paramInt2);
      if (localView != null)
      {
        if (localView.getParent() != paramView.getParent()) {
          throw new IllegalArgumentException("Tried to animate a item to an occupied cell. Failed to swap item positions because the inbound item belonged to a different cell layout.");
        }
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localLayoutParams.isLockedToGrid = true;
        localLayoutParams.cellX = ((LayoutParams)localObject).cellX;
        localLayoutParams.cellY = ((LayoutParams)localObject).cellY;
        localView.requestLayout();
      }
      ((LayoutParams)localObject).isLockedToGrid = true;
      ((LayoutParams)localObject).cellX = paramInt1;
      ((LayoutParams)localObject).cellY = paramInt2;
      if (paramBoolean)
      {
        paramView.requestLayout();
        return true;
      }
      localObject = (BaseItem)paramView.getTag();
      if ((localObject instanceof HomeItem))
      {
        localObject = (HomeItem)localObject;
        ((HomeItem)localObject).cellX = paramInt1;
        ((HomeItem)localObject).cellY = paramInt2;
      }
      return animateIcon(paramView, paramInt3, true, CLIP_BY_DEFAULT());
    }
    return false;
  }
  
  public boolean animateIcon(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAnimateChildInstantly)
    {
      paramView.requestLayout();
      return true;
    }
    AnimationLayer localAnimationLayer = ((Launcher)getContext()).getAnimationLayer();
    if (localAnimationLayer.updateExistingAnimationTo(paramView, null, paramInt, paramBoolean2) == null)
    {
      Object localObject2 = paramView.getDrawingCache();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramView.buildDrawingCache();
        localObject2 = paramView.getDrawingCache();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          paramView.requestLayout();
          return false;
        }
      }
      localObject2 = localObject1;
      if (paramBoolean1)
      {
        localObject2 = Bitmap.createBitmap((Bitmap)localObject1);
        paramView.destroyDrawingCache();
      }
      localObject1 = localAnimationLayer.getLocationOfView(paramView, (Bitmap)localObject2, null);
      paramView.requestLayout();
      paramView = (AppIconView)paramView;
      paramView = localAnimationLayer.animateIcon(paramView.getAnimGroup(), null, paramView, (Bitmap)localObject2, (int[])localObject1, null, false, paramInt, false);
      getGlobalVisibleRect(paramView.getClipRect());
      if (paramBoolean2)
      {
        paramView.getClipRect().offset(0, -AnimationLayer.sRootLocationOnScreen[1]);
        paramView.enableClipping();
      }
    }
    return true;
  }
  
  void buildChildrenLayer()
  {
    this.mChildren.buildLayer();
  }
  
  public void cancelLongPress()
  {
    super.cancelLongPress();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).cancelLongPress();
      i += 1;
    }
  }
  
  void cellToPoint(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramArrayOfInt[0] = ((this.mCellWidth + this.mGapX) * paramInt1 + i);
    paramArrayOfInt[1] = ((this.mCellHeight + this.mGapY) * paramInt2 + j);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void clearDragOutlines()
  {
    invalidateVisualize();
    int i = this.mDragOutlineCurrent;
    this.mDragOutlineAnims[i].animateOut();
    this.mDragOutlineCurrent = ((this.mDragOutlineCurrent + 1) % this.mDragOutlineAnims.length);
    this.mDragCell[0] = -1;
    this.mDragCell[1] = -1;
    this.mDragState = null;
  }
  
  public void clearTagCellInfo()
  {
    CellInfo localCellInfo = this.mCellInfo;
    localCellInfo.cell = null;
    localCellInfo.cellX = -1;
    localCellInfo.cellY = -1;
    localCellInfo.spanX = 0;
    localCellInfo.spanY = 0;
    if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
    {
      localCellInfo.touchStartedCellX = -1;
      localCellInfo.touchStartedCellY = -1;
    }
    setTag(localCellInfo);
  }
  
  void commitDeltas()
  {
    if (this.mPositioner.getDeltas() != null)
    {
      Iterator localIterator = this.mPositioner.getDeltas().iterator();
      while (localIterator.hasNext())
      {
        PositionDelta localPositionDelta = (PositionDelta)localIterator.next();
        if (localPositionDelta.changed())
        {
          HomeItem localHomeItem = (HomeItem)localPositionDelta.item;
          localHomeItem.spanX = localPositionDelta.getSpanX();
          localHomeItem.spanY = localPositionDelta.getSpanY();
          new DragState(getViewForItem(localPositionDelta.item), this).moveItemTo(this, localPositionDelta.getX(), localPositionDelta.getY(), localPositionDelta.getSpanX(), localPositionDelta.getSpanY(), getScreen(), false);
        }
      }
    }
    this.mVisualizer.reset();
    this.mPositioner.reset(true);
  }
  
  public View createViewForItem(BaseItem paramBaseItem)
  {
    switch (paramBaseItem.mType)
    {
    default: 
      return null;
    case ???: 
    case ???: 
      int i = AppIconView.getHomeIconLayout(paramBaseItem);
      return this.mHomeView.createShortcut((HomeShortcutItem)paramBaseItem, i, this);
    }
    return this.mHomeView.createFolder((HomeFolderItem)paramBaseItem, 2130903070, this);
  }
  
  public void destroyDummyPanel()
  {
    if ((this.mDummyPanelView == null) || (this.mDummyPanelView.panel == null)) {
      return;
    }
    ((Launcher)getContext()).getAnimationLayer().removeView(this.mDummyPanelView);
    this.mDummyPanelView.panel.setBaseDarken(0.0F);
    this.mDummyPanelView.panel.blockDraw = false;
    this.mDummyPanelView.panel = null;
    invalidate();
  }
  
  public void disableHardwareLayers()
  {
    this.mChildren.disableHardwareLayers();
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    boolean bool2 = super.dispatchDragEvent(paramDragEvent);
    boolean bool1 = bool2;
    if (bool2) {
      if (paramDragEvent.getAction() != 1)
      {
        bool1 = bool2;
        if (paramDragEvent.getAction() != 4) {}
      }
      else
      {
        if ((this.mOnDragListener == null) || (!this.mOnDragListener.onDrag(null, paramDragEvent))) {
          break label55;
        }
        bool1 = true;
      }
    }
    return bool1;
    label55:
    onDragEvent(paramDragEvent);
    return bool2;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(this.mChildren.getLeft() + this.mShadowOffset, this.mChildren.getTop());
    this.mChildren.drawShadows(paramCanvas);
    paramCanvas.restore();
    super.dispatchDraw(paramCanvas);
    Paint localPaint;
    if (this.mDrawDragOutlines)
    {
      localPaint = this.mDragOutlinePaint;
      int i = 0;
      while (i < this.mDragOutlines.length)
      {
        float f = this.mDragOutlineAlphas[i];
        if (f > 0.0F)
        {
          Bitmap localBitmap = (Bitmap)this.mDragOutlineAnims[i].getTag();
          localPaint.setAlpha((int)(0.5F + f));
          paramCanvas.drawBitmap(localBitmap, null, this.mDragOutlines[i], localPaint);
        }
        i += 1;
      }
    }
    if (this.mForegroundAlpha > 0)
    {
      this.mOverScrollForegroundDrawable.setBounds(this.mForegroundRect);
      localPaint = ((NinePatchDrawable)this.mOverScrollForegroundDrawable).getPaint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
      this.mOverScrollForegroundDrawable.draw(paramCanvas);
      localPaint.setXfermode(null);
    }
  }
  
  public void drawChildren(Canvas paramCanvas)
  {
    this.mChildren.draw(paramCanvas);
  }
  
  public void enableHardwareLayers()
  {
    this.mChildren.enableHardwareLayers();
  }
  
  void estimateDropCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = this.mCountX;
    int i = this.mCountY;
    pointToCellRounded(paramInt1, paramInt2, paramArrayOfInt);
    paramInt1 = paramArrayOfInt[0] + paramInt3 - j;
    if (paramInt1 > 0) {
      paramArrayOfInt[0] -= paramInt1;
    }
    paramArrayOfInt[0] = Math.max(0, paramArrayOfInt[0]);
    paramInt1 = paramArrayOfInt[1] + paramInt4 - i;
    if (paramInt1 > 0) {
      paramArrayOfInt[1] -= paramInt1;
    }
    paramArrayOfInt[1] = Math.max(0, paramArrayOfInt[1]);
  }
  
  boolean existsEmptyCell()
  {
    return findCellForSpan(null, 1, 1);
  }
  
  boolean findCellForSpan(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return findCellForSpanThatIntersects(paramArrayOfInt, paramInt1, paramInt2, -1, -1);
  }
  
  boolean findCellForSpanThatIntersects(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    this.mPositioner.reset(true);
    int j = paramInt4;
    int i = paramInt3;
    for (;;)
    {
      paramInt3 = 0;
      if (i >= 0) {
        paramInt3 = Math.max(0, i - (paramInt1 - 1));
      }
      int m = this.mCountX - (paramInt1 - 1);
      int k = m;
      int n;
      if (i >= 0)
      {
        if (paramInt1 == 1)
        {
          paramInt4 = 1;
          k = Math.min(m, paramInt4 + (i + (paramInt1 - 1)));
        }
      }
      else
      {
        paramInt4 = 0;
        if (j >= 0) {
          paramInt4 = Math.max(0, j - (paramInt2 - 1));
        }
        n = this.mCountY - (paramInt2 - 1);
        m = n;
        if (j >= 0)
        {
          if (paramInt2 != 1) {
            break label266;
          }
          m = 1;
          label131:
          m = Math.min(n, m + (j + (paramInt2 - 1)));
        }
      }
      for (;;)
      {
        if ((paramInt4 >= m) || (bool1)) {
          break label354;
        }
        n = paramInt3;
        label163:
        boolean bool2 = bool1;
        if (n < k)
        {
          int i1 = 0;
          for (;;)
          {
            if (i1 >= paramInt1) {
              break label324;
            }
            int i2 = 0;
            for (;;)
            {
              if (i2 >= paramInt2) {
                break label315;
              }
              if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (getPageType() == 2))
              {
                if ((paramInt4 + i2 == 0) || (this.mPositioner.deltaAt(n + i1, paramInt4 + i2, 1, 1) != null)) {
                  n += i1;
                }
              }
              else {
                for (;;)
                {
                  n += 1;
                  break label163;
                  paramInt4 = 0;
                  break;
                  label266:
                  m = 0;
                  break label131;
                  if (this.mPositioner.deltaAt(n + i1, paramInt4 + i2, 1, 1) == null) {
                    break label306;
                  }
                  n += i1;
                }
              }
              label306:
              i2 += 1;
            }
            label315:
            i1 += 1;
          }
          label324:
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = n;
            paramArrayOfInt[1] = paramInt4;
          }
          bool2 = true;
        }
        paramInt4 += 1;
        bool1 = bool2;
      }
      label354:
      if ((i == -1) && (j == -1)) {
        return bool1;
      }
      i = -1;
      j = -1;
    }
  }
  
  boolean findDragCell(DragState paramDragState, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return findDragCell(paramDragState, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, false);
  }
  
  boolean findDragCell(DragState paramDragState, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.mLastXY[0] = paramInt1;
    this.mLastXY[1] = paramInt2;
    BaseItem localBaseItem = paramDragState.getItem();
    for (;;)
    {
      try
      {
        Object localObject = paramDragState.getShadow().getTouchOffset();
        pointToCellExact(paramInt1 - localObject[0] + this.mCellWidth / 2, paramInt2 - localObject[1] + this.mCellHeight / 2, this.mTmpXY);
        paramInt2 = this.mTmpXY[0];
        paramInt1 = this.mTmpXY[1];
        localObject = new PositionDelta(localBaseItem);
        ((PositionDelta)localObject).setX(paramInt2);
        ((PositionDelta)localObject).setY(paramInt1);
        if ((!paramBoolean) && (((localBaseItem.mType == BaseItem.Type.HOME_APPLICATION) && (localBaseItem.mIconMovie == null)) || ((localBaseItem.mType == BaseItem.Type.HOME_SHORTCUT) && (localBaseItem.mIconMovie == null)) || ((localBaseItem.mType == BaseItem.Type.MENU_APP) && ((getChildAt(this.mTmpXY[0], this.mTmpXY[1]) instanceof FolderIconView)))))
        {
          paramBoolean = true;
          int[] arrayOfInt = new int[2];
          arrayOfInt[0] = localBaseItem.getSpanX();
          arrayOfInt[1] = localBaseItem.getSpanY();
          if (paramDragState.getSupportWidgetSizes() != null)
          {
            arrayOfInt[0] = paramDragState.getSupportWidgetSizes().getMinXSpan();
            arrayOfInt[1] = paramDragState.getSupportWidgetSizes().getMinYSpan();
          }
          if (!this.mPositioner.updateDeltasForDrag((PositionDelta)localObject, paramDragState.getSupportWidgetSizes(), arrayOfInt[0], arrayOfInt[1], false, true, paramBoolean))
          {
            paramArrayOfInt1[0] = -1;
            paramArrayOfInt1[1] = -1;
            this.mPositioner.reset(true);
            return false;
          }
          this.mVisualizer.updateForDeltas(this.mPositioner.getDeltas());
          paramArrayOfInt1[0] = ((PositionDelta)localObject).getX();
          paramArrayOfInt1[1] = ((PositionDelta)localObject).getY();
          paramArrayOfInt2[0] = ((PositionDelta)localObject).getSpanX();
          paramArrayOfInt2[1] = ((PositionDelta)localObject).getSpanY();
          if (paramArrayOfInt1[0] == paramInt2)
          {
            paramInt2 = paramArrayOfInt1[1];
            if (paramInt2 == paramInt1) {
              return true;
            }
          }
          return false;
        }
      }
      catch (NullPointerException paramDragState)
      {
        if (DEBUGGABLE) {
          Log.d("CellLayout", "Null Pointer Exception Occurred", paramDragState);
        }
        return false;
      }
      paramBoolean = false;
    }
  }
  
  @Deprecated
  int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    pointToCellExact(paramInt1, paramInt2, this.mTmpXY);
    paramInt1 = this.mTmpXY[0];
    paramInt2 = this.mTmpXY[1];
    return this.mPositioner.findNearestVacantArea(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public Matrix getAbsMatrix(Matrix paramMatrix, ViewParent paramViewParent)
  {
    paramMatrix.set(getMatrix());
    paramMatrix.postTranslate(getLeft(), getTop());
    for (Object localObject = getParent(); (localObject != null) && (paramViewParent != localObject) && ((localObject instanceof View)); localObject = ((View)localObject).getParent())
    {
      localObject = (View)localObject;
      paramMatrix.postTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
      paramMatrix.postConcat(((View)localObject).getMatrix());
      paramMatrix.postTranslate(((View)localObject).getLeft(), ((View)localObject).getTop());
    }
    return paramMatrix;
  }
  
  public float getBackgroundAlpha()
  {
    return this.mBackgroundAlpha;
  }
  
  public float getBackgroundBaseDarken()
  {
    float f = 0.0F;
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof PanelDrawer.PanelDrawable)) {
      f = ((PanelDrawer.PanelDrawable)localDrawable).getBaseDarken();
    }
    return f;
  }
  
  public int getCellHeight()
  {
    return this.mCellHeight;
  }
  
  public int getCellWidth()
  {
    return this.mCellWidth;
  }
  
  public View getChildAt(int paramInt1, int paramInt2)
  {
    return this.mChildren.getChildAt(paramInt1, paramInt2);
  }
  
  public View getChildOnPageAt(int paramInt)
  {
    return this.mChildren.getChildAt(paramInt);
  }
  
  public float getChildrenAlpha()
  {
    return this.mChildrenAlpha;
  }
  
  public CellLayoutChildren getChildrenLayout()
  {
    return this.mChildren;
  }
  
  CellLayoutContainer getContainer()
  {
    for (ViewParent localViewParent = getParent(); (!(localViewParent instanceof CellLayoutContainer)) && ((localViewParent instanceof View)); localViewParent = ((View)localViewParent).getParent()) {}
    if ((localViewParent instanceof CellLayoutContainer)) {
      return (CellLayoutContainer)localViewParent;
    }
    return null;
  }
  
  public long getContainerType()
  {
    if (this.mHomeView.isHotseatLayout(this)) {
      return -101L;
    }
    return -100L;
  }
  
  Rect getContentRect(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    int i = getPaddingLeft();
    int j = getPaddingTop();
    localRect.set(i, j, getWidth() + i - getPaddingLeft() - getPaddingRight(), getHeight() + j - getPaddingTop() - getPaddingBottom());
    return localRect;
  }
  
  int getCountX()
  {
    return this.mCountX;
  }
  
  int getCountY()
  {
    return this.mCountY;
  }
  
  public int getDesiredHeight()
  {
    return getDesiredHeightForRows(this.mCountY);
  }
  
  public int getDesiredHeightForRows(int paramInt)
  {
    CellLayoutContainer localCellLayoutContainer = getContainer();
    int j = (this.mCellHeight + this.mGapY) * paramInt + getPaddingTop() + getPaddingBottom();
    int i;
    if (paramInt > 0) {
      i = j - this.mGapY;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramInt != 0);
      i = j;
    } while (!(localCellLayoutContainer instanceof Folder));
    return getResources().getDimensionPixelSize(2131624186);
  }
  
  public int getDesiredWidth()
  {
    return getDesiredWidthForColumns(this.mCountX);
  }
  
  public int getDesiredWidthForColumns(int paramInt)
  {
    int j = (this.mCellWidth + this.mGapX) * paramInt + getPaddingLeft() + getPaddingRight();
    int i = j;
    if (paramInt > 0) {
      i = j - this.mGapX;
    }
    return i;
  }
  
  public void getExpandabilityArrayForView(View paramView, int[] paramArrayOfInt)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    paramArrayOfInt[0] = paramView.cellX;
    paramArrayOfInt[1] = paramView.cellY;
    paramArrayOfInt[2] = (this.mCountX - (paramView.cellX + paramView.cellHSpan));
    paramArrayOfInt[3] = (this.mCountY - (paramView.cellY + paramView.cellVSpan));
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (getPageType() == 2)) {
      paramArrayOfInt[1] = (paramView.cellY - 1);
    }
  }
  
  int getGapX()
  {
    return this.mGapX;
  }
  
  int getGapY()
  {
    return this.mGapY;
  }
  
  int getHeightGap()
  {
    return this.mGapY;
  }
  
  public float getHoverAlpha()
  {
    return this.mGlowBackgroundAlpha;
  }
  
  public float getHoverScale()
  {
    return this.mGlowBackgroundScale;
  }
  
  boolean getIsDragOverlapping()
  {
    return this.mIsDragOverlapping;
  }
  
  public BaseItem getItemAt(int paramInt1, int paramInt2)
  {
    return this.mChildren.getItemAt(paramInt1, paramInt2);
  }
  
  public int getPageChildCount()
  {
    return this.mChildren.getChildCount();
  }
  
  public int getPageItemCount()
  {
    return this.mChildren.mItems.size();
  }
  
  public int getPageType()
  {
    return this.mPageType;
  }
  
  int getScreen()
  {
    if ((ViewGroup)getParent() == null) {
      return -1;
    }
    return ((ViewGroup)getParent()).indexOfChild(this);
  }
  
  public CellInfo getTag()
  {
    return (CellInfo)super.getTag();
  }
  
  public View getViewForItem(BaseItem paramBaseItem)
  {
    View localView2 = this.mChildren.getChildAt(paramBaseItem);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = this.mChildren.buildView(paramBaseItem);
    }
    return localView1;
  }
  
  int getWidthGap()
  {
    return this.mGapX;
  }
  
  public void hide(BaseItem paramBaseItem)
  {
    this.mChildren.setItemVisibility(paramBaseItem, 4);
  }
  
  public int indexOfChildOnPage(View paramView)
  {
    return this.mChildren.indexOfChild(paramView);
  }
  
  public boolean isNoNeedToDraw()
  {
    return this.mNoNeedToDraw;
  }
  
  public boolean isOccupiedNoThrow(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < this.mCountX) && (paramInt2 < this.mCountY)) {
      return this.mPositioner.deltaAt(paramInt1, paramInt2, 1, 1) != null;
    }
    return false;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean lastDownOnOccupiedCell()
  {
    return this.mLastDownOnOccupiedCell;
  }
  
  abstract CellPositioner newCellPositioner();
  
  protected void noRoomForDrop(DragState paramDragState, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mCellInfo.screen = getScreen();
  }
  
  protected void onDetachedFromWindow() {}
  
  void onDragEnter()
  {
    if ((!this.mDragging) && (this.mCrosshairsAnimator != null))
    {
      if (!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) {
        break label39;
      }
      if (!Launcher.isHomeRemoveMode()) {
        this.mCrosshairsAnimator.animateIn();
      }
    }
    for (;;)
    {
      this.mDragging = true;
      return;
      label39:
      this.mCrosshairsAnimator.animateIn();
    }
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    isItemApp = false;
    CellLayoutContainer localCellLayoutContainer = getContainer();
    if (localCellLayoutContainer == null) {
      return false;
    }
    if ((Launcher.CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE) && ((localCellLayoutContainer instanceof Hotseat))) {
      return false;
    }
    if (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    if (paramDragEvent.getLocalState() != null) {}
    int i2;
    for (Object localObject1 = (DragState)paramDragEvent.getLocalState();; localObject1 = Launcher.dragstate)
    {
      i2 = paramDragEvent.getAction();
      if ((i2 == 4) || (!((DragState)localObject1).hasDeleted())) {
        break;
      }
      this.mDragState = null;
      return true;
    }
    if ((i2 != 4) && (i2 != 3) && (i2 != 1) && ((localCellLayoutContainer instanceof Workspace)) && (((Workspace)localCellLayoutContainer).isPageMoving())) {
      return true;
    }
    int m = (int)paramDragEvent.getX();
    int k = (int)paramDragEvent.getY();
    View localView = ((DragState)localObject1).getView();
    BaseItem localBaseItem;
    boolean bool3;
    boolean bool1;
    label215:
    Object localObject2;
    boolean bool4;
    boolean bool2;
    int j;
    int i;
    label322:
    int n;
    int i1;
    if (i2 == 1)
    {
      this.mDragState = ((DragState)localObject1);
      localBaseItem = ((DragState)localObject1).getItem();
      bool3 = BaseItem.isWidget(localBaseItem);
      if ((localBaseItem.mType != BaseItem.Type.HOME_SHORTCUT) && (localBaseItem.mType != BaseItem.Type.HOME_APPLICATION) && (localBaseItem.mType != BaseItem.Type.MENU_APP)) {
        break label416;
      }
      bool1 = true;
      isItemApp = bool1;
      if ((i2 == 5) && (((DragState)localObject1).mDragOrigin != this) && ((((DragState)localObject1).mDragOrigin instanceof CellLayout)))
      {
        localObject2 = (CellLayout)((DragState)localObject1).mDragOrigin;
        if (((CellLayout)localObject2).getIsDragOverlapping()) {
          ((CellLayout)localObject2).onDragExit();
        }
      }
      bool4 = ((Launcher)getContext()).isExitingAllApps();
      bool2 = true;
      switch (i2)
      {
      default: 
        bool1 = bool2;
        j = k;
        i = m;
        n = this.mTmpXY[0];
        i1 = this.mTmpXY[1];
        switch (i2)
        {
        default: 
          label360:
          switch (i2)
          {
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      super.onDragEvent(paramDragEvent);
      return true;
      this.mDragState = null;
      break;
      label416:
      bool1 = false;
      break label215;
      getLocationInWindow(this.mTmpXY);
      i = m - this.mTmpXY[0];
      j = k - this.mTmpXY[1];
      this.mLastXY[0] = i;
      this.mLastXY[1] = j;
      bool1 = bool2;
      break label322;
      i = m;
      j = k;
      bool1 = bool2;
      if (this.mHomeView.getWorkspace().getOpenFolder() != null) {
        break label322;
      }
      i = m;
      j = k;
      bool1 = bool2;
      if (bool4) {
        break label322;
      }
      bool1 = findDragCell((DragState)localObject1, m, k, this.mDragCell, this.mTmpXY);
      i = m;
      j = k;
      break label322;
      if (!this.mChildren.hasItem(localBaseItem)) {
        break label360;
      }
      localObject2 = new int[2];
      Object localObject3 = (HomeItem)((DragState)localObject1).getItem();
      cellToPoint(((HomeItem)localObject3).cellX, ((HomeItem)localObject3).cellY, (int[])localObject2);
      m = localObject2[0] + this.mGapX;
      k = localObject2[1] + this.mGapY;
      i = m;
      j = k;
      if ((localView instanceof LauncherAppWidgetHostView)) {
        break label360;
      }
      i = m;
      j = k;
      if (((DragState)localObject1).getShadow() == null) {
        break label360;
      }
      localObject2 = ((DragState)localObject1).getShadow().getTouchOffset();
      i = m + localObject2[0];
      j = k + localObject2[1];
      break label360;
      this.mFingerMovedOnDrag = false;
      if (localView.getParent() == getChildrenLayout())
      {
        this.mIsDragOverlapping = true;
        onDragEnter();
      }
      localCellLayoutContainer.onDragStartedWithItem(localView);
      this.mStateAnimationFinished = false;
      continue;
      this.mFingerMovedOnDrag = true;
      if ((((DragState)localObject1).mUnderdragView == null) && (!bool4))
      {
        j = 1;
        i = j;
        if (!(((DragState)localObject1).getItem() instanceof FolderItem))
        {
          i = j;
          if (!bool3)
          {
            i = j;
            if (bool1)
            {
              if ((getChildAt(this.mDragCell[0], this.mDragCell[1]) instanceof FolderIconView)) {
                break label839;
              }
              i = 1;
            }
          }
        }
        label776:
        if ((i == 0) || (this.mHomeView == null) || (this.mHomeView.isWorkspaceLocked())) {
          break label844;
        }
        visualizeDropLocation(localView, localCellLayoutContainer.getDragOutline(localView), this.mDragCell, n, i1);
      }
      while (!this.mDragging)
      {
        setIsDragOccuring(true);
        onDragEnter();
        break;
        label839:
        i = 0;
        break label776;
        label844:
        if (this.mStateAnimationFinished) {
          clearDragOutlines();
        }
      }
      localObject1 = ((DragState)localObject1).getFolderParent();
      if (localObject1 != null) {
        ((Folder)localObject1).parentLayoutEntered();
      }
      setIsDragOccuring(true);
      onDragEnter();
      continue;
      setIsDragOccuring(false);
      onDragExit();
      invalidate();
      invalidateVisualize();
      cleanupWidgetAutoResize((DragState)localObject1);
      continue;
      if ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!Launcher.isHomeRemoveMode()))
      {
        long l = getContainerType();
        k = getScreen();
        if (l == -101L) {}
        for (m = 1;; m = 0)
        {
          if (m != 0) {
            k = ((Hotseat)localCellLayoutContainer).getOrderInHotseat(this.mDragCell[0], this.mDragCell[1]);
          }
          if ((!LauncherApplication.sFestivalPageLauncher) || (!Launcher.sIsFestivalModeOn) || (this.mPageType != 2)) {
            break label1028;
          }
          ((DragState)localObject1).onEnd();
          this.mHomeView.getWorkspace().snapToPage(((DragState)localObject1).getItem().mScreen);
          break;
        }
        label1028:
        if ((this.mDragCell[0] != -1) && (this.mDragCell[1] != -1))
        {
          m = 1;
          label1051:
          if (m == 0) {
            break label1584;
          }
          if (this.mChildren.mItems.size() != 0) {
            break label1189;
          }
          i = 1;
        }
        for (;;)
        {
          if (((localView instanceof LauncherAppWidgetHostView)) || ((localView instanceof SurfaceWidgetView)))
          {
            if ((!this.mFingerMovedOnDrag) && (((DragState)localObject1).mDragOrigin == this))
            {
              ((DragState)localObject1).onEnd();
              if ((localView instanceof SurfaceWidgetView))
              {
                localView.setVisibility(0);
                if (((SurfaceWidgetItem)localView.getTag()).mScreen == this.mHomeView.getCurrentPage()) {
                  ((SurfaceWidgetItem)localView.getTag()).onResume();
                }
                this.mHomeView.getWorkspace().enterSurfaceWidgetResizeMode((SurfaceWidgetView)localView, this);
                this.mPositioner.reset(true);
                break;
                m = 0;
                break label1051;
                label1189:
                i = 0;
                continue;
              }
              if (Launcher.isHelpAppRunning) {
                isWidgetResized = true;
              }
              this.mHomeView.getWorkspace().enterWidgetResizeMode((LauncherAppWidgetHostView)localView, this);
              this.mPositioner.reset(true);
              break;
            }
            if ((localView instanceof SurfaceWidgetView)) {
              localView.setVisibility(0);
            }
          }
        }
        localObject2 = ((DragState)localObject1).getItem();
        if ((localObject2 instanceof HomeItem))
        {
          localObject2 = (HomeItem)localObject2;
          ((HomeItem)localObject2).spanX = n;
          ((HomeItem)localObject2).spanY = i1;
        }
        localObject2 = getChildAt(this.mDragCell[0], this.mDragCell[1]);
        if ((bool1) && (localObject2 != null) && ((localObject2 instanceof FolderIconView)) && (((View)localObject2).onDragEvent(paramDragEvent))) {
          continue;
        }
        if (((DragState)localObject1).moveItemTo(this, this.mDragCell[0], this.mDragCell[1], n, i1, k))
        {
          if (!(localView instanceof LauncherAppWidgetHostView)) {
            break label1557;
          }
          this.mHomeView.getWorkspace().enterWidgetResizeMode((LauncherAppWidgetHostView)localView, this);
          label1379:
          commitDeltas();
        }
        if (((localCellLayoutContainer instanceof Workspace)) && (i != 0) && (this.mChildren.mItems.size() != 0)) {
          ((Workspace)localCellLayoutContainer).turnOffEmptyPageMsg();
        }
        ((DragState)localObject1).onDrop();
        if ((localView instanceof LauncherAppWidgetHostView))
        {
          localObject1 = (LayoutParams)localView.getLayoutParams();
          localObject2 = (LauncherAppWidgetHostView)localView;
          localObject3 = (HomeWidgetItem)localView.getTag();
          this.mHomeView.getWorkspace().sendWidgetResizeIntent(((LayoutParams)localObject1).cellHSpan, ((LayoutParams)localObject1).cellVSpan, ((LauncherAppWidgetHostView)localObject2).getAppWidgetInfo().provider, ((HomeWidgetItem)localObject3).appWidgetId);
        }
      }
      for (;;)
      {
        if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
          performHapticFeedback(25687, 1);
        }
        localCellLayoutContainer.onDragEndedWithItem(localBaseItem);
        localObject1 = localView.getTag();
        if (!(localObject1 instanceof SamsungWidgetItem)) {
          break label1597;
        }
        ((SamsungWidgetItem)localObject1).fireOnResume(getContext());
        break;
        label1557:
        if (!(localView instanceof SurfaceWidgetView)) {
          break label1379;
        }
        this.mHomeView.getWorkspace().enterSurfaceWidgetResizeMode((SurfaceWidgetView)localView, this);
        break label1379;
        label1584:
        noRoomForDrop((DragState)localObject1, k, i, j);
      }
      label1597:
      if (((localObject1 instanceof SurfaceWidgetItem)) && (((SurfaceWidgetItem)localObject1).mScreen == this.mHomeView.getCurrentPage()))
      {
        ((SurfaceWidgetItem)localObject1).onResume();
        continue;
        this.mFingerMovedOnDrag = false;
        getChildrenLayout().setChildrenDrawingCacheEnabled(false);
        setIsDragOccuring(false);
        onDragExit();
        localCellLayoutContainer.onDragEndedWithItem(localBaseItem);
        ((DragState)localObject1).onEnd();
        if (Launcher.dragstate != null) {
          Launcher.dragstate.onEnd();
        }
        clearDragOutlines();
        cleanupWidgetAutoResize((DragState)localObject1);
        if ((localView.getTag() instanceof SurfaceWidgetItem))
        {
          localView.setVisibility(0);
          if (((SurfaceWidgetItem)localView.getTag()).mScreen == this.mHomeView.getCurrentPage()) {
            ((SurfaceWidgetItem)localView.getTag()).onResume();
          }
        }
      }
    }
  }
  
  void onDragExit()
  {
    this.mVisualizer.reset();
    if (this.mDragging)
    {
      this.mDragging = false;
      if (this.mCrosshairsAnimator != null)
      {
        if (!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) {
          break label103;
        }
        if (!Launcher.isHomeRemoveMode()) {
          this.mCrosshairsAnimator.animateOut();
        }
      }
    }
    for (;;)
    {
      this.mDragCell[0] = -1;
      this.mDragCell[1] = -1;
      this.mDragOutlineAnims[this.mDragOutlineCurrent].animateOut();
      this.mDragOutlineCurrent = ((this.mDragOutlineCurrent + 1) % this.mDragOutlineAnims.length);
      setIsDragOverlapping(false);
      this.mPositioner.reset(true);
      return;
      label103:
      this.mCrosshairsAnimator.animateOut();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mHomeView != null) && (this.mHomeView.getWorkspace().isSwitchingState())) {
      postInvalidate();
    }
    int k;
    int j;
    int i;
    Object localObject;
    if (this.mCrosshairsVisibility > 0.0F)
    {
      int i2 = this.mCountX;
      int i3 = this.mCountY;
      k = 0;
      int m = 0;
      j = k;
      i = m;
      if (LauncherApplication.sFestivalPageLauncher)
      {
        j = k;
        i = m;
        if (Launcher.sIsFestivalModeOn)
        {
          j = k;
          i = m;
          if (getPageType() == 2)
          {
            j = 1;
            i = this.mCellHeight + this.mGapY;
          }
        }
      }
      localObject = this.mCrosshairsDrawable;
      int i4 = ((Drawable)localObject).getIntrinsicWidth();
      int i5 = ((Drawable)localObject).getIntrinsicHeight();
      ((Drawable)localObject).setAlpha((int)(255.0F * this.mCrosshairsVisibility));
      m = getPaddingLeft() - this.mGapX / 2 - i4 / 2 + (this.mCellWidth + this.mGapX);
      k = 1;
      while (k <= i2 - 1)
      {
        int i1 = getPaddingTop() - this.mGapY / 2 - i5 / 2 + (this.mCellHeight + this.mGapY);
        int n;
        if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (getPageType() == 2))
        {
          i1 += i;
          n = j + 1;
        }
        while (n <= i3 - 1)
        {
          ((Drawable)localObject).setBounds(m, i1, m + i4, i1 + i5);
          ((Drawable)localObject).draw(paramCanvas);
          i1 += this.mCellHeight + this.mGapY;
          n += 1;
          continue;
          n = 1;
          while (n <= i3 - 1)
          {
            ((Drawable)localObject).setBounds(m, i1, m + i4, i1 + i5);
            ((Drawable)localObject).draw(paramCanvas);
            i1 += this.mCellHeight + this.mGapY;
            n += 1;
          }
        }
        m += this.mCellWidth + this.mGapX;
        k += 1;
      }
    }
    if (this.mPressedOrFocusedIcon != null)
    {
      i = this.mPressedOrFocusedIcon.getPressedOrFocusedBackgroundPadding();
      localObject = this.mPressedOrFocusedIcon.getPressedOrFocusedBackground();
      if (localObject != null)
      {
        j = getPaddingLeft();
        k = getPaddingTop();
        paramCanvas.drawBitmap((Bitmap)localObject, this.mPressedOrFocusedIcon.getLeft() + j - i, this.mPressedOrFocusedIcon.getTop() + k - i, null);
      }
    }
  }
  
  void onDropChild(View paramView)
  {
    if (paramView != null)
    {
      ((LayoutParams)paramView.getLayoutParams()).dropped = true;
      paramView.requestLayout();
    }
  }
  
  public void onFailedDrop(BaseItem paramBaseItem) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if ("USA".equals(SystemProperties.get("ro.csc.country_code"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mEmptyMessage = ((TextView)findViewById(2131689694));
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      clearTagCellInfo();
    }
    if ((this.mInterceptTouchListener != null) && (this.mInterceptTouchListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      setTagToCellInfoForPoint((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      continue;
      clearTagCellInfo();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof CellLayoutChildren)) {
        localView.layout(getPaddingLeft(), getPaddingTop(), paramInt3 - paramInt1 - getPaddingRight(), paramInt4 - paramInt2 - getPaddingBottom());
      }
      for (;;)
      {
        i += 1;
        break;
        if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && ((localView instanceof LinearLayout)))
        {
          int k = getPaddingLeft();
          int m = getPaddingTop();
          localView.layout(k, m, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + m);
        }
        else
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          localView.layout(localLayoutParams.x, localLayoutParams.y, localLayoutParams.x + localLayoutParams.width, localLayoutParams.y + localLayoutParams.height);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getDesiredWidth();
    int k = getDesiredHeight();
    int m = View.MeasureSpec.getMode(paramInt1);
    int i;
    if (m == 0)
    {
      i = Integer.MIN_VALUE;
      paramInt1 = j;
      m = View.MeasureSpec.getMode(paramInt2);
      if (m != 0) {
        break label274;
      }
      j = Integer.MIN_VALUE;
      paramInt2 = k;
    }
    Object localObject;
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      k = getPaddingLeft();
      int i1 = getPaddingRight();
      m = getPaddingTop();
      int n = getPaddingBottom();
      k = View.MeasureSpec.makeMeasureSpec(paramInt1 - k - i1, i);
      j = View.MeasureSpec.makeMeasureSpec(paramInt2 - m - n, j);
      m = getChildCount();
      i = 0;
      while (i < m)
      {
        localObject = getChildAt(i);
        if ((localObject != this.mEmptyMessage) && (localObject != this.mSecretPageMetaphor) && (((View)localObject).getVisibility() != 8)) {
          ((View)localObject).measure(k, j);
        }
        i += 1;
      }
      n = View.MeasureSpec.getSize(paramInt1);
      if ((DEBUGGABLE) && (j > n)) {
        Log.w("CellLayout", getClass().getSimpleName() + ".onMeasure. Parent maxWidth: " + n + "; setting to: " + j);
      }
      paramInt1 = j;
      i = m;
      if (m != 1073741824) {
        break;
      }
      paramInt1 = j;
      i = m;
      if (j >= n) {
        break;
      }
      paramInt1 = n;
      i = m;
      break;
      label274:
      n = View.MeasureSpec.getSize(paramInt2);
      if ((DEBUGGABLE) && (k > n)) {
        Log.w("CellLayout", getClass().getSimpleName() + ".onMeasure. Parent maxHeight: " + n + "; setting to: " + k);
      }
      paramInt2 = k;
      j = m;
      if (m == 1073741824)
      {
        paramInt2 = k;
        j = m;
        if (k < n)
        {
          paramInt2 = n;
          j = m;
        }
      }
    }
    if ((this.mEmptyMessage != null) && (this.mEmptyMessage.getVisibility() != 8))
    {
      measureChild(this.mEmptyMessage, View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE));
      localObject = (LayoutParams)this.mEmptyMessage.getLayoutParams();
      ((LayoutParams)localObject).width = this.mEmptyMessage.getMeasuredWidth();
      ((LayoutParams)localObject).height = this.mEmptyMessage.getMeasuredHeight();
      ((LayoutParams)localObject).y = ((paramInt2 - ((LayoutParams)localObject).height) / 2);
      ((LayoutParams)localObject).x = ((paramInt1 - ((LayoutParams)localObject).width) / 2);
    }
  }
  
  public void onPreDeltaVisualize(View paramView, BaseItem paramBaseItem) {}
  
  protected boolean onSetAlpha(int paramInt)
  {
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mBackgroundRect.set(0, 0, paramInt1, paramInt2);
    this.mForegroundRect.set(this.mForegroundPadding, this.mForegroundPadding, paramInt1 - this.mForegroundPadding * 2, paramInt2 - this.mForegroundPadding * 2);
    updateGlowRect();
  }
  
  public void onStateAnimationEnd(Workspace.State paramState)
  {
    if ((this.mDragState != null) && (this.mIsDragOverlapping) && (paramState == Workspace.State.EDIT))
    {
      paramState = getContainer();
      Matrix localMatrix = new Matrix();
      getMatrix().invert(localMatrix);
      localMatrix.mapPoints(this.mLastXY);
      findDragCell(this.mDragState, (int)this.mLastXY[0], (int)this.mLastXY[1], this.mDragCell, this.mTmpXY);
      visualizeDropLocation(this.mDragState.getView(), paramState.getDragOutline(this.mDragState.getView()), this.mDragCell, this.mTmpXY[0], this.mTmpXY[1]);
    }
    this.mStateAnimationFinished = true;
    this.mDragState = null;
  }
  
  public void onViewAddedToLayout(View paramView)
  {
    if ((paramView.getTag() instanceof HomeItem))
    {
      HomeItem localHomeItem = (HomeItem)paramView.getTag();
      if ((localHomeItem != null) && ((ViewGroup)getParent() != null)) {
        paramView.setId(LauncherModel.getCellLayoutChildId(-100L, ((ViewGroup)getParent()).indexOfChild(this), localHomeItem.cellX, localHomeItem.cellY, localHomeItem.spanX, localHomeItem.spanY));
      }
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    this.mChildren.setupLp(paramView);
  }
  
  void pointToCellExact(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (getPageType() == 2))
    {
      pointToCellExact(paramInt1, paramInt2, paramArrayOfInt, 0, this.mCountX, 1, this.mCountY);
      return;
    }
    pointToCellExact(paramInt1, paramInt2, paramArrayOfInt, 0, this.mCountX, 0, this.mCountY);
  }
  
  void pointToCellExact(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramArrayOfInt[0] = ((paramInt1 - i) / (this.mCellWidth + this.mGapX));
    paramArrayOfInt[1] = ((paramInt2 - j) / (this.mCellHeight + this.mGapY));
    if (paramArrayOfInt[0] < paramInt3) {
      paramArrayOfInt[0] = paramInt3;
    }
    if (paramArrayOfInt[0] >= paramInt4) {
      paramArrayOfInt[0] = (paramInt4 - 1);
    }
    if (paramArrayOfInt[1] < paramInt5) {
      paramArrayOfInt[1] = paramInt5;
    }
    if (paramArrayOfInt[1] >= paramInt6) {
      paramArrayOfInt[1] = (paramInt6 - 1);
    }
  }
  
  void pointToCellRounded(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    pointToCellExact(this.mCellWidth / 2 + paramInt1, this.mCellHeight / 2 + paramInt2, paramArrayOfInt);
  }
  
  void realRemoveView(View paramView)
  {
    super.removeView(paramView);
  }
  
  void refreshCellDimension()
  {
    this.mChildren.setCellDimensions(this.mCellWidth, this.mCellHeight, this.mGapX, this.mGapY);
  }
  
  public void removeAllItems()
  {
    this.mChildren.removeAllItems();
  }
  
  public void removeAllViews()
  {
    this.mChildren.removeAllViews();
  }
  
  public void removeAllViewsInLayout()
  {
    if (this.mChildren.getChildCount() > 0) {
      this.mChildren.removeAllItems();
    }
  }
  
  public void removeAllViewsOnPage()
  {
    this.mChildren.removeAllViews();
  }
  
  public CellLayoutChildren removeChildrenLayout()
  {
    CellLayoutChildren localCellLayoutChildren = this.mChildren;
    super.removeView(localCellLayoutChildren);
    this.mChildren = null;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((getChildAt(i) instanceof CellLayoutChildren)) {
          this.mChildren = ((CellLayoutChildren)getChildAt(i));
        }
      }
      else {
        return localCellLayoutChildren;
      }
      i += 1;
    }
  }
  
  public boolean removeItem(BaseItem paramBaseItem)
  {
    boolean bool = this.mChildren.removeItem(paramBaseItem);
    if ((bool) && (paramBaseItem != null) && (this.mPositioner.getDeltas() != null))
    {
      Iterator localIterator = this.mPositioner.getDeltas().iterator();
      while (localIterator.hasNext())
      {
        PositionDelta localPositionDelta = (PositionDelta)localIterator.next();
        if (paramBaseItem.equals(localPositionDelta.item)) {
          this.mPositioner.getDeltas().remove(localPositionDelta);
        }
      }
    }
    return bool;
  }
  
  public void removeView(View paramView)
  {
    if ((paramView instanceof Folder))
    {
      super.removeView(paramView);
      return;
    }
    this.mChildren.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    this.mChildren.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(View paramView)
  {
    this.mChildren.removeViewInLayout(paramView);
  }
  
  public void removeViewOnPageAt(int paramInt)
  {
    this.mChildren.removeViewAt(paramInt);
  }
  
  public void removeViewWithoutMarkingCells(View paramView)
  {
    this.mChildren.removeView(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    this.mChildren.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    this.mChildren.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  public void reset()
  {
    this.mVisualizer.reset();
    this.mPositioner.reset(true);
  }
  
  public void setAcceptsDrops(boolean paramBoolean)
  {
    if (this.mAcceptsDrops != paramBoolean)
    {
      this.mAcceptsDrops = paramBoolean;
      invalidate();
    }
  }
  
  public void setAccessibilityEnabled(boolean paramBoolean)
  {
    int k = this.mChildren.getChildCount();
    int i;
    int j;
    label22:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      setImportantForAccessibility(i);
      j = 0;
      if (j >= k) {
        return;
      }
      localView = this.mChildren.getChildAt(j);
      if (localView != null)
      {
        if ((paramBoolean) || ((!(localView instanceof LauncherAppWidgetHostView)) && (!(localView instanceof SurfaceWidgetView)))) {
          break label81;
        }
        localView.setImportantForAccessibility(4);
      }
    }
    for (;;)
    {
      j += 1;
      break label22;
      i = 2;
      break;
      label81:
      localView.setImportantForAccessibility(i);
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    setChildrenAlpha(paramFloat);
  }
  
  public void setBackgroundAlpha(float paramFloat1, float paramFloat2)
  {
    setBackgroundAlpha(paramFloat1, paramFloat2, false);
  }
  
  public void setBackgroundAlpha(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.mBackgroundAlpha = paramFloat1;
    Drawable localDrawable = getBackground();
    if (localDrawable != null)
    {
      localDrawable.setAlpha((int)(255.0F * paramFloat1));
      if ((localDrawable instanceof PanelDrawer.PanelDrawable))
      {
        ((PanelDrawer.PanelDrawable)localDrawable).setBackgroundDarken(paramFloat2);
        ((PanelDrawer.PanelDrawable)localDrawable).setBlend(paramBoolean);
        if (this.mDummyPanelView != null) {
          this.mDummyPanelView.invalidate();
        }
      }
    }
  }
  
  public void setBackgroundBaseDarken(float paramFloat)
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof PanelDrawer.PanelDrawable)) {
      ((PanelDrawer.PanelDrawable)localDrawable).setBaseDarken(paramFloat);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setAlpha((int)(this.mBackgroundAlpha * 255.0F));
  }
  
  void setCellSize(int paramInt1, int paramInt2)
  {
    this.mCellWidth = paramInt1;
    this.mCellHeight = paramInt2;
  }
  
  protected void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    this.mChildren.setChildrenDrawingCacheEnabled(paramBoolean);
  }
  
  protected void setChildrenDrawnWithCacheEnabled(boolean paramBoolean)
  {
    this.mChildren.setChildrenDrawnWithCacheEnabled(paramBoolean);
  }
  
  public void setCrosshairsVisibility(float paramFloat)
  {
    if (this.mCrosshairsAnimator != null) {
      this.mCrosshairsAnimator.cancel();
    }
    this.mCrosshairsVisibility = paramFloat;
  }
  
  void setDummyPanelProperties(float paramFloat, int paramInt)
  {
    if ((this.mDummyPanelView == null) || (this.mDummyPanelView.panel == null)) {
      return;
    }
    if (-1 != paramInt) {
      this.mDummyPanelView.panel.setAlpha(paramInt);
    }
    this.mDummyPanelView.panel.setBaseDarken(paramFloat);
    this.mDummyPanelView.invalidate();
  }
  
  public void setEmptyMessageVisibility(int paramInt)
  {
    if (this.mEmptyMessage != null)
    {
      this.mEmptyMessage.setVisibility(paramInt);
      if (paramInt != 8) {
        break label30;
      }
      this.mEmptyMessage.setText(null);
    }
    label30:
    while (paramInt != 0) {
      return;
    }
    this.mEmptyMessage.setText(getContext().getResources().getString(2131755044));
  }
  
  void setGaps(int paramInt1, int paramInt2)
  {
    this.mGapX = paramInt1;
    this.mGapY = paramInt2;
    invalidateVisualize();
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.mCountX != paramInt1) || (this.mCountY != paramInt2))
    {
      this.mCountX = paramInt1;
      this.mCountY = paramInt2;
      requestLayout();
      if (DEBUGGABLE) {
        Log.d("CellLayout", "setGridSize(" + paramInt1 + ", " + paramInt2 + ")");
      }
    }
  }
  
  public void setHomeView(HomeView paramHomeView)
  {
    this.mHomeView = paramHomeView;
  }
  
  public void setHoverAlpha(float paramFloat)
  {
    this.mGlowBackgroundAlpha = paramFloat;
    invalidate();
  }
  
  public void setHoverScale(float paramFloat)
  {
    if (paramFloat != this.mGlowBackgroundScale)
    {
      this.mGlowBackgroundScale = paramFloat;
      updateGlowRect();
      if (getParent() != null) {
        ((View)getParent()).invalidate();
      }
    }
  }
  
  public void setIsDefaultDropTarget(boolean paramBoolean)
  {
    if (this.mIsDefaultDropTarget != paramBoolean)
    {
      this.mIsDefaultDropTarget = paramBoolean;
      invalidate();
    }
  }
  
  void setIsDragOccuring(boolean paramBoolean)
  {
    if (this.mIsDragOccuring != paramBoolean)
    {
      this.mIsDragOccuring = paramBoolean;
      invalidate();
    }
  }
  
  void setIsDragOverlapping(boolean paramBoolean)
  {
    if (this.mIsDragOverlapping != paramBoolean)
    {
      this.mIsDragOverlapping = paramBoolean;
      invalidate();
    }
  }
  
  public void setIsPaused(boolean paramBoolean)
  {
    this.mIsPaused = paramBoolean;
  }
  
  public void setItemLocation(BaseItem paramBaseItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    if ((paramBaseItem instanceof HomeItem))
    {
      HomeItem localHomeItem = (HomeItem)paramBaseItem;
      LauncherModel.addOrMoveItemInDatabase(getContext(), localHomeItem, paramLong, paramInt5, paramInt1, paramInt2, paramInt3, paramInt4);
      paramBaseItem = this.mChildren.getChildAt(paramBaseItem);
      if (paramBaseItem != null)
      {
        paramBaseItem = (LayoutParams)paramBaseItem.getLayoutParams();
        paramBaseItem.cellX = localHomeItem.cellX;
        paramBaseItem.cellY = localHomeItem.cellY;
        paramBaseItem.cellHSpan = localHomeItem.spanX;
        paramBaseItem.cellVSpan = localHomeItem.spanY;
        this.mChildren.setupLp(paramBaseItem);
        this.mChildren.requestLayout();
      }
    }
  }
  
  public void setItemViewBuilder(ItemViewBuilder paramItemViewBuilder)
  {
    this.mChildren.setItemViewBuilder(paramItemViewBuilder);
  }
  
  public void setNoNeedToDraw(boolean paramBoolean)
  {
    this.mNoNeedToDraw = paramBoolean;
  }
  
  public void setOnDragListener(View.OnDragListener paramOnDragListener)
  {
    this.mOnDragListener = paramOnDragListener;
    super.setOnDragListener(paramOnDragListener);
  }
  
  public void setOnInterceptTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mInterceptTouchListener = paramOnTouchListener;
  }
  
  void setOverScrollAmount(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mOverScrollForegroundDrawable != this.mOverScrollLeft)) {}
    for (this.mOverScrollForegroundDrawable = this.mOverScrollLeft;; this.mOverScrollForegroundDrawable = this.mOverScrollRight) {
      do
      {
        this.mForegroundAlpha = Math.round(255.0F * paramFloat);
        this.mOverScrollForegroundDrawable.setAlpha(this.mForegroundAlpha);
        invalidate();
        return;
      } while ((paramBoolean) || (this.mOverScrollForegroundDrawable == this.mOverScrollRight));
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.mPageType = paramInt;
  }
  
  void setPressedOrFocusedIcon(AppIconView paramAppIconView)
  {
    AppIconView localAppIconView = this.mPressedOrFocusedIcon;
    this.mPressedOrFocusedIcon = paramAppIconView;
    if (localAppIconView != null) {
      invalidateAppIconView(localAppIconView);
    }
    if (this.mPressedOrFocusedIcon != null) {
      invalidateAppIconView(this.mPressedOrFocusedIcon);
    }
  }
  
  public void setSecretPageMetaphorVisibility(int paramInt)
  {
    if (this.mSecretPageMetaphor != null) {
      this.mSecretPageMetaphor.setVisibility(paramInt);
    }
  }
  
  public void setTagToCellInfoForPoint(int paramInt1, int paramInt2)
  {
    CellInfo localCellInfo = this.mCellInfo;
    int i = getScrollX() + paramInt1 - this.mChildren.getLeft() + this.mChildren.getScrollX();
    paramInt2 = getScrollY() + paramInt2 - this.mChildren.getTop() + this.mChildren.getScrollY();
    paramInt1 = this.mChildren.getChildCount();
    boolean bool2 = false;
    paramInt1 -= 1;
    for (;;)
    {
      boolean bool1 = bool2;
      Object localObject;
      if (paramInt1 >= 0)
      {
        localObject = this.mChildren.getChildAt(paramInt1);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (((((View)localObject).getVisibility() == 0) || (((View)localObject).getAnimation() != null)) && (localLayoutParams.isLockedToGrid) && (localLayoutParams.containsPt(i, paramInt2)))
        {
          localCellInfo.cell = ((View)localObject);
          localCellInfo.cellX = localLayoutParams.cellX;
          localCellInfo.cellY = localLayoutParams.cellY;
          localCellInfo.spanX = localLayoutParams.cellHSpan;
          localCellInfo.spanY = localLayoutParams.cellVSpan;
          bool1 = true;
        }
      }
      else
      {
        this.mLastDownOnOccupiedCell = bool1;
        if (!bool1)
        {
          localObject = this.mTmpXY;
          pointToCellExact(i, paramInt2, (int[])localObject);
          localCellInfo.cell = null;
          localCellInfo.cellX = localObject[0];
          localCellInfo.cellY = localObject[1];
          localCellInfo.spanX = 1;
          localCellInfo.spanY = 1;
        }
        if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
        {
          localObject = this.mTmpXY;
          pointToCellExact(i, paramInt2, (int[])localObject);
          localCellInfo.touchStartedCellX = localObject[0];
          localCellInfo.touchStartedCellY = localObject[1];
        }
        setTag(localCellInfo);
        return;
      }
      paramInt1 -= 1;
    }
  }
  
  public void setupDummyPanel()
  {
    if (this.mDummyPanelView == null)
    {
      this.mDummyPanelView = new DummyPanelView(getContext());
      this.mDummyPanelView.layout = this;
    }
    if (this.mDummyPanelView.panel != null) {}
    do
    {
      return;
      this.mDummyPanelView.panel = ((PanelDrawer.PanelDrawable)getBackground());
    } while (this.mDummyPanelView.panel == null);
    this.mDummyPanelView.panel.blockDraw = true;
    AnimationLayer localAnimationLayer = ((Launcher)getContext()).getAnimationLayer();
    int i = 1;
    if (LauncherApplication.sDNDBinding) {
      i = 1 + 1;
    }
    localAnimationLayer.addView(this.mDummyPanelView, i);
    invalidate();
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public void show(BaseItem paramBaseItem)
  {
    this.mChildren.setItemVisibility(paramBaseItem, 0);
  }
  
  public int[] spanToPixel(int paramInt1, int paramInt2)
  {
    return new int[] { this.mCellWidth * paramInt1 + (paramInt1 - 1) * this.mGapX, this.mCellHeight * paramInt2 + (paramInt2 - 1) * this.mGapY };
  }
  
  void visualizeDropLocation(View paramView, Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeRemoveMode())) {}
    label235:
    label334:
    label539:
    label548:
    label574:
    label725:
    label835:
    label1144:
    label1191:
    for (;;)
    {
      return;
      int[] arrayOfInt = this.mLastVisualize;
      if ((paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1) && ((arrayOfInt[0] != paramArrayOfInt[0]) || (arrayOfInt[1] != paramArrayOfInt[1]) || (arrayOfInt[2] != paramInt1) || (arrayOfInt[3] != paramInt2)))
      {
        arrayOfInt[0] = paramArrayOfInt[0];
        arrayOfInt[1] = paramArrayOfInt[1];
        arrayOfInt[2] = paramInt1;
        arrayOfInt[3] = paramInt2;
        if ((paramBitmap == null) && (paramView == null))
        {
          if (this.mCrosshairsDrawable != null) {
            invalidate();
          }
        }
        else
        {
          Object localObject;
          int i2;
          int n;
          int m;
          int i1;
          int i5;
          int i3;
          int i6;
          int k;
          int j;
          int i;
          if (paramBitmap != null)
          {
            localObject = this.mTmpPoint;
            cellToPoint(paramArrayOfInt[0], paramArrayOfInt[1], (int[])localObject);
            i2 = localObject[0];
            n = localObject[1];
            m = paramBitmap.getWidth();
            i1 = paramBitmap.getHeight();
            paramArrayOfInt = getContext().getResources().getDisplayMetrics();
            if (paramArrayOfInt.widthPixels != 240) {
              break label835;
            }
            i5 = 0;
            i3 = 0;
            i6 = 0;
            int i4 = 0;
            if ((!(paramView instanceof AppIconView)) && (!(paramView instanceof TextView))) {
              break label725;
            }
            if (!(getContainer() instanceof Hotseat)) {
              break label574;
            }
            paramView = ((TextView)paramView).getCompoundDrawables();
            i5 = paramView.length;
            k = 0;
            j = i4;
            i = i3;
            if (k < i5)
            {
              localObject = paramView[k];
              if (localObject == null) {
                break label539;
              }
              i = ((Drawable)localObject).getIntrinsicWidth();
              j = ((Drawable)localObject).getIntrinsicHeight();
            }
            paramView = getResources();
            k = (int)paramView.getDimension(2131624200);
            i3 = (int)paramView.getDimension(2131624201);
            if (paramArrayOfInt.widthPixels <= paramArrayOfInt.heightPixels) {
              break label548;
            }
            j = n + Math.abs(i3 - j) / 2;
            i = i2;
            k = i1;
            n = this.mDragOutlineCurrent;
            this.mDragOutlineAnims[n].animateOut();
            this.mDragOutlineCurrent = ((n + 1) % this.mDragOutlines.length);
            this.mDragOutlines[this.mDragOutlineCurrent].set(i, j, i + m, j + k);
            this.mDragOutlineAnims[this.mDragOutlineCurrent].setTag(paramBitmap);
            this.mDragOutlineAnims[this.mDragOutlineCurrent].animateIn();
            if ((paramInt1 == 1) && (paramInt2 == 1))
            {
              if (!(getParent() instanceof PagedView)) {
                break label1144;
              }
              paramView = getContext().getString(2131755227, new Object[] { Integer.valueOf(arrayOfInt[1] + 1), Integer.valueOf(arrayOfInt[0] + 1) });
              if (!((PagedView)getParent()).isPageMoving()) {
                Talk.INSTANCE.sayByTalkback(this, paramView, true);
              }
            }
          }
          for (;;)
          {
            if (this.mCrosshairsDrawable == null) {
              break label1191;
            }
            invalidate();
            if ((!this.USE_SET_INTEGRATOR_HAPTIC) || (!((Launcher)getContext()).isHapticFeedbackExtraOn())) {
              break;
            }
            performHapticFeedback(25688, 1);
            return;
            k += 1;
            break label235;
            i = i2 + Math.abs(k - i) / 2;
            k = i1;
            j = n;
            break label334;
            paramArrayOfInt = ((TextView)paramView).getCompoundDrawables();
            i3 = paramArrayOfInt.length;
            k = 0;
            for (;;)
            {
              i = i6;
              j = i5;
              if (k < i3)
              {
                localObject = paramArrayOfInt[k];
                if (localObject != null)
                {
                  j = ((Drawable)localObject).getIntrinsicWidth();
                  i = ((Drawable)localObject).getIntrinsicHeight();
                }
              }
              else
              {
                paramArrayOfInt = getResources();
                i3 = (int)paramArrayOfInt.getDimension(2131624155);
                k = (int)paramArrayOfInt.getDimension(2131624156);
                j = i2 + Math.abs(i3 - j) / 2;
                n = (int)(n + (Math.abs(k - i) / 2 - (int)((TextView)paramView).getTextSize() * 0.85D));
                k = i1;
                i = j;
                j = n;
                break;
              }
              k += 1;
            }
            i1 = this.mCellWidth * paramInt1 + (paramInt1 - 1) * this.mGapX;
            i3 = this.mCellHeight * paramInt2 + (paramInt2 - 1) * this.mGapY;
            k = i3;
            i = i2;
            j = n;
            m = i1;
            if (!(paramView instanceof ImageView)) {
              break label334;
            }
            float f = Math.min(i1 / paramBitmap.getWidth(), i3 / paramBitmap.getHeight());
            k = (int)(paramBitmap.getHeight() * f);
            i = i2;
            j = n;
            m = i1;
            break label334;
            if ((paramView instanceof AppIconView))
            {
              paramArrayOfInt = getContainer();
              if ((paramArrayOfInt instanceof Hotseat))
              {
                j = getResources().getDimensionPixelSize(2131623970);
                k = paramView.getPaddingTop();
                i = i2 + paramView.getPaddingLeft();
                j = n + (k + j - 6);
                k = i1;
                break label334;
              }
              j = 0;
              if ((paramView instanceof FolderIconView))
              {
                j = getResources().getDimensionPixelSize(2131624341);
                if ((paramArrayOfInt instanceof Workspace)) {}
                for (i = i2 + getResources().getDimensionPixelSize(2131624014);; i = i2 + getResources().getDimensionPixelSize(2131624016))
                {
                  j = n + (paramView.getPaddingTop() + AppIconView.sIconTopToTopOffset + j - 3);
                  k = i1;
                  break;
                }
              }
              if ((paramArrayOfInt instanceof Workspace)) {
                i = getResources().getDimensionPixelSize(2131624013);
              }
              for (;;)
              {
                i = i2 + (HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS - 3 + i);
                break;
                if ((paramArrayOfInt instanceof Folder)) {
                  try
                  {
                    i = getResources().getDimensionPixelSize(2131624017);
                  }
                  catch (Resources.NotFoundException paramArrayOfInt)
                  {
                    i = getResources().getDimensionPixelSize(2131624015);
                  }
                } else {
                  i = getResources().getDimensionPixelSize(2131624015);
                }
              }
            }
            k = i1;
            i = i2;
            j = n;
            if ((paramView instanceof TextView)) {
              break label334;
            }
            m = this.mCellWidth * paramInt1 + (paramInt1 - 1) * this.mGapX;
            k = this.mCellHeight * paramInt2 + (paramInt2 - 1) * this.mGapY;
            i = i2;
            j = n;
            break label334;
            if ((getParent() instanceof Hotseat))
            {
              paramView = getContext().getString(2131755228, new Object[] { Integer.valueOf(arrayOfInt[0] + 1) });
              Talk.INSTANCE.sayByTalkback(this, paramView, true);
            }
          }
        }
      }
    }
  }
  
  static final class CellInfo
  {
    View cell;
    int cellX = -1;
    int cellY = -1;
    int screen;
    int spanX;
    int spanY;
    int touchStartedCellX = -1;
    int touchStartedCellY = -1;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Cell[view=");
      if (this.cell == null) {}
      for (Object localObject = "null";; localObject = this.cell.getClass()) {
        return localObject + ", x=" + this.cellX + ", y=" + this.cellY + "]";
      }
    }
  }
  
  public static class CellLayoutAnimationController
    extends LayoutAnimationController
  {
    public CellLayoutAnimationController(Animation paramAnimation, float paramFloat)
    {
      super(paramFloat);
    }
    
    protected long getDelayForView(View paramView)
    {
      return (int)(Math.random() * 150.0D);
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final Property<LayoutParams, Integer> HEIGHT = new Property(Integer.class, "height")
    {
      public Integer get(CellLayout.LayoutParams paramAnonymousLayoutParams)
      {
        return Integer.valueOf(paramAnonymousLayoutParams.getHeight());
      }
      
      public void set(CellLayout.LayoutParams paramAnonymousLayoutParams, Integer paramAnonymousInteger)
      {
        paramAnonymousLayoutParams.setHeight(paramAnonymousInteger.intValue());
      }
    };
    public static final Property<LayoutParams, Integer> WIDTH = new Property(Integer.class, "width")
    {
      public Integer get(CellLayout.LayoutParams paramAnonymousLayoutParams)
      {
        return Integer.valueOf(paramAnonymousLayoutParams.getWidth());
      }
      
      public void set(CellLayout.LayoutParams paramAnonymousLayoutParams, Integer paramAnonymousInteger)
      {
        paramAnonymousLayoutParams.setWidth(paramAnonymousInteger.intValue());
      }
    };
    public static final Property<LayoutParams, Integer> X = new Property(Integer.class, "x")
    {
      public Integer get(CellLayout.LayoutParams paramAnonymousLayoutParams)
      {
        return Integer.valueOf(paramAnonymousLayoutParams.getX());
      }
      
      public void set(CellLayout.LayoutParams paramAnonymousLayoutParams, Integer paramAnonymousInteger)
      {
        paramAnonymousLayoutParams.setX(paramAnonymousInteger.intValue());
      }
    };
    public static final Property<LayoutParams, Integer> Y = new Property(Integer.class, "y")
    {
      public Integer get(CellLayout.LayoutParams paramAnonymousLayoutParams)
      {
        return Integer.valueOf(paramAnonymousLayoutParams.getY());
      }
      
      public void set(CellLayout.LayoutParams paramAnonymousLayoutParams, Integer paramAnonymousInteger)
      {
        paramAnonymousLayoutParams.setY(paramAnonymousInteger.intValue());
      }
    };
    @ViewDebug.ExportedProperty
    public int cellHSpan;
    @ViewDebug.ExportedProperty
    public int cellVSpan;
    @ViewDebug.ExportedProperty
    public int cellX;
    @ViewDebug.ExportedProperty
    public int cellY;
    boolean dropped;
    public boolean isLockedToGrid = true;
    @ViewDebug.ExportedProperty
    int x;
    @ViewDebug.ExportedProperty
    int y;
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(-1);
      this.cellX = paramInt1;
      this.cellY = paramInt2;
      this.cellHSpan = paramInt3;
      this.cellVSpan = paramInt4;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.cellHSpan = 1;
      this.cellVSpan = 1;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.cellHSpan = 1;
      this.cellVSpan = 1;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.cellX = paramLayoutParams.cellX;
      this.cellY = paramLayoutParams.cellY;
      this.cellHSpan = paramLayoutParams.cellHSpan;
      this.cellVSpan = paramLayoutParams.cellVSpan;
    }
    
    public boolean containsPt(int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.isLockedToGrid)
      {
        bool1 = bool2;
        if (paramInt1 >= this.x)
        {
          bool1 = bool2;
          if (paramInt2 >= this.y)
          {
            bool1 = bool2;
            if (paramInt1 <= this.x + this.width)
            {
              bool1 = bool2;
              if (paramInt2 <= this.y + this.height) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    
    public int getHeight()
    {
      return this.height;
    }
    
    public int getWidth()
    {
      return this.width;
    }
    
    public int getX()
    {
      return this.x;
    }
    
    public int getY()
    {
      return this.y;
    }
    
    public void setHeight(int paramInt)
    {
      this.height = paramInt;
    }
    
    public void setWidth(int paramInt)
    {
      this.width = paramInt;
    }
    
    public void setX(int paramInt)
    {
      this.x = paramInt;
    }
    
    public void setY(int paramInt)
    {
      this.y = paramInt;
    }
    
    public void setup(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.isLockedToGrid)
      {
        this.x = (this.cellX * (paramInt1 + paramInt3) + this.leftMargin);
        this.y = (this.cellY * (paramInt2 + paramInt4) + this.topMargin);
        this.width = (this.cellHSpan * paramInt1 + (this.cellHSpan - 1) * paramInt3 - this.leftMargin - this.rightMargin);
        this.height = (this.cellVSpan * paramInt2 + (this.cellVSpan - 1) * paramInt4 - this.topMargin - this.bottomMargin);
      }
    }
    
    public String toString()
    {
      return "(" + this.cellX + ", " + this.cellY + ")";
    }
  }
  
  static class SpanRect
  {
    public final int height;
    public final Integer size;
    public final int width;
    
    public SpanRect(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.size = Integer.valueOf(paramInt1 * paramInt2);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */