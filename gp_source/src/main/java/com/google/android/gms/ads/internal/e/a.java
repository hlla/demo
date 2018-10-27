package com.google.android.gms.ads.internal.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.util.bo;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.z;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  private final Context a;
  
  public a(Context paramContext)
  {
    z.a(paramContext, "Context can not be null");
    this.a = paramContext;
  }
  
  public final boolean a()
  {
    if (((Boolean)bo.a(this.a, new b())).booleanValue())
    {
      Context localContext = this.a;
      if (c.a.a(localContext).a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(Intent paramIntent)
  {
    z.a(paramIntent, "Intent can not be null");
    return this.a.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty() ^ true;
  }
  
  @TargetApi(14)
  public final boolean b()
  {
    return a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */