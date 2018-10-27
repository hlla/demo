package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.d.al;
import com.google.wireless.android.finsky.d.bd;

public final class ca
  extends b
{
  private bd a = null;
  private al b = null;
  private al c = null;
  
  public ca()
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
      i = j + CodedOutputStream.c(1, (cl)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(2, (cl)localObject);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputStream.c(3, (cl)localObject);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(1, (cl)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, (cl)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(3, (cl)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ca))
      {
        paramObject = (ca)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label139;
        }
        if (((ca)paramObject).a != null) {}
      }
      label139:
      while (((bb)localObject).equals(((ca)paramObject).a))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((ca)paramObject).c != null) {}
        }
        while (((bb)localObject).equals(((ca)paramObject).c))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((ca)paramObject).b != null) {}
          }
          while (((bb)localObject).equals(((ca)paramObject).b))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((ca)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((ca)paramObject).unknownFieldData);
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
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((bb)localObject).hashCode();; j = 0)
      {
        localObject = this.b;
        if (localObject != null) {}
        for (int k = ((bb)localObject).hashCode();; k = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */