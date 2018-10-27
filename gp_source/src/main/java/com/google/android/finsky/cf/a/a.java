package com.google.android.finsky.cf.a;

import android.os.Environment;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.cg.c;
import com.google.android.finsky.ds.a.ds;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.em.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.b.ah;
import com.google.wireless.android.finsky.b.e;

public final class a
  implements com.google.android.finsky.cf.b
{
  private final com.google.android.finsky.dh.a a;
  private final g b;
  
  public a(g paramg, com.google.android.finsky.dh.a parama)
  {
    this.b = paramg;
    this.a = parama;
  }
  
  private final long c(long paramLong)
  {
    long l = g.g();
    if (paramLong < 0L)
    {
      FinskyLog.e("Cannot use a negative offset", new Object[0]);
      return -1L;
    }
    return this.b.a(l) - paramLong;
  }
  
  public final long a(long paramLong)
  {
    paramLong = ((Integer)d.bV.b()).intValue() * paramLong / 100L;
    return ((Long)d.bW.b()).longValue() + paramLong;
  }
  
  public final long a(com.google.android.finsky.bf.f paramf)
  {
    return (paramf.j + paramf.b.a) * 110L / 100L;
  }
  
  public final long a(com.google.android.finsky.cf.a parama)
  {
    boolean bool = this.b.f();
    if ((parama.g & 0x1000) == 0)
    {
      if (parama.f <= 0L) {
        if (!bool) {
          break label50;
        }
      }
      label50:
      for (l = this.b.e();; l = g.d())
      {
        parama.f = l;
        return parama.f;
      }
    }
    if (parama.a <= 0L) {
      if (!bool) {
        break label88;
      }
    }
    label88:
    for (long l = this.b.c();; l = g.b())
    {
      parama.a = l;
      return parama.a;
    }
  }
  
  public final long a(o paramo)
  {
    Object localObject = paramo.t;
    localObject = this.a.a((String)localObject);
    if (localObject != null) {}
    long l2;
    for (int i = ((com.google.android.finsky.dh.b)localObject).f;; i = -1)
    {
      paramo = paramo.n;
      int k = paramo.length;
      int j = 0;
      l2 = 0L;
      if (j >= k) {
        break;
      }
      localObject = paramo[j];
      if (((ds)localObject).c != 0)
      {
        l1 = l2;
        if (Environment.isExternalStorageEmulated())
        {
          l1 = l2;
          if (i >= ((ds)localObject).g) {}
        }
      }
      for (long l1 = l2 + ((ds)localObject).e;; l1 = l2 + ((ds)localObject).e)
      {
        j += 1;
        l2 = l1;
        break;
      }
    }
    return l2;
  }
  
  public final long a(com.google.android.finsky.l.b paramb)
  {
    int j = 0;
    int k = -1;
    com.google.wireless.android.finsky.b.a locala = paramb.a.i;
    long l1 = locala.e;
    ah[] arrayOfah = locala.q;
    int m = arrayOfah.length;
    int i = 0;
    while (i < m)
    {
      l1 += arrayOfah[i].c;
      i += 1;
    }
    long l2 = l1;
    if (Environment.isExternalStorageEmulated())
    {
      i = k;
      if (paramb != null)
      {
        paramb = paramb.c;
        i = k;
        if (paramb != null) {
          i = paramb.f;
        }
      }
      paramb = locala.a;
      k = paramb.length;
      for (;;)
      {
        l2 = l1;
        if (j >= k) {
          break;
        }
        locala = paramb[j];
        l2 = l1;
        if (i < locala.j) {
          l2 = l1 + locala.i;
        }
        j += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    if (com.google.android.finsky.utils.a.d()) {}
    for (paramLong2 = c(paramLong2);; paramLong2 = c(0L))
    {
      if (paramLong2 > 0L) {
        return g.d() - ((Integer)d.bX.b()).intValue() * paramLong1 / 100L >= paramLong2;
      }
      return false;
    }
  }
  
  public final long b(com.google.android.finsky.bf.f paramf)
  {
    return ((Integer)d.ca.b()).intValue() * paramf.j / 100L;
  }
  
  public final boolean b(long paramLong)
  {
    return a(paramLong, 0L);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cf/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */