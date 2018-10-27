package com.google.android.finsky.bw;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;

final class aa
  extends AsyncTask
{
  private final z a;
  private final PackageManager b;
  
  public aa(PackageManager paramPackageManager, z paramz)
  {
    this.b = paramPackageManager;
    this.a = paramz;
  }
  
  private final Drawable a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    try
    {
      if (Build.VERSION.SDK_INT < 22) {
        return this.b.getApplicationIcon(paramVarArgs);
      }
      paramVarArgs = this.b.getApplicationInfo(paramVarArgs, 1024).loadUnbadgedIcon(this.b);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */