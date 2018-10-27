package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class dd
  extends b
{
  public fb a = null;
  public fb[] b = fb.b();
  public fb c = null;
  
  public dd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.b;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.b;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.d(1, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.a;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(2, (g)localObject);
      }
      localObject = this.c;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(3, (g)localObject);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.b;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof dd))
      {
        paramObject = (dd)paramObject;
        if (f.a(this.b, ((dd)paramObject).b))
        {
          localObject = this.a;
          if (localObject != null) {
            break label124;
          }
          if (((dd)paramObject).a != null) {}
        }
      }
      label124:
      while (((fb)localObject).equals(((dd)paramObject).a))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((dd)paramObject).c != null) {}
        }
        while (((fb)localObject).equals(((dd)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((dd)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((dd)paramObject).unknownFieldData);
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
    int i1 = f.a(this.b);
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((fb)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */