package com.android.launcher2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.DVFSHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import java.util.ArrayList;

public class CellLayoutHotseat
  extends CellLayoutNoGap
{
  private static final boolean DEBUGGABLE = ;
  static final String TAG = "CellLayoutHotseat";
  private static DVFSHelper cpuBooster = null;
  private static DVFSHelper gpuBooster = null;
  private AllappsIcon mAllappsIcon;
  private boolean mBinding = false;
  private DragState mDragState;
  private boolean mHasEnded = false;
  boolean mIsLandscape;
  int mMaxCellCount = 4;
  private boolean mRemoveEmptySpacePosted = false;
  private boolean mReorderPosted = false;
  private final int[] mTmpDragXY = new int[2];
  
  public CellLayoutHotseat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CellLayoutHotseat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CellLayoutHotseat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cpuBooster = LauncherApplication.getInst().getCpuBoosterObject();
    gpuBooster = LauncherApplication.getInst().getGpuBoosterObject();
  }
  
  private void animateAllChildren()
  {
    int j = getPageItemCount() + 1;
    if (DEBUGGABLE) {
      Log.d("CellLayoutHotseat", "animateAllChildren " + j);
    }
    int i = 0;
    if (i < j)
    {
      View localView = this.mChildren.getChildAt(i);
      if ((localView == null) || (localView.getTag() == null) || (localView.getTag() == this.mHiddenItem)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof FolderIconView)) {
          ((FolderIconView)localView).cancelFolderAnims();
        }
        animateIcon(localView, 230, true, false);
      }
    }
  }
  
  private int getAllappsPos()
  {
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)this.mAllappsIcon.getLayoutParams();
    return cellToPosition(localLayoutParams.cellX, localLayoutParams.cellY);
  }
  
  private void setupAllAppsIcon(Context paramContext, AllappsIcon paramAllappsIcon, boolean paramBoolean)
  {
    if (paramAllappsIcon == null) {
      return;
    }
    int i = (int)TypedValue.applyDimension(1, (int)paramContext.getResources().getDimension(2131623964), paramContext.getResources().getDisplayMetrics());
    Bitmap localBitmap1 = null;
    if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
      localBitmap1 = LauncherApplication.getInst().getThemeLoader().loadAppsIconBitmap();
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130837689);
    }
    paramAllappsIcon.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(Bitmap.createScaledBitmap(localBitmap2, i, i, true)), null, null);
    if (LauncherApplication.isTabletLayout())
    {
      float f = paramContext.getResources().getFraction(2131558412, 1, 1);
      paramAllappsIcon.setScaleX(f);
      paramAllappsIcon.setScaleY(f);
    }
    if (paramBoolean) {
      paramAllappsIcon.setText(2131755041);
    }
    paramAllappsIcon.setContentDescription(paramContext.getString(2131755225));
    paramAllappsIcon.setOnKeyListener(FocusHelper.HOTSEAT_ICON_KEY_LISTENER);
    paramAllappsIcon.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeEditMode())) {}
        while (CellLayoutHotseat.this.mHomeView == null) {
          return;
        }
        MenuView localMenuView = ((Launcher)CellLayoutHotseat.this.getContext()).getMenuView();
        if (localMenuView != null) {
          localMenuView.selectAppsTab();
        }
        CellLayoutHotseat.this.mHomeView.onClickAllAppsButton(paramAnonymousView);
      }
    });
  }
  
  private void updateViewToLandscape()
  {
    CellLayoutChildren localCellLayoutChildren = getChildrenLayout();
    int i = 0;
    if (i < localCellLayoutChildren.getChildCount())
    {
      View localView = localCellLayoutChildren.getChildAt(i);
      BaseItem localBaseItem = (BaseItem)localView.getTag();
      if (localBaseItem == null) {}
      for (;;)
      {
        i += 1;
        break;
        CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)localView.getLayoutParams();
        setCellFromPosition(localLayoutParams, localBaseItem.getPosition());
        localView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  boolean CLIP_BY_DEFAULT()
  {
    return false;
  }
  
  public boolean addItem(BaseItem paramBaseItem)
  {
    int j = getPageItemCount();
    int i = 0;
    while (i < j + 1)
    {
      View localView = this.mChildren.getChildAt(i);
      if ((localView instanceof FolderIconView)) {
        ((FolderIconView)localView).cancelFolderAnims();
      }
      i += 1;
    }
    i = makeEmptySpace();
    if ((this.mDisabled) || (i != -1)) {
      realTimeReorder(paramBaseItem.getPosition());
    }
    if (!HomeView.sIsBindHotseat)
    {
      if (paramBaseItem.getPackageName() == null) {
        break label108;
      }
      LauncherApplication.getInst().insertLog("HSAD", paramBaseItem.getPackageName(), -1L, false);
    }
    for (;;)
    {
      return super.addItem(paramBaseItem);
      label108:
      LauncherApplication.getInst().insertLog("HSAD", "Folder", -1L, false);
    }
  }
  
  public void beginBind(int paramInt)
  {
    this.mBinding = true;
    this.mAnimateChildInstantly = true;
    if (this.mIsLandscape)
    {
      setGridSize(1, paramInt + 1);
      return;
    }
    setGridSize(paramInt + 1, 1);
  }
  
  int cellToPosition(int paramInt1, int paramInt2)
  {
    int i = getCellCount();
    if (this.mIsLandscape) {
      paramInt1 = i - 1 - paramInt2;
    }
    return paramInt1;
  }
  
  public void endBind()
  {
    moveAppIcon();
    this.mBinding = false;
    this.mAnimateChildInstantly = false;
    removeEmptySpace();
  }
  
  boolean existsEmptyCell()
  {
    return true;
  }
  
  public AllappsIcon getAllAppsIcon()
  {
    return this.mAllappsIcon;
  }
  
  int getCellCount()
  {
    if (this.mIsLandscape) {
      return getCountY();
    }
    return getCountX();
  }
  
  int getCellXFromPos(int paramInt)
  {
    if (this.mIsLandscape) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  int getCellYFromPos(int paramInt)
  {
    int i = getCellCount();
    if (this.mIsLandscape) {
      return i - 1 - paramInt;
    }
    return 0;
  }
  
  public long getContainerType()
  {
    return -101L;
  }
  
  public DragState getDragState()
  {
    return this.mDragState;
  }
  
  public AllappsIcon inflateAllAppsIcon(Hotseat paramHotseat, boolean paramBoolean)
  {
    paramHotseat = getChildrenLayout();
    Context localContext = getContext();
    this.mAllappsIcon = ((AllappsIcon)LayoutInflater.from(localContext).inflate(2130903042, this, false));
    setupAllAppsIcon(localContext, this.mAllappsIcon, paramBoolean);
    paramHotseat.addView(this.mAllappsIcon, new CellLayout.LayoutParams(0, 0, 1, 1));
    paramHotseat = paramHotseat.getChildAt(paramHotseat.getChildCount() - 1);
    if ((paramHotseat != null) && (this.mHomeView != null) && (this.mHomeView.isVisible())) {
      paramHotseat.requestFocus();
    }
    return this.mAllappsIcon;
  }
  
  public boolean isFull()
  {
    if (this.mHiddenItem != null) {}
    while (getPageItemCount() + 1 < this.mMaxCellCount) {
      return false;
    }
    return true;
  }
  
  int makeEmptySpace()
  {
    int j = 1;
    int k = getPageItemCount() + 2;
    int i = k;
    if (this.mHiddenItem != null) {
      i = k - 1;
    }
    if (DEBUGGABLE) {
      Log.d("CellLayoutHotseat", "makeEmptySpace check:" + getCellCount() + " < " + i);
    }
    if (getCellCount() < i)
    {
      if (DEBUGGABLE) {
        Log.d("CellLayoutHotseat", "makeEmptySpace count:" + i);
      }
      if (this.mIsLandscape)
      {
        if (getCountY() < this.mMaxCellCount) {
          setGridSize(1, i);
        }
        moveAppIcon();
        k = getCellCount();
        if (!this.mIsLandscape) {
          break label173;
        }
      }
      label173:
      for (i = j;; i = 2)
      {
        return k - i;
        if (getCountX() >= this.mMaxCellCount) {
          break;
        }
        setGridSize(i, 1);
        break;
      }
    }
    return -1;
  }
  
  public void moveAppIcon()
  {
    if (this.mHomeView == null) {}
    for (;;)
    {
      return;
      AllappsIcon localAllappsIcon = this.mAllappsIcon;
      CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)localAllappsIcon.getLayoutParams();
      int j = 0;
      int i;
      if ((this.mIsLandscape) && (localLayoutParams.cellY != getCountY()))
      {
        localLayoutParams.cellY = 0;
        i = 1;
      }
      while (i != 0)
      {
        animateIcon(localAllappsIcon, 230, true, false);
        return;
        i = j;
        if (!this.mIsLandscape)
        {
          i = j;
          if (localLayoutParams.cellX != getCountX() - 1)
          {
            localLayoutParams.cellX = (getCountX() - 1);
            i = 1;
          }
        }
      }
    }
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    int j = paramDragEvent.getAction();
    Hotseat localHotseat = (Hotseat)getContainer();
    if (paramDragEvent.getLocalState() != null) {}
    for (DragState localDragState = (DragState)paramDragEvent.getLocalState(); localHotseat == null; localDragState = Launcher.dragstate) {
      return super.onDragEvent(paramDragEvent);
    }
    if (((localDragState.mDragOrigin instanceof CellLayoutWithResizableWidgets)) || ((localDragState.mItem instanceof HomeShortcutItem)))
    {
      if (j == 5) {
        localHotseat.getWorkspace().disableRollNavigation();
      }
    }
    else
    {
      localObject = localDragState.mItem;
      if ((((BaseItem)localObject).mType != BaseItem.Type.MENU_APP) && (((BaseItem)localObject).mType != BaseItem.Type.MENU_FOLDER) && ((localDragState.mDragOrigin != null) || (!(localObject instanceof HomePendingItem)))) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (j == 1)
      {
        this.mHasEnded = false;
        this.mDrawDragOutlines = true;
      }
      if (!this.mHasEnded) {
        break label186;
      }
      return false;
      if (j != 6) {
        break;
      }
      localHotseat.getWorkspace().enableRollNavigation();
      break;
    }
    label186:
    if ((i == 0) && ((localDragState.mItem instanceof HomeItem)) && (((HomeItem)localDragState.mItem).container > 0L) && (j == 2) && (localHotseat.getWorkspace().getOpenFolder() != null))
    {
      localHotseat.getWorkspace().closeFolder();
      return true;
    }
    pointToCellExact((int)paramDragEvent.getX(), (int)paramDragEvent.getY(), this.mTmpDragXY);
    Object localObject = getChildAt(this.mTmpDragXY[0], this.mTmpDragXY[1]);
    if (((i != 0) && (isFull())) || (localHotseat.checkHotSeatInteraction(localDragState, j, (View)localObject)))
    {
      if (j == 3) {
        return true;
      }
    }
    else {
      this.mDrawDragOutlines = true;
    }
    if (BaseItem.isWidget(localDragState.getItem())) {
      return true;
    }
    if (localDragState.getItem().getFromDND()) {
      return true;
    }
    if (j != 4) {
      this.mDragState = localDragState;
    }
    if (j == 5) {
      this.mDisabled = isFull();
    }
    if (this.mDisabled)
    {
      if (j == 4) {
        this.mDisabled = false;
      }
    }
    else {
      switch (j)
      {
      }
    }
    for (;;)
    {
      return super.onDragEvent(paramDragEvent);
      return super.onDragEvent(paramDragEvent);
      localHotseat.setDragInContentArea(false);
      cancelRealTimeReorder();
      return true;
      this.mDrawDragOutlines = false;
      this.mHasEnded = true;
      localDragState.onEnd();
      this.mDragState = null;
      this.mHiddenItem = null;
      removeEmptySpace();
      continue;
      this.mReorderImmediately = true;
      this.mDrawDragOutlines = true;
      localHotseat.setDragInContentArea(true);
    }
  }
  
  public void onFailedDrop(BaseItem paramBaseItem)
  {
    int i = 0;
    if (this.mDragState != null) {
      i = this.mDragState.mOriginalScreen;
    }
    int j = i;
    if (i == -1) {
      j = 0;
    }
    this.mDragState = null;
    makeEmptySpace();
    realTimeReorder(j);
    paramBaseItem.setPosition(j);
    super.onFailedDrop(paramBaseItem);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    cpuBooster.addExtraOptionsByDefaultPolicy("Launcher_touch");
    if (i == 0)
    {
      cpuBooster.acquire("Launcher_touch");
      if (gpuBooster.getSupportedGPUFrequency() != null) {
        gpuBooster.acquire();
      }
    }
    if (i == 1)
    {
      cpuBooster.release();
      if (gpuBooster.getSupportedGPUFrequency() != null) {
        gpuBooster.release();
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i3 = getCountX();
    int n = getCountY();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i1 = getPaddingTop() + getPaddingBottom();
    int i5 = getCellWidth() * i3;
    int i2 = getCellHeight() * n;
    if (m == 0) {
      j = i5 + i4;
    }
    if (i == 0) {
      k = i2 + i1;
    }
    i = 0;
    m = 0;
    if (i3 > 1)
    {
      j = (j - i5 - i4) / (i3 + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
    j = m;
    if (n > 1)
    {
      k = (k - i2 - i1) / (n + 1);
      j = k;
      if (k < 0) {
        j = 0;
      }
    }
    setGaps(i, j);
    refreshCellDimension();
    if (DEBUGGABLE) {
      Log.d("CellLayoutHotseat", "setGaps(" + i + ", " + j + ")");
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewAddedToLayout(View paramView)
  {
    super.onViewAddedToLayout(paramView);
    if ((this.mBinding) && ((paramView.getTag() instanceof HomeItem)))
    {
      HomeItem localHomeItem = (HomeItem)paramView.getTag();
      paramView = (CellLayout.LayoutParams)paramView.getLayoutParams();
      paramView.cellX = localHomeItem.cellX;
      paramView.cellY = localHomeItem.cellY;
    }
  }
  
  void realTimeReorder()
  {
    if ((this.mHasEnded) && (findFirstEmptySpace() == getAllappsPos())) {}
    do
    {
      return;
      if (!hasAnimatingChild()) {
        break;
      }
    } while (this.mReorderPosted);
    this.mReorderPosted = true;
    postDelayed(new Runnable()
    {
      public void run()
      {
        CellLayoutHotseat.access$002(CellLayoutHotseat.this, false);
        CellLayoutHotseat.this.realTimeReorder();
      }
    }, 20L);
    return;
    if (findFirstEmptySpace() == getAllappsPos()) {
      makeEmptySpace();
    }
    super.realTimeReorder();
    this.mReorderImmediately = false;
  }
  
  public void realTimeReorder(final int paramInt)
  {
    if (hasAnimatingChild())
    {
      if (this.mReorderPosted) {
        return;
      }
      this.mReorderPosted = true;
      postDelayed(new Runnable()
      {
        public void run()
        {
          CellLayoutHotseat.access$002(CellLayoutHotseat.this, false);
          CellLayoutHotseat.this.realTimeReorder(paramInt);
        }
      }, 20L);
      return;
    }
    super.realTimeReorder(paramInt);
  }
  
  public void removeAllItems()
  {
    int i = 0;
    while (i < this.mChildren.mItems.size())
    {
      BaseItem localBaseItem = (BaseItem)this.mChildren.mItems.get(i);
      if (localBaseItem != null) {
        removeItem(localBaseItem);
      }
      i += 1;
    }
  }
  
  public void removeEmptySpace()
  {
    if (hasAnimatingChild()) {
      if (!this.mRemoveEmptySpacePosted) {}
    }
    int i;
    do
    {
      return;
      this.mRemoveEmptySpacePosted = true;
      postDelayed(new Runnable()
      {
        public void run()
        {
          CellLayoutHotseat.access$102(CellLayoutHotseat.this, false);
          CellLayoutHotseat.this.removeEmptySpace();
        }
      }, 20L);
      return;
      int j = getPageItemCount() + 1;
      i = j;
      if (this.mHiddenItem != null) {
        i = j - 1;
      }
    } while (getCellCount() == i);
    if (DEBUGGABLE) {
      Log.d("CellLayoutHotseat", "removeEmptySpace count:" + i);
    }
    closeLayoutGap();
    if (this.mIsLandscape) {
      setGridSize(1, i);
    }
    for (;;)
    {
      moveAppIcon();
      return;
      setGridSize(i, 1);
    }
  }
  
  public boolean removeItem(BaseItem paramBaseItem)
  {
    boolean bool = super.removeItem(paramBaseItem);
    if ((bool) && (!this.mDisabled)) {
      removeEmptySpace();
    }
    if (paramBaseItem.getPackageName() != null)
    {
      LauncherApplication.getInst().insertLog("HSDT", paramBaseItem.getPackageName(), -1L, false);
      return bool;
    }
    LauncherApplication.getInst().insertLog("HSDT", "Folder", -1L, false);
    return bool;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (!this.mDisabled) {
      removeEmptySpace();
    }
  }
  
  public void setAllAppsIconDimState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.mAllappsIcon != null)
    {
      this.mAllappsIcon.setDimmed(paramBoolean1, paramBoolean2);
      this.mAllappsIcon.setEnabled(paramBoolean3);
    }
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if (DEBUGGABLE) {
      Log.d("CellLayoutHotseat", "setGridSize:" + paramInt1 + "," + paramInt2);
    }
    super.setGridSize(paramInt1, paramInt2);
    if (this.mIsLandscape) {
      updateViewToLandscape();
    }
    animateAllChildren();
  }
  
  public void setup(boolean paramBoolean, int paramInt)
  {
    this.mIsLandscape = paramBoolean;
    this.mMaxCellCount = paramInt;
    setGridSize(1, 1);
  }
  
  void visualizeDropLocation(View paramView, Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((this.mDisabled) && (this.mDragState != null))
    {
      localObject = this.mDragState.getItem();
      if ((((BaseItem)localObject).mType != BaseItem.Type.MENU_APP) && (((BaseItem)localObject).mType != BaseItem.Type.MENU_FOLDER)) {}
    }
    do
    {
      do
      {
        return;
      } while ((this.mDragState.mDragOrigin == null) && ((this.mDragState.getItem() instanceof HomePendingItem)));
      if (!this.mDisabled) {
        break;
      }
      localObject = (CellLayout.LayoutParams)this.mAllappsIcon.getLayoutParams();
    } while ((paramArrayOfInt[0] == ((CellLayout.LayoutParams)localObject).cellX) && (paramArrayOfInt[1] == ((CellLayout.LayoutParams)localObject).cellY));
    super.visualizeDropLocation(paramView, paramBitmap, paramArrayOfInt, paramInt1, paramInt2);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutHotseat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */