package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.x;

public final class bt
  extends b
{
  private int a = 0;
  private long b = 0L;
  private bp c = null;
  private int d = 1;
  private int e;
  private Integer f;
  
  public bt()
  {
    if (x.a != null) {}
    for (Integer localInteger = Integer.valueOf(x.a.b);; localInteger = null)
    {
      this.f = localInteger;
      this.e = 0;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  private final bt b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      int j;
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 40: 
        this.e = parama.e();
        this.a |= 0x8;
        break;
      case 32: 
        this.a |= 0x4;
        j = parama.j();
        int k = parama.e();
        switch (k)
        {
        default: 
          parama.e(j);
          a(parama, i);
          break;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          this.f = Integer.valueOf(k);
          this.a |= 0x4;
        }
        break;
      case 24: 
        this.a |= 0x2;
        j = parama.j();
        try
        {
          this.d = cb.a(parama.e());
          this.a |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 18: 
        if (this.c == null) {
          this.c = new bp();
        }
        parama.a(this.c);
        break;
      case 9: 
        this.b = parama.h();
        this.a |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 8);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.d);
    }
    j = i;
    if ((this.a & 0x4) != 0)
    {
      localObject = this.f;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(4, ((Integer)localObject).intValue());
      }
    }
    i = j;
    if ((this.a & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.d(5, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.c(1, this.b);
    }
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.a & 0x4) != 0)
    {
      localObject = this.f;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(4, ((Integer)localObject).intValue());
      }
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bt))
      {
        paramObject = (bt)paramObject;
        if (((this.a & 0x1) == (((bt)paramObject).a & 0x1)) && (this.b == ((bt)paramObject).b))
        {
          localObject = this.c;
          if (localObject != null) {
            break label185;
          }
          if (((bt)paramObject).c != null) {}
        }
      }
      label185:
      while (((bp)localObject).equals(((bt)paramObject).c))
      {
        int i = this.a;
        int j = ((bt)paramObject).a;
        if (((i & 0x2) == (j & 0x2)) && (this.d == ((bt)paramObject).d) && ((i & 0x4) == (j & 0x4)) && (this.f == ((bt)paramObject).f) && ((i & 0x8) == (j & 0x8)) && (this.e == ((bt)paramObject).e))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((bt)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bt)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int j = getClass().getName().hashCode();
    long l = this.b;
    Object localObject = this.c;
    int m = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      j = (i + ((j + 527) * 31 + m) * 31) * 31 + this.d;
      localObject = this.f;
      i = j;
      if (localObject != null) {
        i = j * 31 + ((Integer)localObject).intValue();
      }
      m = this.e;
      localObject = this.unknownFieldData;
      j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i * 31 + m) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */