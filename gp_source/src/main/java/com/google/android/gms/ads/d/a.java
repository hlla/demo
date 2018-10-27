package com.google.android.gms.ads.d;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.common.internal.z;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public static void a(Context paramContext, b paramb)
  {
    z.a(paramb, "PlayStoreInAppPurchase must not be null.");
    try
    {
      c.a(paramContext).a(paramb.a);
      return;
    }
    catch (RemoteException paramContext)
    {
      e.c("Failed to report In-App Purchases", paramContext);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */