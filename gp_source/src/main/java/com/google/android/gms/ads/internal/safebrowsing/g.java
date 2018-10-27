package com.google.android.gms.ads.internal.safebrowsing;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@com.google.android.gms.ads.internal.q.a.a
public final class g
  implements l
{
  private m a;
  
  public g(m paramm)
  {
    this.a = paramm;
  }
  
  public final k a(Context paramContext, VersionInfoParcel paramVersionInfoParcel, AdResponseParcel paramAdResponseParcel)
  {
    SafeBrowsingConfigParcel localSafeBrowsingConfigParcel = paramAdResponseParcel.R;
    if (localSafeBrowsingConfigParcel != null) {
      return new a(paramContext, paramVersionInfoParcel, localSafeBrowsingConfigParcel, paramAdResponseParcel.e, this.a);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/safebrowsing/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */