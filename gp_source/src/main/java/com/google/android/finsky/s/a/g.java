package com.google.android.finsky.s.a;

import com.google.android.finsky.av.m;
import com.google.android.finsky.av.n;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;
import com.google.android.finsky.utils.j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class g
  implements com.google.android.finsky.s.b
{
  private final com.google.android.finsky.accounts.c a;
  private final m b;
  private final com.google.android.finsky.bo.c c;
  private final b.a d;
  
  public g(com.google.android.finsky.bo.c paramc, com.google.android.finsky.accounts.c paramc1, b.a parama, m paramm)
  {
    this.c = paramc;
    this.a = paramc1;
    this.d = parama;
    this.b = paramm;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    Object localObject1 = parama.k;
    String str;
    if (localObject1 != null)
    {
      str = ((com.google.android.finsky.dh.b)localObject1).o;
      bool = ((com.google.android.finsky.dh.b)localObject1).m;
      if (com.google.android.finsky.ey.a.a(this.a, this.c, null)) {
        if (!"com.google.android.gms".equals(str)) {
          break label307;
        }
      }
    }
    for (boolean bool = com.google.android.finsky.ey.a.b((com.google.android.finsky.ba.g)this.d.a(), this.c);; bool = com.google.android.finsky.ey.a.a((com.google.android.finsky.ba.g)this.d.a(), this.c))
    {
      if ((bool) && (!parama.k.i))
      {
        parama.l |= 0x1;
        localObject1 = parama.c;
        Object localObject2 = new HashSet(Arrays.asList(j.a((String)com.google.android.finsky.ag.d.jv.b())));
        localObject1 = this.b.a((Document)localObject1, (Set)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (n)((Iterator)localObject1).next();
        } while ((((n)localObject2).c) || (((n)localObject2).b));
      }
      label307:
      do
      {
        do
        {
          return;
          localObject1 = this.c.cY();
          if (((f)localObject1).a(12643667L)) {
            parama.e &= 0xFDFF;
          }
          parama.b.c(0);
          if (!"com.google.android.gms".equals(str)) {
            break;
          }
          if (com.google.android.finsky.ey.a.a((f)localObject1)) {
            parama.e |= 0x8;
          }
          if (com.google.android.finsky.ey.a.b((f)localObject1)) {
            parama.b.a(2);
          }
        } while (!com.google.android.finsky.ey.a.c((f)localObject1));
        parama.b.a(1);
        return;
        parama.f.a(l.b);
        parama.b.a(2);
        return;
      } while (!bool);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */