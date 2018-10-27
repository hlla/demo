package com.google.android.gms.ads.internal.mediation.client;

import com.google.ads.mediation.j;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class ah
{
  public static int a(com.google.ads.a parama)
  {
    switch (ai.a[parama.ordinal()])
    {
    default: 
      return 0;
    case 4: 
      return 3;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  public static j a(AdRequestParcel paramAdRequestParcel)
  {
    List localList = paramAdRequestParcel.j;
    if (localList != null) {
      new HashSet(localList);
    }
    new Date(paramAdRequestParcel.b);
    int i = paramAdRequestParcel.g;
    paramAdRequestParcel = paramAdRequestParcel.k;
    return new j();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */