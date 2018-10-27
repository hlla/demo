package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ih
  extends b
{
  public ii a = null;
  public boolean b = false;
  private int c = 0;
  
  public ih()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    ii localii = this.a;
    j = i;
    if (localii != null) {
      j = i + CodedOutputByteBufferNano.d(2, localii);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    ii localii = this.a;
    if (localii != null) {
      paramCodedOutputByteBufferNano.b(2, localii);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ih))
      {
        paramObject = (ih)paramObject;
        if (((this.c & 0x1) == (((ih)paramObject).c & 0x1)) && (this.b == ((ih)paramObject).b))
        {
          localObject = this.a;
          if (localObject != null) {
            break label107;
          }
          if (((ih)paramObject).a != null) {}
        }
      }
      label107:
      while (((ii)localObject).equals(((ih)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ih)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ih)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    if (!this.b) {}
    for (int i = 1237;; i = 1231)
    {
      Object localObject = this.a;
      if (localObject != null) {}
      for (int j = ((ii)localObject).hashCode();; j = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */