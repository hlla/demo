package com.google.android.gms.ads.internal.w;

import android.content.Context;
import com.google.android.gms.ads.internal.w.a.f;
import java.util.Arrays;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class v
  extends m
{
  public final l a(Context paramContext, ad paramad, int paramInt, boolean paramBoolean, com.google.android.gms.ads.internal.g.l paraml, ac paramac)
  {
    if (a(paramContext))
    {
      ae localae = new ae(paramContext, paramad.getVersionInfo(), paramad.getRequestId(), paraml, paramad.getAdWebViewCreatedLabel());
      if (paramInt == 2)
      {
        List localList = Arrays.asList(paramac.e.split(","));
        localList.contains("3");
        if (localList.contains("1")) {
          return new f(paramContext, localae, paramad, paramInt, paramBoolean, a(paramad), paramac);
        }
      }
      return new a(paramContext, paramBoolean, a(paramad), new ae(paramContext, paramad.getVersionInfo(), paramad.getRequestId(), paraml, paramad.getAdWebViewCreatedLabel()));
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */