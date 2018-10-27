package com.google.android.finsky.cm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.finsky.af.e;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.cg.k;
import com.google.android.finsky.packagemanager.h;
import com.google.android.finsky.utils.FinskyLog;
import java.util.List;

public final class b
  implements h
{
  public final b.a a;
  private final Context b;
  private final com.google.android.finsky.bo.c c;
  
  public b(Context paramContext, com.google.android.finsky.bo.c paramc, b.a parama)
  {
    this.b = paramContext;
    this.c = paramc;
    this.a = parama;
  }
  
  private final void a(String paramString1, int paramInt, String paramString2)
  {
    ((com.google.android.finsky.l.a)this.a.a()).b.d().a(new c(this, paramString1, paramInt, paramString2));
  }
  
  public final void a(String[] paramArrayOfString) {}
  
  public final void b(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean)
  {
    Intent localIntent;
    if ("com.google.android.instantapps.supervisor".equals(paramString))
    {
      a(paramString, 1, "install/update");
      if (!this.c.cY().a(12626696L))
      {
        paramString = this.b;
        localIntent = new Intent((String)d.eM.b());
        localIntent.setClassName("com.google.android.instantapps.supervisor", (String)d.eO.b());
        if (!paramString.getPackageManager().queryBroadcastReceivers(localIntent, 0).isEmpty()) {
          break label106;
        }
        FinskyLog.b("No receiver found for intent: %s", new Object[] { localIntent });
      }
    }
    return;
    label106:
    localIntent.setFlags(32);
    FinskyLog.b("Sending broadcast: %s", new Object[] { localIntent });
    paramString.sendBroadcast(localIntent);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && ("com.google.android.instantapps.supervisor".equals(paramString))) {
      a(paramString, 2, "removed");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cm/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */