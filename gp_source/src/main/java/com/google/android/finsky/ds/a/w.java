package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class w
  extends b
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public boolean d = false;
  
  public w()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof w))
      {
        paramObject = (w)paramObject;
        if (((this.a & 0x1) == (((w)paramObject).a & 0x1)) && (this.b.equals(((w)paramObject).b)) && ((this.a & 0x2) == (((w)paramObject).a & 0x2)) && (this.c.equals(((w)paramObject).c)) && ((this.a & 0x4) == (((w)paramObject).a & 0x4)) && (this.d == ((w)paramObject).d))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label137;
          }
          paramObject = ((w)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label137:
      return this.unknownFieldData.equals(((w)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.b.hashCode();
    int n = this.c.hashCode();
    if (!this.d) {}
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
        return i + (j + (((k + 527) * 31 + m) * 31 + n) * 31) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */