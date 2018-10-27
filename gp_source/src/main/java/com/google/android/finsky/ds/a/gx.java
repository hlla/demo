package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class gx
  extends b
{
  public String a = "";
  public kr b = null;
  private int c = 0;
  
  public gx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    kr localkr = this.b;
    j = i;
    if (localkr != null) {
      j = i + CodedOutputByteBufferNano.d(2, localkr);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    kr localkr = this.b;
    if (localkr != null) {
      paramCodedOutputByteBufferNano.b(2, localkr);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gx))
      {
        paramObject = (gx)paramObject;
        if (((this.c & 0x1) == (((gx)paramObject).c & 0x1)) && (this.a.equals(((gx)paramObject).a)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label110;
          }
          if (((gx)paramObject).b != null) {}
        }
      }
      label110:
      while (((kr)localObject).equals(((gx)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((gx)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((gx)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.a.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((kr)localObject).hashCode();; i = 0)
    {
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */