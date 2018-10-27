package com.google.android.finsky.ci;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller.Session;
import java.util.concurrent.Executor;

final class e
  extends BroadcastReceiver
{
  e(c paramc, String paramString, PackageInstaller.Session paramSession, Executor paramExecutor, f paramf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.a.unregisterReceiver(this);
    paramContext = this.a;
    String str = this.e;
    PackageInstaller.Session localSession = this.d;
    this.b.execute(new d(paramContext, paramIntent, str, localSession, this.c));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ci/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */