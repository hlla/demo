package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.bd;

public final class cg
  extends b
{
  private int a = 0;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private String e = "";
  private boolean f = false;
  private bd g = null;
  private long h = 0L;
  private String i = "";
  private long j = 0L;
  private ch k = null;
  private bd l = null;
  private bp[] m = bp.b();
  private boolean n = false;
  private cd o = null;
  private ci p = null;
  private bd q = null;
  
  public cg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i2 = super.a();
    Object localObject = this.l;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(1, (cl)localObject);
    }
    localObject = this.q;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(2, (cl)localObject);
    }
    int i3 = i2;
    if ((this.a & 0x4) != 0) {
      i3 = i2 + CodedOutputByteBufferNano.b(3, this.e);
    }
    localObject = this.o;
    i1 = i3;
    if (localObject != null) {
      i1 = i3 + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.m;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.m;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.d(5, (g)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(6, (cl)localObject);
    }
    i2 = i1;
    if ((this.a & 0x8) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(56) + 1);
    }
    i1 = i2;
    if ((this.a & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(8, this.h);
    }
    i2 = i1;
    if ((this.a & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(9, this.i);
    }
    i1 = i2;
    if ((this.a & 0x40) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(10, this.j);
    }
    i2 = i1;
    if ((this.a & 0x2) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(88) + 1);
    }
    localObject = this.p;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(12, (g)localObject);
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(13, (g)localObject);
    }
    i1 = i2;
    if ((this.a & 0x80) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(112) + 1);
    }
    i2 = i1;
    if ((this.a & 0x1) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(120) + 1);
    }
    i1 = i2;
    if ((this.a & 0x100) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(128) + 1);
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(1, (cl)localObject);
    }
    localObject = this.q;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, (cl)localObject);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    localObject = this.o;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    localObject = this.m;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i1;
    do
    {
      localObject = this.g;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(6, (cl)localObject);
      }
      if ((this.a & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(7, this.n);
      }
      if ((this.a & 0x10) != 0) {
        paramCodedOutputByteBufferNano.b(8, this.h);
      }
      if ((this.a & 0x20) != 0) {
        paramCodedOutputByteBufferNano.a(9, this.i);
      }
      if ((this.a & 0x40) != 0) {
        paramCodedOutputByteBufferNano.b(10, this.j);
      }
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(11, this.b);
      }
      localObject = this.p;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(12, (g)localObject);
      }
      localObject = this.k;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(13, (g)localObject);
      }
      if ((this.a & 0x80) != 0) {
        paramCodedOutputByteBufferNano.a(14, this.d);
      }
      if ((this.a & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(15, this.c);
      }
      if ((this.a & 0x100) != 0) {
        paramCodedOutputByteBufferNano.a(16, this.f);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i1 = 0;
      localObject = this.m;
    } while (i1 >= localObject.length);
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cg))
      {
        paramObject = (cg)paramObject;
        localObject = this.l;
        if (localObject != null) {
          break label494;
        }
        if (((cg)paramObject).l != null) {}
      }
      label412:
      label452:
      label466:
      label494:
      while (((bb)localObject).equals(((cg)paramObject).l))
      {
        localObject = this.q;
        if (localObject == null) {
          if (((cg)paramObject).q != null) {}
        }
        while (((bb)localObject).equals(((cg)paramObject).q))
        {
          int i1 = this.a;
          int i2 = ((cg)paramObject).a;
          if (((i1 & 0x1) == (i2 & 0x1)) && (this.c == ((cg)paramObject).c) && ((i1 & 0x2) == (i2 & 0x2)) && (this.b == ((cg)paramObject).b) && ((i1 & 0x4) == (i2 & 0x4)) && (this.e.equals(((cg)paramObject).e)))
          {
            localObject = this.o;
            if (localObject != null) {
              break label466;
            }
            if (((cg)paramObject).o != null) {}
          }
          while (((cd)localObject).equals(((cg)paramObject).o))
          {
            if (f.a(this.m, ((cg)paramObject).m))
            {
              localObject = this.p;
              if (localObject != null) {
                break label452;
              }
              if (((cg)paramObject).p != null) {}
            }
            while (((ci)localObject).equals(((cg)paramObject).p))
            {
              localObject = this.g;
              if (localObject == null) {
                if (((cg)paramObject).g != null) {}
              }
              while (((bb)localObject).equals(((cg)paramObject).g))
              {
                localObject = this.k;
                if (localObject == null) {
                  if (((cg)paramObject).k != null) {}
                }
                while (((ch)localObject).equals(((cg)paramObject).k))
                {
                  i1 = this.a;
                  i2 = ((cg)paramObject).a;
                  if (((i1 & 0x8) == (i2 & 0x8)) && (this.n == ((cg)paramObject).n) && ((i1 & 0x10) == (i2 & 0x10)) && (this.h == ((cg)paramObject).h) && ((i1 & 0x20) == (i2 & 0x20)) && (this.i.equals(((cg)paramObject).i)))
                  {
                    i1 = this.a;
                    i2 = ((cg)paramObject).a;
                    if (((i1 & 0x40) == (i2 & 0x40)) && (this.j == ((cg)paramObject).j) && ((i1 & 0x80) == (i2 & 0x80)) && (this.d == ((cg)paramObject).d) && ((i1 & 0x100) == (i2 & 0x100)) && (this.f == ((cg)paramObject).f))
                    {
                      localObject = this.unknownFieldData;
                      if ((localObject != null) && (!((d)localObject).a())) {
                        break label412;
                      }
                      paramObject = ((cg)paramObject).unknownFieldData;
                    }
                  }
                  return (paramObject == null) || (((d)paramObject).a());
                  return this.unknownFieldData.equals(((cg)paramObject).unknownFieldData);
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
    int i11 = 1237;
    int i13 = 0;
    int i14 = getClass().getName().hashCode();
    Object localObject = this.l;
    if (localObject != null) {}
    for (int i1 = ((bb)localObject).hashCode();; i1 = 0)
    {
      localObject = this.q;
      if (localObject != null) {}
      for (int i2 = ((bb)localObject).hashCode();; i2 = 0)
      {
        if (!this.c) {}
        for (int i3 = 1237;; i3 = 1231)
        {
          if (!this.b) {}
          for (int i4 = 1237;; i4 = 1231)
          {
            int i15 = this.e.hashCode();
            localObject = this.o;
            if (localObject != null) {}
            for (int i5 = ((cd)localObject).hashCode();; i5 = 0)
            {
              int i16 = f.a(this.m);
              localObject = this.p;
              if (localObject != null) {}
              for (int i6 = ((ci)localObject).hashCode();; i6 = 0)
              {
                localObject = this.g;
                if (localObject != null) {}
                for (int i7 = ((bb)localObject).hashCode();; i7 = 0)
                {
                  localObject = this.k;
                  if (localObject != null) {}
                  for (int i8 = ((ch)localObject).hashCode();; i8 = 0)
                  {
                    if (!this.n) {}
                    for (int i9 = 1237;; i9 = 1231)
                    {
                      long l1 = this.h;
                      int i17 = this.i.hashCode();
                      long l2 = this.j;
                      int i18 = (int)(l1 ^ l1 >>> 32);
                      int i19 = (int)(l2 >>> 32 ^ l2);
                      if (!this.d) {}
                      for (int i10 = 1237;; i10 = 1231)
                      {
                        if (!this.f) {}
                        for (;;)
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
                          return ((i10 + ((((i9 + (i8 + (i7 + (i6 + ((i5 + ((i4 + (i3 + (i2 + (i1 + (i14 + 527) * 31) * 31) * 31) * 31) * 31 + i15) * 31) * 31 + i16) * 31) * 31) * 31) * 31) * 31 + i18) * 31 + i17) * 31 + i19) * 31) * 31 + i11) * 31 + i12;
                          i11 = 1231;
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
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */