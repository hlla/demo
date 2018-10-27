package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class hz
  extends b
{
  public de a = null;
  private int b = 0;
  private boolean c = true;
  private hk d = null;
  
  public hz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.d;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    i = j;
    if ((this.b & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hz))
      {
        paramObject = (hz)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label136;
        }
        if (((hz)paramObject).a != null) {}
      }
      label123:
      label136:
      while (((de)localObject).equals(((hz)paramObject).a))
      {
        if (((this.b & 0x1) == (((hz)paramObject).b & 0x1)) && (this.c == ((hz)paramObject).c))
        {
          localObject = this.d;
          if (localObject != null) {
            break label123;
          }
          if (((hz)paramObject).d != null) {}
        }
        while (((hk)localObject).equals(((hz)paramObject).d))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((hz)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((hz)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((de)localObject).hashCode();; i = 0)
    {
      if (!this.c) {}
      for (int j = 1237;; j = 1231)
      {
        localObject = this.d;
        if (localObject != null) {}
        for (int k = ((hk)localObject).hashCode();; k = 0)
        {
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */