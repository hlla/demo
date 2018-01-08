package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

class FolderAnimator
{
  private static final boolean DEBUG = true;
  private static final String TAG = "FolderAnimator";
  private boolean mAnimatingOpen = false;
  private final AnimationLayer mAnimationLayer;
  private AnimationLayer.Anim mBouncingAnim;
  private final ArrayList<AnimationLayer.Anim> mCloseAnims = new ArrayList();
  private final CellLayoutNoGap mContent;
  private final Folder mFolder;
  private final ArrayList<AnimationLayer.Anim> mFolderHoverAnim = new ArrayList();
  private long mFolderHoveringEndTime = 0L;
  private int mFolderOpenOri = 0;
  private FolderIconView mIcon;
  private int mNumCloseAnimsRunning = 0;
  Runnable mOnAnimationCancel = new Runnable()
  {
    public void run()
    {
      FolderAnimator.this.cleanupCloseAnims(false);
      FolderAnimator.this.clearFolderHoverAnims();
      if (FolderAnimator.this.mIcon != null)
      {
        if (!FolderAnimator.this.mIcon.isOpened()) {
          FolderAnimator.this.mIcon.mDrawIcon = true;
        }
        FolderAnimator.this.mIcon.mPlate = null;
      }
    }
  };
  private final ArrayList<ImageView> mOpenAnimations = new ArrayList();
  private Runnable mPostDrawPlate = new Runnable()
  {
    public void run()
    {
      if ((!FolderAnimator.this.mIcon.mCreateFactor.isAnimating()) && (!FolderAnimator.this.mIcon.mHighlightFactor.isAnimating()))
      {
        if ((FolderAnimator.this.mIcon.mHighlightFactor.get() == 1.0F) && (FolderAnimator.this.mIcon.mPlate != null) && (FolderAnimator.this.mIcon.mPlate.mAnimIcon != null))
        {
          FolderAnimator.this.mIcon.post(FolderAnimator.this.mPostDrawPlate);
          return;
        }
        FolderAnimator.this.destroyPlate();
        return;
      }
      FolderAnimator.this.drawPlate();
    }
  };
  private boolean mRenderIconOnPlate;
  private int[] mTempIconPos;
  private Canvas mTmpCanvas = new Canvas();
  private Paint mTmpPaint = new Paint();
  private Rect mTmpRect = new Rect();
  
  public FolderAnimator(Folder paramFolder, FolderIconView paramFolderIconView)
  {
    this.mIcon = paramFolderIconView;
    if (paramFolder != null) {}
    for (CellLayoutNoGap localCellLayoutNoGap = paramFolder.mContent;; localCellLayoutNoGap = null)
    {
      this.mContent = localCellLayoutNoGap;
      this.mFolder = paramFolder;
      this.mAnimationLayer = ((Launcher)paramFolderIconView.getContext()).getAnimationLayer();
      return;
    }
  }
  
  private int animHoverGroup(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        return 2;
      }
      if (paramInt > 4) {
        return 3;
      }
      return 1;
    }
    if ((paramInt == 2) || (paramInt == 3)) {
      return 2;
    }
    if (paramInt > 3) {
      return 3;
    }
    return 1;
  }
  
  private boolean animationNeeded(View paramView, int paramInt)
  {
    boolean bool1 = false;
    float f2 = 1.0F;
    boolean bool2 = paramView.getGlobalVisibleRect(this.mTmpRect, null);
    int i = this.mTmpRect.height();
    int j = this.mTmpRect.width();
    int k = paramView.getHeight();
    int m = paramView.getWidth();
    float f1;
    if ((i == k) && (j == m))
    {
      i = 1;
      if ((!bool2) || (i == 0)) {
        break label107;
      }
      f1 = 1.0F;
      label76:
      if (paramInt >= 6) {
        break label112;
      }
    }
    for (;;)
    {
      if ((f1 > 0.0F) || (f2 > 0.0F)) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      label107:
      f1 = 0.0F;
      break label76;
      label112:
      f2 = 0.0F;
    }
  }
  
  private AnimationLayer.Anim buildAnimForItem(BaseItem paramBaseItem)
  {
    if (((DragReceivable)this.mIcon.getParent().getParent()).getContainerType() == -101L) {}
    for (int i = 1;; i = 0)
    {
      AnimationLayer.Anim localAnim = this.mAnimationLayer.buildBasicAnim(i, this.mOnAnimationCancel, null, paramBaseItem.mIconBitmap, -1);
      localAnim.mLinkedItem = paramBaseItem;
      paramBaseItem = new Paint();
      paramBaseItem.setFilterBitmap(true);
      paramBaseItem.setAntiAlias(true);
      localAnim.mAnimIcon.setLayerType(1, paramBaseItem);
      localAnim.mPaint = paramBaseItem;
      return localAnim;
    }
  }
  
  private ValueAnimator.AnimatorUpdateListener buildAnimation(final int[] paramArrayOfInt1, final AnimationLayer.Anim paramAnim, final int paramInt, final int[] paramArrayOfInt2)
  {
    new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (paramAnim.mAnimIcon == null) {
          paramAnim.mAnimIcon = FolderAnimator.this.getNewImageView();
        }
        paramAnim.mAnimIcon.setTranslationX(paramArrayOfInt1[0] + paramArrayOfInt2[0]);
        paramAnim.mAnimIcon.setTranslationY(paramArrayOfInt1[1] + paramArrayOfInt2[1]);
        if (FolderAnimator.this.mIcon == null) {
          Log.d("FolderAnimator", "mIcon is null");
        }
        for (;;)
        {
          int i = 0;
          if (paramInt < 6) {
            i = 1;
          }
          paramAnim.mAnimIcon.setAlpha(0.3F * i);
          paramAnim.mAnimIcon.invalidate();
          FolderAnimator.this.mAnimationLayer.invalidate();
          return;
          if (FolderAnimator.this.mIcon.getParent() == null) {
            Log.d("FolderAnimator", "mIcon's parent is null");
          }
        }
      }
    };
  }
  
  private ValueAnimator.AnimatorUpdateListener buildCloseAnimation(int[] paramArrayOfInt1, final AnimationLayer.Anim paramAnim, int paramInt, final int[] paramArrayOfInt2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    final boolean bool;
    final int[] arrayOfInt;
    final float f3;
    label99:
    final float f1;
    if (paramArrayOfInt1 != null)
    {
      bool = true;
      arrayOfInt = paramArrayOfInt1;
      if (paramArrayOfInt1 == null)
      {
        paramArrayOfInt1 = getLocationOfFolderIcon();
        arrayOfInt = new int[2];
        arrayOfInt[0] = ((int)paramAnim.mAnimIcon.getTranslationX() - paramArrayOfInt1[0]);
        arrayOfInt[1] = ((int)paramAnim.mAnimIcon.getTranslationY() - paramArrayOfInt1[1]);
      }
      f3 = paramAnim.mAnimIcon.getScaleX();
      int i = 6;
      if (paramBoolean2) {
        i = 7;
      }
      if (paramAnim.mView == null) {
        break label156;
      }
      paramBoolean2 = paramAnim.mView.getGlobalVisibleRect(this.mTmpRect, null);
      if (!paramBoolean2) {
        break label162;
      }
      f1 = 1.0F;
      label107:
      if (paramInt >= i) {
        break label168;
      }
    }
    label156:
    label162:
    label168:
    for (final float f2 = 1.0F;; f2 = 0.0F)
    {
      new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = FolderAnimator.this.getLocationOfFolderIcon();
          float f2 = 1.0F;
          float f1 = f2;
          if (FolderAnimator.this.mIcon != null)
          {
            View localView = (View)FolderAnimator.this.mIcon.getParent();
            f1 = f2;
            if (localView != null)
            {
              localView = (View)localView.getParent();
              f1 = f2;
              if (localView != null) {
                f1 = localView.getScaleX();
              }
            }
          }
          f2 = paramAnonymousValueAnimator[0] + paramArrayOfInt2[0];
          float f4 = paramAnonymousValueAnimator[1] + paramArrayOfInt2[1];
          if (paramAnim.mAnimIcon == null) {
            paramAnim.mAnimIcon = FolderAnimator.this.getNewImageView();
          }
          if (paramBoolean1)
          {
            paramAnim.mAnimIcon.setTranslationX(PagedView.mix(arrayOfInt[0], f2, f3));
            paramAnim.mAnimIcon.setTranslationY(PagedView.mix(arrayOfInt[1], f4, f3));
          }
          for (;;)
          {
            f1 *= this.val$iconScale;
            paramAnim.mAnimIcon.setScaleX(PagedView.mix(f3, f1, f3));
            paramAnim.mAnimIcon.setScaleY(PagedView.mix(f3, f1, f3));
            paramAnim.mAnimIcon.setAlpha(PagedView.mix(f1, f2, f3));
            paramAnim.mAnimIcon.invalidate();
            FolderAnimator.this.mAnimationLayer.invalidate();
            return;
            if (!bool)
            {
              paramAnim.mAnimIcon.setTranslationX(PagedView.mix(paramAnonymousValueAnimator[0] + arrayOfInt[0], f2, f3));
              paramAnim.mAnimIcon.setTranslationY(PagedView.mix(paramAnonymousValueAnimator[1] + arrayOfInt[1], f4, f3));
            }
            else
            {
              paramAnim.mAnimIcon.setTranslationX(PagedView.mix(arrayOfInt[0], f2, f3));
              paramAnim.mAnimIcon.setTranslationY(PagedView.mix(arrayOfInt[1], f4, f3));
            }
          }
        }
      };
      bool = false;
      break;
      paramBoolean2 = true;
      break label99;
      f1 = 0.0F;
      break label107;
    }
  }
  
  private void drawPlate()
  {
    if ((this.mIcon.mPlate == null) || (this.mIcon.mPlate.mAnimIcon == null) || (this.mIcon.getParent() == null))
    {
      destroyPlate();
      return;
    }
    if ((this.mIcon.mHighlightFactor.isAnimating()) || (this.mIcon.mCreateFactor.isAnimating()))
    {
      this.mTmpCanvas.setBitmap(this.mIcon.mPlateBitmap);
      this.mIcon.mPlateBitmap.eraseColor(0);
      drawPlate_(this.mTmpCanvas);
      this.mTmpCanvas.setBitmap(null);
      this.mIcon.mPlate.mAnimIcon.setImageBitmap(this.mIcon.mPlateBitmap);
    }
    int[] arrayOfInt = getLocationOfFolderIcon();
    this.mIcon.mPlate.mAnimIcon.setTranslationX(arrayOfInt[0]);
    this.mIcon.mPlate.mAnimIcon.setTranslationY(arrayOfInt[1]);
    float f = ((CellLayout)this.mIcon.getParent().getParent()).getScaleX();
    this.mIcon.mPlate.mAnimIcon.setScaleX(f);
    this.mIcon.mPlate.mAnimIcon.setScaleY(f);
    f = ((Launcher)this.mIcon.getContext()).mHomeView.getHomeContainer().getAlpha();
    this.mIcon.mPlate.mAnimIcon.setAlpha(f);
    if (f != 1.0F)
    {
      this.mTmpPaint.setFilterBitmap(true);
      this.mTmpPaint.setAntiAlias(true);
      this.mIcon.mPlate.mAnimIcon.setLayerType(1, this.mTmpPaint);
    }
    this.mIcon.mPlate.mAnimIcon.invalidate();
    this.mAnimationLayer.invalidate();
    this.mIcon.post(this.mPostDrawPlate);
  }
  
  private void drawPlate_(Canvas paramCanvas)
  {
    this.mIcon.drawPlateWithFolderScale(paramCanvas);
    if (this.mRenderIconOnPlate)
    {
      float f = 1.0F + 0.1F * this.mIcon.mHighlightFactor.get();
      paramCanvas.save();
      Bitmap localBitmap = this.mIcon.getIcon();
      if (localBitmap != null)
      {
        paramCanvas.scale(f, f, localBitmap.getWidth() / 2.0F, localBitmap.getHeight() / 2.0F);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      }
      paramCanvas.restore();
    }
  }
  
  private int[] getAppIconOffset(int paramInt)
  {
    int i = 8;
    int j = 10;
    Object localObject = this.mIcon.getContext().getResources();
    if (localObject != null)
    {
      i = ((Resources)localObject).getInteger(2131492913);
      j = ((Resources)localObject).getInteger(2131492914);
    }
    try
    {
      f1 = ((View)this.mIcon.getParent().getParent()).getScaleX();
      localObject = FolderIconHelper.getAppIconXYCord(paramInt);
      float f2 = 1.0F;
      if (this.mFolder != null) {
        f2 = this.mIcon.getHotseatScaleFactor();
      }
      localObject[0] *= f2 * f1;
      localObject[0] -= i * f2 * f1;
      localObject[1] *= f2 * f1;
      localObject[1] -= j * f2 * f1;
      return new int[] { (int)localObject[0], (int)localObject[1] };
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        float f1 = 1.0F;
      }
    }
  }
  
  private int[] getIconRelativeToAnimationLayer(AppIconView paramAppIconView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mAnimationLayer.getLocationOfView(paramAppIconView, ((BaseItem)paramAppIconView.getTag()).mIconBitmap, null);
    }
    Object localObject = this.mFolder.getCustomLayoutParams();
    int j = ((HomeView.LayoutParams)localObject).x;
    int i = ((HomeView.LayoutParams)localObject).y;
    localObject = paramAppIconView.getCompoundDrawables()[1];
    j += (paramAppIconView.getWidth() - ((Drawable)localObject).getIntrinsicWidth()) / 2;
    i += paramAppIconView.getPaddingTop();
    while (paramAppIconView != this.mFolder)
    {
      j += paramAppIconView.getLeft();
      i += paramAppIconView.getTop();
      paramAppIconView = (View)paramAppIconView.getParent();
    }
    return new int[] { j, i };
  }
  
  private final int[] getLocationOfFolderIcon()
  {
    FolderIconView localFolderIconView = this.mIcon;
    Bitmap localBitmap = this.mIcon.getIcon();
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)localFolderIconView.getLayoutParams();
    int[] arrayOfInt = new int[2];
    localFolderIconView.getLocationOnScreen(arrayOfInt);
    arrayOfInt[1] -= AnimationLayer.sRootLocationOnScreen[1];
    float f2 = (localLayoutParams.width - localBitmap.getWidth()) / 2.0F;
    float f3 = localFolderIconView.getPaddingTop();
    try
    {
      f1 = ((View)localFolderIconView.getParent().getParent()).getScaleX();
      arrayOfInt[0] = ((int)(arrayOfInt[0] + f2 * f1));
      arrayOfInt[1] = ((int)(arrayOfInt[1] + f3 * f1));
      if (f1 != 1.0F)
      {
        f2 = localBitmap.getWidth();
        f3 = localBitmap.getHeight();
        arrayOfInt[0] = ((int)(arrayOfInt[0] - (f2 - f2 * f1) / 2.0F));
        arrayOfInt[1] = ((int)(arrayOfInt[1] - (f3 - f3 * f1) / 2.0F));
      }
      return arrayOfInt;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        float f1 = 1.0F;
      }
    }
  }
  
  private ImageView getNewImageView()
  {
    ImageView localImageView = new ImageView(this.mIcon.getContext());
    localImageView.setLayerType(0, Launcher.sViewLayerPaint);
    return localImageView;
  }
  
  private FolderIconHelper.LocFolder startHoveringLocation(int paramInt)
  {
    FolderIconHelper.LocFolder localLocFolder2 = FolderIconHelper.LocFolder.NOMAL;
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)this.mIcon.getLayoutParams();
    Resources localResources = this.mIcon.getContext().getResources();
    BaseItem localBaseItem = (BaseItem)this.mIcon.getTag();
    boolean bool = localResources.getBoolean(2131427342);
    if (paramInt == 1) {
      return FolderIconHelper.LocFolder.NOMAL;
    }
    FolderIconHelper.LocFolder localLocFolder1 = localLocFolder2;
    if (bool)
    {
      if ((localLayoutParams.cellX != 0) || (localBaseItem.mType != BaseItem.Type.MENU_FOLDER)) {
        break label91;
      }
      localLocFolder1 = FolderIconHelper.LocFolder.LEFT_FOLDER_INMENU;
    }
    for (;;)
    {
      return localLocFolder1;
      label91:
      if ((localLayoutParams.cellX == localResources.getInteger(2131492903) - 1) && (localBaseItem.mType == BaseItem.Type.MENU_FOLDER))
      {
        localLocFolder1 = FolderIconHelper.LocFolder.RIGHT_FOLDER_INMENU;
      }
      else
      {
        localLocFolder1 = localLocFolder2;
        if (localLayoutParams.cellY == 0)
        {
          localLocFolder1 = localLocFolder2;
          if (localBaseItem.mType == BaseItem.Type.HOME_FOLDER)
          {
            localLocFolder1 = localLocFolder2;
            if (paramInt > 4) {
              localLocFolder1 = FolderIconHelper.LocFolder.TOP_FOLDER_INHOME;
            }
          }
        }
      }
    }
  }
  
  void FadeInHoverIcon(int paramInt)
  {
    FolderItem localFolderItem = this.mIcon.getFolderItem();
    final int j = this.mIcon.getFolderItem().getItemCount();
    final int i = 0;
    setFolderHoveringEndTime(System.currentTimeMillis());
    if (j < 8) {
      return;
    }
    if (j / 7 == paramInt) {
      i = j % (7 * paramInt);
    }
    label66:
    int[] arrayOfInt1;
    label84:
    final Object localObject1;
    if (i == 0)
    {
      i = 7 - 1;
      cleanupCloseAnims(true);
      clearFolderHoverAnims();
      arrayOfInt1 = getLocationOfFolderIcon();
      j = i;
      if (j >= 0)
      {
        localObject1 = localFolderItem.getItemAt(paramInt * 7 + j).mIconBitmap;
        if (localObject1 != null) {
          break label129;
        }
      }
    }
    for (;;)
    {
      j -= 1;
      break label84;
      break;
      i -= 1;
      break label66;
      label129:
      localObject1 = this.mAnimationLayer.buildBasicAnim(this.mIcon.getAnimGroup(), this.mOnAnimationCancel, null, (Bitmap)localObject1, -1);
      ((AnimationLayer.Anim)localObject1).mAnimIcon.invalidate();
      ((AnimationLayer.Anim)localObject1).mAnimIcon.setAlpha(0.0F);
      ((AnimationLayer.Anim)localObject1).mLinkedItem = localFolderItem.getItemAt(paramInt * 7 + j);
      this.mCloseAnims.add(localObject1);
      this.mFolderHoverAnim.add(localObject1);
      final Object localObject2 = new Paint();
      ((Paint)localObject2).setFilterBitmap(true);
      ((Paint)localObject2).setAntiAlias(true);
      ((AnimationLayer.Anim)localObject1).mAnimIcon.setLayerType(1, (Paint)localObject2);
      ((AnimationLayer.Anim)localObject1).mPaint = ((Paint)localObject2);
      float f = ((View)this.mIcon.getParent().getParent()).getScaleX() * FolderIconHelper.getAppIconScaleFactor();
      ((AnimationLayer.Anim)localObject1).mAnimIcon.setScaleX(f);
      ((AnimationLayer.Anim)localObject1).mAnimIcon.setScaleY(f);
      localObject2 = getAppIconOffset(j);
      localObject2[0] += arrayOfInt1[0];
      localObject2[1] += arrayOfInt1[1];
      final int[] arrayOfInt2 = FolderIconHelper.getHoverOffset(this.mIcon.getContext().getResources(), j, i + 1, startHoveringLocation(i + 1));
      ((AnimationLayer.Anim)localObject1).addUpdateListener(buildAnimation((int[])localObject2, (AnimationLayer.Anim)localObject1, j, arrayOfInt2), false);
      ((AnimationLayer.Anim)localObject1).getAnimator().addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localObject1.mAnimIcon.setTranslationX(localObject2[0] + arrayOfInt2[0]);
          localObject1.mAnimIcon.setTranslationY(localObject2[1] + arrayOfInt2[1]);
          int i = 0;
          AnimationLayer.Anim localAnim;
          if (j == 4)
          {
            paramAnonymousAnimator = FolderAnimator.this.mFolderHoverAnim.iterator();
            while (paramAnonymousAnimator.hasNext())
            {
              localAnim = (AnimationLayer.Anim)paramAnonymousAnimator.next();
              if ((localAnim.mAnimIcon.getAlpha() == 0.3F) || (FolderAnimator.this.animHoverGroup(i, false) == 2))
              {
                localAnim.mAnimIcon.setAlpha(0.6F);
                localAnim.mAnimIcon.invalidate();
              }
              i += 1;
            }
          }
          if (j == i)
          {
            paramAnonymousAnimator = FolderAnimator.this.mFolderHoverAnim.iterator();
            while (paramAnonymousAnimator.hasNext())
            {
              localAnim = (AnimationLayer.Anim)paramAnonymousAnimator.next();
              localAnim.mAnimIcon.setAlpha(1.0F);
              localAnim.mAnimIcon.invalidate();
            }
          }
          FolderAnimator.this.mAnimationLayer.invalidate();
        }
      });
      ((AnimationLayer.Anim)localObject1).getAnimator().setDuration(animHoverGroup(j, true) * 100);
      ((AnimationLayer.Anim)localObject1).getAnimator().start();
    }
  }
  
  void animateCloseAnimsEnd(DragState paramDragState, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mIcon == null) || (this.mIcon.getParent() == null)) {}
    do
    {
      return;
      if ((paramDragState != null) && (paramDragState.hasDeleted()))
      {
        cleanupCloseAnims(false);
        return;
      }
    } while ((this.mFolder != null) && (this.mFolder.getInfo().isOpened()));
    cancelBouncingItem();
    int k = this.mIcon.getFolderItem().getItemCount();
    int i = 0;
    if (paramDragState != null)
    {
      if ((!paramBoolean1) && ((paramDragState.foundValidDrop()) || (this.mFolder == null) || (paramDragState.mDragOrigin != this.mFolder.mContent))) {
        break label413;
      }
      j = 1;
      i = j;
      if (!paramBoolean1)
      {
        i = j;
        if (j != 0)
        {
          i = j;
          if (!paramDragState.hasEnded()) {
            i = 0;
          }
        }
      }
    }
    Object localObject2 = this.mAnimationLayer;
    int j = this.mIcon.getAnimGroup();
    Runnable localRunnable = this.mOnAnimationCancel;
    final Object localObject1;
    if (i != 0)
    {
      localObject1 = paramDragState.getItem().mIconBitmap;
      label183:
      localObject1 = ((AnimationLayer)localObject2).buildBasicAnim(j, localRunnable, null, (Bitmap)localObject1, -1);
      if (paramDragState != null) {
        ((AnimationLayer.Anim)localObject1).mLinkedItem = paramDragState.getItem();
      }
      if (i == 0) {
        break label425;
      }
      i = paramDragState.getItem().getPosition();
      ((ValueAnimator)((AnimationLayer.Anim)localObject1).getAnimator()).addUpdateListener(buildCloseAnimation(this.mAnimationLayer.getDropOffset(paramDragState.getShadow()), (AnimationLayer.Anim)localObject1, i, getAppIconOffset(i), false, false));
      paramDragState = new Paint();
      paramDragState.setFilterBitmap(true);
      paramDragState.setAntiAlias(true);
      ((AnimationLayer.Anim)localObject1).mAnimIcon.setLayerType(1, paramDragState);
      ((AnimationLayer.Anim)localObject1).mPaint = paramDragState;
      this.mIcon.invalidate();
      label304:
      paramDragState = this.mCloseAnims.iterator();
      i = k;
    }
    for (;;)
    {
      if (!paramDragState.hasNext()) {
        break label473;
      }
      localObject2 = (AnimationLayer.Anim)paramDragState.next();
      ((AnimationLayer.Anim)localObject2).cancelAnimation();
      k = ((AnimationLayer.Anim)localObject2).mLinkedItem.getPosition();
      if (((AnimationLayer.Anim)localObject2).mAnimIcon != null)
      {
        if (paramBoolean2)
        {
          j = i;
          if (i > 7) {
            j = 7;
          }
          ((ValueAnimator)((AnimationLayer.Anim)localObject1).getAnimator()).addUpdateListener(buildCloseAnimation(null, (AnimationLayer.Anim)localObject2, k, getAppIconOffset(k), false, true));
          i = j;
          continue;
          label413:
          j = 0;
          break;
          localObject1 = null;
          break label183;
          label425:
          if (!this.mCloseAnims.isEmpty()) {
            break label304;
          }
          animatePlate(true);
          return;
        }
        ((ValueAnimator)((AnimationLayer.Anim)localObject1).getAnimator()).addUpdateListener(buildCloseAnimation(null, (AnimationLayer.Anim)localObject2, k, getAppIconOffset(k), false, false));
      }
    }
    label473:
    ((AnimationLayer.Anim)localObject1).getAnimator().addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localObject1.cancel();
        FolderAnimator.this.cleanupCloseAnims(false);
        FolderAnimator.this.clearFolderHoverAnims();
        if ((FolderAnimator.this.mCloseAnims.isEmpty()) && ((FolderAnimator.this.mFolder == null) || (!FolderAnimator.this.mFolder.getInfo().isOpened())) && (!FolderAnimator.this.mIcon.isOpened())) {
          FolderAnimator.this.mIcon.mDrawIcon = true;
        }
      }
    });
    ((AnimationLayer.Anim)localObject1).getAnimator().setDuration(Workspace.STATE_CHANGE_DURATION);
    ((AnimationLayer.Anim)localObject1).getAnimator().start();
    animatePlate(true);
  }
  
  void animateHoverExpand()
  {
    removeOpenAnimations();
    if (!this.mCloseAnims.isEmpty()) {
      cleanupCloseAnims(false);
    }
    FolderItem localFolderItem = this.mIcon.getFolderItem();
    int j = Math.min(localFolderItem.getItemCount(), 7);
    this.mIcon.mDrawIcon = false;
    this.mIcon.invalidate();
    int[] arrayOfInt = getLocationOfFolderIcon();
    int i = j - 1;
    if (i >= 0)
    {
      Object localObject1 = localFolderItem.getItemAt(i).mIconBitmap;
      if (localObject1 == null) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject1 = this.mAnimationLayer.buildBasicAnim(this.mIcon.getAnimGroup(), this.mOnAnimationCancel, null, (Bitmap)localObject1, -1);
        ((AnimationLayer.Anim)localObject1).mLinkedItem = localFolderItem.getItemAt(i);
        this.mCloseAnims.add(localObject1);
        this.mFolderHoverAnim.add(localObject1);
        Object localObject2 = new Paint();
        ((Paint)localObject2).setFilterBitmap(true);
        ((Paint)localObject2).setAntiAlias(true);
        ((AnimationLayer.Anim)localObject1).mAnimIcon.setLayerType(1, (Paint)localObject2);
        ((AnimationLayer.Anim)localObject1).mPaint = ((Paint)localObject2);
        float f = ((View)this.mIcon.getParent().getParent()).getScaleX() * FolderIconHelper.getAppIconScaleFactor();
        ((AnimationLayer.Anim)localObject1).mAnimIcon.setScaleX(f);
        ((AnimationLayer.Anim)localObject1).mAnimIcon.setScaleY(f);
        localObject2 = getAppIconOffset(i);
        localObject2[0] += arrayOfInt[0];
        localObject2[1] += arrayOfInt[1];
        ((AnimationLayer.Anim)localObject1).addUpdateListener(buildCloseAnimation((int[])localObject2, (AnimationLayer.Anim)localObject1, i, FolderIconHelper.getHoverOffset(this.mIcon.getContext().getResources(), i, j, startHoveringLocation(j)), true, true), false);
        ((AnimationLayer.Anim)localObject1).getAnimator().addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            FolderAnimator.this.setFolderHoveringEndTime(System.currentTimeMillis());
            FolderAnimator.this.mIcon.mDrawIcon = true;
            FolderAnimator.access$420(FolderAnimator.this, 1);
          }
        });
        ((AnimationLayer.Anim)localObject1).getAnimator().setDuration(400L);
        ((AnimationLayer.Anim)localObject1).getAnimator().start();
        this.mNumCloseAnimsRunning += 1;
      }
    }
  }
  
  boolean animatePlate(boolean paramBoolean)
  {
    boolean bool1 = this.mIcon.mHighlightFactor.isAnimating();
    boolean bool2 = this.mIcon.mCreateFactor.isAnimating();
    if (((paramBoolean) || (!this.mIcon.fromThisFolder())) && (!bool1) && (!bool2)) {}
    do
    {
      return false;
      if ((paramBoolean) || (!this.mIcon.fromThisFolder()))
      {
        this.mIcon.mDrawIcon = false;
        this.mIcon.mDrawShadow = false;
        this.mIcon.mDrawPlate = false;
        this.mIcon.invalidate();
      }
    } while (this.mIcon.mPlate != null);
    if ((this.mAnimatingOpen) || ((this.mFolder == null) && (!paramBoolean))) {}
    for (this.mRenderIconOnPlate = false;; this.mRenderIconOnPlate = this.mCloseAnims.isEmpty())
    {
      Bitmap localBitmap = FolderIconHelper.getOpenFolderHighlightBitmap(((FolderItem)this.mIcon.getTag()).getFolderColor());
      this.mIcon.mPlateBitmap = Bitmap.createBitmap(localBitmap.getWidth(), localBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      int i = -1;
      if (this.mFolder != null) {
        i = this.mAnimationLayer.indexOfChild(this.mFolder);
      }
      this.mIcon.mPlate = this.mAnimationLayer.buildBasicAnim(this.mIcon.getAnimGroup(), this.mOnAnimationCancel, null, this.mIcon.mPlateBitmap, i);
      drawPlate();
      return true;
    }
  }
  
  void bounceItemInIconAt(BaseItem paramBaseItem, int paramInt)
  {
    final AnimationLayer.Anim localAnim = buildAnimForItem(paramBaseItem);
    this.mBouncingAnim = localAnim;
    this.mCloseAnims.add(localAnim);
    localAnim.getAnimator().setInterpolator(new BounceInterpolator());
    if (paramInt != 0)
    {
      this.mAnimationLayer.removeView(localAnim.mAnimIcon);
      this.mAnimationLayer.addView(localAnim.mAnimIcon);
    }
    int[] arrayOfInt1 = getLocationOfFolderIcon();
    int[] arrayOfInt2 = getAppIconOffset(4);
    float f = this.mIcon.getHotseatScaleFactor();
    Resources localResources = this.mIcon.getContext().getResources();
    paramInt = localResources.getDimensionPixelSize(2131624345);
    if (f < 1.0F) {
      paramInt = localResources.getDimensionPixelSize(2131624346);
    }
    int i = arrayOfInt1[0];
    int j = arrayOfInt2[0];
    int k = arrayOfInt1[1];
    int m = arrayOfInt2[1];
    int n = arrayOfInt1[0];
    int i1 = arrayOfInt2[0];
    int i2 = arrayOfInt1[1];
    int i3 = arrayOfInt2[1];
    int i4 = paramBaseItem.mIconBitmap.getHeight() / 4;
    f = ((View)this.mIcon.getParent().getParent()).getScaleX() * 0.75F;
    localAnim.mAnimIcon.setScaleX(f);
    localAnim.mAnimIcon.setScaleY(f);
    localAnim.mDarken = 0.0F;
    FolderIconView.setDarkenPaintMultiplier(localAnim.mDarken, localAnim.mPaint);
    this.mIcon.setBounceItem(true);
    setCloseAnimsAlpha(0.5F, this.mBouncingAnim);
    this.mAnimationLayer.invalidate();
    localAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f1 = (1.0F - (float)Math.cos(6.37F * f2)) / 2.0F;
        f2 = Math.min(1.0F, 4.0F * f2);
        localAnim.mAnimIcon.setTranslationX(PagedView.mix(this.val$dest[0], this.val$up[0], f1));
        localAnim.mAnimIcon.setTranslationY(PagedView.mix(this.val$dest[1], this.val$up[1], f1));
        localAnim.mAnimIcon.setAlpha(PagedView.mix(0.0F, 1.0F, f2));
        FolderAnimator.this.mAnimationLayer.invalidate();
      }
    }, false);
    localAnim.getAnimator().setDuration(1200L);
    localAnim.getAnimator().start();
  }
  
  void cancel()
  {
    destroyPlate();
    this.mOnAnimationCancel.run();
  }
  
  void cancelBouncingItem()
  {
    if (this.mBouncingAnim == null) {}
    AnimationLayer.Anim localAnim;
    do
    {
      return;
      localAnim = this.mBouncingAnim;
      this.mCloseAnims.remove(localAnim);
      this.mBouncingAnim = null;
      this.mIcon.setBounceItem(false);
      setCloseAnimsAlpha(1.0F, null);
      ((ValueAnimator)localAnim.getAnimator()).removeAllUpdateListeners();
      localAnim.getAnimator().removeAllListeners();
      localAnim.getAnimator().setInterpolator(new LinearInterpolator());
      localAnim.getAnimator().setDuration(300L);
    } while (localAnim.mAnimIcon == null);
    localAnim.addAlphaAnimator(localAnim.mAnimIcon.getAlpha(), 0.0F, true);
    localAnim.getAnimator().start();
  }
  
  void cleanupCloseAnims(boolean paramBoolean)
  {
    if (this.mCloseAnims.isEmpty()) {
      if (!this.mIcon.isOpened())
      {
        this.mIcon.mDrawIcon = true;
        if (!paramBoolean) {
          this.mIcon.invalidate();
        }
      }
    }
    do
    {
      return;
      Iterator localIterator = this.mCloseAnims.iterator();
      while (localIterator.hasNext()) {
        ((AnimationLayer.Anim)localIterator.next()).cancel();
      }
      this.mCloseAnims.clear();
      this.mNumCloseAnimsRunning = 0;
    } while (paramBoolean);
    this.mIcon.invalidate();
  }
  
  void clearFolderHoverAnims()
  {
    if (this.mFolderHoverAnim.isEmpty()) {
      return;
    }
    Iterator localIterator = this.mFolderHoverAnim.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLayer.Anim)localIterator.next()).cancel();
    }
    this.mFolderHoverAnim.clear();
  }
  
  void destroyPlate()
  {
    this.mIcon.resetShadow();
    this.mIcon.invalidate();
    if (this.mIcon.mPlate != null)
    {
      this.mIcon.mPlate.cancel();
      this.mIcon.mPlate = null;
    }
    this.mIcon.mDrawPlate = true;
    if (this.mCloseAnims.isEmpty())
    {
      this.mIcon.mDrawShadow = true;
      if (!this.mIcon.isAnimating()) {
        this.mIcon.mDrawIcon = true;
      }
    }
  }
  
  void finishBouncingItem(BaseItem paramBaseItem)
  {
    if (this.mBouncingAnim == null) {
      return;
    }
    this.mBouncingAnim.getAnimator().removeAllListeners();
    ((ValueAnimator)this.mBouncingAnim.getAnimator()).removeAllUpdateListeners();
    this.mBouncingAnim.getAnimator().setInterpolator(new LinearInterpolator());
    this.mBouncingAnim = null;
    this.mIcon.setBounceItem(false);
    setCloseAnimsAlpha(1.0F, null);
  }
  
  public long getFolderHoveringEndTime()
  {
    return this.mFolderHoveringEndTime;
  }
  
  public boolean isAnimating()
  {
    return (this.mAnimatingOpen) || (this.mNumCloseAnimsRunning > 0);
  }
  
  public boolean isCloseAnimating()
  {
    boolean bool = false;
    if ((!this.mCloseAnims.isEmpty()) || (!this.mIcon.mDrawIcon)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isHoverAnimating()
  {
    return !this.mFolderHoverAnim.isEmpty();
  }
  
  void open()
  {
    this.mIcon.mDrawIcon = false;
    this.mIcon.invalidate();
  }
  
  public void removeOpenAnimations()
  {
    Iterator localIterator = this.mOpenAnimations.iterator();
    while (localIterator.hasNext())
    {
      final ImageView localImageView = (ImageView)localIterator.next();
      localImageView.post(new Runnable()
      {
        public void run()
        {
          FolderAnimator.this.mAnimationLayer.removeView(localImageView);
        }
      });
      localImageView.animate().setListener(null);
    }
    this.mOpenAnimations.clear();
    this.mNumCloseAnimsRunning = 0;
  }
  
  void setCloseAnimsAlpha(float paramFloat, AnimationLayer.Anim paramAnim)
  {
    ListIterator localListIterator = this.mCloseAnims.listIterator();
    while (localListIterator.hasNext())
    {
      AnimationLayer.Anim localAnim = (AnimationLayer.Anim)localListIterator.next();
      if (((paramAnim == null) || (localAnim != paramAnim)) && (localAnim.mLinkedItem.getPosition() < 6)) {
        localAnim.getIcon().setAlpha(paramFloat);
      }
    }
  }
  
  public void setFolderHoveringEndTime(long paramLong)
  {
    this.mFolderHoveringEndTime = paramLong;
  }
  
  public void updateTempIconPosition()
  {
    View localView = this.mContent.getChildrenLayout().getChildFromPosition(0);
    BaseItem localBaseItem = (BaseItem)this.mIcon.getTag();
    if (localView != null)
    {
      this.mTempIconPos = getIconRelativeToAnimationLayer((AppIconView)localView, false);
      if ((localBaseItem.getItemType() == BaseItem.Type.HOME_FOLDER) && (((HomeItem)this.mIcon.getTag()).container == -101L) && (this.mFolderOpenOri != Resources.getSystem().getConfiguration().orientation)) {
        this.mTempIconPos = getLocationOfFolderIcon();
      }
    }
  }
  
  void updateToNewIcon(FolderIconView paramFolderIconView)
  {
    this.mIcon = paramFolderIconView;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FolderAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */