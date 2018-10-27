package com.google.android.gms.ads.internal.js.function;

import com.google.android.gms.ads.internal.js.y;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.c.e;

@a
public final class p
{
  private af a;
  private y b;
  
  public p(y paramy)
  {
    this.b = paramy;
  }
  
  private final void a()
  {
    if (this.a == null)
    {
      this.a = af.b();
      af localaf = this.a;
      this.b.a().a(new q(localaf), new r(localaf));
    }
  }
  
  public final u a(String paramString, d paramd, c paramc)
  {
    a();
    return new u(this.a, paramString, paramd, paramc);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    a();
    this.a = ((af)h.a(this.a, new s(paramString, paramu), aa.a));
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    this.a = ((af)h.a(this.a, new t(paramString, paramu), aa.a));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/function/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */