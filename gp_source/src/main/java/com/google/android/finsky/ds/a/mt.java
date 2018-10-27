package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class mt
  extends b
{
  private static volatile mt[] d;
  public int a = 0;
  public mu b = null;
  public int c = 0;
  
  public mt()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 13))
    {
      StringBuilder localStringBuilder = new StringBuilder(36);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum Type");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  private final mt b(a parama)
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
      case 18: 
        if (this.b == null) {
          this.b = new mu();
        }
        parama.a(this.b);
        break;
      case 8: 
        this.a |= 0x1;
        int j = parama.j();
        try
        {
          this.c = a(parama.e());
          this.a |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
      }
    }
  }
  
  public static mt[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new mt[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    mu localmu = this.b;
    j = i;
    if (localmu != null) {
      j = i + CodedOutputByteBufferNano.d(2, localmu);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    mu localmu = this.b;
    if (localmu != null) {
      paramCodedOutputByteBufferNano.b(2, localmu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof mt))
      {
        paramObject = (mt)paramObject;
        if (((this.a & 0x1) == (((mt)paramObject).a & 0x1)) && (this.c == ((mt)paramObject).c))
        {
          localObject = this.b;
          if (localObject != null) {
            break label107;
          }
          if (((mt)paramObject).b != null) {}
        }
      }
      label107:
      while (((mu)localObject).equals(((mt)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((mt)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((mt)paramObject).unknownFieldData);
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
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((mu)localObject).hashCode();; i = 0)
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
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */