package com.google.android.gms.ads.internal.w.b;

import com.google.android.gms.ads.internal.w.ac;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.ads.internal.w.b.a.b;
import com.google.android.gms.ads.internal.w.b.a.e;
import java.util.Arrays;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  implements s
{
  public final k a(ad paramad, int paramInt, ac paramac)
  {
    if (paramInt > 0)
    {
      List localList = Arrays.asList(paramac.e.split(","));
      localList.contains("3");
      if (localList.contains("1"))
      {
        int i = com.google.android.gms.ads.internal.w.a.a.d;
        if (i >= paramac.g) {}
        do
        {
          if (i < paramac.b) {
            return new com.google.android.gms.ads.internal.w.b.a.a(paramad, paramac);
          }
          return new u(paramad);
          if (paramInt == 1) {
            return new e(paramad);
          }
        } while (paramInt != 2);
        return new b(paramad);
      }
    }
    return new t(paramad);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */