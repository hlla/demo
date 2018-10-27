package com.google.android.finsky.s.a;

import com.google.android.finsky.bo.f;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;
import com.google.android.finsky.s.b;

public final class d
  implements b
{
  private final com.google.android.finsky.f.c a;
  private final com.google.android.finsky.bo.c b;
  
  public d(com.google.android.finsky.f.c paramc, com.google.android.finsky.bo.c paramc1)
  {
    this.a = paramc;
    this.b = paramc1;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    if ((this.b.cY().a(12637130L)) && (this.b.cY().a(12643849L)) && (this.a.b(parama.k, parama.c)))
    {
      parama.l |= 0x1;
      parama.e &= 0xFDF0;
      if (android.support.v4.os.a.a()) {
        break label118;
      }
      parama.f.a(l.a);
    }
    for (;;)
    {
      parama.f.a(true);
      parama.b = new com.google.android.finsky.installqueue.d();
      return;
      label118:
      parama.f.a(l.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */