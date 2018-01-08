package com.android.launcher2.guide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.launcher2.HomeView;
import com.android.launcher2.Launcher;

public final class GuideModeHelper
{
  public static final int ACTION_BAR_POINTER_SHOW_DELAY = 150;
  public static final String GUIDE_MODE_NAVIGATION = "navigation";
  public static final String GUIDE_MODE_VIEWAPPS = "viewapps";
  public static final String HOMESCREEN_GUIDE_COMPLETED = "homescreen:guide_completed";
  public static final String HOMESCREEN_GUIDE_IS_ON = "homescreen:guide_is_on";
  public static final String HOMESCREEN_GUIDE_MODE = "homescreen:guide_mode";
  private static boolean mIsTablet = false;
  
  protected static void emulateTouchOnFocusedView(Activity paramActivity) {}
  
  static String getGuideModeFromBundle(Bundle paramBundle)
  {
    String str2 = null;
    String str1 = str2;
    if (paramBundle != null)
    {
      str1 = str2;
      if (paramBundle.containsKey("homescreen:guide_mode"))
      {
        str2 = paramBundle.getString("homescreen:guide_mode");
        str1 = str2;
        if (!paramBundle.containsKey("homescreen:guide_is_on"))
        {
          paramBundle.remove("homescreen:guide_mode");
          str1 = str2;
        }
      }
    }
    return str1;
  }
  
  static String getGuideModeFromIntent(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null) {}
    for (paramBundle1 = paramBundle1.getString("homescreen:guide_mode");; paramBundle1 = null)
    {
      Object localObject = paramBundle1;
      if (paramBundle1 == null) {
        localObject = getGuideModeFromBundle(paramBundle2);
      }
      return (String)localObject;
    }
  }
  
  static void init(Context paramContext) {}
  
  static boolean isGuideCompleted(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.containsKey("homescreen:guide_completed"))
      {
        bool1 = paramBundle.getBoolean("homescreen:guide_completed");
        paramBundle.remove("homescreen:guide_completed");
      }
    }
    return bool1;
  }
  
  static boolean isGuideModeNavigation(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {
      bool = paramString.equals("navigation");
    }
    return bool;
  }
  
  static boolean isGuideModeViewApps(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {
      bool = paramString.equals("viewapps");
    }
    return bool;
  }
  
  static boolean isInGuideMode(Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool2 = false;
    if ((paramBundle1 != null) && (paramBundle1.containsKey("homescreen:guide_is_on"))) {
      bool1 = paramBundle1.getBoolean("homescreen:guide_is_on");
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramBundle2 == null);
      bool1 = bool2;
    } while (!paramBundle2.containsKey("homescreen:guide_is_on"));
    boolean bool1 = paramBundle2.getBoolean("homescreen:guide_is_on");
    paramBundle2.remove("homescreen:guide_is_on");
    return bool1;
  }
  
  static boolean isTablet()
  {
    return mIsTablet;
  }
  
  static void setHomeViewDisabled(boolean paramBoolean, Activity paramActivity)
  {
    if ((paramActivity instanceof Launcher))
    {
      paramActivity = ((Launcher)paramActivity).getHomeView();
      if (paramActivity != null) {
        paramActivity.cancelClicksOnHome();
      }
    }
  }
  
  static boolean switchMode(Activity paramActivity)
  {
    return isTablet();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/GuideModeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */