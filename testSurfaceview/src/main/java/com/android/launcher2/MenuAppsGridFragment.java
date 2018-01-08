package com.android.launcher2;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.android.launcher2.mainmenu.PinchLayerView;
import com.android.launcher2.mainmenu.PinchLayerView.OnPinchListener;
import java.util.List;

public final class MenuAppsGridFragment
  extends Fragment
  implements MenuView.AppModelNotifications, Launcher.HardwareKeys, MenuView.NeedsTabHost, PinchLayerView.OnPinchListener, PagedView.PageSwitchListener
{
  private static final String APP_GRID_SAVED_STATE = "MENU_APP_GRID_SAVED_STATE";
  public static String DL_APPS_FROM_LISTVIEW_MODE;
  public static String DL_APPS_FROM_WIDGET_TAB_WITH_LISTVIEW_MODE = "FromDownloadedAppsReturnToWidgetsTabMenuIsInListViewMode";
  public static String DL_APPS_FROM_WIDGET_WITH_GRIDVIEW_MODE = "FromDownloadedAppsReturntoWidgetsTabMenuIsInGridViewMode";
  public static String DL_UNINSTALL_MODE = "WeAreCurrentlyInDownloadedUninstallMode";
  public static final String DONT_CHG_STATE_ON_PREDRAW = "DONT_CHG_STATE_ON_PREDRAW";
  private static final String FOLDER_STATE_BUNDLE = "folderStateBundle";
  public static String SHARE_SELECT_MODE;
  private static final String TAG = "MenuAppsGridFragment";
  public static String WIDGET_TAB_WITH_GRIDVIEW_MODE;
  public static String WIDGET_TAB_WITH_LISTVIEW_MODE;
  private MenuAppsGrid mAppsGrid;
  private Bundle mFolderBundle;
  private boolean mIsPaused = false;
  public ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
  private boolean mPendingModelUpdate = false;
  private PinchLayerView mPinchLayer;
  private MenuAppsGrid.State mState;
  private MenuView mTabHost;
  private MenuView.ViewType mViewType;
  
  static
  {
    DL_APPS_FROM_LISTVIEW_MODE = "FromDownloadedAppsReturnToListViewMode";
    WIDGET_TAB_WITH_LISTVIEW_MODE = "WeAreCurrentlyInWidgetTabWithMenuInListViewMode";
    WIDGET_TAB_WITH_GRIDVIEW_MODE = "WeAreCurrentlyInWidgetTabWithMenuInGridViewMode";
    SHARE_SELECT_MODE = "WeAreCurrentlyInShareSelectMode";
  }
  
  private void cancelAppFolderRemoveDialog()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    AppFolderRemoveDialog.dismiss(localFragmentManager.beginTransaction(), localFragmentManager);
  }
  
  private void closeDialog()
  {
    if (getState() == MenuAppsGrid.State.EDIT) {
      MenuAppModel.INSTANCE.setFolderToDelete(null);
    }
    Object localObject = getFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    AppFolderRemoveDialog.dismiss(localFragmentTransaction, (FragmentManager)localObject);
    localObject = (DialogFragment)getFragmentManager().findFragmentByTag("editCancelDialog");
    if (localObject != null)
    {
      ((DialogFragment)localObject).dismiss();
      localFragmentTransaction.remove((Fragment)localObject);
    }
    localObject = (DialogFragment)getFragmentManager().findFragmentByTag("AddAppsWidgetToastPopUp");
    if (localObject != null)
    {
      ((DialogFragment)localObject).dismiss();
      localFragmentTransaction.remove((Fragment)localObject);
    }
    localFragmentTransaction.addToBackStack(null);
  }
  
  private void updatePinchListener(MenuView.ViewType paramViewType, MenuAppsGrid.State paramState)
  {
    if (this.mPinchLayer != null)
    {
      if (((paramViewType == MenuView.ViewType.CUSTOM_GRID) || (paramViewType == MenuView.ViewType.ALPHABETIC_GRID)) && (paramState == MenuAppsGrid.State.NORMAL)) {
        this.mPinchLayer.setOnPinchListener(this);
      }
    }
    else {
      return;
    }
    this.mPinchLayer.setOnPinchListener(null);
  }
  
  public void appBadgeUpdated(List<AppItem> paramList)
  {
    if (this.mAppsGrid != null) {
      this.mAppsGrid.appBadgeUpdated(paramList);
    }
  }
  
  public void appModelLoaded()
  {
    if (this.mAppsGrid != null) {
      appModelUpdated();
    }
  }
  
  public void appModelUpdated()
  {
    if (this.mAppsGrid != null)
    {
      if (this.mIsPaused) {
        this.mPendingModelUpdate = true;
      }
    }
    else {
      return;
    }
    this.mAppsGrid.appModelUpdated();
  }
  
  public void changeState(MenuAppsGrid.State paramState)
  {
    changeState(paramState, false);
  }
  
  public void changeState(MenuAppsGrid.State paramState, boolean paramBoolean)
  {
    MenuAppsGrid.State localState = this.mState;
    if ((paramState != localState) || (paramBoolean))
    {
      this.mState = paramState;
      updatePinchListener(this.mViewType, paramState);
      if ((this.mAppsGrid != null) && (localState != null)) {
        this.mAppsGrid.handleStateChange(paramState, localState);
      }
    }
  }
  
  public void closeFolders()
  {
    if (this.mAppsGrid != null) {
      this.mAppsGrid.closeFolder(false, true);
    }
  }
  
  public MenuAppsGrid getMenuAppsGrid()
  {
    return this.mAppsGrid;
  }
  
  public MenuAppsGrid.State getState()
  {
    return this.mState;
  }
  
  public void handleDownloadedAppsStateChange()
  {
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    if (getActivity() != null)
    {
      localSharedPreferences = ((Launcher)getActivity()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
      localEditor = localSharedPreferences.edit();
      if (localSharedPreferences.getBoolean(DL_APPS_FROM_WIDGET_WITH_GRIDVIEW_MODE, false))
      {
        localEditor.putBoolean(DL_APPS_FROM_WIDGET_WITH_GRIDVIEW_MODE, false);
        localEditor.putBoolean(WIDGET_TAB_WITH_GRIDVIEW_MODE, true);
        localEditor.commit();
        ((Launcher)getActivity()).getMenuView().selectWidgetsTab();
      }
    }
    else
    {
      return;
    }
    if (localSharedPreferences.getBoolean(DL_APPS_FROM_LISTVIEW_MODE, false))
    {
      localEditor.putBoolean(DL_APPS_FROM_LISTVIEW_MODE, false);
      localEditor.commit();
      ((Launcher)getActivity()).getMenuView().selectAppsTab();
      ((Launcher)getActivity()).getMenuView().setViewType(MenuView.ViewType.ALPHABETIC_LIST);
      return;
    }
    if (localSharedPreferences.getBoolean(DL_APPS_FROM_WIDGET_TAB_WITH_LISTVIEW_MODE, false))
    {
      localEditor.putBoolean(DL_APPS_FROM_WIDGET_TAB_WITH_LISTVIEW_MODE, false);
      localEditor.putBoolean(WIDGET_TAB_WITH_LISTVIEW_MODE, true);
      localEditor.commit();
      ((Launcher)getActivity()).getMenuView().setViewType(MenuView.ViewType.ALPHABETIC_LIST);
      ((Launcher)getActivity()).getMenuView().selectWidgetsTab();
      return;
    }
    changeState(MenuAppsGrid.State.NORMAL);
  }
  
  public boolean onBackPressed()
  {
    boolean bool1;
    if (getState() == null) {
      bool1 = false;
    }
    do
    {
      boolean bool2;
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
                bool2 = true;
                if (this.mAppsGrid == null) {
                  break;
                }
                bool1 = bool2;
              } while (this.mAppsGrid.closeFolder(true, true));
              switch (getState())
              {
              default: 
                changeState(MenuAppsGrid.State.NORMAL);
                return true;
              case ???: 
                return false;
              case ???: 
                bool1 = bool2;
              }
            } while (this.mAppsGrid == null);
            ((MenuAppsGrid.StateShareAppSelect)getState().getObj(this.mAppsGrid)).returnToPreviousState();
            return true;
            changeState(MenuAppsGrid.State.DOWNLOADED_APPS);
            return true;
            bool1 = bool2;
          } while (this.mAppsGrid == null);
          ((MenuAppsGrid.StateFolderSelect)getState().getObj(this.mAppsGrid)).backState();
          return true;
          bool1 = bool2;
        } while (this.mAppsGrid == null);
        bool1 = bool2;
      } while (this.mAppsGrid.getStateObj() == null);
      ((MenuAppsGrid.StatePageEdit)this.mAppsGrid.getStateObj()).exitWithAnimaton();
      return true;
      bool1 = bool2;
    } while (HomeView.sIsDragState);
    if (this.mAppsGrid != null) {
      this.mAppsGrid.saveEditChanges();
    }
    handleDownloadedAppsStateChange();
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onCreateView. savedInstanceState: ");
    String str;
    if (paramBundle == null)
    {
      str = "null";
      Log.d("MenuAppsGridFragment", str);
      this.mPinchLayer = ((PinchLayerView)paramLayoutInflater.inflate(2130903099, paramViewGroup, false));
      this.mAppsGrid = ((MenuAppsGrid)this.mPinchLayer.findViewById(2131689632));
      this.mAppsGrid.setPageSwitchListener(this);
      this.mAppsGrid.setMenuAppsGridFragment(this);
      FolderIconView.setMenuAppsGridFragment(this);
      this.mState = MenuAppsGrid.State.NORMAL;
      if (paramBundle != null)
      {
        int i = paramBundle.getInt("MENU_APP_GRID_SAVED_STATE", -1);
        if (-1 != i) {
          this.mState = MenuAppsGrid.State.values()[i];
        }
        if (!this.mState.getObj(this.mAppsGrid).restore(paramBundle)) {
          break label269;
        }
        this.mFolderBundle = paramBundle.getBundle("folderStateBundle");
      }
    }
    for (;;)
    {
      if (this.mTabHost != null) {
        setTabHost(this.mTabHost);
      }
      if (this.mViewType == null) {
        this.mViewType = MenuView.ViewType.valueOf(getActivity().getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("MenuView.ViewType", MenuView.ViewType.CUSTOM_GRID.name()));
      }
      setViewType(this.mViewType);
      if (this.mAppsGrid != null) {
        this.mAppsGrid.appModelUpdated();
      }
      updatePinchListener(this.mViewType, getState());
      onShowTab(this.mTabHost);
      cancelAppFolderRemoveDialog();
      return this.mPinchLayer;
      str = "not null";
      break;
      label269:
      this.mState = MenuAppsGrid.State.NORMAL;
    }
  }
  
  public void onDestroyView()
  {
    Log.d("MenuAppsGridFragment", "onDestroyView");
    super.onDestroyView();
    onHideTab(this.mTabHost);
    this.mPinchLayer = null;
    this.mAppsGrid = null;
    this.mViewType = null;
  }
  
  public void onExitAllApps()
  {
    if (this.mAppsGrid != null)
    {
      if (this.mAppsGrid.getState() == MenuAppsGrid.State.PAGE_EDIT) {
        changeState(MenuAppsGrid.State.NORMAL);
      }
      this.mAppsGrid.onExitAllApps();
    }
  }
  
  public void onHideTab(MenuView paramMenuView)
  {
    if (this.mAppsGrid != null)
    {
      this.mFolderBundle = new Bundle();
      this.mAppsGrid.saveOpenFolderState(this.mFolderBundle);
      this.mAppsGrid.setCurrentPage(this.mAppsGrid.getComingPage());
      this.mAppsGrid.leaveCurrentState();
    }
  }
  
  public boolean onHomePressed(boolean paramBoolean)
  {
    paramBoolean = true;
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBoolean = false;
      return paramBoolean;
    }
    localObject = ((Activity)localObject).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    MenuAppsGrid.State localState = getState();
    switch (localState)
    {
    }
    for (;;)
    {
      return false;
      if (this.mAppsGrid != null)
      {
        ((MenuAppsGrid.StatePageEdit)this.mAppsGrid.getStateObj(localState)).exitWithoutAnimation();
        continue;
        if (this.mAppsGrid != null) {
          ((MenuAppsGrid.StateFolderSelect)getState().getObj(this.mAppsGrid)).backState();
        }
        for (;;)
        {
          closeDialog();
          break;
          changeState(MenuAppsGrid.State.EDIT);
          MenuAppModel.INSTANCE.editBegin();
        }
        ((SharedPreferences.Editor)localObject).putBoolean(SHARE_SELECT_MODE, true);
        ((SharedPreferences.Editor)localObject).commit();
        closeDialog();
        continue;
        if ((this.mAppsGrid != null) && (this.mAppsGrid.isDragInProgress())) {
          break;
        }
        closeDialog();
        if (this.mAppsGrid != null)
        {
          this.mAppsGrid.appModelUpdated();
          continue;
          ((SharedPreferences.Editor)localObject).putBoolean(DL_UNINSTALL_MODE, true);
          ((SharedPreferences.Editor)localObject).commit();
          continue;
          closeDialog();
          continue;
          closeDialog();
        }
      }
    }
  }
  
  public void onPageSwitch(View paramView, int paramInt)
  {
    if (this.mAppsGrid != null) {
      this.mAppsGrid.closeFolder(true, true);
    }
  }
  
  public void onPause()
  {
    this.mIsPaused = true;
    if (this.mAppsGrid != null)
    {
      this.mAppsGrid.closeFolder(true, false);
      this.mAppsGrid.onPause();
    }
    super.onPause();
  }
  
  public boolean onPinch()
  {
    if ((getState() != MenuAppsGrid.State.NORMAL) || (this.mAppsGrid.isFastScrolling()) || (Launcher.isPopupMenuShowing()) || (this.mIsPaused) || (!((Launcher)getActivity()).getMenuView().getCurrentFragment()) || (Launcher.isHelpAppRunning)) {
      return false;
    }
    changeState(MenuAppsGrid.State.PAGE_EDIT);
    return true;
  }
  
  public void onResume()
  {
    Log.d("MenuAppsGridFragment", "onResume");
    this.mIsPaused = false;
    super.onResume();
    Object localObject = getActivity().getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
    if (this.mAppsGrid != null)
    {
      if (!((SharedPreferences)localObject).getBoolean(SHARE_SELECT_MODE, false)) {
        break label106;
      }
      changeState(MenuAppsGrid.State.SHARE_SELECT);
    }
    for (;;)
    {
      localObject = this.mAppsGrid.getStateObj();
      if (localObject != null) {
        ((MenuAppsGrid.StateObj)localObject).onResume();
      }
      this.mAppsGrid.onResume();
      if ((this.mAppsGrid != null) && (this.mPendingModelUpdate))
      {
        this.mAppsGrid.appModelUpdated();
        this.mPendingModelUpdate = false;
      }
      return;
      label106:
      if (((SharedPreferences)localObject).getBoolean(DL_UNINSTALL_MODE, false))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean(DL_UNINSTALL_MODE, false);
        ((SharedPreferences.Editor)localObject).commit();
      }
      else if ((((SharedPreferences)localObject).getBoolean(DL_APPS_FROM_LISTVIEW_MODE, false)) || (((SharedPreferences)localObject).getBoolean(DL_APPS_FROM_WIDGET_TAB_WITH_LISTVIEW_MODE, false)))
      {
        changeState(MenuAppsGrid.State.DOWNLOADED_APPS);
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mState != null)
    {
      paramBundle.putInt("MENU_APP_GRID_SAVED_STATE", this.mState.ordinal());
      if (this.mAppsGrid != null)
      {
        this.mState.getObj(this.mAppsGrid).save(paramBundle);
        Bundle localBundle = new Bundle();
        this.mAppsGrid.saveOpenFolderState(localBundle);
        paramBundle.putBundle("folderStateBundle", localBundle);
      }
    }
  }
  
  public void onShowTab(MenuView paramMenuView)
  {
    if ((paramMenuView != null) && (this.mAppsGrid != null) && (paramMenuView.isCurrentTabAppGrid()))
    {
      if (Launcher.isOptionMenuShowing()) {
        ((Launcher)getActivity()).closePopupMenu();
      }
      if (this.mOnPreDrawListener == null)
      {
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            if (MenuAppsGridFragment.this.mAppsGrid == null) {}
            boolean bool1;
            boolean bool2;
            do
            {
              return true;
              bool1 = MenuAppsGridFragment.this.mAppsGrid.isShown();
              bool2 = ((Launcher)MenuAppsGridFragment.this.mAppsGrid.getContext()).isExitingAllApps();
            } while ((!bool1) || (bool2));
            Object localObject1 = MenuAppsGridFragment.this.getActivity().getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
            Object localObject2;
            if (MenuAppsGridFragment.this.mState.equals(MenuAppsGrid.State.EDIT))
            {
              localObject2 = MenuAppsGridFragment.this.getFragmentManager();
              FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
              if ((AppFolderRemoveDialog.isActive((FragmentManager)localObject2)) && (MenuAppModel.INSTANCE.getFolderToDelete() == null)) {
                AppFolderRemoveDialog.dismiss(localFragmentTransaction, (FragmentManager)localObject2);
              }
            }
            if (((SharedPreferences)localObject1).getBoolean(MenuAppsGridFragment.WIDGET_TAB_WITH_GRIDVIEW_MODE, false))
            {
              localObject2 = ((SharedPreferences)localObject1).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean(MenuAppsGridFragment.WIDGET_TAB_WITH_GRIDVIEW_MODE, false);
              ((SharedPreferences.Editor)localObject2).commit();
              MenuAppsGridFragment.access$202(MenuAppsGridFragment.this, MenuView.ViewType.valueOf(((SharedPreferences)localObject1).getString("MenuView.ViewType", MenuView.ViewType.CUSTOM_GRID.name())));
              ((Launcher)MenuAppsGridFragment.this.getActivity()).getMenuView().setViewType(MenuAppsGridFragment.this.mViewType);
              ((Launcher)MenuAppsGridFragment.this.getActivity()).getMenuView().selectAppsTab();
              MenuAppsGridFragment.this.changeState(MenuAppsGrid.State.NORMAL);
              if (!((Launcher)MenuAppsGridFragment.this.mAppsGrid.getContext()).getTransitionToAllApps()) {
                break label438;
              }
              MenuAppsGridFragment.this.mAppsGrid.postDelayed(new Runnable()
              {
                public void run()
                {
                  if (MenuAppsGridFragment.this.mAppsGrid != null)
                  {
                    MenuAppsGridFragment.this.mAppsGrid.restoreOpenFolderState(MenuAppsGridFragment.this.mFolderBundle);
                    MenuAppsGridFragment.access$402(MenuAppsGridFragment.this, null);
                  }
                }
              }, Launcher.SHOW_ALL_APPS_TRANSITION_DURATION);
            }
            for (;;)
            {
              ((Launcher)MenuAppsGridFragment.this.getActivity()).restorePopupMenu();
              MenuAppsGridFragment.this.mAppsGrid.getViewTreeObserver().removeOnPreDrawListener(MenuAppsGridFragment.this.mOnPreDrawListener);
              MenuAppsGridFragment.this.mOnPreDrawListener = null;
              return true;
              if (((SharedPreferences)localObject1).getBoolean(MenuAppsGridFragment.WIDGET_TAB_WITH_LISTVIEW_MODE, false))
              {
                localObject1 = ((SharedPreferences)localObject1).edit();
                ((SharedPreferences.Editor)localObject1).putBoolean(MenuAppsGridFragment.WIDGET_TAB_WITH_LISTVIEW_MODE, false);
                ((SharedPreferences.Editor)localObject1).commit();
                break;
              }
              if (((SharedPreferences)localObject1).getBoolean("DONT_CHG_STATE_ON_PREDRAW", false))
              {
                MenuAppsGridFragment.this.mTabHost.getTitleBarManager().setTitleBarVisibility(MenuAppsGrid.State.NORMAL, 0);
                localObject1 = ((SharedPreferences)localObject1).edit();
                ((SharedPreferences.Editor)localObject1).putBoolean("DONT_CHG_STATE_ON_PREDRAW", false);
                ((SharedPreferences.Editor)localObject1).commit();
                break;
              }
              MenuAppsGridFragment.this.mAppsGrid.handleStateChange(MenuAppsGridFragment.this.mState, MenuAppsGrid.State.UNKNOWN);
              break;
              label438:
              MenuAppsGridFragment.this.mAppsGrid.restoreOpenFolderState(MenuAppsGridFragment.this.mFolderBundle);
              MenuAppsGridFragment.access$402(MenuAppsGridFragment.this, null);
            }
          }
        };
        this.mAppsGrid.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    closeFolders();
    if (this.mAppsGrid != null) {
      this.mAppsGrid.onStop();
    }
  }
  
  public void setTabHost(MenuView paramMenuView)
  {
    this.mTabHost = paramMenuView;
    if (this.mAppsGrid != null) {
      this.mAppsGrid.setTabHost(paramMenuView);
    }
  }
  
  public void setViewType(MenuView.ViewType paramViewType)
  {
    updatePinchListener(paramViewType, getState());
    if (this.mAppsGrid != null) {
      this.mAppsGrid.setViewType(paramViewType);
    }
    this.mViewType = paramViewType;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuAppsGridFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */