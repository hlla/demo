package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.android.volley.a.p;
import com.android.volley.m;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.httpcache.i;
import java.util.regex.Pattern;

@com.google.android.gms.ads.internal.q.a.a
public final class ar
  extends com.android.volley.a.e
{
  private final Context a;
  
  ar(Context paramContext, p paramp)
  {
    super(paramp);
    this.a = paramContext;
  }
  
  public final m a(com.android.volley.n paramn)
  {
    if ((paramn.i) && (paramn.e == 0))
    {
      localObject = paramn.ac_();
      if (Pattern.matches((String)com.google.android.gms.ads.internal.f.n.aC.a(), (CharSequence)localObject))
      {
        localObject = u.h.a;
        if (com.google.android.gms.ads.internal.util.client.a.c(this.a, 13400000))
        {
          localObject = new i(this.a).a(paramn);
          if (localObject != null)
          {
            paramn = String.valueOf(paramn.ac_());
            if (paramn.length() == 0) {}
            for (paramn = new String("Got gmscore asset response: ");; paramn = "Got gmscore asset response: ".concat(paramn))
            {
              e.a(paramn);
              return (m)localObject;
            }
          }
          localObject = String.valueOf(paramn.ac_());
          if (((String)localObject).length() != 0) {
            break label150;
          }
        }
      }
    }
    label150:
    for (Object localObject = new String("Failed to get gmscore asset response: ");; localObject = "Failed to get gmscore asset response: ".concat((String)localObject))
    {
      e.a((String)localObject);
      return super.a(paramn);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */