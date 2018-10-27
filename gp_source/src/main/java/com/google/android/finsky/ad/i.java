package com.google.android.finsky.ad;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.settings.deletionservice.f;
import java.util.Iterator;
import java.util.List;

final class i
  implements ServiceConnection
{
  i(a parama) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (a.c)
    {
      this.a.d = f.a(paramIBinder);
      paramIBinder = this.a.e.iterator();
      if (!paramIBinder.hasNext())
      {
        this.a.e.clear();
        return;
      }
      ((n)paramIBinder.next()).a();
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (a.c)
    {
      a locala = this.a;
      locala.d = null;
      locala.f = null;
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ad/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */