package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.dfe.q.ch;

public final class gd
  extends b
{
  public int a = 0;
  public ch b = null;
  public boolean c = false;
  
  public gd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    ch localch = this.b;
    j = i;
    if (localch != null) {
      j = i + CodedOutputStream.c(2, localch);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    ch localch = this.b;
    if (localch != null) {
      paramCodedOutputByteBufferNano.a(2, localch);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gd))
      {
        paramObject = (gd)paramObject;
        if (((this.a & 0x1) == (((gd)paramObject).a & 0x1)) && (this.c == ((gd)paramObject).c))
        {
          localObject = this.b;
          if (localObject != null) {
            break label107;
          }
          if (((gd)paramObject).b != null) {}
        }
      }
      label107:
      while (((bb)localObject).equals(((gd)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((gd)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((gd)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    if (!this.c) {}
    for (int i = 1237;; i = 1231)
    {
      Object localObject = this.b;
      if (localObject != null) {}
      for (int j = ((bb)localObject).hashCode();; j = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */