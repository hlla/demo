package com.google.android.finsky.c;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.gms.ads.adshield.a.c;
import com.google.android.gms.dynamic.e;

final class l
  implements Runnable
{
  l(k paramk, MotionEvent paramMotionEvent) {}
  
  public final void run()
  {
    com.google.android.finsky.dp.a locala = this.a.a;
    MotionEvent localMotionEvent = this.b;
    if (locala.a()) {}
    try
    {
      locala.a.a.d(e.a(localMotionEvent));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      FinskyLog.d("Error accessing AdShield: %s", new Object[] { localNullPointerException });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */