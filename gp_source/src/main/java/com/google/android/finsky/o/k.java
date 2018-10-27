package com.google.android.finsky.o;

import com.google.android.finsky.em.g;
import com.google.wireless.android.finsky.dfe.d.a.c.a.c;

final class k
  implements a
{
  private final c a = new c();
  private final g b;
  
  k(g paramg)
  {
    this.b = paramg;
  }
  
  public final int a()
  {
    return 2;
  }
  
  public final void a(com.google.wireless.android.finsky.dfe.d.a.a.a parama)
  {
    parama.c = this.a;
  }
  
  public final boolean b()
  {
    long l1 = g.g();
    c localc = this.a;
    long l2 = g.b(l1);
    localc.a |= 0x2;
    localc.d = l2;
    localc = this.a;
    l2 = g.b(g.d());
    localc.a |= 0x1;
    localc.c = l2;
    localc = this.a;
    l1 = g.b(this.b.a(l1));
    localc.a |= 0x4;
    localc.b = l1;
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */