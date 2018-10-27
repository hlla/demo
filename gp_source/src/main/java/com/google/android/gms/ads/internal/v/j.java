package com.google.android.gms.ads.internal.v;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.g;

@a
public final class j
{
  public final g a;
  public int b = 0;
  public long c = -1L;
  public long d = -1L;
  public int e = 0;
  public final Object f = new Object();
  public int g = -1;
  public int h = -1;
  public long i = 0L;
  private final String j;
  
  public j(String paramString, g paramg)
  {
    this.j = paramString;
    this.a = paramg;
  }
  
  private static boolean a(Context paramContext)
  {
    int k = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (k == 0)
    {
      e.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (k != paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme)
      {
        e.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      e.e("Fail to fetch AdActivity theme");
      e.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    return true;
  }
  
  public final Bundle a(Context paramContext, String paramString)
  {
    synchronized (this.f)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.j);
      localBundle.putLong("basets", this.d);
      localBundle.putLong("currts", this.c);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.g);
      localBundle.putInt("preqs_in_session", this.h);
      localBundle.putLong("time_in_session", this.i);
      localBundle.putInt("pclick", this.b);
      localBundle.putInt("pimp", this.e);
      localBundle.putBoolean("support_transparent_background", a(paramContext));
      return localBundle;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */