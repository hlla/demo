package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ko
  extends b
{
  private static volatile ko[] a;
  private km b = null;
  private kn c = null;
  private int d = -1;
  
  public ko()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ko[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new ko[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.d == 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.c);
    }
    j = i;
    if (this.d == 1) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.d == 0) {
      paramCodedOutputByteBufferNano.b(1, this.c);
    }
    if (this.d == 1) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final kn c()
  {
    if (this.d != 0) {
      return null;
    }
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d == 0;
  }
  
  public final boolean e()
  {
    boolean bool = true;
    if (this.d != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ko))
      {
        paramObject = (ko)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label110;
        }
        if (((ko)paramObject).c != null) {}
      }
      label110:
      while (((kn)localObject).equals(((ko)paramObject).c))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((ko)paramObject).b != null) {}
        }
        while (((km)localObject).equals(((ko)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((ko)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ko)paramObject).unknownFieldData);
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
    int m = 0;
    int n = getClass().getName().hashCode();
    Object localObject1 = this.c;
    if (this.d != 0) {
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (int i = ((kn)localObject1).hashCode();; i = 0)
    {
      localObject1 = this.b;
      if (this.d != 1) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localObject1 != null) {}
        for (int j = ((km)localObject1).hashCode();; j = 0)
        {
          localObject1 = this.unknownFieldData;
          int k = m;
          if (localObject1 != null)
          {
            k = m;
            if (!((d)localObject1).a()) {
              k = this.unknownFieldData.hashCode();
            }
          }
          return (j + ((n + 527) * 31 + i) * 31) * 31 + k;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */