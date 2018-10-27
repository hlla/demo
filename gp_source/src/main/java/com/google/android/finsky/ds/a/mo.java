package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class mo
  extends b
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private int h = 0;
  private int i = 0;
  private int j = 0;
  
  public mo()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((this.b & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.d(1, this.i);
    }
    m = k;
    if ((this.b & 0x2) != 0) {
      m = k + CodedOutputByteBufferNano.d(2, this.j);
    }
    k = m;
    if ((this.b & 0x4) != 0) {
      k = m + CodedOutputByteBufferNano.d(3, this.h);
    }
    m = k;
    if ((this.b & 0x8) != 0) {
      m = k + CodedOutputByteBufferNano.b(4, this.e);
    }
    k = m;
    if ((this.b & 0x10) != 0) {
      k = m + CodedOutputByteBufferNano.b(5, this.a);
    }
    m = k;
    if ((this.b & 0x20) != 0) {
      m = k + CodedOutputByteBufferNano.b(6, this.f);
    }
    k = m;
    if ((this.b & 0x40) != 0) {
      k = m + CodedOutputByteBufferNano.b(7, this.d);
    }
    m = k;
    if ((this.b & 0x80) != 0) {
      m = k + CodedOutputByteBufferNano.b(8, this.c);
    }
    k = m;
    if ((this.b & 0x100) != 0) {
      k = m + CodedOutputByteBufferNano.b(9, this.g);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.i);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.j);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.h);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.a);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.f);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.d);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.c);
    }
    if ((this.b & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.g);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.b & 0x40) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mo))
      {
        paramObject = (mo)paramObject;
        int k = this.b;
        int m = ((mo)paramObject).b;
        if (((k & 0x1) == (m & 0x1)) && (this.i == ((mo)paramObject).i) && ((k & 0x2) == (m & 0x2)) && (this.j == ((mo)paramObject).j) && ((k & 0x4) == (m & 0x4)) && (this.h == ((mo)paramObject).h) && ((k & 0x8) == (m & 0x8)) && (this.e.equals(((mo)paramObject).e)) && ((this.b & 0x10) == (((mo)paramObject).b & 0x10)) && (this.a.equals(((mo)paramObject).a)) && ((this.b & 0x20) == (((mo)paramObject).b & 0x20)) && (this.f.equals(((mo)paramObject).f)) && ((this.b & 0x40) == (((mo)paramObject).b & 0x40)) && (this.d.equals(((mo)paramObject).d)) && ((this.b & 0x80) == (((mo)paramObject).b & 0x80)) && (this.c.equals(((mo)paramObject).c)) && ((this.b & 0x100) == (((mo)paramObject).b & 0x100)) && (this.g.equals(((mo)paramObject).g)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label310;
          }
          paramObject = ((mo)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label310:
      return this.unknownFieldData.equals(((mo)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.i;
    int i2 = this.j;
    int i3 = this.h;
    int i4 = this.e.hashCode();
    int i5 = this.a.hashCode();
    int i6 = this.f.hashCode();
    int i7 = this.d.hashCode();
    int i8 = this.c.hashCode();
    int i9 = this.g.hashCode();
    d locald = this.unknownFieldData;
    int k = m;
    if (locald != null)
    {
      k = m;
      if (!locald.a()) {
        k = this.unknownFieldData.hashCode();
      }
    }
    return k + ((((((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */