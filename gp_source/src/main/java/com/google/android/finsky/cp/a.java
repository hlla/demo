package com.google.android.finsky.cp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.installer.b.a.e;
import com.google.android.finsky.installqueue.n;
import com.google.android.finsky.installqueue.r;
import com.google.android.finsky.utils.FinskyLog;

public final class a
  implements r
{
  private final Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(n paramn)
  {
    Intent localIntent;
    switch (paramn.f.f)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      localIntent = null;
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localIntent.setPackage((String)d.dN.b());
        localIntent.setData(Uri.fromParts("package", paramn.a(), null));
        FinskyLog.b("GEL broadcast uri=[%s], action=[%s], for package=[%s]", new Object[] { localIntent.getData(), localIntent.getAction(), paramn.a() });
        this.a.sendBroadcast(localIntent);
      }
      return;
      localIntent = new Intent("com.android.launcher.action.ACTION_PACKAGE_DEQUEUED");
      if (paramn.f.f == 6) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("com.android.launcher.action.INSTALL_COMPLETED", bool);
        break;
      }
      localIntent = new Intent("com.android.launcher.action.ACTION_PACKAGE_INSTALLING");
      continue;
      localIntent = new Intent("com.android.launcher.action.ACTION_PACKAGE_DOWNLOADING");
      continue;
      localIntent = new Intent("com.android.launcher.action.ACTION_PACKAGE_ENQUEUED");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */