package android.support.v4.app;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class cc
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    return cl.a(paramNotification);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */