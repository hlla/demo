package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.dg;
import com.google.wireless.android.finsky.d.dj;

public final class iv
  extends b
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public float e = 0.0F;
  public long f = 0L;
  public long g = 0L;
  private double h = 0.0D;
  private int i = 0;
  private long j = 0L;
  private iw k = null;
  private long l = 0L;
  private long m = 0L;
  private dj[] n = new dj[0];
  private dg o = dg.a;
  
  public iv()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i2 = super.a();
    Object localObject = this.o;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(1, ((dg)localObject).b);
    }
    i2 = i1;
    if ((this.i & 0x1) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(16) + 4);
    }
    i1 = i2;
    if ((this.i & 0x2) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.e(3, this.d);
    }
    i2 = i1;
    if ((this.i & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.e(4, this.c);
    }
    i1 = i2;
    if ((this.i & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.e(5, this.g);
    }
    i2 = i1;
    if ((this.i & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.e(6, this.f);
    }
    i1 = i2;
    if ((this.i & 0x40) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.e(7, this.b);
    }
    i2 = i1;
    if ((this.i & 0x80) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.e(8, this.a);
    }
    i1 = i2;
    if ((this.i & 0x200) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.e(9, this.m);
    }
    i2 = i1;
    if ((this.i & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.e(10, this.l);
    }
    int i3 = i2;
    if ((this.i & 0x4) != 0) {
      i3 = i2 + CodedOutputByteBufferNano.e(11, this.j);
    }
    i1 = i3;
    if ((this.i & 0x100) != 0) {
      i1 = i3 + (CodedOutputByteBufferNano.d(96) + 8);
    }
    localObject = this.n;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.n;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputStream.c(13, (cl)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    localObject = this.k;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(15, (g)localObject);
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.o;
    if (localObject == null) {}
    for (;;)
    {
      if ((this.i & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.e);
      }
      if ((this.i & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.d);
      }
      if ((this.i & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.c);
      }
      if ((this.i & 0x10) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.g);
      }
      if ((this.i & 0x20) != 0) {
        paramCodedOutputByteBufferNano.a(6, this.f);
      }
      if ((this.i & 0x40) != 0) {
        paramCodedOutputByteBufferNano.a(7, this.b);
      }
      if ((this.i & 0x80) != 0) {
        paramCodedOutputByteBufferNano.a(8, this.a);
      }
      if ((this.i & 0x200) != 0) {
        paramCodedOutputByteBufferNano.a(9, this.m);
      }
      if ((this.i & 0x400) != 0) {
        paramCodedOutputByteBufferNano.a(10, this.l);
      }
      if ((this.i & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(11, this.j);
      }
      if ((this.i & 0x100) != 0) {
        paramCodedOutputByteBufferNano.a(12, this.h);
      }
      localObject = this.n;
      if ((localObject == null) || (localObject.length <= 0)) {}
      int i1;
      do
      {
        localObject = this.k;
        if (localObject != null) {
          paramCodedOutputByteBufferNano.b(15, (g)localObject);
        }
        super.a(paramCodedOutputByteBufferNano);
        return;
        i1 = 0;
        localObject = this.n;
      } while (i1 >= localObject.length);
      localObject = localObject[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramCodedOutputByteBufferNano.a(13, (cl)localObject);
      }
      paramCodedOutputByteBufferNano.a(1, ((dg)localObject).b);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof iv))
      {
        paramObject = (iv)paramObject;
        if ((this.o == ((iv)paramObject).o) && ((this.i & 0x1) == (((iv)paramObject).i & 0x1)) && (Float.floatToIntBits(this.e) == Float.floatToIntBits(((iv)paramObject).e)))
        {
          int i1 = this.i;
          int i2 = ((iv)paramObject).i;
          if (((i1 & 0x2) == (i2 & 0x2)) && (this.d == ((iv)paramObject).d) && ((i1 & 0x4) == (i2 & 0x4)) && (this.j == ((iv)paramObject).j) && ((i1 & 0x8) == (i2 & 0x8)) && (this.c == ((iv)paramObject).c) && ((i1 & 0x10) == (i2 & 0x10)) && (this.g == ((iv)paramObject).g) && ((i1 & 0x20) == (i2 & 0x20)) && (this.f == ((iv)paramObject).f) && ((i1 & 0x40) == (i2 & 0x40)) && (this.b == ((iv)paramObject).b) && ((i1 & 0x80) == (i2 & 0x80)) && (this.a == ((iv)paramObject).a) && ((i1 & 0x100) == (i2 & 0x100)) && (Double.doubleToLongBits(this.h) == Double.doubleToLongBits(((iv)paramObject).h)))
          {
            i1 = this.i;
            i2 = ((iv)paramObject).i;
            if (((i1 & 0x200) == (i2 & 0x200)) && (this.m == ((iv)paramObject).m) && ((i1 & 0x400) == (i2 & 0x400)) && (this.l == ((iv)paramObject).l) && (f.a(this.n, ((iv)paramObject).n)))
            {
              localObject = this.k;
              if (localObject != null) {
                break label403;
              }
              if (((iv)paramObject).k != null) {}
            }
          }
        }
      }
      label403:
      while (((iw)localObject).equals(((iv)paramObject).k))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((iv)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((iv)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i4 = getClass().getName().hashCode();
    Object localObject = this.o;
    if (localObject != null) {}
    for (int i2 = ((dg)localObject).hashCode();; i2 = 0)
    {
      int i5 = Float.floatToIntBits(this.e);
      long l1 = this.d;
      long l2 = this.j;
      long l3 = this.c;
      long l4 = this.g;
      long l5 = this.f;
      long l6 = this.b;
      long l7 = this.a;
      long l8 = Double.doubleToLongBits(this.h);
      long l9 = this.m;
      long l10 = this.l;
      int i6 = f.a(this.n);
      localObject = this.k;
      int i7 = (int)(l1 ^ l1 >>> 32);
      int i8 = (int)(l2 >>> 32 ^ l2);
      int i9 = (int)(l3 >>> 32 ^ l3);
      int i10 = (int)(l4 >>> 32 ^ l4);
      int i11 = (int)(l5 >>> 32 ^ l5);
      int i12 = (int)(l6 >>> 32 ^ l6);
      int i13 = (int)(l7 >>> 32 ^ l7);
      int i14 = (int)(l8 >>> 32 ^ l8);
      int i15 = (int)(l9 >>> 32 ^ l9);
      int i16 = (int)(l10 >>> 32 ^ l10);
      if (localObject != null) {}
      for (int i3 = ((iw)localObject).hashCode();; i3 = 0)
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
          return i1 + (i3 + (((((((((((((i2 + (i4 + 527) * 31) * 31 + i5) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i6) * 31) * 31;
          i1 = 0;
          continue;
          i1 = 0;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/iv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */