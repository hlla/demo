package com.google.android.finsky.s.a;

import com.google.android.finsky.ag.q;
import com.google.android.finsky.ag.r;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;

public final class b
  implements com.google.android.finsky.s.b
{
  private final com.google.android.finsky.t.a a;
  private final c b;
  
  public b(c paramc, com.google.android.finsky.t.a parama)
  {
    this.b = paramc;
    this.a = parama;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    parama.e |= 0x15F;
    if (!this.b.cY().a(12616260L)) {
      parama.e |= 0x20;
    }
    if (((Boolean)com.google.android.finsky.ag.d.Z.b()).booleanValue()) {
      parama.e |= 0x80;
    }
    if (this.b.cY().a(12643667L)) {
      parama.e |= 0x200;
    }
    if (this.b.cY().a(12605750L)) {
      parama.e |= 0x400;
    }
    if (this.a.b()) {
      parama.b.a(2);
    }
    if (((Boolean)r.i.a()).booleanValue()) {
      parama.f.a(l.c);
    }
    for (;;)
    {
      parama.f.a("auto_update");
      parama.h = 3;
      parama.f.b(3);
      parama.g = 0;
      parama.f.a(true);
      return;
      parama.f.a(l.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */