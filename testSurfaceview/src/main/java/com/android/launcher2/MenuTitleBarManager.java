package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.HoverPopupWindow;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MenuTitleBarManager
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "Launcher.MenuTitleBarManager";
  private static final PropertyValuesHolder TITLE_BAR_ALPHA_IN = PropertyValuesHolder.ofFloat(View.ALPHA, new float[] { 0.0F, 1.0F });
  private static final PropertyValuesHolder TITLE_BAR_ALPHA_OUT;
  private static final float TITLE_BAR_SCALE_IN = 1.0F;
  private static final float TITLE_BAR_SCALE_OUT = 0.9F;
  private static final PropertyValuesHolder TITLE_BAR_SCALE_X_IN;
  private static final PropertyValuesHolder TITLE_BAR_SCALE_X_OUT = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[] { 1.0F, 0.9F });
  private static final PropertyValuesHolder TITLE_BAR_SCALE_Y_IN;
  private static final PropertyValuesHolder TITLE_BAR_SCALE_Y_OUT;
  private View mCurrentTitleBar;
  private ViewGroup mDownloadedTitleBar;
  private ViewStub mDownloadedTitleBarStub;
  private ViewGroup mEditTitleBar;
  private MenuEditBar mMenuEditBar;
  private ViewGroup mNormalTitleBar;
  private ViewGroup mSearchTitleBar;
  private ViewGroup mSelectedTitleBar;
  private ViewStub mSelectedTitleBarStub;
  private MenuView mTabHost;
  private int mTitleBarHeight;
  private ViewGroup mUninstallTitleBar;
  
  static
  {
    TITLE_BAR_SCALE_X_IN = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[] { 0.9F, 1.0F });
    TITLE_BAR_SCALE_Y_OUT = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[] { 1.0F, 0.9F });
    TITLE_BAR_SCALE_Y_IN = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[] { 0.9F, 1.0F });
    TITLE_BAR_ALPHA_OUT = PropertyValuesHolder.ofFloat(View.ALPHA, new float[] { 1.0F, 0.0F });
  }
  
  private void getSlideDownAnimation(List<Animator> paramList, View paramView)
  {
    paramView.setVisibility(0);
    paramView.setLayerType(2, Launcher.sViewLayerPaint);
    paramView = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { -this.mTitleBarHeight, 0.0F }), TITLE_BAR_ALPHA_IN });
    paramView.addListener(((Launcher)this.mTabHost.getContext()).getAnimationLayer().mBlockEventsListener);
    paramList.add(paramView);
  }
  
  private void getSlideUpAnimation(List<Animator> paramList, final View paramView)
  {
    paramView.setLayerType(2, Launcher.sViewLayerPaint);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { -paramView.getHeight() }), TITLE_BAR_ALPHA_OUT });
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setLayerType(0, Launcher.sViewLayerPaint);
        paramView.setVisibility(8);
      }
    });
    localObjectAnimator.addListener(((Launcher)this.mTabHost.getContext()).getAnimationLayer().mBlockEventsListener);
    paramList.add(localObjectAnimator);
  }
  
  public void animateInTitleBar(List<Animator> paramList, View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramView != null)
      {
        if (paramView != this.mNormalTitleBar) {
          break label42;
        }
        paramView.setScaleX(1.0F);
        paramView.setScaleY(1.0F);
        paramView.setAlpha(0.0F);
        paramView.setVisibility(0);
        paramView.setTranslationY(0.0F);
      }
    }
    label42:
    do
    {
      return;
      paramView.setAlpha(1.0F);
      break;
      if ((this.mNormalTitleBar != null) && (paramView == this.mNormalTitleBar))
      {
        this.mNormalTitleBar.setVisibility(0);
        this.mNormalTitleBar.setLayerType(2, Launcher.sViewLayerPaint);
        paramList.add(ObjectAnimator.ofPropertyValuesHolder(this.mNormalTitleBar, new PropertyValuesHolder[] { TITLE_BAR_SCALE_X_IN, TITLE_BAR_SCALE_Y_IN, TITLE_BAR_ALPHA_IN }));
        return;
      }
    } while (paramView == null);
    getSlideDownAnimation(paramList, paramView);
  }
  
  public void animateOutTitleBar(List<Animator> paramList, final View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramView != null)
      {
        if (paramView != this.mNormalTitleBar) {
          break label40;
        }
        paramView.setScaleX(0.9F);
        paramView.setScaleY(0.9F);
        paramView.setVisibility(8);
        paramView.setAlpha(0.0F);
      }
    }
    label40:
    do
    {
      return;
      paramView.setTranslationY(-paramView.getHeight());
      break;
      Launcher localLauncher = (Launcher)this.mTabHost.getContext();
      if ((this.mNormalTitleBar != null) && (paramView == this.mNormalTitleBar))
      {
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mNormalTitleBar, new PropertyValuesHolder[] { TITLE_BAR_SCALE_X_OUT, TITLE_BAR_SCALE_Y_OUT, TITLE_BAR_ALPHA_OUT });
        localObjectAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramView.setLayerType(0, Launcher.sViewLayerPaint);
            MenuTitleBarManager.this.mNormalTitleBar.setLayerType(0, Launcher.sViewLayerPaint);
            MenuTitleBarManager.this.mNormalTitleBar.setVisibility(8);
          }
        });
        localObjectAnimator.addListener(localLauncher.getAnimationLayer().mBlockEventsListener);
        paramList.add(localObjectAnimator);
        paramList = localLauncher.getMenuView().getMenuAppsGrid();
        if (paramList != null)
        {
          if (DEBUGGABLE) {
            Log.i("Launcher.MenuTitleBarManager", "current page is " + paramList.getCurrentPage() + " count " + paramList.getChildCount());
          }
          paramList = paramList.getPageAt(paramList.getCurrentPage());
          if (paramList != null)
          {
            paramView = new int[2];
            paramList.getLocationOnScreen(paramView);
            int i = paramView[1];
            this.mNormalTitleBar.getLocationOnScreen(paramView);
            int j = paramView[1];
            this.mNormalTitleBar.setPivotY(i - j + paramList.getPivotY());
            this.mNormalTitleBar.setPivotX(this.mNormalTitleBar.getWidth() / 2.0F);
          }
        }
        this.mNormalTitleBar.setLayerType(2, Launcher.sViewLayerPaint);
        return;
      }
    } while (paramView == null);
    getSlideUpAnimation(paramList, paramView);
  }
  
  public void changeTitleBar(List<Animator> paramList, View paramView, boolean paramBoolean)
  {
    if (paramView == this.mCurrentTitleBar) {
      return;
    }
    animateOutTitleBar(paramList, this.mCurrentTitleBar, paramBoolean);
    animateInTitleBar(paramList, paramView, paramBoolean);
    this.mCurrentTitleBar = paramView;
  }
  
  public void changeTitleBar(List<Animator> paramList, MenuAppsGrid.State paramState, boolean paramBoolean)
  {
    changeTitleBar(paramList, getActiveTitleBarForState(paramState), paramBoolean);
  }
  
  public void changeTitleBar(List<Animator> paramList, MenuWidgets.WidgetState paramWidgetState, boolean paramBoolean)
  {
    changeTitleBar(paramList, getActiveTitleBarForState(paramWidgetState), paramBoolean);
  }
  
  public ViewGroup getActiveTitleBarForState(MenuAppsGrid.State paramState)
  {
    switch (4.$SwitchMap$com$android$launcher2$MenuAppsGrid$State[paramState.ordinal()])
    {
    default: 
      Log.w("Launcher.MenuTitleBarManager", "unknown state when asking for title bar");
      return null;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      if ((this.mSelectedTitleBar == null) && (this.mSelectedTitleBarStub != null))
      {
        this.mSelectedTitleBar = ((ViewGroup)this.mSelectedTitleBarStub.inflate());
        this.mSelectedTitleBarStub = null;
      }
      return this.mSelectedTitleBar;
    case 9: 
      return this.mNormalTitleBar;
    case 10: 
      return this.mEditTitleBar;
    case 11: 
      if ((this.mDownloadedTitleBar == null) && (this.mDownloadedTitleBarStub != null))
      {
        if (this.mDownloadedTitleBarStub.getParent() != null) {
          break label333;
        }
        this.mDownloadedTitleBar = ((ViewGroup)this.mTabHost.findViewById(this.mDownloadedTitleBarStub.getInflatedId()));
        paramState = Launcher.getInstance().getResources();
        String str = paramState.getString(2131755055);
        FrameLayout localFrameLayout = (FrameLayout)this.mTabHost.findViewById(2131689634);
        final Toast localToast = Toast.makeText(Launcher.getInstance(), str, 0);
        if (localFrameLayout != null)
        {
          localFrameLayout.setOnLongClickListener(new View.OnLongClickListener()
          {
            public boolean onLongClick(View paramAnonymousView)
            {
              int i = paramAnonymousView.getWidth() / 2;
              int j = paramAnonymousView.getHeight();
              localToast.setGravity(53, i, j);
              localToast.show();
              return true;
            }
          });
          if (localFrameLayout.getHoverPopupWindow() != null)
          {
            localFrameLayout.setHoverPopupType(1);
            localFrameLayout.getHoverPopupWindow().setContent(str);
            localFrameLayout.getHoverPopupWindow().setPopupGravity(12341);
            localFrameLayout.getHoverPopupWindow().setPopupPosOffset(paramState.getDimensionPixelOffset(2131623960), 0);
            localFrameLayout.getHoverPopupWindow().setFHAnimationEnabled(false);
          }
        }
        if (!LauncherApplication.hasMenuKey()) {
          break label355;
        }
        this.mDownloadedTitleBar.findViewById(2131689634).setVisibility(8);
        this.mDownloadedTitleBar.removeView(this.mDownloadedTitleBar.findViewById(2131689634));
      }
      for (;;)
      {
        return this.mDownloadedTitleBar;
        label333:
        this.mDownloadedTitleBar = ((ViewGroup)this.mDownloadedTitleBarStub.inflate());
        this.mDownloadedTitleBarStub = null;
        break;
        label355:
        this.mDownloadedTitleBar.removeView(this.mDownloadedTitleBar.findViewById(2131689635));
      }
    }
    return this.mUninstallTitleBar;
  }
  
  public ViewGroup getActiveTitleBarForState(MenuWidgets.WidgetState paramWidgetState)
  {
    switch (paramWidgetState)
    {
    default: 
      Log.w("Launcher.MenuTitleBarManager", "unknown widget state when asking for title bar");
      return null;
    case ???: 
      return this.mNormalTitleBar;
    case ???: 
      return this.mUninstallTitleBar;
    }
    this.mSearchTitleBar = ((ViewGroup)this.mTabHost.findViewById(2131689664));
    if (this.mSearchTitleBar == null)
    {
      paramWidgetState = (ViewStub)this.mTabHost.findViewById(2131689663);
      if (paramWidgetState != null) {
        this.mSearchTitleBar = ((ViewGroup)paramWidgetState.inflate());
      }
    }
    return this.mSearchTitleBar;
  }
  
  public View getEditTitleBar()
  {
    return this.mEditTitleBar;
  }
  
  public MenuEditBar getMenuEditBar()
  {
    return this.mMenuEditBar;
  }
  
  public int getTitleBarHeight()
  {
    return this.mTitleBarHeight;
  }
  
  public void hideEditBar(Animator paramAnimator, MenuStateAnimatorSet paramMenuStateAnimatorSet)
  {
    paramMenuStateAnimatorSet.end();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAnimator);
    animateInTitleBar(localArrayList, this.mCurrentTitleBar, false);
    paramMenuStateAnimatorSet.buildAndStart(localArrayList);
  }
  
  public void init(MenuView paramMenuView)
  {
    if (this.mNormalTitleBar != null) {
      return;
    }
    this.mNormalTitleBar = ((ViewGroup)paramMenuView.findViewById(2131689651));
    this.mEditTitleBar = ((ViewGroup)paramMenuView.findViewById(2131689659));
    this.mMenuEditBar = ((MenuEditBar)paramMenuView.findViewById(2131689636));
    this.mUninstallTitleBar = ((ViewGroup)paramMenuView.findViewById(2131689660));
    if (!LauncherApplication.isTabletLayout())
    {
      ViewGroup localViewGroup = (ViewGroup)this.mEditTitleBar.getChildAt(0);
      if (localViewGroup != null)
      {
        int i = 0;
        while (i < localViewGroup.getChildCount())
        {
          localViewGroup.getChildAt(i).setOnKeyListener(FocusHelper.TITLEBAR_KEY_LISTENER);
          i += 1;
        }
      }
    }
    this.mSelectedTitleBar = ((ViewGroup)paramMenuView.findViewById(2131689666));
    if (this.mSelectedTitleBar == null) {
      this.mSelectedTitleBarStub = ((ViewStub)paramMenuView.findViewById(2131689665));
    }
    this.mDownloadedTitleBar = ((ViewGroup)paramMenuView.findViewById(2131689662));
    if (this.mDownloadedTitleBar == null) {
      this.mDownloadedTitleBarStub = ((ViewStub)paramMenuView.findViewById(2131689661));
    }
    this.mTabHost = paramMenuView;
    this.mCurrentTitleBar = this.mNormalTitleBar;
    this.mTitleBarHeight = paramMenuView.getResources().getDimensionPixelSize(2131623958);
  }
  
  public void resetTitleBar(View paramView)
  {
    setTitleBarVisibility(paramView, 0);
    paramView.setAlpha(1.0F);
  }
  
  public void resetTitleBar(MenuAppsGrid.State paramState)
  {
    resetTitleBar(getActiveTitleBarForState(paramState));
  }
  
  public void setEditBarClickListener(MenuAppsGrid.MenuEditTabClickListener paramMenuEditTabClickListener)
  {
    this.mEditTitleBar.findViewById(2131689590).setOnClickListener(paramMenuEditTabClickListener);
    this.mEditTitleBar.findViewById(2131689645).setOnClickListener(paramMenuEditTabClickListener);
    View localView = (View)this.mEditTitleBar.findViewById(2131689639).getParent();
    if (localView != null)
    {
      localView.setOnClickListener(paramMenuEditTabClickListener);
      localView.setContentDescription(Launcher.getInstance().getString(2131755057) + " " + Launcher.getInstance().getString(2131755095));
    }
  }
  
  public void setTitleBarVisibility(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      paramView.setTranslationY(0.0F);
    }
  }
  
  public void setTitleBarVisibility(MenuAppsGrid.State paramState, int paramInt)
  {
    setTitleBarVisibility(getActiveTitleBarForState(paramState), paramInt);
  }
  
  public void showEditBar(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MenuStateAnimatorSet paramMenuStateAnimatorSet, boolean paramBoolean5)
  {
    if (this.mMenuEditBar != null)
    {
      paramMenuStateAnimatorSet.end();
      ArrayList localArrayList = new ArrayList();
      animateOutTitleBar(localArrayList, this.mCurrentTitleBar, false);
      this.mMenuEditBar.show(((Launcher)this.mTabHost.getContext()).getMenuView().getMenuAppsGrid(), localArrayList, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
      paramMenuStateAnimatorSet.buildAndStart(localArrayList);
    }
  }
  
  public void slideDownTitleBar(MenuAppsGrid.State paramState, MenuStateAnimatorSet paramMenuStateAnimatorSet)
  {
    ArrayList localArrayList = new ArrayList();
    getSlideDownAnimation(localArrayList, getActiveTitleBarForState(paramState));
    paramMenuStateAnimatorSet.buildAndStart(localArrayList);
  }
  
  public void slideDownTitleBar(MenuAppsGrid.State paramState, List<Animator> paramList)
  {
    getSlideDownAnimation(paramList, getActiveTitleBarForState(paramState));
  }
  
  public void slideUpTitleBar(MenuAppsGrid.State paramState, MenuStateAnimatorSet paramMenuStateAnimatorSet)
  {
    ArrayList localArrayList = new ArrayList();
    getSlideUpAnimation(localArrayList, getActiveTitleBarForState(paramState));
    paramMenuStateAnimatorSet.buildAndStart(localArrayList);
  }
  
  public void slideUpTitleBar(MenuAppsGrid.State paramState, List<Animator> paramList)
  {
    getSlideUpAnimation(paramList, getActiveTitleBarForState(paramState));
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuTitleBarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */