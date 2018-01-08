package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.util.secutil.Log;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public final class GuideFragment
{
  public static boolean CSCFEATURE_LAUNCHER_DISABLEHELPUI = false;
  public static String GMode;
  public static final String TAG = "GuideFragment";
  public static int currentPageToStopNavigation;
  public static GuideFragment instance;
  public static boolean isExtraWorkspacePageAdded = false;
  public static boolean isGuideCompleted;
  public static boolean isViewApps;
  public static boolean isViewAppsDialogDismissed;
  public static boolean isWallpaperGuide_Toast3_visible;
  public static boolean isWrongActionDialogVisible = false;
  public static GuiderLifecycleListener mGuider;
  public static int sHelpHubStepNumber;
  
  static
  {
    CSCFEATURE_LAUNCHER_DISABLEHELPUI = false;
    isViewApps = false;
    isViewAppsDialogDismissed = false;
    currentPageToStopNavigation = 0;
    GMode = null;
    isWallpaperGuide_Toast3_visible = false;
    isGuideCompleted = false;
    mGuider = null;
  }
  
  public static void deployGuide(Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramIntent.getExtras() != null)
        {
          Log.d("GuideFragment", "get extras not null");
          GMode = paramIntent.getStringExtra("homescreen:guide_mode");
          if (GMode == null)
          {
            Log.d("GuideFragment", "guide mode is not ours");
            continue;
          }
        }
      }
      finally {}
    }
    Object localObject = (Launcher)paramActivity;
    HomeView localHomeView = ((Launcher)localObject).getHomeView();
    localObject = ((Launcher)localObject).getMenuView();
    if (!GMode.equals("onBackPressed")) {
      ((Launcher)paramActivity).exitAllApps();
    }
    for (;;)
    {
      label94:
      if (GMode.equals("onBackPressed"))
      {
        paramIntent = paramIntent.getStringExtra("currentGmode");
        GMode = paramIntent;
        if (paramIntent.equals("addapps"))
        {
          isViewApps = false;
          mGuider = new AddAppsGuider(paramActivity);
        }
        if (paramIntent.equals("change_wallpaper"))
        {
          isViewApps = false;
          mGuider = new ChangeWallpaperGuider(paramActivity);
        }
        if (paramIntent.equals("add_widgets"))
        {
          mGuider = new AddWidgetsGuider(paramActivity);
          isViewApps = false;
        }
        if (paramIntent.equals("view_all_apps"))
        {
          isViewApps = false;
          mGuider = new ViewAppsGuider(paramActivity);
        }
        if (paramIntent.equals("resize_widgets")) {
          mGuider = new ResizeWidgetsGuider(paramActivity);
        }
        if (paramIntent.equals("create_folder")) {
          mGuider = new CreateFolderGuider(paramActivity);
        }
        if (paramIntent.equals("move_app")) {
          mGuider = new MoveAppsGuider(paramActivity);
        }
        if (paramIntent.equals("remove_items")) {
          mGuider = new RemoveItemsGuider(paramActivity);
        }
        if (mGuider == null) {
          break;
        }
        mGuider.dismissHelpDialog();
        break;
      }
      if (GMode.equals("addapps"))
      {
        if (mGuider != null)
        {
          Log.d("GuideFragment", "" + mGuider);
          mGuider.dismissHelpDialog();
          mGuider = null;
        }
        mGuider = new AddAppsGuider(paramActivity);
      }
      for (;;)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if ((GuideFragment.mGuider != null) && (Launcher.isHelpAppRunning)) {
              GuideFragment.mGuider.showHelpDialog();
            }
          }
        }, 400L);
        break;
        if (GMode.equals("view_all_apps"))
        {
          isViewApps = true;
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new ViewAppsGuider(paramActivity);
        }
        else if (GMode.equals("change_wallpaper"))
        {
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new ChangeWallpaperGuider(paramActivity);
        }
        else if (GMode.equals("resize_widgets"))
        {
          mGuider = new ResizeWidgetsGuider(paramActivity);
        }
        else if (GMode.equals("create_folder"))
        {
          isViewApps = true;
          mGuider = new CreateFolderGuider(paramActivity);
        }
        else if (GMode.equals("remove_items"))
        {
          mGuider = new RemoveItemsGuider(paramActivity);
        }
        else if (GMode.equals("move_app"))
        {
          mGuider = new MoveAppsGuider(paramActivity);
        }
        else if (GMode.equals("add_widgets"))
        {
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new AddWidgetsGuider(paramActivity);
        }
      }
      do
      {
        Log.d("GuideFragment", "frag=null");
        break;
        if (localHomeView != null) {
          break label94;
        }
      } while (localObject == null);
    }
  }
  
  public static ViewGroup findMainView(Activity paramActivity)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramActivity instanceof Launcher))
    {
      paramActivity = (Launcher)paramActivity;
      if ((!GMode.equals("move_app")) && (!GMode.equals("change_wallpaper")) && (!GMode.equals("view_all_apps")) && (!GMode.equals("remove_items")) && (!GMode.equals("resize_widgets"))) {
        break label78;
      }
      localObject1 = paramActivity.getHomeView();
    }
    label78:
    do
    {
      return (ViewGroup)localObject1;
      if ((GMode.equals("addapps")) || (GMode.equals("add_widgets"))) {
        break;
      }
      localObject1 = localObject2;
    } while (!GMode.equals("create_folder"));
    if (!isViewAppsDialogDismissed) {
      return paramActivity.getHomeView();
    }
    return paramActivity.getMenuView();
  }
  
  public static GuideFragment getGuideFragmentInstance()
  {
    if (instance != null) {
      return instance;
    }
    return new GuideFragment();
  }
  
  public static void removeWrongActionDialog()
  {
    if (isWrongActionDialogVisible) {
      isWrongActionDialogVisible = false;
    }
  }
  
  public static void showCompleteDialog(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    isGuideCompleted = false;
    if (GMode.equals("view_all_apps"))
    {
      isViewApps = false;
      mGuider = new ViewAppsGuider(paramActivity);
      if (!isViewAppsDialogDismissed) {
        mGuider.dismissHelpDialog();
      }
    }
    new Handler().post(new Runnable()
    {
      public void run()
      {
        this.val$activity.onBackPressed();
      }
    });
  }
  
  public static void showToast(Context paramContext)
  {
    paramContext.setTheme(2131820545);
    Toast.makeText(paramContext, 2131755175, 0).show();
    HelpAnimatedDialog.setAlpha();
  }
  
  public static void showToast_createfolder(Context paramContext)
  {
    paramContext = Toast.makeText(paramContext, 2131755185, 0);
    paramContext.setGravity(17, 0, 0);
    paramContext.show();
  }
  
  public static void showWrongActionDialog(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Toast.makeText(paramActivity, 2131755175, 1).show();
    if (GMode.equals("view_all_apps"))
    {
      isViewApps = false;
      mGuider = new ViewAppsGuider(paramActivity);
      if (!isViewAppsDialogDismissed) {
        mGuider.dismissHelpDialog();
      }
    }
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        this.val$activity.onBackPressed();
      }
    }, 100L);
    isWrongActionDialogVisible = true;
  }
  
  public void onConfigurationChanged(final Configuration paramConfiguration, final Activity paramActivity, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        Log.d("Guide fragment", "Guide fragment -> onConfigurationChanged");
        if (paramIntent == null) {
          return;
        }
        if (paramIntent.getExtras() != null)
        {
          Log.d("GuideFragment", "get extras not null");
          GMode = paramIntent.getStringExtra("homescreen:guide_mode");
          if (GMode == null)
          {
            Log.d("GuideFragment", "guide mode is not ours");
            continue;
          }
        }
        localObject = (Launcher)paramActivity;
      }
      finally {}
      HomeView localHomeView = ((Launcher)localObject).getHomeView();
      Object localObject = ((Launcher)localObject).getMenuView();
      if ((localHomeView != null) || (localObject != null))
      {
        if (GMode.equals("add_widgets"))
        {
          Log.d("GuideFragment", " showing help dialog--add widgets");
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new AddWidgetsGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("onBackPressed"))
        {
          paramConfiguration = paramIntent.getStringExtra("currentGmode");
          GMode = paramConfiguration;
          if (paramConfiguration.equals("navigation")) {
            mGuider = new NavigationGuider(paramActivity);
          }
          if (paramConfiguration.equals("addapps"))
          {
            isViewApps = false;
            mGuider = new AddAppsGuider(paramActivity);
          }
          if (paramConfiguration.equals("add_widgets"))
          {
            mGuider = new AddWidgetsGuider(paramActivity);
            isViewApps = false;
          }
          if (paramConfiguration.equals("view_all_apps"))
          {
            isViewApps = false;
            mGuider = new ViewAppsGuider(paramActivity);
          }
          if (paramConfiguration.equals("resize_widgets")) {
            mGuider = new ResizeWidgetsGuider(paramActivity);
          }
          if (paramConfiguration.equals("create_folder")) {
            mGuider = new CreateFolderGuider(paramActivity);
          }
          if (paramConfiguration.equals("move_app")) {
            mGuider = new MoveAppsGuider(paramActivity);
          }
          if (paramConfiguration.equals("remove_items")) {
            mGuider = new RemoveItemsGuider(paramActivity);
          }
          if (mGuider != null) {
            mGuider.dismissHelpDialog();
          }
        }
        else if (GMode.equals("addapps"))
        {
          if (mGuider != null)
          {
            Log.d("GuideFragment", "" + mGuider);
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new AddAppsGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("view_all_apps"))
        {
          isViewApps = true;
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new ViewAppsGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("change_wallpaper"))
        {
          if (mGuider != null)
          {
            mGuider.dismissHelpDialog();
            mGuider = null;
          }
          mGuider = new ChangeWallpaperGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("resize_widgets"))
        {
          sHelpHubStepNumber = 1;
          ResizeWidgetsGuider.isWidgetToBeAdded = false;
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              GuideFragment.mGuider = new ResizeWidgetsGuider(paramActivity);
              GuideFragment.mGuider.onConfigurationChanged(paramConfiguration);
            }
          }, 400L);
        }
        else if (GMode.equals("create_folder"))
        {
          isViewApps = true;
          mGuider = new CreateFolderGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("remove_items"))
        {
          mGuider = new RemoveItemsGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
        else if (GMode.equals("move_app"))
        {
          mGuider = new MoveAppsGuider(paramActivity);
          mGuider.onConfigurationChanged(paramConfiguration);
        }
      }
      else {
        Log.d("GuideFragment", "frag=null");
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/GuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */