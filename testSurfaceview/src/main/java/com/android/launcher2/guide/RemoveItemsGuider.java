package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class RemoveItemsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "RemoveitemsGuider";
  private static boolean isRemoveItemsHelpDialogVisible = false;
  public static boolean isViewApps = false;
  private View mGoalAnimationView;
  
  public RemoveItemsGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("RemoveitemsGuider", "removeitemsguider");
  }
  
  public void dismissHelpDialog()
  {
    if (!isRemoveItemsHelpDialogVisible) {}
    do
    {
      return;
      localObject = getActivity();
    } while ((localObject == null) || (((Launcher)localObject).getHomeView() == null));
    Object localObject = GuideFragment.findMainView((Activity)localObject);
    Log.d("RemoveitemsGuider", "dismissHelpDialog.layout=" + localObject);
    ((ViewGroup)localObject).removeViewAt(((ViewGroup)localObject).getChildCount() - 1);
    isRemoveItemsHelpDialogVisible = false;
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
      showHelpDialog();
      return;
    }
    showHelpDialog2();
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void showHelpDialog()
  {
    if (isRemoveItemsHelpDialogVisible) {}
    do
    {
      do
      {
        return;
        GuideFragment.sHelpHubStepNumber = 1;
        localObject1 = getActivity();
      } while (localObject1 == null);
      localObject2 = ((Launcher)localObject1).getHomeView();
    } while (localObject2 == null);
    Log.d("RemoveitemsGuider", " frag!=null");
    ViewGroup localViewGroup = GuideFragment.findMainView((Activity)localObject1);
    LayoutInflater localLayoutInflater = (LayoutInflater)((Activity)localObject1).getSystemService("layout_inflater");
    ((HomeView)localObject2).addItemToHomeScreen();
    Object localObject2 = localLayoutInflater.inflate(2130903060, localViewGroup, true);
    ((ImageView)((View)localObject2).findViewById(2131689502)).bringToFront();
    this.mGoalAnimationView = ((View)localObject2).findViewById(2131689534);
    Object localObject1 = new HelpAnimatedDialog((Context)localObject1, this.mGoalAnimationView);
    isRemoveItemsHelpDialogVisible = true;
    localObject2 = (RelativeLayout)((View)localObject2).findViewById(2131689501);
    ((HelpAnimatedDialog)localObject1).start();
    ((HelpAnimatedDialog)localObject1).startZoom(0.6F, 0.1F, (View)localObject2);
  }
  
  public void showHelpDialog2()
  {
    if (isRemoveItemsHelpDialogVisible) {}
    Activity localActivity;
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 2;
      localActivity = getActivity();
    } while ((localActivity == null) || (((Launcher)localActivity).getHomeView() == null));
    Log.d("RemoveitemsGuider", " frag!=null");
    Object localObject = GuideFragment.findMainView(localActivity);
    localObject = ((LayoutInflater)localActivity.getSystemService("layout_inflater")).inflate(2130903061, (ViewGroup)localObject, true);
    this.mGoalAnimationView = ((View)localObject).findViewById(2131689534);
    localObject = (RelativeLayout)((View)localObject).findViewById(2131689532);
    HelpAnimatedDialog localHelpAnimatedDialog = new HelpAnimatedDialog(localActivity, this.mGoalAnimationView);
    isRemoveItemsHelpDialogVisible = true;
    if (localActivity.getResources().getConfiguration().smallestScreenWidthDp < 800)
    {
      localHelpAnimatedDialog.start();
      return;
    }
    localHelpAnimatedDialog.startZoom(0.6F, 0.1F, (View)localObject);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/RemoveItemsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */