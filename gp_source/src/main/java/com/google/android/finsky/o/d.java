package com.google.android.finsky.o;

import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public final com.google.wireless.android.finsky.dfe.d.a.a.a a = new com.google.wireless.android.finsky.dfe.d.a.a.a();
  public final List b = new ArrayList();
  
  d(com.google.android.finsky.em.g paramg, com.google.android.finsky.t.a parama, com.google.android.finsky.ad.a parama1, c paramc)
  {
    a(new g(parama));
    a(new k(paramg));
    if (paramc.cY().a(12648203L)) {
      a(new j(parama1));
    }
  }
  
  private final void a(a parama)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((a)localIterator.next()).a() == parama.a())
      {
        FinskyLog.e("Already have a data provider with type %d", new Object[] { Integer.valueOf(parama.a()) });
        return;
      }
    }
    this.b.add(parama);
  }
  
  public final com.google.wireless.android.finsky.dfe.d.a.a.a a()
  {
    synchronized (this.a)
    {
      com.google.wireless.android.finsky.dfe.d.a.a.a locala2 = this.a;
      return locala2;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */