package com.google.android.gms.ads.internal.util;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class bp
{
  public static void a(Bundle paramBundle)
  {
    Bundle localBundle2 = paramBundle.getBundle(AdMobAdapter.class.getName());
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle1 = new Bundle();
      paramBundle.putBundle(AdMobAdapter.class.getName(), localBundle1);
    }
    localBundle1.putBoolean("render_test_ad_label", true);
  }
  
  public static boolean b(Bundle paramBundle)
  {
    boolean bool2 = false;
    paramBundle = paramBundle.getBundle(AdMobAdapter.class.getName());
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("render_test_ad_label", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */