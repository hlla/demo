package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;

public final class ca
{
  public static Intent a(Activity paramActivity)
  {
    Object localObject = paramActivity.getParentActivityIntent();
    ComponentName localComponentName;
    if (localObject == null)
    {
      localObject = b(paramActivity);
      if (localObject != null) {
        localComponentName = new ComponentName(paramActivity, (String)localObject);
      }
    }
    else
    {
      try
      {
        if (b(paramActivity, localComponentName) != null) {
          return new Intent().setComponent(localComponentName);
        }
        paramActivity = Intent.makeMainActivity(localComponentName);
        return paramActivity;
      }
      catch (PackageManager.NameNotFoundException paramActivity)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getParentActivityIntent: bad parentActivityName '");
        paramActivity.append((String)localObject);
        paramActivity.append("' in manifest");
        Log.e("NavUtils", paramActivity.toString());
      }
      return (Intent)localObject;
    }
    return null;
  }
  
  public static Intent a(Context paramContext, ComponentName paramComponentName)
  {
    String str = b(paramContext, paramComponentName);
    if (str != null)
    {
      paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
      if (b(paramContext, paramComponentName) != null) {
        return new Intent().setComponent(paramComponentName);
      }
      return Intent.makeMainActivity(paramComponentName);
    }
    return null;
  }
  
  public static String b(Activity paramActivity)
  {
    try
    {
      paramActivity = b(paramActivity, paramActivity.getComponentName());
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      throw new IllegalArgumentException(paramActivity);
    }
  }
  
  private static String b(Context paramContext, ComponentName paramComponentName)
  {
    ActivityInfo localActivityInfo = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    String str = localActivityInfo.parentActivityName;
    paramComponentName = str;
    if (str == null)
    {
      if (localActivityInfo.metaData == null) {
        break label88;
      }
      str = localActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
      if (str == null) {
        break label86;
      }
      paramComponentName = str;
      if (str.charAt(0) == '.')
      {
        paramComponentName = new StringBuilder();
        paramComponentName.append(paramContext.getPackageName());
        paramComponentName.append(str);
        paramComponentName = paramComponentName.toString();
      }
    }
    return paramComponentName;
    label86:
    return null;
    label88:
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */