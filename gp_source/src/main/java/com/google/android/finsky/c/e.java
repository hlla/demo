package com.google.android.finsky.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.volley.a.ak;
import com.android.volley.f;
import com.android.volley.n;
import com.google.android.finsky.api.ab;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class e
  extends ak
{
  private final Context k;
  private final i l;
  
  e(Context paramContext, String paramString, d paramd, a parama, f paramf, i parami)
  {
    super(paramString, paramd, parama);
    this.k = paramContext;
    this.l = parami;
    this.g = paramf;
  }
  
  public final Map f()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localObject = this.k.getPackageManager().getPackageInfo(this.k.getPackageName(), 0);
        boolean bool = this.k.getResources().getBoolean(2131034157);
        String str1 = ab.a(VERSION.RELEASE);
        String str2 = ab.a(Build.MODEL);
        String str3 = ab.a(Build.ID);
        String str4 = ab.a(((PackageInfo)localObject).versionName);
        if (bool) {
          continue;
        }
        localObject = " Mobile";
        localHashMap.put("User-Agent", String.format(Locale.US, "Mozilla/5.0 (Linux; Android %s; %s Build/%s) AppleWebKit/537.36 Finsky/%s%s", new Object[] { str1, str2, str3, str4, localObject }));
      }
      catch (NameNotFoundException localNameNotFoundException)
      {
        Object localObject;
        FinskyLog.e("Can't find our own package", new Object[0]);
        continue;
      }
      if (!"https".equalsIgnoreCase(Uri.parse(ac_()).getScheme())) {
        this.l.cV().a(new com.google.android.finsky.e.d(1106).a, null, -1L);
      }
      return localHashMap;
      localObject = "";
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */