package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class hu
  extends b
{
  private int a = 0;
  private boolean b = false;
  private ht c = null;
  
  public hu()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    ht localht = this.c;
    int i = j;
    if (localht != null) {
      i = j + CodedOutputByteBufferNano.d(1, localht);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    ht localht = this.c;
    if (localht != null) {
      paramCodedOutputByteBufferNano.b(1, localht);
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
      if ((paramObject instanceof hu))
      {
        paramObject = (hu)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label107;
        }
        if (((hu)paramObject).c != null) {}
      }
      label107:
      while (((ht)localObject).equals(((hu)paramObject).c))
      {
        if (((this.a & 0x1) == (((hu)paramObject).a & 0x1)) && (this.b == ((hu)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((hu)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((hu)paramObject).unknownFieldData);
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
    for (int i = ((ht)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */