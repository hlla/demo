package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.d.bd;

public final class ce
  extends b
{
  private int a = 0;
  private String b = "";
  private String c = "";
  private long d = 0L;
  private bd e = null;
  
  public ce()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.d);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    bd localbd = this.e;
    j = i;
    if (localbd != null) {
      j = i + CodedOutputStream.c(4, localbd);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    bd localbd = this.e;
    if (localbd != null) {
      paramCodedOutputByteBufferNano.a(4, localbd);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ce))
      {
        paramObject = (ce)paramObject;
        int i = this.a;
        int j = ((ce)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((ce)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((ce)paramObject).b)) && ((this.a & 0x4) == (((ce)paramObject).a & 0x4)) && (this.c.equals(((ce)paramObject).c)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label169;
          }
          if (((ce)paramObject).e != null) {}
        }
      }
      label169:
      while (((bb)localObject).equals(((ce)paramObject).e))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ce)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ce)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    long l = this.d;
    int n = this.b.hashCode();
    int i1 = this.c.hashCode();
    Object localObject = this.e;
    int i2 = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i + ((((m + 527) * 31 + i2) * 31 + n) * 31 + i1) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */