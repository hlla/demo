package com.google.android.finsky.cq;

import android.content.Context;
import com.google.android.finsky.cq.c.d;
import com.google.android.finsky.cq.c.g;
import com.google.android.finsky.cq.c.k;
import com.google.android.finsky.cq.d.p;
import e.a.a;

public final class r
{
  private final d a;
  private final p b;
  private final a c;
  private final k d;
  private final k e;
  
  r(p paramp, a parama, k paramk1, k paramk2, d paramd)
  {
    this.b = paramp;
    this.c = parama;
    this.d = paramk1;
    this.e = paramk2;
    this.a = paramd;
  }
  
  public final c a(Context paramContext, t paramt)
  {
    return new c(paramContext, paramt, this.b, (g)this.c.a(), this.d.a(), this.e.a());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */