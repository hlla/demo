package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ji
  extends b
{
  public aw a = null;
  public bp b = null;
  public String c = "";
  private int d = 0;
  
  public ji()
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
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ji))
      {
        paramObject = (ji)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label139;
        }
        if (((ji)paramObject).a != null) {}
      }
      label139:
      while (((aw)localObject).equals(((ji)paramObject).a))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((ji)paramObject).b != null) {}
        }
        while (((bp)localObject).equals(((ji)paramObject).b))
        {
          if (((this.d & 0x1) == (((ji)paramObject).d & 0x1)) && (this.c.equals(((ji)paramObject).c)))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((ji)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ji)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((aw)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((bp)localObject).hashCode();; j = 0)
      {
        int i1 = this.c.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */