package com.google.android.gms.ads.internal.mediation.client;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.h;
import com.google.android.gms.ads.mediation.k;
import com.google.android.gms.ads.mediation.l;
import com.google.android.gms.ads.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class aa
  extends o
{
  private final l a;
  
  public aa(l paraml)
  {
    this.a = paraml;
  }
  
  public final String a()
  {
    return this.a.g;
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
    return this.a.e;
  }
  
  public final void c(com.google.android.gms.ads.internal.j.a parama)
  {
    com.google.android.gms.dynamic.e.a(parama);
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e d()
  {
    com.google.android.gms.ads.formats.e locale = this.a.h;
    if (locale != null) {
      return new h(locale.a(), locale.b(), locale.c());
    }
    return null;
  }
  
  public final String e()
  {
    return this.a.f;
  }
  
  public final double f()
  {
    return this.a.k;
  }
  
  public final String g()
  {
    return this.a.l;
  }
  
  public final String h()
  {
    return this.a.j;
  }
  
  public final void i() {}
  
  public final boolean j()
  {
    return this.a.c;
  }
  
  public final boolean k()
  {
    return this.a.b;
  }
  
  public final Bundle l()
  {
    return this.a.a;
  }
  
  public final bo m()
  {
    n localn = this.a.d;
    if (localn != null) {
      return localn.a();
    }
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a n()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a o()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a p()
  {
    return null;
  }
  
  public final com.google.android.gms.ads.internal.j.a q()
  {
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */