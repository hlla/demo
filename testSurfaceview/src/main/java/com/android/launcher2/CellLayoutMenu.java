package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;
import com.samsung.android.feature.FloatingFeature;
import java.util.List;

public class CellLayoutMenu
  extends CellLayoutNoGap
{
  private static final String TAG = "CellLayoutMenu";
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  private int mNumItemsPushedIn = 0;
  
  public CellLayoutMenu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CellLayoutMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayoutMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fillFromPageRightSnake()
  {
    CellLayoutMenu localCellLayoutMenu;
    if (existsEmptyCell())
    {
      int i = ((ViewGroup)getParent()).indexOfChild(this);
      localCellLayoutMenu = (CellLayoutMenu)((MenuAppsGrid)getParent()).getChildAt(i + 1);
      if (localCellLayoutMenu != null)
      {
        BaseItem localBaseItem = localCellLayoutMenu.getChildrenLayout().getItemAt(0);
        if (localBaseItem != null)
        {
          localCellLayoutMenu.removeItem(localBaseItem);
          setItemLocation(localBaseItem, getPageItemCount(), getScreen());
          addItem(localBaseItem);
        }
        if (localCellLayoutMenu.getPageItemCount() != 0) {
          break label107;
        }
        ((ViewGroup)getParent()).removeView(localCellLayoutMenu);
        ((View)getParent()).invalidate();
      }
    }
    return;
    label107:
    localCellLayoutMenu.invalidate();
  }
  
  private MenuAppsGrid.State getState()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof MenuAppsGrid)) {
      return ((MenuAppsGrid)localViewParent).getState();
    }
    return null;
  }
  
  private void pushItemsToNextPage()
  {
    int j = findFirstEmptySpace();
    int i = j;
    if (j == -1) {
      i = getCountX() * getCountY();
    }
    for (;;)
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      AppItem localAppItem = (AppItem)getChildrenLayout().getItemAt(j);
      if (localAppItem == null) {
        throw new IllegalArgumentException("item in < was null");
      }
      removeItem(localAppItem);
      setItemLocation(localAppItem, localAppItem.mCell, localAppItem.mScreen + 1);
      CellLayoutMenu localCellLayoutMenu = ((MenuAppsGrid)getParent()).getOrCreatePageAt(localAppItem.mScreen);
      i = j;
      if (localCellLayoutMenu != null)
      {
        localCellLayoutMenu.addItem(localAppItem);
        i = j;
      }
    }
  }
  
  private void showViewTypeRearrangeDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext());
    localBuilder.setTitle(2131755248);
    localBuilder.setMessage(2131755249).setCancelable(false).setPositiveButton(2131755017, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MenuViewTypeDialog.createAndShow(MenuView.ViewType.valueOf(CellLayoutMenu.this.getContext().getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("MenuView.ViewType", MenuView.ViewType.CUSTOM_GRID.name())), ((Activity)CellLayoutMenu.this.getContext()).getFragmentManager());
      }
    }).setNegativeButton(2131755018, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  boolean CLIP_BY_DEFAULT()
  {
    return false;
  }
  
  public long getContainerType()
  {
    return -102L;
  }
  
  public void handleStateChange(MenuAppsGrid.State paramState1, MenuAppsGrid.State paramState2)
  {
    this.mNumItemsPushedIn = 0;
  }
  
  public void hide(BaseItem paramBaseItem)
  {
    if ((getState() == null) || (getState() != MenuAppsGrid.State.EDIT)) {
      return;
    }
    super.hide(paramBaseItem);
  }
  
  public boolean isReOrderingEnabled()
  {
    MenuView localMenuView = ((Launcher)getContext()).getMenuView();
    if (localMenuView.getViewType() == MenuView.ViewType.CUSTOM_GRID) {}
    for (int i = 1;; i = 0)
    {
      boolean bool2 = false;
      boolean bool1;
      if (localMenuView.getState() != MenuAppsGrid.State.NORMAL)
      {
        bool1 = bool2;
        if (localMenuView.getState() != MenuAppsGrid.State.EDIT) {}
      }
      else
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public boolean onDragEvent(final DragEvent paramDragEvent)
  {
    if ((getState() != MenuAppsGrid.State.EDIT) || (!(paramDragEvent.getLocalState() instanceof DragState))) {
      return false;
    }
    DragState localDragState = (DragState)paramDragEvent.getLocalState();
    int i;
    if (((Launcher)getContext()).getMenuView().getViewType() == MenuView.ViewType.CUSTOM_GRID)
    {
      i = 1;
      if (i != 0) {
        break label244;
      }
      switch (paramDragEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      if (localDragState.mDragOrigin != this)
      {
        paramDragEvent = localDragState.getItem();
        if ((paramDragEvent instanceof AppItem))
        {
          paramDragEvent = (AppItem)paramDragEvent;
          if (paramDragEvent.mFolder != null)
          {
            paramDragEvent.removeFromFolder();
            paramDragEvent.mScreen = -1;
            paramDragEvent.mCell = -1;
            final MenuView localMenuView = ((Launcher)getContext()).getMenuView();
            final ViewParent localViewParent = getParent();
            if (localMenuView == null) {
              continue;
            }
            localDragState.onDropSetEndRunnable(new Runnable()
            {
              public void run()
              {
                Log.d("CellLayoutMenu", "item removed from folder; appModelUpdated");
                MenuAppModel.INSTANCE.invalidateTopLevelItems();
                localMenuView.closeFolders();
                localMenuView.appModelUpdated();
                if ((localViewParent instanceof MenuAppsGrid))
                {
                  MenuAppsGrid localMenuAppsGrid = (MenuAppsGrid)localViewParent;
                  List localList = MenuAppModel.INSTANCE.getTopLevelItems();
                  if (localList != null) {
                    localMenuAppsGrid.setCurrentPage(localList.indexOf(paramDragEvent) / localMenuAppsGrid.getMaxItemsPerScreen());
                  }
                }
              }
            });
            continue;
          }
        }
      }
      Toast.makeText(getContext(), getContext().getString(2131755132), 0).show();
      continue;
      if (((Launcher)getContext()).getMenuView().getViewType() == MenuView.ViewType.ALPHABETIC_GRID) {
        ((MenuAppsGrid)getParent()).disableRollNavigation();
      }
      localDragState.onEnd();
    }
    label244:
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onDragEvent(paramDragEvent);
      undoSnake(true);
      continue;
      ((MenuAppsGrid)getParent()).disableRollNavigation();
      undoSnake(true);
      continue;
      MenuAppModel.INSTANCE.invalidateTopLevelItems();
      if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
        performHapticFeedback(25687, 1);
      }
      this.mNumItemsPushedIn = 0;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    setCrosshairsVisibility(getBackgroundAlpha());
    super.onDraw(paramCanvas);
  }
  
  public void onFolderIconViewDragEvent(DragEvent paramDragEvent, FolderIconView paramFolderIconView)
  {
    if ((getState() != MenuAppsGrid.State.EDIT) || (!(paramDragEvent.getLocalState() instanceof DragState))) {}
    for (;;)
    {
      return;
      if (((Launcher)getContext()).getMenuView().getViewType() == MenuView.ViewType.CUSTOM_GRID) {}
      for (int i = 1; i != 0; i = 0)
      {
        super.onFolderIconViewDragEvent(paramDragEvent, paramFolderIconView);
        return;
      }
    }
  }
  
  public void onViewAddedToLayout(View paramView)
  {
    if (!((MenuAppsGrid)getParent()).allowCustomOrdering())
    {
      CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
      int i = getChildrenLayout().getChildCount() - 1;
      localLayoutParams.cellX = (i % getCountX());
      localLayoutParams.cellY = (i / getCountX());
      if (getState() == MenuAppsGrid.State.EDIT) {
        ((BaseItem)paramView.getTag()).setPosition(i);
      }
    }
    super.onViewAddedToLayout(paramView);
  }
  
  void realTimeReorder()
  {
    if (!existsEmptyCell()) {
      snake(null);
    }
    super.realTimeReorder();
  }
  
  public boolean removeItem(BaseItem paramBaseItem)
  {
    boolean bool2 = false;
    MenuAppsGrid.State localState = getState();
    boolean bool1 = bool2;
    if (localState != null)
    {
      bool1 = bool2;
      if (localState == MenuAppsGrid.State.EDIT)
      {
        bool2 = super.removeItem(paramBaseItem);
        bool1 = bool2;
        if (bool2) {
          if (((Launcher)getContext()).getMenuView().getViewType() != MenuView.ViewType.ALPHABETIC_GRID) {
            break label110;
          }
        }
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0)
      {
        cancelAllFolderAnimations();
        closeLayoutGap();
        fillFromPageRightSnake();
        paramBaseItem = getParent();
        bool1 = bool2;
        if ((paramBaseItem instanceof MenuAppsGrid))
        {
          ((MenuAppsGrid)paramBaseItem).clampCurrentPage();
          bool1 = bool2;
        }
      }
      return bool1;
    }
  }
  
  void snake(AppItem paramAppItem)
  {
    Object localObject1;
    if (!existsEmptyCellIgnoreHidden())
    {
      Object localObject2 = (AppItem)getChildrenLayout().getItemAt(getCountX() * getCountY() - 1);
      localObject1 = localObject2;
      if (localObject2 == this.mHiddenItem) {
        localObject1 = (AppItem)getChildrenLayout().getItemAt(getCountX() * getCountY() - 2);
      }
      if (localObject1 != null)
      {
        localObject2 = getChildrenLayout().getChildAt((BaseItem)localObject1);
        if ((localObject2 instanceof FolderIconView)) {
          ((FolderIconView)localObject2).cancelFolderAnims();
        }
        removeItem((BaseItem)localObject1);
        int i = ((ViewGroup)getParent()).indexOfChild(this);
        localObject2 = ((MenuAppsGrid)getParent()).getOrCreatePageAt(i + 1);
        if (localObject2 != null) {
          ((CellLayoutMenu)localObject2).snake((AppItem)localObject1);
        }
      }
    }
    if (paramAppItem != null)
    {
      this.mNumItemsPushedIn += 1;
      this.mTargetCell = 0;
      localObject1 = this.mHiddenItem;
      this.mHiddenItem = null;
      realTimeReorder();
      this.mHiddenItem = ((BaseItem)localObject1);
      setItemLocation(paramAppItem, 0, getScreen());
      addItem(paramAppItem);
    }
  }
  
  AppItem undoSnake(boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((!paramBoolean) && (this.mNumItemsPushedIn == 0)) {}
    Object localObject1;
    int i;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return (AppItem)localObject2;
        } while ((paramBoolean) && (!existsEmptyCellIgnoreHidden()));
        localObject1 = null;
        if (!paramBoolean)
        {
          localObject1 = (AppItem)getChildrenLayout().getItemAt(0);
          localObject2 = localObject1;
          if (localObject1 == this.mHiddenItem) {
            localObject2 = (AppItem)getChildrenLayout().getItemAt(1);
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            removeItem((BaseItem)localObject2);
            closeLayoutGap();
            this.mNumItemsPushedIn -= 1;
            localObject1 = localObject2;
          }
        }
        i = ((ViewGroup)getParent()).indexOfChild(this);
        localObject3 = (CellLayoutMenu)((MenuAppsGrid)getParent()).getPageAt(i + 1);
        localObject2 = localObject1;
      } while (localObject3 == null);
      localObject3 = ((CellLayoutMenu)localObject3).undoSnake(false);
      localObject2 = localObject1;
    } while (localObject3 == null);
    cancelAllFolderAnimations();
    closeLayoutGap();
    setItemLocation((BaseItem)localObject3, getPageItemCount(), i);
    addItem((BaseItem)localObject3);
    return (AppItem)localObject1;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */