package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ay
  extends b
{
  public String a = "";
  public boolean b = false;
  private int c = 0;
  
  public ay()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.c & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ay))
      {
        paramObject = (ay)paramObject;
        if (((this.c & 0x1) == (((ay)paramObject).c & 0x1)) && (this.a.equals(((ay)paramObject).a)) && ((this.c & 0x2) == (((ay)paramObject).c & 0x2)) && (this.b == ((ay)paramObject).b))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label108;
          }
          paramObject = ((ay)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label108:
      return this.unknownFieldData.equals(((ay)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    if (!this.b) {}
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
        return i + (j + ((k + 527) * 31 + m) * 31) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */