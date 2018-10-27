package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.graphics.Bitmap;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;

final class u
  implements Runnable
{
  u(f paramf, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    SessionInfo localSessionInfo = (SessionInfo)this.a.h.get(this.c);
    if (localSessionInfo != null) {}
    try
    {
      this.a.f.updateSessionAppIcon(localSessionInfo.getSessionId(), this.b);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      FinskyLog.c("Stale session id %d for %s", new Object[] { Integer.valueOf(localSessionInfo.getSessionId()), this.c });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */