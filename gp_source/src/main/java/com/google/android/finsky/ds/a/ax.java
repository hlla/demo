package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ax
  extends b
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public au[] d = au.b();
  public String e = "";
  public String f = "";
  
  public ax()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.d;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.d;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.d(1, (g)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.f);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(3, this.b);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(4, this.e);
    }
    j = i;
    if ((this.a & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(5, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.a & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.f);
      }
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.b);
      }
      if ((this.a & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.e);
      }
      if ((this.a & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.c);
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
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ax))
      {
        paramObject = (ax)paramObject;
        if ((f.a(this.d, ((ax)paramObject).d)) && ((this.a & 0x1) == (((ax)paramObject).a & 0x1)) && (this.f.equals(((ax)paramObject).f)) && ((this.a & 0x2) == (((ax)paramObject).a & 0x2)) && (this.b.equals(((ax)paramObject).b)) && ((this.a & 0x4) == (((ax)paramObject).a & 0x4)) && (this.e.equals(((ax)paramObject).e)) && ((this.a & 0x8) == (((ax)paramObject).a & 0x8)) && (this.c.equals(((ax)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label185;
          }
          paramObject = ((ax)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label185:
      return this.unknownFieldData.equals(((ax)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.d);
    int n = this.f.hashCode();
    int i1 = this.b.hashCode();
    int i2 = this.e.hashCode();
    int i3 = this.c.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */