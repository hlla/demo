package com.google.android.finsky.cm;

import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.e.af;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;
import com.google.android.finsky.s.b;
import com.google.android.finsky.utils.i;

public final class a
  implements b
{
  private final com.google.android.finsky.t.a a;
  private final c b;
  
  public a(c paramc, com.google.android.finsky.t.a parama)
  {
    this.b = paramc;
    this.a = parama;
  }
  
  public static boolean a()
  {
    if (((Boolean)com.google.android.finsky.ag.d.eL.b()).booleanValue()) {
      return !android.support.v4.os.a.b();
    }
    return false;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    if ("com.google.android.instantapps.supervisor".equals(parama.c.cC()))
    {
      parama.j |= 0x1;
      parama.l |= 0x1;
      if (!a()) {
        parama.d |= 0x100;
      }
    }
    else
    {
      return;
    }
    Object localObject = parama.a;
    if (localObject == null) {}
    label233:
    while (((com.google.android.finsky.autoupdatev2.d)localObject).a.b != 2)
    {
      parama.f = new k(parama.i.a("auto_update"), parama.c);
      parama.b = new com.google.android.finsky.installqueue.d();
      if (this.b.cY().a(12630207L)) {
        parama.f.a(l.a);
      }
      for (;;)
      {
        parama.e = 68;
        if (((Boolean)com.google.android.finsky.ag.d.Z.b()).booleanValue()) {
          parama.e |= 0x80;
        }
        if ((this.b.cY().a(12633462L)) && (this.a.b()))
        {
          localObject = parama.a;
          if (localObject != null) {
            break label233;
          }
        }
        for (;;)
        {
          localObject = parama.f;
          if (parama.k != null) {}
          for (boolean bool = true;; bool = false)
          {
            ((k)localObject).a(bool);
            return;
          }
          long l1 = ((com.google.android.finsky.autoupdatev2.d)localObject).a.g;
          long l2 = i.a() - l1;
          if ((l1 >= 0L) && (l2 >= 0L) && (l2 < ((Long)com.google.android.finsky.ag.d.h.b()).longValue()))
          {
            parama.e |= 0x110;
            parama.b.a(2);
          }
        }
        parama.f.a(l.b);
      }
    }
    parama.d |= 0x4;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */