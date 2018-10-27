package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class mz
  extends b
{
  public String a = "";
  public String b = "";
  public bp[] c = bp.b();
  public boolean d = false;
  public String e = "";
  private int f = 0;
  
  public mz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    int k = j;
    if ((this.f & 0x4) != 0) {
      k = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    i = k;
    if ((this.f & 0x8) != 0) {
      i = k + CodedOutputByteBufferNano.b(4, this.a);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(5, (g)localObject);
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
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.c;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.b(5, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mz))
      {
        paramObject = (mz)paramObject;
        int i = this.f;
        int j = ((mz)paramObject).f;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((mz)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((mz)paramObject).b)) && ((this.f & 0x4) == (((mz)paramObject).f & 0x4)) && (this.e.equals(((mz)paramObject).e)) && ((this.f & 0x8) == (((mz)paramObject).f & 0x8)) && (this.a.equals(((mz)paramObject).a)) && (f.a(this.c, ((mz)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label183;
          }
          paramObject = ((mz)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label183:
      return this.unknownFieldData.equals(((mz)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    if (!this.d) {}
    for (int j = 1237;; j = 1231)
    {
      int m = this.b.hashCode();
      int n = this.e.hashCode();
      int i1 = this.a.hashCode();
      int i2 = f.a(this.c);
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (((((j + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */