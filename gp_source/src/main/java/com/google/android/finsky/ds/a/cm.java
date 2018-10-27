package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class cm
  extends b
{
  public int a = 0;
  public String b = "";
  public cn[] c = cn.b();
  public bu d = null;
  public String e = "";
  public boolean f = false;
  public boolean g = false;
  private String h = "";
  private long i = 0L;
  private double j = 0.0D;
  
  public cm()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((this.a & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.b(1, this.b);
    }
    m = k;
    if ((this.a & 0x2) != 0) {
      m = k + CodedOutputByteBufferNano.b(2, this.e);
    }
    k = m;
    if ((this.a & 0x4) != 0) {
      k = m + (CodedOutputByteBufferNano.d(24) + 8);
    }
    m = k;
    if ((this.a & 0x8) != 0) {
      m = k + CodedOutputByteBufferNano.f(4, this.i);
    }
    int n = m;
    if ((this.a & 0x10) != 0) {
      n = m + CodedOutputByteBufferNano.b(5, this.h);
    }
    k = n;
    if ((this.a & 0x20) != 0) {
      k = n + (CodedOutputByteBufferNano.d(48) + 1);
    }
    Object localObject = this.c;
    m = k;
    if (localObject != null)
    {
      m = k;
      if (localObject.length > 0)
      {
        m = 0;
        for (;;)
        {
          localObject = this.c;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          n = k;
          if (localObject != null) {
            n = k + CodedOutputByteBufferNano.d(7, (g)localObject);
          }
          m += 1;
          k = n;
        }
        m = k;
      }
    }
    localObject = this.d;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    m = k;
    if ((this.a & 0x40) != 0) {
      m = k + (CodedOutputByteBufferNano.d(72) + 1);
    }
    return m;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.j);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.i);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.h);
    }
    if ((this.a & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.f);
    }
    Object localObject = this.c;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int k;
    do
    {
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(8, (g)localObject);
      }
      if ((this.a & 0x40) != 0) {
        paramCodedOutputByteBufferNano.a(9, this.g);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      k = 0;
      localObject = this.c;
    } while (k >= localObject.length);
    localObject = localObject[k];
    if (localObject == null) {}
    for (;;)
    {
      k += 1;
      break;
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cm))
      {
        paramObject = (cm)paramObject;
        if (((this.a & 0x1) == (((cm)paramObject).a & 0x1)) && (this.b.equals(((cm)paramObject).b)) && ((this.a & 0x2) == (((cm)paramObject).a & 0x2)) && (this.e.equals(((cm)paramObject).e)) && ((this.a & 0x4) == (((cm)paramObject).a & 0x4)) && (Double.doubleToLongBits(this.j) == Double.doubleToLongBits(((cm)paramObject).j)))
        {
          int k = this.a;
          int m = ((cm)paramObject).a;
          if (((k & 0x8) == (m & 0x8)) && (this.i == ((cm)paramObject).i) && ((k & 0x10) == (m & 0x10)) && (this.h.equals(((cm)paramObject).h)) && ((this.a & 0x20) == (((cm)paramObject).a & 0x20)) && (this.f == ((cm)paramObject).f) && (f.a(this.c, ((cm)paramObject).c)))
          {
            localObject = this.d;
            if (localObject != null) {
              break label305;
            }
            if (((cm)paramObject).d != null) {}
          }
        }
      }
      label305:
      while (((bu)localObject).equals(((cm)paramObject).d))
      {
        if (((this.a & 0x40) == (((cm)paramObject).a & 0x40)) && (this.g == ((cm)paramObject).g))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((cm)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((cm)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = 1237;
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.e.hashCode();
    long l1 = Double.doubleToLongBits(this.j);
    long l2 = this.i;
    int i6 = (int)(l1 >>> 32 ^ l1);
    int i7 = (int)(l2 >>> 32 ^ l2);
    int i8 = this.h.hashCode();
    if (!this.f) {}
    for (int k = 1237;; k = 1231)
    {
      int i9 = f.a(this.c);
      Object localObject = this.d;
      if (localObject != null) {}
      for (int m = ((bu)localObject).hashCode();; m = 0)
      {
        if (!this.g) {}
        for (;;)
        {
          localObject = this.unknownFieldData;
          int i1 = i2;
          if (localObject != null)
          {
            i1 = i2;
            if (!((d)localObject).a()) {
              i1 = this.unknownFieldData.hashCode();
            }
          }
          return ((m + ((k + ((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31 + i9) * 31) * 31 + n) * 31 + i1;
          n = 1231;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */