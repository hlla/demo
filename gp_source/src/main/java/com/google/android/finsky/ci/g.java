package com.google.android.finsky.ci;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.finsky.dh.a;
import com.google.android.finsky.dh.b;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public static b a(String paramString, a parama, boolean paramBoolean)
  {
    if (parama.a(paramString, paramBoolean) == null) {
      parama.d(paramString);
    }
    return parama.a(paramString, paramBoolean);
  }
  
  public static CharSequence a(String paramString, Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationInfo(paramString, 0).loadLabel(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      FinskyLog.b(paramContext, "No title found for package name: %s", new Object[] { paramString });
    }
    return paramString;
  }
  
  public static boolean a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance <= paramInt) && ((paramString.equals(localRunningAppProcessInfo.processName)) || (Arrays.asList(localRunningAppProcessInfo.pkgList).contains(paramString)))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ci/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */