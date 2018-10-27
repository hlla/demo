package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class cq
  extends b
{
  private static volatile cq[] d;
  public boolean a = false;
  public int b = 0;
  public String c = "";
  private int e = 0;
  private boolean f = false;
  private int g = 0;
  
  public cq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static cq[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new cq[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.g);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
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
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.g);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    if ((this.e & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean c()
  {
    return (this.e & 0x10) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof cq))
      {
        paramObject = (cq)paramObject;
        if (((this.e & 0x1) == (((cq)paramObject).e & 0x1)) && (this.c.equals(((cq)paramObject).c)))
        {
          int i = this.e;
          int j = ((cq)paramObject).e;
          if (((i & 0x2) == (j & 0x2)) && (this.b == ((cq)paramObject).b) && ((i & 0x4) == (j & 0x4)) && (this.g == ((cq)paramObject).g) && ((i & 0x8) == (j & 0x8)) && (this.f == ((cq)paramObject).f) && ((i & 0x10) == (j & 0x10)) && (this.a == ((cq)paramObject).a))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label179;
            }
            paramObject = ((cq)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label179:
      return this.unknownFieldData.equals(((cq)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 1237;
    int m = getClass().getName().hashCode();
    int n = this.c.hashCode();
    int i1 = this.b;
    int i2 = this.g;
    if (!this.f) {}
    for (int j = 1237;; j = 1231)
    {
      if (!this.a) {}
      for (;;)
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
          return i + ((j + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + k) * 31;
          i = 0;
          continue;
          i = 0;
        }
        k = 1231;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */