package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ah
  extends com.google.protobuf.nano.b
{
  private static volatile ah[] d;
  public b a = null;
  public String b = "";
  public bu c = null;
  private int e = 0;
  
  public ah()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ah[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new ah[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.c;
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
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ah))
      {
        paramObject = (ah)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label139;
        }
        if (((ah)paramObject).c != null) {}
      }
      label139:
      while (((bu)localObject).equals(((ah)paramObject).c))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((ah)paramObject).a != null) {}
        }
        while (((b)localObject).equals(((ah)paramObject).a))
        {
          if (((this.e & 0x1) == (((ah)paramObject).e & 0x1)) && (this.b.equals(((ah)paramObject).b)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((ah)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ah)paramObject).unknownFieldData);
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
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((b)localObject).hashCode();; j = 0)
      {
        int i1 = this.b.hashCode();
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */