package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class gy
  extends b
{
  public String a = "";
  public String b = "";
  public fb c = null;
  public de d = null;
  public String e = "";
  private int f = 0;
  private long g = 0L;
  
  public gy()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.g);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.d;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.e);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.g);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.f & 0x2) != 0;
  }
  
  public final boolean c()
  {
    return (this.f & 0x4) != 0;
  }
  
  public final boolean d()
  {
    return (this.f & 0x8) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gy))
      {
        paramObject = (gy)paramObject;
        int i = this.f;
        int j = ((gy)paramObject).f;
        if (((i & 0x1) == (j & 0x1)) && (this.g == ((gy)paramObject).g) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((gy)paramObject).b)) && ((this.f & 0x4) == (((gy)paramObject).f & 0x4)) && (this.a.equals(((gy)paramObject).a)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label232;
          }
          if (((gy)paramObject).c != null) {}
        }
      }
      label232:
      while (((fb)localObject).equals(((gy)paramObject).c))
      {
        localObject = this.d;
        if (localObject == null) {
          if (((gy)paramObject).d != null) {}
        }
        while (((de)localObject).equals(((gy)paramObject).d))
        {
          if (((this.f & 0x8) == (((gy)paramObject).f & 0x8)) && (this.e.equals(((gy)paramObject).e)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((gy)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((gy)paramObject).unknownFieldData);
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
    long l = this.g;
    int i1 = this.b.hashCode();
    int i2 = this.a.hashCode();
    Object localObject = this.c;
    int i3 = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      localObject = this.d;
      if (localObject != null) {}
      for (int j = ((de)localObject).hashCode();; j = 0)
      {
        int i4 = this.e.hashCode();
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((j + (i + ((((n + 527) * 31 + i3) * 31 + i1) * 31 + i2) * 31) * 31) * 31 + i4) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */