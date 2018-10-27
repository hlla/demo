package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.js.j;
import com.google.android.gms.ads.internal.request.a.c;
import com.google.android.gms.ads.internal.request.a.g;
import com.google.android.gms.ads.internal.request.a.q;
import com.google.android.gms.ads.internal.request.a.u;
import com.google.android.gms.ads.internal.request.a.v;

@com.google.android.gms.ads.internal.q.a.a
public final class r
  extends o
{
  private final Context c;
  
  public r(Context paramContext, com.google.android.gms.ads.internal.util.c.a parama, m paramm)
  {
    super(parama, paramm);
    this.c = paramContext;
  }
  
  public final void d() {}
  
  public final z e()
  {
    Context localContext = this.c;
    bt.A.q.a(localContext);
    v localv = new v(localContext);
    return c.a(localContext, new com.google.android.gms.ads.internal.request.a.b(new com.google.android.gms.ads.internal.cache.m(), new com.google.android.gms.ads.internal.t.b(), new com.google.android.gms.ads.internal.f.a(), new q(localContext, localv.b()), new com.google.android.gms.ads.internal.l.b(), new u(), new com.google.android.gms.ads.internal.o.a(), new com.google.android.gms.ads.internal.u.a(), localv));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */