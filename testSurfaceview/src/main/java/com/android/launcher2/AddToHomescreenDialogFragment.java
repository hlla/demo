package com.android.launcher2;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.launcher2.guide.GuideFragment;
import com.android.launcher2.guide.HelpAnimatedDialog;
import java.util.ArrayList;
import java.util.List;

public class AddToHomescreenDialogFragment
  extends DialogFragment
{
  private static final String sFragmentTag = "AddToHomescreen";
  static boolean setWallpaperSelected = false;
  
  static void createAndShow(FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    new AddToHomescreenDialogFragment().show(paramFragmentManager, "AddToHomescreen");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("AddToHomescreen");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("AddToHomescreen") != null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    final Launcher localLauncher = (Launcher)getActivity();
    Object localObject1 = View.inflate(paramBundle, 2130903045, null);
    setWallpaperSelected = false;
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131689502);
    if (localObject2 != null) {
      ((ImageView)localObject2).bringToFront();
    }
    ((View)localObject1).setVisibility(0);
    localObject2 = new AlertDialog.Builder(paramBundle);
    ((AlertDialog.Builder)localObject2).setTitle(getString(2131755032));
    ((AlertDialog.Builder)localObject2).setView((View)localObject1);
    localObject2 = ((AlertDialog.Builder)localObject2).create();
    Object localObject4;
    if ((Launcher.isHelpAppRunning) && ("change_wallpaper".equals(GuideFragment.GMode)))
    {
      Launcher.changeWallpaperStatus = 2;
      localObject3 = (RelativeLayout)((View)localObject1).findViewById(2131689499);
      if (localObject3 != null)
      {
        ((RelativeLayout)localObject3).setVisibility(0);
        localObject3 = new HelpAnimatedDialog(localLauncher, (ImageView)((View)localObject1).findViewById(2131689500));
        localObject4 = (RelativeLayout)((View)localObject1).findViewById(2131689501);
        ((HelpAnimatedDialog)localObject3).start();
        ((HelpAnimatedDialog)localObject3).startZoom(0.6F, 0.1F, (View)localObject4);
      }
    }
    if (!Launcher.isHelpAppRunning) {
      ((Dialog)localObject2).setCanceledOnTouchOutside(true);
    }
    final Object localObject3 = localLauncher.mHomeView.getWorkspace();
    int i;
    if (((Workspace)localObject3).getChildCount() < LauncherApplication.getMaxScreenCount())
    {
      i = 1;
      localObject4 = new ArrayList();
      ((TextView)((View)localObject1).findViewById(2131689496)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AddToHomescreenDialogFragment.setWallpaperSelected = true;
          HomeScreenDialogFragment.createAndShow(AddToHomescreenDialogFragment.this.getFragmentManager());
          AddToHomescreenDialogFragment.this.dismiss();
        }
      });
      ((TextView)((View)localObject1).findViewById(2131689496)).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((Launcher.isHelpAppRunning) && (paramAnonymousMotionEvent.getActionMasked() == 1)) {
            HelpAnimatedDialog.setAlpha();
          }
          return false;
        }
      });
      if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
      {
        ((View)localObject1).findViewById(2131689504).setVisibility(0);
        ((TextView)((View)localObject1).findViewById(2131689506)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent("com.sec.android.intent.action.THEME_CHOOSER");
            AddToHomescreenDialogFragment.this.startActivity(paramAnonymousView);
            AddToHomescreenDialogFragment.this.dismiss();
          }
        });
      }
      ((ArrayList)localObject4).add(getResources().getText(2131755029).toString());
      ((ArrayList)localObject4).add(getResources().getText(2131755030).toString());
      if (i != 0) {
        ((ArrayList)localObject4).add(getResources().getText(2131755031).toString());
      }
      if (!LauncherApplication.isScreenSmall()) {
        break label473;
      }
      paramBundle = new ArrayAdapter(paramBundle, 17367043, (List)localObject4);
      label389:
      localObject1 = (ListView)((View)localObject1).findViewById(2131689498);
      ((ListView)localObject1).setAdapter(paramBundle);
      if (!Launcher.isHelpAppRunning) {
        break label498;
      }
      if (!GuideFragment.GMode.equals("change_wallpaper")) {
        break label489;
      }
      ((ListView)localObject1).setEnabled(true);
      ((ListView)localObject1).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
      });
    }
    for (;;)
    {
      if (!Launcher.isHelpAppRunning) {
        ((ListView)localObject1).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AddToHomescreenDialogFragment.this.dismiss();
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 0: 
              localLauncher.showAllApps();
              if (localLauncher.shouldToastRepeat())
              {
                AddAppsWidgetToastPopUp.createAndShow(AddToHomescreenDialogFragment.this.getFragmentManager());
                return;
              }
              Toast.makeText(localLauncher, 2131755040, 0).show();
              return;
            case 1: 
              CreateFolderDialog.createAndShow(AddToHomescreenDialogFragment.this.getFragmentManager(), null, -1L, -100L, false, true, -1, -1);
              return;
            }
            paramAnonymousInt = localObject3.newPage(localLauncher.getShowEmptyPageMessagePref());
            localObject3.snapToPage(paramAnonymousInt);
          }
        });
      }
      return (Dialog)localObject2;
      i = 0;
      break;
      label473:
      paramBundle = new ArrayAdapter(paramBundle, 2130903041, (List)localObject4);
      break label389;
      label489:
      ((ListView)localObject1).setEnabled(true);
      continue;
      label498:
      ((ListView)localObject1).setEnabled(true);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (Launcher)getActivity();
    if ((Launcher.isHelpAppRunning) && (!setWallpaperSelected) && (paramDialogInterface != null)) {
      paramDialogInterface.onBackPressed();
    }
    if ((paramDialogInterface != null) && (paramDialogInterface.getFragmentManager() != null)) {
      dismiss();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AddToHomescreenDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */