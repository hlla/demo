package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;
import com.android.launcher2.MenuView;
import com.android.launcher2.MenuWidgets;

public class AddWidgetsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "AddWidgetsGuider";
  public static boolean isAddWidgetsGuiderOn = false;
  static boolean isStep1DialogVisible = false;
  static boolean isStep2DialogVisible = false;
  static boolean isStep3DialogVisible = false;
  static ViewGroup layout;
  static View menuLayout;
  private View mGoalAnimationView;
  
  public AddWidgetsGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("AddWidgetsGuider", "AddWidgetsGuider");
    isAddWidgetsGuiderOn = true;
  }
  
  public void dismissHelpDialog()
  {
    Log.d("AddWidgetsGuider", "AddWidgetsGuider.dismissHelpDialog()");
    dismissShowHelpDialog_firstStep();
    dismissShowHelpDialog_step1();
    dismissShowHelpDialog_step3();
    isAddWidgetsGuiderOn = false;
    GuideFragment.mGuider = null;
  }
  
  public void dismissShowHelpDialog_firstStep()
  {
    if (!isStep1DialogVisible) {}
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
    isStep1DialogVisible = false;
  }
  
  public void dismissShowHelpDialog_step1()
  {
    if (isStep2DialogVisible)
    {
      isStep2DialogVisible = false;
      new ViewAppsGuider((Launcher)getActivity()).dismissHelpDialog();
    }
  }
  
  public void dismissShowHelpDialog_step2()
  {
    int i;
    if (isStep2DialogVisible)
    {
      isStep2DialogVisible = false;
      Launcher localLauncher = (Launcher)getActivity();
      if (localLauncher.getMenuView() != null)
      {
        Log.d("AddWidgetsGuider", " frag!=null");
        MenuWidgets localMenuWidgets = localLauncher.getMenuView().getMenuWidgets();
        if (localMenuWidgets != null) {
          localMenuWidgets.updatePackages("AddWidgetsGuider - dismissShowHelpDialog_step2");
        }
        layout = GuideFragment.findMainView(localLauncher);
        i = layout.getChildCount();
        if (layout != null) {
          break label80;
        }
        Log.d("AddWidgetsGuider", "layout==null");
      }
    }
    return;
    label80:
    if (i != 0) {
      layout.removeViewAt(i - 1);
    }
    GuideFragment.mGuider = null;
  }
  
  public void dismissShowHelpDialog_step3()
  {
    int i;
    if (isStep3DialogVisible)
    {
      isStep3DialogVisible = false;
      Launcher localLauncher = (Launcher)getActivity();
      if (localLauncher.getMenuView() != null)
      {
        Log.d("AddWidgetsGuider", " frag!=null");
        layout = GuideFragment.findMainView(localLauncher);
        i = layout.getChildCount();
        if (layout != null) {
          break label62;
        }
        Log.d("AddWidgetsGuider", "layout==null");
      }
    }
    return;
    label62:
    if (i != 0) {
      layout.removeViewAt(i - 1);
    }
    GuideFragment.mGuider = null;
  }
  
  public boolean isStep1DialogVisible()
  {
    return isStep1DialogVisible;
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
      showHelpDialog_first_step();
      return;
    case 2: 
      showHelpDialog_step1();
      return;
    }
    showHelpDialog_step3();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    showHelpDialog_first_step();
  }
  
  public void showHelpDialog_first_step()
  {
    if (isStep1DialogVisible) {}
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 1;
      isStep1DialogVisible = true;
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
    if (isStep2DialogVisible) {
      return;
    }
    GuideFragment.sHelpHubStepNumber = 2;
    isStep2DialogVisible = true;
    GuideFragment.isViewApps = true;
    new ViewAppsGuider((Launcher)getActivity()).showHelpDialog();
  }
  
  public void showHelpDialog_step2()
  {
    if (isStep2DialogVisible) {}
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 2;
      isStep2DialogVisible = true;
      dismissShowHelpDialog_step1();
      GuideFragment.isViewApps = false;
      localObject = (Launcher)getActivity();
    } while (((Launcher)localObject).getMenuView() == null);
    Log.d("AddWidgetsGuider", " frag!=null");
    layout = GuideFragment.findMainView((Activity)localObject);
    menuLayout = ((LayoutInflater)((Launcher)localObject).getSystemService("layout_inflater")).inflate(2130903065, layout, true);
    ((ImageView)menuLayout.findViewById(2131689502)).bringToFront();
    this.mGoalAnimationView = ((ImageView)menuLayout.findViewById(2131689534));
    Object localObject = new HelpAnimatedDialog((Context)localObject, this.mGoalAnimationView);
    final RelativeLayout localRelativeLayout = (RelativeLayout)menuLayout.findViewById(2131689501);
    localRelativeLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localRelativeLayout.performAccessibilityAction(64, null);
      }
    });
    localRelativeLayout.setContentDescription(layout.getResources().getString(2131755191));
    ((HelpAnimatedDialog)localObject).start();
    ((HelpAnimatedDialog)localObject).startZoom(0.6F, 0.1F, localRelativeLayout);
  }
  
  public void showHelpDialog_step3()
  {
    if (isStep3DialogVisible) {}
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 3;
      isStep3DialogVisible = true;
      Log.d("AddWidgetsGuider", "showhelpdialog step 3");
      localObject = (Launcher)getActivity();
    } while (((Launcher)localObject).getMenuView() == null);
    Log.d("AddWidgetsGuider", " frag!=null");
    layout = GuideFragment.findMainView((Activity)localObject);
    menuLayout = ((LayoutInflater)((Launcher)localObject).getSystemService("layout_inflater")).inflate(2130903066, layout, true);
    Object localObject = new HelpAnimatedDialog();
    final TextView localTextView = (TextView)menuLayout.findViewById(2131689503);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localTextView.performAccessibilityAction(64, null);
      }
    });
    localTextView.setContentDescription(layout.getResources().getString(2131755193));
    ((HelpAnimatedDialog)localObject).startZoom(0.6F, 0.1F, localTextView);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/AddWidgetsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */