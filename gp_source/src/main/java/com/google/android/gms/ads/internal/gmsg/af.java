package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.m.d;
import com.google.android.gms.ads.internal.m.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.v;
import com.google.android.gms.common.util.c;
import java.util.Collections;
import java.util.Map;

@a
public final class af
  implements u
{
  private static final Map a;
  private final v b;
  private final d c;
  private final n d;
  
  static
  {
    int i = 0;
    Map localMap = c.a(7);
    while (i < 7)
    {
      localMap.put(new String[] { "resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload" }[i], new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }[i]);
      i += 1;
    }
    a = Collections.unmodifiableMap(localMap);
  }
  
  public af(v paramv, d paramd, n paramn)
  {
    this.b = paramv;
    this.c = paramd;
    this.d = paramn;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */