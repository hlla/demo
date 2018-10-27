package android.support.v7.widget;

import android.support.v4.g.a;
import android.support.v4.g.h;
import android.support.v4.g.v;

final class hz
{
  public final a a = new a();
  public final h b = new h();
  
  final fc a(fz paramfz, int paramInt)
  {
    Object localObject2 = null;
    int i = this.a.a(paramfz);
    Object localObject1 = localObject2;
    ia localia;
    if (i >= 0)
    {
      localia = (ia)this.a.c(i);
      localObject1 = localObject2;
      if (localia != null)
      {
        int j = localia.a;
        localObject1 = localObject2;
        if ((j & paramInt) != 0)
        {
          localia.a = ((paramInt ^ 0xFFFFFFFF) & j);
          if (paramInt != 4) {
            break label116;
          }
        }
      }
    }
    for (paramfz = localia.c;; paramfz = localia.b)
    {
      localObject1 = paramfz;
      if ((localia.a & 0xC) == 0)
      {
        this.a.d(i);
        ia.a(localia);
        localObject1 = paramfz;
      }
      return (fc)localObject1;
      label116:
      if (paramInt != 8) {
        break;
      }
    }
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  final void a()
  {
    this.a.clear();
    this.b.b();
  }
  
  final void a(long paramLong, fz paramfz)
  {
    this.b.b(paramLong, paramfz);
  }
  
  final void a(fz paramfz, fc paramfc)
  {
    ia localia2 = (ia)this.a.get(paramfz);
    ia localia1 = localia2;
    if (localia2 == null)
    {
      localia1 = ia.a();
      this.a.put(paramfz, localia1);
    }
    localia1.c = paramfc;
    localia1.a |= 0x4;
  }
  
  final boolean a(fz paramfz)
  {
    paramfz = (ia)this.a.get(paramfz);
    return (paramfz != null) && ((paramfz.a & 0x1) != 0);
  }
  
  final void b(fz paramfz)
  {
    ia localia2 = (ia)this.a.get(paramfz);
    ia localia1 = localia2;
    if (localia2 == null)
    {
      localia1 = ia.a();
      this.a.put(paramfz, localia1);
    }
    localia1.a |= 0x1;
  }
  
  final void b(fz paramfz, fc paramfc)
  {
    ia localia2 = (ia)this.a.get(paramfz);
    ia localia1 = localia2;
    if (localia2 == null)
    {
      localia1 = ia.a();
      this.a.put(paramfz, localia1);
    }
    localia1.b = paramfc;
    localia1.a |= 0x8;
  }
  
  final void c(fz paramfz)
  {
    paramfz = (ia)this.a.get(paramfz);
    if (paramfz != null) {
      paramfz.a &= 0xFFFFFFFE;
    }
  }
  
  final void d(fz paramfz)
  {
    int i = this.b.a() - 1;
    for (;;)
    {
      if (i < 0) {}
      for (;;)
      {
        paramfz = (ia)this.a.remove(paramfz);
        if (paramfz != null) {
          ia.a(paramfz);
        }
        return;
        if (paramfz != this.b.b(i)) {
          break;
        }
        h localh = this.b;
        if (localh.c[i] != h.a)
        {
          localh.c[i] = h.a;
          localh.b = true;
        }
      }
      i -= 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */