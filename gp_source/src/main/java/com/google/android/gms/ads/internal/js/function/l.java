package com.google.android.gms.ads.internal.js.function;

import com.google.android.gms.ads.internal.js.al;
import com.google.android.gms.ads.internal.js.y;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.c.e;

@com.google.android.gms.ads.internal.q.a.a
public final class l
  implements a
{
  public final String a;
  public final d b;
  public final c c;
  private final y d;
  
  l(y paramy, String paramString, d paramd, c paramc)
  {
    this.d = paramy;
    this.a = paramString;
    this.b = paramd;
    this.c = paramc;
  }
  
  public final v a(Object paramObject)
  {
    return b(paramObject);
  }
  
  public final v b(Object paramObject)
  {
    af localaf = af.b();
    al localal = this.d.a();
    localal.a(new m(this, localal, paramObject, localaf), new n(localaf, localal));
    return localaf;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/function/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */