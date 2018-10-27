package android.support.v4.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Process;

public final class x
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
  
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = -1;
    int i = j;
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) != -1) {
      if (Build.VERSION.SDK_INT < 23) {
        break label116;
      }
    }
    label112:
    label116:
    for (paramString1 = AppOpsManager.permissionToOp(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        String str = paramString2;
        if (paramString2 == null)
        {
          paramString2 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
          i = j;
          if (paramString2 != null)
          {
            i = j;
            if (paramString2.length > 0) {
              str = paramString2[0];
            }
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, str) == 0)) {
            break label112;
          }
          i = -2;
        }
        return i;
        return 0;
      }
      return 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */