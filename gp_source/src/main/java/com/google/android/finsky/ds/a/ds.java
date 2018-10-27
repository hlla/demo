package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ds
  extends b
{
  private static volatile ds[] h;
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public hr d = null;
  public long e = 0L;
  public String f = "";
  public int g = 0;
  
  public ds()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ds b(a parama)
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
      case 50: 
        if (this.d == null) {
          this.d = new hr();
        }
        parama.a(this.d);
        break;
      case 40: 
        this.b = parama.f();
        this.a |= 0x8;
        break;
      case 34: 
        this.f = parama.c();
        this.a |= 0x10;
        break;
      case 24: 
        this.e = parama.f();
        this.a |= 0x4;
        break;
      case 16: 
        this.g = parama.e();
        this.a |= 0x2;
        break;
      case 8: 
        this.a |= 0x1;
        int j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(40);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum FileType");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 3);
        this.c = k;
        this.a |= 0x1;
      }
    }
  }
  
  public static ds[] b()
  {
    if (h == null) {}
    synchronized (f.a)
    {
      if (h == null) {
        h = new ds[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.g);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.f(3, this.e);
    }
    j = i;
    if ((this.a & 0x10) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.f);
    }
    i = j;
    if ((this.a & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.f(5, this.b);
    }
    hr localhr = this.d;
    j = i;
    if (localhr != null) {
      j = i + CodedOutputByteBufferNano.d(6, localhr);
    }
    return j;
  }
  
  public final ds a(int paramInt)
  {
    this.c = paramInt;
    this.a |= 0x1;
    return this;
  }
  
  public final ds a(long paramLong)
  {
    this.a |= 0x4;
    this.e = paramLong;
    return this;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.g);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.e);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.b);
    }
    hr localhr = this.d;
    if (localhr != null) {
      paramCodedOutputByteBufferNano.b(6, localhr);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final ds b(int paramInt)
  {
    this.a |= 0x2;
    this.g = paramInt;
    return this;
  }
  
  public final ds b(long paramLong)
  {
    this.a |= 0x8;
    this.b = paramLong;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ds))
      {
        paramObject = (ds)paramObject;
        int i = this.a;
        int j = ((ds)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.c == ((ds)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.g == ((ds)paramObject).g) && ((i & 0x4) == (j & 0x4)) && (this.e == ((ds)paramObject).e) && ((i & 0x8) == (j & 0x8)) && (this.b == ((ds)paramObject).b))
        {
          localObject = this.d;
          if (localObject != null) {
            break label211;
          }
          if (((ds)paramObject).d != null) {}
        }
      }
      label211:
      while (((hr)localObject).equals(((ds)paramObject).d))
      {
        if (((this.a & 0x10) == (((ds)paramObject).a & 0x10)) && (this.f.equals(((ds)paramObject).f)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ds)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ds)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c;
    int i1 = this.g;
    long l1 = this.e;
    long l2 = this.b;
    Object localObject = this.d;
    int i2 = (int)(l1 >>> 32 ^ l1);
    int i3 = (int)(l2 >>> 32 ^ l2);
    if (localObject != null) {}
    for (int i = ((hr)localObject).hashCode();; i = 0)
    {
      int i4 = this.f.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + (((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */