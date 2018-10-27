package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class lq
  extends b
{
  public String a = "";
  public bu b = null;
  public fb c = null;
  private int d = 0;
  
  public lq()
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
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lq))
      {
        paramObject = (lq)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label139;
        }
        if (((lq)paramObject).b != null) {}
      }
      label139:
      while (((bu)localObject).equals(((lq)paramObject).b))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((lq)paramObject).c != null) {}
        }
        while (((fb)localObject).equals(((lq)paramObject).c))
        {
          if (((this.d & 0x1) == (((lq)paramObject).d & 0x1)) && (this.a.equals(((lq)paramObject).a)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((lq)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((lq)paramObject).unknownFieldData);
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
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((fb)localObject).hashCode();; j = 0)
      {
        int i1 = this.a.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */