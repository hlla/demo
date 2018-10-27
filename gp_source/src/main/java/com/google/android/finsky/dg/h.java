package com.google.android.finsky.dg;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInstaller.Session;
import android.content.pm.PackageInstaller.SessionInfo;
import android.os.Handler;
import com.google.android.finsky.accounts.a;
import com.google.android.finsky.utils.FinskyLog;
import java.io.IOException;
import java.util.HashMap;

final class h
  implements Runnable
{
  h(f paramf, String paramString, e parame) {}
  
  public final void run()
  {
    localObject2 = (PackageInstaller.SessionInfo)this.b.h.get(this.c);
    localSession = (PackageInstaller.Session)this.b.e.get(this.c);
    if ((localObject2 != null) && (localSession != null)) {}
    try
    {
      int i = localSession.getNames().length;
      if (i <= 0) {
        break label291;
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          long l;
          Thread.sleep(l);
          Object localObject3 = this.b;
          String str = this.c;
          localObject2 = new k((f)localObject3, str, ((PackageInstaller.SessionInfo)localObject2).getSessionId(), this.a);
          Object localObject1 = String.valueOf("com.android.vending.INTENT_PACKAGE_INSTALL_COMMIT.");
          Object localObject4 = String.valueOf(str);
          if (((String)localObject4).length() == 0) {}
          for (localObject1 = new String((String)localObject1);; localObject1 = ((String)localObject1).concat((String)localObject4))
          {
            localObject4 = new IntentFilter();
            ((IntentFilter)localObject4).addAction((String)localObject1);
            ((f)localObject3).b.registerReceiver((BroadcastReceiver)localObject2, (IntentFilter)localObject4);
            localObject1 = new Intent((String)localObject1);
            localSession.commit(PendingIntent.getBroadcast(((f)localObject3).b, str.hashCode(), (Intent)localObject1, 1207959552).getIntentSender());
            localSession.close();
            this.b.e.remove(this.c);
            return;
          }
          localObject1 = null;
        }
        this.b.b(this.c, ((PackageInstaller.SessionInfo)localObject2).getSessionId());
        this.b.a(new j(this));
        return;
        FinskyLog.e("Unexpected missing open session for %s", new Object[] { this.c });
        this.b.d.post(new i(this));
        return;
        localIOException = localIOException;
        FinskyLog.c("Error calling getNames() on session for: %s", new Object[] { this.c });
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
          FinskyLog.c("Install delay (experiment) interrupted", new Object[0]);
        }
      }
    }
    localObject3 = this.b;
    localObject1 = ((f)localObject3).a.b();
    localObject3 = ((f)localObject3).c;
    if (localObject1 != null)
    {
      localObject1 = ((Account)localObject1).name;
      l = ((com.google.android.finsky.dn.e)localObject3).a("SaturnV", "delay_installation_ms", (String)localObject1);
      if (l <= 0L) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */