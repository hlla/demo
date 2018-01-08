package com.android.launcher2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;

public class PageIndicator
{
  public static final int ADDPAGE_INDI = 5;
  protected static final int ANIMATION_DURATION = 200;
  private static final int ANIMATION_STATE_DONE = 3;
  private static final int ANIMATION_STATE_RUNNING = 2;
  private static final int ANIMATION_STATE_STARTING = 1;
  public static final int CAMERA_INDI = 1;
  protected static final int DRAW_STATE_LARGE = 3;
  protected static final int DRAW_STATE_MIDDLE = 2;
  protected static final int DRAW_STATE_NONE = 0;
  protected static final int DRAW_STATE_SMALL = 1;
  public static final int FESTIVAL_INDI = 3;
  public static final int HEADLINES_INDI = 4;
  public static final int HOME_INDI = 0;
  public static final int INVALID_AREA = -1;
  public static final int LEFT_MORE_AREA = -2;
  private static final Paint PANEL_TEXT_PAINT;
  public static final int RIGHT_MORE_AREA = -3;
  public static final int SECRET_INDI = 2;
  private static final float[] rate = { 0.0F, 0.0F, 1.0F, 1.0F };
  protected Drawable mAddPageDrawable;
  protected Drawable mCameraPageDrawable;
  protected int mCurrentPage = -1;
  protected Drawable mDefaultPageDrawable;
  protected PageIndicatorManager.DISPLAY_ITEM mDisplayItem = PageIndicatorManager.DISPLAY_ITEM.ALL_PAGE;
  protected int mDisplayPageCount;
  private boolean mEnableTouch;
  private Drawable mFastScrollBarDrawable;
  private final ScalarAnimator mFastScrollFactor = new ScalarAnimator(200L, 0.0F, new DecelerateInterpolator());
  private int mFastScrollNumBgTop;
  private int mFastScrollPaddingTop;
  private int mFastScrollPaddingTopDelta;
  private Drawable mFastScrollThumbDrawable;
  protected Drawable mFestivalPageDrawable;
  private int mFirstTextIndex;
  private Drawable mFocusPageDrawable;
  private Drawable mFocustDefaultPageDrawable;
  protected Drawable mFolderPageDrawable;
  protected int mGap;
  private float mGrowBy;
  protected Drawable mHeadlinesPageDrawable;
  protected int mHotseatBarSize;
  boolean mIsAnimationPrevented = false;
  private boolean mIsDraw;
  private boolean mIsFastScrolling = false;
  private boolean mIsHiding;
  private boolean mIsVisibleLeftMore;
  private boolean mIsVisibleRightMore;
  protected boolean mIsWorkspaceItem;
  protected int mLeft;
  private final int mMaxVisiblePages;
  private Drawable mMoreDrawable;
  private int mMoreGap;
  protected Page[] mPage;
  protected Drawable mPageDrawable;
  private int mPageIndicatorPanelRightAdjust;
  private Drawable mPageNumberBg;
  private int mPageindicatorPanelTopAdjust = -70;
  private int mPanelSize;
  private int mScrollBarThumbWidth = 0;
  private int mScrollBarWidth = 0;
  private float mScrollPosition = 0.0F;
  protected Drawable mSecretPageDrawable;
  protected boolean mShowHeadLinesPage = false;
  protected int mTop;
  private int mTotalPageCount = 0;
  private final Rect rect = new Rect();
  
  static
  {
    PANEL_TEXT_PAINT = new Paint();
    PANEL_TEXT_PAINT.setAntiAlias(true);
    PANEL_TEXT_PAINT.setTextAlign(Paint.Align.CENTER);
    PANEL_TEXT_PAINT.setColor(-1);
  }
  
  public PageIndicator(Resources paramResources, int paramInt)
  {
    this.mMaxVisiblePages = paramInt;
    this.mIsDraw = true;
    this.mIsHiding = false;
    this.mEnableTouch = true;
    setupDimens(paramResources);
  }
  
  private void drawPageNumber(Context paramContext, Canvas paramCanvas, int paramInt, Drawable paramDrawable, Paint paramPaint)
  {
    int i = paramDrawable.getBounds().width();
    int j = paramDrawable.getBounds().height();
    paramCanvas.drawText(Integer.toString(paramInt), i / 2.0F, (j - paramPaint.ascent() - paramPaint.descent()) / 2.0F, paramPaint);
  }
  
  boolean draw(Canvas paramCanvas, PagedView paramPagedView, long paramLong)
  {
    if ((this.mPageDrawable == null) || (!this.mIsDraw))
    {
      bool2 = false;
      return bool2;
    }
    boolean bool2 = false;
    int i = this.mDisplayPageCount;
    int j = this.mGap;
    int k = this.mMoreGap;
    paramCanvas.save();
    paramCanvas.translate(this.mLeft, this.mTop);
    if ((this.mIsVisibleLeftMore) && (this.mMoreDrawable != null))
    {
      int m = this.mMoreDrawable.getIntrinsicWidth() + k;
      paramCanvas.translate(-m, 0.0F);
      this.mMoreDrawable.draw(paramCanvas);
      paramCanvas.translate(m, 0.0F);
    }
    if ((this.mIsVisibleRightMore) && (this.mMoreDrawable != null))
    {
      paramCanvas.translate(k - j, 0.0F);
      this.mMoreDrawable.draw(paramCanvas);
    }
    Rect localRect;
    label182:
    float f;
    if (this.mCurrentPage + 1 < 100)
    {
      localRect = this.mPageNumberBg.getBounds();
      localRect.right = this.mPanelSize;
      this.mPageNumberBg.setBounds(localRect);
      f = this.mFastScrollFactor.get();
      if (f > 0.0F)
      {
        j = (int)(255.0F * f);
        this.mFastScrollBarDrawable.setAlpha(j);
        this.mFastScrollThumbDrawable.setAlpha(j);
        this.mPageNumberBg.setAlpha(j);
        PANEL_TEXT_PAINT.setAlpha(j);
        if (LauncherApplication.getSmallestWidth() < 800) {
          break label634;
        }
        paramCanvas.translate(0.0F, 10.0F);
        label259:
        this.mFastScrollBarDrawable.draw(paramCanvas);
        j = (int)(this.mScrollPosition * (this.mScrollBarWidth - this.mScrollBarThumbWidth));
        paramCanvas.translate(j, 0.0F);
        this.mFastScrollThumbDrawable.draw(paramCanvas);
        paramCanvas.translate(-j, 0.0F);
        if (LauncherApplication.getSmallestWidth() < 800) {
          break label643;
        }
        paramCanvas.translate(0.0F, -10.0F);
      }
    }
    for (;;)
    {
      if (this.mFastScrollNumBgTop == 0)
      {
        localRect = this.mPageNumberBg.getBounds();
        j = (this.mScrollBarWidth - localRect.width()) / 2;
        k = -localRect.height() + this.mPageindicatorPanelTopAdjust;
        paramCanvas.translate(j, k);
        this.mPageNumberBg.draw(paramCanvas);
        drawPageNumber(paramPagedView.getContext(), paramCanvas, this.mCurrentPage + 1, this.mPageNumberBg, PANEL_TEXT_PAINT);
        paramCanvas.translate(-j, -k);
      }
      if (f == 0.0F) {
        bool2 = drawIndicatorDots(paramCanvas, paramPagedView, i, this.mFirstTextIndex, this.mGap, paramLong);
      }
      paramCanvas.restore();
      if ((f > 0.0F) && (this.mFastScrollNumBgTop != 0))
      {
        paramCanvas.save();
        paramCanvas.translate(this.mLeft + (this.mScrollBarWidth - this.mPageNumberBg.getBounds().width()) / 2, this.mFastScrollNumBgTop - 30);
        this.mPageNumberBg.draw(paramCanvas);
        drawPageNumber(paramPagedView.getContext(), paramCanvas, this.mCurrentPage + 1, this.mPageNumberBg, PANEL_TEXT_PAINT);
        paramCanvas.restore();
      }
      boolean bool1 = bool2;
      if (f > 0.0F)
      {
        bool1 = bool2;
        if (f < 1.0F) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.mIsHiding) {
        break;
      }
      this.mIsHiding = false;
      this.mIsDraw = false;
      return true;
      localRect = this.mPageNumberBg.getBounds();
      localRect.right = (this.mPanelSize + this.mPanelSize / 2);
      this.mPageNumberBg.setBounds(localRect);
      break label182;
      label634:
      paramCanvas.translate(0.0F, 1.0F);
      break label259;
      label643:
      paramCanvas.translate(0.0F, -1.0F);
    }
  }
  
  public boolean drawIndicatorDots(Canvas paramCanvas, PagedView paramPagedView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    boolean bool = false;
    boolean[] arrayOfBoolean = new boolean[6];
    boolean[] tmp11_9 = arrayOfBoolean;
    tmp11_9[0] = 0;
    boolean[] tmp16_11 = tmp11_9;
    tmp16_11[1] = 0;
    boolean[] tmp21_16 = tmp16_11;
    tmp21_16[2] = 0;
    boolean[] tmp26_21 = tmp21_16;
    tmp26_21[3] = 0;
    boolean[] tmp31_26 = tmp26_21;
    tmp31_26[4] = 0;
    boolean[] tmp36_31 = tmp31_26;
    tmp36_31[5] = 0;
    tmp36_31;
    int i = 0;
    while (i < paramInt1)
    {
      if (this.mDisplayItem == PageIndicatorManager.DISPLAY_ITEM.SECRET_PAGE) {
        tmp11_9[2] = true;
      }
      float f = this.mPage[i].getScale(paramLong);
      if (this.mPage[i].draw(paramCanvas, paramPagedView, paramInt2 + i, this.mPageDrawable.getIntrinsicWidth(), this.mPageDrawable.getIntrinsicHeight(), 1.0F, f, tmp11_9)) {
        bool = true;
      }
      paramCanvas.translate(this.mPageDrawable.getIntrinsicWidth() + paramInt3, 0.0F);
      i += 1;
    }
    return bool;
  }
  
  void enableLeftMore(boolean paramBoolean)
  {
    this.mIsVisibleLeftMore = paramBoolean;
  }
  
  void enableRightMore(boolean paramBoolean)
  {
    this.mIsVisibleRightMore = paramBoolean;
  }
  
  public void enterFastScroll()
  {
    this.mIsFastScrolling = true;
    this.mIsDraw = true;
    this.mFastScrollFactor.to(1.0F);
  }
  
  public void exitFastScroll()
  {
    this.mIsFastScrolling = false;
    this.mIsDraw = true;
    this.mFastScrollFactor.to(0.0F);
  }
  
  public ScalarAnimator getFastScrollFactor()
  {
    return this.mFastScrollFactor;
  }
  
  public int getHeight()
  {
    return this.mPageDrawable.getIntrinsicHeight();
  }
  
  int getPageTouchArea(int paramInt1, int paramInt2)
  {
    if ((this.mPageDrawable == null) || (!this.mEnableTouch)) {
      return -1;
    }
    int j = 0;
    int i = j;
    if (Launcher.sIsHeadlinesAppEnable)
    {
      i = j;
      if (this.mShowHeadLinesPage) {
        i = 1;
      }
    }
    int k = this.mDisplayPageCount;
    int m = this.mGap;
    j = this.mMoreGap;
    int n = this.mLeft;
    int i1 = m / 2;
    int i2 = this.mPageDrawable.getIntrinsicWidth();
    int i3 = this.mPageDrawable.getIntrinsicHeight();
    this.rect.top = (this.mTop - 10);
    this.rect.bottom = (this.mTop + i3 + 8 + 10);
    if (this.mIsVisibleLeftMore)
    {
      this.rect.left = (n - this.mMoreDrawable.getIntrinsicWidth() - j - i1);
      this.rect.right = n;
      if (this.rect.contains(paramInt1, paramInt2)) {
        return -2;
      }
    }
    if (this.mIsVisibleRightMore)
    {
      this.rect.left = (this.mMaxVisiblePages * i2 + n + (this.mMaxVisiblePages - 2) * m);
      this.rect.right = (this.rect.left + this.mMoreDrawable.getIntrinsicWidth() + i1);
      if (this.rect.contains(paramInt1, paramInt2)) {
        return -3;
      }
    }
    j = 0;
    while (j < k + 0 + i)
    {
      this.rect.left = ((i2 + m) * j + n - i1);
      this.rect.right = (this.rect.left + i2 + i1 * 2);
      if (this.rect.contains(paramInt1, paramInt2)) {
        return this.mFirstTextIndex + j;
      }
      j += 1;
    }
    return -1;
  }
  
  public Rect[] getPreviewRects()
  {
    return null;
  }
  
  public void handleOrientationChange(Resources paramResources)
  {
    setupDimens(paramResources);
  }
  
  public void hide(boolean paramBoolean)
  {
    int j = this.mDisplayPageCount;
    int i = 0;
    while (i < j)
    {
      this.mPage[i].setDrawState(0);
      if (!paramBoolean) {
        this.mPage[i].endAnimation();
      }
      i += 1;
    }
    this.mIsHiding = true;
  }
  
  public boolean isFastScrolling()
  {
    return this.mIsFastScrolling;
  }
  
  public void setAddPageDrawable(Drawable paramDrawable)
  {
    this.mAddPageDrawable = paramDrawable;
    updatePositions();
  }
  
  public void setAnimationPrevented(boolean paramBoolean)
  {
    this.mIsAnimationPrevented = paramBoolean;
  }
  
  public void setCameraPageDrawable(Drawable paramDrawable)
  {
    this.mCameraPageDrawable = paramDrawable;
    updatePositions();
  }
  
  void setCurrentPage(int paramInt, boolean paramBoolean, PagedView paramPagedView)
  {
    this.mCurrentPage = paramInt;
    if (this.mIsHiding) {}
    label74:
    label185:
    label203:
    do
    {
      return;
      int k = this.mDisplayPageCount;
      int i;
      int j;
      if (this.mTotalPageCount == k)
      {
        i = 0;
        if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && ((paramPagedView instanceof Workspace)) && (this.mDisplayItem == PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE)) {
          this.mCurrentPage = 0;
        }
        setFirstTextNum(i);
        j = 0;
        if (j >= k) {
          continue;
        }
        if (j + i != paramInt) {
          break label203;
        }
        if (!paramBoolean) {
          break label185;
        }
        this.mPage[j].setDrawState(3, this.mIsAnimationPrevented);
      }
      for (;;)
      {
        j += 1;
        break label74;
        if (this.mCurrentPage <= this.mMaxVisiblePages / 2)
        {
          i = 0;
          break;
        }
        if (this.mCurrentPage + this.mMaxVisiblePages / 2 < this.mTotalPageCount)
        {
          i = this.mCurrentPage - this.mMaxVisiblePages / 2;
          break;
        }
        i = this.mTotalPageCount - this.mMaxVisiblePages;
        break;
        this.mPage[j].setDrawState(3, this.mIsAnimationPrevented);
        continue;
        this.mPage[j].setDrawState(1, this.mIsAnimationPrevented);
      }
    } while (!this.mIsAnimationPrevented);
    this.mIsAnimationPrevented = false;
  }
  
  public void setDefaultPageDrawable(Drawable paramDrawable)
  {
    this.mDefaultPageDrawable = paramDrawable;
    updatePositions();
  }
  
  public void setDisplayItem(PageIndicatorManager.DISPLAY_ITEM paramDISPLAY_ITEM)
  {
    this.mDisplayItem = paramDISPLAY_ITEM;
  }
  
  public void setFestivalPageDrawable(Drawable paramDrawable)
  {
    this.mFestivalPageDrawable = paramDrawable;
    updatePositions();
  }
  
  void setFirstTextNum(int paramInt)
  {
    this.mFirstTextIndex = paramInt;
  }
  
  public void setFocusDefaultPageDrawable(Drawable paramDrawable)
  {
    if (LauncherApplication.getSmallestWidth() >= 600) {
      this.mFocustDefaultPageDrawable = paramDrawable;
    }
  }
  
  public void setFocusPageDrawable(Drawable paramDrawable)
  {
    if (LauncherApplication.getSmallestWidth() >= 600) {
      this.mFocusPageDrawable = paramDrawable;
    }
  }
  
  public void setFolderPageDrawable(Drawable paramDrawable)
  {
    this.mFolderPageDrawable = paramDrawable;
    updatePositions();
  }
  
  void setGap(int paramInt)
  {
    setGap(paramInt, paramInt);
  }
  
  void setGap(int paramInt1, int paramInt2)
  {
    this.mGap = paramInt1;
    this.mMoreGap = paramInt2;
  }
  
  public void setHeadlinesPageDrawable(Drawable paramDrawable)
  {
    this.mHeadlinesPageDrawable = paramDrawable;
    updatePositions();
  }
  
  public void setMoreDrawable(Drawable paramDrawable)
  {
    this.mMoreDrawable = paramDrawable;
  }
  
  void setOffset(int paramInt1, int paramInt2)
  {
    this.mTop = paramInt2;
    this.mLeft = paramInt1;
    if (this.mIsWorkspaceItem) {
      this.mLeft -= this.mHotseatBarSize;
    }
    if (Launcher.is_TB) {
      this.mLeft -= this.mPageIndicatorPanelRightAdjust;
    }
  }
  
  void setPageCount(int paramInt)
  {
    this.mTotalPageCount = paramInt;
    int i = paramInt;
    if (paramInt > this.mMaxVisiblePages) {
      i = this.mMaxVisiblePages;
    }
    if (this.mDisplayPageCount != i)
    {
      this.mPage = new Page[i];
      paramInt = 0;
      while (paramInt < i)
      {
        this.mPage[paramInt] = new Page();
        paramInt += 1;
      }
    }
    this.mDisplayPageCount = i;
  }
  
  public void setPageDrawable(Drawable paramDrawable)
  {
    this.mPageDrawable = paramDrawable;
    updatePositions();
  }
  
  public void setPageIndicatorPanelRightAdjust(int paramInt)
  {
    if (Launcher.is_TB) {}
    for (;;)
    {
      this.mPageIndicatorPanelRightAdjust = paramInt;
      return;
      paramInt = 0;
    }
  }
  
  public void setScrollPosition(float paramFloat)
  {
    this.mScrollPosition = paramFloat;
  }
  
  public void setSecretPageDrawable(Drawable paramDrawable)
  {
    this.mSecretPageDrawable = paramDrawable;
    updatePositions();
  }
  
  public void setShowHeadLinePage(boolean paramBoolean)
  {
    this.mShowHeadLinesPage = paramBoolean;
  }
  
  public void setupDimens(Resources paramResources)
  {
    this.mFastScrollThumbDrawable = paramResources.getDrawable(2130837577);
    this.mFastScrollBarDrawable = paramResources.getDrawable(2130837576);
    this.mPageNumberBg = paramResources.getDrawable(2130837759);
    PANEL_TEXT_PAINT.setTextSize(paramResources.getDimensionPixelSize(2131624163));
    this.mGrowBy = (paramResources.getDimensionPixelSize(2131624162) / 2.0F);
    this.mPanelSize = paramResources.getDimensionPixelSize(2131624164);
    this.mPageNumberBg.setBounds(0, 0, this.mPanelSize, this.mPanelSize);
    if (LauncherApplication.isTabletLayout())
    {
      this.mFastScrollNumBgTop = paramResources.getDimensionPixelSize(2131624553);
      this.mPageindicatorPanelTopAdjust = paramResources.getDimensionPixelSize(2131624165);
      this.mFastScrollPaddingTop = paramResources.getDimensionPixelSize(2131624018);
      this.mFastScrollPaddingTopDelta = paramResources.getDimensionPixelSize(2131624019);
      if (this.mIsWorkspaceItem)
      {
        this.mHotseatBarSize = paramResources.getDimensionPixelSize(2131624195);
        if ((!LauncherApplication.isTabletLayout()) && (paramResources.getConfiguration().orientation != 1)) {
          break label228;
        }
        this.mHotseatBarSize = 0;
      }
      label179:
      if ((Launcher.is_TB) && (paramResources.getConfiguration().orientation == 1))
      {
        if (Utilities.getDeviceRotation(Launcher.getInstance().getBaseContext()) != 0) {
          break label248;
        }
        this.mPageIndicatorPanelRightAdjust = paramResources.getDimensionPixelSize(2131624108);
      }
    }
    label228:
    label248:
    while (Utilities.getDeviceRotation(Launcher.getInstance().getBaseContext()) != 2)
    {
      return;
      this.mFastScrollNumBgTop = 0;
      break;
      if (this.mHotseatBarSize <= 0) {
        break label179;
      }
      this.mHotseatBarSize /= 2;
      break label179;
    }
    this.mPageIndicatorPanelRightAdjust = paramResources.getDimensionPixelSize(2131624109);
  }
  
  public void show()
  {
    show(false, true);
  }
  
  public void show(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mIsDraw) && (!paramBoolean1)) {
      return;
    }
    this.mIsDraw = true;
    this.mIsHiding = false;
  }
  
  public void updatePositions()
  {
    int k = this.mDisplayPageCount;
    if (this.mPageDrawable == null) {
      return;
    }
    int j = this.mPageDrawable.getIntrinsicWidth();
    int i = j;
    if (k <= 2) {
      i = j + 10;
    }
    i = i * k + this.mGap * (k - 1);
    this.mFastScrollBarDrawable.setBounds(0, this.mFastScrollPaddingTop, i, this.mFastScrollBarDrawable.getIntrinsicHeight() + this.mFastScrollPaddingTop);
    j = this.mFastScrollThumbDrawable.getIntrinsicWidth();
    k = this.mFastScrollThumbDrawable.getIntrinsicHeight();
    int m = (this.mFastScrollBarDrawable.getIntrinsicHeight() - k) / 2 + this.mFastScrollPaddingTop - this.mFastScrollPaddingTopDelta;
    this.mFastScrollThumbDrawable.setBounds(0, m, j, m + k);
    this.mScrollBarWidth = (i - 0);
    this.mScrollBarThumbWidth = (j - 0);
  }
  
  public class Page
  {
    protected int mAnimationDuration = 200;
    private float mAnimationFrom;
    private long mAnimationStartTime;
    private int mAnimationState = 3;
    private float mAnimationTo;
    private int mDrawState = 1;
    private boolean mIsDraggedOn = false;
    private int mPrevDrawState = 1;
    
    public Page() {}
    
    boolean draw(Canvas paramCanvas, PagedView paramPagedView, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, boolean[] paramArrayOfBoolean)
    {
      int j = (int)(PageIndicator.this.mGrowBy * paramFloat2);
      int i = 0;
      float f = PageIndicator.this.mFastScrollFactor.get();
      if (PageIndicator.this.mIsHiding)
      {
        paramFloat1 = paramFloat2 * paramFloat1;
        if ((j <= 0) || (LauncherApplication.getSmallestWidth() < 600)) {
          break label289;
        }
        if (paramArrayOfBoolean[0] == 0) {
          break label167;
        }
        i = 1;
        PageIndicator.this.mFocustDefaultPageDrawable.setBounds(0, 0, paramInt2, paramInt3);
        PageIndicator.this.mFocustDefaultPageDrawable.draw(paramCanvas);
        PageIndicator.this.mFocustDefaultPageDrawable.setAlpha((int)(255.0F * paramFloat1));
        paramInt2 = i;
        label116:
        if (paramInt2 == 0)
        {
          if (paramArrayOfBoolean[1] == 0) {
            break label720;
          }
          PageIndicator.this.mCameraPageDrawable.draw(paramCanvas);
        }
      }
      for (;;)
      {
        if (this.mAnimationState == 3) {
          break label862;
        }
        return true;
        paramFloat2 = (0.5F * paramFloat2 + 0.5F) * (1.0F - f);
        break;
        label167:
        i = 1;
        if (isFolderPage(paramPagedView, paramInt1))
        {
          PageIndicator.this.mFolderPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
          PageIndicator.this.mFolderPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mFolderPageDrawable.draw(paramCanvas);
          paramInt2 = i;
          break label116;
        }
        PageIndicator.this.mFocusPageDrawable.setBounds(0, 0, paramInt2, paramInt3);
        PageIndicator.this.mFocusPageDrawable.draw(paramCanvas);
        PageIndicator.this.mFocusPageDrawable.setAlpha((int)(255.0F * paramFloat1));
        paramInt2 = i;
        break label116;
        label289:
        if (paramArrayOfBoolean[1] != 0)
        {
          PageIndicator.this.mCameraPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mCameraPageDrawable.setBounds(-j, -3, paramInt2 + j, paramInt3 - 3);
          paramInt2 = i;
          break label116;
        }
        if (paramArrayOfBoolean[4] != 0)
        {
          PageIndicator.this.mHeadlinesPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mHeadlinesPageDrawable.setBounds(-j, 0, paramInt2 + j, paramInt3);
          paramInt2 = i;
          break label116;
        }
        if (paramArrayOfBoolean[0] != 0)
        {
          PageIndicator.this.mDefaultPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mDefaultPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
          paramInt2 = i;
          break label116;
        }
        if (paramArrayOfBoolean[5] != 0)
        {
          PageIndicator.this.mAddPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mAddPageDrawable.setBounds(-j, 0, paramInt2 + j, paramInt3);
          paramInt2 = i;
          break label116;
        }
        if (paramArrayOfBoolean[2] != 0)
        {
          PageIndicator.this.mSecretPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mSecretPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
          paramInt2 = i;
          break label116;
        }
        if (paramArrayOfBoolean[3] != 0)
        {
          PageIndicator.this.mFestivalPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mFestivalPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
          paramInt2 = i;
          break label116;
        }
        if (isFolderPage(paramPagedView, paramInt1))
        {
          PageIndicator.this.mFolderPageDrawable.setAlpha((int)(255.0F * paramFloat1));
          PageIndicator.this.mFolderPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
          paramInt2 = i;
          break label116;
        }
        PageIndicator.this.mPageDrawable.setAlpha((int)(255.0F * paramFloat1));
        PageIndicator.this.mPageDrawable.setBounds(-j, -j, paramInt2 + j, paramInt3 + j);
        paramInt2 = i;
        break label116;
        label720:
        if (paramArrayOfBoolean[4] != 0) {
          PageIndicator.this.mHeadlinesPageDrawable.draw(paramCanvas);
        } else if (paramArrayOfBoolean[5] != 0) {
          PageIndicator.this.mAddPageDrawable.draw(paramCanvas);
        } else if (paramArrayOfBoolean[0] != 0) {
          PageIndicator.this.mDefaultPageDrawable.draw(paramCanvas);
        } else if (paramArrayOfBoolean[2] != 0) {
          PageIndicator.this.mSecretPageDrawable.draw(paramCanvas);
        } else if (paramArrayOfBoolean[3] != 0) {
          PageIndicator.this.mFestivalPageDrawable.draw(paramCanvas);
        } else if (isFolderPage(paramPagedView, paramInt1)) {
          PageIndicator.this.mFolderPageDrawable.draw(paramCanvas);
        } else {
          PageIndicator.this.mPageDrawable.draw(paramCanvas);
        }
      }
      label862:
      return false;
    }
    
    void endAnimation()
    {
      this.mAnimationState = 3;
    }
    
    public float getScale()
    {
      return getScale(SystemClock.uptimeMillis());
    }
    
    public float getScale(long paramLong)
    {
      float f = 0.0F;
      if (this.mAnimationState == 1)
      {
        this.mAnimationStartTime = paramLong;
        this.mAnimationState = 2;
      }
      if (this.mAnimationState == 2)
      {
        f = (float)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / this.mAnimationDuration;
        if (f >= 1.0F) {
          this.mAnimationState = 3;
        }
        f = Math.min(f, 1.0F);
        f = this.mAnimationFrom + (this.mAnimationTo - this.mAnimationFrom) * f;
      }
      while (this.mAnimationState != 3) {
        return f;
      }
      return PageIndicator.rate[this.mDrawState];
    }
    
    void initDrawState()
    {
      this.mPrevDrawState = 0;
      this.mDrawState = 0;
    }
    
    public boolean isDraggedOn()
    {
      return this.mIsDraggedOn;
    }
    
    boolean isFolderPage(PagedView paramPagedView, int paramInt)
    {
      return false;
    }
    
    public void setDraggedOn(boolean paramBoolean)
    {
      this.mIsDraggedOn = paramBoolean;
    }
    
    void setDrawState(int paramInt)
    {
      setDrawState(paramInt, true);
    }
    
    void setDrawState(int paramInt, boolean paramBoolean)
    {
      this.mPrevDrawState = this.mDrawState;
      this.mDrawState = paramInt;
      if ((!paramBoolean) && (this.mDrawState != this.mPrevDrawState))
      {
        this.mAnimationState = 1;
        this.mAnimationTo = PageIndicator.rate[this.mDrawState];
        this.mAnimationFrom = PageIndicator.rate[this.mPrevDrawState];
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */