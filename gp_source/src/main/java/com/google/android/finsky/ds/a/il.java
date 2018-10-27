package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class il
  extends b
{
  public fb a = null;
  public im b = null;
  public String c = "";
  private int d = 0;
  
  public il()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    Object localObject = this.a;
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
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    Object localObject = this.a;
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
      if ((paramObject instanceof il))
      {
        paramObject = (il)paramObject;
        if (((this.d & 0x1) == (((il)paramObject).d & 0x1)) && (this.c.equals(((il)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label139;
          }
          if (((il)paramObject).a != null) {}
        }
      }
      label139:
      while (((fb)localObject).equals(((il)paramObject).a))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((il)paramObject).b != null) {}
        }
        while (((im)localObject).equals(((il)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((il)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((il)paramObject).unknownFieldData);
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
    int i1 = this.c.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((im)localObject).hashCode();; j = 0)
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
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */