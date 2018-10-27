package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.a.v;

@com.google.android.gms.ads.internal.q.a.a
public final class c
{
  public static void a(Context paramContext)
  {
    if ((com.google.android.gms.ads.internal.util.client.e.a(paramContext)) && (!com.google.android.gms.ads.internal.util.client.e.a()))
    {
      paramContext = (v)new d(paramContext).c();
      e.d("Updating ad debug logging enablement.");
      com.google.android.gms.ads.internal.util.a.e.a(paramContext, "AdDebugLogUpdater.updateEnablement");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */