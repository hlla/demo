package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class b
  implements Runnable
{
  b(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    int[] arrayOfInt = new int[this.b.length];
    PackageManager localPackageManager = this.a.getPackageManager();
    String str = this.a.getPackageName();
    int j = this.b.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(this.b[i], str);
      i += 1;
    }
    ((c)this.a).onRequestPermissionsResult(this.c, this.b, arrayOfInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */