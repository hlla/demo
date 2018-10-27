package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class kv
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 200;
  public String e = "";
  private int f = 0;
  
  public kv()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.d(4, this.d);
    }
    i = j;
    if ((this.f & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(6, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.f & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kv))
      {
        paramObject = (kv)paramObject;
        if (((this.f & 0x1) == (((kv)paramObject).f & 0x1)) && (this.e.equals(((kv)paramObject).e)) && ((this.f & 0x2) == (((kv)paramObject).f & 0x2)) && (this.c.equals(((kv)paramObject).c)) && ((this.f & 0x4) == (((kv)paramObject).f & 0x4)) && (this.b.equals(((kv)paramObject).b)))
        {
          int i = this.f;
          int j = ((kv)paramObject).f;
          if (((i & 0x8) == (j & 0x8)) && (this.d == ((kv)paramObject).d) && ((i & 0x10) == (j & 0x10)) && (this.a.equals(((kv)paramObject).a)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label200;
            }
            paramObject = ((kv)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label200:
      return this.unknownFieldData.equals(((kv)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e.hashCode();
    int n = this.c.hashCode();
    int i1 = this.b.hashCode();
    int i2 = this.d;
    int i3 = this.a.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */