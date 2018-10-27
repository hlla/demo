package com.google.android.finsky.by.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.finsky.af.e;
import com.google.android.finsky.cg.k;
import com.google.android.finsky.packagemanager.h;
import com.google.android.finsky.utils.FinskyLog;

public final class a
  implements h
{
  public final b.a a;
  private final Context b;
  
  public a(Context paramContext, b.a parama)
  {
    this.b = paramContext;
    this.a = parama;
  }
  
  private final void a(String paramString1, int paramInt, String paramString2)
  {
    ((com.google.android.finsky.l.a)this.a.a()).b.d().a(new b(this, paramString1, paramInt, paramString2));
  }
  
  public final void a(String[] paramArrayOfString) {}
  
  public final void b(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if ("com.google.android.gms".equals(paramString))
    {
      localObject = new Intent("com.google.android.gms.GMS_UPDATED");
      ((Intent)localObject).setPackage("com.google.android.gms");
      this.b.sendBroadcast((Intent)localObject);
    }
    try
    {
      localObject = this.b.getPackageManager().getApplicationInfo(paramString, 0);
      int j = ((ApplicationInfo)localObject).flags;
      if ((j & 0x80) == 0) {}
      for (;;)
      {
        if ((j & 0x1) == 0) {}
        while (i != 0)
        {
          a(paramString, 1, "install/update");
          return;
        }
        a(paramString, 2, "downgrade");
        return;
        i = 1;
      }
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      FinskyLog.c("NameNotFoundException getting info for %s", new Object[] { paramString });
    }
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && ("com.google.android.gms".equals(paramString))) {
      a(paramString, 2, "removed");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/by/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */