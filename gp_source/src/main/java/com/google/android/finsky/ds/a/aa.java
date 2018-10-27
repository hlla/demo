package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class aa
  extends b
{
  public y a = null;
  public z b = null;
  public ab c = null;
  
  public aa()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof aa))
      {
        paramObject = (aa)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label139;
        }
        if (((aa)paramObject).a != null) {}
      }
      label139:
      while (((y)localObject).equals(((aa)paramObject).a))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((aa)paramObject).c != null) {}
        }
        while (((ab)localObject).equals(((aa)paramObject).c))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((aa)paramObject).b != null) {}
          }
          while (((z)localObject).equals(((aa)paramObject).b))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((aa)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((aa)paramObject).unknownFieldData);
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
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((y)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((ab)localObject).hashCode();; j = 0)
      {
        localObject = this.b;
        if (localObject != null) {}
        for (int k = ((z)localObject).hashCode();; k = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */