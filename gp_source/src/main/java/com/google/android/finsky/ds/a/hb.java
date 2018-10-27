package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class hb
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  private int e = 0;
  private String f = "";
  
  public hb()
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
      j = i + CodedOutputByteBufferNano.b(2, this.f);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    i = j;
    if ((this.e & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    if ((this.e & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof hb))
      {
        paramObject = (hb)paramObject;
        if (((this.e & 0x1) == (((hb)paramObject).e & 0x1)) && (this.d.equals(((hb)paramObject).d)) && ((this.e & 0x2) == (((hb)paramObject).e & 0x2)) && (this.f.equals(((hb)paramObject).f)) && ((this.e & 0x4) == (((hb)paramObject).e & 0x4)) && (this.c.equals(((hb)paramObject).c)) && ((this.e & 0x8) == (((hb)paramObject).e & 0x8)) && (this.a.equals(((hb)paramObject).a)) && ((this.e & 0x10) == (((hb)paramObject).e & 0x10)) && (this.b.equals(((hb)paramObject).b)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label202;
          }
          paramObject = ((hb)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label202:
      return this.unknownFieldData.equals(((hb)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.d.hashCode();
    int n = this.f.hashCode();
    int i1 = this.c.hashCode();
    int i2 = this.a.hashCode();
    int i3 = this.b.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */