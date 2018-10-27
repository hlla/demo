package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.q.do;
import com.google.wireless.android.finsky.dfe.q.fq;

public final class lu
  extends b
{
  private static volatile lu[] a;
  private int b = 0;
  private lw c = null;
  private Integer d;
  private long e = 0L;
  private do f = null;
  
  public lu()
  {
    if (fq.a != null) {}
    for (Integer localInteger = Integer.valueOf(fq.a.b);; localInteger = null)
    {
      this.d = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static lu[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new lu[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.e);
    }
    Object localObject = this.f;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(2, (cl)localObject);
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.b & 0x2) != 0)
    {
      localObject = this.d;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(4, ((Integer)localObject).intValue());
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.e);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, (cl)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.b & 0x2) != 0)
    {
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(4, ((Integer)localObject).intValue());
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lu))
      {
        paramObject = (lu)paramObject;
        if (((this.b & 0x1) == (((lu)paramObject).b & 0x1)) && (this.e == ((lu)paramObject).e))
        {
          localObject = this.f;
          if (localObject != null) {
            break label163;
          }
          if (((lu)paramObject).f != null) {}
        }
      }
      label163:
      while (((bb)localObject).equals(((lu)paramObject).f))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((lu)paramObject).c != null) {}
        }
        while (((lw)localObject).equals(((lu)paramObject).c))
        {
          if (((this.b & 0x2) == (((lu)paramObject).b & 0x2)) && (this.d == ((lu)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((lu)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((lu)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    long l = this.e;
    Object localObject = this.f;
    int n = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((lw)localObject).hashCode();; j = 0)
      {
        j += (i + ((m + 527) * 31 + n) * 31) * 31;
        localObject = this.d;
        i = j;
        if (localObject != null) {
          i = j * 31 + ((Integer)localObject).intValue();
        }
        localObject = this.unknownFieldData;
        j = k;
        if (localObject != null)
        {
          j = k;
          if (!((d)localObject).a()) {
            j = this.unknownFieldData.hashCode();
          }
        }
        return i * 31 + j;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */