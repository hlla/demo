package com.google.android.finsky.s.a;

import com.google.android.finsky.ag.d;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.l;
import com.google.android.finsky.utils.FinskyLog;
import java.util.List;

public final class e
  implements com.google.android.finsky.s.b
{
  private List a;
  private final com.google.android.finsky.bo.c b;
  private Integer c;
  private final com.google.android.finsky.tos.c d;
  
  public e(com.google.android.finsky.bo.c paramc, com.google.android.finsky.tos.c paramc1)
  {
    this.b = paramc;
    this.d = paramc1;
  }
  
  public final void a(com.google.android.finsky.s.a parama)
  {
    if (this.a != null) {}
    for (;;)
    {
      int j = this.a.size();
      int i = 0;
      f localf;
      for (;;)
      {
        if (i >= j) {
          break label381;
        }
        localf = (f)this.a.get(i);
        if (localf.d.equals(parama.c.U().t)) {
          break;
        }
        i += 1;
      }
      for (;;)
      {
        if (localf != null)
        {
          parama.j |= 0x1;
          if ((localf.d.equals(parama.c.U().t)) && ((localf.a & 0x4) != 0))
          {
            j = parama.k.f;
            if (j >= 0) {
              break label143;
            }
            FinskyLog.c("Server thinks we have an asset that we don't have : %s", new Object[] { localf.d });
          }
        }
        label143:
        do
        {
          do
          {
            return;
            int k = localf.b;
            i = j;
            if (k > 0) {
              i = j % k;
            }
          } while (i >= localf.c);
          if (!"com.android.chrome".equals(parama.c.U().t)) {
            break;
          }
          if (this.c == null) {
            this.c = Integer.valueOf(this.d.b());
          }
        } while (this.c.intValue() < ((Integer)d.hu.b()).intValue());
        parama.e &= 0xFEE3;
        if ((localf.a & 0x2) != 0) {
          parama.e &= 0xFFFFFFFD;
        }
        if (this.b.cY().a(12643667L)) {
          parama.e &= 0xFDFF;
        }
        if (this.b.cY().a(12605750L)) {
          parama.e &= 0xFBFF;
        }
        if (!android.support.v4.os.a.a())
        {
          if ((localf.a & 0x1) == 0) {
            break label367;
          }
          parama.f.a(l.a);
        }
        for (;;)
        {
          parama.f.a("rapid_auto_update");
          return;
          label367:
          parama.f.a(l.c);
        }
        label381:
        localf = null;
      }
      this.a = f.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */