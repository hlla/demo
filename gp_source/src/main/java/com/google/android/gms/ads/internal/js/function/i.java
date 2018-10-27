package com.google.android.gms.ads.internal.js.function;

import android.content.Context;
import com.google.android.gms.ads.internal.js.y;
import com.google.android.gms.ads.internal.util.at;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@com.google.android.gms.ads.internal.q.a.a
public final class i
{
  private static final at b = new k();
  private static final at c = new j();
  public final y a;
  
  public i(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    this.a = new y(paramContext, paramVersionInfoParcel, paramString, c, b);
  }
  
  public final a a(String paramString, d paramd, c paramc)
  {
    return new l(this.a, paramString, paramd, paramc);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/function/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */