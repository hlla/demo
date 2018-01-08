package com.android.launcher2;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

abstract interface AvailableWidgetListProvider
{
  public static final boolean DEBUG = true;
  public static final boolean DEBUGGABLE = ;
  
  public abstract AvailableWidget getAvailableWidget(ComponentName paramComponentName);
  
  public abstract List<AvailableWidget> getAvailableWidgets();
  
  public abstract boolean isShortcutWidget(String paramString);
  
  public static final class Util
  {
    private static final int UNINSTALLABLE = 129;
    
    public static boolean canUninstall(ApplicationInfo paramApplicationInfo)
    {
      if ((MenuAppLoader.nonUninstallableWidgets.contains(paramApplicationInfo.packageName)) && (Build.MODEL.equals("SM-T310X"))) {}
      while ((paramApplicationInfo.flags & 0x81) != 0) {
        return false;
      }
      return true;
    }
    
    public static boolean canUninstall(PackageManager paramPackageManager, String paramString)
    {
      try
      {
        boolean bool = canUninstall(paramPackageManager.getApplicationInfo(paramString, 0));
        return bool;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager) {}
      return false;
    }
    
    public static boolean isSecret(PackageManager paramPackageManager, String paramString)
    {
      return false;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableWidgetListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */