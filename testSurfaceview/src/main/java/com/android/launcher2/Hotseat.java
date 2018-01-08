package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hotseat
  extends FrameLayout
  implements Animator.AnimatorListener, Workspace.StateAnimatorProvider, CellLayoutContainer
{
  private static final Comparator<HomeItem> HOTSEAT_COMPARATOR = new Comparator()
  {
    public final int compare(HomeItem paramAnonymousHomeItem1, HomeItem paramAnonymousHomeItem2)
    {
      if (paramAnonymousHomeItem1.mScreen == paramAnonymousHomeItem2.mScreen) {
        return 0;
      }
      if (paramAnonymousHomeItem1.mScreen == -1) {
        return 1;
      }
      if (paramAnonymousHomeItem2.mScreen == -1) {
        return -1;
      }
      if (paramAnonymousHomeItem1.mScreen < paramAnonymousHomeItem2.mScreen) {
        return -1;
      }
      return 1;
    }
  };
  private static final String TAG = "Hotseat";
  private boolean isFromDND = false;
  private boolean isSecretItem = false;
  private boolean isWidgetItem = false;
  private boolean itemFromMenu = false;
  private View mBackground;
  CellLayoutHotseat mContent;
  private boolean mDragInContentArea = false;
  private boolean mEntered = false;
  private HomeView mHomeView;
  private boolean mIsLandscape;
  private final ItemViewBuilder mItemViewBuilder = new ItemViewBuilder()
  {
    public View buildView(BaseItem paramAnonymousBaseItem, CellLayout paramAnonymousCellLayout)
    {
      switch (Hotseat.3.$SwitchMap$com$android$launcher2$BaseItem$Type[paramAnonymousBaseItem.mType.ordinal()])
      {
      default: 
        throw new IllegalStateException("Don't know how to convert item into view for Hotseat: " + paramAnonymousBaseItem.mType);
      case 1: 
      case 2: 
        return Hotseat.this.mHomeView.createShortcut((HomeShortcutItem)paramAnonymousBaseItem, 2130903087, paramAnonymousCellLayout);
      }
      return Hotseat.this.mHomeView.createFolder((HomeFolderItem)paramAnonymousBaseItem, 2130903086, paramAnonymousCellLayout);
    }
    
    public void onViewAdded(View paramAnonymousView, BaseItem paramAnonymousBaseItem, CellLayout paramAnonymousCellLayout)
    {
      if ((paramAnonymousView instanceof AllappsIcon)) {}
      do
      {
        return;
        paramAnonymousBaseItem = (HomeItem)paramAnonymousBaseItem;
        if ((!Hotseat.access$000(Hotseat.this).getHotseat().mShowHotseatTitle) && ((paramAnonymousView instanceof AppIconView))) {
          ((AppIconView)paramAnonymousView).setTextVisible(false);
        }
        paramAnonymousView.setOnKeyListener(FocusHelper.HOTSEAT_ICON_KEY_LISTENER);
        paramAnonymousView.setLayoutParams(new CellLayout.LayoutParams(paramAnonymousBaseItem.cellX, paramAnonymousBaseItem.cellY, paramAnonymousBaseItem.spanX, paramAnonymousBaseItem.spanY));
      } while ((paramAnonymousView instanceof Folder));
      paramAnonymousView.setHapticFeedbackEnabled(false);
      paramAnonymousView.setOnLongClickListener(Hotseat.this.mHomeView.getWorkspace().mLongClickListener);
    }
  };
  private int mMaxCellCount;
  private boolean mShowHotseatTitle;
  private Workspace mWorkspace;
  private int[] tmp = new int[2];
  
  public Hotseat(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public Hotseat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Hotseat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void normalizeContents(Context paramContext, List<HomeItem> paramList)
  {
    Collections.sort(paramList, HOTSEAT_COMPARATOR);
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      HomeItem localHomeItem = (HomeItem)paramList.get(i);
      if (localHomeItem.mScreen != i)
      {
        localHomeItem.mScreen = i;
        localArrayList.add(localHomeItem);
      }
      i -= 1;
    }
    if (!localArrayList.isEmpty()) {
      LauncherModel.moveItemsInDatabase(paramContext, localArrayList);
    }
  }
  
  public boolean addItem(HomeItem paramHomeItem)
  {
    return this.mContent.addItem(paramHomeItem);
  }
  
  boolean checkHotSeatInteraction(DragState paramDragState, int paramInt, View paramView)
  {
    boolean bool2 = true;
    View localView = paramDragState.getView();
    BaseItem localBaseItem = paramDragState.getItem();
    boolean bool3 = BaseItem.isWidget(localBaseItem);
    int i;
    if ((localBaseItem.mType == BaseItem.Type.MENU_APP) || (localBaseItem.mType == BaseItem.Type.MENU_FOLDER) || (localBaseItem.mIconMovie != null))
    {
      i = 1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      label92:
      boolean bool1 = false;
      label125:
      label147:
      label174:
      label226:
      label233:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                i = 0;
                break;
                if (!this.mContent.isFull()) {
                  break label125;
                }
                bool1 = bool2;
              } while ((paramView instanceof AllappsIcon));
              if ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!Launcher.CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE)) {
                break label147;
              }
              bool1 = bool2;
            } while (!Launcher.isHomeEditMode());
            if ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (Launcher.CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE) || (i != 0)) {
              break label174;
            }
            bool1 = bool2;
          } while (!Launcher.isHomeEditMode());
          if ((bool3) || (i != 0) || (paramView == localView) || (paramView == null) || (!this.mContent.isFull())) {
            break label233;
          }
          if (!(paramView instanceof FolderIconView)) {
            break label226;
          }
          bool1 = bool2;
        } while ((DragState.findOrigin(localView) instanceof CellLayoutNoGap));
        paramDragState.initiateSwap(paramView);
        return true;
        if (!bool3) {
          break label92;
        }
        return true;
        if (!this.mEntered) {
          break label92;
        }
        bool1 = bool2;
      } while (bool3);
      if ((paramView != null) && (paramView != localView))
      {
        return true;
        this.mEntered = true;
        continue;
        if (this.mEntered)
        {
          this.mEntered = false;
          paramDragState.cleanupSwap();
          continue;
          if ((paramView != null) && ((paramView instanceof FolderIconView))) {
            ((FolderIconView)paramView).redrawFolderIcon();
          }
        }
      }
    }
  }
  
  public void collectWorkspaceStateAnimators(Workspace paramWorkspace, Workspace.State paramState1, Workspace.State paramState2, BaseItem paramBaseItem, ArrayList<Animator> paramArrayList)
  {
    paramWorkspace = getContext();
    int m = 0;
    int k = 0;
    int i;
    int j;
    boolean bool;
    if (paramState2 == Workspace.State.RESIZE)
    {
      k = 1;
      i = m;
      j = k;
      if (paramState1 == Workspace.State.NORMAL)
      {
        this.isWidgetItem = true;
        j = k;
        i = m;
      }
      if (paramBaseItem != null)
      {
        if ((paramBaseItem.mType != BaseItem.Type.MENU_APP) && (paramBaseItem.mType != BaseItem.Type.MENU_FOLDER) && (!(paramBaseItem instanceof HomePendingItem))) {
          break label318;
        }
        bool = true;
        label87:
        this.itemFromMenu = bool;
        this.isWidgetItem = BaseItem.isWidget(paramBaseItem);
        this.isFromDND = paramBaseItem.getFromDND();
      }
      if ((j == 0) && (i == 0)) {
        break label324;
      }
      paramState1 = AnimatorInflater.loadAnimator(paramWorkspace, 2131034113);
      paramState1.setTarget(this.mBackground);
      paramArrayList.add(paramState1);
      paramState1 = AnimatorInflater.loadAnimator(paramWorkspace, 2131034124);
      paramState1.setTarget(this.mContent);
      paramArrayList.add(paramState1);
      this.mContent.setAllAppsIconDimState(true, true, false);
      if (((this.itemFromMenu) && (this.mContent.isFull())) || (this.isWidgetItem) || (this.isFromDND)) {
        setDimHotseatItems(this.mContent, true, false);
      }
    }
    for (;;)
    {
      if ((paramState2 != Workspace.State.RESIZE) && (paramState2 != Workspace.State.EDIT)) {
        break label439;
      }
      j = this.mContent.getPageChildCount();
      i = 0;
      while (i < j)
      {
        paramState1 = this.mContent.getChildOnPageAt(i);
        if ((paramState1 instanceof FolderIconView)) {
          ((FolderIconView)paramState1).showBadge();
        }
        i += 1;
      }
      i = m;
      j = k;
      if (paramState2 != Workspace.State.EDIT) {
        break;
      }
      if (paramBaseItem != null) {}
      for (i = 1;; i = 0)
      {
        j = k;
        break;
      }
      label318:
      bool = false;
      break label87;
      label324:
      paramState1 = AnimatorInflater.loadAnimator(paramWorkspace, 2131034112);
      paramState1.setTarget(this.mBackground);
      paramArrayList.add(paramState1);
      paramState1 = AnimatorInflater.loadAnimator(paramWorkspace, 2131034125);
      paramState1.setTarget(this.mContent);
      paramArrayList.add(paramState1);
      this.mContent.setAllAppsIconDimState(false, true, true);
      if (((this.itemFromMenu) && (this.mContent.isFull())) || (this.isWidgetItem) || (this.isFromDND))
      {
        setDimHotseatItems(this.mContent, false, true);
        this.itemFromMenu = false;
        this.isWidgetItem = false;
        this.isFromDND = false;
      }
    }
    label439:
    paramWorkspace = AnimatorInflater.loadAnimator(paramWorkspace, 2131034113);
    paramWorkspace.setTarget(this);
    paramWorkspace.addListener(this);
    paramArrayList.add(paramWorkspace);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  int getCellXFromOrder(int paramInt)
  {
    if (this.mIsLandscape) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  int getCellYFromOrder(int paramInt1, int paramInt2)
  {
    if (this.mIsLandscape) {
      return paramInt2 - paramInt1;
    }
    return 0;
  }
  
  public Bitmap getDragOutline(View paramView)
  {
    return this.mWorkspace.getDragOutline(paramView);
  }
  
  CellLayout getLayout()
  {
    return this.mContent;
  }
  
  int getOrderInHotseat(int paramInt1, int paramInt2)
  {
    if (this.mIsLandscape) {
      paramInt1 = this.mMaxCellCount - paramInt2 - 1;
    }
    return paramInt1;
  }
  
  public Workspace getWorkspace()
  {
    return this.mHomeView.getWorkspace();
  }
  
  boolean isLandscape()
  {
    return this.mIsLandscape;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator.getDuration() == 0L) {}
    for (;;)
    {
      return;
      this.mBackground.setLayerType(0, Launcher.sViewLayerPaint);
      paramAnimator = this.mContent.getChildrenLayout();
      int j = paramAnimator.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramAnimator.getChildAt(i).setLayerType(0, Launcher.sViewLayerPaint);
        i += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator.getDuration() == 0L) {
      return;
    }
    paramAnimator = this.mContent.getChildrenLayout();
    int j = paramAnimator.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramAnimator.getChildAt(i).setLayerType(2, Launcher.sViewLayerPaint);
      i += 1;
    }
    this.mBackground.setLayerType(2, Launcher.sViewLayerPaint);
  }
  
  public void onDragEndedWithItem(BaseItem paramBaseItem)
  {
    this.mWorkspace.onDragEndedWithItem(paramBaseItem);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onDragEvent(paramDragEvent);
      if (!Launcher.isInValidDragState(paramDragEvent))
      {
        if (paramDragEvent.getLocalState() != null) {}
        for (Object localObject = (DragState)paramDragEvent.getLocalState(); (((DragState)localObject).mDragOrigin != this) && ((((DragState)localObject).mDragOrigin instanceof CellLayout)); localObject = Launcher.dragstate)
        {
          localObject = (CellLayout)((DragState)localObject).mDragOrigin;
          if (!((CellLayout)localObject).getIsDragOverlapping()) {
            break;
          }
          ((CellLayout)localObject).onDragExit();
          break;
        }
        if ((!this.mDragInContentArea) && (!this.mContent.isFull()))
        {
          this.mContent.pointToCellExact((int)paramDragEvent.getX(), (int)paramDragEvent.getY(), this.tmp);
          localObject = this.mContent.getChildAt(this.tmp[0], this.tmp[1]);
          if ((paramDragEvent.getAction() == 3) || (localObject != null))
          {
            this.mContent.onDragEvent(paramDragEvent);
            continue;
            this.mContent.mDrawDragOutlines = false;
            this.mContent.removeEmptySpace();
            this.mContent.cancelRealTimeReorder();
            this.mContent.clearDragOutlines();
          }
        }
      }
    }
  }
  
  public void onDragStartedWithItem(View paramView)
  {
    this.mWorkspace.onDragStartedWithItem(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mContent = ((CellLayoutHotseat)findViewById(2131689559));
    this.mBackground = findViewById(2131689614);
    HotseatSwapAnimator.create(this, this.mContent);
    resetLayout();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.mWorkspace == null) {}
    do
    {
      return false;
      switch (i & 0xFF)
      {
      default: 
        return false;
      }
    } while (this.mWorkspace.isHoveringAreaX(paramMotionEvent.getX()) == 0);
    this.mWorkspace.setHoveringSpenIcon(0);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mWorkspace.getState() == Workspace.State.RESIZE) {
      return this.mWorkspace.isTouchResizeFrame(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mWorkspace.getState() == Workspace.State.RESIZE)
    {
      paramMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY() + getTop());
      this.mWorkspace.onTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void reapplyIconViewStyles()
  {
    Object localObject1 = getContext();
    TypedArray localTypedArray1 = AppIconView.getTextViewStyle((Context)localObject1, 2131820569);
    TypedArray localTypedArray2 = AppIconView.getViewStyle((Context)localObject1, 2131820569);
    TypedArray localTypedArray3 = AppIconView.getTextViewStyle((Context)localObject1, 2131820570);
    localObject1 = AppIconView.getViewStyle((Context)localObject1, 2131820570);
    int i = this.mContent.getPageChildCount() - 1;
    if (i >= 0)
    {
      Object localObject2 = this.mContent.getChildOnPageAt(i);
      if ((localObject2 instanceof FolderIconView))
      {
        localObject2 = (FolderIconView)localObject2;
        ((FolderIconView)localObject2).applyStyle((TypedArray)localObject1, localTypedArray3);
        ((FolderIconView)localObject2).showBadge();
      }
      for (;;)
      {
        i -= 1;
        break;
        if ((localObject2 instanceof AppIconView)) {
          ((AppIconView)localObject2).applyStyle(localTypedArray2, localTypedArray1);
        }
      }
    }
    AppIconView.recycleViewStyles(localTypedArray2, localTypedArray1);
    AppIconView.recycleViewStyles((TypedArray)localObject1, localTypedArray3);
  }
  
  void resetLayout()
  {
    this.mContent.removeAllViewsInLayout();
    this.mContent.setGridSize(1, 1);
    Resources localResources = getContext().getResources();
    if (!Utilities.isCamera()) {}
    for (int i = 2131427347;; i = 2131427346)
    {
      this.mShowHotseatTitle = localResources.getBoolean(i);
      this.mContent.inflateAllAppsIcon(this, this.mShowHotseatTitle);
      return;
    }
  }
  
  public void setDimHotseatItems(CellLayoutHotseat paramCellLayoutHotseat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramCellLayoutHotseat.getPageChildCount();
    int i = 0;
    while (i < j)
    {
      AppIconView localAppIconView = (AppIconView)paramCellLayoutHotseat.getChildOnPageAt(i);
      if (localAppIconView != null)
      {
        localAppIconView.setDimmed(paramBoolean1, true);
        localAppIconView.setEnabled(paramBoolean2);
      }
      i += 1;
    }
  }
  
  void setDragInContentArea(boolean paramBoolean)
  {
    this.mDragInContentArea = paramBoolean;
  }
  
  public void setup(HomeView paramHomeView)
  {
    boolean bool = false;
    this.mHomeView = paramHomeView;
    this.mWorkspace = paramHomeView.getWorkspace();
    setOnKeyListener(FocusHelper.HOTSEAT_ICON_KEY_LISTENER);
    Resources localResources = getContext().getResources();
    if (localResources.getConfiguration().smallestScreenWidthDp >= 800) {}
    for (this.mIsLandscape = false;; this.mIsLandscape = bool)
    {
      this.mMaxCellCount = Math.max(localResources.getInteger(2131492901), localResources.getInteger(2131492902));
      this.mContent.setHomeView(paramHomeView);
      this.mContent.setItemViewBuilder(this.mItemViewBuilder);
      this.mContent.setup(this.mIsLandscape, this.mMaxCellCount);
      return;
      if (localResources.getConfiguration().orientation == 2) {
        bool = true;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Hotseat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */