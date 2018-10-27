package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class j
  extends b
{
  public boolean a = false;
  public String b = "";
  public io[] c = io.b();
  public String d = "";
  private int e = 0;
  
  public j()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    Object localObject = this.c;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.c;
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
      i = j + CodedOutputByteBufferNano.b(2, this.d);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(3, this.b);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(32) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.c;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.e & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.d);
      }
      if ((this.e & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.b);
      }
      if ((this.e & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.a);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.c;
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
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((f.a(this.c, ((j)paramObject).c)) && ((this.e & 0x1) == (((j)paramObject).e & 0x1)) && (this.d.equals(((j)paramObject).d)) && ((this.e & 0x2) == (((j)paramObject).e & 0x2)) && (this.b.equals(((j)paramObject).b)) && ((this.e & 0x4) == (((j)paramObject).e & 0x4)) && (this.a == ((j)paramObject).a))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label151;
          }
          paramObject = ((j)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label151:
      return this.unknownFieldData.equals(((j)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = f.a(this.c);
    int n = this.d.hashCode();
    int i1 = this.b.hashCode();
    if (!this.a) {}
    for (int j = 1237;; j = 1231)
    {
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (j + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */