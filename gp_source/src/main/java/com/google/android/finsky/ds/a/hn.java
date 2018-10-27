package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class hn
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  public boolean d = false;
  public String e = "";
  public String f = "";
  private int g = 0;
  
  public hn()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.e);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    j = i;
    if ((this.g & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    i = j;
    if ((this.g & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.c);
    }
    j = i;
    if ((this.g & 0x20) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.g & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    if ((this.g & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    if ((this.g & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof hn))
      {
        paramObject = (hn)paramObject;
        if (((this.g & 0x1) == (((hn)paramObject).g & 0x1)) && (this.f.equals(((hn)paramObject).f)) && ((this.g & 0x2) == (((hn)paramObject).g & 0x2)) && (this.e.equals(((hn)paramObject).e)))
        {
          int i = this.g;
          int j = ((hn)paramObject).g;
          if (((i & 0x4) == (j & 0x4)) && (this.d == ((hn)paramObject).d) && ((i & 0x8) == (j & 0x8)) && (this.a.equals(((hn)paramObject).a)) && ((this.g & 0x10) == (((hn)paramObject).g & 0x10)) && (this.c.equals(((hn)paramObject).c)) && ((this.g & 0x20) == (((hn)paramObject).g & 0x20)) && (this.b.equals(((hn)paramObject).b)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label231;
            }
            paramObject = ((hn)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label231:
      return this.unknownFieldData.equals(((hn)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.f.hashCode();
    int n = this.e.hashCode();
    if (!this.d) {}
    for (int j = 1237;; j = 1231)
    {
      int i1 = this.a.hashCode();
      int i2 = this.c.hashCode();
      int i3 = this.b.hashCode();
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + ((((j + (((k + 527) * 31 + m) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */