package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class t
  extends b
{
  public bp a = null;
  public int b = 0;
  public long c = 0L;
  public long d = 0L;
  
  public t()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bp localbp = this.a;
    int i = j;
    if (localbp != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbp);
    }
    j = i;
    if ((this.b & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.f(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bp localbp = this.a;
    if (localbp != null) {
      paramCodedOutputByteBufferNano.b(1, localbp);
    }
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label138;
        }
        if (((t)paramObject).a != null) {}
      }
      label138:
      while (((bp)localObject).equals(((t)paramObject).a))
      {
        int i = this.b;
        int j = ((t)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.c == ((t)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.d == ((t)paramObject).d))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((t)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((t)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      long l1 = this.c;
      long l2 = this.d;
      int n = (int)(l1 >>> 32 ^ l1);
      int i1 = (int)(l2 >>> 32 ^ l2);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */