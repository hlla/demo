package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.an;

public final class bz
  extends b
{
  private static volatile bz[] a;
  private int b = 0;
  private String c = "";
  private long d = 0L;
  private an[] e = new an[0];
  private ca f = null;
  
  public bz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static bz[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new bz[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.d);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    Object localObject = this.f;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    localObject = this.e;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.e;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputStream.c(4, (cl)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.d);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.e;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.a(4, (cl)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bz))
      {
        paramObject = (bz)paramObject;
        int i = this.b;
        int j = ((bz)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((bz)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.c.equals(((bz)paramObject).c)))
        {
          localObject = this.f;
          if (localObject != null) {
            break label154;
          }
          if (((bz)paramObject).f != null) {}
        }
      }
      label154:
      while (((ca)localObject).equals(((bz)paramObject).f))
      {
        if (f.a(this.e, ((bz)paramObject).e))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((bz)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bz)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    long l = this.d;
    int n = this.c.hashCode();
    Object localObject = this.f;
    int i1 = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((ca)localObject).hashCode();; i = 0)
    {
      int i2 = f.a(this.e);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + (((m + 527) * 31 + i1) * 31 + n) * 31) * 31 + i2) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */