package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class MoveAppsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "NavigationGuider";
  private static boolean isMoveAppsDialog_Visible = false;
  static ViewGroup layout;
  static View menuLayout;
  private View mGoalAnimationView;
  
  public MoveAppsGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("NavigationGuider", "MoveAppsGuider");
  }
  
  public void dismissHelpDialog()
  {
    dismissHelpDialog_step1();
  }
  
  public void dismissHelpDialog_step1()
  {
    if (!isMoveAppsDialog_Visible) {}
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
      isMoveAppsDialog_Visible = false;
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
    case 1: 
      showHelpDialog_step1();
      return;
    }
    showHelpDialog_step2();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    showHelpDialog_step1();
  }
  
  public void showHelpDialog_step1()
  {
    if (isMoveAppsDialog_Visible) {}
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 1;
      localObject1 = (Launcher)getActivity();
      localObject2 = ((Launcher)getActivity()).getHomeView();
    } while (localObject2 == null);
    ((HomeView)localObject2).addHelpAppPage();
    ((HomeView)localObject2).addItemToHomeScreen();
    layout = GuideFragment.findMainView((Activity)localObject1);
    menuLayout = ((LayoutInflater)((Activity)localObject1).getSystemService("layout_inflater")).inflate(2130903057, layout, true);
    ((ImageView)menuLayout.findViewById(2131689502)).bringToFront();
    this.mGoalAnimationView = ((ImageView)menuLayout.findViewById(2131689534));
    Object localObject1 = new HelpAnimatedDialog((Context)localObject1, this.mGoalAnimationView);
    isMoveAppsDialog_Visible = true;
    Object localObject2 = (RelativeLayout)menuLayout.findViewById(2131689501);
    ((HelpAnimatedDialog)localObject1).start();
    ((HelpAnimatedDialog)localObject1).startZoom(0.6F, 0.1F, (View)localObject2);
  }
  
  public void showHelpDialog_step2()
  {
    if (isMoveAppsDialog_Visible) {}
    HomeView localHomeView;
    Launcher localLauncher;
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 2;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localLauncher = (Launcher)getActivity();
    } while (localHomeView == null);
    layout = GuideFragment.findMainView(localLauncher);
    menuLayout = ((LayoutInflater)localLauncher.getSystemService("layout_inflater")).inflate(2130903058, layout, true);
    isMoveAppsDialog_Visible = true;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/MoveAppsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */