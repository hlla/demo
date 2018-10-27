package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
public final class j
{
  public static final j a = new j();
  
  public static AdRequestParcel a(Context paramContext, bv parambv)
  {
    Object localObject1 = parambv.a;
    if (localObject1 != null) {}
    for (long l = ((Date)localObject1).getTime();; l = -1L)
    {
      int k = parambv.d;
      localObject1 = parambv.f;
      if (!((Set)localObject1).isEmpty()) {}
      for (List localList = Collections.unmodifiableList(new ArrayList((Collection)localObject1));; localList = null)
      {
        localObject1 = parambv.k;
        Object localObject2 = u.h.a;
        boolean bool1 = ((Set)localObject1).contains(com.google.android.gms.ads.internal.util.client.a.a(paramContext));
        int m = parambv.j;
        localObject2 = parambv.g;
        Bundle localBundle = parambv.i.getBundle(AdMobAdapter.class.getName());
        paramContext = paramContext.getApplicationContext();
        int i;
        int j;
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageName();
          localObject1 = u.h.a;
          localObject1 = Thread.currentThread().getStackTrace();
          i = 0;
          j = i + 1;
          if (j < localObject1.length)
          {
            String str1 = localObject1[i];
            String str2 = str1.getClassName();
            if ("loadAd".equalsIgnoreCase(str1.getMethodName())) {
              if ((com.google.android.gms.ads.internal.util.client.a.a.equalsIgnoreCase(str2)) || (com.google.android.gms.ads.internal.util.client.a.b.equalsIgnoreCase(str2)) || (com.google.android.gms.ads.internal.util.client.a.c.equalsIgnoreCase(str2)) || (com.google.android.gms.ads.internal.util.client.a.d.equalsIgnoreCase(str2)) || (com.google.android.gms.ads.internal.util.client.a.f.equalsIgnoreCase(str2)) || (com.google.android.gms.ads.internal.util.client.a.e.equalsIgnoreCase(str2)))
              {
                localObject1 = localObject1[j].getClassName();
                label251:
                if (paramContext != null)
                {
                  str1 = com.google.android.gms.ads.internal.util.client.a.a(paramContext, ".");
                  if (localObject1 != null)
                  {
                    paramContext = (Context)localObject1;
                    if (((String)localObject1).contains(str1)) {
                      paramContext = null;
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          boolean bool2 = parambv.e;
          i = parambv.l;
          return new AdRequestParcel(8, l, localBundle, k, localList, bool1, m, false, null, null, (Location)localObject2, null, parambv.i, parambv.c, Collections.unmodifiableList(new ArrayList(parambv.b)), null, paramContext, bool2, null, i, null);
          paramContext = null;
          continue;
          paramContext = null;
          continue;
          i = j;
          break;
          i = j;
          break;
          localObject1 = null;
          break label251;
          paramContext = null;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */