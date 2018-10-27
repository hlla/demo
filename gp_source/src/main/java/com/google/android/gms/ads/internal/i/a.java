package com.google.android.gms.ads.internal.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.c.k;
import android.support.c.m;
import java.util.List;
import org.chromium.customtabsclient.shared.c;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements c
{
  public android.support.c.b a;
  public k b;
  public b c;
  public m d;
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    Object localObject1 = paramContext.getPackageManager();
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
      ResolveInfo localResolveInfo = ((PackageManager)localObject1).resolveActivity((Intent)localObject2, 0);
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 65536);
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (localResolveInfo != null)
        {
          int i = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i >= ((List)localObject1).size()) {
              return bool1;
            }
            localObject2 = (ResolveInfo)((List)localObject1).get(i);
            if (localResolveInfo.activityInfo.name.equals(((ResolveInfo)localObject2).activityInfo.name)) {
              break;
            }
            i += 1;
          }
          bool1 = localResolveInfo.activityInfo.packageName.equals(org.chromium.customtabsclient.shared.a.a(paramContext));
        }
      }
    }
    return bool1;
  }
  
  public final void a()
  {
    this.a = null;
    this.d = null;
  }
  
  public final void a(android.support.c.b paramb)
  {
    this.a = paramb;
    this.a.a();
    paramb = this.c;
    if (paramb != null) {
      paramb.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */