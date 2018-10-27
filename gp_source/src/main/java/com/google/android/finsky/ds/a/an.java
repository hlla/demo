package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class an
  extends b
{
  private static volatile an[] b;
  public am[] a = am.b();
  private int c = 0;
  private bu[] d = bu.b();
  private String e = "";
  
  public an()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static an[] b()
  {
    if (b == null) {}
    synchronized (f.a)
    {
      if (b == null) {
        b = new an[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int m = 0;
    int i = super.a();
    int j = i;
    if ((this.c & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.e);
    }
    Object localObject = this.d;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.d;
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
    localObject = this.a;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.a;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(3, (g)localObject);
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
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.a;
      if ((localObject != null) && (localObject.length > 0))
      {
        i = j;
        localObject = this.a;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.b(3, (g)localObject);
          }
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.d;
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
      if ((paramObject instanceof an))
      {
        paramObject = (an)paramObject;
        if (((this.c & 0x1) == (((an)paramObject).c & 0x1)) && (this.e.equals(((an)paramObject).e)) && (f.a(this.d, ((an)paramObject).d)) && (f.a(this.a, ((an)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label110;
          }
          paramObject = ((an)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label110:
      return this.unknownFieldData.equals(((an)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e.hashCode();
    int n = f.a(this.d);
    int i1 = f.a(this.a);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */