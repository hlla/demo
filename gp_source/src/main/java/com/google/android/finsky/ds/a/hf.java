package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class hf
  extends b
{
  private fb a = null;
  private fc b = null;
  private int c = -1;
  private ky d = null;
  
  public hf()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.c == 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.a);
    }
    j = i;
    if (this.c == 1) {
      j = i + CodedOutputByteBufferNano.d(2, this.d);
    }
    i = j;
    if (this.c == 2) {
      i = j + CodedOutputByteBufferNano.d(3, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.c == 0) {
      paramCodedOutputByteBufferNano.b(1, this.a);
    }
    if (this.c == 1) {
      paramCodedOutputByteBufferNano.b(2, this.d);
    }
    if (this.c == 2) {
      paramCodedOutputByteBufferNano.b(3, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final fb b()
  {
    if (this.c != 0) {
      return null;
    }
    return this.a;
  }
  
  public final boolean c()
  {
    return this.c == 0;
  }
  
  public final ky d()
  {
    if (this.c != 1) {
      return null;
    }
    return this.d;
  }
  
  public final boolean e()
  {
    boolean bool = true;
    if (this.c != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hf))
      {
        paramObject = (hf)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label139;
        }
        if (((hf)paramObject).a != null) {}
      }
      label139:
      while (((fb)localObject).equals(((hf)paramObject).a))
      {
        localObject = this.d;
        if (localObject == null) {
          if (((hf)paramObject).d != null) {}
        }
        while (((ky)localObject).equals(((hf)paramObject).d))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((hf)paramObject).b != null) {}
          }
          while (((fc)localObject).equals(((hf)paramObject).b))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((hf)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((hf)paramObject).unknownFieldData);
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final fc f()
  {
    if (this.c != 2) {
      return null;
    }
    return this.b;
  }
  
  public final boolean g()
  {
    return this.c == 2;
  }
  
  public final int hashCode()
  {
    Object localObject2 = null;
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject1 = this.a;
    if (this.c != 0) {
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (int i = ((fb)localObject1).hashCode();; i = 0)
    {
      localObject1 = this.d;
      if (this.c != 1) {
        localObject1 = null;
      }
      if (localObject1 != null) {}
      for (int j = ((ky)localObject1).hashCode();; j = 0)
      {
        localObject1 = this.b;
        if (this.c != 2) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          if (localObject1 != null) {}
          for (int k = ((fc)localObject1).hashCode();; k = 0)
          {
            localObject1 = this.unknownFieldData;
            int m = n;
            if (localObject1 != null)
            {
              m = n;
              if (!((d)localObject1).a()) {
                m = this.unknownFieldData.hashCode();
              }
            }
            return (k + (((i1 + 527) * 31 + i) * 31 + j) * 31) * 31 + m;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */