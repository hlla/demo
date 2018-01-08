package com.android.launcher2;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.launcher2.guide.GuideFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PagePreviewIndicator
  extends PageIndicator
{
  static Paint mTestPaint = new Paint();
  private final ScalarAnimator mDragMode = new ScalarAnimator(230L, 0.0F);
  private Rect[] mFromRects;
  private Drawable mItemOutlineNormalBlock;
  private Drawable mItemOutlineNormalO;
  private Drawable mItemOutlineSelectedBlock;
  private Drawable mItemOutlineSelectedO;
  PageIndicator.Page mNewPage;
  protected final ScalarAnimator mNewPageSelectedAnimator = new ScalarAnimator(200L, 0.0F);
  private int mNormalPreviewHeight;
  private int mNormalPreviewWidth;
  private int mPgIndContentGap;
  private int mPgIndContentPadding;
  private int mPgIndPanel_AdjustTop;
  private int mPreviewGapWidth;
  private Drawable mPreviewNormalAddDrawable;
  private Drawable mPreviewNormalDrawable;
  private Rect[] mPreviewRects;
  private Drawable mPreviewSelectedAddDrawable;
  private Drawable mPreviewSelectedDrawable;
  private int mSelectedPreviewHeight;
  private int mSelectedPreviewWidth;
  private Rect[] mToRects;
  
  static
  {
    mTestPaint.setColor(-65536);
    mTestPaint.setStyle(Paint.Style.STROKE);
  }
  
  public PagePreviewIndicator(Resources paramResources, int paramInt)
  {
    super(paramResources, paramInt);
    int i = LauncherApplication.getMaxScreenCount() + 2;
    paramInt = i;
    if (LauncherApplication.sFestivalPageLauncher) {
      paramInt = i + LauncherApplication.getMaxFestivalScreenCount();
    }
    this.mFromRects = new Rect[paramInt];
    this.mToRects = new Rect[paramInt];
    this.mPreviewRects = new Rect[paramInt];
    i = 0;
    while (i < paramInt)
    {
      this.mFromRects[i] = new Rect();
      this.mToRects[i] = new Rect();
      this.mPreviewRects[i] = new Rect();
      i += 1;
    }
    this.mNewPage = new PageIndicator.Page(this);
  }
  
  private int getPreviewPageWidth(float paramFloat)
  {
    return (int)PagedView.mix(this.mNormalPreviewWidth, this.mSelectedPreviewWidth, paramFloat);
  }
  
  void animateDragMode(float paramFloat)
  {
    this.mDragMode.to(paramFloat);
  }
  
  boolean draw(Canvas paramCanvas, PagedView paramPagedView, long paramLong)
  {
    setupIndicatorPreviews(paramPagedView, paramLong);
    return super.draw(paramCanvas, paramPagedView, paramLong);
  }
  
  public boolean drawIndicatorDots(Canvas paramCanvas, PagedView paramPagedView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    int j = 0;
    paramInt3 = 0;
    float f1 = this.mDragMode.get();
    Rect localRect1 = new Rect();
    Object localObject1 = new boolean[6];
    Object tmp32_30 = localObject1;
    tmp32_30[0] = 0;
    Object tmp37_32 = tmp32_30;
    tmp37_32[1] = 0;
    Object tmp42_37 = tmp37_32;
    tmp42_37[2] = 0;
    Object tmp47_42 = tmp42_37;
    tmp47_42[3] = 0;
    Object tmp52_47 = tmp47_42;
    tmp52_47[4] = 0;
    Object tmp57_52 = tmp52_47;
    tmp57_52[5] = 0;
    tmp57_52;
    int m = LauncherApplication.getHomeScreenIndex();
    Object localObject2;
    if (this.mDragMode.get() > 0.0F)
    {
      paramInt2 = 0;
      j = paramInt3;
      if (paramInt2 < paramInt1)
      {
        if (paramInt2 >= this.mFromRects.length) {}
        for (;;)
        {
          paramInt2 += 1;
          break;
          localObject1 = this.mFromRects[(paramInt2 - 0)];
          localObject2 = this.mToRects[(paramInt2 - 0)];
          localRect1.left = ((int)PagedView.mix(((Rect)localObject1).left, ((Rect)localObject2).left, f1));
          localRect1.top = ((int)PagedView.mix(((Rect)localObject1).top, ((Rect)localObject2).top, f1));
          localRect1.right = ((int)PagedView.mix(((Rect)localObject1).right, ((Rect)localObject2).right, f1));
          localRect1.bottom = ((int)PagedView.mix(((Rect)localObject1).bottom, ((Rect)localObject2).bottom, f1));
          paramCanvas.save();
          paramCanvas.translate(localRect1.left, localRect1.top);
          drawPagePreview(paramCanvas, paramInt2, localRect1, f1, paramPagedView);
          paramCanvas.restore();
        }
      }
    }
    else
    {
      if (!((Workspace)paramPagedView).isStartDragStarted()) {
        break label308;
      }
      j = paramInt3;
    }
    if ((this.mDragMode.isAnimating()) || (this.mNewPageSelectedAnimator.isAnimating())) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      return j | paramInt1;
      label308:
      paramInt3 = 0;
      int i = paramInt3;
      if (Launcher.sIsHeadlinesAppEnable)
      {
        i = paramInt3;
        if (this.mShowHeadLinesPage)
        {
          i = 1;
          localObject2 = this.mFromRects[0];
          localRect2 = this.mToRects[0];
          localRect1.left = ((int)PagedView.mix(((Rect)localObject2).left, localRect2.left, f1));
          localRect1.top = ((int)PagedView.mix(((Rect)localObject2).top, localRect2.top, f1));
          localRect1.right = ((int)PagedView.mix(((Rect)localObject2).right, localRect2.right, f1));
          localRect1.bottom = ((int)PagedView.mix(((Rect)localObject2).bottom, localRect2.bottom, f1));
          paramCanvas.save();
          paramCanvas.translate(localRect1.left, localRect1.top);
          f2 = Math.max(0.0F, 1.0F - this.mDragMode.get() * 5.0F);
          localObject1[0] = 0;
          localObject1[1] = 0;
          localObject1[4] = 1;
          localObject2 = new PageIndicator.Page(this);
          ((PageIndicator.Page)localObject2).draw(paramCanvas, paramPagedView, 0, this.mHeadlinesPageDrawable.getIntrinsicWidth(), this.mHeadlinesPageDrawable.getIntrinsicHeight(), f2, ((PageIndicator.Page)localObject2).getScale(paramLong), (boolean[])localObject1);
          ((PageIndicator.Page)localObject2).setDrawState(3);
          paramCanvas.restore();
        }
      }
      int k = 0;
      paramInt3 = j;
      for (;;)
      {
        j = paramInt3;
        if (k >= paramInt1) {
          break;
        }
        if (k < this.mFromRects.length) {
          break label587;
        }
        k += 1;
      }
      label587:
      localObject2 = this.mFromRects[(k + i - 0)];
      Rect localRect2 = this.mToRects[(k + i - 0)];
      localRect1.left = ((int)PagedView.mix(((Rect)localObject2).left, localRect2.left, f1));
      localRect1.top = ((int)PagedView.mix(((Rect)localObject2).top, localRect2.top, f1));
      localRect1.right = ((int)PagedView.mix(((Rect)localObject2).right, localRect2.right, f1));
      localRect1.bottom = ((int)PagedView.mix(((Rect)localObject2).bottom, localRect2.bottom, f1));
      paramCanvas.save();
      paramCanvas.translate(localRect1.left, localRect1.top);
      float f2 = Math.max(0.0F, 1.0F - this.mDragMode.get() * 5.0F);
      int n;
      if (m == k - 0)
      {
        n = 1;
        label758:
        localObject1[0] = n;
        localObject1[1] = 0;
        if (LauncherApplication.sFestivalPageLauncher) {
          switch (this.mDisplayItem)
          {
          }
        }
      }
      for (;;)
      {
        localObject1[4] = 0;
        if (this.mPage[(k - 0)].draw(paramCanvas, paramPagedView, paramInt2 + k, localRect1.width(), localRect1.height(), f2, this.mPage[(k - 0)].getScale(paramLong), (boolean[])localObject1)) {
          paramInt3 = 1;
        }
        paramCanvas.restore();
        break;
        n = 0;
        break label758;
        localObject2 = (CellLayout)paramPagedView.getChildAt(k);
        if ((localObject2 != null) && (((CellLayout)localObject2).getPageType() == 2))
        {
          localObject1[3] = 1;
        }
        else
        {
          localObject1[3] = 0;
          continue;
          localObject1[3] = 0;
          continue;
          localObject1[3] = 1;
        }
      }
    }
  }
  
  public boolean drawPagePreview(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat, PagedView paramPagedView)
  {
    if ((Launcher.isHelpAppRunning) && (GuideFragment.GMode.equals("add_widgets"))) {}
    do
    {
      return false;
      if (paramInt != this.mCurrentPage) {
        break;
      }
      localObject1 = this.mPreviewSelectedDrawable;
      ((Drawable)localObject1).setBounds(0, 0, paramRect.width() - this.mPgIndContentGap, paramRect.height() - this.mPgIndContentGap);
      ((Drawable)localObject1).setAlpha((int)(255.0F * paramFloat));
      ((Drawable)localObject1).draw(paramCanvas);
      paramFloat = Math.max(0.0F, paramFloat - 0.7F) / 0.3F;
    } while ((paramPagedView.getChildAt(paramInt) == null) || (((CellLayout)paramPagedView.getChildAt(paramInt)).mPositioner == null));
    Object localObject1 = ((CellLayout)paramPagedView.getChildAt(paramInt)).mPositioner.getDeltas();
    label169:
    PositionDelta localPositionDelta1;
    Object localObject2;
    if (((List)localObject1).isEmpty())
    {
      localObject1 = new ArrayList();
      ((CellLayoutWithResizableWidgets)paramPagedView.getChildAt(paramInt)).getDeltas((List)localObject1);
      localPositionDelta1 = ((CellPositionerWorkspace)((CellLayout)paramPagedView.getChildAt(paramInt)).mPositioner).getDragDelta();
      if (localPositionDelta1 == null) {
        break label354;
      }
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PositionDelta localPositionDelta2 = (PositionDelta)((Iterator)localObject2).next();
        if (localPositionDelta2.item == localPositionDelta1.item) {
          ((List)localObject1).remove(localPositionDelta2);
        }
      }
      if ((((Launcher)paramPagedView.getContext()).mHomeView.getCurrentResizeWidgetItem() != null) || (((CellLayout)paramPagedView.getChildAt(paramInt)).mDragging)) {
        ((List)localObject1).add(0, localPositionDelta1);
      }
    }
    for (;;)
    {
      drawPreviewContent(paramCanvas, paramInt, paramRect, paramFloat, (List)localObject1, (Launcher)paramPagedView.getContext(), localPositionDelta1);
      return false;
      if (paramPagedView.isPageAddedForDrag(paramInt))
      {
        localObject1 = this.mPreviewNormalAddDrawable;
        break;
      }
      localObject1 = this.mPreviewNormalDrawable;
      break;
      localObject1 = new ArrayList((Collection)localObject1);
      break label169;
      label354:
      if (((CellLayoutWithResizableWidgets)paramPagedView.getChildAt(paramInt)).getResizeFrame() != null)
      {
        localObject2 = ((Launcher)paramPagedView.getContext()).mHomeView.getCurrentResizeWidgetItem();
        if (localObject2 != null) {
          ((List)localObject1).add(0, new PositionDelta((BaseItem)localObject2));
        }
      }
    }
  }
  
  public void drawPreviewContent(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat, List<PositionDelta> paramList, Launcher paramLauncher, PositionDelta paramPositionDelta)
  {
    Object localObject = this.mPreviewRects[paramInt];
    float f = paramRect.height() / ((Rect)localObject).height();
    int j = ((Rect)localObject).height();
    int k = this.mPgIndContentPadding;
    paramInt = ((Rect)localObject).width();
    int i = this.mPgIndContentPadding;
    j = (int)((j - k * 2) * f);
    i = (int)((paramInt - i * 2) * f);
    paramInt = j / LauncherModel.getCellCountY();
    i /= LauncherModel.getCellCountX();
    paramCanvas.save();
    paramCanvas.translate(this.mPgIndContentPadding, this.mPgIndContentPadding);
    paramRect = paramLauncher.mHomeView.getCurrentResizeWidgetItem();
    paramLauncher = paramLauncher.mHomeView.getCurrentDragItem();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (PositionDelta)paramList.next();
      if ((paramPositionDelta != null) || (paramLauncher != ((PositionDelta)localObject).item))
      {
        j = ((PositionDelta)localObject).getX();
        k = ((PositionDelta)localObject).getY();
        j *= i;
        k *= paramInt;
        int m = this.mPgIndContentGap;
        int n = ((PositionDelta)localObject).getSpanY();
        int i1 = ((PositionDelta)localObject).getSpanX();
        if (((paramPositionDelta != null) && (((PositionDelta)localObject).item == paramPositionDelta.item)) || (((PositionDelta)localObject).item == paramRect)) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = getOutlineForItem(((PositionDelta)localObject).getSpanX(), ((PositionDelta)localObject).getSpanY(), bool);
          ((Drawable)localObject).setAlpha((int)(255.0F * paramFloat));
          ((Drawable)localObject).setBounds(j, k, j + (i1 * i - m), k + (n * paramInt - m));
          ((Drawable)localObject).draw(paramCanvas);
          break;
        }
      }
    }
    paramCanvas.restore();
  }
  
  public float getDragModeFactor()
  {
    return this.mDragMode.get();
  }
  
  public void getItemSpan(BaseItem paramBaseItem, int[] paramArrayOfInt)
  {
    if ((paramBaseItem instanceof HomeItem))
    {
      paramBaseItem = (HomeItem)paramBaseItem;
      paramArrayOfInt[0] = paramBaseItem.spanX;
      paramArrayOfInt[1] = paramBaseItem.spanY;
      return;
    }
    if ((paramBaseItem instanceof AppItem))
    {
      paramArrayOfInt[0] = 1;
      paramArrayOfInt[1] = 1;
      return;
    }
    throw new IllegalArgumentException("Encounted item in paged indicator preview that we werent expecting!");
  }
  
  public Drawable getOutlineForItem(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      if (paramBoolean) {
        return this.mItemOutlineSelectedO;
      }
      return this.mItemOutlineNormalO;
    }
    if (paramBoolean) {
      return this.mItemOutlineSelectedBlock;
    }
    return this.mItemOutlineNormalBlock;
  }
  
  public int getPreviewPageHeight(float paramFloat)
  {
    return (int)PagedView.mix(this.mNormalPreviewHeight, this.mSelectedPreviewHeight, paramFloat);
  }
  
  public Rect[] getPreviewRects()
  {
    return this.mPreviewRects;
  }
  
  public void setupDimens(Resources paramResources)
  {
    super.setupDimens(paramResources);
    this.mPreviewNormalDrawable = paramResources.getDrawable(2130837641);
    this.mPreviewNormalAddDrawable = paramResources.getDrawable(2130837634);
    this.mPreviewSelectedDrawable = paramResources.getDrawable(2130837635);
    this.mPreviewSelectedAddDrawable = paramResources.getDrawable(2130837633);
    this.mItemOutlineNormalO = paramResources.getDrawable(2130837637);
    this.mItemOutlineSelectedO = paramResources.getDrawable(2130837638);
    this.mItemOutlineNormalBlock = paramResources.getDrawable(2130837639);
    this.mItemOutlineSelectedBlock = paramResources.getDrawable(2130837640);
    this.mPreviewNormalDrawable.setBounds(0, 0, this.mPreviewNormalDrawable.getIntrinsicWidth(), this.mPreviewNormalDrawable.getIntrinsicHeight());
    this.mPreviewNormalAddDrawable.setBounds(0, 0, this.mPreviewNormalAddDrawable.getIntrinsicWidth(), this.mPreviewNormalAddDrawable.getIntrinsicHeight());
    this.mPreviewSelectedDrawable.setBounds(0, 0, this.mPreviewSelectedDrawable.getIntrinsicWidth(), this.mPreviewSelectedDrawable.getIntrinsicHeight());
    this.mPreviewSelectedAddDrawable.setBounds(0, 0, this.mPreviewSelectedAddDrawable.getIntrinsicWidth(), this.mPreviewSelectedAddDrawable.getIntrinsicHeight());
    this.mNormalPreviewHeight = paramResources.getDimensionPixelSize(2131624169);
    this.mNormalPreviewWidth = paramResources.getDimensionPixelSize(2131624170);
    this.mSelectedPreviewHeight = paramResources.getDimensionPixelSize(2131624171);
    this.mSelectedPreviewWidth = paramResources.getDimensionPixelSize(2131624172);
    this.mPreviewGapWidth = paramResources.getDimensionPixelSize(2131624173);
    this.mPgIndContentGap = paramResources.getDimensionPixelSize(2131624174);
    this.mPgIndContentPadding = paramResources.getDimensionPixelSize(2131624175);
    this.mPgIndPanel_AdjustTop = paramResources.getDimensionPixelSize(2131624166);
  }
  
  void setupIndicatorPreviews(PagedView paramPagedView, long paramLong)
  {
    int i = Math.min(this.mDisplayPageCount, LauncherApplication.getMaxScreenCount());
    int j = this.mNormalPreviewWidth;
    int k = this.mSelectedPreviewWidth;
    int m = this.mNormalPreviewWidth;
    int n = this.mPreviewGapWidth;
    k = paramPagedView.getScrollX() + (paramPagedView.getWidth() - (j * i + (k - m) + (i - 1) * n)) / 2 - this.mHotseatBarSize;
    j = 0;
    m = this.mLeft;
    i = 0;
    float f;
    if (i < this.mToRects.length)
    {
      this.mToRects[i].left = (-(m - k) + j);
      f = 0.0F;
      if (i < this.mDisplayPageCount) {
        f = this.mPage[i].getScale(paramLong);
      }
      for (;;)
      {
        n = getPreviewPageHeight(f);
        int i1 = getPreviewPageWidth(f);
        this.mToRects[i].top = (-(n / 2) + this.mPgIndPanel_AdjustTop);
        this.mToRects[i].bottom = (n / 2 + this.mPgIndPanel_AdjustTop);
        this.mToRects[i].right = (this.mToRects[i].left + i1);
        j += this.mPreviewGapWidth + i1;
        i += 1;
        break;
        if (i == this.mDisplayPageCount) {
          f = this.mNewPage.getScale(paramLong);
        }
      }
    }
    j = k - paramPagedView.getScrollX();
    i = 0;
    if (i < this.mPreviewRects.length)
    {
      this.mPreviewRects[i].left = j;
      f = 0.0F;
      if (i < this.mDisplayPageCount) {
        f = this.mPage[i].getScale(paramLong);
      }
      for (;;)
      {
        k = getPreviewPageHeight(f);
        m = getPreviewPageWidth(f);
        this.mPreviewRects[i].top = (this.mTop - k / 2 + this.mPgIndPanel_AdjustTop);
        this.mPreviewRects[i].bottom = (this.mTop + k / 2 + this.mPgIndPanel_AdjustTop);
        this.mPreviewRects[i].right = (j + m);
        j += this.mPreviewGapWidth + m;
        i += 1;
        break;
        if (i == this.mDisplayPageCount) {
          f = this.mNewPage.getScale(paramLong);
        }
      }
    }
  }
  
  public void updatePositions()
  {
    super.updatePositions();
    int k = this.mPageDrawable.getIntrinsicWidth();
    int m = this.mPageDrawable.getIntrinsicHeight();
    int j = 0;
    int i = 0;
    while (i < this.mFromRects.length)
    {
      this.mFromRects[i].left = j;
      this.mFromRects[i].top = 0;
      this.mFromRects[i].right = (j + k);
      this.mFromRects[i].bottom = (m + 0);
      j += this.mGap + k;
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PagePreviewIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */