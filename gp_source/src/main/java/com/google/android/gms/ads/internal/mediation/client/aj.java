package com.google.android.gms.ads.internal.mediation.client;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.h;
import com.google.android.gms.ads.mediation.q;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class aj
  extends u
{
  private final q a;
  
  public aj(q paramq)
  {
    this.a = paramq;
  }
  
  public final String a()
  {
    return this.a.e;
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    com.google.android.gms.dynamic.e.a(parama);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2, com.google.android.gms.ads.internal.j.a parama3)
  {
    com.google.android.gms.dynamic.e.a(parama2);
    com.google.android.gms.dynamic.e.a(parama3);
    this.a.a((View)com.google.android.gms.dynamic.e.a(parama1));
  }
  
  public final List b()
  {
    Object localObject = this.a.g;
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.google.android.gms.ads.formats.e locale = (com.google.android.gms.ads.formats.e)((Iterator)localObject).next();
        localArrayList.add(new h(locale.a(), locale.b(), locale.c()));
      }
      return localArrayList;
    }
    return localArrayList;
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a parama)
  {
    com.google.android.gms.dynamic.e.a(parama);
  }
  
  public final String c()
  {
    return this.a.b;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e d()
  {
    com.google.android.gms.ads.formats.e locale = this.a.f;
    if (locale != null) {
      return new h(locale.a(), locale.b(), locale.c());
    }
    return null;
  }
  
  public final String e()
  {
    return this.a.c;
  }
  
  public final String f()
  {
    return this.a.a;
  }
  
  public final double g()
  {
    Double localDouble = this.a.l;
    if (localDouble != null) {
      return localDouble.doubleValue();
    }
    return -1.0D;
  }
  
  public final String h()
  {
    return this.a.m;
  }
  
  public final String i()
  {
    return this.a.k;
  }
  
  public final bo j()
  {
    n localn = this.a.n;
    if (localn != null) {
      return localn.a();
    }
    return null;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a k()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a l()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a m()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a n()
  {
    Object localObject = this.a.h;
    if (localObject != null) {
      return com.google.android.gms.dynamic.e.a(localObject);
    }
    return null;
  }
  
  public final Bundle o()
  {
    return this.a.d;
  }
  
  public final boolean p()
  {
    return this.a.j;
  }
  
  public final boolean q()
  {
    return this.a.i;
  }
  
  public final void r() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */