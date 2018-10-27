package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class iz
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  private int e = 0;
  
  public iz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.d);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.e & 0x2) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof iz))
      {
        paramObject = (iz)paramObject;
        if (((this.e & 0x1) == (((iz)paramObject).e & 0x1)) && (this.d.equals(((iz)paramObject).d)) && ((this.e & 0x2) == (((iz)paramObject).e & 0x2)) && (this.a.equals(((iz)paramObject).a)) && ((this.e & 0x4) == (((iz)paramObject).e & 0x4)) && (this.c.equals(((iz)paramObject).c)) && ((this.e & 0x8) == (((iz)paramObject).e & 0x8)) && (this.b.equals(((iz)paramObject).b)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label171;
          }
          paramObject = ((iz)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label171:
      return this.unknownFieldData.equals(((iz)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.d.hashCode();
    int n = this.a.hashCode();
    int i1 = this.c.hashCode();
    int i2 = this.b.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */