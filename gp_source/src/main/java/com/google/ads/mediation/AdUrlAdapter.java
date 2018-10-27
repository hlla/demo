package com.google.ads.mediation;

import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.ads.mediation.d;
import com.google.android.gms.ads.mediation.g;
import com.google.android.gms.ads.mediation.i;

@Keep
public final class AdUrlAdapter
  extends a
  implements d, g, i
{
  protected final Bundle a(Bundle paramBundle1, Bundle paramBundle2)
  {
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    localBundle.putBundle("sdk_less_server_data", paramBundle2);
    localBundle.putBoolean("_noRefresh", true);
    return localBundle;
  }
  
  public final String a(Bundle paramBundle)
  {
    return "adurl";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/AdUrlAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */