package com.google.android.finsky.e;

import com.google.android.finsky.bo.f;
import com.google.android.finsky.dn.e;
import com.google.android.play.utils.b.a;

public final class ad
{
  private long[] a;
  private final com.google.android.finsky.bo.c b;
  private long[] c;
  private com.google.android.play.b.d d = new com.google.android.play.b.d();
  private final e e;
  private com.google.android.play.b.a.c f;
  private com.google.android.play.b.a.c g;
  
  public ad(e parame, com.google.android.finsky.bo.c paramc)
  {
    this.e = parame;
    this.b = paramc;
  }
  
  public final com.google.android.play.b.d a(String paramString)
  {
    com.google.android.play.b.a.c localc = null;
    f localf = this.b.h(paramString);
    long[] arrayOfLong1 = localf.b();
    long[] arrayOfLong2 = localf.c();
    if (this.e != null) {
      if ((((Boolean)com.google.android.finsky.ag.d.l.b()).booleanValue()) || (localf.a(12625902L)))
      {
        localc = this.e.c();
        paramString = this.e.g(paramString);
      }
    }
    for (;;)
    {
      try
      {
        if ((arrayOfLong1 == this.a) && (arrayOfLong2 == this.c) && (paramString == this.f) && (localc == this.g))
        {
          paramString = this.d;
          return paramString;
        }
        this.a = arrayOfLong1;
        this.c = arrayOfLong2;
        this.f = paramString;
        this.g = localc;
        this.d = new com.google.android.play.b.d(this.a, this.c, this.g, this.f);
        paramString = this.d;
        return paramString;
      }
      finally {}
      paramString = null;
      continue;
      paramString = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */