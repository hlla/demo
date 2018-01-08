package com.android.launcher2.guide;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class NavigationGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "NavigationGuider";
  private static boolean isNavigationDialogVisible = false;
  static ViewGroup layout;
  static View menuLayout;
  
  public NavigationGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("NavigationGuider", "NavigationGuider");
  }
  
  public void dismissHelpDialog()
  {
    if (!isNavigationDialogVisible) {}
    HomeView localHomeView;
    Launcher localLauncher;
    do
    {
      return;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localLauncher = (Launcher)getActivity();
    } while (localHomeView == null);
    Log.d("NavigationGuider", " frag!=null");
    layout = GuideFragment.findMainView(localLauncher);
    int i = layout.getChildCount();
    if (i != 0)
    {
      layout.removeViewAt(i - 1);
      isNavigationDialogVisible = false;
    }
    GuideFragment.mGuider = null;
  }
  
  public void onActivityCreated(Bundle paramBundle) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    dismissHelpDialog();
    switch (GuideFragment.sHelpHubStepNumber)
    {
    default: 
      return;
    }
    showHelpDialog();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    if (isNavigationDialogVisible) {}
    HomeView localHomeView;
    Launcher localLauncher;
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 1;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localLauncher = (Launcher)getActivity();
    } while (localHomeView == null);
    layout = GuideFragment.findMainView(localLauncher);
    menuLayout = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2130903059, layout, true);
    isNavigationDialogVisible = true;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/NavigationGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */