package com.google.android.finsky.dn.a.a;

import android.content.Context;
import com.google.android.finsky.dn.a.b;
import com.google.android.finsky.dn.a.q;

public final class e
{
  public final Context a;
  public final com.google.android.finsky.dn.a.i b;
  public final com.google.android.gms.phenotype.core.common.c c;
  public final p d;
  private final com.google.android.finsky.i.c e;
  private final b f;
  private final com.google.android.finsky.e.i g;
  private final g h;
  private final com.google.android.finsky.bo.c i;
  private final q j;
  private final int k;
  
  public e(com.google.android.finsky.dn.a.i parami, g paramg, b paramb, Context paramContext, int paramInt, com.google.android.gms.phenotype.core.common.c paramc, p paramp, com.google.android.finsky.i.c paramc1, q paramq, com.google.android.finsky.e.i parami1, com.google.android.finsky.bo.c paramc2)
  {
    this.b = parami;
    this.h = paramg;
    this.a = paramContext;
    this.k = paramInt;
    this.c = paramc;
    this.d = paramp;
    this.f = paramb;
    this.e = paramc1;
    this.j = paramq;
    this.g = parami1;
    this.i = paramc2;
  }
  
  static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final k a(String paramString)
  {
    return new k(this.d, this.c, this.h, this.a, "com.google.android.finsky.regular", com.google.android.finsky.dn.a.k.a, this.k, c(paramString), this.f.a(), this.b, this.g, this.i);
  }
  
  public final n b(String paramString)
  {
    return new n(this.d, this.c, this.h, this.a, "com.google.android.finsky.stable", com.google.android.finsky.dn.a.k.a, this.k, c(paramString), this.f.a(), this.b, this.e, this.j, this.g, this.i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */