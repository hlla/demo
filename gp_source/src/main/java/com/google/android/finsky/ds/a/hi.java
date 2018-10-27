package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class hi
  extends b
{
  private static volatile hi[] d;
  public int a = 0;
  public int b = 0;
  public String c = "";
  
  public hi()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final hi b(a parama)
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
      case 16: 
        this.a |= 0x2;
        int j = parama.j();
        try
        {
          this.b = hh.a(parama.e());
          this.a |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 10: 
        this.c = parama.c();
        this.a |= 0x1;
      }
    }
  }
  
  public static hi[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new hi[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof hi))
      {
        paramObject = (hi)paramObject;
        if (((this.a & 0x1) == (((hi)paramObject).a & 0x1)) && (this.c.equals(((hi)paramObject).c)) && ((this.a & 0x2) == (((hi)paramObject).a & 0x2)) && (this.b == ((hi)paramObject).b))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label108;
          }
          paramObject = ((hi)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label108:
      return this.unknownFieldData.equals(((hi)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.c.hashCode();
    int n = this.b;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */