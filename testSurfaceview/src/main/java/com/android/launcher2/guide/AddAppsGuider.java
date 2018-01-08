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
import android.widget.TextView;
import com.android.launcher2.Launcher;

public class AddAppsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "AddAppsGuider";
  static boolean isStep1DialogVisible = false;
  static boolean isStep2DialogVisible = false;
  static ViewGroup layout;
  static View menuLayout;
  TextView txtvw;
  
  public AddAppsGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("AddAppsGuider", "AddAppsGuider");
  }
  
  public void dismissHelpDialog()
  {
    Log.d("AddAppsGuider", "dismissHelpDialog()");
    dismissShowHelpDialog_step1();
    dismissShowHelpDialog_step2();
    GuideFragment.mGuider = null;
  }
  
  public void dismissShowHelpDialog_step1()
  {
    Log.d("AddAppsGuider", "dismisshelpdialog step 1");
    if (isStep1DialogVisible)
    {
      isStep1DialogVisible = false;
      new ViewAppsGuider((Launcher)getActivity()).dismissHelpDialog();
    }
  }
  
  public void dismissShowHelpDialog_step2()
  {
    int i;
    if (isStep2DialogVisible)
    {
      Log.d("AddAppsGuider", "dismisshelpdialog step 2. isStep2DialogVisible");
      isStep2DialogVisible = false;
      Launcher localLauncher = (Launcher)getActivity();
      if (localLauncher.getMenuView() != null)
      {
        layout = GuideFragment.findMainView(localLauncher);
        i = layout.getChildCount();
        if (layout != null) {
          break label54;
        }
      }
    }
    return;
    label54:
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
    if (isStep1DialogVisible) {
      return;
    }
    GuideFragment.sHelpHubStepNumber = 1;
    isStep1DialogVisible = true;
    Log.d("AddAppsGuider", "showhelpdialog step 1+isStep1DialogVisible=true");
    GuideFragment.isViewApps = true;
    new ViewAppsGuider((Launcher)getActivity()).showHelpDialog();
  }
  
  public void showHelpDialog_step2()
  {
    if (isStep2DialogVisible) {}
    Launcher localLauncher;
    do
    {
      return;
      GuideFragment.sHelpHubStepNumber = 2;
      isStep2DialogVisible = true;
      dismissShowHelpDialog_step1();
      GuideFragment.isViewApps = false;
      localLauncher = (Launcher)getActivity();
    } while (localLauncher.getMenuView() == null);
    layout = GuideFragment.findMainView(localLauncher);
    menuLayout = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2130903054, layout, true);
    HelpAnimatedDialog localHelpAnimatedDialog = new HelpAnimatedDialog();
    this.txtvw = ((TextView)localLauncher.findViewById(2131689503));
    this.txtvw.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AddAppsGuider.this.txtvw.performAccessibilityAction(64, null);
      }
    });
    this.txtvw.setContentDescription(layout.getContext().getString(2131755188));
    if (GuideFragment.GMode.equals("create_folder")) {
      this.txtvw.setText(2131755182);
    }
    localHelpAnimatedDialog.startZoom(0.1F, 0.1F, this.txtvw);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/AddAppsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */