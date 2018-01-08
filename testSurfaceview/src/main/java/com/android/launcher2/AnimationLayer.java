package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class AnimationLayer
  extends FrameLayout
  implements Runnable
{
  static final int[] sRootLocationOnScreen = new int[2];
  private final long BLOCK_EVENTS_TIMEOUT = 1000L;
  private Stack<Anim> mAnimPool = new Stack();
  private List<Anim> mAnimations = new ArrayList();
  private boolean mBlockEvents = false;
  final AnimatorListenerAdapter mBlockEventsListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      AnimationLayer.access$002(AnimationLayer.this, false);
    }
    
    public void onAnimationStart(Animator paramAnonymousAnimator)
    {
      AnimationLayer.access$002(AnimationLayer.this, true);
      AnimationLayer.access$102(AnimationLayer.this, SystemClock.uptimeMillis());
    }
  };
  private int mCurrentOrientation;
  private int mDragLastX = 0;
  private int mDragLastY = 0;
  private Object mDragLocalState;
  private boolean mDragStateDropped;
  private boolean mFirstDrawAfterConfigChange;
  private long mLastBlockTime;
  private Launcher mLauncher;
  private boolean mNeedToInvalidate = false;
  private final Resources mResources;
  private final float[] mTmpFPos = new float[2];
  private final int[] mTmpPos = new int[2];
  private Stack<ImageView> mViewPool = new Stack();
  
  public AnimationLayer(Context paramContext)
  {
    super(paramContext);
    this.mResources = paramContext.getResources();
    this.mCurrentOrientation = this.mResources.getConfiguration().orientation;
    this.mLauncher = ((Launcher)paramContext);
  }
  
  public AnimationLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AnimationLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mResources = paramContext.getResources();
    this.mCurrentOrientation = this.mResources.getConfiguration().orientation;
    this.mLauncher = ((Launcher)paramContext);
  }
  
  private void cleanupFinishedAnimations()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.mAnimations.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Anim)((Iterator)localObject2).next();
      if (((Anim)localObject3).isCompleted()) {
        ((List)localObject1).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Anim)((Iterator)localObject1).next();
      this.mAnimations.remove(localObject2);
      localObject3 = ((Anim)localObject2).mAnimIcon;
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setAlpha(1.0F);
        ((ImageView)localObject3).setScaleX(1.0F);
        ((ImageView)localObject3).setScaleY(1.0F);
        this.mViewPool.push(localObject3);
      }
      ((Anim)localObject2).recycle();
      this.mAnimPool.push(localObject2);
    }
  }
  
  public static AnimatorSet createAnimatorSequentialSet(Animator paramAnimator1, Animator paramAnimator2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  public static AnimatorSet createAnimatorTogetherSet(Animator paramAnimator1, Animator paramAnimator2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  private void dispatchOrientationChanged(Configuration paramConfiguration)
  {
    this.mCurrentOrientation = paramConfiguration.orientation;
    this.mFirstDrawAfterConfigChange = true;
    cancelAnimations();
    FolderIconHelper.initFolderResources(this.mResources);
    super.dispatchConfigurationChanged(paramConfiguration);
  }
  
  private Anim getNewAnim()
  {
    if (this.mAnimPool.empty()) {
      return new Anim();
    }
    return (Anim)this.mAnimPool.pop();
  }
  
  private ImageView getNewImageView()
  {
    if (this.mViewPool.empty()) {}
    for (ImageView localImageView = new ImageView(getContext());; localImageView = (ImageView)this.mViewPool.pop())
    {
      localImageView.setLayerType(0, Launcher.sViewLayerPaint);
      return localImageView;
    }
  }
  
  public Anim animateDrop(int paramInt, Runnable paramRunnable, View paramView, ShadowBuilder paramShadowBuilder)
  {
    if (paramView.getParent() == null) {}
    while (!(paramView instanceof TextView)) {
      return null;
    }
    Bitmap localBitmap1 = null;
    if ((paramView instanceof AppIconView)) {
      localBitmap1 = ((AppIconView)paramView).getDragIcon();
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = paramShadowBuilder.getBitmap();
    }
    return animateIcon(paramInt, paramRunnable, paramView, localBitmap2, getDropOffset(paramShadowBuilder), null, false, 320, true);
  }
  
  public Anim animateIcon(int paramInt1, Runnable paramRunnable, View paramView, Bitmap paramBitmap, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    cleanupFinishedAnimations();
    ImageView localImageView = getNewImageView();
    localImageView.setImageBitmap(paramBitmap);
    addView(localImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
    Anim localAnim = getNewAnim();
    localAnim.mAnimGroup = paramInt1;
    if (paramRunnable != null) {
      localAnim.mCallback = new WeakReference(paramRunnable);
    }
    if (paramBoolean1) {
      localAnim.setupMoveFadeAnimation(paramView, paramBitmap, localImageView, paramArrayOfInt1, paramArrayOfInt2);
    }
    for (;;)
    {
      this.mAnimations.add(localAnim);
      localImageView.setTag(localAnim);
      return localAnim;
      localAnim.setupMoveAnimation(paramView, paramBitmap, localImageView, paramArrayOfInt1, paramArrayOfInt2, paramInt2, paramBoolean2);
    }
  }
  
  public boolean areTouchEventsBlocked()
  {
    if ((this.mBlockEvents) && (SystemClock.uptimeMillis() - this.mLastBlockTime > 1000L)) {
      this.mBlockEvents = false;
    }
    return this.mBlockEvents;
  }
  
  public Anim buildBasicAnim(int paramInt1, Runnable paramRunnable, View paramView, Bitmap paramBitmap, int paramInt2)
  {
    cleanupFinishedAnimations();
    Anim localAnim = getNewAnim();
    if (paramBitmap == null) {
      localAnim.setupBasicAnimation(paramInt1, paramRunnable, paramView, paramBitmap, null);
    }
    for (;;)
    {
      this.mAnimations.add(localAnim);
      return localAnim;
      ImageView localImageView = getNewImageView();
      localImageView.setImageBitmap(paramBitmap);
      localImageView.setTag(localAnim);
      FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.width = paramBitmap.getWidth();
      localLayoutParams.height = paramBitmap.getHeight();
      addView(localImageView, paramInt2, localLayoutParams);
      localAnim.setupBasicAnimation(paramInt1, paramRunnable, paramView, paramBitmap, localImageView);
    }
  }
  
  public void cancelAnimationFor(View paramView)
  {
    Iterator localIterator = this.mAnimations.iterator();
    while (localIterator.hasNext())
    {
      Anim localAnim = (Anim)localIterator.next();
      if (localAnim.mView == paramView) {
        localAnim.cancel();
      }
    }
  }
  
  public void cancelAnimations()
  {
    Iterator localIterator = this.mAnimations.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Anim)localIterator.next();
      ((Anim)localObject).cancel();
      if (((Anim)localObject).mCallback != null)
      {
        localObject = (Runnable)((Anim)localObject).mCallback.get();
        if (localObject != null) {
          ((Runnable)localObject).run();
        }
      }
    }
    cleanupFinishedAnimations();
  }
  
  public void cancelAnimationsByGroup(int paramInt)
  {
    Iterator localIterator = this.mAnimations.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Anim)localIterator.next();
      if (((Anim)localObject).mAnimGroup == paramInt)
      {
        ((Anim)localObject).cancel();
        if (((Anim)localObject).mCallback != null)
        {
          localObject = (Runnable)((Anim)localObject).mCallback.get();
          if (localObject != null) {
            ((Runnable)localObject).run();
          }
        }
      }
    }
    cleanupFinishedAnimations();
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    i = paramDragEvent.getAction();
    localObject2 = paramDragEvent.getLocalState();
    bool1 = false;
    localObject1 = localObject2;
    Object localObject3;
    HomeView localHomeView;
    Workspace localWorkspace;
    if (LauncherApplication.sDNDBinding)
    {
      localObject1 = localObject2;
      if (!Launcher.isHelpAppRunning)
      {
        if (i == 1) {
          Launcher.dragstate = null;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = paramDragEvent.getClipDescription();
          if (this.mLauncher == null) {
            break label341;
          }
          localHomeView = this.mLauncher.getHomeView();
          if (localHomeView == null) {
            break label347;
          }
          localWorkspace = localHomeView.getWorkspace();
          label86:
          if ((localObject3 == null) || (i != 1))
          {
            localObject1 = localObject2;
            if (i != 3) {}
          }
          else
          {
            localObject3 = (String)((ClipDescription)localObject3).getLabel();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if ((((String)localObject3).contains("DragAndDropBinding")) && (i != 3)) {
                break label353;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = paramDragEvent.getClipData().getItemAt(0).getIntent();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          int j = LauncherSettings.Favorites.convertToLocalItemType(((Intent)localObject3).getIntExtra("itemType", -1));
          localObject1 = localObject2;
          if (j >= 0)
          {
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = new DragState((Intent)localObject3, j, this.mLauncher);
              if (localObject1 == null) {
                continue;
              }
            }
          }
        }
      }
      catch (URISyntaxException localURISyntaxException2)
      {
        boolean bool2;
        label341:
        label347:
        label353:
        localObject1 = localObject2;
        localObject2 = localURISyntaxException2;
        ((URISyntaxException)localObject2).printStackTrace();
        continue;
        if (this.mDragLocalState == null)
        {
          this.mDragLocalState = null;
          continue;
        }
        if (i == 4)
        {
          this.mDragLocalState = null;
          bool1 = true;
          continue;
        }
        if (this.mDragStateDropped) {
          continue;
        }
        if ((i == 2) || (i == 3))
        {
          this.mDragLastX = ((int)paramDragEvent.getX());
          this.mDragLastY = ((int)paramDragEvent.getY());
          if (i == 3) {
            this.mDragStateDropped = true;
          }
        }
        bool1 = true;
        continue;
      }
      try
      {
        if (((DragState)localObject1).mItem == null) {
          continue;
        }
        Launcher.dragstate = (DragState)localObject1;
        Launcher.isHelpIntentFired = Launcher.isHelpAppRunning;
        if (localHomeView == null) {
          break label475;
        }
        if (localHomeView.getVisibility() != 0) {
          localHomeView.setVisibility(0);
        }
        if ((localWorkspace == null) || (!localWorkspace.isQuickViewWorkspaceOpend())) {
          break label475;
        }
        localHomeView.closeQuickViewWorkspace(true);
      }
      catch (URISyntaxException localURISyntaxException1)
      {
        continue;
        continue;
      }
      if (i != 1) {
        continue;
      }
      this.mDragLocalState = localObject1;
      if (localObject1 != null)
      {
        this.mDragLastX = ((int)paramDragEvent.getX());
        this.mDragLastY = ((int)paramDragEvent.getY());
        this.mDragStateDropped = false;
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = super.dispatchDragEvent(paramDragEvent);
      }
      return bool2;
      localHomeView = null;
      break;
      localWorkspace = null;
      break label86;
      localObject3 = Intent.parseUri((String)localObject3, 1);
      continue;
      localObject1 = null;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (Launcher.sIsStopped)
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    Configuration localConfiguration = this.mResources.getConfiguration();
    if (localConfiguration.orientation != this.mCurrentOrientation)
    {
      dispatchOrientationChanged(localConfiguration);
      requestLayout();
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      return;
      if (this.mFirstDrawAfterConfigChange)
      {
        this.mFirstDrawAfterConfigChange = false;
        post(this);
      }
    }
  }
  
  protected void dispatchGetDisplayList()
  {
    if (Launcher.sIsStopped)
    {
      super.dispatchGetDisplayList();
      return;
    }
    Configuration localConfiguration = this.mResources.getConfiguration();
    if (localConfiguration.orientation != this.mCurrentOrientation)
    {
      dispatchOrientationChanged(localConfiguration);
      requestLayout();
    }
    for (;;)
    {
      super.dispatchGetDisplayList();
      return;
      if (this.mFirstDrawAfterConfigChange)
      {
        this.mFirstDrawAfterConfigChange = false;
        post(this);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (areTouchEventsBlocked()) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void dispatchWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mNeedToInvalidate)) {
      invalidate();
    }
    super.dispatchWindowFocusChanged(paramBoolean);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject;
    if ((!(paramView instanceof ImageView)) || (paramView.getLayerType() != 0))
    {
      localObject = this.mResources.getConfiguration();
      if ((Launcher.sIsStopped) && (((Configuration)localObject).orientation != this.mCurrentOrientation))
      {
        this.mNeedToInvalidate = true;
        return true;
      }
      this.mNeedToInvalidate = false;
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    paramCanvas.save();
    if ((paramView.getTag() instanceof Anim))
    {
      localObject = (Anim)paramView.getTag();
      if (((Anim)localObject).mClippingEnabled) {
        paramCanvas.clipRect(((Anim)localObject).mClipRect);
      }
    }
    paramCanvas.concat(paramView.getMatrix());
    paramView.draw(paramCanvas);
    paramCanvas.restore();
    return true;
  }
  
  public Anim findExistingAnimation(View paramView)
  {
    Iterator localIterator = this.mAnimations.iterator();
    while (localIterator.hasNext())
    {
      Anim localAnim = (Anim)localIterator.next();
      if ((!localAnim.isCompleted()) && (localAnim.mView == paramView) && (paramView.getParent() != null)) {
        return localAnim;
      }
    }
    return null;
  }
  
  public Anim getAnimationForView(View paramView)
  {
    Object localObject2 = null;
    Iterator localIterator = this.mAnimations.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Anim)localIterator.next();
    } while (((Anim)localObject1).mView != paramView);
    return (Anim)localObject1;
  }
  
  public int[] getDropOffset(ShadowBuilder paramShadowBuilder)
  {
    if (paramShadowBuilder != null) {
      paramShadowBuilder = paramShadowBuilder.getTouchOffset();
    }
    for (;;)
    {
      return new int[] { this.mDragLastX - paramShadowBuilder[0], this.mDragLastY - paramShadowBuilder[1] };
      paramShadowBuilder = new int[2];
      ShadowBuilder tmp40_39 = paramShadowBuilder;
      tmp40_39[0] = 0;
      ShadowBuilder tmp44_40 = tmp40_39;
      tmp44_40[1] = 0;
      tmp44_40;
    }
  }
  
  public int[] getLocationFromCellPos(int paramInt1, int paramInt2, CellLayout paramCellLayout, View paramView, Bitmap paramBitmap)
  {
    int[] arrayOfInt2 = new int[2];
    int[] arrayOfInt1 = new int[2];
    paramCellLayout.cellToPoint(paramInt1, paramInt2, arrayOfInt2);
    float f1 = paramCellLayout.getScaleX();
    float f2 = paramCellLayout.getScaleY();
    paramCellLayout.setScaleX(1.0F);
    paramCellLayout.setScaleY(1.0F);
    paramCellLayout.getLocationOnScreen(arrayOfInt1);
    float f3 = paramCellLayout.getWidth();
    float f4 = paramCellLayout.getHeight();
    paramCellLayout.setScaleX(f1);
    paramCellLayout.setScaleY(f2);
    arrayOfInt1[0] += (int)((f3 - f3 * f1) / 2.0F);
    arrayOfInt1[1] -= sRootLocationOnScreen[1];
    arrayOfInt1[1] += (int)((f4 - f4 * f2) / 2.0F);
    paramCellLayout = this.mTmpFPos;
    paramCellLayout[0] = (arrayOfInt2[0] * f1 + arrayOfInt1[0]);
    paramCellLayout[1] = (arrayOfInt2[1] * f2 + arrayOfInt1[1]);
    if (paramBitmap != null)
    {
      f3 = (paramView.getLayoutParams().width - paramBitmap.getWidth()) / 2.0F;
      f1 = 0.0F;
      if (paramBitmap.getHeight() != paramView.getHeight()) {
        f1 = paramView.getPaddingTop();
      }
    }
    try
    {
      f2 = ((View)paramView.getParent().getParent()).getScaleX();
      paramCellLayout[0] += f3 * f2;
      if (f2 != 1.0F)
      {
        f3 = paramBitmap.getWidth();
        paramCellLayout[0] -= (f3 - f3 * f2) / 2.0F;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      try
      {
        f2 = ((View)paramView.getParent().getParent()).getScaleY();
        paramCellLayout[1] += f1 * f2;
        if (f2 != 1.0F)
        {
          f1 = paramBitmap.getHeight();
          paramCellLayout[1] -= (f1 - f1 * f2) / 2.0F;
        }
        arrayOfInt1[0] = ((int)paramCellLayout[0]);
        arrayOfInt1[1] = ((int)paramCellLayout[1]);
        return arrayOfInt1;
        localNullPointerException = localNullPointerException;
        f2 = 1.0F;
      }
      catch (NullPointerException paramView)
      {
        for (;;)
        {
          f2 = 1.0F;
        }
      }
    }
  }
  
  public int[] getLocationOfView(View paramView, Bitmap paramBitmap)
  {
    return getLocationOfView(paramView, paramBitmap, this.mTmpPos);
  }
  
  public int[] getLocationOfView(View paramView, Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    return getLocationOfView(paramView, paramBitmap, paramArrayOfInt, false);
  }
  
  public int[] getLocationOfView(View paramView, Bitmap paramBitmap, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[2];
    }
    if (paramView == null) {
      return arrayOfInt;
    }
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
    float f1 = paramView.getScaleX();
    float f2 = paramView.getScaleY();
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.getLocationOnScreen(arrayOfInt);
    paramView.setScaleX(f1);
    paramView.setScaleY(f2);
    paramArrayOfInt = this.mTmpFPos;
    paramArrayOfInt[0] = arrayOfInt[0];
    paramArrayOfInt[1] = arrayOfInt[1];
    paramArrayOfInt[1] -= sRootLocationOnScreen[1];
    float f3;
    if (paramBitmap != null)
    {
      f3 = (localLayoutParams.width - paramBitmap.getWidth()) / 2.0F;
      f2 = 0.0F;
      f1 = f2;
      if (!paramBoolean)
      {
        f1 = f2;
        if (paramBitmap.getHeight() != paramView.getHeight()) {
          f1 = paramView.getPaddingTop();
        }
      }
    }
    try
    {
      f2 = ((View)paramView.getParent().getParent()).getScaleX();
      paramArrayOfInt[0] += f3 * f2;
      if (f2 != 1.0F)
      {
        f3 = paramBitmap.getWidth();
        paramArrayOfInt[0] -= (f3 - f3 * f2) / 2.0F;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      try
      {
        f2 = ((View)paramView.getParent().getParent()).getScaleY();
        paramArrayOfInt[1] += f1 * f2;
        if (f2 != 1.0F)
        {
          f1 = paramBitmap.getHeight();
          paramArrayOfInt[1] -= (f1 - f1 * f2) / 2.0F;
        }
        arrayOfInt[0] = ((int)paramArrayOfInt[0]);
        arrayOfInt[1] = ((int)paramArrayOfInt[1]);
        return arrayOfInt;
        localNullPointerException = localNullPointerException;
        f2 = 1.0F;
      }
      catch (NullPointerException paramView)
      {
        for (;;)
        {
          f2 = 1.0F;
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    cancelAnimations();
    this.mAnimations.clear();
    this.mViewPool.clear();
    this.mAnimPool.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getActionMasked() == 0) && (this.mLauncher.isPaused());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getLocationOnScreen(sRootLocationOnScreen);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Configuration localConfiguration = this.mResources.getConfiguration();
    if (localConfiguration.orientation != this.mCurrentOrientation) {
      dispatchOrientationChanged(localConfiguration);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void run()
  {
    this.mLauncher.bindWidgetsAfterConfigChange();
  }
  
  public Anim updateExistingAnimationTo(View paramView, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    cleanupFinishedAnimations();
    Iterator localIterator = this.mAnimations.iterator();
    while (localIterator.hasNext())
    {
      Anim localAnim = (Anim)localIterator.next();
      if ((!localAnim.isCompleted()) && (localAnim.mView == paramView) && (paramView.getParent() != null))
      {
        localAnim.update(paramArrayOfInt, paramInt, paramBoolean);
        return localAnim;
      }
    }
    return null;
  }
  
  public class Anim
  {
    static final int DEFAULT = 0;
    static final int SCROLLABLE = 1;
    private Bitmap b;
    int mAnimGroup;
    ImageView mAnimIcon;
    private Animator mAnimation;
    WeakReference<Runnable> mCallback;
    Rect mClipRect = new Rect();
    boolean mClippingEnabled = false;
    public float mDarken;
    int[] mFrom;
    private boolean mIsCompleted = false;
    public BaseItem mLinkedItem;
    private AnimatorListenerAdapter mMoveAnimListener = new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AnimationLayer.Anim.this.markCompleted();
        AnimationLayer.Anim.this.updateView();
      }
    };
    private ValueAnimator.AnimatorUpdateListener mMoveUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i;
        if (AnimationLayer.Anim.this.mView.getWindowToken() == null)
        {
          i = 1;
          if (((AnimationLayer.Anim.this.mTo != null) || (AnimationLayer.Anim.this.mView.getParent() != null)) && (i == 0)) {
            break label58;
          }
          AnimationLayer.Anim.this.cancel();
        }
        for (;;)
        {
          return;
          i = 0;
          break;
          label58:
          int[] arrayOfInt1 = AnimationLayer.Anim.this.getTo();
          int[] arrayOfInt2 = AnimationLayer.Anim.this.getFrom();
          float f1 = arrayOfInt1[0] - arrayOfInt2[0];
          float f3 = arrayOfInt1[1] - arrayOfInt2[1];
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          AnimationLayer.Anim.this.mAnimIcon.setTranslationX(arrayOfInt2[0] + f1 * f2);
          AnimationLayer.Anim.this.mAnimIcon.setTranslationY(arrayOfInt2[1] + f3 * f2);
          AnimationLayer.Anim.this.mAnimIcon.setScaleX(((View)AnimationLayer.Anim.this.mView.getParent().getParent()).getScaleX());
          AnimationLayer.Anim.this.mAnimIcon.setScaleY(((View)AnimationLayer.Anim.this.mView.getParent().getParent()).getScaleY());
          AnimationLayer.Anim.this.mAnimIcon.invalidate();
          AnimationLayer.this.invalidate();
          if ((!AnimationLayer.Anim.this.mShadowFadeStarted) && ((AnimationLayer.Anim.this.mView instanceof AppIconView)))
          {
            if (f1 * f1 + f3 * f3 > 1600.0F) {}
            for (f1 = 1.0F; f2 >= f1; f1 = 0.6F)
            {
              AnimationLayer.Anim.access$302(AnimationLayer.Anim.this, true);
              AnimationLayer.Anim.this.mView.setVisibility(0);
              ((AppIconView)AnimationLayer.Anim.this.mView).startFadeShadow();
              return;
            }
          }
        }
      }
    };
    public Paint mPaint;
    private boolean mShadowFadeStarted = false;
    int[] mTo;
    View mView;
    
    public Anim() {}
    
    private void updateView()
    {
      if (this.mView != null)
      {
        if (this.mView.getVisibility() != 0) {
          this.mView.setVisibility(0);
        }
        if ((this.mView instanceof AppIconView)) {
          ((AppIconView)this.mView).onDrop();
        }
      }
    }
    
    public void addAlphaAnimator(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
    {
      final ValueAnimator localValueAnimator = (ValueAnimator)this.mAnimation;
      final ValueAnimator.AnimatorUpdateListener local2 = new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          AnimationLayer.Anim.this.mAnimIcon.setAlpha(paramFloat1 * (1.0F - f) + paramFloat2 * f);
          AnimationLayer.Anim.this.mAnimIcon.invalidate();
          AnimationLayer.this.invalidate();
        }
      };
      AnimatorListenerAdapter local3 = new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localValueAnimator.removeUpdateListener(local2);
          localValueAnimator.removeListener(this);
          if (paramBoolean) {
            AnimationLayer.Anim.this.markCompleted();
          }
        }
      };
      localValueAnimator.addUpdateListener(local2);
      localValueAnimator.addListener(local3);
    }
    
    public void addUpdateListener(final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener, final boolean paramBoolean)
    {
      final ValueAnimator localValueAnimator = (ValueAnimator)this.mAnimation;
      AnimatorListenerAdapter local1 = new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localValueAnimator.removeUpdateListener(paramAnimatorUpdateListener);
          localValueAnimator.removeListener(this);
          if (paramBoolean) {
            AnimationLayer.Anim.this.markCompleted();
          }
        }
      };
      localValueAnimator.addUpdateListener(paramAnimatorUpdateListener);
      localValueAnimator.addListener(local1);
    }
    
    void cancel()
    {
      if (this.mAnimation != null) {
        this.mAnimation.cancel();
      }
      markCompleted();
    }
    
    public void cancelAnimation()
    {
      if (this.mAnimation != null) {
        this.mAnimation.cancel();
      }
    }
    
    public void enableClipping()
    {
      this.mClippingEnabled = true;
    }
    
    public Animator getAnimator()
    {
      return this.mAnimation;
    }
    
    public Bitmap getBitmap()
    {
      return this.b;
    }
    
    public Rect getClipRect()
    {
      return this.mClipRect;
    }
    
    public int[] getFrom()
    {
      return this.mFrom;
    }
    
    public ImageView getIcon()
    {
      return this.mAnimIcon;
    }
    
    public int[] getTo()
    {
      if (this.mTo != null) {
        return this.mTo;
      }
      return AnimationLayer.this.getLocationOfView(this.mView, this.b);
    }
    
    public boolean isAnimating()
    {
      return (this.mAnimation != null) && (this.mAnimation.isRunning());
    }
    
    boolean isCompleted()
    {
      return this.mIsCompleted;
    }
    
    public void markCompleted()
    {
      if ((this.mAnimIcon != null) && (this.mAnimIcon.getParent() != null)) {
        AnimationLayer.this.removeView(this.mAnimIcon);
      }
      this.mIsCompleted = true;
    }
    
    public void recycle()
    {
      cancel();
      this.mAnimGroup = 0;
      this.mCallback = null;
      this.mView = null;
      this.mAnimIcon = null;
      this.b = null;
      this.mTo = null;
      this.mFrom = null;
      this.mIsCompleted = false;
      if (this.mAnimation != null)
      {
        this.mAnimation.removeAllListeners();
        if ((this.mAnimation instanceof ValueAnimator))
        {
          ((ValueAnimator)this.mAnimation).setRepeatCount(0);
          ((ValueAnimator)this.mAnimation).removeAllUpdateListeners();
        }
      }
      this.mClippingEnabled = false;
      this.mPaint = null;
    }
    
    public void setFrom(int[] paramArrayOfInt)
    {
      this.mFrom = paramArrayOfInt;
    }
    
    public void setTo(int[] paramArrayOfInt)
    {
      this.mTo = paramArrayOfInt;
    }
    
    void setupBasicAnimation(int paramInt, Runnable paramRunnable, View paramView, Bitmap paramBitmap, ImageView paramImageView)
    {
      this.mAnimGroup = paramInt;
      if (paramRunnable != null) {
        this.mCallback = new WeakReference(paramRunnable);
      }
      this.mView = paramView;
      this.mAnimIcon = paramImageView;
      this.b = paramBitmap;
      this.mAnimation = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    }
    
    void setupMoveAnimation(View paramView, Bitmap paramBitmap, ImageView paramImageView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, boolean paramBoolean)
    {
      paramView.setVisibility(4);
      this.mView = paramView;
      this.mAnimIcon = paramImageView;
      this.b = paramBitmap;
      this.mFrom = paramArrayOfInt1;
      this.mTo = paramArrayOfInt2;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.mShadowFadeStarted = paramBoolean;
        this.mAnimation = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)this.mAnimation).addUpdateListener(this.mMoveUpdateListener);
        this.mAnimation.addListener(this.mMoveAnimListener);
        this.mAnimation.setDuration(paramInt);
        this.mAnimation.start();
        return;
      }
    }
    
    void setupMoveFadeAnimation(View paramView, Bitmap paramBitmap, final ImageView paramImageView, final int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      paramView.setVisibility(4);
      this.mView = paramView;
      this.mAnimIcon = paramImageView;
      this.mFrom = paramArrayOfInt1;
      this.mTo = paramArrayOfInt2;
      this.b = paramBitmap;
      paramView = getTo();
      final float f1 = paramView[0] - paramArrayOfInt1[0];
      final float f2 = paramView[1] - paramArrayOfInt1[1];
      float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      float f4 = AnimationLayer.this.getHeight();
      float f5 = AnimationLayer.this.getHeight();
      paramView = ValueAnimator.ofFloat(new float[] { 0.1F, 0.1F + 0.08F * f4 / f3 });
      paramView.setDuration(90L);
      paramView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramImageView.setTranslationX(paramArrayOfInt1[0] + f1 * f);
          paramImageView.setTranslationY(paramArrayOfInt1[1] + f2 * f);
          AnimationLayer.Anim.this.mAnimIcon.invalidate();
          AnimationLayer.this.invalidate();
        }
      });
      paramBitmap = ValueAnimator.ofFloat(new float[] { 1.0F - 0.12F * f5 / f3, 1.0F });
      paramBitmap.setDuration(90L);
      paramBitmap.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramImageView.setTranslationX(paramArrayOfInt1[0] + f1 * f);
          paramImageView.setTranslationY(paramArrayOfInt1[1] + f2 * f);
          AnimationLayer.Anim.this.mAnimIcon.invalidate();
          AnimationLayer.this.invalidate();
        }
      });
      paramArrayOfInt1 = ObjectAnimator.ofFloat(paramImageView, View.ALPHA, new float[] { 1.0F, 0.3F });
      paramImageView = ObjectAnimator.ofFloat(paramImageView, View.ALPHA, new float[] { 0.3F, 1.0F });
      paramArrayOfInt1.setDuration(90L);
      paramArrayOfInt1.setStartDelay(0L);
      paramImageView.setDuration(90L);
      this.mAnimation = AnimationLayer.createAnimatorSequentialSet(AnimationLayer.createAnimatorTogetherSet(paramArrayOfInt1, paramView), AnimationLayer.createAnimatorTogetherSet(paramImageView, paramBitmap));
      this.mAnimation.start();
    }
    
    void update(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    {
      this.mClippingEnabled = paramBoolean;
      this.mTo = paramArrayOfInt;
      this.mFrom[0] = ((int)this.mAnimIcon.getTranslationX());
      this.mFrom[1] = ((int)this.mAnimIcon.getTranslationY());
      if ((this.mAnimation instanceof ValueAnimator))
      {
        paramArrayOfInt = (ValueAnimator)this.mAnimation;
        paramArrayOfInt.setDuration(paramInt);
        paramArrayOfInt.setCurrentPlayTime(0L);
        paramArrayOfInt.start();
      }
    }
    
    public void updateBitmap(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
      this.mAnimIcon.setImageBitmap(this.b);
      paramBitmap = (FrameLayout.LayoutParams)this.mAnimIcon.getLayoutParams();
      paramBitmap.width = this.b.getWidth();
      paramBitmap.height = this.b.getHeight();
      this.mAnimIcon.requestLayout();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AnimationLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */