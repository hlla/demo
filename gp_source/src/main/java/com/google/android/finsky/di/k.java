package com.google.android.finsky.di;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.os.UserHandle;
import com.google.android.finsky.utils.FinskyLog;
import java.lang.reflect.Method;
import java.util.UUID;

final class k
{
  static Method a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getClass().getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class });
      return paramContext;
    }
    catch (NoSuchMethodException paramContext)
    {
      FinskyLog.c("Unable to find PackageManager.getPackageSizeInfo", new Object[0]);
    }
    return null;
  }
  
  static Method a(Object paramObject)
  {
    try
    {
      paramObject = paramObject.getClass().getMethod("queryStatsForPackage", new Class[] { UUID.class, String.class, UserHandle.class });
      return (Method)paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      FinskyLog.c("Unable to find query method on StorageStatsService", new Object[0]);
    }
    return null;
  }
  
  static Method a(String paramString)
  {
    try
    {
      paramString = Class.forName("android.app.usage.StorageStats").getMethod(paramString, new Class[0]);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      FinskyLog.c("Unable to find StorageStats class", new Object[0]);
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/di/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */