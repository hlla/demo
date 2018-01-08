package com.android.launcher2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CellLayoutNoGap
  extends CellLayout
{
  static final int REORDER_ANIMATION_DURATION = 230;
  protected boolean isFolderPage = false;
  private boolean mCloseLayoutGapPosted = false;
  protected boolean mDisabled = false;
  Bitmap mDragOutline;
  Folder mFolder;
  private boolean mForceReorder = false;
  protected BaseItem mHiddenItem;
  private int mPreviousTargetCell = -1;
  private boolean mReOrderingEnabled = true;
  private Alarm mReorderAlarm = new Alarm();
  Alarm.OnAlarmListener mReorderAlarmListener = new Alarm.OnAlarmListener()
  {
    public void onAlarm(Alarm paramAnonymousAlarm)
    {
      CellLayoutNoGap.this.realTimeReorder();
    }
  };
  protected boolean mReorderImmediately = false;
  int mTargetCell = -1;
  
  public CellLayoutNoGap(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CellLayoutNoGap(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayoutNoGap(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void forceRealTimeReorder()
  {
    this.mForceReorder = true;
    realTimeReorder();
    this.mForceReorder = false;
  }
  
  private void updateItemToNewPosition(BaseItem paramBaseItem, int paramInt)
  {
    setItemLocation(paramBaseItem, paramInt, paramBaseItem.mScreen);
    paramBaseItem = getChildrenLayout().getChildAt(paramBaseItem);
    boolean bool;
    PagedView localPagedView;
    if (paramBaseItem != null)
    {
      bool = false;
      if ((getParent() instanceof PagedView))
      {
        localPagedView = (PagedView)getParent();
        bool = localPagedView.isPageMoving();
        if (paramBaseItem.getVisibility() == 0) {
          break label85;
        }
        bool = true;
      }
    }
    while ((this.mFolder != null) && (!this.mFolder.getInfo().isOpened()))
    {
      return;
      label85:
      if (getScreen() != localPagedView.getCurrentPage()) {
        bool = true;
      }
    }
    int i = getCellXFromPos(paramInt);
    paramInt = getCellYFromPos(paramInt);
    if ((paramBaseItem instanceof FolderIconView)) {
      ((FolderIconView)paramBaseItem).cancelFolderAnims();
    }
    animateChildToPosition(paramBaseItem, i, paramInt, 230, 0, bool);
  }
  
  public boolean addItem(BaseItem paramBaseItem)
  {
    if (super.addItem(paramBaseItem))
    {
      if ((this.mFolder != null) && (!this.mFolder.getInfo().contains(paramBaseItem))) {
        this.mFolder.getInfo().addItemAt(paramBaseItem, paramBaseItem.mScreen);
      }
      return true;
    }
    return false;
  }
  
  void cancelAllFolderAnimations()
  {
    CellLayoutChildren localCellLayoutChildren = getChildrenLayout();
    int i = 0;
    while (i < localCellLayoutChildren.getChildCount())
    {
      View localView = localCellLayoutChildren.getChildAt(i);
      if ((localView instanceof FolderIconView)) {
        ((FolderIconView)localView).cancelFolderAnims();
      }
      i += 1;
    }
  }
  
  void cancelRealTimeReorder()
  {
    this.mReorderAlarm.cancelAlarm();
  }
  
  int cellToPosition(int paramInt1, int paramInt2)
  {
    return getCountX() * paramInt2 + paramInt1;
  }
  
  protected void closeLayoutGap()
  {
    if (hasAnimatingChild()) {
      if (!this.mCloseLayoutGapPosted) {}
    }
    int m;
    label74:
    do
    {
      do
      {
        return;
        this.mCloseLayoutGapPosted = true;
        postDelayed(new Runnable()
        {
          public void run()
          {
            CellLayoutNoGap.access$002(CellLayoutNoGap.this, false);
            CellLayoutNoGap.this.closeLayoutGap();
          }
        }, 20L);
        return;
      } while (getPageItemCount() == 0);
      BaseItem localBaseItem = this.mHiddenItem;
      this.mHiddenItem = null;
      if (existsEmptyCell())
      {
        m = findFirstEmptySpace();
        if (m != -1) {
          break;
        }
      }
      this.mHiddenItem = localBaseItem;
    } while (this.mHiddenItem == null);
    this.mTargetCell = (getPageItemCount() - 1);
    realTimeReorder();
    return;
    Object localObject = findAllOccupiedCells();
    int k = -1;
    int i = m + 1;
    for (;;)
    {
      int j = k;
      if (i < localObject.length)
      {
        if (localObject[i] != 0) {
          j = i;
        }
      }
      else
      {
        if ((j == m) || (j == -1)) {
          break label74;
        }
        localObject = getChildrenLayout().getItemAt(j);
        if (localObject == null) {
          break label74;
        }
        updateItemToNewPosition((BaseItem)localObject, m);
        break;
      }
      i += 1;
    }
  }
  
  boolean existsEmptyCell()
  {
    int j = getPageItemCount();
    int i = j;
    if (this.mHiddenItem != null) {
      i = j - 1;
    }
    return i < getCountX() * getCountY();
  }
  
  boolean existsEmptyCellIgnoreHidden()
  {
    return getPageItemCount() < getCountX() * getCountY();
  }
  
  boolean[] findAllOccupiedCells()
  {
    int i = getCountX() * getCountY();
    boolean[] arrayOfBoolean = new boolean[i];
    Iterator localIterator = getChildrenLayout().mItems.iterator();
    while (localIterator.hasNext())
    {
      int j = ((BaseItem)localIterator.next()).getPosition();
      if ((j >= 0) && (j < i)) {
        arrayOfBoolean[j] = true;
      }
    }
    return arrayOfBoolean;
  }
  
  public void findDropLocation(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (DragState)paramObject;
      switch (paramInt3)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramObject = Launcher.dragstate;
        break;
      } while (!getChildrenLayout().hasItem(((DragState)paramObject).getItem()));
      localObject = new int[2];
      paramInt1 = ((DragState)paramObject).getItem().getPosition();
      cellToPoint(getCellXFromPos(paramInt1), getCellYFromPos(paramInt1), (int[])localObject);
      try
      {
        arrayOfInt = ((DragState)paramObject).getShadow().getTouchOffset();
        paramInt1 = localObject[0] + arrayOfInt[0] + getWidthGap();
        paramInt2 = localObject[1];
        int i = arrayOfInt[1];
        int j = getHeightGap();
        paramInt2 = paramInt2 + i + j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int[] arrayOfInt;
          paramInt1 = localObject[0] + getWidthGap();
          paramInt2 = localObject[1] + getHeightGap();
          continue;
          if (paramInt1 == 0) {}
          for (;;)
          {
            this.mTargetCell = paramInt1;
            break;
            paramInt1 -= 1;
          }
          localObject = ((Workspace)localObject).createDragOutline(((DragState)paramObject).getView(), new Canvas(), HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS);
        }
      }
      arrayOfInt = new int[2];
      pointToCellExact(paramInt1, paramInt2, arrayOfInt);
      this.mTargetCell = cellToPosition(arrayOfInt[0], arrayOfInt[1]);
      paramInt2 = getPageItemCount();
      paramInt1 = paramInt2;
      if (this.mHiddenItem == null) {
        paramInt1 = paramInt2 + 1;
      }
      if ((this.mTargetCell >= paramInt1) || (this.mTargetCell < 0))
      {
        if (this.mTargetCell >= 0) {
          break label358;
        }
        this.mTargetCell = 0;
        arrayOfInt[0] = getCellXFromPos(this.mTargetCell);
        arrayOfInt[1] = getCellYFromPos(this.mTargetCell);
      }
      if (this.mDragOutline == null)
      {
        localObject = ((Launcher)getContext()).mHomeView.getWorkspace();
        if (localObject != null) {
          break label377;
        }
        localObject = null;
        this.mDragOutline = ((Bitmap)localObject);
      }
    } while ((paramInt3 != 2) || (this.mDragOutline == null) || ((!(((DragState)paramObject).getItem() instanceof FolderItem)) && ((getChildAt(arrayOfInt[0], arrayOfInt[1]) instanceof FolderIconView))));
    visualizeDropLocation(((DragState)paramObject).getView(), this.mDragOutline, arrayOfInt, 1, 1);
  }
  
  public void findDropLocation(DragEvent paramDragEvent)
  {
    findDropLocation((int)paramDragEvent.getX(), (int)paramDragEvent.getY(), paramDragEvent.getAction(), paramDragEvent.getLocalState());
  }
  
  public int findFirstEmptySpace()
  {
    int j;
    if (this.mHiddenItem != null)
    {
      j = this.mHiddenItem.getPosition();
      return j;
    }
    boolean[] arrayOfBoolean = findAllOccupiedCells();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfBoolean.length) {
        break label45;
      }
      j = i;
      if (arrayOfBoolean[i] == 0) {
        break;
      }
      i += 1;
    }
    label45:
    return -1;
  }
  
  int getCellXFromPos(int paramInt)
  {
    return paramInt % getCountX();
  }
  
  int getCellYFromPos(int paramInt)
  {
    return (int)Math.floor(paramInt / getCountX());
  }
  
  public long getContainerType()
  {
    CellLayoutContainer localCellLayoutContainer = getContainer();
    if ((localCellLayoutContainer instanceof Folder)) {
      return ((Folder)localCellLayoutContainer).getContainerType();
    }
    return -1L;
  }
  
  boolean hasAnimatingChild()
  {
    int j = getPageItemCount();
    int i = 0;
    if (i < j + 1)
    {
      View localView = this.mChildren.getChildAt(i);
      if ((localView == null) || (localView.getTag() == null) || (localView.getTag() == this.mHiddenItem)) {}
      do
      {
        do
        {
          i += 1;
          break;
        } while (!(localView instanceof FolderIconView));
        if (((FolderIconView)localView).isOpened()) {
          return true;
        }
      } while (!((FolderIconView)localView).isAnimating());
      return true;
    }
    return false;
  }
  
  public void hide(BaseItem paramBaseItem)
  {
    super.hide(paramBaseItem);
    if (this.mDisabled) {
      return;
    }
    this.mHiddenItem = paramBaseItem;
  }
  
  boolean isDraggingOverIcon()
  {
    return false;
  }
  
  public boolean isReOrderingEnabled()
  {
    return this.mReOrderingEnabled;
  }
  
  CellPositioner newCellPositioner()
  {
    return new CellPositionerNoGap(this);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (Launcher.isHelpAppRunning) {
      return false;
    }
    if (this.mDisabled) {
      return super.onDragEvent(paramDragEvent);
    }
    if (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    if (paramDragEvent.getLocalState() != null) {}
    for (Object localObject = (DragState)paramDragEvent.getLocalState(); ((DragState)localObject).getItem().mIconMovie != null; localObject = Launcher.dragstate) {
      return false;
    }
    if ((paramDragEvent.getAction() == 5) && (((DragState)localObject).mDragOrigin != this) && ((((DragState)localObject).mDragOrigin instanceof CellLayout)))
    {
      CellLayout localCellLayout = (CellLayout)((DragState)localObject).mDragOrigin;
      if (localCellLayout.getIsDragOverlapping()) {
        localCellLayout.onDragExit();
      }
    }
    if (isReOrderingEnabled()) {
      findDropLocation(paramDragEvent);
    }
    switch (paramDragEvent.getAction())
    {
    default: 
      return false;
    case 1: 
      if (((DragState)localObject).mDragOrigin == this)
      {
        setIsDragOverlapping(true);
        onDragEnter();
      }
      return true;
    case 6: 
      this.mReorderAlarm.cancelAlarm();
      if (((Launcher)getContext()).getMenuView().getViewType() != MenuView.ViewType.ALPHABETIC_GRID) {
        closeLayoutGap();
      }
      clearDragOutlines();
      return true;
    case 5: 
      this.mPreviousTargetCell = -1;
      paramDragEvent = ((DragState)localObject).getFolderParent();
      if ((paramDragEvent != null) && (paramDragEvent != this.mFolder)) {
        paramDragEvent.parentLayoutEntered();
      }
      return true;
    case 2: 
      if (!isReOrderingEnabled()) {
        return true;
      }
      if (this.mTargetCell != this.mPreviousTargetCell)
      {
        this.mReorderAlarm.cancelAlarm();
        if (this.mReorderImmediately)
        {
          realTimeReorder();
          paramDragEvent = getChildrenLayout().getChildFromPosition(this.mTargetCell);
          localObject = ((DragState)localObject).getFolderParent();
          if ((localObject == null) || (((Folder)localObject).mContent == this) || (!((Folder)localObject).getInfo().isOpened())) {
            break label387;
          }
          this.mReorderAlarm.setAlarm(((Folder)localObject).mExpandDuration + 800 + 100);
          this.mPreviousTargetCell = this.mTargetCell;
        }
      }
      for (;;)
      {
        return true;
        this.mReorderAlarm.setOnAlarmListener(this.mReorderAlarmListener);
        break;
        if (((getParent() instanceof PagedView)) && (((PagedView)getParent()).isPageMoving()))
        {
          this.mReorderAlarm.setAlarm(((PagedView)getParent()).PAGE_SNAP_ANIMATION_DURATION - ((PagedView)getParent()).mScroller.timePassed() + 200);
          break label363;
        }
        if ((paramDragEvent instanceof FolderIconView))
        {
          this.mReorderAlarm.setAlarm(500L);
          break label363;
        }
        this.mReorderAlarm.setAlarm(250L);
        break label363;
        if (!this.mReorderAlarm.alarmPending()) {
          this.mReorderAlarm.setAlarm(250L);
        }
      }
    case 3: 
      label363:
      label387:
      cancelAllFolderAnimations();
      this.mReorderAlarm.cancelAlarm();
      if (!isReOrderingEnabled())
      {
        Toast.makeText(getContext(), getContext().getString(2131755132), 0).show();
        onDragExit();
        return false;
      }
      if (this.mTargetCell == -1) {
        return true;
      }
      forceRealTimeReorder();
      int i = getCellXFromPos(this.mTargetCell);
      int j = getCellYFromPos(this.mTargetCell);
      int k = getScreen();
      paramDragEvent = ((DragState)localObject).getItem();
      if (((DragState)localObject).moveItemTo(this, i, j, paramDragEvent.getSpanX(), paramDragEvent.getSpanY(), k))
      {
        ((DragState)localObject).onDrop();
        return true;
      }
      return false;
    }
    ((DragState)localObject).onEnd();
    if (Launcher.dragstate != null) {
      Launcher.dragstate.onEnd();
    }
    this.mReorderAlarm.cancelAlarm();
    this.mHiddenItem = null;
    if (!isReOrderingEnabled()) {
      return false;
    }
    if ((((DragState)localObject).mRevertDrag) && (this == ((DragState)localObject).mDragOrigin))
    {
      hide(((DragState)localObject).mItem);
      realTimeReorder(((DragState)localObject).mOriginalCell);
      show(this.mHiddenItem);
    }
    for (;;)
    {
      this.mTargetCell = -1;
      this.mDragOutline = null;
      clearDragOutlines();
      onDragExit();
      return true;
      closeLayoutGap();
    }
  }
  
  public void onFailedDrop(BaseItem paramBaseItem)
  {
    this.mReorderAlarm.cancelAlarm();
    if (this.mFolder != null) {
      this.mFolder.mOnExitAlarm.cancelAlarm();
    }
  }
  
  public void onFolderIconViewDragEvent(DragEvent paramDragEvent, FolderIconView paramFolderIconView)
  {
    int i = (int)paramDragEvent.getX();
    int j = (int)paramDragEvent.getY();
    Rect localRect = new Rect();
    localRect.set(i, j, i, j);
    i = paramFolderIconView.getScrollX();
    j = paramFolderIconView.getScrollY();
    paramFolderIconView.scrollTo(0, 0);
    offsetDescendantRectToMyCoords(paramFolderIconView, localRect);
    paramFolderIconView.scrollTo(i, j);
    if (isReOrderingEnabled()) {
      findDropLocation(localRect.left, localRect.top, paramDragEvent.getAction(), paramDragEvent.getLocalState());
    }
    this.mReorderAlarm.cancelAlarm();
    this.mReorderAlarm.setOnAlarmListener(this.mReorderAlarmListener);
  }
  
  public void onViewAddedToLayout(View paramView)
  {
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
    if (!isReOrderingEnabled()) {
      setCellFromPosition(localLayoutParams, getChildrenLayout().getChildCount() - 1);
    }
    for (;;)
    {
      super.onViewAddedToLayout(paramView);
      return;
      if ((localLayoutParams.cellX == -1) || (localLayoutParams.cellY == -1))
      {
        int j = ((BaseItem)paramView.getTag()).getPosition();
        int i = j;
        if (j < 0)
        {
          i = findFirstEmptySpace();
          ((BaseItem)paramView.getTag()).setPosition(i);
        }
        setCellFromPosition(localLayoutParams, i);
      }
      else
      {
        setCellFromPosition(localLayoutParams, ((BaseItem)paramView.getTag()).getPosition());
      }
    }
  }
  
  void realTimeReorder()
  {
    if ((!this.mForceReorder) && (hasAnimatingChild())) {
      if (!this.mReorderAlarm.alarmPending()) {
        this.mReorderAlarm.setAlarm(20L);
      }
    }
    int k;
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return;
          i = findFirstEmptySpace();
          j = getCountX() * getCountY() - 1;
        } while (j == 0);
        k = Math.min(this.mTargetCell, j);
        this.mTargetCell = k;
      } while ((k == i) || (getChildrenLayout().getItemAt(k) == null));
      if (i == -1) {
        throw new IllegalArgumentException("Couldn't find empty cell. This should never happen! Cell Occupancy: " + Arrays.toString(findAllOccupiedCells()) + " item count = " + this.mChildren.mItems.size());
      }
      if (k == -1) {
        throw new IllegalArgumentException("Couldn't find target cell. This should never happen!");
      }
      BaseItem localBaseItem;
      for (;;)
      {
        j = i;
        if (k >= i) {
          break;
        }
        localBaseItem = getChildrenLayout().getItemAt(i - 1);
        if (localBaseItem == null) {
          throw new IllegalArgumentException("item in < was null");
        }
        updateItemToNewPosition(localBaseItem, i);
        i -= 1;
      }
      do
      {
        updateItemToNewPosition(localBaseItem, j);
        j += 1;
        if (k <= j) {
          break;
        }
        localBaseItem = getChildrenLayout().getItemAt(j + 1);
      } while (localBaseItem != null);
      throw new IllegalArgumentException("item in > was null");
    } while (this.mHiddenItem == null);
    this.mHiddenItem.setPosition(k);
  }
  
  public void realTimeReorder(int paramInt)
  {
    this.mTargetCell = paramInt;
    realTimeReorder();
  }
  
  public boolean removeItem(BaseItem paramBaseItem)
  {
    boolean bool1 = false;
    if ((this.mFolder == null) || (this.mFolder.mCurrentDragInfo != null))
    {
      boolean bool2 = super.removeItem(paramBaseItem);
      bool1 = bool2;
      if (bool2)
      {
        if (this.mFolder != null) {
          this.mFolder.getInfo().removeItem(paramBaseItem);
        }
        if (this.mHiddenItem == paramBaseItem) {
          this.mHiddenItem = null;
        }
        closeLayoutGap();
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  final void setCellFromPosition(CellLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    paramLayoutParams.cellX = getCellXFromPos(paramInt);
    paramLayoutParams.cellY = getCellYFromPos(paramInt);
  }
  
  public void setEnableReOrdering(boolean paramBoolean)
  {
    this.mReOrderingEnabled = paramBoolean;
  }
  
  protected void setItemLocation(BaseItem paramBaseItem, int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      throw new IllegalArgumentException("Invalid position");
    }
    paramBaseItem.mScreen = paramInt2;
    paramBaseItem.setPosition(paramInt1);
    if ((paramBaseItem instanceof HomeItem))
    {
      paramBaseItem = (HomeItem)paramBaseItem;
      LauncherModel.addOrMoveItemInDatabase(getContext(), paramBaseItem, paramBaseItem.container, paramInt1, paramBaseItem.cellX, paramBaseItem.cellY, paramBaseItem.spanX, paramBaseItem.spanY);
    }
  }
  
  public void setItemLocation(BaseItem paramBaseItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    paramBaseItem.mScreen = paramInt5;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      paramBaseItem.setPosition(cellToPosition(paramInt1, paramInt2));
    }
    if (paramBaseItem.getPosition() == -1) {
      throw new IllegalArgumentException("Invalid position");
    }
    if ((paramBaseItem instanceof HomeItem))
    {
      paramInt5 = paramBaseItem.getPosition();
      LauncherModel.addOrMoveItemInDatabase(getContext(), (HomeItem)paramBaseItem, paramLong, paramInt5, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show(BaseItem paramBaseItem)
  {
    super.show(paramBaseItem);
    if (this.mDisabled) {
      return;
    }
    this.mReorderAlarm.cancelAlarm();
    this.mHiddenItem = null;
  }
  
  void updateCustomViewToCellLayout()
  {
    CellLayoutChildren localCellLayoutChildren = getChildrenLayout();
    int j = localCellLayoutChildren.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = localCellLayoutChildren.getChildAt(i);
      if (localView.getTag() == null) {}
      for (;;)
      {
        i += 1;
        break;
        CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)localView.getLayoutParams();
        setCellFromPosition(localLayoutParams, ((BaseItem)localView.getTag()).getPosition());
        localView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  protected void updateViewToCellLayout(int paramInt)
  {
    int i = getCountX();
    if ((paramInt > 0) && (paramInt != i))
    {
      CellLayoutChildren localCellLayoutChildren = getChildrenLayout();
      i = 0;
      while (i < localCellLayoutChildren.getChildCount())
      {
        View localView = localCellLayoutChildren.getChildAt(i);
        CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)localView.getLayoutParams();
        setCellFromPosition(localLayoutParams, localLayoutParams.cellY * paramInt + localLayoutParams.cellX);
        localView.setLayoutParams(localLayoutParams);
        i += 1;
      }
    }
  }
  
  protected void updateViewsToTheirItemPositions()
  {
    int i = 0;
    if (i < getPageItemCount())
    {
      Object localObject = this.mChildren.getChildAt(i);
      if ((localObject == null) || (((View)localObject).getTag() == null)) {}
      for (;;)
      {
        i += 1;
        break;
        BaseItem localBaseItem = (BaseItem)((View)localObject).getTag();
        localObject = (CellLayout.LayoutParams)((View)localObject).getLayoutParams();
        int j = getCellXFromPos(localBaseItem.getPosition());
        int k = getCellYFromPos(localBaseItem.getPosition());
        if ((((CellLayout.LayoutParams)localObject).cellX != j) || (((CellLayout.LayoutParams)localObject).cellY != k)) {
          updateItemToNewPosition(localBaseItem, localBaseItem.getPosition());
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutNoGap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */