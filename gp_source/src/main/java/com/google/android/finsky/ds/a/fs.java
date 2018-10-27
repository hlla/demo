package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class fs
  extends b
{
  public String a = "";
  public String b = "";
  public boolean c = false;
  public String d = "";
  private int e = 0;
  private String f = "";
  
  public fs()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    i = j;
    if ((this.e & 0x10) != 0) {
      i = j + (CodedOutputByteBufferNano.d(40) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    if ((this.e & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof fs))
      {
        paramObject = (fs)paramObject;
        if (((this.e & 0x1) == (((fs)paramObject).e & 0x1)) && (this.f.equals(((fs)paramObject).f)) && ((this.e & 0x2) == (((fs)paramObject).e & 0x2)) && (this.b.equals(((fs)paramObject).b)) && ((this.e & 0x4) == (((fs)paramObject).e & 0x4)) && (this.d.equals(((fs)paramObject).d)) && ((this.e & 0x8) == (((fs)paramObject).e & 0x8)) && (this.a.equals(((fs)paramObject).a)) && ((this.e & 0x10) == (((fs)paramObject).e & 0x10)) && (this.c == ((fs)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label199;
          }
          paramObject = ((fs)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label199:
      return this.unknownFieldData.equals(((fs)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.f.hashCode();
    int n = this.b.hashCode();
    int i1 = this.d.hashCode();
    int i2 = this.a.hashCode();
    if (!this.c) {}
    for (int j = 1237;; j = 1231)
    {
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (j + (((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */