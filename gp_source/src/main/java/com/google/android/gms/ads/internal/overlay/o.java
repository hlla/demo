package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;

@a
public final class o
  extends AdOverlay
{
  public o(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void a(Bundle paramBundle)
  {
    e.a("AdOverlayParcel is null or does not contain valid overlay type.");
    this.d = 3;
    this.a.finish();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */