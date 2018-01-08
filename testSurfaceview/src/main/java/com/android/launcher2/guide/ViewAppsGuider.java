package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public class ViewAppsGuider
  extends GuiderBase
  implements GuiderLifecycleListener
{
  private static final String TAG = "ViewAppsGuider";
  static ImageView image;
  static ViewGroup layout;
  static View menuLayout;
  private Activity mActivity;
  private View mGoalAnimationView;
  
  public ViewAppsGuider(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    Log.v("ViewAppsGuider", "Viewappsguider");
  }
  
  private boolean isPortOrientation()
  {
    Display localDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
    return localDisplay.getWidth() < localDisplay.getHeight();
  }
  
  public void dismissHelpDialog()
  {
    Launcher localLauncher = (Launcher)getActivity();
    if ((!GuideFragment.isViewAppsDialogDismissed) && (((Launcher)getActivity()).getHomeView() != null))
    {
      layout = GuideFragment.findMainView((Launcher)localLauncher);
      GuideFragment.isViewAppsDialogDismissed = true;
      if (layout == null) {
        return;
      }
      int i = layout.getChildCount();
      if (i != 0) {
        layout.removeViewAt(i - 1);
      }
      GuideFragment.isViewAppsDialogDismissed = true;
      GuideFragment.mGuider = null;
    }
    GuideFragment.isViewApps = false;
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
    if ((!GuideFragment.GMode.equals("change_wallpaper")) && (!GuideFragment.GMode.equals("add_widgets"))) {
      GuideFragment.sHelpHubStepNumber = 1;
    }
    GuideFragment.isViewAppsDialogDismissed = false;
    Object localObject3 = ((Launcher)getActivity()).getHomeView();
    Object localObject2 = (Launcher)getActivity();
    Object localObject1;
    int k;
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    TextView localTextView;
    RelativeLayout.LayoutParams localLayoutParams3;
    int m;
    int i;
    int j;
    if (localObject3 != null)
    {
      layout = GuideFragment.findMainView((Activity)localObject2);
      menuLayout = ((LayoutInflater)((Activity)localObject2).getSystemService("layout_inflater")).inflate(2130903064, layout, true);
      localObject1 = ((Activity)localObject2).getResources();
      k = ((Resources)localObject1).getDimensionPixelSize(2131624421);
      image = (ImageView)menuLayout.findViewById(2131689534);
      this.mGoalAnimationView = ((ImageView)menuLayout.findViewById(2131689534));
      localObject2 = new HelpAnimatedDialog((Context)localObject2, this.mGoalAnimationView);
      localImageView = (ImageView)menuLayout.findViewById(2131689536);
      localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(11);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(11);
      localTextView = (TextView)menuLayout.findViewById(2131689503);
      localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams3.addRule(11);
      m = ((HomeView)localObject3).getHotseatItemcount();
      if (!GuideFragment.GMode.equals("add_widgets")) {
        break label464;
      }
      i = ((Resources)localObject1).getDimensionPixelSize(2131624540);
      j = ((Resources)localObject1).getDimensionPixelSize(2131624541);
      localLayoutParams3.addRule(12);
      localLayoutParams3.addRule(21);
      localLayoutParams3.setMarginsRelative(0, 0, i, j);
      localTextView.setLayoutParams(localLayoutParams3);
      localTextView.setText(((Resources)localObject1).getString(2131755181));
      j = ((Resources)localObject1).getDimensionPixelSize(2131623996);
      k = ((Resources)localObject1).getDimensionPixelSize(2131623997);
      localLayoutParams1.addRule(12);
      localLayoutParams1.addRule(21);
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(21);
      if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
        break label442;
      }
      i = ((Resources)localObject1).getDimensionPixelSize(2131624106);
      localLayoutParams2.setMarginsRelative(0, 0, i, k);
      localImageView.setLayoutParams(localLayoutParams2);
      if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
        break label453;
      }
      i = ((Resources)localObject1).getDimensionPixelSize(2131624107);
      label395:
      localLayoutParams1.setMarginsRelative(0, 0, i, j);
      image.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localObject1 = (RelativeLayout)menuLayout.findViewById(2131689501);
      ((HelpAnimatedDialog)localObject2).start();
      ((HelpAnimatedDialog)localObject2).startZoom(0.8F, 0.8F, (View)localObject1);
      return;
      label442:
      i = ((Resources)localObject1).getDimensionPixelSize(2131623995);
      break;
      label453:
      i = ((Resources)localObject1).getDimensionPixelSize(2131623998);
      break label395;
      label464:
      if (GuideFragment.GMode.equals("change_wallpaper"))
      {
        i = ((Resources)localObject1).getDimensionPixelSize(2131624006);
        j = ((Resources)localObject1).getDimensionPixelSize(2131624004);
        localLayoutParams3.addRule(12);
        localLayoutParams3.addRule(20);
        localLayoutParams3.setMargins(j, 0, 0, i);
        localLayoutParams3.setMarginStart(j);
        localTextView.setText(2131755165);
        localTextView.setLayoutParams(localLayoutParams3);
        j = ((Resources)localObject1).getDimensionPixelSize(2131624001);
        k = ((Resources)localObject1).getDimensionPixelSize(2131624002);
        localLayoutParams1.addRule(12);
        localLayoutParams2.addRule(12);
        localLayoutParams2.addRule(21);
        if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
        {
          i = ((Resources)localObject1).getDimensionPixelSize(2131624104);
          label585:
          localLayoutParams2.setMargins(0, 0, i, k);
          localLayoutParams2.setMarginEnd(i);
          localImageView.setLayoutParams(localLayoutParams2);
          if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
            break label667;
          }
        }
        label667:
        for (i = ((Resources)localObject1).getDimensionPixelSize(2131624105);; i = ((Resources)localObject1).getDimensionPixelSize(2131624003))
        {
          localLayoutParams1.addRule(21);
          localLayoutParams1.setMargins(0, 0, i, j);
          localLayoutParams1.setMarginEnd(i);
          image.setLayoutParams(localLayoutParams1);
          break;
          i = ((Resources)localObject1).getDimensionPixelSize(2131624000);
          break label585;
        }
      }
      if ((isPortOrientation()) || (((Resources)localObject1).getConfiguration().smallestScreenWidthDp >= 800))
      {
        i = ((Resources)localObject1).getDimensionPixelSize(2131624420);
        j = ((Resources)localObject1).getDimensionPixelSize(2131624422);
        localLayoutParams1.addRule(12);
        localLayoutParams2.addRule(12);
      }
      switch (m)
      {
      default: 
        break;
      case 0: 
        Log.e("ViewAppsGuider", "HotSeatItems Cannot be null");
        k = ((Resources)localObject1).getDimensionPixelSize(2131623980);
        m = ((Resources)localObject1).getDimensionPixelSize(2131624421);
        localLayoutParams3.addRule(12);
        localLayoutParams3.addRule(21);
        localLayoutParams3.setMargins(0, 0, k, m);
        localLayoutParams3.setMarginEnd(k);
        localTextView.setLayoutParams(localLayoutParams3);
        k = ((Resources)localObject1).getDimensionPixelSize(2131624433);
        localLayoutParams2.addRule(21);
        localLayoutParams2.setMargins(0, 0, k, j);
        localLayoutParams2.setMarginEnd(k);
        localImageView.setLayoutParams(localLayoutParams2);
        j = ((Resources)localObject1).getDimensionPixelSize(2131624432);
        localLayoutParams1.addRule(21);
        localLayoutParams1.setMargins(0, 0, j, i);
        localLayoutParams1.setMarginEnd(j);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 1: 
        k = ((Resources)localObject1).getDimensionPixelSize(2131623980);
        m = ((Resources)localObject1).getDimensionPixelSize(2131624421);
        localLayoutParams3.addRule(12);
        localLayoutParams3.setMargins(0, 0, k, m);
        localTextView.setLayoutParams(localLayoutParams3);
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624433), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624432), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 2: 
        m = ((Resources)localObject1).getDimensionPixelSize(2131623981);
        localLayoutParams3.addRule(12);
        localLayoutParams3.setMargins(0, 0, m, k);
        localTextView.setLayoutParams(localLayoutParams3);
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624431), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624430), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 3: 
        m = ((Resources)localObject1).getDimensionPixelSize(2131624539);
        localLayoutParams3.addRule(12);
        localLayoutParams3.setMargins(0, 0, m, k);
        localTextView.setLayoutParams(localLayoutParams3);
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624429), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624428), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 4: 
        m = ((Resources)localObject1).getDimensionPixelSize(2131624539);
        localLayoutParams3.addRule(12);
        localLayoutParams3.setMargins(0, 0, m, k);
        localTextView.setLayoutParams(localLayoutParams3);
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624427), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624426), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 5: 
        m = ((Resources)localObject1).getDimensionPixelSize(2131624539);
        localLayoutParams3.addRule(12);
        localLayoutParams3.setMargins(0, 0, m, k);
        localTextView.setLayoutParams(localLayoutParams3);
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624425), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624424), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 6: 
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624628), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624627), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 7: 
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624670), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624669), i);
        image.setLayoutParams(localLayoutParams1);
        break;
      case 8: 
        localLayoutParams2.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624668), j);
        localImageView.setLayoutParams(localLayoutParams2);
        localLayoutParams1.setMargins(0, 0, ((Resources)localObject1).getDimensionPixelSize(2131624667), i);
        image.setLayoutParams(localLayoutParams1);
        continue;
        if (((Resources)localObject1).getConfiguration().smallestScreenWidthDp >= 600)
        {
          localLayoutParams2.addRule(10);
          localLayoutParams2.addRule(10);
          localObject3 = SystemProperties.get("ro.product.name");
          RelativeLayout localRelativeLayout = (RelativeLayout)menuLayout.findViewById(2131689501);
          switch (m)
          {
          default: 
            break;
          case 0: 
            Log.e("ViewAppsGuider", "HotSeatItems Cannot be null");
          case 1: 
            if ((((String)localObject3).startsWith("degas")) || (((String)localObject3).startsWith("rubens")))
            {
              i = ((Resources)localObject1).getDimensionPixelSize(2131623980);
              j = ((Resources)localObject1).getDimensionPixelSize(2131624671);
              localLayoutParams3.addRule(12);
              localLayoutParams3.setMargins(0, 0, i, j);
              localTextView.setLayoutParams(localLayoutParams3);
              i = ((Resources)localObject1).getDimensionPixelSize(2131624630);
              j = ((Resources)localObject1).getDimensionPixelSize(2131624433);
              localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624636), j, 0);
              localImageView.setLayoutParams(localLayoutParams2);
              localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624432), 0);
              image.setLayoutParams(localLayoutParams1);
            }
            else
            {
              i = ((Resources)localObject1).getDimensionPixelSize(2131624630);
              j = ((Resources)localObject1).getDimensionPixelSize(2131624433);
              localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624636), j, 0);
              localRelativeLayout.setLayoutParams(localLayoutParams2);
              localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624432), 0);
              image.setLayoutParams(localLayoutParams1);
            }
            break;
          case 2: 
            i = ((Resources)localObject1).getDimensionPixelSize(2131624631);
            j = ((Resources)localObject1).getDimensionPixelSize(2131624431);
            localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624637), j, 0);
            localRelativeLayout.setLayoutParams(localLayoutParams2);
            localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624430), 0);
            image.setLayoutParams(localLayoutParams1);
            break;
          case 3: 
            i = ((Resources)localObject1).getDimensionPixelSize(2131624632);
            j = ((Resources)localObject1).getDimensionPixelSize(2131624429);
            localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624638), j, 0);
            localRelativeLayout.setLayoutParams(localLayoutParams2);
            localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624428), 0);
            image.setLayoutParams(localLayoutParams1);
            break;
          case 4: 
            i = ((Resources)localObject1).getDimensionPixelSize(2131624633);
            j = ((Resources)localObject1).getDimensionPixelSize(2131624427);
            localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624639), j, 0);
            localRelativeLayout.setLayoutParams(localLayoutParams2);
            localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624426), 0);
            image.setLayoutParams(localLayoutParams1);
            break;
          case 5: 
            i = ((Resources)localObject1).getDimensionPixelSize(2131624634);
            j = ((Resources)localObject1).getDimensionPixelSize(2131624425);
            localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624640), j, 0);
            localRelativeLayout.setLayoutParams(localLayoutParams2);
            localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624424), 0);
            image.setLayoutParams(localLayoutParams1);
            break;
          case 6: 
            i = ((Resources)localObject1).getDimensionPixelSize(2131624635);
            j = ((Resources)localObject1).getDimensionPixelSize(2131624628);
            localLayoutParams2.setMargins(0, ((Resources)localObject1).getDimensionPixelSize(2131624641), j, 0);
            localRelativeLayout.setLayoutParams(localLayoutParams2);
            localLayoutParams1.setMargins(0, i, ((Resources)localObject1).getDimensionPixelSize(2131624627), 0);
            image.setLayoutParams(localLayoutParams1);
          }
        }
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/ViewAppsGuider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */