package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public final class a
  extends android.support.v4.content.d
{
  public static d a()
  {
    return null;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.finishAffinity();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof e)) {
        ((e)paramActivity).c_(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
    }
    while (!(paramActivity instanceof c)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new b(paramArrayOfString, paramActivity, paramInt));
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */