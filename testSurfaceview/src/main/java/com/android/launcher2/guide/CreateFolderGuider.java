package com.android.launcher2.guide;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.launcher2.HomeEditBar;
import com.android.launcher2.Launcher;

public class CreateFolderGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "ViewAppsGuider";
  static boolean isStep3DialogVisible = false;
  public static boolean isViewApps = false;
  static ViewGroup layout;
  private static GuiderLifecycleListener mGuider;
  static View menuLayout;
  
  public CreateFolderGuider(Activity paramActivity)
  {
    super(paramActivity);
    Log.d("ViewAppsGuider", "createfolderguider");
  }
  
  private void showHelpDialog_step1()
  {
    GuideFragment.sHelpHubStepNumber = 1;
    mGuider = new AddAppsGuider(getActivity());
    mGuider.showHelpDialog();
  }
  
  private void showHelpDialog_step2()
  {
    GuideFragment.sHelpHubStepNumber = 2;
    mGuider = new AddAppsGuider(getActivity());
    ((AddAppsGuider)mGuider).showHelpDialog_step2();
  }
  
  public void dismissHelpDialog()
  {
    dismissHelpDialog_step3();
    mGuider = new AddAppsGuider(getActivity());
    mGuider.dismissHelpDialog();
  }
  
  public void dismissHelpDialog_step3()
  {
    if (isStep3DialogVisible)
    {
      isStep3DialogVisible = false;
      layout = ((Launcher)getActivity()).getHomeView();
      if ((layout != null) && (layout.getChildCount() != 0)) {
        layout.removeViewAt(layout.getChildCount() - 1);
      }
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
      showHelpDialog_step1();
      return;
    case 2: 
      showHelpDialog_step2();
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
    showHelpDialog_step1();
  }
  
  public void showHelpDialog_step3()
  {
    if ((isStep3DialogVisible) || (HomeEditBar.isfolderCreated)) {}
    TextView localTextView;
    Object localObject;
    do
    {
      do
      {
        return;
        GuideFragment.sHelpHubStepNumber = 3;
        isStep3DialogVisible = true;
        layout = ((Launcher)getActivity()).getHomeView();
      } while (layout == null);
      menuLayout = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2130903056, layout, true);
      ((ImageView)menuLayout.findViewById(2131689502)).bringToFront();
      localTextView = (TextView)menuLayout.findViewById(2131689503);
      localObject = layout.getResources();
      localObject = String.format(((Resources)localObject).getString(2131755183), new Object[] { ((Resources)localObject).getString(2131755143) });
    } while (localObject == null);
    localTextView.setText((CharSequence)localObject);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/CreateFolderGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */