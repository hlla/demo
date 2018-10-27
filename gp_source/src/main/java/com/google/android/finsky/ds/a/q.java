package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class q
  extends b
{
  public bp[] a = bp.b();
  public bp[] b = bp.b();
  public bp[] c = bp.b();
  public bp[] d = bp.b();
  public bp[] e = bp.b();
  public bp[] f = bp.b();
  
  public q()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int i = super.a();
    Object localObject = this.b;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
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
    localObject = this.e;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.e;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + CodedOutputByteBufferNano.d(2, (g)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = this.f;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.f;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.d(3, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.d;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.d;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = this.a;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.a;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.d(5, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.c;
    int k = j;
    if (localObject != null)
    {
      k = j;
      if (localObject.length > 0)
      {
        i = m;
        for (;;)
        {
          localObject = this.c;
          k = j;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          k = j;
          if (localObject != null) {
            k = j + CodedOutputByteBufferNano.d(6, (g)localObject);
          }
          i += 1;
          j = k;
        }
      }
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.e;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        localObject = this.f;
        if ((localObject == null) || (localObject.length <= 0)) {}
        do
        {
          localObject = this.d;
          if ((localObject == null) || (localObject.length <= 0)) {}
          do
          {
            localObject = this.a;
            if ((localObject == null) || (localObject.length <= 0)) {}
            do
            {
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
                    paramCodedOutputByteBufferNano.b(6, (g)localObject);
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
              paramCodedOutputByteBufferNano.b(5, (g)localObject);
            }
            i = 0;
            localObject = this.d;
          } while (i >= localObject.length);
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.b(4, (g)localObject);
          }
          i = 0;
          localObject = this.f;
        } while (i >= localObject.length);
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.b(3, (g)localObject);
        }
        i = 0;
        localObject = this.e;
      } while (i >= localObject.length);
      localObject = localObject[i];
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramCodedOutputByteBufferNano.b(2, (g)localObject);
      }
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
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((f.a(this.b, ((q)paramObject).b)) && (f.a(this.e, ((q)paramObject).e)) && (f.a(this.f, ((q)paramObject).f)) && (f.a(this.d, ((q)paramObject).d)) && (f.a(this.a, ((q)paramObject).a)) && (f.a(this.c, ((q)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label137;
          }
          paramObject = ((q)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label137:
      return this.unknownFieldData.equals(((q)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.b);
    int n = f.a(this.e);
    int i1 = f.a(this.f);
    int i2 = f.a(this.d);
    int i3 = f.a(this.a);
    int i4 = f.a(this.c);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */