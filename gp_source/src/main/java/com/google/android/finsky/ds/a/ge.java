package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ge
  extends b
{
  public String a = "";
  public kc[] b = kc.b();
  public int c = 0;
  public String d = "";
  private int e = 0;
  
  public ge()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.b;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.b;
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
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.e(2, this.c);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(3, this.a);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(4, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.e & 0x1) != 0) {
        paramCodedOutputByteBufferNano.c(2, this.c);
      }
      if ((this.e & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.a);
      }
      if ((this.e & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.d);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.b;
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
      if ((paramObject instanceof ge))
      {
        paramObject = (ge)paramObject;
        if (f.a(this.b, ((ge)paramObject).b))
        {
          int i = this.e;
          int j = ((ge)paramObject).e;
          if (((i & 0x1) == (j & 0x1)) && (this.c == ((ge)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.a.equals(((ge)paramObject).a)) && ((this.e & 0x4) == (((ge)paramObject).e & 0x4)) && (this.d.equals(((ge)paramObject).d)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label152;
            }
            paramObject = ((ge)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label152:
      return this.unknownFieldData.equals(((ge)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.b);
    int n = this.c;
    int i1 = this.a.hashCode();
    int i2 = this.d.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */