package com.google.android.gms.ads.internal.u;

import android.content.Context;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.l;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements c
{
  public final v a(Context paramContext)
  {
    af localaf = new af();
    com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
    if (com.google.android.gms.ads.internal.util.client.a.c(paramContext)) {
      l.a(new b(paramContext, localaf));
    }
    return localaf;
  }
  
  public final v a(String paramString)
  {
    return h.a(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/u/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */