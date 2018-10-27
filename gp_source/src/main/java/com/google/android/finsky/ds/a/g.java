package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class g
  extends b
{
  public gl a = null;
  public ad b = null;
  private int c = 0;
  private boolean d = false;
  private String e = "";
  
  public g()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    Object localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (com.google.protobuf.nano.g)localObject);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (com.google.protobuf.nano.g)localObject);
    }
    j = i;
    if ((this.c & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (com.google.protobuf.nano.g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (com.google.protobuf.nano.g)localObject);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (((this.c & 0x1) == (((g)paramObject).c & 0x1)) && (this.e.equals(((g)paramObject).e)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label165;
          }
          if (((g)paramObject).a != null) {}
        }
      }
      label165:
      while (((gl)localObject).equals(((g)paramObject).a))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((g)paramObject).b != null) {}
        }
        while (((ad)localObject).equals(((g)paramObject).b))
        {
          if (((this.c & 0x2) == (((g)paramObject).c & 0x2)) && (this.d == ((g)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((g)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((g)paramObject).unknownFieldData);
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
    int i2 = this.e.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((gl)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((ad)localObject).hashCode();; j = 0)
      {
        if (!this.d) {}
        for (int k = 1237;; k = 1231)
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
          return (k + (j + (i + ((i1 + 527) * 31 + i2) * 31) * 31) * 31) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */