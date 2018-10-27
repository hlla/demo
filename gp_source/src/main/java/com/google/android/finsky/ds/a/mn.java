package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class mn
  extends b
{
  public int a = 0;
  public boolean b = false;
  public nl[] c = nl.b();
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private String h = "";
  private String i = "";
  private int j = 0;
  
  public mn()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((this.a & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.b(1, this.h);
    }
    m = k;
    if ((this.a & 0x2) != 0) {
      m = k + CodedOutputByteBufferNano.d(2, this.j);
    }
    k = m;
    if ((this.a & 0x4) != 0) {
      k = m + CodedOutputByteBufferNano.b(3, this.i);
    }
    m = k;
    if ((this.a & 0x8) != 0) {
      m = k + CodedOutputByteBufferNano.b(4, this.d);
    }
    k = m;
    if ((this.a & 0x10) != 0) {
      k = m + CodedOutputByteBufferNano.d(5, this.f);
    }
    m = k;
    if ((this.a & 0x20) != 0) {
      m = k + CodedOutputByteBufferNano.d(6, this.g);
    }
    int n = m;
    if ((this.a & 0x40) != 0) {
      n = m + (CodedOutputByteBufferNano.d(56) + 1);
    }
    k = n;
    if ((this.a & 0x80) != 0) {
      k = n + CodedOutputByteBufferNano.b(8, this.e);
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
            n = k + CodedOutputByteBufferNano.d(9, (g)localObject);
          }
          m += 1;
          k = n;
        }
        m = k;
      }
    }
    return m;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.j);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.i);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.f);
    }
    if ((this.a & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.g);
    }
    if ((this.a & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.b);
    }
    if ((this.a & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.e);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = 0;
      localObject = this.c;
      if (k < localObject.length)
      {
        localObject = localObject[k];
        if (localObject == null) {}
        for (;;)
        {
          k += 1;
          break;
          paramCodedOutputByteBufferNano.b(9, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mn))
      {
        paramObject = (mn)paramObject;
        if (((this.a & 0x1) == (((mn)paramObject).a & 0x1)) && (this.h.equals(((mn)paramObject).h)))
        {
          int k = this.a;
          int m = ((mn)paramObject).a;
          if (((k & 0x2) == (m & 0x2)) && (this.j == ((mn)paramObject).j) && ((k & 0x4) == (m & 0x4)) && (this.i.equals(((mn)paramObject).i)) && ((this.a & 0x8) == (((mn)paramObject).a & 0x8)) && (this.d.equals(((mn)paramObject).d)))
          {
            k = this.a;
            m = ((mn)paramObject).a;
            if (((k & 0x10) == (m & 0x10)) && (this.f == ((mn)paramObject).f) && ((k & 0x20) == (m & 0x20)) && (this.g == ((mn)paramObject).g) && ((k & 0x40) == (m & 0x40)) && (this.b == ((mn)paramObject).b) && ((k & 0x80) == (m & 0x80)) && (this.e.equals(((mn)paramObject).e)) && (f.a(this.c, ((mn)paramObject).c)))
            {
              d locald = this.unknownFieldData;
              if ((locald != null) && (!locald.a())) {
                break label286;
              }
              paramObject = ((mn)paramObject).unknownFieldData;
            }
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label286:
      return this.unknownFieldData.equals(((mn)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = getClass().getName().hashCode();
    int i1 = this.h.hashCode();
    int i2 = this.j;
    int i3 = this.i.hashCode();
    int i4 = this.d.hashCode();
    int i5 = this.f;
    int i6 = this.g;
    if (!this.b) {}
    for (int m = 1237;; m = 1231)
    {
      int i7 = this.e.hashCode();
      int i8 = f.a(this.c);
      d locald = this.unknownFieldData;
      int k;
      if (locald != null) {
        if (!locald.a()) {
          k = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return k + (((m + (((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31;
        k = 0;
        continue;
        k = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */