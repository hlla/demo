package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class lt
  extends b
{
  public ct a = null;
  public ja[] b = ja.b();
  private ct c = null;
  
  public lt()
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
            j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(5, (g)localObject);
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
        paramCodedOutputByteBufferNano.b(4, (g)localObject);
      }
      localObject = this.c;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(5, (g)localObject);
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
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lt))
      {
        paramObject = (lt)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label124;
        }
        if (((lt)paramObject).a != null) {}
      }
      label124:
      while (((ct)localObject).equals(((lt)paramObject).a))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((lt)paramObject).c != null) {}
        }
        while (((ct)localObject).equals(((lt)paramObject).c))
        {
          if (f.a(this.b, ((lt)paramObject).b))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((lt)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((lt)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((ct)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((ct)localObject).hashCode();; j = 0)
      {
        int i1 = f.a(this.b);
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */