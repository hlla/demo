package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class lf
  extends b
{
  private static volatile lf[] a;
  private int b = 0;
  private long c = 0L;
  private long d = 0L;
  private int e = 0;
  
  public lf()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final lf b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 24: 
        this.d = parama.f();
        this.b |= 0x4;
        break;
      case 16: 
        this.c = parama.f();
        this.b |= 0x2;
        break;
      case 8: 
        this.b |= 0x1;
        int j = parama.j();
        try
        {
          this.e = li.a(parama.e());
          this.b |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
      }
    }
  }
  
  public static lf[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new lf[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.e);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.c);
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.f(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.c);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof lf))
      {
        paramObject = (lf)paramObject;
        int i = this.b;
        int j = ((lf)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.e == ((lf)paramObject).e) && ((i & 0x2) == (j & 0x2)) && (this.c == ((lf)paramObject).c) && ((i & 0x4) == (j & 0x4)) && (this.d == ((lf)paramObject).d))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label128;
          }
          paramObject = ((lf)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label128:
      return this.unknownFieldData.equals(((lf)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e;
    long l1 = this.c;
    long l2 = this.d;
    int n = (int)(l1 >>> 32 ^ l1);
    int i1 = (int)(l2 >>> 32 ^ l2);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */