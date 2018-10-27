package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.d.bd;

public final class ch
  extends b
{
  private int a = 0;
  private boolean b = false;
  private bd c = null;
  
  public ch()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bd localbd = this.c;
    int i = j;
    if (localbd != null) {
      i = j + CodedOutputStream.c(1, localbd);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bd localbd = this.c;
    if (localbd != null) {
      paramCodedOutputByteBufferNano.a(1, localbd);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ch))
      {
        paramObject = (ch)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label107;
        }
        if (((ch)paramObject).c != null) {}
      }
      label107:
      while (((bb)localObject).equals(((ch)paramObject).c))
      {
        if (((this.a & 0x1) == (((ch)paramObject).a & 0x1)) && (this.b == ((ch)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ch)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ch)paramObject).unknownFieldData);
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
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      if (!this.b) {}
      for (int j = 1237;; j = 1231)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */