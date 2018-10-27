package com.google.android.gms.ads.internal.mediation.client;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.h;
import com.google.android.gms.ads.mediation.k;
import com.google.android.gms.ads.mediation.m;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class ab
  extends r
{
  private final m a;
  
  public ab(m paramm)
  {
    this.a = paramm;
  }
  
  public final String a()
  {
    return this.a.h;
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    com.google.android.gms.dynamic.e.a(parama);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2, com.google.android.gms.ads.internal.j.a parama3)
  {
    com.google.android.gms.dynamic.e.a(parama2);
    com.google.android.gms.dynamic.e.a(parama3);
    com.google.android.gms.dynamic.e.a(parama1);
  }
  
  public final List b()
  {
    Object localObject = this.a.i;
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.google.android.gms.ads.formats.e locale = (com.google.android.gms.ads.formats.e)((Iterator)localObject).next();
        localArrayList.add(new h(locale.a(), locale.b(), locale.c()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a parama)
  {
    this.a.a((View)com.google.android.gms.dynamic.e.a(parama));
  }
  
  public final String c()
  {
    return this.a.f;
  }
  
  public final void c(com.google.android.gms.ads.internal.j.a parama)
  {
    com.google.android.gms.dynamic.e.a(parama);
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e d()
  {
    com.google.android.gms.ads.formats.e locale = this.a.j;
    if (locale != null) {
      return new h(locale.a(), locale.b(), locale.c());
    }
    return null;
  }
  
  public final String e()
  {
    return this.a.g;
  }
  
  public final String f()
  {
    return this.a.e;
  }
  
  public final void g() {}
  
  public final boolean h()
  {
    return this.a.c;
  }
  
  public final boolean i()
  {
    return this.a.b;
  }
  
  public final Bundle j()
  {
    return this.a.a;
  }
  
  public final com.google.android.gms.ads.internal.j.a k()
  {
    return null;
  }
  
  public final bo l()
  {
    n localn = this.a.d;
    if (localn != null) {
      return localn.a();
    }
    return null;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a m()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a n()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a o()
  {
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */