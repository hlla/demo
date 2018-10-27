package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class is
  extends b
{
  public int a = 0;
  public by b = null;
  public it c = null;
  public String d = "";
  public String e = "";
  public long f = 0L;
  public it g = null;
  public String h = "";
  private bu i = null;
  
  public is()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((this.a & 0x1) != 0) {
      j = k + CodedOutputByteBufferNano.f(2, this.f);
    }
    k = j;
    if ((this.a & 0x4) != 0) {
      k = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    Object localObject = this.b;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    k = j;
    if ((this.a & 0x8) != 0) {
      k = j + CodedOutputByteBufferNano.b(6, this.e);
    }
    j = k;
    if ((this.a & 0x2) != 0) {
      j = k + CodedOutputByteBufferNano.b(7, this.h);
    }
    localObject = this.i;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    localObject = this.c;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(10, (g)localObject);
    }
    localObject = this.g;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(11, (g)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.f);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.e);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.h);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(10, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(11, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.a & 0x2) != 0;
  }
  
  public final boolean c()
  {
    return (this.a & 0x4) != 0;
  }
  
  public final boolean d()
  {
    return (this.a & 0x8) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof is))
      {
        paramObject = (is)paramObject;
        int j = this.a;
        int k = ((is)paramObject).a;
        if (((j & 0x1) == (k & 0x1)) && (this.f == ((is)paramObject).f) && ((j & 0x2) == (k & 0x2)) && (this.h.equals(((is)paramObject).h)) && ((this.a & 0x4) == (((is)paramObject).a & 0x4)) && (this.d.equals(((is)paramObject).d)))
        {
          localObject = this.i;
          if (localObject != null) {
            break label296;
          }
          if (((is)paramObject).i != null) {}
        }
      }
      label268:
      label296:
      while (((bu)localObject).equals(((is)paramObject).i))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((is)paramObject).b != null) {}
        }
        while (((by)localObject).equals(((is)paramObject).b))
        {
          if (((this.a & 0x8) == (((is)paramObject).a & 0x8)) && (this.e.equals(((is)paramObject).e)))
          {
            localObject = this.c;
            if (localObject != null) {
              break label268;
            }
            if (((is)paramObject).c != null) {}
          }
          while (((it)localObject).equals(((is)paramObject).c))
          {
            localObject = this.g;
            if (localObject == null) {
              if (((is)paramObject).g != null) {}
            }
            while (((it)localObject).equals(((is)paramObject).g))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a()))
              {
                paramObject = ((is)paramObject).unknownFieldData;
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((is)paramObject).unknownFieldData);
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    long l = this.f;
    int i4 = this.h.hashCode();
    int i5 = this.d.hashCode();
    Object localObject = this.i;
    int i6 = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int j = ((bu)localObject).hashCode();; j = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int k = ((by)localObject).hashCode();; k = 0)
      {
        int i7 = this.e.hashCode();
        localObject = this.c;
        if (localObject != null) {}
        for (int m = ((it)localObject).hashCode();; m = 0)
        {
          localObject = this.g;
          if (localObject != null) {}
          for (int n = ((it)localObject).hashCode();; n = 0)
          {
            localObject = this.unknownFieldData;
            int i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (!((d)localObject).a()) {
                i1 = this.unknownFieldData.hashCode();
              }
            }
            return (n + (m + ((k + (j + ((((i3 + 527) * 31 + i6) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + i7) * 31) * 31) * 31 + i1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */