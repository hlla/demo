package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import com.samsung.android.feature.FloatingFeature;
import com.sec.dtl.launcher.Talk;
import java.util.ArrayList;
import java.util.Locale;

public class FolderIconView
  extends AppIconView
  implements DragReceivable, HomeFolderItem.FolderListener
{
  public static final int FOLDER_ICON_CNT = 6;
  public static final int HOVER_FOLDER_ICON_CNT = 7;
  private static final long HOVER_REMAIN = 2000L;
  private static final long HOVER_START_DURATION = 300L;
  private static MenuAppsGridFragment mMenuAppsGridFragment;
  private int Hover_Refresh_cnt = 0;
  private boolean USE_SET_INTEGRATOR_HAPTIC = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_FRAMEWORK_ENABLE_INTEGRATOR_HAPTIC");
  final ScalarAnimator mCreateFactor = new ScalarAnimator(500L, 1.0F);
  private float mDimAmount = 0.55F;
  private long mDraggedIconId = -2147483648L;
  private boolean mDraggingOver = false;
  boolean mDrawPlate = true;
  private final FolderAnimator mFolderAnimator = new FolderAnimator(null, this);
  private long mFolderHoveringStartTime = 0L;
  private FolderItem mFolderItem;
  private boolean mFromThisFolder;
  public boolean mHasBounceItem = false;
  final ScalarAnimator mHighlightFactor = new ScalarAnimator(200L, 0.0F);
  boolean mIgnoreSetAlphaOnDragExit = false;
  private Folder mLastAttachedFolder;
  private Runnable mOnEnterDelayed = new Runnable()
  {
    public void run()
    {
      if ((FolderIconView.this.mDraggingOver) && (!FolderIconView.this.isAnimating())) {
        FolderIconView.this.onDragEnter();
      }
    }
  };
  protected AnimationLayer.Anim mPlate;
  protected Bitmap mPlateBitmap;
  private Paint mTmpPaint = new Paint();
  
  public FolderIconView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FolderIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FolderIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean acceptDrop(DragState paramDragState)
  {
    if (paramDragState.getView() != this)
    {
      paramDragState = paramDragState.getItem();
      if ((paramDragState != null) && (!BaseItem.isFolder(paramDragState)) && (!BaseItem.isWidget(paramDragState))) {
        return true;
      }
    }
    return false;
  }
  
  private void drawPlate(Canvas paramCanvas)
  {
    float f1 = this.mHighlightFactor.get();
    float f2 = this.mCreateFactor.get();
    Paint localPaint1 = this.mTmpPaint;
    if ((isDimmed()) && (!CellLayout.isItemApp())) {
      localPaint1.setColorFilter(createDarkenColorFilter(this.mDimAmount));
    }
    for (;;)
    {
      localPaint1.setFilterBitmap(true);
      localPaint1.setAntiAlias(true);
      Object localObject = (FolderItem)getTag();
      Bitmap localBitmap = FolderIconHelper.getOpenFolderBitmap(((FolderItem)localObject).getFolderColor());
      localObject = FolderIconHelper.getOpenFolderHighlightBitmap(((FolderItem)localObject).getFolderColor());
      float f5 = localBitmap.getWidth();
      float f6 = localBitmap.getHeight();
      float f3 = f5 / 2.0F;
      float f4 = f6 / 2.0F;
      if (FolderIconHelper.DEBUG)
      {
        Paint localPaint2 = new Paint();
        localPaint2.setColor(1157562368);
        paramCanvas.drawRect(new Rect(0, 0, (int)f5, (int)f6), localPaint2);
      }
      paramCanvas.save();
      setTextAlpha((int)(255.0F * f2));
      f5 = 1.0F + 0.1F * f1;
      paramCanvas.scale(f5, f5, f3, f4);
      if (LauncherApplication.isTabletLayout()) {
        paramCanvas.translate(0.0F, FolderIconHelper.getFolderPlateOffsetY());
      }
      if (f1 > 0.0F)
      {
        localPaint1.setAlpha((int)(f2 * f1 * 255.0F));
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint1);
      }
      if (f1 < 1.0F)
      {
        localPaint1.setAlpha((int)((1.0F - f1) * f2 * 255.0F));
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint1);
      }
      paramCanvas.restore();
      return;
      localPaint1.setColorFilter(createDarkenColorFilter(0.0F));
    }
  }
  
  private void draw_(Canvas paramCanvas)
  {
    if (this.mDrawPlate)
    {
      Bitmap localBitmap = FolderIconHelper.getOpenFolderBitmap(((FolderItem)getTag()).getFolderColor());
      float f = getHotseatScaleFactor();
      paramCanvas.save();
      paramCanvas.translate(getScrollX() + (getWidth() - localBitmap.getWidth() * f) / 2.0F, getScrollY() + getPaddingTop() / f);
      paramCanvas.scale(f, f);
      drawPlate(paramCanvas);
      paramCanvas.restore();
    }
    drawIconOrText(paramCanvas);
  }
  
  private boolean droppedInOurFolder(DragState paramDragState)
  {
    paramDragState = paramDragState.getReceiver();
    if (paramDragState == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramDragState instanceof CellLayoutNoGap));
      paramDragState = (CellLayoutNoGap)paramDragState;
    } while ((paramDragState.mFolder == null) || (paramDragState.mFolder.mInfo != this.mFolderItem));
    return true;
  }
  
  private BaseItem getHiddenIconItem(FolderItem paramFolderItem)
  {
    int i = 0;
    while (i < paramFolderItem.getItemCount())
    {
      BaseItem localBaseItem = paramFolderItem.getItemAt(i);
      if (localBaseItem.mId == this.mDraggedIconId) {
        return localBaseItem;
      }
      i += 1;
    }
    return null;
  }
  
  public static MenuAppsGridFragment getMenuAppsGridFragment()
  {
    return mMenuAppsGridFragment;
  }
  
  static float mix(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat2 * paramFloat3;
  }
  
  private void onDragEnter()
  {
    if ((getVisibility() != 0) || (((Launcher)getContext()).isTransitioningRunning()))
    {
      postDelayed(this.mOnEnterDelayed, 20L);
      return;
    }
    this.mHighlightFactor.to(1.0F);
    if ((fromThisFolder()) && (!this.mFolderItem.isOpened())) {}
    this.mFolderAnimator.animatePlate(true);
  }
  
  private void resetPlateIfNeeded()
  {
    if (getVisibility() != 0) {}
    do
    {
      return;
      if ((fromThisFolder()) && (this.mFolderItem.isOpened())) {}
      this.mHighlightFactor.to(0.0F);
    } while (getParent() == null);
    invalidate();
    this.mFolderAnimator.animatePlate(false);
  }
  
  private void resetPlateIfNeeded(DragState paramDragState)
  {
    resetPlateIfNeeded();
    if ((getParent() != null) && (paramDragState != null)) {
      this.mFolderAnimator.animateCloseAnimsEnd(paramDragState, false, false);
    }
  }
  
  private void setFolderItem(FolderItem paramFolderItem)
  {
    if (this.mFolderItem != null) {
      this.mFolderItem.removeListener(this);
    }
    this.mFolderItem = paramFolderItem;
    if (this.mFolderItem != null) {
      this.mFolderItem.addListener(this);
    }
  }
  
  public static void setMenuAppsGridFragment(MenuAppsGridFragment paramMenuAppsGridFragment)
  {
    mMenuAppsGridFragment = paramMenuAppsGridFragment;
  }
  
  public boolean addItem(BaseItem paramBaseItem)
  {
    this.mFolderItem.addItem(paramBaseItem);
    Talk.INSTANCE.say(2131755206);
    return true;
  }
  
  public void applyBaseItem(BaseItem paramBaseItem)
  {
    Bitmap localBitmap2 = paramBaseItem.mIconBitmap;
    int j = localBitmap2.getHeight();
    int i = 0;
    if (j == (int)getResources().getDimension(2131624134)) {
      i = 1;
    }
    Bitmap localBitmap1;
    if (paramBaseItem.mType != BaseItem.Type.MENU_FOLDER)
    {
      localBitmap1 = localBitmap2;
      if (paramBaseItem.mType != BaseItem.Type.HOME_FOLDER) {}
    }
    else
    {
      setFolderItem((FolderItem)paramBaseItem);
      if (i == 0)
      {
        localBitmap1 = localBitmap2;
        if (!this.mFolderItem.isRequiredToRedraw()) {}
      }
      else
      {
        localBitmap1 = FolderIconHelper.createFolderIconNoPlate(localBitmap2, this.mFolderItem, getHiddenIconItem(this.mFolderItem));
        paramBaseItem.mIconBitmap = localBitmap1;
        this.mFolderItem.setToRedrawIcons(false);
      }
    }
    this.mPlateBitmap = FolderIconHelper.getOpenFolderBitmap(paramBaseItem.mColor);
    applyBaseItem(paramBaseItem, localBitmap1);
    if ((isEmpty()) && (!paramBaseItem.viewForThisHasSeenLightOfDayBefore))
    {
      this.mCreateFactor.abort(0.0F);
      postDelayed(new Runnable()
      {
        public void run()
        {
          FolderIconView.this.mCreateFactor.start(0.0F, 1.0F);
          FolderIconView.this.mFolderAnimator.animatePlate(false);
        }
      }, 200L);
    }
    paramBaseItem.viewForThisHasSeenLightOfDayBefore = true;
  }
  
  public void cancelFolderAnims()
  {
    cleanupFolderAnims();
    if (this.mLastAttachedFolder != null) {
      this.mLastAttachedFolder.mFolderAnimator.cancel();
    }
  }
  
  public void cleanupFolderAnims()
  {
    destroyDrawingCache();
    this.mFolderAnimator.cancel();
    this.mDrawPlate = true;
    this.mDrawShadow = true;
    if (isEmpty()) {}
    for (this.mDrawIcon = false;; this.mDrawIcon = true)
    {
      this.mHighlightFactor.abort(0.0F);
      return;
    }
  }
  
  public View createViewForItem(BaseItem paramBaseItem)
  {
    if (!(paramBaseItem instanceof HomeShortcutItem)) {
      return null;
    }
    return ((Launcher)getContext()).mHomeView.createShortcut((HomeShortcutItem)paramBaseItem, 2130903071);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = getTag();
    drawShadow(paramCanvas);
    if (((localObject instanceof AppFolderItem)) && (isDimmed() == ((AppFolderItem)localObject).isEnabled())) {
      if (isDimmed()) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      setDimmed(bool, false);
      draw_(paramCanvas);
      return;
    }
  }
  
  public void drawPlateWithFolderScale(Canvas paramCanvas)
  {
    Bitmap localBitmap = FolderIconHelper.getOpenFolderBitmap(((FolderItem)getTag()).getFolderColor());
    float f = getHotseatScaleFactor();
    paramCanvas.save();
    if (f < 1.0F) {
      paramCanvas.translate(0.0F, (f - 1.0F) * (getScrollY() + getPaddingTop() / f) * (1.0F + 0.1F * this.mHighlightFactor.get()));
    }
    paramCanvas.scale(f, f, localBitmap.getWidth() / 2.0F, localBitmap.getHeight() / 2.0F);
    drawPlate(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void drawShadow(Canvas paramCanvas)
  {
    if ((this.mIconShadowDrawable != null) && (this.mDrawShadow))
    {
      paramCanvas.save();
      int i = getWidth();
      int j = this.mIconShadowDrawable.getIntrinsicWidth();
      int k = this.mPlateBitmap.getHeight();
      int m = this.mIconShadowDrawable.getIntrinsicHeight();
      float f = getHotseatScaleFactor();
      paramCanvas.translate((i - j) / 2.0F, (getPaddingTop() + (k - m) / 2) / f);
      i = (int)(this.mShadowAlpha.get() * getAlpha() * 255.0F);
      this.mIconShadowDrawable.setAlpha(i);
      this.mIconShadowDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean fromThisFolder()
  {
    return this.mFromThisFolder;
  }
  
  protected void generateShadowIfNeeded()
  {
    if ((shouldHaveIconShadow()) && (this.mIconShadowDrawable == null) && (this.mPlateBitmap != null))
    {
      localBaseItem = (BaseItem)getTag();
      if (localBaseItem != null)
      {
        if (localBaseItem.mIconShadowBitmap == null) {
          break label49;
        }
        setIconShadow(localBaseItem.mIconShadowBitmap);
      }
    }
    label49:
    while (shouldHaveIconShadow())
    {
      BaseItem localBaseItem;
      return;
      ShadowGen.getInstance().queueBitmap(this.mPlateBitmap, new AppIconView.ShadowReadyCallback(this, localBaseItem), getHandler(), getContext().getResources(), true);
      return;
    }
  }
  
  public long getContainerType()
  {
    return this.mFolderItem.getId();
  }
  
  public Bitmap getDragIcon()
  {
    return getFolderIconWithPlate();
  }
  
  public Bitmap getFolderIconWithPlate()
  {
    FolderItem localFolderItem = (FolderItem)getTag();
    return FolderIconHelper.createFolderIconWithPlate(((BaseItem)localFolderItem).mIconBitmap, localFolderItem);
  }
  
  public FolderItem getFolderItem()
  {
    return this.mFolderItem;
  }
  
  public boolean isAnimating()
  {
    if (this.mHighlightFactor.get() == 1.0F) {}
    while ((this.mLastAttachedFolder != null) && (this.mLastAttachedFolder.mFolderAnimator.isAnimating())) {
      return true;
    }
    return false;
  }
  
  public boolean isContentDragging()
  {
    return this.mDraggedIconId != -2147483648L;
  }
  
  public boolean isEmpty()
  {
    int i = this.mFolderItem.getItemCount();
    return (i == 0) || ((i == 1) && (fromThisFolder()));
  }
  
  public boolean isOpened()
  {
    return this.mFolderItem.isOpened();
  }
  
  public void onAdd(BaseItem paramBaseItem)
  {
    showBadge();
    refresh();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFolderItem.removeListener(this);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    boolean bool2;
    if (Launcher.isInValidDragState(paramDragEvent)) {
      bool2 = false;
    }
    Object localObject;
    label99:
    label104:
    boolean bool1;
    label183:
    label274:
    label324:
    do
    {
      do
      {
        return bool2;
        if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
        {
          if (paramDragEvent.getLocalState() != null)
          {
            localObject = (DragState)paramDragEvent.getLocalState();
            localObject = ((DragState)localObject).getItem();
            if ((localObject == null) || ((((BaseItem)localObject).mType != BaseItem.Type.MENU_APP) && (((BaseItem)localObject).mType != BaseItem.Type.MENU_FOLDER) && (!(localObject instanceof HomePendingItem)))) {
              break label99;
            }
          }
          for (int i = 1;; i = 0)
          {
            if ((Launcher.isHomeEditMode()) || (i != 0)) {
              break label104;
            }
            return false;
            localObject = Launcher.dragstate;
            break;
          }
        }
        localObject = getParent();
        if ((localObject instanceof CellLayoutChildren))
        {
          localObject = ((ViewParent)localObject).getParent();
          if ((localObject instanceof CellLayoutNoGap)) {
            ((CellLayoutNoGap)localObject).onFolderIconViewDragEvent(paramDragEvent, this);
          }
        }
        if (paramDragEvent.getLocalState() == null) {
          break;
        }
        localObject = (DragState)paramDragEvent.getLocalState();
        if ((!acceptDrop((DragState)localObject)) || (((DragState)localObject).getItem().mIconMovie != null)) {
          break label274;
        }
        bool1 = true;
        bool2 = bool1;
      } while (!bool1);
      switch (paramDragEvent.getAction())
      {
      default: 
        return bool1;
      case 1: 
        if (BaseItem.getContainingFolderId(((DragState)localObject).getItem()) == this.mFolderItem.getId()) {}
        for (bool2 = true;; bool2 = false)
        {
          this.mFromThisFolder = bool2;
          return bool1;
          localObject = Launcher.dragstate;
          break;
          bool1 = false;
          break label183;
        }
      case 5: 
        return false;
      case 6: 
        if (this.mFromThisFolder) {
          if (!this.mFolderItem.isOpened()) {
            break label324;
          }
        }
        for (this.mDrawIcon = false;; this.mDrawIcon = true)
        {
          resetPlateIfNeeded((DragState)localObject);
          this.mDraggingOver = false;
          return bool1;
        }
      case 3: 
        if (this.mFromThisFolder) {
          this.mDrawIcon = true;
        }
        paramDragEvent = ((DragState)localObject).getItem();
        ((DragState)localObject).moveItemTo(this, 0, 0, paramDragEvent.getSpanX(), paramDragEvent.getSpanY(), this.mFolderItem.getItemCount());
        resetPlateIfNeeded((DragState)localObject);
        ((DragState)localObject).onDrop();
        this.mDraggingOver = false;
        return bool1;
      case 4: 
        this.mFromThisFolder = false;
        if ((droppedInOurFolder((DragState)localObject)) || (this.mFolderItem.isOpened())) {
          return false;
        }
        if (((DragState)localObject).hasDeleted()) {
          this.mDrawIcon = true;
        }
        resetPlateIfNeeded((DragState)localObject);
        this.mDraggingOver = false;
        return false;
      }
      if ((((Launcher)getContext()).isExitingAllApps()) || (this.mDraggingOver)) {
        return false;
      }
      paramDragEvent = ((DragState)localObject).getFolderParent();
      if (paramDragEvent == null) {
        break;
      }
      bool2 = bool1;
    } while (paramDragEvent.getInfo().isOpened());
    if (this.mFromThisFolder) {
      this.mDrawIcon = false;
    }
    ((CellLayout)getParent().getParent()).clearDragOutlines();
    onDragEnter();
    Talk.INSTANCE.say(((DragState)localObject).getItem().mTitle + ", " + getResources().getString(2131755209));
    if ((this.USE_SET_INTEGRATOR_HAPTIC) && (((Launcher)getContext()).isHapticFeedbackExtraOn())) {
      performHapticFeedback(22111, 1);
    }
    this.mDraggingOver = true;
    return bool1;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    int i = Settings.System.getInt(getContext().getContentResolver(), "pen_hovering", 0);
    int j = Settings.System.getInt(getContext().getContentResolver(), "finger_air_view", 0);
    if ((i == 0) && (j == 0)) {
      return false;
    }
    if (paramMotionEvent.getToolType(0) == 3) {
      return false;
    }
    if (!getResources().getBoolean(2131427333)) {
      return false;
    }
    if ((((Launcher)getContext()).getMenuView().isVisible()) && (((Launcher)getContext()).getMenuView().mMenuViewDarken.getVisibility() == 0)) {
      return false;
    }
    if ((((Launcher)getContext()).getHomeView().isVisible()) && (((Launcher)getContext()).getHomeView().getHomeDarkenLayer().getVisibility() == 0)) {
      return false;
    }
    i = paramMotionEvent.getAction();
    int k = getFolderItem().getItemCount();
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.mFolderAnimator.setFolderHoveringEndTime(0L);
      if ((this.mFolderItem.isOpened()) || (this.mFolderAnimator.isCloseAnimating())) {
        return false;
      }
      this.mFolderHoveringStartTime = System.currentTimeMillis();
      continue;
      long l1 = this.mFolderAnimator.getFolderHoveringEndTime();
      long l2 = System.currentTimeMillis();
      long l3 = this.mFolderHoveringStartTime;
      if ((this.mFolderItem.isOpened()) || (l1 != 0L) || (l2 - l3 <= 300L) || (this.mFolderAnimator.isCloseAnimating()) || (this.mDrawIcon != true) || (this.mFolderAnimator.isHoverAnimating()) || (k > 0)) {}
      try
      {
        PointerIcon.setHoveringSpenIcon(10, -1);
        this.Hover_Refresh_cnt = 0;
        this.mFolderAnimator.animateHoverExpand();
        return true;
        j = k / 7;
        i = j;
        if (k % 7 == 0)
        {
          i = j;
          if (j > 0) {
            i = j - 1;
          }
        }
        if ((k <= 7) || (l2 - l1 <= 2000L) || (i <= this.Hover_Refresh_cnt) || (l1 <= 0L)) {
          continue;
        }
        this.Hover_Refresh_cnt += 1;
        this.mFolderAnimator.FadeInHoverIcon(this.Hover_Refresh_cnt);
      }
      catch (RemoteException paramMotionEvent)
      {
        try
        {
          PointerIcon.setHoveringSpenIcon(1, -1);
          this.mFolderAnimator.animateCloseAnimsEnd(null, false, true);
          this.Hover_Refresh_cnt = 0;
          this.mFolderAnimator.setFolderHoveringEndTime(0L);
          continue;
          paramMotionEvent = paramMotionEvent;
        }
        catch (RemoteException paramMotionEvent)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public void onItemsChanged()
  {
    showBadge();
    refresh();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof CellLayoutChildren))
    {
      localViewParent = localViewParent.getParent();
      boolean bool = false;
      if ((localViewParent instanceof CellLayoutWithResizableWidgets)) {
        bool = ((Launcher)getContext()).getHomeView().getWorkspace().isPageMoving();
      }
      while (bool)
      {
        return true;
        if ((localViewParent instanceof CellLayoutNoGap)) {
          bool = ((Launcher)getContext()).getMenuView().getMenuAppsGrid().isPageMoving();
        }
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onRemove(BaseItem paramBaseItem)
  {
    showBadge();
    refresh();
  }
  
  public void onTitleChanged(String paramString) {}
  
  public boolean redrawFolderIcon()
  {
    BaseItem localBaseItem = (BaseItem)getTag();
    if ((this.mFolderItem == null) || (localBaseItem == null)) {
      return false;
    }
    Bitmap localBitmap = FolderIconHelper.createFolderIconNoPlate(localBaseItem.mIconBitmap, this.mFolderItem, getHiddenIconItem(this.mFolderItem));
    localBaseItem.mIconBitmap = localBitmap;
    this.mFolderItem.setToRedrawIcons(false);
    if (!this.mFolderItem.isOpened()) {
      resetPlateIfNeeded();
    }
    if ((mMenuAppsGridFragment != null) || (((Launcher)getContext()).getMenuView().getViewType() == MenuView.ViewType.ALPHABETIC_LIST)) {
      setIcon(localBitmap, false);
    }
    return true;
  }
  
  public void refresh()
  {
    initBadgeValue();
    redrawFolderIcon();
    invalidate();
  }
  
  public void restoreStateForOpenVisualize()
  {
    this.mDrawIcon = false;
    this.mDrawShadow = false;
  }
  
  public void setBounceItem(boolean paramBoolean)
  {
    this.mHasBounceItem = paramBoolean;
    if (paramBoolean)
    {
      setAlpha(0.5F);
      return;
    }
    setAlpha(1.0F);
  }
  
  public void setDraggedIconId(long paramLong)
  {
    this.mDraggedIconId = paramLong;
  }
  
  public void setFolder(Folder paramFolder)
  {
    this.mLastAttachedFolder = paramFolder;
  }
  
  public void setItemLocation(BaseItem paramBaseItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    paramBaseItem.setPosition(this.mFolderItem.getItemCount());
    if ((paramBaseItem instanceof HomeItem)) {
      LauncherModel.addOrMoveItemInDatabase(getContext(), (HomeItem)paramBaseItem, paramLong, paramBaseItem.getPosition(), 0, 0, paramInt3, paramInt4);
    }
  }
  
  protected boolean shouldHaveIconShadow()
  {
    return false;
  }
  
  public void show(BaseItem paramBaseItem) {}
  
  public void showBadge()
  {
    Object localObject3 = getTag();
    Object localObject1 = null;
    int i = 0;
    int k;
    int j;
    label89:
    Object localObject2;
    if ((localObject3 instanceof AppFolderItem))
    {
      if ((mMenuAppsGridFragment != null) && (mMenuAppsGridFragment.getState() == MenuAppsGrid.State.EDIT)) {}
      do
      {
        return;
        localObject1 = (AppFolderItem)localObject3;
        i = 0;
        k = ((AppFolderItem)localObject1).getItemCount();
        j = 0;
        while (j < k)
        {
          i += ((AppItem)((AppFolderItem)localObject1).getItemAt(j)).mBadgeCount;
          j += 1;
        }
        localObject1 = createBadgeDrawable(i);
        if ((isDimmed()) && ((!CellLayout.isItemApp()) || (!sIsDragState)))
        {
          localObject2 = createDarkenColorFilter(this.mDimAmount);
          if (localObject1 != null) {
            ((Drawable)localObject1).setColorFilter((ColorFilter)localObject2);
          }
        }
        setOverlay((Drawable)localObject1);
      } while ((localObject3 == null) || (!(localObject3 instanceof BaseItem)));
      localObject3 = (BaseItem)localObject3;
      localObject2 = ((BaseItem)localObject3).mTitle;
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
        break label508;
      }
      localObject1 = getResources().getString(2131755113);
      label187:
      if ((((BaseItem)localObject3).mType != BaseItem.Type.MENU_FOLDER) && (((BaseItem)localObject3).mType != BaseItem.Type.HOME_FOLDER)) {
        break label632;
      }
      if (i <= 1) {
        break label634;
      }
      localObject1 = (String)localObject1 + ", " + String.format(getResources().getString(2131755217), new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (BaseItem.isItemInFolder((BaseItem)localObject3)) {
        localObject2 = (String)localObject1 + ", " + getResources().getString(2131755209);
      }
      setContentDescription((CharSequence)localObject2);
      return;
      if (!(localObject3 instanceof HomeFolderItem)) {
        break label89;
      }
      Object localObject4 = (HomeFolderItem)localObject3;
      ArrayList localArrayList = new ArrayList();
      i = 0;
      BaseItem localBaseItem = getHiddenIconItem((FolderItem)localObject4);
      j = 0;
      for (;;)
      {
        localObject2 = null;
        if (j >= ((HomeFolderItem)localObject4).getItemCount()) {
          break;
        }
        if (((HomeFolderItem)localObject4).getItemAt(j).mType != BaseItem.Type.HOME_APPLICATION)
        {
          localObject1 = localObject2;
          if (((HomeFolderItem)localObject4).getItemAt(j).mType != BaseItem.Type.HOME_SHORTCUT) {}
        }
        else
        {
          Intent localIntent = ((HomeShortcutItem)((HomeFolderItem)localObject4).getItemAt(j)).intent;
          localObject1 = localObject2;
          if (localIntent != null) {
            localObject1 = localIntent.getComponent();
          }
        }
        k = i;
        if (localObject1 != null)
        {
          k = i;
          if (!localArrayList.contains(((ComponentName)localObject1).toString()))
          {
            k = i;
            if (((HomeFolderItem)localObject4).getItemAt(j) != localBaseItem)
            {
              k = i + ((HomeFolderItem)localObject4).getItemAt(j).mBadgeCount;
              localArrayList.add(((ComponentName)localObject1).toString());
            }
          }
        }
        j += 1;
        i = k;
      }
      localObject1 = createBadgeDrawable(i);
      break label89;
      label508:
      localObject4 = getResources().getString(2131755114);
      j = ((String)localObject4).length();
      k = ((String)localObject2).length();
      if (k >= j)
      {
        localObject1 = localObject2;
        if (((String)localObject2).substring(k - j).equalsIgnoreCase((String)localObject4)) {
          break label187;
        }
      }
      if (Locale.getDefault().toString().contains("fr"))
      {
        localObject1 = ((String)localObject4).concat(" " + (String)localObject2);
        break label187;
      }
      localObject1 = ((String)localObject2).concat(" " + (String)localObject4);
      break label187;
      label632:
      break;
      label634:
      if (((BaseItem)localObject3).mBadgeCount == 1) {
        localObject1 = (String)localObject1 + ", " + String.format(getResources().getString(2131755218), new Object[0]);
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FolderIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */