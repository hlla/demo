package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.common.util.h;

@com.google.android.gms.ads.internal.q.a.a
public final class i
{
  public static void a(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((paramAdOverlayInfoParcel.n == 4) && (paramAdOverlayInfoParcel.d == null))
    {
      localObject = paramAdOverlayInfoParcel.a;
      if (localObject != null) {
        ((com.google.android.gms.ads.internal.client.a)localObject).e();
      }
      localObject = bt.A.a;
      a.a(paramContext, paramAdOverlayInfoParcel.b, paramAdOverlayInfoParcel.l);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    ((Intent)localObject).putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramAdOverlayInfoParcel.p.d);
    ((Intent)localObject).putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.a((Intent)localObject, paramAdOverlayInfoParcel);
    if (!h.c()) {
      ((Intent)localObject).addFlags(524288);
    }
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramAdOverlayInfoParcel = bt.A.e;
    n.a(paramContext, (Intent)localObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */