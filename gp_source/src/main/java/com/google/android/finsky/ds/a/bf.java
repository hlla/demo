package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;

public final class bf
  extends b
{
  private static volatile bf[] b;
  public String[] a = j.h;
  
  public bf()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static bf[] b()
  {
    if (b == null) {}
    synchronized (f.a)
    {
      if (b == null) {
        b = new bf[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int i = 0;
    int i1 = super.a();
    Object localObject = this.a;
    if (localObject != null)
    {
      if (localObject.length > 0)
      {
        int j = 0;
        int m;
        for (int k = 0;; k = m)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            return i1 + j + k;
          }
          localObject = localObject[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + CodedOutputByteBufferNano.a((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      return i1;
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.a;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.a(1, (String)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof bf))
      {
        paramObject = (bf)paramObject;
        if (f.a(this.a, ((bf)paramObject).a))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label67;
          }
          paramObject = ((bf)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label67:
      return this.unknownFieldData.equals(((bf)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.a);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((k + 527) * 31 + m) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */