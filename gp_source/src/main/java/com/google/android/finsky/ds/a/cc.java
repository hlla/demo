package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.d.bd;

public final class cc
  extends b
{
  private bd a = null;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private long e = 0L;
  private bd f = null;
  
  public cc()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    bd localbd = this.f;
    i = j;
    if (localbd != null) {
      i = j + CodedOutputStream.c(3, localbd);
    }
    localbd = this.a;
    j = i;
    if (localbd != null) {
      j = i + CodedOutputStream.c(4, localbd);
    }
    i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(5, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    bd localbd = this.f;
    if (localbd != null) {
      paramCodedOutputByteBufferNano.a(3, localbd);
    }
    localbd = this.a;
    if (localbd != null) {
      paramCodedOutputByteBufferNano.a(4, localbd);
    }
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cc))
      {
        paramObject = (cc)paramObject;
        localObject = this.f;
        if (localObject != null) {
          break label189;
        }
        if (((cc)paramObject).f != null) {}
      }
      label189:
      while (((bb)localObject).equals(((cc)paramObject).f))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((cc)paramObject).a != null) {}
        }
        while (((bb)localObject).equals(((cc)paramObject).a))
        {
          int i = this.b;
          int j = ((cc)paramObject).b;
          if (((i & 0x1) == (j & 0x1)) && (this.e == ((cc)paramObject).e) && ((i & 0x2) == (j & 0x2)) && (this.d == ((cc)paramObject).d) && ((i & 0x4) == (j & 0x4)) && (this.c == ((cc)paramObject).c))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((cc)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((cc)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    Object localObject = this.f;
    if (localObject != null) {}
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((bb)localObject).hashCode();; j = 0)
      {
        long l = this.e;
        int i1 = (int)(l >>> 32 ^ l);
        int i2 = this.d;
        int i3 = this.c;
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */