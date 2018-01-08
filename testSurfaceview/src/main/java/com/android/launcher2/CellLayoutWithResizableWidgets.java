package com.android.launcher2;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CellLayoutWithResizableWidgets
  extends CellLayout
  implements CellPositionerWorkspace.DeltaProvider, CellPositionerWorkspace.GridDimensionProvider
{
  private AppWidgetResizeFrame mFrame;
  
  public CellLayoutWithResizableWidgets(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CellLayoutWithResizableWidgets(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayoutWithResizableWidgets(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean canAcceptDrop(DragState paramDragState, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (getContainer() == null) {
      return false;
    }
    if ((this.mHomeView != null) && (this.mHomeView.isWorkspaceLocked()))
    {
      invalidatePageIndicatorPreview();
      return false;
    }
    Object localObject1 = paramDragState.getView();
    findDragCell(paramDragState, paramInt1, paramInt2, this.mDragCell, this.mTmpXY, true);
    paramInt2 = this.mTmpXY[0];
    int i = this.mTmpXY[1];
    if ((this.mDragCell[0] != -1) && (this.mDragCell[1] != -1)) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0) {
      return false;
    }
    Object localObject2 = paramDragState.getItem();
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (((CellLayout)this.mHomeView.getWorkspace().getChildAt(paramInt3)).getPageType() == 2)) {
      return false;
    }
    if ((localObject2 instanceof HomeItem))
    {
      localObject2 = (HomeItem)paramDragState.getItem();
      ((HomeItem)localObject2).spanX = paramInt2;
      ((HomeItem)localObject2).spanY = i;
    }
    if ((paramDragState.moveItemTo(this, this.mDragCell[0], this.mDragCell[1], paramInt2, i, paramInt3, paramBoolean)) && ((localObject1 instanceof LauncherAppWidgetHostView))) {
      this.mHomeView.getWorkspace().enterWidgetResizeMode((LauncherAppWidgetHostView)localObject1, this);
    }
    paramDragState.onDrop();
    if ((localObject1 instanceof LauncherAppWidgetHostView))
    {
      paramDragState = (CellLayout.LayoutParams)((View)localObject1).getLayoutParams();
      localObject2 = (LauncherAppWidgetHostView)localObject1;
      localObject1 = (HomeWidgetItem)((View)localObject1).getTag();
      this.mHomeView.getWorkspace().sendWidgetResizeIntent(paramDragState.cellHSpan, paramDragState.cellVSpan, ((LauncherAppWidgetHostView)localObject2).getAppWidgetInfo().provider, ((HomeWidgetItem)localObject1).appWidgetId);
    }
    return true;
  }
  
  public void clearResizeFrame()
  {
    realRemoveView(this.mFrame);
    this.mFrame = null;
    ((Launcher)getContext()).mHomeView.setCurrentResizeWidgetItem(null);
  }
  
  public boolean findDragCell(DragState paramDragState, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool = super.findDragCell(paramDragState, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    invalidatePageIndicatorPreview();
    return bool;
  }
  
  public boolean findDragCell(DragState paramDragState, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    paramBoolean = super.findDragCell(paramDragState, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramBoolean);
    invalidatePageIndicatorPreview();
    return paramBoolean;
  }
  
  public void getDeltas(List<PositionDelta> paramList)
  {
    Iterator localIterator = this.mChildren.mItems.iterator();
    while (localIterator.hasNext()) {
      paramList.add(new PositionDelta((BaseItem)localIterator.next()));
    }
  }
  
  public int getNumColumns()
  {
    return getCountX();
  }
  
  public int getNumRows()
  {
    return getCountY();
  }
  
  public AppWidgetResizeFrame getResizeFrame()
  {
    return this.mFrame;
  }
  
  protected void invalidatePageIndicatorPreview()
  {
    PageIndicatorPreviewManager localPageIndicatorPreviewManager = this.mHomeView.getWorkspace().mPagePreviewManager;
    if (localPageIndicatorPreviewManager != null) {
      localPageIndicatorPreviewManager.mPagedView.invalidate();
    }
  }
  
  public boolean isPointInRegion(float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect();
    if (this.mFrame != null)
    {
      this.mFrame.getHitRect(localRect);
      if (localRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return true;
      }
    }
    getHitRect(localRect);
    return localRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  CellPositioner newCellPositioner()
  {
    return new CellPositionerWorkspace(this, this, this);
  }
  
  public void noRoomForDrop(DragState paramDragState, int paramInt1, int paramInt2, int paramInt3)
  {
    Workspace localWorkspace = (Workspace)getParent();
    int k;
    int i;
    label34:
    int i4;
    int i3;
    int j;
    int n;
    int i2;
    if (localWorkspace.getCreatedPageForDrag() != null)
    {
      k = 1;
      if (k == 0) {
        break label168;
      }
      i = localWorkspace.getChildCount() - 1;
      i4 = Integer.MIN_VALUE;
      i3 = 1;
      j = 0;
      n = paramInt1 + 1;
      i2 = k;
    }
    for (;;)
    {
      int m = n;
      int i1 = i3;
      if (i3 != 0)
      {
        m = n;
        i1 = i3;
        if (n >= i)
        {
          i1 = 0;
          m = 0;
        }
      }
      n = m;
      i3 = i2;
      k = j;
      if (i1 == 0)
      {
        n = m;
        i3 = i2;
        k = j;
        if (m >= paramInt1) {
          if (i2 == 0) {
            paramInt1 = i4;
          }
        }
      }
      for (;;)
      {
        if (Integer.MIN_VALUE == paramInt1) {
          break label268;
        }
        HomeView.showOutOfSpaceMessage(getContext());
        if (j == 0) {
          localWorkspace.removeCreatedPageForDrag();
        }
        localWorkspace.snapToPage(paramInt1);
        return;
        k = 0;
        break;
        label168:
        i = localWorkspace.getChildCount();
        break label34;
        n = i;
        i3 = 0;
        k = 1;
        Object localObject = localWorkspace.getChildAt(n);
        if ((localObject == null) || (!(localObject instanceof CellLayoutWithResizableWidgets))) {
          break label247;
        }
        localObject = (CellLayoutWithResizableWidgets)localObject;
        if (!((CellLayoutWithResizableWidgets)localObject).canAcceptDrop(paramDragState, paramInt2, paramInt3, n, false)) {
          break label247;
        }
        ((CellLayoutWithResizableWidgets)localObject).commitDeltas();
        paramInt1 = n;
        j = k;
      }
      label247:
      n += 1;
      i2 = i3;
      i3 = i1;
      j = k;
    }
    label268:
    HomeView.showNoRoomAnyPageMessage(getContext());
  }
  
  void notifyWidgetsOfPageScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < getChildCount())
    {
      if ((getChildAt(i) instanceof CellLayoutChildren)) {
        ((CellLayoutChildren)getChildAt(i)).notifyWidgetsOfPageScroll(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      i += 1;
    }
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (paramDragEvent.getAction() == 6) {
      onDragExit();
    }
    return super.onDragEvent(paramDragEvent);
  }
  
  public void onDragExit()
  {
    super.onDragExit();
    invalidatePageIndicatorPreview();
  }
  
  public void onPreDeltaVisualize(View paramView, BaseItem paramBaseItem)
  {
    if ((paramView instanceof FolderIconView)) {
      ((FolderIconView)paramView).cancelFolderAnims();
    }
    super.onPreDeltaVisualize(paramView, paramBaseItem);
  }
  
  boolean rearrangeWorkspaceForSpace(BaseItem paramBaseItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramBaseItem instanceof HomeItem))
    {
      paramBaseItem = new PositionDelta(paramBaseItem);
      paramBaseItem.setX(paramInt1);
      paramBaseItem.setY(paramInt2);
      paramBaseItem.setSpanX(paramInt3);
      paramBaseItem.setSpanY(paramInt4);
      if (this.mPositioner.updateDeltasForDrag(paramBaseItem, null, paramInt3, paramInt4, true, false, false))
      {
        this.mVisualizer.updateForDeltas(this.mPositioner.getDeltas());
        invalidatePageIndicatorPreview();
        return true;
      }
      this.mPositioner.resetDragDelta();
    }
    return false;
  }
  
  public void setResizeFrame(View paramView, final Runnable paramRunnable, Workspace.State paramState)
  {
    if ((this.mFrame != null) || (paramState != Workspace.State.RESIZE)) {
      return;
    }
    paramState = (HomeItem)paramView.getTag();
    this.mFrame = new AppWidgetResizeFrame(getContext(), paramState, paramView, this);
    if (paramRunnable != null) {
      this.mFrame.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public void onViewDetachedFromWindow(View paramAnonymousView)
        {
          paramRunnable.run();
        }
      });
    }
    addView(this.mFrame);
    this.mFrame.snapToWidget(false);
    setClipChildren(false);
    setClipToPadding(false);
    paramView = getParent();
    if ((paramView instanceof ViewGroup))
    {
      ((ViewGroup)paramView).setClipChildren(false);
      ((ViewGroup)paramView).setClipToPadding(false);
    }
    ((Launcher)getContext()).mHomeView.setCurrentResizeWidgetItem(paramState);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutWithResizableWidgets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */