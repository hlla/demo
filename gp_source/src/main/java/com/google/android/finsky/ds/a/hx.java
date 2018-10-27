package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class hx
  extends b
{
  public kw a = null;
  public hw b = null;
  public id[] c = id.b();
  private kx d = null;
  
  public hx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static hx a(byte[] paramArrayOfByte)
  {
    return (hx)g.a(new hx(), paramArrayOfByte);
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.b;
    int j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(3, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.d;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.c;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(4, (g)localObject);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.c;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hx))
      {
        paramObject = (hx)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label153;
        }
        if (((hx)paramObject).b != null) {}
      }
      label127:
      label153:
      while (((hw)localObject).equals(((hx)paramObject).b))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((hx)paramObject).a != null) {}
        }
        while (((kw)localObject).equals(((hx)paramObject).a))
        {
          if (f.a(this.c, ((hx)paramObject).c))
          {
            localObject = this.d;
            if (localObject != null) {
              break label127;
            }
            if (((hx)paramObject).d != null) {}
          }
          while (((kx)localObject).equals(((hx)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((hx)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((hx)paramObject).unknownFieldData);
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
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((hw)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((kw)localObject).hashCode();; j = 0)
      {
        int i2 = f.a(this.c);
        localObject = this.d;
        if (localObject != null) {}
        for (int k = ((kx)localObject).hashCode();; k = 0)
        {
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return (k + ((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */