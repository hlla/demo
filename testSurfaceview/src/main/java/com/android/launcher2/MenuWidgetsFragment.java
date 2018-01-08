package com.android.launcher2;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.DVFSHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.android.launcher2.mainmenu.PinchLayerView;
import com.android.launcher2.mainmenu.PinchLayerView.OnPinchListener;
import com.sec.dtl.launcher.Talk;

public final class MenuWidgetsFragment
  extends Fragment
  implements Launcher.HardwareKeys, MenuView.PackageNotifications, PinchLayerView.OnPinchListener, MenuView.NeedsTabHost
{
  private static final String WIDGET_SAVED_STATE = "WIDGET_SAVED_STATE";
  private static final String WIDGET_STATE_BUNDLE = "WIDGET_STATE_BUNDLE";
  private static DVFSHelper cpuBooster = null;
  private boolean comeFromHelp = false;
  private boolean mIsPaused = false;
  private boolean mPendingPackageUpdate = false;
  private PinchLayerView mPinchLayer;
  private MenuView mTabHost;
  private MenuWidgets.WidgetState mWidgetState;
  private Bundle mWidgetStateBundle;
  private MenuWidgets mWidgets;
  
  private void updatePinchListener()
  {
    if (this.mPinchLayer == null) {
      return;
    }
    if (this.mWidgetState == MenuWidgets.WidgetState.NORMAL)
    {
      this.mPinchLayer.setOnPinchListener(this);
      return;
    }
    this.mPinchLayer.setOnPinchListener(null);
  }
  
  public void changeWidgetState(MenuWidgets.WidgetState paramWidgetState)
  {
    MenuWidgets.WidgetState localWidgetState = this.mWidgetState;
    if (paramWidgetState != localWidgetState)
    {
      this.mWidgetState = paramWidgetState;
      updatePinchListener();
      if (this.mWidgets != null)
      {
        this.mWidgets.setSearchString("");
        this.mWidgets.handleWidgetStateChange(paramWidgetState, localWidgetState);
      }
    }
  }
  
  public MenuWidgets getMenuWidgets()
  {
    return this.mWidgets;
  }
  
  public MenuView getTabHost()
  {
    return this.mTabHost;
  }
  
  public MenuWidgets.WidgetState getWidgetState()
  {
    return this.mWidgetState;
  }
  
  public boolean onBackPressed()
  {
    if (this.mWidgetState == null) {
      return false;
    }
    WidgetFolder localWidgetFolder = this.mWidgets.getWidgetFolder();
    switch (this.mWidgetState)
    {
    default: 
      if ((localWidgetFolder != null) && (localWidgetFolder.isOpened())) {
        this.mWidgets.closeFolder();
      }
      break;
    }
    for (;;)
    {
      return true;
      if ((localWidgetFolder == null) || (!localWidgetFolder.isOpened())) {
        break;
      }
      this.mWidgets.closeFolder();
      continue;
      if ((localWidgetFolder != null) && (localWidgetFolder.isOpened()))
      {
        this.mWidgets.closeFolder();
      }
      else
      {
        changeWidgetState(MenuWidgets.WidgetState.NORMAL);
        continue;
        ((MenuWidgets.WidgetStatePageEdit)this.mWidgets.getWidgetStateObj()).exitWithAnimation();
        continue;
        changeWidgetState(MenuWidgets.WidgetState.NORMAL);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mPinchLayer = ((PinchLayerView)paramLayoutInflater.inflate(2130903118, paramViewGroup, false));
    this.mWidgets = ((MenuWidgets)this.mPinchLayer.findViewById(2131689670));
    cpuBooster = LauncherApplication.getInst().getCpuBoosterObject();
    cpuBooster.addExtraOptionsByDefaultPolicy("Launcher_touch");
    cpuBooster.acquire(1000);
    if (this.mWidgets != null)
    {
      this.mWidgets.setMenuWidgetsFragment(this);
      this.mWidgets.updatePackages("onCreateView");
    }
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("WIDGET_SAVED_STATE", -1);
      if (-1 == i)
      {
        this.mWidgetState = MenuWidgets.WidgetState.NORMAL;
        this.mWidgetStateBundle = paramBundle.getBundle("WIDGET_STATE_BUNDLE");
        this.mWidgetState.getObj(this.mWidgets).restore(this.mWidgetStateBundle);
      }
    }
    for (;;)
    {
      if (this.mTabHost != null) {
        setTabHost(this.mTabHost);
      }
      updatePinchListener();
      onShowTab(this.mTabHost);
      return this.mPinchLayer;
      this.mWidgetState = MenuWidgets.WidgetState.values()[i];
      break;
      if (this.mWidgetState == null) {
        this.mWidgetState = MenuWidgets.WidgetState.NORMAL;
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    onHideTab(this.mTabHost);
    this.mPinchLayer = null;
    this.mWidgets.cleanupCache("onDestroyView");
    this.mWidgets = null;
  }
  
  public void onExitAllApps()
  {
    if (this.mWidgets != null)
    {
      this.mWidgetStateBundle = new Bundle();
      if ((this.mWidgets.getWidgetState() == MenuWidgets.WidgetState.PAGE_EDIT) || (this.mWidgets.getWidgetState() == MenuWidgets.WidgetState.SEARCH)) {
        changeWidgetState(MenuWidgets.WidgetState.NORMAL);
      }
      if (this.mWidgetState != null) {
        this.mWidgetState.getObj(this.mWidgets).save(this.mWidgetStateBundle);
      }
    }
  }
  
  public void onHideTab(MenuView paramMenuView) {}
  
  public boolean onHomePressed(boolean paramBoolean)
  {
    if (this.mWidgetState == MenuWidgets.WidgetState.PAGE_EDIT) {
      changeWidgetState(MenuWidgets.WidgetState.NORMAL);
    }
    if (this.mWidgets != null) {
      this.mWidgets.closeFolder();
    }
    AddAppsWidgetToastPopUp.dismiss(getFragmentManager());
    return false;
  }
  
  public void onOptionSelectedSearch(MenuView paramMenuView)
  {
    changeWidgetState(MenuWidgets.WidgetState.SEARCH);
  }
  
  public void onOptionSelectedUninstall(MenuView paramMenuView)
  {
    changeWidgetState(MenuWidgets.WidgetState.UNINSTALL);
  }
  
  public void onPause()
  {
    this.mIsPaused = true;
    super.onPause();
    WidgetFolder localWidgetFolder = this.mWidgets.getWidgetFolder();
    if ((localWidgetFolder != null) && (localWidgetFolder.isOpened())) {
      this.mWidgets.closeFolder();
    }
  }
  
  public boolean onPinch()
  {
    return true;
  }
  
  public void onResume()
  {
    this.mIsPaused = false;
    super.onResume();
    if ((this.comeFromHelp) && (!Launcher.isHelpAppRunning))
    {
      this.mWidgets.setMenuWidgetsFragment(this);
      this.mWidgets.updatePackages("onCreateView");
      this.comeFromHelp = false;
    }
    if ((!this.comeFromHelp) && (Launcher.isHelpAppRunning) && (this.mWidgets != null))
    {
      this.mWidgets.setMenuWidgetsFragment(this);
      this.mWidgets.updatePackages("onCreateView");
      this.comeFromHelp = true;
    }
    if ((this.comeFromHelp) && (Launcher.isHelpAppRunning))
    {
      this.mWidgets.setMenuWidgetsFragment(this);
      this.mWidgets.updatePackages("onCreateView");
      this.comeFromHelp = true;
    }
    if ((this.mPendingPackageUpdate) && (this.mWidgets != null))
    {
      this.mPendingPackageUpdate = false;
      this.mWidgets.packagesChanged();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mWidgetState != null)
    {
      paramBundle.putInt("WIDGET_SAVED_STATE", this.mWidgetState.ordinal());
      if (this.mWidgets != null)
      {
        this.mWidgetStateBundle = new Bundle();
        this.mWidgetState.getObj(this.mWidgets).save(this.mWidgetStateBundle);
        paramBundle.putBundle("WIDGET_STATE_BUNDLE", this.mWidgetStateBundle);
      }
    }
  }
  
  public void onShowTab(MenuView paramMenuView)
  {
    if ((this.mWidgets != null) && (paramMenuView != null) && (paramMenuView.isCurrentTabWidgets()))
    {
      if (Launcher.isOptionMenuShowing()) {
        ((Launcher)getActivity()).closePopupMenu();
      }
      this.mWidgets.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          if ((MenuWidgetsFragment.this.mWidgets == null) || (!MenuWidgetsFragment.this.mWidgets.isShown())) {
            return true;
          }
          if ((MenuWidgetsFragment.this.mWidgets != null) && (MenuWidgetsFragment.this.mWidgets.mDragOnSearchState))
          {
            MenuWidgetsFragment.this.mWidgets.updatePackages("Drag on widget search state");
            MenuWidgetsFragment.this.mWidgets.mDragOnSearchState = false;
          }
          MenuWidgetsFragment.this.mWidgets.handleWidgetStateChange(MenuWidgetsFragment.this.mWidgetState, null);
          if (MenuWidgetsFragment.this.mWidgetState != null) {
            MenuWidgetsFragment.this.mWidgetState.getObj(MenuWidgetsFragment.this.mWidgets).restore(MenuWidgetsFragment.this.mWidgetStateBundle);
          }
          if ((!((Launcher)MenuWidgetsFragment.this.mTabHost.getContext()).getTransitionToAllApps()) && (!((Launcher)MenuWidgetsFragment.this.mTabHost.getContext()).isPaused())) {
            Talk.INSTANCE.sayByTalkback(32, MenuWidgetsFragment.this.getResources().getString(2131755011), false);
          }
          ((Launcher)MenuWidgetsFragment.this.getActivity()).restorePopupMenu();
          MenuWidgetsFragment.this.mWidgets.getViewTreeObserver().removeOnPreDrawListener(this);
          return true;
        }
      });
    }
  }
  
  public void onStop()
  {
    super.onStop();
    WidgetFolder localWidgetFolder = this.mWidgets.getWidgetFolder();
    if ((localWidgetFolder != null) && (localWidgetFolder.isOpened())) {
      this.mWidgets.closeFolder();
    }
    this.mWidgets.onStop();
  }
  
  public void packagesChanged()
  {
    if (this.mWidgets != null)
    {
      if (this.mIsPaused) {
        this.mPendingPackageUpdate = true;
      }
    }
    else {
      return;
    }
    this.mWidgets.packagesChanged();
  }
  
  public void refreshWidgetStateModel()
  {
    if (this.mWidgets != null) {
      this.mWidgets.refreshWidgetStateModel(this.mWidgetState);
    }
  }
  
  public void refreshWidgetStateView()
  {
    if (this.mWidgets != null) {
      this.mWidgets.refreshWidgetStateView(this.mWidgetState);
    }
  }
  
  public void setTabHost(MenuView paramMenuView)
  {
    this.mTabHost = paramMenuView;
    if (this.mWidgets != null) {
      this.mWidgets.setTabHost(paramMenuView);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuWidgetsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */