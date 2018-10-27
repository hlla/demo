package com.google.android.gms.ads.internal.request.a;

import android.content.Context;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.js.function.b;
import com.google.android.gms.ads.internal.js.function.f;
import com.google.android.gms.ads.internal.js.function.i;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@com.google.android.gms.ads.internal.q.a.a
public final class v
  implements g
{
  private com.google.android.gms.ads.internal.js.function.a a;
  private com.google.android.gms.ads.internal.js.function.a b;
  
  public v(Context paramContext)
  {
    this.a = bt.A.s.a(paramContext, VersionInfoParcel.a()).a("google.afma.request.getAdDictionary", f.b, f.b);
    this.b = bt.A.s.a(paramContext, VersionInfoParcel.a()).a("google.afma.sdkConstants.getSdkConstants", f.b, f.b);
  }
  
  public final com.google.android.gms.ads.internal.js.function.a a()
  {
    return this.a;
  }
  
  public final com.google.android.gms.ads.internal.js.function.a b()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */