package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller.Session;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;

final class t
  implements Runnable
{
  t(f paramf, String paramString, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    PackageInstaller.Session localSession = this.a.c(this.d);
    if (localSession != null) {}
    try
    {
      long l = this.c;
      if (l > 0L) {
        localSession.setStagingProgress((float)this.b / (float)l);
      }
      return;
    }
    catch (Exception localException)
    {
      FinskyLog.d("Session for %s unexpectedly closed: %s", new Object[] { this.d, localException });
      this.a.e.remove(this.d);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */