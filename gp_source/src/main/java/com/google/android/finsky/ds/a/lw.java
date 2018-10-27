package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class lw
  extends b
{
  private lv[] a = lv.b();
  private int b = 0;
  private String c = "";
  private String d = "";
  
  public lw()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((this.b & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.d);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.c);
    }
    Object localObject = this.a;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.a;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(3, (g)localObject);
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
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
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
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof lw))
      {
        paramObject = (lw)paramObject;
        if (((this.b & 0x1) == (((lw)paramObject).b & 0x1)) && (this.d.equals(((lw)paramObject).d)) && ((this.b & 0x2) == (((lw)paramObject).b & 0x2)) && (this.c.equals(((lw)paramObject).c)) && (f.a(this.a, ((lw)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label125;
          }
          paramObject = ((lw)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label125:
      return this.unknownFieldData.equals(((lw)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.d.hashCode();
    int n = this.c.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */