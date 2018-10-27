package android.support.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;

public class b
{
  private final p a;
  private final ComponentName b;
  
  b(p paramp, ComponentName paramComponentName)
  {
    this.a = paramp;
    this.b = paramComponentName;
  }
  
  public static boolean a(Context paramContext, String paramString, k paramk)
  {
    Intent localIntent = new Intent("android.support.customtabs.action.CustomTabsService");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.setPackage(paramString);
    }
    return paramContext.bindService(localIntent, paramk, 33);
  }
  
  public final m a(a parama)
  {
    Object localObject = null;
    c localc = new c(parama);
    try
    {
      boolean bool = this.a.a(localc);
      parama = (a)localObject;
      if (bool) {
        parama = new m(this.a, localc, this.b);
      }
      return parama;
    }
    catch (RemoteException parama) {}
    return null;
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.a.a();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */