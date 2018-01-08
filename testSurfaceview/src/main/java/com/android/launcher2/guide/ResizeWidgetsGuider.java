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
import android.widget.Toast;
import com.android.launcher2.HomeItem;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class ResizeWidgetsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  public static boolean isResizeHelpDialogVisible = false;
  public static boolean isStep3Visible;
  public static boolean isWidgetToBeAdded;
  static ViewGroup layout;
  static TextView mStep2Text;
  static View menuLayout;
  private static boolean okButtonClicked = false;
  public HomeItem AddedWidget;
  private String TAG = "ResizeWidgetGuider";
  private View mGoalAnimationView;
  
  static
  {
    isWidgetToBeAdded = true;
    isStep3Visible = false;
  }
  
  public ResizeWidgetsGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d(this.TAG, "Resize widgets guider");
  }
  
  public void dismissHelpDialog()
  {
    if (!isResizeHelpDialogVisible) {}
    HomeView localHomeView;
    Launcher localLauncher;
    do
    {
      return;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localLauncher = (Launcher)getActivity();
    } while (localHomeView == null);
    Log.d(this.TAG, " frag!=null");
    layout = GuideFragment.findMainView(localLauncher);
    int i = layout.getChildCount();
    if (!okButtonClicked) {
      layout.removeViewAt(i - 1);
    }
    isResizeHelpDialogVisible = false;
    okButtonClicked = false;
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
    showHelpDialog_step2();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    if (isResizeHelpDialogVisible) {}
    HomeView localHomeView;
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 1;
      localHomeView = ((Launcher)getActivity()).getHomeView();
      localObject1 = (Launcher)getActivity();
    } while (localHomeView == null);
    layout = GuideFragment.findMainView((Activity)localObject1);
    final Object localObject2 = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    if (!isWidgetToBeAdded)
    {
      localHomeView.isHelpAppPageDeleted = false;
      localHomeView.removehelpAppPage();
      localHomeView.isHelpAppPageAdded = false;
    }
    this.AddedWidget = localHomeView.HelpAppAddwidget();
    if (this.AddedWidget == null)
    {
      Toast.makeText(((Activity)localObject1).getApplicationContext(), "Resize Widget Guide encountered a problem!", 0).show();
      return;
    }
    isResizeHelpDialogVisible = true;
    menuLayout = ((LayoutInflater)localObject2).inflate(2130903062, layout, true);
    ((ImageView)menuLayout.findViewById(2131689502)).bringToFront();
    this.mGoalAnimationView = ((ImageView)menuLayout.findViewById(2131689534));
    Object localObject1 = new HelpAnimatedDialog((Context)localObject1, this.mGoalAnimationView);
    localObject2 = (RelativeLayout)menuLayout.findViewById(2131689501);
    ((RelativeLayout)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localObject2.performAccessibilityAction(64, null);
      }
    });
    ((RelativeLayout)localObject2).setContentDescription(layout.getResources().getString(2131755176));
    ((HelpAnimatedDialog)localObject1).start();
    ((HelpAnimatedDialog)localObject1).startZoom(0.6F, 0.1F, (View)localObject2);
    localHomeView.helpHubSnapToLastPage();
  }
  
  public void showHelpDialog_step2()
  {
    if (isResizeHelpDialogVisible) {}
    Object localObject;
    do
    {
      Launcher localLauncher;
      do
      {
        return;
        GuideFragment.sHelpHubStepNumber = 2;
        localObject = ((Launcher)getActivity()).getHomeView();
        localLauncher = (Launcher)getActivity();
      } while (localObject == null);
      layout = GuideFragment.findMainView(localLauncher);
      menuLayout = ((LayoutInflater)localLauncher.getSystemService("layout_inflater")).inflate(2130903063, layout, true);
      mStep2Text = (TextView)menuLayout.findViewById(2131689503);
      localObject = new HelpAnimatedDialog(localLauncher, mStep2Text);
      ((HelpAnimatedDialog)localObject).startZoom(0.6F, 0.1F, mStep2Text);
      isResizeHelpDialogVisible = true;
    } while (!isStep3Visible);
    isStep3Visible = false;
    mStep2Text.setText(2131755169);
    ((HelpAnimatedDialog)localObject).startZoom(0.6F, 0.1F, mStep2Text);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/ResizeWidgetsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */