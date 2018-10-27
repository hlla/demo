package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;

public final class fn
  extends b
{
  private int a = 0;
  private String[] b = j.h;
  private String c = "";
  private String d = "";
  
  public fn()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = 0;
    int i = super.a();
    Object localObject = this.b;
    int k;
    int m;
    if (localObject != null) {
      if (localObject.length > 0)
      {
        k = 0;
        m = 0;
        localObject = this.b;
        if (j >= localObject.length) {
          i = i + k + m;
        }
      }
    }
    for (;;)
    {
      j = i;
      if ((this.a & 0x1) != 0) {
        j = i + CodedOutputByteBufferNano.b(2, this.c);
      }
      i = j;
      if ((this.a & 0x2) != 0) {
        i = j + CodedOutputByteBufferNano.b(3, this.d);
      }
      return i;
      localObject = localObject[j];
      int i1 = k;
      int n = m;
      if (localObject != null)
      {
        n = m + 1;
        i1 = k + CodedOutputByteBufferNano.a((String)localObject);
      }
      j += 1;
      k = i1;
      m = n;
      break;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.a & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(2, this.c);
      }
      if ((this.a & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.d);
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
      paramCodedOutputByteBufferNano.a(1, (String)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof fn))
      {
        paramObject = (fn)paramObject;
        if ((f.a(this.b, ((fn)paramObject).b)) && ((this.a & 0x1) == (((fn)paramObject).a & 0x1)) && (this.c.equals(((fn)paramObject).c)) && ((this.a & 0x2) == (((fn)paramObject).a & 0x2)) && (this.d.equals(((fn)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label125;
          }
          paramObject = ((fn)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label125:
      return this.unknownFieldData.equals(((fn)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = f.a(this.b);
    int n = this.c.hashCode();
    int i1 = this.d.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */