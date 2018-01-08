package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DeltaVisualizer
{
  private static final boolean DEBUG = false;
  private final List<Runnable> mAnimLayerPendingRunnables = new ArrayList();
  private boolean mBlockTransform = false;
  private final IdentityHashMap<BaseItem, PositionDelta> mLastDeltas = new IdentityHashMap();
  private final CellLayout mLayout;
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private final List<BaseItem> tmpRemove = new ArrayList();
  
  DeltaVisualizer(CellLayout paramCellLayout)
  {
    this.mLayout = paramCellLayout;
  }
  
  private void animateDelta(final PositionDelta paramPositionDelta)
  {
    if (paramPositionDelta.item == null) {}
    final Launcher localLauncher;
    final AnimationLayer localAnimationLayer;
    final View localView;
    do
    {
      do
      {
        return;
        localLauncher = (Launcher)this.mLayout.getContext();
      } while ((localLauncher.isTransitioningToShowAllApps()) || (localLauncher.mHomeView.getWorkspace().isAnimating()) || (localLauncher.mHomeView.getWorkspace().getState() == Workspace.State.NORMAL) || ((this.mLastDeltas.containsKey(paramPositionDelta.item)) && (!((PositionDelta)this.mLastDeltas.get(paramPositionDelta.item)).differentFrom(paramPositionDelta))));
      localAnimationLayer = localLauncher.getAnimationLayer();
      localView = this.mLayout.getViewForItem(paramPositionDelta.item);
    } while (localView == null);
    final boolean bool = updateViewForSpan(localView, paramPositionDelta.getSpanX(), paramPositionDelta.getSpanY());
    this.mLayout.onPreDeltaVisualize(localView, paramPositionDelta.item);
    paramPositionDelta = new Runnable()
    {
      public void run()
      {
        DeltaVisualizer.this.mAnimLayerPendingRunnables.remove(this);
        if ((localLauncher != null) && (localLauncher.mHomeView != null) && ((localLauncher.isTransitioningToShowAllApps()) || (localLauncher.mHomeView.getWorkspace().isAnimating()) || (localLauncher.mHomeView.getWorkspace().getState() == Workspace.State.NORMAL))) {
          return;
        }
        Object localObject2 = localAnimationLayer.findExistingAnimation(localView);
        Object localObject1;
        int[] arrayOfInt;
        if ((bool) || (localObject2 == null))
        {
          localObject1 = DeltaVisualizer.this.getBitmapForAnim(paramPositionDelta.item, localView);
          arrayOfInt = localAnimationLayer.getLocationFromCellPos(paramPositionDelta.getX(), paramPositionDelta.getY(), DeltaVisualizer.this.mLayout, localView, (Bitmap)localObject1);
          DeltaVisualizer.access$402(DeltaVisualizer.this, true);
          if (localObject2 == null) {
            break label258;
          }
          ((AnimationLayer.Anim)localObject2).update(arrayOfInt, 100, false);
          DeltaVisualizer.this.removeAllListeners((AnimationLayer.Anim)localObject2);
          DeltaVisualizer.access$402(DeltaVisualizer.this, false);
          DeltaVisualizer.this.positioningListener((AnimationLayer.Anim)localObject2, localView);
          DeltaVisualizer.this.bounceOnEndListener((AnimationLayer.Anim)localObject2, localView);
          if (bool) {
            ((AnimationLayer.Anim)localObject2).updateBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          DeltaVisualizer.this.mLastDeltas.put(paramPositionDelta.item, paramPositionDelta);
          return;
          localObject1 = ((AnimationLayer.Anim)localObject2).getBitmap();
          break;
          label258:
          localObject2 = localAnimationLayer.getLocationOfView(localView, (Bitmap)localObject1, null);
          DeltaVisualizer.AnimLayerPendingRunnable localAnimLayerPendingRunnable = new DeltaVisualizer.AnimLayerPendingRunnable(DeltaVisualizer.this, localView);
          localObject1 = localAnimationLayer.buildBasicAnim(0, localAnimLayerPendingRunnable, localView, (Bitmap)localObject1, -1);
          DeltaVisualizer.this.positioningListener((AnimationLayer.Anim)localObject1, localView);
          DeltaVisualizer.this.bounceOnEndListener((AnimationLayer.Anim)localObject1, localView);
          ((AnimationLayer.Anim)localObject1).setTo(arrayOfInt);
          ((AnimationLayer.Anim)localObject1).setFrom((int[])localObject2);
          localView.setVisibility(4);
          ((AnimationLayer.Anim)localObject1).getAnimator().setDuration(200L);
          ((AnimationLayer.Anim)localObject1).getAnimator().start();
        }
      }
    };
    this.mAnimLayerPendingRunnables.add(paramPositionDelta);
    this.mMainHandler.post(paramPositionDelta);
  }
  
  private void bounceListner(final AnimationLayer.Anim paramAnim, View paramView)
  {
    final ValueAnimator localValueAnimator = (ValueAnimator)paramAnim.getAnimator();
    final AnimationLayer localAnimationLayer = ((Launcher)this.mLayout.getContext()).getAnimationLayer();
    final int[] arrayOfInt = paramAnim.getFrom();
    final ImageView localImageView = paramAnim.getIcon();
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (DeltaVisualizer.this.mBlockTransform) {
          return;
        }
        int[] arrayOfInt = paramAnim.getTo();
        float f3 = arrayOfInt[0] - arrayOfInt[0];
        float f1 = arrayOfInt[1] - arrayOfInt[1];
        float f2 = (float)Math.sqrt(f3 * f3 + f1 * f1);
        if (f3 != 0.0F) {
          f3 /= f2;
        }
        if (f1 != 0.0F) {
          f1 /= f2;
        }
        f1 = (0.5F - Math.abs(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() - 0.5F)) * 2.0F;
        f2 = this.val$viewParent.getScaleX();
        f3 = this.val$viewParent.getScaleY();
        localImageView.setScaleX(f2 + 0.03F * f1);
        localImageView.setScaleY(f3 + 0.03F * f1);
        localAnimationLayer.invalidate(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0], arrayOfInt[1]);
      }
    });
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setDuration(450L);
    paramView.post(new Runnable()
    {
      public void run()
      {
        localValueAnimator.start();
      }
    });
  }
  
  private void bounceOnEndListener(final AnimationLayer.Anim paramAnim, final View paramView)
  {
    ((ValueAnimator)paramAnim.getAnimator()).setRepeatCount(0);
    ((ValueAnimator)paramAnim.getAnimator()).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        DeltaVisualizer.this.removeAllListeners(paramAnim);
        DeltaVisualizer.this.bounceListner(paramAnim, paramView);
      }
    });
  }
  
  private void finishOnEndListener(final AnimationLayer.Anim paramAnim, final View paramView)
  {
    ((ValueAnimator)paramAnim.getAnimator()).setRepeatCount(0);
    ((ValueAnimator)paramAnim.getAnimator()).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
        if ((paramView instanceof AppIconView)) {
          ((AppIconView)paramView).mDrawIcon = true;
        }
        paramAnim.markCompleted();
      }
    });
  }
  
  private Bitmap getBitmapForAnim(BaseItem paramBaseItem, View paramView)
  {
    if ((paramView instanceof SurfaceWidgetView)) {
      return ((SurfaceWidgetView)paramView).getBitmap();
    }
    if (((paramView instanceof FolderIconView)) && (((FolderIconView)paramView).isContentDragging())) {
      ((FolderIconView)paramView).redrawFolderIcon();
    }
    Bitmap localBitmap2 = paramView.getDrawingCache();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      paramView.buildDrawingCache();
      localBitmap1 = paramView.getDrawingCache();
    }
    if (localBitmap1 == null) {
      return paramBaseItem.mIconBitmap;
    }
    paramBaseItem = Bitmap.createBitmap(localBitmap1);
    paramView.destroyDrawingCache();
    return paramBaseItem;
  }
  
  private void positioningListener(final AnimationLayer.Anim paramAnim, View paramView)
  {
    final AnimationLayer localAnimationLayer = ((Launcher)this.mLayout.getContext()).getAnimationLayer();
    final ImageView localImageView = paramAnim.getIcon();
    paramView = (View)paramView.getParent().getParent();
    localImageView.setScaleX(paramView.getScaleX());
    localImageView.setScaleY(paramView.getScaleY());
    ((ValueAnimator)paramAnim.getAnimator()).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int[] arrayOfInt1 = paramAnim.getTo();
        int[] arrayOfInt2 = paramAnim.getFrom();
        float f1 = arrayOfInt1[0] - arrayOfInt2[0];
        float f2 = arrayOfInt1[1] - arrayOfInt2[1];
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f4 = arrayOfInt2[0];
        float f5 = arrayOfInt2[1];
        localImageView.setTranslationX(f4 + f1 * f3);
        localImageView.setTranslationY(f5 + f2 * f3);
        localAnimationLayer.invalidate(arrayOfInt2[0], arrayOfInt2[1], arrayOfInt1[0], arrayOfInt1[1]);
      }
    });
  }
  
  private void removeAllListeners(AnimationLayer.Anim paramAnim)
  {
    if ((paramAnim.getAnimator() instanceof ValueAnimator))
    {
      paramAnim = (ValueAnimator)paramAnim.getAnimator();
      paramAnim.removeAllListeners();
      paramAnim.removeAllUpdateListeners();
    }
    this.mBlockTransform = false;
  }
  
  private void resetItem(BaseItem paramBaseItem)
  {
    Object localObject = ((Launcher)this.mLayout.getContext()).getAnimationLayer();
    View localView = this.mLayout.getViewForItem(paramBaseItem);
    updateViewForSpan(localView, paramBaseItem.getSpanX(), paramBaseItem.getSpanY());
    this.mBlockTransform = true;
    localObject = ((AnimationLayer)localObject).updateExistingAnimationTo(localView, null, 300, false);
    if (localObject != null)
    {
      removeAllListeners((AnimationLayer.Anim)localObject);
      positioningListener((AnimationLayer.Anim)localObject, localView);
      finishOnEndListener((AnimationLayer.Anim)localObject, localView);
      ((AnimationLayer.Anim)localObject).getAnimator().setDuration(200L);
      ((AnimationLayer.Anim)localObject).getAnimator().start();
      ((AnimationLayer.Anim)localObject).updateBitmap(getBitmapForAnim(paramBaseItem, localView));
      return;
    }
    localView.setVisibility(0);
  }
  
  private boolean updateViewForSpan(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    CellLayout.LayoutParams localLayoutParams;
    if (!(paramView instanceof SurfaceWidgetView))
    {
      bool1 = bool2;
      if (!(paramView instanceof LauncherAppWidgetHostView)) {}
    }
    else
    {
      localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.cellHSpan = paramInt1;
      localLayoutParams.cellVSpan = paramInt2;
      this.mLayout.mChildren.setupLp(localLayoutParams);
      if (localLayoutParams.width == paramView.getWidth())
      {
        bool1 = bool2;
        if (localLayoutParams.height == paramView.getHeight()) {}
      }
      else
      {
        bool1 = true;
        if (!(paramView instanceof SurfaceWidgetView)) {
          break label148;
        }
        ((SurfaceWidgetView)paramView).resizeSurfaceWidgetView(localLayoutParams.width, localLayoutParams.height);
      }
    }
    for (;;)
    {
      paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getLeft() + localLayoutParams.width, paramView.getTop() + localLayoutParams.height);
      paramView.invalidate();
      return bool1;
      label148:
      if ((paramView instanceof LauncherAppWidgetHostView))
      {
        ((LauncherApplication)this.mLayout.getContext().getApplicationContext()).getSpanCalculator().updateWidgetSizeRanges((AppWidgetHostView)paramView, (Launcher)this.mLayout.getContext(), localLayoutParams.cellHSpan, localLayoutParams.cellVSpan);
        ((Workspace)this.mLayout.getParent()).sendWidgetResizeIntent(localLayoutParams.cellHSpan, localLayoutParams.cellVSpan, ((LauncherAppWidgetHostView)paramView).getAppWidgetInfo().provider, ((HomeWidgetItem)paramView.getTag()).appWidgetId);
      }
    }
  }
  
  public void reset()
  {
    Iterator localIterator = this.mLastDeltas.keySet().iterator();
    while (localIterator.hasNext()) {
      resetItem((BaseItem)localIterator.next());
    }
    this.mLastDeltas.clear();
    if (!this.mAnimLayerPendingRunnables.isEmpty())
    {
      localIterator = this.mAnimLayerPendingRunnables.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        this.mMainHandler.removeCallbacks(localRunnable);
      }
      this.mAnimLayerPendingRunnables.clear();
    }
  }
  
  public void updateForDeltas(List<PositionDelta> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (PositionDelta)paramList.next();
      if (((PositionDelta)localObject).changed())
      {
        animateDelta((PositionDelta)localObject);
      }
      else if (this.mLastDeltas.containsKey(((PositionDelta)localObject).item))
      {
        resetItem(((PositionDelta)localObject).item);
        this.tmpRemove.add(((PositionDelta)localObject).item);
      }
    }
    paramList = this.tmpRemove.iterator();
    while (paramList.hasNext())
    {
      localObject = (BaseItem)paramList.next();
      this.mLastDeltas.remove(localObject);
    }
    this.tmpRemove.clear();
  }
  
  private class AnimLayerPendingRunnable
    implements Runnable
  {
    private WeakReference<View> mView;
    
    public AnimLayerPendingRunnable(View paramView)
    {
      this.mView = new WeakReference(paramView);
      DeltaVisualizer.this.mAnimLayerPendingRunnables.add(this);
    }
    
    public void run()
    {
      if (this.mView != null) {
        ((View)this.mView.get()).setVisibility(0);
      }
      DeltaVisualizer.this.mAnimLayerPendingRunnables.remove(this);
      DeltaVisualizer.this.mLastDeltas.clear();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DeltaVisualizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */