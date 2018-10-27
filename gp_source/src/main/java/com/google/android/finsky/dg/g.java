package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class g
  implements Runnable
{
  g(f paramf) {}
  
  public final void run()
  {
    Iterator localIterator = this.a.f.getMySessions().iterator();
    while (localIterator.hasNext())
    {
      SessionInfo localSessionInfo1 = (SessionInfo)localIterator.next();
      if (this.a.a(localSessionInfo1))
      {
        FinskyLog.a("Skipping instant app session id %d", new Object[] { Integer.valueOf(localSessionInfo1.getSessionId()) });
      }
      else
      {
        String str = localSessionInfo1.getAppPackageName();
        SessionInfo localSessionInfo2 = (SessionInfo)this.a.h.put(str, localSessionInfo1);
        if (localSessionInfo2 != null) {
          FinskyLog.c("Multiple sessions for %s found. Removing %d & keeping %d.", new Object[] { str, Integer.valueOf(localSessionInfo2.getSessionId()), Integer.valueOf(localSessionInfo1.getSessionId()) });
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */