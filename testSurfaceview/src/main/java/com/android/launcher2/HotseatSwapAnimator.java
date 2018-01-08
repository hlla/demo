package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

class HotseatSwapAnimator
  implements View.OnDragListener
{
  final int kFolderScaleDuration = 100;
  final int kIconFastFadeInDuration = 100;
  final int kIconFastFadeOutDuration = 100;
  final int kIconSlowFadeInDuration = 500;
  final int kIconSlowFadeOutDuration = 500;
  private AnimationLayer.Anim mAnimInfo;
  private final CellLayoutChildren mChildren;
  private boolean mDisabled = true;
  private final int[] mDragCell = new int[2];
  private FolderIconView mDragOverFolderIcon;
  private boolean mDropped = false;
  private final Hotseat mHotseat;
  private View mHotseatSwapIcon;
  private final Launcher mLauncher;
  private final CellLayout mLayout;
  Runnable mOnAnimationCancel = new Runnable()
  {
    public void run()
    {
      HotseatSwapAnimator.access$002(HotseatSwapAnimator.this, null);
    }
  };
  private Folder mSwapFolder;
  
  public HotseatSwapAnimator(Hotseat paramHotseat, CellLayout paramCellLayout)
  {
    this.mHotseat = paramHotseat;
    this.mLayout = paramCellLayout;
    this.mChildren = paramCellLayout.getChildrenLayout();
    this.mLauncher = ((Launcher)paramHotseat.getContext());
  }
  
  private void animateMoveFade(DragState paramDragState)
  {
    if ((paramDragState.getView() == null) || (paramDragState.mUnderdragView == null)) {}
    Workspace localWorkspace;
    AnimationLayer localAnimationLayer;
    Bitmap localBitmap;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    do
    {
      do
      {
        do
        {
          return;
          localWorkspace = getWorkspaceParent(paramDragState.getView());
        } while (localWorkspace == null);
        animateOverlayIconBack(paramDragState);
      } while ((!isAppIcon(paramDragState.mUnderdragView)) || ((paramDragState.getItem().mType != BaseItem.Type.HOME_FOLDER) && ((paramDragState.mUnderdragView instanceof FolderIconView))));
      localAnimationLayer = this.mLauncher.getAnimationLayer();
      localBitmap = ((AppIconView)paramDragState.mUnderdragView).getDragIcon();
      arrayOfInt1 = localAnimationLayer.getLocationOfView(paramDragState.mUnderdragView, localBitmap, null);
      arrayOfInt2 = localAnimationLayer.getLocationOfView(paramDragState.getView(), localBitmap, null, true);
      int i = ((AppIconView)paramDragState.mUnderdragView).getPaddingTop();
      arrayOfInt2[1] = ((int)(arrayOfInt2[1] + i * 0.8F));
    } while (localWorkspace.getChildCount() <= 0);
    if (this.mAnimInfo != null) {
      throw new IllegalStateException("We already have an mAnimInfo!");
    }
    paramDragState = (AppIconView)paramDragState.getView();
    this.mAnimInfo = localAnimationLayer.animateIcon(paramDragState.getAnimGroup(), this.mOnAnimationCancel, paramDragState, localBitmap, arrayOfInt1, arrayOfInt2, true, 320, false);
    this.mAnimInfo.getIcon().setScaleX(0.8F);
    this.mAnimInfo.getIcon().setScaleY(0.8F);
  }
  
  private void animateOverlayIconBack(DragState paramDragState)
  {
    if (this.mAnimInfo != null)
    {
      if ((this.mAnimInfo.isCompleted()) || (this.mAnimInfo.mAnimIcon == null) || (this.mAnimInfo.getFrom() == null)) {
        this.mAnimInfo = null;
      }
    }
    else {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mAnimInfo, "alpha", new float[] { 1.0F, 0.0F });
    final Object localObject = new OverlayFadeAdapter(this.mAnimInfo, this.mAnimInfo.getIcon(), this.mAnimInfo.getTo(), this.mAnimInfo.getFrom());
    localObjectAnimator.setDuration(120L);
    localObjectAnimator.addListener((Animator.AnimatorListener)localObject);
    int i;
    if ((paramDragState.mUnderdragView != null) && (paramDragState.getItem().mType != BaseItem.Type.HOME_FOLDER) && ((paramDragState.mUnderdragView instanceof FolderIconView)))
    {
      i = 1;
      if ((!this.mAnimInfo.isAnimating()) || (i != 0)) {
        break label181;
      }
      localObjectAnimator.start();
    }
    for (;;)
    {
      this.mAnimInfo = null;
      return;
      i = 0;
      break;
      label181:
      float f1 = this.mAnimInfo.getTo()[0] - this.mAnimInfo.getFrom()[0];
      float f2 = this.mAnimInfo.getTo()[1] - this.mAnimInfo.getFrom()[1];
      paramDragState = ValueAnimator.ofFloat(new float[] { 0.1F, 0.1F + 70.0F / (float)Math.sqrt(f1 * f1 + f2 * f2) });
      paramDragState.setDuration(120L);
      paramDragState.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
      localObject = this.mAnimInfo;
      paramDragState = AnimationLayer.createAnimatorTogetherSet(localObjectAnimator, paramDragState);
      paramDragState.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          HotseatSwapAnimator.this.mLauncher.getAnimationLayer().removeView(localObject.getIcon());
          localObject.markCompleted();
        }
      });
      paramDragState.start();
    }
  }
  
  public static HotseatSwapAnimator create(Hotseat paramHotseat, CellLayout paramCellLayout)
  {
    paramHotseat = new HotseatSwapAnimator(paramHotseat, paramCellLayout);
    paramCellLayout.setOnDragListener(paramHotseat);
    return paramHotseat;
  }
  
  private void displaySwapItemOverFolder(DragState paramDragState, View paramView)
  {
    paramView = (BaseItem)paramView.getTag();
    removeFolderOverlay();
    if ((paramView == null) || (paramView.mIconBitmap == null)) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          paramDragState = paramDragState.getFolderParent();
        } while (paramDragState == null);
        localView = paramDragState.getIconView();
      } while (localView == null);
      if (paramView.mType == BaseItem.Type.HOME_FOLDER)
      {
        scaleAnimate(localView, 1.0F);
        return;
      }
    } while (!localView.getLocalVisibleRect(new Rect()));
    paramDragState.beginHotseatSwapAnimation(paramView);
    this.mSwapFolder = paramDragState;
  }
  
  static void fadeAnimate(View paramView, float paramFloat, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setLayerType(2, Launcher.sViewLayerPaint);
      paramView.animate().alpha(paramFloat).setDuration(paramInt).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.val$v.setLayerType(0, Launcher.sViewLayerPaint);
        }
      }).start();
    }
  }
  
  private void fadeOutAndRemoveOverlayIcon(DragState paramDragState)
  {
    if ((this.mAnimInfo != null) && (this.mAnimInfo.getIcon() != null)) {
      this.mAnimInfo.getIcon().animate().scaleX(1.0F).scaleY(1.0F).alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (HotseatSwapAnimator.this.mAnimInfo != null)
          {
            HotseatSwapAnimator.this.mLauncher.getAnimationLayer().removeView(HotseatSwapAnimator.this.mAnimInfo.getIcon());
            HotseatSwapAnimator.this.mAnimInfo.markCompleted();
            HotseatSwapAnimator.access$002(HotseatSwapAnimator.this, null);
          }
        }
      });
    }
  }
  
  private CellLayout getCellLayoutParent(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = paramView.getParent()) {
      if ((paramView instanceof CellLayout)) {
        return (CellLayout)paramView;
      }
    }
    return null;
  }
  
  private Workspace getWorkspaceParent(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = paramView.getParent()) {
      if ((paramView instanceof Workspace)) {
        return (Workspace)paramView;
      }
    }
    return null;
  }
  
  private boolean handleDragOverViewDrop(DragState paramDragState)
  {
    this.mDropped = true;
    View localView = this.mChildren.getChildAt(this.mDragCell[0], this.mDragCell[1]);
    if (localView != null) {
      removeFolderOverlay((BaseItem)localView.getTag());
    }
    if (paramDragState.mUnderdragView != null)
    {
      fadeAnimate(paramDragState.mUnderdragView, 1.0F, 200);
      paramDragState.mUnderdragView = null;
    }
    paramDragState = this.mLauncher.getAnimationLayer();
    if ((paramDragState != null) && (this.mAnimInfo != null) && (this.mAnimInfo.getIcon() != null)) {
      paramDragState.removeView(this.mAnimInfo.getIcon());
    }
    hideHotseatSwapIcon(true);
    return false;
  }
  
  private void handleDragOverViewEnded(DragState paramDragState)
  {
    AnimationLayer localAnimationLayer = this.mLauncher.getAnimationLayer();
    if ((this.mLayout.mDragging) && (!this.mDropped))
    {
      if (paramDragState.getView() != null) {
        paramDragState.getView().setAlpha(1.0F);
      }
      if (paramDragState.mUnderdragView != null)
      {
        paramDragState.mUnderdragView.animate().cancel();
        paramDragState.mUnderdragView.setAlpha(1.0F);
      }
      if ((localAnimationLayer != null) && (this.mAnimInfo != null) && (this.mAnimInfo.getIcon() != null)) {
        localAnimationLayer.removeView(this.mAnimInfo.getIcon());
      }
      if (this.mHotseatSwapIcon != null)
      {
        this.mChildren.removeView(this.mHotseatSwapIcon);
        this.mHotseatSwapIcon = null;
      }
    }
    paramDragState = paramDragState.getFolderParent();
    if (paramDragState != null) {
      scaleAnimate(paramDragState.getIconView(), 1.0F);
    }
    if (this.mDragOverFolderIcon != null)
    {
      this.mDragOverFolderIcon.mIgnoreSetAlphaOnDragExit = false;
      fadeAnimate(this.mDragOverFolderIcon, 1.0F, 200);
      this.mDragOverFolderIcon = null;
    }
    removeFolderOverlay();
    this.mDropped = false;
  }
  
  private void handleDragOverViewExit(DragState paramDragState)
  {
    if (paramDragState.mUnderdragView != null) {
      fadeAnimate(paramDragState.mUnderdragView, 1.0F, 500);
    }
    paramDragState.mUnderdragView = null;
    paramDragState = paramDragState.getFolderParent();
    if (paramDragState != null) {
      scaleAnimate(paramDragState.getIconView(), 1.0F);
    }
    removeFolderOverlay();
    hideHotseatSwapIcon(true);
  }
  
  private void handleDragOverViewMove(DragState paramDragState)
  {
    Object localObject2 = this.mChildren.getChildAt(this.mDragCell[0], this.mDragCell[1]);
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      if (((View)localObject2).getTag() != null)
      {
        localObject1 = localObject2;
        if (((View)localObject2).getTag() != paramDragState.getItem()) {}
      }
      else
      {
        localObject1 = null;
      }
    }
    int i;
    if ((localObject1 != null) && (paramDragState.getItem().mType != BaseItem.Type.HOME_FOLDER) && ((localObject1 instanceof FolderIconView)))
    {
      i = 1;
      if (i != 0)
      {
        localObject2 = (FolderIconView)localObject1;
        ((FolderIconView)localObject2).mIgnoreSetAlphaOnDragExit = true;
        if ((localObject2 != this.mDragOverFolderIcon) && (this.mDragOverFolderIcon != null)) {
          this.mDragOverFolderIcon.mIgnoreSetAlphaOnDragExit = false;
        }
        this.mDragOverFolderIcon = ((FolderIconView)localObject2);
        hideHotseatSwapIcon(true);
      }
      if (localObject1 != null) {
        break label195;
      }
      if (paramDragState.mUnderdragView != null)
      {
        fadeAnimate(paramDragState.mUnderdragView, 1.0F, 500);
        localObject2 = paramDragState.getFolderParent();
        if (localObject2 != null) {
          scaleAnimate(((Folder)localObject2).getIconView(), 1.0F);
        }
        removeFolderOverlay();
      }
      hideHotseatSwapIcon(true);
    }
    label195:
    label244:
    do
    {
      for (;;)
      {
        paramDragState.mUnderdragView = ((View)localObject1);
        return;
        i = 0;
        break;
        if (paramDragState.mUnderdragView != null) {
          break label244;
        }
        if ((isAppIcon((View)localObject1)) && (i == 0))
        {
          fadeAnimate((View)localObject1, 0.0F, 500);
          showHotseatSwapIcon(paramDragState, (View)localObject1);
        }
        if (paramDragState.getFolderParent() != null) {
          displaySwapItemOverFolder(paramDragState, (View)localObject1);
        }
      }
    } while (paramDragState.mUnderdragView == localObject1);
    if ((isAppIcon((View)localObject1)) && (i == 0))
    {
      fadeAnimate((View)localObject1, 0.0F, 500);
      showHotseatSwapIcon(paramDragState, (View)localObject1);
      label278:
      if ((!isAppIcon((View)localObject1)) || (isAppIcon(paramDragState.mUnderdragView))) {
        break label347;
      }
    }
    for (;;)
    {
      fadeAnimate(paramDragState.mUnderdragView, 1.0F, 500);
      displaySwapItemOverFolder(paramDragState, (View)localObject1);
      break;
      if ((isAppIcon((View)localObject1)) && (!(localObject1 instanceof ImageView)) && (((View)localObject1).getTag() != null)) {
        break label278;
      }
      hideHotseatSwapIcon(true);
      break label278;
      label347:
      if ((!isAppIcon((View)localObject1)) && (isAppIcon(paramDragState.mUnderdragView)))
      {
        localObject2 = paramDragState.getFolderParent();
        if (localObject2 != null) {
          scaleAnimate(((Folder)localObject2).getIconView(), 1.0F);
        }
      }
    }
  }
  
  private void hideHotseatSwapIcon(boolean paramBoolean)
  {
    if (this.mHotseatSwapIcon == null) {
      return;
    }
    if (paramBoolean)
    {
      final View localView = this.mHotseatSwapIcon;
      localView.setLayerType(2, Launcher.sViewLayerPaint);
      localView.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          HotseatSwapAnimator.this.mChildren.removeView(localView);
        }
      }).start();
    }
    for (;;)
    {
      this.mHotseatSwapIcon = null;
      return;
      this.mChildren.removeView(this.mHotseatSwapIcon);
    }
  }
  
  private boolean isAppIcon(View paramView)
  {
    return (paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof BaseItem));
  }
  
  private void removeFolderOverlay()
  {
    if (this.mSwapFolder == null) {
      return;
    }
    this.mSwapFolder.cancelHotseatSwapAnimation();
    this.mSwapFolder = null;
  }
  
  private void removeFolderOverlay(BaseItem paramBaseItem)
  {
    if (this.mSwapFolder == null) {
      return;
    }
    this.mSwapFolder.finishHotseatSwapAnimation(paramBaseItem);
    this.mSwapFolder = null;
  }
  
  private ViewPropertyAnimator scaleAnimate(View paramView, float paramFloat)
  {
    if (paramView != null) {
      return paramView.animate().scaleX(paramFloat).scaleY(paramFloat).setDuration(100L);
    }
    return null;
  }
  
  private void showHotseatSwapIcon(DragState paramDragState, View paramView)
  {
    if (paramDragState.getFolderParent() != null) {}
    do
    {
      return;
      localObject = (BaseItem)paramView.getTag();
    } while ((localObject == null) || (((BaseItem)localObject).mIconBitmap == null) || (paramDragState.getItem() == localObject) || (!hasHotSeatAncestor(paramDragState.getItem())));
    paramDragState = (HomeItem)paramDragState.getItem();
    hideHotseatSwapIcon(true);
    if (this.mHotseatSwapIcon != null) {
      this.mChildren.removeView(this.mHotseatSwapIcon);
    }
    final Object localObject = (AppIconView)this.mLauncher.mHomeView.createShortcut((HomeShortcutItem)localObject, 2130903087);
    ((AppIconView)localObject).setTextVisible(((AppIconView)paramView).getTextVisible());
    ((AppIconView)localObject).setTag(null);
    paramDragState = new CellLayout.LayoutParams(paramDragState.cellX, paramDragState.cellY, paramDragState.spanX, paramDragState.spanY);
    this.mLayout.addViewToCellLayout((View)localObject, this.mChildren.getChildCount(), 0, paramDragState, false);
    this.mHotseatSwapIcon = ((View)localObject);
    ((AppIconView)localObject).setLayerType(2, Launcher.sViewLayerPaint);
    ((AppIconView)localObject).setAlpha(0.0F);
    ((AppIconView)localObject).animate().alpha(1.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localObject.setLayerType(0, Launcher.sViewLayerPaint);
      }
    }).start();
  }
  
  boolean hasHotSeatAncestor(BaseItem paramBaseItem)
  {
    if (!(paramBaseItem instanceof HomeItem)) {}
    while (((HomeItem)paramBaseItem).container != -101L) {
      return false;
    }
    return true;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    boolean bool;
    if (paramDragEvent.getAction() == 5)
    {
      if (!((CellLayoutHotseat)this.mLayout).isFull())
      {
        bool = true;
        this.mDisabled = bool;
      }
    }
    else {
      if (!this.mDisabled) {
        break label45;
      }
    }
    label45:
    label79:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
      } while ((Launcher.isInValidDragState(paramDragEvent)) || ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (!Launcher.isHomeEditMode())));
      if (paramDragEvent.getLocalState() == null) {
        break label330;
      }
      paramView = (DragState)paramDragEvent.getLocalState();
      localObject = paramView.getItem();
    } while ((((BaseItem)localObject).mIconMovie != null) || (paramView.mDragOrigin == null) || ((localObject instanceof HomePendingItem)));
    switch (localObject.mType)
    {
    default: 
      return false;
    }
    int i = this.mDragCell[0];
    int j = this.mDragCell[1];
    this.mLayout.pointToCellExact((int)paramDragEvent.getX(), (int)paramDragEvent.getY(), this.mDragCell);
    Object localObject = paramView.getFolderParent();
    switch (paramDragEvent.getAction())
    {
    case 1: 
    default: 
      return false;
    case 2: 
      handleDragOverViewMove(paramView);
      if ((paramView.mUnderdragView != null) && (isAppIcon(paramView.mUnderdragView))) {
        if (((paramView.mUnderdragView instanceof FolderIconView)) && (!(paramView.getView() instanceof FolderIconView))) {
          this.mLayout.clearDragOutlines();
        }
      }
    case 5: 
      while ((i != this.mDragCell[0]) || (j != this.mDragCell[1]) || (this.mAnimInfo == null))
      {
        if (paramView.mUnderdragView != null) {
          break label397;
        }
        animateOverlayIconBack(paramView);
        return false;
        paramView = Launcher.dragstate;
        break label79;
        if (localObject == null) {
          break;
        }
        ((Folder)localObject).ignoreShrinkingFolder();
        ((Folder)localObject).close(false, true);
        return false;
        this.mLayout.visualizeDropLocation(paramView.mUnderdragView, this.mHotseat.getDragOutline(paramView.getView()), this.mDragCell, 1, 1);
        continue;
        this.mLayout.clearDragOutlines();
      }
      animateMoveFade(paramView);
      return false;
    case 6: 
      handleDragOverViewExit(paramView);
      animateOverlayIconBack(paramView);
      return false;
    case 3: 
      label330:
      label397:
      fadeOutAndRemoveOverlayIcon(paramView);
      return handleDragOverViewDrop(paramView);
    }
    handleDragOverViewEnded(paramView);
    animateOverlayIconBack(paramView);
    return false;
  }
  
  class OverlayFadeAdapter
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private final AnimationLayer.Anim mAnim;
    private float mDx;
    private float mDy;
    private int[] mFrom;
    private View mView;
    
    OverlayFadeAdapter(AnimationLayer.Anim paramAnim, View paramView, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.mAnim = paramAnim;
      this.mView = paramView;
      this.mFrom = paramArrayOfInt1;
      this.mDx = (paramArrayOfInt2[0] - paramArrayOfInt1[0]);
      this.mDy = (paramArrayOfInt2[1] - paramArrayOfInt1[1]);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      HotseatSwapAnimator.this.mLauncher.getAnimationLayer().removeView(this.mView);
      this.mAnim.markCompleted();
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.mView.setTranslationX(this.mFrom[0] + this.mDx * f);
      this.mView.setTranslationY(this.mFrom[1] + this.mDy * f);
      paramValueAnimator = HotseatSwapAnimator.this.mLauncher.getAnimationLayer();
      this.mView.invalidate();
      paramValueAnimator.invalidate();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HotseatSwapAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */