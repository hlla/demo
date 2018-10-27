package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class gq
  extends b
{
  public kp a = null;
  private int b = 0;
  private String c = "";
  
  public gq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    kp localkp = this.a;
    j = i;
    if (localkp != null) {
      j = i + CodedOutputByteBufferNano.d(2, localkp);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    kp localkp = this.a;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(2, localkp);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gq))
      {
        paramObject = (gq)paramObject;
        if (((this.b & 0x1) == (((gq)paramObject).b & 0x1)) && (this.c.equals(((gq)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label110;
          }
          if (((gq)paramObject).a != null) {}
        }
      }
      label110:
      while (((kp)localObject).equals(((gq)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((gq)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((gq)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((kp)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */