package com.google.android.finsky.co.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.j;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.leolin.shortcutbadger.b;

public final class a
  implements com.google.android.finsky.co.a
{
  private final boolean a;
  private final Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (!b()) {
        bool1 = true;
      }
    }
    this.a = bool1;
  }
  
  private final boolean a()
  {
    try
    {
      boolean bool = b.a(this.b);
      return bool;
    }
    finally
    {
      FinskyLog.a(localThrowable, "Badge counter support check failed.", new Object[0]);
    }
    return false;
  }
  
  private final boolean b()
  {
    List localList = Arrays.asList(j.a((String)d.iR.b()));
    try
    {
      Object localObject = this.b.getPackageManager().getInstalledApplications(0);
      ApplicationInfo localApplicationInfo;
      String str;
      do
      {
        localObject = ((List)localObject).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localApplicationInfo = (ApplicationInfo)((Iterator)localObject).next();
          localIterator = localList.iterator();
        }
        str = (String)localIterator.next();
      } while (!localApplicationInfo.packageName.contains(str));
      FinskyLog.c("Found incompatible package: %s", new Object[] { localApplicationInfo.packageName });
      return true;
      return false;
    }
    catch (Exception localException)
    {
      FinskyLog.c("Error getting installed packages: %s", new Object[] { localException });
    }
    return true;
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool = false;
    if (this.a) {}
    try
    {
      bool = b.a(this.b, paramInt);
      return bool;
    }
    finally
    {
      FinskyLog.a(localThrowable, "Badge icon count application failed.", new Object[0]);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/co/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */