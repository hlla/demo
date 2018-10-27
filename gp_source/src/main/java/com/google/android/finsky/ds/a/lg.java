package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class lg
  extends b
{
  public String a = "";
  public String b = "";
  public lh[] c = lh.b();
  private int d = 0;
  
  public lg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((this.d & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.a);
    }
    i = j;
    if ((this.d & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.b);
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
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
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
      if ((paramObject instanceof lg))
      {
        paramObject = (lg)paramObject;
        if (((this.d & 0x1) == (((lg)paramObject).d & 0x1)) && (this.a.equals(((lg)paramObject).a)) && ((this.d & 0x2) == (((lg)paramObject).d & 0x2)) && (this.b.equals(((lg)paramObject).b)) && (f.a(this.c, ((lg)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label125;
          }
          paramObject = ((lg)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label125:
      return this.unknownFieldData.equals(((lg)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    int n = this.b.hashCode();
    int i1 = f.a(this.c);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */