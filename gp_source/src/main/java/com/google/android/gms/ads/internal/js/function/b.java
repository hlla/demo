package com.google.android.gms.ads.internal.js.function;

import android.content.Context;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@a
public final class b
{
  private final Object a = new Object();
  private i b;
  
  public final i a(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (this.a)
    {
      if (this.b != null)
      {
        paramContext = this.b;
        return paramContext;
      }
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
      this.b = new i(paramContext, paramVersionInfoParcel, (String)n.bE.a());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/function/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */