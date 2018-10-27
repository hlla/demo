package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class dx
  extends b
{
  private static volatile dx[] a;
  private boolean[] b = j.a;
  private double[] c = j.d;
  private long[] d = j.g;
  private String[] e = j.h;
  private dw f = null;
  
  public dx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static dx[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new dx[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i2 = 0;
    int j = super.a();
    Object localObject = this.f;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.e;
    int k;
    int m;
    if (localObject != null) {
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        m = 0;
        localObject = this.e;
        if (j >= localObject.length) {
          i = i + k + m;
        }
      }
    }
    for (;;)
    {
      localObject = this.d;
      j = i;
      if (localObject != null)
      {
        j = i;
        if (localObject.length > 0)
        {
          k = 0;
          j = i2;
          for (;;)
          {
            localObject = this.d;
            m = localObject.length;
            if (j >= m) {
              break;
            }
            k += CodedOutputByteBufferNano.b(localObject[j]);
            j += 1;
          }
          j = k + i + m;
        }
      }
      localObject = this.b;
      i = j;
      if (localObject != null)
      {
        k = localObject.length;
        i = j;
        if (k > 0) {
          i = j + k + k;
        }
      }
      localObject = this.c;
      j = i;
      if (localObject != null)
      {
        k = localObject.length;
        j = i;
        if (k > 0) {
          j = i + k * 8 + k;
        }
      }
      return j;
      localObject = localObject[j];
      int i1 = k;
      int n = m;
      if (localObject != null)
      {
        n = m + 1;
        i1 = k + CodedOutputByteBufferNano.a((String)localObject);
      }
      j += 1;
      k = i1;
      m = n;
      break;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.e;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.d;
      if ((localObject == null) || (localObject.length <= 0))
      {
        localObject = this.b;
        if ((localObject == null) || (localObject.length <= 0))
        {
          localObject = this.c;
          if ((localObject != null) && (localObject.length > 0))
          {
            i = j;
            for (;;)
            {
              localObject = this.c;
              if (i >= localObject.length) {
                break;
              }
              paramCodedOutputByteBufferNano.a(5, localObject[i]);
              i += 1;
            }
          }
          super.a(paramCodedOutputByteBufferNano);
          return;
        }
        i = 0;
        for (;;)
        {
          localObject = this.b;
          if (i >= localObject.length) {
            break;
          }
          paramCodedOutputByteBufferNano.a(4, localObject[i]);
          i += 1;
        }
      }
      i = 0;
      for (;;)
      {
        localObject = this.d;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.b(3, localObject[i]);
        i += 1;
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
      paramCodedOutputByteBufferNano.a(2, (String)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof dx))
      {
        paramObject = (dx)paramObject;
        localObject = this.f;
        if (localObject != null) {
          break label137;
        }
        if (((dx)paramObject).f != null) {}
      }
      label137:
      while (((dw)localObject).equals(((dx)paramObject).f))
      {
        if ((f.a(this.e, ((dx)paramObject).e)) && (f.a(this.d, ((dx)paramObject).d)) && (f.a(this.b, ((dx)paramObject).b)) && (f.a(this.c, ((dx)paramObject).c)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((dx)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((dx)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.f;
    if (localObject != null) {}
    for (int i = ((dw)localObject).hashCode();; i = 0)
    {
      int n = f.a(this.e);
      int i1 = f.a(this.d);
      int i2 = f.a(this.b);
      int i3 = f.a(this.c);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */