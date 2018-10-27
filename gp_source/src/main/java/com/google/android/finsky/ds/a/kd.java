package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class kd
  extends b
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public int d = 0;
  private int e = 0;
  
  public kd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.b);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.d);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kd))
      {
        paramObject = (kd)paramObject;
        int i = this.e;
        int j = ((kd)paramObject).e;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((kd)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.c == ((kd)paramObject).c) && ((i & 0x4) == (j & 0x4)) && (this.d == ((kd)paramObject).d) && ((i & 0x8) == (j & 0x8)) && (this.a.equals(((kd)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label151;
          }
          paramObject = ((kd)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label151:
      return this.unknownFieldData.equals(((kd)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.b;
    int n = this.c;
    int i1 = this.d;
    int i2 = this.a.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */