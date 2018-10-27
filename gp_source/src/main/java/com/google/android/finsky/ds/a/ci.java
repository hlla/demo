package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.az;

public final class ci
  extends b
{
  private int a = 0;
  private boolean b = false;
  private boolean c = false;
  private Integer d;
  private bp e = null;
  private bp[] f = bp.b();
  private boolean g = false;
  
  public ci()
  {
    if (az.a != null) {}
    for (Integer localInteger = Integer.valueOf(az.a.b);; localInteger = null)
    {
      this.d = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.e;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.f;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.f;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(2, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((this.a & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(40) + 1);
    }
    j = i;
    if ((this.a & 0x8) != 0)
    {
      localObject = this.d;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(6, ((Integer)localObject).intValue());
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.f;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.a & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.c);
      }
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.g);
      }
      if ((this.a & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.b);
      }
      if ((this.a & 0x8) != 0)
      {
        localObject = this.d;
        if (localObject != null) {
          paramCodedOutputByteBufferNano.a(6, ((Integer)localObject).intValue());
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.f;
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
      Object localObject;
      if ((paramObject instanceof ci))
      {
        paramObject = (ci)paramObject;
        localObject = this.e;
        if (localObject != null) {
          break label192;
        }
        if (((ci)paramObject).e != null) {}
      }
      label180:
      label192:
      while (((bp)localObject).equals(((ci)paramObject).e))
      {
        if (f.a(this.f, ((ci)paramObject).f))
        {
          int i = this.a;
          int j = ((ci)paramObject).a;
          if (((i & 0x1) == (j & 0x1)) && (this.c == ((ci)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.g == ((ci)paramObject).g) && ((i & 0x4) == (j & 0x4)) && (this.b == ((ci)paramObject).b) && ((i & 0x8) == (j & 0x8)) && (this.d == ((ci)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject != null) && (!((d)localObject).a())) {
              break label180;
            }
            paramObject = ((ci)paramObject).unknownFieldData;
          }
        }
        return (paramObject == null) || (((d)paramObject).a());
        return this.unknownFieldData.equals(((ci)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 1237;
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject = this.e;
    if (localObject != null) {}
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      int i2 = f.a(this.f);
      if (!this.c) {}
      for (int j = 1237;; j = 1231)
      {
        if (!this.g) {}
        for (int k = 1237;; k = 1231)
        {
          if (!this.b) {}
          for (;;)
          {
            j = (k + (j + ((i + (i1 + 527) * 31) * 31 + i2) * 31) * 31) * 31 + m;
            localObject = this.d;
            i = j;
            if (localObject != null) {
              i = j * 31 + ((Integer)localObject).intValue();
            }
            localObject = this.unknownFieldData;
            j = n;
            if (localObject != null)
            {
              j = n;
              if (!((d)localObject).a()) {
                j = this.unknownFieldData.hashCode();
              }
            }
            return i * 31 + j;
            m = 1231;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */