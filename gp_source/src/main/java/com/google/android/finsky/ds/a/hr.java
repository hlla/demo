package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class hr
  extends b
{
  public int a = 0;
  public int b = 0;
  public long c = 0L;
  
  public hr()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.a);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof hr))
      {
        paramObject = (hr)paramObject;
        int i = this.b;
        int j = ((hr)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.a == ((hr)paramObject).a) && ((i & 0x2) == (j & 0x2)) && (this.c == ((hr)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label107;
          }
          paramObject = ((hr)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label107:
      return this.unknownFieldData.equals(((hr)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a;
    long l = this.c;
    int n = (int)(l >>> 32 ^ l);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((k + 527) * 31 + m) * 31 + n) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */