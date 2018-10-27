package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class mb
  extends b
{
  public long[] a = j.g;
  private int b = 0;
  private byte[] c = j.b;
  
  public mb()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = 0;
    int i = super.a();
    long[] arrayOfLong = this.a;
    if (arrayOfLong != null) {
      if (arrayOfLong.length > 0)
      {
        int k = 0;
        int m;
        for (;;)
        {
          arrayOfLong = this.a;
          m = arrayOfLong.length;
          if (j >= m) {
            break;
          }
          k += CodedOutputByteBufferNano.b(arrayOfLong[j]);
          j += 1;
        }
        i = i + k + m;
      }
    }
    for (;;)
    {
      j = i;
      if ((this.b & 0x1) != 0) {
        j = i + CodedOutputByteBufferNano.b(2, this.c);
      }
      return j;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long[] arrayOfLong = this.a;
    if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
    {
      if ((this.b & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.c);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
    }
    int i = 0;
    for (;;)
    {
      arrayOfLong = this.a;
      if (i >= arrayOfLong.length) {
        break;
      }
      paramCodedOutputByteBufferNano.b(1, arrayOfLong[i]);
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mb))
      {
        paramObject = (mb)paramObject;
        if ((f.a(this.a, ((mb)paramObject).a)) && ((this.b & 0x1) == (((mb)paramObject).b & 0x1)) && (Arrays.equals(this.c, ((mb)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label96;
          }
          paramObject = ((mb)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label96:
      return this.unknownFieldData.equals(((mb)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.a);
    int n = Arrays.hashCode(this.c);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */