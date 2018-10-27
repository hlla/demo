package com.google.android.finsky.cj;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.g.h;
import com.google.android.finsky.instantapps.PhenotypeUpdateService;
import com.google.android.finsky.utils.FinskyLog;

public final class a
  implements com.google.android.finsky.bo.g
{
  private final Context a;
  private final b.a b;
  private final com.google.android.finsky.ba.g c;
  
  public a(Context paramContext, b.a parama, com.google.android.finsky.ba.g paramg)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = paramg;
  }
  
  private final boolean a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    paramString = new ComponentName(this.a, paramString);
    int j = ((PackageManager)this.b.a()).getComponentEnabledSetting(paramString);
    if (!paramBoolean) {}
    while (j != 1)
    {
      if (paramBoolean) {}
      while ((j != 2) && (j != 4))
      {
        if (j != 3)
        {
          PackageManager localPackageManager = (PackageManager)this.b.a();
          if (!paramBoolean) {}
          for (;;)
          {
            localPackageManager.setComponentEnabledSetting(paramString, i, 1);
            return true;
            i = 1;
          }
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public final void a(h paramh1, h paramh2)
  {
    if (a())
    {
      if (paramh2.b(12625103L) < 0) {
        break label23;
      }
      b(true);
    }
    label23:
    while (paramh1.b(12625103L) < 0) {
      return;
    }
    b(false);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a()
  {
    return ((this.c.f() == 0) || (this.c.f() == 3)) && (!this.c.d()) && (android.support.v4.os.a.b());
  }
  
  public final void b(boolean paramBoolean)
  {
    if (!a())
    {
      FinskyLog.b("Skipping Instant App setup for unsupported device.", new Object[0]);
      return;
    }
    boolean bool1 = a("com.google.android.finsky.instantapps.EphemeralInstallerActivity", paramBoolean);
    boolean bool2 = a("com.google.android.finsky.instantapps.InstantAppsConfigChangeListener", paramBoolean);
    boolean bool3 = a("com.google.android.finsky.instantapps.ContentFilterUpdatedReceiver", paramBoolean);
    boolean bool4 = a("com.google.android.finsky.instantapps.appmanagement.InstantAppRemoveMonitor", paramBoolean);
    if (bool1) {}
    while ((bool2) || (bool3) || (bool4))
    {
      if (!paramBoolean)
      {
        PhenotypeUpdateService.c(this.a);
        return;
      }
      PhenotypeUpdateService.b(this.a);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cj/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */