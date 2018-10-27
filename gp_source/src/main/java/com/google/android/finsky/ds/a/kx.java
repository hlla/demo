package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class kx
  extends b
{
  public int a = 0;
  public long b = 0L;
  
  public kx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kx))
      {
        paramObject = (kx)paramObject;
        if (((this.a & 0x1) == (((kx)paramObject).a & 0x1)) && (this.b == ((kx)paramObject).b))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label80;
          }
          paramObject = ((kx)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label80:
      return this.unknownFieldData.equals(((kx)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    long l = this.b;
    int m = (int)(l ^ l >>> 32);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((k + 527) * 31 + m) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */