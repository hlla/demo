package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class mm
  extends b
{
  public int a = 0;
  public String b = "";
  public nl[] c = nl.b();
  private int d = 0;
  private String e = "";
  
  public mm()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.a);
    }
    i = j;
    if ((this.d & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
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
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(4, (g)localObject);
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
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
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
          paramCodedOutputByteBufferNano.b(4, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mm))
      {
        paramObject = (mm)paramObject;
        if (((this.d & 0x1) == (((mm)paramObject).d & 0x1)) && (this.e.equals(((mm)paramObject).e)))
        {
          int i = this.d;
          int j = ((mm)paramObject).d;
          if (((i & 0x2) == (j & 0x2)) && (this.a == ((mm)paramObject).a) && ((i & 0x4) == (j & 0x4)) && (this.b.equals(((mm)paramObject).b)) && (f.a(this.c, ((mm)paramObject).c)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label152;
            }
            paramObject = ((mm)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label152:
      return this.unknownFieldData.equals(((mm)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e.hashCode();
    int n = this.a;
    int i1 = this.b.hashCode();
    int i2 = f.a(this.c);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */