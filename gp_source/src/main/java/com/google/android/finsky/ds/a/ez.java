package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ez
  extends b
{
  public bu a = null;
  public bu b = null;
  
  public ez()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bu localbu = this.b;
    int i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbu);
    }
    localbu = this.a;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(2, localbu);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bu localbu = this.b;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(1, localbu);
    }
    localbu = this.a;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(2, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ez))
      {
        paramObject = (ez)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label110;
        }
        if (((ez)paramObject).b != null) {}
      }
      label110:
      while (((bu)localObject).equals(((ez)paramObject).b))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((ez)paramObject).a != null) {}
        }
        while (((bu)localObject).equals(((ez)paramObject).a))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((ez)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ez)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((bu)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */