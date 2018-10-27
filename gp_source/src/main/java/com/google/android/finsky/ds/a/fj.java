package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class fj
  extends b
{
  public int a = -1;
  private ff b = null;
  private fh c = null;
  private fk d = null;
  
  public fj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.a == 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    j = i;
    if (this.a == 1) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    i = j;
    if (this.a == 2) {
      i = j + CodedOutputByteBufferNano.d(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.a == 0) {
      paramCodedOutputByteBufferNano.b(1, this.c);
    }
    if (this.a == 1) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    if (this.a == 2) {
      paramCodedOutputByteBufferNano.b(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final fh b()
  {
    if (this.a != 0) {
      return null;
    }
    return this.c;
  }
  
  public final ff c()
  {
    if (this.a != 1) {
      return null;
    }
    return this.b;
  }
  
  public final fk d()
  {
    if (this.a != 2) {
      return null;
    }
    return this.d;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof fj))
      {
        paramObject = (fj)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label139;
        }
        if (((fj)paramObject).c != null) {}
      }
      label139:
      while (((fh)localObject).equals(((fj)paramObject).c))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((fj)paramObject).b != null) {}
        }
        while (((ff)localObject).equals(((fj)paramObject).b))
        {
          localObject = this.d;
          if (localObject == null) {
            if (((fj)paramObject).d != null) {}
          }
          while (((fk)localObject).equals(((fj)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((fj)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((fj)paramObject).unknownFieldData);
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    Object localObject2 = null;
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject1 = this.c;
    if (this.a != 0) {
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (int i = ((fh)localObject1).hashCode();; i = 0)
    {
      localObject1 = this.b;
      if (this.a != 1) {
        localObject1 = null;
      }
      if (localObject1 != null) {}
      for (int j = ((ff)localObject1).hashCode();; j = 0)
      {
        localObject1 = this.d;
        if (this.a != 2) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          if (localObject1 != null) {}
          for (int k = ((fk)localObject1).hashCode();; k = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */