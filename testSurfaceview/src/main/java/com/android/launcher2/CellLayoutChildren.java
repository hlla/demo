package com.android.launcher2;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CellLayoutChildren
  extends ViewGroup
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "CellLayoutChildren";
  private int mCellHeight;
  private int mCellWidth;
  private int mGapX;
  private int mGapY;
  private BaseItem mHiddenItem = null;
  protected ViewGroup.OnHierarchyChangeListener mHierarchyChangeListener = new ViewGroup.OnHierarchyChangeListener()
  {
    public void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
    {
      paramAnonymousView1 = (CellLayout)((CellLayoutChildren)paramAnonymousView1).getParent();
      paramAnonymousView1.setEmptyMessageVisibility(8);
      ViewParent localViewParent = paramAnonymousView1.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        WorkspacePages.itemAddedToPage(((ViewGroup)localViewParent).indexOfChild(paramAnonymousView1), CellLayoutChildren.this.getContext());
      }
      CellLayoutChildren.this.onViewAddedInCLC(paramAnonymousView2);
    }
    
    public void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
    {
      if ((paramAnonymousView1.getParent() instanceof CellLayoutWithResizableWidgets))
      {
        paramAnonymousView1 = (CellLayoutWithResizableWidgets)paramAnonymousView1.getParent();
        AppWidgetResizeFrame localAppWidgetResizeFrame = paramAnonymousView1.getResizeFrame();
        if ((localAppWidgetResizeFrame != null) && (localAppWidgetResizeFrame.getWidgetView() == paramAnonymousView2)) {
          paramAnonymousView1.clearResizeFrame();
        }
      }
      CellLayoutChildren.this.onViewRemovedInCLC(paramAnonymousView2);
    }
  };
  private ItemViewBuilder mItemViewBuilder;
  ArrayList<BaseItem> mItems = new ArrayList();
  private final int[] mTmpCellXY = new int[2];
  private final WallpaperManager mWallpaperManager;
  
  public CellLayoutChildren(Context paramContext)
  {
    super(paramContext);
    this.mWallpaperManager = WallpaperManager.getInstance(paramContext);
    setMotionEventSplittingEnabled(false);
    setOnHierarchyChangeListener(this.mHierarchyChangeListener);
  }
  
  public boolean addItem(BaseItem paramBaseItem, boolean paramBoolean)
  {
    if (hasItem(paramBaseItem))
    {
      if (DEBUGGABLE) {
        Log.w("CellLayoutChildren", "Attempted to add a duplicate entry for this item " + paramBaseItem);
      }
      return false;
    }
    this.mItems.add(paramBaseItem);
    if (paramBoolean) {
      addView(buildView(paramBaseItem));
    }
    return true;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppIconView localAppIconView;
    if ((((View)getParent().getParent() instanceof Hotseat)) && ((paramView instanceof AppIconView)))
    {
      localAppIconView = (AppIconView)paramView;
      BaseItem localBaseItem = (BaseItem)localAppIconView.getTag();
      if (localBaseItem == null) {
        break label142;
      }
      if (DEBUGGABLE) {
        Log.d("CellLayoutChildren", "addView() adding view to Hotseat's CellLayoutChildren @ index = " + paramInt + " and title = " + localBaseItem.mTitle + " child count = " + getChildCount());
      }
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      if ((paramView instanceof DynamicShadowMixin.Holder))
      {
        paramView = ((DynamicShadowMixin.Holder)paramView).getDynamicShadowMixin();
        if (paramView != null) {
          paramView.setViewToInvalidate((View)getParent());
        }
      }
      return;
      label142:
      if (((localAppIconView instanceof AllappsIcon)) && (DEBUGGABLE)) {
        Log.d("CellLayoutChildren", "addView() adding all apps icon to Hotseat's CellLayoutChildren @ index = " + paramInt + " child count = " + getChildCount());
      }
    }
  }
  
  public View buildView(BaseItem paramBaseItem)
  {
    Object localObject = (CellLayout)getParent();
    localObject = this.mItemViewBuilder.buildView(paramBaseItem, (CellLayout)localObject);
    if (paramBaseItem == this.mHiddenItem) {
      ((View)localObject).setVisibility(8);
    }
    return (View)localObject;
  }
  
  public void buildViews()
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("Tried to build item views when we already had views.");
    }
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      addView(buildView((BaseItem)localIterator.next()));
    }
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
  
  public void disableHardwareLayers()
  {
    if (getLayerType() != 0) {
      setLayerType(0, Launcher.sViewLayerPaint);
    }
  }
  
  public void drawShadows(Canvas paramCanvas)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 0) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof DynamicShadowMixin.Holder))
        {
          DynamicShadowMixin localDynamicShadowMixin = ((DynamicShadowMixin.Holder)localView).getDynamicShadowMixin();
          if (localDynamicShadowMixin != null)
          {
            paramCanvas.save();
            paramCanvas.translate(localView.getLeft() + localView.getScrollX(), localView.getTop() + localView.getScrollY());
            localDynamicShadowMixin.draw(paramCanvas);
            paramCanvas.restore();
          }
        }
      }
    }
  }
  
  public void enableHardwareLayers()
  {
    if (getLayerType() != 2) {
      setLayerType(2, Launcher.sViewLayerPaint);
    }
  }
  
  public BaseItem findFolderItem(long paramLong)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext())
    {
      BaseItem localBaseItem = (BaseItem)localIterator.next();
      if (localBaseItem.mId == paramLong) {
        return localBaseItem;
      }
    }
    return null;
  }
  
  public View getChildAt(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView.getTag() == null) && (!(localView instanceof AllappsIcon))) {}
      CellLayout.LayoutParams localLayoutParams;
      do
      {
        i += 1;
        break;
        localLayoutParams = (CellLayout.LayoutParams)localView.getLayoutParams();
      } while ((localLayoutParams.cellX > paramInt1) || (paramInt1 >= localLayoutParams.cellX + localLayoutParams.cellHSpan) || (localLayoutParams.cellY > paramInt2) || (paramInt2 >= localLayoutParams.cellY + localLayoutParams.cellVSpan));
      return localView;
    }
    return null;
  }
  
  public View getChildAt(BaseItem paramBaseItem)
  {
    View localView;
    if (paramBaseItem == null)
    {
      localView = null;
      return localView;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label67;
      }
      localView = getChildAt(i);
      Object localObject = localView.getTag();
      if (((localObject instanceof BaseItem)) && (((BaseItem)localObject).mId == paramBaseItem.mId)) {
        break;
      }
      i += 1;
    }
    label67:
    return null;
  }
  
  public View getChildFromPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getTag() == null) {}
      while (((BaseItem)localView.getTag()).getPosition() != paramInt)
      {
        i += 1;
        break;
      }
      return localView;
    }
    return null;
  }
  
  public BaseItem getHiddenItem()
  {
    return this.mHiddenItem;
  }
  
  public BaseItem getItemAt(int paramInt)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext())
    {
      BaseItem localBaseItem = (BaseItem)localIterator.next();
      if (localBaseItem.getPosition() == paramInt) {
        return localBaseItem;
      }
    }
    return null;
  }
  
  public BaseItem getItemAt(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1, paramInt2);
    if (localView == null) {
      return null;
    }
    return (BaseItem)localView.getTag();
  }
  
  public boolean hasItem(BaseItem paramBaseItem)
  {
    return this.mItems.contains(paramBaseItem);
  }
  
  public <Closure> void iterateBaseItems(BaseItemIterator<Closure> paramBaseItemIterator, Closure paramClosure)
  {
    Iterator localIterator = this.mItems.iterator();
    while ((localIterator.hasNext()) && (paramBaseItemIterator.iterate((BaseItem)localIterator.next(), paramClosure))) {}
  }
  
  public void measureChild(View paramView)
  {
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.setup(this.mCellWidth, this.mCellHeight, this.mGapX, this.mGapY);
    int i = localLayoutParams.width;
    int j = localLayoutParams.height;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
  }
  
  void notifyWidgetsOfPageScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof SurfaceWidgetView)) {
        ((SurfaceWidgetView)localView).onPageScroll(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = getChildAt(paramInt1);
        CellLayout.LayoutParams localLayoutParams;
        if (((View)localObject).getVisibility() != 8)
        {
          localLayoutParams = (CellLayout.LayoutParams)((View)localObject).getLayoutParams();
          paramInt3 = localLayoutParams.x;
          paramInt4 = localLayoutParams.y;
        }
        try
        {
          ((View)localObject).layout(paramInt3, paramInt4, localLayoutParams.width + paramInt3, ((View)localObject).getMeasuredHeight() + paramInt4);
          if (localLayoutParams.dropped)
          {
            localLayoutParams.dropped = false;
            localObject = this.mTmpCellXY;
            getLocationOnScreen((int[])localObject);
            this.mWallpaperManager.sendWallpaperCommand(getWindowToken(), "android.home.drop", localObject[0] + paramInt3 + localLayoutParams.width / 2, localObject[1] + paramInt4 + localLayoutParams.height / 2, 0, null);
          }
          paramInt1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (DEBUGGABLE) {
              Log.e("CellLayoutChildren", "child layout exception. child tag : " + ((View)localObject).getTag());
            }
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == 0) || (View.MeasureSpec.getMode(paramInt2) == 0)) {
      throw new IllegalArgumentException("CellLayoutChildren cannot accept an UNSPECIFIED MeasureSpec");
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8) {
        measureChild(localView);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onViewAddedInCLC(View paramView)
  {
    if (paramView.getTag() == null)
    {
      Log.w("CellLayoutChildren", "Adding view to CellLayoutChildren without an associated item.");
      return;
    }
    CellLayout localCellLayout = (CellLayout)getParent();
    if (this.mItemViewBuilder != null) {
      this.mItemViewBuilder.onViewAdded(paramView, (BaseItem)paramView.getTag(), localCellLayout);
    }
    localCellLayout.onViewAddedToLayout(paramView);
  }
  
  protected void onViewRemovedInCLC(View paramView) {}
  
  public void removeAllItems()
  {
    this.mItems.clear();
    removeAllViews();
  }
  
  public boolean removeItem(BaseItem paramBaseItem)
  {
    boolean bool = this.mItems.remove(paramBaseItem);
    if (paramBaseItem == this.mHiddenItem) {
      this.mHiddenItem = null;
    }
    if (bool)
    {
      paramBaseItem = getChildAt(paramBaseItem);
      if (paramBaseItem != null) {
        removeView(paramBaseItem);
      }
    }
    return bool;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if (paramView1 != null)
    {
      paramView2 = new Rect();
      paramView1.getDrawingRect(paramView2);
      requestChildRectangleOnScreen(paramView1, paramView2, false);
    }
  }
  
  public void setCellDimensions(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mCellWidth = paramInt1;
    this.mCellHeight = paramInt2;
    this.mGapX = paramInt3;
    this.mGapY = paramInt4;
    if (DEBUGGABLE) {
      Log.d("CellLayoutChildren", "setCellDimensions. width: " + paramInt1 + ", height: " + paramInt2 + ", gapX: " + paramInt3 + ", gapY: " + paramInt4);
    }
  }
  
  protected void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setDrawingCacheEnabled(paramBoolean);
      if ((!localView.isHardwareAccelerated()) && (paramBoolean)) {
        localView.buildDrawingCache(true);
      }
      i += 1;
    }
  }
  
  protected void setChildrenDrawnWithCacheEnabled(boolean paramBoolean)
  {
    super.setChildrenDrawnWithCacheEnabled(paramBoolean);
  }
  
  public void setItemViewBuilder(ItemViewBuilder paramItemViewBuilder)
  {
    this.mItemViewBuilder = paramItemViewBuilder;
  }
  
  public void setItemVisibility(BaseItem paramBaseItem, int paramInt)
  {
    if (paramInt == 0) {}
    for (this.mHiddenItem = null;; this.mHiddenItem = paramBaseItem)
    {
      paramBaseItem = getChildAt(paramBaseItem);
      if ((paramBaseItem != null) && (!(paramBaseItem instanceof SurfaceWidgetView))) {
        paramBaseItem.setVisibility(paramInt);
      }
      return;
    }
  }
  
  public void setupLp(CellLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.setup(this.mCellWidth, this.mCellHeight, this.mGapX, this.mGapY);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public void updateChildrenToNewPage(int paramInt, List<HomeItem> paramList)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      HomeItem localHomeItem = (HomeItem)getChildAt(i).getTag();
      if ((localHomeItem instanceof HomeFolderItem))
      {
        View localView = getChildAt(localHomeItem);
        ((HomeFolderItem)localHomeItem).addListener((HomeFolderItem.FolderListener)localView);
      }
      localHomeItem.mScreen = paramInt;
      paramList.add(localHomeItem);
      i += 1;
    }
  }
  
  public static abstract interface BaseItemIterator<Closure>
  {
    public abstract boolean iterate(BaseItem paramBaseItem, Closure paramClosure);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutChildren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */