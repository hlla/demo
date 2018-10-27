package com.google.android.finsky.e;

import com.google.wireless.android.a.b.a.a.bg;
import com.google.wireless.android.a.b.a.a.bh;
import com.google.wireless.android.a.b.a.a.bl;
import com.google.wireless.android.a.b.a.a.bm;
import com.google.wireless.android.a.b.a.a.bo;
import com.google.wireless.android.a.b.a.a.br;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.a.b.a.a.cc;

public final class j
{
  public static final j d = new j();
  public final s a = new s(bg.class, 10, o.a);
  public final s b = new s(bm.class, 10, l.a);
  public final s c = new s(cc.class, 10, r.a);
  private final s e = new s(bh.class, 10, m.a);
  private final s f = new s(bl.class, 10, n.a);
  private final s g = new s(bo.class, 40, k.a);
  private final s h = new s(br.class, 10, p.a);
  private final s i = new s(bt.class, 50, q.a);
  
  private final void a(bt parambt)
  {
    bt[] arrayOfbt = parambt.b;
    int k = arrayOfbt.length;
    int j = 0;
    while (j < k)
    {
      a(arrayOfbt[j]);
      j += 1;
    }
    parambt.e();
    this.i.a(parambt);
  }
  
  public final bo a()
  {
    return (bo)this.g.a();
  }
  
  public final void a(bo parambo)
  {
    int k = 0;
    Object localObject1 = parambo.i;
    if (localObject1 == null) {}
    for (;;)
    {
      localObject1 = parambo.d;
      if (localObject1 == null) {}
      for (;;)
      {
        localObject1 = parambo.h;
        if (localObject1 == null) {}
        for (;;)
        {
          localObject1 = parambo.b;
          if (localObject1 == null)
          {
            localObject1 = parambo.k;
            if (localObject1 != null)
            {
              ((br)localObject1).d();
              this.h.a(localObject1);
            }
            parambo.d();
            this.g.a(parambo);
            return;
          }
          localObject2 = ((bg)localObject1).as;
          if (localObject2 == null) {}
          for (;;)
          {
            ((bg)localObject1).e();
            this.a.a(localObject1);
            break;
            ((cc)localObject2).d();
            this.c.a(localObject2);
          }
          localObject2 = ((bl)localObject1).a;
          m = localObject2.length;
          j = k;
          while (j < m)
          {
            a(localObject2[j]);
            j += 1;
          }
          ((bl)localObject1).d();
          this.f.a(localObject1);
        }
        localObject2 = ((bh)localObject1).a;
        m = localObject2.length;
        j = 0;
        while (j < m)
        {
          a(localObject2[j]);
          j += 1;
        }
        ((bh)localObject1).d();
        this.e.a(localObject1);
      }
      Object localObject2 = ((bm)localObject1).d;
      if (localObject2 != null) {
        a((bt)localObject2);
      }
      localObject2 = ((bm)localObject1).c;
      int m = localObject2.length;
      int j = 0;
      while (j < m)
      {
        a(localObject2[j]);
        j += 1;
      }
      ((bm)localObject1).d();
      this.b.a(localObject1);
    }
  }
  
  public final bh b()
  {
    return (bh)this.e.a();
  }
  
  public final bt c()
  {
    return (bt)this.i.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */