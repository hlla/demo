package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class my
  extends b
{
  public mx[] a = mx.b();
  public mx[] b = mx.b();
  
  public my()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
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
      }
    }
    localObject = this.b;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.b;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(2, (g)localObject);
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
      if ((localObject != null) && (localObject.length > 0))
      {
        i = j;
        localObject = this.b;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.b(2, (g)localObject);
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
      if ((paramObject instanceof my))
      {
        paramObject = (my)paramObject;
        if ((f.a(this.a, ((my)paramObject).a)) && (f.a(this.b, ((my)paramObject).b)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label81;
          }
          paramObject = ((my)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label81:
      return this.unknownFieldData.equals(((my)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.a);
    int n = f.a(this.b);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((k + 527) * 31 + m) * 31 + n) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/my.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */