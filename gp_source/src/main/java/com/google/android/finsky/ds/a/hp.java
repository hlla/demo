package com.google.android.finsky.ds.a;

import com.google.n.b.a.a;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.av;

public final class hp
  extends b
{
  private boolean a = false;
  private a b = null;
  private int c = 0;
  private boolean d = false;
  private bp e = null;
  private av f = null;
  private ej g = null;
  private boolean h = false;
  private long i = 0L;
  private long j = 0L;
  private bx k = null;
  private long l = 0L;
  private boolean m = false;
  private int n = 1;
  private long o = 0L;
  private cc p = null;
  private long q = 0L;
  private boolean r = false;
  private long s = 0L;
  
  public hp()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.c & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(1, this.i);
    }
    i2 = i1;
    if ((this.c & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.f(2, this.s);
    }
    i1 = i2;
    if ((this.c & 0x8) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(24) + 1);
    }
    i2 = i1;
    if ((this.c & 0x40) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.f(4, this.o);
    }
    i1 = i2;
    if ((this.c & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(5, this.l);
    }
    Object localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(6, (cl)localObject);
    }
    i1 = i2;
    if ((this.c & 0x100) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(56) + 1);
    }
    i2 = i1;
    if ((this.c & 0x200) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(64) + 1);
    }
    localObject = this.p;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    localObject = this.g;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(10, (g)localObject);
    }
    localObject = this.k;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(11, (g)localObject);
    }
    i2 = i1;
    if ((this.c & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(12, this.n);
    }
    localObject = this.b;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(13, (cl)localObject);
    }
    i2 = i1;
    if ((this.c & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.f(14, this.j);
    }
    localObject = this.e;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(16, (g)localObject);
    }
    i2 = i1;
    if ((this.c & 0x800) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(136) + 1);
    }
    i1 = i2;
    if ((this.c & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(18, this.q);
    }
    i2 = i1;
    if ((this.c & 0x10) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(152) + 1);
    }
    return i2;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.i);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.s);
    }
    if ((this.c & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.c & 0x40) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.o);
    }
    if ((this.c & 0x80) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.l);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(6, (cl)localObject);
    }
    if ((this.c & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.m);
    }
    if ((this.c & 0x200) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.h);
    }
    localObject = this.p;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(10, (g)localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(11, (g)localObject);
    }
    if ((this.c & 0x400) != 0) {
      paramCodedOutputByteBufferNano.a(12, this.n);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(13, (cl)localObject);
    }
    if ((this.c & 0x20) != 0) {
      paramCodedOutputByteBufferNano.b(14, this.j);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(16, (g)localObject);
    }
    if ((this.c & 0x800) != 0) {
      paramCodedOutputByteBufferNano.a(17, this.d);
    }
    if ((this.c & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(18, this.q);
    }
    if ((this.c & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(19, this.r);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i1;
      int i2;
      Object localObject;
      if ((paramObject instanceof hp))
      {
        paramObject = (hp)paramObject;
        i1 = this.c;
        i2 = ((hp)paramObject).c;
        if (((i1 & 0x1) == (i2 & 0x1)) && (this.i == ((hp)paramObject).i) && ((i1 & 0x2) == (i2 & 0x2)) && (this.s == ((hp)paramObject).s) && ((i1 & 0x4) == (i2 & 0x4)) && (this.q == ((hp)paramObject).q) && ((i1 & 0x8) == (i2 & 0x8)) && (this.a == ((hp)paramObject).a) && ((i1 & 0x10) == (i2 & 0x10)) && (this.r == ((hp)paramObject).r) && ((i1 & 0x20) == (i2 & 0x20)) && (this.j == ((hp)paramObject).j) && ((i1 & 0x40) == (i2 & 0x40)) && (this.o == ((hp)paramObject).o) && ((i1 & 0x80) == (i2 & 0x80)) && (this.l == ((hp)paramObject).l))
        {
          localObject = this.f;
          if (localObject != null) {
            break label552;
          }
          if (((hp)paramObject).f != null) {}
        }
      }
      label482:
      label496:
      label538:
      label552:
      while (((bb)localObject).equals(((hp)paramObject).f))
      {
        i1 = this.c;
        i2 = ((hp)paramObject).c;
        if (((i1 & 0x100) == (i2 & 0x100)) && (this.m == ((hp)paramObject).m) && ((i1 & 0x200) == (i2 & 0x200)) && (this.h == ((hp)paramObject).h))
        {
          localObject = this.p;
          if (localObject != null) {
            break label538;
          }
          if (((hp)paramObject).p != null) {}
        }
        while (((cc)localObject).equals(((hp)paramObject).p))
        {
          localObject = this.g;
          if (localObject == null) {
            if (((hp)paramObject).g != null) {}
          }
          while (((ej)localObject).equals(((hp)paramObject).g))
          {
            localObject = this.k;
            if (localObject == null) {
              if (((hp)paramObject).k != null) {}
            }
            while (((bx)localObject).equals(((hp)paramObject).k))
            {
              if (((this.c & 0x400) == (((hp)paramObject).c & 0x400)) && (this.n == ((hp)paramObject).n))
              {
                localObject = this.e;
                if (localObject != null) {
                  break label496;
                }
                if (((hp)paramObject).e != null) {}
              }
              while (((bp)localObject).equals(((hp)paramObject).e))
              {
                if (((this.c & 0x800) == (((hp)paramObject).c & 0x800)) && (this.d == ((hp)paramObject).d))
                {
                  localObject = this.b;
                  if (localObject != null) {
                    break label482;
                  }
                  if (((hp)paramObject).b != null) {}
                }
                while (((bb)localObject).equals(((hp)paramObject).b))
                {
                  localObject = this.unknownFieldData;
                  if ((localObject == null) || (((d)localObject).a()))
                  {
                    paramObject = ((hp)paramObject).unknownFieldData;
                    return (paramObject == null) || (((d)paramObject).a());
                  }
                  return this.unknownFieldData.equals(((hp)paramObject).unknownFieldData);
                }
                return false;
              }
              return false;
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
  
  public final int hashCode()
  {
    int i10 = 1237;
    int i13 = 0;
    int i14 = getClass().getName().hashCode();
    long l1 = this.i;
    long l2 = this.s;
    long l3 = this.q;
    int i15 = (int)(l1 ^ l1 >>> 32);
    int i16 = (int)(l2 >>> 32 ^ l2);
    int i17 = (int)(l3 >>> 32 ^ l3);
    if (!this.a) {}
    for (int i1 = 1237;; i1 = 1231)
    {
      if (!this.r) {}
      for (int i2 = 1237;; i2 = 1231)
      {
        l1 = this.j;
        l2 = this.o;
        l3 = this.l;
        Object localObject = this.f;
        int i18 = (int)(l1 ^ l1 >>> 32);
        int i19 = (int)(l2 >>> 32 ^ l2);
        int i20 = (int)(l3 >>> 32 ^ l3);
        if (localObject != null) {}
        for (int i3 = ((bb)localObject).hashCode();; i3 = 0)
        {
          if (!this.m) {}
          for (int i4 = 1237;; i4 = 1231)
          {
            if (!this.h) {}
            for (int i5 = 1237;; i5 = 1231)
            {
              localObject = this.p;
              if (localObject != null) {}
              for (int i6 = ((cc)localObject).hashCode();; i6 = 0)
              {
                localObject = this.g;
                if (localObject != null) {}
                for (int i7 = ((ej)localObject).hashCode();; i7 = 0)
                {
                  localObject = this.k;
                  if (localObject != null) {}
                  for (int i8 = ((bx)localObject).hashCode();; i8 = 0)
                  {
                    int i21 = this.n;
                    localObject = this.e;
                    if (localObject != null) {}
                    for (int i9 = ((bp)localObject).hashCode();; i9 = 0)
                    {
                      if (!this.d) {}
                      for (;;)
                      {
                        localObject = this.b;
                        if (localObject != null) {}
                        for (int i11 = ((bb)localObject).hashCode();; i11 = 0)
                        {
                          localObject = this.unknownFieldData;
                          int i12 = i13;
                          if (localObject != null)
                          {
                            i12 = i13;
                            if (!((d)localObject).a()) {
                              i12 = this.unknownFieldData.hashCode();
                            }
                          }
                          return (i11 + ((i9 + ((i8 + (i7 + (i6 + (i5 + (i4 + (i3 + ((((i2 + (i1 + ((((i14 + 527) * 31 + i15) * 31 + i16) * 31 + i17) * 31) * 31) * 31 + i18) * 31 + i19) * 31 + i20) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i21) * 31) * 31 + i10) * 31) * 31 + i12;
                        }
                        i10 = 1231;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */