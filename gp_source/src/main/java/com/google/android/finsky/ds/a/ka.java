package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ka
  extends b
{
  private static volatile ka[] u;
  public de a = null;
  public String b = "";
  public int c = 0;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public boolean i = false;
  public String j = "";
  public long k = 0L;
  public bu l = null;
  public boolean m = false;
  public String n = "";
  public int o = 0;
  public lj p = null;
  public long q = 0L;
  public long r = 0L;
  public String s = "";
  public String t = "";
  private int v = 0;
  private hk w = null;
  
  public ka()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ka[] b()
  {
    if (u == null) {}
    synchronized (f.a)
    {
      if (u == null) {
        u = new ka[0];
      }
      return u;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.c & 0x2000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(1, this.b);
    }
    i2 = i1;
    if ((this.c & 0x10) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(2, this.t);
    }
    i1 = i2;
    if ((this.c & 0x20) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(3, this.n);
    }
    i2 = i1;
    if ((this.c & 0x40) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(4, this.g);
    }
    i1 = i2;
    if ((this.c & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(5, this.r);
    }
    i2 = i1;
    if ((this.c & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(6, this.o);
    }
    i1 = i2;
    if ((this.c & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(7, this.s);
    }
    i2 = i1;
    if ((this.c & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(8, this.e);
    }
    i1 = i2;
    if ((this.c & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(9, this.d);
    }
    i2 = i1;
    if ((this.c & 0x100) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(19, this.f);
    }
    i1 = i2;
    if ((this.c & 0x200) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(29, this.j);
    }
    i2 = i1;
    if ((this.c & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.f(30, this.k);
    }
    Object localObject = this.w;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(31, (g)localObject);
    }
    localObject = this.a;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(33, (g)localObject);
    }
    localObject = this.l;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(34, (g)localObject);
    }
    i2 = i1;
    if ((this.c & 0x800) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(35, this.v);
    }
    i1 = i2;
    if ((this.c & 0x1000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.e(38, this.q);
    }
    localObject = this.p;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(39, (g)localObject);
    }
    i1 = i2;
    if ((this.c & 0x4000) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(320) + 1);
    }
    i2 = i1;
    if ((this.c & 0x8000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(41, this.h);
    }
    i1 = i2;
    if ((this.c & 0x10000) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(336) + 1);
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x2000) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.c & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.t);
    }
    if ((this.c & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.n);
    }
    if ((this.c & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.g);
    }
    if ((this.c & 0x80) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.r);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.o);
    }
    if ((this.c & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.s);
    }
    if ((this.c & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.e);
    }
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.d);
    }
    if ((this.c & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(19, this.f);
    }
    if ((this.c & 0x200) != 0) {
      paramCodedOutputByteBufferNano.a(29, this.j);
    }
    if ((this.c & 0x400) != 0) {
      paramCodedOutputByteBufferNano.b(30, this.k);
    }
    Object localObject = this.w;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(31, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(33, (g)localObject);
    }
    localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(34, (g)localObject);
    }
    if ((this.c & 0x800) != 0) {
      paramCodedOutputByteBufferNano.a(35, this.v);
    }
    if ((this.c & 0x1000) != 0) {
      paramCodedOutputByteBufferNano.a(38, this.q);
    }
    localObject = this.p;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(39, (g)localObject);
    }
    if ((this.c & 0x4000) != 0) {
      paramCodedOutputByteBufferNano.a(40, this.i);
    }
    if ((this.c & 0x8000) != 0) {
      paramCodedOutputByteBufferNano.a(41, this.h);
    }
    if ((this.c & 0x10000) != 0) {
      paramCodedOutputByteBufferNano.a(42, this.m);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean c()
  {
    return (this.c & 0x2) != 0;
  }
  
  public final boolean d()
  {
    return (this.c & 0x80) != 0;
  }
  
  public final boolean e()
  {
    return (this.c & 0x200) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ka))
      {
        paramObject = (ka)paramObject;
        if (((this.c & 0x1) == (((ka)paramObject).c & 0x1)) && (this.d.equals(((ka)paramObject).d)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label689;
          }
          if (((ka)paramObject).a != null) {}
        }
      }
      label635:
      label661:
      label675:
      label689:
      while (((de)localObject).equals(((ka)paramObject).a))
      {
        if (((this.c & 0x2) == (((ka)paramObject).c & 0x2)) && (this.o == ((ka)paramObject).o))
        {
          localObject = this.l;
          if (localObject != null) {
            break label675;
          }
          if (((ka)paramObject).l != null) {}
        }
        while (((bu)localObject).equals(((ka)paramObject).l))
        {
          int i1;
          int i2;
          if (((this.c & 0x4) == (((ka)paramObject).c & 0x4)) && (this.s.equals(((ka)paramObject).s)) && ((this.c & 0x8) == (((ka)paramObject).c & 0x8)) && (this.e.equals(((ka)paramObject).e)) && ((this.c & 0x10) == (((ka)paramObject).c & 0x10)) && (this.t.equals(((ka)paramObject).t)) && ((this.c & 0x20) == (((ka)paramObject).c & 0x20)) && (this.n.equals(((ka)paramObject).n)) && ((this.c & 0x40) == (((ka)paramObject).c & 0x40)) && (this.g.equals(((ka)paramObject).g)))
          {
            i1 = this.c;
            i2 = ((ka)paramObject).c;
            if (((i1 & 0x80) == (i2 & 0x80)) && (this.r == ((ka)paramObject).r) && ((i1 & 0x100) == (i2 & 0x100)) && (this.f.equals(((ka)paramObject).f)) && ((this.c & 0x200) == (((ka)paramObject).c & 0x200)) && (this.j.equals(((ka)paramObject).j)))
            {
              i1 = this.c;
              i2 = ((ka)paramObject).c;
              if (((i1 & 0x400) == (i2 & 0x400)) && (this.k == ((ka)paramObject).k) && ((i1 & 0x800) == (i2 & 0x800)) && (this.v == ((ka)paramObject).v) && ((i1 & 0x1000) == (i2 & 0x1000)) && (this.q == ((ka)paramObject).q))
              {
                localObject = this.p;
                if (localObject != null) {
                  break label661;
                }
                if (((ka)paramObject).p != null) {}
              }
            }
          }
          while (((lj)localObject).equals(((ka)paramObject).p))
          {
            localObject = this.w;
            if (localObject == null) {
              if (((ka)paramObject).w != null) {}
            }
            while (((hk)localObject).equals(((ka)paramObject).w))
            {
              if (((this.c & 0x2000) == (((ka)paramObject).c & 0x2000)) && (this.b.equals(((ka)paramObject).b)))
              {
                i1 = this.c;
                i2 = ((ka)paramObject).c;
                if (((i1 & 0x4000) == (i2 & 0x4000)) && (this.i == ((ka)paramObject).i) && ((i1 & 0x8000) == (i2 & 0x8000)) && (this.h.equals(((ka)paramObject).h)) && ((this.c & 0x10000) == (((ka)paramObject).c & 0x10000)) && (this.m == ((ka)paramObject).m))
                {
                  localObject = this.unknownFieldData;
                  if ((localObject != null) && (!((d)localObject).a())) {
                    break label635;
                  }
                  paramObject = ((ka)paramObject).unknownFieldData;
                }
              }
              return (paramObject == null) || (((d)paramObject).a());
              return this.unknownFieldData.equals(((ka)paramObject).unknownFieldData);
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final boolean f()
  {
    return (this.c & 0x400) != 0;
  }
  
  public final int hashCode()
  {
    int i8 = getClass().getName().hashCode();
    int i9 = this.d.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i2 = ((de)localObject).hashCode();; i2 = 0)
    {
      int i10 = this.o;
      localObject = this.l;
      if (localObject != null) {}
      for (int i3 = ((bu)localObject).hashCode();; i3 = 0)
      {
        int i11 = this.s.hashCode();
        int i12 = this.e.hashCode();
        int i13 = this.t.hashCode();
        int i14 = this.n.hashCode();
        int i15 = this.g.hashCode();
        long l1 = this.r;
        int i16 = this.f.hashCode();
        int i17 = this.j.hashCode();
        long l2 = this.k;
        int i18 = this.v;
        long l3 = this.q;
        localObject = this.p;
        int i19 = (int)(l1 >>> 32 ^ l1);
        int i20 = (int)(l2 >>> 32 ^ l2);
        int i21 = (int)(l3 >>> 32 ^ l3);
        if (localObject != null) {}
        for (int i4 = ((lj)localObject).hashCode();; i4 = 0)
        {
          localObject = this.w;
          if (localObject != null) {}
          for (int i5 = ((hk)localObject).hashCode();; i5 = 0)
          {
            int i22 = this.b.hashCode();
            if (!this.i) {}
            for (int i6 = 1237;; i6 = 1231)
            {
              int i23 = this.h.hashCode();
              if (!this.m) {}
              for (int i7 = 1237;; i7 = 1231)
              {
                localObject = this.unknownFieldData;
                int i1;
                if (localObject != null) {
                  if (!((d)localObject).a()) {
                    i1 = this.unknownFieldData.hashCode();
                  }
                }
                for (;;)
                {
                  return i1 + (i7 + ((i6 + ((i5 + (i4 + ((((((((((((i3 + ((i2 + ((i8 + 527) * 31 + i9) * 31) * 31 + i10) * 31) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i19) * 31 + i16) * 31 + i17) * 31 + i20) * 31 + i18) * 31 + i21) * 31) * 31) * 31 + i22) * 31) * 31 + i23) * 31) * 31;
                  i1 = 0;
                  continue;
                  i1 = 0;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */