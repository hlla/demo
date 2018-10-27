package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class kw
  extends b
{
  public boolean a = false;
  public String b = "";
  public String c = "";
  public mt[] d = mt.b();
  private int e = 0;
  
  public kw()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    Object localObject = this.d;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.d;
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
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    Object localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.d;
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
  
  public final boolean b()
  {
    return (this.e & 0x2) != 0;
  }
  
  public final boolean c()
  {
    return (this.e & 0x4) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kw))
      {
        paramObject = (kw)paramObject;
        int i = this.e;
        int j = ((kw)paramObject).e;
        if (((i & 0x1) == (j & 0x1)) && (this.a == ((kw)paramObject).a) && ((i & 0x2) == (j & 0x2)) && (this.b.equals(((kw)paramObject).b)) && ((this.e & 0x4) == (((kw)paramObject).e & 0x4)) && (this.c.equals(((kw)paramObject).c)) && (f.a(this.d, ((kw)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label152;
          }
          paramObject = ((kw)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label152:
      return this.unknownFieldData.equals(((kw)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    if (!this.a) {}
    for (int j = 1237;; j = 1231)
    {
      int m = this.b.hashCode();
      int n = this.c.hashCode();
      int i1 = f.a(this.d);
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + ((((j + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */