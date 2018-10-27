package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class cm
{
  private final Context a;
  private final NotificationManager b;
  
  static
  {
    new Object();
    new HashSet();
    new Object();
  }
  
  private cm(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((NotificationManager)this.a.getSystemService("notification"));
  }
  
  public static cm a(Context paramContext)
  {
    return new cm(paramContext);
  }
  
  public final boolean a()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.b.areNotificationsEnabled();
    }
    AppOpsManager localAppOpsManager;
    Object localObject;
    String str;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAppOpsManager = (AppOpsManager)this.a.getSystemService("appops");
      localObject = this.a.getApplicationInfo();
      str = this.a.getApplicationContext().getPackageName();
      i = ((ApplicationInfo)localObject).uid;
    }
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      return i == 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */