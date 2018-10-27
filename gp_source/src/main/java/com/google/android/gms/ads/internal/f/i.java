package com.google.android.gms.ads.internal.f;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@a
public final class i
{
  public final Collection a = new ArrayList();
  public final Collection b = new ArrayList();
  public final Collection c = new ArrayList();
  
  public final List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((c)localIterator.next()).a();
      if (str != null) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */