package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class id
  extends b
{
  private static volatile id[] h;
  public String a = "";
  public long b = 0L;
  public long c = 0L;
  public byte[] d = j.b;
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  private int i = 0;
  
  public id()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static id[] b()
  {
    if (h == null) {}
    synchronized (f.a)
    {
      if (h == null) {
        h = new id[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((this.i & 0x1) != 0) {
      j = k + CodedOutputByteBufferNano.b(1, this.g);
    }
    k = j;
    if ((this.i & 0x2) != 0) {
      k = j + CodedOutputByteBufferNano.b(2, this.d);
    }
    j = k;
    if ((this.i & 0x4) != 0) {
      j = k + CodedOutputByteBufferNano.b(3, this.a);
    }
    k = j;
    if ((this.i & 0x8) != 0) {
      k = j + CodedOutputByteBufferNano.f(4, this.f);
    }
    j = k;
    if ((this.i & 0x10) != 0) {
      j = k + CodedOutputByteBufferNano.f(5, this.e);
    }
    k = j;
    if ((this.i & 0x20) != 0) {
      k = j + CodedOutputByteBufferNano.f(6, this.c);
    }
    j = k;
    if ((this.i & 0x40) != 0) {
      j = k + CodedOutputByteBufferNano.f(7, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.i & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.g);
    }
    if ((this.i & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.i & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.i & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.f);
    }
    if ((this.i & 0x10) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.e);
    }
    if ((this.i & 0x20) != 0) {
      paramCodedOutputByteBufferNano.b(6, this.c);
    }
    if ((this.i & 0x40) != 0) {
      paramCodedOutputByteBufferNano.b(7, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof id))
      {
        paramObject = (id)paramObject;
        if (((this.i & 0x1) == (((id)paramObject).i & 0x1)) && (this.g.equals(((id)paramObject).g)) && ((this.i & 0x2) == (((id)paramObject).i & 0x2)) && (Arrays.equals(this.d, ((id)paramObject).d)) && ((this.i & 0x4) == (((id)paramObject).i & 0x4)) && (this.a.equals(((id)paramObject).a)))
        {
          int j = this.i;
          int k = ((id)paramObject).i;
          if (((j & 0x8) == (k & 0x8)) && (this.f == ((id)paramObject).f) && ((j & 0x10) == (k & 0x10)) && (this.e == ((id)paramObject).e) && ((j & 0x20) == (k & 0x20)) && (this.c == ((id)paramObject).c) && ((j & 0x40) == (k & 0x40)) && (this.b == ((id)paramObject).b))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label245;
            }
            paramObject = ((id)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label245:
      return this.unknownFieldData.equals(((id)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.g.hashCode();
    int i1 = Arrays.hashCode(this.d);
    int i2 = this.a.hashCode();
    long l1 = this.f;
    long l2 = this.e;
    long l3 = this.c;
    long l4 = this.b;
    int i3 = (int)(l1 >>> 32 ^ l1);
    int i4 = (int)(l2 >>> 32 ^ l2);
    int i5 = (int)(l3 >>> 32 ^ l3);
    int i6 = (int)(l4 >>> 32 ^ l4);
    d locald = this.unknownFieldData;
    int j = k;
    if (locald != null)
    {
      j = k;
      if (!locald.a()) {
        j = this.unknownFieldData.hashCode();
      }
    }
    return j + ((((((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */