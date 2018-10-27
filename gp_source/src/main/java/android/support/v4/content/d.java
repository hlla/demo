package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;

public class d
{
  static
  {
    new Object();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  private static File a(File paramFile)
  {
    Object localObject = paramFile;
    try
    {
      if (!paramFile.exists())
      {
        localObject = paramFile;
        if (!paramFile.mkdirs())
        {
          localObject = paramFile;
          if (!paramFile.exists())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unable to create files subdir ");
            ((StringBuilder)localObject).append(paramFile.getPath());
            Log.w("ContextCompat", ((StringBuilder)localObject).toString());
            localObject = null;
          }
        }
      }
      return (File)localObject;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    paramContext.startActivity(paramIntent, paramBundle);
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    paramContext.startActivities(paramArrayOfIntent, null);
    return true;
  }
  
  public static File[] a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(null);
    }
    return new File[] { paramContext.getExternalFilesDir(null) };
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static File[] b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  public static File c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getNoBackupFilesDir();
    }
    return a(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */