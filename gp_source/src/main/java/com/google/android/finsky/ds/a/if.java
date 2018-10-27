package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class if
  extends b
{
  public eq a = null;
  public ge b = null;
  
  public if()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.b;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof if))
      {
        paramObject = (if)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label110;
        }
        if (((if)paramObject).b != null) {}
      }
      label110:
      while (((ge)localObject).equals(((if)paramObject).b))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((if)paramObject).a != null) {}
        }
        while (((eq)localObject).equals(((if)paramObject).a))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((if)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((if)paramObject).unknownFieldData);
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
    for (int i = ((ge)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((eq)localObject).hashCode();; j = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */