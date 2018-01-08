package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class ChangeWallpaperGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "ChangeWallpaperGuider";
  public static boolean isChangeWallpaperDialog1Visible = false;
  public static boolean isChangeWallpaperDialog2Visible = false;
  static ViewGroup layout;
  static View menuLayout;
  private View mGoalAnimationView;
  
  public ChangeWallpaperGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("ChangeWallpaperGuider", "ChangeWallpaperGuider");
  }
  
  public void dismissHelpDialog()
  {
    dismissShowHelpDialog_firstStep();
    dismissShowHelpDialog_step1();
    GuideFragment.mGuider = null;
  }
  
  public void dismissShowHelpDialog_firstStep()
  {
    if (!isChangeWallpaperDialog1Visible) {}
    HomeView localHomeView;
    Launcher localLauncher;
    do
    {
      return;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localLauncher = (Launcher)getActivity();
    } while (localHomeView == null);
    layout = GuideFragment.findMainView(localLauncher);
    int i = layout.getChildCount();
    layout.removeViewAt(i - 1);
    isChangeWallpaperDialog1Visible = false;
  }
  
  public void dismissShowHelpDialog_step1()
  {
    if (isChangeWallpaperDialog2Visible)
    {
      isChangeWallpaperDialog2Visible = false;
      new ViewAppsGuider((Launcher)getActivity()).dismissHelpDialog();
    }
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
      showHelpDialog();
      return;
    }
    showHelpDialog_step1();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    if (isChangeWallpaperDialog1Visible) {}
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 1;
      localObject1 = ((Launcher)getActivity()).getHomeView();
      localObject2 = (Launcher)getActivity();
    } while (localObject1 == null);
    layout = GuideFragment.findMainView((Activity)localObject2);
    menuLayout = ((LayoutInflater)((Activity)localObject2).getSystemService("layout_inflater")).inflate(2130903055, layout, true);
    Launcher.changeWallpaperStatus = 1;
    ((ImageView)menuLayout.findViewById(2131689502)).bringToFront();
    this.mGoalAnimationView = ((ImageView)menuLayout.findViewById(2131689533));
    Object localObject2 = new HelpAnimatedDialog((Context)localObject2, this.mGoalAnimationView);
    ((HomeView)localObject1).addHelpAppPage();
    isChangeWallpaperDialog1Visible = true;
    final Object localObject1 = (RelativeLayout)menuLayout.findViewById(2131689501);
    ((RelativeLayout)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localObject1.performAccessibilityAction(64, null);
      }
    });
    ((RelativeLayout)localObject1).setContentDescription(layout.getContext().getString(2131755186));
    ((HelpAnimatedDialog)localObject2).start();
    ((HelpAnimatedDialog)localObject2).startZoom(0.6F, 0.1F, (View)localObject1);
  }
  
  public void showHelpDialog_step1()
  {
    if ((isChangeWallpaperDialog2Visible) || (Launcher.changeWallpaperStatus > 2)) {
      return;
    }
    GuideFragment.sHelpHubStepNumber = 2;
    isChangeWallpaperDialog2Visible = true;
    GuideFragment.isViewApps = true;
    new ViewAppsGuider((Launcher)getActivity()).showHelpDialog();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/ChangeWallpaperGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */