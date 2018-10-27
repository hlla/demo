package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class at
  extends b
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public String d = "";
  public String e = "";
  private int f = 0;
  private String g = "";
  
  public at()
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
      j = i + CodedOutputByteBufferNano.b(2, this.g);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    i = j;
    if ((this.f & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.d);
    }
    j = i;
    if ((this.f & 0x20) != 0) {
      j = i + CodedOutputByteBufferNano.d(6, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.g);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    if ((this.f & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    if ((this.f & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof at))
      {
        paramObject = (at)paramObject;
        if (((this.f & 0x1) == (((at)paramObject).f & 0x1)) && (this.e.equals(((at)paramObject).e)) && ((this.f & 0x2) == (((at)paramObject).f & 0x2)) && (this.g.equals(((at)paramObject).g)) && ((this.f & 0x4) == (((at)paramObject).f & 0x4)) && (this.b.equals(((at)paramObject).b)) && ((this.f & 0x8) == (((at)paramObject).f & 0x8)) && (this.a.equals(((at)paramObject).a)) && ((this.f & 0x10) == (((at)paramObject).f & 0x10)) && (this.d.equals(((at)paramObject).d)) && ((this.f & 0x20) == (((at)paramObject).f & 0x20)) && (this.c == ((at)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label230;
          }
          paramObject = ((at)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label230:
      return this.unknownFieldData.equals(((at)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e.hashCode();
    int n = this.g.hashCode();
    int i1 = this.b.hashCode();
    int i2 = this.a.hashCode();
    int i3 = this.d.hashCode();
    int i4 = this.c;
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */