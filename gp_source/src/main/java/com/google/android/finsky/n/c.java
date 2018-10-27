package com.google.android.finsky.n;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.google.android.finsky.utils.FinskyLog;

public final class c
{
  public static final Uri a = Uri.parse("content://org.chromium.arc.apk_cache/cache_info");
  private final Context b;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final boolean a()
  {
    boolean bool = true;
    try
    {
      ApplicationInfo localApplicationInfo = this.b.getPackageManager().getApplicationInfo("org.chromium.arc.apkcacheprovider", 0);
      if ((localApplicationInfo == null) || ((localApplicationInfo.flags & 0x1) == 0))
      {
        FinskyLog.e("%s is not a system app.", new Object[] { "org.chromium.arc.apkcacheprovider" });
        bool = false;
      }
      return bool;
    }
    catch (NameNotFoundException localNameNotFoundException) {}
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */