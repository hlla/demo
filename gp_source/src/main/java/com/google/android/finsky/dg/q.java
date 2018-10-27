package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller.SessionInfo;
import java.util.HashMap;

final class q
  implements Runnable
{
  q(f paramf, String paramString) {}
  
  public final void run()
  {
    f localf = this.a;
    String str = this.b;
    PackageInstaller.SessionInfo localSessionInfo = (PackageInstaller.SessionInfo)localf.h.get(str);
    if (localSessionInfo != null) {
      localf.b(str, localSessionInfo.getSessionId());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */