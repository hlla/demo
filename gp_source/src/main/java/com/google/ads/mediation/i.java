package com.google.ads.mediation;

import com.google.android.gms.ads.b;
import com.google.android.gms.ads.formats.k;
import com.google.android.gms.ads.formats.l;
import com.google.android.gms.ads.formats.m;
import com.google.android.gms.ads.formats.n;
import com.google.android.gms.ads.formats.o;
import com.google.android.gms.ads.formats.p;
import com.google.android.gms.ads.formats.r;
import com.google.android.gms.ads.formats.s;

final class i
  extends b
  implements k, m, o, p, s
{
  private final a a;
  private final com.google.android.gms.ads.mediation.j b;
  
  public i(a parama, com.google.android.gms.ads.mediation.j paramj)
  {
    this.a = parama;
    this.b = paramj;
  }
  
  public final void a() {}
  
  public final void a(int paramInt)
  {
    this.b.c(paramInt);
  }
  
  public final void a(com.google.android.gms.ads.formats.j paramj)
  {
    this.b.a(this.a, new d(paramj));
  }
  
  public final void a(l paraml)
  {
    this.b.a(this.a, new e(paraml));
  }
  
  public final void a(n paramn)
  {
    this.b.a(paramn);
  }
  
  public final void a(n paramn, String paramString)
  {
    this.b.a(paramn, paramString);
  }
  
  public final void a(r paramr)
  {
    this.b.a(this.a, new f(paramr));
  }
  
  public final void b()
  {
    this.b.k();
  }
  
  public final void c()
  {
    this.b.l();
  }
  
  public final void d()
  {
    this.b.m();
  }
  
  public final void e()
  {
    this.b.n();
  }
  
  public final void f()
  {
    this.b.o();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */