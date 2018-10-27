package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class bx
  extends b
{
  private long a = 0L;
  private int b = 0;
  private String c = "";
  private long[] d = j.g;
  private String e = "";
  private bt f = null;
  
  public bx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.d;
    int i = j;
    if (localObject != null)
    {
      int k = localObject.length;
      i = j;
      if (k > 0) {
        i = j + k * 8 + k;
      }
    }
    j = i;
    if ((this.b & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.e);
    }
    localObject = this.f;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 8);
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0))
    {
      if ((this.b & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.e);
      }
      localObject = this.f;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(3, (g)localObject);
      }
      if ((this.b & 0x2) != 0) {
        paramCodedOutputByteBufferNano.c(4, this.a);
      }
      if ((this.b & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.c);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
    }
    int i = 0;
    for (;;)
    {
      localObject = this.d;
      if (i >= localObject.length) {
        break;
      }
      paramCodedOutputByteBufferNano.c(1, localObject[i]);
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bx))
      {
        paramObject = (bx)paramObject;
        if ((f.a(this.d, ((bx)paramObject).d)) && ((this.b & 0x1) == (((bx)paramObject).b & 0x1)) && (this.e.equals(((bx)paramObject).e)))
        {
          localObject = this.f;
          if (localObject != null) {
            break label183;
          }
          if (((bx)paramObject).f != null) {}
        }
      }
      label183:
      while (((bt)localObject).equals(((bx)paramObject).f))
      {
        int i = this.b;
        int j = ((bx)paramObject).b;
        if (((i & 0x2) == (j & 0x2)) && (this.a == ((bx)paramObject).a) && ((i & 0x4) == (j & 0x4)) && (this.c.equals(((bx)paramObject).c)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((bx)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bx)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = f.a(this.d);
    int i1 = this.e.hashCode();
    Object localObject = this.f;
    if (localObject != null) {}
    for (int i = ((bt)localObject).hashCode();; i = 0)
    {
      long l = this.a;
      int i2 = (int)(l >>> 32 ^ l);
      int i3 = this.c.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */