package com.google.android.gms.ads.internal.w.b;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.w.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a
public final class j
  implements Iterable
{
  public final List a = new ArrayList();
  
  public static boolean a(ad paramad)
  {
    paramad = b(paramad);
    if (paramad != null)
    {
      paramad.a.a();
      return true;
    }
    return false;
  }
  
  static h b(ad paramad)
  {
    Iterator localIterator = bt.A.D.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.b == paramad) {
        return localh;
      }
    }
    return null;
  }
  
  public final Iterator iterator()
  {
    return this.a.iterator();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */