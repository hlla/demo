package android.support.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

public abstract class k
  implements ServiceConnection
{
  public abstract void a(b paramb);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
      if ((localIInterface != null) && ((localIInterface instanceof p))) {
        paramIBinder = (p)localIInterface;
      }
    }
    for (;;)
    {
      a(new l(paramIBinder, paramComponentName));
      return;
      paramIBinder = new q(paramIBinder);
      continue;
      paramIBinder = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */