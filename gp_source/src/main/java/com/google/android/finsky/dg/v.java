package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller.Session;
import java.util.concurrent.CountDownLatch;

final class v
  implements Runnable
{
  v(f paramf, PackageInstaller.Session[] paramArrayOfSession, String paramString, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    this.d[0] = this.a.c(this.c);
    this.b.countDown();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */