package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class hy
  extends b
{
  private int a = 0;
  private de[] b = de.b();
  private long c = 0L;
  private hk[] d = hk.b();
  private boolean e = false;
  private long f = 0L;
  
  public hy()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    int k = i;
    if ((this.a & 0x2) != 0) {
      k = i + CodedOutputByteBufferNano.f(2, this.f);
    }
    j = k;
    if ((this.a & 0x4) != 0) {
      j = k + CodedOutputByteBufferNano.f(3, this.c);
    }
    Object localObject = this.d;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.d;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = this.b;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.b;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(5, (g)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.f);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.c);
    }
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.b;
      if ((localObject != null) && (localObject.length > 0))
      {
        i = j;
        localObject = this.b;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.b(5, (g)localObject);
          }
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.d;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof hy))
      {
        paramObject = (hy)paramObject;
        int i = this.a;
        int j = ((hy)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.e == ((hy)paramObject).e) && ((i & 0x2) == (j & 0x2)) && (this.f == ((hy)paramObject).f) && ((i & 0x4) == (j & 0x4)) && (this.c == ((hy)paramObject).c) && (f.a(this.b, ((hy)paramObject).b)) && (f.a(this.d, ((hy)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label156;
          }
          paramObject = ((hy)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label156:
      return this.unknownFieldData.equals(((hy)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    if (!this.e) {}
    for (int j = 1237;; j = 1231)
    {
      long l1 = this.f;
      long l2 = this.c;
      int m = (int)(l1 >>> 32 ^ l1);
      int n = (int)(l2 >>> 32 ^ l2);
      int i1 = f.a(this.b);
      int i2 = f.a(this.d);
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (((((j + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */