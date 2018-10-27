package com.google.android.finsky.s.a;

import android.content.Context;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;
import com.google.android.finsky.utils.i;

public final class c
  implements com.google.android.finsky.s.b
{
  private final com.google.android.finsky.t.a a;
  private final Context b;
  private final com.google.android.finsky.bo.c c;
  
  c(com.google.android.finsky.t.a parama, Context paramContext, com.google.android.finsky.bo.c paramc)
  {
    this.a = parama;
    this.b = paramContext;
    this.c = paramc;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    int i = 0;
    if (com.google.android.finsky.by.a.a(parama.c.U()))
    {
      parama.j |= 0x1;
      parama.l |= 0x1;
      if (!((Boolean)com.google.android.finsky.ag.d.dQ.b()).booleanValue()) {
        parama.d |= 0x100;
      }
    }
    else
    {
      return;
    }
    Object localObject = parama.a;
    if (localObject == null) {}
    for (;;)
    {
      parama.e = 132;
      if (((Boolean)com.google.android.finsky.ag.d.dR.b()).booleanValue()) {
        parama.e |= 0x40;
      }
      parama.f = new k(parama.i.a("auto_update"), parama.c);
      if (!this.c.cY().a(12635214L)) {
        label151:
        parama.f.a(l.a);
      }
      for (;;)
      {
        parama.b = new com.google.android.finsky.installqueue.d();
        parama.h = 2;
        parama.f.b(2);
        parama.g = 64536;
        localObject = parama.f;
        if (parama.k != null) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject).a(bool);
          int j;
          if ((!com.google.android.finsky.ba.a.c(this.b)) || (!com.google.android.finsky.fg.a.a(this.b).c()))
          {
            if (!this.c.cY().a(12617485L)) {
              break;
            }
            localObject = parama.k;
            if ((localObject == null) || ((((com.google.android.finsky.dh.b)localObject).m) && (!((com.google.android.finsky.dh.b)localObject).n)) || (!this.a.b())) {
              break;
            }
            localObject = parama.c.U();
            if (localObject != null)
            {
              localObject = ((o)localObject).y;
              j = localObject.length;
            }
          }
          for (;;)
          {
            if (i >= j)
            {
              localObject = parama.a;
              if (localObject == null) {
                break;
              }
              long l1 = ((com.google.android.finsky.autoupdatev2.d)localObject).a.g;
              long l2 = i.a() - l1;
              if ((l1 < 0L) || (l2 < 0L) || (l2 >= ((Long)com.google.android.finsky.ag.d.dS.b()).longValue())) {
                break;
              }
              parama.e |= 0x110;
              parama.b.a(2);
              return;
            }
            if (localObject[i] == 300) {
              break;
            }
            i += 1;
          }
        }
        if (!android.support.v4.os.a.a()) {
          break label151;
        }
        parama.f.a(l.b);
      }
      if (((com.google.android.finsky.autoupdatev2.d)localObject).a.b == 2) {
        parama.d |= 0x4;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */