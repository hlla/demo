package com.google.android.finsky.ba;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.d.a;
import com.google.android.d.b;
import com.google.android.finsky.utils.FinskyLog;

final class f
  implements ServiceConnection
{
  private final Context a;
  private final e b;
  
  f(d paramd, Context paramContext, e parame)
  {
    this.a = paramContext;
    this.b = parame;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    label51:
    try
    {
      paramComponentName = b.a(paramIBinder);
    }
    finally {}
    try
    {
      this.c.a = Boolean.valueOf(paramComponentName.a());
    }
    catch (RemoteException paramComponentName)
    {
      FinskyLog.e("Error calling school-ownership service; assume not school-owned", new Object[0]);
      this.c.a = Boolean.valueOf(false);
      this.a.unbindService(this);
      this.b.a(this.c.a.booleanValue());
      break label51;
    }
    finally
    {
      this.a.unbindService(this);
      this.b.a(this.c.a.booleanValue());
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ba/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */