package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class c
  extends b
{
  private as[] a = as.b();
  private de b = null;
  private de[] c = de.b();
  
  public c()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int i = super.a();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.a;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(1, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.c;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.c;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    Object localObject = this.a;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.b;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(2, (g)localObject);
      }
      localObject = this.c;
      if ((localObject != null) && (localObject.length > 0))
      {
        i = j;
        localObject = this.c;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.b(4, (g)localObject);
          }
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.a;
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
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (f.a(this.a, ((c)paramObject).a))
        {
          localObject = this.b;
          if (localObject != null) {
            break label109;
          }
          if (((c)paramObject).b != null) {}
        }
      }
      label109:
      while (((de)localObject).equals(((c)paramObject).b))
      {
        if (f.a(this.c, ((c)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((c)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((c)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = f.a(this.a);
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((de)localObject).hashCode();; i = 0)
    {
      int i1 = f.a(this.c);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */