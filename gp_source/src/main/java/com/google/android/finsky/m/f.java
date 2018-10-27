package com.google.android.finsky.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  @SuppressLint({"InlinedApi"})
  @TargetApi(21)
  private static Map a(Context paramContext, long paramLong1, long paramLong2, af paramaf)
  {
    int i = ((AppOpsManager)paramContext.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), paramContext.getPackageName());
    if (i != 0)
    {
      if (!((Boolean)com.google.android.finsky.ag.d.cq.b()).booleanValue()) {}
      while (i != 3)
      {
        a(paramaf, 1);
        return Collections.emptyMap();
      }
    }
    for (;;)
    {
      UsageStats localUsageStats;
      String str;
      b localb;
      try
      {
        paramContext = (UsageStatsManager)paramContext.getSystemService("usagestats");
        if (paramContext == null) {
          break label332;
        }
        Object localObject = paramContext.queryUsageStats(3, paramLong1, paramLong2);
        if (localObject == null) {
          break label312;
        }
        paramContext = new HashMap();
        paramLong1 = i.a();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          return paramContext;
        }
        localUsageStats = (UsageStats)((Iterator)localObject).next();
        if (localUsageStats.getLastTimeUsed() > paramLong1) {
          continue;
        }
        str = localUsageStats.getPackageName();
        localb = (b)paramContext.get(str);
        if (localb == null)
        {
          paramContext.put(str, new b(str, localUsageStats.getLastTimeUsed(), localUsageStats.getFirstTimeStamp(), localUsageStats.getLastTimeStamp(), localUsageStats.getTotalTimeInForeground()));
          continue;
        }
      }
      catch (Exception paramContext)
      {
        FinskyLog.c("Unable to invoke method: %s", new Object[] { paramContext.getMessage() });
        a(paramaf, 7);
      }
      paramLong2 = Math.max(localb.b, localUsageStats.getLastTimeUsed());
      long l1 = Math.min(localb.e, localUsageStats.getFirstTimeStamp());
      long l2 = Math.max(localb.d, localUsageStats.getLastTimeStamp());
      long l3 = localb.a;
      paramContext.put(str, new b(str, paramLong2, l1, l2, localUsageStats.getTotalTimeInForeground() + l3));
    }
    label312:
    FinskyLog.c("queryUsageStats returned null", new Object[0]);
    a(paramaf, 6);
    return Collections.emptyMap();
    label332:
    FinskyLog.c("UsageStatsManager is not available", new Object[0]);
    a(paramaf, 5);
    paramContext = Collections.emptyMap();
    return paramContext;
    return paramContext;
  }
  
  public static Map a(Context paramContext, af paramaf)
  {
    long l = i.a();
    paramContext = paramContext.getApplicationContext();
    if (com.google.android.finsky.utils.a.d()) {
      return a(paramContext, l - 31449600000L, l, paramaf);
    }
    return b(paramContext, paramaf);
  }
  
  private static void a(af paramaf, int paramInt)
  {
    paramaf.a(new com.google.android.finsky.e.d(154).a(paramInt));
  }
  
  private static Map b(Context paramContext, af paramaf)
  {
    Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
    for (;;)
    {
      try
      {
        localObject3 = localObject2.getClass().getDeclaredMethod("getAllPackageUsageStats", new Class[0]);
        if (paramContext.getPackageManager().checkPermission("android.permission.PACKAGE_USAGE_STATS", paramContext.getPackageName()) != 0) {}
      }
      catch (NoSuchMethodException paramContext)
      {
        Object localObject3;
        Object localObject1;
        int j;
        int i;
        FinskyLog.b("Unable to get package usage stats method", new Object[0]);
        a(paramaf, 3);
        return Collections.emptyMap();
      }
      try
      {
        localObject1 = Class.forName("com.android.internal.os.PkgUsageStats");
        paramContext = ((Class)localObject1).getDeclaredField("componentResumeTimes");
        localObject1 = ((Class)localObject1).getDeclaredField("packageName");
        localObject2 = (Object[])((Method)localObject3).invoke(localObject2, new Object[0]);
        localObject3 = new HashMap();
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          Object localObject4 = localObject2[i];
          Iterator localIterator = ((HashMap)paramContext.get(localObject4)).values().iterator();
          long l = 0L;
          if (!localIterator.hasNext())
          {
            localObject4 = (String)((Field)localObject1).get(localObject4);
            ((Map)localObject3).put(localObject4, new b((String)localObject4, l, -1L, -1L, 0L));
            i += 1;
          }
          else
          {
            l = Math.max(l, ((Long)localIterator.next()).longValue());
          }
        }
        else
        {
          return (Map)localObject3;
        }
      }
      catch (Exception paramContext)
      {
        FinskyLog.c("Unable to invoke method: %s", new Object[] { paramContext.getMessage() });
        a(paramaf, 4);
      }
    }
    a(paramaf, 2);
    return Collections.emptyMap();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/m/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */